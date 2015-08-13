/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuTest extends DbzTestBase {

    private static DbT1005KaigoJogaiTokureiTaishoShisetsuEntity KaigoJogaiTokureiTaishoShisetsuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 事業者種別;
    private static RString 事業者番号;
    private static FlexibleDate 有効開始日時;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        事業者種別 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者種別;
        事業者番号 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_事業者番号;
        有効開始日時 = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.DEFAULT_有効開始年月日;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 事業者種別がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(null, 事業者番号, 有効開始日時);
        }

        @Test(expected = NullPointerException.class)
        public void 事業者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(事業者種別, null, 有効開始日時);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始日時がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(事業者種別, 事業者番号, null);
        }

        @Test
        public void 指定したキーが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityにセットされている() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(事業者種別, 事業者番号, 有効開始日時);
            assertThat(sut.get事業者種別(), is(事業者種別));
            assertThat(sut.get事業者番号(), is(事業者番号));
            assertThat(sut.get有効開始年月日(), is(有効開始日時));
        }

        @Test
        public void 指定したキーが保持するKaigoJogaiTokureiTaishoShisetsuIdentifierにセットされている() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(事業者種別, 事業者番号, 有効開始日時);
//            assertThat(sut.identifier().getXXX(), is(事業者種別));
//            assertThat(sut.identifier().getXXX(), is(事業者番号));
//            assertThat(sut.identifier().getXXX(), is(有効開始日時));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KaigoJogaiTokureiTaishoShisetsu(null);
        }

        @Test
        public void 指定したDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのキー情報を識別子が持つ() {

            sut = new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);

//            assertThat(sut.identifier().getXXX(), is(事業者種別));
//            assertThat(sut.identifier().getXXX(), is(事業者番号));
//            assertThat(sut.identifier().getXXX(), is(有効開始日時));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);

            sut = new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);
        }

        @Test
        public void get事業者種別は_entityが持つ事業者種別を返す() {
            assertThat(sut.get事業者種別(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaShubetsu()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaNo()));
        }

        @Test
        public void get有効開始年月日は_entityが持つ有効開始年月日を返す() {
            assertThat(sut.get有効開始年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了年月日は_entityが持つ有効終了年月日を返す() {
            assertThat(sut.get有効終了年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get管内_管外区分は_entityが持つ管内_管外区分を返す() {
            assertThat(sut.get管内_管外区分(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getKannaiKangaiKubun()));
        }

        @Test
        public void get事業者名称は_entityが持つ事業者名称を返す() {
            assertThat(sut.get事業者名称(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaMeisho()));
        }

        @Test
        public void get事業者名称カナは_entityが持つ事業者名称カナを返す() {
            assertThat(sut.get事業者名称カナ(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaKanaMeisho()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getYubinNo()));
        }

        @Test
        public void get事業者住所は_entityが持つ事業者住所を返す() {
            assertThat(sut.get事業者住所(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaJusho()));
        }

        @Test
        public void get事業者住所カナは_entityが持つ事業者住所カナを返す() {
            assertThat(sut.get事業者住所カナ(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoshaKanaJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getFaxNo()));
        }

        @Test
        public void get異動事由は_entityが持つ異動事由を返す() {
            assertThat(sut.get異動事由(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getIdoJiyuCode()));
        }

        @Test
        public void get異動年月日は_entityが持つ異動年月日を返す() {
            assertThat(sut.get異動年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getIdoYMD()));
        }

        @Test
        public void get代表者名称は_entityが持つ代表者名称を返す() {
            assertThat(sut.get代表者名称(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getDaihyoshaMeisho()));
        }

        @Test
        public void get代表者名称カナは_entityが持つ代表者名称カナを返す() {
            assertThat(sut.get代表者名称カナ(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getDaihyoshaKanaMeisho()));
        }

        @Test
        public void get役職は_entityが持つ役職を返す() {
            assertThat(sut.get役職(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getYakushoku()));
        }

        @Test
        public void get備考は_entityが持つ備考を返す() {
            assertThat(sut.get備考(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getBiko()));
        }

        @Test
        public void get事業開始年月日は_entityが持つ事業開始年月日を返す() {
            assertThat(sut.get事業開始年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoKaishiYMD()));
        }

        @Test
        public void get事業休止年月日は_entityが持つ事業休止年月日を返す() {
            assertThat(sut.get事業休止年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoKyushiYMD()));
        }

        @Test
        public void get事業廃止年月日は_entityが持つ事業廃止年月日を返す() {
            assertThat(sut.get事業廃止年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoHaishiYMD()));
        }

        @Test
        public void get事業再開年月日は_entityが持つ事業再開年月日を返す() {
            assertThat(sut.get事業再開年月日(), is(KaigoJogaiTokureiTaishoShisetsuEntity.getJigyoSaikaiYMD()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);

            sut = new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KaigoJogaiTokureiTaishoShisetsuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);

            sut = new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KaigoJogaiTokureiTaishoShisetsu sut;
        private static KaigoJogaiTokureiTaishoShisetsu result;

        @Before
        public void setUp() {
            KaigoJogaiTokureiTaishoShisetsuEntity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaShubetsu(事業者種別);
            KaigoJogaiTokureiTaishoShisetsuEntity.setJigyoshaNo(事業者番号);
            KaigoJogaiTokureiTaishoShisetsuEntity.setYukoKaishiYMD(有効開始日時);

        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがDeletedに指定されたKaigoJogaiTokureiTaishoShisetsuが返る() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KaigoJogaiTokureiTaishoShisetsuが保持するDbT1005KaigoJogaiTokureiTaishoShisetsuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKaigoJogaiTokureiTaishoShisetsu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KaigoJogaiTokureiTaishoShisetsu setStateKaigoJogaiTokureiTaishoShisetsu(EntityDataState parentState) {
            KaigoJogaiTokureiTaishoShisetsuEntity.setState(parentState);
            return new KaigoJogaiTokureiTaishoShisetsu(KaigoJogaiTokureiTaishoShisetsuEntity);
        }
    }
}
