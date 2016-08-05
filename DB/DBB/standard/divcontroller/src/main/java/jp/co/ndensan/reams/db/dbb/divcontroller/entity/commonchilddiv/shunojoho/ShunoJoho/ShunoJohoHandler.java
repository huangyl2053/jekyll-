/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.shunojoho.ShunoJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 収納情報【共有子Div】のハンドラクラスです。
 *
 * @reamsid_L DBB-5710-010 xuxin
 */
public class ShunoJohoHandler {

    private static final FlexibleYear 平成12年 = new FlexibleYear("2000");
    private static final int INT_1 = 1;

    private final ShunoJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShunoJohoDiv
     */
    public ShunoJohoHandler(ShunoJohoDiv div) {
        this.div = div;
    }

    /**
     * 調定年度DDLと賦課年度DDLの初期化です。
     */
    public void setDDL初期化() {
        RDate 適用基準日 = RDate.getNowDate();
        RString 調定年度r = getConfig値(ConfigNameDBB.日付関連_調定年度, 適用基準日);
        if (!RString.isNullOrEmpty(調定年度r)) {
            FlexibleYear 調定年度f = new FlexibleYear(調定年度r);
            ShoriDateKanriManager manager = new ShoriDateKanriManager();
            ShoriDateKanri 新年度管理情報 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課,
                    ShoriName.新年度管理情報作成.get名称(), 調定年度f.plusYear(INT_1));
            boolean flag;
            flag = (新年度管理情報 == null) || (新年度管理情報.get基準年月日() == null)
                    || (新年度管理情報.get基準年月日().isEmpty());
            FlexibleYear 選択可能年度 = flag ? 調定年度f : 調定年度f.plusYear(INT_1);
            List<KeyValueDataSource> dataSource = new ArrayList<>();
            for (int index = 選択可能年度.getYearValue(); 平成12年.getYearValue() <= index; index--) {
                FlexibleYear 調定年度 = new FlexibleYear(new RString(index));
                dataSource.add(new KeyValueDataSource(調定年度.seireki().toDateString(), 調定年度.wareki().toDateString()));
            }
            div.getDdlChoteiNendo().setDataSource(dataSource);
            div.getDdlFukaNendo().setDataSource(dataSource);
            div.getDdlChoteiNendo().setSelectedKey(調定年度f.seireki().toDateString());
            div.getDdlFukaNendo().setSelectedKey(調定年度f.seireki().toDateString());
        } else {
            div.getDdlChoteiNendo().getDataSource().clear();
            div.getDdlFukaNendo().getDataSource().clear();
        }
    }

    private RString getConfig値(Enum key, RDate 適用基準日) {
        return DbBusinessConfig.get(key, 適用基準日, SubGyomuCode.DBB介護賦課);
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     */
    public void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号) {

        dgTokucho_Row row = new dgTokucho_Row();
        row.setTxtKi(RString.EMPTY);
        row.setTxtChoteiGaku(RString.EMPTY);
        row.setTxtShunyuGaku(RString.EMPTY);
        row.setTxtShunyuYMD(RString.EMPTY);
        row.setTxtRyosyuYMD(RString.EMPTY);
        row.setTxtTokusokuTesuryo(RString.EMPTY);
        row.setTxtEntaikin(RString.EMPTY);
        row.setTxtChoteiYMD(RString.EMPTY);
        row.setTxtNokigen(RString.EMPTY);
    }
}
