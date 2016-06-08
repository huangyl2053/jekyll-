/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
//import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7067ChohyoSeigyoHanyoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChohyoSeigyoHanyoBuilder}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ChohyoSeigyoHanyoBuilderTest extends DbzTestBase {

    private static DbT7067ChohyoSeigyoHanyoEntity ChohyoSeigyoHanyoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode 主キー名1;
    private static ReportId 主キー名2;
    private static RString 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = SubGyomuCode.DBZ介護共通;
//                DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード;
        主キー名2 = new ReportId("01");
//                DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChohyoSeigyoHanyoBuilder sut;
        private static ChohyoSeigyoHanyo business;

        @Before
        public void setUp() {
            ChohyoSeigyoHanyoEntity = new DbT7067ChohyoSeigyoHanyoEntity();
            ChohyoSeigyoHanyoEntity.setSubGyomuCode(主キー名1);
            ChohyoSeigyoHanyoEntity.setChohyoBunruiID(主キー名2);

            business = new ChohyoSeigyoHanyo(ChohyoSeigyoHanyoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

//        @Test
//        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
//            business = sut.setサブ業務コード(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード).build();
//            assertThat(business.getサブ業務コード(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_サブ業務コード));
//        }
//
//        @Test
//        public void 戻り値の帳票分類IDは_設定した値と同じ帳票分類IDを返す() {
//            business = sut.set帳票分類ID(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID).build();
//            assertThat(business.get帳票分類ID(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_帳票分類ID));
//        }
//
//        @Test
//        public void 戻り値の項目名は_設定した値と同じ項目名を返す() {
//            business = sut.set項目名(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_項目名).build();
//            assertThat(business.get項目名(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_項目名));
//        }
//
//        @Test
//        public void 戻り値の設定値は_設定した値と同じ設定値を返す() {
//            business = sut.set設定値(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_設定値).build();
//            assertThat(business.get設定値(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_設定値));
//        }
//
//        @Test
//        public void 戻り値の説明は_設定した値と同じ説明を返す() {
//            business = sut.set説明(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_説明).build();
//            assertThat(business.get説明(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_説明));
//        }
//
//        @Test
//        public void 戻り値の変更可否は_設定した値と同じ変更可否を返す() {
//            business = sut.set変更可否(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_変更可否).build();
//            assertThat(business.get変更可否(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_変更可否));
//        }
//
//        @Test
//        public void 戻り値のコードマスタサブ業務コードは_設定した値と同じコードマスタサブ業務コードを返す() {
//            business = sut.setコードマスタサブ業務コード(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_コードマスタサブ業務コード).build();
//            assertThat(business.getコードマスタサブ業務コード(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_コードマスタサブ業務コード));
//        }
//
//        @Test
//        public void 戻り値のコードマスタコード種別は_設定した値と同じコードマスタコード種別を返す() {
//            business = sut.setコードマスタコード種別(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_コードマスタコード種別).build();
//            assertThat(business.getコードマスタコード種別(), is(DbT7067ChohyoSeigyoHanyoEntityGenerator.DEFAULT_コードマスタコード種別));
//        }
//
    }
}
