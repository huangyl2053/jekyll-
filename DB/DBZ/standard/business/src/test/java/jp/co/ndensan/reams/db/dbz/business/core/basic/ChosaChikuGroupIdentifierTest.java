/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosaChikuGroupIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosaChikuGroupIdentifierTest extends DbzTestBase {

    private static Code 調査地区グループコード;
    private static LasdecCode 市町村コード;

    @BeforeClass
    public static void setUpClass() {
        調査地区グループコード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード;
        市町村コード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ChosaChikuGroupIdentifier sut = new ChosaChikuGroupIdentifier(調査地区グループコード, 市町村コード);
            assertThat(sut, is(serializable()));
        }
    }
}
