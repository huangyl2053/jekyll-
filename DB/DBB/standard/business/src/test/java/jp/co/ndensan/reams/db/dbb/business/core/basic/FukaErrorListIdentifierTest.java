/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaErrorListIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaErrorListIdentifierTest extends DbbTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static RString 内部帳票ID;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
        内部帳票ID = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
    }

    public static class シリアライズテスト extends DbbTestBase {

        @Test
        public void シリアライズできる() {
            FukaErrorListIdentifier sut = new FukaErrorListIdentifier(サブ業務コード, 内部帳票ID, 賦課年度, 通知書番号);
//            assertThat(sut, is(serializable()));
        }
    }
}
