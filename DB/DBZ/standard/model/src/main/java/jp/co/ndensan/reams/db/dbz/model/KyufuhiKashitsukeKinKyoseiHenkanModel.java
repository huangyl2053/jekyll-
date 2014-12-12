/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金強制返還のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KyufuhiKashitsukeKinKyoseiHenkanModel implements Serializable {

    private DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinKyoseiHenkanModel() {
        entity = new DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity
     */
    public KyufuhiKashitsukeKinKyoseiHenkanModel(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityを返します。
     *
     * @return DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity
     */
    public DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntityを設定します。
     *
     * @param entity DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity
     */
    public void setEntity(DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity) {
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
     * 返還金区分を返します。
     *
     * @return 返還金区分
     */
    public RString get返還金区分() {
        return entity.getHenkanKinKubun();
    }

    /**
     * 返還金額を返します。
     *
     * @return 返還金額
     */
    public Decimal get返還金額() {
        return entity.getHenkanKingaku();
    }

    /**
     * 返還期限を返します。
     *
     * @return 返還期限
     */
    public FlexibleDate get返還期限() {
        return entity.getHenkanKigenYMD();
    }

    /**
     * 返還理由を返します。
     *
     * @return 返還理由
     */
    public RString get返還理由() {
        return entity.getHenkanRiyu();
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
     * 返還金区分を設定します。
     *
     * @param 返還金区分 返還金区分
     */
    public void set返還金区分(RString 返還金区分) {
        requireNonNull(返還金区分, UrSystemErrorMessages.値がnull.getReplacedMessage("返還金区分"));
        entity.setHenkanKinKubun(返還金区分);
    }

    /**
     * 返還金額を設定します。
     *
     * @param 返還金額 返還金額
     */
    public void set返還金額(Decimal 返還金額) {
        requireNonNull(返還金額, UrSystemErrorMessages.値がnull.getReplacedMessage("返還金額"));
        entity.setHenkanKingaku(返還金額);
    }

    /**
     * 返還期限を設定します。
     *
     * @param 返還期限 返還期限
     */
    public void set返還期限(FlexibleDate 返還期限) {
        requireNonNull(返還期限, UrSystemErrorMessages.値がnull.getReplacedMessage("返還期限"));
        entity.setHenkanKigenYMD(返還期限);
    }

    /**
     * 返還理由を設定します。
     *
     * @param 返還理由 返還理由
     */
    public void set返還理由(RString 返還理由) {
        requireNonNull(返還理由, UrSystemErrorMessages.値がnull.getReplacedMessage("返還理由"));
        entity.setHenkanRiyu(返還理由);
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
