/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二次予防任意チェックリストエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT3102NijiYoboNiniCheckListEntityGenerator {

    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_受付年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_任意質問番号 = 1;
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final int DEFAULT_任意質問事項 = 1;

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
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setNiniShitsumonJiko(DEFAULT_任意質問事項);
        return entity;
    }
}
