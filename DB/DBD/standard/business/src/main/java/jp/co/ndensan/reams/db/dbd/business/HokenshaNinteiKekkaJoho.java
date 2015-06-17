/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報のビジネスクラスです。
 *
 * @author n8223 朴義一
 */
public class HokenshaNinteiKekkaJoho implements INinteiKekkaJoho {

    private DbT4102NinteiKekkaJohoEntity entity;

    private HokenshaNinteiKekkaJoho() {
        this.entity = new DbT4102NinteiKekkaJohoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT4102NinteiKekkaJohoEntity
     */
    public HokenshaNinteiKekkaJoho(DbT4102NinteiKekkaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT4102NinteiKekkaJohoEntityを返します。
     *
     * @return DbT4102NinteiKekkaJohoEntity
     */
    public DbT4102NinteiKekkaJohoEntity getEntity() {
        return entity;
    }

    /**
     * DbT4102NinteiKekkaJohoEntityを設定します。
     *
     * @param entity DbT4102NinteiKekkaJohoEntity
     */
    public void setEntity(DbT4102NinteiKekkaJohoEntity entity) {
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
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    @Override
    public Code get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    @Override
    public Integer get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    @Override
    public FlexibleDate get二次判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    @Override
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    @Override
    public Integer get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    @Override
    public RString get介護認定審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    @Override
    public RString get一次判定結果変更理由() {
        return entity.getIchijiHnateiKekkaHenkoRiyu();
    }

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    @Override
    public Code get要介護状態像例コード() {
        return entity.getYokaigoJotaizoReiCode();
    }

    /**
     * 認定審査会意見種類を返します。
     *
     * @return 認定審査会意見種類
     */
    @Override
    public RString get認定審査会意見種類() {
        return entity.getNinteishinsakaiIkenShurui();
    }

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    @Override
    public RString get審査会メモ() {
        return entity.getShinsakaiMemo();
    }

    /**
     * 二次判定結果入力方法を返します。
     *
     * @return 二次判定結果入力方法
     */
    @Override
    public Code get二次判定結果入力方法() {
        return entity.getNijiHanteiKekkaInputHoho();
    }

    /**
     * 二次判定結果入力年月日を返します。
     *
     * @return 二次判定結果入力年月日
     */
    @Override
    public FlexibleDate get二次判定結果入力年月日() {
        return entity.getNiniHanteiKekkaInputYMD();
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

    private HokenshaNinteiKekkaJoho(Builder builder) {
        this.entity = builder.entity;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return DbT4102NinteiKekkaJohoEntity
     */
    public DbT4102NinteiKekkaJohoEntity toEntity() {
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
     * 新しい{@link HokenshaNinteiKekkaJoho}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link HokenshaNinteiKekkaJoho}を生成するためのビルダーです。
     */
    public static final class Builder extends INinteiKekkaJoho.Builder {

        private DbT4102NinteiKekkaJohoEntity entity;

        Builder() {
            this.entity = new DbT4102NinteiKekkaJohoEntity();
        }

        Builder(HokenshaNinteiKekkaJoho hokenshaNinteiKekkaJoho) {
            this.entity = hokenshaNinteiKekkaJoho.entity.clone();
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
         * nijiHanteiYMDを設定します。
         *
         * @param nijiHanteiYMD 二次判定年月日
         * @return builder
         */
        @Override
        public Builder setNijiHanteiYMD(FlexibleDate nijiHanteiYMD) {
            Objects.requireNonNull(nijiHanteiYMD);
            this.entity.setNijiHanteiYMD(nijiHanteiYMD);
            return this;
        }

        /**
         * nijiHanteiYokaigoJotaiKubunCodeを設定します。
         *
         * @param nijiHanteiYokaigoJotaiKubunCode 二次判定要介護状態区分コード
         * @return builder
         */
        @Override
        public Builder setNijiHanteiYokaigoJotaiKubunCode(Code nijiHanteiYokaigoJotaiKubunCode) {
            Objects.requireNonNull(nijiHanteiYokaigoJotaiKubunCode);
            this.entity.setNijiHanteiYokaigoJotaiKubunCode(nijiHanteiYokaigoJotaiKubunCode);
            return this;
        }

        /**
         * nijiHanteiNinteiYukoKikanを設定します。
         *
         * @param nijiHanteiNinteiYukoKikan 二次判定認定有効期間
         * @return builder
         */
        @Override
        public Builder setNijiHanteiNinteiYukoKikan(int nijiHanteiNinteiYukoKikan) {
            this.entity.setNijiHanteiNinteiYukoKikan(nijiHanteiNinteiYukoKikan);
            return this;
        }

        /**
         * nijiHanteiNinteiYukoKaishiYMDを設定します。
         *
         * @param nijiHanteiNinteiYukoKaishiYMD 二次判定認定有効開始年月日
         * @return builder
         */
        @Override
        public Builder setNijiHanteiNinteiYukoKaishiYMD(FlexibleDate nijiHanteiNinteiYukoKaishiYMD) {
            Objects.requireNonNull(nijiHanteiNinteiYukoKaishiYMD);
            this.entity.setNijiHanteiNinteiYukoKaishiYMD(nijiHanteiNinteiYukoKaishiYMD);
            return this;
        }

        /**
         * nijiHanteiNinteiYukoShuryoYMDを設定します。
         *
         * @param nijiHanteiNinteiYukoShuryoYMD 二次判定認定有効開始年月日
         * @return builder
         */
        @Override
        public Builder setNijiHanteiNinteiYukoShuryoYMD(FlexibleDate nijiHanteiNinteiYukoShuryoYMD) {
            Objects.requireNonNull(nijiHanteiNinteiYukoShuryoYMD);
            this.entity.setNijiHanteiNinteiYukoShuryoYMD(nijiHanteiNinteiYukoShuryoYMD);
            return this;
        }

        /**
         * shinsakaiKaisaiNoを設定します。
         *
         * @param shinsakaiKaisaiNo 介護認定審査会開催番号
         * @return builder
         */
        @Override
        public Builder setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
            this.entity.setShinsakaiKaisaiNo(shinsakaiKaisaiNo);
            return this;
        }

        /**
         * shinsakaiIkenを設定します。
         *
         * @param shinsakaiIken 介護認定審査会意見
         * @return builder
         */
        @Override
        public Builder setShinsakaiIken(RString shinsakaiIken) {
            Objects.requireNonNull(shinsakaiIken);
            this.entity.setShinsakaiIken(shinsakaiIken);
            return this;
        }

        /**
         * ichijiHnateiKekkaHenkoRiyuを設定します。
         *
         * @param ichijiHnateiKekkaHenkoRiyu 一次判定結果変更理由
         * @return builder
         */
        @Override
        public Builder setIchijiHnateiKekkaHenkoRiyu(RString ichijiHnateiKekkaHenkoRiyu) {
            Objects.requireNonNull(ichijiHnateiKekkaHenkoRiyu);
            this.entity.setIchijiHnateiKekkaHenkoRiyu(ichijiHnateiKekkaHenkoRiyu);
            return this;
        }

        /**
         * yokaigoJotaizoReiCodeを設定します。
         *
         * @param yokaigoJotaizoReiCode 要介護状態像例コード
         * @return builder
         */
        @Override
        public Builder setYokaigoJotaizoReiCode(Code yokaigoJotaizoReiCode) {
            Objects.requireNonNull(yokaigoJotaizoReiCode);
            this.entity.setYokaigoJotaizoReiCode(yokaigoJotaizoReiCode);
            return this;
        }

        /**
         * ninteishinsakaiIkenShuruiを設定します。
         *
         * @param ninteishinsakaiIkenShurui 認定審査会意見種類
         * @return builder
         */
        @Override
        public Builder setNinteishinsakaiIkenShurui(RString ninteishinsakaiIkenShurui) {
            Objects.requireNonNull(ninteishinsakaiIkenShurui);
            this.entity.setNinteishinsakaiIkenShurui(ninteishinsakaiIkenShurui);
            return this;
        }

        /**
         * shinsakaiMemoを設定します。
         *
         * @param shinsakaiMemo 審査会メモ
         * @return builder
         */
        @Override
        public Builder setShinsakaiMemo(RString shinsakaiMemo) {
            Objects.requireNonNull(shinsakaiMemo);
            this.entity.setShinsakaiMemo(shinsakaiMemo);
            return this;
        }

        /**
         * nijiHanteiKekkaInputHohoを設定します。
         *
         * @param nijiHanteiKekkaInputHoho 二次判定結果入力方法
         * @return builder
         */
        @Override
        public Builder setNijiHanteiKekkaInputHoho(Code nijiHanteiKekkaInputHoho) {
            Objects.requireNonNull(nijiHanteiKekkaInputHoho);
            this.entity.setNijiHanteiKekkaInputHoho(nijiHanteiKekkaInputHoho);
            return this;
        }

        /**
         * niniHanteiKekkaInputYMDを設定します。
         *
         * @param niniHanteiKekkaInputYMD 二次判定結果入力年月日
         * @return builder
         */
        @Override
        public Builder setNiniHanteiKekkaInputYMD(FlexibleDate niniHanteiKekkaInputYMD) {
            Objects.requireNonNull(niniHanteiKekkaInputYMD);
            this.entity.setNiniHanteiKekkaInputYMD(niniHanteiKekkaInputYMD);
            return this;
        }

        /**
         * {@link HokenshaNinteiKekkaJoho}を生成します。
         *
         * @return {@link HokenshaNinteiKekkaJoho}
         */
        @Override
        public HokenshaNinteiKekkaJoho build() {
            return new HokenshaNinteiKekkaJoho(this);
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

        private static final long serialVersionUID = 2036070529568954387L;

        private final DbT4102NinteiKekkaJohoEntity entity;

        private _SerializationProxy(HokenshaNinteiKekkaJoho hokenshaNinteiKekkaJoho) {
            this.entity = hokenshaNinteiKekkaJoho.entity;
        }

        private Object readResolve() {
            return new HokenshaNinteiKekkaJoho(entity);
        }
    }
}
