/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.NendoKirikae;

import jp.co.ndensan.reams.db.dbb.definition.processprm.NendoKirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 年度切替バッチのパラメッタ
 *
 * @reamsid_L DBB_9010_002 zhengshenlei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_CHOTEINENDO = "choteiNendo";
    @BatchParameter(key = KEY_CHOTEINENDO, name = "調定年度")
    private RDate choteiNendo;

    public NendoKirikaeProcessParameter toNendoKirikaeProcessParameter() {
        return new NendoKirikaeProcessParameter(choteiNendo);
    }
}
