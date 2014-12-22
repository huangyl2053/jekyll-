/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static java.util.Objects.requireNonNull;

/**
 * ランク情報のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class RankJohoModel implements Serializable {

    private DbT2011RankJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public RankJohoModel() {
        entity = new DbT2011RankJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2011RankJohoEntity
     */
    public RankJohoModel(DbT2011RankJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2011RankJohoEntityを返します。
     *
     * @return DbT2011RankJohoEntity
     */
    public DbT2011RankJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT2011RankJohoEntityを設定します。
     *
     * @param entity DbT2011RankJohoEntity
     */
    public void setEntity(DbT2011RankJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FlexibleYear get賦課年度() {
        return entity.getFukaNendo();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RankKubun getランク区分() {
        return entity.getRankKubun();
    }

    /**
     * ランク名称を返します。
     *
     * @return ランク名称
     */
    public RString getランク名称() {
        return entity.getRankName();
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     */
    public void setランク区分(RankKubun ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankKubun(ランク区分);
    }

    /**
     * ランク名称を設定します。
     *
     * @param ランク名称 ランク名称
     */
    public void setランク名称(RString ランク名称) {
        requireNonNull(ランク名称, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク名称"));
        entity.setRankName(ランク名称);
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
