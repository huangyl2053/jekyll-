/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.gensenchoshudatasakusei;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 「源泉徴収データ作成」のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-2000-020 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class GensenChoshuMapperParameter implements IMyBatisParameter {

    private final RDate 指定年;

    private GensenChoshuMapperParameter(RDate 指定年) {
        this.指定年 = 指定年;
    }

    /**
     * 源泉徴収データ作成用情報の指定年です。
     *
     * @param 指定年 指定年
     * @return 源泉徴収データ作成用情報の指定年
     */
    public static GensenChoshuMapperParameter createParamter(RDate 指定年) {
        return new GensenChoshuMapperParameter(指定年);
    }
}
