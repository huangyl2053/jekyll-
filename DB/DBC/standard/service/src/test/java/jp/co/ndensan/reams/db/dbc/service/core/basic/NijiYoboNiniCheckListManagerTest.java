/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboNiniCheckList;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3102NijiYoboNiniCheckListEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3102NijiYoboNiniCheckListDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {link NijiYoboNiniCheckListManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NijiYoboNiniCheckListManagerTest {

    private static DbT3102NijiYoboNiniCheckListDac dac;
    private static NijiYoboNiniCheckListManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3102NijiYoboNiniCheckListDac.class);
        sut = new NijiYoboNiniCheckListManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防任意チェックリスト extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防任意チェックリスト(null, 主キー2, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防任意チェックリスト(主キー1, null, 主キー3, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防任意チェックリスト(主キー1, 主キー2, null, 主キー4, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防任意チェックリスト(主キー1, 主キー2, 主キー3, null, 主キー5);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型5にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            sut.get二次予防任意チェックリスト(主キー1, 主キー2, 主キー3, 主キー4, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class), any(Decimal.class))).thenReturn(null);
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            NijiYoboNiniCheckList result = sut.get二次予防任意チェックリスト(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class), any(Decimal.class))).thenReturn(entity);
            ShikibetsuCode 主キー1 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_任意質問番号;
            Decimal 主キー5 = DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_履歴番号;
            NijiYoboNiniCheckList result = sut.get二次予防任意チェックリスト(主キー1, 主キー2, 主キー3, 主キー4, 主キー5);

            assertThat(result.get識別コード().value(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防任意チェックリスト一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NijiYoboNiniCheckList> result = sut.get二次予防任意チェックリスト一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3102NijiYoboNiniCheckListEntity> entityList = Arrays.asList(DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NijiYoboNiniCheckList> result = sut.get二次予防任意チェックリスト一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT3102NijiYoboNiniCheckListEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save二次予防任意チェックリスト extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(1);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(0);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(1);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.initializeMd5();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);
            二次予防任意チェックリスト = 二次予防任意チェックリスト.createBuilderForEdit().set任意質問番号(new Decimal(100)).build();

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(0);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.initializeMd5();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);
            二次予防任意チェックリスト = 二次予防任意チェックリスト.createBuilderForEdit().set任意質問番号(new Decimal(100)).build();

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(1);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.initializeMd5();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);
            二次予防任意チェックリスト = 二次予防任意チェックリスト.deleted();

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3102NijiYoboNiniCheckListEntity.class))).thenReturn(0);

            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.initializeMd5();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);
            二次予防任意チェックリスト = 二次予防任意チェックリスト.deleted();

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3102NijiYoboNiniCheckListEntity entity = DbT3102NijiYoboNiniCheckListEntityGenerator.createDbT3102NijiYoboNiniCheckListEntity();
            entity.initializeMd5();
            NijiYoboNiniCheckList 二次予防任意チェックリスト = new NijiYoboNiniCheckList(entity);

            assertThat(sut.save二次予防任意チェックリスト(二次予防任意チェックリスト), is(false));
        }
    }
}
