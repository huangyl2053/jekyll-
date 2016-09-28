/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710160;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassan.HanyoListKogakuGassanKeisanProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)のBatchParameterクラスです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBC710160_HanyoListKogakuGassanKeisanKekkaRenrakuHyoParameter extends BatchParameterBase {

    private static final String CHUSHUTSUKUBUN = "抽出区分";
    private static final String DATAKUBUN = "データ区分";
    private static final String DATATYPE = "データ種類";
    private static final String TAISHONENDO = "対象年度";
    private static final String UKETORIYMFROM = "受取年月From";
    private static final String UKETORIYMTO = "受取年月To";
    private static final String SOFUYMFROM = "送付年月From";
    private static final String SOFUYMTO = "送付年月To";
    private static final String TOMOKUMEFUKA = "項目名付加";
    private static final String REBANFUKA = "連番付加";
    private static final String DATE = "日付スラッシュ付加";
    private static final String HOKENSHACODE = "保険者コード";
    private static final String OUTPUT = "出力順";
    private static final String INTPUT = "出力項目";

    @BatchParameter(key = CHUSHUTSUKUBUN, name = "抽出区分")
    private RString 抽出区分;
    @BatchParameter(key = DATAKUBUN, name = "データ区分")
    private RString データ区分;
    @BatchParameter(key = DATATYPE, name = "データ種類")
    private RString データ種類;
    @BatchParameter(key = TAISHONENDO, name = "対象年度")
    private FlexibleYear 対象年度;
    @BatchParameter(key = UKETORIYMFROM, name = "受取年月From")
    private FlexibleYearMonth 受取年月From;
    @BatchParameter(key = UKETORIYMTO, name = "受取年月To")
    private FlexibleYearMonth 受取年月To;
    @BatchParameter(key = SOFUYMFROM, name = "送付年月From")
    private FlexibleYearMonth 送付年月From;
    @BatchParameter(key = SOFUYMTO, name = "送付年月To")
    private FlexibleYearMonth 送付年月To;
    @BatchParameter(key = TOMOKUMEFUKA, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = REBANFUKA, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = DATE, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;
    @BatchParameter(key = HOKENSHACODE, name = "保険者コード")
    private LasdecCode 保険者コード;
    @BatchParameter(key = OUTPUT, name = "出力順")
    private Long 出力順;
    @BatchParameter(key = INTPUT, name = "出力項目")
    private RString 出力項目;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListKogakuGassanKeisanProcessParameter toProcessParam() {
        return new HanyoListKogakuGassanKeisanProcessParameter(
                抽出区分,
                データ区分,
                データ種類,
                対象年度,
                受取年月From,
                受取年月To,
                送付年月From,
                送付年月To,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                保険者コード,
                出力順,
                出力項目);
    }

}
