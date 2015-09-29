/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5508ShinsakaiJizenKekkaJohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiJizenKekkaJohoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiJizenKekkaJohoIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 介護認定審査会開催番号;
    private static RString 介護認定審査会委員コード;
    private static int 介護認定審査会審査順;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        介護認定審査会開催番号 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
        介護認定審査会委員コード = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
        介護認定審査会審査順 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            ShinsakaiJizenKekkaJohoIdentifier sut = new ShinsakaiJizenKekkaJohoIdentifier(介護認定審査会開催番号, 介護認定審査会委員コード, 介護認定審査会審査順);
            assertThat(sut, is(serializable()));
        }
    }
}
