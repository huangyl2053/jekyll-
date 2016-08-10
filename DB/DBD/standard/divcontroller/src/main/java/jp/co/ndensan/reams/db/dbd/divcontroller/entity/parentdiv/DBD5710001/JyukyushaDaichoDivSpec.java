/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001;

import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者台帳画面のチェックです。
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public enum JyukyushaDaichoDivSpec implements IPredicate<JyukyushaDaichoDiv> {

    今回抽出対象期間今回の日付が非空必須チェック {
                /**
                 * 今回抽出対象期間今回の非空必須チェックです。
                 *
                 * @param div 受給者台帳リストDiv
                 * @return true:今回が非空です、false:「今回抽出対象開始日付」と「今回抽出対象終了日付」がいずれか空白の場合。
                 */

                @Override
                public boolean apply(JyukyushaDaichoDiv div) {
                    RDate Konkaifromdate;
                    RTime Konkaifromtime;
                    Konkaifromdate = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromDateValue();
                    Konkaifromtime = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromTimeValue();
                    return (Konkaifromdate != null && !Konkaifromdate.toDateString().isEmpty()) && (Konkaifromtime != null && !Konkaifromtime.toString().isEmpty());
                }

            },
    今回抽出対象終了日付が開始日付以前チェック {
                /**
                 * 今回抽出対象終了日付が開始日付以前チェックを行います。
                 *
                 * @param pairs バリデーションコントロール
                 * @param div JyukyushaDaichoDiv
                 * @return true:「今回抽出対象開始日付」>「今回抽出対象終了日付」がではありません,false:「今回抽出対象開始日付」>「今回抽出対象終了日付」の場合。
                 */
                @Override
                public boolean apply(JyukyushaDaichoDiv div) {
                    if (div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromDateValue() == null
                    || div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromTimeValue() == null) {
                        return true;
                    }
                    RDate Konkaifromdate;
                    RDate Konkaitodate;
                    RTime Konkaifromtime;
                    RTime Konkaitotime;
                    Konkaifromdate = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromDateValue();
                    Konkaifromtime = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getFromTimeValue();
                    Konkaitodate = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getToDateValue();
                    Konkaitotime = div.getChushutsuJyouken().getTaishouKikan().getTxtKonkaiymdtime().getToTimeValue();
                    YMDHMS konkaifromYMDHMS = new YMDHMS(Konkaifromdate, Konkaifromtime);
                    YMDHMS konkaitoYMDHMS = new YMDHMS(Konkaitodate, Konkaitotime);

                    return !konkaitoYMDHMS.isBeforeOrEquals(konkaifromYMDHMS);

                }
            },
    被保険者番号非空チェック {
                /**
                 * 被保険者番号必須チェックを行います。
                 *
                 * @param pairs バリデーションコントロール
                 * @param div JyukyushaDaichoDiv
                 * @return true:被保険者番号が非空です、false:被保険者番号がいずれか空白の場合。
                 */
                @Override
                public boolean apply(JyukyushaDaichoDiv div) {
                    Decimal hihokenshaBangoufrom = div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getFromValue();
                    Decimal hihokenshaBangouto = div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getToValue();
                    return (hihokenshaBangoufrom != null && !hihokenshaBangoufrom.toString().isEmpty())
                    || (hihokenshaBangouto != null && !hihokenshaBangouto.toString().isEmpty());
                }
            },
    被保険者番号ToがFrom以前チェック {
                /**
                 * 被保険者番号ToがFrom以前チェックを行います。
                 *
                 * @param pairs バリデーションコントロール
                 * @param div JyukyushaDaichoDiv
                 * @return true:「被保険者番号（From）」＞「被保険者番号（To）」がではありません、false:「被保険者番号（From）」＞「被保険者番号（To）」の場合。
                 */
                @Override
                public boolean apply(JyukyushaDaichoDiv div) {
                    if (div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getFromValue() == null
                    || div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getToValue() == null) {
                        return true;
                    }
                    RString hihokenshaBangoufrom = new RString(div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getFromValue().toString());
                    RString hihokenshaBangouto = new RString(div.getChushutsuJyouken().getTaishouSha().getTxtHihokenshaBangou().getToValue().toString());
                    return hihokenshaBangouto.compareTo(hihokenshaBangoufrom) <= 0;
                }

            },
    出力順未指定チェック {
                /**
                 * 出力順未指定チェックを行います。
                 *
                 * @param pairs バリデーションコントロール
                 * @param div JyukyushaDaichoDiv
                 * @return true:出力順が指定します、false:出力順が未指定しますの場合。
                 */
                @Override
                public boolean apply(JyukyushaDaichoDiv div) {
                    RString 出力順 = ((ChohyoShutsuryokujunDiv) div.getShutsuryokuSort()).getTxtSort().getValue();
                    return 出力順 != null && !出力順.isEmpty();
                }

            }
}
