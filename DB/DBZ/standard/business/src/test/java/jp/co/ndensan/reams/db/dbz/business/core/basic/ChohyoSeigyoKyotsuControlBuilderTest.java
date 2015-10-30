/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7066ChohyoSeigyoKyotsuControlEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7066ChohyoSeigyoKyotsuControlEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoKyotsuControlBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuControlBuilderTest extends DbzTestBase {

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

    public static class getterSetterTest extends DbzTestBase {

        private static ChohyoSeigyoKyotsuControlBuilder sut;
        private static ChohyoSeigyoKyotsuControl business;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuControlEntity = new DbT7066ChohyoSeigyoKyotsuControlEntity();
            ChohyoSeigyoKyotsuControlEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuControlEntity.setChohyoBunruiID(主キー名2);

            business = new ChohyoSeigyoKyotsuControl(ChohyoSeigyoKyotsuControlEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の帳票分類IDは_設定した値と同じ帳票分類IDを返す() {
            business = sut.set帳票分類ID(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票分類ID).build();
            assertThat(business.get帳票分類ID(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票分類ID));
        }

        @Test
        public void 戻り値の共通画面使用有無は_設定した値と同じ共通画面使用有無を返す() {
            business = sut.set共通画面使用有無(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_共通画面使用有無).build();
            assertThat(business.is共通画面使用有無(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_共通画面使用有無));
        }

        @Test
        public void 戻り値の文書番号使用区分は_設定した値と同じ文書番号使用区分を返す() {
            business = sut.set文書番号使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_文書番号使用区分).build();
            assertThat(business.get文書番号使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_文書番号使用区分));
        }

        @Test
        public void 戻り値の通知書定型文使用区分は_設定した値と同じ通知書定型文使用区分を返す() {
            business = sut.set通知書定型文使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_通知書定型文使用区分).build();
            assertThat(business.get通知書定型文使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_通知書定型文使用区分));
        }

        @Test
        public void 戻り値の認証者使用区分は_設定した値と同じ認証者使用区分を返す() {
            business = sut.set認証者使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_認証者使用区分).build();
            assertThat(business.get認証者使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_認証者使用区分));
        }

        @Test
        public void 戻り値の帳票出力順使用区分は_設定した値と同じ帳票出力順使用区分を返す() {
            business = sut.set帳票出力順使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票出力順使用区分).build();
            assertThat(business.get帳票出力順使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票出力順使用区分));
        }

        @Test
        public void 戻り値の帳票出力順表示方法は_設定した値と同じ帳票出力順表示方法を返す() {
            business = sut.set帳票出力順表示方法(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票出力順表示方法).build();
            assertThat(business.get帳票出力順表示方法(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_帳票出力順表示方法));
        }

        @Test
        public void 戻り値の介護問合せ先使用区分は_設定した値と同じ介護問合せ先使用区分を返す() {
            business = sut.set介護問合せ先使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_介護問合せ先使用区分).build();
            assertThat(business.get介護問合せ先使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_介護問合せ先使用区分));
        }

        @Test
        public void 戻り値の住所編集使用区分は_設定した値と同じ住所編集使用区分を返す() {
            business = sut.set住所編集使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_住所編集使用区分).build();
            assertThat(business.get住所編集使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_住所編集使用区分));
        }

        @Test
        public void 戻り値の世帯主表示使用区分は_設定した値と同じ世帯主表示使用区分を返す() {
            business = sut.set世帯主表示使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_世帯主表示使用区分).build();
            assertThat(business.get世帯主表示使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_世帯主表示使用区分));
        }

        @Test
        public void 戻り値のカスタマバーコード使用区分は_設定した値と同じカスタマバーコード使用区分を返す() {
            business = sut.setカスタマバーコード使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_カスタマバーコード使用区分).build();
            assertThat(business.getカスタマバーコード使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_カスタマバーコード使用区分));
        }

        @Test
        public void 戻り値の外部帳票文字切れ制御使用区分は_設定した値と同じ外部帳票文字切れ制御使用区分を返す() {
            business = sut.set外部帳票文字切れ制御使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_外部帳票文字切れ制御使用区分).build();
            assertThat(business.get外部帳票文字切れ制御使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_外部帳票文字切れ制御使用区分));
        }

        @Test
        public void 戻り値の内部帳票文字切れ制御使用区分は_設定した値と同じ内部帳票文字切れ制御使用区分を返す() {
            business = sut.set内部帳票文字切れ制御使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_内部帳票文字切れ制御使用区分).build();
            assertThat(business.get内部帳票文字切れ制御使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_内部帳票文字切れ制御使用区分));
        }

        @Test
        public void 戻り値の文字切れ分離制御使用区分は_設定した値と同じ文字切れ分離制御使用区分を返す() {
            business = sut.set文字切れ分離制御使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_文字切れ分離制御使用区分).build();
            assertThat(business.get文字切れ分離制御使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_文字切れ分離制御使用区分));
        }

        @Test
        public void 戻り値の定型文文字サイズ使用区分は_設定した値と同じ定型文文字サイズ使用区分を返す() {
            business = sut.set定型文文字サイズ使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_定型文文字サイズ使用区分).build();
            assertThat(business.get定型文文字サイズ使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_定型文文字サイズ使用区分));
        }

        @Test
        public void 戻り値の口座マスク使用区分は_設定した値と同じ口座マスク使用区分を返す() {
            business = sut.set口座マスク使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_口座マスク使用区分).build();
            assertThat(business.get口座マスク使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_口座マスク使用区分));
        }

        @Test
        public void 戻り値の口座名義人カナ優先使用区分は_設定した値と同じ口座名義人カナ優先使用区分を返す() {
            business = sut.set口座名義人カナ優先使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_口座名義人カナ優先使用区分).build();
            assertThat(business.get口座名義人カナ優先使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_口座名義人カナ優先使用区分));
        }

        @Test
        public void 戻り値の代行プリント使用区分は_設定した値と同じ代行プリント使用区分を返す() {
            business = sut.set代行プリント使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_代行プリント使用区分).build();
            assertThat(business.get代行プリント使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_代行プリント使用区分));
        }

        @Test
        public void 戻り値の地区表示使用区分は_設定した値と同じ地区表示使用区分を返す() {
            business = sut.set地区表示使用区分(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_地区表示使用区分).build();
            assertThat(business.get地区表示使用区分(), is(DbT7066ChohyoSeigyoKyotsuControlEntityGenerator.DEFAULT_地区表示使用区分));
        }

    }
}
