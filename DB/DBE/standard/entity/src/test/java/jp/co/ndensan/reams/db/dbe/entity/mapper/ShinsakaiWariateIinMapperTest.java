/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIin;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiWariateIinList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
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

        @Before
        public void setUp() {
            審査会割当委員Entity = ShinsakaiTestEntityCreator.create審査会割当委員情報EntitySpy(1, "19990101", "iin01");
            委員 = ShinsakaiTestBusinessCreator.create審査会委員("iin01");
            審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, 委員, 審査会情報);
        }

        @Test
        public void 審査会割当委員Entityにnullが渡されたとき_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(null, 委員, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 委員にnullが渡されたとき_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, null, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 審査会情報にnullが渡されたとき_nullが返却される() {
            result = ShinsakaiWariateIinMapper.to審査会割当委員(審査会割当委員Entity, 委員, null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査会情報の開催番号は_1になる() {
            assertThat(result.get審査会情報().get審査会開催番号().value(), is(1));
        }

        @Test
        public void 返却された審査会割当委員が持つ_委員情報の委員コードは_iin01になる() {
            assertThat(result.get委員情報().get委員コード().value(), is(new RString("iin01")));
        }

        @Test
        public void 返却された審査会割当委員が持つ_認定審査員区分の区分コードは_shinsain01になる() {
            assertThat(result.get認定審査員区分().getCode(), is(new Code("shinsain01")));
        }

        @Test
        public void 返却された審査会割当委員が持つ_合議体長区分の区分コードは_gogitaicho01になる() {
            assertThat(result.get合議体長区分().getCode(), is(new Code("gogitaicho01")));
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査時間の開始は_0830になる() {
            assertThat(result.get審査時間().getFrom(), is(new TimeString("0830")));
        }

        @Test
        public void 返却された審査会割当委員が持つ_審査時間の終了は_1720になる() {
            assertThat(result.get審査時間().getTo(), is(new TimeString("1720")));
        }

        @Test
        public void 返却された審査会割当委員が持つ_出欠区分の区分コードは_1になる() {
            assertThat(result.get出欠区分().get出欠区分コード(), is(new RString("1")));
        }
    }

    public static class to審査会割当委員Listのテスト extends DbeTestBase {

        private List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList;
        private ShinsakaiIinList 委員List;
        private ShinsakaiDetail 審査会情報;
        private ShinsakaiWariateIinList result;

        @Before
        public void setUp() {
            審査会割当委員EntityList =
                    ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin001", "iin002", "iin003");
            委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin001", "iin002", "iin003");
            審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
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
            審査会割当委員EntityList =
                    ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin001", "iin002", "iin003");
            委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin001", "iin002");
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);
        }

        @Test(expected = IllegalArgumentException.class)
        public void 割当委員EntityListと委員Listの要素間に_委員コードが一致しない要素が存在するとき_IllegalArgumentExceptionが発生する() {
            審査会割当委員EntityList =
                    ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin01", "iin04", "iin03");
            委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin001", "iin002", "iin003");
            result = ShinsakaiWariateIinMapper.to審査会割当委員List(審査会割当委員EntityList, 委員List, 審査会情報);
        }
    }

    public static class to審査員割当委員Entityのテスト extends DbeTestBase {

        private DbT5106ShinsakaiWariateIinJohoEntity result;
        private ShinsakaiWariateIin 割当委員;

        @Before
        public void setUp() {
            割当委員 = ShinsakaiTestBusinessCreator.create審査会割当委員(1, "19990101", "iin01");
            result = ShinsakaiWariateIinMapper.to審査員割当委員Entity(割当委員);
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査会開催番号は_1になる() {
            assertThat(result.getShinsakaiKaisaiNo(), is(1));
        }

        @Test
        public void 返却された割当委員Entityが持つ_開催年月日は_19990101になる() {
            assertThat(result.getShinsakaiKaisaiYMD(), is(new FlexibleDate("19990101")));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査会委員コードは_iin01になる() {
            assertThat(result.getShinsakaiIinCode(), is(new RString("iin01")));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査員区分コードは_S001になる() {
            assertThat(result.getShinsainKubunCode().value(), is(new RString("S001")));
        }

        @Test
        public void 返却された割当委員Entityが持つ合議体長区分コード_は_G001になる() {
            assertThat(result.getGogitaichoKubunCode().value(), is(new RString("G001")));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査開始時間は_0000になる() {
            assertThat(result.getShinsakaiIinShinsaKaishiTime(), is(new RString("0000")));
        }

        @Test
        public void 返却された割当委員Entityが持つ_審査終了時間は_2359になる() {
            assertThat(result.getShinsakaiIinshinsaShuryoTime(), is(new RString("2359")));
        }

        @Test
        public void 返却された割当委員Entityが持つ_委員出欠区分は_出席を表す1になる() {
            assertThat(result.getShinsakaiIinShukketsuKubun(), is(new RString("1")));
        }
    }

    public static class to審査会割当委員EntityListのテスト extends DbeTestBase {

        private List<DbT5106ShinsakaiWariateIinJohoEntity> result;
        private ShinsakaiWariateIinList 割当委員List;

        @Test
        public void 要素数が3件の割当委員が渡されたとき_3件の要素を持つ() {
            割当委員List = ShinsakaiTestBusinessCreator.create審査会割当委員List(1, "19990101", "iin01", "iin02", "iin03");
            result = ShinsakaiWariateIinMapper.to審査会割当委員EntityList(割当委員List);
            assertThat(result.size(), is(3));
        }
    }
}
