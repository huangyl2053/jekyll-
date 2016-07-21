/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 要介護認定取消画面のチェックロジックです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public enum NinteiShinseiTorokuTorikeshiShosaiSpec implements IPredicate<NinteiShinseiTorokuTorikeshiShosaiDiv> {

    /**
     * 異動事由が未選択チェック。
     */
    異動事由が未選択チェック {
                @Override
                public boolean apply(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
                    RString 異動事由 = div.getCcdSonotaJoho().get異動事由();
                    return null != 異動事由 && !異動事由.isEmpty();
                }
            },
    /**
     * 理由が未入力チェック。
     */
    理由が未入力チェック {
                @Override
                public boolean apply(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
                    RString 理由 = div.getCcdSonotaJoho().get理由();
                    return null != 理由 && !理由.isEmpty();
                }
            },
    /**
     * 更新チェック。
     */
    更新チェック {
                @Override
                public boolean apply(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
                    RString 介護事務 = div.getHdnKaigoJimuCode();
                    RString 介護認定 = div.getHdnKaigoNinteiCode();
                    RString menuId = ResponseHolder.getMenuID();
                    // TODO. menuID
                    if ((DonyuKeitaiCode.事務単一.getCode().equals(介護事務) && DonyuKeitaiCode.認定単一.getCode().equals(介護認定))
                    || (DonyuKeitaiCode.事務単一.getCode().equals(介護事務) && 介護認定.isEmpty())
                    || (DonyuKeitaiCode.事務広域.getCode().equals(介護事務) && DonyuKeitaiCode.認定広域.getCode().equals(介護認定))) {
//                        return menuId.equals(認定メニュー);
                        return true;
                    } else if (介護事務.isEmpty() && DonyuKeitaiCode.認定広域.getCode().equals(介護認定)) {
                        // return menuId.equals(受給メニュー);
                        return true;
                    }
                    return false;
                }
            };
}
