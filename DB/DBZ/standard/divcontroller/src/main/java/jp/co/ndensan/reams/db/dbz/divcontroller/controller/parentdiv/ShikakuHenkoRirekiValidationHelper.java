/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv;

import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.ShikakuHenkoRirekiKanriContext;
import jp.co.ndensan.reams.db.dbz.business.core.validation.ShikakuHenkoValidationMessage;
import jp.co.ndensan.reams.db.dbz.business.core.validations.validator.custom.ShikakuHenkoValidator;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionary;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護資格変更のバリデーションヘルパークラスです。
 *
 * @author N8235 船山 洋介
 */
public final class ShikakuHenkoRirekiValidationHelper {

    private ShikakuHenkoRirekiValidationHelper() {

    }

    /**
     * コンストラクタです。
     *
     * @param 変更日 変更日のコントロール
     * @param 変更届出日 変更届出日のコントロール
     * @param 取得日 取得日のコントロール
     * @param 喪失日 喪失日のコントロール
     * @param 最新取得日 最新履歴
     * @param 最新喪失日 最新喪失日
     * @param 最新更新日 最新更新日
     * @param 一号資格取得 一号資格取得
     * @param 変更事由 変更事由のコントロール
     * @param context コンテキスト
     * @return バリデーションメッセージとそれに関係するコントロールのセットを持つコレクション
     */
    public static ValidationMessageControlPairs validate資格変更(TextBoxFlexibleDate 変更日, TextBoxFlexibleDate 変更届出日,
            FlexibleDate 取得日, FlexibleDate 喪失日, FlexibleDate 最新取得日, FlexibleDate 最新喪失日, FlexibleDate 最新更新日,
            FlexibleDate 一号資格取得, DropDownList 変更事由, ShikakuHenkoRirekiKanriContext context) {
        ValidationMessageControlDictionary dictionary = new ValidationMessageControlDictionaryBuilder()
                .add(ShikakuHenkoValidationMessage.変更日が未入力, 変更日)
                .add(ShikakuHenkoValidationMessage.変更事由が未入力, 変更事由)
                .add(ShikakuHenkoValidationMessage.変更事由が１号到達で年齢が65歳未満, 変更事由)
                .add(ShikakuHenkoValidationMessage.変更事由が１号到達以外年齢が40歳未満, 変更事由)
                .add(ShikakuHenkoValidationMessage.変更日と前の履歴データの変更日の期間が重複, 変更日)
                .add(ShikakuHenkoValidationMessage.取得日より前, 変更日)
                .add(ShikakuHenkoValidationMessage.喪失日より後, 変更日)
                .add(ShikakuHenkoValidationMessage.変更日と住所地特例履歴の期間が重複する履歴がある, 変更日)
                .add(ShikakuHenkoValidationMessage.変更日と次の履歴データの変更日の期間が重複, 変更日)
                .add(ShikakuHenkoValidationMessage.届出日設定なし, 変更届出日)
                .build();

        IValidationMessages messages = (new ShikakuHenkoValidator(変更日.getValue(), 取得日, 喪失日, 変更事由.getSelectedKey(),
                最新取得日, 最新喪失日, 最新更新日, 一号資格取得)).validateIn(context);
        return dictionary.check(messages);
    }
}
