/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3078ShokanJuryoininKeiyakushaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3078ShokanJuryoininKeiyakushaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {link ShokanJuryoininKeiyakushaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShokanJuryoininKeiyakushaManagerTest {

    private static DbT3078ShokanJuryoininKeiyakushaDac dac;
    private static ShokanJuryoininKeiyakushaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3078ShokanJuryoininKeiyakushaDac.class);
        sut = new ShokanJuryoininKeiyakushaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還受領委任契約者 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            ShoKisaiHokenshaNo 主キー2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleDate 主キー3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
            sut.get償還受領委任契約者(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
            sut.get償還受領委任契約者(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
            ShoKisaiHokenshaNo 主キー2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
            Decimal 主キー4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
            sut.get償還受領委任契約者(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
            ShoKisaiHokenshaNo 主キー2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleDate 主キー3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
            sut.get償還受領委任契約者(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(HihokenshaNo.class), any(ShoKisaiHokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(null);
            HihokenshaNo 主キー1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
            ShoKisaiHokenshaNo 主キー2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleDate 主キー3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
            ShokanJuryoininKeiyakusha result = sut.get償還受領委任契約者(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            when(dac.selectByKey(any(HihokenshaNo.class), any(ShoKisaiHokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(entity);
            HihokenshaNo 主キー1 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号;
            ShoKisaiHokenshaNo 主キー2 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_証記載保険者番号;
            FlexibleDate 主キー3 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_履歴番号;
            ShokanJuryoininKeiyakusha result = sut.get償還受領委任契約者(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get被保険者番号().value(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get償還受領委任契約者一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<ShokanJuryoininKeiyakusha> result = sut.get償還受領委任契約者一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3078ShokanJuryoininKeiyakushaEntity> entityList = Arrays.asList(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<ShokanJuryoininKeiyakusha> result = sut.get償還受領委任契約者一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get被保険者番号().value(), is(DbT3078ShokanJuryoininKeiyakushaEntityGenerator.DEFAULT_被保険者番号.value()));
        }
    }

    public static class save償還受領委任契約者 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);
            償還受領委任契約者 = 償還受領委任契約者.createBuilderForEdit().set事業者契約番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);
            償還受領委任契約者 = 償還受領委任契約者.createBuilderForEdit().set事業者契約番号(new RString("任意項目1を変更")).build();

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(1);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);
            償還受領委任契約者 = 償還受領委任契約者.deleted();

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3078ShokanJuryoininKeiyakushaEntity.class))).thenReturn(0);

            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);
            償還受領委任契約者 = 償還受領委任契約者.deleted();

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3078ShokanJuryoininKeiyakushaEntity entity = DbT3078ShokanJuryoininKeiyakushaEntityGenerator.createDbT3078ShokanJuryoininKeiyakushaEntity();
            entity.initializeMd5();
            ShokanJuryoininKeiyakusha 償還受領委任契約者 = new ShokanJuryoininKeiyakusha(entity);

            assertThat(sut.save償還受領委任契約者(償還受領委任契約者), is(false));
        }
    }
}
