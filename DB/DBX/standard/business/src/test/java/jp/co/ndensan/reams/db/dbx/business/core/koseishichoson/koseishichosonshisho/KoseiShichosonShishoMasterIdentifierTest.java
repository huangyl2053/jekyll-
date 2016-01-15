/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.koseishichosonshisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonShishoMasterIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterIdentifierTest extends DbxTestBase {

    private static LasdecCode 市町村コード;
    private static ShishoCode 支所コード;

    @BeforeClass
    public static void setUpClass() {

        市町村コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
        支所コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    }

    public static class シリアライズテスト extends DbxTestBase {

        @Test
        public void シリアライズできる() {
            KoseiShichosonShishoMasterIdentifier sut = new KoseiShichosonShishoMasterIdentifier(市町村コード, 支所コード);
            assertThat(sut, is(canBeCopiedBySerialization()));
        }
    }
}
