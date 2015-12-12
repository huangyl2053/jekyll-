/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanTokuteiShinryoTokubetsuRyoyo}の編集を行うビルダークラスです。
 */
public class ShokanTokuteiShinryoTokubetsuRyoyoBuilder {

    private final DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity;
    private final ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id;

    /**
     * {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}より{@link ShokanTokuteiShinryoTokubetsuRyoyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity}
     * @param id {@link ShokanTokuteiShinryoTokubetsuRyoyoIdentifier}
     *
     */
    ShokanTokuteiShinryoTokubetsuRyoyoBuilder(
            DbT3042ShokanTokuteiShinryoTokubetsuRyoyoEntity entity,
            ShokanTokuteiShinryoTokubetsuRyoyoIdentifier id
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
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 傷病名を設定します。
     *
     * @param 傷病名 傷病名
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set傷病名(RString 傷病名) {
        requireNonNull(傷病名, UrSystemErrorMessages.値がnull.getReplacedMessage("傷病名"));
        entity.setShobyoName(傷病名);
        return this;
    }

    /**
     * 識別番号を設定します。
     *
     * @param 識別番号 識別番号
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set識別番号(RString 識別番号) {
        requireNonNull(識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("識別番号"));
        entity.setShikibetsuNo(識別番号);
        return this;
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set単位数(Decimal 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
        return this;
    }

    /**
     * 回数を設定します。
     *
     * @param 回数 回数
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set回数(Decimal 回数) {
        requireNonNull(回数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数"));
        entity.setKaisu(回数);
        return this;
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
        return this;
    }

    /**
     * 合計単位数を設定します。
     *
     * @param 合計単位数 合計単位数
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set合計単位数(int 合計単位数) {
        requireNonNull(合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("合計単位数"));
        entity.setTotalTanisu(合計単位数);
        return this;
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyoBuilder}
     */
    public ShokanTokuteiShinryoTokubetsuRyoyoBuilder set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
        return this;
    }

    /**
     * {@link ShokanTokuteiShinryoTokubetsuRyoyo}のインスタンスを生成します。
     *
     * @return {@link ShokanTokuteiShinryoTokubetsuRyoyo}のインスタンス
     */
    public ShokanTokuteiShinryoTokubetsuRyoyo build() {
        return new ShokanTokuteiShinryoTokubetsuRyoyo(entity, id);
    }
}
