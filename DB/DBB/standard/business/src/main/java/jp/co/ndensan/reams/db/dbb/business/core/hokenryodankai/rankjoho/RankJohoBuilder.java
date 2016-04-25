/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.rankjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRank;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRankIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * {@link RankJoho}の編集を行うビルダークラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class RankJohoBuilder {

    private final DbT2011RankJohoEntity entity;
    private final RankJohoIdentifier id;
    private final Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank;

    /**
     * {@link DbT2011RankJohoEntity}より{@link RankJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2011RankJohoEntity}
     * @param id {@link RankJohoIdentifier}
     * @param hokenryoRank {@link Models<HokenryoRankIdentifier, HokenryoRank>}
     */
    RankJohoBuilder(
            DbT2011RankJohoEntity entity,
            RankJohoIdentifier id,
            Models<HokenryoRankIdentifier, HokenryoRank> hokenryoRank
    ) {
        this.entity = entity.clone();
        this.id = id;
        this.hokenryoRank = hokenryoRank;

    }

    /**
     * ランク名称を設定します。
     *
     * @param ランク名称 ランク名称
     * @return {@link RankJohoBuilder}
     */
    public RankJohoBuilder setランク名称(RString ランク名称) {
        requireNonNull(ランク名称, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク名称"));
        entity.setRankName(ランク名称);
        return this;
    }

    /**
     * ランク情報のキー情報について判定します。<br>
     * ランク情報に関連できる保険料ランク情報である場合、下記の処理に遷移します。<br>
     * キーが一致する場合は保険料ランク情報リストにランク情報{@link RankJoho}をセットします。<br>
     * キーが一致しない場合、新たに追加します。<br>
     *
     * @param 保険料ランク情報 {@link HokenryoRank}
     * @return {@link RankJohoBuilder}
     * @throws IllegalStateException キーが一致しない場合
     */
    public RankJohoBuilder setKibetsu(HokenryoRank 保険料ランク情報) {
        if (hasSameIdentifier(保険料ランク情報.toEntity())) {
            hokenryoRank.add(保険料ランク情報);
            return this;
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    private boolean hasSameIdentifier(DbT2012HokenryoRankEntity 保険料ランク情報) {

        return (id.get賦課年度().equals(保険料ランク情報.getFukaNendo())
                && id.getランク区分().equals(保険料ランク情報.getRankKubun()));
    }

    /**
     * {@link RankJoho}のインスタンスを生成します。
     *
     * @return {@link RankJoho}のインスタンス
     */
    public RankJoho build() {
        return new RankJoho(entity, id, hokenryoRank);
    }
}
