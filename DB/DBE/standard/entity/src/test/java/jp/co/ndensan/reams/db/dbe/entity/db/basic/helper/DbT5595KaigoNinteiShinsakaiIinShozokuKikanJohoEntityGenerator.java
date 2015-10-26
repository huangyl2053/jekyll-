/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員所属機関情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityGenerator {

    public static final RString DEFAULT_介護認定審査会委員コード = new RString("1");
    public static final int DEFAULT_連番 = 1;
    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo("123456");
    public static final RString DEFAULT_主治医医療機関コード = new RString("1");
    public static final RString DEFAULT_主治医コード = new RString("1");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1");
    public static final RString DEFAULT_認定調査員コード = new RString("1");
    public static final RString DEFAULT_その他機関コード = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntityGenerator() {
    }

    public static DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity createDbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity() {
        DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity = new DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity();
        entity.setShinsakaiIinCode(DEFAULT_介護認定審査会委員コード);
        entity.setRemban(DEFAULT_連番);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShujiiIryokikanCode(DEFAULT_主治医医療機関コード);
        entity.setShujiiCode(DEFAULT_主治医コード);
        entity.setNinteichosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainNo(DEFAULT_認定調査員コード);
        entity.setSonotaKikanCode(DEFAULT_その他機関コード);
        return entity;
    }
}
