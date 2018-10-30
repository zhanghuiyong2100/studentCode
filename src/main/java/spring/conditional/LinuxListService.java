package spring.conditional;

import org.springframework.stereotype.Service;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: Linux實現接口
 **/
@Service
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
