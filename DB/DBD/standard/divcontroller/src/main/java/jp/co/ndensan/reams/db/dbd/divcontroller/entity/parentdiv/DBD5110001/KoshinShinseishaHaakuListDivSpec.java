/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5110001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 更新未申請者把握リスト作成画面バリデーションクラスです。
 *
 * @reamsid_L DBD-1420-010 wangjie2
 */
public enum KoshinShinseishaHaakuListDivSpec implements IPredicate<KoshinShinseishaHaakuListDiv> {

    認定有効期間_終了月の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinShinseishaHaakuListDiv div) {
                    return div.getTxtInsatsuDate().getDomain() != null;
                }
            },
    認定有効期間_終了月_Fromの非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinShinseishaHaakuListDiv div) {
                    return div.getTxtInsatsuDateFrom().getDomain() != null;
                }
            },
    認定有効期間_終了月_Toの非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinShinseishaHaakuListDiv div) {
                    return div.getTxtInsatsuDateTo().getDomain() != null;
                }
            },
    期間大小関係チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinShinseishaHaakuListDiv div) {
                    if (div.getTxtInsatsuDateFrom().getDomain() != null && div.getTxtInsatsuDateTo().getDomain() != null) {
                        return div.getTxtInsatsuDateFrom().getDomain().isBeforeOrEquals(div.getTxtInsatsuDateTo().getDomain());
                    }
                    return true;
                }
            }

}
