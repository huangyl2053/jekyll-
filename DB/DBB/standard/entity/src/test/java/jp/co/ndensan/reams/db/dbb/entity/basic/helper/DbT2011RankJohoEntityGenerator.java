/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2011RankJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ランク情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2011RankJohoEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final RankKubun DEFAULT_ランク区分 = new RankKubun(new RString("Data"));
    public static final RString DEFAULT_ランク名称 = new RString("Data");

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
