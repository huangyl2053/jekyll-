/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3150001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001.ChoshuYuyoPrintinfoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBBGM62001_1_更新結果確認
 *
 * @reamsid_L DBB-1680-050 lihang
 */
public enum ChoshuYuyoPrintinfoSpec implements IPredicate<ChoshuYuyoJuminKihonDiv> {

    /**
     * 未指定
     */
    未指定 {
                @Override
                public boolean apply(ChoshuYuyoJuminKihonDiv div) {
                    return SpecHelper.is未指定(div);
                }
            };

    private static class SpecHelper {

        private static final RString 徴収猶予決定通知書 = new RString("徴収猶予決定通知書");

        public static boolean is未指定(ChoshuYuyoJuminKihonDiv div) {
            ChoshuYuyoPrintinfoDiv 発行パネル = div.getChoshuYuyoPrintinfo();
            boolean is徴収猶予決定通知書checked;
            boolean is徴収猶予取消通知書checked;
            if (徴収猶予決定通知書.equals(発行パネル.getPritPublish2().getTitle())) {
                is徴収猶予決定通知書checked = 発行パネル.getPritPublish2().isIsPublish() && 発行パネル.getPritPublish2().isVisible();
                is徴収猶予取消通知書checked = false;
            } else {
                is徴収猶予取消通知書checked = 発行パネル.getPritPublish2().isIsPublish() && 発行パネル.getPritPublish2().isVisible();
                is徴収猶予決定通知書checked = false;
            }
            return is徴収猶予決定通知書checked || is徴収猶予取消通知書checked;
        }

    }
}
