/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;
import jp.co.ndensan.reams.db.dbz.model.ShoriDateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoriDateDac}のテストクラスです。
 *
 * @author n3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShoriDateDacTest {

    private static ShoriDateDac sut;
    private static DbT7022ShoriDateKanriDac 処理日付Dac;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShoriDateDac.class);
        処理日付Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    public static class select処理日付ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT7022(DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void サブ業務コードがnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    null,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    null,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理名がnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    null,
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 処理枝番がnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    null,
                    DEFAULT_年度,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 年度がnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    null,
                    DEFAULT_年度内連番);
        }

        @Test(expected = NullPointerException.class)
        public void 年度内連番がnullの場合_select処理日付ByKeyは_NullPointerExceptionを発生させる() {
            sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_処理日付モデル返す() {
            assertThat(sut.select処理日付ByKey(
                    DEFAULT_サブ業務コード,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番).get().getサブ業務コード(), is(DEFAULT_サブ業務コード));
        }

        @Test
        public void データが見つかない検索条件を渡すと_Optionalのemptyを返す() {
            SubGyomuCode notFound = new SubGyomuCode("RDD");
            Optional<ShoriDateModel> empty = Optional.empty();

            assertThat(sut.select処理日付ByKey(
                    notFound,
                    DEFAULT_市町村コード,
                    ShoriName.valueOf(DEFAULT_処理名.toString()),
                    DEFAULT_処理枝番,
                    DEFAULT_年度,
                    DEFAULT_年度内連番), is(empty));
        }
    }
//TODO n3317塚田萌　更新が必要になったときにテストを作る

    private static class TestSupport {

        public static void insertDbT7022(
                SubGyomuCode サブ業務コード,
                LasdecCode 市町村コード,
                ShoriName 処理名,
                RString 処理枝番,
                FlexibleYear 年度,
                RString 年度内連番) {
            DbT7022ShoriDateKanriEntity entity = DbT7022ShoriDateKanriEntityGenerator.createDbT7022ShoriDateKanriEntity();
            entity.setSubGyomuCode(サブ業務コード);
            entity.setShichosonCode(市町村コード);
            entity.setShoriName(処理名.toRString());
            entity.setShoriEdaban(処理枝番);
            entity.setNendo(年度);
            entity.setNendoNaiRenban(年度内連番);
            処理日付Dac.insert(entity);
        }
    }
}
