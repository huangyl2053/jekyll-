/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算申請書情報)のバッチパラメータです。
 *
 * @reamsid_L DBC-3103-010 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710140_HanyoListKogakuGassanShinseishoJohoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_CHUSHUTSU_KUBUN = "chushutsuKubun";
    private static final String KEY_KAIGOGASSAN_KUBUN = "kaigoGassanShinseiJokyoKubun";
    private static final String KEY_FLEXIBLE_YEAR = "flexibleYear";
    private static final String KEY_FLEXIBLE_DATE_FROM = "flexibleDateFrom";
    private static final String KEY_FLEXIBLE_DATE_TO = "flexibleDateTo";
    private static final String KEY_SHIKYU_FROM = "shikyuShinseishoSeiriNoFrom";
    private static final String KEY_SHIKYU_TO = "shikyuShinseishoSeiriNoTo";
    private static final String KEY_FLEXIBLE_FROM = "flexibleYearMonthFrom";
    private static final String KEY_FLEXIBLE_TO = "flexibleYearMonthTo";
    private static final String KEY_TOMOKUME_FUKA = "tomokumeFuka";
    private static final String KEY_REBAN_FUKA = "rebanFuka";
    private static final String KEY_SLASH_DATE = "slashDate";
    private static final String KEY_HOKENSHA_NO = "hokenshaNo";
    private static final String KEY_SHUTSURYOKUJU = "shutsuryokuju";
    private static final String KEY_SHUTSURYOKU_TOMOKU = "shutsuryokuTomoku";

    @BatchParameter(key = KEY_CHUSHUTSU_KUBUN, name = "抽出区分")
    private RString chushutsuKubun;
    @BatchParameter(key = KEY_KAIGOGASSAN_KUBUN, name = "申請状況区分")
    private RString kaigoGassanShinseiJokyoKubun;
    @BatchParameter(key = KEY_FLEXIBLE_YEAR, name = "対象年度")
    private RString flexibleYear;
    @BatchParameter(key = KEY_FLEXIBLE_DATE_FROM, name = "申請年月日From")
    private FlexibleDate flexibleDateFrom;
    @BatchParameter(key = KEY_FLEXIBLE_DATE_TO, name = "申請年月日To")
    private FlexibleDate flexibleDateTo;
    @BatchParameter(key = KEY_SHIKYU_FROM, name = "支給申請書整理番号From")
    private RString shikyuShinseishoSeiriNoFrom;
    @BatchParameter(key = KEY_SHIKYU_TO, name = "支給申請書整理番号To")
    private RString shikyuShinseishoSeiriNoTo;
    @BatchParameter(key = KEY_FLEXIBLE_FROM, name = "送付年月From")
    private FlexibleYearMonth flexibleYearMonthFrom;
    @BatchParameter(key = KEY_FLEXIBLE_TO, name = "送付年月To")
    private FlexibleYearMonth flexibleYearMonthTo;
    @BatchParameter(key = KEY_TOMOKUME_FUKA, name = "項目名付加")
    private boolean tomokumeFuka;
    @BatchParameter(key = KEY_REBAN_FUKA, name = "連番付加")
    private boolean rebanFuka;
    @BatchParameter(key = KEY_SLASH_DATE, name = "日付スラッシュ付加")
    private boolean slashDate;
    @BatchParameter(key = KEY_HOKENSHA_NO, name = "保険者コード")
    private RString hokenshaNo;
    @BatchParameter(key = KEY_SHUTSURYOKUJU, name = "出力順")
    private Long shutsuryokuju;
    @BatchParameter(key = KEY_SHUTSURYOKU_TOMOKU, name = "出力項目")
    private RString shutsuryokuTomoku;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListKogakuGassanShinseishoJohoProcessParameter toProcessParam() {
        return new HanyoListKogakuGassanShinseishoJohoProcessParameter(
                chushutsuKubun,
                kaigoGassanShinseiJokyoKubun,
                flexibleYear,
                flexibleDateFrom,
                flexibleDateTo,
                shikyuShinseishoSeiriNoFrom,
                shikyuShinseishoSeiriNoTo,
                flexibleYearMonthFrom,
                flexibleYearMonthTo,
                tomokumeFuka,
                rebanFuka,
                slashDate,
                hokenshaNo,
                shutsuryokuju,
                shutsuryokuTomoku,
                null,
                null,
                null
        );
    }
}
