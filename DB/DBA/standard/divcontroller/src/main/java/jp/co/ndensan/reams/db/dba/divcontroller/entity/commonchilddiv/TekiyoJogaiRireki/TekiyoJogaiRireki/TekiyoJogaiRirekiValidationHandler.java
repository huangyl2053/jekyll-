/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki.TekiyoJogaiRireki;

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
    private static final RString 状態_削除 = new RString("削除");
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
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        if (状態_削除.equals(div.getStauts())) {
            return result;
        }

        datagridTekiyoJogai_Row 最新の適用情報 = new datagridTekiyoJogai_Row();
        if (div.getDatagridTekiyoJogai().getDataSource() != null
            && !div.getDatagridTekiyoJogai().getDataSource().isEmpty()) {
            最新の適用情報 = div.getDatagridTekiyoJogai().getDataSource().get(0);
        }
        switch (div.getMode_DisplayMode()) {
            case 適用登録モード:
                result.add(validate適用登録(div, 最新の適用情報));
                break;
            case 訂正履歴モード:
                result.add(validate訂正履歴(div, 最新の適用情報));
                break;
            case 解除モード:
                result.add(validate解除(div, 最新の適用情報));
            default:
        }
        return result;
    }

    //<editor-fold defaultstate="collapsed" desc="validate適用登録()">
    private static ValidationMessageControlPairs validate適用登録(TekiyoJogaiRirekiDiv div, datagridTekiyoJogai_Row 最新の適用情報) {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        if (div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() == null) {
            result.add(new ValidationMessageControlPair(RRVMessages.入所日_必須, div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput()));
        }
        if (RString.isNullOrEmpty(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            result.add(new ValidationMessageControlPair(RRVMessages.入所施設コード_必須));
        }
        if (RString.isNullOrEmpty(div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput().getSelectedKey())) {
            result.add(new ValidationMessageControlPair(RRVMessages.適用事由_必須, div.getPanelTekiyoJokaiTekiInput().getDdlTekiyoJiyuInput()));
        }
        if (!RString.isNullOrEmpty(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo())
            && div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() == null) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.入所日の必須チェック,
                    div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput()));
        }
        if (div.getPanelTekiyoJokaiTekiInput().getTxtNyusyoDateInput().getValue() != null
            && RString.isNullOrEmpty(div.getPanelTekiyoJokaiTekiInput().getCcdShisetsuJoho().getNyuryokuShisetsuKodo())) {
            result.add(new ValidationMessageControlPair(RRVMessages.入所施設の必須チェック));
        }
        if (div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue() == null) {
            result.add(new ValidationMessageControlPair(RRVMessages.適用日_必須, div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput()));
            return result;
        }
        if (状態_追加.equals(div.getStauts())) {
            if (最新の適用情報.getTekiyoDate().getValue() == null) {
                return result;
            }
            if (div.getPanelTekiyoJokaiTekiInput().getTxtTekiyoDateInput().getValue()
                    .isBeforeOrEquals(最新の適用情報.getTekiyoDate().getValue())) {
                result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
            }
            return result;
        }
        result.add(validate期間重複なし(div));
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="validate訂正履歴()">
    private static ValidationMessageControlPairs validate訂正履歴(TekiyoJogaiRirekiDiv div, datagridTekiyoJogai_Row 最新の適用情報) {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        if (div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() == null) {
            result.add(new ValidationMessageControlPair(RRVMessages.適用日_必須,
                    div.getPanelTekiyoInput().getTxtTekiyoDate()));
        } else {
            if (最新の適用情報.getTekiyoDate().getValue() != null
                && 最新の適用情報.getTekiyoDate().getValue().isBeforeOrEquals(
                    div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())) {
                result.add(new ValidationMessageControlPair(
                        RRVMessages.適用日と直近データの適用日の整合性チェック,
                        div.getPanelTekiyoInput().getTxtTekiyoDate()));
            }
        }
        if (div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey() == null
            || div.getPanelTekiyoInput().getDdlTekiyoJiyu().getSelectedKey().isEmpty()) {
            result.add(new ValidationMessageControlPair(RRVMessages.適用事由_必須,
                    div.getPanelTekiyoInput().getDdlTekiyoJiyu()));
        }

        if (div.getPanelTekiyoInput()
                .getTxtKayijoDate().getValue() == null) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.解除日_必須, div.getPanelTekiyoInput().getTxtKayijoDate()));
        }

        if (div.getPanelTekiyoInput()
                .getDdlKaijyoJiyu().getSelectedKey() == null
            || div.getPanelTekiyoInput().getDdlKaijyoJiyu().getSelectedKey().isEmpty()) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.解除事由_必須, div.getPanelTekiyoInput().getDdlKaijyoJiyu()));
        }

        if (div.getPanelTekiyoInput()
                .getTxtTekiyoDate().getValue() != null
            && div.getPanelTekiyoInput().getTxtKayijoDate().getValue() != null
            && div.getPanelTekiyoInput().getTxtKayijoDate().getValue().isBefore(
                div.getPanelTekiyoInput().getTxtTekiyoDate().getValue())) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.適用日と解除日の整合性チェック, div.getPanelTekiyoInput().getTxtTekiyoDate(),
                    div.getPanelTekiyoInput().getTxtKayijoDate()));
        }

        result.add(validate期間重複なし(div));
        return result;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="validate解除()">
    private static ValidationMessageControlPairs validate解除(TekiyoJogaiRirekiDiv div, datagridTekiyoJogai_Row 最新の適用情報) {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        if (div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue() == null) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.解除日_必須, div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput()));
        } else {
            if (最新の適用情報.getTekiyoDate().getValue() != null
                && div.getPanelTekiyoJokaiKaiJyoInput().getTxtKaijoDateInput().getValue().isBeforeOrEquals(
                    最新の適用情報.getTekiyoDate().getValue())) {
                result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
            }
        }
        if (div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey() == null
            || div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput().getSelectedKey().isEmpty()) {
            result.add(new ValidationMessageControlPair(
                    RRVMessages.解除事由_必須, div.getPanelTekiyoJokaiKaiJyoInput().getDdlKaijoJiyuInput()));
        }
        return result;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="validate期間重複なし()">
    private static ValidationMessageControlPairs validate期間重複なし(TekiyoJogaiRirekiDiv div) {
        ValidationMessageControlPairs result = new ValidationMessageControlPairs();
        for (datagridTekiyoJogai_Row row : div.getDatagridTekiyoJogai().getDataSource()) {
            if (RowState.Deleted.equals(row.getRowState())
                || (div.getDatagridTekiyoJogai().getActiveRow() != null
                    && row.getId() == div.getDatagridTekiyoJogai().getActiveRow().getId())) {
                continue;
            }

            if (row.getKayijoDate().getValue() == null) {
                if (div.getPanelTekiyoInput().getTxtKayijoDate().getValue() == null) {
                    result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    break;
                }
                if (row.getTekiyoDate().getValue().isBeforeOrEquals(
                        div.getPanelTekiyoInput().getTxtKayijoDate().getValue())) {
                    result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    break;
                }
            }

            if (div.getPanelTekiyoInput().getTxtKayijoDate().getValue() == null) {
                if (div.getPanelTekiyoInput().getTxtTekiyoDate().getValue() != null
                    && div.getPanelTekiyoInput().getTxtTekiyoDate().getValue().isBefore(
                        row.getKayijoDate().getValue())) {
                    result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                    break;
                }
            }

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
                result.add(new ValidationMessageControlPair(RRVMessages.期間が重複));
                break;
            }
        }
        return result;

    }
    //</editor-fold>

    private static enum RRVMessages implements IValidationMessage {

        適用日_必須(UrErrorMessages.必須, メッセージ適用日.toString()),
        解除日_必須(UrErrorMessages.必須, "解除日"),
        適用事由_必須(UrErrorMessages.必須, "適用事由"),
        解除事由_必須(UrErrorMessages.必須, "解除事由"),
        入所日_必須(UrErrorMessages.必須, "入所日"),
        入所施設コード_必須(UrErrorMessages.必須, "入所施設コード"),
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
