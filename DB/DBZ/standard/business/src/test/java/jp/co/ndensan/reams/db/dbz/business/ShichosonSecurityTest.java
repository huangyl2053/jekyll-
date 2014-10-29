/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * 市町村セキュリティの情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShichosonSecurityTest extends DbzTestBase {

    private static final boolean 介護導入あり = true;
    private static final boolean 介護導入なし = false;
    private static final ShichosonShikibetsuID 市町村識別ID = new ShichosonShikibetsuID("01");
    private static final ShichosonCode 市町村コード = new ShichosonCode("00002");

    public static class get市町村識別ID {

        @Test
        public void 介護導入ありの時_get市町村識別IDは_設定値を返す() {
            ShichosonSecurity sut = new ShichosonSecurity(介護導入あり, 市町村識別ID, 市町村コード);
            assertThat(sut.get市町村識別ID(), is(市町村識別ID));
        }

        @Test
        public void 介護導入なしの時_get市町村識別IDは_nullを返す() {
            ShichosonSecurity sut = new ShichosonSecurity(介護導入なし, 市町村識別ID, 市町村コード);
            assertThat(sut.get市町村識別ID(), nullValue());
        }
    }

    public static class get市町村コード {

        @Test
        public void 介護導入ありの時_get市町村コードは_設定値を返す() {
            ShichosonSecurity sut = new ShichosonSecurity(介護導入あり, 市町村識別ID, 市町村コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 介護導入なしの時_get市町村コードは_nullを返す() {
            ShichosonSecurity sut = new ShichosonSecurity(介護導入なし, 市町村識別ID, 市町村コード);
            assertThat(sut.get市町村コード(), nullValue());
        }
    }
}
