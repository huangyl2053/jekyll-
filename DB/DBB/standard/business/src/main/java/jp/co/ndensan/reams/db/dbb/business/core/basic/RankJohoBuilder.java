/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link RankJoho}の編集を行うビルダークラスです。
 */
public class RankJohoBuilder {

    private final DbT2011RankJohoEntity entity;
    private final RankJohoIdentifier id;

    /**
     * {@link DbT2011RankJohoEntity}より{@link RankJoho}の編集用Builderクラスを生成します。
     *
     * @param entity {@link DbT2011RankJohoEntity}
     * @param id {@link RankJohoIdentifier}
     *
     */
    RankJohoBuilder(
            DbT2011RankJohoEntity entity,
            RankJohoIdentifier id
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
     * @return {@link RankJohoBuilder}
     */
    public RankJohoBuilder set賦課年度(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度);
        return this;
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     * @return {@link RankJohoBuilder}
     */
    public RankJohoBuilder setランク区分(RankKubun ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankKubun(ランク区分);
        return this;
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
     * {@link RankJoho}のインスタンスを生成します。
     *
     * @return {@link RankJoho}のインスタンス
     */
    public RankJoho build() {
        return new RankJoho(entity, id);
    }
}
