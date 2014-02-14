/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.mapper.ShujiiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IShujiiDac;
import jp.co.ndensan.reams.db.dbe.realservice.helper.KaigoDoctorEntityMock;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 主治医情報を管理するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiManagerTest {

    public static class save {

        @Test
        public void 主治医情報の保存が成功した時_saveは_TRUEを返す() {
            assertThat(createShujiiManager(1).save(createShujii()), is(true));
        }

        @Test
        public void 主治医情報の保存が失敗した時_saveは_FALSEを返す() {
            assertThat(createShujiiManager(0).save(createShujii()), is(false));
        }
    }

    public static class saveAs有効 {

        @Test
        public void 主治医情報の保存が成功した時_saveAs有効は_TRUEを返す() {
            assertThat(createShujiiManager(1).saveAs有効(createShujii()), is(true));
        }

        @Test
        public void 主治医情報の保存が失敗した時_saveAs有効は_FALSEを返す() {
            assertThat(createShujiiManager(0).saveAs有効(createShujii()), is(false));
        }
    }

    public static class saveAs無効 {

        @Test
        public void 主治医情報の保存が成功した時_saveAs無効は_TRUEを返す() {
            assertThat(createShujiiManager(1).saveAs無効(createShujii()), is(true));
        }

        @Test
        public void 主治医情報の保存が失敗した時_saveAs無効は_FALSEを返す() {
            assertThat(createShujiiManager(0).saveAs無効(createShujii()), is(false));
        }
    }

    public static class saveAsNew {

        @Test
        public void 主治医情報の保存が成功した時_saveAsNewは_TRUEを返す() {
            assertThat(createShujiiManager(1).saveAsNew(createShujii()), is(true));
        }

        @Test
        public void 主治医情報の保存が失敗した時_saveAsNewは_FALSEを返す() {
            assertThat(createShujiiManager(0).saveAsNew(createShujii()), is(false));
        }
    }

    public static class remove {

        @Test
        public void 主治医情報の削除が成功した時_removeは_TRUEを返す() {
            assertThat(createShujiiManager(1).remove(createShujii()), is(true));
        }

        @Test
        public void 主治医情報の削除が失敗した時_removeは_FALSEを返す() {
            assertThat(createShujiiManager(0).remove(createShujii()), is(false));
        }
    }

    private static IShujiiManager createShujiiManager(int flg) {
        IShujiiDac dac = mock(IShujiiDac.class);
        when(dac.insertOrUpdate(any(DbT7012ShujiiJohoEntity.class))).thenReturn(flg);
        when(dac.insert(any(DbT7012ShujiiJohoEntity.class))).thenReturn(flg);
        when(dac.delete(any(DbT7012ShujiiJohoEntity.class))).thenReturn(flg);
        return new ShujiiManager(dac);
    }

    private static IShujii createShujii() {
        return ShujiiMapper.toShujii(KaigoDoctorEntityMock.getSpiedInstance().getDbT7012ShujiiJohoEntity());
    }
}
