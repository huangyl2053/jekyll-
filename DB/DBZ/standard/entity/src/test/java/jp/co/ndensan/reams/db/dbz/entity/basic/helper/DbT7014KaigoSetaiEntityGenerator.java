/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7014KaigoSetaiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護世帯エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7014KaigoSetaiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final FlexibleDate DEFAULT_世帯基準年月日 = new FlexibleDate("20140402");
    public static final int DEFAULT_連番 = 1;
    public static final RDateTime DEFAULT_処理日時 = RDateTime.of(2014, 9, 01, 10, 20, 30, 123);
    public static final ShikibetsuCode DEFAULT_世帯員識別コード = new ShikibetsuCode("000001234567890");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7014KaigoSetaiEntityGenerator() {
    }

    public static DbT7014KaigoSetaiEntity createDbT7014KaigoSetaiEntity() {
        DbT7014KaigoSetaiEntity entity = new DbT7014KaigoSetaiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setSetaiKijunYMD(DEFAULT_世帯基準年月日);
        entity.setRenban(DEFAULT_連番);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setSetaiInshikibetsuCode(DEFAULT_世帯員識別コード);
        return entity;
    }
}
