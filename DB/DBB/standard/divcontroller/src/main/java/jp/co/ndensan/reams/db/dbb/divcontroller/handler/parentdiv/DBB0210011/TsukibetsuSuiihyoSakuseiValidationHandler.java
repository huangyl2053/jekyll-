/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 月別推移表のValidationHandlerクラスです。
 *
 * @reamsid_L DBB-0760-010 zhangguopeng
 */
public class TsukibetsuSuiihyoSakuseiValidationHandler {

    private static final int 年齢_65 = 65;
    private final TsukibetsuSuiihyoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 月別推移表Div
     */
    public TsukibetsuSuiihyoSakuseiValidationHandler(TsukibetsuSuiihyoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        Decimal ageStart = div.getTxtNenreiSt().getValue();
        Decimal ageEnd = div.getTxtNenreiEd().getValue();
        RDate 年齢基準日 = div.getTxtNenreiKijunYMD().getValue();
        RDate 生年月日F = div.getTxtUmareSt().getValue();
        RDate 生年月日E = div.getTxtUmareEd().getValue();
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart.intValue() <= 年齢_65) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.年齢65歳未満));
        }
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart != null && ageEnd != null && 年齢基準日 == null) {
            throw new ApplicationException(UrWarningMessages.未入力.getMessage().replace("年齢基準日"));
        }
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()
                && ageStart != null && ageEnd != null && ageStart.compareTo(ageEnd) > 0) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始年齢大小不整合));
        }
        if (div.getRadUmareYMD().getSelectedKey() != null && !div.getRadUmareYMD().getSelectedKey().isEmpty()
                && 生年月日F != null && 生年月日E != null && 生年月日E.isBefore(生年月日F)) {
            validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始年齢大小不整合));
        }
        return validationMessages;
    }

    private static enum RRVMessages implements IValidationMessage {

        年齢65歳未満(DbbErrorMessages.年齢65歳未満),
        抽出開始年齢大小不整合(DbbErrorMessages.抽出開始年齢大小不整合, "抽出開始年齢", "抽出終了年齢"),
        抽出開始生年月日大小不整合(DbbErrorMessages.抽出開始生年月日大小不整合, "抽出開始生年月日", "抽出終了生年月日");

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
