/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.relate;

import jp.co.ndensan.reams.db.dbb.persistence.db.relate.GemmenDac;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
//import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator;
//import jp.co.ndensan.reams.db.dbz.model.fuka.DbT2004GemmenEntity;
//import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import static jp.co.ndensan.reams.uz.uza.lang.cast._CastDataTypeFactory.DataType.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GemmenDac}のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class GemmenDacTest {

    private static GemmenDac sut;
    private static DbT2004GemmenDac 減免Dac;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(GemmenDac.class);
        減免Dac = InstanceProvider.create(DbT2004GemmenDac.class);
    }

    public static class select減免ByKeyAndStateTest extends DbzTestDacBase {

        private static final FlexibleYear 調定年度1 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度;
        private static final FlexibleYear notFound調定年度 = DbT2004GemmenEntityGenerator.DEFAULT_調定年度.plusYear(1);
        private static final FlexibleYear 賦課年度1 = DbT2004GemmenEntityGenerator.DEFAULT_賦課年度;
        private static final TsuchishoNo 通知書番号1 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
        private static final Decimal 履歴番号 = DbT2004GemmenEntityGenerator.DEFAULT_履歴番号;
        private static final GemmenChoshuYuyoStateKubun 状態区分1
                = GemmenChoshuYuyoStateKubun.toValue(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分);

        @Before
        public void setUp() {
            TestSupport.insertDbT2004(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(null, 賦課年度1, 通知書番号1, 履歴番号, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, null, 通知書番号1, 履歴番号, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, null, 履歴番号, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, null, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_減免モデル返す() {
            assertThat(sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 履歴番号, 状態区分1)
                    .get().getChoteiNendo(), is(調定年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
            Optional<DbT2004GemmenEntity> empty = Optional.empty();
            assertThat(sut.select減免ByKeyAndState(
                    notFound調定年度, 賦課年度1, 通知書番号1, 履歴番号, 状態区分1), is(empty));
        }
    }

//TODO n3317塚田萌　更新が必要になったときにテストを作る
    private static class TestSupport {

        public static void insertDbT2004(
                FlexibleYear 調定年度, FlexibleYear 賦課年度,
                TsuchishoNo 通知書番号, Decimal 履歴番号, GemmenChoshuYuyoStateKubun 状態区分1) {

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.setChoteiNendo(調定年度);
            entity.setFukaNendo(賦課年度);
            entity.setTsuchishoNo(通知書番号);
            entity.setRirekiNo(履歴番号);
            entity.setJotaiKubun(状態区分1.code());

            減免Dac.save(entity);
        }
    }
}
