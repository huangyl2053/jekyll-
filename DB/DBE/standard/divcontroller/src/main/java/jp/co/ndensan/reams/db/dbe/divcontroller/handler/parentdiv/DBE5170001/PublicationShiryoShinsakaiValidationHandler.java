/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護認定審査会資料作成のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakaiValidationHandler {

    private final RString 作成条件_範囲指定 = new RString("key1");
    private final PublicationShiryoShinsakaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会資料作成Div
     */
    public PublicationShiryoShinsakaiValidationHandler(PublicationShiryoShinsakaiDiv div) {
        this.div = div;
    }

    /**
     * 発行チェックを行う。
     *
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 発行チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<RString> 印刷帳票_事務局審査会資料 = div.getChkPrintChohyoShinsakaiJimu().getSelectedKeys();
        List<RString> 印刷帳票_委員審査会資料 = div.getChkPrintChohyoShinsakaiIin().getSelectedKeys();
        List<RString> 事務局_概況特記 = div.getChkPrintChoyoJimu2().getSelectedKeys();
        List<RString> 委員_概況特記 = div.getChkPrintChohyoIin2().getSelectedKeys();
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        Decimal 印刷範囲指定開始 = div.getTxtShiryoNoStart().getValue();
        Decimal 印刷範囲指定終了 = div.getTxtSiryoNoEnd().getValue();
        if ((印刷帳票_事務局審査会資料 == null || 印刷帳票_事務局審査会資料.isEmpty())
                && (印刷帳票_委員審査会資料 == null || 印刷帳票_委員審査会資料.isEmpty())
                && (事務局_概況特記 == null || 事務局_概況特記.isEmpty())
                && (委員_概況特記 == null || 委員_概況特記.isEmpty())) {
            validPairs.add(new ValidationMessageControlPair(RRVMessages.印刷帳票未選択, div.getPublishingConditionForJimukyoku(), div.getPublishingConditionForShinsakaiIin()));
        }
        if (作成条件_範囲指定.equals(作成条件)) {
            if (印刷範囲指定開始 == null || 印刷範囲指定開始.intValue() == 0 || 印刷範囲指定終了 == null || 印刷範囲指定終了.intValue() == 0) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.印刷範囲指定未入力, div.getTxtShiryoNoStart(), div.getTxtSiryoNoEnd()));
            } else if (印刷範囲指定終了.intValue() < 印刷範囲指定開始.intValue()) {
                validPairs.add(new ValidationMessageControlPair(RRVMessages.印刷範囲指定の前後順, div.getTxtShiryoNoStart(), div.getTxtSiryoNoEnd()));
            }
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        部数未入力(UrErrorMessages.入力値が不正_追加メッセージあり, "部数"),
        印刷帳票未選択(UrErrorMessages.選択されていない, "選択条件"),
        印刷範囲指定未入力(UrErrorMessages.入力値が不正_追加メッセージあり, "印刷範囲指定"),
        印刷範囲指定の前後順(UrErrorMessages.終了日が開始日以前);
        private final Message message;

        private RRVMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
