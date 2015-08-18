/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyokaisoHokenryoDankai}の編集を行うビルダークラスです。
 */
public class KyokaisoHokenryoDankaiBuilder {

    private final DbT1007KyokaisoHokenryoDankaiEntity entity;
    private final KyokaisoHokenryoDankaiIdentifier id;

    /**
     * {@link DbT1007KyokaisoHokenryoDankaiEntity}より{@link KyokaisoHokenryoDankai}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT1007KyokaisoHokenryoDankaiEntity}
     * @param id {@link KyokaisoHokenryoDankaiIdentifier}
     *
     */
    KyokaisoHokenryoDankaiBuilder(
            DbT1007KyokaisoHokenryoDankaiEntity entity,
            KyokaisoHokenryoDankaiIdentifier id
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
     * @return {@link KyokaisoHokenryoDankaiBuilder}
     */
    public KyokaisoHokenryoDankaiBuilder set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
        return this;
    }

    /**
     * 履歴番号を設定します。
     *
     * @param 履歴番号 履歴番号
     * @return {@link KyokaisoHokenryoDankaiBuilder}
     */
    public KyokaisoHokenryoDankaiBuilder set履歴番号(Decimal 履歴番号) {
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        entity.setRirekiNo(履歴番号);
        return this;
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     * @return {@link KyokaisoHokenryoDankaiBuilder}
     */
    public KyokaisoHokenryoDankaiBuilder set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
        return this;
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     * @return {@link KyokaisoHokenryoDankaiBuilder}
     */
    public KyokaisoHokenryoDankaiBuilder set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
        return this;
    }

    /**
     * 保険料納付減額後保険料段階を設定します。
     *
     * @param 保険料納付減額後保険料段階 保険料納付減額後保険料段階
     * @return {@link KyokaisoHokenryoDankaiBuilder}
     */
    public KyokaisoHokenryoDankaiBuilder set保険料納付減額後保険料段階(RString 保険料納付減額後保険料段階) {
        requireNonNull(保険料納付減額後保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料納付減額後保険料段階"));
        entity.setGengakuGoHokenryoDankai(保険料納付減額後保険料段階);
        return this;
    }

    /**
     * {@link KyokaisoHokenryoDankai}のインスタンスを生成します。
     *
     * @return {@link KyokaisoHokenryoDankai}のインスタンス
     */
    public KyokaisoHokenryoDankai build() {
        return new KyokaisoHokenryoDankai(entity, id);
    }
}
