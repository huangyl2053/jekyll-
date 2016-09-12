/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokushafuseigo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格取得者不整合リストMybatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikakuShutokushaFuseigoMybatisParameter {

    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタです。
     *
     * @param psmShikibetsuTaisho psm
     */
    public ShikakuShutokushaFuseigoMybatisParameter(RString psmShikibetsuTaisho) {
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
