/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連取込情報のモデルクラスです。
 *
 * @author n2810 久保里史
 */
public class KokuhorenTorikomiJohoModel implements Serializable {

    private DbV3104KokuhorenTorikomiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public KokuhorenTorikomiJohoModel() {
        entity = new DbV3104KokuhorenTorikomiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbV3104KokuhorenTorikomiJohoEntity
     */
    public KokuhorenTorikomiJohoModel(DbV3104KokuhorenTorikomiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbV3104KokuhorenTorikomiJohoEntityを返します。
     *
     * @return DbV3104KokuhorenTorikomiJohoEntity
     */
    public DbV3104KokuhorenTorikomiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbV3104KokuhorenTorikomiJohoEntityを設定します。
     *
     * @param entity DbV3104KokuhorenTorikomiJohoEntity
     */
    public void setEntity(DbV3104KokuhorenTorikomiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public RYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 当月処理状態区分を返します。
     *
     * @return 当月処理状態区分
     */
    public RString get当月処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 前月処理状態区分を返します。
     *
     * @return 前月処理状態区分
     */
    public RString get前月処理状態区分() {
        return entity.getZen_shorijotaikubun();
    }

    /**
     * 前々月処理状態区分を返します。
     *
     * @return 前々月処理状態区分
     */
    public RString get前々月処理状態区分() {
        return entity.getZenzen_shorijotaikubun();
    }

    /**
     * 処理年月を設定します。
     *
     * @param 処理年月 処理年月
     */
    public void set処理年月(RYearMonth 処理年月) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        entity.setShoriYM(処理年月);
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(RString 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanShikibetsuNo(交換情報識別番号);
    }

    /**
     * 当月処理状態区分を設定します。
     *
     * @param 当月処理状態区分 当月処理状態区分
     */
    public void set当月処理状態区分(RString 当月処理状態区分) {
        requireNonNull(当月処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("当月処理状態区分"));
        entity.setShoriJotaiKubun(当月処理状態区分);
    }

    /**
     * 前月処理状態区分を設定します。
     *
     * @param 前月処理状態区分 前月処理状態区分
     */
    public void set前月処理状態区分(RString 前月処理状態区分) {
        requireNonNull(前月処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("前月処理状態区分"));
        entity.setZen_shorijotaikubun(前月処理状態区分);
    }

    /**
     * 前々月処理状態区分を設定します。
     *
     * @param 前々月処理状態区分 前々月処理状態区分
     */
    public void set前々月処理状態区分(RString 前々月処理状態区分) {
        requireNonNull(前々月処理状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("前々月処理状態区分"));
        entity.setZenzen_shorijotaikubun(前々月処理状態区分);
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
