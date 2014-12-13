/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護第三者行為給付額減額のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DaisanshaKoiKyufugakuGengakuModel implements Serializable {

    private DbT3081DaisanshaKoiKyufugakuGengakuEntity entity;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiKyufugakuGengakuModel() {
        entity = new DbT3081DaisanshaKoiKyufugakuGengakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3081DaisanshaKoiKyufugakuGengakuEntity
     */
    public DaisanshaKoiKyufugakuGengakuModel(DbT3081DaisanshaKoiKyufugakuGengakuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3081DaisanshaKoiKyufugakuGengakuEntityを返します。
     *
     * @return DbT3081DaisanshaKoiKyufugakuGengakuEntity
     */
    public DbT3081DaisanshaKoiKyufugakuGengakuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3081DaisanshaKoiKyufugakuGengakuEntityを設定します。
     *
     * @param entity DbT3081DaisanshaKoiKyufugakuGengakuEntity
     */
    public void setEntity(DbT3081DaisanshaKoiKyufugakuGengakuEntity entity) {
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
     * 第三者行為届出管理番号を返します。
     *
     * @return 第三者行為届出管理番号
     */
    public RString get第三者行為届出管理番号() {
        return entity.getTodokedeKanriNo();
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
     * 減額対象金額を返します。
     *
     * @return 減額対象金額
     */
    public Decimal get減額対象金額() {
        return entity.getGengakuTaishoKingaku();
    }

    /**
     * 給付額減額期間開始年月日を返します。
     *
     * @return 給付額減額期間開始年月日
     */
    public FlexibleDate get給付額減額期間開始年月日() {
        return entity.getGengakuKaishiYMD();
    }

    /**
     * 給付額減額期間終了年月日を返します。
     *
     * @return 給付額減額期間終了年月日
     */
    public FlexibleDate get給付額減額期間終了年月日() {
        return entity.getGengakuShuryoYMD();
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
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     */
    public void set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
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
     * 減額対象金額を設定します。
     *
     * @param 減額対象金額 減額対象金額
     */
    public void set減額対象金額(Decimal 減額対象金額) {
        requireNonNull(減額対象金額, UrSystemErrorMessages.値がnull.getReplacedMessage("減額対象金額"));
        entity.setGengakuTaishoKingaku(減額対象金額);
    }

    /**
     * 給付額減額期間開始年月日を設定します。
     *
     * @param 給付額減額期間開始年月日 給付額減額期間開始年月日
     */
    public void set給付額減額期間開始年月日(FlexibleDate 給付額減額期間開始年月日) {
        requireNonNull(給付額減額期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額期間開始年月日"));
        entity.setGengakuKaishiYMD(給付額減額期間開始年月日);
    }

    /**
     * 給付額減額期間終了年月日を設定します。
     *
     * @param 給付額減額期間終了年月日 給付額減額期間終了年月日
     */
    public void set給付額減額期間終了年月日(FlexibleDate 給付額減額期間終了年月日) {
        requireNonNull(給付額減額期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額減額期間終了年月日"));
        entity.setGengakuShuryoYMD(給付額減額期間終了年月日);
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
