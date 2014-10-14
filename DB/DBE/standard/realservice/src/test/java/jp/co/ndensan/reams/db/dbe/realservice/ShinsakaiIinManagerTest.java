/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiIinList;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5102ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShinsakaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.ShinsakaiIinDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 審査会委員の管理を行うクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinManagerTest {

    private static ShinsakaiIinManager sut;

    public static class get審査会委員Listのテスト extends DbeTestBase {

        @Test
        public void dummyTest() {
            //TODO n8178 城間篤人 審査会関連本実装の際に記述予定 2014年9月
        }
    }

    public static class get審査会委員のテスト extends DbeTestBase {

        @Test
        public void dummyTest() {
            //TODO n8178 城間篤人 審査会関連本実装の際に記述予定 2014年9月
        }
    }

    public static class get有効審査会委員Listのテスト extends DbeTestBase {

        @Before
        public void setUp() {
            ShinsakaiIinDac dacMock = mock(ShinsakaiIinDac.class);
            List<DbT5102ShinsakaiIinJohoEntity> list = create審査会委員EntityList();
            when(dacMock.select有効審査会委員List()).thenReturn(list);
            sut = new ShinsakaiIinManager(dacMock);
        }

        @Test
        public void Dacから2件の有効な審査会委員Entityが返るとき_get有効審査会委員Listの戻り値は_2件の要素を持つ審査会委員Listになる() {
            ShinsakaiIinList result = sut.get有効審査会委員List();
            assertThat(result.size(), is(2));
        }

        private List<DbT5102ShinsakaiIinJohoEntity> create審査会委員EntityList() {
            List<DbT5102ShinsakaiIinJohoEntity> list = new ArrayList<>();
            list.add(ShinsakaiMockEntityCreator.create審査会委員EntitySpy("00000001", true));
            list.add(ShinsakaiMockEntityCreator.create審査会委員EntitySpy("00000004", true));
            return list;
        }
    }

}
