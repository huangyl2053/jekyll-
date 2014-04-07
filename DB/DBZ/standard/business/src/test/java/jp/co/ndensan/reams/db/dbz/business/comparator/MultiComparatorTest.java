/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.comparator.HihokenshaComparators.RegisterDateTimeComparator;
import jp.co.ndensan.reams.db.dbz.business.comparator.HihokenshaComparators.ShichosonCodeComparator;
import jp.co.ndensan.reams.db.dbz.business.helper.HihokenshaMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;

/**
 * MultiComparatorのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class MultiComparatorTest extends DbzTestBase {

    public static class sort extends DbzTestBase {

        MultiComparator<Hihokensha> sut;
        List<Hihokensha> hihokenshaList;
        private final LasdecCode l000001 = new LasdecCode("000001");
        private final LasdecCode l000002 = new LasdecCode("000002");
        private final ShikibetsuCode s0000000001 = new ShikibetsuCode("0000000001");
        private final ShikibetsuCode s0000000002 = new ShikibetsuCode("0000000002");
        private final ShikibetsuCode s0000000003 = new ShikibetsuCode("0000000003");
        private final RDateTime rt2014_04_07_00_00 = RDateTime.of(2014, 4, 7, 0, 0);
        private final RDateTime rt2014_04_08_00_00 = RDateTime.of(2014, 4, 8, 0, 0);
        private final KaigoHihokenshaNo hn0000000001 = new KaigoHihokenshaNo(new RString("0000000001"));
        private final KaigoHihokenshaNo hn0000000002 = new KaigoHihokenshaNo(new RString("0000000002"));
        private final KaigoHihokenshaNo hn0000000003 = new KaigoHihokenshaNo(new RString("0000000003"));
        private final KaigoHihokenshaNo hn0000000004 = new KaigoHihokenshaNo(new RString("0000000004"));
        private final KaigoHihokenshaNo hn0000000005 = new KaigoHihokenshaNo(new RString("0000000005"));

        @Before
        public void setUp() {
            sut = new MultiComparator<>(
                    ShichosonCodeComparator.ASC,
                    ShikibetsuCodeComparator.ASC,
                    RegisterDateTimeComparator.DESC,
                    HihokenshaNoComparator.ASC);

            hihokenshaList = createHihokenshaList();
            Collections.sort(hihokenshaList, sut);
        }

        @Test
        public void Hihokenshaのlistのソート後_地方公共団体コードが小さい物の方が_前にある() {
            LasdecCode lasdecCode2 = hihokenshaList.get(2).get地方公共団体コード();
            LasdecCode lasdecCode3 = hihokenshaList.get(3).get地方公共団体コード();
            assertThat(lasdecCode2.equals(lasdecCode3), is(false));
            assertThat(lasdecCode2.compareTo(lasdecCode3) < 0, is(true));
        }

        @Test
        public void Hihokenshaのlistのソート後_地方公共団体コードが同じ物は_識別コードが小さい物の方が_前にある() {
            assertThat(hihokenshaList.get(0).get地方公共団体コード(), is(hihokenshaList.get(1).get地方公共団体コード()));
            ShikibetsuCode shikibetsuCode0 = hihokenshaList.get(0).get識別コード();
            ShikibetsuCode shikibetsuCode1 = hihokenshaList.get(1).get識別コード();
            assertThat(shikibetsuCode0.equals(shikibetsuCode1), is(false));
            assertThat(shikibetsuCode0.compareTo(shikibetsuCode1) < 0, is(true));
        }

        @Test
        public void Hihokenshaのlistのソート後_地方公共団体コードと識別コードが同じ値の物は_被保険者台帳登録日時の遅い物の方が_前にある() {
            assertThat(hihokenshaList.get(1).get地方公共団体コード(), is(hihokenshaList.get(2).get地方公共団体コード()));
            assertThat(hihokenshaList.get(1).get識別コード(), is(hihokenshaList.get(2).get識別コード()));
            RDateTime torokuDateTime1 = hihokenshaList.get(1).get被保険者台帳登録日時();
            RDateTime torokuDateTime2 = hihokenshaList.get(2).get被保険者台帳登録日時();
            assertThat(torokuDateTime1.isAfter(torokuDateTime2), is(true));
        }

        @Test
        public void Hihokenshaのlistのソート後_地方公共団体コードと識別コードと被保険者台帳登録日時が同じ値の物は_被保険者番号の小さい物の方が_前にある() {
            assertThat(hihokenshaList.get(3).get地方公共団体コード(), is(hihokenshaList.get(4).get地方公共団体コード()));
            assertThat(hihokenshaList.get(3).get識別コード(), is(hihokenshaList.get(4).get識別コード()));
            assertThat(hihokenshaList.get(3).get被保険者台帳登録日時(), is(hihokenshaList.get(4).get被保険者台帳登録日時()));
            KaigoHihokenshaNo hihokenshaNo3 = hihokenshaList.get(3).get被保険者番号();
            KaigoHihokenshaNo hihokenshaNo4 = hihokenshaList.get(4).get被保険者番号();
            assertThat(hihokenshaNo3.equals(hihokenshaNo4), is(false));
            assertThat(hihokenshaNo3.compareTo(hihokenshaNo4) < 0, is(true));
        }

        private List<Hihokensha> createHihokenshaList() {
            List<Hihokensha> list = new ArrayList<>();
            list.add(HihokenshaMock.createHihokensha(l000002, s0000000003, rt2014_04_07_00_00, hn0000000003));
            list.add(HihokenshaMock.createHihokensha(l000001, s0000000001, rt2014_04_07_00_00, hn0000000002));
            list.add(HihokenshaMock.createHihokensha(l000002, s0000000003, rt2014_04_07_00_00, hn0000000001));
            list.add(HihokenshaMock.createHihokensha(l000001, s0000000002, rt2014_04_07_00_00, hn0000000004));
            list.add(HihokenshaMock.createHihokensha(l000001, s0000000002, rt2014_04_08_00_00, hn0000000005));
            return list;
        }
    }
}
