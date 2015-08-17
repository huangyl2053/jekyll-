/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7065ChohyoSeigyoKyotsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoKyotsuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChohyoSeigyoKyotsuBuilderTest extends DbzTestBase {

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

    public static class getterSetterTest extends FdaTestBase {

        private static ChohyoSeigyoKyotsuBuilder sut;
        private static ChohyoSeigyoKyotsu business;

        @Before
        public void setUp() {
            ChohyoSeigyoKyotsuEntity = new DbT7065ChohyoSeigyoKyotsuEntity();
            ChohyoSeigyoKyotsuEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoKyotsuEntity.setChohyoBunruiID(主キー名2);

            business = new ChohyoSeigyoKyotsu(ChohyoSeigyoKyotsuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の帳票分類IDは_設定した値と同じ帳票分類IDを返す() {
            business = sut.set帳票分類ID(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID).build();
            assertThat(business.get帳票分類ID(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類ID));
        }

        @Test
        public void 戻り値の帳票分類名称は_設定した値と同じ帳票分類名称を返す() {
            business = sut.set帳票分類名称(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類名称).build();
            assertThat(business.get帳票分類名称(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_帳票分類名称));
        }

        @Test
        public void 戻り値の住所編集区分は_設定した値と同じ住所編集区分を返す() {
            business = sut.set住所編集区分(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集区分).build();
            assertThat(business.get住所編集区分(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集区分));
        }

        @Test
        public void 戻り値の住所編集都道府県名表示有無は_設定した値と同じ住所編集都道府県名表示有無を返す() {
            business = sut.set住所編集都道府県名表示有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集都道府県名表示有無).build();
            assertThat(business.get住所編集都道府県名表示有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集都道府県名表示有無));
        }

        @Test
        public void 戻り値の住所編集郡名表示有無は_設定した値と同じ住所編集郡名表示有無を返す() {
            business = sut.set住所編集郡名表示有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集郡名表示有無).build();
            assertThat(business.get住所編集郡名表示有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集郡名表示有無));
        }

        @Test
        public void 戻り値の住所編集市町村名表示有無は_設定した値と同じ住所編集市町村名表示有無を返す() {
            business = sut.set住所編集市町村名表示有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集市町村名表示有無).build();
            assertThat(business.get住所編集市町村名表示有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集市町村名表示有無));
        }

        @Test
        public void 戻り値の住所編集町域編集方法は_設定した値と同じ住所編集町域編集方法を返す() {
            business = sut.set住所編集町域編集方法(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集町域編集方法).build();
            assertThat(business.get住所編集町域編集方法(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集町域編集方法));
        }

        @Test
        public void 戻り値の住所編集方書表示有無は_設定した値と同じ住所編集方書表示有無を返す() {
            business = sut.set住所編集方書表示有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集方書表示有無).build();
            assertThat(business.get住所編集方書表示有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_住所編集方書表示有無));
        }

        @Test
        public void 戻り値の世帯主表示有無は_設定した値と同じ世帯主表示有無を返す() {
            business = sut.set世帯主表示有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_世帯主表示有無).build();
            assertThat(business.get世帯主表示有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_世帯主表示有無));
        }

        @Test
        public void 戻り値のカスタマバーコード使用有無は_設定した値と同じカスタマバーコード使用有無を返す() {
            business = sut.setカスタマバーコード使用有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_カスタマバーコード使用有無).build();
            assertThat(business.getカスタマバーコード使用有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_カスタマバーコード使用有無));
        }

        @Test
        public void 戻り値のカスタマバーコード変換エラー編集方法は_設定した値と同じカスタマバーコード変換エラー編集方法を返す() {
            business = sut.setカスタマバーコード変換エラー編集方法(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_カスタマバーコード変換エラー編集方法).build();
            assertThat(business.getカスタマバーコード変換エラー編集方法(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_カスタマバーコード変換エラー編集方法));
        }

        @Test
        public void 戻り値の外部帳票文字切れ制御は_設定した値と同じ外部帳票文字切れ制御を返す() {
            business = sut.set外部帳票文字切れ制御(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_外部帳票文字切れ制御).build();
            assertThat(business.get外部帳票文字切れ制御(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_外部帳票文字切れ制御));
        }

        @Test
        public void 戻り値の内部帳票文字切れ制御は_設定した値と同じ内部帳票文字切れ制御を返す() {
            business = sut.set内部帳票文字切れ制御(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_内部帳票文字切れ制御).build();
            assertThat(business.get内部帳票文字切れ制御(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_内部帳票文字切れ制御));
        }

        @Test
        public void 戻り値の文字切れ分離制御は_設定した値と同じ文字切れ分離制御を返す() {
            business = sut.set文字切れ分離制御(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_文字切れ分離制御).build();
            assertThat(business.get文字切れ分離制御(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_文字切れ分離制御));
        }

        @Test
        public void 戻り値の定型文文字サイズは_設定した値と同じ定型文文字サイズを返す() {
            business = sut.set定型文文字サイズ(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_定型文文字サイズ).build();
            assertThat(business.get定型文文字サイズ(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_定型文文字サイズ));
        }

        @Test
        public void 戻り値の口座マスク有無は_設定した値と同じ口座マスク有無を返す() {
            business = sut.set口座マスク有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_口座マスク有無).build();
            assertThat(business.get口座マスク有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_口座マスク有無));
        }

        @Test
        public void 戻り値の口座名義人カナ優先区分は_設定した値と同じ口座名義人カナ優先区分を返す() {
            business = sut.set口座名義人カナ優先区分(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_口座名義人カナ優先区分).build();
            assertThat(business.get口座名義人カナ優先区分(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_口座名義人カナ優先区分));
        }

        @Test
        public void 戻り値の代行プリント有無は_設定した値と同じ代行プリント有無を返す() {
            business = sut.set代行プリント有無(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_代行プリント有無).build();
            assertThat(business.get代行プリント有無(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_代行プリント有無));
        }

        @Test
        public void 戻り値の地区表示1は_設定した値と同じ地区表示1を返す() {
            business = sut.set地区表示1(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示1).build();
            assertThat(business.get地区表示1(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示1));
        }

        @Test
        public void 戻り値の地区表示2は_設定した値と同じ地区表示2を返す() {
            business = sut.set地区表示2(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示2).build();
            assertThat(business.get地区表示2(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示2));
        }

        @Test
        public void 戻り値の地区表示3は_設定した値と同じ地区表示3を返す() {
            business = sut.set地区表示3(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示3).build();
            assertThat(business.get地区表示3(), is(DbT7065ChohyoSeigyoKyotsuEntityGenerator.DEFAULT_地区表示3));
        }

    }
}
