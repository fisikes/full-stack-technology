package fisikes.simpleserver.contorller;


import com.google.common.collect.Lists;
import fisikes.core.BaseReq;
import fisikes.core.R;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class ProjectController {



    /**
     * 获取当前项目信息
     */
    @SneakyThrows
    @PostMapping("get-project")
    public R<List<String>> getProjects(@RequestBody BaseReq baseReq) {

        log.info("调用获取项目详情");

        TimeUnit.SECONDS.sleep(2);
        return R.success(Lists.newArrayList("test project"));
    }
}
