/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.shomeishosakusei;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanShomeisho_Insho;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 自己負担額証明書作成（括）のバッチパラメータです。
 *
 * @reamsid_L DBC-2380-010 yuqingzhang
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikofutanShomeishoParameter extends BatchParameterBase {

    @BatchParameter(key = "開始申請年月日", name = "申請年月日（開始）")
    private FlexibleDate 開始申請年月日;
    @BatchParameter(key = "終了申請年月日", name = "申請年月日（終了）")
    private FlexibleDate 終了申請年月日;
    @BatchParameter(key = "受取年月", name = "受取年月")
    private FlexibleDate 受取年月;
    @BatchParameter(key = "印書", name = "印書")
    private KaigoGassan_JikoFutanShomeisho_Insho 印書;
    @BatchParameter(key = "発行日", name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = "出力順ID", name = "出力順ID")
    private long 出力順ID;
    @BatchParameter(key = "文書情報", name = "文書情報")
    private RString 文書情報;
    @BatchParameter(key = "抽出対象", name = "抽出対象")
    private KaigoGassan_DataSakuseiKubun 抽出対象;
}
