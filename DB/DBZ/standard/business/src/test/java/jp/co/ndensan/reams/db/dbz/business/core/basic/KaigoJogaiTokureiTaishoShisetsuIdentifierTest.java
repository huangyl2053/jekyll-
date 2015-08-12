/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsuIdentifier;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 事業者種別;
    private static RString 事業者番号;
    private static FlexibleDate 有効開始日時;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        事業者種別 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
        事業者番号 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
        有効開始日時 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KaigoJogaiTokureiTaishoShisetsuIdentifier sut = new KaigoJogaiTokureiTaishoShisetsuIdentifier(事業者種別, 事業者番号, 有効開始日時);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
