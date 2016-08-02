/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001;


import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * @author liuyl
 */
public enum KoshinTaishoshaKanriDivSpec implements IPredicate<KoshinTaishoshaKanriDiv>{
       有効期間_終了日_Fromの非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getYukoKikanSelect().getTxtYukokikanSelect().getFromValue()!=null;
                }
            },
            対象月の非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getZenkaiJoho().getTxtTaishoTsuki().getValue()!=null;
                }
            },
    有効期間_終了日_Toの非空チェック {
                /**
                 * 申請日の非空チェックです。
                 *
                 * @param div 社会福祉法人等利用者負担軽減申請Div
                 * @return true:申請日が非空です、false:申請日が空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getYukoKikanSelect().getTxtYukokikanSelect().getToValue()!=null;
                }
            };
}
