/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0210011;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210011.TsukibetsuSuiihyoSakuseiParameterDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
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
public class TsukibetsuSuiihyoSakuseiParameterValidationHandler {

    private static final int 年齢_65 = 65;
    private final TsukibetsuSuiihyoSakuseiParameterDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 月別推移表Div
     */
    public TsukibetsuSuiihyoSakuseiParameterValidationHandler(TsukibetsuSuiihyoSakuseiParameterDiv div) {
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
        if (div.getRadNenrei().getSelectedKey() != null && !div.getRadNenrei().getSelectedKey().isEmpty()) {
            if (ageStart == null || ageStart.intValue() < 年齢_65) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.年齢65歳未満, div.getTxtNenreiSt()));
            }
            if ((ageStart != null || ageEnd != null) && 年齢基準日 == null) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.年齢基準日, div.getTxtNenreiKijunYMD()));
            }
            if (ageStart != null && ageEnd != null && ageStart.compareTo(ageEnd) > 0) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始年齢大小不整合, div.getTxtNenreiSt(), div.getTxtNenreiEd()));
            }
        } else {
            if (生年月日F != null && 生年月日E != null && 生年月日E.isBefore(生年月日F)) {
                validationMessages.add(new ValidationMessageControlPair(RRVMessages.抽出開始生年月日大小不整合, div.getTxtUmareSt(), div.getTxtUmareEd()));
            }
        }
        return validationMessages;
    }

    private enum RRVMessages implements IValidationMessage {

        年齢65歳未満(DbbErrorMessages.年齢65歳未満),
        抽出開始年齢大小不整合(DbbErrorMessages.抽出開始年齢大小不整合),
        抽出開始生年月日大小不整合(DbbErrorMessages.抽出開始生年月日大小不整合),
        年齢基準日(UrWarningMessages.未入力, "年齢基準日");

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
