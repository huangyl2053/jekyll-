/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoHanyo}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoHanyoTest extends DbzTestBase {

    private static DbT7067ChohyoSeigyoHanyoEntity ChohyoSeigyoHanyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode 主キー名1;
    private static ReportId 主キー名2;
    private static RString 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード;
        主キー名2 = DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoHanyo(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoHanyo(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT7067ChohyoSeigyoHanyoEntityにセットされている() {
            sut = new ChohyoSeigyoHanyo(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChohyoSeigyoHanyoIdentifierにセットされている() {
            sut = new ChohyoSeigyoHanyo(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.getサブ業務コード(), is(主キー名1));
            assertThat(sut.get帳票分類ID(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChohyoSeigyoHanyo(null);
        }

        @Test
        public void 指定したDbT7067ChohyoSeigyoHanyoEntityのキー情報を識別子が持つ() {

            sut = new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);

            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(ChohyoSeigyoHanyoEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(ChohyoSeigyoHanyoEntity.getChohyoBunruiID()));
        }

        @Test
        public void get項目名は_entityが持つ項目名を返す() {
            assertThat(sut.get項目名(), is(ChohyoSeigyoHanyoEntity.getKomokuName()));
        }

        @Test
        public void get設定値は_entityが持つ設定値を返す() {
            assertThat(sut.get設定値(), is(ChohyoSeigyoHanyoEntity.getKomokuValue()));
        }

        @Test
        public void get説明は_entityが持つ説明を返す() {
            assertThat(sut.get説明(), is(ChohyoSeigyoHanyoEntity.getKomokuSetsumei()));
        }

        @Test
        public void get変更可否は_entityが持つ変更可否を返す() {
            assertThat(sut.get変更可否(), is(ChohyoSeigyoHanyoEntity.getHenkoKahi()));
        }

        @Test
        public void getコードマスタサブ業務コードは_entityが持つコードマスタサブ業務コードを返す() {
            assertThat(sut.getコードマスタサブ業務コード(), is(ChohyoSeigyoHanyoEntity.getCodeMasterSubGyomuCode()));
        }

        @Test
        public void getコードマスタコード種別は_entityが持つコードマスタコード種別を返す() {
            assertThat(sut.getコードマスタコード種別(), is(ChohyoSeigyoHanyoEntity.getCodeMasterCodeShubetsu()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChohyoSeigyoHanyoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChohyoSeigyoHanyo sut;
        private static ChohyoSeigyoHanyo result;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = DbT7067ChohyoSeigyoHanyoEntityGenerator.createDbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);

        }

        @Test
        public void ChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoHanyoが返る() {
            sut = TestSupport.setStateChohyoSeigyoHanyo(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoHanyoが返る() {
            sut = TestSupport.setStateChohyoSeigyoHanyo(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoHanyoが返る() {
            sut = TestSupport.setStateChohyoSeigyoHanyo(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChohyoSeigyoHanyoが保持するDbT7067ChohyoSeigyoHanyoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChohyoSeigyoHanyo(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChohyoSeigyoHanyo setStateChohyoSeigyoHanyo(EntityDataState parentState) {
            ChohyoSeigyoHanyoEntity.setState(parentState);
            return new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);
        }
    }
}
