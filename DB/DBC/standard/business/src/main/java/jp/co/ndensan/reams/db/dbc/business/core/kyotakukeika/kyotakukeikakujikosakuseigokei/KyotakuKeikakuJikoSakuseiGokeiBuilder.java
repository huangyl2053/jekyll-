/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link KyotakuKeikakuJikoSakuseiGokei}の編集を行うビルダークラスです。
 */
public class KyotakuKeikakuJikoSakuseiGokeiBuilder {

    private final DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity;
    private final KyotakuKeikakuJikoSakuseiGokeiIdentifier id;

    /**
     * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}より{@link KyotakuKeikakuJikoSakuseiGokei}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiGokeiIdentifier}
     *
     */
    KyotakuKeikakuJikoSakuseiGokeiBuilder(
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity,
            KyotakuKeikakuJikoSakuseiGokeiIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 給付計画単位数を設定します。
     *
     * @param 給付計画単位数 給付計画単位数
     * @return {@link KyotakuKeikakuJikoSakuseiGokeiBuilder}
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder set給付計画単位数(Decimal 給付計画単位数) {
        requireNonNull(給付計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("給付計画単位数"));
        entity.setKyufuKeikakuTaniSu(給付計画単位数);
        return this;
    }

    /**
     * {@link KyotakuKeikakuJikoSakuseiGokei}のインスタンスを生成します。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiGokei}のインスタンス
     */
    public KyotakuKeikakuJikoSakuseiGokei build() {
        return new KyotakuKeikakuJikoSakuseiGokei(entity, id);
    }
}
