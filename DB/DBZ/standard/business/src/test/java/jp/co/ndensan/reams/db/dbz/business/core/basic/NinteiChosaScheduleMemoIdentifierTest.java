/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5222NinteiChosaScheduleMemoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiChosaScheduleMemoIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiChosaScheduleMemoIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleDate 主キー名1;
    private static Code 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ年月日;
        主キー名2 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_メモ区分;
        主キー名3 = DbT5222NinteiChosaScheduleMemoEntityGenerator.DEFAULT_連番;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            NinteiChosaScheduleMemoIdentifier sut = new NinteiChosaScheduleMemoIdentifier(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut, is(serializable()));
        }
    }
}
