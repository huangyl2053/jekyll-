/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7025KoikiNoHatsubanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiNoHatsubanIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiNoHatsubanIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static RString コード区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            KoikiNoHatsubanIdentifier sut = new KoikiNoHatsubanIdentifier(市町村コード, コード区分);
            assertThat(sut, is(serializable()));
        }
    }
}
