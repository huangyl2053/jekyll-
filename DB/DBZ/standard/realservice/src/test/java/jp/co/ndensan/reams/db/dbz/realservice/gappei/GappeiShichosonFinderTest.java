/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice.gappei;

import java.util.ArrayList;
import java.util.List;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

    private static final int 特殊パターン = 99;

    public static class get旧市町村情報付与終了日 {

        @Test
        public void 合併情報が複数件の時_get旧市町村情報付与終了日は_最新の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(特殊パターン, 5, 0);
            assertThat(sut.get旧市町村情報付与終了日().get(), is(new FlexibleDate("20140303")));
        }
    }

    public static class get全合併市町村 {

        @Test
        public void 合併市町村情報が0件の時_get全合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get全合併市町村(true).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_get全合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 5, 0);
            assertThat(sut.get全合併市町村(true).size(), is(1));
        }

        @Test
        public void 合併市町村情報が2件の時_get全合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 5, 0);
            assertThat(sut.get全合併市町村(true).size(), is(2));
        }
    }

    public static class get全旧市町村 {

        @Test
        public void 合併市町村が0件の時_get全旧市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get全旧市町村().size(), is(0));
        }

        @Test
        public void 合併市町村が1件の時_get全旧市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 1, 0);
            assertThat(sut.get全旧市町村().size(), is(1));
        }

        @Test
        public void 合併市町村が2件の時_get全旧市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 2, 0);
            assertThat(sut.get全旧市町村().size(), is(2));
        }

        @Test
        public void 合併市町村が複数件の時_get全旧市町村は_最新のリストを返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 特殊パターン, 0);
            assertThat(sut.get全旧市町村().size(), is(3));
        }
    }

    public static class find合併市町村 {

        @Test
        public void 合併市町村情報が0件の時_find合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.find合併市町村(createSearchCondition(), true).size(), is(0));
        }

        @Test
        public void 合併市町村情報が1件の時_find合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 5, 0);
            assertThat(sut.find合併市町村(createSearchCondition(), true).size(), is(1));
        }

        @Test
        public void 合併市町村情報が2件の時_find合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 5, 0);
            assertThat(sut.find合併市町村(createSearchCondition(), true).size(), is(2));
        }
    }

    public static class get全広域合併市町村 {

        @Test
        public void 広域合併市町村情報が0件の時_get全広域合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get全広域合併市町村(true).size(), is(0));
        }

        @Test
        public void 広域合併市町村情報が1件の時_get全広域合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.get全広域合併市町村(true).size(), is(1));
        }

        @Test
        public void 広域合併市町村情報が2件の時_get全広域合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 0, 5);
            assertThat(sut.get全広域合併市町村(true).size(), is(2));
        }
    }

    public static class get地域ごとの最新広域合併市町村 {

        @Test
        public void 広域合併市町村情報が0件の時_get地域ごとの最新広域合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get地域ごとの最新広域合併市町村().size(), is(0));
        }

        @Test
        public void 広域合併市町村情報が1件の時_get地域ごとの最新広域合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.get地域ごとの最新広域合併市町村().size(), is(1));
        }

        @Test
        public void 広域合併市町村情報が2件の時_get地域ごとの最新広域合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 0, 5);
            assertThat(sut.get地域ごとの最新広域合併市町村().size(), is(2));
        }

        @Test
        public void 合併情報が複数件の時_get地域ごとの最新広域合併市町村は_最新のリストを返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(特殊パターン, 0, 5);
            assertThat(sut.get地域ごとの最新広域合併市町村().size(), is(3));
        }
    }

    public static class get地域ごとの広域合併市町村 {

        @Test
        public void 広域合併市町村情報が0件の時_get地域ごとの広域合併市町村は_nullを返す() {;
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get地域ごとの広域合併市町村(RString.EMPTY).isPresent(), is(false));
        }

        @Test
        public void 広域合併市町村情報が1件の時_get地域ごとの広域合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.get地域ごとの広域合併市町村(RString.EMPTY).isPresent(), is(true));
        }
    }

    public static class get全地域の広域合併市町村 {

        @Test
        public void 広域合併市町村情報が0件の時_get全地域の広域合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.get全地域の広域合併市町村().size(), is(0));
        }

        @Test
        public void 広域合併市町村情報が1件の時_get全地域の広域合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.get全地域の広域合併市町村().size(), is(1));
        }

        @Test
        public void 広域合併市町村情報が2件の時_get全地域の広域合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 0, 5);
            assertThat(sut.get全地域の広域合併市町村().size(), is(2));
        }
    }

    public static class find広域合併市町村 {

        @Test
        public void 広域合併市町村情報が0件の時_find広域合併市町村は_0件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.find広域合併市町村(createSearchCondition()).size(), is(0));
        }

        @Test
        public void 広域合併市町村情報が1件の時_find広域合併市町村は_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.find広域合併市町村(createSearchCondition()).size(), is(1));
        }

        @Test
        public void 広域合併市町村情報が2件の時_find広域合併市町村は_2件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(2, 0, 5);
            assertThat(sut.find広域合併市町村(createSearchCondition()).size(), is(2));
        }
    }

    public static class find広域合併市町村By合併後市町村コード {

        @Test
        public void 広域合併市町村情報が0件の時_find広域合併市町村By合併後市町村コードは_nullを返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.find広域合併市町村By合併後市町村コード(RString.EMPTY).isPresent(), is(false));
        }

        @Test
        public void 広域合併市町村情報が1件の時_find広域合併市町村By合併後市町村コードは_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.find広域合併市町村By合併後市町村コード(RString.EMPTY).isPresent(), is(true));
        }

        @Test
        public void 広域合併市町村が複数件の時_find広域合併市町村By合併後市町村コードは_最新の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.find広域合併市町村By合併後市町村コード(RString.EMPTY).get().get構成市町村().asList().get(0).get合併情報地域番号(), is(new RString("05")));
        }
    }

    public static class find広域合併市町村By合併元市町村コード {

        @Test
        public void 広域合併市町村情報が0件の時_find広域合併市町村By合併元市町村コードは_nullを返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(0, 0, 0);
            assertThat(sut.find広域合併市町村By合併元市町村コード(RString.EMPTY).isPresent(), is(false));
        }

        @Test
        public void 広域合併市町村情報が1件の時_find広域合併市町村By合併元市町村コードは_1件の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.find広域合併市町村By合併元市町村コード(RString.EMPTY).isPresent(), is(true));
        }

        @Test
        public void 広域合併市町村が複数件の時_find広域合併市町村By合併元市町村コードは_最古の情報を返す() {
            GappeiShichosonFinder sut = createGappeiShichosonFinder(1, 0, 5);
            assertThat(sut.find広域合併市町村By合併元市町村コード(RString.EMPTY).get().get構成市町村().asList().get(0).get合併情報地域番号(), is(new RString("01")));
        }
    }

    private static GappeiShichosonFinder createGappeiShichosonFinder(int count1, int count2, int count3) {
        return new GappeiShichosonFinder(createGappeiJohoDac(count1), createGappeiShichosonDac(count2), createKoseiShichosonMasterDac(count3));
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

    private static IGappeiJoho createGappeiJoho(int param1, int param2) {
        IGappeiJoho gappeiJoho = mock(GappeiJohoModel.class);
        FlexibleDate 合併日 = new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2));
        RString 地域番号 = new RString(String.format("%1$02d", param1));
        RString 市町村コード = new RString(String.format("%1$05d", param1));
        FlexibleDate 旧市町村情報付与終了日 = new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2));
        when(gappeiJoho.get合併日()).thenReturn(合併日);
        when(gappeiJoho.get地域番号()).thenReturn(地域番号);
        when(gappeiJoho.get市町村コード()).thenReturn(市町村コード);
        when(gappeiJoho.get旧市町村情報付与終了日()).thenReturn(旧市町村情報付与終了日);
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
        FlexibleDate 合併日 = new FlexibleDate(String.format("2014%1$02d%2$02d", param1, param2));
        RString 地域番号 = new RString(String.format("%1$02d", param1));
        RString 旧市町村コード = new RString(String.format("%1$05d", param2));
        when(gappeiShichoson.get合併日()).thenReturn(合併日);
        when(gappeiShichoson.get地域番号()).thenReturn(地域番号);
        when(gappeiShichoson.get旧市町村コード()).thenReturn(旧市町村コード);
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
        RString 合併情報地域番号 = new RString(String.format("%1$02d", index));
        when(koikiKoseiShichoson.get合併情報地域番号()).thenReturn(合併情報地域番号);
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
