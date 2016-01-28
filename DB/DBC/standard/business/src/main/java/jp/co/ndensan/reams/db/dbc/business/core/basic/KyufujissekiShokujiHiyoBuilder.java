/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3022KyufujissekiShokujiHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyufujissekiShokujiHiyo}の編集を行うビルダークラスです。
 */
public class KyufujissekiShokujiHiyoBuilder {

    private final DbT3022KyufujissekiShokujiHiyoEntity entity;
    private final KyufujissekiShokujiHiyoIdentifier id;

    /**
     * {@link DbT3022KyufujissekiShokujiHiyoEntity}より{@link KyufujissekiShokujiHiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3022KyufujissekiShokujiHiyoEntity}
     * @param id {@link KyufujissekiShokujiHiyoIdentifier}
     *
     */
    KyufujissekiShokujiHiyoBuilder(
            DbT3022KyufujissekiShokujiHiyoEntity entity,
            KyufujissekiShokujiHiyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        return this;
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
        return this;
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
        return this;
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
        return this;
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
        return this;
    }

    /**
     * 基本_提供日数を設定します。
     *
     * @param 基本_提供日数 基本_提供日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set基本_提供日数(Decimal 基本_提供日数) {
        requireNonNull(基本_提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供日数"));
        entity.setKihonTeikyoNissu(基本_提供日数);
        return this;
    }

    /**
     * 基本_提供単価を設定します。
     *
     * @param 基本_提供単価 基本_提供単価
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set基本_提供単価(Decimal 基本_提供単価) {
        requireNonNull(基本_提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供単価"));
        entity.setKihonTeikyoTanka(基本_提供単価);
        return this;
    }

    /**
     * 基本_提供金額を設定します。
     *
     * @param 基本_提供金額 基本_提供金額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set基本_提供金額(Decimal 基本_提供金額) {
        requireNonNull(基本_提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("基本_提供金額"));
        entity.setKihonTeikyoKingaku(基本_提供金額);
        return this;
    }

    /**
     * 特別_提供日数を設定します。
     *
     * @param 特別_提供日数 特別_提供日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set特別_提供日数(Decimal 特別_提供日数) {
        requireNonNull(特別_提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供日数"));
        entity.setTokubestuTeikyoNissu(特別_提供日数);
        return this;
    }

    /**
     * 特別_提供単価を設定します。
     *
     * @param 特別_提供単価 特別_提供単価
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set特別_提供単価(Decimal 特別_提供単価) {
        requireNonNull(特別_提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供単価"));
        entity.setTokubestuTeikyoTanka(特別_提供単価);
        return this;
    }

    /**
     * 特別_提供金額を設定します。
     *
     * @param 特別_提供金額 特別_提供金額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set特別_提供金額(Decimal 特別_提供金額) {
        requireNonNull(特別_提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("特別_提供金額"));
        entity.setTokubestuTeikyoKingaku(特別_提供金額);
        return this;
    }

    /**
     * 食事提供延べ日数を設定します。
     *
     * @param 食事提供延べ日数 食事提供延べ日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set食事提供延べ日数(Decimal 食事提供延べ日数) {
        requireNonNull(食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供延べ日数"));
        entity.setSyokujiTeikyoNissu(食事提供延べ日数);
        return this;
    }

    /**
     * 公費１対象食事提供延べ日数を設定します。
     *
     * @param 公費１対象食事提供延べ日数 公費１対象食事提供延べ日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費１対象食事提供延べ日数(Decimal 公費１対象食事提供延べ日数) {
        requireNonNull(公費１対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１対象食事提供延べ日数"));
        entity.setKohi1SyokujiTeikyoNissu(公費１対象食事提供延べ日数);
        return this;
    }

    /**
     * 公費２対象食事提供延べ日数を設定します。
     *
     * @param 公費２対象食事提供延べ日数 公費２対象食事提供延べ日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費２対象食事提供延べ日数(Decimal 公費２対象食事提供延べ日数) {
        requireNonNull(公費２対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２対象食事提供延べ日数"));
        entity.setKohi2SyokujiTeikyoNissu(公費２対象食事提供延べ日数);
        return this;
    }

    /**
     * 公費３対象食事提供延べ日数を設定します。
     *
     * @param 公費３対象食事提供延べ日数 公費３対象食事提供延べ日数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費３対象食事提供延べ日数(Decimal 公費３対象食事提供延べ日数) {
        requireNonNull(公費３対象食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３対象食事提供延べ日数"));
        entity.setKohi3SyokujiTeikyoNissu(公費３対象食事提供延べ日数);
        return this;
    }

    /**
     * 食事提供費合計を設定します。
     *
     * @param 食事提供費合計 食事提供費合計
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set食事提供費合計(Decimal 食事提供費合計) {
        requireNonNull(食事提供費合計, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費合計"));
        entity.setSyokujiTeikyohiTotal(食事提供費合計);
        return this;
    }

    /**
     * 標準負担額_月額を設定します。
     *
     * @param 標準負担額_月額 標準負担額_月額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set標準負担額_月額(Decimal 標準負担額_月額) {
        requireNonNull(標準負担額_月額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_月額"));
        entity.setGetsugakuHyojunFutanGaku(標準負担額_月額);
        return this;
    }

    /**
     * 食事提供費請求額を設定します。
     *
     * @param 食事提供費請求額 食事提供費請求額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set食事提供費請求額(Decimal 食事提供費請求額) {
        requireNonNull(食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費請求額"));
        entity.setSyokujiTeikyohiSeikyugaku(食事提供費請求額);
        return this;
    }

    /**
     * 公費１食事提供費請求額を設定します。
     *
     * @param 公費１食事提供費請求額 公費１食事提供費請求額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費１食事提供費請求額(Decimal 公費１食事提供費請求額) {
        requireNonNull(公費１食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費１食事提供費請求額"));
        entity.setKohi1SyokujiTeikyohiSeikyugaku(公費１食事提供費請求額);
        return this;
    }

    /**
     * 公費２食事提供費請求額を設定します。
     *
     * @param 公費２食事提供費請求額 公費２食事提供費請求額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費２食事提供費請求額(Decimal 公費２食事提供費請求額) {
        requireNonNull(公費２食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費２食事提供費請求額"));
        entity.setKohi2SyokujiTeikyohiSeikyugaku(公費２食事提供費請求額);
        return this;
    }

    /**
     * 公費３食事提供費請求額を設定します。
     *
     * @param 公費３食事提供費請求額 公費３食事提供費請求額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set公費３食事提供費請求額(Decimal 公費３食事提供費請求額) {
        requireNonNull(公費３食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("公費３食事提供費請求額"));
        entity.setKohi3SyokujiTeikyohiSeikyugaku(公費３食事提供費請求額);
        return this;
    }

    /**
     * 標準負担額_日額を設定します。
     *
     * @param 標準負担額_日額 標準負担額_日額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set標準負担額_日額(Decimal 標準負担額_日額) {
        requireNonNull(標準負担額_日額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_日額"));
        entity.setNichigakuHyojunFutanGaku(標準負担額_日額);
        return this;
    }

    /**
     * 後_基本食提供費用提供単価を設定します。
     *
     * @param 後_基本食提供費用提供単価 後_基本食提供費用提供単価
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set後_基本食提供費用提供単価(Decimal 後_基本食提供費用提供単価) {
        requireNonNull(後_基本食提供費用提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_基本食提供費用提供単価"));
        entity.setAtoKihonTeikyoTanka(後_基本食提供費用提供単価);
        return this;
    }

    /**
     * 後_特別食提供費用提供単価を設定します。
     *
     * @param 後_特別食提供費用提供単価 後_特別食提供費用提供単価
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set後_特別食提供費用提供単価(Decimal 後_特別食提供費用提供単価) {
        requireNonNull(後_特別食提供費用提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("後_特別食提供費用提供単価"));
        entity.setAtoTokubestuTeikyoTanka(後_特別食提供費用提供単価);
        return this;
    }

    /**
     * 後_食事提供費請求額を設定します。
     *
     * @param 後_食事提供費請求額 後_食事提供費請求額
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set後_食事提供費請求額(Decimal 後_食事提供費請求額) {
        requireNonNull(後_食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_食事提供費請求額"));
        entity.setAtoSyokujiTeikyohiSeikyugaku(後_食事提供費請求額);
        return this;
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set再審査回数(Decimal 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
        return this;
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set過誤回数(Decimal 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
        return this;
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     * @return {@link KyufujissekiShokujiHiyoBuilder}
     */
    public KyufujissekiShokujiHiyoBuilder set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
        return this;
    }

    /**
     * {@link KyufujissekiShokujiHiyo}のインスタンスを生成します。
     *
     * @return {@link KyufujissekiShokujiHiyo}のインスタンス
     */
    public KyufujissekiShokujiHiyo build() {
        return new KyufujissekiShokujiHiyo(entity, id);
    }
}
