/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoshikakukihon;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.realservice.hihokenshadaicho.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.business.IKobetsuJikoKaigoJukyu;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.realservice.IJukyuDaichoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * 介護資格基本情報Divの操作を行うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KaigoShikakuKihonHandlerTest extends DbzTestBase {

    private static final LasdecCode 市町村コード = new LasdecCode("000002");
    private static final ShikibetsuCode 識別コード = new ShikibetsuCode("000000000000002");
    private static final RString 被保険者番号 = new RString("000003");
    private static final ShikakuShutokuJiyu 資格取得事由 = ShikakuShutokuJiyu.転入;
    private static final FlexibleDate 資格取得日 = new FlexibleDate("20140202");
    private static final ShikakuSoshitsuJiyu 資格喪失事由 = ShikakuSoshitsuJiyu.転出;
    private static final FlexibleDate 資格喪失日 = new FlexibleDate("20140404");
    private static final JushochitokureishaKubun 住所地特例者区分 = JushochitokureishaKubun.通常資格者;
    private static final ShoriTimestamp 処理日時 = ShoriTimestamp.of(new YMDHMS("20140102030405"));
    private static final YoKaigoJotaiKubun 要介護状態区分 = YoKaigoJotaiKubun.要介護1;
    private static final RDate 認定有効開始日 = new RDate("20140505");
    private static final RDate 認定有効終了日 = new RDate("20140606");

    public static class constructor extends DbzTestBase {

        KaigoShikakuKihonHandler sut;
        KaigoShikakuKihonDiv result;

        @Test
        public void コンストラクタを起動できる() {
            KaigoShikakuKihonHandler sut = new KaigoShikakuKihonHandler(new KaigoShikakuKihonDiv());
        }
    }

    public static class load {

        private KaigoShikakuKihonDiv result;

        @Before
        public void setup() {
            result = createNewDiv();
            new KaigoShikakuKihonHandler(result, createHihokenshaDaichoManager(), createJukyuDaichoFinder()).load(市町村コード, 識別コード);
        }

        @Test
        public void 被保険者番号のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtHihokenshaNo().getValue(), is(被保険者番号));
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
            assertThat(result.getTxtSoshitsuJiyu().getValue(), is(資格喪失事由.getName()));
        }

        @Test
        public void 住所地特例者区分のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtJutokuKubun().getValue(), is(new RString(住所地特例者区分.name())));
        }

        @Test
        public void 要介護状態区分のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtYokaigoJotaiKubun().getValue(), is(new RString(要介護状態区分.name())));
        }

        @Test
        public void 認定有効開始日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtNinteiKaishiYmd().getValue(), is(認定有効開始日));
        }

        @Test
        public void 認定有効終了日のデータがある時_loadは_データをDivに設定する() {
            assertThat(result.getTxtNinteiShuryoYmd().getValue(), is(認定有効終了日));
        }
    }

    private static HihokenshaDaichoManager createHihokenshaDaichoManager() {
        HihokenshaDaichoManager mock = mock(HihokenshaDaichoManager.class);
        Optional<HihokenshaDaichoModel> hihokenshaDaicho = Optional.ofNullable(createHihokenshaDaicho());
        when(mock.get最新被保険者台帳(any(LasdecCode.class), any(ShikibetsuCode.class))).thenReturn(hihokenshaDaicho);
        return mock;
    }

    private static IJukyuDaichoFinder createJukyuDaichoFinder() {
        IJukyuDaichoFinder mock = mock(IJukyuDaichoFinder.class);
        IKobetsuJikoKaigoJukyu jukyu = createJukyuDaicho();
        when(mock.get個別事項介護受給(any(ShikibetsuCode.class), any(RDate.class))).thenReturn(jukyu);
        return mock;
    }

    private static KaigoShikakuKihonDiv createNewDiv() {
        KaigoShikakuKihonDiv div = new KaigoShikakuKihonDiv();
        div.setTxtHihokenshaNo(new TextBox());
        div.setTxtShutokuYmd(new TextBoxFlexibleDate());
        div.setTxtShutokuJiyu(new TextBox());
        div.setTxtSoshitsuYmd(new TextBoxFlexibleDate());
        div.setTxtSoshitsuJiyu(new TextBox());
        div.setTxtJutokuKubun(new TextBox());
        div.setTxtYokaigoJotaiKubun(new TextBox());
        div.setTxtNinteiKaishiYmd(new TextBoxDate());
        div.setTxtNinteiShuryoYmd(new TextBoxDate());
        return div;
    }

    private static HihokenshaDaichoModel createHihokenshaDaicho() {
        HihokenshaDaichoModel mock = mock(HihokenshaDaichoModel.class);
        when(mock.get被保険者番号()).thenReturn(new HihokenshaNo(被保険者番号));
        when(mock.get資格取得年月日()).thenReturn(new FlexibleDate(資格取得日.toString()));
        when(mock.get資格取得事由()).thenReturn(資格取得事由);
        when(mock.get資格喪失年月日()).thenReturn(new FlexibleDate(資格喪失日.toString()));
        when(mock.get資格喪失事由()).thenReturn(資格喪失事由);
        when(mock.get住所地特例者区分()).thenReturn(住所地特例者区分);
        when(mock.get処理日時()).thenReturn(処理日時);
        return mock;
    }

    private static IKobetsuJikoKaigoJukyu createJukyuDaicho() {
        IKobetsuJikoKaigoJukyu mock = mock(IKobetsuJikoKaigoJukyu.class);
        when(mock.get要介護状態区分()).thenReturn(要介護状態区分);
        when(mock.get認定有効開始日()).thenReturn(認定有効開始日);
        when(mock.get認定有効終了日()).thenReturn(認定有効終了日);
        return mock;
    }
}
