/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料ランクエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2012HokenryoRankEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("209007");
    public static final RankKubun DEFAULT_ランク区分 = new RankKubun(new RString("Data"));
    public static final FlexibleYear DEFAULT_遡及年度 = new FlexibleYear("1990");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2012HokenryoRankEntityGenerator() {
    }

    public static DbT2012HokenryoRankEntity createDbT2012HokenryoRankEntity() {
        DbT2012HokenryoRankEntity entity = new DbT2012HokenryoRankEntity();
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setRankKubun(DEFAULT_ランク区分);
        entity.setSokyuNendo(DEFAULT_遡及年度);
        return entity;
    }
}
