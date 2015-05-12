/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
//import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先のテストヘルパーです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaItakusakiTestHelper {

    public static final LasdecCode 市町村コード = new LasdecCode(new RString("123456"));
    public static final KaigoJigyoshaNo 介護事業者番号 = new KaigoJigyoshaNo(new RString("123456"));
    public static final JigyoshaNo 事業者番号 = new JigyoshaNo(new RString("123456"));
    public static final boolean 介護事業者状況 = true;
    public static final ChosaItakuKubun 調査委託区分 = ChosaItakuKubun.介護保険施設;
    public static final int 割付定員 = 3;
    public static final RString 割付地区 = new RString("割付地区");
    public static final RString 機関の区分 = new RString("機関の区分");

    /**
     * テスト用認定調査委託先Entityを返します。
     *
     * @return 認定調査委託先Entity
     */
    public static DbT7010NinteichosaItakusakiJohoEntity create認定調査委託先Entity() {
        DbT7010NinteichosaItakusakiJohoEntity entity = new DbT7010NinteichosaItakusakiJohoEntity(
                市町村コード,
                介護事業者番号,
                事業者番号,
                介護事業者状況,
                調査委託区分,
                割付定員,
                割付地区,
                機関の区分);

        return entity;
    }
}
