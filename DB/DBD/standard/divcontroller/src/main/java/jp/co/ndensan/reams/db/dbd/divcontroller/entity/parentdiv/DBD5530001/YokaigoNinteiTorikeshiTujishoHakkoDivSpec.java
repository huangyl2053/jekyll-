/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5530001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 要介護認定取消通知書発行のバリデーションクラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
public enum YokaigoNinteiTorikeshiTujishoHakkoDivSpec implements IPredicate<YokaigoNinteiTorikeshiTujishoHakkoDiv> {

    異動事由必須入力チェック {
                /**
                 * 異動事由の非空チェックです。
                 *
                 * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
                 * @return true:異動事由が非空です、false:異動事由が空です。
                 */
                @Override
                public boolean apply(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
                    return div.getTujishoHakkoMeisai().getTxtIdoJiyu().getValue() != null && !div.getTujishoHakkoMeisai().
                    getTxtIdoJiyu().getValue().isEmpty();
                }
            },
    期間大小関係チェック {
                /**
                 * 期間大小関係チェックです。
                 *
                 * @param div YokaigoNinteiTorikeshiTujishoHakkoDiv
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(YokaigoNinteiTorikeshiTujishoHakkoDiv div) {
                    if (div.getTujishoHakkoMeisai().getTxtYukoKigen2().getFromValue() != null && div.getTujishoHakkoMeisai().
                    getTxtYukoKigen2().getToValue() != null) {
                        return div.getTujishoHakkoMeisai().getTxtYukoKigen2().getFromValue().isBeforeOrEquals(div.getTujishoHakkoMeisai().
                                getTxtYukoKigen2().getToValue());
                    }
                    return true;
                }
            }
}
