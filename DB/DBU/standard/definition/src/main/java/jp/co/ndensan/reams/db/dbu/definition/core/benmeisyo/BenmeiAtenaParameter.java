/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.benmeisyo;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名識別対象PSM検索用パラメータです。
 *
 */
public final class BenmeiAtenaParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;

    @SuppressWarnings("URF_UNREAD_FIELD")
    private BenmeiAtenaParameter(ShikibetsuCode shikibetsuCode, RString psmShikibetsuTaisho) {
        this.shikibetsuCode = shikibetsuCode;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    public static BenmeiAtenaParameter createSelectByKeyParam(ShikibetsuCode shikibetsuCode, RString uaFt200Psm) {
        return new BenmeiAtenaParameter(shikibetsuCode, uaFt200Psm);
    }
}
