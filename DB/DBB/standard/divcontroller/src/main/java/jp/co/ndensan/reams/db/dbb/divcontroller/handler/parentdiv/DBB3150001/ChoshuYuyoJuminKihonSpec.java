/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 介護保険料徴収猶予画面
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public enum ChoshuYuyoJuminKihonSpec implements IPredicate<ChoshuYuyoJuminKihonDiv> {

    /**
     * エラーチェック
     */
    エラーチェック {
                @Override
                public boolean apply(ChoshuYuyoJuminKihonDiv div) {
                    return false;
                }
            };
}
