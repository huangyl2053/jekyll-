/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1720011;

import jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1720011.SogoJigyoTaishoshaTorokuHandler;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 新総合事業・事業対象者登録画面バリデーションクラスです。
 *
 * @reamsid_L DBC-4900-010 wangjie2
 */
public enum SogoJigyoTaishoshaTorokuSpec implements IPredicate<SogoJigyoTaishoshaTorokuDiv> {

    開始日と終了日の前後順チェック {
                /**
                 * 開始日と終了日の前後順チェックです。
                 *
                 * @param div 新総合事業・事業対象者登録Div
                 * @return true:not開始日＞終了日です、false:開始日＞終了日です。
                 */
                @Override
                public boolean apply(SogoJigyoTaishoshaTorokuDiv div) {
                    RDate 開始日 = div.getSougouZigyouTaishouShousai().getTxtymfromto().getFromValue();
                    RDate 終了日 = div.getSougouZigyouTaishouShousai().getTxtymfromto().getToValue();
                    if (終了日 != null && 開始日 != null) {
                        return 開始日.isBeforeOrEquals(終了日);
                    }
                    return true;
                }
            },
    適用期間重複チェック {
                /**
                 * 適用期間重複チェックです。
                 *
                 * @param div 新総合事業・事業対象者登録Div
                 * @return true:not適用期間重複です、false:適用期間重複です。
                 */
                @Override
                public boolean apply(SogoJigyoTaishoshaTorokuDiv div) {
                    SogoJigyoTaishoshaTorokuHandler handler = new SogoJigyoTaishoshaTorokuHandler(div);
                    return handler.適用期間重複チェック();
                }
            }

}
