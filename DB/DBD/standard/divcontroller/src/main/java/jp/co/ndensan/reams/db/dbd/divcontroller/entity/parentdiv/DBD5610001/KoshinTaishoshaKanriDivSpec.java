/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5610001;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 新申請対象者管理リスト作成画面のバリデーションクラスです。
 *
 * @reamsid_L DBD-1460-010 liuyl
 */
public enum KoshinTaishoshaKanriDivSpec implements IPredicate<KoshinTaishoshaKanriDiv> {

    有効期間_終了日_Fromの非空チェック {
                /**
                 * 有効期間_終了日_Fromの非空チェックです。
                 *
                 * @param div KoshinTaishoshaKanriDiv
                 * @return true:有効期間_終了日_Fromが非空です、false:有効期間_終了日_Fromが空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getYukoKikanSelect().getTxtYukokikanSelect().getFromValue() != null;
                }
            },
    対象月の非空チェック {
                /**
                 * 対象月の非空チェックです。
                 *
                 * @param div KoshinTaishoshaKanriDiv
                 * @return true:対象月が非空です、false:対象月が空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getZenkaiJoho().getTxtTaishoTsuki().getValue() != null;
                }
            },
    有効期間_終了日_Toの非空チェック {
                /**
                 * 効期間_終了日_Toの非空チェックです。
                 *
                 * @param div KoshinTaishoshaKanriDiv
                 * @return true:効期間_終了日_Toが非空です、false:効期間_終了日_Toが空です。
                 */
                @Override
                public boolean apply(KoshinTaishoshaKanriDiv div) {
                    return div.getYukoKikanSelect().getTxtYukokikanSelect().getToValue() != null;
                }
            };
}
