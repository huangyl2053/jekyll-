/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.JutakuKaishuShinseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link JutakuKaishuShinseiJyohoTorokuDiv}の仕様クラスです。
 * <br> {@link JutakuKaishuShinseiJyohoTorokuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-0992-100 yebangqiang
 */
public enum JutakuKaishuShinseiSpec implements IPredicate<JutakuKaishuShinseiDiv> {

    /**
     * 提供着工年月入力必須チェック
     */
    サービス年月が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiDiv div) {
                    return SpecHelper.isサービス年月が入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean isサービス年月が入力(JutakuKaishuShinseiDiv div) {
            return div.getJutakuKaishuShinseiList().getTxtServiceYM().getValue() != null;
        }
    }
}
