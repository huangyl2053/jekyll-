/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3117FukushiyoguShohinEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link ChiikiMitchakuServiceCode}の編集を行うビルダークラスです。
 */
public class FukushiyoguShohinBuilder {

    private final DbT3117FukushiyoguShohinEntity entity;
    private final FukushiyoguShohinIdentifier id;

    /**
     * {@link DbT3117FukushiyoguShohinEntity}より{@link ChiikiMitchakuServiceCode}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3117FukushiyoguShohinEntity}
     * @param id {@link FukushiyoguShohinIdentifier}
     *
     */
    FukushiyoguShohinBuilder(
            DbT3117FukushiyoguShohinEntity entity,
            FukushiyoguShohinIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
//    /**
//     * 商品番号を設定します。
//     *
//     * @param 商品番号 商品番号
//     * @return {@link FukushiyoguShohinBuilder}
//     */
//    public FukushiyoguShohinBuilder set商品番号(RString 商品番号) {
//        requireNonNull(商品番号, UrSystemErrorMessages.値がnull.getReplacedMessage("商品番号"));
//        entity.setShohinNo(商品番号);
//        return this;
//    }
//    /**
//     * 管理開始年月日を設定します。
//     *
//     * @param 管理開始年月日 管理開始年月日
//     * @return {@link FukushiyoguShohinBuilder}
//     */
//    public FukushiyoguShohinBuilder set管理開始年月日(FlexibleDate 管理開始年月日) {
//        requireNonNull(管理開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("管理開始年月日"));
//        entity.setKanriKaishiYMD(管理開始年月日);
//        return this;
//    }
    /**
     * 管理終了年月日を設定します。
     *
     * @param 管理終了年月日 管理終了年月日
     * @return {@link FukushiyoguShohinBuilder}
     */
    public FukushiyoguShohinBuilder set管理終了年月日(FlexibleDate 管理終了年月日) {
        requireNonNull(管理終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("管理終了年月日"));
        entity.setKanriShuryoYMD(管理終了年月日);
        return this;
    }

    /**
     * 商品名を設定します。
     *
     * @param 商品名 商品名
     * @return {@link FukushiyoguShohinBuilder}
     */
    public FukushiyoguShohinBuilder set商品名(RString 商品名) {
        requireNonNull(商品名, UrSystemErrorMessages.値がnull.getReplacedMessage("商品名"));
        entity.setShohinmei(商品名);
        return this;
    }

    /**
     * 製造事業者名を設定します。
     *
     * @param 製造事業者名 製造事業者名
     * @return {@link FukushiyoguShohinBuilder}
     */
    public FukushiyoguShohinBuilder set製造事業者名(RString 製造事業者名) {
        requireNonNull(製造事業者名, UrSystemErrorMessages.値がnull.getReplacedMessage("製造事業者名"));
        entity.setSeizoJigyoshamei(製造事業者名);
        return this;
    }

    /**
     * 品目コードを設定します。
     *
     * @param 品目コード 品目コード
     * @return {@link FukushiyoguShohinBuilder}
     */
    public FukushiyoguShohinBuilder set品目コード(RString 品目コード) {
        requireNonNull(品目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("品目コード"));
        entity.setHinmokuCode(品目コード);
        return this;
    }

    /**
     * {@link FukushiyoguShohin}のインスタンスを生成します。
     *
     * @return {@link FukushiyoguShohin}のインスタンス
     */
    public FukushiyoguShohin build() {
        return new FukushiyoguShohin(entity, id);
    }
}
