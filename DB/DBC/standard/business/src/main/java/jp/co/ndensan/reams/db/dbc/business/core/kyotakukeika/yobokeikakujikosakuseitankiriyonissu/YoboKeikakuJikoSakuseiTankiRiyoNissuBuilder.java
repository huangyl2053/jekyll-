/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}の編集を行うビルダークラスです。
 */
public class YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder {

    private final DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity;
    private final YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id;

    /**
     * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}より{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}
     * @param id {@link YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier}
     *
     */
    YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder(
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity,
            YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * 前回迄利用日数を設定します。
     *
     * @param 前回迄利用日数 前回迄利用日数
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder}
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder set前回迄利用日数(Decimal 前回迄利用日数) {
        requireNonNull(前回迄利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("前回迄利用日数"));
        entity.setZenkaiRiyoNissu(前回迄利用日数);
        return this;
    }

    /**
     * 今回計画利用日数を設定します。
     *
     * @param 今回計画利用日数 今回計画利用日数
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder}
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder set今回計画利用日数(Decimal 今回計画利用日数) {
        requireNonNull(今回計画利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("今回計画利用日数"));
        entity.setKonkaiKeikakuRiyoNissu(今回計画利用日数);
        return this;
    }

    /**
     * {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}のインスタンスを生成します。
     *
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}のインスタンス
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissu build() {
        return new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity, id);
    }
}
