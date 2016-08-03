/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishoshaIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link SogoJigyoTaishosha}の編集を行うビルダークラスです。
 */
public class SogoJigyoTaishoshaBuilder {

    private final DbT3105SogoJigyoTaishoshaEntity entity;
    private final SogoJigyoTaishoshaIdentifier id;

    /**
     * {@link DbT3105SogoJigyoTaishoshaEntity}より{@link SogoJigyoTaishosha}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3105SogoJigyoTaishoshaEntity}
     * @param id {@link SogoJigyoTaishoshaIdentifier}
     *
     */
    SogoJigyoTaishoshaBuilder(
            DbT3105SogoJigyoTaishoshaEntity entity,
            SogoJigyoTaishoshaIdentifier id
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
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set履歴番号(int 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
        return this;
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
        return this;
    }

    /**
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
        return this;
    }

    /**
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     * @return {@link SogoJigyoTaishoshaBuilder}
     */
    public SogoJigyoTaishoshaBuilder set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
        return this;
    }

    /**
     * {@link SogoJigyoTaishosha}のインスタンスを生成します。
     *
     * @return {@link SogoJigyoTaishosha}のインスタンス
     */
    public SogoJigyoTaishosha build() {
        return new SogoJigyoTaishosha(entity, id);
    }
}
