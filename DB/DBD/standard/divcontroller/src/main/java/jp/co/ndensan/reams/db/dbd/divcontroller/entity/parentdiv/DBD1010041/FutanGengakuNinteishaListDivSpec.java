/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010041;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 負担限度額認定者リストのバリデーションクラスです。
 *
 * @reamsid_L DBD-3960-010 xuejm
 */
public enum FutanGengakuNinteishaListDivSpec implements IPredicate<FutanGengakuNinteishaListDiv> {

    対象年度の未入力チェック {
                /**
                 * 対象年度が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:対象年度が非空です、false:対象年度が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getTxtTaishoYM().getValue() != null && !div.getTxtTaishoYM().getValue().isEmpty();
                }
            },
    所得年度の未入力チェック {
                /**
                 * 所得年度が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:所得年度が非空です、false:所得年度が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getTxtShotokuNendo().getValue() != null && !div.getTxtShotokuNendo().getValue().isEmpty();
                }
            },
    基準日の未入力チェック {
                /**
                 * 基準日が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:基準日が非空です、false:基準日が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getTxtKijunYMD().getValue() != null && !div.getTxtKijunYMD().getValue().isEmpty();
                }
            },
    課税判定等基準日の未入力チェック {
                /**
                 * 課税判定等基準日が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:課税判定等基準日が非空です、false:課税判定等基準日が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    FlexibleDate txtKazeiHanteiToKijunDate = div.getTxtKazeiHanteiToKijunDate().getValue();
                    return txtKazeiHanteiToKijunDate != null && !txtKazeiHanteiToKijunDate.isEmpty();
                }
            },
    旧措置者区分の未入力チェック {
                /**
                 * 旧措置者区分が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:旧措置者区分が非空です、false:旧措置者区分が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getRadKyusochishaKubun().getSelectedKey() != null
                    && !div.getRadKyusochishaKubun().getSelectedKey().isEmpty();
                }
            },
    世帯表示の未入力チェック {
                /**
                 * 世帯表示が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:世帯表示が非空です、false:世帯表示が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getRadSetaiHyoji().getSelectedKey() != null
                    && !div.getRadSetaiHyoji().getSelectedKey().isEmpty();
                }
            },
    受給者区分の未入力チェック {
                /**
                 * 受給者区分が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:受給者区分が非空です、false:受給者区分が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getRadJukyushaKubun().getSelectedKey() != null
                    && !div.getRadJukyushaKubun().getSelectedKey().isEmpty();
                }
            },
    利用者負担段階の未入力チェック {
                /**
                 * 利用者負担段階が未入力チェック .
                 *
                 * @param div FutanGengakuNinteishaListDiv
                 * @return true:利用者負担段階が非空です、false:利用者負担段階が空白の場合。
                 */
                @Override
                public boolean apply(FutanGengakuNinteishaListDiv div) {
                    return div.getDdlRiyoshaFutanDankai().getSelectedKey() != null
                    && !div.getDdlRiyoshaFutanDankai().getSelectedKey().isEmpty();
                }
            }
}
