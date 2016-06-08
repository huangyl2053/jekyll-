/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link HokenryoRank}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoRankBuilder {

    private final DbT2012HokenryoRankEntity entity;
    private final HokenryoRankIdentifier id;

    /**
     * {@link DbT2012HokenryoRankEntity}より{@link HokenryoRank}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2012HokenryoRankEntity}
     * @param id {@link HokenryoRankIdentifier}
     *
     */
    HokenryoRankBuilder(
            DbT2012HokenryoRankEntity entity,
            HokenryoRankIdentifier id
    ) {
        this.entity = entity.clone();
        this.id = id;

    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     * @return {@link HokenryoRankBuilder}
     */
    public HokenryoRankBuilder setランク区分(RString ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankKubun(ランク区分);
        return this;
    }

    /**
     * 遡及年度を設定します。
     *
     * @param 遡及年度 遡及年度
     * @return {@link HokenryoRankBuilder}
     */
    public HokenryoRankBuilder set遡及年度(FlexibleYear 遡及年度) {
        requireNonNull(遡及年度, UrSystemErrorMessages.値がnull.getReplacedMessage("遡及年度"));
        entity.setSokyuNendo(遡及年度);
        return this;
    }

    /**
     * {@link HokenryoRank}のインスタンスを生成します。
     *
     * @return {@link HokenryoRank}のインスタンス
     */
    public HokenryoRank build() {
        return new HokenryoRank(entity, id);
    }
}
