/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
//mport jp.co.ndensan.reams.fc.dbz.model.validations.validators.DzValidationMessage;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatable;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidatableWithContext;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessages;
import jp.co.ndensan.reams.ur.urz.model.validations.ValidationMessagesFactory;
import jp.co.ndensan.reams.ur.urz.model.validations.validators.OrderValidator;
import jp.co.ndensan.reams.ur.urz.model.validations.validators.PresenceValidator;

/**
 * 介護保険施設入退所のモデルクラスです。
 *
 * @author n8223 朴義一
 */
public class ShisetsuNyutaishoModel implements Serializable, IValidatable, IValidatableWithContext<ShisetsuNyutaishoRirekiKanriContext> {

    private DbT1004ShisetsuNyutaishoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoModel() {
        entity = new DbT1004ShisetsuNyutaishoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     */
    public ShisetsuNyutaishoModel(DbT1004ShisetsuNyutaishoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを返します。
     *
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    public DbT1004ShisetsuNyutaishoEntity getEntity() {
        return entity;
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを設定します。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     */
    public void setEntity(DbT1004ShisetsuNyutaishoEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類を返します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public RString get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所処理年月日を返します。
     *
     * @return 入所処理年月日
     */
    public FlexibleDate get入所処理年月日() {
        return entity.getNyushoShoriYMD();
    }

    /**
     * 退所処理年月日を返します。
     *
     * @return 退所処理年月日
     */
    public FlexibleDate get退所処理年月日() {
        return entity.getTaishoShoriYMD();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 台帳種別を設定します。
     *
     * @param 台帳種別 台帳種別
     */
    public void set台帳種別(RString 台帳種別) {
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        entity.setDaichoShubetsu(台帳種別);
    }

    /**
     * 入所施設種類を設定します。
     *
     * @param 入所施設種類 入所施設種類
     */
    public void set入所施設種類(RString 入所施設種類) {
        requireNonNull(入所施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設種類"));
        entity.setNyushoShisetsuShurui(入所施設種類);
    }

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     */
    public void set入所施設コード(RString 入所施設コード) {
        requireNonNull(入所施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        entity.setNyushoShisetsuCode(入所施設コード);
    }

    /**
     * 入所年月日を設定します。
     *
     * @param 入所年月日 入所年月日
     */
    public void set入所年月日(FlexibleDate 入所年月日) {
        requireNonNull(入所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所年月日"));
        entity.setNyushoYMD(入所年月日);
    }

    /**
     * 退所年月日を設定します。
     *
     * @param 退所年月日 退所年月日
     */
    public void set退所年月日(FlexibleDate 退所年月日) {
        requireNonNull(退所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所年月日"));
        entity.setTaishoYMD(退所年月日);
    }

    /**
     * 入所処理年月日を設定します。
     *
     * @param 入所処理年月日 入所処理年月日
     */
    public void set入所処理年月日(FlexibleDate 入所処理年月日) {
        requireNonNull(入所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所処理年月日"));
        entity.setNyushoShoriYMD(入所処理年月日);
    }

    /**
     * 退所処理年月日を設定します。
     *
     * @param 退所処理年月日 退所処理年月日
     */
    public void set退所処理年月日(FlexibleDate 退所処理年月日) {
        requireNonNull(退所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所処理年月日"));
        entity.setTaishoShoriYMD(退所処理年月日);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        return messages;
    }

    @Override
    public IValidationMessages validateIn(ShisetsuNyutaishoRirekiKanriContext context) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();

        if (PresenceValidator.isInvalid(this.get入所年月日())) {
            messages.add(ShisetsuNyutaishoValidationMessage.入所日が未入力, "必須項目の入所日が未入力 ");
        }

        if (PresenceValidator.isInvalid(this.get入所施設コード())) {
            messages.add(ShisetsuNyutaishoValidationMessage.入所施設が未入力, "必須項目の入所施設が未入力 ");
        }

        if (is退所日が入所日より前()) {
            messages.add(ShisetsuNyutaishoValidationMessage.入所年月日より前, "退所年月日" + this.get退所年月日() + "が入所年月日" + this.get入所年月日() + "以降でない");
        }
        if (!context.shouldSkipValidation(ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複)) {
            if (is入所日が前の履歴データの退所日と重複(context.get前履歴())) {
                messages.add(ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複, "入所年月日" + this.get入所年月日() + "と前の履歴データの退所日と重複");
            }
        }
        if (!context.shouldSkipValidation(ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複)) {
            if (is退所日が次の履歴データの入所日と重複(context.get次履歴())) {
                messages.add(ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複, "退所年月日" + this.get退所年月日() + "次の履歴データの入所日の期間が重複");
            }
        }
        if (!context.shouldSkipValidation(ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある)) {

            IItemList<ShisetsuNyutaishoModel> list = context.get全履歴();
            boolean flg = Boolean.FALSE;

            for (ShisetsuNyutaishoModel model : list) {
                if (model.get退所年月日().isEmpty()) {
                    messages.add(ShisetsuNyutaishoValidationMessage.終了日設定なし);
                    flg = Boolean.TRUE;
                }
            }

            if (!flg) {
                if (has入所日と期間が重複する履歴In(context.get全履歴())) {
                    messages.add(ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある, "入所年月日" + this.get入所年月日() + "と期間が重複する履歴がある");

                }
            }
        }
        if (!context.shouldSkipValidation(ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある)) {
            if (has退所日と期間が重複する履歴In(context.get全履歴())) {
                messages.add(ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある, "退所年月日" + this.get退所年月日() + "と期間が重複する履歴がある");
            }
        }
        return messages;
    }

    private boolean is退所日が入所日より前() {
        if (get入所年月日().isEmpty() || get退所年月日().isEmpty()) {
            return false;
        }

        return get退所年月日().isBefore(get入所年月日());
    }

    private boolean is入所日が前の履歴データの退所日と重複(IOptional<ShisetsuNyutaishoModel> optional) {
        ShisetsuNyutaishoModel 前履歴 = optional.orElse(null);
        if (前履歴 == null || get入所年月日().isEmpty() || get入所年月日() == null) {

            return false;
        }

//        return !前履歴.get退所年月日().isBefore(get入所年月日());
        return !前履歴.get退所年月日().isBeforeOrEquals(get入所年月日());

    }

    private boolean is退所日が次の履歴データの入所日と重複(IOptional<ShisetsuNyutaishoModel> 次履歴) {
        if (!次履歴.isPresent() || get退所年月日().isEmpty() || get退所年月日() == null) {
            return false;
        }
//        return !get退所年月日().isBefore(次履歴.get().get入所年月日());
        return !get退所年月日().isBeforeOrEquals(次履歴.get().get入所年月日());
    }

    private boolean has入所日と期間が重複する履歴In(IItemList<ShisetsuNyutaishoModel> list) {
        if (this.get入所年月日().isEmpty()) {
            return false;
        }
        for (ShisetsuNyutaishoModel model : list) {
            if (model.get退所年月日().isEmpty()) {
                return false;
            }
//            if (OrderValidator.from(model.get入所年月日()).afterOrEquals(this.get入所年月日()).afterOrEquals(model.get退所年月日()).isValid()) {
//                return true;
//            }
            if (OrderValidator.from(model.get入所年月日()).afterOrEquals(this.get入所年月日()).after(model.get退所年月日()).isValid()) {
                return true;
            }
        }
        return false;
    }

    private boolean has退所日と期間が重複する履歴In(IItemList<ShisetsuNyutaishoModel> list) {
        if (this.get退所年月日().isEmpty()) {
            return false;
        }
        for (ShisetsuNyutaishoModel model : list) {
            if (model.get退所年月日().isEmpty()) {
                return false;
            }
            if (OrderValidator.from(model.get入所年月日()).afterOrEquals(this.get退所年月日()).afterOrEquals(model.get退所年月日()).isValid()) {
                return true;
            }
        }
        return false;
    }
}
