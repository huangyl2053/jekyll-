/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額認定証・決定通知書個別発行バリデーションクラスです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public enum GemmenGengakuShoHakkoMainDivSpec implements IPredicate<GemmenGengakuShoHakkoMainDiv> {

    出力対象の選択されていない {
                /**
                 * 出力対象の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:出力対象が選択、false:画面に一つ出力チェックボックスを選択しない、エラーとする
                 */
                @Override
                public boolean apply(GemmenGengakuShoHakkoMainDiv div) {
                    return div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()
                    || div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish();
                }
            },
    申請情報の存在しない {
                /**
                 * 申請情報の存在チェックです。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:存在、false:存在しない
                 */
                @Override
                public boolean apply(GemmenGengakuShoHakkoMainDiv div) {
                    return !new RString("-1").equals(div.getHiddenRirekiNo());
                }
            },
    交付日の非空チェック {
                /**
                 * 交付日の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:交付日が非空です、false:交付日が空です。
                 */
                @Override
                public boolean apply(GemmenGengakuShoHakkoMainDiv div) {
                    return !div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().getValue().isEmpty();
                }
            },
    発行日の非空チェック {
                /**
                 * 発行日の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:発行日が非空です、false:発行日が空です。
                 */
                @Override
                public boolean apply(GemmenGengakuShoHakkoMainDiv div) {
                    return !div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue().isEmpty();
                }
            },
    文書番号の非空チェック {
                /**
                 * 文書番号の必須入力です。
                 *
                 * @param div SaiketukekaTorokuPanelDiv
                 * @return true:文書番号が非空です、false:文書番号が空です。
                 */
                @Override
                public boolean apply(GemmenGengakuShoHakkoMainDiv div) {
                    return !div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getCcdBunshoNo().get文書番号().isNullOrEmpty();
                }
            },
}
