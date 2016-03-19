/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.dbc0720011.MishinsaShikyuShinseiListHandler;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 住宅改修費支給申請一括審査・決定画面JutakuKaishuhiShikyuShinseiPanelSpec
 */
public enum JutakuKaishuhiShikyuShinseiPanelSpec implements IPredicate<JutakuKaishuhiShikyuShinseiPanelDiv> {

    支給申請日有効性 {
                @Override
                public boolean apply(JutakuKaishuhiShikyuShinseiPanelDiv div) {
                    return MishinsaShikyuShinseiListHandler.is支給申請日有効(div);
                }

            },
    支給申請日入力 {
                @Override
                public boolean apply(JutakuKaishuhiShikyuShinseiPanelDiv div) {
                    return MishinsaShikyuShinseiListHandler.is支給申請日入力(div);
                }

            },
    データ選択のチェック {
                @Override
                public boolean apply(JutakuKaishuhiShikyuShinseiPanelDiv div) {
                    return MishinsaShikyuShinseiListHandler.isデータ選択(div);
                }

            },
    未審査のチェック {
                @Override
                public boolean apply(JutakuKaishuhiShikyuShinseiPanelDiv div) {
                    return MishinsaShikyuShinseiListHandler.is未審査(div);
                }

            }
}
