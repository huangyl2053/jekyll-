/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0310012;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0310012.PnlTotalPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * {@link PnlTotalPanelDiv}の仕様クラスです。 <br> {@link PnlTotalPanelDiv}における画面としての仕様を定義しています。
 */
public enum PnlTotalPanelSpec implements IPredicate<PnlTotalPanelDiv> {

    /**
     * 契約申請受付日必須入力
     */
    契約申請受付日 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is契約申請受付日(div);
                }
            },
    /**
     * 契約申請日必須入力
     */
    契約申請日 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is契約申請日(div);
                }
            },
    /**
     * 契約事業者番号必須入力
     */
    契約事業者番号 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is契約事業者番号(div);
                }
            },
    /**
     * 決定区分必須入力
     */
    決定区分 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is決定区分(div);
                }
            },
    /**
     * 不承認理由必須入力
     */
    不承認理由 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is不承認理由(div);
                }
            },
    /**
     * 年度必須入力
     */
    年度 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is年度(div);
                }
            },
    /**
     * 番号①必須入力
     */
    番号1 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is番号1(div);
                }
            },
    /**
     * 番号②必須入力
     */
    番号2 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is番号2(div);
                }
            },
    /**
     * 金額不整合チェック
     */
    金額 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is金額不整合(div);
                }
            },
    /**
     * 受領委任契約番号重複チェック
     */
    受領委任契約番号 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is受領委任契約番号重複(div);
                }
            },
    /**
     * 存在チェック
     */
    存在 {
                @Override
                public boolean apply(PnlTotalPanelDiv div) {
                    return SpecHelper.is存在(div);
                }
            };

    private static class SpecHelper {

        private static final RString KEY_0 = new RString("key0");
        private static final RString KEY_1 = new RString("key1");
        private static final RString 登録 = new RString("登録");

        public static boolean is契約申請受付日(PnlTotalPanelDiv div) {
            return div.getPnlCommon().getPnlDetail().getTxtKeyakushinseuketukebi().getValue() != null;
        }

        public static boolean is契約申請日(PnlTotalPanelDiv div) {
            return div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue() != null;
        }

        public static boolean is契約事業者番号(PnlTotalPanelDiv div) {
            return !div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue().isEmpty();
        }

        public static boolean is決定区分(PnlTotalPanelDiv div) {
            if (div.getPnlCommon().getPnlDetail().getTxtKeyakukettebi().getValue() != null) {
                return !div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey().isEmpty();
            }
            return true;
        }

        public static boolean is不承認理由(PnlTotalPanelDiv div) {
            if (KEY_1.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
                return !div.getPnlCommon().getPnlDetail().getTxtFusyoninriyu().getValue().isEmpty();
            }
            return true;
        }

        public static boolean is年度(PnlTotalPanelDiv div) {
            if (KEY_0.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
                return !div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedKey().isEmpty();
            }
            return true;
        }

        public static boolean is番号1(PnlTotalPanelDiv div) {
            if (KEY_0.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
                return !div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue().toString().isEmpty();
            }
            return true;
        }

        public static boolean is番号2(PnlTotalPanelDiv div) {
            if (KEY_0.equals(div.getPnlCommon().getPnlDetail().getRdoKettekubun().getSelectedKey())) {
                return !div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue().toString().isEmpty();
            }
            return true;
        }

        public static boolean is金額不整合(PnlTotalPanelDiv div) {
            if (div.getPnlCommon().getPnlDetail().getPnlKyufuhi().getTxtHokentaisyohiyogaku().getValue() != null) {
                // TODO QA No.432
                return true;
            }
            return true;
        }

        public static boolean is受領委任契約番号重複(PnlTotalPanelDiv div) {
            RStringBuilder rsb = new RStringBuilder();
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getDdlYear().getSelectedValue());
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango1().getValue());
            rsb.append(div.getPnlCommon().getPnlDetail().getPnlHidari().getTxtBango2().getValue());
            // TODO QA No.432
            return true;
        }

        public static boolean is存在(PnlTotalPanelDiv div) {
            RString 状態 = ViewStateHolder.get(ViewStateKeys.処理モード, RString.class);
            // TODO QA No.431
//                KaigoShikakuKihonDiv kaigoDiv = (KaigoShikakuKihonDiv) div.getPnlCommon().getCcdKaigoShikakuKihon();
            if (登録.equals(状態)
                    && div.getPnlCommon().getPnlDetail().getTxtKeyakushinseibi().getValue() != null
                    && !div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue().isEmpty()
                    && !div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey().isEmpty()) {
                ShokanJuryoininKeiyakushaFinder finder = InstanceProvider.create(ShokanJuryoininKeiyakushaFinder.class);
                ShokanJuryoininKeiyakusha shokanData = finder.getShokanJuryoininKeiyakusha(
                        new HihokenshaNo("000000003"),
                        new FlexibleDate(div.getPnlCommon().getPnlDetail()
                                .getTxtKeyakushinseibi().getValue().toDateString()),
                        div.getPnlCommon().getPnlDetail().getTxtKeyakujigyosyaNo().getValue(),
                        div.getPnlCommon().getPnlDetail().getDdlKeiyakuServiceType().getSelectedKey());
                return shokanData != null;
            }
            return true;
        }
    }
}
