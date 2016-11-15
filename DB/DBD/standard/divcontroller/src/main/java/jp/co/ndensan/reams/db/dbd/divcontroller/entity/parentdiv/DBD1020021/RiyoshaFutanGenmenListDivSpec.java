/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020021;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 利用者負担額減免認定者リスト画面の入力チェックです
 *
 * @reamsid_L DBD-3980-010 xuejm
 */
public enum RiyoshaFutanGenmenListDivSpec implements IPredicate<RiyoshaFutanGenmenListDiv> {

    基準日の未入力チェック {
                /**
                 * 基準日が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:基準日が非空です、false:基準日が空白の場合。
                 */
                @Override
                public boolean apply(RiyoshaFutanGenmenListDiv div) {
                    RDate txtKijunYMD = div.getTxtKijunYMD().getValue();
                    return txtKijunYMD != null && !txtKijunYMD.toDateString().isEmpty();
                }
            },
    所得年度の未入力チェック {
                /**
                 * 所得年度が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:所得年度が非空です、false:所得年度が空白の場合。
                 */
                @Override
                public boolean apply(RiyoshaFutanGenmenListDiv div) {
                    return div.getTxtShotokuNendo().getValue() != null && !div.getTxtShotokuNendo().getValue().toDateString().isEmpty();
                }
            },
    旧措置者区分の未入力チェック {
                /**
                 * 旧措置者区分が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:旧措置者区分が非空です、false:旧措置者区分が空白の場合。
                 */
                @Override
                public boolean apply(RiyoshaFutanGenmenListDiv div) {
                    return div.getRadKyusochishaKubun().getSelectedKey() != null && !div.getRadKyusochishaKubun().getSelectedKey().isEmpty();
                }
            },
    世帯表示の未入力チェック {
                /**
                 * 世帯表示が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:世帯表示が非空です、false:世帯表示が空白の場合。
                 */
                @Override
                public boolean apply(RiyoshaFutanGenmenListDiv div) {
                    return div.getRadSetaiHyoji().getSelectedKey() != null && !div.getRadSetaiHyoji().getSelectedKey().isEmpty();
                }
            },
    受給者区分の未入力チェック {
                /**
                 * 受給者区分が未入力チェック .
                 *
                 * @param div RiyoshaFutanGenmenListDiv
                 * @return true:受給者区分が非空です、false:受給者区分が空白の場合。
                 */
                @Override
                public boolean apply(RiyoshaFutanGenmenListDiv div) {
                    return div.getRadJukyushaKubun().getSelectedKey() != null && !div.getRadJukyushaKubun().getSelectedKey().isEmpty();
                }
            }
}
