/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040021;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 特別地域加算軽減実績管理画面の入力チェックです
 *
 * @reamsid_L DBD-3880-010 xuejm
 */
public enum TokubetsuPanelDivSpec implements IPredicate<TokubetsuPanelDiv> {

    年月範囲開始が非空必須チェック {
                /**
                 * 年月範囲開始が非空必須チェック .
                 *
                 * @param div TokubetsuPanelDiv
                 * @return true:年月範囲開始が非空です、false:年月範囲開始が空白の場合。
                 */

                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    RDate ymrangefrom = div.getTxtRangeYM().getFromValue();
                    return ymrangefrom != null && !ymrangefrom.toDateString().isEmpty();
                }

            },
    年月範囲終了が非空必須チェック {
                /**
                 * 年月範囲開始が非空必須チェック .
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:年月範囲開始が非空です、false:年月範囲開始が空白の場合。
                 */
                @Override
                public boolean apply(TokubetsuPanelDiv div) {
                    RDate ymrangeto = div.getTxtRangeYM().getToValue();
                    return ymrangeto != null && !ymrangeto.toDateString().isEmpty();
                }
            }

}
