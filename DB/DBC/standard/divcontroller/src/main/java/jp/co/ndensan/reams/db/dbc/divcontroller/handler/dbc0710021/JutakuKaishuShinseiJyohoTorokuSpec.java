/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0710021;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link JutakuKaishuShinseiJyohoTorokuDiv}の仕様クラスです。
 * <br> {@link JutakuKaishuShinseiJyohoTorokuDiv}における画面としての仕様を定義しています。
 */
public enum JutakuKaishuShinseiJyohoTorokuSpec implements IPredicate<JutakuKaishuShinseiJyohoTorokuDiv> {

    /**
     * 提供着工年月入力必須チェック
     */
    提供着工年月が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is提供着工年月が入力(div);
                }
            },
    /**
     * 領収日入力必須チェック
     */
    領収日が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is領収日が入力(div);
                }
            },
    /**
     * 申請日入力必須チェック
     */
    申請日が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is申請日が入力(div);
                }
            },
    /**
     * 申請取消事由入力必須チェック
     */
    申請取消事由が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is申請取消事由が入力(div);
                }
            },
    /**
     * 住宅所有者入力必須チェック
     */
    住宅所有者が入力 {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is住宅所有者が入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean is提供着工年月が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getTxtTeikyoYM().getValue() != null;
        }

        public static boolean is住宅所有者が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return !div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue().isEmpty();
        }

        public static boolean is領収日が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue() != null;
        }

        public static boolean is申請日が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue() != null;
        }

        public static boolean is申請取消事由が入力(JutakuKaishuShinseiJyohoTorokuDiv div) {
            return !div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu()
                    .getSelectedKey().isNullOrEmpty();
        }
    }
}
