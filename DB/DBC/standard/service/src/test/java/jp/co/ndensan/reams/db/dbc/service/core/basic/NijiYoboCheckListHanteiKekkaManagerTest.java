/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.NijiYoboCheckListHanteiKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3103NijiYoboCheckListHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {link NijiYoboCheckListHanteiKekkaManager}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class NijiYoboCheckListHanteiKekkaManagerTest {

    private static DbT3103NijiYoboCheckListHanteiKekkaDac dac;
    private static NijiYoboCheckListHanteiKekkaManager sut;

    @BeforeClass
    public static void test() {
        dac = mock(DbT3103NijiYoboCheckListHanteiKekkaDac.class);
        sut = new NijiYoboCheckListHanteiKekkaManager(dac);
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防チェックリスト判定結果 extends DbcTestBase {

        // TODO メソッドの引数の数に合わせて、NullPointerExceptionのテストケースを増減してください。
        @Test(expected = NullPointerException.class)
        public void 引数の主キー型1にnullを指定した場合_NullPointerExceptionが発生する() {
            HihokenshaNo 主キー2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防チェックリスト判定結果(null, 主キー2, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型2にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
            FlexibleDate 主キー3 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防チェックリスト判定結果(主キー1, null, 主キー3, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型3にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            Decimal 主キー4 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            sut.get二次予防チェックリスト判定結果(主キー1, 主キー2, null, 主キー4);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー型4にnullを指定した場合_NullPointerExceptionが発生する() {
            ShikibetsuCode 主キー1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
            sut.get二次予防チェックリスト判定結果(主キー1, 主キー2, 主キー3, null);
        }

        // TODO メソッドの引数の数に合わせて、mock処理とメソッド呼び出しを見直してください。
        @Test
        public void 検索結果がnullの場合() {
            when(dac.selectByKey(any(ShikibetsuCode.class), any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(null);
            ShikibetsuCode 主キー1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            NijiYoboCheckListHanteiKekka result = sut.get二次予防チェックリスト判定結果(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result, is(nullValue()));
        }

        @Test
        public void 検索結果が存在する場合() {
            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            when(dac.selectByKey(any(ShikibetsuCode.class), any(HihokenshaNo.class), any(FlexibleDate.class), any(Decimal.class))).thenReturn(entity);
            ShikibetsuCode 主キー1 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード;
            HihokenshaNo 主キー2 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
            FlexibleDate 主キー3 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_受付年月日;
            Decimal 主キー4 = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
            NijiYoboCheckListHanteiKekka result = sut.get二次予防チェックリスト判定結果(主キー1, 主キー2, 主キー3, 主キー4);

            assertThat(result.get識別コード().value(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    // TODO 主キー型、主キー値については使用するエンティティに合わせて適切に置換してください。
    public static class get二次予防チェックリスト判定結果一覧 extends DbcTestBase {

        @Test
        public void 検索結果が空の場合() {
            when(dac.selectAll()).thenReturn(Collections.EMPTY_LIST);

            List<NijiYoboCheckListHanteiKekka> result = sut.get二次予防チェックリスト判定結果一覧();

            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 検索結果が存在する場合() {
            List<DbT3103NijiYoboCheckListHanteiKekkaEntity> entityList = Arrays.asList(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity());
            when(dac.selectAll()).thenReturn(entityList);

            List<NijiYoboCheckListHanteiKekka> result = sut.get二次予防チェックリスト判定結果一覧();

            assertThat(result.size(), is(1));
            assertThat(result.get(0).get識別コード().value(), is(DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.DEFAULT_識別コード.value()));
        }
    }

    public static class save二次予防チェックリスト判定結果 extends DbcTestBase {

        @Test
        public void insertに成功するとtrueが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(1);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(true));
        }

        @Test
        public void insertに失敗するとfalseが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(0);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(false));
        }

        @Test
        public void updateに成功するとtrueが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(1);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.initializeMd5();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);
            二次予防チェックリスト判定結果 = 二次予防チェックリスト判定結果.createBuilderForEdit().set二次予防_主観的健康感(new RString("任意項目1を変更")).build();

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(true));
        }

        @Test
        public void updateに失敗するとfalseが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(0);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.initializeMd5();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);
            二次予防チェックリスト判定結果 = 二次予防チェックリスト判定結果.createBuilderForEdit().set二次予防_主観的健康感(new RString("任意項目1を変更")).build();

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(false));
        }

        @Test
        public void deleteに成功するとtrueが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(1);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.initializeMd5();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);
            二次予防チェックリスト判定結果 = 二次予防チェックリスト判定結果.deleted();

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(true));
        }

        @Test
        public void deleteに失敗するとfalseが返る() {
            when(dac.save(any(DbT3103NijiYoboCheckListHanteiKekkaEntity.class))).thenReturn(0);

            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.initializeMd5();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);
            二次予防チェックリスト判定結果 = 二次予防チェックリスト判定結果.deleted();

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(false));
        }

        public void 何も変更せずにsaveを呼び出すとfalseが返る() {
            DbT3103NijiYoboCheckListHanteiKekkaEntity entity = DbT3103NijiYoboCheckListHanteiKekkaEntityGenerator.createDbT3103NijiYoboCheckListHanteiKekkaEntity();
            entity.initializeMd5();
            NijiYoboCheckListHanteiKekka 二次予防チェックリスト判定結果 = new NijiYoboCheckListHanteiKekka(entity);

            assertThat(sut.save二次予防チェックリスト判定結果(二次予防チェックリスト判定結果), is(false));
        }
    }
}
