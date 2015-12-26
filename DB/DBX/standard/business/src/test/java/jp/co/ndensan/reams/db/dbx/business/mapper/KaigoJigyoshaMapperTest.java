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
import jp.co.ndensan.reams.db.dbx.business.core.IKaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護事業者エンティティを変換するクラスのテストクラスです。
 *
 * @author LDNS 馬広宇
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJigyoshaMapperTest extends DbxTestBase {

    private static KaigoJigyoshaMapper sut;

    public KaigoJigyoshaMapperTest() {
    }

    public static class toKaigoJigyoshasのテスト extends DbxTestBase {

        @Test
        public void LDNS_引数に空のリストを渡した場合_toKaigoJigyoshasは_0件のリストを返す() {
            List<DbT7060KaigoJigyoshaEntity> jigyoshas = new ArrayList<>();
            List<IKaigoJigyosha> result = KaigoJigyoshaMapper.toKaigoJigyoshas(jigyoshas);
            assertThat(result.size(), is(0));
        }

        @Test
        public void LDNS_引数を渡した場合_toKaigoJigyoshasは_1件のリストを返す() {
            DbT7060KaigoJigyoshaEntity jigyoshas;
            jigyoshas = new DbT7060KaigoJigyoshaEntity();
            List<DbT7060KaigoJigyoshaEntity> entity = new ArrayList<>();
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
