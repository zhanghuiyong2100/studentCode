package spring.conditional;

import org.springframework.stereotype.Service;

/**
 * @author 章辉勇
 * @创建时间 2018年10月30日
 * @描述: windows實現接口
 **/
@Service
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
