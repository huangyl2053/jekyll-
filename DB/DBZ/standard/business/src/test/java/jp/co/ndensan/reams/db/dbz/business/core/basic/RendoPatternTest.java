/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7035RendoPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RendoPattern}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RendoPatternTest extends DbzTestBase {

    private static DbT7035RendoPatternEntity RendoPatternEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 送信元市町村コード;
    private static LasdecCode 送信先市町村コード;
    private static RString 種別;
    private static FlexibleDate 有効開始年月日;
    private static FlexibleDate 有効終了年月日;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        送信元市町村コード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_送信元市町村コード;
        送信先市町村コード = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_送信先市町村コード;
        種別 = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_種別;
        有効開始年月日 = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_有効開始年月日;
        有効終了年月日 = jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7035RendoPatternEntityGenerator.DEFAULT_有効終了年月日;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static RendoPattern sut;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 送信元市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(null, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 送信先市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(送信元市町村コード, null, 種別, 有効開始年月日, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 種別がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(送信元市町村コード, 送信先市町村コード, null, 有効開始年月日, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効開始年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(送信元市町村コード, 送信先市町村コード, 種別, null, 有効終了年月日);
        }

        @Test(expected = NullPointerException.class)
        public void 有効終了年月日がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RendoPattern(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, null);
        }

        @Test
        public void 指定したキーが保持するDbT7035RendoPatternEntityにセットされている() {
            sut = new RendoPattern(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);
            assertThat(sut.get送信元市町村コード(), is(送信元市町村コード));
            assertThat(sut.get送信先市町村コード(), is(送信先市町村コード));
            assertThat(sut.get種別(), is(種別));
            assertThat(sut.get有効開始年月日(), is(有効開始年月日));
            assertThat(sut.get有効終了年月日(), is(有効終了年月日));
        }

        @Test
        public void 指定したキーが保持するRendoPatternIdentifierにセットされている() {
            sut = new RendoPattern(送信元市町村コード, 送信先市町村コード, 種別, 有効開始年月日, 有効終了年月日);
            assertThat(sut.identifier().get送信元市町村コード(), is(送信元市町村コード));
            assertThat(sut.identifier().get送信先市町村コード(), is(送信先市町村コード));
            assertThat(sut.identifier().get種別(), is(種別));
            assertThat(sut.identifier().get有効開始年月日(), is(有効開始年月日));
            assertThat(sut.identifier().get有効終了年月日(), is(有効終了年月日));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static RendoPattern sut;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RendoPattern(null);
        }

        @Test
        public void 指定したDbT7035RendoPatternEntityのキー情報を識別子が持つ() {

            sut = new RendoPattern(RendoPatternEntity);

            assertThat(sut.identifier().get送信元市町村コード(), is(送信元市町村コード));
            assertThat(sut.identifier().get送信先市町村コード(), is(送信先市町村コード));
            assertThat(sut.identifier().get種別(), is(種別));
            assertThat(sut.identifier().get有効開始年月日(), is(有効開始年月日));
            assertThat(sut.identifier().get有効終了年月日(), is(有効終了年月日));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static RendoPattern sut;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void get送信元市町村コードは_entityが持つ送信元市町村コードを返す() {
            assertThat(sut.get送信元市町村コード(), is(RendoPatternEntity.getMotoShichosonCode()));
        }

        @Test
        public void get送信先市町村コードは_entityが持つ送信先市町村コードを返す() {
            assertThat(sut.get送信先市町村コード(), is(RendoPatternEntity.getSakiShichosonCode()));
        }

        @Test
        public void get種別は_entityが持つ種別を返す() {
            assertThat(sut.get種別(), is(RendoPatternEntity.getShubetsu()));
        }

        @Test
        public void get有効開始年月日は_entityが持つ有効開始年月日を返す() {
            assertThat(sut.get有効開始年月日(), is(RendoPatternEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了年月日は_entityが持つ有効終了年月日を返す() {
            assertThat(sut.get有効終了年月日(), is(RendoPatternEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get連動形態コードは_entityが持つ連動形態コードを返す() {
            assertThat(sut.get連動形態コード(), is(RendoPatternEntity.getRendoKeitaiCode()));
        }

        @Test
        public void get送信元フォーマットバージョンは_entityが持つ送信元フォーマットバージョンを返す() {
            assertThat(sut.get送信元フォーマットバージョン(), is(RendoPatternEntity.getMotoFormatVersion()));
        }

        @Test
        public void get送信元エンコーディングは_entityが持つ送信元エンコーディングを返す() {
            assertThat(sut.get送信元エンコーディング(), is(RendoPatternEntity.getMotoEncodeKeitai()));
        }

        @Test
        public void get送信先フォーマットバージョンは_entityが持つ送信先フォーマットバージョンを返す() {
            assertThat(sut.get送信先フォーマットバージョン(), is(RendoPatternEntity.getSakiFormatVersion()));
        }

        @Test
        public void get送信先エンコーディングは_entityが持つ送信先エンコーディングを返す() {
            assertThat(sut.get送信先エンコーディング(), is(RendoPatternEntity.getSakiEncodeKeitai()));
        }

        @Test
        public void getコード変換区分は_entityが持つコード変換区分を返す() {
            assertThat(sut.getコード変換区分(), is(RendoPatternEntity.getCodeHenkanKubun()));
        }

        @Test
        public void get外字変換区分は_entityが持つ外字変換区分を返す() {
            assertThat(sut.get外字変換区分(), is(RendoPatternEntity.getGaijiHenkanKubun()));
        }

        @Test
        public void get全件連動区分は_entityが持つ全件連動区分を返す() {
            assertThat(sut.get全件連動区分(), is(RendoPatternEntity.getZenkenRendoKubun()));
        }

        @Test
        public void get連携区分は_entityが持つ連携区分を返す() {
            assertThat(sut.get連携区分(), is(RendoPatternEntity.getRendoKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static RendoPattern sut;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RendoPatternEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static RendoPattern sut;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();

            sut = new RendoPattern(RendoPatternEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static RendoPattern sut;
        private static RendoPattern result;

        @BeforeClass
        public static void setUpClass() {
            RendoPatternEntity = DbT7035RendoPatternEntityGenerator.createDbT7035RendoPatternEntity();

        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがDeletedに指定されたRendoPatternが返る() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RendoPatternが保持するDbT7035RendoPatternEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRendoPattern(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RendoPattern setStateRendoPattern(EntityDataState parentState) {
            RendoPatternEntity.setState(parentState);
            return new RendoPattern(RendoPatternEntity);
        }
    }
}
