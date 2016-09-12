/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.validations.validator.custom;

import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.ShikakuHenkoRirekiKanriContext;
import jp.co.ndensan.reams.db.dbz.business.core.validation.ShikakuHenkoValidationMessage;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatableWithContext;
import jp.co.ndensan.reams.uz.uza.core.validation.OrderValidator;
import jp.co.ndensan.reams.uz.uza.core.validation.PresenceValidator;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 介護資格変更のバリデーションクラスです。
 *
 * @author N8235 船山 洋介
 */
public class ShikakuHenkoValidator implements IValidatableWithContext<ShikakuHenkoRirekiKanriContext> {

    private final FlexibleDate 変更日;
    private final FlexibleDate 取得日;
    private final FlexibleDate 喪失日;
    private final RString 変更事由;
    private final FlexibleDate 最新資格取得日;
    private final FlexibleDate 最新資格喪失日;
    private final FlexibleDate 一号資格取得日;
    private final FlexibleDate 最新資格変更日;

    /**
     * コンストラクタです。
     *
     * @param 変更日 変更日
     * @param 取得日 取得日
     * @param 喪失日 喪失日
     * @param 変更事由 変更事由
     * @param 最新資格取得日 最新資格取得日
     * @param 最新資格喪失日 最新資格喪失日
     * @param 最新資格更新日 最新資格更新日
     * @param 一号資格取得日 一号資格取得日
     */
    public ShikakuHenkoValidator(FlexibleDate 変更日, FlexibleDate 取得日, FlexibleDate 喪失日, RString 変更事由,
            FlexibleDate 最新資格取得日, FlexibleDate 最新資格喪失日, FlexibleDate 最新資格更新日, FlexibleDate 一号資格取得日) {

        this.変更日 = 変更日;
        this.取得日 = 取得日;
        this.喪失日 = 喪失日;
        this.変更事由 = 変更事由;
        this.最新資格取得日 = 最新資格取得日;
        this.最新資格喪失日 = 最新資格喪失日;
        this.一号資格取得日 = 一号資格取得日;
        this.最新資格変更日 = 最新資格更新日;
    }

    @Override
    public IValidationMessages validateIn(ShikakuHenkoRirekiKanriContext context) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        if (!PresenceValidator.isValid(変更日)) {
            messages.add(ShikakuHenkoValidationMessage.変更日が未入力);
        }

        if (!PresenceValidator.isValid(変更事由)) {
            messages.add(ShikakuHenkoValidationMessage.変更事由が未入力);
        }

        if (is取得日が変更日より前()) {
            messages.add(ShikakuHenkoValidationMessage.取得日より前);
        }

        if (is喪失日が変更日より後()) {
            messages.add(ShikakuHenkoValidationMessage.喪失日より後);
        }

        if (!context.shouldSkipValidation(ShikakuHenkoValidationMessage.変更日と次の履歴データの変更日の期間が重複)
                && is変更日が次の履歴データの変更日と重複(context.get次履歴())) {
            messages.add(ShikakuHenkoValidationMessage.変更日と次の履歴データの変更日の期間が重複);
        }

        if (!context.shouldSkipValidation(ShikakuHenkoValidationMessage.変更日と前の履歴データの変更日の期間が重複)
                && is変更日が前の履歴データの変更日と重複(context.get前履歴())) {

            messages.add(ShikakuHenkoValidationMessage.変更日と前の履歴データの変更日の期間が重複);
        }

        if (!context.shouldSkipValidation(ShikakuHenkoValidationMessage.変更日と住所地特例履歴の期間が重複する履歴がある)
                && has住所地特例履歴と期間が重複する履歴In(context.get全履歴())) {

            messages.add(ShikakuHenkoValidationMessage.変更日と住所地特例履歴の期間が重複する履歴がある);
        }

        if (!context.shouldSkipValidation(ShikakuHenkoValidationMessage.最新の取得日として登録不可)) {

            if (is最新の取得日として登録不可(最新資格変更日, 最新資格喪失日, 最新資格取得日)) {
                messages.add(ShikakuHenkoValidationMessage.最新の取得日として登録不可);
            }

            if (!context.shouldSkipValidation(ShikakuHenkoValidationMessage.変更事由が１号到達で年齢が65歳未満) && 変更日.equals(一号資格取得日)) {
                messages.add(ShikakuHenkoValidationMessage.変更事由が１号到達で年齢が65歳未満);
            }
        }
        return messages;

    }

    private boolean is最新の取得日として登録不可(FlexibleDate 最新変更日, FlexibleDate 最新喪失日, FlexibleDate 最新取得日) {
        if (最新資格喪失日.isEmpty()) {

            if (変更日.isBefore(最新変更日)) {
                return true;
            }

        } else {
            if (!最新変更日.isBeforeOrEquals(最新喪失日)) {
                return true;
            }
        }
        if (最新変更日.isBefore(最新取得日)) {
            return true;
        }
        return false;
    }

    private boolean is取得日が変更日より前() {
        if (変更日.isEmpty() || 取得日.isEmpty()) {
            return false;
        }
        return 変更日.isBefore(取得日);
    }

    private boolean is喪失日が変更日より後() {
        if (喪失日.isEmpty() || 取得日.isEmpty()) {
            return false;
        }
        return !変更日.isBefore(喪失日);
    }

    private boolean is変更日が前の履歴データの変更日と重複(Optional<DbT1001HihokenshaDaichoEntity> optional) {
        DbT1001HihokenshaDaichoEntity 前履歴 = optional.orElse(null);

        if (前履歴 == null || 変更日.isEmpty()) {
            return false;
        }
        FlexibleDate shikakuHenkoYMD = 前履歴.getShikakuHenkoYMD();
        if (shikakuHenkoYMD == null) {
            return false;
        }
        return !shikakuHenkoYMD.isBefore(変更日);
    }

    private boolean is変更日が次の履歴データの変更日と重複(Optional<DbT1001HihokenshaDaichoEntity> optional) {
        DbT1001HihokenshaDaichoEntity 次履歴 = optional.orElse(null);

        if (次履歴 == null || 変更日.isEmpty()) {
            return false;
        }
        FlexibleDate shikakuHenkoYMD = 次履歴.getShikakuHenkoYMD();
        if (shikakuHenkoYMD == null) {
            return false;
        }
        return shikakuHenkoYMD.isBefore(変更日);
    }

    private boolean has住所地特例履歴と期間が重複する履歴In(IItemList<DbT1001HihokenshaDaichoEntity> list) {
        if (変更日.isEmpty()) {
            return false;
        }
        for (DbT1001HihokenshaDaichoEntity model : list) {
            FlexibleDate shikakuShutokuYMD = model.getShikakuShutokuYMD();
            FlexibleDate shikakuSoshitsuYMD = model.getShikakuSoshitsuYMD();
            if ((shikakuShutokuYMD == null || shikakuShutokuYMD.isEmpty())
                    || (shikakuSoshitsuYMD == null || shikakuSoshitsuYMD.isEmpty())) {
                return false;
            }
            if (OrderValidator.from(model.getShikakuShutokuYMD()).afterOrEquals(変更日).after(model.getShikakuSoshitsuYMD()).isValid()) {
                return true;
            }
        }
        return false;
    }
}
