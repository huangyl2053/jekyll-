/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金延滞利息計算のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukekinEntaiRisokuKeisanModel implements Serializable {

    private DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanModel() {
        entity = new DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanModel(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityを返します。
     *
     * @return DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity
     */
    public DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity getEntity() {
        return entity;
    }

    /**
     * DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntityを設定します。
     *
     * @param entity DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity
     */
    public void setEntity(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity) {
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
     * 貸付金延滞日数を返します。
     *
     * @return 貸付金延滞日数
     */
    public RString get貸付金延滞日数() {
        return entity.getEntaiNissu();
    }

    /**
     * 貸付金延滞利息金額を返します。
     *
     * @return 貸付金延滞利息金額
     */
    public Decimal get貸付金延滞利息金額() {
        return entity.getEntaiRisokuKingaku();
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
     * 貸付金延滞日数を設定します。
     *
     * @param 貸付金延滞日数 貸付金延滞日数
     */
    public void set貸付金延滞日数(RString 貸付金延滞日数) {
        requireNonNull(貸付金延滞日数, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金延滞日数"));
        entity.setEntaiNissu(貸付金延滞日数);
    }

    /**
     * 貸付金延滞利息金額を設定します。
     *
     * @param 貸付金延滞利息金額 貸付金延滞利息金額
     */
    public void set貸付金延滞利息金額(Decimal 貸付金延滞利息金額) {
        requireNonNull(貸付金延滞利息金額, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付金延滞利息金額"));
        entity.setEntaiRisokuKingaku(貸付金延滞利息金額);
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
