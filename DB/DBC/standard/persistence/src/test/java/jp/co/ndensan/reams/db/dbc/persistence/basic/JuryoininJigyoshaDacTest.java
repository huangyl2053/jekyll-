/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.basic;

import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.helper.JuryoininJigyoshaMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 受領委任事業者データアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaDacTest extends DbcTestDacBase {

    private static JuryoininJigyoshaDac sut;
    private static final KeiyakuNo 契約番号 = new KeiyakuNo(new RString("1234567890"));
    private static final RString 送付先部署 = new RString("１課");
    private static final int 成功 = 1;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(JuryoininJigyoshaDac.class);
    }

    public static class insert extends DbcTestDacBase {

        @Test
        public void 新規にデータをinsertできる() {
            int result = sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, 送付先部署));
            assertThat(result, is(成功));
        }

        @Test
        public void 追記型は同じデータがある時でもinsertできる() {
            sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, 送付先部署));
            int result = sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, 送付先部署));
            assertThat(result, is(成功));
        }
    }

    public static class select extends DbcTestDacBase {

        @Test
        public void 指定するデータがない時_select契約番号は_NULLを返す() {
            KeiyakuNo notFound契約番号 = new KeiyakuNo(new RString("1111111111"));
            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(notFound契約番号);
            assertThat(result, nullValue());
        }

        @Test
        public void 指定するデータがあり履歴もある時_select契約番号は_履歴最新の一件を返す() {
            initializeEntityData();
            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(契約番号);
            RString newest送付先部署 = new RString("３課");
            assertThat(result.getSofusakiBusho(), is(newest送付先部署));
        }
    }

    public static class delete extends DbcTestDacBase {

        @Test
        public void 論理削除したいデータがある時_deleteできる() {
            initializeEntityData();
            int result = sut.delete(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, 送付先部署));
            assertThat(result, is(成功));
        }

        @Test
        public void 論理削除したデータは取得できない() {
            initializeEntityData();
            sut.delete(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, 送付先部署));
            DbT3077JuryoininKeiyakuJigyoshaEntity result = sut.select(契約番号);
            assertThat(result, nullValue());
        }
    }

    private static void initializeEntityData() {
        sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, new RString("１課")));
        sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, new RString("２課")));
        sut.insert(JuryoininJigyoshaMock.create受領委任事業者Entity(契約番号, new RString("３課")));
    }
}
