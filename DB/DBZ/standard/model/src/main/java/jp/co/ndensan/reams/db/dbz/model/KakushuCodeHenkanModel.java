/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7027KakushuCodeHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 各種コード変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class KakushuCodeHenkanModel implements Serializable {

    private DbT7027KakushuCodeHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public KakushuCodeHenkanModel() {
        entity = new DbT7027KakushuCodeHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7027KakushuCodeHenkanEntity
     */
    public KakushuCodeHenkanModel(DbT7027KakushuCodeHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7027KakushuCodeHenkanEntityを返します。
     *
     * @return DbT7027KakushuCodeHenkanEntity
     */
    public DbT7027KakushuCodeHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7027KakushuCodeHenkanEntityを設定します。
     *
     * @param entity DbT7027KakushuCodeHenkanEntity
     */
    public void setEntity(DbT7027KakushuCodeHenkanEntity entity) {
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
     * 内部コードを返します。
     *
     * @return 内部コード
     */
    public RString get内部コード() {
        return entity.getNaibuCode();
    }

    /**
     * 内部番号を返します。
     *
     * @return 内部番号
     */
    public RString get内部番号() {
        return entity.getNaibuNo();
    }

    /**
     * 外部コードを返します。
     *
     * @return 外部コード
     */
    public RString get外部コード() {
        return entity.getGaibuCode();
    }

    /**
     * 市町村コード２を返します。
     *
     * @return 市町村コード２
     */
    public LasdecCode get市町村コード２() {
        return entity.getShichosonCode2();
    }

    /**
     * 外部コード２を返します。
     *
     * @return 外部コード２
     */
    public RString get外部コード２() {
        return entity.getGaibuCode2();
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
     * 内部コードを設定します。
     *
     * @param 内部コード 内部コード
     */
    public void set内部コード(RString 内部コード) {
        requireNonNull(内部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("内部コード"));
        entity.setNaibuCode(内部コード);
    }

    /**
     * 内部番号を設定します。
     *
     * @param 内部番号 内部番号
     */
    public void set内部番号(RString 内部番号) {
        requireNonNull(内部番号, UrSystemErrorMessages.値がnull.getReplacedMessage("内部番号"));
        entity.setNaibuNo(内部番号);
    }

    /**
     * 外部コードを設定します。
     *
     * @param 外部コード 外部コード
     */
    public void set外部コード(RString 外部コード) {
        requireNonNull(外部コード, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード"));
        entity.setGaibuCode(外部コード);
    }

    /**
     * 市町村コード２を設定します。
     *
     * @param 市町村コード２ 市町村コード２
     */
    public void set市町村コード２(LasdecCode 市町村コード２) {
        requireNonNull(市町村コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード２"));
        entity.setShichosonCode2(市町村コード２);
    }

    /**
     * 外部コード２を設定します。
     *
     * @param 外部コード２ 外部コード２
     */
    public void set外部コード２(RString 外部コード２) {
        requireNonNull(外部コード２, UrSystemErrorMessages.値がnull.getReplacedMessage("外部コード２"));
        entity.setGaibuCode2(外部コード２);
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
