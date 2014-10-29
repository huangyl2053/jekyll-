/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Restrictions;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 広域市町村セキュリティのデータアクセスクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KoikiShichosonSecurityDacTest extends DbzTestDacBase {

    private static KoikiShichosonSecurityDac sut;

    private static final ITrueFalseCriteria 検索条件_該当0件 = Restrictions.eq(new RString("99"), DbT7057KoikiShichosonSecurity.shichosonShikibetsuID);
    private static final ITrueFalseCriteria 検索条件_該当1件 = Restrictions.eq(new RString("01"), DbT7057KoikiShichosonSecurity.shichosonShikibetsuID);
    private static final ITrueFalseCriteria 検索条件_該当2件 = Restrictions.eq(new RString("00001"), DbT7057KoikiShichosonSecurity.shichosonCode);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KoikiShichosonSecurityDac.class);
    }

    public static class select extends DbzTestDacBase {

        @Before
        public void setup() {
            initializeEntityData(2);
        }

        @Test
        public void 検索条件に該当する広域市町村セキュリティが0件の時_selectは_0件の情報を返す() {
            assertThat(sut.select(検索条件_該当0件).size(), is(0));
        }

        @Test
        public void 検索条件に該当する該当の広域市町村セキュリティが1件の時_selectは_1件の情報を返す() {
            assertThat(sut.select(検索条件_該当1件).size(), is(1));
        }

        @Test
        public void 検索条件に該当する該当の広域市町村セキュリティが2件の時_selectは_2件の情報を返す() {
            assertThat(sut.select(検索条件_該当2件).size(), is(2));
        }
    }

    private static void initializeEntityData(int count) {
        for (int i = 1; i <= count; i++) {
            sut.insert(createEntity(i));
        }
    }

    private static DbT7057KoikiShichosonSecurityEntity createEntity(int no) {
        DbT7057KoikiShichosonSecurityEntity entity = new DbT7057KoikiShichosonSecurityEntity();
        entity.setGroupID(new RString(String.format("%1$010d", no)));
        entity.setShichosonShikibetsuID(new ShichosonShikibetsuID(String.format("%1$02d", no)));
        entity.setShichosonCode(new ShichosonCode("00001"));
        return entity;
    }
}
