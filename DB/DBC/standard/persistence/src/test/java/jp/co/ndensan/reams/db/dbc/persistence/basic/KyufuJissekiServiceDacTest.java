/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.DbT3017KyufujissekiKihonEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.InputShikibetsuNoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ServiceTeikyoYM;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ToshiNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * KyufuJissekiServiceのデータアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KyufuJissekiServiceDacTest extends DbcTestDacBase {

    private static KyufuJissekiServiceDac sut;
    private static final KaigoHihokenshaNo found被保番号 = new KaigoHihokenshaNo(new RString("0000000034"));
    private static final KaigoHihokenshaNo notFound被保番号 = new KaigoHihokenshaNo(new RString("0000000099"));
    private static final ServiceTeikyoYM foundサービス提供年月_データ4件 = new ServiceTeikyoYM(new FlexibleYearMonth("200511"));
    private static final ServiceTeikyoYM foundサービス提供年月_データ1件 = new ServiceTeikyoYM(new FlexibleYearMonth("201207"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyufuJissekiServiceDac.class);
    }

    public static class select extends DbcTestDacBase {
//
//        @Test
//        public void 該当の給付実績基本が存在しない時_selectは_NULLを返す() {
//            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(notFound被保番号, foundサービス提供年月1);
//            assertThat(result, nullValue());
//        }

        @Test
        public void 該当の給付実績基本が存在する時_selectは_4件のデータが入ったentityを返す() {
            List<DbV3016KyufujissekiShuruiDetailEntity> result = sut.select(found被保番号, foundサービス提供年月_データ4件);
            assertThat(result.size(), is(4));
        }
    }
}
