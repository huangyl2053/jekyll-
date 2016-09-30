/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * {@link KaigoHihokenshaInfoDiv}の仕様クラスです。 <br> {@link KaigoHihokenshaInfoDiv}における画面としての仕様を定義しています。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public enum KaigoHihokenshaInfoSpec implements IPredicate<KaigoHihokenshaInfoPanelDiv> {

    /**
     * 連帯納付義務者が選択されていないチェック。
     */
    連帯納付義務者が選択されていない {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    return SpecHelper.is連帯納付義務者が選択されていない場合(div);
                }
            },
    /**
     * 初期状態からの変更有無場合。
     */
    初期状態からの変更有無 {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    return SpecHelper.is初期状態からの変更有無(div);
                }
            },
    /**
     * 開始日未入力場合。
     */
    開始日未入力 {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    return SpecHelper.is開始日未入力(div);
                }
            },
    /**
     * 開始日と終了日の前後順場合。
     */
    開始日と終了日の前後順 {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    return SpecHelper.is開始日と終了日の前後順(div);
                }
            };

    private static class SpecHelper {

        /**
         * 連帯納付義務者が選択されていない場合です。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is連帯納付義務者が選択されていない場合(KaigoHihokenshaInfoPanelDiv div) {
            return div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode() != null;
        }

        /**
         * 初期状態からの変更有無です。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is初期状態からの変更有無(KaigoHihokenshaInfoPanelDiv div) {
            //TODO
            return div.getRentaiNofuGimushaInfo().getTxtShikibetsuCode() != null;
        }

        /**
         * 開始日未入力です。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is開始日未入力(KaigoHihokenshaInfoPanelDiv div) {
            return div.getRentaiNofuGimushaInfo().getTxtKaishiYMD() != null;
        }

        /**
         * 開始日と終了日の前後順です。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is開始日と終了日の前後順(KaigoHihokenshaInfoPanelDiv div) {
            if (div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue() == null) {
                return true;
            }
            return div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue().isBeforeOrEquals(
                    div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue());
        }

    }
}
