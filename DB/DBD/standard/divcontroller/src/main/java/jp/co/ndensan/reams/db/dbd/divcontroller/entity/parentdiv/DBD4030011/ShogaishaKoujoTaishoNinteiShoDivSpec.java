/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4030011;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 障がい者控除対象者認定書一括発行リストバリデーションクラスです。
 *
 * @reamsid_L DBD-3860-010 donghj
 */
public enum ShogaishaKoujoTaishoNinteiShoDivSpec implements IPredicate<ShogaishaKoujoTaishoNinteiShoDiv> {

    対象年度の未入力チェック {

                /**
                 * 対象年度の未入力チェックです。
                 *
                 * @param div ShogaishaKoujoTaishoNinteiShoDiv
                 * @return true:対象年度が非空です、false:対象年度が空です。
                 */
                @Override
                public boolean apply(ShogaishaKoujoTaishoNinteiShoDiv div) {
                    return div.getTyusyutuJyokenPanel().getTxtTaishoNendo().getValue() != null
                    && !div.getTyusyutuJyokenPanel().getTxtTaishoNendo().getValue().toString().isEmpty();
                }

            },
    喪失日_終了日が開始日以前チェック {
                /**
                 * 喪失日_終了日が開始日以前チェックです。
                 *
                 * @param div ShogaishaKoujoTaishoNinteiShoDiv
                 * @return true:喪失日_終了日が開始日以後です、false:喪失日_終了日が開始日以前です。
                 */
                @Override
                public boolean apply(ShogaishaKoujoTaishoNinteiShoDiv div) {
                    RDate 喪失日開始日 = div.getTyusyutuJyokenPanel().getTxtSoshituDay().getFromValue();
                    RDate 喪失日終了日 = div.getTyusyutuJyokenPanel().getTxtSoshituDay().getToValue();
                    if (喪失日終了日 == null || 喪失日終了日.toDateString().isEmpty()
                    || 喪失日開始日 == null || 喪失日開始日.toDateString().isEmpty()) {
                        return false;
                    }
                    return !喪失日終了日.isBeforeOrEquals(喪失日開始日);
                }

            },
    決定日_終了日が開始日以前チェック {
                /**
                 * 決定日_終了日が開始日以前チェックです。
                 *
                 * @param div ShogaishaKoujoTaishoNinteiShoDiv
                 * @return true:決定日_終了日が開始日以後です、false:決定日_終了日が開始日以前です。
                 */
                @Override
                public boolean apply(ShogaishaKoujoTaishoNinteiShoDiv div) {
                    RDate 決定日開始日 = div.getTyusyutuJyokenPanel().getTxtKeteiDay().getFromValue();
                    RDate 決定日終了日 = div.getTyusyutuJyokenPanel().getTxtKeteiDay().getToValue();
                    if (決定日終了日 == null || 決定日終了日.toDateString().isEmpty()
                    || 決定日開始日 == null || 決定日開始日.toDateString().isEmpty()) {
                        return false;
                    }
                    return !決定日終了日.isBefore(決定日開始日);

                }

            },
    出力順序必須入力チェック {
                /**
                 * 出力順序必須入力チェックです。
                 *
                 * @param div ShogaishaKoujoTaishoNinteiShoDiv
                 * @return true:出力順序が非空です、false:出力順序が空です。
                 */
                @Override
                public boolean apply(ShogaishaKoujoTaishoNinteiShoDiv div) {
                    return div.getShogaishaKojoNinteishoOutput().getCommonChildDiv1().getSelected出力順() != null;
                }

            };

}
