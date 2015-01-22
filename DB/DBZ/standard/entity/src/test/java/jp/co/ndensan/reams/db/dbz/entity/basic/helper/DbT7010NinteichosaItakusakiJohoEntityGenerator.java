/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先情報　継承エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7010NinteichosaItakusakiJohoEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_介護事業者番号 = new RString("123");
    public static final RString DEFAULT_事業者番号 = new RString("123");
    public static final RString DEFAULT_介護事業者状況 = new RString("3");
    public static final Code DEFAULT_調査委託区分コード = new Code("3");
    public static final int DEFAULT_割付定員 = 1;
    public static final ChikuCode DEFAULT_割付地区 = new ChikuCode(new RString("02"));
    public static final Code DEFAULT_機関の区分コード = new Code("3");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7010NinteichosaItakusakiJohoEntityGenerator() {
    }

    public static DbT7010NinteichosaItakusakiJohoEntity createDbT7010NinteichosaItakusakiJohoEntity() {
        DbT7010NinteichosaItakusakiJohoEntity entity = new DbT7010NinteichosaItakusakiJohoEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setKaigoJigyoshaNo(DEFAULT_介護事業者番号);
        entity.setJigyoshaNo(DEFAULT_事業者番号);
        entity.setKaigoJigyoshaJokyo(DEFAULT_介護事業者状況);
        entity.setChosaItakuKubunCode(DEFAULT_調査委託区分コード);
        entity.setWaritsukeTeiin(DEFAULT_割付定員);
        entity.setWaritsukeChiku(DEFAULT_割付地区);
        entity.setKikanKubunCode(DEFAULT_機関の区分コード);
        return entity;
    }
}
