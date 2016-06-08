/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5051KoseiShichosonMasterEntityGenerator;
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
 * {@link KoseiShichosonMasterIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 市町村識別ID;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村識別ID = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            KoseiShichosonMasterIdentifier sut = new KoseiShichosonMasterIdentifier(市町村識別ID);
            assertThat(sut, is(serializable()));
        }
    }
}
