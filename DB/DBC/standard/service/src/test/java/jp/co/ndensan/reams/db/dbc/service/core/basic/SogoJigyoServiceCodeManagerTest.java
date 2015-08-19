/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT7122SogoJigyoServiceCodeEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.basic.DbT7122SogoJigyoServiceCodeDac;
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
 * {link SogoJigyoServiceCodeManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class SogoJigyoServiceCodeManagerTest {

    private static DbT7122SogoJigyoServiceCodeDac dac;
    private static SogoJigyoServiceCodeManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT7122SogoJigyoServiceCodeDac.class);
        sut = new SogoJigyoServiceCodeManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護予防

        ・日常生活支援総合事業サービスコード extends FdaTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型2 主キー2 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー2;
            sut.get介護予防
            ・日常生活支援総合事業サービスコード(null, 主キー2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            主キー型1 主キー1 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー1;
            sut.get介護予防
            ・日常生活支援総合事業サービスコード(主キー1, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(null);

            主キー型1 主キー1 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー2;
            SogoJigyoServiceCode result = sut.get介護予防
            ・日常生活支援総合事業サービスコード(主キー1, 主キー2);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            when(dac.selectByKey(any(主キー型1.class), any(主キー型2.class))).thenReturn(entity);

            主キー型1 主キー1 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー1;
            主キー型2 主キー2 = DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー2;
            SogoJigyoServiceCode result = sut.get介護予防
            ・日常生活支援総合事業サービスコード(主キー1, 主キー2);

            assertThat(result.get主キー1().value(), is(DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護予防

        ・日常生活支援総合事業サービスコード一覧 extends FdaTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<SogoJigyoServiceCode> result = sut.get介護予防
            ・日常生活支援総合事業サービスコード一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT7122SogoJigyoServiceCodeEntity> entityList = Arrays.asList(DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<SogoJigyoServiceCode> result = sut.get介護予防
            ・日常生活支援総合事業サービスコード一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get主キー1().value(), is(DbT7122SogoJigyoServiceCodeEntityGenerator.DEFAULT_主キー1.value()));
        }
    }

    public static class save介護予防

        ・日常生活支援総合事業サービスコード extends XxxTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(1);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(true)




        );
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(0);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(false)




        );
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(1);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.initializeMd5();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);
            介護予防
            ・日常生活支援総合事業サービスコード = 介護予防
            ・日常生活支援総合事業サービスコード.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(true)




        );
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(0);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.initializeMd5();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);
            介護予防
            ・日常生活支援総合事業サービスコード = 介護予防
            ・日常生活支援総合事業サービスコード.createBuilderForEdit().set任意項目1(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(false)




        );
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(1);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.initializeMd5();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);
            介護予防
            ・日常生活支援総合事業サービスコード = 介護予防
            ・日常生活支援総合事業サービスコード.deleted();

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(true)




        );
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT7122SogoJigyoServiceCodeEntity.class))).thenReturn(0);

            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.initializeMd5();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);
            介護予防
            ・日常生活支援総合事業サービスコード = 介護予防
            ・日常生活支援総合事業サービスコード.deleted();

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(false)




        );
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT7122SogoJigyoServiceCodeEntity entity = DbT7122SogoJigyoServiceCodeEntityGenerator.createDbT7122SogoJigyoServiceCodeEntity();
            entity.initializeMd5();
            SogoJigyoServiceCode 介護予防
            ・日常生活支援総合事業サービスコード = new SogoJigyoServiceCode(entity);

            assertThat(sut.save介護予防
            ・日常生活支援総合事業サービスコード(介護予防・日常生活支援総合事業サービスコード
            ), is(false)






);
        }
    }
}
