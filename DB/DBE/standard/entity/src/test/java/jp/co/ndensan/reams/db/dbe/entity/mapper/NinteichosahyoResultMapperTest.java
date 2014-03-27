/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoResult;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査票を一次判定で使用する形にマッピングするクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosahyoResultMapperTest {

    private static NinteichosahyoResult result;

    public static class to認定調査結果のテスト extends DbeTestBase {

        @Before
        public void setUp() {
            result = NinteichosahyoResultMapper.to認定調査結果(IchijiHanteiTestEntityCreator.create認定調査票Entity());
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            result = NinteichosahyoResultMapper.to認定調査結果(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後の調査項目結果は_申請書管理番号に01を持つ() {
            assertThat(result.get申請書管理番号().value(), is(new RString("01")));
        }

        @Test
        public void マッピング後の調査項目結果は_厚労省IF区分にV02Aを持つ() {
            assertThat(result.get厚労省IF区分(), is(KoroshoIFKubun.V02A));
        }

        @Test
        public void マッピング後の調査項目結果は_要介護認定調査履歴番号に1を持つ() {
            assertThat(result.get要介護認定調査履歴番号().value(), is(1));
        }

        @Test
        public void マッピング後の調査項目結果は_get調査項目回答で_entity内の調査項目に対応した回答結果を返す() {
            assertThat(result.get調査項目回答(),
                    is(new RString("22222111112222211111222223333311111222223333344444111112222233333444445555511111222223333344444555556")));
        }
    }
}
