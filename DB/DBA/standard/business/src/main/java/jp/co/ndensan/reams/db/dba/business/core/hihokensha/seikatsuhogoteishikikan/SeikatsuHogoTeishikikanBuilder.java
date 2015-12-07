/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0528SeikatsuHogoTeishikikanEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * {@link SeikatsuHogoTeishikikan}の編集を行うビルダークラスです。
 */
public class SeikatsuHogoTeishikikanBuilder {

    private final UrT0528SeikatsuHogoTeishikikanEntity entity;
    private final SeikatsuHogoTeishikikanIdentifier id;

    /**
     * {@link UrT0528SeikatsuHogoTeishikikanEntity}より{@link SeikatsuHogoTeishikikan}の編集用Builderクラスを生成します。
     *
     * @param entity {@link UrT0528SeikatsuHogoTeishikikanEntity}
     * @param id {@link SeikatsuHogoTeishikikanIdentifier}
     *
     */
    SeikatsuHogoTeishikikanBuilder(
            UrT0528SeikatsuHogoTeishikikanEntity entity,
            SeikatsuHogoTeishikikanIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 受給停止終了日を設定します。
     *
     * @param 受給停止終了日 受給停止終了日
     * @return {@link SeikatsuHogoTeishikikanBuilder}
     */
    public SeikatsuHogoTeishikikanBuilder set受給停止終了日(FlexibleDate 受給停止終了日) {
        requireNonNull(受給停止終了日, UrSystemErrorMessages.値がnull.getReplacedMessage("受給停止終了日"));
        entity.setJukyuTeishiShuryoYMD(受給停止終了日);
        return this;
    }

    /**
     * {@link SeikatsuHogoTeishikikan}のインスタンスを生成します。
     *
     * @return {@link SeikatsuHogoTeishikikan}のインスタンス
     */
    public SeikatsuHogoTeishikikan build() {
        return new SeikatsuHogoTeishikikan(entity, id);
    }
}
