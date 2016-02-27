/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.yokaigoninteikubunhenkoshinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名識別対象取得パラメータクラス。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoNinteikubunHenkoShinseishoParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    private YokaigoNinteikubunHenkoShinseishoParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * 申請書_共通クラス部分のパラメータです。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     * @return YokaigoNinteikubunHenkoShinseishoParameter
     */
    public static YokaigoNinteikubunHenkoShinseishoParameter createParam(
            RString psmShikibetsuTaisho) {
        return new YokaigoNinteikubunHenkoShinseishoParameter(
                psmShikibetsuTaisho);
    }
}
