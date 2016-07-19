/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RYear;

/**
 * 「源泉徴収データ作成」のProcessParameterです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GensenChoshuProcessParameter implements IBatchProcessParameter {

    private final RYear 指定年;

    /**
     * コンストラクタです。
     *
     * @param 指定年 指定年
     */
    public GensenChoshuProcessParameter(RYear 指定年) {
        this.指定年 = 指定年;
    }

    /**
     * 「源泉徴収データ作成」のmapperのparameterを作成します。
     *
     * @return 「源泉徴収データ作成」のmapperparameter
     */
    public GensenChoshuMapperParameter toMybitisParamter() {
        return GensenChoshuMapperParameter.createParamter(指定年);
    }
}
