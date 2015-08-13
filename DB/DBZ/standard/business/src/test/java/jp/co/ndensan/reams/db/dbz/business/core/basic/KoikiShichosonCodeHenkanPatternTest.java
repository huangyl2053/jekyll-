/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7024KoikiShichosonCodeHenkanPatternEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link KoikiShichosonCodeHenkanPattern}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiShichosonCodeHenkanPatternTest extends DbzTestBase {

    private static DbT7024KoikiShichosonCodeHenkanPatternEntity KoikiShichosonCodeHenkanPatternEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 広域内市町村番号;
    private static LasdecCode 市町村コード;
    private static RString コード区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        広域内市町村番号 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_広域内市町村番号;
        市町村コード = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_市町村コード;
        コード区分 = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.DEFAULT_コード区分;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 広域内市町村番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiShichosonCodeHenkanPattern(null, 市町村コード, コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiShichosonCodeHenkanPattern(広域内市町村番号, null, コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void コード区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KoikiShichosonCodeHenkanPattern(広域内市町村番号, 市町村コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityにセットされている() {
            sut = new KoikiShichosonCodeHenkanPattern(広域内市町村番号, 市町村コード, コード区分);
            assertThat(sut.get広域内市町村番号(), is(広域内市町村番号));
            assertThat(sut.get市町村コード(), is(市町村コード));
        }

        @Test
        public void 指定したキーが保持するKoikiShichosonCodeHenkanPatternIdentifierにセットされている() {
            sut = new KoikiShichosonCodeHenkanPattern(広域内市町村番号, 市町村コード, コード区分);
//            assertThat(sut.identifier().getXXX(), is(広域内市町村番号));
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KoikiShichosonCodeHenkanPattern(null);
        }

        @Test
        public void 指定したDbT7024KoikiShichosonCodeHenkanPatternEntityのキー情報を識別子が持つ() {

            sut = new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);

//            assertThat(sut.identifier().getXXX(), is(広域内市町村番号));
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);

            sut = new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);
        }

        @Test
        public void get広域内市町村番号は_entityが持つ広域内市町村番号を返す() {
            assertThat(sut.get広域内市町村番号(), is(KoikiShichosonCodeHenkanPatternEntity.getKoikiShichosonNo()));
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonCode()));
        }

        @Test
        public void getコード区分は_entityが持つコード区分を返す() {
            assertThat(sut.getコード区分(), is(KoikiShichosonCodeHenkanPatternEntity.getCodeKubun()));
        }

        @Test
        public void getコード変換テーブル使用区分は_entityが持つコード変換テーブル使用区分を返す() {
            assertThat(sut.getコード変換テーブル使用区分(), is(KoikiShichosonCodeHenkanPatternEntity.getCodeHenkanTableShiyoUmu()));
        }

        @Test
        public void get自動採番区分は_entityが持つ自動採番区分を返す() {
            assertThat(sut.get自動採番区分(), is(KoikiShichosonCodeHenkanPatternEntity.getJidoSaibanKubun()));
        }

        @Test
        public void get市町村用コード桁数は_entityが持つ市町村用コード桁数を返す() {
            assertThat(sut.get市町村用コード桁数(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonCodeKetasu()));
        }

        @Test
        public void get市町村用コード開始位置は_entityが持つ市町村用コード開始位置を返す() {
            assertThat(sut.get市町村用コード開始位置(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonCodeKaishiIchi()));
        }

        @Test
        public void get市町村用コード使用桁数は_entityが持つ市町村用コード使用桁数を返す() {
            assertThat(sut.get市町村用コード使用桁数(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonCodeShiyoKetasu()));
        }

        @Test
        public void get市町村用チェックディジット有無区分は_entityが持つ市町村用チェックディジット有無区分を返す() {
            assertThat(sut.get市町村用チェックディジット有無区分(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonNinshoNoUmu()));
        }

        @Test
        public void get広域用コード桁数は_entityが持つ広域用コード桁数を返す() {
            assertThat(sut.get広域用コード桁数(), is(KoikiShichosonCodeHenkanPatternEntity.getKoikiCodeKetasu()));
        }

        @Test
        public void get広域用コード開始位置は_entityが持つ広域用コード開始位置を返す() {
            assertThat(sut.get広域用コード開始位置(), is(KoikiShichosonCodeHenkanPatternEntity.getKoikiCodeKaishiIchi()));
        }

        @Test
        public void get広域用コード使用桁数は_entityが持つ広域用コード使用桁数を返す() {
            assertThat(sut.get広域用コード使用桁数(), is(KoikiShichosonCodeHenkanPatternEntity.getKoikiCodeShiyoKetasu()));
        }

        @Test
        public void get広域用チェックディジット有無区分は_entityが持つ広域用チェックディジット有無区分を返す() {
            assertThat(sut.get広域用チェックディジット有無区分(), is(KoikiShichosonCodeHenkanPatternEntity.getKoikiNinshoNoUmu()));
        }

        @Test
        public void get広域内市町村番号付加区分は_entityが持つ広域内市町村番号付加区分を返す() {
            assertThat(sut.get広域内市町村番号付加区分(), is(KoikiShichosonCodeHenkanPatternEntity.getShichosonNoFukaKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);

            sut = new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KoikiShichosonCodeHenkanPatternEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);

            sut = new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static KoikiShichosonCodeHenkanPattern sut;
        private static KoikiShichosonCodeHenkanPattern result;

        @Before
        public void setUp() {
            KoikiShichosonCodeHenkanPatternEntity = DbT7024KoikiShichosonCodeHenkanPatternEntityGenerator.createDbT7024KoikiShichosonCodeHenkanPatternEntity();
            KoikiShichosonCodeHenkanPatternEntity.setKoikiShichosonNo(広域内市町村番号);
            KoikiShichosonCodeHenkanPatternEntity.setShichosonCode(市町村コード);
            KoikiShichosonCodeHenkanPatternEntity.setCodeKubun(コード区分);

        }

        @Test
        public void KoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがDeletedに指定されたKoikiShichosonCodeHenkanPatternが返る() {
            sut = TestSupport.setStateKoikiShichosonCodeHenkanPattern(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがDeletedに指定されたKoikiShichosonCodeHenkanPatternが返る() {
            sut = TestSupport.setStateKoikiShichosonCodeHenkanPattern(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがDeletedに指定されたKoikiShichosonCodeHenkanPatternが返る() {
            sut = TestSupport.setStateKoikiShichosonCodeHenkanPattern(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KoikiShichosonCodeHenkanPatternが保持するDbT7024KoikiShichosonCodeHenkanPatternEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKoikiShichosonCodeHenkanPattern(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KoikiShichosonCodeHenkanPattern setStateKoikiShichosonCodeHenkanPattern(EntityDataState parentState) {
            KoikiShichosonCodeHenkanPatternEntity.setState(parentState);
            return new KoikiShichosonCodeHenkanPattern(KoikiShichosonCodeHenkanPatternEntity);
        }
    }
}
