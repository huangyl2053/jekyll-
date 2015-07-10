/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.mapper.NinteichosaItakusakiMapper;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.MockNinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * NinteichosaItakusakiMapperのテストクラスです
 *
 * @author n1013 松本直樹
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiMapperTest extends TestBase {
//
//    public static class toNinteichosaItakusaki extends TestBase {
//
//        private KaigoJigyoshaNo kaigojigyoshaNo = new KaigoJigyoshaNo(new RString("0000000001"));
//        private JigyoshaNo jigyoshaNo = new JigyoshaNo(new RString("2020300001"));
//        private DbT7010NinteichosaItakusakiJohoEntity testentity;
//
//        @Override
//        public void setUp() {
//            testentity = MockNinteichosaItakusakiJohoEntity.getSpiedInstance();
//        }
//
//        @Test
//        public void 引き渡した市町村コードとtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set市町村コード(new LasdecCode(new RString("202050")));
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getShichosonCode(), is(new LasdecCode(new RString("202050"))));
//        }
//
//        @Test
//        public void 引き渡した介護事業者番号とtoNinteichosaItakusakiの結果は一致する() {
//            kaigojigyoshaNo = new KaigoJigyoshaNo(new RString("1000000001"));
//            testentity.set介護事業者番号(kaigojigyoshaNo);
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getKaigoJigyoshaNo().getColumnValue(), is(kaigojigyoshaNo.getColumnValue()));
//        }
//
//        @Test
//        public void 引き渡した事業者番号とtoNinteichosaItakusakiの結果は一致する() {
//            jigyoshaNo = new JigyoshaNo(new RString("2220000001"));
//            testentity.set事業者番号(jigyoshaNo);
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getJigyoshaNo().getColumnValue(), is(jigyoshaNo.getColumnValue()));
//        }
//
//        @Test
//        public void 引き渡した介護事業者状況とtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set介護事業者状況(false);
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.is有効(), is(false));
//        }
//
//        @Test
//        public void 引き渡した調査委託区分とtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set調査委託区分(ChosaItakuKubun.介護保険施設);
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getChosaItakuKubun(), is(ChosaItakuKubun.介護保険施設));
//        }
//
//        @Test
//        public void 引き渡した割付定員とtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set割付定員(20);
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getWaritsukeTeiin(), is(20));
//        }
//
//        @Test
//        public void 引き渡した割付地区とtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set割付地区(new RString("AA"));
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getWaritsukeChiku(), is(new RString("AA")));
//        }
//
//        @Test
//        public void 引き渡した機関の区分とtoNinteichosaItakusakiの結果は一致する() {
//            testentity.set機関の区分(new RString("00000001"));
//            NinteichosaItakusaki result = NinteichosaItakusakiMapper.toNinteichosaItakusaki(testentity);
//            assertThat(result.getKikanKubun(), is(new RString("00000001")));
//        }
//    }
}
