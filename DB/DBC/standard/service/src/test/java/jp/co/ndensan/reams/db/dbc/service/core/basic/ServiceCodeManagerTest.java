/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7119ServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7119ServiceCodeDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ServiceCodeManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ServiceCodeManagerTest {

    private static DbT7119ServiceCodeDac dac;
    private static ServiceCodeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7119ServiceCodeDac.class);
        sut = new ServiceCodeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getサービスコード extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー2;
            sut.getサービスコード(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー1;
            sut.getサービスコード(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー2;
            ServiceCode result = sut.getサービスコード(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー2;
            ServiceCode result = sut.getサービスコード(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class getサービスコード一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ServiceCode> result = sut.getサービスコード一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7119ServiceCodeEntity> entityList = Arrays.asList(DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ServiceCode> result = sut.getサービスコード一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7119ServiceCodeEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class saveサービスコード extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(1);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.deleted();

            assertThat(sut.saveサービスコード(サービスコード), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7119ServiceCodeEntity.class))).thenReturn(0);

            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);
            サービスコード = サービスコード.deleted();

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7119ServiceCodeEntity entity = DbT7119ServiceCodeEntityGenerator.createDbT7119ServiceCodeEntity();
            entity.initializeMd5();
            ServiceCode サービスコード = new ServiceCode(entity);

            assertThat(sut.saveサービスコード(サービスコード), is(false));
        }
    }
}
