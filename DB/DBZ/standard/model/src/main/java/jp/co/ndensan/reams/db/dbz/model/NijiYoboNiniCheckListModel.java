/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防任意チェックリストのモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class NijiYoboNiniCheckListModel implements Serializable {

    private DbT3102NijiYoboNiniCheckListEntity entity;

    /**
     * コンストラクタです。
     */
    public NijiYoboNiniCheckListModel() {
        entity = new DbT3102NijiYoboNiniCheckListEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3102NijiYoboNiniCheckListEntity
     */
    public NijiYoboNiniCheckListModel(DbT3102NijiYoboNiniCheckListEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3102NijiYoboNiniCheckListEntityを返します。
     *
     * @return DbT3102NijiYoboNiniCheckListEntity
     */
    public DbT3102NijiYoboNiniCheckListEntity getEntity() {
        return entity;
    }

    /**
     * DbT3102NijiYoboNiniCheckListEntityを設定します。
     *
     * @param entity DbT3102NijiYoboNiniCheckListEntity
     */
    public void setEntity(DbT3102NijiYoboNiniCheckListEntity entity) {
        this.entity = entity;
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 任意質問番号を返します。
     *
     * @return 任意質問番号
     */
    public int get任意質問番号() {
        return entity.getNiniShitsumonNo();
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
     * 任意質問事項を返します。
     *
     * @return 任意質問事項
     */
    public int get任意質問事項() {
        return entity.getNiniShitsumonJiko();
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
    }

    /**
     * 任意質問番号を設定します。
     *
     * @param 任意質問番号 任意質問番号
     */
    public void set任意質問番号(int 任意質問番号) {
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        entity.setNiniShitsumonNo(任意質問番号);
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
     * 任意質問事項を設定します。
     *
     * @param 任意質問事項 任意質問事項
     */
    public void set任意質問事項(int 任意質問事項) {
        requireNonNull(任意質問事項, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問事項"));
        entity.setNiniShitsumonJiko(任意質問事項);
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
