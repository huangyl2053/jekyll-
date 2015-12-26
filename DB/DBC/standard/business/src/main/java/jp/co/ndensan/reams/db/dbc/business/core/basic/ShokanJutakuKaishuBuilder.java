/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link ShokanJutakuKaishu}の編集を行うビルダークラスです。
 */
public class ShokanJutakuKaishuBuilder {

    private final DbT3049ShokanJutakuKaishuEntity entity;
    private final ShokanJutakuKaishuIdentifier id;

    /**
     * {@link DbT3049ShokanJutakuKaishuEntity}より{@link ShokanJutakuKaishu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3049ShokanJutakuKaishuEntity}
     * @param id {@link ShokanJutakuKaishuIdentifier}
     *
     */
    ShokanJutakuKaishuBuilder(
            DbT3049ShokanJutakuKaishuEntity entity,
            ShokanJutakuKaishuIdentifier id
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
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
        return this;
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
        return this;
    }

    /**
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
        return this;
    }

    /**
     * 住宅改修着工年月日を設定します。
     *
     * @param 住宅改修着工年月日 住宅改修着工年月日
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set住宅改修着工年月日(FlexibleDate 住宅改修着工年月日) {
        requireNonNull(住宅改修着工年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修着工年月日"));
        entity.setJutakuKaishuChakkoYMD(住宅改修着工年月日);
        return this;
    }

    /**
     * 住宅改修事業者名を設定します。
     *
     * @param 住宅改修事業者名 住宅改修事業者名
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set住宅改修事業者名(RString 住宅改修事業者名) {
        requireNonNull(住宅改修事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修事業者名"));
        entity.setJutakuKaishuJigyoshaName(住宅改修事業者名);
        return this;
    }

    /**
     * 住宅改修住宅住所を設定します。
     *
     * @param 住宅改修住宅住所 住宅改修住宅住所
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set住宅改修住宅住所(RString 住宅改修住宅住所) {
        requireNonNull(住宅改修住宅住所, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修住宅住所"));
        entity.setJutakuKaishuJutakuAddress(住宅改修住宅住所);
        return this;
    }

    /**
     * 改修金額を設定します。
     *
     * @param 改修金額 改修金額
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set改修金額(int 改修金額) {
        requireNonNull(改修金額, UrSystemErrorMessages.値がnull.getReplacedMessage("改修金額"));
        entity.setKaishuKingaku(改修金額);
        return this;
    }

    /**
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set審査方法区分コード(RString 審査方法区分コード) {
        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
        return this;
    }

    /**
     * 住宅改修完成年月日を設定します。
     *
     * @param 住宅改修完成年月日 住宅改修完成年月日
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set住宅改修完成年月日(FlexibleDate 住宅改修完成年月日) {
        requireNonNull(住宅改修完成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修完成年月日"));
        entity.setJutakuKaishuKanseiYMD(住宅改修完成年月日);
        return this;
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     * @return {@link ShokanJutakuKaishuBuilder}
     */
    public ShokanJutakuKaishuBuilder set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
        return this;
    }

    /**
     * {@link ShokanJutakuKaishu}のインスタンスを生成します。
     *
     * @return {@link ShokanJutakuKaishu}のインスタンス
     */
    public ShokanJutakuKaishu build() {
        return new ShokanJutakuKaishu(entity, id);
    }
}
