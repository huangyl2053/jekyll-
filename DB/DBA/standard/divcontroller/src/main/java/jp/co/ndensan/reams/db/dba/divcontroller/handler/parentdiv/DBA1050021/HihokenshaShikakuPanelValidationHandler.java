/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021.HihokenshaShisakuPanalDiv;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021.ShikakuShutokuValidator.ShikakuShutokuValidationMessage;
import jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1050021.ShikakuSoshitsuValidator.ShikakuSoshitsuValidationMessage;

/**
 * 資格詳細画面のバリデーションを定義します。
 *
 * @author n8178
 */
public class HihokenshaShikakuPanelValidationHandler {

    private final HihokenshaShisakuPanalDiv div;

    /**
     * コンストラクタ
     *
     * @param div 被保険者資格PanelDiv
     */
    public HihokenshaShikakuPanelValidationHandler(HihokenshaShisakuPanalDiv div) {
        this.div = div;
    }

    /**
     * 資格取得情報の入力について検査します。
     *
     * @return 検査結果
     */
    public ValidationMessageControlPairs validate資格取得情報() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        ShikakuShutokuValidator validator = new ShikakuShutokuValidator(div);

        IValidationMessages messages = validator.validate();
        if (messages.contains(ShikakuShutokuValidationMessage.資格取得日未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.資格取得日未入力, div.getTxtShutokuDate()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.資格取得届出日未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.資格取得届出日未入力, div.getTxtShutokuTodokedeDate()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.資格取得事由未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.資格取得事由未入力, div.getDdlShutokuJiyu()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.被保険者区分未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.被保険者区分未入力, div.getDdlHihoKubun()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.所在保険者未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.所在保険者未入力, div.getDdlShutokuShozaiHokensha()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.措置元保険者未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.措置元保険者未入力, div.getDdlShutokuSochimotoHokensha()));
        }
        if (messages.contains(ShikakuShutokuValidationMessage.旧保険者未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuShutokuValidationMessage.旧保険者未入力, div.getDdlShutokuKyuHokensha()));
        }
        return pairs;
    }

    /**
     * 資格喪失情報の入力について検査します。
     *
     * @return 検査結果
     */
    public ValidationMessageControlPairs validate資格喪失情報() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();

        ShikakuSoshitsuValidator validator = new ShikakuSoshitsuValidator(div);

        IValidationMessages messages = validator.validate();
        if (messages.contains(ShikakuSoshitsuValidationMessage.資格喪失日未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuSoshitsuValidationMessage.資格喪失日未入力, div.getTxtSoshitsuDate()));
        }
        if (messages.contains(ShikakuSoshitsuValidationMessage.資格得喪日不整合)) {
            pairs.add(new ValidationMessageControlPair(ShikakuSoshitsuValidationMessage.資格得喪日不整合, div.getTxtSoshitsuDate()));
        }
        if (messages.contains(ShikakuSoshitsuValidationMessage.資格喪失届出日未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuSoshitsuValidationMessage.資格喪失届出日未入力, div.getTxtSoshitsuTodokedeDate()));
        }
        if (messages.contains(ShikakuSoshitsuValidationMessage.資格喪失事由未入力)) {
            pairs.add(new ValidationMessageControlPair(ShikakuSoshitsuValidationMessage.資格喪失事由未入力, div.getDdlSoshitsuJiyu()));
        }

        return pairs;
    }
}
