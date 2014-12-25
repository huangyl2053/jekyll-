/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3092KyufuhiKashitsukeKinChoshuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金徴収のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukeKinChoshuModel implements Serializable {

    private DbT3092KyufuhiKashitsukeKinChoshuEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinChoshuModel() {
        entity = new DbT3092KyufuhiKashitsukeKinChoshuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3092KyufuhiKashitsukeKinChoshuEntity
     */
    public KyufuhiKashitsukeKinChoshuModel(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3092KyufuhiKashitsukeKinChoshuEntityを返します。
     *
     * @return DbT3092KyufuhiKashitsukeKinChoshuEntity
     */
    public DbT3092KyufuhiKashitsukeKinChoshuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3092KyufuhiKashitsukeKinChoshuEntityを設定します。
     *
     * @param entity DbT3092KyufuhiKashitsukeKinChoshuEntity
     */
    public void setEntity(DbT3092KyufuhiKashitsukeKinChoshuEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 貸付管理番号を返します。
     *
     * @return 貸付管理番号
     */
    public RString get貸付管理番号() {
        return entity.getKashitsukeKanriNo();
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
     * 貸付金返還徴収方法を返します。
     *
     * @return 貸付金返還徴収方法
     */
    public RString get貸付金返還徴収方法() {
        return entity.getHenkanChoshuHoho();
    }

    /**
     * 貸付金返還徴収年月日を返します。
     *
     * @return 貸付金返還徴収年月日
     */
    public FlexibleDate get貸付金返還徴収年月日() {
        return entity.getHenkanChoshuYMD();
    }

    /**
     * 貸付金返還徴収金額を返します。
     *
     * @return 貸付金返還徴収金額
     */
    public Decimal get貸付金返還徴収金額() {
        return entity.getHenkanChoshuKingaku();
    }

    /**
     * 過不足判定結果区分を返します。
     *
     * @return 過不足判定結果区分
     */
    public RString get過不足判定結果区分() {
        return entity.getKabusokuHanteiKekkaKubun();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 貸付管理番号を設定します。
     *
     * @param 貸付管理番号 貸付管理番号
     */
    public void set貸付管理番号(RString 貸付管理番号) {
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        entity.setKashitsukeKanriNo(貸付管理番号);
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
     * 貸付金返還徴収方法を設定します。
     *
     * @param 貸付金返還徴収方法 貸付金返還徴収方法
     */
    public void set貸付金返還徴収方法(RString 貸付金返還徴収方法) {
        requireNonNull(貸付金返還徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収方法"));
        entity.setHenkanChoshuHoho(貸付金返還徴収方法);
    }

    /**
     * 貸付金返還徴収年月日を設定します。
     *
     * @param 貸付金返還徴収年月日 貸付金返還徴収年月日
     */
    public void set貸付金返還徴収年月日(FlexibleDate 貸付金返還徴収年月日) {
        requireNonNull(貸付金返還徴収年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収年月日"));
        entity.setHenkanChoshuYMD(貸付金返還徴収年月日);
    }

    /**
     * 貸付金返還徴収金額を設定します。
     *
     * @param 貸付金返還徴収金額 貸付金返還徴収金額
     */
    public void set貸付金返還徴収金額(Decimal 貸付金返還徴収金額) {
        requireNonNull(貸付金返還徴収金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金返還徴収金額"));
        entity.setHenkanChoshuKingaku(貸付金返還徴収金額);
    }

    /**
     * 過不足判定結果区分を設定します。
     *
     * @param 過不足判定結果区分 過不足判定結果区分
     */
    public void set過不足判定結果区分(RString 過不足判定結果区分) {
        requireNonNull(過不足判定結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("過不足判定結果区分"));
        entity.setKabusokuHanteiKekkaKubun(過不足判定結果区分);
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
