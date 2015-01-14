/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2004GemmenEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.model.fuka.GemmenModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.GemmenDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link GemmenFinder}のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class GemmenFinderTest {

    private static GemmenDac dac;
    private static GemmenFinder sut;

    private static final FukaNendo notFound賦課年度 = new FukaNendo("2111");
    private static final FukaNendo 賦課年度 = new FukaNendo(DEFAULT_賦課年度);
    private static final ChoteiNendo 調定年度 = new ChoteiNendo(DEFAULT_調定年度);
    private static final GemmenChoshuYuyoStateKubun 状態区分 = GemmenChoshuYuyoStateKubun.toValue(DEFAULT_減免状態区分);

    @BeforeClass
    public static void test() {
        dac = mock(GemmenDac.class);
        sut = new GemmenFinder(dac);
    }

    public static class find減免 extends DbzTestBase {

        @Test
        public void find減免は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<GemmenModel> empty = Optional.empty();

            when(dac.select減免ByKeyAndState(any(ChoteiNendo.class), any(FukaNendo.class),
                    any(TsuchishoNo.class), any(RDateTime.class), any(GemmenChoshuYuyoStateKubun.class))).thenReturn(empty);
            Optional<GemmenModel> result = sut.find減免(
                    調定年度, notFound賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分);

            assertThat(result, is(empty));
        }

        @Test
        public void find減免は_該当の情報がある時_該当情報を返す() {
            Optional<GemmenModel> model = Optional.of(
                    new GemmenModel(DbT2004GemmenEntityGenerator.createDbT2004GemmenEntity()));

            when(dac.select減免ByKeyAndState(
                    調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分)).thenReturn(model);
            Optional<GemmenModel> result = sut.find減免(
                    調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分);

            assertThat(result.get().get賦課年度(), is(賦課年度));
        }
    }
}
