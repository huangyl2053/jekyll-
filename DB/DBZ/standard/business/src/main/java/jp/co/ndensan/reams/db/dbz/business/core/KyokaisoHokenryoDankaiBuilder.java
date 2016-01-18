/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
