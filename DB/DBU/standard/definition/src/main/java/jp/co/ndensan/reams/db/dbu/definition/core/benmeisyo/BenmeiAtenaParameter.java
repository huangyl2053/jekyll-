/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名識別対象PSM検索用パラメータです。
 *
 */
@java.lang.SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class BenmeiAtenaParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;

    private BenmeiAtenaParameter(ShikibetsuCode shikibetsuCode, RString psmShikibetsuTaisho) {
        this.shikibetsuCode = shikibetsuCode;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param uaFt200Psm 宛名識別対象PSM検索キー
     * @return BenmeiAtenaParameter 宛名識別対象PSM検索用パラメータ
     */
    public static BenmeiAtenaParameter createSelectByKeyParam(ShikibetsuCode shikibetsuCode, RString uaFt200Psm) {
        return new BenmeiAtenaParameter(shikibetsuCode, uaFt200Psm);
    }
}
