/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanriIdentifier;
import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7022ShoriDateKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShoriDateKanriIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShoriDateKanriIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static LasdecCode 市町村コード;
    private static RString 処理名;
    private static RString 処理枝番;
    private static FlexibleYear 年度;
    private static RString 年度内連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_サブ業務コード;
        市町村コード = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_市町村コード;
        処理名 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理名;
        処理枝番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_処理枝番;
        年度 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度;
        年度内連番 = DbT7022ShoriDateKanriEntityGenerator.DEFAULT_年度内連番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            ShoriDateKanriIdentifier sut = new ShoriDateKanriIdentifier(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
            assertThat(sut, is(serializable()));
        }
    }
}
