/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukeisankekkasofuichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.gassanshikyugakukeisankekkasofuichiran.GassanShikyugakuKeisankekkaSofuIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200036_高額合算支給額計算結果連絡票情報送付一覧表 HeaderEditorクラスです。
 *
 * @reamsid_L DBC-2670-040 lijian
 */
public class GassanShikyugakuKeisankekkaSofuIchiranHeaderEditor implements IGassanShikyugakuKeisankekkaSofuIchiranEditor {

    private static final RString 日時作成 = new RString("作成");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private final IOutputOrder 出力順情報;
    private final RYearMonth 処理年月;
    private final YMDHMS 作成日時;

    /**
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     */
    public GassanShikyugakuKeisankekkaSofuIchiranHeaderEditor(
            IOutputOrder 出力順情報,
            RYearMonth 処理年月,
            YMDHMS 作成日時) {

        this.出力順情報 = 出力順情報;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public GassanShikyugakuKeisankekkaSofuIchiranSource edit(GassanShikyugakuKeisankekkaSofuIchiranSource source) {

        source.printTimeStamp = get印刷日時(作成日時);
        if (処理年月 != null) {
            source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.hokenshaNo = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        source.hokenshaName = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        setHeader(source);
        return source;
    }

    private RString get印刷日時(YMDHMS datetime) {

        RStringBuilder sakuseiYMD = new RStringBuilder();

        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private void setHeader(GassanShikyugakuKeisankekkaSofuIchiranSource source) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        RString 出力順１ = RString.EMPTY;
        RString 出力順２ = RString.EMPTY;
        RString 出力順３ = RString.EMPTY;
        RString 出力順４ = RString.EMPTY;
        RString 出力順５ = RString.EMPTY;

        List<ISetSortItem> list;
        if (出力順情報 != null) {
            list = 出力順情報.get設定項目リスト();
        } else {
            list = null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }

        if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
            改頁１ = list.get(0).get項目名();
        }
        if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
            改頁２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
            改頁３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
            改頁４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
            改頁５ = list.get(INDEX_4).get項目名();
        }

        if (list.size() > INDEX_0) {
            出力順１ = list.get(INDEX_0).get項目名();
        }
        if (list.size() > INDEX_1) {
            出力順２ = list.get(INDEX_1).get項目名();
        }
        if (list.size() > INDEX_2) {
            出力順３ = list.get(INDEX_2).get項目名();
        }
        if (list.size() > INDEX_3) {
            出力順４ = list.get(INDEX_3).get項目名();
        }
        if (list.size() > INDEX_4) {
            出力順５ = list.get(INDEX_4).get項目名();
        }

        source.kaipage1 = 改頁１;
        source.kaipage2 = 改頁２;
        source.kaipage3 = 改頁３;
        source.kaipage4 = 改頁４;
        source.kaipage5 = 改頁５;

        source.shutsuryokujun1 = 出力順１;
        source.shutsuryokujun2 = 出力順２;
        source.shutsuryokujun3 = 出力順３;
        source.shutsuryokujun4 = 出力順４;
        source.shutsuryokujun5 = 出力順５;
    }
}
