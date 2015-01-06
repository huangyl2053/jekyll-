/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2008ShotokuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護所得のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class ShotokuModel implements Serializable {

    private DbT2008ShotokuEntity entity;

    /**
     * コンストラクタです。
     */
    public ShotokuModel() {
        entity = new DbT2008ShotokuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2008ShotokuEntity
     */
    public ShotokuModel(DbT2008ShotokuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2008ShotokuEntityを返します。
     *
     * @return DbT2008ShotokuEntity
     */
    public DbT2008ShotokuEntity getEntity() {
        return entity;
    }

    /**
     * DbT2008ShotokuEntityを設定します。
     *
     * @param entity DbT2008ShotokuEntity
     */
    public void setEntity(DbT2008ShotokuEntity entity) {
        this.entity = entity;
    }

    /**
     * 所得年度を返します。
     *
     * @return 所得年度
     */
    public FlexibleYear get所得年度() {
        return entity.getShotokuNendo();
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 非課税区分_住民税減免前を返します。
     *
     * @return 非課税区分_住民税減免前
     */
    public RString get非課税区分_住民税減免前() {
        return entity.getHiKazeiKubun();
    }

    /**
     * 非課税区分_住民税減免後を返します。
     *
     * @return 非課税区分_住民税減免後
     */
    public RString get非課税区分_住民税減免後() {
        return entity.getHiKazeiKubunGemmenGo();
    }

    /**
     * 合計所得金額を返します。
     *
     * @return 合計所得金額
     */
    public Decimal get合計所得金額() {
        return entity.getGokeiShotokuGaku();
    }

    /**
     * 公的年金収入額を返します。
     *
     * @return 公的年金収入額
     */
    public Decimal get公的年金収入額() {
        return entity.getNenkiniShunyuGaku();
    }

    /**
     * 激変緩和措置区分を返します。
     *
     * @return 激変緩和措置区分
     */
    public RString get激変緩和措置区分() {
        return entity.getGekihenKanwaKubun();
    }

    /**
     * 所得年度を設定します。
     *
     * @param 所得年度 所得年度
     */
    public void set所得年度(FlexibleYear 所得年度) {
        requireNonNull(所得年度, UrSystemErrorMessages.値がnull.getReplacedMessage("所得年度"));
        entity.setShotokuNendo(所得年度);
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
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     */
    public void set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
    }

    /**
     * 非課税区分_住民税減免前を設定します。
     *
     * @param 非課税区分_住民税減免前 非課税区分_住民税減免前
     */
    public void set非課税区分_住民税減免前(RString 非課税区分_住民税減免前) {
        requireNonNull(非課税区分_住民税減免前, UrSystemErrorMessages.値がnull.getReplacedMessage("非課税区分_住民税減免前"));
        entity.setHiKazeiKubun(非課税区分_住民税減免前);
    }

    /**
     * 非課税区分_住民税減免後を設定します。
     *
     * @param 非課税区分_住民税減免後 非課税区分_住民税減免後
     */
    public void set非課税区分_住民税減免後(RString 非課税区分_住民税減免後) {
        requireNonNull(非課税区分_住民税減免後, UrSystemErrorMessages.値がnull.getReplacedMessage("非課税区分_住民税減免後"));
        entity.setHiKazeiKubunGemmenGo(非課税区分_住民税減免後);
    }

    /**
     * 合計所得金額を設定します。
     *
     * @param 合計所得金額 合計所得金額
     */
    public void set合計所得金額(Decimal 合計所得金額) {
        requireNonNull(合計所得金額, UrSystemErrorMessages.値がnull.getReplacedMessage("合計所得金額"));
        entity.setGokeiShotokuGaku(合計所得金額);
    }

    /**
     * 公的年金収入額を設定します。
     *
     * @param 公的年金収入額 公的年金収入額
     */
    public void set公的年金収入額(Decimal 公的年金収入額) {
        requireNonNull(公的年金収入額, UrSystemErrorMessages.値がnull.getReplacedMessage("公的年金収入額"));
        entity.setNenkiniShunyuGaku(公的年金収入額);
    }

    /**
     * 激変緩和措置区分を設定します。
     *
     * @param 激変緩和措置区分 激変緩和措置区分
     */
    public void set激変緩和措置区分(RString 激変緩和措置区分) {
        requireNonNull(激変緩和措置区分, UrSystemErrorMessages.値がnull.getReplacedMessage("激変緩和措置区分"));
        entity.setGekihenKanwaKubun(激変緩和措置区分);
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
