/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link KaigoJigyoshaShiteiService}の編集を行うビルダークラスです。
 */
public class KaigoJigyoshaShiteiServiceBuilder {

    private final DbT7063KaigoJigyoshaShiteiServiceEntity entity;
    private final KaigoJigyoshaShiteiServiceIdentifier id;

    /**
     * {@link DbT7063KaigoJigyoshaShiteiServiceEntity}より{@link KaigoJigyoshaShiteiService}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT7063KaigoJigyoshaShiteiServiceEntity}
     * @param id {@link KaigoJigyoshaShiteiServiceIdentifier}
     *
     */
    KaigoJigyoshaShiteiServiceBuilder(
            DbT7063KaigoJigyoshaShiteiServiceEntity entity,
            KaigoJigyoshaShiteiServiceIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 有効終了日を設定します。
     *
     * @param 有効終了日 有効終了日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set有効終了日(FlexibleDate 有効終了日) {
        requireNonNull(有効終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効終了日"));
        entity.setYukoShuryoYMD(有効終了日);
        return this;
    }

    /**
     * 異動日を設定します。
     *
     * @param 異動日 異動日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set異動日(FlexibleDate 異動日) {
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        entity.setIdoYMD(異動日);
        return this;
    }

    /**
     * 異動事由を設定します。
     *
     * @param 異動事由 異動事由
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set異動事由(RString 異動事由) {
        requireNonNull(異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("異動事由"));
        entity.setIdoJiyu(異動事由);
        return this;
    }

    /**
     * 指定番号を設定します。
     *
     * @param 指定番号 指定番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set指定番号(RString 指定番号) {
        requireNonNull(指定番号, UrSystemErrorMessages.値がnull.getReplacedMessage("指定番号"));
        entity.setShiteiNo(指定番号);
        return this;
    }

    /**
     * 基本情報準拠区分を設定します。
     *
     * @param 基本情報準拠区分 基本情報準拠区分
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set基本情報準拠区分(RString 基本情報準拠区分) {
        requireNonNull(基本情報準拠区分, UrSystemErrorMessages.値がnull.getReplacedMessage("基本情報準拠区分"));
        entity.setKihonJohoJunkyoKubun(基本情報準拠区分);
        return this;
    }

    /**
     * 事業開始日を設定します。
     *
     * @param 事業開始日 事業開始日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業開始日(FlexibleDate 事業開始日) {
        requireNonNull(事業開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業開始日"));
        entity.setJigyoKaishiYMD(事業開始日);
        return this;
    }

    /**
     * 事業休止日を設定します。
     *
     * @param 事業休止日 事業休止日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業休止日(FlexibleDate 事業休止日) {
        requireNonNull(事業休止日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業休止日"));
        entity.setJigyoKyushiYMD(事業休止日);
        return this;
    }

    /**
     * 事業再開日を設定します。
     *
     * @param 事業再開日 事業再開日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業再開日(FlexibleDate 事業再開日) {
        requireNonNull(事業再開日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業再開日"));
        entity.setJigyoSaikaiYMD(事業再開日);
        return this;
    }

    /**
     * 事業廃止日を設定します。
     *
     * @param 事業廃止日 事業廃止日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業廃止日(FlexibleDate 事業廃止日) {
        requireNonNull(事業廃止日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業廃止日"));
        entity.setJigyoHaishiYMD(事業廃止日);
        return this;
    }

    /**
     * 事業者名称を設定します。
     *
     * @param 事業者名称 事業者名称
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者名称(AtenaMeisho 事業者名称) {
        requireNonNull(事業者名称, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称"));
        entity.setJigyoshaName(事業者名称);
        return this;
    }

    /**
     * 事業者名称カナを設定します。
     *
     * @param 事業者名称カナ 事業者名称カナ
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者名称カナ(AtenaKanaMeisho 事業者名称カナ) {
        requireNonNull(事業者名称カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者名称カナ"));
        entity.setJigyoshaNameKana(事業者名称カナ);
        return this;
    }

    /**
     * 事業者郵便番号を設定します。
     *
     * @param 事業者郵便番号 事業者郵便番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者郵便番号(YubinNo 事業者郵便番号) {
        requireNonNull(事業者郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者郵便番号"));
        entity.setJigyoshaYubinNo(事業者郵便番号);
        return this;
    }

    /**
     * 事業者住所を設定します。
     *
     * @param 事業者住所 事業者住所
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者住所(AtenaJusho 事業者住所) {
        requireNonNull(事業者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所"));
        entity.setJigyoshaAddress(事業者住所);
        return this;
    }

    /**
     * 事業者住所カナを設定します。
     *
     * @param 事業者住所カナ 事業者住所カナ
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者住所カナ(RString 事業者住所カナ) {
        requireNonNull(事業者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者住所カナ"));
        entity.setJigyoshaAddressKana(事業者住所カナ);
        return this;
    }

    /**
     * 事業者電話番号を設定します。
     *
     * @param 事業者電話番号 事業者電話番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者電話番号(TelNo 事業者電話番号) {
        requireNonNull(事業者電話番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者電話番号"));
        entity.setJigyoshaTelNo(事業者電話番号);
        return this;
    }

    /**
     * 事業者FAX番号を設定します。
     *
     * @param 事業者FAX番号 事業者FAX番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業者FAX番号(TelNo 事業者FAX番号) {
        requireNonNull(事業者FAX番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者FAX番号"));
        entity.setJigyoshaFaxNo(事業者FAX番号);
        return this;
    }

    /**
     * 登録保険者番号を設定します。
     *
     * @param 登録保険者番号 登録保険者番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set登録保険者番号(RString 登録保険者番号) {
        requireNonNull(登録保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("登録保険者番号"));
        entity.setTorokuHokenshaNo(登録保険者番号);
        return this;
    }

    /**
     * 受領委任の有無を設定します。
     *
     * @param 受領委任の有無 受領委任の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set受領委任の有無(Code 受領委任の有無) {
        requireNonNull(受領委任の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任の有無"));
        entity.setJuryoininUmu(受領委任の有無);
        return this;
    }

    /**
     * 登録開始日を設定します。
     *
     * @param 登録開始日 登録開始日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set登録開始日(FlexibleDate 登録開始日) {
        requireNonNull(登録開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録開始日"));
        entity.setTorokuKaishiYMD(登録開始日);
        return this;
    }

    /**
     * 登録終了日を設定します。
     *
     * @param 登録終了日 登録終了日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set登録終了日(FlexibleDate 登録終了日) {
        requireNonNull(登録終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("登録終了日"));
        entity.setTorokuShuryoYMD(登録終了日);
        return this;
    }

    /**
     * 管理者氏名を設定します。
     *
     * @param 管理者氏名 管理者氏名
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set管理者氏名(AtenaMeisho 管理者氏名) {
        requireNonNull(管理者氏名, UrSystemErrorMessages.値がnull.getReplacedMessage("管理者氏名"));
        entity.setKanrishaName(管理者氏名);
        return this;
    }

    /**
     * 管理者氏名カナを設定します。
     *
     * @param 管理者氏名カナ 管理者氏名カナ
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set管理者氏名カナ(AtenaKanaMeisho 管理者氏名カナ) {
        requireNonNull(管理者氏名カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("管理者氏名カナ"));
        entity.setKanrishaNameKana(管理者氏名カナ);
        return this;
    }

    /**
     * 管理者住所郵便番号を設定します。
     *
     * @param 管理者住所郵便番号 管理者住所郵便番号
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set管理者住所郵便番号(YubinNo 管理者住所郵便番号) {
        requireNonNull(管理者住所郵便番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理者住所郵便番号"));
        entity.setKanrishaYubinNo(管理者住所郵便番号);
        return this;
    }

    /**
     * 管理者住所を設定します。
     *
     * @param 管理者住所 管理者住所
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set管理者住所(AtenaJusho 管理者住所) {
        requireNonNull(管理者住所, UrSystemErrorMessages.値がnull.getReplacedMessage("管理者住所"));
        entity.setKanrishaAddress(管理者住所);
        return this;
    }

    /**
     * 管理者住所カナを設定します。
     *
     * @param 管理者住所カナ 管理者住所カナ
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set管理者住所カナ(RString 管理者住所カナ) {
        requireNonNull(管理者住所カナ, UrSystemErrorMessages.値がnull.getReplacedMessage("管理者住所カナ"));
        entity.setKanrishaAddressKana(管理者住所カナ);
        return this;
    }

    /**
     * 口座情報準拠区分を設定します。
     *
     * @param 口座情報準拠区分 口座情報準拠区分
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set口座情報準拠区分(RString 口座情報準拠区分) {
        requireNonNull(口座情報準拠区分, UrSystemErrorMessages.値がnull.getReplacedMessage("口座情報準拠区分"));
        entity.setKozaJohoJunkyoKubun(口座情報準拠区分);
        return this;
    }

    /**
     * 社会福祉法人軽減事業実施の有無を設定します。
     *
     * @param 社会福祉法人軽減事業実施の有無 社会福祉法人軽減事業実施の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set社会福祉法人軽減事業実施の有無(Code 社会福祉法人軽減事業実施の有無) {
        requireNonNull(社会福祉法人軽減事業実施の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人軽減事業実施の有無"));
        entity.setShakaiFukushihoujinKeigenjigyouJisshi_umu(社会福祉法人軽減事業実施の有無);
        return this;
    }

    /**
     * 生活保護法による指定の有無を設定します。
     *
     * @param 生活保護法による指定の有無 生活保護法による指定の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set生活保護法による指定の有無(Code 生活保護法による指定の有無) {
        requireNonNull(生活保護法による指定の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護法による指定の有無"));
        entity.setSeikatsuhogohouShitei_umu(生活保護法による指定の有無);
        return this;
    }

    /**
     * 施設等の区分を設定します。
     *
     * @param 施設等の区分 施設等の区分
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set施設等の区分(Code 施設等の区分) {
        requireNonNull(施設等の区分, UrSystemErrorMessages.値がnull.getReplacedMessage("施設等の区分"));
        entity.setShisetsunadoKubun(施設等の区分);
        return this;
    }

    /**
     * 人員配置区分を設定します。
     *
     * @param 人員配置区分 人員配置区分
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set人員配置区分(Code 人員配置区分) {
        requireNonNull(人員配置区分, UrSystemErrorMessages.値がnull.getReplacedMessage("人員配置区分"));
        entity.setJininHaichiKubun(人員配置区分);
        return this;
    }

    /**
     * 特別地域加算の有無を設定します。
     *
     * @param 特別地域加算の有無 特別地域加算の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set特別地域加算の有無(Code 特別地域加算の有無) {
        requireNonNull(特別地域加算の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算の有無"));
        entity.setTokubetsuChiikiKasan_umu(特別地域加算の有無);
        return this;
    }

    /**
     * 緊急時訪問介護加算の有無を設定します。
     *
     * @param 緊急時訪問介護加算の有無 緊急時訪問介護加算の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set緊急時訪問介護加算の有無(Code 緊急時訪問介護加算の有無) {
        requireNonNull(緊急時訪問介護加算の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急時訪問介護加算の有無"));
        entity.setKinkyujiHomonkaigoKasan_umu(緊急時訪問介護加算の有無);
        return this;
    }

    /**
     * 特別管理体制を設定します。
     *
     * @param 特別管理体制 特別管理体制
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set特別管理体制(Code 特別管理体制) {
        requireNonNull(特別管理体制, UrSystemErrorMessages.値がnull.getReplacedMessage("特別管理体制"));
        entity.setTokubetsuKanriTaisei(特別管理体制);
        return this;
    }

    /**
     * 機能訓練指導体制の有無を設定します。
     *
     * @param 機能訓練指導体制の有無 機能訓練指導体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set機能訓練指導体制の有無(Code 機能訓練指導体制の有無) {
        requireNonNull(機能訓練指導体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("機能訓練指導体制の有無"));
        entity.setKinoKunrenShidoTaisei_umu(機能訓練指導体制の有無);
        return this;
    }

    /**
     * 食事提供体制の有無を設定します。
     *
     * @param 食事提供体制の有無 食事提供体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set食事提供体制の有無(Code 食事提供体制の有無) {
        requireNonNull(食事提供体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供体制の有無"));
        entity.setShokujiTeikyoTaisei_umu(食事提供体制の有無);
        return this;
    }

    /**
     * 入浴介助体制の有無を設定します。
     *
     * @param 入浴介助体制の有無 入浴介助体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set入浴介助体制の有無(Code 入浴介助体制の有無) {
        requireNonNull(入浴介助体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("入浴介助体制の有無"));
        entity.setNyuyokuKaijoTaisei_umu(入浴介助体制の有無);
        return this;
    }

    /**
     * 特別入浴介助体制の有無を設定します。
     *
     * @param 特別入浴介助体制の有無 特別入浴介助体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set特別入浴介助体制の有無(Code 特別入浴介助体制の有無) {
        requireNonNull(特別入浴介助体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特別入浴介助体制の有無"));
        entity.setTokubetsuNyuyokuKaijoTaisei_umu(特別入浴介助体制の有無);
        return this;
    }

    /**
     * 常勤専従医師配置の有無を設定します。
     *
     * @param 常勤専従医師配置の有無 常勤専従医師配置の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set常勤専従医師配置の有無(Code 常勤専従医師配置の有無) {
        requireNonNull(常勤専従医師配置の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("常勤専従医師配置の有無"));
        entity.setJoukinsenjuIshiHaichi_umu(常勤専従医師配置の有無);
        return this;
    }

    /**
     * 医師の配置基準を設定します。
     *
     * @param 医師の配置基準 医師の配置基準
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set医師の配置基準(Code 医師の配置基準) {
        requireNonNull(医師の配置基準, UrSystemErrorMessages.値がnull.getReplacedMessage("医師の配置基準"));
        entity.setIshiHaichiKijun(医師の配置基準);
        return this;
    }

    /**
     * 精神科医師定期的療養指導の有無を設定します。
     *
     * @param 精神科医師定期的療養指導の有無 精神科医師定期的療養指導の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set精神科医師定期的療養指導の有無(Code 精神科医師定期的療養指導の有無) {
        requireNonNull(精神科医師定期的療養指導の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("精神科医師定期的療養指導の有無"));
        entity.setSeisinkaIshiTeikitekiRyouyousidou_umu(精神科医師定期的療養指導の有無);
        return this;
    }

    /**
     * 夜間勤務条件基準を設定します。
     *
     * @param 夜間勤務条件基準 夜間勤務条件基準
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set夜間勤務条件基準(Code 夜間勤務条件基準) {
        requireNonNull(夜間勤務条件基準, UrSystemErrorMessages.値がnull.getReplacedMessage("夜間勤務条件基準"));
        entity.setYakanKinmuJokenKijun(夜間勤務条件基準);
        return this;
    }

    /**
     * 認知症専門棟の有無を設定します。
     *
     * @param 認知症専門棟の有無 認知症専門棟の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set認知症専門棟の有無(Code 認知症専門棟の有無) {
        requireNonNull(認知症専門棟の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症専門棟の有無"));
        entity.setNinchishouSenmontou_umu(認知症専門棟の有無);
        return this;
    }

    /**
     * 食事提供の状況を設定します。
     *
     * @param 食事提供の状況 食事提供の状況
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set食事提供の状況(Code 食事提供の状況) {
        requireNonNull(食事提供の状況, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供の状況"));
        entity.setShokujiTeikyoJokyo(食事提供の状況);
        return this;
    }

    /**
     * 送迎体制を設定します。
     *
     * @param 送迎体制 送迎体制
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set送迎体制(Code 送迎体制) {
        requireNonNull(送迎体制, UrSystemErrorMessages.値がnull.getReplacedMessage("送迎体制"));
        entity.setSougeiTaisei(送迎体制);
        return this;
    }

    /**
     * リハビリテーション提供体制（総合リハビリテーション施設）の有無を設定します。
     *
     * @param リハビリテーション提供体制_総合リハビリテーション施設_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_総合リハビリテーション施設_の有無(Code リハビリテーション提供体制_総合リハビリテーション施設_の有無) {
        requireNonNull(リハビリテーション提供体制_総合リハビリテーション施設_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_総合リハビリテーション施設_の有無"));
        entity.setRehaTeikyoTaisei_SogoRehaShisetsu_umu(リハビリテーション提供体制_総合リハビリテーション施設_の有無);
        return this;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅱ）の有無を設定します。
     *
     * @param リハビリテーション提供体制_理学療法Ⅱ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_理学療法Ⅱ_の有無(Code リハビリテーション提供体制_理学療法Ⅱ_の有無) {
        requireNonNull(リハビリテーション提供体制_理学療法Ⅱ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_理学療法Ⅱ_の有無"));
        entity.setRehaTeikyoTaisei_RigakuRyohoII_umu(リハビリテーション提供体制_理学療法Ⅱ_の有無);
        return this;
    }

    /**
     * リハビリテーション提供体制（理学療法Ⅲ）の有無を設定します。
     *
     * @param リハビリテーション提供体制_理学療法Ⅲ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_理学療法Ⅲ_の有無(Code リハビリテーション提供体制_理学療法Ⅲ_の有無) {
        requireNonNull(リハビリテーション提供体制_理学療法Ⅲ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_理学療法Ⅲ_の有無"));
        entity.setRehaTeikyoTaisei_RigakuRyohoIII_umu(リハビリテーション提供体制_理学療法Ⅲ_の有無);
        return this;
    }

    /**
     * リハビリテーション提供体制（作業療法Ⅱ）の有無を設定します。
     *
     * @param リハビリテーション提供体制_作業療法Ⅱ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_作業療法Ⅱ_の有無(Code リハビリテーション提供体制_作業療法Ⅱ_の有無) {
        requireNonNull(リハビリテーション提供体制_作業療法Ⅱ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_作業療法Ⅱ_の有無"));
        entity.setRehaTeikyoTaisei_SagyoRyohoII_umu(リハビリテーション提供体制_作業療法Ⅱ_の有無);
        return this;
    }

    /**
     * リハビリテーション提供体制（精神科作業療法）の有無を設定します。
     *
     * @param リハビリテーション提供体制_精神科作業療法_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_精神科作業療法_の有無(Code リハビリテーション提供体制_精神科作業療法_の有無) {
        requireNonNull(リハビリテーション提供体制_精神科作業療法_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_精神科作業療法_の有無")
        );
        entity.setRehaTeikyoTaisei_SeisinkaSagyouRyoho_umu(リハビリテーション提供体制_精神科作業療法_の有無);
        return this;
    }

    /**
     * リハビリテーション提供体制（その他）の有無を設定します。
     *
     * @param リハビリテーション提供体制_その他_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション提供体制_その他_の有無(Code リハビリテーション提供体制_その他_の有無) {
        requireNonNull(リハビリテーション提供体制_その他_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション提供体制_その他_の有無")
        );
        entity.setRehaTeikyoTaisei_Sonota_umu(リハビリテーション提供体制_その他_の有無);
        return this;
    }

    /**
     * リハビリテーションの加算状況の有無を設定します。
     *
     * @param リハビリテーションの加算状況の有無 リハビリテーションの加算状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーションの加算状況の有無(Code リハビリテーションの加算状況の有無) {
        requireNonNull(リハビリテーションの加算状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーションの加算状況の有無"));
        entity.setRehabilitationKasanJokyo(リハビリテーションの加算状況の有無);
        return this;
    }

    /**
     * 療養環境基準を設定します。
     *
     * @param 療養環境基準 療養環境基準
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set療養環境基準(Code 療養環境基準) {
        requireNonNull(療養環境基準, UrSystemErrorMessages.値がnull.getReplacedMessage("療養環境基準"));
        entity.setRyoyoKankyoKijun(療養環境基準);
        return this;
    }

    /**
     * 医師の欠員による減算の状況の有無を設定します。
     *
     * @param 医師の欠員による減算の状況の有無 医師の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set医師の欠員による減算の状況の有無(Code 医師の欠員による減算の状況の有無) {
        requireNonNull(医師の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("医師の欠員による減算の状況の有無"));
        entity.setIshiKetuinGenzanJokyo_umu(医師の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 看護職員の欠員による減算の状況の有無を設定します。
     *
     * @param 看護職員の欠員による減算の状況の有無 看護職員の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set看護職員の欠員による減算の状況の有無(Code 看護職員の欠員による減算の状況の有無) {
        requireNonNull(看護職員の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("看護職員の欠員による減算の状況の有無"));
        entity.setKangoShokuinKetsuinGenzanJokyo_umu(看護職員の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 理学療法士の欠員による減算の状況の有無を設定します。
     *
     * @param 理学療法士の欠員による減算の状況の有無 理学療法士の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set理学療法士の欠員による減算の状況の有無(Code 理学療法士の欠員による減算の状況の有無) {
        requireNonNull(理学療法士の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("理学療法士の欠員による減算の状況の有無"));
        entity.setRigakuRyouhousiKetsuinGenzanJokyo_umu(理学療法士の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 作業療法士の欠員による減算の状況の有無を設定します。
     *
     * @param 作業療法士の欠員による減算の状況の有無 作業療法士の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set作業療法士の欠員による減算の状況の有無(Code 作業療法士の欠員による減算の状況の有無) {
        requireNonNull(作業療法士の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("作業療法士の欠員による減算の状況の有無"));
        entity.setSagyouRyouhousiKetsuinGenzanJokyo_umu(作業療法士の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 介護職員の欠員による減算の状況の有無を設定します。
     *
     * @param 介護職員の欠員による減算の状況の有無 介護職員の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護職員の欠員による減算の状況の有無(Code 介護職員の欠員による減算の状況の有無) {
        requireNonNull(介護職員の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("介護職員の欠員による減算の状況の有無"));
        entity.setKaigoShokuinKetsuinGenzanJokyo_umu(介護職員の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 介護支援専門員の欠員による減算の状況の有無を設定します。
     *
     * @param 介護支援専門員の欠員による減算の状況の有無 介護支援専門員の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護支援専門員の欠員による減算の状況の有無(Code 介護支援専門員の欠員による減算の状況の有無) {
        requireNonNull(介護支援専門員の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員の欠員による減算の状況の有無"));
        entity.setKaigoSienSenmoninShokuinKetsuinGenzanJokyo_umu(介護支援専門員の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 介護従業者の欠員による減算の状況の有無を設定します。
     *
     * @param 介護従業者の欠員による減算の状況の有無 介護従業者の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護従業者の欠員による減算の状況の有無(Code 介護従業者の欠員による減算の状況の有無) {
        requireNonNull(介護従業者の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("介護従業者の欠員による減算の状況の有無"));
        entity.setKaigoJujishaKetsuinGenzanJokyo_umu(介護従業者の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 感染対策指導管理の有無を設定します。
     *
     * @param 感染対策指導管理の有無 感染対策指導管理の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set感染対策指導管理の有無(Code 感染対策指導管理の有無) {
        requireNonNull(感染対策指導管理の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("感染対策指導管理の有無"));
        entity.setKansenTaisakuSidoKanri_umu(感染対策指導管理の有無);
        return this;
    }

    /**
     * 重症皮膚潰瘍指導管理の有無を設定します。
     *
     * @param 重症皮膚潰瘍指導管理の有無 重症皮膚潰瘍指導管理の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set重症皮膚潰瘍指導管理の有無(Code 重症皮膚潰瘍指導管理の有無) {
        requireNonNull(重症皮膚潰瘍指導管理の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("重症皮膚潰瘍指導管理の有無"));
        entity.setJushoHifuKaiyouShidoKanri_umu(重症皮膚潰瘍指導管理の有無);
        return this;
    }

    /**
     * 薬剤管理指導の有無を設定します。
     *
     * @param 薬剤管理指導の有無 薬剤管理指導の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set薬剤管理指導の有無(Code 薬剤管理指導の有無) {
        requireNonNull(薬剤管理指導の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("薬剤管理指導の有無"));
        entity.setYakuzaiKaniriShido_umu(薬剤管理指導の有無);
        return this;
    }

    /**
     * 障害者生活支援体制の有無を設定します。
     *
     * @param 障害者生活支援体制の有無 障害者生活支援体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set障害者生活支援体制の有無(Code 障害者生活支援体制の有無) {
        requireNonNull(障害者生活支援体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("障害者生活支援体制の有無"));
        entity.setShogaishaSeikatsuShienTaisei_umu(障害者生活支援体制の有無);
        return this;
    }

    /**
     * 地域区分コードを設定します。
     *
     * @param 地域区分コード 地域区分コード
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set地域区分コード(Code 地域区分コード) {
        requireNonNull(地域区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("地域区分コード"));
        entity.setChiikiKubunCode(地域区分コード);
        return this;
    }

    /**
     * 時間延長サービス体制を設定します。
     *
     * @param 時間延長サービス体制 時間延長サービス体制
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set時間延長サービス体制(Code 時間延長サービス体制) {
        requireNonNull(時間延長サービス体制, UrSystemErrorMessages.値がnull.getReplacedMessage("時間延長サービス体制"));
        entity.setJikanEnchoServiceTaisei(時間延長サービス体制);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制を設定します。
     *
     * @param 個別リハビリテーション提供体制 個別リハビリテーション提供体制
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制(Code 個別リハビリテーション提供体制) {
        requireNonNull(個別リハビリテーション提供体制, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制"));
        entity.setKobetsuRehabilitationTeikyoTaisei(個別リハビリテーション提供体制);
        return this;
    }

    /**
     * 居住費対策を設定します。
     *
     * @param 居住費対策 居住費対策
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set居住費対策(Code 居住費対策) {
        requireNonNull(居住費対策, UrSystemErrorMessages.値がnull.getReplacedMessage("居住費対策"));
        entity.setKyojuhiTaisaku(居住費対策);
        return this;
    }

    /**
     * 夜間ケアの有無を設定します。
     *
     * @param 夜間ケアの有無 夜間ケアの有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set夜間ケアの有無(Code 夜間ケアの有無) {
        requireNonNull(夜間ケアの有無, UrSystemErrorMessages.値がnull.getReplacedMessage("夜間ケアの有無"));
        entity.setYakanCare_umu(夜間ケアの有無);
        return this;
    }

    /**
     * リハビリテーション機能強化の有無を設定します。
     *
     * @param リハビリテーション機能強化の有無 リハビリテーション機能強化の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setリハビリテーション機能強化の有無(Code リハビリテーション機能強化の有無) {
        requireNonNull(リハビリテーション機能強化の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション機能強化の有無"));
        entity.setRehabilitationKinoKyoka_umu(リハビリテーション機能強化の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（総合リハビリテーション施設）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_総合リハビリテーション施設_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_総合リハビリテーション施設_の有無(Code 個別リハビリテーション提供体制_総合リハビリテーション施設_の有無) {
        requireNonNull(個別リハビリテーション提供体制_総合リハビリテーション施設_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_総合リハビリテーション施設_の有無"));
        entity.setKobetsuRehaTeikyoTaisei_SogoRehaShisetsu_umu(個別リハビリテーション提供体制_総合リハビリテーション施設_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無1を設定します。
     *
     * @param 個別リハビリテーション提供体制_理学療法Ⅱ_の有無1
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_理学療法Ⅱ_の有無1(Code 個別リハビリテーション提供体制_理学療法Ⅱ_の有無1) {
        requireNonNull(個別リハビリテーション提供体制_理学療法Ⅱ_の有無1, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_理学療法Ⅱ_の有無1"));
        entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu1(個別リハビリテーション提供体制_理学療法Ⅱ_の有無1);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅲ）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_理学療法Ⅲ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_理学療法Ⅲ_の有無(Code 個別リハビリテーション提供体制_理学療法Ⅲ_の有無) {
        requireNonNull(個別リハビリテーション提供体制_理学療法Ⅲ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_理学療法Ⅲ_の有無")
        );
        entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoIII_umu(個別リハビリテーション提供体制_理学療法Ⅲ_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法Ⅱ）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_作業療法Ⅱ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_作業療法Ⅱ_の有無(Code 個別リハビリテーション提供体制_作業療法Ⅱ_の有無) {
        requireNonNull(個別リハビリテーション提供体制_作業療法Ⅱ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_作業療法Ⅱ_の有無")
        );
        entity.setKobetsuRehaTeikyoTaisei_SagyoRyohoII_umu(個別リハビリテーション提供体制_作業療法Ⅱ_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅰ）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無(Code 個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無) {
        requireNonNull(個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無")
        );
        entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoI_umu(個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無
        );
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法Ⅱ）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無(Code 個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無) {
        requireNonNull(個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無")
        );
        entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyohoII_umu(個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無);
        return this;
    }

    /**
     * 言語聴覚士の欠員による減算の状況の有無を設定します。
     *
     * @param 言語聴覚士の欠員による減算の状況の有無 言語聴覚士の欠員による減算の状況の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set言語聴覚士の欠員による減算の状況の有無(Code 言語聴覚士の欠員による減算の状況の有無) {
        requireNonNull(言語聴覚士の欠員による減算の状況の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("言語聴覚士の欠員による減算の状況の有無"));
        entity.setGengoChokakushiKetsuinGenzanJokyo_umu(言語聴覚士の欠員による減算の状況の有無);
        return this;
    }

    /**
     * 栄養管理の評価を設定します。
     *
     * @param 栄養管理の評価 栄養管理の評価
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set栄養管理の評価(Code 栄養管理の評価) {
        requireNonNull(栄養管理の評価, UrSystemErrorMessages.値がnull.getReplacedMessage("栄養管理の評価"));
        entity.setEiyouKanriHyoka(栄養管理の評価);
        return this;
    }

    /**
     * 特定事業所加算（訪問介護）の有無を設定します。
     *
     * @param 特定事業所加算_訪問介護_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set特定事業所加算_訪問介護_の有無(Code 特定事業所加算_訪問介護_の有無) {
        requireNonNull(特定事業所加算_訪問介護_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特定事業所加算_訪問介護_の有無")
        );
        entity.setTokuteijigyoushoKasan_HomonKaigo_umu(特定事業所加算_訪問介護_の有無);
        return this;
    }

    /**
     * 若年性認知症ケア体制の有無を設定します。
     *
     * @param 若年性認知症ケア体制の有無 若年性認知症ケア体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set若年性認知症ケア体制の有無(Code 若年性認知症ケア体制の有無) {
        requireNonNull(若年性認知症ケア体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("若年性認知症ケア体制の有無"));
        entity.setJakunenseiNinchishoCareTaisei_umu(若年性認知症ケア体制の有無);
        return this;
    }

    /**
     * 運動器機能向上体制の有無を設定します。
     *
     * @param 運動器機能向上体制の有無 運動器機能向上体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set運動器機能向上体制の有無(Code 運動器機能向上体制の有無) {
        requireNonNull(運動器機能向上体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("運動器機能向上体制の有無"));
        entity.setUndokiKinoKojoTaisei_umu(運動器機能向上体制の有無);
        return this;
    }

    /**
     * 栄養マネジメント（改善）体制の有無を設定します。
     *
     * @param 栄養マネジメント_改善_体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set栄養マネジメント_改善_体制の有無(Code 栄養マネジメント_改善_体制の有無) {
        requireNonNull(栄養マネジメント_改善_体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("栄養マネジメント_改善_体制の有無"));
        entity.setEiyoManagement_KaizenTaisei_umu(栄養マネジメント_改善_体制の有無);
        return this;
    }

    /**
     * 口腔機能向上体制の有無を設定します。
     *
     * @param 口腔機能向上体制の有無 口腔機能向上体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set口腔機能向上体制の有無(Code 口腔機能向上体制の有無) {
        requireNonNull(口腔機能向上体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("口腔機能向上体制の有無"));
        entity.setKokuKinoKojoTaisei_umu(口腔機能向上体制の有無);
        return this;
    }

    /**
     * 事業所評価加算（申出）の有無を設定します。
     *
     * @param 事業所評価加算_申出_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業所評価加算_申出_の有無(Code 事業所評価加算_申出_の有無) {
        requireNonNull(事業所評価加算_申出_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所評価加算_申出_の有無"));
        entity.setJigyoshoHyokaKasan_Moshide_umu(事業所評価加算_申出_の有無);
        return this;
    }

    /**
     * 事業所評価加算（決定）の有無を設定します。
     *
     * @param 事業所評価加算_決定_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set事業所評価加算_決定_の有無(Code 事業所評価加算_決定_の有無) {
        requireNonNull(事業所評価加算_決定_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所評価加算_決定_の有無")
        );
        entity.setJigyoshoHyokaKasan_Kettei_umu(事業所評価加算_決定_の有無);
        return this;
    }

    /**
     * 緊急受入体制の有無を設定します。
     *
     * @param 緊急受入体制の有無 緊急受入体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set緊急受入体制の有無(Code 緊急受入体制の有無) {
        requireNonNull(緊急受入体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急受入体制の有無"));
        entity.setKinkyuUkeireTaisei_umu(緊急受入体制の有無);
        return this;
    }

    /**
     * 夜間看護体制の有無を設定します。
     *
     * @param 夜間看護体制の有無 夜間看護体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set夜間看護体制の有無(Code 夜間看護体制の有無) {
        requireNonNull(夜間看護体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("夜間看護体制の有無"));
        entity.setYakanKangoTaisei_umu(夜間看護体制の有無);
        return this;
    }

    /**
     * 特定事業所加算（居宅介護支援）の有無を設定します。
     *
     * @param 特定事業所加算_居宅介護支援_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set特定事業所加算_居宅介護支援_の有無(Code 特定事業所加算_居宅介護支援_の有無) {
        requireNonNull(特定事業所加算_居宅介護支援_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("特定事業所加算_居宅介護支援_の有無"));
        entity.setTokuteijigyoshoKasan_Kyotakukaigoshien_umu(特定事業所加算_居宅介護支援_の有無);
        return this;
    }

    /**
     * 介護支援専門員数（専従の常勤者）を設定します。
     *
     * @param 介護支援専門員数_専従の常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護支援専門員数_専従の常勤者_(int 介護支援専門員数_専従の常勤者_) {
        requireNonNull(介護支援専門員数_専従の常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員数_専従の常勤者_")
        );
        entity.setKaigoShienSemmoninSenjuJokinshaNinsu(介護支援専門員数_専従の常勤者_);
        return this;
    }

    /**
     * 介護支援専門員数（専従の非常勤者）を設定します。
     *
     * @param 介護支援専門員数_専従の非常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護支援専門員数_専従の非常勤者_(int 介護支援専門員数_専従の非常勤者_) {
        requireNonNull(介護支援専門員数_専従の非常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員数_専従の非常勤者_")
        );
        entity.setKaigoSienSemmoninSenjuHijokinshaNinsu(介護支援専門員数_専従の非常勤者_);
        return this;
    }

    /**
     * 介護支援専門員数（兼務の常勤者）を設定します。
     *
     * @param 介護支援専門員数_兼務の常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護支援専門員数_兼務の常勤者_(int 介護支援専門員数_兼務の常勤者_) {
        requireNonNull(介護支援専門員数_兼務の常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員数_兼務の常勤者_")
        );
        entity.setKaigoSienSemmoninKemmuJokinshaNinsu(介護支援専門員数_兼務の常勤者_);
        return this;
    }

    /**
     * 介護支援専門員数（兼務の非常勤者）を設定します。
     *
     * @param 介護支援専門員数_兼務の非常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護支援専門員数_兼務の非常勤者_(int 介護支援専門員数_兼務の非常勤者_) {
        requireNonNull(介護支援専門員数_兼務の非常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支援専門員数_兼務の非常勤者_")
        );
        entity.setKaigoSienSemmoninKemmuHijokinshaNinsu(介護支援専門員数_兼務の非常勤者_);
        return this;
    }

    /**
     * 訪問介護サービス提供責任者数を設定します。
     *
     * @param 訪問介護サービス提供責任者数 訪問介護サービス提供責任者数
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護サービス提供責任者数(int 訪問介護サービス提供責任者数) {
        requireNonNull(訪問介護サービス提供責任者数, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護サービス提供責任者数"));
        entity.setHomonkaigoServiceTeikyoSekininshaNinsu(訪問介護サービス提供責任者数);
        return this;
    }

    /**
     * 訪問介護員数（専従の常勤者）を設定します。
     *
     * @param 訪問介護員数_専従の常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護員数_専従の常勤者_(int 訪問介護員数_専従の常勤者_) {
        requireNonNull(訪問介護員数_専従の常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護員数_専従の常勤者_")
        );
        entity.setHomonkaigoSenjuJokinshaNinsu(訪問介護員数_専従の常勤者_);
        return this;
    }

    /**
     * 訪問介護員数（専従の非常勤者）を設定します。
     *
     * @param 訪問介護員数_専従の非常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護員数_専従の非常勤者_(int 訪問介護員数_専従の非常勤者_) {
        requireNonNull(訪問介護員数_専従の非常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護員数_専従の非常勤者_")
        );
        entity.setHomonkaigoSenjuHijokinshaNinsu(訪問介護員数_専従の非常勤者_);
        return this;
    }

    /**
     * 訪問介護員数（兼務の常勤者）を設定します。
     *
     * @param 訪問介護員数_兼務の常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護員数_兼務の常勤者_(int 訪問介護員数_兼務の常勤者_) {
        requireNonNull(訪問介護員数_兼務の常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護員数_兼務の常勤者_")
        );
        entity.setHomonkaigoKemmuJokinshaNinsu(訪問介護員数_兼務の常勤者_);
        return this;
    }

    /**
     * 訪問介護員数（兼務の非常勤者）を設定します。
     *
     * @param 訪問介護員数_兼務の非常勤者_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護員数_兼務の非常勤者_(int 訪問介護員数_兼務の非常勤者_) {
        requireNonNull(訪問介護員数_兼務の非常勤者_, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護員数_兼務の非常勤者_")
        );
        entity.setHomonkaigoKemmuHijokinshaNinsu(訪問介護員数_兼務の非常勤者_);
        return this;
    }

    /**
     * 訪問介護員数（常勤換算後の人数）を設定します。
     *
     * @param 訪問介護員数_常勤換算後の人数_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set訪問介護員数_常勤換算後の人数_(int 訪問介護員数_常勤換算後の人数_) {
        requireNonNull(訪問介護員数_常勤換算後の人数_, UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護員数_常勤換算後の人数_"));
        entity.setHomonkaigoJokinKanzangoNinsu(訪問介護員数_常勤換算後の人数_);
        return this;
    }

    /**
     * 利用定員数を設定します。
     *
     * @param 利用定員数 利用定員数
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set利用定員数(int 利用定員数) {
        requireNonNull(利用定員数, UrSystemErrorMessages.値がnull.getReplacedMessage("利用定員数"));
        entity.setRiyoTeiinNinsu(利用定員数);
        return this;
    }

    /**
     * 指定有効開始日を設定します。
     *
     * @param 指定有効開始日 指定有効開始日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set指定有効開始日(FlexibleDate 指定有効開始日) {
        requireNonNull(指定有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("指定有効開始日"));
        entity.setShiteiYukoKaishiYMD(指定有効開始日);
        return this;
    }

    /**
     * 指定有効終了日を設定します。
     *
     * @param 指定有効終了日 指定有効終了日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set指定有効終了日(FlexibleDate 指定有効終了日) {
        requireNonNull(指定有効終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("指定有効終了日"));
        entity.setShiteiYukoShuryoYMD(指定有効終了日);
        return this;
    }

    /**
     * 指定更新申請中区分を設定します。
     *
     * @param 指定更新申請中区分 指定更新申請中区分
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set指定更新申請中区分(Code 指定更新申請中区分) {
        requireNonNull(指定更新申請中区分, UrSystemErrorMessages.値がnull.getReplacedMessage("指定更新申請中区分"));
        entity.setShiteiKoshinShinseichuKubun(指定更新申請中区分);
        return this;
    }

    /**
     * 効力停止開始日を設定します。
     *
     * @param 効力停止開始日 効力停止開始日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set効力停止開始日(FlexibleDate 効力停止開始日) {
        requireNonNull(効力停止開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("効力停止開始日"));
        entity.setKoryokuTeishiKaishiYMD(効力停止開始日);
        return this;
    }

    /**
     * 効力停止終了日を設定します。
     *
     * @param 効力停止終了日 効力停止終了日
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set効力停止終了日(FlexibleDate 効力停止終了日) {
        requireNonNull(効力停止終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("効力停止終了日"));
        entity.setKoryokuTeishiShuryoYMD(効力停止終了日);
        return this;
    }

    /**
     * 大規模事業所該当の有無を設定します。
     *
     * @param 大規模事業所該当の有無 大規模事業所該当の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set大規模事業所該当の有無(Code 大規模事業所該当の有無) {
        requireNonNull(大規模事業所該当の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("大規模事業所該当の有無"));
        entity.setDaikiboJigyoshaGaito_umu(大規模事業所該当の有無);
        return this;
    }

    /**
     * 準ユニットケア体制の有無を設定します。
     *
     * @param 準ユニットケア体制の有無 準ユニットケア体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set準ユニットケア体制の有無(Code 準ユニットケア体制の有無) {
        requireNonNull(準ユニットケア体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("準ユニットケア体制の有無"));
        entity.setJunUnitCareTaisei_umu(準ユニットケア体制の有無);
        return this;
    }

    /**
     * 重度化対応体制の有無を設定します。
     *
     * @param 重度化対応体制の有無 重度化対応体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set重度化対応体制の有無(Code 重度化対応体制の有無) {
        requireNonNull(重度化対応体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("重度化対応体制の有無"));
        entity.setJudokaTaioTaisei_umu(重度化対応体制の有無);
        return this;
    }

    /**
     * 医療連携体制の有無を設定します。
     *
     * @param 医療連携体制の有無 医療連携体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set医療連携体制の有無(Code 医療連携体制の有無) {
        requireNonNull(医療連携体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("医療連携体制の有無"));
        entity.setIryoRenkeiTaisei_umu(医療連携体制の有無);
        return this;
    }

    /**
     * ユニットケア体制の有無を設定します。
     *
     * @param ユニットケア体制の有無 ユニットケア体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setユニットケア体制の有無(Code ユニットケア体制の有無) {
        requireNonNull(ユニットケア体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("ユニットケア体制の有無"));
        entity.setUnitCareTaisei_umu(ユニットケア体制の有無);
        return this;
    }

    /**
     * 在宅・入所相互利用体制の有無を設定します。
     *
     * @param 在宅_入所相互利用体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set在宅_入所相互利用体制の有無(Code 在宅_入所相互利用体制の有無) {
        requireNonNull(在宅_入所相互利用体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅_入所相互利用体制の有無")
        );
        entity.setZaitaku_nyushoSogoRiyoTaisei_umu(在宅_入所相互利用体制の有無);
        return this;
    }

    /**
     * ターミナルケア体制（看取り介護体制）の有無を設定します。
     *
     * @param ターミナルケア体制_看取り介護体制_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setターミナルケア体制_看取り介護体制_の有無(Code ターミナルケア体制_看取り介護体制_の有無) {
        requireNonNull(ターミナルケア体制_看取り介護体制_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("ターミナルケア体制_看取り介護体制_の有無")
        );
        entity.setTerminalCareTaisei_umu(ターミナルケア体制_看取り介護体制_の有無);
        return this;
    }

    /**
     * 身体拘束廃止取組の有無を設定します。
     *
     * @param 身体拘束廃止取組の有無 身体拘束廃止取組の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set身体拘束廃止取組の有無(Code 身体拘束廃止取組の有無) {
        requireNonNull(身体拘束廃止取組の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("身体拘束廃止取組の有無"));
        entity.setShintaiKosokuHaishiTorikumi_umu(身体拘束廃止取組の有無);
        return this;
    }

    /**
     * 小規模拠点集合体制の有無を設定します。
     *
     * @param 小規模拠点集合体制の有無 小規模拠点集合体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set小規模拠点集合体制の有無(Code 小規模拠点集合体制の有無) {
        requireNonNull(小規模拠点集合体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("小規模拠点集合体制の有無"));
        entity.setShokiboKyotenShugoTaisei_umu(小規模拠点集合体制の有無);
        return this;
    }

    /**
     * 認知症ケア加算の有無を設定します。
     *
     * @param 認知症ケア加算の有無 認知症ケア加算の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set認知症ケア加算の有無(Code 認知症ケア加算の有無) {
        requireNonNull(認知症ケア加算の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症ケア加算の有無"));
        entity.setNinchishoCareKasan_umu(認知症ケア加算の有無);
        return this;
    }

    /**
     * 個別機能訓練体制の有無を設定します。
     *
     * @param 個別機能訓練体制の有無 個別機能訓練体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別機能訓練体制の有無(Code 個別機能訓練体制の有無) {
        requireNonNull(個別機能訓練体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別機能訓練体制の有無"));
        entity.setKobetsuKinoKunrenTaisei_umu(個別機能訓練体制の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅰ）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_理学療法Ⅰ_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_理学療法Ⅰ_の有無(Code 個別リハビリテーション提供体制_理学療法Ⅰ_の有無) {
        requireNonNull(個別リハビリテーション提供体制_理学療法Ⅰ_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_理学療法Ⅰ_の有無"));
        entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoI_umu(個別リハビリテーション提供体制_理学療法Ⅰ_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（理学療法Ⅱ）の有無2を設定します。
     *
     * @param 個別リハビリテーション提供体制_理学療法Ⅱ_の有無2
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_理学療法Ⅱ_の有無2(Code 個別リハビリテーション提供体制_理学療法Ⅱ_の有無2) {
        requireNonNull(個別リハビリテーション提供体制_理学療法Ⅱ_の有無2, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_理学療法Ⅱ_の有無2")
        );
        entity.setKobetsuRehaTeikyoTaisei_RigakuRyohoII_umu2(個別リハビリテーション提供体制_理学療法Ⅱ_の有無2);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（作業療法）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_作業療法_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_作業療法_の有無(Code 個別リハビリテーション提供体制_作業療法_の有無) {
        requireNonNull(個別リハビリテーション提供体制_作業療法_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_作業療法_の有無"));
        entity.setKobetsuRehaTeikyoTaisei_SagyoRyoho_umu(個別リハビリテーション提供体制_作業療法_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（言語聴覚療法）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_言語聴覚療法_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_言語聴覚療法_の有無(Code 個別リハビリテーション提供体制_言語聴覚療法_の有無) {
        requireNonNull(個別リハビリテーション提供体制_言語聴覚療法_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_言語聴覚療法_の有無")
        );
        entity.setKobetsuRehaTeikyoTaisei_GengoChokakuRyoho_umu(個別リハビリテーション提供体制_言語聴覚療法_の有無);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（その他）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_その他_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_その他_の有無(Code 個別リハビリテーション提供体制_その他_の有無) {
        requireNonNull(個別リハビリテーション提供体制_その他_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_その他_の有無"));
        entity.setKobetsuRehaTeikyoTaisei_Sonota_umu(個別リハビリテーション提供体制_その他_の有無);
        return this;
    }

    /**
     * 設備基準を設定します。
     *
     * @param 設備基準 設備基準
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set設備基準(Code 設備基準) {
        requireNonNull(設備基準, UrSystemErrorMessages.値がnull.getReplacedMessage("設備基準"));
        entity.setSetsubiKijun(設備基準);
        return this;
    }

    /**
     * 療養体制維持特別加算を設定します。
     *
     * @param 療養体制維持特別加算 療養体制維持特別加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set療養体制維持特別加算(Code 療養体制維持特別加算) {
        requireNonNull(療養体制維持特別加算, UrSystemErrorMessages.値がnull.getReplacedMessage("療養体制維持特別加算"));
        entity.setRyoyoTaiseiIjiTokubetsuKasan(療養体制維持特別加算);
        return this;
    }

    /**
     * 個別リハビリテーション提供体制（リハビリテーション指導管理）の有無を設定します。
     *
     * @param 個別リハビリテーション提供体制_リハビリテーション指導管理_の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set個別リハビリテーション提供体制_リハビリテーション指導管理_の有無(Code 個別リハビリテーション提供体制_リハビリテーション指導管理_の有無) {
        requireNonNull(個別リハビリテーション提供体制_リハビリテーション指導管理_の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("個別リハビリテーション提供体制_リハビリテーション指導管理_の有無"));
        entity.setKobetsuRehaTeikyoTaisei_RehaShidoKanri_umu(個別リハビリテーション提供体制_リハビリテーション指導管理_の有無);
        return this;
    }

    /**
     * ３級ヘルパー体制を設定します。
     *
     * @param ヘルパー体制_３級
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set３級ヘルパー体制(Code ヘルパー体制_３級) {
        requireNonNull(ヘルパー体制_３級, UrSystemErrorMessages.値がnull.getReplacedMessage("ヘルパー体制_３級"));
        entity.setSankyuHelperTaisei(ヘルパー体制_３級);
        return this;
    }

    /**
     * 中山間地域等における小規模事業所加算（地域に関する状況）を設定します。
     *
     * @param 中山間地域等における小規模事業所加算_地域に関する状況_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set中山間地域等における小規模事業所加算_地域に関する状況_(Code 中山間地域等における小規模事業所加算_地域に関する状況_) {
        requireNonNull(中山間地域等における小規模事業所加算_地域に関する状況_, UrSystemErrorMessages.値がnull.getReplacedMessage("中山間地域等における小規模事業所加算_地域に関する状況_")
        );
        entity.setChuSankanChiikiShokiboJigyoshoKasan_chiiki(中山間地域等における小規模事業所加算_地域に関する状況_);
        return this;
    }

    /**
     * 中山間地域等における小規模事業所加算（規模に関する状況）を設定します。
     *
     * @param 中山間地域等における小規模事業所加算_規模に関する状況_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set中山間地域等における小規模事業所加算_規模に関する状況_(Code 中山間地域等における小規模事業所加算_規模に関する状況_) {
        requireNonNull(中山間地域等における小規模事業所加算_規模に関する状況_, UrSystemErrorMessages.値がnull.getReplacedMessage("中山間地域等における小規模事業所加算_規模に関する状況_"));
        entity.setChuSankanChiikiShokiboJigyoushoKasan_kibo(中山間地域等における小規模事業所加算_規模に関する状況_);
        return this;
    }

    /**
     * サービス提供体制強化加算を設定します。
     *
     * @param サービス提供体制強化加算 サービス提供体制強化加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setサービス提供体制強化加算(Code サービス提供体制強化加算) {
        requireNonNull(サービス提供体制強化加算, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供体制強化加算"));
        entity.setServiceTeikyoTaiseiKyokaKasan(サービス提供体制強化加算);
        return this;
    }

    /**
     * 認知症短期集中リハビリテーション加算を設定します。
     *
     * @param 認知症短期集中リハビリテーション加算 認知症短期集中リハビリテーション加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set認知症短期集中リハビリテーション加算(Code 認知症短期集中リハビリテーション加算) {
        requireNonNull(認知症短期集中リハビリテーション加算, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症短期集中リハビリテーション加算"));
        entity.setNinchishoTankiShuchuRehabilitationKasan(認知症短期集中リハビリテーション加算);
        return this;
    }

    /**
     * 若年性認知症利用者（入所者・患者）受入加算を設定します。
     *
     * @param 若年性認知症利用者_入所者_患者_受入加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set若年性認知症利用者_入所者_患者_受入加算(Code 若年性認知症利用者_入所者_患者_受入加算) {
        requireNonNull(若年性認知症利用者_入所者_患者_受入加算, UrSystemErrorMessages.値がnull.getReplacedMessage("若年性認知症利用者_入所者_患者_受入加算")
        );
        entity.setJakunenseiNinchishoRiyoushaUkeeireKasan(若年性認知症利用者_入所者_患者_受入加算);
        return this;
    }

    /**
     * 看護体制加算を設定します。
     *
     * @param 看護体制加算 看護体制加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set看護体制加算(Code 看護体制加算) {
        requireNonNull(看護体制加算, UrSystemErrorMessages.値がnull.getReplacedMessage("看護体制加算"));
        entity.setKangoTaiseiKasan(看護体制加算);
        return this;
    }

    /**
     * 夜勤職員配置加算を設定します。
     *
     * @param 夜勤職員配置加算 夜勤職員配置加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set夜勤職員配置加算(Code 夜勤職員配置加算) {
        requireNonNull(夜勤職員配置加算, UrSystemErrorMessages.値がnull.getReplacedMessage("夜勤職員配置加算"));
        entity.setYakinShokuinHaichiKasan(夜勤職員配置加算);
        return this;
    }

    /**
     * 療養食加算を設定します。
     *
     * @param 療養食加算 療養食加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set療養食加算(Code 療養食加算) {
        requireNonNull(療養食加算, UrSystemErrorMessages.値がnull.getReplacedMessage("療養食加算"));
        entity.setRyoyoShokuKasan(療養食加算);
        return this;
    }

    /**
     * 日常生活継続支援加算を設定します。
     *
     * @param 日常生活継続支援加算 日常生活継続支援加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set日常生活継続支援加算(Code 日常生活継続支援加算) {
        requireNonNull(日常生活継続支援加算, UrSystemErrorMessages.値がnull.getReplacedMessage("日常生活継続支援加算"));
        entity.setNichijoSeikatsuKeizokuShienKasan(日常生活継続支援加算);
        return this;
    }

    /**
     * 認知症専門ケア加算を設定します。
     *
     * @param 認知症専門ケア加算 認知症専門ケア加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set認知症専門ケア加算(Code 認知症専門ケア加算) {
        requireNonNull(認知症専門ケア加算, UrSystemErrorMessages.値がnull.getReplacedMessage("認知症専門ケア加算"));
        entity.setNinchishoSemmonCareKasan(認知症専門ケア加算);
        return this;
    }

    /**
     * ２４時間通報対応加算を設定します。
     *
     * @param 対応加算_２４時間通報
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set２４時間通報対応加算(Code 対応加算_２４時間通報) {
        requireNonNull(対応加算_２４時間通報, UrSystemErrorMessages.値がnull.getReplacedMessage("対応加算_２４時間通報"));
        entity.setTwentyFourHoursTsuhoTaioKasan(対応加算_２４時間通報);
        return this;
    }

    /**
     * 看護職員配置加算を設定します。
     *
     * @param 看護職員配置加算 看護職員配置加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set看護職員配置加算(Code 看護職員配置加算) {
        requireNonNull(看護職員配置加算, UrSystemErrorMessages.値がnull.getReplacedMessage("看護職員配置加算"));
        entity.setKangoShokuinHaichiKasan(看護職員配置加算);
        return this;
    }

    /**
     * 夜間ケア加算を設定します。
     *
     * @param 夜間ケア加算 夜間ケア加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set夜間ケア加算(Code 夜間ケア加算) {
        requireNonNull(夜間ケア加算, UrSystemErrorMessages.値がnull.getReplacedMessage("夜間ケア加算"));
        entity.setYakanCareKasan(夜間ケア加算);
        return this;
    }

    /**
     * 集団コミュニケーション療法の有無を設定します。
     *
     * @param 集団コミュニケーション療法の有無 集団コミュニケーション療法の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set集団コミュニケーション療法の有無(Code 集団コミュニケーション療法の有無) {
        requireNonNull(集団コミュニケーション療法の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("集団コミュニケーション療法の有無"));
        entity.setShudanCommunicationRyoho_umu(集団コミュニケーション療法の有無);
        return this;
    }

    /**
     * サービス提供体制強化加算（空床型）を設定します。
     *
     * @param サービス提供体制強化加算_空床型_ サービス提供体制強化加算_空床型_
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setサービス提供体制強化加算_空床型_(Code サービス提供体制強化加算_空床型_) {
        requireNonNull(サービス提供体制強化加算_空床型_, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供体制強化加算_空床型_（空床型）"));
        entity.setServiceTeikyoTaiseiKyokaKasan_Karadokogata(サービス提供体制強化加算_空床型_);
        return this;
    }

    /**
     * 日中の身体介護２０分未満体制の有無を設定します。
     *
     * @param 日中の身体介護２０分未満体制の有無 日中の身体介護２０分未満体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set日中の身体介護２０分未満体制の有無(Code 日中の身体介護２０分未満体制の有無) {
        requireNonNull(日中の身体介護２０分未満体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("日中の身体介護２０分未満体制の有無"));
        entity.setNitchuShintaikaigoTaise_20funmiman_umu(日中の身体介護２０分未満体制の有無);
        return this;
    }

    /**
     * サービス提供責任者体制の有無を設定します。
     *
     * @param サービス提供責任者体制の有無 サービス提供責任者体制の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder setサービス提供責任者体制の有無(Code サービス提供責任者体制の有無) {
        requireNonNull(サービス提供責任者体制の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供責任者体制の有無"));
        entity.setServiceTeikyoSekininshaTaisei_umu(サービス提供責任者体制の有無);
        return this;
    }

    /**
     * 同一建物に居住する利用者の減算の有無を設定します。
     *
     * @param 同一建物に居住する利用者の減算の有無 同一建物に居住する利用者の減算の有無
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set同一建物に居住する利用者の減算の有無(Code 同一建物に居住する利用者の減算の有無) {
        requireNonNull(同一建物に居住する利用者の減算の有無, UrSystemErrorMessages.値がnull.getReplacedMessage("同一建物に居住する利用者の減算の有無"));
        entity.setDoitsuTatemonoKyojuRiyoshaGenzan_umu(同一建物に居住する利用者の減算の有無);
        return this;
    }

    /**
     * 緊急短期入所体制確保加算を設定します。
     *
     * @param 緊急短期入所体制確保加算 緊急短期入所体制確保加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set緊急短期入所体制確保加算(Code 緊急短期入所体制確保加算) {
        requireNonNull(緊急短期入所体制確保加算, UrSystemErrorMessages.値がnull.getReplacedMessage("緊急短期入所体制確保加算"));
        entity.setKinkyuTankiNyushoTaiseiKakuhoKasan(緊急短期入所体制確保加算);
        return this;
    }

    /**
     * 在宅復帰・在宅療養支援機能加算を設定します。
     *
     * @param 在宅復帰_在宅療養支援機能加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set在宅復帰_在宅療養支援機能加算(Code 在宅復帰_在宅療養支援機能加算) {
        requireNonNull(在宅復帰_在宅療養支援機能加算, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅復帰_在宅療養支援機能加算"));
        entity.setZaitakuFukki_ZaitakuRyoyoShienKinoKasan(在宅復帰_在宅療養支援機能加算);
        return this;
    }

    /**
     * 生活機能向上グループ活動加算を設定します。
     *
     * @param 生活機能向上グループ活動加算 生活機能向上グループ活動加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set生活機能向上グループ活動加算(Code 生活機能向上グループ活動加算) {
        requireNonNull(生活機能向上グループ活動加算, UrSystemErrorMessages.値がnull.getReplacedMessage("生活機能向上グループ活動加算"));
        entity.setSeikatuKinoKojoGroupKatsudoKasan(生活機能向上グループ活動加算);
        return this;
    }

    /**
     * 介護職員処遇改善加算を設定します。
     *
     * @param 介護職員処遇改善加算 介護職員処遇改善加算
     * @return {@link KaigoJigyoshaShiteiServiceBuilder}
     */
    public KaigoJigyoshaShiteiServiceBuilder set介護職員処遇改善加算(Code 介護職員処遇改善加算) {
        requireNonNull(介護職員処遇改善加算, UrSystemErrorMessages.値がnull.getReplacedMessage("介護職員処遇改善加算"));
        entity.setKaigoShokuinShoguKaizenKasan(介護職員処遇改善加算);
        return this;
    }

    /**
     * {@link KaigoJigyoshaShiteiService}のインスタンスを生成します。
     *
     * @return {@link KaigoJigyoshaShiteiService}のインスタンス
     */
    public KaigoJigyoshaShiteiService build() {
        return new KaigoJigyoshaShiteiService(entity, id);
    }
}
