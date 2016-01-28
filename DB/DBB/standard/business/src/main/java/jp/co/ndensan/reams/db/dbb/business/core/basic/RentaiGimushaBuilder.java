/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link RentaiGimusha}の編集を行うビルダークラスです。
 */
public class RentaiGimushaBuilder {

    private final DbT2009RentaiGimushaEntity entity;
    private final RentaiGimushaIdentifier id;

    /**
     * {@link DbT2009RentaiGimushaEntity}より{@link RentaiGimusha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2009RentaiGimushaEntity}
     * @param id {@link RentaiGimushaIdentifier}
     *
     */
    RentaiGimushaBuilder(
            DbT2009RentaiGimushaEntity entity,
            RentaiGimushaIdentifier id
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
     * @return {@link RentaiGimushaBuilder}
     */
    public RentaiGimushaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link RentaiGimushaBuilder}
     */
    public RentaiGimushaBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link RentaiGimushaBuilder}
     */
    public RentaiGimushaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetuCode(識別コード);
        return this;
    }

    /**
     * 開始年月日を設定します。
     *
     * @param 開始年月日 開始年月日
     * @return {@link RentaiGimushaBuilder}
     */
    public RentaiGimushaBuilder set開始年月日(FlexibleDate 開始年月日) {
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        entity.setStartYMD(開始年月日);
        return this;
    }

    /**
     * 終了年月日を設定します。
     *
     * @param 終了年月日 終了年月日
     * @return {@link RentaiGimushaBuilder}
     */
    public RentaiGimushaBuilder set終了年月日(FlexibleDate 終了年月日) {
        requireNonNull(終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月日"));
        entity.setEndYMD(終了年月日);
        return this;
    }

    /**
     * {@link RentaiGimusha}のインスタンスを生成します。
     *
     * @return {@link RentaiGimusha}のインスタンス
     */
    public RentaiGimusha build() {
        return new RentaiGimusha(entity, id);
    }
}
