/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.shikaku;

import jp.co.ndensan.reams.ur.urz.model.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 介護資格変更のバリデーションクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoValidator {

    private final ShikakuHenko nothing;
//    private final FlexibleDate 変更日;
//    private final FlexibleDate 取得日;
//    private final FlexibleDate 喪失日;
//    private final RString 変更事由;
//    private final FlexibleDate 最新資格取得日;
//    private final FlexibleDate 最新資格喪失日;
//    private final FlexibleDate 一号資格取得日;
//    private final FlexibleDate 最新資格変更日;

    /**
     * ShikakuHenkoValidator
     *
     * @param shikakuHenko ShikakuHenko
     */
    public ShikakuHenkoValidator(ShikakuHenko shikakuHenko) {
        this.nothing = shikakuHenko;
    }

    /**
     * コンストラクタです。
     *
     * @return IValidationMessages
     */
//    public ShikakuHenkoValidator(FlexibleDate 変更日, FlexibleDate 取得日, FlexibleDate 喪失日, RString 変更事由,
//            FlexibleDate 最新資格取得日, FlexibleDate 最新資格喪失日, FlexibleDate 最新資格更新日, FlexibleDate 一号資格取得日) {
//
//        this.変更日 = 変更日;
//        this.取得日 = 取得日;
//        this.喪失日 = 喪失日;
//        this.変更事由 = 変更事由;
//        this.最新資格取得日 = 最新資格取得日;
//        this.最新資格喪失日 = 最新資格喪失日;
//        this.一号資格取得日 = 一号資格取得日;
//        this.最新資格変更日 = 最新資格更新日;
//    }
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        messages.add(
                ValidateChain.validateStart(nothing)
                .ifNot(ShikakuHenkoSpec.変更日が入力であること)
                .thenAdd(ShikakuHenkoValidationMessage.変更日が未入力)
                .ifNot(ShikakuHenkoSpec.変更事由が入力であること)
                .thenAdd(ShikakuHenkoValidationMessage.変更事由が未入力)
                .ifNot(ShikakuHenkoSpec.取得日が変更日より前)
                .thenAdd(ShikakuHenkoValidationMessage.取得日より前)
                .ifNot(ShikakuHenkoSpec.喪失日が変更日より後)
                .thenAdd(ShikakuHenkoValidationMessage.喪失日より後)
                .ifNot(ShikakuHenkoSpec.変更日が次の履歴データの変更日以降)
                .thenAdd(ShikakuHenkoValidationMessage.変更日と次の履歴データの変更日の期間が重複)
                .ifNot(ShikakuHenkoSpec.変更日が前の履歴データの変更日以降)
                .thenAdd(ShikakuHenkoValidationMessage.変更日と前の履歴データの変更日の期間が重複)
                .ifNot(ShikakuHenkoSpec.has住所地特例履歴と期間が重複する履歴)
                .thenAdd(ShikakuHenkoValidationMessage.変更日と住所地特例履歴の期間が重複する履歴がある)
                .ifNot(ShikakuHenkoSpec.is最新の取得日として登録不可)
                .thenAdd(ShikakuHenkoValidationMessage.最新の取得日として登録不可)
                .ifNot(ShikakuHenkoSpec.変更事由が１号到達で年齢が65歳未満)
                .thenAdd(ShikakuHenkoValidationMessage.変更事由が１号到達で年齢が65歳未満)
                .messages());
        return messages;
    }
}
