/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.GappeiJohoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GappeiJohoKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HokenshaKoseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.model.koiki.KoikiKoseiShichosonModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.realservice.search.GappeiJohoSearchItem;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * 合併市町村情報を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class GappeiShichosonFinderTest extends DbzTestBase {

    private static final LasdecCode 市町村コード = new LasdecCode("000001");
    private static final LasdecCode 旧市町村コード = new LasdecCode("000002");
    private static final ShoKisaiHokenshaNo 保険者番号 = new ShoKisaiHokenshaNo("000001");
    private static final ShoKisaiHokenshaNo 旧保険者番号 = new ShoKisaiHokenshaNo("000002");
    private static final FlexibleYearMonth 基準年月 = new FlexibleYearMonth("201301");

    private static final int 特殊パターン = 99;

    public static class get旧市町村情報付与終了日 {

        @Test
        public void 合併情報が複数件の時_get旧市町村情報付与終了日は_最新の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(特殊パターン, 5, 0);
            assertThat(sut.get旧市町村情報付与終了日().get(), is(new FlexibleDate("20140303")));
        }
    }

    public static class get合併市町村情報_表示フラグ {

        @Test
        public void 合併市町村情報が0件の時_get合併市町村情報Listは_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get合併市町村情報(true).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get合併市町村情報Listは_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get合併市町村情報(true).size(), is(1));
        }

        @Test
        public void 合併市町村情報が2件の時_get合併市町村情報Listは_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 1, 1);
            assertThat(sut.get合併市町村情報(true).size(), is(2));
        }
    }

    public static class get合併市町村情報_旧市町村コード {

        @Test
        public void 合併市町村情報が0件の時_get合併市町村情報Listは_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get合併市町村情報(旧市町村コード).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get合併市町村情報Listは_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get合併市町村情報(旧市町村コード).size(), is(1));
        }
    }

    public static class get合併市町村情報_旧保険者番号 {

        @Test
        public void 合併市町村情報が0件の時_get合併市町村情報Listは_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get合併市町村情報(旧保険者番号).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get合併市町村情報Listは_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get合併市町村情報(旧保険者番号).size(), is(1));
        }
    }

    public static class get最新合併市町村情報_市町村コード {

        @Test
        public void 合併市町村情報が0件の時_get最新合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get最新合併市町村情報(市町村コード).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get最新合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get最新合併市町村情報(市町村コード).isPresent(), is(true));
        }
    }

    public static class get最新合併市町村情報_保険者番号 {

        @Test
        public void 合併市町村情報が0件の時_get最新合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get最新合併市町村情報(保険者番号).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get最新合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get最新合併市町村情報(保険者番号).isPresent(), is(true));
        }
    }

    public static class get最新合併市町村情報_保険者番号_基準年月 {

        @Test
        public void 合併市町村情報が0件の時_get最新合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get最新合併市町村情報(保険者番号, 基準年月).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get最新合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get最新合併市町村情報(保険者番号, 基準年月).isPresent(), is(true));
        }
    }

    public static class get最古合併市町村情報_旧市町村コード {

        @Test
        public void 合併市町村情報が0件の時_get最古合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get最古合併市町村情報(旧市町村コード).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get最古合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get最古合併市町村情報(旧市町村コード).isPresent(), is(true));
        }
    }

    public static class get直近合併市町村情報_旧保険者番号 {

        @Test
        public void 合併市町村情報が0件の時_get直近合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get直近合併市町村情報(旧保険者番号).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get直近合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get直近合併市町村情報(旧保険者番号).isPresent(), is(true));
        }
    }

    public static class get直近合併市町村情報_旧保険者番号_基準年月 {

        @Test
        public void 合併市町村情報が0件の時_get直近合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get直近合併市町村情報(旧保険者番号, 基準年月).isPresent(), is(false));
        }

        @Test
        public void 合併市町村情報が1件の時_get直近合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get直近合併市町村情報(旧保険者番号, 基準年月).isPresent(), is(true));
        }
    }

    public static class get市町村情報_市町村コード {

        @Test
        public void 合併市町村情報が0件の時_get市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get市町村情報(市町村コード).get().get合併市町村().size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get市町村情報(市町村コード).get().get合併市町村().size(), is(1));
        }
    }

    public static class get市町村情報_保険者番号 {

        @Test
        public void 合併市町村情報が0件の時_get市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get市町村情報(保険者番号).get().get合併市町村().size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get市町村情報(保険者番号).get().get合併市町村().size(), is(1));
        }
    }

    public static class get最古市町村情報_市町村コード {

        @Test
        public void 合併市町村情報が0件の時_get市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get最古市町村情報(市町村コード).get().get合併市町村().size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.get最古市町村情報(市町村コード).get().get合併市町村().size(), is(1));
        }
    }

    public static class find合併市町村情報_検索条件 {

        @Test
        public void 合併市町村情報が0件の時_find合併市町村情報は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.find合併市町村情報(createSearchCondition(), true).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_find合併市町村情報は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 1, 1);
            assertThat(sut.find合併市町村情報(createSearchCondition(), true).size(), is(1));
        }

        @Test
        public void 合併市町村情報が2件の時_find合併市町村情報は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 1, 1);
            assertThat(sut.find合併市町村情報(createSearchCondition(), true).size(), is(2));
        }
    }

    private static GappeiShichosonFinder createGappeiShichosonFinder(int count1, int count2, int count3) {
        return new GappeiShichosonFinder(
                createGappeiJohoDac(count1), createGappeiShichosonDac(count2), createKoseiShichosonMasterDac(count3),
                createGappeiJohoConfig(), createHokenshaJohoConfig());
    }

    private static GappeiJohoDac createGappeiJohoDac(int count) {
        GappeiJohoDac dac = mock(GappeiJohoDac.class);
        IItemList<IGappeiJoho> list = createGappeiJohoList(count);
        when(dac.selectAll()).thenReturn(list);
        when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(list);
        return dac;
    }

    private static GappeiShichosonDac createGappeiShichosonDac(int count) {
        GappeiShichosonDac dac = mock(GappeiShichosonDac.class);
        IItemList<IGappeiShichoson> list = createGappeiShichosonList(count);
        when(dac.selectAll()).thenReturn(list);
        when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(list);
        return dac;
    }

    private static KoseiShichosonMasterDac createKoseiShichosonMasterDac(int count) {
        KoseiShichosonMasterDac dac = mock(KoseiShichosonMasterDac.class);
        IItemList<IKoikiKoseiShichoson> list = createKoseiShichosonList(count);
        when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(list);
        return dac;
    }

    private static GappeiJohoConfig createGappeiJohoConfig() {
        GappeiJohoConfig config = mock(GappeiJohoConfig.class);
        when(config.get合併情報区分()).thenReturn(GappeiJohoKubun.合併あり);
        return config;
    }

    private static HokenshaJohoConfig createHokenshaJohoConfig() {
        HokenshaJohoConfig config = mock(HokenshaJohoConfig.class);
        when(config.get保険者構成()).thenReturn(HokenshaKoseiKubun.単一市町村);
        return config;
    }

    private static IGappeiJoho createGappeiJoho(int param1, int param2) {
        IGappeiJoho gappeiJoho = mock(GappeiJohoModel.class);
        when(gappeiJoho.get合併日()).thenReturn(new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2)));
        when(gappeiJoho.get地域番号()).thenReturn(new RString(String.format("%1$02d", param1)));
        when(gappeiJoho.get市町村コード()).thenReturn(new LasdecCode(String.format("%1$06d", param1)));
        when(gappeiJoho.get旧市町村情報付与終了日()).thenReturn(new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2)));
        when(gappeiJoho.get国保連データ連携開始日()).thenReturn(new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2)));
        return gappeiJoho;
    }

    private static IItemList<IGappeiJoho> createGappeiJohoList(int count) {
        List<IGappeiJoho> list = new ArrayList<>();
        if (count != 特殊パターン) {
            for (int i = 1; i <= count; i++) {
                list.add(createGappeiJoho(i, i));
            }
        } else {
            for (int chiikiNo = 1; chiikiNo <= 3; chiikiNo++) {
                for (int gappeiYMD = 1; gappeiYMD <= 3; gappeiYMD++) {
                    list.add(createGappeiJoho(chiikiNo, gappeiYMD));
                }
            }
        }
        return ItemList.of(list);
    }

    private static IGappeiShichoson createGappeiShichoson(int param1, int param2) {
        IGappeiShichoson gappeiShichoson = mock(GappeiShichosonModel.class);
        when(gappeiShichoson.get合併日()).thenReturn(new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2)));
        when(gappeiShichoson.get地域番号()).thenReturn(new RString(String.format("%1$02d", param1)));
        when(gappeiShichoson.get旧市町村コード()).thenReturn(new LasdecCode(String.format("%1$06d", param2)));
        return gappeiShichoson;
    }

    private static IItemList<IGappeiShichoson> createGappeiShichosonList(int count) {
        List<IGappeiShichoson> list = new ArrayList<>();
        if (count != 特殊パターン) {
            for (int i = 1; i <= count; i++) {
                list.add(createGappeiShichoson(i, i));
            }
        } else {
            for (int chiikiNo = 1; chiikiNo <= 3; chiikiNo++) {
                for (int shichosonCode = 1; shichosonCode <= 3; shichosonCode++) {
                    list.add(createGappeiShichoson(chiikiNo, shichosonCode));
                }
            }
        }
        return ItemList.of(list);
    }

    private static IKoikiKoseiShichoson createKoseiShichoson(int index) {
        IKoikiKoseiShichoson koikiKoseiShichoson = mock(KoikiKoseiShichosonModel.class);
        when(koikiKoseiShichoson.get合併情報地域番号()).thenReturn(new RString(String.format("%1$02d", index)));
        return koikiKoseiShichoson;
    }

    private static IItemList<IKoikiKoseiShichoson> createKoseiShichosonList(int count) {
        List<IKoikiKoseiShichoson> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(createKoseiShichoson(i));
        }
        return ItemList.of(list);
    }

    private static ISearchCondition createSearchCondition() {
        return SearchConditionFactory.condition(GappeiJohoSearchItem.地域番号, StringOperator.完全一致, RString.EMPTY);
    }
}
