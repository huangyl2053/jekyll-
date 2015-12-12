/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.basic.helper;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 連帯納付義務者エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2009RentaiGimushaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("00001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2009RentaiGimushaEntityGenerator() {
    }

    public static DbT2009RentaiGimushaEntity createDbT2009RentaiGimushaEntity() {
        DbT2009RentaiGimushaEntity entity = new DbT2009RentaiGimushaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShikibetuCode(DEFAULT_識別コード);
        entity.setStartYMD(DEFAULT_開始年月日);
        entity.setEndYMD(DEFAULT_終了年月日);
        return entity;
    }
}
