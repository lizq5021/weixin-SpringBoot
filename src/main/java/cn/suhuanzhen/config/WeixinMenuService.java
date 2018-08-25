package cn.suhuanzhen.config;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;

public class WeixinMenuService {

    public static void main(String[] args) {
        WxMenu menu = new WxMenu();
        //菜单1
        WxMenuButton button1 = new WxMenuButton();
        button1.setType(WxConsts.MenuButtonType.VIEW);
        button1.setName("在线音乐");
        button1.setUrl("http://music.suhuanzhen.cn");

        //添加菜单
        menu.getButtons().add(button1);

        //发送请求 创建菜单
        WxMpService service = new WxMpServiceImpl();
        WxMpInMemoryConfigStorage wxConfigProvider = new WxMpInMemoryConfigStorage();
        wxConfigProvider.setAppId("wx2fc26f41b30ec81c");
        wxConfigProvider.setSecret("78e612955c0a58225c3871f4d161c49e");
        service.setWxMpConfigStorage(wxConfigProvider);
        try {
            service.getMenuService().menuCreate(menu);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
