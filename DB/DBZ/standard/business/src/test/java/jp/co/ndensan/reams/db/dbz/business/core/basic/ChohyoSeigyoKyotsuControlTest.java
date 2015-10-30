/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoKyotsuControl}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuControlTest extends DbzTestBase {

    private static DbT7066ChohyoSeigyoKyotsuControlEntity ChohyoSeigyoKyotsuControlEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode 主キー名1;
    private static ReportId 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード;
        主キー名2 = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoKyotsuControl(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChohyoSeigyoKyotsuControl(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT7066ChohyoSeigyoKyotsuControlEntityにセットされている() {
            sut = new ChohyoSeigyoKyotsuControl(主キー名1, 主キー名2);
            assertThat(sut.getサブ業務コード(), is(主キー名1));
            assertThat(sut.get帳票分類ID(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChohyoSeigyoKyotsuControlIdentifierにセットされている() {
            sut = new ChohyoSeigyoKyotsuControl(主キー名1, 主キー名2);
            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChohyoSeigyoKyotsuControl(null);
        }

        @Test
        public void 指定したDbT7066ChohyoSeigyoKyotsuControlEntityのキー情報を識別子が持つ() {

            sut = new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);

            assertThat(sut.identifier().getサブ業務コード(), is(主キー名1));
            assertThat(sut.identifier().get帳票分類ID(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);
        }

        @Test
        public void getサブ業務コードは_entityが持つサブ業務コードを返す() {
            assertThat(sut.getサブ業務コード(), is(ChohyoSeigyoKyotsuControlEntity.getSubGyomuCode()));
        }

        @Test
        public void get帳票分類IDは_entityが持つ帳票分類IDを返す() {
            assertThat(sut.get帳票分類ID(), is(ChohyoSeigyoKyotsuControlEntity.getChohyoBunruiID()));
        }

        @Test
        public void is共通画面使用有無は_entityが持つ共通画面使用有無を返す() {
            assertThat(sut.is共通画面使用有無(), is(ChohyoSeigyoKyotsuControlEntity.getKyotsuGamenShiyoUmu()));
        }

        @Test
        public void get文書番号使用区分は_entityが持つ文書番号使用区分を返す() {
            assertThat(sut.get文書番号使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getBunshoNoShiyoKubun()));
        }

        @Test
        public void get通知書定型文使用区分は_entityが持つ通知書定型文使用区分を返す() {
            assertThat(sut.get通知書定型文使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getTsuchishoTeikeibunShiyoKubun()));
        }

        @Test
        public void get認証者使用区分は_entityが持つ認証者使用区分を返す() {
            assertThat(sut.get認証者使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getNinshoshaShiyoKubun()));
        }

        @Test
        public void get帳票出力順使用区分は_entityが持つ帳票出力順使用区分を返す() {
            assertThat(sut.get帳票出力順使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getChohyoShuturyokujunShiyoKubun()));
        }

        @Test
        public void get帳票出力順表示方法は_entityが持つ帳票出力順表示方法を返す() {
            assertThat(sut.get帳票出力順表示方法(), is(ChohyoSeigyoKyotsuControlEntity.getChohyoShuturyokujunHyojiHohho()));
        }

        @Test
        public void get介護問合せ先使用区分は_entityが持つ介護問合せ先使用区分を返す() {
            assertThat(sut.get介護問合せ先使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getKaigoToiawasesakiShiyoKubun()));
        }

        @Test
        public void get住所編集使用区分は_entityが持つ住所編集使用区分を返す() {
            assertThat(sut.get住所編集使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getJushoHenshuShiyoKubun()));
        }

        @Test
        public void get世帯主表示使用区分は_entityが持つ世帯主表示使用区分を返す() {
            assertThat(sut.get世帯主表示使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getSetainushiHyojiShiyoKubun()));
        }

        @Test
        public void getカスタマバーコード使用区分は_entityが持つカスタマバーコード使用区分を返す() {
            assertThat(sut.getカスタマバーコード使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getCustomerBarCodeShiyoKubun()));
        }

        @Test
        public void get外部帳票文字切れ制御使用区分は_entityが持つ外部帳票文字切れ制御使用区分を返す() {
            assertThat(sut.get外部帳票文字切れ制御使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getGaibuChohyoMojigireSeigyoShiyoKubun()));
        }

        @Test
        public void get内部帳票文字切れ制御使用区分は_entityが持つ内部帳票文字切れ制御使用区分を返す() {
            assertThat(sut.get内部帳票文字切れ制御使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getNaibuChohyoMojigireSeigyoShiyoKubun()));
        }

        @Test
        public void get文字切れ分離制御使用区分は_entityが持つ文字切れ分離制御使用区分を返す() {
            assertThat(sut.get文字切れ分離制御使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getMojigireBunriSeigyoShiyoKubun()));
        }

        @Test
        public void get定型文文字サイズ使用区分は_entityが持つ定型文文字サイズ使用区分を返す() {
            assertThat(sut.get定型文文字サイズ使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getTeikeibunMojiSizeShiyoKubun()));
        }

        @Test
        public void get口座マスク使用区分は_entityが持つ口座マスク使用区分を返す() {
            assertThat(sut.get口座マスク使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getKozaMaskShiyoKubun()));
        }

        @Test
        public void get口座名義人カナ優先使用区分は_entityが持つ口座名義人カナ優先使用区分を返す() {
            assertThat(sut.get口座名義人カナ優先使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getKozaMeigininKanaYusenShiyoKubun()));
        }

        @Test
        public void get代行プリント使用区分は_entityが持つ代行プリント使用区分を返す() {
            assertThat(sut.get代行プリント使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getDaikoPrintShiyoKubun()));
        }

        @Test
        public void get地区表示使用区分は_entityが持つ地区表示使用区分を返す() {
            assertThat(sut.get地区表示使用区分(), is(ChohyoSeigyoKyotsuControlEntity.getChikuhyojiShiyoKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChohyoSeigyoKyotsuControlEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);

            sut = new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControl sut;
        private static ChohyoSeigyoKyotsuControl result;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.createDbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);

        }

        @Test
        public void ChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuControlが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsuControl(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuControlが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsuControl(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがDeletedに指定されたChohyoSeigyoKyotsuControlが返る() {
            sut = TestSupport.setStateChohyoSeigyoKyotsuControl(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChohyoSeigyoKyotsuControlが保持するDbT7066ChohyoSeigyoKyotsuControlEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChohyoSeigyoKyotsuControl(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChohyoSeigyoKyotsuControl setStateChohyoSeigyoKyotsuControl(EntityDataState parentState) {
            ChohyoSeigyoKyotsuControlEntity.setState(parentState);
            return new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);
        }
    }
}
