package aiss.bitbucketminer.service;

import aiss.bitbucketminer.model.CommitDTO;
import aiss.bitbucketminer.mapper.CommitMapper;
import aiss.gitminer.model.Commit;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommitService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BITBUCKET_API_BASE_URL = "https://api.bitbucket.org/2.0/repositories/";
    private static final String GITMINER_API_URL = "http://gitminer-service/api/commits"; // URL del servicio GitMiner

    /**
     * Obtiene commits desde Bitbucket para un repositorio determinado.
     */
    public List<CommitDTO> fetchCommits(String workspace, String repoSlug, int nCommits) {
        String url = BITBUCKET_API_BASE_URL + workspace + "/" + repoSlug + "/commits?pagelen=" + nCommits;
        CommitDTO[] response = restTemplate.getForObject(url, CommitDTO[].class);
        return response != null ? List.of(response) : List.of();
    }

    /**
     * Mapea una lista de `CommitDTO` a `Commit`, adaptando los datos al modelo GitMiner.
     */
    public List<Commit> mapCommits(List<CommitDTO> commitDTOs) {
        return commitDTOs.stream()
                .map(CommitMapper::transformCommit)
                .collect(Collectors.toList());
    }

    /**
     * Envía los commits transformados a GitMiner.
     */
    public void sendCommitsToGitMiner(List<Commit> commits) {
        if (commits.isEmpty()) {
            throw new IllegalArgumentException("No hay commits para enviar a GitMiner.");
        }

        restTemplate.postForEntity(GITMINER_API_URL, commits, String.class);
        System.out.println("Commits enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de commits.
     */
    public List<Commit> processCommits(String workspace, String repoSlug, int nCommits) {
        List<CommitDTO> commitDTOs = fetchCommits(workspace, repoSlug, nCommits);
        List<Commit> processedCommits = mapCommits(commitDTOs);
        sendCommitsToGitMiner(processedCommits);
        return processedCommits;
    }
}