/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7908KaigoDonyuKeitaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link KaigoDonyuKeitaiManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoDonyuKeitaiManagerTest {

    private static final DonyuKeitaiCode 導入形態 = DonyuKeitaiCode.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_導入形態コード.value());
    private static final GyomuBunrui 業務分類 = GyomuBunrui.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類);

    private static DbT7908KaigoDonyuKeitaiDac dac;
    private static KaigoDonyuKeitaiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7908KaigoDonyuKeitaiDac.class);
        sut = new KaigoDonyuKeitaiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護導入形態 extends DbxTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数のRStringにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護導入形態(null, 導入形態);
        }

        @Test(expected = NullPointerException.class)
        public void 引数のCodeにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get介護導入形態(業務分類, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(Code.class))).thenReturn(null);
            KaigoDonyuKeitai result = sut.get介護導入形態(業務分類, 導入形態);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            when(dac.selectByKey(any(RString.class), any(Code.class))).thenReturn(entity);

            KaigoDonyuKeitai result = sut.get介護導入形態(業務分類, 導入形態);

            assertThat(result.get業務分類(), is(GyomuBunrui.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類)));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護導入形態一覧 extends DbxTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoDonyuKeitai> result = sut.get介護導入形態一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7908KaigoDonyuKeitaiEntity> entityList = Arrays.asList(DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoDonyuKeitai> result = sut.get介護導入形態一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get業務分類(), is(GyomuBunrui.toValue(DbT7908KaigoDonyuKeitaiEntityGenerator.DEFAULT_業務分類)));
        }
    }

    public static class save介護導入形態 extends DbxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(1);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);

            assertThat(sut.save介護導入形態(介護導入形態), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(0);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);

            assertThat(sut.save介護導入形態(介護導入形態), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(1);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.initializeMd5();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);
            介護導入形態 = 介護導入形態.createBuilderForEdit().set支所管理有無(true).build();

            assertThat(sut.save介護導入形態(介護導入形態), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(0);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.initializeMd5();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);
            介護導入形態 = 介護導入形態.createBuilderForEdit().set支所管理有無(true).build();

            assertThat(sut.save介護導入形態(介護導入形態), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(1);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.initializeMd5();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);
            介護導入形態 = 介護導入形態.deleted();

            assertThat(sut.save介護導入形態(介護導入形態), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7908KaigoDonyuKeitaiEntity.class))).thenReturn(0);

            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.initializeMd5();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);
            介護導入形態 = 介護導入形態.deleted();

            assertThat(sut.save介護導入形態(介護導入形態), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7908KaigoDonyuKeitaiEntity entity = DbT7908KaigoDonyuKeitaiEntityGenerator.createDbT7908KaigoDonyuKeitaiEntity();
            entity.initializeMd5();
            KaigoDonyuKeitai 介護導入形態 = new KaigoDonyuKeitai(entity);

            assertThat(sut.save介護導入形態(介護導入形態), is(false));
        }
    }
}
