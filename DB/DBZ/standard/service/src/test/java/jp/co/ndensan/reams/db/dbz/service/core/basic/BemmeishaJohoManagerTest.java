/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.BemmeishaJoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7003BemmeishaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7003BemmeishaJohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link BemmeishaJohoManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class BemmeishaJohoManagerTest {

    private static DbT7003BemmeishaJohoDac dac;
    private static BemmeishaJohoManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7003BemmeishaJohoDac.class);
        sut = new BemmeishaJohoManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明者情報 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のShoKisaiHokenshaNoにnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー2 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
            sut.get弁明者情報(null, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のShikibetsuCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            ShoKisaiHokenshaNo 主キー1 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
            sut.get弁明者情報(主キー1, null, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class),
                    any(HihokenshaNo.class), any(FlexibleDate.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(null);

            ShoKisaiHokenshaNo 主キー1 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
            BemmeishaJoho result = sut.get弁明者情報(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            when(dac.selectByKey(any(ShoKisaiHokenshaNo.class), any(ShikibetsuCode.class),
                    any(HihokenshaNo.class), any(FlexibleDate.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(entity);

            ShoKisaiHokenshaNo 主キー1 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号;
            ShikibetsuCode 主キー2 = DbT7003BemmeishaJohoEntityGenerator.DEFAULT_識別コード;
            BemmeishaJoho result = sut.get弁明者情報(主キー1, 主キー2, HihokenshaNo.EMPTY, FlexibleDate.MAX, FlexibleDate.MAX, Decimal.ZERO);

            assertThat(result.get証記載保険者番号().value(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get弁明者情報一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<BemmeishaJoho> result = sut.get弁明者情報一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7003BemmeishaJohoEntity> entityList = Arrays.asList(DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<BemmeishaJoho> result = sut.get弁明者情報一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get証記載保険者番号().value(), is(DbT7003BemmeishaJohoEntityGenerator.DEFAULT_証記載保険者番号.value()));
        }
    }

    public static class save弁明者情報 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(1);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);

            assertThat(sut.save弁明者情報(弁明者情報), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(0);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);

            assertThat(sut.save弁明者情報(弁明者情報), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(1);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.initializeMd5();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);
            弁明者情報 = 弁明者情報.createBuilderForEdit().set役職名(new RString("任意項目1を変更")).build();

            assertThat(sut.save弁明者情報(弁明者情報), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(0);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.initializeMd5();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);
            弁明者情報 = 弁明者情報.createBuilderForEdit().set役職名(new RString("任意項目1を変更")).build();

            assertThat(sut.save弁明者情報(弁明者情報), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(1);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.initializeMd5();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);
            弁明者情報 = 弁明者情報.deleted();

            assertThat(sut.save弁明者情報(弁明者情報), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7003BemmeishaJohoEntity.class))).thenReturn(0);

            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.initializeMd5();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);
            弁明者情報 = 弁明者情報.deleted();

            assertThat(sut.save弁明者情報(弁明者情報), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7003BemmeishaJohoEntity entity = DbT7003BemmeishaJohoEntityGenerator.createDbT7003BemmeishaJohoEntity();
            entity.initializeMd5();
            BemmeishaJoho 弁明者情報 = new BemmeishaJoho(entity);

            assertThat(sut.save弁明者情報(弁明者情報), is(false));
        }
    }
}
