/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2012HokenryoRankEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenryoRankIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoRankIdentifierTest extends DbbTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2012HokenryoRankEntityGenerator.DEFAULT_賦課年度;
        市町村コード = DbT2012HokenryoRankEntityGenerator.DEFAULT_市町村コード;
    }

    public static class シリアライズテスト extends DbbTestBase {

        @Test
        public void シリアライズできる() {
            HokenryoRankIdentifier sut = new HokenryoRankIdentifier(賦課年度, 市町村コード);
//            assertThat(sut, is(serializable()));
        }
    }
}
