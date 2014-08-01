/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Minashi2GoHihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 *
 * @author N8211 田辺 紘一
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaDaichoMapperTest {

    private static LasdecCode 市町村コード;
    private static ShikibetsuCode 識別コード;
    private static KaigoHihokenshaNo 被保険者番号;
    private static int 履歴番号;
    private static Minashi2GoHihokenshaKubun 被保険者区分コード;
    private static FlexibleDate みなし2号登録年月日;
    private static FlexibleDate みなし2号解除年月日;

    @BeforeClass
    public static void setUpBeforeClass() {
        市町村コード = new LasdecCode("123456");
        識別コード = new ShikibetsuCode("123456789012345");
        被保険者番号 = new KaigoHihokenshaNo(new RString("1234567890"));
        履歴番号 = 1;
        被保険者区分コード = Minashi2GoHihokenshaKubun.みなし2号;
        みなし2号登録年月日 = new FlexibleDate("20140101");
        みなし2号解除年月日 = new FlexibleDate("20140101");
    }

    public static class toMinashi2GoshaDaichoのテスト extends DbeTestBase {

        @Test
        public void 引数がNullの場合_nullを返す() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(null), is(IsNull.nullValue()));
        }

        @Test
        public void Entityが持つ市町村コードと_変換後のみなし2号台帳が持つ市町村コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).get市町村コード(), is(市町村コード));
        }

        @Test
        public void Entityが持つ識別コードと_変換後のみなし2号台帳が持つ識別コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).get識別コード(), is(識別コード));
        }

        @Test
        public void Entityが持つ被保険者番号と_変換後のみなし2号台帳が持つ被保険者番号が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void Entityが持つ履歴番号と_変換後のみなし2号台帳が持つ履歴番号が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).get履歴番号(), is(履歴番号));
        }

        @Test
        public void Entityが持つ被保険者区分コードと_変換後のみなし2号台帳が持つ被保険者区分コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).get被保険者区分コード(), is(被保険者区分コード));
        }

        @Test
        public void Entityが持つみなし2号登録年月日と_変換後のみなし2号台帳が持つみなし2号登録年月日が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).getみなし2号登録年月日(), is(みなし2号登録年月日));
        }

        @Test
        public void Entityが持つみなし2号解除年月日と_変換後のみなし2号台帳が持つみなし2号登解除月日が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toMinashi2GoshaDaicho(createEntity()).getみなし2号解除年月日(), is(みなし2号解除年月日));
        }

        private DbT1012Minashi2GoshaDaichoEntity createEntity() {

            DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();

            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setHihokenshaNo(被保険者番号);
            entity.setRirekiNo(履歴番号);
            entity.setHihokenshaKubunCode(被保険者区分コード.getみなし2号区分());
            entity.setMinashi2GoshaTorokuYMD(みなし2号登録年月日);
            entity.setMinashi2GoshaKaijoYMD(みなし2号解除年月日);
            return entity;
        }
    }

    public static class toDbT1012Minashi2GoshaDaichoEntityのテスト extends DbeTestBase {

        @Test
        public void 引数がNullの場合_nullを返す() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(null), is(IsNull.nullValue()));
        }

        @Test
        public void みなし2号台帳が持つ市町村コードと_変換後のEntityが持つ市町村コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getShichosonCode(), is(市町村コード));
        }

        @Test
        public void みなし2号台帳が持つ識別コードと_変換後のEntityが持つ識別コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getShikibetsuCode(), is(識別コード));
        }

        @Test
        public void みなし2号台帳が持つ被保険者番号と_変換後のEntityが持つ被保険者番号が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getHihokenshaNo(), is(被保険者番号));
        }

        @Test
        public void みなし2号台帳が持つ履歴番号と_変換後のEntityが持つ履歴番号が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getRirekiNo(), is(履歴番号));
        }

        @Test
        public void みなし2号台帳が持つ被保険者区分コードと_変換後のEntityが持つ被保険者区分コードが_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getHihokenshaKubunCode(), is(被保険者区分コード.getみなし2号区分()));
        }

        @Test
        public void みなし2号台帳が持つみなし2号登録年月日と_変換後のEntityが持つみなし2号登録年月日が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getMinashi2GoshaTorokuYMD(), is(みなし2号登録年月日));
        }

        @Test
        public void みなし2号台帳が持つみなし2号解除年月日と_変換後のEntityが持つみなし2号解除年月日が_一致する() {
            assertThat(Minashi2GoshaDaichoMapper.toDbT1012Minashi2GoshaDaichoEntity(createMinashi2GoshaDaicho()).getMinashi2GoshaKaijoYMD(), is(みなし2号解除年月日));
        }

        private Minashi2GoshaDaicho createMinashi2GoshaDaicho() {

            return new Minashi2GoshaDaicho(
                    市町村コード,
                    識別コード,
                    被保険者番号,
                    履歴番号,
                    被保険者区分コード,
                    みなし2号登録年月日,
                    みなし2号解除年月日);
        }
    }
}
