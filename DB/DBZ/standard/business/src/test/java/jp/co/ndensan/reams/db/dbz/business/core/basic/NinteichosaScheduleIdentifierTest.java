/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5221NinteichosaScheduleEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaScheduleIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosaScheduleIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 認定調査予定年月日;
    private static RString 認定調査予定開始時間;
    private static RString 認定調査予定終了時間;
    private static Code 認定調査時間枠;
    private static RString 認定調査委託先コード;
    private static RString 認定調査員コード;
    private static LasdecCode 市町村コード;
    private static Code 調査地区コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        認定調査予定年月日 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定年月日;
        認定調査予定開始時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定開始時間;
        認定調査予定終了時間 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査予定終了時間;
        認定調査時間枠 = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査時間枠;
        認定調査委託先コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査委託先コード;
        認定調査員コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_認定調査員コード;
        市町村コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_市町村コード;
        調査地区コード = DbT5221NinteichosaScheduleEntityGenerator.DEFAULT_調査地区コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteichosaScheduleIdentifier sut = new NinteichosaScheduleIdentifier(認定調査予定年月日, 認定調査予定開始時間, 認定調査予定終了時間,
                    認定調査時間枠, 調査地区コード, 認定調査委託先コード, 認定調査員コード, 市町村コード);
            assertThat(sut, is(serializable()));
        }
    }
}
