/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5913ChosainJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1");
    public static final RString DEFAULT_認定調査員コード = new RString("1");
    public static final RString DEFAULT_調査員氏名 = new RString("1");
    public static final RString DEFAULT_調査員氏名カナ = new RString("1");
    public static final RString DEFAULT_性別 = new RString("1");
    public static final RString DEFAULT_調査員資格 = new RString("1");
    public static final RString DEFAULT_地区コード = new RString("1");
    public static final int DEFAULT_調査可能人数_月 = 1;
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("3801234");
    public static final AtenaJusho DEFAULT_住所 = new AtenaJusho("あ");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("1234567890");
    public static final RString DEFAULT_所属機関名称 = new RString("1");
    public static final boolean DEFAULT_状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5913ChosainJohoEntityGenerator() {
    }

    public static DbT5913ChosainJohoEntity createDbT5913ChosainJohoEntity() {
        DbT5913ChosainJohoEntity entity = new DbT5913ChosainJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setNinteiChosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setNinteiChosainCode(DEFAULT_認定調査員コード);
        entity.setChosainShimei(DEFAULT_調査員氏名);
        entity.setChosainKanaShimei(DEFAULT_調査員氏名カナ);
        entity.setSeibetsu(DEFAULT_性別);
        entity.setChosainShikaku(DEFAULT_調査員資格);
        entity.setChikuCode(DEFAULT_地区コード);
        entity.setChosaKanoNinzuPerMonth(DEFAULT_調査可能人数_月);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setShozokuKikanName(DEFAULT_所属機関名称);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
