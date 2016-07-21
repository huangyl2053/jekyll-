/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1731011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1731011.SogojigyoShuruiShikyuGendogakuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link SogojigyoShuruiShikyuGendogakuDiv}の仕様クラスです。 <br> {@link SogojigyoShuruiShikyuGendogakuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public enum SogojigyoShuruiShikyuGendogakuSpec implements IPredicate<SogojigyoShuruiShikyuGendogakuDiv> {

    /**
     * 各必須入力項目未入力の場合です。
     */
    各必須入力項目未入力の場合 {
                @Override
                public boolean apply(SogojigyoShuruiShikyuGendogakuDiv div) {
                    return SpecHelper.is各必須入力項目未入力(div);
                }
            },
    /**
     * 適用期間重複入力の場合です。
     */
    適用期間重複入力の場合 {
                @Override
                public boolean apply(SogojigyoShuruiShikyuGendogakuDiv div) {
                    return SpecHelper.is適用期間重複入力(div);
                }
            };

    /**
     * {@link SogojigyoShuruiShikyuGendogakuSpec}における判定ロジックのHelperクラスです。
     */
    private static class SpecHelper {

        /**
         * *が各項目が未入力の場合、エラーとします。
         *
         * @param div SogojigyoShuruiShikyuGendogakuDiv
         */
        public static boolean is各必須入力項目未入力(SogojigyoShuruiShikyuGendogakuDiv div) {

            return Boolean.TRUE;
        }

        /**
         * 適用期間が一部でも重複する場合はエラーとします。
         *
         * @param div SogojigyoShuruiShikyuGendogakuDiv
         */
        public static boolean is適用期間重複入力(SogojigyoShuruiShikyuGendogakuDiv div) {

            return Boolean.TRUE;
        }

    }

}
