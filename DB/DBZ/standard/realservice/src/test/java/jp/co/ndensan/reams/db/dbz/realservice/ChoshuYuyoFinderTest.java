/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2006ChoshuYuyoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2007KibetsuChoshuYuyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyoModel;
import jp.co.ndensan.reams.db.dbz.model.relate.fuka.ChoshuYuyoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ChoshuYuyoRelateDac;
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
 * {link ChoshuYuyoFinder}のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoFinderTest {

    private static ChoshuYuyoRelateDac dac;
    private static ChoshuYuyoFinder sut;

    private static final FukaNendo notFound賦課年度 = new FukaNendo("2111");
    private static final FukaNendo 賦課年度 = new FukaNendo(DEFAULT_賦課年度);
    private static final ChoteiNendo 調定年度 = new ChoteiNendo(DEFAULT_調定年度);
    private static final GemmenChoshuYuyoStateKubun 状態区分 = GemmenChoshuYuyoStateKubun.toValue(DEFAULT_徴収猶予状態区分);

    @BeforeClass
    public static void test() {
        dac = mock(ChoshuYuyoRelateDac.class);
        sut = new ChoshuYuyoFinder(dac);
    }

    public static class find徴収猶予 extends DbzTestBase {

        @Test
        public void find徴収猶予は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<ChoshuYuyoRelateModel> empty = Optional.empty();

            when(dac.select徴収猶予RelateByKeyAndState(any(ChoteiNendo.class), any(FukaNendo.class),
                    any(TsuchishoNo.class), any(RDateTime.class), any(GemmenChoshuYuyoStateKubun.class))).thenReturn(empty);
            Optional<ChoshuYuyoRelateModel> result = sut.find徴収猶予(
                    調定年度, notFound賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分);

            assertThat(result, is(empty));
        }

        @Test
        public void find徴収猶予は_該当の情報がある時_該当情報を返す() {
            Optional<ChoshuYuyoRelateModel> model = Optional.of(createModel());

            when(dac.select徴収猶予RelateByKeyAndState(
                    調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分)).thenReturn(model);

            Optional<ChoshuYuyoRelateModel> result = sut.find徴収猶予(
                    調定年度, 賦課年度, DEFAULT_通知書番号, DEFAULT_処理日時, 状態区分);

            assertThat(result.get().get徴収猶予モデル().get賦課年度(), is(賦課年度));
        }

        private ChoshuYuyoRelateModel createModel() {
            List<KibetsuChoshuYuyoModel> list = new ArrayList<>();
            list.add(new KibetsuChoshuYuyoModel(DbT2007KibetsuChoshuYuyoEntityGenerator.createDbT2007KibetsuChoshuYuyoEntity()));

            return new ChoshuYuyoRelateModel(
                    new ChoshuYuyoModel(DbT2006ChoshuYuyoEntityGenerator.createDbT2006ChoshuYuyoEntity()),
                    list);
        }
    }
}
