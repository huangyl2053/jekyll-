/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険医療保険加入状況のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class IryohokenKanyuJokyoModel implements Serializable {

    private DbT1008IryohokenKanyuJokyoEntity entity;

    /**
     * コンストラクタです。
     */
    public IryohokenKanyuJokyoModel() {
        entity = new DbT1008IryohokenKanyuJokyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1008IryohokenKanyuJokyoEntity
     */
    public IryohokenKanyuJokyoModel(DbT1008IryohokenKanyuJokyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1008IryohokenKanyuJokyoEntityを返します。
     *
     * @return DbT1008IryohokenKanyuJokyoEntity
     */
    public DbT1008IryohokenKanyuJokyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT1008IryohokenKanyuJokyoEntityを設定します。
     *
     * @param entity DbT1008IryohokenKanyuJokyoEntity
     */
    public void setEntity(DbT1008IryohokenKanyuJokyoEntity entity) {
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimeStamp();
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
     * 医療保険種別コードを返します。
     *
     * @return 医療保険種別コード
     */
    public RString get医療保険種別コード() {
        return entity.getIryoHokenShubetsuCode();
    }

    /**
     * 医療保険者番号を返します。
     *
     * @return 医療保険者番号
     */
    public RString get医療保険者番号() {
        return entity.getIryoHokenshaNo();
    }

    /**
     * 医療保険者名称を返します。
     *
     * @return 医療保険者名称
     */
    public RString get医療保険者名称() {
        return entity.getIryoHokenshaMeisho();
    }

    /**
     * 医療保険記号番号を返します。
     *
     * @return 医療保険記号番号
     */
    public RString get医療保険記号番号() {
        return entity.getIryoHokenKigoNo();
    }

    /**
     * 医療保険加入年月日を返します。
     *
     * @return 医療保険加入年月日
     */
    public FlexibleDate get医療保険加入年月日() {
        return entity.getIryoHokenKanyuYMD();
    }

    /**
     * 医療保険脱退年月日を返します。
     *
     * @return 医療保険脱退年月日
     */
    public FlexibleDate get医療保険脱退年月日() {
        return entity.getIryoHokenDattaiYMD();
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
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimeStamp(処理日時);
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
     * 医療保険種別コードを設定します。
     *
     * @param 医療保険種別コード 医療保険種別コード
     */
    public void set医療保険種別コード(RString 医療保険種別コード) {
        requireNonNull(医療保険種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険種別コード"));
        entity.setIryoHokenShubetsuCode(医療保険種別コード);
    }

    /**
     * 医療保険者番号を設定します。
     *
     * @param 医療保険者番号 医療保険者番号
     */
    public void set医療保険者番号(RString 医療保険者番号) {
        requireNonNull(医療保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険者番号"));
        entity.setIryoHokenshaNo(医療保険者番号);
    }

    /**
     * 医療保険者名称を設定します。
     *
     * @param 医療保険者名称 医療保険者名称
     */
    public void set医療保険者名称(RString 医療保険者名称) {
        requireNonNull(医療保険者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険者名称"));
        entity.setIryoHokenshaMeisho(医療保険者名称);
    }

    /**
     * 医療保険記号番号を設定します。
     *
     * @param 医療保険記号番号 医療保険記号番号
     */
    public void set医療保険記号番号(RString 医療保険記号番号) {
        requireNonNull(医療保険記号番号, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険記号番号"));
        entity.setIryoHokenKigoNo(医療保険記号番号);
    }

    /**
     * 医療保険加入年月日を設定します。
     *
     * @param 医療保険加入年月日 医療保険加入年月日
     */
    public void set医療保険加入年月日(FlexibleDate 医療保険加入年月日) {
        requireNonNull(医療保険加入年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険加入年月日"));
        entity.setIryoHokenKanyuYMD(医療保険加入年月日);
    }

    /**
     * 医療保険脱退年月日を設定します。
     *
     * @param 医療保険脱退年月日 医療保険脱退年月日
     */
    public void set医療保険脱退年月日(FlexibleDate 医療保険脱退年月日) {
        requireNonNull(医療保険脱退年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("医療保険脱退年月日"));
        entity.setIryoHokenDattaiYMD(医療保険脱退年月日);
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
