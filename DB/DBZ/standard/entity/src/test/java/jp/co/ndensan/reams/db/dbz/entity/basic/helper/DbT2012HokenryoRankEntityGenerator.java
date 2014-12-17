/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2012HokenryoRankEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料ランクエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8156 宮本 康
 */
public final class DbT2012HokenryoRankEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2000");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("000006");
    public static final RString DEFAULT_ランク区分 = new RString("01");
    public static final FlexibleYear DEFAULT_遡及年度 = new FlexibleYear("2001");

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
