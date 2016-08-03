/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA2030011;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.dgJutoku_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住所地特例画面の資格詳細パネルで実行されるバリデーションのヘルパーです。
 *
 * @author n8178 城間篤人
 */
public final class ShikakuShosaiValidationHelper {

    private ShikakuShosaiValidationHelper() {
    }

    /**
     *
     * @param target HihokenshaDaicho
     * @param daichoList HihokenshaDaicho
     * @param 適用日 適用日
     * @param 解除日 解除日
     * @param 住所地特例grid dgJutoku_Row
     * @param status JushochiTokureiExecutionStatus
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate画面起動時(HihokenshaDaicho target, IItemList<HihokenshaDaicho> daichoList,
            TextBoxFlexibleDate 適用日, TextBoxFlexibleDate 解除日, DataGrid<dgJutoku_Row> 住所地特例grid, JushochiTokureiExecutionStatus status) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder().build();

        IValidationMessages messages = ValidationMessagesFactory.createInstance(); //createValidationMessagesInstance();
        return dictionary.check(messages);
    }

    /**
     *
     * @param target HihokenshaDaicho
     * @param daichoList HihokenshaDaicho
     * @param 適用日 適用日
     * @param 解除日 解除日
     * @param 住所地特例grid dgJutoku_Row
     * @param status JushochiTokureiExecutionStatus
     * @return ValidationMessageControlPairs
     */
    public static ValidationMessageControlPairs validate保存前(HihokenshaDaicho target, IItemList<HihokenshaDaicho> daichoList,
            TextBoxFlexibleDate 適用日, TextBoxFlexibleDate 解除日, DataGrid<dgJutoku_Row> 住所地特例grid, JushochiTokureiExecutionStatus status) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder().build();

        IValidationMessages messages = ValidationMessagesFactory.createInstance(); //createValidationMessagesInstance();
        return dictionary.check(messages);
    }

}
