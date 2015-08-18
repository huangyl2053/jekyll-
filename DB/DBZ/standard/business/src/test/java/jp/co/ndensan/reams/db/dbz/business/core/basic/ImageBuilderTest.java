/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5115ImageEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ImageBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ImageBuilderTest extends DbzTestBase {

    private static DbT5115ImageEntity ImageEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 取込ページ番号;
    private static Code 原本マスク分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号;
        取込ページ番号 = DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号;
        原本マスク分 = DbT5115ImageEntityGenerator.DEFAULT_原本マスク分;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ImageBuilder sut;
        private static Image business;

        @Before
        public void setUp() {
            ImageEntity = new DbT5115ImageEntity();

            business = new Image(ImageEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5115ImageEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の取込ページ番号は_設定した値と同じ取込ページ番号を返す() {
            business = sut.set取込ページ番号(DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号).build();
            assertThat(business.get取込ページ番号(), is(DbT5115ImageEntityGenerator.DEFAULT_取込ページ番号));
        }

        @Test
        public void 戻り値の原本マスク分は_設定した値と同じ原本マスク分を返す() {
            business = sut.set原本マスク分(DbT5115ImageEntityGenerator.DEFAULT_原本マスク分).build();
            assertThat(business.get原本マスク分(), is(DbT5115ImageEntityGenerator.DEFAULT_原本マスク分));
        }

        @Test
        public void 戻り値のイメージ共有ファイルIDは_設定した値と同じイメージ共有ファイルIDを返す() {
            business = sut.setイメージ共有ファイルID(DbT5115ImageEntityGenerator.DEFAULT_イメージ共有ファイルID).build();
            assertThat(business.getイメージ共有ファイルID(), is(DbT5115ImageEntityGenerator.DEFAULT_イメージ共有ファイルID));
        }

    }
}
