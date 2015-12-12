/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.fukaerr.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2010FukaErrorListEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FukaErrorListBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class FukaErrorListBuilderTest extends DbbTestBase {

    private static DbT2010FukaErrorListEntity FukaErrorListEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SubGyomuCode サブ業務コード;
    private static RString 内部帳票ID;
    private static FlexibleYear 賦課年度;
    private static TsuchishoNo 通知書番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        サブ業務コード = DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード;
        内部帳票ID = DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID;
    }

    public static class getterSetterTest extends DbbTestBase {

        private static FukaErrorListBuilder sut;
        private static FukaErrorList business;

        @Before
        public void setUp() {
            FukaErrorListEntity = new DbT2010FukaErrorListEntity();
            FukaErrorListEntity.setSubGyomuCode(サブ業務コード);
            FukaErrorListEntity.setInternalReportId(内部帳票ID);

            business = new FukaErrorList(FukaErrorListEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値のサブ業務コードは_設定した値と同じサブ業務コードを返す() {
            business = sut.setサブ業務コード(DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード).build();
            assertThat(business.getサブ業務コード(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_サブ業務コード));
        }

        @Test
        public void 戻り値の内部帳票IDは_設定した値と同じ内部帳票IDを返す() {
            business = sut.set内部帳票ID(DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID).build();
            assertThat(business.get内部帳票ID(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票ID));
        }

        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値の通知書番号は_設定した値と同じ通知書番号を返す() {
            business = sut.set通知書番号(DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号).build();
            assertThat(business.get通知書番号(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_通知書番号));
        }

        @Test
        public void 戻り値の内部帳票作成日時は_設定した値と同じ内部帳票作成日時を返す() {
            business = sut.set内部帳票作成日時(DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票作成日時).build();
            assertThat(business.get内部帳票作成日時(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_内部帳票作成日時));
        }

        @Test
        public void 戻り値のバッチIDは_設定した値と同じバッチIDを返す() {
            business = sut.setバッチID(DbT2010FukaErrorListEntityGenerator.DEFAULT_バッチID).build();
            assertThat(business.getバッチID(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_バッチID));
        }

        @Test
        public void 戻り値のバッチ起動日時は_設定した値と同じバッチ起動日時を返す() {
            business = sut.setバッチ起動日時(DbT2010FukaErrorListEntityGenerator.DEFAULT_バッチ起動日時).build();
            assertThat(business.getバッチ起動日時(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_バッチ起動日時));
        }

        @Test
        public void 戻り値のエラーコードは_設定した値と同じエラーコードを返す() {
            business = sut.setエラーコード(DbT2010FukaErrorListEntityGenerator.DEFAULT_エラーコード).build();
            assertThat(business.getエラーコード(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_エラーコード));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT2010FukaErrorListEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT2010FukaErrorListEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の処理区分コードは_設定した値と同じ処理区分コードを返す() {
            business = sut.set処理区分コード(DbT2010FukaErrorListEntityGenerator.DEFAULT_処理区分コード).build();
            assertThat(business.get処理区分コード(), is(DbT2010FukaErrorListEntityGenerator.DEFAULT_処理区分コード));
        }

    }
}
