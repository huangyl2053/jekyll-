/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2011RankJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
//import static jp.co.ndensan.reams.db.dbb.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RankJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RankJohoIdentifierTest extends DbbTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static RString ランク区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度;
        ランク区分 = DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分;
    }

    public static class シリアライズテスト extends DbbTestBase {

        @Test
        public void シリアライズできる() {
            RankJohoIdentifier sut = new RankJohoIdentifier(賦課年度, ランク区分);
//            assertThat(sut, is(serializable()));
        }
    }
}
