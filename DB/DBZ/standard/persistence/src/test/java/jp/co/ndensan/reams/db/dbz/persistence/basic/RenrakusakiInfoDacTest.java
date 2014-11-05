/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.RenrakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.util.db._SQLOptimisticLockFaildException;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 * 連絡先情報データアクセスクラスのテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class RenrakusakiInfoDacTest extends DbzTestDacBase {

    private static RenrakusakiInfoDac sut;
    private static final int 成功 = 1;
    private static final int 失敗 = 0;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(RenrakusakiInfoDac.class);
    }

    public static class insert extends DbzTestDacBase {

        @Test
        public void 連絡先情報テーブルに対して_1件のデータを挿入したとき_1を返す() {
            int result = sut.insert(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            assertThat(result, is(成功));
        }

        @Test(expected = SystemException.class)
        public void 連絡先情報テーブルに対して_既に存在するデータを挿入したとき_0を返す() {
            sut.insert(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            int result = sut.insert(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            assertThat(result, is(失敗));
        }
    }

    public static class update extends DbzTestDacBase {

        private static final ShoKisaiHokenshaNo 保険者番号 = new ShoKisaiHokenshaNo(
                new RString("123456"));
        private static final KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(
                new RString("1111111111"));
        private static final KaigoHihokenshaNo notFount被保番号 = new KaigoHihokenshaNo(
                new RString("9999999999"));

        @Test
        public void 連絡先情報テーブルに対して_対象データを更新したとき_1を返す() {
            sut.insert(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();
            entity.setRenrakusakiShimei(new AtenaMeisho("更新　てすと"));

            int result = sut.update(entity);
            assertThat(result, is(成功));
        }

        @Test
        public void 更新に成功し_対象データの氏名が_更新テスト成功に変更される() {
            sut.insert(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();
            entity.setRenrakusakiShimei(new AtenaMeisho("更新テスト成功"));

            sut.update(entity);

            assertThat(sut.select(保険者番号, 被保番号).get(0).getRenrakusakiShimei(),
                    is(new AtenaMeisho("更新テスト成功")));
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void 指定した連絡先情報が存在しないとき_更新に失敗する() {

            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();
            entity.setHihokenshaNo(notFount被保番号);

            int result = sut.update(entity);
            assertThat(result, is(失敗));
        }
    }

    public static class delete extends DbzTestDacBase {

        private static final ShoKisaiHokenshaNo 保険者番号 = new ShoKisaiHokenshaNo(
                new RString("123456"));
        private static final KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(
                new RString("1111111111"));
        private static final KaigoHihokenshaNo notFount被保番号 = new KaigoHihokenshaNo(
                new RString("9999999999"));

        @Before
        public void setUp() {
            createEntityForDelete();
        }

        @Test
        public void 削除対象のデータが存在しているとき_対象データを削除すると_1が返る() {
            int result = sut.delete(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            assertThat(result, is(成功));
        }

        @Test
        public void 既に物理削除したデータを取得しようとしたとき_空のリストが返る() {
            sut.delete(RenrakusakiJohoEntityMock.create連絡先情報Entity());
            List<DbT5050RenrakusakiJohoEntity> result = sut.select(保険者番号, 被保番号);
            assertThat(result.isEmpty(), is(true));
        }

        @Test(expected = _SQLOptimisticLockFaildException.class)
        public void 指定した連絡先情報が存在しないとき_削除に失敗する() {

            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();

            entity.setHihokenshaNo(notFount被保番号);

            int result = sut.delete(entity);
            assertThat(result, is(失敗));
        }

        private static void createEntityForDelete() {
            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();

            sut.insert(entity);
        }
    }

    public static class select保険者番号_被保番号 extends DbzTestDacBase {

        private static final ShoKisaiHokenshaNo 保険者番号 = new ShoKisaiHokenshaNo(
                new RString("123456"));
        private static final KaigoHihokenshaNo 被保番号 = new KaigoHihokenshaNo(
                new RString("1234567890"));

        private static final ShoKisaiHokenshaNo 保険者番号2 = new ShoKisaiHokenshaNo(
                new RString("987654"));
        private static final KaigoHihokenshaNo 被保番号2 = new KaigoHihokenshaNo(
                new RString("9876543210"));

        @Before
        public void setUp() {
            createEntityForInsert保険者番号_被保番号();
        }

        @Test
        public void 指定する保険者番号に対応するデータがない時_select保険者番号_被保番号は_空のリストを返す() {
            ShoKisaiHokenshaNo notFound保険者番号 = new ShoKisaiHokenshaNo(new RString("111111"));
            List<DbT5050RenrakusakiJohoEntity> result = sut.select(notFound保険者番号, 被保番号);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定する被保険者番号に対応するデータがない時_select保険者番号_被保番号は_空のリストを返す() {
            KaigoHihokenshaNo notFound被保番号 = new KaigoHihokenshaNo(new RString("1111111110"));
            List<DbT5050RenrakusakiJohoEntity> result = sut.select(保険者番号, notFound被保番号);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 保険者番号_被保険者番号に対応するデータが１件存在する時_select保険者番号_被保番号は_１件のリストを返す() {
            List<DbT5050RenrakusakiJohoEntity> result = sut.select(保険者番号, 被保番号);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 保険者番号_被保険者番号に対応するデータが２件存在する時_select保険者番号_被保番号は_２件のリストを返す() {
            List<DbT5050RenrakusakiJohoEntity> result = sut.select(保険者番号2, 被保番号2);
            assertThat(result.size(), is(2));
        }

        static void createEntityForInsert保険者番号_被保番号() {
            DbT5050RenrakusakiJohoEntity entity
                    = RenrakusakiJohoEntityMock.create連絡先情報Entity();

            entity.setShoKisaiHokenshaNo(保険者番号);
            entity.setHihokenshaNo(被保番号);
            sut.insert(entity);

            entity.setShoKisaiHokenshaNo(保険者番号2);
            entity.setHihokenshaNo(被保番号2);
            sut.insert(entity);

            entity.setShoKisaiHokenshaNo(保険者番号2);
            entity.setHihokenshaNo(被保番号2);
            entity.setRenrakusakiKubunNo(new RString("00000002"));
            sut.insert(entity);
        }
    }
}
