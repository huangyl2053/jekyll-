/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.ShujiiIkensho5KomokuMapper;
import jp.co.ndensan.reams.db.dbe.business.ShujiiIkensho5Komoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.IchijiHanteiTestEntityCreator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 主治医意見書5項目マッパーのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShujiiIkensho5KomokuMapperTest {

    public static class to主治医意見書5項目のテスト extends DbeTestBase {

        private ShujiiIkensho5Komoku result;
        private Code 障害高齢者自立度コード;
        private Code 認知症高齢者自立度コード;
        private TankiKiokuKomoku 短期記憶;
        private NinchiNoryokuKomoku 認知能力;
        private DentatsuNoryokuKomoku 伝達能力;
        private ShokujiKoiHyokaKomoku 食事行為;

        @Before
        public void setUp() {
            障害高齢者自立度コード = new Code("9");
            認知症高齢者自立度コード = new Code("8");
            短期記憶 = TankiKiokuKomoku.問題あり;
            認知能力 = NinchiNoryokuKomoku.判断できない;
            伝達能力 = DentatsuNoryokuKomoku.具体的要求に限られる;
            食事行為 = ShokujiKoiHyokaKomoku.自立ないし何とか自分で食べられる;
            DbT5013ShujiiIkenshoShosaiJohoEntity entity = IchijiHanteiTestEntityCreator.create主治医意見書5項目EntitySpy(KoroshoIFKubun.V99A,
                    障害高齢者自立度コード, 認知症高齢者自立度コード, 短期記憶, 認知能力, 伝達能力, 食事行為);
            result = ShujiiIkensho5KomokuMapper.to主治医意見書5項目(entity);
        }

        @Test
        public void 引数にnullが渡されたとき_nullが返る() {
            result = ShujiiIkensho5KomokuMapper.to主治医意見書5項目(null);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_障害高齢者自立度コードに9を持つ() {
            assertThat(result.get障害高齢者自立度().getCode().value(), is(new RString("9")));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_認知症高齢者自立度コードに8を持つ() {
            assertThat(result.get認知症高齢者自立度().getCode().value(), is(new RString("8")));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_短期記憶に問題ありを持つ() {
            assertThat(result.get短期記憶(), is(TankiKiokuKomoku.問題あり));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_認知能力に判断できないを持つ() {
            assertThat(result.get認知能力(), is(NinchiNoryokuKomoku.判断できない));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_伝達能力に具体的要求に限られるを持つ() {
            assertThat(result.get伝達能力(), is(DentatsuNoryokuKomoku.具体的要求に限られる));
        }

        @Test
        public void マッピング後に返された主治医意見書5項目は_食事行為に自立ないし何とか自分で食べられるを持つ() {
            assertThat(result.get食事行為(), is(ShokujiKoiHyokaKomoku.自立ないし何とか自分で食べられる));
        }
    }
}
