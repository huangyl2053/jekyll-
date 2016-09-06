/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1100012;

import java.util.Collections;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100012.KogakuGassanShikyuShinseiTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author admin
 */
public enum KogakuGassanShikyuShinseiTorokuPanelSpec implements IPredicate<KogakuGassanShikyuShinseiTorokuPanelDiv> {

    /**
     * 終了日が開始日以前。
     */
    終了日が開始日以前 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getFromValue() != null
                    && div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getToValue() != null) {
                        return div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getFromValue().isBeforeOrEquals(
                                div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtShinseiYMD().getToValue());
                    }
                    return true;
                }
            },
    /**
     * 介護支給申請書整理番号1必須。
     */
    介護支給申請書整理番号1必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango1().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 介護支給申請書整理番号2必須。
     */
    介護支給申請書整理番号2必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango2().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 介護支給申請書整理番号3必須。
     */
    介護支給申請書整理番号3必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getDdlKaigoShikyuShinseishoSeiriBango3().getSelectedValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 介護支給申請書整理番号4必須。
     */
    介護支給申請書整理番号4必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 介護支給申請書整理番号各項目の桁数チェック1。
     */
    介護支給申請書整理番号各項目の桁数チェック1 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    RString 六 = new RString("6");
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().getValue() != null
                    && div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkKaigoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtKaigoShikyuShinseishoSeiriBango4().getValue().length()
                        == Integer.parseInt(六.toString());
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号1必須。
     */
    医療支給申請書整理番号1必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango1().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号2必須。
     */
    医療支給申請書整理番号2必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango2().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号3必須。
     */
    医療支給申請書整理番号3必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号4必須。
     */
    医療支給申請書整理番号4必須 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return !div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().getValue().isEmpty();
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号各項目の桁数チェック1。
     */
    医療支給申請書整理番号各項目の桁数チェック1 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    RString 六 = new RString("6");
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().getValue() != null
                    && div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango3().getValue().length()
                        == Integer.parseInt(六.toString());
                    }
                    return true;
                }
            },
    /**
     * 医療支給申請書整理番号各項目の桁数チェック2。
     */
    医療支給申請書整理番号各項目の桁数チェック2 {
                @Override
                public boolean apply(KogakuGassanShikyuShinseiTorokuPanelDiv div) {
                    RString 六 = new RString("6");
                    if (div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().getValue() != null
                    && div.getKogakuGassanShikyuShinseiTorokuSearch().getCbkIryoShikyuShinseishoSeiriBango()
                    .getSelectedKeys().equals(Collections.EMPTY_LIST)) {
                        return div.getKogakuGassanShikyuShinseiTorokuSearch().getTxtIryoShikyuShinseishoSeiriBango4().getValue().length()
                        == Integer.parseInt(六.toString());
                    }
                    return true;
                }
            };
}
