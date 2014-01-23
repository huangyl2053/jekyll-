/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.HatsubanJoho;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaItakusaki;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.T5020HatsubanKanriJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.T7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.IHatsubanKanriJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.INinteichosaItakusakiDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.*;

/**
 * 認定調査委託先の情報を管理するクラスのテストクラスです
 *
 * @author N1013 松本直樹
 */
@RunWith(Enclosed.class)
public class NinteichosaItakusakiManagerTest {

    private static INinteichosaItakusakiDac ninteichosaItakusakiDac;
    private static IHatsubanKanriJohoDac hatsubankanrijohoDac;
    private static T7010NinteichosaItakusakiJohoEntity entity;
    private static T5020HatsubanKanriJohoEntity hatsubanentity;
    private static NinteichosaItakusaki ninteichosaItakusaki;
    private static KaigoJigyoshaNo kaigojigyoshaNo;
    private static JigyoshaNo jigyoshaNo;
    private static List<T7010NinteichosaItakusakiJohoEntity> list;
    private static List<T7010NinteichosaItakusakiJohoEntity> emptyList;
    private static NinteichosaItakusakiManager sut;

    @BeforeClass
    public static void setUpClass() {
        ninteichosaItakusakiDac = mock(INinteichosaItakusakiDac.class);
        hatsubankanrijohoDac = mock(IHatsubanKanriJohoDac.class);
        ninteichosaItakusaki = mock(NinteichosaItakusaki.class);
        kaigojigyoshaNo = mock(KaigoJigyoshaNo.class);
        jigyoshaNo = mock(JigyoshaNo.class);
        entity = mock(T7010NinteichosaItakusakiJohoEntity.class);
        hatsubanentity = mock(T5020HatsubanKanriJohoEntity.class);
        list = new ArrayList<>();
//        entity.set市町村コード(new RString("20203"));
        when(entity.get市町村コード()).thenReturn(new RString("20203"));
        kaigojigyoshaNo = new KaigoJigyoshaNo(new RString("0000000001"));
//        entity.set介護事業者番号(kaigojigyoshaNo);
        when(entity.get介護事業者番号()).thenReturn(kaigojigyoshaNo);
        jigyoshaNo = new JigyoshaNo(new RString("2020300001"));
//        entity.set事業者番号(jigyoshaNo);
        when(entity.get事業者番号()).thenReturn(jigyoshaNo);
//        entity.set介護事業者状況(true);
        when(entity.is介護事業者状況()).thenReturn(true);
        entity.set割付地区(new RString("a"));
        entity.set割付定員(10);
        entity.set機関の区分(new RString("b"));
        entity.set調査委託区分(ChosaItakuKubun.指定なし);


        list.add(entity);

        emptyList = Collections.EMPTY_LIST;
        when(ninteichosaItakusakiDac.selectAll(null, true)).thenReturn(emptyList);
        when(ninteichosaItakusakiDac.selectAll(null)).thenReturn(emptyList);
        when(ninteichosaItakusakiDac.selectAll(new RString("20203"), true)).thenReturn(list);

//        entity.set市町村コード(new RString("20203"));
        when(entity.get市町村コード()).thenReturn(new RString("20203"));
        kaigojigyoshaNo = new KaigoJigyoshaNo(new RString("0000000002"));
//        entity.set介護事業者番号(kaigojigyoshaNo);
        when(entity.get介護事業者番号()).thenReturn(kaigojigyoshaNo);
        jigyoshaNo = new JigyoshaNo(new RString("2020300002"));
//        entity.set事業者番号(jigyoshaNo);
        when(entity.get事業者番号()).thenReturn(jigyoshaNo);
//        entity.set介護事業者状況(false);
        when(entity.is介護事業者状況()).thenReturn(false);
        entity.set割付地区(new RString("c"));
        entity.set割付定員(10);
        entity.set機関の区分(new RString("d"));
        entity.set調査委託区分(ChosaItakuKubun.指定なし);
        list.add(entity);
        when(ninteichosaItakusakiDac.selectAll(new RString("20203"))).thenReturn(list);


    }

    public static class get認定調査委託先市町村指定全件 extends TestBase {

        @Override
        public void setUp() {
            sut = new NinteichosaItakusakiManager(ninteichosaItakusakiDac, hatsubankanrijohoDac);
        }

        @Test
        public void 引数の指定がない場合get認定調査委託先市町村指定全件_市町村_事業状況_はEMPTY_LISTを返却する() {
            List<NinteichosaItakusaki> resultList = sut.get認定調査委託先市町村指定全件(null, true);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 引数の指定がない場合get認定調査委託先市町村指定全件_市町村_はEMPTY_LISTを返却する() {
            List<NinteichosaItakusaki> resultList = sut.get認定調査委託先市町村指定全件(null);
            assertThat(resultList, is(Collections.EMPTY_LIST));
        }

        @Test
        public void 市町村指定の場合get認定調査委託先市町村指定全件事業状況ありは有効な件数を返却する() {
            List<NinteichosaItakusaki> resultList = sut.get認定調査委託先市町村指定全件(new RString("20203"), true);
            assertThat(resultList.size(), is(2));
        }

        @Test
        public void 市町村指定の場合get認定調査委託先市町村指定全件事業状況なしは市町村の全ての件数を返却する() {
            List<NinteichosaItakusaki> resultList = sut.get認定調査委託先市町村指定全件(new RString("20203"));
            assertThat(resultList.size(), is(2));
        }
    }

    public static class get認定調査委託先介護事業番号指定 extends TestBase {

        @Override
        public void setUp() {
            sut = new NinteichosaItakusakiManager(ninteichosaItakusakiDac, hatsubankanrijohoDac);
        }

        @Test
        public void 引数の指定がない場合get認定調査委託先介護事業者番号指定はNullを返却する() {
            kaigojigyoshaNo = new KaigoJigyoshaNo(null);
            when(ninteichosaItakusakiDac.select(null, kaigojigyoshaNo, true)).thenReturn(null);
            NinteichosaItakusaki result = sut.get認定調査委託先介護事業者番号指定(null, kaigojigyoshaNo, true);
            assertThat(result, nullValue());
        }

        @Test
        public void 引数を指定した場合get認定調査委託先介護事業者番号指定は指定した情報を返却する() {
            when(ninteichosaItakusakiDac.select(new RString("20203"), kaigojigyoshaNo, false)).thenReturn(entity);
            NinteichosaItakusaki result = sut.get認定調査委託先介護事業者番号指定(new RString("20203"), kaigojigyoshaNo, false);
            assertThat(result.getKaigoJigyoshaNo(), is(kaigojigyoshaNo));
        }
    }

    public static class get認定調査委託先事業番号指定 extends TestBase {

        @Override
        public void setUp() {
            sut = new NinteichosaItakusakiManager(ninteichosaItakusakiDac, hatsubankanrijohoDac);
        }

        @Test
        public void 引数の指定がない場合get認定調査委託先事業者番号指定はNullを返却する() {
            jigyoshaNo = new JigyoshaNo(null);
            when(ninteichosaItakusakiDac.select(null, jigyoshaNo, true)).thenReturn(null);
            NinteichosaItakusaki result = sut.get認定調査委託先事業者番号指定(null, jigyoshaNo, true);
            assertThat(result, nullValue());
        }

        @Test
        public void 引数を指定した場合get認定調査委託先事業者番号指定は指定した情報を返却する() {
//            jigyoshaNo = new JigyoshaNo(new RString("2020300002"));
            when(ninteichosaItakusakiDac.select(new RString("20203"), jigyoshaNo, false)).thenReturn(entity);
            NinteichosaItakusaki result = sut.get認定調査委託先事業者番号指定(new RString("20203"), jigyoshaNo, false);
            assertThat(result.getJigyoshaNo(), is(jigyoshaNo));
        }
    }

    public static class get発番情報 extends TestBase {

        @Override
        public void setUp() {
            sut = new NinteichosaItakusakiManager(ninteichosaItakusakiDac, hatsubankanrijohoDac);
        }

        @Test
        public void get発番情報は指定した項目区分の番号を返却する() {
            hatsubanentity = mock(T5020HatsubanKanriJohoEntity.class);
            hatsubanentity.set年度(new RString("0000"));
            hatsubanentity.set項目区分(new RString("010"));
            hatsubanentity.set発番(new RString("020"));
            when(hatsubanentity.get発番()).thenReturn(new RString("020"));
            when(hatsubankanrijohoDac.select(new RString("10"), new RString("0000"))).thenReturn(hatsubanentity);
            when(hatsubanentity.get発番()).thenReturn(new RString("20"));
            HatsubanJoho result = sut.get発番情報(new RString("10"), new RString("0000"));
            assertThat(result.getColumnValue(), is(new RString("21")));
        }
    }
}
