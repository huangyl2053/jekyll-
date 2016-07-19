/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7061JuryoIninJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.ServiceShubetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link JuryoIninKeiyakuJigyoshaIdentifier}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class JuryoIninKeiyakuJigyoshaIdentifierTest extends DbxTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static JigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;
    private static ServiceShubetsuCode 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約事業者番号;
        主キー名2 = DbT7061JuryoIninJigyoshaEntityGenerator.DEFAULT_受領委任契約開始日;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            JuryoIninKeiyakuJigyoshaIdentifier sut = new JuryoIninKeiyakuJigyoshaIdentifier(主キー名1, 主キー名2, 主キー名3.getColumnValue());
            assertThat(sut, is(serializable()));
        }
    }
}
