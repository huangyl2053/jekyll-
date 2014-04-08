/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.Shinsakai;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会Mapperのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiMapperTest {

    private static List<DbT5106ShinsakaiWariateIinJohoEntity> 審査会割当委員EntityList;
    private static ShinsakaiIinList 委員List;
    private static ShinsakaiDetail 審査会情報;
    private static Shinsakai result;

    public static class to審査会_引数のいずれかにnullが渡された場合のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            審査会割当委員EntityList =
                    ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin001", "iin002", "iin003");
            委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin001", "iin002", "iin003");
            審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
        }

        @Test
        public void 審査会割当委員EntityListにnullが渡された場合_返却される値はnullになる() {
            result = ShinsakaiMapper.to審査会(null, 委員List, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 委員Listにnullが渡された場合_返却される値はnullになる() {
            result = ShinsakaiMapper.to審査会(審査会割当委員EntityList, null, 審査会情報);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 審査会情報にnullが渡された場合_返却される値はnullになる() {
            result = ShinsakaiMapper.to審査会(審査会割当委員EntityList, 委員List, null);
            assertThat(result, is(nullValue()));
        }
    }

    public static class to審査会_引数に3件の割当委員_3件の審査会委員_審査会情報が渡された場合のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            審査会割当委員EntityList =
                    ShinsakaiTestEntityCreator.create審査会割当委員情報EntityListSpy(1, "19990101", "iin001", "iin002", "iin003");
            委員List = ShinsakaiTestBusinessCreator.create審査会委員List("iin001", "iin002", "iin003");
            審査会情報 = ShinsakaiTestBusinessCreator.create審査会情報(1, "19990101");
            result = ShinsakaiMapper.to審査会(審査会割当委員EntityList, 委員List, 審査会情報);
        }

        @Test
        public void 返却された審査会が持つ_審査会情報の開催番号は_1になる() {
            assertThat(result.get審査会情報().get審査会開催番号().value(), is(1));
        }

        @Test
        public void 返却された審査会が持つ_割当委員Listの件数は_3になる() {
            assertThat(result.get割当委員List().size(), is(3));
        }
    }
}
