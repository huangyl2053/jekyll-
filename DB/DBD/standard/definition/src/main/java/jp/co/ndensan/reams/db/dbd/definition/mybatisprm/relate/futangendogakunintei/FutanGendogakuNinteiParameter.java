/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 宛先情報のパラメータ
 *
 * @reamsid_L DBD-3570-030 wangchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public final class FutanGendogakuNinteiParameter {

    private RString 減免減額種類;
    private HihokenshaNo 被保険者番号;
    private int 履歴番号;

    private boolean uses減免減額種類;
    private boolean uses被保険者番号;
    private boolean uses履歴番号;

    private FutanGendogakuNinteiParameter(
            @lombok.NonNull RString 減免減額種類,
            @lombok.NonNull HihokenshaNo 被保険者番号,
            int 履歴番号,
            boolean uses減免減額種類,
            boolean uses被保険者番号,
            boolean uses履歴番号) {

        this.減免減額種類 = 減免減額種類;
        this.被保険者番号 = 被保険者番号;
        this.履歴番号 = 履歴番号;

        this.uses減免減額種類 = uses減免減額種類;
        this.uses被保険者番号 = uses被保険者番号;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * 負担限度額認定更新のお知らせ通知書が発行可能である場合、介護負担限度額認定の情報を取得する。
     *
     * @param 減免減額種類 減免減額種類
     * @param 被保険者番号 被保険者番号
     * @return 利用者負担額減額検索パラメータ
     */
    public static FutanGendogakuNinteiParameter createSelectParam(
            RString 減免減額種類,
            HihokenshaNo 被保険者番号) {
        return new FutanGendogakuNinteiParameter(減免減額種類, 被保険者番号, 0, true, true, true);
    }

    /**
     * 介護負担限度額認定の情報を取得する。
     *
     * @param 減免減額種類 減免減額種類
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return 利用者負担額減額検索パラメータ
     */
    public static FutanGendogakuNinteiParameter createSelectParam(
            RString 減免減額種類,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        return new FutanGendogakuNinteiParameter(減免減額種類, 被保険者番号, 履歴番号, true, true, true);
    }
}
