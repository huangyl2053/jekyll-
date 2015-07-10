/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7002BemmeiNaiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 弁明内容のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class BemmeiNaiyoModel implements Serializable {

    private DbT7002BemmeiNaiyoEntity entity;

    /**
     * コンストラクタです。
     */
    public BemmeiNaiyoModel() {
        entity = new DbT7002BemmeiNaiyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7002BemmeiNaiyoEntity
     */
    public BemmeiNaiyoModel(DbT7002BemmeiNaiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7002BemmeiNaiyoEntityを返します。
     *
     * @return DbT7002BemmeiNaiyoEntity
     */
    public DbT7002BemmeiNaiyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7002BemmeiNaiyoEntityを設定します。
     *
     * @param entity DbT7002BemmeiNaiyoEntity
     */
    public void setEntity(DbT7002BemmeiNaiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 原処分被保険者番号を返します。
     *
     * @return 原処分被保険者番号
     */
    public HihokenshaNo get原処分被保険者番号() {
        return entity.getGenshobunHihokenshaNo();
    }

    /**
     * 審査請求届出日を返します。
     *
     * @return 審査請求届出日
     */
    public FlexibleDate get審査請求届出日() {
        return entity.getShinsaseikyuTodokedeYMD();
    }

    /**
     * 弁明書作成日を返します。
     *
     * @return 弁明書作成日
     */
    public FlexibleDate get弁明書作成日() {
        return entity.getBemmeishoSakuseiYMD();
    }

    /**
     * 審査請求に係る処分内容を返します。
     *
     * @return 審査請求に係る処分内容
     */
    public RString get審査請求に係る処分内容() {
        return entity.getShinsaseikyuKankeiShobunNaiyo();
    }

    /**
     * 弁明内容を返します。
     *
     * @return 弁明内容
     */
    public RString get弁明内容() {
        return entity.getBemmeiNaiyo();
    }

    /**
     * 弁明書作成日提出日を返します。
     *
     * @return 弁明書作成日提出日
     */
    public FlexibleDate get弁明書作成日提出日() {
        return entity.getBemmeishoSakuseiTeishutsuYMD();
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 原処分被保険者番号を設定します。
     *
     * @param 原処分被保険者番号 原処分被保険者番号
     */
    public void set原処分被保険者番号(HihokenshaNo 原処分被保険者番号) {
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        entity.setGenshobunHihokenshaNo(原処分被保険者番号);
    }

    /**
     * 審査請求届出日を設定します。
     *
     * @param 審査請求届出日 審査請求届出日
     */
    public void set審査請求届出日(FlexibleDate 審査請求届出日) {
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        entity.setShinsaseikyuTodokedeYMD(審査請求届出日);
    }

    /**
     * 弁明書作成日を設定します。
     *
     * @param 弁明書作成日 弁明書作成日
     */
    public void set弁明書作成日(FlexibleDate 弁明書作成日) {
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        entity.setBemmeishoSakuseiYMD(弁明書作成日);
    }

    /**
     * 審査請求に係る処分内容を設定します。
     *
     * @param 審査請求に係る処分内容 審査請求に係る処分内容
     */
    public void set審査請求に係る処分内容(RString 審査請求に係る処分内容) {
        requireNonNull(審査請求に係る処分内容, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求に係る処分内容"));
        entity.setShinsaseikyuKankeiShobunNaiyo(審査請求に係る処分内容);
    }

    /**
     * 弁明内容を設定します。
     *
     * @param 弁明内容 弁明内容
     */
    public void set弁明内容(RString 弁明内容) {
        requireNonNull(弁明内容, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明内容"));
        entity.setBemmeiNaiyo(弁明内容);
    }

    /**
     * 弁明書作成日提出日を設定します。
     *
     * @param 弁明書作成日提出日 弁明書作成日提出日
     */
    public void set弁明書作成日提出日(FlexibleDate 弁明書作成日提出日) {
        requireNonNull(弁明書作成日提出日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日提出日"));
        entity.setBemmeishoSakuseiTeishutsuYMD(弁明書作成日提出日);
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
