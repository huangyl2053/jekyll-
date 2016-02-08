/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiServiceIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyoshaIdentifier;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoJigyosha}の編集を行うビルダークラスです。
 */
public class KaigoJigyoshaBuilder {

    private final DbT7060KaigoJigyoshaEntity entity;
    private final KaigoJigyoshaIdentifier id;
    private final Models<KaigoJigyoshaDaihyoshaIdentifier, KaigoJigyoshaDaihyosha> kaigoJigyoshaDaihyosha;
    private final Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> kaigoJigyoshaShiteiService;

    /**
     * {@link DbT7060KaigoJigyoshaEntity}より{@link KaigoJigyosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7060KaigoJigyoshaEntity}
     * @param id {@link KaigoJigyoshaIdentifier}
     *
     */
    KaigoJigyoshaBuilder(
            DbT7060KaigoJigyoshaEntity entity,
            KaigoJigyoshaIdentifier id,
            Models<KaigoJigyoshaDaihyoshaIdentifier, KaigoJigyoshaDaihyosha> kaigoJigyoshaDaihyosha,
            Models<KaigoJigyoshaShiteiServiceIdentifier, KaigoJigyoshaShiteiService> kaigoJigyoshaShiteiService
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.kaigoJigyoshaDaihyosha = kaigoJigyoshaDaihyosha.clone();
        this.kaigoJigyoshaShiteiService = kaigoJigyoshaShiteiService.clone();

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
     * 有効終了日を設定します。
     *
     * @param 有効終了日 有効終了日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set有効終了日(FlexibleDate 有効終了日) {
        requireNonNull(有効終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了日"));
        entity.setYukoShuryoYMD(有効終了日);
        return this;
    }

    /**
     * 異動日を設定します。
     *
     * @param 異動日 異動日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(異動日);
        return this;
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set異動事由(RString 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdoJiyuCode(異動事由);
        return this;
    }

    /**
     * 事業開始日を設定します。
     *
     * @param 事業開始日 事業開始日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業開始日(FlexibleDate 事業開始日) {
        requireNonNull(事業開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業開始日"));
        entity.setJigyoKaishiYMD(事業開始日);
        return this;
    }

    /**
     * 事業休止日を設定します。
     *
     * @param 事業休止日 事業休止日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業休止日(FlexibleDate 事業休止日) {
        requireNonNull(事業休止日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業休止日"));
        entity.setJigyoKyushiYMD(事業休止日);
        return this;
    }

    /**
     * 事業再開日を設定します。
     *
     * @param 事業再開日 事業再開日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業再開日(FlexibleDate 事業再開日) {
        requireNonNull(事業再開日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業再開日"));
        entity.setJigyoSaikaiYMD(事業再開日);
        return this;
    }

    /**
     * 事業廃止日を設定します。
     *
     * @param 事業廃止日 事業廃止日
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業廃止日(FlexibleDate 事業廃止日) {
        requireNonNull(事業廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業廃止日"));
        entity.setJigyoHaishiYMD(事業廃止日);
        return this;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業者名称(AtenaMeisho 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaName(事業者名称);
        return this;
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業者名称カナ(AtenaKanaMeisho 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaNameKana(事業者名称カナ);
        return this;
    }

    /**
     * 郵便番号を設定します。
     *
     * @param 郵便番号 郵便番号
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set郵便番号(YubinNo 郵便番号) {
        requireNonNull(郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("郵便番号"));
        entity.setYubinNo(郵便番号);
        return this;
    }

    /**
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業者住所(AtenaJusho 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaAddress(事業者住所);
        return this;
    }

    /**
     * 事業者住所カナを設定します。
     *
     * @param 事業者住所カナ 事業者住所カナ
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set事業者住所カナ(RString 事業者住所カナ) {
        requireNonNull(事業者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所カナ"));
        entity.setJigyoshaKanaAddress(事業者住所カナ);
        return this;
    }

    /**
     * 電話番号を設定します。
     *
     * @param 電話番号 電話番号
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set電話番号(TelNo 電話番号) {
        requireNonNull(電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("電話番号"));
        entity.setTelNo(電話番号);
        return this;
    }

    /**
     * FAX番号を設定します。
     *
     * @param FAX番号 FAX番号
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder setFAX番号(TelNo FAX番号) {
        requireNonNull(FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("FAX番号"));
        entity.setFaxNo(FAX番号);
        return this;
    }

    /**
     * 宛先部署を設定します。
     *
     * @param 宛先部署 宛先部署
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set宛先部署(RString 宛先部署) {
        requireNonNull(宛先部署, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先部署"));
        entity.setAtesakiBusho(宛先部署);
        return this;
    }

    /**
     * 宛先人名を設定します。
     *
     * @param 宛先人名 宛先人名
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set宛先人名(AtenaMeisho 宛先人名) {
        requireNonNull(宛先人名, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先人名"));
        entity.setAtesakininName(宛先人名);
        return this;
    }

    /**
     * 宛先人名カナを設定します。
     *
     * @param 宛先人名カナ 宛先人名カナ
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set宛先人名カナ(AtenaKanaMeisho 宛先人名カナ) {
        requireNonNull(宛先人名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("宛先人名カナ"));
        entity.setAtesakininNamekana(宛先人名カナ);
        return this;
    }

    /**
     * 指定_基準該当等事業所区分を設定します。
     *
     * @param 指定_基準該当等事業所区分 指定_基準該当等事業所区分
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set指定_基準該当等事業所区分(Code 指定_基準該当等事業所区分) {
        requireNonNull(指定_基準該当等事業所区分, UrSystemErrorMessages.値がnull.getReplacedMessage("指定_基準該当等事業所区分"));
        entity.setShiteiKijungaitoJigyoshaKubun(指定_基準該当等事業所区分);
        return this;
    }

    /**
     * 所在市町村を設定します。
     *
     * @param 所在市町村 所在市町村
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set所在市町村(RString 所在市町村) {
        requireNonNull(所在市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("所在市町村"));
        entity.setShozaiShichoson(所在市町村);
        return this;
    }

    /**
     * サービス実施地域を設定します。
     *
     * @param サービス実施地域 サービス実施地域
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder setサービス実施地域(RString サービス実施地域) {
        requireNonNull(サービス実施地域, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス実施地域"));
        entity.setServiceJisshiChiiki(サービス実施地域);
        return this;
    }

    /**
     * 法人等種別を設定します。
     *
     * @param 法人等種別 法人等種別
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set法人等種別(Code 法人等種別) {
        requireNonNull(法人等種別, UrSystemErrorMessages.値がnull.getReplacedMessage("法人等種別"));
        entity.setHojinShubetsu(法人等種別);
        return this;
    }

    /**
     * ベッド数を設定します。
     *
     * @param ベッド数 ベッド数
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder setベッド数(int ベッド数) {
        requireNonNull(ベッド数, UrSystemErrorMessages.値がnull.getReplacedMessage("ベッド数"));
        entity.setBedSu(ベッド数);
        return this;
    }

    /**
     * 所属人数を設定します。
     *
     * @param 所属人数 所属人数
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set所属人数(int 所属人数) {
        requireNonNull(所属人数, UrSystemErrorMessages.値がnull.getReplacedMessage("所属人数"));
        entity.setShozokuNinzu(所属人数);
        return this;
    }

    /**
     * 利用者数を設定します。
     *
     * @param 利用者数 利用者数
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set利用者数(int 利用者数) {
        requireNonNull(利用者数, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者数"));
        entity.setRiyoshaSu(利用者数);
        return this;
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     * @return {@link KaigoJigyoshaBuilder}
     */
    public KaigoJigyoshaBuilder set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
        return this;
    }

    /**
     * 介護事業者指定サービスのキー情報について判定します。<br>
     * 介護事業者情報に関連できる介護事業者指定サービス情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護事業者指定サービスリストに介護事業者指定サービス情報{@link KaigoJigyoshaDaihyosha}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護事業者代表者 {@link KaigoJigyoshaDaihyosha}
     * @return {@link KaigoJigyoshaBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public KaigoJigyoshaBuilder setKaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyosha 介護事業者代表者) {
        if (hasSameIdentifier(介護事業者代表者.identifier())) {
            kaigoJigyoshaDaihyosha.add(介護事業者代表者);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KaigoJigyoshaDaihyoshaIdentifier 介護事業者代表者の識別子) {
        return (id.get事業者番号().equals(介護事業者代表者の識別子.get事業者番号())
                && id.get有効開始日().equals(介護事業者代表者の識別子.get有効開始日()));
    }

    /**
     * 介護事業者代表者情報のキー情報について判定します。<br>
     * 介護事業者情報に関連できる介護事業者代表者情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は介護事業者代表者情報リストに介護事業者代表者情報{@link KaigoJigyoshaShiteiService}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 介護事業者指定サービス {@link KaigoJigyoshaShiteiService}
     * @return KaigoJigyoshaBuilder
     * @throws IllegalStateException キーが一致しない場合
     */
    public KaigoJigyoshaBuilder setKaigoJigyoshaShiteiService(KaigoJigyoshaShiteiService 介護事業者指定サービス) {
        if (hasSameIdentifier(介護事業者指定サービス.identifier())) {
            kaigoJigyoshaShiteiService.add(介護事業者指定サービス);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(KaigoJigyoshaShiteiServiceIdentifier 介護事業者指定サービスの識別子) {
        return (id.get事業者番号().equals(介護事業者指定サービスの識別子.get事業者番号())
                && id.get有効開始日().equals(介護事業者指定サービスの識別子.get有効開始日()));
    }

    /**
     * {@link KaigoJigyosha}のインスタンスを生成します。
     *
     * @return {@link KaigoJigyosha}のインスタンス
     */
    public KaigoJigyosha build() {
        return new KaigoJigyosha(entity, id, kaigoJigyoshaDaihyosha, kaigoJigyoshaShiteiService);
    }

}
