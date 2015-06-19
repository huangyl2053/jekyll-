/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 認定調査委託先情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class ShinsakaiNinteichosaItakusakiJoho implements Serializable, INinteichosaItakusakiJoho {

    private DbT5910NinteichosaItakusakiJohoEntity entity;

    private ShinsakaiNinteichosaItakusakiJoho() {
        this.entity = new DbT5910NinteichosaItakusakiJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5910NinteichosaItakusakiJohoEntity
     */
    public ShinsakaiNinteichosaItakusakiJoho(DbT5910NinteichosaItakusakiJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5910NinteichosaItakusakiJohoEntityを返します。
     *
     * @return DbT5910NinteichosaItakusakiJohoEntity
     */
    public DbT5910NinteichosaItakusakiJohoEntity getEntity() {
        return entity;
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
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    @Override
    public ChosaItakusakiCode get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    @Override
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    @Override
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    @Override
    public RString get事業者名称カナ() {
        return entity.getJigyoshaMeishoKana();
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
    public AtenaMeisho get代表者名() {
        return entity.getDaihyoshaName();
    }

    /**
     * 調査委託区分を返します。
     *
     * @return 調査委託区分
     */
    @Override
    public RString get調査委託区分() {
        return entity.getChosaItakuKubun();
    }

    /**
     * 割付定員を返します。
     *
     * @return 割付定員
     */
    @Override
    public int get割付定員() {
        return entity.getWaritsukeTeiin();
    }

    /**
     * 割付地区を返します。
     *
     * @return 割付地区
     */
    @Override
    public ChikuCode get割付地区() {
        return entity.getWaritsukeChiku();
    }

    /**
     * 自動割付フラグを返します。
     *
     * @return 自動割付フラグ
     */
    @Override
    public boolean get自動割付フラグ() {
        return entity.getAutoWaritsukeFlag();
    }

    /**
     * 機関の区分を返します。
     *
     * @return 機関の区分
     */
    @Override
    public RString get機関の区分() {
        return entity.getKikanKubun();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    @Override
    public boolean get状況フラグ() {
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

    private ShinsakaiNinteichosaItakusakiJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT5910NinteichosaItakusakiJohoEntity
     */
    public DbT5910NinteichosaItakusakiJohoEntity toEntity() {
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
     * 新しい{@link ShinsakaiNinteichosaItakusakiJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link ShinsakaiNinteichosaItakusakiJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends INinteichosaItakusakiJoho.Builder {

        private DbT5910NinteichosaItakusakiJohoEntity entity;

        Builder() {
            this.entity = new DbT5910NinteichosaItakusakiJohoEntity();
        }

        private Builder(ShinsakaiNinteichosaItakusakiJoho ninteichosaItakusakiJohoNintei) {
            this.entity = ninteichosaItakusakiJohoNintei.entity.clone();
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
         * jigyoshaNoを設定します。
         *
         * @param jigyoshaNo 事業者番号
         * @return builder
         */
        @Override
        public Builder setJigyoshaNo(JigyoshaNo jigyoshaNo) {
            Objects.requireNonNull(jigyoshaNo);
            this.entity.setJigyoshaNo(jigyoshaNo);
            return this;
        }

        /**
         * jigyoshaMeishoを設定します。
         *
         * @param jigyoshaMeisho 事業者名称
         * @return builder
         */
        @Override
        public Builder setJigyoshaMeisho(RString jigyoshaMeisho) {
            Objects.requireNonNull(jigyoshaMeisho);
            this.entity.setJigyoshaMeisho(jigyoshaMeisho);
            return this;
        }

        /**
         * jigyoshaMeishoKanaを設定します。
         *
         * @param jigyoshaMeishoKana 事業者名称カナ
         * @return builder
         */
        @Override
        public Builder setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
            Objects.requireNonNull(jigyoshaMeishoKana);
            this.entity.setJigyoshaMeishoKana(jigyoshaMeishoKana);
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
        public Builder setDaihyoshaName(AtenaMeisho daihyoshaName) {
            Objects.requireNonNull(daihyoshaName);
            this.entity.setDaihyoshaName(daihyoshaName);
            return this;
        }

        /**
         * chosaItakuKubunを設定します。
         *
         * @param chosaItakuKubun 調査委託区分
         * @return builder
         */
        @Override
        public Builder setChosaItakuKubun(RString chosaItakuKubun) {
            Objects.requireNonNull(chosaItakuKubun);
            this.entity.setChosaItakuKubun(chosaItakuKubun);
            return this;
        }

        /**
         * waritsukeTeiinを設定します。
         *
         * @param waritsukeTeiin 割付定員
         * @return builder
         */
        @Override
        public Builder setWaritsukeTeiin(int waritsukeTeiin) {
            this.entity.setWaritsukeTeiin(waritsukeTeiin);
            return this;
        }

        /**
         * waritsukeChikuを設定します。
         *
         * @param waritsukeChiku 割付地区
         * @return builder
         */
        @Override
        public Builder setWaritsukeChiku(ChikuCode waritsukeChiku) {
            Objects.requireNonNull(waritsukeChiku);
            this.entity.setWaritsukeChiku(waritsukeChiku);
            return this;
        }

        /**
         * autoWaritsukeFlagを設定します。
         *
         * @param autoWaritsukeFlag 自動割付フラグ
         * @return builder
         */
        @Override
        public Builder setAutoWaritsukeFlag(boolean autoWaritsukeFlag) {
            this.entity.setAutoWaritsukeFlag(autoWaritsukeFlag);
            return this;
        }

        /**
         * kikanKubunを設定します。
         *
         * @param kikanKubun 機関の区分
         * @return builder
         */
        @Override
        public Builder setKikanKubun(RString kikanKubun) {
            Objects.requireNonNull(kikanKubun);
            this.entity.setKikanKubun(kikanKubun);
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
         * {@link ShinsakaiNinteichosaItakusakiJoho}を生成します。
         *
         * @return {@link ShinsakaiNinteichosaItakusakiJoho}
         */
        @Override
        public ShinsakaiNinteichosaItakusakiJoho build() {
            return new ShinsakaiNinteichosaItakusakiJoho(this);
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

        private static final long serialVersionUID = -4863016133559721743L;

        private final DbT5910NinteichosaItakusakiJohoEntity entity;

        private _SerializationProxy(ShinsakaiNinteichosaItakusakiJoho ninteichosaItakusakiJohoNintei) {
            this.entity = ninteichosaItakusakiJohoNintei.entity;
        }

        private Object readResolve() {
            return new ShinsakaiNinteichosaItakusakiJoho(entity);
        }
    }
}
