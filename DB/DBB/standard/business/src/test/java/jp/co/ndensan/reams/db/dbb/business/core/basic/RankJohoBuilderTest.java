/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RankJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RankJohoBuilderTest extends DbbTestBase {

    private static DbT2011RankJohoEntity RankJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT2011RankJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT2011RankJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RankJohoBuilder sut;
        private static RankJoho business;

        @Before
        public void setUp() {
            RankJohoEntity = new DbT2011RankJohoEntity();
            RankJohoEntity.setXXX(主キー名1);
            RankJohoEntity.setXXX(主キー名2);

            business = new RankJoho(RankJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の賦課年度は_設定した値と同じ賦課年度を返す() {
            business = sut.set賦課年度(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度).build();
            assertThat(business.get賦課年度(), is(DbT2011RankJohoEntityGenerator.DEFAULT_賦課年度));
        }

        @Test
        public void 戻り値のランク区分は_設定した値と同じランク区分を返す() {
            business = sut.setランク区分(DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分).build();
            assertThat(business.getランク区分(), is(DbT2011RankJohoEntityGenerator.DEFAULT_ランク区分));
        }

        @Test
        public void 戻り値のランク名称は_設定した値と同じランク名称を返す() {
            business = sut.setランク名称(DbT2011RankJohoEntityGenerator.DEFAULT_ランク名称).build();
            assertThat(business.getランク名称(), is(DbT2011RankJohoEntityGenerator.DEFAULT_ランク名称));
        }

    }
}
