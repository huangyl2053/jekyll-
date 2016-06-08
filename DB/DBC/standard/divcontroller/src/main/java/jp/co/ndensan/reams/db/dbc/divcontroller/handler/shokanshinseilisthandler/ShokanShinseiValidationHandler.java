/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.shokanshinseilisthandler;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList.ShokanShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshinseiichiran.ShokanShinseiIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 償還払申請一覧のチェッククラスです。
 *
 * @reamsid_L DBC-0960-010 hezhenzhen
 */
public class ShokanShinseiValidationHandler {

    private final ShokanShinseiListDiv requestDiv;
    private static final RString サービス年月 = new RString("サービス年月");

    /**
     * コンストラクタです。
     *
     * @param requestDiv ShokanShinseiListDiv
     */
    public ShokanShinseiValidationHandler(ShokanShinseiListDiv requestDiv) {
        this.requestDiv = requestDiv;
    }

    /**
     * サービス年月の有効性チェック。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs サービス年月の有効性チェック(HihokenshaNo 被保険者番号) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (RDate.getNowDate().getYearMonth().isBefore(requestDiv.getTxtServiceYM().getValue().getYearMonth())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokanShinseiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(UrWarningMessages.日付の前後関係逆転以降,
                            requestDiv.getTxtServiceYM().getValue().getYearMonth().wareki().eraType(EraType.KANJI_RYAKU).
                            firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().toString(),
                            RDate.getNowDate().getYearMonth().wareki().eraType(EraType.KANJI_RYAKU).
                            firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().toString())));
        }
        int count = ShokanShinseiIchiranManager.createInstance().getShokanShinseiCount(被保険者番号, new FlexibleYearMonth(
                requestDiv.getTxtServiceYM().getValue().getYearMonth().toDateString())
        );
        if (count >= 1) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokanShinseiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(UrErrorMessages.既に登録済,
                            requestDiv.getTxtServiceYM().getValue().getYearMonth().wareki().eraType(EraType.KANJI_RYAKU).
                            firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().toString())));
        }
        return validationMessages;
    }

    /**
     * 検索ボタンのチェック。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 検索ボタンcheck() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (requestDiv.getTxtServiceYMFrom().getValue() == null && requestDiv.getTxtServiceYMTo().getValue() == null) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokanShinseiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(
                            UrErrorMessages.必須項目_追加メッセージあり, サービス年月.toString())));
        }
        if ((requestDiv.getTxtServiceYMFrom().getValue() != null
                && !RString.EMPTY.equals(requestDiv.getTxtServiceYMFrom().getValue().toDateString()))
                && (requestDiv.getTxtServiceYMTo().getValue() != null
                && !RString.EMPTY.equals(requestDiv.getTxtServiceYMTo().getValue().toDateString()))
                && requestDiv.getTxtServiceYMTo().getValue().getYearMonth().isBefore(requestDiv.getTxtServiceYMFrom().getValue().getYearMonth())) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShokanShinseiValidationHandler.ShujiiIkenshoSakuseiIraiMessages(UrErrorMessages.期間が不正_追加メッセージあり２,
                            requestDiv.getTxtServiceYMFrom().getValue().getYearMonth().wareki().eraType(EraType.KANJI_RYAKU).
                            firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().toString(),
                            requestDiv.getTxtServiceYMTo().getValue().getYearMonth().wareki().eraType(EraType.KANJI_RYAKU).
                            firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.ZERO).toDateString().toString())));
        }
        return validationMessages;
    }

    private static final class ShujiiIkenshoSakuseiIraiMessages implements IValidationMessage {

        private final Message message;

        private ShujiiIkenshoSakuseiIraiMessages(IMessageGettable message, String... replaceParam) {
            this.message = message.getMessage().replace(replaceParam);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
