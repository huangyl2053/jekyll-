/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.service.core.shikakuhenkorireki.ShikakuhenkorirekiFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 資格変更履歴の入力チェックグラスです
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuHenkoRirekiValidationHandler {

    private static final RString MENUID_DBAMN24001 = new RString("DBAMN24001");
    private final ShikakuHenkoRirekiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuHenkoRirekiDiv
     */
    public ShikakuHenkoRirekiValidationHandler(ShikakuHenkoRirekiDiv div) {
        this.div = div;
    }

    /**
     *
     * 追加処理のチェック
     *
     * @param 資格関連異動 資格関連異動
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs tsuikaShoriCheck(HihokenshaDaicho 資格関連異動) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        RString menuID = ResponseHolder.getMenuID();
        ShikakuhenkorirekiFinder shikakuhenkorireki = ShikakuhenkorirekiFinder.createInstance();
        HihokenshaDaicho hihokenshaDaicho = shikakuhenkorireki.getHihokenshaDaichoByHihokenshaNo(資格関連異動.get被保険者番号());
        if (MENUID_DBAMN24001.equals(menuID)) {
            if (hihokenshaDaicho != null && !div.getTxtHenkoDate().getValue().isBeforeOrEquals(hihokenshaDaicho.get異動日())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShikakuHenkoRirekiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "最新履歴を追加することはできません。")));
            }
        } else {
            if (hihokenshaDaicho != null && div.getTxtHenkoDate().getValue().isBefore(hihokenshaDaicho.get異動日())) {
                validationMessages.add(new ValidationMessageControlPair(
                        new ShikakuHenkoRirekiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "過去の履歴を追加することはできません。")));
            }
        }

        return validationMessages;
    }

    /**
     *
     * 変更事由のチェック
     *
     * @param 資格関連異動 資格関連異動
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs henkoJiyuCheck(HihokenshaDaicho 資格関連異動) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (new RString("1").equals(資格関連異動.get広域内住所地特例フラグ())
                && (div.getDdlHenkoJiyu().getSelectedKey().equals(new RString("11"))
                || div.getDdlHenkoJiyu().getSelectedKey().equals(new RString("13")))) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShikakuHenkoRirekiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "広住特適用中にその事由は選択できません。")));
        }
        if (!new RString("1").equals(資格関連異動.get広域内住所地特例フラグ())
                && (div.getDdlHenkoJiyu().getSelectedKey().equals(new RString("14"))
                || div.getDdlHenkoJiyu().getSelectedKey().equals(new RString("15"))
                || div.getDdlHenkoJiyu().getSelectedKey().equals(new RString("17")))) {
            validationMessages.add(new ValidationMessageControlPair(
                    new ShikakuHenkoRirekiMessages(UrErrorMessages.入力値が不正_追加メッセージあり, "広住特適用中にその事由は選択できません。")));
        }

        return validationMessages;
    }

    private static class ShikakuHenkoRirekiMessages implements IValidationMessage {

        private final Message message;

        private ShikakuHenkoRirekiMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
