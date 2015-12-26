/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 賦課検索Aliveエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbV7902FukaSearchEntityGenerator {

    public static final FlexibleYear DEFAULT_調定年度 = new FlexibleYear("1990");
    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("1990");
    public static final TsuchishoNo DEFAULT_通知書番号 = new TsuchishoNo("0000000003");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("0000000001");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_被保台帳被保険者番号 = new HihokenshaNo("0000000001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbV7902FukaSearchEntityGenerator() {
    }

    public static DbV7902FukaSearchEntity createDbV7902FukaSearchEntity() {
        DbV7902FukaSearchEntity entity = new DbV7902FukaSearchEntity();
        entity.setChoteiNendo(DEFAULT_調定年度);
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setTsuchishoNo(DEFAULT_通知書番号);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihodaichoHihokenshaNo(DEFAULT_被保台帳被保険者番号);
        return entity;
    }
}
