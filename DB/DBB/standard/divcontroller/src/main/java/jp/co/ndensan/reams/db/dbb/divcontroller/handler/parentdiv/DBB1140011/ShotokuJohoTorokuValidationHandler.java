/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1140011;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1140011.ShotokuJohoTorokuTotalDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzWarningMessages;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBBGM13003_所得照会回答内容登録のバリデーションハンドラークラス
 *
 * @reamsid_L DBB-1750-010 zhangrui
 */
public class ShotokuJohoTorokuValidationHandler {

    private final ShotokuJohoTorokuTotalDiv div;
    private static final RString 激変緩和対象者となっていない人メッセージ = new RString("激変緩和区分の登録をしなくても");
    private static final RString 年金収入額メッセージ = new RString("年金等所得≧年金等収入ですが、");
    private static final RString 住民種別_外国人 = new RString("外国人");
    private static final RString 激変緩和措置区分_対象者 = new RString("対象者");
    private static final RString 激変緩和措置区分_なし = new RString("なし");

    /**
     * コンストラクタです。
     *
     * @param div 所得照会回答内容登録Div
     */
    public ShotokuJohoTorokuValidationHandler(ShotokuJohoTorokuTotalDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuJohoTorokuValidationMessages.住民税非課税区分のチェック, div.getShotokuJohoToroku().getDdlJuminzei())
                .add(ShotokuJohoTorokuValidationMessages.合計所得金額のチェック, div.getShotokuJohoToroku().getTxtGokeiShotokuGaku())
                .add(ShotokuJohoTorokuValidationMessages.生年月日のチェック,
                        div.getAtenaInfo().getKaigoAtenaInfo().getShokaiData().getTxtSeinengappiYMD())
                .add(ShotokuJohoTorokuValidationMessages.激変緩和対象者となっていない人のチェック,
                        div.getShotokuJohoToroku().getTxtGokeiShotokuGaku())
                .add(ShotokuJohoTorokuValidationMessages.年金収入額のチェック, div.getShotokuJohoToroku().getTxtNenkinShotokuGaku())
                .build();
    }

    private static class ControlValidator {

        private final ShotokuJohoTorokuTotalDiv div;

        public ControlValidator(ShotokuJohoTorokuTotalDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            ValidateChain vc = ValidateChain.validateStart(div);
            if (div.getShotokuJohoToroku().getTxtNenkinShunyuGaku().isVisible()) {
                vc.ifNot(ShotokuJohoTorokuSpec.年金収入額)
                        .thenAdd(ShotokuJohoTorokuValidationMessages.年金収入額のチェック);
            }
            if (canCheck()) {
                RString 激変緩和措置区分 = div.getShotokuJohoToroku().getDdlGekihenKanwa().getSelectedValue();
                if (激変緩和措置区分_対象者.equals(激変緩和措置区分)) {
                    vc.ifNot(ShotokuJohoTorokuSpec.住民税非課税区分)
                            .thenAdd(ShotokuJohoTorokuValidationMessages.住民税非課税区分のチェック)
                            .ifNot(ShotokuJohoTorokuSpec.合計所得金額)
                            .thenAdd(ShotokuJohoTorokuValidationMessages.合計所得金額のチェック)
                            .ifNot(ShotokuJohoTorokuSpec.生年月日)
                            .thenAdd(ShotokuJohoTorokuValidationMessages.生年月日のチェック);
                } else if (激変緩和措置区分_なし.equals(激変緩和措置区分)) {
                    vc.ifNot(ShotokuJohoTorokuSpec.激変緩和対象者となっていない人)
                            .thenAdd(ShotokuJohoTorokuValidationMessages.激変緩和対象者となっていない人のチェック);
                }
            }
            messages.add(vc.messages());
            return messages;
        }

        private boolean canCheck() {
            KaigoFukaKihonDiv kaigoFukaKihon = (KaigoFukaKihonDiv) div.getKaigoFukaKihon();
            KaigoAtenaInfoDiv kaigoAtenaInfo = (KaigoAtenaInfoDiv) div.getKaigoAtenaInfo();
            return div.getShotokuJohoToroku().getDdlGekihenKanwa().isVisible()
                    && (!RString.isNullOrEmpty(kaigoFukaKihon.getTxtHihokenshaNo().getText())
                    || kaigoAtenaInfo.getAtenaInfoDiv().getHdnTxtJuminShubetsu().equals(住民種別_外国人));
        }
    }

    private static enum ShotokuJohoTorokuValidationMessages implements IValidationMessage {

        住民税非課税区分のチェック(DbbErrorMessages.激変緩和区分対象者不正_非課税区分),
        合計所得金額のチェック(DbbErrorMessages.激変緩和区分対象者不正_合計所得),
        生年月日のチェック(DbbErrorMessages.激変緩和区分対象者不正_年齢),
        激変緩和対象者となっていない人のチェック(DbzWarningMessages.確認, 激変緩和対象者となっていない人メッセージ.toString()),
        年金収入額のチェック(DbzWarningMessages.確認, 年金収入額メッセージ.toString());
        private final Message message;

        ShotokuJohoTorokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
