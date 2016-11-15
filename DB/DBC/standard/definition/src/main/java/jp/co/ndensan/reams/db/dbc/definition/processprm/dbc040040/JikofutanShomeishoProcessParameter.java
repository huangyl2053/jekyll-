/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040040;

import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_DataSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan.KaigoGassan_JikoFutanShomeisho_Insho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040040.JikofutanShomeishoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 自己負担額証明書作成（括）のProcessパラメータです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JikofutanShomeishoProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 開始申請年月日;
    private FlexibleDate 終了申請年月日;
    private FlexibleYearMonth 受取年月;
    private KaigoGassan_JikoFutanShomeisho_Insho 印書;
    private FlexibleDate 発行日;
    private Long 出力順ID;
    private RString 文書情報;
    private KaigoGassan_DataSakuseiKubun 抽出対象;

    private RString 対象年度区分;
    private LasdecCode 市町村コード;
    private RString 出力順;

    /**
     * MybatisParameterを作成する。
     *
     * @return JikofutanShomeishoMybatisParameter
     */
    public JikofutanShomeishoMybatisParameter toMybatisParameter() {
        JikofutanShomeishoMybatisParameter param = new JikofutanShomeishoMybatisParameter();
        param.set受取年月(受取年月);
        param.set抽出対象(抽出対象 == null ? RString.EMPTY : 抽出対象.getコード());
        param.set申請開始年月日(開始申請年月日);
        param.set申請終了年月日(終了申請年月日);
        param.set対象年度区分(対象年度区分);
        param.set市町村コード(市町村コード);
        param.set出力順(出力順);
        return param;
    }
}
