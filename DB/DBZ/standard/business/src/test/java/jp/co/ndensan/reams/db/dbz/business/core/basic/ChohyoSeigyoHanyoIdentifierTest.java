/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoHanyoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoHanyoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode 主キー名1;
    private static ReportId 主キー名2;
    private static RString 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード;
        主キー名2 = DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ChohyoSeigyoHanyoIdentifier sut = new ChohyoSeigyoHanyoIdentifier(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
