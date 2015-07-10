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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 弁明者情報のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class BemmeishaJohoModel implements Serializable {

    private DbT7003BemmeishaJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public BemmeishaJohoModel() {
        entity = new DbT7003BemmeishaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7003BemmeishaJohoEntity
     */
    public BemmeishaJohoModel(DbT7003BemmeishaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT7003BemmeishaJohoEntityを返します。
     *
     * @return DbT7003BemmeishaJohoEntity
     */
    public DbT7003BemmeishaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT7003BemmeishaJohoEntityを設定します。
     *
     * @param entity DbT7003BemmeishaJohoEntity
     */
    public void setEntity(DbT7003BemmeishaJohoEntity entity) {
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
     * 弁明者枝番を返します。
     *
     * @return 弁明者枝番
     */
    public int get弁明者枝番() {
        return entity.getBemmeishaEdaban();
    }

    /**
     * 職員コードを返します。
     *
     * @return 職員コード
     */
    public Code get職員コード() {
        return entity.getShokuinCode();
    }

    /**
     * 部署コードを返します。
     *
     * @return 部署コード
     */
    public BushoCode get部署コード() {
        return entity.getBushoCode();
    }

    /**
     * 役職名を返します。
     *
     * @return 役職名
     */
    public RString get役職名() {
        return entity.getYakushoskuName();
    }

    /**
     * 弁明者氏名を返します。
     *
     * @return 弁明者氏名
     */
    public AtenaMeisho get弁明者氏名() {
        return entity.getBemmeishaShimei();
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
     * 弁明者枝番を設定します。
     *
     * @param 弁明者枝番 弁明者枝番
     */
    public void set弁明者枝番(int 弁明者枝番) {
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));
        entity.setBemmeishaEdaban(弁明者枝番);
    }

    /**
     * 職員コードを設定します。
     *
     * @param 職員コード 職員コード
     */
    public void set職員コード(Code 職員コード) {
        requireNonNull(職員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("職員コード"));
        entity.setShokuinCode(職員コード);
    }

    /**
     * 部署コードを設定します。
     *
     * @param 部署コード 部署コード
     */
    public void set部署コード(BushoCode 部署コード) {
        requireNonNull(部署コード, UrSystemErrorMessages.値がnull.getReplacedMessage("部署コード"));
        entity.setBushoCode(部署コード);
    }

    /**
     * 役職名を設定します。
     *
     * @param 役職名 役職名
     */
    public void set役職名(RString 役職名) {
        requireNonNull(役職名, UrSystemErrorMessages.値がnull.getReplacedMessage("役職名"));
        entity.setYakushoskuName(役職名);
    }

    /**
     * 弁明者氏名を設定します。
     *
     * @param 弁明者氏名 弁明者氏名
     */
    public void set弁明者氏名(AtenaMeisho 弁明者氏名) {
        requireNonNull(弁明者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者氏名"));
        entity.setBemmeishaShimei(弁明者氏名);
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
