/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
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
 * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilderTest extends DbzTestBase {

    private static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder sut;
        private static KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu business;

        @Before
        public void setUp() {
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity = new DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名1);
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity.setXXX(主キー名2);

            business = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。
        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の対象年月は_設定した値と同じ対象年月を返す() {
            business = sut.set対象年月(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月).build();
            assertThat(business.get対象年月(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_対象年月));
        }

        @Test
        public void 戻り値の履歴番号は_設定した値と同じ履歴番号を返す() {
            business = sut.set履歴番号(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号).build();
            assertThat(business.get履歴番号(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_履歴番号));
        }

        @Test
        public void 戻り値の前回迄利用日数は_設定した値と同じ前回迄利用日数を返す() {
            business = sut.set前回迄利用日数(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_前回迄利用日数).build();
            assertThat(business.get前回迄利用日数(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_前回迄利用日数));
        }

        @Test
        public void 戻り値の今回計画利用日数は_設定した値と同じ今回計画利用日数を返す() {
            business = sut.set今回計画利用日数(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_今回計画利用日数).build();
            assertThat(business.get今回計画利用日数(), is(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator.DEFAULT_今回計画利用日数));
        }

    }
}
