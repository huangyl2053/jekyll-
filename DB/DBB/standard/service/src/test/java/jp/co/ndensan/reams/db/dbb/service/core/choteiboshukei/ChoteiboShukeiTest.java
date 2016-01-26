/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choteiboshukei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.DankaiShokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Gokei;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Gokeigo;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fuka.KibetsuShokei;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.ChoteiboShukeiEntitysGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {link FukaManager}のテストクラスです。
 *
 * @author yebangqiang
 */
@RunWith(Enclosed.class)
public class ChoteiboShukeiTest extends DbbTestDacBase {

    public static class kibetsuChoteigakuShokei extends DbbTestDacBase {

        private static List<Kibetsu> kiBetsuList;

        @Before
        public void setUp() {
            kiBetsuList = new ArrayList<>();
            kiBetsuList.add(ChoteiboShukeiEntitysGenerator.createKibetsuTokusyo1kiEntity());
            kiBetsuList.add(ChoteiboShukeiEntitysGenerator.createKibetsuFutsu2kiEntity());
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            ChoteiboShukei.kibetsuChoteigakuShokei(null);
        }

        @Test
        public void 期別調定額を集計する_特別徴収場合() {
            List<KibetsuShokei> kibetsuShokeiList = ChoteiboShukei.kibetsuChoteigakuShokei(kiBetsuList);
            assertThat(kibetsuShokeiList.get(0).getChoshuHouhou(), is(new RString("1")));
            assertThat(kibetsuShokeiList.get(0).getDai1kiChoteiIdGakuCount(), is(new Decimal(10.05)));
            assertThat(kibetsuShokeiList.get(0).getDai2kiChoteiIdGakuCount(), is(new Decimal(0)));
        }

        @Test
        public void 期別調定額を集計する_特別徴収多き期場合() {
            kiBetsuList = new ArrayList<>();
            kiBetsuList.addAll(ChoteiboShukeiEntitysGenerator.createKibetsuTokusyoOokiEntity());
            List<KibetsuShokei> kibetsuShokeiList = ChoteiboShukei.kibetsuChoteigakuShokei(kiBetsuList);
            assertThat(kibetsuShokeiList.get(0).getChoshuHouhou(), is(new RString("1")));
            assertThat(kibetsuShokeiList.get(0).getDai1kiChoteiIdGakuCount(), is(new Decimal(20.10)));
            assertThat(kibetsuShokeiList.get(0).getDai2kiChoteiIdGakuCount(), is(new Decimal(0)));
        }

        @Test
        public void 期別調定額を集計する_普通徴収場合() {
            List<KibetsuShokei> kibetsuShokeiList = ChoteiboShukei.kibetsuChoteigakuShokei(kiBetsuList);
            assertThat(kibetsuShokeiList.get(1).getChoshuHouhou(), is(new RString("2")));
            assertThat(kibetsuShokeiList.get(1).getDai1kiChoteiIdGakuCount(), is(new Decimal(0)));
            assertThat(kibetsuShokeiList.get(1).getDai2kiChoteiIdGakuCount(), is(new Decimal(10.05)));
        }
    }

    public static class ChoteiboDataGokei extends DbbTestDacBase {

        private static List<Gokei> gokeiList;
        private static List<KibetsuShokei> kiBetsuList;
        private static List<DankaiShokei> dankaiShokeiList;

        @Before
        public void setUp() {
            gokeiList = new ArrayList<>();
            kiBetsuList = new ArrayList<>();
            dankaiShokeiList = new ArrayList<>();
            kiBetsuList.addAll(ChoteiboShukeiEntitysGenerator.createKibetsuShokeiTokusyoOokiEntity());
            dankaiShokeiList.addAll(ChoteiboShukeiEntitysGenerator.createDankaiShokeiTokusyoOokiEntity());
            Gokei gokei = Gokei.createParam(kiBetsuList, dankaiShokeiList);
            gokeiList.add(gokei);
        }

        @Test(expected = NullPointerException.class)
        public void 引数にnullを指定した場合_NullPointerExceptionが発生する() {
            ChoteiboShukei.choteiboDataGokei(null);
        }

        @Test
        public void 調定簿データ合計する_特別徴収場合() {
            List<Gokeigo> gokeigoList = ChoteiboShukei.choteiboDataGokei(gokeiList);
            assertThat(gokeigoList.get(0).getKibetsuGokeigoList().get(0).getChoshuHouhou(), is(new RString("1")));
            assertThat(gokeigoList.get(0).getKibetsuGokeigoList().get(0).getTobetsuChoteiGakuCount(), is(new Decimal(60)));
            assertThat(gokeigoList.get(0).getKibetsuGokeigoList().get(1).getChoshuHouhou(), is(new RString("2")));
            assertThat(gokeigoList.get(0).getKibetsuGokeigoList().get(1).getFutsuChoteiGakuCount(), is(new Decimal(140)));
            assertThat(gokeigoList.get(0).getKibetsuGokeigoList().get(2).getTobetsuTofutsuChoteiGakuCount(), is(new Decimal(200)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(0).getChoshuHouhou(), is(new RString("1")));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(0).getDogetsusueKensuCount(), is(new Decimal(15)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(0).getDogetsusueChoteigakuCount(), is(new Decimal(25)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(1).getZengetsusueKensuCount(), is(new Decimal(10)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(1).getZengetsusueChoteigakuCount(), is(new Decimal(20)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(2).getChoshuHouhou(), is(new RString("2")));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(2).getDogetsusueKensuCount(), is(new Decimal(15)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(2).getDogetsusueChoteigakuCount(), is(new Decimal(25)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(3).getZengetsusueKensuCount(), is(new Decimal(10)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(3).getZengetsusueChoteigakuCount(), is(new Decimal(20)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(4).getTokuchosyaKensuCount(), is(new Decimal(44)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(4).getFuchosyaKensuCount(), is(new Decimal(44)));
            assertThat(gokeigoList.get(0).getDankaiGokeigoList().get(4).getNaiheisyaKensuCount(), is(new Decimal(44)));
        }
    }
}
