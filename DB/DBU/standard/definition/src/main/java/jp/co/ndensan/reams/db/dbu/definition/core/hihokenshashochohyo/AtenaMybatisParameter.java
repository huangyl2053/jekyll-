/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashochohyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * PSM参数のセット。
 *
 * @reamsid_L DBU-0490-021 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AtenaMybatisParameter {

    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * 宛名識別対象PSMパラメータです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     */
    public AtenaMybatisParameter(RString psmShikibetsuTaisho, RString psmAtesaki) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
    }
}
