/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki.TekiyoJogaiRirekiDiv.DisplayMode;
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
 * 適用除外者管理のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBA-0210-010 dingyi
 */
public class TekiyoJogaiRirekiValidationHandler {

    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_修正 = new RString("修正");
    private static final RString 状態_削除 = new RString("削除");
    private static final DisplayMode 状態_適用登録 = DisplayMode.適用登録モード;
    private static final DisplayMode 状態_解除 = DisplayMode.解除モード;
    private static final DisplayMode 状態_訂正履歴 = DisplayMode.訂正履歴モード;
    private static final RString メッセージ適用日 = new RString("適用日");
    private final TekiyoJogaiRirekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 適用除外者管理Div
     */
    public TekiyoJogaiRirekiValidationHandler(TekiyoJogaiRirekiDiv div) {
        this.div = div;
    }

    /**
     * 「適用除外情報を確定する」ボタンを押下する場合、入力項目をチェックします。
     *
     * @param 画面状態 画面状態
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 入力チェック(DisplayMode 画面状態) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        datagridTekiyoJogai_Row 最新の適用情報 = new datagridTekiyoJogai_Row();
        if (div.getDatagridTekiyoJogai().getDataSource() != null
            && !div.getDatagridTekiyoJogai().getDataSource().isEmpty()) {
            最新の適用情報 = div.getDatagridTekiyoJogai().getDataSource().get(0);
        }
        if (!状態_削除.equals(div.getStauts())) {
            if (状態_適用登録.equals(画面状態)) {
                if (div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入所日,
                            div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput()));
                }
                if (RString.isNullOrEmpty(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入所施設コード));
                }
                if (div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日,
                            div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput()));
                } else {
                    if (最新の適用情報.getTekiyoDate().getValue() != null
                        && div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue().isBeforeOrEquals(
                            最新の適用情報.getTekiyoDate().getValue())) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    }
                }
                if (div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedKey() == null
                    || div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用事由,
                            div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput()));
                }
            } else if (状態_訂正履歴.equals(画面状態) && (状態_追加.equals(div.getStauts()) || 状態_修正.equals(div.getStauts()))) {
                if (div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用日,
                            div.getPanelTekiyoInput().getTxtTekiyoDate()));
                } else {
                    if (最新の適用情報.getTekiyoDate().getValue() != null
                        && 最新の適用情報.getTekiyoDate().getValue().isBeforeOrEquals(
                            div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())) {
                        validPairs.add(new ValidationMessageControlPair(
                                RRVMessages.適用日と直近データの適用日の整合性チェック,
                                div.getPanelTekiyoInput().getTxtTekiyoDate()));
                    }
                }
                if (div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey() == null
                    || div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.適用事由,
                            div.getPanelTekiyoInput().getDdlTekiyoJiyu()));
                }
            }
            if (状態_訂正履歴.equals(画面状態) && (状態_追加.equals(div.getStauts()) || 状態_修正.equals(div.getStauts()))) {
                if (div.getPanelTekiyoInput().getTxtKayijoDate().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.解除日, div.getPanelTekiyoInput().getTxtKayijoDate()));
                }
                if (div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey() == null
                    || div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.解除事由, div.getPanelTekiyoInput().getDdlKaijyoJiyu()));
                }
                if (div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() != null
                    && div.getPanelTekiyoInput().getTxtKayijoDate().getValue() != null
                    && div.getPanelTekiyoInput().getTxtKayijoDate().getValue().isBefore(
                        div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.適用日と解除日の整合性チェック, div.getPanelTekiyoInput().getTxtTekiyoDate(),
                            div.getPanelTekiyoInput().getTxtKayijoDate()));
                }
            } else if (状態_解除.equals(画面状態)) {
                if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.解除日, div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput()));
                } else {
                    if (最新の適用情報.getTekiyoDate().getValue() != null
                        && div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue().isBeforeOrEquals(
                            最新の適用情報.getTekiyoDate().getValue())) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    }
                }
                if (div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey() == null
                    || div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.解除事由, div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput()));
                }
            }
            if (状態_適用登録.equals(画面状態)) {
                if (div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() == null
                    && div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().
                        getNyuryokuShisetsuKodo() != null
                    && !div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().
                        getNyuryokuShisetsuKodo().isEmpty()) {
                    validPairs.add(new ValidationMessageControlPair(
                            RRVMessages.入所日の必須チェック,
                            div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput()));
                }
                if (div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() != null
                    && (div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().
                        getNyuryokuShisetsuKodo() == null
                        || div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().
                        getNyuryokuShisetsuKodo().isEmpty())) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.入所施設の必須チェック));
                }
            }
            if (状態_訂正履歴.equals(画面状態)) {
                期間重複チェック(div.getDatagridTekiyoJogai().getDataSource(), validPairs);
            }
        }
        return validPairs;
    }

    private void 期間重複チェック(List<datagridTekiyoJogai_Row> 適用情報リスト, ValidationMessageControlPairs validPairs) {
        for (datagridTekiyoJogai_Row row : 適用情報リスト) {
            if (RowState.Deleted.equals(row.getRowState()) || (div.getDatagridTekiyoJogai().getActiveRow() != null
                                                               && row.getId() == div.getDatagridTekiyoJogai().getActiveRow().getId())) {
                continue;
            }
            if (row.getKayijoDate().getValue() == null) {
                if (div.getPanelTekiyoInput().getTxtKayijoDate().getValue() == null) {
                    validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    break;
                } else {
                    if (row.getTekiyoDate().getValue().isBeforeOrEquals(
                            div.getPanelTekiyoInput().getTxtKayijoDate().getValue())) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                        break;
                    }
                }
            } else {
                if (div.getPanelTekiyoInput().getTxtKayijoDate().getValue() == null) {
                    if (div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() != null
                        && div.getPanelTekiyoInput().getTxtTekiyoDate().getValue().isBefore(
                            row.getKayijoDate().getValue())) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                        break;
                    }
                } else {
                    if (!(div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() != null
                          && div.getPanelTekiyoInput().getTxtKayijoDate().getValue() != null
                          && ((div.getPanelTekiyoInput().getTxtTekiyoDate().getValue().isBefore(
                               row.getTekiyoDate().getValue())
                               && div.getPanelTekiyoInput().getTxtKayijoDate().getValue().isBeforeOrEquals(
                               row.getTekiyoDate().getValue())
                               || (row.getKayijoDate().getValue().isBeforeOrEquals(
                                   div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())
                                   && row.getKayijoDate().getValue().isBefore(
                                   div.getPanelTekiyoInput().getTxtKayijoDate().getValue())))))) {
                        validPairs.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                        break;
                    }
                }
            }
        }
    }

    private static enum RRVMessages implements IValidationMessage {

        適用日(UrErrorMessages.必須, メッセージ適用日.toString()),
        解除日(UrErrorMessages.必須, "解除日"),
        適用事由(UrErrorMessages.必須, "適用事由"),
        解除事由(UrErrorMessages.必須, "解除事由"),
        入所日(UrErrorMessages.必須, "入所日"),
        入所施設コード(UrErrorMessages.必須, "入所施設コード"),
        適用日と解除日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, メッセージ適用日.toString(), "解除日"),
        適用日と適用届出日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, "適用届出日", メッセージ適用日.toString()),
        解除日と解除届出日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, "解除届出日", "解除日"),
        入所施設の必須チェック(DbzErrorMessages.複数必須項目相関チェックエラー, "入所日", "入所施設"),
        入所日の必須チェック(DbzErrorMessages.複数必須項目相関チェックエラー, "入所施設", "入所日"),
        適用日と直近データの適用日の整合性チェック(DbzErrorMessages.期間が不正_未来日付不可, メッセージ適用日.toString(), "直近データ．適用日"),
        期間が重複(UrErrorMessages.期間が重複);
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
