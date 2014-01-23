/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.helper;

import jp.co.ndensan.reams.db.dba.definition.valueobject.JushochitokureiKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.mockito.Mockito.*;

/**
 * 住所地特例解除事由のMockクラスです。
 *
 * @author N3327 三浦 凌
 */
public class JushochitokureiKaijoJiyuMock {

    private JushochitokureiKaijoJiyuMock() {
    }

    public static JushochitokureiKaijoJiyu getSpiedInstance() {
        JushochitokureiKaijoJiyu 住所地特例解除事由 = new JushochitokureiKaijoJiyu(new RString("コード"), new RString("名称"));
        return spy(住所地特例解除事由);
    }
}
