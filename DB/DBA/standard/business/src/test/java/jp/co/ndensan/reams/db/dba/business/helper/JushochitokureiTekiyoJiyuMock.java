/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.helper;

import jp.co.ndensan.reams.db.dba.definition.core.jushochitokureitekiyojiyu.JushochitokureiTekiyoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.spy;

/**
 * 住所地特例適用事由のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiTekiyoJiyuMock {

    private JushochitokureiTekiyoJiyuMock() {
    }

    public static JushochitokureiTekiyoJiyu getSpiedInstance() {
        JushochitokureiTekiyoJiyu 住所地特例適用事由 = new JushochitokureiTekiyoJiyu(new RString("コード"), new RString("名称"));
        return spy(住所地特例適用事由);
    }
}
