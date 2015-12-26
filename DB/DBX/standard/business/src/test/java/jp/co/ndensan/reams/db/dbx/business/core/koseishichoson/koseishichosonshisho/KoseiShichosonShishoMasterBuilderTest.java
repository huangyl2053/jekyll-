/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.helper.DbT7052KoseiShichosonShishoMasterEntityGenerator;
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
 * {@link KoseiShichosonShishoMasterBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonShishoMasterBuilderTest extends DbzTestBase {

    private static DbT7052KoseiShichosonShishoMasterEntity KoseiShichosonShishoMasterEntity;
    private static LasdecCode 市町村コード;
    private static ShishoCode 支所コード;

    @BeforeClass
    public static void setUpClass() {

        市町村コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_市町村コード;
        支所コード = DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static KoseiShichosonShishoMasterBuilder sut;
        private static KoseiShichosonShishoMaster business;

        @Before
        public void setUp() {
            KoseiShichosonShishoMasterEntity = new DbT7052KoseiShichosonShishoMasterEntity();
            KoseiShichosonShishoMasterEntity.setShichosonCode(市町村コード);
            KoseiShichosonShishoMasterEntity.setShishoCode(支所コード);

            business = new KoseiShichosonShishoMaster(KoseiShichosonShishoMasterEntity);

            sut = business.createBuilderForEdit();
        }

        @Test
        public void 戻り値の支所名は_設定した値と同じ支所名を返す() {
            business = sut.set支所名(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所名).build();
            assertThat(business.get支所名(), is(DbT7052KoseiShichosonShishoMasterEntityGenerator.DEFAULT_支所名));
        }

    }
}
