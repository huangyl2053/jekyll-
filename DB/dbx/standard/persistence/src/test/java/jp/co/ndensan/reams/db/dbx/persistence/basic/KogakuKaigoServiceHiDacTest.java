package jp.co.ndensan.reams.db.dbx.persistence.basic;

import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.basic.helper.KogakuKaigoServiceHiDacTestHelper;
import jp.co.ndensan.reams.db.dbx.persistence.basic.helper.KogakuKaigoServiceHiInserter;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;

import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 *
 * @author N9943 王 永康
 */
@Ignore //TODO N9818清水健一　業務のDBの配置場所が確定したら対応する。確定の内容次第ではURから不要になることがある。期限：2015/4/30
@RunWith(Enclosed.class)
public class KogakuKaigoServiceHiDacTest {

    private static IKogakuKaigoServiceHiDac sut;
    private static KogakuKaigoServiceHiInserter inserter;

    @BeforeClass
    public static void setUpClass() {
        inserter = InstanceProvider.create(KogakuKaigoServiceHiInserter.class);
        sut = InstanceProvider.create(KogakuKaigoServiceHiDac.class);
    }

    public static class selectのテスト extends DbxTestDacBase {

        @Before
        public void setUp() {
            inserter.insert(KogakuKaigoServiceHiDacTestHelper.getSpiedInstance());
        }

        @Test
        public void selectで識別コード0000000001_対象年月201312のデータを取得できる() {
            DbV3057KogakuShikyuHanteiKekkaEntity selected = sut.select(new RString("0000000001"), new FlexibleYearMonth("201312"));
            assertThat(selected.getHihokenshaNo(), is(new RString("0000000001")));
        }

        @Test
        public void selectで識別コード0000000002_対象年月201312のデータを取得できない() {
            DbV3057KogakuShikyuHanteiKekkaEntity selected = sut.select(new RString("0000000002"), new FlexibleYearMonth("201312"));
            assertNull(selected);
        }
    }
}
