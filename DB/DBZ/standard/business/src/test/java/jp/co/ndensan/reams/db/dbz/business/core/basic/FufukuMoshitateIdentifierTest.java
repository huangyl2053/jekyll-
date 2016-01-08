/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7001FufukuMoshitateEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FufukuMoshitateIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FufukuMoshitateIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 主キー名1;
    private static ShikibetsuCode 主キー名2;
    private static HihokenshaNo 主キー名3;
    private static FlexibleDate 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
//        主キー名1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
            FufukuMoshitateIdentifier sut = new FufukuMoshitateIdentifier(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }
}
