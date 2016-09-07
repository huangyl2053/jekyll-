/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 生活保護明細のValidationHandlerクラスです。
 *
 * @reamsid_L DBZ-4510-010 xuyannan
 */
public class SeikatsuhogoDetailValidationHandler {

    private static final RString 表示モード_修正 = new RString("修正");
    private final SeikatsuhogoDetailDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 生活保護明細Div
     */
    public SeikatsuhogoDetailValidationHandler(SeikatsuhogoDetailDiv div) {
        this.div = div;
    }

    /**
     * 「確定する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTeishiShuryoYMD().getValue() != null
                && div.getTxtTeishiShuryoYMD().getValue().isBefore(div.getTxtTeishiKaishiYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate停止期間が不正_追加メッセージあり, div.getTxtTeishiShuryoYMD(), div.getTxtTeishiKaishiYMD()));
        }
        for (dgTeishiRireki_Row row : div.getTeishiKikan().getDgTeishiRireki().getDataSource()) {
            if ((row.getTxtTeishiKaishiYMD().getValue() == null
                    || div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiKaishiYMD().getValue() == null
                    || (row.getTxtTeishiKaishiYMD().getValue()
                    .isBeforeOrEquals(div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiKaishiYMD().getValue())
                    && div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiKaishiYMD().getValue()
                    .isBeforeOrEquals(row.getTxtTeishiShuryoYMD().getValue())))
                    || (row.getTxtTeishiKaishiYMD().getValue() == null
                    || div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiShuryoYMD().getValue() == null
                    || (row.getTxtTeishiKaishiYMD().getValue()
                    .isBeforeOrEquals(div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiShuryoYMD().getValue())
                    && div.getTeishiKikan().getTeishiKikanInput().getTxtTeishiShuryoYMD().getValue()
                    .isBeforeOrEquals(row.getTxtTeishiShuryoYMD().getValue())))) {
                if (表示モード_修正.equals(div.getHdnHyoujiMode())
                        && (row.getTxtTeishiKaishiYMD().getValue().equals(
                                div.getTeishiKikan().getDgTeishiRireki().getClickedItem().getTxtTeishiKaishiYMD().getValue())
                        && row.getTxtTeishiShuryoYMD().getValue().equals(
                                div.getTeishiKikan().getDgTeishiRireki().getClickedItem().getTxtTeishiShuryoYMD().getValue()))) {
                    continue;
                }
                validPairs.add(new ValidationMessageControlPair(
                        IdocheckMessages.Validate期間が重複, div.getTeishiKikan().getTeishiKikanInput(),
                        div.getTeishiKikan().getDgTeishiRireki()));
                break;
            }
        }
        return validPairs;
    }

    /**
     * 「明細を確定する」ボタンを押下するとき、バリデーションチェックを行う。
     *
     * @return ValidationMessageControlPairs(バリデーション結果)
     */
    public ValidationMessageControlPairs validateForDetailKakutei() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtJukyuHaishiYMD().getValue().isBefore(div.getTxtJukyuKaishiYMD().getValue())) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate受給期間が不正_追加メッセージあり, div.getTxtJukyuKaishiYMD(), div.getTxtJukyuHaishiYMD()));
        }
        List<RString> 停止開始日List = new ArrayList<>();
        List<RString> 停止終了日List = new ArrayList<>();
        for (dgTeishiRireki_Row row : div.getDgTeishiRireki().getDataSource()) {
            停止開始日List.add(row.getTxtTeishiKaishiYMD().getValue() == null
                    ? RString.EMPTY : row.getTxtTeishiKaishiYMD().getValue().toDateString());
            停止終了日List.add(row.getTxtTeishiShuryoYMD().getValue() == null
                    ? RString.EMPTY : row.getTxtTeishiShuryoYMD().getValue().toDateString());
        }
        Collections.sort(停止開始日List, new Comparator<RString>() {
            @Override
            public int compare(RString r1, RString r2) {
                return r1.compareTo(r2);
            }
        });
        Collections.sort(停止終了日List, new Comparator<RString>() {
            @Override
            public int compare(RString r1, RString r2) {
                return r1.compareTo(r2);
            }
        });
        if (停止開始日List.get(0).compareTo(div.getTxtJukyuKaishiYMD().getValue().toDateString()) < 0) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate期間が不正, div.getTxtJukyuKaishiYMD(), div.getDgTeishiRireki()));
        }
        if (div.getTxtJukyuHaishiYMD().getValue() != null
                && 停止終了日List.get(停止終了日List.size() - 1).compareTo(div.getTxtJukyuHaishiYMD().getValue().toDateString()) >= 0) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate期間が不正, div.getTxtJukyuHaishiYMD(), div.getDgTeishiRireki()));
        }
        if (div.getTxtTeishiShuryoYMD().getValue() != null
                && !RString.isNullOrEmpty(停止開始日List.get(停止開始日List.size() - 1))
                && RString.isNullOrEmpty(停止終了日List.get(0))) {
            validPairs.add(new ValidationMessageControlPair(
                    IdocheckMessages.Validate期間が不正, div.getTxtJukyuHaishiYMD(), div.getDgTeishiRireki()));
        }
        return validPairs;
    }

    private static enum IdocheckMessages implements IValidationMessage {

        Validate受給期間が不正_追加メッセージあり(UrErrorMessages.期間が不正_追加メッセージあり２, "廃止年月日", "開始年月日"),
        Validate停止期間が不正_追加メッセージあり(UrErrorMessages.期間が不正_追加メッセージあり２, "停止終了日", "停止開始日"),
        Validate期間が不正(UrErrorMessages.期間が不正),
        Validate期間が重複(UrErrorMessages.期間が重複);
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
