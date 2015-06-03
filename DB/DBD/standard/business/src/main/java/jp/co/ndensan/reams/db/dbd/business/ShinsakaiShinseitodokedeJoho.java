/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;

/**
 * 申請届出情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class ShinsakaiShinseitodokedeJoho implements IShinseitodokedeJoho {

    private DbT5120ShinseitodokedeJohoEntity entity;

    private ShinsakaiShinseitodokedeJoho() {
        this.entity = new DbT5120ShinseitodokedeJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5120ShinseitodokedeJohoEntity
     */
    public ShinsakaiShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5120ShinseitodokedeJohoEntityを返します。
     *
     * @return DbT5120ShinseitodokedeJohoEntity
     */
    public DbT5120ShinseitodokedeJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT5120ShinseitodokedeJohoEntityを設定します。
     *
     * @param entity DbT5120ShinseitodokedeJohoEntity
     */
    public void setEntity(DbT5120ShinseitodokedeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 申請届出代行区分コードを返します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.getShinseiTodokedeDaikoKubunCode();
    }

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    public AtenaMeisho get申請届出者氏名() {
        return entity.getShinseiTodokedeshaShimei();
    }

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    public AtenaKanaMeisho get申請届出者氏名カナ() {
        return entity.getShinseiTodokedeshaKanaShimei();
    }

    /**
     * 申請届出者続柄コードを返します。
     *
     * @return 申請届出者続柄コード
     */
    public RString get申請届出者続柄コード() {
        return entity.getShinseiTodokedeshaTsuzukigaraCode();
    }

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.getShinseiTodokedeDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.getShinseiTodokedeshaYubinNo();
    }

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    public AtenaJusho get申請届出者住所() {
        return entity.getShinseiTodokedeshaJusho();
    }

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getShinseiTodokedeshaTelNo();
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

    private ShinsakaiShinseitodokedeJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT5120ShinseitodokedeJohoEntity
     */
    public DbT5120ShinseitodokedeJohoEntity toEntity() {
        return entity.clone();
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link ShinsakaiShinseitodokedeJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link ShinsakaiShinseitodokedeJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private DbT5120ShinseitodokedeJohoEntity entity;

        Builder() {
            this.entity = new DbT5120ShinseitodokedeJohoEntity();
        }

        Builder(ShinsakaiShinseitodokedeJoho shinsakaiShinseitodokedeJoho) {
            this.entity = shinsakaiShinseitodokedeJoho.entity.clone();
        }

        /**
         * insertDantaiCdを設定します。
         *
         * @param insertDantaiCd 挿入市町村
         * @return builder
         */
        public Builder setInsertDantaiCd(RString insertDantaiCd) {
            Objects.requireNonNull(insertDantaiCd);
            this.entity.setInsertDantaiCd(insertDantaiCd);
            return this;
        }

        /**
         * isDeletedを設定します。
         *
         * @param isDeleted 論理削除flag
         * @return builder
         */
        public Builder setIsDeleted(boolean isDeleted) {
            this.entity.setIsDeleted(isDeleted);
            return this;
        }

        /**
         * lastUpdateReamsLoginIdを設定します。
         *
         * @param lastUpdateReamsLoginId 更新ユーザーId
         * @return builder
         */
        public Builder setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
            Objects.requireNonNull(lastUpdateReamsLoginId);
            this.entity.setLastUpdateReamsLoginId(lastUpdateReamsLoginId);
            return this;
        }

        /**
         * shinseishoKanriNoを設定します。
         *
         * @param shinseishoKanriNo 申請書管理番号
         * @return builder
         */
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            Objects.requireNonNull(shinseishoKanriNo);
            this.entity.setShinseishoKanriNo(shinseishoKanriNo);
            return this;
        }

        /**
         * shinseiTodokedeDaikoKubunCodeを設定します。
         *
         * @param shinseiTodokedeDaikoKubunCode 申請届出代行区分コード
         * @return builder
         */
        public Builder setShinseiTodokedeDaikoKubunCode(Code shinseiTodokedeDaikoKubunCode) {
            Objects.requireNonNull(shinseiTodokedeDaikoKubunCode);
            this.entity.setShinseiTodokedeDaikoKubunCode(shinseiTodokedeDaikoKubunCode);
            return this;
        }

        /**
         * shinseiTodokedeshaShimeiを設定します。
         *
         * @param shinseiTodokedeshaShimei 申請届出者氏名
         * @return builder
         */
        public Builder setShinseiTodokedeshaShimei(AtenaMeisho shinseiTodokedeshaShimei) {
            Objects.requireNonNull(shinseiTodokedeshaShimei);
            this.entity.setShinseiTodokedeshaShimei(shinseiTodokedeshaShimei);
            return this;
        }

        /**
         * shinseiTodokedeshaKanaShimeiを設定します。
         *
         * @param shinseiTodokedeshaKanaShimei 申請届出者氏名カナ
         * @return builder
         */
        public Builder setShinseiTodokedeshaKanaShimei(AtenaKanaMeisho shinseiTodokedeshaKanaShimei) {
            Objects.requireNonNull(shinseiTodokedeshaKanaShimei);
            this.entity.setShinseiTodokedeshaKanaShimei(shinseiTodokedeshaKanaShimei);
            return this;
        }

        /**
         * shinseiTodokedeshaTsuzukigaraCodeを設定します。
         *
         * @param shinseiTodokedeshaTsuzukigaraCode 申請届出者続柄コード
         * @return builder
         */
        public Builder setShinseiTodokedeshaTsuzukigaraCode(RString shinseiTodokedeshaTsuzukigaraCode) {
            Objects.requireNonNull(shinseiTodokedeshaTsuzukigaraCode);
            this.entity.setShinseiTodokedeshaTsuzukigaraCode(shinseiTodokedeshaTsuzukigaraCode);
            return this;
        }

        /**
         * shinseiTodokedeDaikoJigyoshaNoを設定します。
         *
         * @param shinseiTodokedeDaikoJigyoshaNo 申請届出代行事業者番号
         * @return builder
         */
        public Builder setShinseiTodokedeDaikoJigyoshaNo(JigyoshaNo shinseiTodokedeDaikoJigyoshaNo) {
            Objects.requireNonNull(shinseiTodokedeDaikoJigyoshaNo);
            this.entity.setShinseiTodokedeDaikoJigyoshaNo(shinseiTodokedeDaikoJigyoshaNo);
            return this;
        }

        /**
         * jigyoshaKubunを設定します。
         *
         * @param jigyoshaKubun 事業者区分
         * @return builder
         */
        public Builder setJigyoshaKubun(RString jigyoshaKubun) {
            Objects.requireNonNull(jigyoshaKubun);
            this.entity.setJigyoshaKubun(jigyoshaKubun);
            return this;
        }

        /**
         * shinseiTodokedeshaYubinNoを設定します。
         *
         * @param shinseiTodokedeshaYubinNo 申請届出者郵便番号
         * @return builder
         */
        public Builder setShinseiTodokedeshaYubinNo(YubinNo shinseiTodokedeshaYubinNo) {
            Objects.requireNonNull(shinseiTodokedeshaYubinNo);
            this.entity.setShinseiTodokedeshaYubinNo(shinseiTodokedeshaYubinNo);
            return this;
        }

        /**
         * shinseiTodokedeshaJushoを設定します。
         *
         * @param shinseiTodokedeshaJusho 申請届出者住所
         * @return builder
         */
        public Builder setShinseiTodokedeshaJusho(AtenaJusho shinseiTodokedeshaJusho) {
            Objects.requireNonNull(shinseiTodokedeshaJusho);
            this.entity.setShinseiTodokedeshaJusho(shinseiTodokedeshaJusho);
            return this;
        }

        /**
         * shinseiTodokedeshaTelNoを設定します。
         *
         * @param shinseiTodokedeshaTelNo 申請届出者電話番号
         * @return builder
         */
        public Builder setShinseiTodokedeshaTelNo(TelNo shinseiTodokedeshaTelNo) {
            Objects.requireNonNull(shinseiTodokedeshaTelNo);
            this.entity.setShinseiTodokedeshaTelNo(shinseiTodokedeshaTelNo);
            return this;
        }

        /**
         * {@link ShinsakaiShinseitodokedeJoho}を生成します。
         *
         * @return {@link ShinsakaiShinseitodokedeJoho}
         */
        public ShinsakaiShinseitodokedeJoho build() {
            return new ShinsakaiShinseitodokedeJoho(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。
     * 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2328978583983952496L;

        private final DbT5120ShinseitodokedeJohoEntity entity;

        private _SerializationProxy(ShinsakaiShinseitodokedeJoho shinsakaiShinseitodokedeJoho) {
            this.entity = shinsakaiShinseitodokedeJoho.entity;
        }

        private Object readResolve() {
            return new ShinsakaiShinseitodokedeJoho(entity);
        }
    }
}
