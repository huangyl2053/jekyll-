/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7014KaigoSetaiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoSetaiIdentifier}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoSetaiIdentifierTest extends DbzTestBase {

//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static RString 管理識別区分;
    private static FlexibleDate 世帯把握基準年月日;
    private static int 世帯員管理連番;
    private static ShikibetsuCode 世帯員識別コード;
    private static RString 本人区分;
    private static FlexibleYear 課税年度;
    private static RString 課税非課税区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_被保険者番号;
        管理識別区分 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_管理識別区分;
        世帯把握基準年月日 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯把握基準年月日;
        世帯員管理連番 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員管理連番;
        世帯員識別コード = DbT7014KaigoSetaiEntityGenerator.DEFAULT_世帯員識別コード;
        本人区分 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_本人区分;
        課税年度 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税年度;
        課税非課税区分 = DbT7014KaigoSetaiEntityGenerator.DEFAULT_課税非課税区分;
    }

    public static class シリアライズテスト extends DbzTestBase {

        @Test
        public void シリアライズできる() {
//            KaigoSetaiIdentifier sut = new KaigoSetaiIdentifier(被保険者番号, 管理識別区分, 世帯把握基準年月日, 世帯員管理連番, 世帯員識別コード, 本人区分, 課税年度, 課税非課税区分);
            KaigoSetaiIdentifier sut = new KaigoSetaiIdentifier(被保険者番号, 管理識別区分, 世帯把握基準年月日, 世帯員管理連番, 世帯員識別コード, 本人区分);
            assertThat(sut, is(serializable()));
        }
    }
}
