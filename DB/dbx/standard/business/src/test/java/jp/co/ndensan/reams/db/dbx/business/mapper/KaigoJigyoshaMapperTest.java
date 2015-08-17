/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.mapper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護事業者エンティティを変換するクラスのテストクラスです。
 *
 * @author LDNS 馬広宇
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaMapperTest extends DbxTestBase {

    private static KaigoJigyoshaMapper sut;

    public KaigoJigyoshaMapperTest() {
    }

    public static class toKaigoJigyoshasのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数に空のリストを渡した場合_toKaigoJigyoshasは_0件のリストを返す() {
            List<KaigoJigyoshaEntity> jigyoshas = new ArrayList<>();
            List<IKaigoJigyosha> result = KaigoJigyoshaMapper.toKaigoJigyoshas(jigyoshas);
            assertThat(result.size(), is(0));
        }

        @Test
        public void LDNS_引数を渡した場合_toKaigoJigyoshasは_1件のリストを返す() {
            KaigoJigyoshaEntity jigyoshas;
            jigyoshas = new KaigoJigyoshaEntity(new KaigoJigyoshaNo(new RString("0000000001")), new FlexibleDate("20130202"),
                    new FlexibleDate("20150202"), new ShikibetsuCode("001"),
                    new RString("事業者略称"), new RString("事業者略称カナ"), new RString("事業者住所カナ"),
                    new RString("異動事由"), new FlexibleDate("20130303"), new RString("社会福祉法人軽減対象区分"),
                    new RString("地域差区分"), new RString("受領委任区分"), new RString("生活保護指定区分"),
                    new RString("法人種別"), new FlexibleDate("20140404"), new FlexibleDate("20150404"),
                    new FlexibleDate("20110512"), new FlexibleDate("20140302")
            );
            List<KaigoJigyoshaEntity> entity = new ArrayList<>();
            entity.add(jigyoshas);
            List<IKaigoJigyosha> result = KaigoJigyoshaMapper.toKaigoJigyoshas(entity);
            assertThat(result.size(), is(1));
        }
    }
    
    public static class コンストラクタのテスト extends DbxTestBase {

        @Test(expected = InvocationTargetException.class)
        public void LDNS_メソッドKaigoJigyoshaMapperが呼び出される場合_KaigoJigyoshaMapperは_インスタンス化成功() throws Exception {
            Constructor<KaigoJigyoshaMapper> constructor = KaigoJigyoshaMapper.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }
    }
}
