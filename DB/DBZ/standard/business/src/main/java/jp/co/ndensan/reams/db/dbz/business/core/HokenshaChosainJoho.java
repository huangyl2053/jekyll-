/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 調査員情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class HokenshaChosainJoho implements Serializable, IChosainJoho {

    private DbT4913ChosainJohoEntity entity;

    private HokenshaChosainJoho() {
        this.entity = new DbT4913ChosainJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4913ChosainJohoEntity
     */
    public HokenshaChosainJoho(DbT4913ChosainJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4913ChosainJohoEntityを返します。
     *
     * @return DbT4913ChosainJohoEntity
     */
//    @Override
//    public DbT4913ChosainJohoEntity getEntity() {
//        return entity;
//    }

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
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    @Override
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    @Override
    public ChosainCode get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    @Override
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    @Override
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    @Override
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    @Override
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    @Override
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 調査可能人数月を返します。
     *
     * @return 調査可能人数月
     */
    @Override
    public int get調査可能人数月() {
        return entity.getChosaKanoNinzuPerMonth();
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
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    @Override
    public boolean has状況フラグ() {
        return entity.getJokyoFlag();
    }

    /**
     * 状態を設定します。
     *
     * @param entityDataState EntityDataState
     */
    @Override
    public void setState(EntityDataState entityDataState) {
        entity.setState(entityDataState);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    @Override
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

    private HokenshaChosainJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT4913ChosainJohoEntity
     */
    public DbT4913ChosainJohoEntity toEntity() {
        return entity.clone();
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
     * 新しい{@link HokenshaChosainJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link HokenshaChosainJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends IChosainJoho.Builder {

        private final DbT4913ChosainJohoEntity entity;

        Builder() {
            this.entity = new DbT4913ChosainJohoEntity();
        }

        Builder(HokenshaChosainJoho chosainJohoJukyu) {
            this.entity = chosainJohoJukyu.entity.clone();
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
         * ninteichosaItakusakiCodeを設定します。
         *
         * @param ninteichosaItakusakiCode 認定調査委託先コード
         * @return builder
         */
        @Override
        public Builder setNinteichosaItakusakiCode(ChosaItakusakiCode ninteichosaItakusakiCode) {
            Objects.requireNonNull(ninteichosaItakusakiCode);
            this.entity.setNinteichosaItakusakiCode(ninteichosaItakusakiCode);
            return this;
        }

        /**
         * ninteiChosainNoを設定します。
         *
         * @param ninteiChosainNo 認定調査員コード
         * @return builder
         */
        @Override
        public Builder setNinteiChosainNo(ChosainCode ninteiChosainNo) {
            Objects.requireNonNull(ninteiChosainNo);
            this.entity.setNinteiChosainNo(ninteiChosainNo);
            return this;
        }

        /**
         * chosainShimeiを設定します。
         *
         * @param chosainShimei 調査員氏名
         * @return builder
         */
        @Override
        public Builder setChosainShimei(RString chosainShimei) {
            Objects.requireNonNull(chosainShimei);
            this.entity.setChosainShimei(chosainShimei);
            return this;
        }

        /**
         * chosainKanaShimeiを設定します。
         *
         * @param chosainKanaShimei 調査員氏名カナ
         * @return builder
         */
        @Override
        public Builder setChosainKanaShimei(RString chosainKanaShimei) {
            Objects.requireNonNull(chosainKanaShimei);
            this.entity.setChosainKanaShimei(chosainKanaShimei);
            return this;
        }

        /**
         * seibetsuを設定します。
         *
         * @param seibetsu 性別
         * @return builder
         */
        @Override
        public Builder setSeibetsu(RString seibetsu) {
            Objects.requireNonNull(seibetsu);
            this.entity.setSeibetsu(seibetsu);
            return this;
        }

        /**
         * chosainShikakuを設定します。
         *
         * @param chosainShikaku 調査員資格
         * @return builder
         */
        @Override
        public Builder setChosainShikaku(RString chosainShikaku) {
            Objects.requireNonNull(chosainShikaku);
            this.entity.setChosainShikaku(chosainShikaku);
            return this;
        }

        /**
         * chikuCodeを設定します。
         *
         * @param chikuCode 地区コード
         * @return builder
         */
        @Override
        public Builder setChikuCode(RString chikuCode) {
            Objects.requireNonNull(chikuCode);
            this.entity.setChikuCode(chikuCode);
            return this;
        }

        /**
         * chosaKanoNinzuPerMonthを設定します。
         *
         * @param chosaKanoNinzuPerMonth 調査可能人数／月
         * @return builder
         */
        @Override
        public Builder setChosaKanoNinzuPerMonth(int chosaKanoNinzuPerMonth) {
            this.entity.setChosaKanoNinzuPerMonth(chosaKanoNinzuPerMonth);
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
         * {@link HokenshaChosainJoho}を生成します。
         *
         * @return {@link HokenshaChosainJoho}
         */
        @Override
        public HokenshaChosainJoho build() {
            return new HokenshaChosainJoho(this);
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

        private static final long serialVersionUID = 1148931453743000196L;

        private final DbT4913ChosainJohoEntity entity;

        private _SerializationProxy(HokenshaChosainJoho chosainJohoJukyu) {
            this.entity = chosainJohoJukyu.entity;
        }

        private Object readResolve() {
            return new HokenshaChosainJoho(entity);
        }
    }
}
