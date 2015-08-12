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
 * {@link DaisanshaKoiKyushoMeisai}の編集を行うビルダークラスです。
 */
public class DaisanshaKoiKyushoMeisaiBuilder {

    private final DbT3083DaisanshaKoiKyushoMeisaiEntity entity;
    private final DaisanshaKoiKyushoMeisaiIdentifier id;

    /**
     * {@link DbT3083DaisanshaKoiKyushoMeisaiEntity}より{@link DaisanshaKoiKyushoMeisai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3083DaisanshaKoiKyushoMeisaiEntity}
     * @param id {@link DaisanshaKoiKyushoMeisaiIdentifier}
     *
     */
    DaisanshaKoiKyushoMeisaiBuilder(
            DbT3083DaisanshaKoiKyushoMeisaiEntity entity,
            DaisanshaKoiKyushoMeisaiIdentifier id
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
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 第三者行為届出管理番号を設定します。
     *
     * @param 第三者行為届出管理番号 第三者行為届出管理番号
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder set第三者行為届出管理番号(RString 第三者行為届出管理番号) {
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        entity.setTodokedeKanriNo(第三者行為届出管理番号);
        return this;
    }

    /**
     * 第三者行為求償請求番号を設定します。
     *
     * @param 第三者行為求償請求番号 第三者行為求償請求番号
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder set第三者行為求償請求番号(RString 第三者行為求償請求番号) {
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        entity.setKyushoSeikyuNo(第三者行為求償請求番号);
        return this;
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
        return this;
    }

    /**
     * サービス提供事業者番号を設定します。
     *
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder setサービス提供事業者番号(JigyoshaNo サービス提供事業者番号) {
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        return this;
    }

    /**
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 給付額を設定します。
     *
     * @param 給付額 給付額
     * @return {@link DaisanshaKoiKyushoMeisaiBuilder}
     */
    public DaisanshaKoiKyushoMeisaiBuilder set給付額(Decimal 給付額) {
        requireNonNull(給付額, UrSystemErrorMessages.値がnull.getReplacedMessage("給付額"));
        entity.setKyufuGaku(給付額);
        return this;
    }

    /**
     * {@link DaisanshaKoiKyushoMeisai}のインスタンスを生成します。
     *
     * @return {@link DaisanshaKoiKyushoMeisai}のインスタンス
     */
    public DaisanshaKoiKyushoMeisai build() {
        return new DaisanshaKoiKyushoMeisai(entity, id);
    }
}
