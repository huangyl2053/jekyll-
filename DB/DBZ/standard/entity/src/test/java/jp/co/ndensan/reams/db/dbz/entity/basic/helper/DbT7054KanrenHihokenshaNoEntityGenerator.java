/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 関連被保険者番号エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7054KanrenHihokenshaNoEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_最新被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final HihokenshaNo DEFAULT_旧被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7054KanrenHihokenshaNoEntityGenerator() {
    }

    public static DbT7054KanrenHihokenshaNoEntity createDbT7054KanrenHihokenshaNoEntity() {
        DbT7054KanrenHihokenshaNoEntity entity = new DbT7054KanrenHihokenshaNoEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setSaishinHihokenshaNo(DEFAULT_最新被保険者番号);
        entity.setKyuuHihokenshaNo(DEFAULT_旧被保険者番号);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        return entity;
    }
}
