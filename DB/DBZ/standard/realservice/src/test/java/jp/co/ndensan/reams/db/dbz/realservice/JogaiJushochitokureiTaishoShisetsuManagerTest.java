/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.JogaiJushochitokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1005KaigoJogai_TokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.helper.JogaiTokureiShisetsuEntityMock;
import jp.co.ndensan.reams.db.dbz.persistence.basic.JogaiJushochitokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * 介護除外・住所地特例対象施設を管理するクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JogaiJushochitokureiTaishoShisetsuManagerTest extends DbzTestBase {

    private static JogaiJushochitokureiTaishoShisetsuManager sut;
    private static final ShisetsuType 施設種類 = ShisetsuType.介護保険施設;
    private static final ShisetsuCode 施設コード = new ShisetsuCode(new RString("1234567890"));
    private static final RString 施設略称 = new RString("たんぽぽ");

    private static final int AS_情報なし = 0;
    private static final int AS_情報あり = 1;

    public static class get対象施設 {

        @Test
        public void 該当の対象施設情報がない時_get対象施設は_NULLを返す() {
            sut = createManager(AS_情報なし);
            JogaiJushochitokureiTaishoShisetsu result = sut.get対象施設(施設種類, 施設コード);
            assertThat(result, nullValue());
        }

        @Test
        public void 該当の対象施設情報がある時_get対象施設は_該当する情報を返す() {
            sut = createManager(AS_情報あり);
            JogaiJushochitokureiTaishoShisetsu result = sut.get対象施設(施設種類, 施設コード);
            assertThat(result, instanceOf(JogaiJushochitokureiTaishoShisetsu.class));
        }
    }

    private static JogaiJushochitokureiTaishoShisetsuManager createManager(int flg) {
        return new JogaiJushochitokureiTaishoShisetsuManager(createDac(flg));
    }

    private static JogaiJushochitokureiTaishoShisetsuDac createDac(int flg) {

        DbT1005KaigoJogai_TokureiTaishoShisetsuEntity entity = createEntity(flg);

        JogaiJushochitokureiTaishoShisetsuDac dac = mock(JogaiJushochitokureiTaishoShisetsuDac.class);
        when(dac.select(any(ShisetsuType.class), any(ShisetsuCode.class))).thenReturn(entity);
        return dac;
    }

    private static DbT1005KaigoJogai_TokureiTaishoShisetsuEntity createEntity(int flg) {
        return flg == 0 ? null : JogaiTokureiShisetsuEntityMock.create除外_特例施設Entity(施設コード, 施設略称);
    }
}
