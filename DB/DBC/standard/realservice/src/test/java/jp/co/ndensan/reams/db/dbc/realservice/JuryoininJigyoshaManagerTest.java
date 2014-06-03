/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.business.helper.JuryoininJigyoshaMock;
import jp.co.ndensan.reams.db.dbc.entity.helper.JuryoininJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbc.persistence.basic.JuryoininJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.realservice.IHojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.IKozaManager;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.instanceOf;

/**
 * 受領委任事業者を管理するテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class JuryoininJigyoshaManagerTest extends DbcTestBase {

    private static JuryoininJigyoshaManager sut;
    private static final KeiyakuNo 契約番号 = new KeiyakuNo(new RString("1234567890"));
    private static final RString 送付先部署 = new RString("１課");

    private static final int AS_情報なし = 0;
    private static final int AS_情報あり = 1;
    private static final int AS_失敗 = 0;
    private static final int AS_成功 = 1;

    public static class Test_get受領委任事業者 {

        @Test
        public void 該当の受領委任事業者情報がない時_get受領委任事業者は_NULLを返す() {
            sut = createManager(AS_情報なし);
            JuryoininJigyosha result = sut.get受領委任事業者(createKeiyakuNo(new RString("1234567890")));
            assertThat(result, nullValue());
        }

        @Test
        public void 該当の受領委任事業者情報がある時_get受領委任事業者は_受領委任事業者情報を返す() {
            sut = createManager(AS_情報あり);
            JuryoininJigyosha result = sut.get受領委任事業者(createKeiyakuNo(new RString("1234567890")));
            assertThat(result, instanceOf(JuryoininJigyosha.class));
        }
    }

    public static class Test_save {

        @Test
        public void saveに失敗した場合_falseを返す() {
            sut = createManager(AS_失敗);
            assertThat(sut.save(JuryoininJigyoshaMock.create受領委任事業者()), is(false));
        }

        @Test
        public void saveに成功した場合_trueを返す() {
            sut = createManager(AS_成功);
            assertThat(sut.save(JuryoininJigyoshaMock.create受領委任事業者()), is(true));
        }
    }

    public static class Test_remove {

        @Test
        public void removeに失敗した場合_falseを返す() {
            sut = createManager(AS_失敗);
            assertThat(sut.remove(JuryoininJigyoshaMock.create受領委任事業者()), is(false));
        }

        @Test
        public void removeに成功した場合_trueを返す() {
            sut = createManager(AS_成功);
            assertThat(sut.remove(JuryoininJigyoshaMock.create受領委任事業者()), is(true));
        }
    }

    private static JuryoininJigyoshaManager createManager(int flg) {
        return new JuryoininJigyoshaManager(createDac(flg),
                createJigyoshaFinderMock(), createHojinFinderMock(), createKozaFinderMock());
    }

    private static JuryoininJigyoshaDac createDac(int flg) {
        DbT3077JuryoininKeiyakuJigyoshaEntity entity = createEntity(flg);

        JuryoininJigyoshaDac dac = mock(JuryoininJigyoshaDac.class);
        when(dac.select(any(KeiyakuNo.class))).thenReturn(entity);
        when(dac.insert(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(flg);
        when(dac.delete(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(flg);
        return dac;
    }

    private static DbT3077JuryoininKeiyakuJigyoshaEntity createEntity(int flg) {
        return flg == 0 ? null : JuryoininJigyoshaEntityMock.create受領委任事業者Entity(契約番号, 送付先部署);
    }

    private static KeiyakuNo createKeiyakuNo(RString no) {
        return new KeiyakuNo(no);
    }

    private static IKaigoJigyoshaFinder createJigyoshaFinderMock() {
        IKaigoJigyoshaFinder JigyoshaFinderMock = mock(IKaigoJigyoshaFinder.class);
        when(JigyoshaFinderMock.get特定の事業者番号の介護事業者(
                any(RString.class))).
                thenReturn(mock(IKaigoJigyosha.class));

        return JigyoshaFinderMock;
    }

    private static IHojinFinder createHojinFinderMock() {
        IHojinFinder HojinFinderMock = mock(IHojinFinder.class);
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたらRDateを修正。
        when(HojinFinderMock.get法人(any(ShikibetsuCode.class), any(RDate.class)))
                .thenReturn(mock(IHojin.class));
        return HojinFinderMock;
    }

    private static IKozaManager createKozaFinderMock() {
        List<IKoza> list = new ArrayList<>();
        list.add(mock(IKoza.class));

        IKozaManager kozaFinderMock = mock(IKozaManager.class);
        //TODO n3317塚田萌　RDateからFlexibleDateに変更されたらRDateを修正。
        when(kozaFinderMock.get口座(any(RDate.class), any(ShikibetsuCode.class),
                any(RString.class), any(KamokuCode.class))).thenReturn(list);

        return kozaFinderMock;
    }
}
