/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.business.IKogakuKaigoServiceHi;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 高額介護サービス費のマッパークラスのテストクラスです。
 *
 * @author LDNS 馬広宇
 */
@RunWith(Enclosed.class)
public class KogakuKaigoServiceHiMapperTest extends DbxTestBase {

    public static class toKogakuKaigoServiceHiのテスト extends DbxTestBase {

        private static DbV3057KogakuShikyuHanteiKekkaEntity entity;
        private static IKogakuKaigoServiceHi rsult;

        @Before
        public void setUp() {
            entity = new DbV3057KogakuShikyuHanteiKekkaEntity();
            entity.setHihokenshaNo(new RString("被保険者番号"));
            entity.setServiceTeikyoYM(new FlexibleYearMonth("201212"));
            entity.setShiharaiKingaku(new Decimal(100));
            entity.setHonninShiharaiGaku(new Decimal(200));
            entity.setShoKisaiHokenshaNo(new RString("初期再保険者番号"));
            entity.setShiharaiKubunCode(new RString("支払区分コード"));
            entity.setShinsaKekkaHaneiKubun(new RString("審査結果"));
        }

        @Test
        public void LDNS_サービス提供年月が201212の時_toKogakuKaigoServiceHiは_201212を返却する() {
            rsult = KogakuKaigoServiceHiMapper.toKogakuKaigoServiceHi(entity);
            assertThat(rsult.getサービス提供年月(), is(new FlexibleYearMonth("201212")));
        }
    }
    
    public static class コンストラクタのテスト extends DbxTestBase {

        @Test
        public void LDNS_メソッドKogakuKaigoServiceHiMapperが呼び出される場合_KogakuKaigoServiceHiMapperは_インスタンス化成功() throws Exception {
            Constructor<KogakuKaigoServiceHiMapper> constructor = KogakuKaigoServiceHiMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }

}
