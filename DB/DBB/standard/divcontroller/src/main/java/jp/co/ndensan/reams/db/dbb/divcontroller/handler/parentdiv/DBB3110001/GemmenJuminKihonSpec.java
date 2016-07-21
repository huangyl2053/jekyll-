/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.PrintInfoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険料減免画面
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public enum GemmenJuminKihonSpec implements IPredicate<GemmenJuminKihonDiv> {

    /**
     * 未指定
     */
    未指定 {
                @Override
                public boolean apply(GemmenJuminKihonDiv div) {
                    return SpecHelper.is未指定(div);
                }
            };

    private static class SpecHelper {

        private static final RString 減免決定通知書 = new RString("保険料減免決定通知書");

        public static boolean is未指定(GemmenJuminKihonDiv div) {
            PrintInfoDiv 発行パネル = div.getGemmenPrintinfo().getPrintInfo();
            boolean is減免決定通知書checked;
            boolean is取消決定通知書checked;
            if (減免決定通知書.equals(発行パネル.getPritPublish1().getTitle())) {
                is減免決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
                is取消決定通知書checked = false;
            } else {
                is取消決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
                is減免決定通知書checked = false;
            }
            boolean is変更通知書兼特徴checked = 発行パネル.getPritPublish2().isIsPublish() && 発行パネル.getPritPublish2().isVisible();
            boolean is納入通知書checked = 発行パネル.getPritPublish3().isIsPublish() && 発行パネル.getPritPublish3().isVisible();
            boolean is賦課台帳checked = 発行パネル.getPritPublish4().isIsPublish() && 発行パネル.getPritPublish4().isVisible();
            return is減免決定通知書checked || is取消決定通知書checked || is変更通知書兼特徴checked || is納入通知書checked || is賦課台帳checked;
        }
    }

}
