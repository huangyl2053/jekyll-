/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RendoPattern;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7035RendoPatternDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link RendoPatternManager}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class RendoPatternManagerTest {

    private static DbT7035RendoPatternDac dac;
    private static RendoPatternManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7035RendoPatternDac.class);
        sut = new RendoPatternManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連動パターン extends DbzTestBase {

        LasdecCode 送信元市町村コード = DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード;
        LasdecCode 送信先市町村コード = DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード;
        RString 種別 = DbT7035RendoPatternEntityGenerator.DEFAULT_種別;
        FlexibleDate 有効開始年月日 = DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日;
        FlexibleDate 有効終了年月日 = DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日;

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の送信元市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get連動パターン(null, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の送信先市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.get連動パターン(送信元市町村コード, null, 種別, 有効開始年月日, 有効終了年月日);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(LasdecCode.class), any(LasdecCode.class), any(RString.class), any(FlexibleDate.class), any(FlexibleDate.class))).thenReturn(null);

            RendoPattern result = sut.get連動パターン(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            when(dac.selectByKey(any(LasdecCode.class), any(LasdecCode.class), any(RString.class), any(FlexibleDate.class), any(FlexibleDate.class))).thenReturn(entity);

            RendoPattern result = sut.get連動パターン(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);

            assertThat(result.get送信元市町村コード().value(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get連動パターン一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<RendoPattern> result = sut.get連動パターン一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7035RendoPatternEntity> entityList = Arrays.asList(DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<RendoPattern> result = sut.get連動パターン一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get送信元市町村コード().value(), is(DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード.value()));
        }
    }

    public static class save連動パターン extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(1);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPattern 連動パターン = new RendoPattern(entity);

            assertThat(sut.save連動パターン(連動パターン), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(0);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            RendoPattern 連動パターン = new RendoPattern(entity);

            assertThat(sut.save連動パターン(連動パターン), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(1);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.initializeMd5();
            RendoPattern 連動パターン = new RendoPattern(entity);
            連動パターン = 連動パターン.createBuilderForEdit().set種別(new RString("種別を変更")).build();

            assertThat(sut.save連動パターン(連動パターン), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(0);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.initializeMd5();
            RendoPattern 連動パターン = new RendoPattern(entity);
            連動パターン = 連動パターン.createBuilderForEdit().set種別(new RString("種別を変更")).build();

            assertThat(sut.save連動パターン(連動パターン), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(1);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.initializeMd5();
            RendoPattern 連動パターン = new RendoPattern(entity);
            連動パターン = 連動パターン.deleted();

            assertThat(sut.save連動パターン(連動パターン), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7035RendoPatternEntity.class))).thenReturn(0);

            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.initializeMd5();
            RendoPattern 連動パターン = new RendoPattern(entity);
            連動パターン = 連動パターン.deleted();

            assertThat(sut.save連動パターン(連動パターン), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7035RendoPatternEntity entity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
            entity.initializeMd5();
            RendoPattern 連動パターン = new RendoPattern(entity);

            assertThat(sut.save連動パターン(連動パターン), is(false));
        }
    }
}
