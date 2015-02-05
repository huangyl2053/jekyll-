/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller;

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
 * 住所地特例関連で使用されるバリデーションヘルパーです。
 *
 * @author n8178 城間篤人
 */
public final class JushochiTokureiRirekiListValidationHelper {

    private JushochiTokureiRirekiListValidationHelper() {
    }

    public static ValidationMessageControlPairs validate住所地特例(HihokenshaDaichoModel target, IItemList<HihokenshaDaichoModel> daichoList,
            TextBoxFlexibleDate 適用日, TextBoxFlexibleDate 解除日, DataGrid<dgJutoku_Row> 住所地特例grid, JushochiTokureiExecutionStatus status) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionary(
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住所地特例適用日が_最新履歴の取得日_変更日_住所地特例解除日より前, 適用日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住特適用日が資格取得日より前, 適用日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住特適用日が資格喪失日以降, 適用日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住所地特例解除日が_最新履歴の取得日_変更日_住所地特例適用日より前, 解除日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住特解除日が資格取得日より前, 解除日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住特解除日が資格喪失日以降, 解除日),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住所地特例期間と他市町村住所地特例期間が重複する履歴がある, 住所地特例grid),
                new ValidationMessageControlPair(
                        JushochiTokureiValidationMessage.住所地特例期間と適用除外期間が重複する履歴がある, 住所地特例grid));

        IValidationMessages messages = ValidationMessagesFactory.createValidationMessagesInstance();

        messages.add(JushochiTokureiValidator.setJushochiTokureiData(target)
                .setJushochiTokureiList(daichoList).validate());

        if (status == JushochiTokureiExecutionStatus.Tekiyo || status == JushochiTokureiExecutionStatus.Teisei) {
            messages.add(JuchochiTokureiTekiyoValidator.setTekiyoDate(target.get適用年月日())
                    .setNewestHihokenshaDaicho(daichoList.findFirst().get()).validate());
        }

        if (status == JushochiTokureiExecutionStatus.Kaijo || status == JushochiTokureiExecutionStatus.Teisei) {
            messages.add(JuchochiTokureiKaijoValidator.setKaijoDate(target.get解除年月日())
                    .setNewestHihokenshaDaicho(daichoList.findFirst().get()).validate());
        }

        messages.add(JushochiTokureiUnduplicateValidator.setHihokenshaDaichoData(target).validate());

        return dictionary.check(messages);
    }

}
