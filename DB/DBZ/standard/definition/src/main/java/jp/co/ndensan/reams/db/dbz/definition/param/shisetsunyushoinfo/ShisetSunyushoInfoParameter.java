/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.shisetsunyushoinfo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 施設入所情報を取得するのParameterクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShisetSunyushoInfoParameter {

    private final ShikibetsuCode shikibetsuCode;

    private ShisetSunyushoInfoParameter(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * パラメータ設定です
     *
     * @param shikibetsuCode 識別コード
     * @return ShisetSunyushoInfoParameter ShisetSunyushoInfoParameter
     */
    public static ShisetSunyushoInfoParameter createParam(ShikibetsuCode shikibetsuCode) {
        return new ShisetSunyushoInfoParameter(shikibetsuCode);
    }
}
