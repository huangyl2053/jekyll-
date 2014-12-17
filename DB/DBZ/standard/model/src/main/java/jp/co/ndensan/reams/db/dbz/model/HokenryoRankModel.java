/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static java.util.Objects.requireNonNull;

/**
 * 保険料ランクのモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoRankModel implements Serializable {

    private DbT2012HokenryoRankEntity entity;

    /**
     * コンストラクタです。
     */
    public HokenryoRankModel() {
        entity = new DbT2012HokenryoRankEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2012HokenryoRankEntity
     */
    public HokenryoRankModel(DbT2012HokenryoRankEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2012HokenryoRankEntityを返します。
     *
     * @return DbT2012HokenryoRankEntity
     */
    public DbT2012HokenryoRankEntity getEntity() {
        return entity;
    }

    /**
     * DbT2012HokenryoRankEntityを設定します。
     *
     * @param entity DbT2012HokenryoRankEntity
     */
    public void setEntity(DbT2012HokenryoRankEntity entity) {
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RString getランク区分() {
        return entity.getRankKubun();
    }

    /**
     * 遡及年度を返します。
     *
     * @return 遡及年度
     */
    public FlexibleYear get遡及年度() {
        return entity.getSokyuNendo();
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
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     */
    public void setランク区分(RString ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankKubun(ランク区分);
    }

    /**
     * 遡及年度を設定します。
     *
     * @param 遡及年度 遡及年度
     */
    public void set遡及年度(FlexibleYear 遡及年度) {
        requireNonNull(遡及年度, UrSystemErrorMessages.値がnull.getReplacedMessage("遡及年度"));
        entity.setSokyuNendo(遡及年度);
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
