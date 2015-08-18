/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5300GeninShikkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5300GeninShikkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GeninShikkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GeninShikkanBuilderTest extends DbzTestBase {

    private static DbT5300GeninShikkanEntity GeninShikkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号;
        連番 = DbT5300GeninShikkanEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static GeninShikkanBuilder sut;
        private static GeninShikkan business;

        @Before
        public void setUp() {
            GeninShikkanEntity = new DbT5300GeninShikkanEntity();

            business = new GeninShikkan(GeninShikkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の申請書管理番号は_設定した値と同じ申請書管理番号を返す() {
            business = sut.set申請書管理番号(DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号).build();
            assertThat(business.get申請書管理番号(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_申請書管理番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT5300GeninShikkanEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の主たる原因疾患フラグは_設定した値と同じ主たる原因疾患フラグを返す() {
            business = sut.set主たる原因疾患フラグ(DbT5300GeninShikkanEntityGenerator.DEFAULT_主たる原因疾患フラグ).build();
            assertThat(business.get主たる原因疾患フラグ(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_主たる原因疾患フラグ));
        }

        @Test
        public void 戻り値の原因疾患コードは_設定した値と同じ原因疾患コードを返す() {
            business = sut.set原因疾患コード(DbT5300GeninShikkanEntityGenerator.DEFAULT_原因疾患コード).build();
            assertThat(business.get原因疾患コード(), is(DbT5300GeninShikkanEntityGenerator.DEFAULT_原因疾患コード));
        }

    }
}
