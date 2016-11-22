/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0510011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.PostMainPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0510011.dgShichoson_Row;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBC0510011_国保・後期高齢資格異動情報取込
 *
 * @reamsid_L DBC-3020-010 chenyadong
 */
public class PostMainPanelValidationHandler {

    private final PostMainPanelDiv div;
    private static final RString ファイル日時 = new RString("ファイル日時");
    private static final RString NUM_00 = new RString("00");
    private static final RString 選択行のファイル日時 = new RString("選択行のファイル日時");
    private static final RString 単一の場合 = new RString("単一の場合");
    private static final RString 広域の場合 = new RString("広域の場合");
    private static final RString 取込み対象 = new RString("取込み対象");

    /**
     * コンストラクタです。
     *
     * @param div PostMainPanelDiv
     */
    public PostMainPanelValidationHandler(PostMainPanelDiv div) {
        this.div = div;
    }

    /**
     * validateチェック
     *
     * @param 場合 RString
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate(RString 場合) {

        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (場合.equals(単一の場合)) {
            messages.add(ValidateChain.validateStart(div).
                    ifNot(KokuhorenTorikomiListSpec.ファイル日時が空白).
                    thenAdd(IdocheckMessages.ファイル日時が空白).
                    messages());
            validPairs.add(createDictionary().check(messages));
        }
        if (場合.equals(広域の場合)) {
            messages.add(ValidateChain.validateStart(div).
                    ifNot(KokuhorenTorikomiListSpec.一覧対象未選択チェック).
                    thenAdd(IdocheckMessages.一覧対象未選択チェック).
                    ifNot(KokuhorenTorikomiListSpec.グリッドのファイル日時が空白).
                    thenAdd(IdocheckMessages.グリッドのファイル日時が空白).
                    ifNot(KokuhorenTorikomiListSpec.一覧選択解除チェック).
                    thenAdd(IdocheckMessages.一覧選択解除チェック).
                    messages());
            validPairs.add(createDictionary().check(messages));
        }
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder()
                .add(IdocheckMessages.ファイル日時が空白, div.getTxtFileYMD())
                .add(IdocheckMessages.一覧対象未選択チェック, div.getDgShichoson())
                .add(IdocheckMessages.グリッドのファイル日時が空白, div.getDgShichoson())
                .add(IdocheckMessages.一覧選択解除チェック, div.getDgShichoson())
                .build();
    }

    private static enum KokuhorenTorikomiListSpec implements IPredicate<PostMainPanelDiv> {

        ファイル日時が空白 {
                    @Override
                    public boolean apply(PostMainPanelDiv div) {

                        return div.getTxtFileYMD().getValue() != null
                        && !div.getTxtFileYMD().getValue().toString().isEmpty();
                    }
                },
        一覧対象未選択チェック {
                    @Override
                    public boolean apply(PostMainPanelDiv div) {

                        return !div.getDgShichoson().getSelectedItems().isEmpty()
                        && div.getDgShichoson().getSelectedItems() != null;
                    }
                },
        グリッドのファイル日時が空白 {
                    @Override
                    public boolean apply(PostMainPanelDiv div) {
                        if (div.getDgShichoson().getSelectedItems() != null
                        && !div.getDgShichoson().getSelectedItems().isEmpty()) {
                            for (dgShichoson_Row row : div.getDgShichoson().getSelectedItems()) {
                                if (row.getFileNitiji() == null || row.getFileNitiji().isEmpty()) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return true;
                    }
                },
        一覧選択解除チェック {
                    @Override
                    public boolean apply(PostMainPanelDiv div) {
                        List<dgShichoson_Row> rowList = div.getDgShichoson().getDataSource();
                        RString 市町村識別ID = ShichosonSecurityJoho.getShichosonShikibetsuId(ControlDataHolder.getUserId()).get(0).getItemId();
                        if (rowList != null && !rowList.isEmpty() && !(市町村識別ID.equals(NUM_00))) {
                            for (dgShichoson_Row row : rowList) {
                                if (!row.getSelected()) {
                                    return row.getSelected();
                                }
                            }
                        }
                        return true;
                    }
                };
    }

    private enum IdocheckMessages implements IValidationMessage {

        ファイル日時が空白(UrErrorMessages.対象データなし_追加メッセージあり, ファイル日時.toString()),
        一覧対象未選択チェック(UrErrorMessages.選択されていない, 取込み対象.toString()),
        グリッドのファイル日時が空白(UrErrorMessages.対象データなし_追加メッセージあり, 選択行のファイル日時.toString()),
        一覧選択解除チェック(DbzErrorMessages.未選択行あり);
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
