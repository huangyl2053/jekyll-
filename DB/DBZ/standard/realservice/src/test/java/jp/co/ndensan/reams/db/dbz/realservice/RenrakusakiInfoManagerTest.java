/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.helper.KaigoRenrakusakiMock;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.RenrakusakiInfoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * RenrakusakiInfoManagerのテストです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class RenrakusakiInfoManagerTest extends DbzTestBase {

    private static RenrakusakiInfoManager sut;
    private static final int 成功 = 1;
    private static final int 失敗 = 0;

    public static class save {

        @Test
        public void saveに失敗した場合_falseを返す() {

            sut = new RenrakusakiInfoManager(createDacMock(失敗));

            assertThat(sut.save(KaigoRenrakusakiMock.create介護連絡先()), is(false));
        }

        @Test
        public void saveに成功した場合_trueを返す() {

            sut = new RenrakusakiInfoManager(createDacMock(成功));

            assertThat(sut.save(KaigoRenrakusakiMock.create介護連絡先()), is(true));
        }

        @Test
        public void deleteに失敗した場合_falseを返す() {

            sut = new RenrakusakiInfoManager(createDacMock(失敗));

            assertThat(sut.remove(KaigoRenrakusakiMock.create介護連絡先()), is(false));
        }

        @Test
        public void deleteに成功した場合_trueを返す() {

            sut = new RenrakusakiInfoManager(createDacMock(成功));

            assertThat(sut.remove(KaigoRenrakusakiMock.create介護連絡先()), is(true));
        }

        private RenrakusakiInfoDac createDacMock(int flg) {
            RenrakusakiInfoDac 連絡先情報dac = mock(RenrakusakiInfoDac.class);
            //DbT5050RenrakusakiJohoEntity entity = RenrakusakiJohoEntityMock.create連絡先情報Entity();

            when(連絡先情報dac.insertOrUpdate(any(DbT5050RenrakusakiJohoEntity.class))).thenReturn(flg);
            when(連絡先情報dac.delete(any(DbT5050RenrakusakiJohoEntity.class))).thenReturn(flg);
            return 連絡先情報dac;

        }
    }

}
