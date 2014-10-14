/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShinsakaiWariateIinMapper;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinShukketsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会割当委員Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiWariateIinMapperTest {

    public static class to審査会割当委員のテスト extends DbeTestBase {

        private DbT5106ShinsakaiWariateIinJohoEntity 審査会割当委員Entity;
        private ShinsakaiIin 委員;
        private ShinsakaiDetail 審査会情報;
        private ShinsakaiWariateIin result;
        private ShinsakaiKaisaiNo 開催番号_1;
        private FlexibleDate 開催年月日_19990101;
        private ShinsakaiIinCode 審査会委員コード_00000001;
        private Code 審査員区分_shinsain01;
        private Code 合議体長区分_gogitaicho01;
        private RString 開始時間_0830;
        private RString 終了時間_1730;
        private RString 出欠区分_1;

        @Before
        public void setUp() {
            開催番号_1 = new ShinsakaiKaisaiNo(1);
            開催年月日_19990101 = new FlexibleDate("19990101");
            審査会委員コード_00000001 = new ShinsakaiIinCode(new RString("00000001"));
            審査員区分_shinsain01 = new Code("shinsain01");
            合議体長区分_gogitaicho01 = new Code("gogitaicho01");
            開始時間_0830 = new RString("0830");
            終了時間_1730 = new RString("1730");
            出欠区分_1 = new RString("1");

            審査会割当委員Entity = ShinsakaiMockEntityCreator.create審査会割当委員情報EntitySpy(開催番号_1.value().intValue(),
                    開催年月日_19990101, 審査会委員コード_00000001.value(), 審査員区分_shinsain01, 合議体長区分_gogitaicho01,
                    開始時間_0830, 終了時間_1730, 出欠区分_1);
            委員 = ShinsakaiMockBusinessCreator.create審査会委員("00000001");
            審査会情報 = ShinsakaiMockBusinessCreator.create審査会情報(1, "19990101");
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, 委員, 審査会情報);
        }

        @Test
        public void 審査会割当委員Entityにnullが渡されたとき_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(null, 委員, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会委員に値が渡されているのに_委員にnullが渡された場合_IllegalArgumentException発生する() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, null, 審査会情報);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 審査会委員に値が渡されているのに_審査会情報にnullが渡されたとき_IllegalArgumentException発生する() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, 委員, null);
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査会情報の開催番号は_1になる() {
            assertThat(result.get審査会情報().get審査会開催番号().value(), is(開催番号_1.value()));
        }

        @Test
        public void 返却された審査会割当委員が持つ_委員情報の委員コードは_iin01になる() {
            assertThat(result.get審査会委員情報().get審査会委員コード().value(), is(審査会委員コード_00000001.value()));
        }

        @Test
        public void 返却された審査会割当委員が持つ_認定審査員区分の区分コードは_shinsain01になる() {
            assertThat(result.get認定審査員区分().getCode(), is(審査員区分_shinsain01));
        }

        @Test
        public void 返却された審査会割当委員が持つ_合議体長区分の区分コードは_gogitaicho01になる() {
            assertThat(result.get合議体長区分().getCode(), is(合議体長区分_gogitaicho01));
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査時間の開始は_0830になる() {
            assertThat(result.get審査時間().getFrom().value(), is(開始時間_0830));
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査時間の終了は_1720になる() {
            assertThat(result.get審査時間().getTo().value(), is(終了時間_1730));
        }

        @Test
        public void 返却された審査会割当委員が持つ_出欠区分の区分コードは_1になる() {
            assertThat(result.get出欠区分().get出欠区分コード(), is(出欠区分_1));
        }
    }

    public static class to審査会割当委員Listのテスト extends DbeTestBase {

        private List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList;
        private ShinsakaiIinList 委員List;
        private ShinsakaiDetail 審査会情報;
        private ShinsakaiWariateIinList result;
        private ShinsakaiKaisaiNo 開催番号;
        private FlexibleDate 開催年月日;

        @Before
        public void setUp() {
            開催番号 = new ShinsakaiKaisaiNo(1);
            開催年月日 = new FlexibleDate("19990101");
            審査会割当委員EntityList = ShinsakaiMockEntityCreator.create審査会割当委員情報EntityListSpy(開催番号.value(),
                    開催年月日.toString(), "00000001", "00000002", "00000003");
            委員List = ShinsakaiMockBusinessCreator.create審査会委員List("00000001", "00000002", "00000003");
            審査会情報 = ShinsakaiMockBusinessCreator.create審査会情報(開催番号.value(), 開催年月日.toString());
        }

        @Test
        public void 審査会割当委員EntityListにnullが渡された時_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(null, 委員List, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 委員Listにnullが渡された時_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, null, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 審査会情報にnullが渡された時_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 割当委員EntityListと委員Listが_それぞれ3件の要素を持つとき_返却される割当委員は3件の要素を持つ() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);
            assertThat(result.size(), is(3));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 割当委員EntityListと委員Listの要素数が違うとき_IllegalArgumentExceptionが発生する() {
            審査会割当委員EntityList
                    = ShinsakaiMockEntityCreator.create審査会割当委員情報EntityListSpy(開催番号.value(),
                            開催年月日.toString(), "00000001", "00000002", "00000003");
            委員List = ShinsakaiMockBusinessCreator.create審査会委員List("00000001", "00000002");
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 割当委員EntityListと委員Listの要素間に_委員コードが一致しない要素が存在するとき_IllegalArgumentExceptionが発生する() {
            審査会割当委員EntityList
                    = ShinsakaiMockEntityCreator.create審査会割当委員情報EntityListSpy(開催番号.value(),
                            開催年月日.toString(), "00000001", "00000004", "00000003");
            委員List = ShinsakaiMockBusinessCreator.create審査会委員List("00000001", "00000002", "00000003");
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);
        }

        public void 返却された審査会割当委員Listと_引数から渡された委員Listは_審査会委員コードがiin01の要素をそれぞれ持つ() {
            ShinsakaiIinCode 委員コード = new ShinsakaiIinCode(new RString("00000001"));
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);

            ShinsakaiIin iin1 = result.get審査会割当委員(開催番号, 委員コード).get審査会委員情報();
            ShinsakaiIin iin2 = 委員List.get審査会委員(委員コード);
            assertThat(iin1.get審査会委員コード(), is(iin2.get審査会委員コード()));
        }

        public void 返却された審査会割当委員Listと_引数から渡された委員Listは_審査会委員コードがiin02の要素をそれぞれ持つ() {
            ShinsakaiIinCode 委員コード = new ShinsakaiIinCode(new RString("00000002"));
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);

            ShinsakaiIin iin1 = result.get審査会割当委員(開催番号, 委員コード).get審査会委員情報();
            ShinsakaiIin iin2 = 委員List.get審査会委員(委員コード);
            assertThat(iin1.get審査会委員コード(), is(iin2.get審査会委員コード()));
        }

        public void 返却された審査会割当委員Listと_引数から渡された委員Listは_審査会委員コードがiin03の要素をそれぞれ持つ() {
            ShinsakaiIinCode 委員コード = new ShinsakaiIinCode(new RString("00000003"));
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);

            ShinsakaiIin iin1 = result.get審査会割当委員(開催番号, 委員コード).get審査会委員情報();
            ShinsakaiIin iin2 = 委員List.get審査会委員(委員コード);
            assertThat(iin1.get審査会委員コード(), is(iin2.get審査会委員コード()));
        }
    }

    public static class to審査員割当委員Entityのテスト extends DbeTestBase {

        private DbT5106ShinsakaiWariateIinJohoEntity result;
        private ShinsakaiWariateIin 割当委員;
        private int 審査会開催番号_1;
        private FlexibleDate 審査会開催年月日_19990101;
        private ShinsakaiIinCode 審査会委員コード_00000001;
        private Code 審査員区分_S001;
        private Code 合議体長区分_G001;
        private TimeString 開始時間_0830;
        private TimeString 終了時間_2359;
        private ShinsakaiIinShukketsuKubun 出欠区分_出席;

        @Before
        public void setUp() {
            審査会開催番号_1 = 1;
            審査会開催年月日_19990101 = new FlexibleDate("19990101");
            審査会委員コード_00000001 = new ShinsakaiIinCode(new RString("00000001"));
            審査員区分_S001 = new Code("S001");
            合議体長区分_G001 = new Code("G001");
            開始時間_0830 = new TimeString("0830");
            終了時間_2359 = new TimeString("2359");
            出欠区分_出席 = ShinsakaiIinShukketsuKubun.出席;

            割当委員 = ShinsakaiMockBusinessCreator.create審査会割当委員(審査会開催番号_1, 審査会開催年月日_19990101.toString(),
                    審査会委員コード_00000001.value().toString(), 審査員区分_S001, 合議体長区分_G001, 開始時間_0830,
                    終了時間_2359, 出欠区分_出席);
            result = ShinsakaiWariateIinMapper.to審査員割当委員Entity(割当委員);
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査会開催番号は_1になる() {
            assertThat(result.getShinsakaiKaisaiNo(), is(審査会開催番号_1));
        }

        @Test
        public void 返却された割当委員Entityが持つ_開催年月日は_19990101になる() {
            assertThat(result.getShinsakaiKaisaiYMD(), is(審査会開催年月日_19990101));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査会委員コードは_iin01になる() {
            assertThat(result.getShinsakaiIinCode(), is(審査会委員コード_00000001.value()));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査員区分コードは_S001になる() {
            assertThat(result.getShinsainKubunCode(), is(審査員区分_S001));
        }

        @Test
        public void 返却された割当委員Entityが持つ合議体長区分コード_は_G001になる() {
            assertThat(result.getGogitaichoKubunCode(), is(合議体長区分_G001));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査開始時間は_0000になる() {
            assertThat(result.getShinsakaiIinShinsaKaishiTime(), is(開始時間_0830.value()));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査終了時間は_2359になる() {
            assertThat(result.getShinsakaiIinshinsaShuryoTime(), is(終了時間_2359.value()));
        }

        @Test
        public void 返却された割当委員Entityが持つ_委員出欠区分は_出席を表す1になる() {
            assertThat(result.getShinsakaiIinShukketsuKubun(), is(出欠区分_出席.get出欠区分コード()));
        }
    }

    public static class to審査会割当委員EntityListのテスト extends DbeTestBase {

        private List<DbT5106ShinsakaiWariateIinJohoEntity> result;
        private ShinsakaiWariateIinList 割当委員List;

        @Test
        public void 要素数が3件の割当委員が渡されたとき_3件の要素を持つ() {
            割当委員List = ShinsakaiMockBusinessCreator.create審査会割当委員List(1, "19990101", "00000001", "00000002", "00000003");
            result = ShinsakaiWariateIinMapper.to審査会割当委員EntityList(割当委員List);
            assertThat(result.size(), is(3));
        }
    }
}
