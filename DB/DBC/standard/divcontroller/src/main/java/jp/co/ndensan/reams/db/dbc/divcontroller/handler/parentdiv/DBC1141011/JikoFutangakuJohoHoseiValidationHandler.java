/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1141011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KokuhorenInterfaceKanri;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011.JikoFutangakuJohoHoseiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 画面設計_DBCMN62002_高額合算自己負担額情報補正（一括）のクラスです。
 *
 * @reamsid_L DBC-2320-010 chenyadong
 */
public class JikoFutangakuJohoHoseiValidationHandler {

    private final JikoFutangakuJohoHoseiDiv div;
    private static final RString NUM_24 = new RString("24");
    private static final RString NUM_60 = new RString("60");
    private static final RString 出力順 = new RString("出力順を");

    /**
     * コンストラクタです。
     *
     * @param div JikoFutangakuJohoHoseiDiv
     */
    public JikoFutangakuJohoHoseiValidationHandler(JikoFutangakuJohoHoseiDiv div) {
        this.div = div;
    }

    /**
     * validateチェック
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuhorenTorikomiListSpec.確認情報受取年月_誤り).
                thenAdd(IdocheckMessages.確認情報受取年月_誤り).
                ifNot(KokuhorenTorikomiListSpec.開始時間の時間_誤り).
                thenAdd(IdocheckMessages.開始時間の時間_誤り).
                ifNot(KokuhorenTorikomiListSpec.開始時間の分_誤り).
                thenAdd(IdocheckMessages.開始時間の分_誤り).
                ifNot(KokuhorenTorikomiListSpec.終了時間の時間_誤り).
                thenAdd(IdocheckMessages.終了時間の時間_誤り).
                ifNot(KokuhorenTorikomiListSpec.終了時間の分_誤り).
                thenAdd(IdocheckMessages.終了時間の分_誤り).
                ifNot(KokuhorenTorikomiListSpec.開始日_誤り).
                thenAdd(IdocheckMessages.開始日_誤り).
                ifNot(KokuhorenTorikomiListSpec.終了日_誤り).
                thenAdd(IdocheckMessages.終了日_誤り).
                ifNot(KokuhorenTorikomiListSpec.必須設定項目_出力順).
                thenAdd(IdocheckMessages.必須設定項目_出力順).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder()
                .add(IdocheckMessages.確認情報受取年月_誤り, div.getTxtKakuninJouhouUketoriYM())
                .add(IdocheckMessages.開始時間の時間_誤り, div.getTxtKaishiJikanHH())
                .add(IdocheckMessages.開始時間の分_誤り, div.getTxtKaishiJIkanMM())
                .add(IdocheckMessages.終了時間の時間_誤り, div.getTxtshuryoJikanHH())
                .add(IdocheckMessages.終了時間の分_誤り, div.getTxtshuryoJikanMM())
                .add(IdocheckMessages.開始日_誤り, div.getTxtKaishiYMD())
                .add(IdocheckMessages.終了日_誤り, div.getTxtShuryoYMD())
                .add(IdocheckMessages.必須設定項目_出力順)
                .build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<JikoFutangakuJohoHoseiDiv> {

        確認情報受取年月_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        List<KokuhorenInterfaceKanri> list = ViewStateHolder.get(ViewStateKeys.自己負担額確認情報, List.class);
                        return list != null && !list.isEmpty();

                    }
                },
        開始時間の時間_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {

                        return 0 <= Integer.parseInt(div.getTxtKaishiJikanHH().getValue().toString())
                        && Integer.parseInt(div.getTxtKaishiJikanHH().getValue().toString())
                        < Integer.parseInt(NUM_24.toString());
                    }
                },
        開始時間の分_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return 0 <= Integer.parseInt(div.getTxtKaishiJIkanMM().getValue().toString())
                        && Integer.parseInt(div.getTxtKaishiJIkanMM().getValue().toString())
                        < Integer.parseInt(NUM_60.toString());
                    }
                },
        終了時間の時間_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return 0 <= Integer.parseInt(div.getTxtshuryoJikanHH().getValue().toString())
                        && Integer.parseInt(div.getTxtshuryoJikanHH().getValue().toString())
                        < Integer.parseInt(NUM_24.toString());
                    }
                },
        終了時間の分_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return 0 <= Integer.parseInt(div.getTxtshuryoJikanMM().getValue().toString())
                        && Integer.parseInt(div.getTxtshuryoJikanMM().getValue().toString())
                        < Integer.parseInt(NUM_60.toString());
                    }
                },
        開始日_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return 0 < div.getTxtKaishiYMD().getValue().compareTo(RDate.getNowDate());
                    }
                },
        終了日_誤り {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return 0 < div.getTxtShuryoYMD().getValue().compareTo(div.getTxtKaishiYMD().getValue());
                    }
                },
        必須設定項目_出力順 {
                    @Override
                    public boolean apply(JikoFutangakuJohoHoseiDiv div) {
                        return div.getCcdChohyoShutsuryokujun().get出力順ID() != null
                        && div.getCcdChohyoShutsuryokujun().get出力順ID() != 0;
                    }
                };
    }

    private enum IdocheckMessages implements IValidationMessage {

        確認情報受取年月_誤り(DbcErrorMessages.確認情報受取年月不正),
        開始時間の時間_誤り(DbcErrorMessages.時間不整合),
        開始時間の分_誤り(DbcErrorMessages.時間不整合),
        終了時間の時間_誤り(DbcErrorMessages.時間不整合),
        終了時間の分_誤り(DbcErrorMessages.時間不整合),
        開始日_誤り(DbcErrorMessages.支払開始日不正),
        終了日_誤り(DbcErrorMessages.支払終了日不正),
        必須設定項目_出力順(UrErrorMessages.未指定, 出力順.toString());
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
