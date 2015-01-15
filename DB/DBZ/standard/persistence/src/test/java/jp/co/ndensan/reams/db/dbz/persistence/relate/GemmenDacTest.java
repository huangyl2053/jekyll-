/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.fuka.GemmenModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
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

        private static final ChoteiNendo 調定年度1 = new ChoteiNendo(DbT2004GemmenEntityGenerator.DEFAULT_調定年度);
        private static final ChoteiNendo notFound調定年度 = new ChoteiNendo(DbT2004GemmenEntityGenerator.DEFAULT_調定年度.plusYear(1));
        private static final FukaNendo 賦課年度1 = new FukaNendo(DbT2004GemmenEntityGenerator.DEFAULT_賦課年度);
        private static final TsuchishoNo 通知書番号1 = DbT2004GemmenEntityGenerator.DEFAULT_通知書番号;
        private static final RDateTime 処理日時1 = DbT2004GemmenEntityGenerator.DEFAULT_処理日時;
        private static final GemmenChoshuYuyoStateKubun 状態区分1
                = GemmenChoshuYuyoStateKubun.toValue(DbT2004GemmenEntityGenerator.DEFAULT_減免状態区分);

        @Before
        public void setUp() {
            TestSupport.insertDbT2004(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の賦課年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(null, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の調定年度にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, null, 通知書番号1, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の通知書番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, null, 処理日時1, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, null, 状態区分1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の状態区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_減免モデル返す() {
            assertThat(sut.select減免ByKeyAndState(調定年度1, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1)
                    .get().get調定年度(), is(調定年度1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
            Optional<GemmenModel> empty = Optional.empty();
            assertThat(sut.select減免ByKeyAndState(
                    notFound調定年度, 賦課年度1, 通知書番号1, 処理日時1, 状態区分1), is(empty));
        }
    }

//TODO n3317塚田萌　更新が必要になったときにテストを作る
    private static class TestSupport {

        public static void insertDbT2004(
                ChoteiNendo 調定年度, FukaNendo 賦課年度,
                TsuchishoNo 通知書番号, RDateTime 処理日時, GemmenChoshuYuyoStateKubun 状態区分1) {

            DbT2004GemmenEntity entity = DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity();
            entity.setChoteiNendo(調定年度.value());
            entity.setFukaNendo(賦課年度.value());
            entity.setTsuchishoNo(通知書番号);
            entity.setShoriTimestamp(処理日時);
            entity.setJotaiKubun(状態区分1.code());

            減免Dac.insert(entity);
        }
    }
}
