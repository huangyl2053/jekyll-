/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村特別給付サービス内容のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShichosonTokubetuKyufuServiceModel implements Serializable {

    private DbT3066ShichosonTokubetuKyufuServiceEntity entity;

    /**
     * コンストラクタです。
     */
    public ShichosonTokubetuKyufuServiceModel() {
        entity = new DbT3066ShichosonTokubetuKyufuServiceEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3066ShichosonTokubetuKyufuServiceEntity
     */
    public ShichosonTokubetuKyufuServiceModel(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3066ShichosonTokubetuKyufuServiceEntityを返します。
     *
     * @return DbT3066ShichosonTokubetuKyufuServiceEntity
     */
    public DbT3066ShichosonTokubetuKyufuServiceEntity getEntity() {
        return entity;
    }

    /**
     * DbT3066ShichosonTokubetuKyufuServiceEntityを設定します。
     *
     * @param entity DbT3066ShichosonTokubetuKyufuServiceEntity
     */
    public void setEntity(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村特別給付用サービスコードを返します。
     *
     * @return 市町村特別給付用サービスコード
     */
    public RString get市町村特別給付用サービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日を返します。
     *
     * @return 市町村特別給付用サービス有効期間開始年月日
     */
    public FlexibleDate get市町村特別給付用サービス有効期間開始年月日() {
        return entity.getServiceYukoKikanKaishiYMD();
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
     * 市町村特別給付用サービス名_正式名称を返します。
     *
     * @return 市町村特別給付用サービス名_正式名称
     */
    public RString get市町村特別給付用サービス名_正式名称() {
        return entity.getServiceSeishikiName();
    }

    /**
     * 市町村特別給付用サービス名_略称を返します。
     *
     * @return 市町村特別給付用サービス名_略称
     */
    public RString get市町村特別給付用サービス名_略称() {
        return entity.getServiceRyakushoName();
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日を返します。
     *
     * @return 市町村特別給付用サービス有効期間終了年月日
     */
    public FlexibleDate get市町村特別給付用サービス有効期間終了年月日() {
        return entity.getServiceYukoKikanShuryoYMD();
    }

    /**
     * 市町村特別給付用サービス区分を返します。
     *
     * @return 市町村特別給付用サービス区分
     */
    public RString get市町村特別給付用サービス区分() {
        return entity.getServiceKubun();
    }

    /**
     * 市町村特別給付用単位_日数を返します。
     *
     * @return 市町村特別給付用単位_日数
     */
    public Decimal get市町村特別給付用単位_日数() {
        return entity.getTanisuNissu();
    }

    /**
     * 市町村特別給付用支給限度基準額を返します。
     *
     * @return 市町村特別給付用支給限度基準額
     */
    public Decimal get市町村特別給付用支給限度基準額() {
        return entity.getShikyuGendoKijungaku();
    }

    /**
     * 市町村特別給付用給付率引下有フラグを返します。
     *
     * @return 市町村特別給付用給付率引下有フラグ
     */
    public boolean get市町村特別給付用給付率引下有フラグ() {
        return entity.getKyufuritsuHikisageAriFlag();
    }

    /**
     * 登録年月日を返します。
     *
     * @return 登録年月日
     */
    public FlexibleDate get登録年月日() {
        return entity.getTorokuYMD();
    }

    /**
     * 変更年月日を返します。
     *
     * @return 変更年月日
     */
    public FlexibleDate get変更年月日() {
        return entity.getHenkoYMD();
    }

    /**
     * 市町村特別給付用サービスコードを設定します。
     *
     * @param 市町村特別給付用サービスコード 市町村特別給付用サービスコード
     */
    public void set市町村特別給付用サービスコード(RString 市町村特別給付用サービスコード) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        entity.setServiceCode(市町村特別給付用サービスコード);
    }

    /**
     * 市町村特別給付用サービス有効期間開始年月日を設定します。
     *
     * @param 市町村特別給付用サービス有効期間開始年月日 市町村特別給付用サービス有効期間開始年月日
     */
    public void set市町村特別給付用サービス有効期間開始年月日(FlexibleDate 市町村特別給付用サービス有効期間開始年月日) {
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        entity.setServiceYukoKikanKaishiYMD(市町村特別給付用サービス有効期間開始年月日);
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
     * 市町村特別給付用サービス名_正式名称を設定します。
     *
     * @param 市町村特別給付用サービス名_正式名称 市町村特別給付用サービス名_正式名称
     */
    public void set市町村特別給付用サービス名_正式名称(RString 市町村特別給付用サービス名_正式名称) {
        requireNonNull(市町村特別給付用サービス名_正式名称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス名_正式名称"));
        entity.setServiceSeishikiName(市町村特別給付用サービス名_正式名称);
    }

    /**
     * 市町村特別給付用サービス名_略称を設定します。
     *
     * @param 市町村特別給付用サービス名_略称 市町村特別給付用サービス名_略称
     */
    public void set市町村特別給付用サービス名_略称(RString 市町村特別給付用サービス名_略称) {
        requireNonNull(市町村特別給付用サービス名_略称, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス名_略称"));
        entity.setServiceRyakushoName(市町村特別給付用サービス名_略称);
    }

    /**
     * 市町村特別給付用サービス有効期間終了年月日を設定します。
     *
     * @param 市町村特別給付用サービス有効期間終了年月日 市町村特別給付用サービス有効期間終了年月日
     */
    public void set市町村特別給付用サービス有効期間終了年月日(FlexibleDate 市町村特別給付用サービス有効期間終了年月日) {
        requireNonNull(市町村特別給付用サービス有効期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間終了年月日"));
        entity.setServiceYukoKikanShuryoYMD(市町村特別給付用サービス有効期間終了年月日);
    }

    /**
     * 市町村特別給付用サービス区分を設定します。
     *
     * @param 市町村特別給付用サービス区分 市町村特別給付用サービス区分
     */
    public void set市町村特別給付用サービス区分(RString 市町村特別給付用サービス区分) {
        requireNonNull(市町村特別給付用サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス区分"));
        entity.setServiceKubun(市町村特別給付用サービス区分);
    }

    /**
     * 市町村特別給付用単位_日数を設定します。
     *
     * @param 市町村特別給付用単位_日数 市町村特別給付用単位_日数
     */
    public void set市町村特別給付用単位_日数(Decimal 市町村特別給付用単位_日数) {
        requireNonNull(市町村特別給付用単位_日数, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用単位_日数"));
        entity.setTanisuNissu(市町村特別給付用単位_日数);
    }

    /**
     * 市町村特別給付用支給限度基準額を設定します。
     *
     * @param 市町村特別給付用支給限度基準額 市町村特別給付用支給限度基準額
     */
    public void set市町村特別給付用支給限度基準額(Decimal 市町村特別給付用支給限度基準額) {
        requireNonNull(市町村特別給付用支給限度基準額, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用支給限度基準額"));
        entity.setShikyuGendoKijungaku(市町村特別給付用支給限度基準額);
    }

    /**
     * 市町村特別給付用給付率引下有フラグを設定します。
     *
     * @param 市町村特別給付用給付率引下有フラグ 市町村特別給付用給付率引下有フラグ
     */
    public void set市町村特別給付用給付率引下有フラグ(boolean 市町村特別給付用給付率引下有フラグ) {
        requireNonNull(市町村特別給付用給付率引下有フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用給付率引下有フラグ"));
        entity.setKyufuritsuHikisageAriFlag(市町村特別給付用給付率引下有フラグ);
    }

    /**
     * 登録年月日を設定します。
     *
     * @param 登録年月日 登録年月日
     */
    public void set登録年月日(FlexibleDate 登録年月日) {
        requireNonNull(登録年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録年月日"));
        entity.setTorokuYMD(登録年月日);
    }

    /**
     * 変更年月日を設定します。
     *
     * @param 変更年月日 変更年月日
     */
    public void set変更年月日(FlexibleDate 変更年月日) {
        requireNonNull(変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更年月日"));
        entity.setHenkoYMD(変更年月日);
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
}
