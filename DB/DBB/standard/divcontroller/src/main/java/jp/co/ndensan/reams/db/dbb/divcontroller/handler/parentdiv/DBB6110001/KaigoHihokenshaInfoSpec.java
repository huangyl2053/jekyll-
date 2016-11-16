/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaHolder;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaIdentifier;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.DBB6110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

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
                    if (DBB6110001StateName.連帯納付義務者修正.getName().equals(ResponseHolder.getState())) {
                        return SpecHelper.is初期状態からの変更有無(div);
                    }
                    return true;
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

        private static final RString 外国人 = new RString("外国人");
        private static final RString 住登外日本人 = new RString("住登外（日本人）");
        private static final RString 住登外外国人 = new RString("住登外（外国人）");

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
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
            if (履歴番号.isNull() || 履歴番号.isEmpty()) {
                return true;
            }
            RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                    被保険者番号, new Decimal(履歴番号.toString()));
            RentaiGimusha result = holder.getKogakuGassanJikoFutanGaku(identifier);
            RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
            RDate 終了年月日 = div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue();
            return !(開始年月日.equals(result.get開始年月日())
                    && 終了年月日.equals(result.get終了年月日()));
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
            if (div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue() != null
                    && div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue() != null) {
                return div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue().isBeforeOrEquals(
                        div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue());
            }
            return true;
        }

        /**
         * 同一日における複数連帯納付義務者登録です。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is同一日における複数連帯納付義務者登録(KaigoHihokenshaInfoPanelDiv div) {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            return taishoshaKey.get世帯コード().equals(div.getRentaiNofuGimushaInfo().getTxtSetaiCode().getDomain());
        }

        /**
         * 前履歴より前の期間指定ある場合。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is前履歴より前の期間指定(KaigoHihokenshaInfoPanelDiv div) {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            return taishoshaKey.get世帯コード().equals(div.getRentaiNofuGimushaInfo().getTxtSetaiCode().getDomain());
        }

        /**
         * 既同一世帯コードる場合。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is同一世帯コード(KaigoHihokenshaInfoPanelDiv div) {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            return taishoshaKey.get世帯コード().equals(div.getRentaiNofuGimushaInfo().getTxtSetaiCode().getDomain());
        }

        /**
         * 連帯納付義務者の住民種別る場合。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is連帯納付義務者の住民種別(KaigoHihokenshaInfoPanelDiv div) {
            RString 住民種別 = div.getRentaiNofuGimushaInfo().getTxtJuminShu().getValue();
            return !住民種別.isNull() && !住民種別.isEmpty() && !住民種別.equals(外国人) && !住民種別.equals(住登外日本人) && !住民種別.equals(住登外外国人);
        }

    }
}
