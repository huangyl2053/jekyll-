/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 二次予防任意チェックリストエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3102NijiYoboNiniCheckListEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_任意質問番号 = new Decimal(0);
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_任意質問事項 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3102NijiYoboNiniCheckListEntityGenerator() {
    }

    public static DbT3102NijiYoboNiniCheckListEntity createDbT3102NijiYoboNiniCheckListEntity() {
        DbT3102NijiYoboNiniCheckListEntity entity = new DbT3102NijiYoboNiniCheckListEntity();
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setUketsukeYMD(DEFAULT_受付年月日);
        entity.setNiniShitsumonNo(DEFAULT_任意質問番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setNiniShitsumonJiko(DEFAULT_任意質問事項);
        return entity;
    }
}
