/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請履歴情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class ShinsakaiShinseiRirekiJoho implements Serializable, IShinseiRirekiJoho {

    private DbT5121ShinseiRirekiJohoEntity entity;

    private ShinsakaiShinseiRirekiJoho() {
        this.entity = new DbT5121ShinseiRirekiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5121ShinseiRirekiJohoEntity
     */
    public ShinsakaiShinseiRirekiJoho(DbT5121ShinseiRirekiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5121ShinseiRirekiJohoEntityを返します。
     *
     * @return DbT5121ShinseiRirekiJohoEntity
     */
    @Override
    public DbT5121ShinseiRirekiJohoEntity getEntity() {
        return entity;
    }

    /**
     * 申請管理番号を返します。
     *
     * @return 申請管理番号
     */
    @Override
    public ShinseishoKanriNo get申請管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 前回申請管理番号を返します。
     *
     * @return 前回申請管理番号
     */
    @Override
    public ShinseishoKanriNo get前回申請管理番号() {
        return entity.getZenkaiShinseishoKanriNo();
    }

    /**
     * 状態を設定します。
     *
     * @param entityDataState EntityDataState
     */
    public void setState(EntityDataState entityDataState) {
        entity.setState(entityDataState);
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

    private ShinsakaiShinseiRirekiJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT5121ShinseiRirekiJohoEntity
     */
    public DbT5121ShinseiRirekiJohoEntity toEntity() {
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
     * 新しい{@link ShinsakaiShinseiRirekiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link ShinsakaiShinseiRirekiJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends IShinseiRirekiJoho.Builder {

        private DbT5121ShinseiRirekiJohoEntity entity;

        Builder() {
            this.entity = new DbT5121ShinseiRirekiJohoEntity();
        }

        Builder(ShinsakaiShinseiRirekiJoho shinsakaiShinseiRirekiJoho) {
            this.entity = shinsakaiShinseiRirekiJoho.entity.clone();
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
        @Override
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            Objects.requireNonNull(shinseishoKanriNo);
            this.entity.setShinseishoKanriNo(shinseishoKanriNo);
            return this;
        }

        /**
         * zenkaiShinseishoKanriNoを設定します。
         *
         * @param zenkaiShinseishoKanriNo 前回申請書管理番号
         * @return builder
         */
        @Override
        public Builder setZenkaiShinseishoKanriNo(ShinseishoKanriNo zenkaiShinseishoKanriNo) {
            Objects.requireNonNull(zenkaiShinseishoKanriNo);
            this.entity.setZenkaiShinseishoKanriNo(zenkaiShinseishoKanriNo);
            return this;
        }

        /**
         * {@link ShinsakaiShinseiRirekiJoho}を生成します。
         *
         * @return {@link ShinsakaiShinseiRirekiJoho}
         */
        @Override
        public ShinsakaiShinseiRirekiJoho build() {
            return new ShinsakaiShinseiRirekiJoho(this);
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

        private static final long serialVersionUID = 13894545693224337L;

        private final DbT5121ShinseiRirekiJohoEntity entity;

        private _SerializationProxy(ShinsakaiShinseiRirekiJoho shinsakaiShinseiRirekiJoho) {
            this.entity = shinsakaiShinseiRirekiJoho.entity;
        }

        private Object readResolve() {
            return new ShinsakaiShinseiRirekiJoho(entity);
        }
    }
}
