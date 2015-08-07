/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * {@link ShokanJuryoininMeisai}の編集を行うビルダークラスです。
 */
public class ShokanJuryoininMeisaiBuilder {

    private final DbT3037ShokanJuryoininMeisaiEntity entity;
    private final ShokanJuryoininMeisaiIdentifier id;

    /**
     * {@link DbT3037ShokanJuryoininMeisaiEntity}より{@link ShokanJuryoininMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3037ShokanJuryoininMeisaiEntity}
     * @param id {@link ShokanJuryoininMeisaiIdentifier}
     *
     */
    ShokanJuryoininMeisaiBuilder(
            DbT3037ShokanJuryoininMeisaiEntity entity,
            ShokanJuryoininMeisaiIdentifier id
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
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 契約番号を設定します。
     *
     * @param 契約番号 契約番号
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder set契約番号(RString 契約番号) {
        requireNonNull(契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約番号"));
        entity.setKeiyakuNo(契約番号);
        return this;
    }

    /**
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     * @return {@link ShokanJuryoininMeisaiBuilder}
     */
    public ShokanJuryoininMeisaiBuilder set支払金額(Decimal 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShiharaiKingaku(支払金額);
        return this;
    }

    /**
     * {@link ShokanJuryoininMeisai}のインスタンスを生成します。
     *
     * @return {@link ShokanJuryoininMeisai}のインスタンス
     */
    public ShokanJuryoininMeisai build() {
        return new ShokanJuryoininMeisai(entity, id);
    }
}
