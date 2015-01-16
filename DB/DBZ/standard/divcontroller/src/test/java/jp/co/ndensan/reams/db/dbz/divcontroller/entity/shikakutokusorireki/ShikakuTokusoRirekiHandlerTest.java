/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.Hihokensha;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbz.business.HihokenshaList;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.business.ShikakuShutoku;
import jp.co.ndensan.reams.db.dbz.business.ShikakuSoshitsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.realservice.HihokenshaFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.JushochiTokureishaKubun;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 資格特喪履歴情報Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShikakuTokusoRirekiHandlerTest extends DbzTestBase {

    private static final LasdecCode 市町村コード = new LasdecCode("000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000002");
    private static final ShikakuShutokuJiyu 資格取得事由 = ShikakuShutokuJiyu.転入;
    private static final FlexibleDate 資格取得届出日 = new FlexibleDate("20140101");
    private static final FlexibleDate 資格取得日 = new FlexibleDate("20140202");
    private static final Code 被保険者区分コード = new Code("1");
    private static final RString 被保険者区分名称 = new RString("介護保険第1号被保険者");
    private static final ShikakuSoshitsuJiyu 資格喪失事由 = ShikakuSoshitsuJiyu.転出;
    private static final FlexibleDate 資格喪失届出日 = new FlexibleDate("20140303");
    private static final FlexibleDate 資格喪失日 = new FlexibleDate("20140404");
    private static final JushochiTokureishaKubun 住所地特例者区分 = JushochiTokureishaKubun.通常資格者;
    private static final ShoKisaiHokenshaNo 広域内住所地特例措置元保険者番号 = new ShoKisaiHokenshaNo("000004");
    private static final LasdecCode 旧市町村コード = new LasdecCode("000005");

    public static class load {

        private ShikakuTokusoRirekiDiv result;

        @Before
        public void setup() {
            result = createNewDiv();
            new ShikakuTokusoRirekiHandler(result, createHihokenshaFinder()).load(市町村コード, 識別コード);
        }

        @Test
        public void 資格取得日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getShutokuDate().getValue(), is(資格取得日));
        }

        @Test
        public void 資格取得届出日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getShutokuTodokedeDate().getValue(), is(資格取得届出日));
        }

        @Test
        public void 資格取得事由のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getShutokuJiyu(), is(資格取得事由.getName()));
        }

        @Test
        public void 被保険者区分のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getHihokenshaKubun(), is(被保険者区分名称));
        }

        @Test
        public void 資格喪失日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getSoshitsuDate().getValue(), is(資格喪失日));
        }

        @Test
        public void 資格喪失届出日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getSoshitsuTodokedeDate().getValue(), is(資格喪失届出日));
        }

        @Test
        public void 資格喪失事由のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getSoshitsuJiyu(), is(資格喪失事由.getName()));
        }

        @Test
        public void 住所地特例者区分のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getJutokuKubun(), is(住所地特例者区分.get名称()));
        }

        @Test
        public void 市町村コードのデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getShozaiHokensha(), is(市町村コード.value()));
        }

        @Test
        public void 広域内住所地特例措置元市町村コードのデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getSochimotoHokensha(), is(広域内住所地特例措置元保険者番号.value()));
        }

        @Test
        public void 旧市町村コードのデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getKyuHokensha(), is(旧市町村コード.value()));
        }

        @Test
        public void 識別コードのデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getDgShikakuShutokuRireki().getDataSource().get(0).getShikibetsuCode(), is(識別コード.value()));
        }
    }

    private static HihokenshaFinder createHihokenshaFinder() {
        HihokenshaFinder mock = mock(HihokenshaFinder.class);
        HihokenshaList hihokenshaList = createHihokenshaList();
        when(mock.get被保険者List(any(ISearchCondition.class))).thenReturn(hihokenshaList);
        return mock;
    }

    private static ShikakuTokusoRirekiDiv createNewDiv() {
        ShikakuTokusoRirekiDiv div = new ShikakuTokusoRirekiDiv();
        div.setDgShikakuShutokuRireki(new DataGrid<dgShikakuShutokuRireki_Row>());
        return div;
    }

    private static HihokenshaList createHihokenshaList() {
        List<Hihokensha> list = new ArrayList<>();
        list.add(createHihokensha());
        return new HihokenshaList(list);
    }

    private static Hihokensha createHihokensha() {
        Hihokensha mock = mock(Hihokensha.class);
        when(mock.get資格取得()).thenReturn(new ShikakuShutoku(資格取得事由, 資格取得届出日, 資格取得日));
        when(mock.get被保険者区分()).thenReturn(new HihokenshaKubun(被保険者区分コード, 被保険者区分名称));
        when(mock.get資格喪失()).thenReturn(new ShikakuSoshitsu(資格喪失事由, 資格喪失届出日, 資格喪失日));
        when(mock.get住所地特例者区分()).thenReturn(住所地特例者区分);
        when(mock.get市町村コード()).thenReturn(市町村コード);
        when(mock.get広域内住所地特例措置元保険者番号()).thenReturn(広域内住所地特例措置元保険者番号);
        when(mock.get旧市町村コード()).thenReturn(旧市町村コード);
        when(mock.get識別コード()).thenReturn(識別コード);
        return mock;
    }
}
