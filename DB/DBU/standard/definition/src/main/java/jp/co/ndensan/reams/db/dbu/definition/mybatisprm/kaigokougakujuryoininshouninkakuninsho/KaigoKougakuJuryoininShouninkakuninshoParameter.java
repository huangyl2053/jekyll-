/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.kaigokougakujuryoininshouninkakuninsho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * [総合窓口用被保険者、受給者等判断]のMybatisパラメータクラスです。
 *
 * @reamsid_L DBU-4220-010 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KaigoKougakuJuryoininShouninkakuninshoParameter {

    private final RString 識別コード;
    private final RString psmShikibetsuTaisho;

    private KaigoKougakuJuryoininShouninkakuninshoParameter(RString 識別コード, RString psmShikibetsuTaisho) {
        this.識別コード = 識別コード;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 識別コード 入力住民情報の識別コード
     * @param psmShikibetsuTaisho 宛名識別対象抽出PSM
     * @return パラメータ
     */
    public static KaigoKougakuJuryoininShouninkakuninshoParameter creatParameter(RString 識別コード, RString psmShikibetsuTaisho) {
        return new KaigoKougakuJuryoininShouninkakuninshoParameter(識別コード, psmShikibetsuTaisho);
    }
}
