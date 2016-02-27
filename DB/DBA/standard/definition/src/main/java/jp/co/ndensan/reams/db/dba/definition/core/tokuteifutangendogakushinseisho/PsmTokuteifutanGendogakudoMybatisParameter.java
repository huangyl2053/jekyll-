/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.tokuteifutangendogakushinseisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 宛名識別対象取得パラメータクラス。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class PsmTokuteifutanGendogakudoMybatisParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    public PsmTokuteifutanGendogakudoMybatisParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
