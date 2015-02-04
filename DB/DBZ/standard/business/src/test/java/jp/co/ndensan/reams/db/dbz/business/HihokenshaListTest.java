/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.HihokenshaMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * HihokenshaListのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class HihokenshaListTest extends DbzTestBase {

    private static final LasdecCode l000001 = new LasdecCode("000001");
    private static final LasdecCode l000002 = new LasdecCode("000002");
    private static final LasdecCode l000003 = new LasdecCode("000003");
    private static final LasdecCode l000004 = new LasdecCode("000004");
    private static final ShikibetsuCode s0000000001 = new ShikibetsuCode("0000000001");
    private static final ShikibetsuCode s0000000002 = new ShikibetsuCode("0000000002");
    private static final YMDHMS rt2014_04_01_00_00 = new YMDHMS("20140401000000");
    private static final YMDHMS rt2014_04_02_00_00 = new YMDHMS("20140402000000");
    private static final YMDHMS rt2014_04_03_00_00 = new YMDHMS("20140403000000");
    private static final YMDHMS rt2014_04_04_00_00 = new YMDHMS("20140404000000");
    private static final HihokenshaNo hn0000000001 = new HihokenshaNo(new RString("0000000001"));
    private static final HihokenshaNo hn0000000002 = new HihokenshaNo(new RString("0000000002"));

    public static class Constructor extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタは_引数がnullのとき_NullPointerExceptionをスローする() {
            HihokenshaList sut = new HihokenshaList(null);
        }
    }

    public static class size extends DbzTestBase {

        @Test
        public void sizeは_コンストラクタ引数のlistのsizeと_同じ値を返す() {
            List<Hihokensha> list = createHihokenshaList();
            HihokenshaList sut = new HihokenshaList(list);
            assertThat(sut.size(), is(list.size()));
        }

        @Test
        public void sizeは_コンストラクタ引数が_Collections$EMPTY_List_のときと_0を返す() {
            HihokenshaList sut = new HihokenshaList(Collections.EMPTY_LIST);
            assertThat(sut.size(), is(0));
        }

        @Test
        public void subHihokenshaListにより作られたsutの_sizeは_元のコンストラクタ引数内の_subHihokenshaListの引数である_条件への該当件数と一致する() {
            List<Hihokensha> list = createHihokenshaList();
            HihokenshaList sut = new HihokenshaList(list);
            HihokenshaList afterSubList = sut.subHihokenshaList(l000001);
            assertThat(afterSubList.size(), is(1));
        }
    }

    public static class isEmpty extends DbzTestBase {

        @Test
        public void isEmptyは_コンストラクタ引数が_Collections$EMPTY_List_のとき_trueを返す() {
            HihokenshaList sut = new HihokenshaList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }
    }

    public static class getHihokensha extends DbzTestBase {

        private List<Hihokensha> list;
        private HihokenshaList sut;

        @Before
        public void setUp() {
            list = createHihokenshaList();
            sut = new HihokenshaList(list);
        }

        @Test
        public void KaigoHihokenshaNo指定の_getHihokenshaで得られるHihokenshaのget被保険者番号は_引数と同じ値を返す() {
            Hihokensha result = sut.getHihokensha(hn0000000001);
            assertThat(result.get被保険者番号(), is(hn0000000001));
        }

        @Test(expected = IllegalArgumentException.class)
        public void KaigoHihokenshaNo指定の_getHihokenshaは_該当のHihokenshaが見つからないとき_IllegalArgumentExceptionをスローする() {
            Hihokensha result = sut.getHihokensha(HihokenshaNo.EMPTY);
        }

        @Test
        public void ShikibetsuCode指定の_getHihokenshaで得られるHihokenshaのget識別コードは_引数と同じ値を返す() {
            Hihokensha result = sut.getHihokensha(s0000000001);
            assertThat(result.get識別コード(), is(s0000000001));
        }

        @Test(expected = IllegalArgumentException.class)
        public void ShikibetsuCode指定の_getHihokenshaは_該当のHihokenshaが見つからないとき_IllegalArgumentExceptionをスローする() {
            Hihokensha result = sut.getHihokensha(new ShikibetsuCode("9999999999"));
        }
    }

    private static List<Hihokensha> createHihokenshaList() {
        List<Hihokensha> list = new ArrayList<>();
        list.add(HihokenshaMock.createHihokensha(l000002, s0000000001, rt2014_04_04_00_00, hn0000000002));
        list.add(HihokenshaMock.createHihokensha(l000003, s0000000001, rt2014_04_02_00_00, hn0000000002));
        list.add(HihokenshaMock.createHihokensha(l000004, s0000000002, rt2014_04_01_00_00, hn0000000001));
        list.add(HihokenshaMock.createHihokensha(l000001, s0000000002, rt2014_04_03_00_00, hn0000000001));
        return list;
    }
}
