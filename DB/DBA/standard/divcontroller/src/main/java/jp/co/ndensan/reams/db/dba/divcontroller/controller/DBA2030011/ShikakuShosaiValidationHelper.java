/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.DBA2030011;

import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JuchochiTokureiKaijoValidator;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JuchochiTokureiTekiyoValidator;
import jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho.JushochiTokureiValidator;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.dgJutoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.validation.JushochiTokureiValidationMessage;
import jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.JushochiTokureiUnduplicateValidator;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住所地特例画面の資格詳細パネルで実行されるバリデーションのヘルパーです。
 *
 * @author n8178 城間篤人
 */
public final class ShikakuShosaiValidationHelper {

    private ShikakuShosaiValidationHelper() {
    }

    public static ValidationMessageControlPairs validate画面起動時(HihokenshaDaichoModel target, IItemList<HihokenshaDaichoModel> daichoList,
            TextBoxFlexibleDate 適用日, TextBoxFlexibleDate 解除日, DataGrid<dgJutoku_Row> 住所地特例grid, JushochiTokureiExecutionStatus status) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionary();

        IValidationMessages messages = ValidationMessagesFactory.createValidationMessagesInstance();
        return dictionary.check(messages);
    }

    public static ValidationMessageControlPairs validate保存前(HihokenshaDaichoModel target, IItemList<HihokenshaDaichoModel> daichoList,
            TextBoxFlexibleDate 適用日, TextBoxFlexibleDate 解除日, DataGrid<dgJutoku_Row> 住所地特例grid, JushochiTokureiExecutionStatus status) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionary();

        IValidationMessages messages = ValidationMessagesFactory.createValidationMessagesInstance();
        return dictionary.check(messages);
    }

}
