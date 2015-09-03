/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5051KoseiShichosonMasterEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMasterBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterBuilderTest extends DbeTestBase {

    private static DbT5051KoseiShichosonMasterEntity KoseiShichosonMasterEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 市町村識別ID;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村識別ID = DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static KoseiShichosonMasterBuilder sut;
        private static KoseiShichosonMaster business;

        @Before
        public void setUp() {
            KoseiShichosonMasterEntity = new DbT5051KoseiShichosonMasterEntity();

            business = new KoseiShichosonMaster(KoseiShichosonMasterEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村識別IDは_設定した値と同じ市町村識別IDを返す() {
            business = sut.set市町村識別ID(DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID).build();
            assertThat(business.get市町村識別ID(), is(DbT5051KoseiShichosonMasterEntityGenerator.DEFAULT_市町村識別ID));
        }

    }
}
