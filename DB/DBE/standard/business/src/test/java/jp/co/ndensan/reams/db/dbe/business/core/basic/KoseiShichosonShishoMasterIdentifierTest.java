/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5052KoseiShichosonShishoMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShishoCode;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
public class KoseiShichosonShishoMasterIdentifierTest extends DbeTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static ShishoCode 支所コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
        支所コード = DbT5052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    }

    public static class シリアライズテスト extends DbeTestBase {

        @Test
        public void シリアライズできる() {
            KoseiShichosonShishoMasterIdentifier sut = new KoseiShichosonShishoMasterIdentifier(市町村コード, 支所コード);
            assertThat(sut, is(serializable()));
        }
    }
}
