/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 宛名識別対象取得パラメータクラス。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class PsmShikibetsuTaishoMybatisParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    public PsmShikibetsuTaishoMybatisParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
