/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7011ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医医療機関情報　継承のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShujiiIryoKikanJohoModel implements Serializable {

    private DbT7011ShujiiIryoKikanJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShujiiIryoKikanJohoModel() {
        entity = new DbT7011ShujiiIryoKikanJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7011ShujiiIryoKikanJohoEntity
     */
    public ShujiiIryoKikanJohoModel(DbT7011ShujiiIryoKikanJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7011ShujiiIryoKikanJohoEntityを返します。
     *
     * @return DbT7011ShujiiIryoKikanJohoEntity
     */
    public DbT7011ShujiiIryoKikanJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7011ShujiiIryoKikanJohoEntityを設定します。
     *
     * @param entity DbT7011ShujiiIryoKikanJohoEntity
     */
    public void setEntity(DbT7011ShujiiIryoKikanJohoEntity entity) {
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
     * 介護医療機関コードを返します。
     *
     * @return 介護医療機関コード
     */
    public RString get介護医療機関コード() {
        return entity.getKaigoIryokikanCode();
    }

    /**
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.getIryokikanCode();
    }

    /**
     * 医療機関の状況を返します。
     *
     * @return 医療機関の状況
     */
    public RString get医療機関の状況() {
        return entity.getIryokikanJokyo();
    }

    /**
     * 機関の区分コードを返します。
     *
     * @return 機関の区分コード
     */
    public Code get機関の区分コード() {
        return entity.getKikanKubunCode();
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
     * 介護医療機関コードを設定します。
     *
     * @param 介護医療機関コード 介護医療機関コード
     */
    public void set介護医療機関コード(RString 介護医療機関コード) {
        requireNonNull(介護医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医療機関コード"));
        entity.setKaigoIryokikanCode(介護医療機関コード);
    }

    /**
     * 医療機関コードを設定します。
     *
     * @param 医療機関コード 医療機関コード
     */
    public void set医療機関コード(RString 医療機関コード) {
        requireNonNull(医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関コード"));
        entity.setIryokikanCode(医療機関コード);
    }

    /**
     * 医療機関の状況を設定します。
     *
     * @param 医療機関の状況 医療機関の状況
     */
    public void set医療機関の状況(RString 医療機関の状況) {
        requireNonNull(医療機関の状況, UrSystemErrorMessages.値がnull.getReplacedMessage("医療機関の状況"));
        entity.setIryokikanJokyo(医療機関の状況);
    }

    /**
     * 機関の区分コードを設定します。
     *
     * @param 機関の区分コード 機関の区分コード
     */
    public void set機関の区分コード(Code 機関の区分コード) {
        requireNonNull(機関の区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("機関の区分コード"));
        entity.setKikanKubunCode(機関の区分コード);
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
