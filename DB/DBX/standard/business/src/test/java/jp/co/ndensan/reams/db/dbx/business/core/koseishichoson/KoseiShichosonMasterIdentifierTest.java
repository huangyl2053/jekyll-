/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.koseishichoson;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
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
public class KoseiShichosonMasterIdentifierTest extends DbxTestBase {

    private static RString 市町村識別ID;

    @BeforeClass
    public static void setUpClass() {

        市町村識別ID = DbT7051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;

    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KoseiShichosonMasterIdentifier sut = new KoseiShichosonMasterIdentifier(市町村識別ID);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
