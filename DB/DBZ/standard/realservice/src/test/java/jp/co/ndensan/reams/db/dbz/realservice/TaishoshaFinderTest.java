/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.FukaTaishoshaModel;
import jp.co.ndensan.reams.db.dbz.model.TaishoshaModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.TaishoshaRelateDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.IShikibetsuTaishoSearchKey;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.db.IPsmCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 対象者を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class TaishoshaFinderTest extends DbzTestBase {

    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("123456789012345");
    private static final ISearchCondition 指定無 = null;
    private static final ISearchCondition 介護条件 = mock(ISearchCondition.class);
    private static final ISearchCondition 介護除外条件 = mock(ISearchCondition.class);
    private static final IShikibetsuTaishoSearchKey 宛名条件 = create宛名条件();
    private static final int 最大表示件数 = 100;

    public static class get資格対象者 {

        @Test
        public void 対象者が0件の時_get資格対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get資格対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 対象者が1件の時_get資格対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get資格対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 対象者が2件の時_get資格対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get資格対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護条件指定無_対象者が0件の時_get資格対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get資格対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護条件指定無_対象者が1件の時_get資格対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get資格対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護条件指定無_対象者が2件の時_get資格対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get資格対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護除外条件指定無_対象者が0件の時_get資格対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get資格対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護除外条件指定無_対象者が1件の時_get資格対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get資格対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護除外条件指定無_対象者が2件の時_get資格対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get資格対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護条件無_介護除外条件指定無_対象者が0件の時_get資格対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get資格対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護条件無_介護除外条件指定無_対象者が1件の時_get資格対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get資格対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護条件無_介護除外条件指定無_対象者が2件の時_get資格対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get資格対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(2));
        }
    }

    public static class get賦課対象者 {

        @Test
        public void 対象者が0件の時_get賦課対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get賦課対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 対象者が1件の時_get賦課対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get賦課対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 対象者が2件の時_get賦課対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get賦課対象者(介護条件, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護条件指定無_対象者が0件の時_get賦課対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get賦課対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護条件指定無_対象者が1件の時_get賦課対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get賦課対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護条件指定無_対象者が2件の時_get賦課対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get賦課対象者(指定無, 介護除外条件, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護除外条件指定無_対象者が0件の時_get賦課対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get賦課対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護除外条件指定無_対象者が1件の時_get賦課対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get賦課対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護除外条件指定無_対象者が2件の時_get賦課対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get賦課対象者(介護条件, 指定無, 宛名条件, 最大表示件数).getList().size(), is(2));
        }

        @Test
        public void 介護条件指定無_介護除外条件指定無_対象者が0件の時_get賦課対象者は_0件の情報を返す() {
            TaishoshaFinder sut = createFinder(0);
            assertThat(sut.get賦課対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(0));
        }

        @Test
        public void 介護条件指定無_介護除外条件指定無_対象者が1件の時_get賦課対象者は_1件の情報を返す() {
            TaishoshaFinder sut = createFinder(1);
            assertThat(sut.get賦課対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(1));
        }

        @Test
        public void 介護条件指定無_介護除外条件指定無_対象者が2件の時_get賦課対象者は_2件の情報を返す() {
            TaishoshaFinder sut = createFinder(2);
            assertThat(sut.get賦課対象者(指定無, 指定無, 宛名条件, 最大表示件数).getList().size(), is(2));
        }
    }

    private static TaishoshaFinder createFinder(int count) {
        return new TaishoshaFinder(createDac(count));
    }

    private static TaishoshaRelateDac createDac(int count) {
        TaishoshaRelateDac dac = mock(TaishoshaRelateDac.class);
        List<TaishoshaModel> list = createTaishoshaList(count);
        List<FukaTaishoshaModel> fukaList = createFukaTaishoshaList(count);
        when(dac.select資格対象者(any(ITrueFalseCriteria.class), any(IPsmCriteria.class), any(boolean.class), any(int.class))).thenReturn(list);
        when(dac.select賦課対象者(any(ITrueFalseCriteria.class), any(IPsmCriteria.class), any(boolean.class), any(int.class))).thenReturn(fukaList);
        return dac;
    }

    private static List<TaishoshaModel> createTaishoshaList(int count) {
        List<TaishoshaModel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(mock(TaishoshaModel.class));
        }
        return list;
    }

    private static List<FukaTaishoshaModel> createFukaTaishoshaList(int count) {
        List<FukaTaishoshaModel> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(mock(FukaTaishoshaModel.class));
        }
        return list;
    }

    private static IShikibetsuTaishoSearchKey create宛名条件() {
        return new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true)
                .setShikibetsuCode(識別コード).build();
    }
}
