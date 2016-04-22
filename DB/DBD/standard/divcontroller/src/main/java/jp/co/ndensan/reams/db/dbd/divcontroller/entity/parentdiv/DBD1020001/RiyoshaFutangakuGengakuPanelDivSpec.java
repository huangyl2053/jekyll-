/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 利用者負担額減額申請バリデーションクラスです。
 *
 * @reamsid_L DBD-3660-010 xuyue
 */
public enum RiyoshaFutangakuGengakuPanelDivSpec implements IPredicate<RiyoshaFutangakuGengakuPanelDiv> {

    申請日の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtShinseiYmd().getValue() != null && !div.getTxtShinseiYmd().getValue().isEmpty();
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
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getRadKetteiKubun().getSelectedKey() != null;
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
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtKettaiYmd().getValue() != null && !div.getTxtKettaiYmd().getValue().isEmpty();
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
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtTekiyoYmd().getValue() != null && !div.getTxtTekiyoYmd().getValue().isEmpty();
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
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtYukoKigenYmd().getValue() != null && !div.getTxtYukoKigenYmd().getValue().isEmpty();
                }
            },
    給付率の非空チェック {
                /**
                 * 給付率の非空チェックです。
                 *
                 * @param div 利用者負担額減額申請Div
                 * @return true:給付率が非空です、false:給付率が空です。
                 */
                @Override
                public boolean apply(RiyoshaFutangakuGengakuPanelDiv div) {
                    return div.getTxtKyufuRitsu().getValue() != null;
                }
            }
}
