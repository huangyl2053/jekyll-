/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho._Name;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link _CareManager}のテストクラスです。
 *
 * @author n9944 趙 春暉
 */
public class _CareManagerTest extends DbxTestBase {

    private static _CareManager careManager;
    Range<FlexibleDate> range = new Range(new RDate("20131118"), new RDate("20131122"));

    @Test(expected = NullPointerException.class)
    public void コンストラクタの引数の介護支援専門員番号にnullを渡すと_コンストラクタは_例外を投げる() {
        new _CareManager(null, TestUtil.createName(), TestUtil.createKaigoJigyosha(), mock(Range.class));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタの引数の氏名にnullを渡すと_コンストラクタは_例外を投げる() {
        new _CareManager(TestUtil.createNumber(), null, TestUtil.createKaigoJigyosha(), mock(Range.class));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタの引数の所属事業者にnullを渡すと_コンストラクタは_例外を投げる() {
        new _CareManager(TestUtil.createNumber(), TestUtil.createName(), null, mock(Range.class));
    }

    @Test(expected = NullPointerException.class)
    public void コンストラクタの引数の有効年月日にnullを渡すと_コンストラクタは_例外を投げる() {
        new _CareManager(TestUtil.createNumber(), TestUtil.createName(), TestUtil.createKaigoJigyosha(), null);
    }

    @Test
    public void LDNS_介護支援専門員番号を設定する_get介護支援専門員番号は_9876543210を返す() {
        careManager = new _CareManager(new RString("9876543210"), TestUtil.createName(), TestUtil.createKaigoJigyosha(), range);
        assertThat(careManager.get介護支援専門員番号(), is(new RString("9876543210")));
    }

    @Test
    public void LDNS_氏名を設定する_get氏名は_氏名を返す() {
        IName 氏名 = new _Name(new AtenaMeisho(new RString("氏名")), new AtenaKanaMeisho(new RString("ｶﾅ")));
        careManager = new _CareManager(new RString("9876543210"), 氏名, TestUtil.createKaigoJigyosha(), range);
        assertThat(careManager.get氏名(), is(氏名));
    }

    @Test
    public void LDNS_所属事業者を設定する_get所属事業者は_所属事業者を返す() {
        IKaigoJigyosha jigyosha = mock(IKaigoJigyosha.class);
        when(jigyosha.get事業者番号()).thenReturn(new KaigoJigyoshaNo(new RString("1234567890")));
        IName 氏名 = new _Name(new AtenaMeisho(new RString("氏名")), new AtenaKanaMeisho(new RString("ｶﾅ")));
        careManager = new _CareManager(new RString("9876543210"), 氏名, jigyosha, range);
        assertThat(careManager.get所属事業者(), is(jigyosha));
    }

    private static class TestUtil {

        private static RString createNumber() {
            return new RString("9876543210");
        }

        private static IName createName() {
            return new _Name(new AtenaMeisho(new RString("氏名")), new AtenaKanaMeisho(new RString("ｶﾅ")));
        }

        private static IKaigoJigyosha createKaigoJigyosha() {
            IKaigoJigyosha jigyosha = mock(IKaigoJigyosha.class);
            when(jigyosha.get事業者番号()).thenReturn(new KaigoJigyoshaNo("1234567890"));
            return jigyosha;
        }
    }
}
