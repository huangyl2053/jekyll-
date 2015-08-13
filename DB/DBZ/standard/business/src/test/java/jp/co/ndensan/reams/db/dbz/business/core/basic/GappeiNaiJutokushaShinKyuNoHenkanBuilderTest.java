/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiNaiJutokushaShinKyuNoHenkanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiNaiJutokushaShinKyuNoHenkanBuilderTest extends DbzTestBase {

    private static DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity gappeiNaiJutokushaShinKyuNoHenkanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShikibetsuCode 識別コード;
    private static RString 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        識別コード = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static GappeiNaiJutokushaShinKyuNoHenkanBuilder sut;
        private static GappeiNaiJutokushaShinKyuNoHenkan business;

        @Before
        public void setUp() {
            gappeiNaiJutokushaShinKyuNoHenkanEntity = new DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntity();
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setShikibetsuCode(識別コード);
            gappeiNaiJutokushaShinKyuNoHenkanEntity.setRirekiNo(履歴番号);

            business = new GappeiNaiJutokushaShinKyuNoHenkan(gappeiNaiJutokushaShinKyuNoHenkanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の識別コード_措置元は_設定した値と同じ識別コード_措置元を返す() {
            business = sut.set識別コード_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード_措置元).build();
            assertThat(business.get識別コード_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_識別コード_措置元));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の市町村コード_措置元は_設定した値と同じ市町村コード_措置元を返す() {
            business = sut.set市町村コード_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード_措置元).build();
            assertThat(business.get市町村コード_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_市町村コード_措置元));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の被保険者番号_措置元は_設定した値と同じ被保険者番号_措置元を返す() {
            business = sut.set被保険者番号_措置元(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号_措置元).build();
            assertThat(business.get被保険者番号_措置元(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_被保険者番号_措置元));
        }

        @Test
        public void 戻り値の開始年月日は_設定した値と同じ開始年月日を返す() {
            business = sut.set開始年月日(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_開始年月日).build();
            assertThat(business.get開始年月日(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_開始年月日));
        }

        @Test
        public void 戻り値の終了年月日は_設定した値と同じ終了年月日を返す() {
            business = sut.set終了年月日(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_終了年月日).build();
            assertThat(business.get終了年月日(), is(DbT7033GappeiNaiJutokushaShinKyuNoHenkanEntityGenerator.DEFAULT_終了年月日));
        }

    }
}
