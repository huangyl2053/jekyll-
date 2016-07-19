/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 「源泉徴収データ作成」のbatch用パラメータクラスです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GensenChoshuDataSakuseiFlowParameter extends BatchParameterBase implements IBatchProcessParameter {

    private static final String KEY_DATE = "指定年";
    private static final long serialVersionUID = 1L;

    @BatchParameter(key = KEY_DATE, name = "指定年")
    private RDate 指定年;

    /**
     * コンストラクタです。
     */
    public GensenChoshuDataSakuseiFlowParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param 指定年 指定年
     */
    public GensenChoshuDataSakuseiFlowParameter(RDate 指定年) {
        this.指定年 = 指定年;
    }

    /**
     * 認定調査報酬照会のProcessParameterを作成します。
     *
     * @return 認定調査報酬照会のProcessParameter
     */
    public GensenChoshuProcessParameter toProcessParamter() {
        return new GensenChoshuProcessParameter(指定年);
    }
}
