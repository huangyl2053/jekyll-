/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;
import jp.co.ndensan.reams.db.dbz.model.ShoriDateModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ShoriDateDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ShoriDateKanriFinder}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShoriDateFinderTest {

    private static ShoriDateDac dac;
    private static ShoriDateFinder sut;

    @BeforeClass
    public static void test() {
        dac = mock(ShoriDateDac.class);
        sut = new ShoriDateFinder(dac);
    }

    public static class find処理日付 extends DbzTestBase {

        @Test
        public void find処理日付は_該当の情報がない時_Optionalのemptyを返す() {
            SubGyomuCode notFound = new SubGyomuCode("RDD");
            Optional<ShoriDateModel> empty = Optional.empty();

            when(dac.select処理日付ByKey(any(SubGyomuCode.class), any(LasdecCode.class),
                    any(ShoriName.class), any(RString.class), any(FlexibleYear.class), any(RString.class))).thenReturn(empty);

            Optional<ShoriDateModel> result = sut.find処理日付(
                    notFound,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);

            assertThat(result, is(empty));
        }

        @Test
        public void find処理日付は_該当の情報がある時_該当情報を返す() {
            Optional<ShoriDateModel> model = Optional.of(
                    new ShoriDateModel(DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity()));

            when(dac.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番)).thenReturn(model);

            Optional<ShoriDateModel> result = sut.find処理日付(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);

            assertThat(result.get().getサブ業務コード(), is(DEFAULT_サブ業務コード));
        }
    }
}
