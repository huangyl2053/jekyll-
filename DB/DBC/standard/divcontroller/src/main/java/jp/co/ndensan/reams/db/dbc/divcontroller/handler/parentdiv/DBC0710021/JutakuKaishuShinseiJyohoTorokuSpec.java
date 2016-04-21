/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link JutakuKaishuShinseiJyohoTorokuDiv}の仕様クラスです。
 * <br> {@link JutakuKaishuShinseiJyohoTorokuDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
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
            },
    /**
     * 住宅所有者入力必須チェック
     */
    提供着工年月が申請日の年月と一致しない {
                @Override
                public boolean apply(JutakuKaishuShinseiJyohoTorokuDiv div) {
                    return SpecHelper.is提供着工年月が申請日の年月と一致しない(div);
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

        public static boolean is提供着工年月が申請日の年月と一致しない(JutakuKaishuShinseiJyohoTorokuDiv div) {
            RString 給付実績連動_受託なし = new RString("1");
            RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
            RDate 申請日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue();
            RYearMonth 申請日年月 = null;
            if (申請日 != null) {
                申請日年月 = div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                        .getTxtShinseiYMD().getValue().getYearMonth();
            }
            RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
            if (給付実績連動_受託なし.equals(償還)) {
                if ((申請日 == null) || (!画面提供着工年月.getYearMonth().equals(申請日年月))) {
                    return false;
                }
            }
            return true;
        }
    }
}
