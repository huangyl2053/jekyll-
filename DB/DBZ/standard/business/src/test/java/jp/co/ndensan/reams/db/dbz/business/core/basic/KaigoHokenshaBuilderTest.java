/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7050KaigoHokenshaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoHokenshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoHokenshaBuilderTest extends DbzTestBase {

    private static DbT7050KaigoHokenshaEntity KaigoHokenshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 広域保険者市町村コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        広域保険者市町村コード = DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KaigoHokenshaBuilder sut;
        private static KaigoHokensha business;

        @Before
        public void setUp() {
            KaigoHokenshaEntity = new DbT7050KaigoHokenshaEntity();
            KaigoHokenshaEntity.setKoikiHokenshaShichosonCode(広域保険者市町村コード);

            business = new KaigoHokensha(KaigoHokenshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の広域保険者市町村コードは_設定した値と同じ広域保険者市町村コードを返す() {
            business = sut.set広域保険者市町村コード(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード).build();
            assertThat(business.get広域保険者市町村コード(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者市町村コード));
        }

        @Test
        public void 戻り値の広域保険者番号は_設定した値と同じ広域保険者番号を返す() {
            business = sut.set広域保険者番号(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者番号).build();
            assertThat(business.get広域保険者番号(), is(DbT7050KaigoHokenshaEntityGenerator.DEFAULT_広域保険者番号));
        }

    }
}
