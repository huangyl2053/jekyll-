/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5101ShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5106ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会と、そこに割り当てられた審査会委員の情報を扱うDacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiAndShinskaiWariateIinDacTest {

    private static ShinsakaiAndShinskaiWariateIinDac sut;
    private static DbT5101ShinsakaiJohoEntity 審査会Entity;
    private static List<DbT5106ShinsakaiWariateIinJohoEntity> 割当委員EntityList;

    @BeforeClass
    public static void setUpClass() {
        sut = new ShinsakaiAndShinskaiWariateIinDac();
    }

    public static class insertOrUpdateのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            審査会Entity = ShinsakaiMockEntityCreator.create審査会情報Entity(1, "19990101");
            割当委員EntityList = ShinsakaiMockEntityCreator.create審査会割当委員情報EntityList(1, "19990101",
                    "00000001", "00000002", "00000003", "00000004", "00000005");
        }

        @Test
        public void 割当委員を5件持つ審査会を更新したとき_総更新件数として6が返る() {
            assertThat(sut.insertOrUpdate(審査会Entity, 割当委員EntityList), is(6));
        }
    }

    public static class deleteのテスト extends DbeTestDacBase {

        @Before
        public void setUp() {
            審査会Entity = ShinsakaiMockEntityCreator.create審査会情報Entity(1, "19990101");
            割当委員EntityList = ShinsakaiMockEntityCreator.create審査会割当委員情報EntityList(1, "19990101",
                    "00000001", "00000002", "00000003", "00000004", "00000005", "00000006");
            sut.insertOrUpdate(審査会Entity, 割当委員EntityList);
        }

        @Test
        public void 割当委員を5件持つ審査会を削除したとき_総削除件数として7が返る() {
            assertThat(sut.delete(審査会Entity, 割当委員EntityList), is(7));
        }
    }
}
