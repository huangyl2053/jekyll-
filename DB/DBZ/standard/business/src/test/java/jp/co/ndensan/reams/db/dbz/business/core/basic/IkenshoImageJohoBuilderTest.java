/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5305IkenshoImageJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IkenshoImageJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class IkenshoImageJohoBuilderTest extends DbzTestBase {

    private static DbT5305IkenshoImageJohoEntity IkenshoImageJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;
    private static Code 帳票ID;
    private static RString マスキングデータ区分;
    private static int 取込みページ番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
        帳票ID = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
        マスキングデータ区分 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
        取込みページ番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static IkenshoImageJohoBuilder sut;
        private static IkenshoImageJoho business;

        @Before
        public void setUp() {
            IkenshoImageJohoEntity = new DbT5305IkenshoImageJohoEntity();

            business = new IkenshoImageJoho(IkenshoImageJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の主治医意見書作成依頼履歴番号は_設定した値と同じ主治医意見書作成依頼履歴番号を返す() {
            business = sut.set主治医意見書作成依頼履歴番号(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号).build();
            assertThat(business.get主治医意見書作成依頼履歴番号(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号));
        }

        @Test
        public void 戻り値の帳票IDは_設定した値と同じ帳票IDを返す() {
            business = sut.set帳票ID(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID).build();
            assertThat(business.get帳票ID(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID));
        }

        @Test
        public void 戻り値のマスキングデータ区分は_設定した値と同じマスキングデータ区分を返す() {
            business = sut.setマスキングデータ区分(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分).build();
            assertThat(business.getマスキングデータ区分(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分));
        }

//        @Test
//        public void 戻り値の取込みページ番号は_設定した値と同じ取込みページ番号を返す() {
//            business = sut.set取込みページ番号(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号).build();
//            assertThat(business.get取込みページ番号(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号));
//        }

//        @Test
//        public void 戻り値の認定申請年は_設定した値と同じ認定申請年を返す() {
//            business = sut.set認定申請年(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_認定申請年).build();
//            assertThat(business.get認定申請年(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_認定申請年));
//        }

//        @Test
//        public void 戻り値の共有ファイルIDは_設定した値と同じ共有ファイルIDを返す() {
//            business = sut.set共有ファイルID(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_共有ファイルID).build();
//            assertThat(business.get共有ファイルID(), is(DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_共有ファイルID));
//        }

    }
}
