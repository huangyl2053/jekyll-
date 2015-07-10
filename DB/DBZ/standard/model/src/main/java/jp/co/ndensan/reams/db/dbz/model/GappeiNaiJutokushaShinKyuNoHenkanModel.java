/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合併内住特者新旧番号変換テーブルのモデルクラスです。
 *
 * @author LDNS 宋文娟
 */
public class GappeiNaiJutokushaShinKyuNoHenkanModel implements Serializable {

    private DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity;

    /**
     * コンストラクタです。
     */
    public GappeiNaiJutokushaShinKyuNoHenkanModel() {
        entity = new DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity
     */
    public GappeiNaiJutokushaShinKyuNoHenkanModel(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityを返します。
     *
     * @return DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity
     */
    public DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity getEntity() {
        return entity;
    }

    /**
     * DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityを設定します。
     *
     * @param entity DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity
     */
    public void setEntity(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity entity) {
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 識別コード_措置元を返します。
     *
     * @return 識別コード_措置元
     */
    public ShikibetsuCode get識別コード_措置元() {
        return entity.getShikibetsuCodeSochiMoto();
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
     * 市町村コード_措置元を返します。
     *
     * @return 市町村コード_措置元
     */
    public LasdecCode get市町村コード_措置元() {
        return entity.getShichosonCodeSochiMoto();
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
     * 被保険者番号_措置元を返します。
     *
     * @return 被保険者番号_措置元
     */
    public HihokenshaNo get被保険者番号_措置元() {
        return entity.getHihokenshaNoSochiMoto();
    }

    /**
     * 開始年月日を返します。
     *
     * @return 開始年月日
     */
    public FlexibleDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 終了年月日を返します。
     *
     * @return 終了年月日
     */
    public FlexibleDate get終了年月日() {
        return entity.getShuryoYMD();
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
    public void set履歴番号(RString 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
    }

    /**
     * 識別コード_措置元を設定します。
     *
     * @param 識別コード_措置元 識別コード_措置元
     */
    public void set識別コード_措置元(ShikibetsuCode 識別コード_措置元) {
        requireNonNull(識別コード_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード_措置元"));
        entity.setShikibetsuCodeSochiMoto(識別コード_措置元);
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
     * 市町村コード_措置元を設定します。
     *
     * @param 市町村コード_措置元 市町村コード_措置元
     */
    public void set市町村コード_措置元(LasdecCode 市町村コード_措置元) {
        requireNonNull(市町村コード_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード_措置元"));
        entity.setShichosonCodeSochiMoto(市町村コード_措置元);
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
     * 被保険者番号_措置元を設定します。
     *
     * @param 被保険者番号_措置元 被保険者番号_措置元
     */
    public void set被保険者番号_措置元(HihokenshaNo 被保険者番号_措置元) {
        requireNonNull(被保険者番号_措置元, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号_措置元"));
        entity.setHihokenshaNoSochiMoto(被保険者番号_措置元);
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     */
    public void set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setKaishiYMD(開始年月日);
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     */
    public void set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setShuryoYMD(終了年月日);
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
