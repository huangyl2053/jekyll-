/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ランク情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8156 宮本 康
 */
public final class DbT2011RankJohoEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2000");
    public static final RankKubun DEFAULT_ランク区分 = new RankKubun(new RString("01"));
    public static final RString DEFAULT_ランク名称 = new RString("ランク電算市");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2011RankJohoEntityGenerator() {
    }

    public static DbT2011RankJohoEntity createDbT2011RankJohoEntity() {
        DbT2011RankJohoEntity entity = new DbT2011RankJohoEntity();
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setRankKubun(DEFAULT_ランク区分);
        entity.setRankName(DEFAULT_ランク名称);
        return entity;
    }
}
