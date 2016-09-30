/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagomoshitateshojohosofu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090.KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagomoshitateshojohosofuichiran.SogojigyohiKagoMoshitateshojohoSofuSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBC200079_総合事業費過誤申立書情報送付一覧表 のeditorクラスです。
 *
 * @reamsid_L DBC-2530-042 zhengshenlei
 */
public class SogojigyohiKagoMoshitateshojohoSofuHeadEditor implements ISogojigyohiKagoMoshitateshojohoSofuEditor {

    private KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ;
    private final IOutputOrder 出力順情報;
    private final FlexibleYearMonth 処理年月;
    private final RDateTime 作成日時;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final RString 日時作成 = new RString("作成");

    /**
     * コンストラクタです
     *
     * @param 送付一覧表データ SogojigyohiKagoMoshitateshojohoSofuIchiranEntity
     * @param 出力順情報 IOutputOrder
     * @param 処理年月 RYearMonth
     * @param 作成日時 YMDHMS
     */
    public SogojigyohiKagoMoshitateshojohoSofuHeadEditor(
            KaigokyufuhiKagoMoshitateshoOutDoBillOutEntity 送付一覧表データ,
            IOutputOrder 出力順情報,
            FlexibleYearMonth 処理年月,
            RDateTime 作成日時) {
        this.送付一覧表データ = 送付一覧表データ;
        this.出力順情報 = 出力順情報;
        this.処理年月 = 処理年月;
        this.作成日時 = 作成日時;
    }

    @Override
    public SogojigyohiKagoMoshitateshojohoSofuSource edit(SogojigyohiKagoMoshitateshojohoSofuSource source) {
        source.printTimeStamp = get印刷日時(作成日時);
        if (処理年月 != null) {
            source.sofuYM = 処理年月.wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (送付一覧表データ.getDbWT1731Entity().getHokenshaNo() != null) {
            source.hokenshaNo = 送付一覧表データ.getDbWT1731Entity().getHokenshaNo().value();
        }
        source.hokenshaName = 送付一覧表データ.getDbWT1731Entity().getHokenshaName();
        if (送付一覧表データ.getDbWT1731Entity().getShoKisaiHokenshaNo() != null) {
            source.shokisaiHokenshaNo = 送付一覧表データ.getDbWT1731Entity().getShoKisaiHokenshaNo().value();
        }
        source.shokisaiHokenshaName = 送付一覧表データ.getDbWT1731Entity().getShoKisaiHokenshaName();
        setHeader(source);
        return source;
    }

    private RString get印刷日時(RDateTime datetime) {
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(日時作成);
        return sakuseiYMD.toRString();
    }

    private void setHeader(SogojigyohiKagoMoshitateshojohoSofuSource source) {
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
