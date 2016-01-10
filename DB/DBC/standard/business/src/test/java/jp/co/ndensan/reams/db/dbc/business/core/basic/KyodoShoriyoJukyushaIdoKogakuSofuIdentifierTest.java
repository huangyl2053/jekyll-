/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyodoShoriyoJukyushaIdoKogakuSofuIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyodoShoriyoJukyushaIdoKogakuSofuIdentifierTest extends DbcTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static ShoKisaiHokenshaNo 主キー名4;
    private static HihokenshaNo 主キー名5;
    private static int 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_異動年月日;
        主キー名2 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_異動区分コード;
        主キー名3 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_受給者異動事由;
        主キー名4 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名5 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_被保険者番号;
        主キー名6 = DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntityGenerator.DEFAULT_履歴番号;
    }

    public static class シリアライズテスト extends DbcTestBase {

        @Test
        public void シリアライズできる() {
            KyodoShoriyoJukyushaIdoKogakuSofuIdentifier sut = new KyodoShoriyoJukyushaIdoKogakuSofuIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut, is(serializable()));
        }
    }
}
