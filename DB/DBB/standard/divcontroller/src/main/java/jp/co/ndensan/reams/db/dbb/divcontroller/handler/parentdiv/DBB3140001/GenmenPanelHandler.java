/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3140001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001.GenmenPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 画面設計_DBBMN61002_介護保険料減免登録(一括)
 *
 * @reamsid_L DBB-1670-010 chenyadong
 */
public class GenmenPanelHandler {

    private final GenmenPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuKeisanIkkatsuPanelDiv
     */
    public GenmenPanelHandler(GenmenPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドます。
     */
    public void initialize() {
        RString 調定年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        div.getTextBoxTyoutenendo().setValue(new RYear(調定年度.toString()).wareki().toDateString());
        div.getTextBoxFukanendo().setValue(new RYear(調定年度.toString()).wareki().toDateString());
        div.getTextBoxSinsei().setValue(RDate.getNowDate());
        div.getTextBoxKette().setValue(RDate.getNowDate());
        div.getChikuShichosonSelect().initialize();
    }

    /**
     * onOkClosebth。
     */
    public void onOkClosebth() {

        div.getTextBoxGenmenSyurui().setValue(DataPassingConverter.
                deserialize(div.getGemmenShuruiCode(), RString.class).
                concat(RString.FULL_SPACE).
                concat(DataPassingConverter.deserialize(div.getGemmenShuruiHyojiMongon(), RString.class)));
    }
}
