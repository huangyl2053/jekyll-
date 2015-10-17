/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {link KaigoJogaiTokureiTaishoShisetsuManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuManagerTest {

    private static DbT1005KaigoJogaiTokureiTaishoShisetsuDac dac;
    private static KaigoJogaiTokureiTaishoShisetsuManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
        sut = new KaigoJogaiTokureiTaishoShisetsuManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護除外住所地特例対象施設 extends DbzTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー2 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー3 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
            sut.get介護除外住所地特例対象施設(null, 主キー2, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            FlexibleDate 主キー3 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
            sut.get介護除外住所地特例対象施設(主キー1, null, 主キー3);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            RString 主キー1 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            RString 主キー2 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            sut.get介護除外住所地特例対象施設(主キー1, 主キー2, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(RString.class), any(RString.class), any(FlexibleDate.class))).thenReturn(null);

            RString 主キー1 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            RString 主キー2 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー3 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
            KaigoJogaiTokureiTaishoShisetsu result = sut.get介護除外住所地特例対象施設(主キー1, 主キー2, 主キー3);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            when(dac.selectByKey(any(RString.class), any(RString.class), any(FlexibleDate.class))).thenReturn(entity);

            RString 主キー1 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
            RString 主キー2 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
            FlexibleDate 主キー3 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
            KaigoJogaiTokureiTaishoShisetsu result = sut.get介護除外住所地特例対象施設(主キー1, 主キー2, 主キー3);

            assertThat(result.get事業者種別(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get介護除外住所地特例対象施設一覧 extends DbzTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<KaigoJogaiTokureiTaishoShisetsu> result = sut.get介護除外住所地特例対象施設一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> entityList = Arrays.asList(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<KaigoJogaiTokureiTaishoShisetsu> result = sut.get介護除外住所地特例対象施設一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get事業者種別(), is(DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別));
        }
    }

    public static class save介護除外住所地特例対象施設 extends DbzTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);
            介護除外住所地特例対象施設 = 介護除外住所地特例対象施設.createBuilderForEdit().set異動事由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);
            介護除外住所地特例対象施設 = 介護除外住所地特例対象施設.createBuilderForEdit().set異動事由(new RString("任意項目1を変更")).build();

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(1);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);
            介護除外住所地特例対象施設 = 介護除外住所地特例対象施設.deleted();

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class))).thenReturn(0);

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);
            介護除外住所地特例対象施設 = 介護除外住所地特例対象施設.deleted();

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.initializeMd5();
            KaigoJogaiTokureiTaishoShisetsu 介護除外住所地特例対象施設 = new KaigoJogaiTokureiTaishoShisetsu(entity);

            assertThat(sut.save介護除外住所地特例対象施設(介護除外住所地特例対象施設), is(false));
        }
    }
}
