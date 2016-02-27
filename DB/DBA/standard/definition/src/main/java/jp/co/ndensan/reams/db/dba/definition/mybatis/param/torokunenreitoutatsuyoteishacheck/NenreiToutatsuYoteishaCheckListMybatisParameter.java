/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.torokunenreitoutatsuyoteishacheck;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * PSM参数のセット。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NenreiToutatsuYoteishaCheckListMybatisParameter {

    private final RString psmShikibetsuTaisho;
    private final RString psmShikibetsuTaisho2;
    private final RString psmShikibetsuTaisho3;

    /**
     * 宛名識別対象PSMパラメータです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmShikibetsuTaisho2 psmShikibetsuTaisho2
     * @param psmShikibetsuTaisho3 psmShikibetsuTaisho3
     */
    public NenreiToutatsuYoteishaCheckListMybatisParameter(
            RString psmShikibetsuTaisho, RString psmShikibetsuTaisho2, RString psmShikibetsuTaisho3) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmShikibetsuTaisho2 = psmShikibetsuTaisho2;
        this.psmShikibetsuTaisho3 = psmShikibetsuTaisho3;
    }
}
