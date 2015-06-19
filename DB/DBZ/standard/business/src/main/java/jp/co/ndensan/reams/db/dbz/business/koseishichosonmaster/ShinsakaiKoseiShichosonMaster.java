/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.koseishichosonmaster;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;

/**
 * 構成市町村マスタのビジネスクラスです。（認定・受給）
 *
 * @author n8223 朴義一
 */
public class ShinsakaiKoseiShichosonMaster implements IKoseiShichosonMaster {

    private DbT5051KoseiShichosonMasterEntity entity;

    private ShinsakaiKoseiShichosonMaster() {
        entity = new DbT5051KoseiShichosonMasterEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT5051KoseiShichosonMasterEntity
     */
    public ShinsakaiKoseiShichosonMaster(DbT5051KoseiShichosonMasterEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT5051KoseiShichosonMasterEntityを返します。
     *
     * @return DbT5051KoseiShichosonMasterEntity
     */
    @Override
    public DbT5051KoseiShichosonMasterEntity getEntity() {
        return entity;
    }

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    @Override
    public RString get市町村識別ID() {
        return entity.getShichosonShokibetsuID();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    @Override
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 国保連広域内市町村番号を返します。
     *
     * @return 国保連広域内市町村番号
     */
    @Override
    public RString get国保連広域内市町村番号() {
        return entity.getKokuhorenKoikiShichosonNo();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    @Override
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
    }

    /**
     * 都道府県名称を返します。
     *
     * @return 都道府県名称
     */
    @Override
    public RString get都道府県名称() {
        return entity.getTodofukenMeisho();
    }

    /**
     * 郡名称を返します。
     *
     * @return 郡名称
     */
    @Override
    public RString get郡名称() {
        return entity.getGunMeisho();
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
     * 最優先地区コードを返します。
     *
     * @return 最優先地区コード
     */
    @Override
    public RString get最優先地区コード() {
        return entity.getYusenChikuCode();
    }

    /**
     * 帳票用都道府県名称表示有無を返します。
     *
     * @return 帳票用都道府県名称表示有無
     */
    @Override
    public RString get帳票用都道府県名称表示有無() {
        return entity.getTyohyoTodoufukenHyojiUmu();
    }

    /**
     * 帳票用郡名称表示有無を返します。
     *
     * @return 帳票用郡名称表示有無
     */
    @Override
    public RString get帳票用郡名称表示有無() {
        return entity.getTyohyoGunHyojiUmu();
    }

    /**
     * 帳票用市町村名称表示有無を返します。
     *
     * @return 帳票用市町村名称表示有無
     */
    @Override
    public RString get帳票用市町村名称表示有無() {
        return entity.getTyohyoShichosonHyojiUmu();
    }

    /**
     * 帳票用住所編集方法を返します。
     *
     * @return 帳票用住所編集方法
     */
    @Override
    public RString get帳票用住所編集方法() {
        return entity.getTyohyoJushoHenshuHouhou();
    }

    /**
     * 帳票用方書表示有無を返します。
     *
     * @return 帳票用方書表示有無
     */
    @Override
    public RString get帳票用方書表示有無() {
        return entity.getTyohyoKatagakiHyojiUmu();
    }

    /**
     * 外国人氏名表示方法を返します。
     *
     * @return 外国人氏名表示方法
     */
    @Override
    public RString get外国人氏名表示方法() {
        return entity.getGaikokujinHyojiHouhou();
    }

    /**
     * 老人保健市町村番号を返します。
     *
     * @return 老人保健市町村番号
     */
    @Override
    public RString get老人保健市町村番号() {
        return entity.getRojinhokenShichosonNo();
    }

    /**
     * 老人保健受給者番号体系を返します。
     *
     * @return 老人保健受給者番号体系
     */
    @Override
    public RString get老人保健受給者番号体系() {
        return entity.getRokenJukyushaNoTaikei();
    }

    /**
     * 特徴分配集約を返します。
     *
     * @return 特徴分配集約
     */
    @Override
    public RString get特徴分配集約() {
        return entity.getTokuchoBunpaishuyaku();
    }

    /**
     * 移行日を返します。
     *
     * @return 移行日
     */
    @Override
    public FlexibleDate get移行日() {
        return entity.getIkoYMD();
    }

    /**
     * 加入日を返します。
     *
     * @return 加入日
     */
    @Override
    public FlexibleDate get加入日() {
        return entity.getKanyuYMD();
    }

    /**
     * 離脱日を返します。
     *
     * @return 離脱日
     */
    @Override
    public FlexibleDate get離脱日() {
        return entity.getRidatsuYMD();
    }

    /**
     * 合併旧市町村区分を返します。
     *
     * @return 合併旧市町村区分
     */
    @Override
    public RString get合併旧市町村区分() {
        return entity.getGappeiKyuShichosonKubun();
    }

    /**
     * 合併旧市町村表示有無を返します。
     *
     * @return 合併旧市町村表示有無
     */
    @Override
    public RString get合併旧市町村表示有無() {
        return entity.getGappeiKyuShichosonHyojiUmu();
    }

    /**
     * 合併情報地域番号を返します。
     *
     * @return 合併情報地域番号
     */
    @Override
    public RString get合併情報地域番号() {
        return entity.getGappeiChiikiNo();
    }

    /**
     * 運用保険者番号を返します。
     *
     * @return 運用保険者番号
     */
    @Override
    public ShoKisaiHokenshaNo get運用保険者番号() {
        return entity.getUnyoHokenshaNo();
    }

    /**
     * 運用開始日を返します。
     *
     * @return 運用開始日
     */
    @Override
    public FlexibleDate get運用開始日() {
        return entity.getUnyoKaishiYMD();
    }

    /**
     * 運用終了日を返します。
     *
     * @return 運用終了日
     */
    @Override
    public FlexibleDate get運用終了日() {
        return entity.getUnyoShuryoYMD();
    }

    /**
     * 運用形態区分を返します。
     *
     * @return 運用形態区分
     */
    @Override
    public RString get運用形態区分() {
        return entity.getUnyoKeitaiKubun();
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

    private ShinsakaiKoseiShichosonMaster(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT5051KoseiShichosonMasterEntity
     */
    public DbT5051KoseiShichosonMasterEntity toEntity() {
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
     * 新しい{@link ShinsakaiKoseiShichosonMaster}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link ShinsakaiKoseiShichosonMaster}を生成するためのビルダーです。
     */
    public static final class Builder extends IKoseiShichosonMaster.Builder {

        private DbT5051KoseiShichosonMasterEntity entity;

        Builder() {
            this.entity = new DbT5051KoseiShichosonMasterEntity();
        }

        Builder(ShinsakaiKoseiShichosonMaster shinsakaiKoseiShichosonMaster) {
            this.entity = shinsakaiKoseiShichosonMaster.entity.clone();
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
         * shichosonShokibetsuIDを設定します。
         *
         * @param shichosonShokibetsuID 市町村識別ID
         * @return builder
         */
        @Override
        public Builder setShichosonShokibetsuID(RString shichosonShokibetsuID) {
            Objects.requireNonNull(shichosonShokibetsuID);
            this.entity.setShichosonShokibetsuID(shichosonShokibetsuID);
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
         * shoKisaiHokenshaNoを設定します。
         *
         * @param shoKisaiHokenshaNo 証記載保険者番号
         * @return builder
         */
        @Override
        public Builder setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
            Objects.requireNonNull(shoKisaiHokenshaNo);
            this.entity.setShoKisaiHokenshaNo(shoKisaiHokenshaNo);
            return this;
        }

        /**
         * kokuhorenKoikiShichosonNoを設定します。
         *
         * @param kokuhorenKoikiShichosonNo 国保連広域内市町村番号
         * @return builder
         */
        @Override
        public Builder setKokuhorenKoikiShichosonNo(RString kokuhorenKoikiShichosonNo) {
            Objects.requireNonNull(kokuhorenKoikiShichosonNo);
            this.entity.setKokuhorenKoikiShichosonNo(kokuhorenKoikiShichosonNo);
            return this;
        }

        /**
         * shichosonMeishoを設定します。
         *
         * @param shichosonMeisho 市町村名称
         * @return builder
         */
        @Override
        public Builder setShichosonMeisho(RString shichosonMeisho) {
            Objects.requireNonNull(shichosonMeisho);
            this.entity.setShichosonMeisho(shichosonMeisho);
            return this;
        }

        /**
         * todofukenMeishoを設定します。
         *
         * @param todofukenMeisho 都道府県名称
         * @return builder
         */
        @Override
        public Builder setTodofukenMeisho(RString todofukenMeisho) {
            Objects.requireNonNull(todofukenMeisho);
            this.entity.setTodofukenMeisho(todofukenMeisho);
            return this;
        }

        /**
         * gunMeishoを設定します。
         *
         * @param gunMeisho 郡名称
         * @return builder
         */
        @Override
        public Builder setGunMeisho(RString gunMeisho) {
            Objects.requireNonNull(gunMeisho);
            this.entity.setGunMeisho(gunMeisho);
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
         * yusenChikuCodeを設定します。
         *
         * @param yusenChikuCode 電話番号
         * @return builder
         */
        @Override
        public Builder setYusenChikuCode(RString yusenChikuCode) {
            Objects.requireNonNull(yusenChikuCode);
            this.entity.setYusenChikuCode(yusenChikuCode);
            return this;
        }

        /**
         * tyohyoTodoufukenHyojiUmuを設定します。
         *
         * @param tyohyoTodoufukenHyojiUmu 帳票用都道府県名称表示有無
         * @return builder
         */
        @Override
        public Builder setTyohyoTodoufukenHyojiUmu(RString tyohyoTodoufukenHyojiUmu) {
            Objects.requireNonNull(tyohyoTodoufukenHyojiUmu);
            this.entity.setTyohyoTodoufukenHyojiUmu(tyohyoTodoufukenHyojiUmu);
            return this;
        }

        /**
         * tyohyoGunHyojiUmuを設定します。
         *
         * @param tyohyoGunHyojiUmu 帳票用郡名称表示有無
         * @return builder
         */
        @Override
        public Builder setTyohyoGunHyojiUmu(RString tyohyoGunHyojiUmu) {
            Objects.requireNonNull(tyohyoGunHyojiUmu);
            this.entity.setTyohyoGunHyojiUmu(tyohyoGunHyojiUmu);
            return this;
        }

        /**
         * tyohyoShichosonHyojiUmuを設定します。
         *
         * @param tyohyoShichosonHyojiUmu 帳票用市町村名称表示有無
         * @return builder
         */
        @Override
        public Builder setTyohyoShichosonHyojiUmu(RString tyohyoShichosonHyojiUmu) {
            Objects.requireNonNull(tyohyoShichosonHyojiUmu);
            this.entity.setTyohyoShichosonHyojiUmu(tyohyoShichosonHyojiUmu);
            return this;
        }

        /**
         * tyohyoJushoHenshuHouhouを設定します。
         *
         * @param tyohyoJushoHenshuHouhou 帳票用住所編集方法
         * @return builder
         */
        @Override
        public Builder setTyohyoJushoHenshuHouhou(RString tyohyoJushoHenshuHouhou) {
            Objects.requireNonNull(tyohyoJushoHenshuHouhou);
            this.entity.setTyohyoJushoHenshuHouhou(tyohyoJushoHenshuHouhou);
            return this;
        }

        /**
         * tyohyoKatagakiHyojiUmuを設定します。
         *
         * @param tyohyoKatagakiHyojiUmu 帳票用方書表示有無
         * @return builder
         */
        @Override
        public Builder setTyohyoKatagakiHyojiUmu(RString tyohyoKatagakiHyojiUmu) {
            Objects.requireNonNull(tyohyoKatagakiHyojiUmu);
            this.entity.setTyohyoKatagakiHyojiUmu(tyohyoKatagakiHyojiUmu);
            return this;
        }

        /**
         * gaikokujinHyojiHouhouを設定します。
         *
         * @param gaikokujinHyojiHouhou 外国人氏名表示方法
         * @return builder
         */
        @Override
        public Builder setGaikokujinHyojiHouhou(RString gaikokujinHyojiHouhou) {
            Objects.requireNonNull(gaikokujinHyojiHouhou);
            this.entity.setGaikokujinHyojiHouhou(gaikokujinHyojiHouhou);
            return this;
        }

        /**
         * rojinhokenShichosonNoを設定します。
         *
         * @param rojinhokenShichosonNo 老人保健市町村番号
         * @return builder
         */
        @Override
        public Builder setRojinhokenShichosonNo(RString rojinhokenShichosonNo) {
            Objects.requireNonNull(rojinhokenShichosonNo);
            this.entity.setRojinhokenShichosonNo(rojinhokenShichosonNo);
            return this;
        }

        /**
         * rokenJukyushaNoTaikeiを設定します。
         *
         * @param rokenJukyushaNoTaikei 老人保健受給者番号体系
         * @return builder
         */
        @Override
        public Builder setRokenJukyushaNoTaikei(RString rokenJukyushaNoTaikei) {
            Objects.requireNonNull(rokenJukyushaNoTaikei);
            this.entity.setRokenJukyushaNoTaikei(rokenJukyushaNoTaikei);
            return this;
        }

        /**
         * tokuchoBunpaishuyakuを設定します。
         *
         * @param tokuchoBunpaishuyaku 特徴分配集約
         * @return builder
         */
        @Override
        public Builder setTokuchoBunpaishuyaku(RString tokuchoBunpaishuyaku) {
            Objects.requireNonNull(tokuchoBunpaishuyaku);
            this.entity.setTokuchoBunpaishuyaku(tokuchoBunpaishuyaku);
            return this;
        }

        /**
         * ikoYMDを設定します。
         *
         * @param ikoYMD 移行日
         * @return builder
         */
        @Override
        public Builder setIkoYMD(FlexibleDate ikoYMD) {
            Objects.requireNonNull(ikoYMD);
            this.entity.setIkoYMD(ikoYMD);
            return this;
        }

        /**
         * kanyuYMDを設定します。
         *
         * @param kanyuYMD 加入日
         * @return builder
         */
        @Override
        public Builder setKanyuYMD(FlexibleDate kanyuYMD) {
            Objects.requireNonNull(kanyuYMD);
            this.entity.setKanyuYMD(kanyuYMD);
            return this;
        }

        /**
         * ridatsuYMDを設定します。
         *
         * @param ridatsuYMD 離脱日
         * @return builder
         */
        @Override
        public Builder setRidatsuYMD(FlexibleDate ridatsuYMD) {
            Objects.requireNonNull(ridatsuYMD);
            this.entity.setRidatsuYMD(ridatsuYMD);
            return this;
        }

        /**
         * gappeiKyuShichosonKubunを設定します。
         *
         * @param gappeiKyuShichosonKubun 合併旧市町村区分
         * @return builder
         */
        @Override
        public Builder setGappeiKyuShichosonKubun(RString gappeiKyuShichosonKubun) {
            Objects.requireNonNull(gappeiKyuShichosonKubun);
            this.entity.setGappeiKyuShichosonKubun(gappeiKyuShichosonKubun);
            return this;
        }

        /**
         * gappeiKyuShichosonHyojiUmuを設定します。
         *
         * @param gappeiKyuShichosonHyojiUmu 合併旧市町村表示有無
         * @return builder
         */
        @Override
        public Builder setGappeiKyuShichosonHyojiUmu(RString gappeiKyuShichosonHyojiUmu) {
            Objects.requireNonNull(gappeiKyuShichosonHyojiUmu);
            this.entity.setGappeiKyuShichosonHyojiUmu(gappeiKyuShichosonHyojiUmu);
            return this;
        }

        /**
         * gappeiChiikiNoを設定します。
         *
         * @param gappeiChiikiNo 合併情報地域番号
         * @return builder
         */
        @Override
        public Builder setGappeiChiikiNo(RString gappeiChiikiNo) {
            Objects.requireNonNull(gappeiChiikiNo);
            this.entity.setGappeiChiikiNo(gappeiChiikiNo);
            return this;
        }

        /**
         * unyoHokenshaNoを設定します。
         *
         * @param unyoHokenshaNo 運用保険者番号
         * @return builder
         */
        @Override
        public Builder setUnyoHokenshaNo(ShoKisaiHokenshaNo unyoHokenshaNo) {
            Objects.requireNonNull(unyoHokenshaNo);
            this.entity.setUnyoHokenshaNo(unyoHokenshaNo);
            return this;
        }

        /**
         * unyoKaishiYMDを設定します。
         *
         * @param unyoKaishiYMD 運用開始日
         * @return builder
         */
        @Override
        public Builder setUnyoKaishiYMD(FlexibleDate unyoKaishiYMD) {
            Objects.requireNonNull(unyoKaishiYMD);
            this.entity.setUnyoKaishiYMD(unyoKaishiYMD);
            return this;
        }

        /**
         * unyoShuryoYMDを設定します。
         *
         * @param unyoShuryoYMD 運用終了日
         * @return builder
         */
        @Override
        public Builder setUnyoShuryoYMD(FlexibleDate unyoShuryoYMD) {
            Objects.requireNonNull(unyoShuryoYMD);
            this.entity.setUnyoShuryoYMD(unyoShuryoYMD);
            return this;
        }

        /**
         * unyoKeitaiKubunを設定します。
         *
         * @param unyoKeitaiKubun 運用形態区分
         * @return builder
         */
        @Override
        public Builder setUnyoKeitaiKubun(RString unyoKeitaiKubun) {
            Objects.requireNonNull(unyoKeitaiKubun);
            this.entity.setUnyoKeitaiKubun(unyoKeitaiKubun);
            return this;
        }

        /**
         * {@link ShinsakaiKoseiShichosonMaster}を生成します。
         *
         * @return {@link ShinsakaiKoseiShichosonMaster}
         */
        @Override
        public ShinsakaiKoseiShichosonMaster build() {
            return new ShinsakaiKoseiShichosonMaster(this);
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

        private static final long serialVersionUID = -5097703917847906736L;

        private final DbT5051KoseiShichosonMasterEntity entity;

        private _SerializationProxy(ShinsakaiKoseiShichosonMaster shinsakaiKoseiShichosonMaster) {
            this.entity = shinsakaiKoseiShichosonMaster.entity;
        }

        private Object readResolve() {
            return new ShinsakaiKoseiShichosonMaster(entity);
        }
    }
}
