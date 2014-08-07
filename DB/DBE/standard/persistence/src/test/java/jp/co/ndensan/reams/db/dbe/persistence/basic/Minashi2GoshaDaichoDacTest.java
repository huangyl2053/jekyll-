/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import jp.co.ndensan.reams.db.dbe.business.Minashi2GoHihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaicho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * Dacのテスト
 *
 * @author N8211 田辺 紘一
 */
@RunWith(Enclosed.class)
public class Minashi2GoshaDaichoDacTest extends DbeTestDacBase {

    private static ITrueFalseCriteria criteria;
    private static IMinashi2GoshaDaichoDac sut;
    private static LasdecCode 市町村コード;
    private static ShikibetsuCode 識別コード;
    private static YMDHMS 処理日時;
    private static Minashi2GoHihokenshaKubun 被保険者区分コード;
    private static FlexibleDate みなし2号登録年月日;
    private static FlexibleDate みなし2号解除年月日;
    private static RString 福祉被保険者番号;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.createWithCustomize(IMinashi2GoshaDaichoDac.class);

        市町村コード = new LasdecCode("123456");
        処理日時 = new YMDHMS("20071106010101");
        識別コード = new ShikibetsuCode(new RString("012345678900001"));
        被保険者区分コード = new Minashi2GoHihokenshaKubun(new Code("1"), new RString("みなし2号"));
        みなし2号登録年月日 = new FlexibleDate("20140101");
        みなし2号解除年月日 = new FlexibleDate("20140101");
        福祉被保険者番号 = new RString("0123456789");
    }

    public static class insertのテスト extends DbeTestDacBase {

        private KaigoHihokenshaNo 被保険者番号;

        @Test
        public void insert成功したら1を返す() {
            被保険者番号 = new KaigoHihokenshaNo(new RString("0123400001"));
            assertThat(sut.insert(createEntity(被保険者番号)), is(1));
        }

    }

    public static class selectのテスト extends DbeTestDacBase {

        private KaigoHihokenshaNo 被保険者番号1;
        private KaigoHihokenshaNo 被保険者番号2;
        private KaigoHihokenshaNo 被保険者番号3;
        private KaigoHihokenshaNo 被保険者番号4;
        private KaigoHihokenshaNo 被保険者番号5;

        @Before
        public void setUp() {

            被保険者番号1 = new KaigoHihokenshaNo(new RString("0123400001"));
            被保険者番号2 = new KaigoHihokenshaNo(new RString("0123400002"));
            被保険者番号3 = new KaigoHihokenshaNo(new RString("0123400003"));
            被保険者番号4 = new KaigoHihokenshaNo(new RString("0123400004"));
            被保険者番号5 = new KaigoHihokenshaNo(new RString("0123400005"));

            sut.insert(createEntity(被保険者番号1));
            sut.insert(createEntity(被保険者番号2));
            sut.insert(createEntity(被保険者番号3));
            sut.insert(createEntity(被保険者番号4));
            sut.insert(createEntity(被保険者番号5));

            ITrueFalseCriteria 被保険者番号検索値 = eq(DbT1012Minashi2GoshaDaicho.hihokenshaNo, 被保険者番号1.getColumnValue());

            criteria = 被保険者番号検索値;
        }

        @Test
        public void 被保険者番号を指定して検索した場合_1件取得する() {
            assertThat(sut.select(criteria).size(), is(1));
        }

        @Test
        public void 検索条件に指定した被保険者番号と_取得した結果の被保険者番号が_一致する() {
            assertThat(sut.select(criteria).get(0).getHihokenshaNo(), is(被保険者番号1));
        }
    }

    private static DbT1012Minashi2GoshaDaichoEntity createEntity(KaigoHihokenshaNo 被保険者番号) {

        DbT1012Minashi2GoshaDaichoEntity entity = new DbT1012Minashi2GoshaDaichoEntity();

        entity.setShichosonCode(市町村コード);
        entity.setShikibetsuCode(識別コード);
        entity.setHihokenshaNo(被保険者番号);
        entity.setShoriTimestamp(処理日時);
        entity.setHihokenshaKubunCode(被保険者区分コード.getCode());
        entity.setMinashi2GoshaTorokuYMD(みなし2号登録年月日);
        entity.setMinashi2GoshaKaijoYMD(みなし2号解除年月日);
        entity.setFukushiHihokenshaNo(福祉被保険者番号);
        return entity;
    }
}
