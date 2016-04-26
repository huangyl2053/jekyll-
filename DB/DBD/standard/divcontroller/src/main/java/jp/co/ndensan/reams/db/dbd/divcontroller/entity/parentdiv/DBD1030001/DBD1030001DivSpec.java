/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 社会福祉法人等利用者負担軽減申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3660-010 wangjie2
 */
public enum DBD1030001DivSpec implements IPredicate<DBD1030001Div> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtShinseiYMD().getValue() != null && !div.getTxtShinseiYMD().getValue().isEmpty();
                }
            },
    決定区分の非空チェック {
                /**
                 * 決定区分の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:決定区分が非空です、false:決定区分が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getRadKetteiKubun().getSelectedKey() != null && !div.getRadKetteiKubun().getSelectedKey().isEmpty();
                }
            },
    決定日の非空チェック {
                /**
                 * 決定日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:決定日が非空です、false:決定日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtKetteiYMD().getValue() != null && !div.getTxtKetteiYMD().getValue().isEmpty();
                }
            },
    適用日の非空チェック {
                /**
                 * 適用日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:適用日が非空です、false:適用日が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtTekiyoYMD().getValue() != null && !div.getTxtTekiyoYMD().getValue().isEmpty();
                }
            },
    有効期限の非空チェック {
                /**
                 * 有効期限の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:有効期限が非空です、false:有効期限が空です。
                 */
                @Override
                public boolean apply(DBD1030001Div div) {
                    return div.getTxtYukoKigenYMD().getValue() != null && !div.getTxtYukoKigenYMD().getValue().isEmpty();
                }
            }

}
