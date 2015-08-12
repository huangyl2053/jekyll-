/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link NijiYoboJigyoTaishosha}の編集を行うビルダークラスです。
 */
public class NijiYoboJigyoTaishoshaBuilder {

    private final DbT3100NijiYoboJigyoTaishoshaEntity entity;
    private final NijiYoboJigyoTaishoshaIdentifier id;

    /**
     * {@link DbT3100NijiYoboJigyoTaishoshaEntity}より{@link NijiYoboJigyoTaishosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3100NijiYoboJigyoTaishoshaEntity}
     * @param id {@link NijiYoboJigyoTaishoshaIdentifier}
     *
     */
    NijiYoboJigyoTaishoshaBuilder(
            DbT3100NijiYoboJigyoTaishoshaEntity entity,
            NijiYoboJigyoTaishoshaIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
        return this;
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link NijiYoboJigyoTaishoshaBuilder}
     */
    public NijiYoboJigyoTaishoshaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * {@link NijiYoboJigyoTaishosha}のインスタンスを生成します。
     *
     * @return {@link NijiYoboJigyoTaishosha}のインスタンス
     */
    public NijiYoboJigyoTaishosha build() {
        return new NijiYoboJigyoTaishosha(entity, id);
    }
}
