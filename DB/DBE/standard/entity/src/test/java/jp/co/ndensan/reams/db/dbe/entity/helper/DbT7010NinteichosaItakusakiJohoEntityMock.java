/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * DbT5001NinteiShinseiJohoEntityを生成するためのMockクラスです
 *
 * @author N8187 久保田 英男
 */
public class DbT7010NinteichosaItakusakiJohoEntityMock {

    private DbT7010NinteichosaItakusakiJohoEntityMock() {
    }

    public static DbT7010NinteichosaItakusakiJohoEntity getSpiedInstance() {
        final RString 試験用文字列 = new RString("0001");
        return spy(new DbT7010NinteichosaItakusakiJohoEntity(
                試験用文字列,
                new KaigoJigyoshaNo(試験用文字列),
                new JigyoshaNo(試験用文字列),
                true,
                ChosaItakuKubun.指定なし,
                1,
                試験用文字列,
                試験用文字列));
    }
}
