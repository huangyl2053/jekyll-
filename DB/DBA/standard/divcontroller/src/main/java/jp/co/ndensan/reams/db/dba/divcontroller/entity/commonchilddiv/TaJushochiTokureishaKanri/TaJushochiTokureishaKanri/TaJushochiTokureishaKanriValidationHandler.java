/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;

import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 他住所地特例管理のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-0200-010 linghuhang
 */
public class TaJushochiTokureishaKanriValidationHandler {

    private static final RString 状態_修正 = new RString("Teisei");
    private static final RString 状態_適用 = new RString("Tekiyo");
    private static final RString 状態_解除 = new RString("Kaijyo");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString メッセージ適用日 = new RString("適用日");
    private final TaJushochiTokureishaKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 他住所地特例管理Div
     */
    public TaJushochiTokureishaKanriValidationHandler(TaJushochiTokureishaKanriDiv div) {
        this.div = div;
    }

    /**
     * 「異動内容を確認する」ボタンを押下します。
     *
     * @param 親画面状態 親画面状態
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validateForUpdate(RString 親画面状態) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        dgJushochiTokureiRireki_Row 最新の適用情報 = new dgJushochiTokureiRireki_Row();
        if (div.getDgJushochiTokureiRireki().getDataSource() != null
                && !div.getDgJushochiTokureiRireki().getDataSource().isEmpty()) {
            最新の適用情報 = div.getDgJushochiTokureiRireki().getDataSource().get(0);
        }

        if (!状態_削除.equals(div.getStrate())) {
            if (状態_修正.equals(親画面状態)) {
                if (div.getTxtTekiyobi().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日, div.getTxtTekiyobi()));
                } else {
                    if (最新の適用情報 != null && 最新の適用情報.getTekiyoYMD().getValue() != null && !RowState.Deleted.equals(最新の適用情報.getRowState())
                            && (!div.getTxtTekiyobi().getValue().isBefore(最新の適用情報.getTekiyoYMD().getValue()))) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日と最新の適用情報の整合性チェック, div.getTxtTekiyobi()));
                    }
                }
                if (div.getTxtKaijyobi().getValue() != null && (div.getDdlKaijyoJiyo().getSelectedKey() == null
                        || div.getDdlKaijyoJiyo().getSelectedKey().isEmpty())) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.解除事由, div.getDdlKaijyoJiyo()));
                }
                if (div.getDdlTekiyoJiyo().getSelectedKey() == null
                        || div.getDdlTekiyoJiyo().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用事由, div.getDdlTekiyoJiyo()));
                }

                if (div.getTxtTekiyobi().getValue() != null
                        && div.getTxtTekiyoTodokedebi().getValue() != null
                        && (div.getTxtTekiyobi().getValue().isBefore(div.getTxtTekiyoTodokedebi().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.適用日と適用届出日の整合性チェック, div.getTxtTekiyobi(), div.getTxtTekiyoTodokedebi()));
                }
                if (div.getTxtKaijyobi().getValue() != null && div.getTxtKaijyoTodokedebi().getValue() != null
                        && (div.getTxtKaijyobi().getValue().isBefore(div.getTxtKaijyoTodokedebi().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.解除日と解除届出日の整合性チェック, div.getTxtKaijyobi(), div.getTxtKaijyoTodokedebi()));
                }
                if (div.getTxtKaijyobi().getValue() != null && div.getTxtTekiyobi().getValue() != null
                        && (div.getTxtKaijyobi().getValue().isBefore(div.getTxtTekiyobi().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.適用日と解除日の整合性チェック, div.getTxtKaijyobi(), div.getTxtTekiyobi()));
                }

                if (div.getDgJushochiTokureiRireki().getDataSource() != null
                        && !div.getDgJushochiTokureiRireki().getDataSource().isEmpty()) {
                    for (dgJushochiTokureiRireki_Row row : div.getDgJushochiTokureiRireki().getDataSource()) {
                        if (div.getSelectData().equals(new RString(String.valueOf(row.getId())))
                                || RowState.Deleted.equals(row.getRowState())) {
                            continue;
                        }
                        if (row.getKaijoYMD().getValue() == null) {
                            if (div.getTxtKaijyobi().getValue() == null) {
                                validPairs.add(new ValidationMessageControlPair(RRVMessages.解除日, div.getTxtKaijyobi()));
                            } else {
                                if (!div.getTxtKaijyobi().getValue().isBefore(row.getTekiyoYMD().getValue())) {
                                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                                }
                            }
                        } else {
                            if (div.getTxtKaijyobi().getValue() == null && div.getTxtTekiyobi().getValue() != null) {
                                if (div.getTxtTekiyobi().getValue().isBefore(row.getKaijoYMD().getValue())) {
                                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                                }
                            } else {
                                if (div.getTxtTekiyobi().getValue() != null && div.getTxtKaijyobi().getValue() != null
                                        && row.getTekiyoYMD().getValue() != null && row.getKaijoYMD().getValue() != null
                                        && row.getTekiyoYMD().getValue().isBeforeOrEquals(div.getTxtKaijyobi().getValue())
                                        && div.getTxtTekiyobi().getValue().isBeforeOrEquals(row.getKaijoYMD().getValue())) {
                                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                                }
                            }
                        }
                    }
                }
            }
            if (状態_適用.equals(親画面状態)) {
                if (div.getTxtTekiyobi().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日, div.getTxtTekiyobi()));
                } else {
                    if (最新の適用情報 != null && 最新の適用情報.getKaijoYMD().getValue() != null
                            && (div.getTxtTekiyobi().getValue().isBefore(最新の適用情報.getKaijoYMD().getValue()))) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    }
                }
                if (div.getTxtNyusyobi().getValue() != null && 最新の適用情報 != null && 最新の適用情報.getTaishoYMD().getValue() != null
                        && (div.getTxtNyusyobi().getValue().isBefore(最新の適用情報.getTaishoYMD().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                }
                if (div.getDdlTekiyoJiyo().getSelectedKey() == null
                        || div.getDdlTekiyoJiyo().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用事由, div.getDdlTekiyoJiyo()));
                }
                if (div.getTxtTekiyobi().getValue() != null && div.getTxtTekiyoTodokedebi().getValue() != null
                        && div.getTxtTekiyobi().getValue().isBefore(div.getTxtTekiyoTodokedebi().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日と適用届出日の整合性チェック, div.getTxtTekiyobi(), div.getTxtTekiyoTodokedebi()));
                }
                if (div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo() != null
                        && !div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty()
                        && div.getTxtNyusyobi().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入所日の必須チェック, div.getTxtNyusyobi()));
                }

                if ((div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo() == null
                        || div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo().isEmpty())
                        && div.getTxtNyusyobi().getValue() != null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入所施設の必須チェック));
                }
                if (RString.isNullOrEmpty(div.getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入力施設コード));
                }
            }
            if (状態_解除.equals(親画面状態)) {
                if (div.getTxtKaijyobi().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.解除日, div.getTxtKaijyobi()));
                } else {
                    if (div.getDdlKaijyoJiyo().getSelectedKey() == null
                            || div.getDdlKaijyoJiyo().getSelectedKey().isEmpty()) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.解除事由));
                    }
                    if (最新の適用情報 != null && 最新の適用情報.getTekiyoYMD().getValue() != null
                            && (div.getTxtKaijyobi().getValue().isBefore(最新の適用情報.getTekiyoYMD().getValue()))) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.入力値が不正, div.getTxtKaijyobi()));
                    }
                }
                if (div.getTxtTasyobi().getValue() != null && 最新の適用情報 != null && 最新の適用情報.getNyushoYMD().getValue() != null
                        && (div.getTxtTasyobi().getValue().isBefore(最新の適用情報.getNyushoYMD().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入力値が不正, div.getTxtKaijyobi()));
                }
                if (div.getTxtKaijyobi().getValue() != null && div.getTxtKaijyoTodokedebi().getValue() != null
                        && (div.getTxtKaijyobi().getValue().isBefore(div.getTxtKaijyoTodokedebi().getValue()))) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.解除日と解除届出日の整合性チェック));
                }
            }
        }
        return validPairs;
    }

    private static enum RRVMessages implements IValidationMessage {

        適用日(UrErrorMessages.必須, メッセージ適用日.toString()),
        解除日(UrErrorMessages.必須, "解除日"),
        適用事由(UrErrorMessages.必須, "適用事由"),
        解除事由(UrErrorMessages.必須, "解除事由"),
        入力施設コード(UrErrorMessages.必須, "入力施設コード"),
        適用日と適用届出日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, "適用届出日", メッセージ適用日.toString()),
        解除日と解除届出日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, "解除届出日", "解除日"),
        適用日と解除日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, "解除日", メッセージ適用日.toString()),
        適用日と最新の適用情報の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, メッセージ適用日.toString(), "最新の適用情報"),
        入所日の必須チェック(DbzErrorMessages.複数必須項目相関チェックエラー, "入所施設", "入所日"),
        入所施設の必須チェック(DbzErrorMessages.複数必須項目相関チェックエラー, "入所日", "入所施設"),
        期間が重複(UrErrorMessages.期間が重複),
        入力値が不正(UrErrorMessages.入力値が不正);
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
