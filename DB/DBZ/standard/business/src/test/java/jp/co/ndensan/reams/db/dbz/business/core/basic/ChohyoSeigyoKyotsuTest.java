/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7065ChohyoSeigyoKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * {@link ChohyoSeigyoKyotsu}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuTest extends DbzTestBase {

    private static DbT7065ChohyoSeigyoKyotsuEntity ChohyoSeigyoKyotsuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode 主キー名1;
    private static ReportId 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード;
        主キー名2 = DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoKyotsu(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoKyotsu(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7065ChohyoSeigyoKyotsuEntityにセットされている() {
            sut = new ChohyoSeigyoKyotsu(主キー名1, 主キー名2);
            assertThat(sut.getサブ業務コード(), is(主キー名1));
            assertThat(sut.get帳票分類ID(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChohyoSeigyoKyotsuIdentifierにセットされている() {
            sut = new ChohyoSeigyoKyotsu(主キー名1, 主キー名2);
            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChohyoSeigyoKyotsu(null);
        }

        @Test
        public void 指定したDbT7065ChohyoSeigyoKyotsuEntityのキー情報を識別子が持つ() {

            sut = new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);

            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(ChohyoSeigyoKyotsuEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(ChohyoSeigyoKyotsuEntity.getChohyoBunruiID()));
        }

        @Test
        public void get帳票分類名称は_entityが持つ帳票分類名称を返す() {
            assertThat(sut.get帳票分類名称(), is(ChohyoSeigyoKyotsuEntity.getChohyoBunruiMeisho()));
        }

        @Test
        public void get住所編集区分は_entityが持つ住所編集区分を返す() {
            assertThat(sut.get住所編集区分(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuKubun()));
        }

        @Test
        public void get住所編集都道府県名表示有無は_entityが持つ住所編集都道府県名表示有無を返す() {
            assertThat(sut.get住所編集都道府県名表示有無(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuTodoufukenMeiHyojiUmu()));
        }

        @Test
        public void get住所編集郡名表示有無は_entityが持つ住所編集郡名表示有無を返す() {
            assertThat(sut.get住所編集郡名表示有無(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuGunMeiHyojiUmu()));
        }

        @Test
        public void get住所編集市町村名表示有無は_entityが持つ住所編集市町村名表示有無を返す() {
            assertThat(sut.get住所編集市町村名表示有無(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuShichosonMeiHyojiUmu()));
        }

        @Test
        public void get住所編集町域編集方法は_entityが持つ住所編集町域編集方法を返す() {
            assertThat(sut.get住所編集町域編集方法(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuChoikiHenshuHoho()));
        }

        @Test
        public void get住所編集方書表示有無は_entityが持つ住所編集方書表示有無を返す() {
            assertThat(sut.get住所編集方書表示有無(), is(ChohyoSeigyoKyotsuEntity.getJushoHenshuKatagakiHyojiUmu()));
        }

        @Test
        public void get世帯主表示有無は_entityが持つ世帯主表示有無を返す() {
            assertThat(sut.get世帯主表示有無(), is(ChohyoSeigyoKyotsuEntity.getSetainushiHyojiUmu()));
        }

        @Test
        public void getカスタマバーコード使用有無は_entityが持つカスタマバーコード使用有無を返す() {
            assertThat(sut.getカスタマバーコード使用有無(), is(ChohyoSeigyoKyotsuEntity.getCustomerBarCodeShiyoUmu()));
        }

        @Test
        public void getカスタマバーコード変換エラー編集方法は_entityが持つカスタマバーコード変換エラー編集方法を返す() {
            assertThat(sut.getカスタマバーコード変換エラー編集方法(), is(ChohyoSeigyoKyotsuEntity.getCustomerBarCodeHenkanErrHenshuHoho()));
        }

        @Test
        public void get外部帳票文字切れ制御は_entityが持つ外部帳票文字切れ制御を返す() {
            assertThat(sut.get外部帳票文字切れ制御(), is(ChohyoSeigyoKyotsuEntity.getGaibuChohyoMojigireSeigyo()));
        }

        @Test
        public void get内部帳票文字切れ制御は_entityが持つ内部帳票文字切れ制御を返す() {
            assertThat(sut.get内部帳票文字切れ制御(), is(ChohyoSeigyoKyotsuEntity.getNaibuChohyoMojigireSeigyo()));
        }

        @Test
        public void get文字切れ分離制御は_entityが持つ文字切れ分離制御を返す() {
            assertThat(sut.get文字切れ分離制御(), is(ChohyoSeigyoKyotsuEntity.getMojigireBunriSeigyo()));
        }

        @Test
        public void get定型文文字サイズは_entityが持つ定型文文字サイズを返す() {
            assertThat(sut.get定型文文字サイズ(), is(ChohyoSeigyoKyotsuEntity.getTeikeibunMojiSize()));
        }

        @Test
        public void get口座マスク有無は_entityが持つ口座マスク有無を返す() {
            assertThat(sut.get口座マスク有無(), is(ChohyoSeigyoKyotsuEntity.getKozaMaskUmu()));
        }

        @Test
        public void get口座名義人カナ優先区分は_entityが持つ口座名義人カナ優先区分を返す() {
            assertThat(sut.get口座名義人カナ優先区分(), is(ChohyoSeigyoKyotsuEntity.getKozaMeigininKanaYusenKubun()));
        }

        @Test
        public void get代行プリント有無は_entityが持つ代行プリント有無を返す() {
            assertThat(sut.get代行プリント有無(), is(ChohyoSeigyoKyotsuEntity.getDaikoPrintUmu()));
        }

        @Test
        public void get地区表示1は_entityが持つ地区表示1を返す() {
            assertThat(sut.get地区表示1(), is(ChohyoSeigyoKyotsuEntity.getChikuHyoji1()));
        }

        @Test
        public void get地区表示2は_entityが持つ地区表示2を返す() {
            assertThat(sut.get地区表示2(), is(ChohyoSeigyoKyotsuEntity.getChikuHyoji2()));
        }

        @Test
        public void get地区表示3は_entityが持つ地区表示3を返す() {
            assertThat(sut.get地区表示3(), is(ChohyoSeigyoKyotsuEntity.getChikuHyoji3()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChohyoSeigyoKyotsuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsu sut;
        private static ChohyoSeigyoKyotsu result;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = DbT7065ChohyoSeigyoKyotsuEntityGenerator.createDbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);

        }

        @Test
        public void ChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsu(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsu(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsu(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChohyoSeigyoKyotsuが保持するDbT7065ChohyoSeigyoKyotsuEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChohyoSeigyoKyotsu(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChohyoSeigyoKyotsu setStateChohyoSeigyoKyotsu(EntityDataState parentState) {
            ChohyoSeigyoKyotsuEntity.setState(parentState);
            return new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);
        }
    }
}
