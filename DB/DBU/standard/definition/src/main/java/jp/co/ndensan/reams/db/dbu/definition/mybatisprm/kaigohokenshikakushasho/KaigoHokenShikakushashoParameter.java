/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigohokenshikakushasho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * PSM参数のセット。
 *
 * @reamsid_L DBU-0490-040 xuyannan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShikakushashoParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * 宛名識別対象PSMパラメータです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     */
    public KaigoHokenShikakushashoParameter(
            RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
