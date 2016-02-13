/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7063KaigoJigyoshaShiteiServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaShiteiServiceIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaShiteiServiceIdentifierTest extends DbxTestBase {

    private static JigyoshaNo 事業者番号;
    private static ServiceShuruiCode サービス種類コード;
    private static FlexibleDate 有効開始日;

    @BeforeClass
    public static void setUpClass() {

        事業者番号 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_事業者番号;
        サービス種類コード = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_サービス種類コード;
        有効開始日 = DbT7063KaigoJigyoshaShiteiServiceEntityGenerator.DEFAULT_有効開始日;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KaigoJigyoshaShiteiServiceIdentifier sut = new KaigoJigyoshaShiteiServiceIdentifier(事業者番号, サービス種類コード, 有効開始日);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
