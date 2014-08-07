/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.TeikeibunJohoEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 定型文情報データアクセスクラスのテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
@RunWith(Enclosed.class)
public class KaigoTeikeibunDacTest extends DbzTestDacBase {

    private static KaigoTeikeibunDac sut;
    private static final int 成功 = 1;
    private static final RString 区分 = new RString("1");
    private static final RString notFound区分 = new RString("2");
    private static final RString 区分2 = new RString("0");
    private static final RString 種別 = new RString("100");
    private static final RString notFound種別 = new RString("200");
    private static final RString コード = new RString("0001");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KaigoTeikeibunDac.class);
    }

    public static class insert extends DbzTestDacBase {

        @Test
        public void 定型文情報テーブルに対して_1件のデータを挿入したとき_1を返す() {
            int result = sut.insert(TeikeibunJohoEntityMock.create定型文情報Entity());
            assertThat(result, is(成功));
        }
    }

    public static class update extends DbzTestDacBase {

        @Test
        public void 定型文情報テーブルに対して_対象データを更新したとき_1を返す() {
            sut.insert(TeikeibunJohoEntityMock.create定型文情報Entity());
            DbT7103TeikeibunJohoEntity entity
                    = TeikeibunJohoEntityMock.create定型文情報Entity();
            entity.setTeikeibunNaiyo(new RString("定型文更新テスト"));

            int result = sut.update(entity);
            assertThat(result, is(成功));
        }

        @Test
        public void 更新に成功し_対象データの内容が_更新テスト成功に変更される() {
            sut.insert(TeikeibunJohoEntityMock.create定型文情報Entity());
            DbT7103TeikeibunJohoEntity entity
                    = TeikeibunJohoEntityMock.create定型文情報Entity();

            entity.setTeikeibunNaiyo(new RString("定型文更新テスト成功"));

            sut.update(entity);
            assertThat(sut.select(区分, 種別, コード).getTeikeibunNaiyo(),
                    is(new RString("定型文更新テスト成功")));
        }
    }

    public static class delete extends DbzTestDacBase {

        @Before
        public void setUp() {
            createEntityForDelete();
        }

        @Test
        public void 削除対象のデータが存在しているとき_対象データを削除すると_1が返る() {
            int result = sut.delete(TeikeibunJohoEntityMock.create定型文情報Entity());
            assertThat(result, is(成功));
        }

        @Test
        public void 既に物理削除したデータを取得しようとしたとき_nullが返る() {
            sut.delete(TeikeibunJohoEntityMock.create定型文情報Entity());
            DbT7103TeikeibunJohoEntity result = sut.select(区分, 種別, コード);
            assertThat(result, nullValue());
        }

        private static void createEntityForDelete() {
            DbT7103TeikeibunJohoEntity entity
                    = TeikeibunJohoEntityMock.create定型文情報Entity();

            sut.insert(entity);
        }
    }

    public static class select区分 extends DbzTestDacBase {

        @Before
        public void setUp() {
            createEntityForInsert();
        }

        @Test
        public void 指定する区分に対応するデータがない時_select区分は_空のリストを返す() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(notFound区分);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定する区分に対応するデータが存在する時_検索結果の区分は_検索条件の区分と一致する() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(区分);
            assertThat(result.get(0).getTeikeiKubun(), is(区分));
        }
    }

    public static class select区分_種別 extends DbzTestDacBase {

        @Before
        public void setUp() {
            createEntityForInsert();
        }

        @Test
        public void 指定する区分に対応するデータがない時_select区分_種別は_空のリストを返す() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(notFound区分, 種別);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定する種別に対応するデータがない時_select区分_種別は_空のリストを返す() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(区分, notFound種別);
            assertThat(result, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 指定する区分_種別に対応するデータが１件存在する時_select区分_種別は_１件のリストを返す() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(区分, 種別);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 指定する区分_種別に対応するデータが２件存在する時_select区分_種別は_２件のリストを返す() {
            List<DbT7103TeikeibunJohoEntity> result = sut.select(区分2, 種別);
            assertThat(result.size(), is(2));
        }
    }

    public static class select区分_種別_コード extends DbzTestDacBase {

        @Before
        public void setUp() {
            createEntityForInsert();
        }

        @Test
        public void 指定する区分_種別_コードに対応するデータがない時_select区分_種別_コードは_nullを返す() {
            DbT7103TeikeibunJohoEntity result = sut.select(notFound区分, 種別, コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 指定する区分_種別_コードに対応するデータが存在する時_select区分_種別_コードは_定型文Entityデータを返す() {
            DbT7103TeikeibunJohoEntity result = sut.select(区分, 種別, コード);
            assertThat(result, instanceOf(DbT7103TeikeibunJohoEntity.class));
        }

    }

    private static void createEntityForInsert() {
        DbT7103TeikeibunJohoEntity entity
                = TeikeibunJohoEntityMock.create定型文情報Entity();

        entity.setTeikeiKubun(区分);
        entity.setShubetsu(種別);
        sut.insert(entity);

        entity.setTeikeiKubun(区分2);
        sut.insert(entity);

        entity.setTeikeibunCd(new RString("0002"));
        sut.insert(entity);
    }
}
