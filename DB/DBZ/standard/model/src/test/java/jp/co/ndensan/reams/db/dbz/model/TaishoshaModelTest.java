/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihoKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.relate.TaishoshaRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * 対象者のモデルのテストクラスです。（資格系）
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class TaishoshaModelTest extends DbzTestBase {

    private static final RString 適用除外適用事由コード = new RString("01");
    private static final RString 他市町村住所地特例適用事由コード = new RString("02");
    private static final RString 住所地特例者 = new RString("1");
    private static final RString 通常資格者 = new RString("2");
    private static final HihokenshaNo 被保険者番号 = new HihokenshaNo("0000000003");
    private static final FlexibleDate 資格喪失日 = new FlexibleDate("20140404");

    private static TaishoshaModel sut;

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 対象者エンティティがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new TaishoshaModel(null);
        }
    }

    public static class get被保区分 {

        @Test
        public void 適用除外適用事由コードがあるとき_get被保区分は_適除を返す() {
            sut = new TaishoshaModel(createTaishoshaRelateEntity(適用除外適用事由コード, null, 通常資格者, null, null));
            assertThat(sut.get被保区分(), is(HihoKubun.適除));

        }

        @Test
        public void 他市町村住所地特例適用事由コードがあるとき_get被保区分は_他住を返す() {
            sut = new TaishoshaModel(createTaishoshaRelateEntity(null, 他市町村住所地特例適用事由コード, 通常資格者, null, null));
            assertThat(sut.get被保区分(), is(HihoKubun.他住));

        }

        @Test
        public void 住所地特例者のとき_get被保区分は_自住を返す() {
            sut = new TaishoshaModel(createTaishoshaRelateEntity(null, null, 住所地特例者, null, null));
            assertThat(sut.get被保区分(), is(HihoKubun.自住));

        }

        @Test
        public void 被保険者番号があり_資格喪失日がないとき_get被保区分は_資格を返す() {
            sut = new TaishoshaModel(createTaishoshaRelateEntity(null, null, 通常資格者, 被保険者番号, null));
            assertThat(sut.get被保区分(), is(HihoKubun.資格));

        }

        @Test
        public void 上記以外のとき_get被保区分は_EMPTYを返す() {
            sut = new TaishoshaModel(createTaishoshaRelateEntity(null, null, 通常資格者, 被保険者番号, 資格喪失日));
            assertThat(sut.get被保区分(), is(HihoKubun.UNKNOWN));

        }
    }

    private static TaishoshaRelateEntity createTaishoshaRelateEntity(
            RString 適用除外適用事由コード, RString 他市町村住所地特例適用事由コード, RString 住所地特例フラグ,
            HihokenshaNo 被保険者番号, FlexibleDate 資格喪失日) {
        DbV7901ShikakuSearchEntity shikakuSearchEntity = mock(DbV7901ShikakuSearchEntity.class);
        when(shikakuSearchEntity.getTekiyoJogaiTekiyoJiyuCode()).thenReturn(適用除外適用事由コード);
        when(shikakuSearchEntity.getTatokureiTekiyoJiyuCode()).thenReturn(他市町村住所地特例適用事由コード);
        when(shikakuSearchEntity.getJushochiTokureiFlag()).thenReturn(住所地特例フラグ);
        when(shikakuSearchEntity.getHihokenshaNo()).thenReturn(被保険者番号);
        when(shikakuSearchEntity.getShikakuSoshitsuYMD()).thenReturn(資格喪失日);
        TaishoshaRelateEntity taishoshaRelateEntity = mock(TaishoshaRelateEntity.class);
        when(taishoshaRelateEntity.get資格検索エンティティ()).thenReturn(shikakuSearchEntity);
        return taishoshaRelateEntity;
    }
}
