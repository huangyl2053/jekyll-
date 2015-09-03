/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.ICareManager;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7064CareManegerDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link _CareManagerFinder}のテストクラスです。
 *
 * @author n9944 趙 春暉
 */
public class _CareManagerFinderTest extends DbxTestBase {

    _CareManagerFinder sut;
    DbT7064CareManegerDac dac;

    @Before
    public void setUp() {
        dac = new DbT7064CareManegerDac();
        sut = new _CareManagerFinder(dac);
    }

    @Test(expected = NullPointerException.class)
    public void 引数の介護支援専門員番号にnullを渡すと_getCareManagerは_例外を投げる() {
        sut.getCareManager(null);
    }

    @Test
    public void 実在しない介護支援専門員番号を渡すと_getCareManagerは_nullを返す() {
        ICareManager result = sut.getCareManager(new RString("実在しないコード"));
        assertThat(result, is(nullValue()));
    }

    @Test(expected = NullPointerException.class)
    public void 引数の所属事業者にnullを渡すと_get所属ケアマネージャは_例外を投げる() {
        sut.get所属ケアマネージャ(null);
    }

    @Test
    public void 事業者に介護支援専門員がいないと_get所属ケアマネージャは_空のリストを返す() {
        IKaigoJigyosha 事業者 = mock(IKaigoJigyosha.class);
        when(事業者.get事業者番号()).thenReturn(new KaigoJigyoshaNo("0123456789"));
        List<ICareManager> result = sut.get所属ケアマネージャ(事業者);
        assertThat(result, is(Collections.EMPTY_LIST));
    }
}
