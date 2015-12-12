/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * {@link HokenryoRank}の編集を行うビルダークラスです。
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

//TODO Key項目のsetterメソッドは削除してください。
//TODO 一緒に置換される値のまとまりで不変なクラスを作成し、その単位でsetterを作る様に見直してください。
    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     * @return {@link HokenryoRankBuilder}
     */
    public HokenryoRankBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     * @return {@link HokenryoRankBuilder}
     */
    public HokenryoRankBuilder set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
        return this;
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     * @return {@link HokenryoRankBuilder}
     */
    public HokenryoRankBuilder setランク区分(RankKubun ランク区分) {
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
