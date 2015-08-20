/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link YoboKeikakuJikoSakuseiGokeiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class YoboKeikakuJikoSakuseiGokeiIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static Decimal 主キー名3;
    private static RString 主キー名4;
    private static JigyoshaNo 主キー名5;
    private static ServiceShuruiCode 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3012NichijoSeikatsuYoboKeikakuJikoSakuseiGokeiEntityGenerator.DEFAULT_対象年月;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            YoboKeikakuJikoSakuseiGokeiIdentifier sut = new YoboKeikakuJikoSakuseiGokeiIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
