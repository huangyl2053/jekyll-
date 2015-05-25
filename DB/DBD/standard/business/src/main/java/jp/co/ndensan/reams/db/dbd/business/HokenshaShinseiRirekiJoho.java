/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請履歴情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class HokenshaShinseiRirekiJoho implements IShinseiRirekiJoho {

    private DbT4121ShinseiRirekiJohoEntity entity;

    private HokenshaShinseiRirekiJoho() {
        this.entity = new DbT4121ShinseiRirekiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4121ShinseiRirekiJohoEntity
     */
    public HokenshaShinseiRirekiJoho(DbT4121ShinseiRirekiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4121ShinseiRirekiJohoEntityを返します。
     *
     * @return DbT4121ShinseiRirekiJohoEntity
     */
    public DbT4121ShinseiRirekiJohoEntity getEntity() {
        return entity;
    }

    /**
     * 申請管理番号を返します。
     *
     * @return 申請管理番号
     */
    public ShinseishoKanriNo get申請管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 前回申請管理番号を返します。
     *
     * @return 前回申請管理番号
     */
    public ShinseishoKanriNo get前回申請管理番号() {
        return entity.getZenkaiShinseishoKanriNo();
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

    private HokenshaShinseiRirekiJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT4121ShinseiRirekiJohoEntity
     */
    public DbT4121ShinseiRirekiJohoEntity toEntity() {
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
     * 新しい{@link HokenshaShinseiRirekiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link HokenshaShinseiRirekiJoho}を生成するためのビルダーです。
     */
    public static final class Builder {

        private final DbT4121ShinseiRirekiJohoEntity entity;

        Builder() {
            this.entity = new DbT4121ShinseiRirekiJohoEntity();
        }

        Builder(HokenshaShinseiRirekiJoho hokenshaShinseiRirekiJoho) {
            this.entity = hokenshaShinseiRirekiJoho.entity.clone();
        }

        /**
         * insertDantaiCdを設定します。
         *
         * @param insertDantaiCd
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
         * @param isDeleted
         * @return builder
         */
        public Builder setIsDeleted(boolean isDeleted) {
            this.entity.setIsDeleted(isDeleted);
            return this;
        }

        /**
         * lastUpdateReamsLoginIdを設定します。
         *
         * @param lastUpdateReamsLoginId
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
         * @param shinseishoKanriNo
         * @return builder
         */
        public Builder setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
            Objects.requireNonNull(shinseishoKanriNo);
            this.entity.setShinseishoKanriNo(shinseishoKanriNo);
            return this;
        }

        /**
         * zenkaiShinseishoKanriNoを設定します。
         *
         * @param zenkaiShinseishoKanriNo
         * @return builder
         */
        public Builder setZenkaiShinseishoKanriNo(ShinseishoKanriNo zenkaiShinseishoKanriNo) {
            Objects.requireNonNull(zenkaiShinseishoKanriNo);
            this.entity.setZenkaiShinseishoKanriNo(zenkaiShinseishoKanriNo);
            return this;
        }

        /**
         * {@link HokenshaShinseiRirekiJoho}を生成します。
         *
         * @return {@link HokenshaShinseiRirekiJoho}
         */
        public HokenshaShinseiRirekiJoho build() {
            return new HokenshaShinseiRirekiJoho(this);
        }
    }

    /**
     * このオブジェクトのシリアライズ形式を提供します。 戻り値である{@link Serializable}のインスタンスは、デシリアライズ時に、このオブジェクトを生成します。
     *
     * @return このオブジェクトのシリアライズ形式
     */
    public Serializable serialize() {
        return new _SerializationProxy(this);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2312003884174406154L;

        private final DbT4121ShinseiRirekiJohoEntity entity;

        private _SerializationProxy(HokenshaShinseiRirekiJoho hokenshaShinseiRirekiJoho) {
            this.entity = hokenshaShinseiRirekiJoho.entity;
        }

        private Object readResolve() {
            return new HokenshaShinseiRirekiJoho(entity);
        }
    }

}
