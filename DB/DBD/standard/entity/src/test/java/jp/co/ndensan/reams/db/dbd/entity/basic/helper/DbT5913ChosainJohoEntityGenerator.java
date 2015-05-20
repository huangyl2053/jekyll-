/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8223 朴義一
 */
public final class DbT5913ChosainJohoEntityGenerator {

    public static final ShichosonCode DEFAULT_市町村コード = new ShichosonCode("12345");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1234567890");
    public static final RString DEFAULT_認定調査員コード = new RString("12345678");
    public static final RString DEFAULT_調査員氏名 = new RString("事業者名称");
    public static final RString DEFAULT_調査員氏名カナ = new RString("事業者名称カナ");
    public static final RString DEFAULT_性別 = new RString("1");
    public static final RString DEFAULT_調査員資格 = new RString("調査員資格");
    public static final RString DEFAULT_地区コード = new RString("地区コード");
    public static final int DEFAULT_調査可能人数月 = 1;
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("住所");
    public static final TelNo DEFAULT_電話番号 = new TelNo("電話番号");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("FAX番号");
    public static final boolean DEFAULT_状況フラグ = new Boolean(true);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5913ChosainJohoEntityGenerator() {
    }

    public static DbT5913ChosainJohoEntity createDbT5913ChosainJohoEntity() {
        DbT5913ChosainJohoEntity entity = new DbT5913ChosainJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setNinteichosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainNo(DEFAULT_認定調査員コード);
        entity.setChosainShimei(DEFAULT_調査員氏名);
        entity.setChosainKanaShimei(DEFAULT_調査員氏名カナ);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setChosainShikaku(DEFAULT_調査員資格);
        entity.setChikuCode(DEFAULT_地区コード);
        entity.setChosaKanoNinzuPerMonth(DEFAULT_調査可能人数月);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
