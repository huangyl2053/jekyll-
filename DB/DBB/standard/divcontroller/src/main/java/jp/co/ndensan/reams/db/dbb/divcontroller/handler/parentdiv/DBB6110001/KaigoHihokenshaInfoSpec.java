/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimusha;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaHolder;
import jp.co.ndensan.reams.db.dbb.business.core.basic.RentaiGimushaIdentifier;
import jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka.FukaShokaiController;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.DBB6110001StateName;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import jp.co.ndensan.reams.db.dbb.service.core.kaigohihokenshainfo.KaigoHihokenshaInfoPanelManger;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.FukaTaishoshaKey;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
            },
    /**
     * 同一日における複数連帯納付義務者登録。
     */
    同一日における複数連帯納付義務者登録 {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    if (DBB6110001StateName.連帯納付義務者削除.getName().equals(ResponseHolder.getState())) {
                        return true;
                    }
                    return SpecHelper.is同一日における複数連帯納付義務者登録(div);
                }
            },
    /**
     * 前履歴より前の期間指定。
     */
    前履歴より前の期間指定 {
                @Override
                public boolean apply(KaigoHihokenshaInfoPanelDiv div) {
                    if (DBB6110001StateName.連帯納付義務者削除.getName().equals(ResponseHolder.getState())) {
                        return true;
                    }
                    return SpecHelper.is前履歴より前の期間指定(div);
                }
            };

    private static class SpecHelper {

        private static final RString ZERO = new RString("0");

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
            RentaiGimushaHolder 初期holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報初期, RentaiGimushaHolder.class);
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
            if (履歴番号.isNull() || 履歴番号.isEmpty()) {
                return true;
            }
            RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                    被保険者番号, new Decimal(履歴番号.toString()));
            RentaiGimusha result = 初期holder.getKogakuGassanJikoFutanGaku(identifier);
            RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
            RDate 終了年月日 = div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue();
            if (終了年月日 != null && result != null) {
                return !(開始年月日.equals(new RDate(result.get開始年月日().toString()))
                        && 終了年月日.equals(new RDate(result.get終了年月日().toString())));
            }
            return true;
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
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
            RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
            KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
            List<RentaiGimusha> list = holder.getRentaiGimushaList();
            if (履歴番号.isEmpty()) {
                Decimal 最新履歴番号 = manager.get最新履歴番号(被保険者番号);
                if (最新履歴番号 == null && (list == null || list.isEmpty())) {
                    履歴番号 = ZERO;
                } else {
                    int 番号 = list.get(0).get履歴番号().intValue();
                    for (RentaiGimusha rentai : list) {
                        int 新番号 = rentai.get履歴番号().intValue();
                        番号 = max番号(番号, 新番号);
                    }
                    履歴番号 = new RString(番号 + 1);
                }
            }
            RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                    被保険者番号, new Decimal(履歴番号.toString()));
            RentaiGimusha curResult = holder.getKogakuGassanJikoFutanGaku(identifier);
            RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
            RDate 終了年月日 = div.getRentaiNofuGimushaInfo().getTxtShuryoYMD().getValue();
            if (list != null) {
                for (RentaiGimusha result : list) {
                    if (result.equals(curResult) || result.isDeleted()) {
                        continue;
                    }
                    if (終了年月日 == null) {
                        return !(開始年月日.isAfter(new RDate(result.get開始年月日().toString()))
                                && 開始年月日.isBeforeOrEquals(new RDate(result.get終了年月日().toString())));
                    }
                    return !(開始年月日.isBeforeOrEquals(new RDate(result.get開始年月日().toString()))
                            && 終了年月日.isAfterOrEquals(new RDate(result.get開始年月日().toString())))
                            && !(開始年月日.isBeforeOrEquals(new RDate(result.get終了年月日().toString()))
                            && 終了年月日.isAfterOrEquals(new RDate(result.get終了年月日().toString())))
                            && !(開始年月日.isAfterOrEquals(new RDate(result.get開始年月日().toString()))
                            && 終了年月日.isBeforeOrEquals(new RDate(result.get終了年月日().toString())));
                }
            }
            return true;
        }

        private static int max番号(int 番号, int 新番号) {
            if (新番号 > 番号) {
                番号 = 新番号;
            }
            return 番号;
        }

        /**
         * 前履歴より前の期間指定ある場合。
         *
         * @param div KaigoHihokenshaInfoDiv
         */
        public static boolean is前履歴より前の期間指定(KaigoHihokenshaInfoPanelDiv div) {
            FukaTaishoshaKey taishoshaKey = FukaShokaiController.getFukaTaishoshaKeyInViewState();
            HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
            RString 履歴番号 = div.getRentaiNofuGimushaInfo().getTxtRirekiNo().getValue();
            RentaiGimushaHolder holder = ViewStateHolder.get(ViewStateKeys.連帯納付義務者情報, RentaiGimushaHolder.class);
            KaigoHihokenshaInfoPanelManger manager = InstanceProvider.create(KaigoHihokenshaInfoPanelManger.class);
            List<RentaiGimusha> list = holder.getRentaiGimushaList();
            if (履歴番号.isEmpty()) {
                Decimal 最新履歴番号 = manager.get最新履歴番号(被保険者番号);
                if (最新履歴番号 == null && (list == null || list.isEmpty())) {
                    履歴番号 = ZERO;
                } else {
                    int 番号 = list.get(0).get履歴番号().intValue();
                    for (RentaiGimusha rentai : list) {
                        int 新番号 = rentai.get履歴番号().intValue();
                        番号 = max番号(番号, 新番号);
                    }
                    履歴番号 = new RString(番号 + 1);
                }
            }
            RentaiGimushaIdentifier identifier = new RentaiGimushaIdentifier(
                    被保険者番号, new Decimal(履歴番号.toString()));
            int cur履歴 = 履歴番号.toInt();
            RentaiGimusha curResult = holder.getKogakuGassanJikoFutanGaku(identifier);
            if (list != null && !list.isEmpty()) {
                FlexibleDate minDate = null;
                for (RentaiGimusha result : list) {
                    if (!result.isDeleted() && curResult == null) {
                        minDate = result.get開始年月日();
                    } else if (!result.isDeleted() && curResult != null
                            && cur履歴 > result.get履歴番号().intValue()) {
                        minDate = result.get開始年月日();
                    }
                }
                if (minDate != null) {
                    return is前履歴より前の期間(div, list, curResult, minDate);
                }
            }
            return true;
        }

        private static boolean is前履歴より前の期間(KaigoHihokenshaInfoPanelDiv div, List<RentaiGimusha> list,
                RentaiGimusha curResult, FlexibleDate minDate) {
            RDate 開始年月日 = div.getRentaiNofuGimushaInfo().getTxtKaishiYMD().getValue();
            for (RentaiGimusha result : list) {
                if (list.get(0).equals(curResult)) {
                    return true;
                }
                if (result.equals(curResult) || result.isDeleted()) {
                    continue;
                }
                return !(開始年月日.isBefore(new RDate(minDate.toString())));
            }
            return true;
        }
    }
}
