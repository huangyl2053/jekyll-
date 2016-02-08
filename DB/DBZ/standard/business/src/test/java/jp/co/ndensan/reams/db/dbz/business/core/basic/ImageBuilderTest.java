/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
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

    private static DbT5115ImageEntity imageEntity;

    @BeforeClass
    public static void setUpClass() {
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ImageBuilder sut;
        private static Image business;

        @Before
        public void setUp() {
            imageEntity = new DbT5115ImageEntity();

            business = new Image(imageEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値のイメージ共有ファイルIDは_設定した値と同じイメージ共有ファイルIDを返す() {
            business = sut.setイメージ共有ファイルID(DbT5115ImageEntityGenerator.DEFAULT_イメージ共有ファイルID).build();
            assertThat(business.getイメージ共有ファイルID(), is(DbT5115ImageEntityGenerator.DEFAULT_イメージ共有ファイルID));
        }

    }
}
