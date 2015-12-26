/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5910NinteichosaItakusakiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202010");
    public static final ChosaItakusakiCode DEFAULT_認定調査委託先コード = new ChosaItakusakiCode("000001");
    public static final JigyoshaNo DEFAULT_事業者番号 = new JigyoshaNo("111111");
    public static final RString DEFAULT_事業者名称 = new RString("名称");
    public static final RString DEFAULT_事業者名称カナ = new RString("名称");
    public static final YubinNo DEFAULT_郵便番号 = new YubinNo("1234567");
    public static final RString DEFAULT_住所 = new RString("名称");
    public static final TelNo DEFAULT_電話番号 = new TelNo("0123456789");
    public static final TelNo DEFAULT_FAX番号 = new TelNo("0123456789");
    public static final AtenaMeisho DEFAULT_代表者名 = new AtenaMeisho("宛名名称");
    public static final RString DEFAULT_調査委託区分 = new RString("名称");
    public static final int DEFAULT_割付定員 = 1;
    public static final ChikuCode DEFAULT_割付地区 = new ChikuCode("123456789");
    public static final boolean DEFAULT_自動割付フラグ = false;
    public static final RString DEFAULT_機関の区分 = new RString("名称");
    public static final boolean DEFAULT_状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5910NinteichosaItakusakiJohoEntityGenerator() {
    }

    public static DbT5910NinteichosaItakusakiJohoEntity createDbT5910NinteichosaItakusakiJohoEntity() {
        DbT5910NinteichosaItakusakiJohoEntity entity = new DbT5910NinteichosaItakusakiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setJigyoshaMeisho(DEFAULT_事業者名称);
        entity.setJigyoshaMeishoKana(DEFAULT_事業者名称カナ);
        entity.setYubinNo(DEFAULT_郵便番号);
        entity.setJusho(DEFAULT_住所);
        entity.setTelNo(DEFAULT_電話番号);
        entity.setFaxNo(DEFAULT_FAX番号);
        entity.setChosaItakuKubun(DEFAULT_調査委託区分);
        entity.setWaritsukeTeiin(DEFAULT_割付定員);
        entity.setWaritsukeChiku(DEFAULT_割付地区);
        entity.setAutoWaritsukeFlag(DEFAULT_自動割付フラグ);
        entity.setKikanKubun(DEFAULT_機関の区分);
        entity.setJokyoFlag(DEFAULT_状況フラグ);
        return entity;
    }
}
