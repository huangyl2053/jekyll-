/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護事業者代表者の情報を扱うクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者代表者
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者代表者
 * @mainClass ○
 * @reference
 */
public class KaigoJigyoshaDaihyosha {

    private final DbT7062KaigoJigyoshaDaihyoshaEntity entity;

    private KaigoJigyoshaDaihyosha() {
        this.entity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7062KaigoJigyoshaDaihyoshaEntity
     */
    public KaigoJigyoshaDaihyosha(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者代表者"));
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return entity.getYukoKaishiYMD();
    }

    /**
     * 代表者名を返します。
     *
     * @return 代表者名
     */
    public AtenaMeisho get代表者名() {
        return entity.getDaihyoshaShimei();
    }

    /**
     * 代表者名カナを返します。
     *
     * @return 代表者名カナ
     */
    public AtenaKanaMeisho get代表者名カナ() {
        return entity.getDaihyoshaKanaShimei();
    }

    /**
     * 代表者郵便番号を返します。
     *
     * @return 代表者郵便番号
     */
    public YubinNo get代表者郵便番号() {
        return entity.getDaihyoshaYubinNo();
    }

    /**
     * 代表者住所を返します。
     *
     * @return 代表者住所
     */
    public AtenaJusho get代表者住所() {
        return entity.getDaihyoshaJusho();
    }

    /**
     * 代表者住所カナを返します。
     *
     * @return 代表者住所カナ
     */
    public RString get代表者住所カナ() {
        return entity.getDaihyoshaKanaJusho();
    }

    /**
     * 代表者役職名を返します。
     *
     * @return 代表者役職名
     */
    public RString get代表者役職名() {
        return entity.getDaihyoshaYakushokuMei();
    }

    /**
     * 開設者名を返します。
     *
     * @return 開設者名
     */
    public AtenaMeisho get開設者名() {
        return entity.getKaisetsushaShimei();
    }

    /**
     * 開設者名カナを返します。
     *
     * @return 開設者名カナ
     */
    public AtenaKanaMeisho get開設者名カナ() {
        return entity.getKaisetsushaKanaShimei();
    }

    /**
     * 開設者郵便番号を返します。
     *
     * @return 開設者郵便番号
     */
    public YubinNo get開設者郵便番号() {
        return entity.getKaisetsushaYubinNo();
    }

    /**
     * 開設者住所を返します。
     *
     * @return 開設者住所
     */
    public AtenaJusho get開設者住所() {
        return entity.getKaisetsushaJusho();
    }

    /**
     * 開設者住所カナを返します。
     *
     * @return 開設者住所カナ
     */
    public RString get開設者住所カナ() {
        return entity.getKaisetsushaKanaJusho();
    }

    /**
     * 開設者電話番号を返します。
     *
     * @return 開設者電話番号
     */
    public TelNo get開設者電話番号() {
        return entity.getKaisetsushaTelNo();
    }

    /**
     * 開設者FAX番号を返します。
     *
     * @return 開設者FAX番号
     */
    public TelNo get開設者FAX番号() {
        return entity.getKaisetsushaFaxNo();
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    //TODO n3423 樋木隆真 KaigoJigyoshaDaihyoshaModelの内容をそのまま移します。ただし、stateの扱いについては現在検討中のため変更の可能性があります。
    public EntityDataState getState() {
        return entity.getState();
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。。
     *
     * @return 介護事業者代表者エンティティ
     */
    public DbT7062KaigoJigyoshaDaihyoshaEntity toEntity() {
        return entity.clone();
    }

    private KaigoJigyoshaDaihyosha(Builder builder) {
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
     * 新しい{@link KaigoJigyoshaDaihyosha}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link KaigoJigyoshaDaihyosha}を生成するためのビルダーです。
     */
    public static final class Builder {

        private DbT7062KaigoJigyoshaDaihyoshaEntity entity;

        Builder() {
            this.entity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
        }

        Builder(KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha) {
            this.entity = kaigoJigyoshaDaihyosha.entity.clone();
        }

        /**
         * jigyoshaNoを設定します。
         *
         * @param jigyoshaNo 事業者番号
         * @return builder
         */
        public Builder setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
            Objects.requireNonNull(jigyoshaNo);
            this.entity.setJigyoshaNo(jigyoshaNo);
            return this;
        }

        /**
         * yukoKaishiYMDを設定します。
         *
         * @param yukoKaishiYMD 有効開始日
         * @return builder
         */
        public Builder setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
            Objects.requireNonNull(yukoKaishiYMD);
            this.entity.setYukoKaishiYMD(yukoKaishiYMD);
            return this;
        }

        /**
         * daihyoshaShimeiを設定します。
         *
         * @param daihyoshaShimei 代表者氏名
         * @return builder
         */
        public Builder setDaihyoshaShimei(AtenaMeisho daihyoshaShimei) {
            Objects.requireNonNull(daihyoshaShimei);
            this.entity.setDaihyoshaShimei(daihyoshaShimei);
            return this;
        }

        /**
         * daihyoshaKanaShimeiを設定します。
         *
         * @param daihyoshaKanaShimei 代表者カナ氏名
         * @return builder
         */
        public Builder setDaihyoshaKanaShimei(AtenaKanaMeisho daihyoshaKanaShimei) {
            Objects.requireNonNull(daihyoshaKanaShimei);
            this.entity.setDaihyoshaKanaShimei(daihyoshaKanaShimei);
            return this;
        }

        /**
         * daihyoshaYubinNoを設定します。
         *
         * @param daihyoshaYubinNo 代表者郵便番号
         * @return builder
         */
        public Builder setDaihyoshaYubinNo(YubinNo daihyoshaYubinNo) {
            Objects.requireNonNull(daihyoshaYubinNo);
            this.entity.setDaihyoshaYubinNo(daihyoshaYubinNo);
            return this;
        }

        /**
         * daihyoshaJushoを設定します。
         *
         * @param daihyoshaJusho 代表者住所
         * @return builder
         */
        public Builder setDaihyoshaJusho(AtenaJusho daihyoshaJusho) {
            Objects.requireNonNull(daihyoshaJusho);
            this.entity.setDaihyoshaJusho(daihyoshaJusho);
            return this;
        }

        /**
         * daihyoshaKanaJushoを設定します。
         *
         * @param daihyoshaKanaJusho 代表者カナ住所
         * @return builder
         */
        public Builder setDaihyoshaKanaJusho(RString daihyoshaKanaJusho) {
            Objects.requireNonNull(daihyoshaKanaJusho);
            this.entity.setDaihyoshaKanaJusho(daihyoshaKanaJusho);
            return this;
        }

        /**
         * daihyoshaYakushokuMeiを設定します。
         *
         * @param daihyoshaYakushokuMei 代表者役職名称
         * @return builder
         */
        public Builder setDaihyoshaYakushokuMei(RString daihyoshaYakushokuMei) {
            Objects.requireNonNull(daihyoshaYakushokuMei);
            this.entity.setDaihyoshaYakushokuMei(daihyoshaYakushokuMei);
            return this;
        }

        /**
         * kaisetsushaShimeiを設定します。
         *
         * @param kaisetsushaShimei 開設者氏名
         * @return builder
         */
        public Builder setKaisetsushaShimei(AtenaMeisho kaisetsushaShimei) {
            Objects.requireNonNull(kaisetsushaShimei);
            this.entity.setKaisetsushaShimei(kaisetsushaShimei);
            return this;
        }

        /**
         * kaisetsushaKanaShimeiを設定します。
         *
         * @param kaisetsushaKanaShimei 開設者カナ氏名
         * @return builder
         */
        public Builder setKaisetsushaKanaShimei(AtenaKanaMeisho kaisetsushaKanaShimei) {
            Objects.requireNonNull(kaisetsushaKanaShimei);
            this.entity.setKaisetsushaKanaShimei(kaisetsushaKanaShimei);
            return this;
        }

        /**
         * kaisetsushaYubinNoを設定します。
         *
         * @param kaisetsushaYubinNo 開設者郵便番号
         * @return builder
         */
        public Builder setKaisetsushaYubinNo(YubinNo kaisetsushaYubinNo) {
            Objects.requireNonNull(kaisetsushaYubinNo);
            this.entity.setKaisetsushaYubinNo(kaisetsushaYubinNo);
            return this;
        }

        /**
         * kaisetsushaJushoを設定します。
         *
         * @param kaisetsushaJusho 開設者住所
         * @return builder
         */
        public Builder setKaisetsushaJusho(AtenaJusho kaisetsushaJusho) {
            Objects.requireNonNull(kaisetsushaJusho);
            this.entity.setKaisetsushaJusho(kaisetsushaJusho);
            return this;
        }

        /**
         * kaisetsushaKanaJushoを設定します。
         *
         * @param kaisetsushaKanaJusho 開設者カナ住所
         * @return builder
         */
        public Builder setKaisetsushaKanaJusho(RString kaisetsushaKanaJusho) {
            Objects.requireNonNull(kaisetsushaKanaJusho);
            this.entity.setKaisetsushaKanaJusho(kaisetsushaKanaJusho);
            return this;
        }

        /**
         * kaisetsushaTelNoを設定します。
         *
         * @param kaisetsushaTelNo 開設者電話番号
         * @return builder
         */
        public Builder setKaisetsushaTelNo(TelNo kaisetsushaTelNo) {
            Objects.requireNonNull(kaisetsushaTelNo);
            this.entity.setKaisetsushaTelNo(kaisetsushaTelNo);
            return this;
        }

        /**
         * kaisetsushaFaxNoを設定します。
         *
         * @param kaisetsushaFaxNo 開設者FAX番号
         * @return builder
         */
        public Builder setKaisetsushaFaxNo(TelNo kaisetsushaFaxNo) {
            Objects.requireNonNull(kaisetsushaFaxNo);
            this.entity.setKaisetsushaFaxNo(kaisetsushaFaxNo);
            return this;
        }

        /**
         * 状態に削除を設定します。
         *
         * @param deleteFlag deleteFlag
         */
        //TODO n3423 樋木隆真 KaigoJigyoshaDaihyoshaModelの内容をそのまま移します。ただし、stateの扱いについては現在検討中のため変更の可能性があります。
        //TODO n3423 樋木隆真 確定した時点でテストを追加してください。
        public void setDeletedState(boolean deleteFlag) {
            if (deleteFlag) {
                entity.setState(EntityDataState.Deleted);
            } else {
                entity.unsetState();
            }
        }

        /**
         * {@link KaigoJigyoshaDaihyosha}を生成します。
         *
         * @return {@link KaigoJigyoshaDaihyosha}
         */
        public KaigoJigyoshaDaihyosha build() {
            return new KaigoJigyoshaDaihyosha(this);
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

        private static final long serialVersionUID = -623819223809433112L;

        private final DbT7062KaigoJigyoshaDaihyoshaEntity entity;

        private _SerializationProxy(KaigoJigyoshaDaihyosha kaigoJigyoshaDaihyosha) {
            this.entity = kaigoJigyoshaDaihyosha.entity;
        }

        private Object readResolve() {
            return new KaigoJigyoshaDaihyosha(entity);
        }
    }
}
