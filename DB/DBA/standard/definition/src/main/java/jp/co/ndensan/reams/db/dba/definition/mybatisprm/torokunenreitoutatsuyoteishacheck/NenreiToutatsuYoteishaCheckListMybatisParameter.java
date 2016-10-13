/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.torokunenreitoutatsuyoteishacheck;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * PSM参数のセット。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NenreiToutatsuYoteishaCheckListMybatisParameter {

    private final RString psmShikibetsuTaisho;
    private final RString psmShikibetsuTaisho2;
    private final RString psmShikibetsuTaisho3;
    private final RString shutsuryokuSort;

    private final Boolean userShutsuryokuSort;

    /**
     * 宛名識別対象PSMパラメータです。
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmShikibetsuTaisho2 psmShikibetsuTaisho2
     * @param psmShikibetsuTaisho3 psmShikibetsuTaisho3
     * @param shutsuryokuSort 出力順
     */
    public NenreiToutatsuYoteishaCheckListMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmShikibetsuTaisho2,
            RString psmShikibetsuTaisho3,
            RString shutsuryokuSort) {
        Boolean shutsuryokujunFlg = true;
        if (shutsuryokuSort == null || shutsuryokuSort.isEmpty()) {
            shutsuryokujunFlg = false;
        }
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmShikibetsuTaisho2 = psmShikibetsuTaisho2;
        this.psmShikibetsuTaisho3 = psmShikibetsuTaisho3;
        this.shutsuryokuSort = shutsuryokuSort;

        this.userShutsuryokuSort = shutsuryokujunFlg;
    }
}
