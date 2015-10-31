/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5910NinteichosaItakusakiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final RString DEFAULT_認定調査委託先コード = new RString("1");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("1");
    public static final RString DEFAULT_事業者名称 = new RString("事業者名称");
    public static final RString DEFAULT_事業者名称カナ = new RString("ジギョウシャメイショウカナ");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("3801111");
    public static final RString DEFAULT_住所 = new RString("長野市県町");
    public static final TelNo DEFAULT_電話番号 = new TelNo("1234567890");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("1234567890");
    public static final RString DEFAULT_代表者名 = new RString("代表者名");
    public static final RString DEFAULT_代表者名カナ = new RString("ダイヒョウシャメイカナ");
    public static final RString DEFAULT_調査委託区分 = new RString("1");
    public static final boolean DEFAULT_特定調査員表示フラグ = false;
    public static final int DEFAULT_割付定員 = 1;
    public static final ChikuCode DEFAULT_割付地区 = new ChikuCode("1");
    public static final boolean DEFAULT_自動割付フラグ = false;
    public static final RString DEFAULT_機関の区分 = new RString("0");
    public static final boolean DEFAULT_状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5910NinteichosaItakusakiJohoEntityGenerator() {
    }

    public static DbT5910NinteichosaItakusakiJohoEntity createDbT5910NinteichosaItakusakiJohoEntity() {
        DbT5910NinteichosaItakusakiJohoEntity entity = new DbT5910NinteichosaItakusakiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setNinteichosaItakusakiCode(DEFAULT_認定調査委託先コード);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setJigyoshaMeisho(DEFAULT_事業者名称);
        entity.setJigyoshaMeishoKana(DEFAULT_事業者名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setDaihyoshaName(DEFAULT_代表者名);
        entity.setDaihyoshaNameKana(DEFAULT_代表者名カナ);
        entity.setChosaItakuKubun(DEFAULT_調査委託区分);
        entity.setTokuteiChosainDisplayFlag(DEFAULT_特定調査員表示フラグ);
        entity.setWaritsukeTeiin(DEFAULT_割付定員);
        entity.setWaritsukeChiku(DEFAULT_割付地区);
        entity.setAutoWaritsukeFlag(DEFAULT_自動割付フラグ);
        entity.setKikanKubun(DEFAULT_機関の区分);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
