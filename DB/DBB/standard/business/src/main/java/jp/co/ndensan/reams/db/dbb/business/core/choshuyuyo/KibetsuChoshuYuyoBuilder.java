/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link KibetsuChoshuYuyo}の編集を行うビルダークラスです。
 */
public class KibetsuChoshuYuyoBuilder {

    private final DbT2007KibetsuChoshuYuyoEntity entity;
    private final KibetsuChoshuYuyoIdentifier id;

    /**
     * {@link DbT2007KibetsuChoshuYuyoEntity}より{@link KibetsuChoshuYuyo}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2007KibetsuChoshuYuyoEntity}
     * @param id {@link KibetsuChoshuYuyoIdentifier}
     *
     */
    KibetsuChoshuYuyoBuilder(
            DbT2007KibetsuChoshuYuyoEntity entity,
            KibetsuChoshuYuyoIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 徴収猶予開始日を設定します。
     *
     * @param 徴収猶予開始日 徴収猶予開始日
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set徴収猶予開始日(FlexibleDate 徴収猶予開始日) {
        requireNonNull(徴収猶予開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予開始日"));
        entity.setYuyoStartYMD(徴収猶予開始日);
        return this;
    }

    /**
     * 徴収猶予終了日を設定します。
     *
     * @param 徴収猶予終了日 徴収猶予終了日
     * @return {@link KibetsuChoshuYuyoBuilder}
     */
    public KibetsuChoshuYuyoBuilder set徴収猶予終了日(FlexibleDate 徴収猶予終了日) {
        requireNonNull(徴収猶予終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収猶予終了日"));
        entity.setYuyoEndYMD(徴収猶予終了日);
        return this;
    }

    /**
     * {@link KibetsuChoshuYuyo}のインスタンスを生成します。
     *
     * @return {@link KibetsuChoshuYuyo}のインスタンス
     */
    public KibetsuChoshuYuyo build() {
        return new KibetsuChoshuYuyo(entity, id);
    }
}
