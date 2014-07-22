/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.GogitaiDetail;
import jp.co.ndensan.reams.db.dbe.business.ShinsakaiKaisaiBasho;
import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiMockBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.GogitaiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiKaisaiBashoCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5103GogitaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.GogitaiMockEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * 合議体情報Finderのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class GogitaiDetailFinderTest {

    private static GogitaiDetailFinder sut;

    public static class get合議体情報のテスト extends DbeTestBase {

        private GogitaiDetail result;

        @Before
        public void setUp() {
            sut = new GogitaiDetailFinder(create合議体情報DacMock(), create開催場所マネージャMock());
            result = sut.get合議体情報(new GogitaiNo(1), new FlexibleDate("19990724"));
        }

        @Test
        public void 合議体番号1_基準年月日19990724を指定したとき_合議体番号に1を持つ合議体情報が取得できる() {
            assertThat(result.get合議体番号(), is(new GogitaiNo(1)));
        }

        @Test
        public void 合議体番号1_基準年月日19990724を指定したとき_合議体有効期間開始年月日に19990101を持つ合議体情報が取得できる() {
            assertThat(result.get有効期間開始年月日().value(), is(new FlexibleDate("19990101")));
        }

        @Test
        public void 合議体番号1_基準年月日19990724を指定したとき_合議体有効期間終了年月日に19991231を持つ合議体情報が取得できる() {
            assertThat(result.get有効期間終了年月日(), is(new FlexibleDate("19991231")));
        }

        private GogitaiJohoDac create合議体情報DacMock() {
            GogitaiJohoDac 合議体情報Dac = mock(GogitaiJohoDac.class);
            DbT5103GogitaiJohoEntity 合議体情報 = GogitaiMockEntityCreator.create合議体情報Entity(1, "19990101", "19991231", "basho01");
            when(合議体情報Dac.select(any(GogitaiNo.class), any(FlexibleDate.class))).thenReturn(合議体情報);
            return 合議体情報Dac;
        }

        private ShinsakaiKaisaiBashoManager create開催場所マネージャMock() {
            ShinsakaiKaisaiBashoManager 開催場所Manager = mock(ShinsakaiKaisaiBashoManager.class);
            ShinsakaiKaisaiBasho 開催場所 = ShinsakaiMockBusinessCreator.create審査会開催場所("basho01");
            when(開催場所Manager.get審査会開催場所(any(ShinsakaiKaisaiBashoCode.class))).thenReturn(開催場所);
            return 開催場所Manager;
        }
    }
}
