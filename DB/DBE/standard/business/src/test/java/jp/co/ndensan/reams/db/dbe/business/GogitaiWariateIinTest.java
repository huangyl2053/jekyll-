/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaichoKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsainKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 合議体割当委員のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiWariateIinTest {

    public static class コンストラクタのテスト extends DbeTestBase {

        ShinsakaiIin 委員情報;
        ShinsainKubun 認定調査員区分;
        GogitaichoKubun 合議体長区分;
        GogitaiJoho 所属合議体情報;

        @Before
        public void setUp() {
            委員情報 = mock(ShinsakaiIin.class);
            認定調査員区分 = mock(ShinsainKubun.class);
            合議体長区分 = mock(GogitaichoKubun.class);
            所属合議体情報 = mock(GogitaiJoho.class);
        }

        @Test(expected = NullPointerException.class)
        public void 委員情報にnullを渡すと_NullPointerExceptionが発生する() {
            GogitaiWariateIin sut = new GogitaiWariateIin(null, 認定調査員区分, 合議体長区分, 所属合議体情報);
        }

        @Test(expected = NullPointerException.class)
        public void 所属合議体情報にnullを渡すと_NullPointerExceptionが発生する() {
            GogitaiWariateIin sut = new GogitaiWariateIin(委員情報, 認定調査員区分, 合議体長区分, null);
        }

        @Test
        public void 必須の項目を引数に渡すと_インスタンスが生成される() {
            GogitaiWariateIin sut = new GogitaiWariateIin(委員情報, null, null, 所属合議体情報);
            assertThat(sut, instanceOf(GogitaiWariateIin.class));
        }
    }
}
