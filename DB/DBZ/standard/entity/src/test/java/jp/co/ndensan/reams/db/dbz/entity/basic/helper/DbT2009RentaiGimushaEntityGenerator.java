/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2009RentaiGimushaEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連帯納付義務者エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2009RentaiGimushaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final int DEFAULT_履歴番号 = 1;
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final FlexibleDate DEFAULT_開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_終了年月日 = new FlexibleDate("20140402");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2009RentaiGimushaEntityGenerator() {
    }

    public static DbT2009RentaiGimushaEntity createDbT2009RentaiGimushaEntity() {
        DbT2009RentaiGimushaEntity entity = new DbT2009RentaiGimushaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setShikibetuCode(DEFAULT_識別コード);
        entity.setStartYMD(DEFAULT_開始年月日);
        entity.setEndYMD(DEFAULT_終了年月日);
        return entity;
    }
}
