/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import jp.co.ndensan.reams.db.dbe.business.IchijiHanteiResultDetail;
import jp.co.ndensan.reams.db.dbe.business.helper.IchijiHanteiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbe.persistence.basic.IchijiHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 一次判定結果Managerのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiResultManagerTest {

    private static IchijiHanteiResultManager sut;

    public static class get一次判定結果_引数に申請書管理番号を指定した場合のテスト extends DbeTestBase {

        @Test
        public void 一次判定結果が取得できる() {
            sut = new IchijiHanteiResultManager(createDacMock());
            IchijiHanteiResultDetail result = sut.get一次判定結果(new ShinseishoKanriNo(new RString("A001")));
            assertThat(result.get申請書管理番号(), is(new ShinseishoKanriNo(new RString("A001"))));
        }

        private IchijiHanteiKekkaDac createDacMock() {
            IchijiHanteiKekkaDac dac = mock(IchijiHanteiKekkaDac.class);
            DbT5016IchijiHanteiKekkaJohoEntity entity = IchijiHanteiTestEntityCreator.create一次判定結果EntitySpy("A001");
            when(dac.select(any(ShinseishoKanriNo.class))).thenReturn(entity);
            return dac;
        }
    }

    public static class get一次判定結果_引数にDLLからの計算結果を受け取った場合のテスト extends DbeTestBase {

        @Test
        public void 一次判定結果が取得できる() {
            //TODO n8178 城間篤人 DLL計算結果から一次判定を作成する処理ができた後テストを作成する 2014年3月
        }
    }

    public static class saveのテスト extends DbeTestBase {

        @Test
        public void 保存に成功したときtrueが返る() {
            sut = new IchijiHanteiResultManager(createDacMock(1));
            IchijiHanteiResultDetail ichijiHantei = IchijiHanteiTestBusinessCreator.create一次判定結果();
            boolean result = sut.save(ichijiHantei);
            assertThat(result, is(true));
        }

        @Test
        public void 保存に失敗したときfalseが返る() {
            sut = new IchijiHanteiResultManager(createDacMock(0));
            IchijiHanteiResultDetail ichijiHantei = IchijiHanteiTestBusinessCreator.create一次判定結果();
            boolean result = sut.save(ichijiHantei);
            assertThat(result, is(false));
        }

        private IchijiHanteiKekkaDac createDacMock(int 件数) {
            IchijiHanteiKekkaDac dac = mock(IchijiHanteiKekkaDac.class);
            when(dac.insertOrUpdate(any(DbT5016IchijiHanteiKekkaJohoEntity.class))).thenReturn(件数);
            return dac;
        }
    }

    public static class removeのテスト extends DbeTestBase {

        @Test
        public void 削除に成功したときtrueが返る() {
            sut = new IchijiHanteiResultManager(createDacMock(1));
            IchijiHanteiResultDetail ichijiHantei = IchijiHanteiTestBusinessCreator.create一次判定結果();
            boolean result = sut.remove(ichijiHantei);
            assertThat(result, is(true));
        }

        @Test
        public void 削除に失敗したときfalseが返る() {
            sut = new IchijiHanteiResultManager(createDacMock(0));
            IchijiHanteiResultDetail ichijiHantei = IchijiHanteiTestBusinessCreator.create一次判定結果();
            boolean result = sut.remove(ichijiHantei);
            assertThat(result, is(false));
        }

        private IchijiHanteiKekkaDac createDacMock(int 件数) {
            IchijiHanteiKekkaDac dac = mock(IchijiHanteiKekkaDac.class);
            when(dac.delete(any(DbT5016IchijiHanteiKekkaJohoEntity.class))).thenReturn(件数);
            return dac;
        }
    }
}
