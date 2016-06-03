/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmengengaku.futangendogakunintei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class FutanGendogakuNinteiShinseiMapperParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 減免減額種類;

    private FutanGendogakuNinteiShinseiMapperParameter(
            HihokenshaNo 被保険者番号,
            RString 減免減額種類) {

        this.被保険者番号 = 被保険者番号;
        this.減免減額種類 = 減免減額種類;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @return 利用者負担額減額検索パラメータ
     */
    public static FutanGendogakuNinteiShinseiMapperParameter createParam(
            HihokenshaNo 被保険者番号,
            RString 減免減額種類) {
        return new FutanGendogakuNinteiShinseiMapperParameter(被保険者番号, 減免減額種類);
    }
}
