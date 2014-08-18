/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.NyushoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.mapper.NyushoShisetsuMapper;
import jp.co.ndensan.reams.db.dbz.business.helper.ShisetsuNyutaishoMock;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 入所施設を作成するクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class NyushoShisetsuMapperTest extends DbzTestBase {

    public static class createNyushoShisetsu extends DbzTestBase {

        private NyushoShisetsu sut;

        @Test
        public void toNyushoShisetsuの引数の法人に_nullを設定した時_nullを返す() {
            ShisetsuType 施設種類 = ShisetsuType.介護保険施設;
            ShisetsuCode 施設コード = new ShisetsuCode(new RString("1234567890"));

            sut = NyushoShisetsuMapper.toNyushoShisetsu(施設種類, 施設コード, null);
            assertThat(sut, is(nullValue()));
        }

        @Test
        public void toNyushoShisetsuの引数に_正しい値を設定した時_入所施設を返す() {
            sut = NyushoShisetsuMapper.toNyushoShisetsu(
                    ShisetsuType.介護保険施設,
                    new ShisetsuCode(new RString("1234567890")),
                    ShisetsuNyutaishoMock.createHojinMock());

            assertThat(sut, instanceOf(NyushoShisetsu.class));
        }
    }
}
