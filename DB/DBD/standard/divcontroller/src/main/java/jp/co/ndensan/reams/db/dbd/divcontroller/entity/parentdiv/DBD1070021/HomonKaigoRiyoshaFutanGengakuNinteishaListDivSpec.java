/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070021;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 訪問介護利用者負担額減額認定者リスト画面のチェックです。
 *
 * @reamsid_L DBD-3970-010 xuejm
 */
public enum HomonKaigoRiyoshaFutanGengakuNinteishaListDivSpec implements IPredicate<HomonKaigoRiyoshaFutanGengakuNinteishaListDiv> {

    対象年度の未入力チェック {
                /**
                 * 対象年度が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:対象年度が非空です、false:対象年度が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getTxtTaishoYM().getValue() != null && !div.getTxtTaishoYM().getValue().toDateString().isEmpty();
                }
            },
    所得年度の未入力チェック {
                /**
                 * 所得年度が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:所得年度が非空です、false:所得年度が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getTxtShotokuNendo().getValue() != null && !div.getTxtShotokuNendo().getValue().toDateString().isEmpty();
                }
            },
    基準日の未入力チェック {
                /**
                 * 基準日が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:基準日が非空です、false:基準日が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    RDate txtKijunYMD = div.getTxtKijunYMD().getValue();
                    return txtKijunYMD != null && !txtKijunYMD.toDateString().isEmpty();
                }
            },
    課税判定等基準日の未入力チェック {
                /**
                 * 課税判定等基準日が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:課税判定等基準日が非空です、false:課税判定等基準日が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    RDate txtKazeiHanteiToKijunDate = div.getTxtKazeiHanteiToKijunDate().getValue();
                    return txtKazeiHanteiToKijunDate != null && !txtKazeiHanteiToKijunDate.toDateString().isEmpty();
                }
            },
    旧措置者区分の未入力チェック {
                /**
                 * 旧措置者区分が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:旧措置者区分が非空です、false:旧措置者区分が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getRadKyusochishaKubun().getSelectedKey() != null && !div.getRadKyusochishaKubun().getSelectedKey().isEmpty();
                }
            },
    法別区分の未入力チェック {
                /**
                 * 法別区分が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:法別区分が非空です、false:法別区分が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getDdlHobetsuKubun().getSelectedKey() != null && !div.getDdlHobetsuKubun().getSelectedKey().isEmpty();
                }
            },
    世帯表示の未入力チェック {
                /**
                 * 世帯表示が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:世帯表示が非空です、false:世帯表示が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getRadSetaiHyoji().getSelectedKey() != null && !div.getRadSetaiHyoji().getSelectedKey().isEmpty();
                }
            },
    受給者区分の未入力チェック {
                /**
                 * 受給者区分が未入力チェック .
                 *
                 * @param div HomonKaigoRiyoshaFutanGengakuNinteishaListDiv
                 * @return true:受給者区分が非空です、false:受給者区分が空白の場合。
                 */
                @Override
                public boolean apply(HomonKaigoRiyoshaFutanGengakuNinteishaListDiv div) {
                    return div.getRadJukyushaKubun().getSelectedKey() != null && !div.getRadJukyushaKubun().getSelectedKey().isEmpty();
                }
            }
}
