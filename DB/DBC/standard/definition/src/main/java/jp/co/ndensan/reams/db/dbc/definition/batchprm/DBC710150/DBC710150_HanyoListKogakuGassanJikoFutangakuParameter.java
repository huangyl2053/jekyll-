/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710150;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト(高額合算自己負担額情報)のバッチパラメータです。
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710150_HanyoListKogakuGassanJikoFutangakuParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_CHUSHUTSU_KUBUN = "chushutsuKubun";
    private static final String KEY_DETA_SAKUSEI_KUBUN = "detaSakuseiKubun";
    private static final String KEY_DATA_SHURUI = "dataShurui";
    private static final String KEY_HOSEU_JOKYO = "hoseuJokyo";
    private static final String KEY_FLEXIBLE_YEAR = "flexibleYear";
    private static final String KEY_FLEXIBLE_DATE_FROM = "flexibleDateFrom";
    private static final String KEY_FLEXIBLE_DATE_TO = "flexibleDateTo";
    private static final String KEY_SHIKYU_FROM = "shikyuShinseishoSeiriNoFrom";
    private static final String KEY_SHIKYU_TO = "shikyuShinseishoSeiriNoTo";
    private static final String KEY_SOFU_TAISHOGAI_FUKUMU = "sofuTaishogaiFukumu";
    private static final String KEY_JIKO_FROM = "jikoFutangakuKakuninFrom";
    private static final String KEY_JIKO_TO = "sofuTaishogaiFukumuTo";
    private static final String KEY_HOSEIZUMI_FROM = "hoseizumiJikoFutangakuFrom";
    private static final String KEY_HOSEIZUMI_TO = "hoseizumiJikoFutangakuTo";
    private static final String KEY_JIKO_FUTANNGAKU_FROM = "jikoFutanngakuShoumeishoFrom";
    private static final String KEY_JIKO_FUTANNGAKU_TO = "jikoFutanngakuShoumeishoTo";
    private static final String KEY_TOMOKUME_FUKA = "tomokumeFuka";
    private static final String KEY_REBAN_FUKA = "rebanFuka";
    private static final String KEY_SLASH_DATE = "slashDate";
    private static final String KEY_HOKENSHA_NO = "hokenshaNo";
    private static final String KEY_SHUTSURYOKUJU = "shutsuryokuju";
    private static final String KEY_SHUTSURYOKU_TOMOKU = "shutsuryokuTomoku";

    @BatchParameter(key = KEY_CHUSHUTSU_KUBUN, name = "抽出区分")
    private RString chushutsuKubun;
    @BatchParameter(key = KEY_DETA_SAKUSEI_KUBUN, name = "データ作成区分")
    private RString detaSakuseiKubun;
    @BatchParameter(key = KEY_DATA_SHURUI, name = "データ種類")
    private RString dataShurui;
    @BatchParameter(key = KEY_HOSEU_JOKYO, name = "補正状況")
    private RString hoseuJokyo;
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
    @BatchParameter(key = KEY_SOFU_TAISHOGAI_FUKUMU, name = "送付対象外")
    private boolean sofuTaishogaiFukumu;
    @BatchParameter(key = KEY_JIKO_FROM, name = "自己負担額確認情報受取年月From")
    private FlexibleYearMonth jikoFutangakuKakuninFrom;
    @BatchParameter(key = KEY_JIKO_TO, name = "自己負担額確認情報受取年月To")
    private FlexibleYearMonth sofuTaishogaiFukumuTo;
    @BatchParameter(key = KEY_HOSEIZUMI_FROM, name = "補正済自己負担額情報送付年月From")
    private FlexibleYearMonth hoseizumiJikoFutangakuFrom;
    @BatchParameter(key = KEY_HOSEIZUMI_TO, name = "補正済自己負担額情報送付年月To")
    private FlexibleYearMonth hoseizumiJikoFutangakuTo;
    @BatchParameter(key = KEY_JIKO_FUTANNGAKU_FROM, name = "自己負担額証明書情報受取年月From")
    private FlexibleYearMonth jikoFutanngakuShoumeishoFrom;
    @BatchParameter(key = KEY_JIKO_FUTANNGAKU_TO, name = "自己負担額証明書情報受取年月To")
    private FlexibleYearMonth jikoFutanngakuShoumeishoTo;
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
    public HanyoListKogakuGassanJikoFutangakuProcessParameter toProcessParam() {
        return new HanyoListKogakuGassanJikoFutangakuProcessParameter(
                chushutsuKubun,
                detaSakuseiKubun,
                dataShurui,
                hoseuJokyo,
                flexibleYear,
                flexibleDateFrom,
                flexibleDateTo,
                shikyuShinseishoSeiriNoFrom,
                shikyuShinseishoSeiriNoTo,
                sofuTaishogaiFukumu,
                jikoFutangakuKakuninFrom,
                sofuTaishogaiFukumuTo,
                hoseizumiJikoFutangakuFrom,
                hoseizumiJikoFutangakuTo,
                jikoFutanngakuShoumeishoFrom,
                jikoFutanngakuShoumeishoTo,
                tomokumeFuka,
                rebanFuka,
                slashDate,
                hokenshaNo,
                shutsuryokuju,
                shutsuryokuTomoku);
    }

}
