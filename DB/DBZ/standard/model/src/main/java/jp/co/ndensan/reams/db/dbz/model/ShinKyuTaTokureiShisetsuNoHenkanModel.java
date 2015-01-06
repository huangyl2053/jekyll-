/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 新旧他特例施設番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class ShinKyuTaTokureiShisetsuNoHenkanModel implements Serializable {

    private DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public ShinKyuTaTokureiShisetsuNoHenkanModel() {
        entity = new DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     */
    public ShinKyuTaTokureiShisetsuNoHenkanModel(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityを返します。
     *
     * @return DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     */
    public DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntityを設定します。
     *
     * @param entity DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity
     */
    public void setEntity(DbT7032ShinKyuTaTokureiShisetsuNoHenkanEntity entity) {
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
     * 新他特例施設番号を返します。
     *
     * @return 新他特例施設番号
     */
    public RString get新他特例施設番号() {
        return entity.getShinTaTokureiShisetsuNo();
    }

    /**
     * 旧他特例施設番号を返します。
     *
     * @return 旧他特例施設番号
     */
    public RString get旧他特例施設番号() {
        return entity.getKyuTaTokureiShisetsuNo();
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
     * 旧他特例施設番号２を返します。
     *
     * @return 旧他特例施設番号２
     */
    public RString get旧他特例施設番号２() {
        return entity.getKyuTaTokureiShisetsuNo2();
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
     * 新他特例施設番号を設定します。
     *
     * @param 新他特例施設番号 新他特例施設番号
     */
    public void set新他特例施設番号(RString 新他特例施設番号) {
        requireNonNull(新他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("新他特例施設番号"));
        entity.setShinTaTokureiShisetsuNo(新他特例施設番号);
    }

    /**
     * 旧他特例施設番号を設定します。
     *
     * @param 旧他特例施設番号 旧他特例施設番号
     */
    public void set旧他特例施設番号(RString 旧他特例施設番号) {
        requireNonNull(旧他特例施設番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号"));
        entity.setKyuTaTokureiShisetsuNo(旧他特例施設番号);
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
     * 旧他特例施設番号２を設定します。
     *
     * @param 旧他特例施設番号２ 旧他特例施設番号２
     */
    public void set旧他特例施設番号２(RString 旧他特例施設番号２) {
        requireNonNull(旧他特例施設番号２, UrSystemErrorMessages.値がnull.getReplacedMessage("旧他特例施設番号２"));
        entity.setKyuTaTokureiShisetsuNo2(旧他特例施設番号２);
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
