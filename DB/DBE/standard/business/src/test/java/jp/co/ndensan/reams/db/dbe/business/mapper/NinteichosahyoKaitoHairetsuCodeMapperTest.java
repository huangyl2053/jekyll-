/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosahyoKaitoHairetsuCodeMapper;
import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoKaitoHairetsuCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.business.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
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
public class NinteichosahyoKaitoHairetsuCodeMapperTest {

    private static NinteichosahyoKaitoHairetsuCode result;

    public static class to認定調査結果のテスト extends DbeTestBase {

        private ShinseishoKanriNo 申請書管理番号_01;
        private KoroshoIFKubun IF区分_V02A;
        private NinteichosaIraiRirekiNo 依頼履歴番号_1;
        private RString 回答項目;

        @Before
        public void setUp() {
            申請書管理番号_01 = new ShinseishoKanriNo(new RString("01"));
            IF区分_V02A = KoroshoIFKubun.V02A;
            依頼履歴番号_1 = new NinteichosaIraiRirekiNo(1);
            回答項目 = new RString("22222111112222211111222223333311111222223333344444111112222233333444445555511111222223333344444555556");
            DbT5009NinteichosahyoJohoEntity entity =
                    IchijiHanteiTestEntityCreator.create認定調査票Entity(申請書管理番号_01, IF区分_V02A, 依頼履歴番号_1, 回答項目);
            result = NinteichosahyoKaitoHairetsuCodeMapper.to認定調査結果(entity);
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            result = NinteichosahyoKaitoHairetsuCodeMapper.to認定調査結果(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後の調査項目結果は_申請書管理番号に01を持つ() {
            assertThat(result.get申請書管理番号(), is(申請書管理番号_01));
        }

        @Test
        public void マッピング後の調査項目結果は_厚労省IF区分にV02Aを持つ() {
            assertThat(result.get厚労省IF区分(), is(IF区分_V02A));
        }

        @Test
        public void マッピング後の調査項目結果は_要介護認定調査履歴番号に1を持つ() {
            assertThat(result.get要介護認定調査履歴番号(), is(依頼履歴番号_1));
        }

        @Test
        public void マッピング後の調査項目結果は_get調査項目回答で_entity内の調査項目に対応した回答結果を返す() {
            assertThat(result.asRString(), is(回答項目));
        }
    }
}
