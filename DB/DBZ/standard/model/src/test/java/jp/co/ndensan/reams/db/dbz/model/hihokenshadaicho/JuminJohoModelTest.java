/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.IShikibetsuTaisho;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.JumonJohoModel}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JuminJohoModelTest {

    private static JuminJohoModel sut;

    public static class constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 引数にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new JuminJohoModel(null);
            fail();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数に個人に変換できない識別対象が渡された場合_IllegalArgumentExceptionが発生する() {
            IShikibetsuTaisho shikibetsuTaisho = mock(IShikibetsuTaisho.class);
            when(shikibetsuTaisho.canBe個人()).thenReturn(false);
            sut = new JuminJohoModel(shikibetsuTaisho);
            fail();
        }
    }

}
