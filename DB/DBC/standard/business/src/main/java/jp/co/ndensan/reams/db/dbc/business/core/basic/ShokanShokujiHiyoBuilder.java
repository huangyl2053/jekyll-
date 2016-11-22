/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ShokanShokujiHiyo}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanShokujiHiyoBuilder {

    private final DbT3043ShokanShokujiHiyoEntity entity;
    private final ShokanShokujiHiyoIdentifier id;

    /**
     * {@link DbT3043ShokanShokujiHiyoEntity}より{@link ShokanShokujiHiyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3043ShokanShokujiHiyoEntity}
     * @param id {@link ShokanShokujiHiyoIdentifier}
     *
     */
    ShokanShokujiHiyoBuilder(
            DbT3043ShokanShokujiHiyoEntity entity,
            ShokanShokujiHiyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 明細番号を設定します。
     *
     * @param 明細番号 明細番号
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set明細番号(RString 明細番号) {
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        entity.setMeisaiNo(明細番号);
        return this;
    }

    /**
     * 連番を設定します。
     *
     * @param 連番 連番
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set連番(RString 連番) {
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        entity.setRenban(連番);
        return this;
    }

    /**
     * 基本提供日数を設定します。
     *
     * @param 基本提供日数 基本提供日数
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set基本提供日数(int 基本提供日数) {
        requireNonNull(基本提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供日数"));
        entity.setKihonTeikyoNissu(基本提供日数);
        return this;
    }

    /**
     * 基本提供単価を設定します。
     *
     * @param 基本提供単価 基本提供単価
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set基本提供単価(int 基本提供単価) {
        requireNonNull(基本提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供単価"));
        entity.setKihonTeikyoTanka(基本提供単価);
        return this;
    }

    /**
     * 基本提供金額を設定します。
     *
     * @param 基本提供金額 基本提供金額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set基本提供金額(int 基本提供金額) {
        requireNonNull(基本提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供金額"));
        entity.setKihonTeikyoKingaku(基本提供金額);
        return this;
    }

    /**
     * 特別提供日数を設定します。
     *
     * @param 特別提供日数 特別提供日数
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set特別提供日数(int 特別提供日数) {
        requireNonNull(特別提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供日数"));
        entity.setTokubetsuTeikyoNissu(特別提供日数);
        return this;
    }

    /**
     * 特別提供単価を設定します。
     *
     * @param 特別提供単価 特別提供単価
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set特別提供単価(int 特別提供単価) {
        requireNonNull(特別提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供単価"));
        entity.setTokubetsuTeikyoTanka(特別提供単価);
        return this;
    }

    /**
     * 特別提供金額を設定します。
     *
     * @param 特別提供金額 特別提供金額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set特別提供金額(int 特別提供金額) {
        requireNonNull(特別提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供金額"));
        entity.setTokubetsuTeikyoKingaku(特別提供金額);
        return this;
    }

    /**
     * 食事提供延べ日数を設定します。
     *
     * @param 食事提供延べ日数 食事提供延べ日数
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set食事提供延べ日数(int 食事提供延べ日数) {
        requireNonNull(食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供延べ日数"));
        entity.setShokujiTeikyoTotalNissu(食事提供延べ日数);
        return this;
    }

    /**
     * 食事提供費合計を設定します。
     *
     * @param 食事提供費合計 食事提供費合計
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set食事提供費合計(int 食事提供費合計) {
        requireNonNull(食事提供費合計, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費合計"));
        entity.setShokujiTeikyohiTotal(食事提供費合計);
        return this;
    }

    /**
     * 標準負担額_月額を設定します。
     *
     * @param 標準負担額_月額 標準負担額_月額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set標準負担額_月額(int 標準負担額_月額) {
        requireNonNull(標準負担額_月額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_月額"));
        entity.setGetsugakuHyojunFutangaku(標準負担額_月額);
        return this;
    }

    /**
     * 食事提供費請求額を設定します。
     *
     * @param 食事提供費請求額 食事提供費請求額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set食事提供費請求額(int 食事提供費請求額) {
        requireNonNull(食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費請求額"));
        entity.setShokujiTeikyohiSeikyugaku(食事提供費請求額);
        return this;
    }

    /**
     * 標準負担額_日額を設定します。
     *
     * @param 標準負担額_日額 標準負担額_日額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set標準負担額_日額(int 標準負担額_日額) {
        requireNonNull(標準負担額_日額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_日額"));
        entity.setNichigakuHyojunFutangaku(標準負担額_日額);
        return this;
    }

    /**
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
        return this;
    }

    /**
     * 点数_金額を設定します。
     *
     * @param 点数_金額 点数_金額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set点数_金額(int 点数_金額) {
        requireNonNull(点数_金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数_金額"));
        entity.setTensuKingaku(点数_金額);
        return this;
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set支給金額(int 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
        return this;
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenTen(増減点);
        return this;
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     * @return {@link ShokanShokujiHiyoBuilder}
     */
    public ShokanShokujiHiyoBuilder set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
        return this;
    }

    /**
     * {@link ShokanShokujiHiyo}のインスタンスを生成します。
     *
     * @return {@link ShokanShokujiHiyo}のインスタンス
     */
    public ShokanShokujiHiyo build() {
        return new ShokanShokujiHiyo(entity, id);
    }
}
