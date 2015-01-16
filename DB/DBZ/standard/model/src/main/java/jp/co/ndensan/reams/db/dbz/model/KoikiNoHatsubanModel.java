/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 広域番号発番テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KoikiNoHatsubanModel implements Serializable {

    private DbT7025KoikiNoHatsubanEntity entity;

    /**
     * コンストラクタです。
     */
    public KoikiNoHatsubanModel() {
        entity = new DbT7025KoikiNoHatsubanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7025KoikiNoHatsubanEntity
     */
    public KoikiNoHatsubanModel(DbT7025KoikiNoHatsubanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7025KoikiNoHatsubanEntityを返します。
     *
     * @return DbT7025KoikiNoHatsubanEntity
     */
    public DbT7025KoikiNoHatsubanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7025KoikiNoHatsubanEntityを設定します。
     *
     * @param entity DbT7025KoikiNoHatsubanEntity
     */
    public void setEntity(DbT7025KoikiNoHatsubanEntity entity) {
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
     * コード区分を返します。
     *
     * @return コード区分
     */
    public RString getコード区分() {
        return entity.getCodeKubun();
    }

    /**
     * 番号を返します。
     *
     * @return 番号
     */
    public RString get番号() {
        return entity.getNo();
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
     * コード区分を設定します。
     *
     * @param コード区分 コード区分
     */
    public void setコード区分(RString コード区分) {
        requireNonNull(コード区分, UrSystemErrorMessages.値がnull.getReplacedMessage("コード区分"));
        entity.setCodeKubun(コード区分);
    }

    /**
     * 番号を設定します。
     *
     * @param 番号 番号
     */
    public void set番号(RString 番号) {
        requireNonNull(番号, UrSystemErrorMessages.値がnull.getReplacedMessage("番号"));
        entity.setNo(番号);
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
