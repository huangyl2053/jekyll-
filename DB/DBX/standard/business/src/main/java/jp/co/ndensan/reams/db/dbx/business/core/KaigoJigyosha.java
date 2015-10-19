/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.HojinsShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.ShiteiKijunGaitoJigyoshoKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.KaigoJigyoshaRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護事業者の情報を扱うクラスです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
//TODO n3317 塚田萌 インターフェースを削除次第、implements、@Override記述を削除する。
public class KaigoJigyosha implements IKaigoJigyosha {

    private final KaigoJigyoshaRelateEntity relateEntity;

    private KaigoJigyosha() {
        this.relateEntity = new KaigoJigyoshaRelateEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param relateEntity KaigoJigyoshaRelateEntity
     */
    public KaigoJigyosha(KaigoJigyoshaRelateEntity relateEntity) {
        this.relateEntity = requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者関連"));
    }

    /**
     * 介護事業者情報のコンストラクタです
     *
     * @param 事業者番号 事業者番号
     * @param 有効開始年月日 有効開始年月日
     * @param 有効終了年月日 有効終了年月日
     * @param 識別コード 識別コード
     * @param 事業者略称 事業者略称
     * @param 事業者略称カナ 事業者略称カナ
     * @param 事業者住所カナ 事業者住所カナ
     * @param 異動事由 異動事由
     * @param 異動年月日 異動年月日
     * @param 社会福祉法人軽減対象区分 社会福祉法人軽減対象区分
     * @param 地域差区分 地域差区分
     * @param 受領委任区分 受領委任区分
     * @param 生活保護指定区分 生活保護指定区分
     * @param 法人種別 法人種別
     * @param 事業開始年月日 事業開始年月日
     * @param 事業休止年月日 事業休止年月日
     * @param 事業廃止年月日 事業廃止年月日
     * @param 事業再開年月日 事業再開年月日
     * @deprecated 新business対応により削除されます。非推奨でないコンストラクタを利用してください。
     */
    public KaigoJigyosha(KaigoJigyoshaNo 事業者番号, FlexibleDate 有効開始年月日, FlexibleDate 有効終了年月日,
            ShikibetsuCode 識別コード, RString 事業者略称, RString 事業者略称カナ, RString 事業者住所カナ,
            RString 異動事由, FlexibleDate 異動年月日, RString 社会福祉法人軽減対象区分, RString 地域差区分,
            RString 受領委任区分, RString 生活保護指定区分, RString 法人種別, FlexibleDate 事業開始年月日,
            FlexibleDate 事業休止年月日, FlexibleDate 事業廃止年月日, FlexibleDate 事業再開年月日) {

        this.relateEntity = new KaigoJigyoshaRelateEntity();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    @Override
    public KaigoJigyoshaNo get事業者番号() {
        return relateEntity.get事業者エンティティ().getJigyoshaNo();
    }

    /**
     * 有効開始日を返します。
     *
     * @return 有効開始日
     */
    @Override
    public FlexibleDate get有効開始日() {
        return relateEntity.get事業者エンティティ().getYukoKaishiYMD();
    }

    /**
     * 有効終了日を返します。
     *
     * @return 有効終了日
     */
    @Override
    public FlexibleDate get有効終了日() {
        return relateEntity.get事業者エンティティ().getYukoShuryoYMD();
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    @Override
    public FlexibleDate get異動日() {
        return relateEntity.get事業者エンティティ().getIdoYMD();
    }

    /**
     * 異動事由を返します。
     *
     * @return 異動事由
     */
    @Override
    public RString get異動事由() {
        return relateEntity.get事業者エンティティ().getIdoJiyuCode();
    }

    /**
     * 事業開始日を返します。
     *
     * @return 事業開始日
     */
    @Override
    public FlexibleDate get事業開始日() {
        return relateEntity.get事業者エンティティ().getJigyoKaishiYMD();
    }

    /**
     * 事業休止日を返します。
     *
     * @return 事業休止日
     */
    @Override
    public FlexibleDate get事業休止日() {
        return relateEntity.get事業者エンティティ().getJigyoKyushiYMD();
    }

    /**
     * 事業再開日を返します。
     *
     * @return 事業再開日
     */
    @Override
    public FlexibleDate get事業再開日() {
        return relateEntity.get事業者エンティティ().getJigyoSaikaiYMD();
    }

    /**
     * 事業廃止日を返します。
     *
     * @return 事業廃止日
     */
    @Override
    public FlexibleDate get事業廃止日() {
        return relateEntity.get事業者エンティティ().getJigyoHaishiYMD();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    @Override
    public AtenaMeisho get事業者名称() {
        return relateEntity.get事業者エンティティ().getJigyoshaName();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    @Override
    public AtenaKanaMeisho get事業者名称カナ() {
        return relateEntity.get事業者エンティティ().getJigyoshaNameKana();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    @Override
    public YubinNo get郵便番号() {
        return relateEntity.get事業者エンティティ().getYubinNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    @Override
    public AtenaJusho get事業者住所() {
        return relateEntity.get事業者エンティティ().getJigyoshaAddress();
    }

    /**
     * 事業者住所カナを返します。
     *
     * @return 事業者住所カナ
     */
    @Override
    public RString get事業者住所カナ() {
        return relateEntity.get事業者エンティティ().getJigyoshaKanaAddress();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    @Override
    public TelNo get電話番号() {
        return relateEntity.get事業者エンティティ().getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    @Override
    public TelNo getFAX番号() {
        return relateEntity.get事業者エンティティ().getFaxNo();
    }

    /**
     * 宛先部署を返します。
     *
     * @return 宛先部署
     */
    @Override
    public RString get宛先部署() {
        return relateEntity.get事業者エンティティ().getAtesakiBusho();
    }

    /**
     * 宛先人名を返します。
     *
     * @return 宛先人名
     */
    @Override
    public AtenaMeisho get宛先人名() {
        return relateEntity.get事業者エンティティ().getAtesakininName();
    }

    /**
     * 宛先人名カナを返します。
     *
     * @return 宛先人名カナ
     */
    @Override
    public AtenaKanaMeisho get宛先人名カナ() {
        return relateEntity.get事業者エンティティ().getAtesakininNamekana();
    }

    /**
     * 銀行コードを返します。
     *
     * @return 銀行コード
     */
    @Override
    public KinyuKikanCode get銀行コード() {
        return KinyuKikanCode.EMPTY;//relateEntity.get事業者エンティティ().getGinkoCode();
    }

    /**
     * 支店コードを返します。
     *
     * @return 支店コード
     */
    @Override
    public KinyuKikanShitenCode get支店コード() {
        return KinyuKikanShitenCode.EMPTY;//relateEntity.get事業者エンティティ().getShitenCode();
    }

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    @Override
    public RString get口座種別() {
        return RString.EMPTY;//relateEntity.get事業者エンティティ().getKozaShubetsu();
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    @Override
    public RString get口座番号() {
        return RString.EMPTY;//relateEntity.get事業者エンティティ().getKozaNo();
    }

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    @Override
    public AtenaMeisho get口座名義人() {
        return AtenaMeisho.EMPTY;//relateEntity.get事業者エンティティ().getKozaMeiginin();
    }

    /**
     * 口座名義人カナを返します。
     *
     * @return 口座名義人カナ
     */
    @Override
    public AtenaKanaMeisho get口座名義人カナ() {
        return AtenaKanaMeisho.EMPTY;//relateEntity.get事業者エンティティ().getKozaMeigininKana();
    }

    /**
     * 指定基準該当等事業所区分を返します。
     *
     * @return 指定基準該当等事業所区分
     */
    @Override
    public ShiteiKijunGaitoJigyoshoKubun get指定基準該当等事業所区分() {
        return new ShiteiKijunGaitoJigyoshoKubun(relateEntity.get事業者エンティティ().getShiteiKijungaitoJigyoshaKubun());
    }

    /**
     * 所在市町村を返します。
     *
     * @return 所在市町村
     */
    @Override
    public RString get所在市町村() {
        return relateEntity.get事業者エンティティ().getShozaiShichoson();
    }

    /**
     * サービス実施地域を返します。
     *
     * @return サービス実施地域
     */
    @Override
    public RString getサービス実施地域() {
        return relateEntity.get事業者エンティティ().getServiceJisshiChiiki();
    }

    /**
     * 法人等種別を返します。
     *
     * @return 法人等種別
     */
    @Override
    public HojinsShubetsu get法人等種別() {
        return new HojinsShubetsu(relateEntity.get事業者エンティティ().getHojinShubetsu());
    }

    /**
     * ベッド数を返します。
     *
     * @return ベッド数
     */
    @Override
    public int getベッド数() {
        return relateEntity.get事業者エンティティ().getBedSu().intValue();
    }

    /**
     * 所属人数を返します。
     *
     * @return 所属人数
     */
    @Override
    public int get所属人数() {
        return relateEntity.get事業者エンティティ().getShozokuNinzu().intValue();
    }

    /**
     * 利用者数を返します。
     *
     * @return 利用者数
     */
    @Override
    public int get利用者数() {
        return relateEntity.get事業者エンティティ().getRiyoshaSu().intValue();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    @Override
    public RString get備考() {
        return relateEntity.get事業者エンティティ().getBiko();
    }

    /**
     * メンバで保持しているKaigoJigyoshaRelateEntityより介護事業者代表者を生成して返します。
     *
     * @return 介護事業者代表者
     */
    public KaigoJigyoshaDaihyosha createDaihyosha() {
        return new KaigoJigyoshaDaihyosha(relateEntity.get事業者代表者エンティティ());
    }

    /**
     * メンバで保持しているKaigoJigyoshaRelateEntityより介護事業者指定サービスリストを生成して返します。
     *
     * @return 介護事業者指定サービスリスト
     */
    public List<KaigoJigyoshaShiteiService> createShiteiServiceList() {
        List<KaigoJigyoshaShiteiService> list = new ArrayList<>();
        for (DbT7063KaigoJigyoshaShiteiServiceEntity entity : relateEntity.get事業者指定サービスエンティティリスト()) {
            list.add(new KaigoJigyoshaShiteiService(entity));
        }
        return list;
    }

    /**
     * 更新処理を行う際に必要となるエンティティを返します。
     *
     * @return 介護事業者関連エンティティ
     */
    public KaigoJigyoshaRelateEntity toEntity() {
        return relateEntity.clone();
    }

    private KaigoJigyosha(Builder builder) {
        this.relateEntity = builder.relateEntity;
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
     * 新しい{@link KaigoJigyosha}を生成するためのビルダーを返します。
     *
     * @return ビルダー
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * {@link KaigoJigyosha}を生成するためのビルダーです。
     */
    public static final class Builder {

        private KaigoJigyoshaRelateEntity relateEntity;

        Builder() {
            this.relateEntity = new KaigoJigyoshaRelateEntity();
        }

        Builder(KaigoJigyosha kaigoJigyosha) {
            this.relateEntity = kaigoJigyosha.relateEntity.clone();
        }

        /**
         * jigyoshaNoを設定します。
         *
         * @param jigyoshaNo 事業者番号
         * @return builder
         */
        public Builder setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
            Objects.requireNonNull(jigyoshaNo);
            this.relateEntity.get事業者エンティティ().setJigyoshaNo(jigyoshaNo);
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
            this.relateEntity.get事業者エンティティ().setYukoKaishiYMD(yukoKaishiYMD);
            return this;
        }

        /**
         * yukoShuryoYMDを設定します。
         *
         * @param yukoShuryoYMD 有効終了日
         * @return builder
         */
        public Builder setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
            Objects.requireNonNull(yukoShuryoYMD);
            this.relateEntity.get事業者エンティティ().setYukoShuryoYMD(yukoShuryoYMD);
            return this;
        }

        /**
         * idoYMDを設定します。
         *
         * @param idoYMD 異動日
         * @return builder
         */
        public Builder setIdoYMD(FlexibleDate idoYMD) {
            Objects.requireNonNull(idoYMD);
            this.relateEntity.get事業者エンティティ().setIdoYMD(idoYMD);
            return this;
        }

        /**
         * idoJiyuCodeを設定します。
         *
         * @param idoJiyuCode 異動事由コード
         * @return builder
         */
        public Builder setIdoJiyuCode(RString idoJiyuCode) {
            Objects.requireNonNull(idoJiyuCode);
            this.relateEntity.get事業者エンティティ().setIdoJiyuCode(idoJiyuCode);
            return this;
        }

        /**
         * jigyoKaishiYMDを設定します。
         *
         * @param jigyoKaishiYMD 事業開始日
         * @return builder
         */
        public Builder setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
            Objects.requireNonNull(jigyoKaishiYMD);
            this.relateEntity.get事業者エンティティ().setJigyoKaishiYMD(jigyoKaishiYMD);
            return this;
        }

        /**
         * jigyoKyushiYMDを設定します。
         *
         * @param jigyoKyushiYMD 事業休止日
         * @return builder
         */
        public Builder setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
            Objects.requireNonNull(jigyoKyushiYMD);
            this.relateEntity.get事業者エンティティ().setJigyoKyushiYMD(jigyoKyushiYMD);
            return this;
        }

        /**
         * jigyoSaikaiYMDを設定します。
         *
         * @param jigyoSaikaiYMD 事業再開日
         * @return builder
         */
        public Builder setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
            Objects.requireNonNull(jigyoSaikaiYMD);
            this.relateEntity.get事業者エンティティ().setJigyoSaikaiYMD(jigyoSaikaiYMD);
            return this;
        }

        /**
         * jigyoHaishiYMDを設定します。
         *
         * @param jigyoHaishiYMD 事業廃止日
         * @return builder
         */
        public Builder setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
            Objects.requireNonNull(jigyoHaishiYMD);
            this.relateEntity.get事業者エンティティ().setJigyoHaishiYMD(jigyoHaishiYMD);
            return this;
        }

        /**
         * jigyoshaNameを設定します。
         *
         * @param jigyoshaName 事業者名称
         * @return builder
         */
        public Builder setJigyoshaName(AtenaMeisho jigyoshaName) {
            Objects.requireNonNull(jigyoshaName);
            this.relateEntity.get事業者エンティティ().setJigyoshaName(jigyoshaName);
            return this;
        }

        /**
         * jigyoshaNameKanaを設定します。
         *
         * @param jigyoshaNameKana 事業者名称カナ
         * @return builder
         */
        public Builder setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
            Objects.requireNonNull(jigyoshaNameKana);
            this.relateEntity.get事業者エンティティ().setJigyoshaNameKana(jigyoshaNameKana);
            return this;
        }

        /**
         * yubinNoを設定します。
         *
         * @param yubinNo 郵便番号
         * @return builder
         */
        public Builder setYubinNo(YubinNo yubinNo) {
            Objects.requireNonNull(yubinNo);
            this.relateEntity.get事業者エンティティ().setYubinNo(yubinNo);
            return this;
        }

        /**
         * jigyoshaAddressを設定します。
         *
         * @param jigyoshaAddress 事業者住所
         * @return builder
         */
        public Builder setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
            Objects.requireNonNull(jigyoshaAddress);
            this.relateEntity.get事業者エンティティ().setJigyoshaAddress(jigyoshaAddress);
            return this;
        }

        /**
         * jigyoshaKanaAddressを設定します。
         *
         * @param jigyoshaKanaAddress 事業者住所カナ
         * @return builder
         */
        public Builder setJigyoshaKanaAddress(RString jigyoshaKanaAddress) {
            Objects.requireNonNull(jigyoshaKanaAddress);
            this.relateEntity.get事業者エンティティ().setJigyoshaKanaAddress(jigyoshaKanaAddress);
            return this;
        }

        /**
         * telNoを設定します。
         *
         * @param telNo 電話番号
         * @return builder
         */
        public Builder setTelNo(TelNo telNo) {
            Objects.requireNonNull(telNo);
            this.relateEntity.get事業者エンティティ().setTelNo(telNo);
            return this;
        }

        /**
         * faxNoを設定します。
         *
         * @param faxNo FAX番号
         * @return builder
         */
        public Builder setFaxNo(TelNo faxNo) {
            Objects.requireNonNull(faxNo);
            this.relateEntity.get事業者エンティティ().setFaxNo(faxNo);
            return this;
        }

        /**
         * atesakiBushoを設定します。
         *
         * @param atesakiBusho 宛先部署
         * @return builder
         */
        public Builder setAtesakiBusho(RString atesakiBusho) {
            Objects.requireNonNull(atesakiBusho);
            this.relateEntity.get事業者エンティティ().setAtesakiBusho(atesakiBusho);
            return this;
        }

        /**
         * atesakininNameを設定します。
         *
         * @param atesakininName 宛先人名称
         * @return builder
         */
        public Builder setAtesakininName(AtenaMeisho atesakininName) {
            Objects.requireNonNull(atesakininName);
            this.relateEntity.get事業者エンティティ().setAtesakininName(atesakininName);
            return this;
        }

        /**
         * atesakininNamekanaを設定します。
         *
         * @param atesakininNamekana 宛先人名称カナ
         * @return builder
         */
        public Builder setAtesakininNamekana(AtenaKanaMeisho atesakininNamekana) {
            Objects.requireNonNull(atesakininNamekana);
            this.relateEntity.get事業者エンティティ().setAtesakininNamekana(atesakininNamekana);
            return this;
        }

        /**
         * ginkoCodeを設定します。
         *
         * @param ginkoCode 銀行コード
         * @return builder
         */
        public Builder setGinkoCode(KinyuKikanCode ginkoCode) {
            Objects.requireNonNull(ginkoCode);
//            this.relateEntity.get事業者エンティティ().setGinkoCode(ginkoCode);
            return this;
        }

        /**
         * shitenCodeを設定します。
         *
         * @param shitenCode 支店コード
         * @return builder
         */
        public Builder setShitenCode(KinyuKikanShitenCode shitenCode) {
            Objects.requireNonNull(shitenCode);
//            this.relateEntity.get事業者エンティティ().setShitenCode(shitenCode);
            return this;
        }

        /**
         * kozaShubetsuを設定します。
         *
         * @param kozaShubetsu 口座種別
         * @return builder
         */
        public Builder setKozaShubetsu(RString kozaShubetsu) {
            Objects.requireNonNull(kozaShubetsu);
//            this.relateEntity.get事業者エンティティ().setKozaShubetsu(kozaShubetsu);
            return this;
        }

        /**
         * kozaNoを設定します。
         *
         * @param kozaNo 口座番号
         * @return builder
         */
        public Builder setKozaNo(RString kozaNo) {
            Objects.requireNonNull(kozaNo);
//            this.relateEntity.get事業者エンティティ().setKozaNo(kozaNo);
            return this;
        }

        /**
         * kozaMeigininを設定します。
         *
         * @param kozaMeiginin 口座名義人
         * @return builder
         */
        public Builder setKozaMeiginin(AtenaMeisho kozaMeiginin) {
            Objects.requireNonNull(kozaMeiginin);
//            this.relateEntity.get事業者エンティティ().setKozaMeiginin(kozaMeiginin);
            return this;
        }

        /**
         * kozaMeigininKanaを設定します。
         *
         * @param kozaMeigininKana 口座名義人カナ
         * @return builder
         */
        public Builder setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
            Objects.requireNonNull(kozaMeigininKana);
//            this.relateEntity.get事業者エンティティ().setKozaMeigininKana(kozaMeigininKana);
            return this;
        }

        /**
         * shiteiKijungaitoJigyoshaKubunを設定します。
         *
         * @param shiteiKijungaitoJigyoshaKubun 指定基準該当事業者区分
         * @return builder
         */
        public Builder setShiteiKijungaitoJigyoshaKubun(ShiteiKijunGaitoJigyoshoKubun shiteiKijungaitoJigyoshaKubun) {
            Objects.requireNonNull(shiteiKijungaitoJigyoshaKubun);
            this.relateEntity.get事業者エンティティ().setShiteiKijungaitoJigyoshaKubun(shiteiKijungaitoJigyoshaKubun.getColumnValue());
            return this;
        }

        /**
         * shozaiShichosonを設定します。
         *
         * @param shozaiShichoson 所在市町村
         * @return builder
         */
        public Builder setShozaiShichoson(RString shozaiShichoson) {
            Objects.requireNonNull(shozaiShichoson);
            this.relateEntity.get事業者エンティティ().setShozaiShichoson(shozaiShichoson);
            return this;
        }

        /**
         * serviceJisshiChiikiを設定します。
         *
         * @param serviceJisshiChiiki サービス実施地域
         * @return builder
         */
        public Builder setServiceJisshiChiiki(RString serviceJisshiChiiki) {
            Objects.requireNonNull(serviceJisshiChiiki);
            this.relateEntity.get事業者エンティティ().setServiceJisshiChiiki(serviceJisshiChiiki);
            return this;
        }

        /**
         * hojinShubetsuを設定します。
         *
         * @param hojinShubetsu 法人種別
         * @return builder
         */
        public Builder setHojinShubetsu(HojinsShubetsu hojinShubetsu) {
            Objects.requireNonNull(hojinShubetsu);
            this.relateEntity.get事業者エンティティ().setHojinShubetsu(hojinShubetsu.value());
            return this;
        }

        /**
         * bedSuを設定します。
         *
         * @param bedSu ベッド数
         * @return builder
         */
        public Builder setBedSu(int bedSu) {
            this.relateEntity.get事業者エンティティ().setBedSu(new Decimal(bedSu));
            return this;
        }

        /**
         * shozokuNinzuを設定します。
         *
         * @param shozokuNinzu 所属人数
         * @return builder
         */
        public Builder setShozokuNinzu(int shozokuNinzu) {
            this.relateEntity.get事業者エンティティ().setShozokuNinzu(new Decimal(shozokuNinzu));
            return this;
        }

        /**
         * riyoshaSuを設定します。
         *
         * @param riyoshaSu 利用者数
         * @return builder
         */
        public Builder setRiyoshaSu(int riyoshaSu) {
            this.relateEntity.get事業者エンティティ().setRiyoshaSu(new Decimal(riyoshaSu));
            return this;
        }

        /**
         * bikoを設定します。
         *
         * @param biko 備考
         * @return builder
         */
        public Builder setBiko(RString biko) {
            Objects.requireNonNull(biko);
            this.relateEntity.get事業者エンティティ().setBiko(biko);
            return this;
        }

        /**
         * 介護事業者代表者を設定します。
         *
         * @param daihyosha 介護事業者代表者
         * @return builder
         */
        public Builder setDaihyosha(KaigoJigyoshaDaihyosha daihyosha) {
            this.relateEntity.set事業者代表者エンティティ(daihyosha.toEntity());
            return this;
        }

        /**
         * 介護事業者指定サービスリストを設定します。
         *
         * @param serviceList 介護事業者指定サービスリスト
         * @return builder
         */
        public Builder setShiteiSerivceList(List<KaigoJigyoshaShiteiService> serviceList) {
            List<DbT7063KaigoJigyoshaShiteiServiceEntity> list = new ArrayList<>();
            for (KaigoJigyoshaShiteiService serivce : serviceList) {
                list.add(serivce.toEntity());
            }
            this.relateEntity.set事業者指定サービスエンティティリスト(list);
            return this;
        }

        /**
         * {@link KaigoJigyosha}を生成します。
         *
         * @return {@link KaigoJigyosha}
         */
        public KaigoJigyosha build() {
            return new KaigoJigyosha(this);
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

        private static final long serialVersionUID = -3198744743390133053L;

        private final KaigoJigyoshaRelateEntity relateEntity;

        private _SerializationProxy(KaigoJigyosha kaigoJigyosha) {
            this.relateEntity = kaigoJigyosha.relateEntity;
        }

        private Object readResolve() {
            return new KaigoJigyosha(relateEntity);
        }
    }
}
