/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoKettei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link JutakuKaishuRiyushoTesuryoKetteiManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JutakuKaishuRiyushoTesuryoKetteiManagerTest {

    private static DbT3094JutakuKaishuRiyushoTesuryoKetteiDac dac;
    private static JutakuKaishuRiyushoTesuryoKetteiManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3094JutakuKaishuRiyushoTesuryoKetteiDac.class);
        sut = new JutakuKaishuRiyushoTesuryoKetteiManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get住宅改修理由書作成手数料請求決定 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            FlexibleDate 主キー2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
            Decimal 主キー3 = new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号);
            sut.get住宅改修理由書作成手数料請求決定(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
            Decimal 主キー3 = new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号);
            sut.get住宅改修理由書作成手数料請求決定(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            JigyoshaNo 主キー1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
            FlexibleDate 主キー2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
            sut.get住宅改修理由書作成手数料請求決定(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(JigyoshaNo.class), any(FlexibleDate.class), any(int.class))).thenReturn(null);

            JigyoshaNo 主キー1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
            FlexibleDate 主キー2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
            Decimal 主キー3 = new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号);
            JutakuKaishuRiyushoTesuryoKettei result = sut.get住宅改修理由書作成手数料請求決定(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            when(dac.selectByKey(any(JigyoshaNo.class), any(FlexibleDate.class), any(int.class))).thenReturn(entity);

            JigyoshaNo 主キー1 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号;
            FlexibleDate 主キー2 = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_決定年月日;
            Decimal 主キー3 = new Decimal(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_履歴番号);
            JutakuKaishuRiyushoTesuryoKettei result = sut.get住宅改修理由書作成手数料請求決定(主キー1, 主キー2, 主キー3);

            assertThat(result.get介護住宅改修理由書作成事業者番号().value(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get住宅改修理由書作成手数料請求決定一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<JutakuKaishuRiyushoTesuryoKettei> result = sut.get住宅改修理由書作成手数料請求決定一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> entityList = Arrays.asList(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<JutakuKaishuRiyushoTesuryoKettei> result = sut.get住宅改修理由書作成手数料請求決定一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get介護住宅改修理由書作成事業者番号().value(), is(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.DEFAULT_介護住宅改修理由書作成事業者番号.value()));
        }
    }

    public static class save住宅改修理由書作成手数料請求決定 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(1);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(0);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(1);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);
            住宅改修理由書作成手数料請求決定 = 住宅改修理由書作成手数料請求決定.createBuilderForEdit().set償還不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(0);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);
            住宅改修理由書作成手数料請求決定 = 住宅改修理由書作成手数料請求決定.createBuilderForEdit().set償還不支給理由等(new RString("任意項目1を変更")).build();

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(1);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);
            住宅改修理由書作成手数料請求決定 = 住宅改修理由書作成手数料請求決定.deleted();

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class))).thenReturn(0);

            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);
            住宅改修理由書作成手数料請求決定 = 住宅改修理由書作成手数料請求決定.deleted();

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityGenerator.createDbT3094JutakuKaishuRiyushoTesuryoKetteiEntity();
            entity.initializeMd5();
            JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定 = new JutakuKaishuRiyushoTesuryoKettei(entity);

            assertThat(sut.save住宅改修理由書作成手数料請求決定(住宅改修理由書作成手数料請求決定), is(false));
        }
    }
}
