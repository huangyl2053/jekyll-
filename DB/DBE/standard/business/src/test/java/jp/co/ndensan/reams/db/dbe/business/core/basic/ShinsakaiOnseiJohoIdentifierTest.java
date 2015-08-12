/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiOnseiJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiOnseiJohoIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            ShinsakaiOnseiJohoIdentifier sut = new ShinsakaiOnseiJohoIdentifier(主キー名1, 主キー名2);
            assertThat(sut, is(serializable()));
        }
    }
}
