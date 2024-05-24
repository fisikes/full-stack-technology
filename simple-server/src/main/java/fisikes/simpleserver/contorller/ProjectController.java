package fisikes.simpleserver.contorller;


import com.google.common.collect.Lists;
import fisikes.simpleserver.BaseReq;
import fisikes.simpleserver.R;
import fisikes.simpleserver.mapper.ProjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class ProjectController {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;


    @GetMapping("get-project-info")
    public R<Integer> getProjectInfo() {
        return R.success(projectInfoMapper.count());
    }


    /**
     * 获取当前项目信息
     */
    @PostMapping("get-project")
    public R<List<String>> getProjects(@RequestBody BaseReq baseReq) throws InterruptedException {

        // log.info("调用获取项目详情");

        TimeUnit.SECONDS.sleep(2);
        return R.success(Lists.newArrayList("test project"));
    }
}
