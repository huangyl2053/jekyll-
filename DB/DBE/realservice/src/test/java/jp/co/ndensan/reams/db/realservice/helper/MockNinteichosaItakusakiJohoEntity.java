/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.realservice.helper;

import jp.co.ndensan.reams.db.dbe.business.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.T7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * NiteichosaItakusakiJohoEntityを生成するためのMockクラスです
 *
 * @author N1013 松本直樹
 */
public class MockNinteichosaItakusakiJohoEntity {

    private static KaigoJigyoshaNo kaigojigyoshaNo;
    private static JigyoshaNo jigyoshaNo;

    private MockNinteichosaItakusakiJohoEntity() {
    }

    public static T7010NinteichosaItakusakiJohoEntity getSpiedInstance() {
        kaigojigyoshaNo = mock(KaigoJigyoshaNo.class);
        jigyoshaNo = mock(JigyoshaNo.class);
        kaigojigyoshaNo = new KaigoJigyoshaNo(new RString("0000000001"));
        jigyoshaNo = new JigyoshaNo(new RString("2020300001"));
        T7010NinteichosaItakusakiJohoEntity ninteichosaItakusakiJohoEntity = new T7010NinteichosaItakusakiJohoEntity(
                new RString("20203"), kaigojigyoshaNo, jigyoshaNo,
                true, ChosaItakuKubun.指定なし, 10, new RString("A"), new RString("B"));
        return spy(ninteichosaItakusakiJohoEntity);
    }
}
