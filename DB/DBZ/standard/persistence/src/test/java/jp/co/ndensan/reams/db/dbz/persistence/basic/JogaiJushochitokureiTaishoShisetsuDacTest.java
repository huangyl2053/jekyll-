/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.JogaiTokureiShisetsuEntityMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 介護除外・住所地特例対象施設のデータアクセスクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
//TODO n3317塚田萌　selsect以外は本実装の時に対応する。
@RunWith(Enclosed.class)
public class JogaiJushochitokureiTaishoShisetsuDacTest extends DbzTestDacBase {

    private static JogaiJushochitokureiTaishoShisetsuDac sut;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(JogaiJushochitokureiTaishoShisetsuDac.class);
    }

    public static class select extends DbzTestDacBase {

        private static ShisetsuType 施設種類;
        private static ShisetsuCode notFound施設コード;
        private static ShisetsuCode found施設コード;

        @Before
        public void setUp() {
            initializeEntityData();
            施設種類 = ShisetsuType.介護保険施設;
            notFound施設コード = new ShisetsuCode(new RString("1111111111"));
            found施設コード = new ShisetsuCode(new RString("1234567890"));
        }

        @Test
        public void 指定するデータがない時_selectは_NULLを返す() {
            DbT1005KaigoJogai_TokureiTaishoShisetsuEntity result = sut.select(施設種類, notFound施設コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 指定するデータがあり_履歴もある時_select契約番号は_履歴最新の一件を返す() {
            DbT1005KaigoJogai_TokureiTaishoShisetsuEntity result = sut.select(施設種類, found施設コード);
            RString newest施設略称 = new RString("あさがお");
            assertThat(result.getShisetsuRyakusho(), is(newest施設略称));
        }
    }

    private static void initializeEntityData() {
        ShisetsuCode 施設コード = new ShisetsuCode(new RString("1234567890"));
        RString 施設略称1 = new RString("ひまわり");
        RString 施設略称2 = new RString("あさがお");

        sut.insert(JogaiTokureiShisetsuEntityMock.create除外_特例施設Entity(施設コード, 施設略称1));
        sut.insert(JogaiTokureiShisetsuEntityMock.create除外_特例施設Entity(施設コード, 施設略称2));
    }
}
