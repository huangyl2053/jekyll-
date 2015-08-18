/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5205NinteichosahyoTokkijikoEntityGenerator;
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
 * {@link NinteichosahyoTokkijikoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteichosahyoTokkijikoBuilderTest extends DbzTestBase {

    private static DbT5205NinteichosahyoTokkijikoEntity NinteichosahyoTokkijikoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;
    private static RString 認定調査特記事項番号;
    private static RString 認定調査特記事項連番;
    private static RString 特記事項テキスト_イメージ区分;
    private static Code 原本マスク区分;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
        認定調査特記事項番号 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項番号;
        認定調査特記事項連番 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項連番;
        特記事項テキスト_イメージ区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_特記事項テキスト_イメージ区分;
        原本マスク区分 = DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_原本マスク区分;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static NinteichosahyoTokkijikoBuilder sut;
        private static NinteichosahyoTokkijiko business;

        @Before
        public void setUp() {
            NinteichosahyoTokkijikoEntity = new DbT5205NinteichosahyoTokkijikoEntity();

            business = new NinteichosahyoTokkijiko(NinteichosahyoTokkijikoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の認定調査依頼履歴番号は_設定した値と同じ認定調査依頼履歴番号を返す() {
            business = sut.set認定調査依頼履歴番号(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号).build();
            assertThat(business.get認定調査依頼履歴番号(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査依頼履歴番号));
        }

        @Test
        public void 戻り値の認定調査特記事項番号は_設定した値と同じ認定調査特記事項番号を返す() {
            business = sut.set認定調査特記事項番号(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項番号).build();
            assertThat(business.get認定調査特記事項番号(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項番号));
        }

        @Test
        public void 戻り値の認定調査特記事項連番は_設定した値と同じ認定調査特記事項連番を返す() {
            business = sut.set認定調査特記事項連番(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項連番).build();
            assertThat(business.get認定調査特記事項連番(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_認定調査特記事項連番));
        }

        @Test
        public void 戻り値の特記事項テキスト_イメージ区分は_設定した値と同じ特記事項テキスト_イメージ区分を返す() {
            business = sut.set特記事項テキスト_イメージ区分(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_特記事項テキスト_イメージ区分).build();
            assertThat(business.get特記事項テキスト_イメージ区分(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_特記事項テキスト_イメージ区分));
        }

        @Test
        public void 戻り値の原本マスク区分は_設定した値と同じ原本マスク区分を返す() {
            business = sut.set原本マスク区分(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_原本マスク区分).build();
            assertThat(business.get原本マスク区分(), is(DbT5205NinteichosahyoTokkijikoEntityGenerator.DEFAULT_原本マスク区分));
        }

    }
}
