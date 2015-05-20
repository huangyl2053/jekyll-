/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import java.util.Objects;

/**
 * 調査員情報のモデルクラスです。
 *
 * @author n8223 朴義一
 */
public class HokenshaChosainJoho {

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
    public DbT4913ChosainJohoEntity getEntity() {
        return entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public ShichosonCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainNo();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 調査員氏名カナを返します。
     *
     * @return 調査員氏名カナ
     */
    public RString get調査員氏名カナ() {
        return entity.getChosainKanaShimei();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.getChosainShikaku();
    }

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    public RString get地区コード() {
        return entity.getChikuCode();
    }

    /**
     * 調査可能人数月を返します。
     *
     * @return 調査可能人数月
     */
    public int get調査可能人数月() {
        return entity.getChosaKanoNinzuPerMonth();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean get状況フラグ() {
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
    public EntityDataState getState() {
        return entity.getState();
    }

    private HokenshaChosainJoho(Builder builder) {
        this.entity = builder.entity;
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
    public static final class Builder {

        private final DbT4913ChosainJohoEntity entity;

        Builder() {
            this.entity = new DbT4913ChosainJohoEntity();
        }

        private Builder(HokenshaChosainJoho chosainJohoJukyu) {
            this.entity = chosainJohoJukyu.entity.clone();
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
         * shichosonCodeを設定します。
         *
         * @param shichosonCode
         * @return builder
         */
        public Builder setShichosonCode(ShichosonCode shichosonCode) {
            Objects.requireNonNull(shichosonCode);
            this.entity.setShichosonCode(shichosonCode);
            return this;
        }

        /**
         * ninteichosaItakusakiCodeを設定します。
         *
         * @param ninteichosaItakusakiCode
         * @return builder
         */
        public Builder setNinteichosaItakusakiCode(RString ninteichosaItakusakiCode) {
            Objects.requireNonNull(ninteichosaItakusakiCode);
            this.entity.setNinteichosaItakusakiCode(ninteichosaItakusakiCode);
            return this;
        }

        /**
         * ninteiChosainNoを設定します。
         *
         * @param ninteiChosainNo
         * @return builder
         */
        public Builder setNinteiChosainNo(RString ninteiChosainNo) {
            Objects.requireNonNull(ninteiChosainNo);
            this.entity.setNinteiChosainNo(ninteiChosainNo);
            return this;
        }

        /**
         * chosainShimeiを設定します。
         *
         * @param chosainShimei
         * @return builder
         */
        public Builder setChosainShimei(RString chosainShimei) {
            Objects.requireNonNull(chosainShimei);
            this.entity.setChosainShimei(chosainShimei);
            return this;
        }

        /**
         * chosainKanaShimeiを設定します。
         *
         * @param chosainKanaShimei
         * @return builder
         */
        public Builder setChosainKanaShimei(RString chosainKanaShimei) {
            Objects.requireNonNull(chosainKanaShimei);
            this.entity.setChosainKanaShimei(chosainKanaShimei);
            return this;
        }

        /**
         * seibetsuを設定します。
         *
         * @param seibetsu
         * @return builder
         */
        public Builder setSeibetsu(RString seibetsu) {
            Objects.requireNonNull(seibetsu);
            this.entity.setSeibetsu(seibetsu);
            return this;
        }

        /**
         * chosainShikakuを設定します。
         *
         * @param chosainShikaku
         * @return builder
         */
        public Builder setChosainShikaku(RString chosainShikaku) {
            Objects.requireNonNull(chosainShikaku);
            this.entity.setChosainShikaku(chosainShikaku);
            return this;
        }

        /**
         * chikuCodeを設定します。
         *
         * @param chikuCode
         * @return builder
         */
        public Builder setChikuCode(RString chikuCode) {
            Objects.requireNonNull(chikuCode);
            this.entity.setChikuCode(chikuCode);
            return this;
        }

        /**
         * chosaKanoNinzuPerMonthを設定します。
         *
         * @param chosaKanoNinzuPerMonth
         * @return builder
         */
        public Builder setChosaKanoNinzuPerMonth(int chosaKanoNinzuPerMonth) {
            this.entity.setChosaKanoNinzuPerMonth(chosaKanoNinzuPerMonth);
            return this;
        }

        /**
         * yubinNoを設定します。
         *
         * @param yubinNo
         * @return builder
         */
        public Builder setYubinNo(YubinNo yubinNo) {
            Objects.requireNonNull(yubinNo);
            this.entity.setYubinNo(yubinNo);
            return this;
        }

        /**
         * jushoを設定します。
         *
         * @param jusho
         * @return builder
         */
        public Builder setJusho(AtenaJusho jusho) {
            Objects.requireNonNull(jusho);
            this.entity.setJusho(jusho);
            return this;
        }

        /**
         * telNoを設定します。
         *
         * @param telNo
         * @return builder
         */
        public Builder setTelNo(TelNo telNo) {
            Objects.requireNonNull(telNo);
            this.entity.setTelNo(telNo);
            return this;
        }

        /**
         * faxNoを設定します。
         *
         * @param faxNo
         * @return builder
         */
        public Builder setFaxNo(TelNo faxNo) {
            Objects.requireNonNull(faxNo);
            this.entity.setFaxNo(faxNo);
            return this;
        }

        /**
         * JokyoFlagを設定します。
         *
         * @param JokyoFlag
         * @return builder
         */
        public Builder setJokyoFlag(boolean JokyoFlag) {
            this.entity.setJokyoFlag(JokyoFlag);
            return this;
        }

        /**
         * {@link HokenshaChosainJoho}を生成します。
         *
         * @return {@link HokenshaChosainJoho}
         */
        public HokenshaChosainJoho build() {
            return new HokenshaChosainJoho(this);
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
