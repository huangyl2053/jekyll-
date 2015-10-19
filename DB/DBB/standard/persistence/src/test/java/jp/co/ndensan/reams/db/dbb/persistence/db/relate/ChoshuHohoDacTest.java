/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.relate;

import jp.co.ndensan.reams.db.dbb.persistence.db.relate.ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuHohoDac}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ChoshuHohoDacTest {

    private static ChoshuHohoDac sut;
    private static DbT2001ChoshuHohoDac 徴収方法Dac;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ChoshuHohoDac.class);
        徴収方法Dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
    }

    public static class select徴収方法Test extends DbzTestDacBase {

        private static final FukaNendo 賦課年度1 = new FukaNendo(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度);
        private static final FukaNendo notFound賦課年度 = new FukaNendo(DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度.plusYear(1));
        private static final HihokenshaNo 被保険者番号1 = DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
        private static final RDateTime 処理日時2001_1_1_1_1_1_1 = RDateTime.of(2001, 1, 1, 1, 1, 1, 1);
        private static final RDateTime 処理日時2002_2_2_2_2_2_2 = RDateTime.of(2002, 2, 2, 2, 2, 2, 2);
        private static final Decimal 履歴番号 = new Decimal(1);

        @Before
        public void setUp() {
            ChoshuHohoDacTest.TestSupport.insertDbT2001(賦課年度1, 被保険者番号1, 履歴番号);
            ChoshuHohoDacTest.TestSupport.insertDbT2001(賦課年度1, 被保険者番号1, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収方法Recently(null, 被保険者番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select徴収方法Recently(賦課年度1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_直近の徴収方法モデル返す() {
            assertThat(sut.select徴収方法Recently(賦課年度1, 被保険者番号1).get().getRirekiNo(), is(履歴番号));
        }

        @Test
        public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
            Optional<DbT2001ChoshuHohoEntity> empty = Optional.empty();
            assertThat(sut.select徴収方法Recently(notFound賦課年度, 被保険者番号1), is(empty));
        }
    }

//TODO n3317塚田萌　更新のメソッドのテストは必要になったときに作る
    private static class TestSupport {

        public static void insertDbT2001(
                FukaNendo 賦課年度, HihokenshaNo 被保険者番号, Decimal 履歴番号) {

            DbT2001ChoshuHohoEntity entity = DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity();
            entity.setFukaNendo(賦課年度.value());
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);

            徴収方法Dac.save(entity);
        }
    }
}
