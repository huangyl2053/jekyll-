/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.db.dbx.persistence.relate.IKaigoHokenJukyushaDac;
import jp.co.ndensan.reams.db.dbx.persistence.relate.KaigoHokenJukyushaDac;
import jp.co.ndensan.reams.db.dbx.realservice.helper.KaigoJukyushaAndKojinEntityMock;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 介護保険受給者finderのテストクラスです。
 *
 * @author N2806 太田 智之
 */
@RunWith(Enclosed.class)
public class _KaigoHokenJukyushaFinderTest extends DbxTestBase {
    // TODO N2102 池田 豊 テストコードの見直しおよび再テストが必要。期限：2014/3月末

    private static _KaigoHokenJukyushaFinder sut;

    public static class get要介護受給者_識別コード extends DbxTestBase {

        static {
            setDummyControlData(new RString("URF"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを渡すと_get要介護受給者_識別コードは_NullPointerExceptionを発生させる() {
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(mock(IKaigoHokenJukyushaDac.class));
            sut.get要介護受給者(null);
        }

        @Test
        public void 識別コード00000000000001が直近で介護受給者でない場合_get要介護受給者_識別コードは_nullを返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(eq(shikibetsuCode.value()), any(RDate.class))).thenReturn(null);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者(shikibetsuCode), is(nullValue()));
        }

        @Ignore //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にIgnore。期限:2015/7末まで。
        @Test
        public void 識別コード00000000000001が直近で介護受給者である場合_get要介護受給者_識別コードは_識別コード00000000000001の受給者情報を返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            KaigohokenJukyushaAndKojinEntity entity = KaigoJukyushaAndKojinEntityMock.getSpiedInstance();
            UaFt200FindShikibetsuTaishoEntity vKojin = entity.getKojinEntity();
            //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にコメントアウト。期限:2015/7末まで。
//            when(vKojin.getShikibetsuCode()).thenReturn(new ShikibetsuCode(new RString("00000000000001")));
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(eq(shikibetsuCode.value()), any(RDate.class))).thenReturn(entity);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者(shikibetsuCode).get個人().get識別コード(), is(shikibetsuCode));
        }
    }

    public static class get要介護受給者_識別コード_基準日 extends DbxTestBase {

        static {
            setDummyControlData(new RString("URF"));
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを渡すと_get要介護受給者_識別コード_基準日は_NullPointerExceptionを発生させる() {
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(mock(IKaigoHokenJukyushaDac.class));
            sut.get要介護受給者(null, RDate.MAX);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の基準日にnullを渡すと_get要介護受給者_識別コード_基準日は_NullPointerExceptionを発生させる() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(mock(IKaigoHokenJukyushaDac.class));
            sut.get要介護受給者(shikibetsuCode, null);
        }

        @Test
        public void 識別コード00000000000001が基準日時点で介護受給者でない場合_get要介護受給者_識別コード_基準日は_nullを返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            RDate date = new RDate(2012, 1, 1);
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(shikibetsuCode.value(), date)).thenReturn(null);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者(shikibetsuCode, date), is(nullValue()));
        }

        @Ignore //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にIgnore。期限:2015/7末まで。
        @Test
        public void 識別コード00000000000001が基準日時点で介護受給者である場合_get要介護受給者_識別コード_基準日は_識別コード00000000000001の受給者情報を返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            RDate date = new RDate(2012, 1, 1);
            KaigohokenJukyushaAndKojinEntity entity = KaigoJukyushaAndKojinEntityMock.getSpiedInstance();
            UaFt200FindShikibetsuTaishoEntity vKojin = entity.getKojinEntity();
            //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にコメントアウト。期限:2015/7末まで。
//            when(vKojin.getShikibetsuCode()).thenReturn(new ShikibetsuCode(new RString("00000000000001")));
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(shikibetsuCode.value(), date)).thenReturn(entity);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者(shikibetsuCode, date).get個人().get識別コード(), is(shikibetsuCode));

        }
    }

    public static class get要介護受給者履歴_識別コード extends DbxTestBase {

        @Test
        public void 識別コード00000000000001の介護受給者がない場合_get要介護受給者履歴_識別コードは_nullを返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(shikibetsuCode.value())).thenReturn(Collections.EMPTY_LIST);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者履歴(shikibetsuCode), is(nullValue()));
        }

        @Ignore //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にIgnore。期限:2015/7末まで。
        @Test
        public void 識別コード00000000000001の介護受給者がある場合_get要介護受給者履歴_識別コードは_識別コード00000000000001の受給者情報を返す() {
            ShikibetsuCode shikibetsuCode = new ShikibetsuCode(new RString("00000000000001"));
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList<>();
            KaigohokenJukyushaAndKojinEntity entity = KaigoJukyushaAndKojinEntityMock.getSpiedInstance();
            UaFt200FindShikibetsuTaishoEntity vKojin = entity.getKojinEntity();
            //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にコメントアウト。期限:2015/7末まで。
//            when(vKojin.getShikibetsuCode()).thenReturn(new ShikibetsuCode(new RString("00000000000001")));
            entityList.add(entity);
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(shikibetsuCode.value())).thenReturn(entityList);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者履歴(shikibetsuCode).get個人().get識別コード(), is(shikibetsuCode));
        }
    }

    public static class get要介護受給者リスト_要介護状態区分 extends DbxTestBase {

        @Test
        public void 要支援1から要支援2の介護受給者がない場合_get要介護受給者履歴_要介護状態区分は_空のリストを返す() {
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(eq(YoKaigoJotaiKubun.要支援1), eq(YoKaigoJotaiKubun.要支援2), any(RDate.class))).thenReturn(Collections.EMPTY_LIST);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者リスト(YoKaigoJotaiKubun.要支援1, YoKaigoJotaiKubun.要支援2), is(Collections.EMPTY_LIST));
        }

        @Ignore //TODO n3304 岡澤 政幸 UA:Ver0.2.1リリースにより発生したエラーの対応方法が決定するまで一時的にIgnore。期限:2015/7末まで。
        @Test
        public void 要介護1から要介護2の介護受給者が2件ある場合_get要介護受給者履歴_要介護状態区分は_リストサイズ2の受給者情報を返す() {
            List<KaigohokenJukyushaAndKojinEntity> entityList = new ArrayList<>();
            KaigohokenJukyushaAndKojinEntity entity1 = KaigoJukyushaAndKojinEntityMock.getSpiedInstance();
//            when(entity1.getKojinEntity().getShikibetsuCode().value()).thenReturn(new RString("00000000000001"));
            entityList.add(entity1);
            KaigohokenJukyushaAndKojinEntity entity2 = KaigoJukyushaAndKojinEntityMock.getSpiedInstance();
//            when(entity2.getKojinEntity().getShikibetsuCode().value()).thenReturn(new RString("00000000000002"));
            entityList.add(entity2);
            IKaigoHokenJukyushaDac dac = mock(KaigoHokenJukyushaDac.class);
            when(dac.select(eq(YoKaigoJotaiKubun.要介護1), eq(YoKaigoJotaiKubun.要介護2), any(RDate.class))).thenReturn(entityList);
            IKaigoHokenJukyushaFinder sut = new _KaigoHokenJukyushaFinder(dac);
            assertThat(sut.get要介護受給者リスト(YoKaigoJotaiKubun.要介護1, YoKaigoJotaiKubun.要介護2).size(), is(2));
        }
    }

    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKaigoHokenJukyushaFinderが呼び出される場合_KaigoHokenJukyushaFinderは_インスタンス化成功() {
            sut = new _KaigoHokenJukyushaFinder();
        }
    }
}
