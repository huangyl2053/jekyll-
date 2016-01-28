/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanTokuteiShinryohi}の編集を行うビルダークラスです。
 */
public class ShokanTokuteiShinryohiBuilder {

    private final DbT3041ShokanTokuteiShinryohiEntity entity;
    private final ShokanTokuteiShinryohiIdentifier id;

    /**
     * {@link DbT3041ShokanTokuteiShinryohiEntity}より{@link ShokanTokuteiShinryohi}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3041ShokanTokuteiShinryohiEntity}
     * @param id {@link ShokanTokuteiShinryohiIdentifier}
     *
     */
    ShokanTokuteiShinryohiBuilder(
            DbT3041ShokanTokuteiShinryohiEntity entity,
            ShokanTokuteiShinryohiIdentifier id
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
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 傷病名を設定します。
     *
     * @param 傷病名 傷病名
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set傷病名(RString 傷病名) {
        requireNonNull(傷病名, UrSystemErrorMessages.値がnull.getReplacedMessage("傷病名"));
        entity.setShobyoName(傷病名);
        return this;
    }

    /**
     * 指導管理料等単位数を設定します。
     *
     * @param 指導管理料等単位数 指導管理料等単位数
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set指導管理料等単位数(int 指導管理料等単位数) {
        requireNonNull(指導管理料等単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("指導管理料等単位数"));
        entity.setShidoKanriryoTanisu(指導管理料等単位数);
        return this;
    }

    /**
     * 単純エックス線単位数を設定します。
     *
     * @param 単純エックス線単位数 単純エックス線単位数
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set単純エックス線単位数(int 単純エックス線単位数) {
        requireNonNull(単純エックス線単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単純エックス線単位数"));
        entity.setTanjunXsenTanisu(単純エックス線単位数);
        return this;
    }

    /**
     * リハビリテーション単位数を設定します。
     *
     * @param リハビリテーション単位数 リハビリテーション単位数
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder setリハビリテーション単位数(int リハビリテーション単位数) {
        requireNonNull(リハビリテーション単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("リハビリテーション単位数"));
        entity.setRehabilitationTanisu(リハビリテーション単位数);
        return this;
    }

    /**
     * 精神科専門療法単位数を設定します。
     *
     * @param 精神科専門療法単位数 精神科専門療法単位数
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set精神科専門療法単位数(int 精神科専門療法単位数) {
        requireNonNull(精神科専門療法単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("精神科専門療法単位数"));
        entity.setSeishinkaSemmonRyoyohouTanisu(精神科専門療法単位数);
        return this;
    }

    /**
     * 合計単位数を設定します。
     *
     * @param 合計単位数 合計単位数
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set合計単位数(int 合計単位数) {
        requireNonNull(合計単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("合計単位数"));
        entity.setTotalTanisu(合計単位数);
        return this;
    }

    /**
     * 摘要１を設定します。
     *
     * @param 摘要１ 摘要１
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１(RString 摘要１) {
        requireNonNull(摘要１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１"));
        entity.setTekiyo1(摘要１);
        return this;
    }

    /**
     * 摘要２を設定します。
     *
     * @param 摘要２ 摘要２
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要２(RString 摘要２) {
        requireNonNull(摘要２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２"));
        entity.setTekiyo2(摘要２);
        return this;
    }

    /**
     * 摘要３を設定します。
     *
     * @param 摘要３ 摘要３
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要３(RString 摘要３) {
        requireNonNull(摘要３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要３"));
        entity.setTekiyo3(摘要３);
        return this;
    }

    /**
     * 摘要４を設定します。
     *
     * @param 摘要４ 摘要４
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要４(RString 摘要４) {
        requireNonNull(摘要４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要４"));
        entity.setTekiyo4(摘要４);
        return this;
    }

    /**
     * 摘要５を設定します。
     *
     * @param 摘要５ 摘要５
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要５(RString 摘要５) {
        requireNonNull(摘要５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要５"));
        entity.setTekiyo5(摘要５);
        return this;
    }

    /**
     * 摘要６を設定します。
     *
     * @param 摘要６ 摘要６
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要６(RString 摘要６) {
        requireNonNull(摘要６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要６"));
        entity.setTekiyo6(摘要６);
        return this;
    }

    /**
     * 摘要７を設定します。
     *
     * @param 摘要７ 摘要７
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要７(RString 摘要７) {
        requireNonNull(摘要７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要７"));
        entity.setTekiyo7(摘要７);
        return this;
    }

    /**
     * 摘要８を設定します。
     *
     * @param 摘要８ 摘要８
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要８(RString 摘要８) {
        requireNonNull(摘要８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要８"));
        entity.setTekiyo8(摘要８);
        return this;
    }

    /**
     * 摘要９を設定します。
     *
     * @param 摘要９ 摘要９
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要９(RString 摘要９) {
        requireNonNull(摘要９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要９"));
        entity.setTekiyo9(摘要９);
        return this;
    }

    /**
     * 摘要１０を設定します。
     *
     * @param 摘要１０ 摘要１０
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１０(RString 摘要１０) {
        requireNonNull(摘要１０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１０"));
        entity.setTekiyo10(摘要１０);
        return this;
    }

    /**
     * 摘要１１を設定します。
     *
     * @param 摘要１１ 摘要１１
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１１(RString 摘要１１) {
        requireNonNull(摘要１１, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１１"));
        entity.setTekiyo11(摘要１１);
        return this;
    }

    /**
     * 摘要１２を設定します。
     *
     * @param 摘要１２ 摘要１２
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１２(RString 摘要１２) {
        requireNonNull(摘要１２, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１２"));
        entity.setTekiyo12(摘要１２);
        return this;
    }

    /**
     * 摘要１３を設定します。
     *
     * @param 摘要１３ 摘要１３
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１３(RString 摘要１３) {
        requireNonNull(摘要１３, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１３"));
        entity.setTekiyo13(摘要１３);
        return this;
    }

    /**
     * 摘要１４を設定します。
     *
     * @param 摘要１４ 摘要１４
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１４(RString 摘要１４) {
        requireNonNull(摘要１４, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１４"));
        entity.setTekiyo14(摘要１４);
        return this;
    }

    /**
     * 摘要１５を設定します。
     *
     * @param 摘要１５ 摘要１５
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１５(RString 摘要１５) {
        requireNonNull(摘要１５, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１５"));
        entity.setTekiyo15(摘要１５);
        return this;
    }

    /**
     * 摘要１６を設定します。
     *
     * @param 摘要１６ 摘要１６
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１６(RString 摘要１６) {
        requireNonNull(摘要１６, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１６"));
        entity.setTekiyo16(摘要１６);
        return this;
    }

    /**
     * 摘要１７を設定します。
     *
     * @param 摘要１７ 摘要１７
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１７(RString 摘要１７) {
        requireNonNull(摘要１７, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１７"));
        entity.setTekiyo17(摘要１７);
        return this;
    }

    /**
     * 摘要１８を設定します。
     *
     * @param 摘要１８ 摘要１８
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１８(RString 摘要１８) {
        requireNonNull(摘要１８, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１８"));
        entity.setTekiyo18(摘要１８);
        return this;
    }

    /**
     * 摘要１９を設定します。
     *
     * @param 摘要１９ 摘要１９
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要１９(RString 摘要１９) {
        requireNonNull(摘要１９, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要１９"));
        entity.setTekiyo19(摘要１９);
        return this;
    }

    /**
     * 摘要２０を設定します。
     *
     * @param 摘要２０ 摘要２０
     * @return {@link ShokanTokuteiShinryohiBuilder}
     */
    public ShokanTokuteiShinryohiBuilder set摘要２０(RString 摘要２０) {
        requireNonNull(摘要２０, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要２０"));
        entity.setTekiyo20(摘要２０);
        return this;
    }

    /**
     * {@link ShokanTokuteiShinryohi}のインスタンスを生成します。
     *
     * @return {@link ShokanTokuteiShinryohi}のインスタンス
     */
    public ShokanTokuteiShinryohi build() {
        return new ShokanTokuteiShinryohi(entity, id);
    }
}
