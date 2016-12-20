/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医医療機関情報のビジネスクラスです。
 *
 * @author n8235 船山洋介
 */
public class ShinsakaiShujiiIryoKikanJoho implements IShujiiIryokikanJoho {

    private DbT5911ShujiiIryoKikanJohoEntity entity;

    /**
     * コンストラクタです。
     */
    private ShinsakaiShujiiIryoKikanJoho() {
        entity = new DbT5911ShujiiIryoKikanJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5911ShujiiIryoKikanJohoEntity 主治医医療機関情報エンティティ(受給)
     */
    public ShinsakaiShujiiIryoKikanJoho(DbT5911ShujiiIryoKikanJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報"));
    }

    /**
     * DbT5911ShujiiIryoKikanJohoEntityを返します。
     *
     * @return DbT5911ShujiiIryoKikanJohoEntity
     */
    @Override
    public DbT5911ShujiiIryoKikanJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT5911ShujiiIryoKikanJohoEntityを設定します。
     *
     * @param entity DbT5911ShujiiIryoKikanJohoEntity 主治医医療機関情報エンティティ(受給)
     */
    public void setEntity(DbT5911ShujiiIryoKikanJohoEntity entity) {
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
     * 医療機関コードを返します。
     *
     * @return 医療機関コード
     */
    @Override
    public IryoKikanCode get医療機関コード() {
        return entity.getIryokikanCode();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    @Override
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 医療機関名称カナを返します。
     *
     * @return 医療機関名称カナ
     */
    @Override
    public RString get医療機関名称カナ() {
        return entity.getIryoKikanMeishoKana();
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
    public RString get住所() {
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
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    @Override
    public RString get代表者名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 代表者名カナを返します。
     *
     * @return 代表者名カナ
     */
    @Override
    public RString get代表者名カナ() {
        return entity.getDaihyoshaNameKana();
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
     * @param deleteFlag 論理削除フラグ
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

    private ShinsakaiShujiiIryoKikanJoho(Builder builder) {
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
     * 新しい{@link ShinsakaiShujiiIryoKikanJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link ShinsakaiShujiiIryoKikanJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends IShujiiIryokikanJoho.Builder {

        private DbT5911ShujiiIryoKikanJohoEntity entity;

        Builder() {
            this.entity = new DbT5911ShujiiIryoKikanJohoEntity();
        }

        Builder(ShinsakaiShujiiIryoKikanJoho shujiiIryoKikanJohoNintei) {
            this.entity = shujiiIryoKikanJohoNintei.entity.clone();
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
         * iryokikanCodeを設定します。
         *
         * @param iryokikanCode 医療機関コード
         * @return builder
         */
        @Override
        public Builder setIryokikanCode(IryoKikanCode iryokikanCode) {
            Objects.requireNonNull(iryokikanCode);
            this.entity.setIryokikanCode(iryokikanCode);
            return this;
        }

        /**
         * iryoKikanMeishoを設定します。
         *
         * @param iryoKikanMeisho 医療機関名称
         * @return builder
         */
        @Override
        public Builder setIryoKikanMeisho(RString iryoKikanMeisho) {
            Objects.requireNonNull(iryoKikanMeisho);
            this.entity.setIryoKikanMeisho(iryoKikanMeisho);
            return this;
        }

        /**
         * iryoKikanMeishoKanaを設定します。
         *
         * @param iryoKikanMeishoKana 医療機関名称カナ
         * @return builder
         */
        @Override
        public Builder setIryoKikanMeishoKana(RString iryoKikanMeishoKana) {
            Objects.requireNonNull(iryoKikanMeishoKana);
            this.entity.setIryoKikanMeishoKana(iryoKikanMeishoKana);
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
        public Builder setJusho(RString jusho) {
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
         * daihyoshaNameを設定します。
         *
         * @param daihyoshaName 代表者名
         * @return builder
         */
        @Override
        public Builder setDaihyoshaName(RString daihyoshaName) {
            Objects.requireNonNull(daihyoshaName);
            this.entity.setDaihyoshaName(daihyoshaName);
            return this;
        }

        /**
         * daihyoshaNameKanaを設定します。
         *
         * @param daihyoshaNameKana 代表者名カナ
         * @return builder
         */
        @Override
        public Builder setDaihyoshaNameKana(RString daihyoshaNameKana) {
            Objects.requireNonNull(daihyoshaNameKana);
            this.entity.setDaihyoshaName(daihyoshaNameKana);
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
         * {@link ShinsakaiShujiiIryoKikanJoho}を生成します。
         *
         * @return {@link ShinsakaiShujiiIryoKikanJoho}
         */
        @Override
        public ShinsakaiShujiiIryoKikanJoho build() {
            return new ShinsakaiShujiiIryoKikanJoho(this);
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

        private static final long serialVersionUID = 3453594259148093463L;

        private final DbT5911ShujiiIryoKikanJohoEntity entity;

        private _SerializationProxy(ShinsakaiShujiiIryoKikanJoho shujiiIryoKikanJohoNintei) {
            this.entity = shujiiIryoKikanJohoNintei.entity;
        }

        private Object readResolve() {
            return new ShinsakaiShujiiIryoKikanJoho(entity);
        }
    }
}
