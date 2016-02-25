/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.KokuhorenJohoTorikomiBatchKidoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;

/**
 *
 * @author n3331
 */
public enum KokuhorenJohoTorikomiSpec implements IPredicate<KokuhorenJohoTorikomiBatchKidoDiv> {

    同月過誤もしくは通常分給付実績情報にチェックがある {
                /**
                 * 処理対象情報が選択可能状態であり、同月過誤もしくは通常分給付実績情報にチェックがある場合にtrueを返す。
                 *
                 * @param div 国保連情報取込Div
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KokuhorenJohoTorikomiBatchKidoDiv div) {
                    CheckBoxList 同月過誤分給付実績情報 = div.getChkDogetsuKagobun();
                    CheckBoxList 通常分給付実績情報 = div.getChkTsujobun();
                    return div.getPnlShoritaishoJoho().isDisplayNone()
                    || !(同月過誤分給付実績情報.getSelectedItems().isEmpty() && 通常分給付実績情報.getSelectedItems().isEmpty());
                }
            },
    出力順が有効である場合に出力順が設定されている {
                /**
                 * 出力順が有効である場合に出力順が設定されている場合にtrueを返す。
                 *
                 * @param div 国保連情報取込Div
                 * @return true：仕様を満たす、false：仕様を満たさない
                 */
                @Override
                public boolean apply(KokuhorenJohoTorikomiBatchKidoDiv div) {
                    return div.getPnlShutsuryokuJun().isDisplayNone() || div.getCcdShutsuryokuJun().get出力順ID() != 0;
                }
            }
}
