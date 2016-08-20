/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710140;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
    private static final String KEY_KAIGOGASSAN_SHINSEIJOKYO_KUBUN = "kaigoGassanShinseiJokyoKubun";
    private static final String KEY_FLEXIBLE_YEAR = "flexibleYear";
    private static final String KEY_FLEXIBLE_DATE_FROM = "flexibleDateFrom";
    private static final String KEY_FLEXIBLE_DATE_TO = "flexibleDateTo";
    private static final String KEY_SHIKYU_SHINSEISHO_SEIRINO_FROM = "shikyuShinseishoSeiriNoFrom";
    private static final String KEY_SHIKYU_SHINSEISHO_SEIRINO_TO = "shikyuShinseishoSeiriNoTo";
    private static final String KEY_FLEXIBLE_YEARMONTH_FROM = "flexibleYearMonthFrom";
    private static final String KEY_FLEXIBLE_YEARMONTH_TO = "flexibleYearMonthTo";
    private static final String KEY_TOMOKUME_FUKA = "tomokumeFuka";
    private static final String KEY_REBAN_FUKA = "rebanFuka";
    private static final String KEY_SLASH_DATE = "slashDate";
    private static final String KEY_HOKENSHA_NO = "hokenshaNo";
    private static final String KEY_SHUTSURYOKUJU = "shutsuryokuju";
    private static final String KEY_SHUTSURYOKU_TOMOKU = "shutsuryokuTomoku";

    @BatchParameter(key = KEY_CHUSHUTSU_KUBUN, name = "抽出区分")
    private RString chushutsuKubun;
    @BatchParameter(key = KEY_KAIGOGASSAN_SHINSEIJOKYO_KUBUN, name = "申請状況区分")
    private RString kaigoGassanShinseiJokyoKubun;
    @BatchParameter(key = KEY_FLEXIBLE_YEAR, name = "対象年度")
    private RString flexibleYear;
    @BatchParameter(key = KEY_FLEXIBLE_DATE_FROM, name = "申請年月日From")
    private FlexibleDate flexibleDateFrom;
    @BatchParameter(key = KEY_FLEXIBLE_DATE_TO, name = "申請年月日To")
    private FlexibleDate flexibleDateTo;
    @BatchParameter(key = KEY_SHIKYU_SHINSEISHO_SEIRINO_FROM, name = "支給申請書整理番号From")
    private RString shikyuShinseishoSeiriNoFrom;
    @BatchParameter(key = KEY_SHIKYU_SHINSEISHO_SEIRINO_TO, name = "支給申請書整理番号To")
    private RString shikyuShinseishoSeiriNoTo;
    @BatchParameter(key = KEY_FLEXIBLE_YEARMONTH_FROM, name = "送付年月From")
    private FlexibleDate flexibleYearMonthFrom;
    @BatchParameter(key = KEY_FLEXIBLE_YEARMONTH_TO, name = "送付年月To")
    private FlexibleDate flexibleYearMonthTo;
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
     * コンストラクタです。
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter() {
    }

    /**
     *
     * @param chushutsuKubun 抽出区分
     * @param kaigoGassanShinseiJokyoKubun 申請状況区分
     * @param flexibleYear 対象年度
     * @param flexibleDateFrom 申請年月日From
     * @param flexibleDateTo 申請年月日To
     * @param shikyuShinseishoSeiriNoFrom 支給申請書整理番号From
     * @param shikyuShinseishoSeiriNoTo 支給申請書整理番号To
     * @param flexibleYearMonthFrom 送付年月From
     * @param flexibleYearMonthTo 送付年月To
     * @param tomokumeFuka 項目名付加
     * @param rebanFuka 連番付加
     * @param slashDate 日付スラッシュ付加
     * @param hokenshaNo 保険者コード
     * @param shutsuryokuju 出力順
     * @param shutsuryokuTomoku 出力項目
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter(
            RString chushutsuKubun,
            RString kaigoGassanShinseiJokyoKubun,
            RString flexibleYear,
            FlexibleDate flexibleDateFrom,
            FlexibleDate flexibleDateTo,
            RString shikyuShinseishoSeiriNoFrom,
            RString shikyuShinseishoSeiriNoTo,
            FlexibleDate flexibleYearMonthFrom,
            FlexibleDate flexibleYearMonthTo,
            boolean tomokumeFuka,
            boolean rebanFuka,
            boolean slashDate,
            RString hokenshaNo,
            Long shutsuryokuju,
            RString shutsuryokuTomoku) {
        this.chushutsuKubun = chushutsuKubun;
        this.kaigoGassanShinseiJokyoKubun = kaigoGassanShinseiJokyoKubun;
        this.flexibleYear = flexibleYear;
        this.flexibleDateFrom = flexibleDateFrom;
        this.flexibleDateTo = flexibleDateTo;
        this.shikyuShinseishoSeiriNoFrom = shikyuShinseishoSeiriNoFrom;
        this.shikyuShinseishoSeiriNoTo = shikyuShinseishoSeiriNoTo;
        this.flexibleYearMonthFrom = flexibleYearMonthFrom;
        this.flexibleYearMonthTo = flexibleYearMonthTo;
        this.tomokumeFuka = tomokumeFuka;
        this.rebanFuka = rebanFuka;
        this.slashDate = slashDate;
        this.hokenshaNo = hokenshaNo;
        this.shutsuryokuju = shutsuryokuju;
        this.shutsuryokuTomoku = shutsuryokuTomoku;
    }

    /**
     * 汎用リスト出力(高額合算申請書情報)_バッチ用のパラメータラス作成
     *
     * @return 汎用リスト出力(高額合算申請書情報)_バッチ用のパラメータラス
     */
    public DBC710140_HanyoListKogakuGassanShinseishoJohoParameter toDBC710140_HanyoListKogakuGassanShinseishoJohoParameter() {
        return new DBC710140_HanyoListKogakuGassanShinseishoJohoParameter(
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
                shutsuryokuTomoku
        );
    }
}
