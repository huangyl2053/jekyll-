/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseigokei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3012YoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link YoboKeikakuJikoSakuseiGokei}の編集を行うビルダークラスです。
 */
public class YoboKeikakuJikoSakuseiGokeiBuilder {

    private final DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity;
    private final YoboKeikakuJikoSakuseiGokeiIdentifier id;

    /**
     * {@link DbT3012YoboKeikakuJikoSakuseiGokeiEntity}より{@link YoboKeikakuJikoSakuseiGokei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3012YoboKeikakuJikoSakuseiGokeiEntity}
     * @param id {@link YoboKeikakuJikoSakuseiGokeiIdentifier}
     *
     */
    YoboKeikakuJikoSakuseiGokeiBuilder(
            DbT3012YoboKeikakuJikoSakuseiGokeiEntity entity,
            YoboKeikakuJikoSakuseiGokeiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }
    /**
     * 給付計画単位数を設定します。
     *
     * @param 給付計画単位数 給付計画単位数
     * @return {@link YoboKeikakuJikoSakuseiGokeiBuilder}
     */
    public YoboKeikakuJikoSakuseiGokeiBuilder set給付計画単位数(Decimal 給付計画単位数) {
        requireNonNull(給付計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数"));
        entity.setKeikakuTaniSu(給付計画単位数);
        return this;
    }

    /**
     * {@link YoboKeikakuJikoSakuseiGokei}のインスタンスを生成します。
     *
     * @return {@link YoboKeikakuJikoSakuseiGokei}のインスタンス
     */
    public YoboKeikakuJikoSakuseiGokei build() {
        return new YoboKeikakuJikoSakuseiGokei(entity, id);
    }
}
