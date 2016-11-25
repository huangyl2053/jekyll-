/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0310001;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.HonsanteiFukaKeisanTotalDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 本算定賦課計算クラスです。
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiFukaKeisanTotalValidationHandler {

    private static final RString 特徴開始通知書_帳票分類ID = new RString("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");
    private static final RString 決定変更通知書_帳票分類ID = new RString("DBB100039_KaigoHokenHokenryogakuKetteiTsuchishoDaihyo");
    private static final RString 納入通知書帳票分類ID = new RString("DBB100045_HokenryoNonyuTsuchishoDaihyo");
    private static final RString MESSAGE_1 = new RString("所得異動基準日");
    private static final RString MESSAGE_2 = new RString("資格基準日");
    private static final RString MESSAGE_3 = new RString("特徴開始通知書の発行日");
    private static final RString MESSAGE_4 = new RString("決定/変更通知書の発行日");
    private static final RString MESSAGE_5 = new RString("納入通知書の発行日");
    private static final RString MESSAGE_6 = new RString("対象者");
    private static final RString MESSAGE_7 = new RString("出力期");
    private final HonsanteiFukaKeisanTotalDiv div;

    /**
     * コンストメソッドです。
     *
     * @param div div
     */
    public HonsanteiFukaKeisanTotalValidationHandler(HonsanteiFukaKeisanTotalDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックメソッドです。
     *
     * @return エラーメッセージ
     */
    public ValidationMessageControlPairs set入力チェック() {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShotokuKijunYMD().getValue() == null) {
            pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                    UrErrorMessages.必須, MESSAGE_1.toString()),
                    div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShotokuKijunYMD()));
        }
        if (div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShikakuKijunYMD().getValue() == null) {
            pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                    UrErrorMessages.必須, MESSAGE_2.toString()),
                    div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShikakuKijunYMD()));
        }
        Map<RString, RString> 帳票一覧Map = div.getHonsanteiChohyoHakko2().getCcdChohyoIchiran().getSelected帳票IdAnd出力順Id();
        Set<Map.Entry<RString, RString>> set = 帳票一覧Map.entrySet();
        Iterator<Map.Entry<RString, RString>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<RString, RString> entry = it.next();
            RString key = entry.getKey();
            if (特徴開始通知書_帳票分類ID.equals(key)
                    && div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD2().getValue() == null) {
                pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                        UrErrorMessages.必須, MESSAGE_3.toString()),
                        div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD2()));
            } else if (決定変更通知書_帳票分類ID.equals(key)
                    && div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteTsuchiHakkoYMD2().getValue() == null) {
                pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                        UrErrorMessages.必須, MESSAGE_4.toString()),
                        div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtKetteTsuchiHakkoYMD2()));
            } else if (納入通知書帳票分類ID.equals(key)) {
                if (div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtNotsuHakkoYMD2().getValue() == null) {
                    pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須, MESSAGE_5.toString()),
                            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getTxtNotsuHakkoYMD2()));
                }
                if (div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getChkNotsuTaishosha2().getSelectedItems().isEmpty()) {
                    pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須, MESSAGE_6.toString()),
                            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getChkNotsuTaishosha2()));
                }
                if (RString.isNullOrEmpty(div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2().getSelectedKey())) {
                    pairs.add(new ValidationMessageControlPair(new HonsanteiFukaKeisanTotalValidationHandler.IdocheckMessages(
                            UrErrorMessages.必須, MESSAGE_7.toString()),
                            div.getHonsanteiChohyoHakko2().getHonTsuchiKobetsuJoho().getDdlNotsuShuturyokuki2()));
                }
            }
        }
        return pairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
