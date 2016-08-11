/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.kaigofukakihon;

import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonHandler;
import jp.co.ndensan.reams.db.dbb.service.core.FukaMiscManager;
import jp.co.ndensan.reams.db.dbb.service.core.basic.HokenryoDankaiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護賦課基本情報Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class KaigoFukaKihonHandlerTest extends DbzTestBase {

    private static final TsuchishoNo 通知書番号 = new TsuchishoNo("0000000001");
    private static final FlexibleYear 賦課年度 = new FlexibleYear("2014");
    private static final LasdecCode 市町村コード = new LasdecCode("000001");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000002");
    private static final RString 被保険者番号 = new RString("000003");
    private static final RString 保険料段階 = new RString("010");
    private static final RString 表示用保険料段階 = new RString("第1段階");
    private static final ShikakuShutokuJiyu 資格取得事由 = ShikakuShutokuJiyu.転入;
    private static final FlexibleDate 資格取得日 = new FlexibleDate("20140202");
    private static final ShikakuSoshitsuJiyu 資格喪失事由 = ShikakuSoshitsuJiyu.転出;
    private static final FlexibleDate 資格喪失日 = new FlexibleDate("20140404");

    public static class load {

        private KaigoFukaKihonDiv result;

        @Before
        public void setup() {
            result = createNewDiv();
            KaigoFukaKihonSearchKey searchKey = new KaigoFukaKihonSearchKey.Builder(通知書番号, 賦課年度, 市町村コード, 識別コード).build();
            new KaigoFukaKihonHandler(result, createHihokenshaDaichoManager(), createFukaMiscManager(), createHokenryoDankaiManager()).load(searchKey);
        }

        @Test
        public void 通知書番号のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtTsuchishoNo().getValue(), is(通知書番号.value()));
        }

        @Test
        public void 被保険者番号のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtHihokenshaNo().getValue(), is(被保険者番号));
        }

        @Test
        public void 保険料段階のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtHokenryoDankai().getValue(), is(表示用保険料段階));
        }

        @Test
        public void 資格取得日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtShutokuYmd().getValue(), is(資格取得日));
        }

        @Test
        public void 資格取得事由のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtShutokuJiyu().getValue(), is(資格取得事由.getName()));
        }

        @Test
        public void 資格喪失日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtSoshitsuYmd().getValue(), is(資格喪失日));
        }

        @Test
        public void 資格喪失事由のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtSoshitsuJiyu().getValue(), is(資格喪失事由.get名称()));
        }
    }

    private static HihokenshaDaichoManager createHihokenshaDaichoManager() {
        HihokenshaDaichoManager mock = mock(HihokenshaDaichoManager.class);
        Optional<HihokenshaDaichoModel> hihokenshaDaicho = Optional.ofNullable(createHihokenshaDaicho());
//        when(mock.get最新被保険者台帳(any(LasdecCode.class), any(ShikibetsuCode.class))).thenReturn(hihokenshaDaicho);
        return mock;
    }

    private static FukaMiscManager createFukaMiscManager() {
        FukaMiscManager mock = mock(FukaMiscManager.class);
        Optional<Fuka> fuka = Optional.ofNullable(createFuka());
//        when(mock.get最新介護賦課(any(FlexibleYear.class), any(TsuchishoNo.class))).thenReturn(fuka);
        return mock;
    }

    private static HokenryoDankaiManager createHokenryoDankaiManager() {
        HokenryoDankaiManager mock = mock(HokenryoDankaiManager.class);
        Optional<HokenryoDankai> hokenryoDankai = Optional.ofNullable(createHokenryoDankai());
//        when(mock.get保険料段階(any(FlexibleYear.class), any(LasdecCode.class), any(RString.class))).thenReturn(hokenryoDankai);
        return mock;
    }

    private static KaigoFukaKihonDiv createNewDiv() {
        KaigoFukaKihonDiv div = new KaigoFukaKihonDiv();
        div.setTxtTsuchishoNo(new TextBox());
        div.setTxtHihokenshaNo(new TextBox());
        div.setTxtHokenryoDankai(new TextBox());
        div.setTxtShutokuYmd(new TextBoxFlexibleDate());
        div.setTxtShutokuJiyu(new TextBox());
        div.setTxtSoshitsuYmd(new TextBoxFlexibleDate());
        div.setTxtSoshitsuJiyu(new TextBox());
        return div;
    }

    private static HihokenshaDaichoModel createHihokenshaDaicho() {
        HihokenshaDaichoModel mock = mock(HihokenshaDaichoModel.class);
        when(mock.get被保険者番号()).thenReturn(new HihokenshaNo(被保険者番号));
//        when(mock.get資格取得年月日()).thenReturn(new FlexibleDate(資格取得日.toString()));
//        when(mock.get資格取得事由()).thenReturn(資格取得事由);
//        when(mock.get資格喪失年月日()).thenReturn(new FlexibleDate(資格喪失日.toString()));
//        when(mock.get資格喪失事由()).thenReturn(資格喪失事由);
        return mock;
    }

    private static Fuka createFuka() {
        Fuka mock = mock(Fuka.class);
        when(mock.get保険料段階()).thenReturn(保険料段階);
        return mock;
    }

    private static HokenryoDankai createHokenryoDankai() {
        HokenryoDankai mock = mock(HokenryoDankai.class);
//        when(mock.edit表示用保険料段階()).thenReturn(表示用保険料段階);
        return mock;
    }
}
