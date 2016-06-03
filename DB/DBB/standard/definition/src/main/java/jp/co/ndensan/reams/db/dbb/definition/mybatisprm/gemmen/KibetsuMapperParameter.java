/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.gemmen;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護期別を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KibetsuMapperParameter {

    private final Decimal 調定ID;

    private final boolean uses調定ID;

    private KibetsuMapperParameter(
            @lombok.NonNull Decimal 調定ID,
            boolean uses調定ID) {

        this.調定ID = 調定ID;

        this.uses調定ID = uses調定ID;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 調定ID Decimal
     * @return 身体手帳検索パラメータ
     */
    public static KibetsuMapperParameter createSelectByKeyParam(
            Decimal 調定ID) {
        return new KibetsuMapperParameter(調定ID, true);
    }
}
