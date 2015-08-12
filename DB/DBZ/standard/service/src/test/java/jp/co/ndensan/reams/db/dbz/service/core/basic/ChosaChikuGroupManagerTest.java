/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosaChikuGroup;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5225ChosaChikuGroupDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {link ChosaChikuGroupManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosaChikuGroupManagerTest {

    private static DbT5225ChosaChikuGroupDac dac;
    private static ChosaChikuGroupManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT5225ChosaChikuGroupDac.class);
        sut = new ChosaChikuGroupManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get調査地区グループマスタ extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            LasdecCode 主キー2 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
            sut.get調査地区グループマスタ(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            Code 主キー1 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
            sut.get調査地区グループマスタ(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(Code.class), any(LasdecCode.class))).thenReturn(null);
            Code 主キー1 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
            LasdecCode 主キー2 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
            ChosaChikuGroup result = sut.get調査地区グループマスタ(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            when(dac.selectByKey(any(Code.class), any(LasdecCode.class))).thenReturn(entity);
            Code 主キー1 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
            LasdecCode 主キー2 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
            ChosaChikuGroup result = sut.get調査地区グループマスタ(主キー1, 主キー2);

            assertThat(result.get調査地区グループコード().value(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get調査地区グループマスタ一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ChosaChikuGroup> result = sut.get調査地区グループマスタ一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT5225ChosaChikuGroupEntity> entityList = Arrays.asList(DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ChosaChikuGroup> result = sut.get調査地区グループマスタ一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get調査地区グループコード().value(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード.value()));
        }
    }

    public static class save調査地区グループマスタ extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(1);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(0);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(1);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            entity.initializeMd5();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);
            調査地区グループマスタ = 調査地区グループマスタ.createBuilderForEdit().set調査地区グループ名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(0);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            entity.initializeMd5();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);
            調査地区グループマスタ = 調査地区グループマスタ.createBuilderForEdit().set調査地区グループ名称(new RString("任意項目1を変更")).build();

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(1);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            entity.initializeMd5();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);
            調査地区グループマスタ = 調査地区グループマスタ.deleted();

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT5225ChosaChikuGroupEntity.class))).thenReturn(0);

            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            entity.initializeMd5();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);
            調査地区グループマスタ = 調査地区グループマスタ.deleted();

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT5225ChosaChikuGroupEntity entity = DbT5225ChosaChikuGroupEntityGenerator.createDbT5225ChosaChikuGroupEntity();
            entity.initializeMd5();
            ChosaChikuGroup 調査地区グループマスタ = new ChosaChikuGroup(entity);

            assertThat(sut.save調査地区グループマスタ(調査地区グループマスタ), is(false));
        }
    }
}
