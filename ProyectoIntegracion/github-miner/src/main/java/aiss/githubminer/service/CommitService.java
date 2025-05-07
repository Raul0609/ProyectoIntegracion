package aiss.githubminer.service;

import aiss.githubminer.model.CommitDTO;
import aiss.gitminer.model.Commit;
import aiss.githubminer.mapper.CommitMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommitService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String GITHUB_API_BASE_URL = "https://api.github.com/repos/";

    /**
     * Obtiene commits desde la API de GitHub.
     */
    public List<CommitDTO> fetchCommits(String owner, String repo) {
        String url = GITHUB_API_BASE_URL + owner + "/" + repo + "/commits";
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

        String gitMinerUrl = "http://gitminer-service/api/commits";
        restTemplate.postForEntity(gitMinerUrl, commits, String.class);

        System.out.println("Commits enviados correctamente a GitMiner.");
    }

    /**
     * Procesa la extracción, transformación y envío de commits.
     */
    public List<Commit> processCommits(String owner, String repo) {
        List<CommitDTO> commitDTOs = fetchCommits(owner, repo);
        List<Commit> processedCommits = mapCommits(commitDTOs);

        sendCommitsToGitMiner(processedCommits);
        return processedCommits;
    }
}