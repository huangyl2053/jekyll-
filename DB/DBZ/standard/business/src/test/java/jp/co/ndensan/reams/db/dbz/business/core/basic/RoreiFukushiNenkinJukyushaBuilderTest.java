/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7006RoreiFukushiNenkinJukyushaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link RoreiFukushiNenkinJukyushaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RoreiFukushiNenkinJukyushaBuilderTest extends DbzTestBase {

    private static DbT7006RoreiFukushiNenkinJukyushaEntity RoreiFukushiNenkinJukyushaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static RoreiFukushiNenkinJukyushaBuilder sut;
        private static RoreiFukushiNenkinJukyusha business;

        @Before
        public void setUp() {
            RoreiFukushiNenkinJukyushaEntity = new DbT7006RoreiFukushiNenkinJukyushaEntity();
            RoreiFukushiNenkinJukyushaEntity.setXXX(主キー名1);
            RoreiFukushiNenkinJukyushaEntity.setXXX(主キー名2);

            business = new RoreiFukushiNenkinJukyusha(RoreiFukushiNenkinJukyushaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の受給開始年月日は_設定した値と同じ受給開始年月日を返す() {
            business = sut.set受給開始年月日(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始年月日).build();
            assertThat(business.get受給開始年月日(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給開始年月日));
        }

        @Test
        public void 戻り値の受給終了年月日は_設定した値と同じ受給終了年月日を返す() {
            business = sut.set受給終了年月日(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給終了年月日).build();
            assertThat(business.get受給終了年月日(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_受給終了年月日));
        }

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT7006RoreiFukushiNenkinJukyushaEntityGenerator.DEFAULT_被保険者番号));
        }

    }
}
