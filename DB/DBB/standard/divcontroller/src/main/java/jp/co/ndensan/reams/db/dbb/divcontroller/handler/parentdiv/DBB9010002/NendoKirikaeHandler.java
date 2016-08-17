/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9010002;

import jp.co.ndensan.reams.db.dbb.definition.batchprm.nendokirikae.DBB901002_NendoKirikaeParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9010002.NendoKirikaeDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.util.DateConverter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年度切替のクラスです
 *
 * @reamsid_L DBB_5722_010 zhengshenlei
 */
public class NendoKirikaeHandler {

    private final NendoKirikaeDiv div;
    private static final int NUM_1 = 1;

    /**
     * コンストラクタです。
     *
     * @param div NendoKirikaeDiv
     */
    public NendoKirikaeHandler(NendoKirikaeDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化のメソッドです。
     *
     */
    public void initialize() {
        RString 当年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        RString 新年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        RString teikyoYM当年度 = DateConverter.toWarekiHalf(new RDate(当年度.toString()));
        RString teikyoYM新年度 = DateConverter.toWarekiHalf(new RDate(新年度.toString()));
        div.getDcLblTonendo().setValue(new RDate(teikyoYM当年度.toString()));
        div.getDcLblShinnendo().setValue(new RDate(teikyoYM新年度.toString()).plusYear(NUM_1));
    }

    /**
     * バッチ実行のメソッドです
     *
     * @return DBB901002_NendoKirikaeParameter
     */
    public DBB901002_NendoKirikaeParameter バッチ実行() {
        DBB901002_NendoKirikaeParameter parameter = new DBB901002_NendoKirikaeParameter();
        RString 当年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        FlexibleYear 調定年度 = new FlexibleYear(当年度.toString());
        parameter.set調定年度(調定年度);
        return parameter;
    }

}
