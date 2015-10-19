/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceShuruiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoServiceShuruiCode 主キー名1;
    private static FlexibleYearMonth 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_サービス種類コード;
        主キー名2 = DbT7130KaigoServiceShuruiEntityGenerator.DEFAULT_提供開始年月;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KaigoServiceShuruiIdentifier sut = new KaigoServiceShuruiIdentifier(主キー名1, 主キー名2);
            assertThat(sut, is(serializable()));
        }
    }
}
