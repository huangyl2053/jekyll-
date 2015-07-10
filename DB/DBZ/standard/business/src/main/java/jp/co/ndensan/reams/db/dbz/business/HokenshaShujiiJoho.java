/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4912ShujiiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 主治医情報のビジネスクラスです。
 *
 * @author n8235 船山洋介
 */
public class HokenshaShujiiJoho implements IShujiiJoho {

    private DbT4912ShujiiJohoEntity entity;

    /**
     * コンストラクタです。
     */
    public HokenshaShujiiJoho() {
        entity = new DbT4912ShujiiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4912ShujiiJohoEntity
     */
    public HokenshaShujiiJoho(DbT4912ShujiiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4912ShujiiJohoEntityを返します。
     *
     * @return DbT4912ShujiiJohoEntity
     */
    public DbT4912ShujiiJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT4912ShujiiJohoEntityを設定します。
     *
     * @param entity DbT4912ShujiiJohoEntity
     */
    public void setEntity(DbT4912ShujiiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    @Override
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    @Override
    public ShujiiIryokikanCode get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    @Override
    public ShujiiCode get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    @Override
    public AtenaMeisho get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医カナを返します。
     *
     * @return 主治医カナ
     */
    @Override
    public AtenaKanaMeisho get主治医カナ() {
        return entity.getShujiiKana();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    @Override
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    @Override
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    @Override
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    @Override
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 診療科名称を返します。
     *
     * @return 診療科名称
     */
    @Override
    public RString get診療科名称() {
        return entity.getShinryokaName();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    @Override
    public boolean is指定医フラグ() {
        return entity.getShiteiiFlag();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    @Override
    public boolean is状況フラグ() {
        return entity.getJokyoFlag();
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
    @Override
    public EntityDataState getState() {
        return entity.getState();
    }

    private HokenshaShujiiJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 編集用のビルダーを返します。
     *
     * @return ビルダー
     */
    @Override
    public Builder createBuilderForEdit() {
        return new Builder(this);
    }

    /**
     * 新しい{@link HokenshaShujiiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link HokenshaShujiiJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends IShujiiJoho.Builder {

        private DbT4912ShujiiJohoEntity entity;

        Builder() {
            this.entity = new DbT4912ShujiiJohoEntity();
        }

        Builder(HokenshaShujiiJoho shujiiJohoJukyu) {
            this.entity = shujiiJohoJukyu.entity.clone();
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
         * @param isDeleted 論理削除フラグ
         * @return builder
         */
        public Builder setIsDeleted(boolean isDeleted) {
            this.entity.setIsDeleted(isDeleted);
            return this;
        }

        /**
         * lastUpdateReamsLoginIdを設定します。
         *
         * @param lastUpdateReamsLoginId 最終更新ユーザーId
         * @return builder
         */
        public Builder setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
            Objects.requireNonNull(lastUpdateReamsLoginId);
            this.entity.setLastUpdateReamsLoginId(lastUpdateReamsLoginId);
            return this;
        }

        /**
         * shichosonCodeを設定します。
         *
         * @param shichosonCode 市町村コード
         * @return builder
         */
        @Override
        public Builder setShichosonCode(LasdecCode shichosonCode) {
            Objects.requireNonNull(shichosonCode);
            this.entity.setShichosonCode(shichosonCode);
            return this;
        }

        /**
         * shujiiIryokikanCodeを設定します。
         *
         * @param shujiiIryokikanCode 主治医医療機関コード
         * @return builder
         */
        @Override
        public Builder setShujiiIryokikanCode(ShujiiIryokikanCode shujiiIryokikanCode) {
            Objects.requireNonNull(shujiiIryokikanCode);
            this.entity.setShujiiIryokikanCode(shujiiIryokikanCode);
            return this;
        }

        /**
         * shujiiCodeを設定します。
         *
         * @param shujiiCode 主治医コード
         * @return builder
         */
        @Override
        public Builder setShujiiCode(ShujiiCode shujiiCode) {
            Objects.requireNonNull(shujiiCode);
            this.entity.setShujiiCode(shujiiCode);
            return this;
        }

        /**
         * shujiiNameを設定します。
         *
         * @param shujiiName 主治医氏名
         * @return builder
         */
        @Override
        public Builder setShujiiName(AtenaMeisho shujiiName) {
            Objects.requireNonNull(shujiiName);
            this.entity.setShujiiName(shujiiName);
            return this;
        }

        /**
         * shujiiKanaを設定します。
         *
         * @param shujiiKana 主治医カナ
         * @return builder
         */
        @Override
        public Builder setShujiiKana(AtenaKanaMeisho shujiiKana) {
            Objects.requireNonNull(shujiiKana);
            this.entity.setShujiiKana(shujiiKana);
            return this;
        }

        /**
         * yubinNoを設定します。
         *
         * @param yubinNo 郵便番号
         * @return builder
         */
        @Override
        public Builder setYubinNo(YubinNo yubinNo) {
            Objects.requireNonNull(yubinNo);
            this.entity.setYubinNo(yubinNo);
            return this;
        }

        /**
         * jushoを設定します。
         *
         * @param jusho 住所
         * @return builder
         */
        @Override
        public Builder setJusho(AtenaJusho jusho) {
            Objects.requireNonNull(jusho);
            this.entity.setJusho(jusho);
            return this;
        }

        /**
         * telNoを設定します。
         *
         * @param telNo 電話番号
         * @return builder
         */
        @Override
        public Builder setTelNo(TelNo telNo) {
            Objects.requireNonNull(telNo);
            this.entity.setTelNo(telNo);
            return this;
        }

        /**
         * faxNoを設定します。
         *
         * @param faxNo FAX番号
         * @return builder
         */
        @Override
        public Builder setFaxNo(TelNo faxNo) {
            Objects.requireNonNull(faxNo);
            this.entity.setFaxNo(faxNo);
            return this;
        }

        /**
         * shinryokaNameを設定します。
         *
         * @param shinryokaName 診療科名称
         * @return builder
         */
        @Override
        public Builder setShinryokaName(RString shinryokaName) {
            Objects.requireNonNull(shinryokaName);
            this.entity.setShinryokaName(shinryokaName);
            return this;
        }

        /**
         * shiteiiFlagを設定します。
         *
         * @param shiteiiFlag 指定医フラグ
         * @return builder
         */
        @Override
        public Builder setShiteiiFlag(boolean shiteiiFlag) {
            this.entity.setShiteiiFlag(shiteiiFlag);
            return this;
        }

        /**
         * JokyoFlagを設定します。
         *
         * @param jokyoFlag 状況フラグ
         * @return builder
         */
        @Override
        public Builder setJokyoFlag(boolean jokyoFlag) {
            this.entity.setJokyoFlag(jokyoFlag);
            return this;
        }

        /**
         * {@link HokenshaShujiiJoho}を生成します。
         *
         * @return {@link HokenshaShujiiJoho}
         */
        @Override
        public HokenshaShujiiJoho build() {
            return new HokenshaShujiiJoho(this);
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

        private static final long serialVersionUID = -7639467188441851900L;

        private final DbT4912ShujiiJohoEntity entity;

        private _SerializationProxy(HokenshaShujiiJoho shujiiJohoJukyu) {
            this.entity = shujiiJohoJukyu.entity;
        }

        private Object readResolve() {
            return new HokenshaShujiiJoho(entity);
        }
    }
}
