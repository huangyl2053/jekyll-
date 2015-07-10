/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.config.GaitoshaKensakuConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysGaitoshaKensaku;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SochimotoSochisakiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoViewModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.HihokenshaDaichoViewDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import org.junit.Ignore;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 被保険者台帳から広域内住所地特例者の情報を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KojutokushaFinderTest extends DbzTestBase {

    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000001");
    private static final LasdecCode 市町村コード = new LasdecCode("000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000001");

    public static class get広住特者_被保険者番号 {

        @Test
        public void 広住特者が0件の時_get広住特者_被保険者番号は_0件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(0);
            assertThat(sut.get広住特者(被保険者番号).isPresent(), is(false));
        }

        @Test
        public void 広住特者が1件の時_get広住特者_被保険者番号は_1件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(1);
            assertThat(sut.get広住特者(被保険者番号).isPresent(), is(true));
        }
    }

    public static class get広住特者_市町村コード {

        @Test
        public void 広住特者が0件の時_get広住特者_市町村コードは_0件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(0);
            assertThat(sut.get広住特者(市町村コード).toList().size(), is(0));
        }

        @Test
        public void 広住特者が1件の時_get広住特者_市町村コードは_1件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(1);
            assertThat(sut.get広住特者(市町村コード).toList().size(), is(1));
        }

        @Test
        public void 広住特者が2件の時_get広住特者_市町村コードは_2件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(2);
            assertThat(sut.get広住特者(市町村コード).toList().size(), is(2));
        }
    }

    public static class get広住特者_措置元先制御あり_市町村コード {

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が0件の時_get広住特者_措置元先制御あり_市町村コードは_0件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(0);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード).toList().size(), is(0));
        }

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が1件の時_get広住特者_措置元先制御あり_市町村コードは_1件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(1);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード).toList().size(), is(1));
        }

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が2件の時_get広住特者_措置元先制御あり_市町村コードは_2件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(2);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード).toList().size(), is(2));
        }
    }

    public static class get広住特者_市町村コード_被保険者番号 {

        @Test
        public void 広住特者が0件の時_get広住特者_市町村コード_被保険者番号は_0件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(0);
            assertThat(sut.get広住特者(市町村コード, 被保険者番号).toList().size(), is(0));
        }

        @Test
        public void 広住特者が1件の時_get広住特者_市町村コード_被保険者番号は_1件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(1);
            assertThat(sut.get広住特者(市町村コード, 被保険者番号).toList().size(), is(1));
        }

        @Test
        public void 広住特者が2件の時_get広住特者_市町村コード_被保険者番号は_2件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(2);
            assertThat(sut.get広住特者(市町村コード, 被保険者番号).toList().size(), is(2));
        }
    }

    public static class get広住特者_措置元先制御あり_市町村コード_被保険者番号 {

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が0件の時_get広住特者_措置元先制御あり_市町村コード_被保険者番号は_0件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(0);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード, 被保険者番号).toList().size(), is(0));
        }

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が1件の時_get広住特者_措置元先制御あり_市町村コード_被保険者番号は_1件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(1);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード, 被保険者番号).toList().size(), is(1));
        }

        @Test
        @Ignore //TODO n8235 船山洋介 DBにデータが無いため、エラーとなるため、スキップする。データを入れたらIgnoreをはずす。
        public void 広住特者が2件の時_get広住特者_措置元先制御あり_市町村コード_被保険者番号は_2件の情報を返す() {
            KojutokushaFinder sut = createKojutokushaFinder(2);
            assertThat(sut.get広住特者_措置元先制御あり(市町村コード, 被保険者番号).toList().size(), is(2));
        }
    }

    private static KojutokushaFinder createKojutokushaFinder(int count) {
        return new KojutokushaFinder(createDaichoViewDac(count), createGaitoshaKensakuConfig());
    }

    private static HihokenshaDaichoViewDac createDaichoViewDac(int count) {
        HihokenshaDaichoViewDac dac = mock(HihokenshaDaichoViewDac.class);
        IItemList<HihokenshaDaichoViewModel> list = createHihokenshaDaichoViewList(count);
        when(dac.selectBy被保険者番号(any(HihokenshaNo.class))).thenReturn(list);
        when(dac.selectByAny市町村コード(any(LasdecCode.class), any(HihokenshaNo.class))).thenReturn(list);
        when(dac.selectBy市町村コード(any(LasdecCode.class), any(HihokenshaNo.class))).thenReturn(list);
        when(dac.selectBy広住特措置元市町村コード(any(LasdecCode.class), any(HihokenshaNo.class))).thenReturn(list);
        return dac;
    }

    private static GaitoshaKensakuConfig createGaitoshaKensakuConfig() {
        IUrBusinessConfig mock = mock(IUrBusinessConfig.class);
        when(mock.get(eq(ConfigKeysGaitoshaKensaku.広域内住所地特例者検索制御_措置元_措置先区分_介護資格), any(RDate.class))).thenReturn(SochimotoSochisakiKubun.措置元.getCode());
        return new GaitoshaKensakuConfig(mock);
    }

    private static IItemList<HihokenshaDaichoViewModel> createHihokenshaDaichoViewList(int count) {
        List<HihokenshaDaichoViewModel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            HihokenshaDaichoViewModel model = mock(HihokenshaDaichoViewModel.class);
            when(model.get識別コード()).thenReturn(識別コード);
            list.add(model);
        }
        return ItemList.of(list);
    }
}
