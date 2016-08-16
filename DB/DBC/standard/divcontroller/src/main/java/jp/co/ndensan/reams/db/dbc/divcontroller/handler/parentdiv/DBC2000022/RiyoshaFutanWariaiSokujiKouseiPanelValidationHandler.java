/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000022;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.DBC2000022PanelAllDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022.dgFutanWariai_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_修正。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiSokujiKouseiPanelValidationHandler {

    private final DBC2000022PanelAllDiv div;
    private static final RString 適用開始日 = new RString("適用開始日");
    private static final RString 適用終了日 = new RString("適用終了日");
    private static final RString 本人合計所得 = new RString("本人合計所得");
    private static final RString 世帯員数１号 = new RString("世帯員数（１号）");
    private static final RString 年金収入合計 = new RString("年金収入合計");
    private static final RString その他の合計所得合計 = new RString("その他の合計所得合計");
    private static final RString 適用開始日と適用終了日 = new RString("適用開始日 > 適用終了日");
    private static final RString その他の合計所得合計不正 = new RString("0以上の数値");
    private static final RString 発行日 = new RString("発行日");
    private static final RString 交付日 = new RString("交付日");

    /**
     * 初期化処理です。
     *
     * @param div DBC2000022PanelAllDiv
     */
    public RiyoshaFutanWariaiSokujiKouseiPanelValidationHandler(DBC2000022PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 入力チェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtTekiyoKaishibi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 適用開始日.toString())));
        }
        if (div.getTxtTekiyoShuryobi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 適用終了日.toString())));
        }
        if (div.getTxtHonninGokeiShotoku().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 本人合計所得.toString())));
        }
        if (div.getTxtSetaiinsu().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 世帯員数１号.toString())));
        }
        if (div.getTxtNenkinShunyuGokei().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 年金収入合計.toString())));
        }
        if (div.getTxtSonotaGokei().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, その他の合計所得合計.toString())));
        }

        if (div.getTxtTekiyoKaishibi().getValue() != null && div.getTxtTekiyoShuryobi().getValue() != null
                && div.getTxtTekiyoShuryobi().getValue().isBefore(div.getTxtTekiyoKaishibi().getValue())) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.大小関係が不正, 適用開始日と適用終了日.toString())));
        }

        if (div.getTxtSonotaGokei().getValue() != null && div.getTxtSonotaGokei().getValue().compareTo(Decimal.ZERO) < 0) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.大小関係が不正, その他の合計所得合計不正.toString())));
        }
        return validPairs;
    }

    /**
     * 妥当性チェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 枝番間期間チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgFutanWariai_Row> rowsData = div.getDgFutanWariai().getDataSource();
        boolean flag = false;
        for (int i = 0; i < rowsData.size(); i++) {
            if (rowsData.get(i).getLogicalDeletedFlag()) {
                continue;
            }
            for (int j = i + 1; j < rowsData.size(); j++) {
                if (!rowsData.get(j).getLogicalDeletedFlag()) {
                    if (rowsData.get(j).getTekiyoKaishibi().getValue().isBefore(rowsData.get(i).getTekiyoShuryobi().getValue())
                            || rowsData.get(j).getTekiyoKaishibi().getValue().minusDay(1)
                            .compareTo(rowsData.get(i).getTekiyoShuryobi().getValue()) != 0) {
                        flag = true;
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (flag) {
                break;
            }
        }
        if (flag) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbcErrorMessages.適用期間_重複_空きエラー)));
        }
        return validPairs;
    }

    /**
     * 妥当性チェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 開始終了チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        List<dgFutanWariai_Row> rowsData = div.getDgFutanWariai().getDataSource();
        RDate 最小適用開始日 = null;
        RDate 最大適用終了日 = null;
        for (int i = 0; i < rowsData.size(); i++) {
            if (!rowsData.get(i).getLogicalDeletedFlag()) {
                最小適用開始日 = rowsData.get(i).getTekiyoKaishibi().getValue();
                break;
            }
        }
        for (int i = rowsData.size() - 1; i >= 0; i--) {
            if (!rowsData.get(i).getLogicalDeletedFlag()) {
                最大適用終了日 = rowsData.get(i).getTekiyoShuryobi().getValue();
                break;
            }
        }
        RString 業務コンフィグ_年度終了月日 = BusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, SubGyomuCode.DBC介護給付);
        RDate 年度終了月日1 = new RDate(div.getDdlNendo().getSelectedKey().concat(業務コンフィグ_年度終了月日).toString()).plusDay(1);
        RDate 年度終了月日2 = new RDate(new RString(Integer.parseInt(div.getDdlNendo().getSelectedKey().toString()) + 1)
                .concat(業務コンフィグ_年度終了月日).toString());
        if (最小適用開始日 != null && 最大適用終了日 != null) {
            if (最小適用開始日.isBefore(年度終了月日1) || 最大適用終了日.isBefore(年度終了月日2)) {
                validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                        DbcErrorMessages.適用期間_年度エラー)));
            }
        }
        return validPairs;
    }

    /**
     * 妥当性チェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 変更有無チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        return validPairs;
    }

    /**
     * 発行日と交付日の必須入力チェックです。
     *
     * @return validPairs
     */
    public ValidationMessageControlPairs 発行日と交付日必須入力チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (div.getTxtHakkobi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 発行日.toString())));
        }
        if (div.getTxtKofubi().getValue() == null) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.必須, 交付日.toString())));
        }
        return validPairs;
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
