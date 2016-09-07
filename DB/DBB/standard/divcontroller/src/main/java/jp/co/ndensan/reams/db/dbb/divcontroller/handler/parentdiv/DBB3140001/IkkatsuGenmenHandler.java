/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.IkkatsuGenmenDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class IkkatsuGenmenHandler {

    private final IkkatsuGenmenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public IkkatsuGenmenHandler(IkkatsuGenmenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTxtChoteiNendo().setValue(new RDate(調定年度.toString()));
        div.getTxtFukaNendo().setValue(new RDate(調定年度.toString()));
        div.getTxtShinseiYMD().setValue(RDate.getNowDate());
        div.getTxtKetteiYMD().setValue(new FlexibleDate(RDate.getNowDate().toString()));
        div.getTxtUketsukeiYMD().setVisible(false);
        div.getTxtGenmenRitsu().setDisplayNone(true);
        div.getCcdChikuShichosonSelect().initialize();
    }

}
