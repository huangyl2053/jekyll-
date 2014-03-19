/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.JuryoininJigyosha;
import jp.co.ndensan.reams.db.dbc.business.KeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.Todokedesha;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbc.definition.valueobject.KeiyakuNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.basic.IJuryoininJigyoshaDac;
import jp.co.ndensan.reams.db.dbc.realservice.helper.DbT3077JuryoininKeiyakuJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.definition.KaigoJigyoshaShubetsu;
import jp.co.ndensan.reams.ur.urf.realservice.IKaigoJigyoshaFinder;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikan;
import jp.co.ndensan.reams.ur.urz.business.IKinyuKikanBranch;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikan;
import jp.co.ndensan.reams.ur.urz.business._KinyuKikanBranch;
import jp.co.ndensan.reams.ur.urz.business._Koza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Hojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.YokinShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.NinkaChienDantai;
import jp.co.ndensan.reams.ur.urz.realservice.IHojinFinder;
import jp.co.ndensan.reams.ur.urz.realservice.IKozaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
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
            assertThat(sut.save(create受領委任事業者()), is(false));
        }

        @Test
        public void saveに成功した場合_trueを返す() {

            sut = createManager(AS_成功);
            assertThat(sut.save(create受領委任事業者()), is(true));
        }
    }

    public static class Test_remove {

        @Test
        public void removeに失敗した場合_falseを返す() {

            sut = createManager(AS_失敗);
            assertThat(sut.remove(create受領委任事業者()), is(false));
        }

        @Test
        public void removeに成功した場合_trueを返す() {

            sut = createManager(AS_成功);
            assertThat(sut.remove(create受領委任事業者()), is(true));
        }
    }

    private static JuryoininJigyoshaManager createManager(int flg) {
        return new JuryoininJigyoshaManager(createDac(flg),
                createJigyoshaFinderMock(), createHojinFinderMock(), createKozaFinderMock());
    }

    private static IJuryoininJigyoshaDac createDac(int flg) {
        IJuryoininJigyoshaDac dac = mock(IJuryoininJigyoshaDac.class);
        when(dac.select(any(KeiyakuNo.class))).thenReturn(createEntity(flg));
        when(dac.insert(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(flg);
        when(dac.delete(any(DbT3077JuryoininKeiyakuJigyoshaEntity.class))).thenReturn(flg);
        return dac;
    }

    private static DbT3077JuryoininKeiyakuJigyoshaEntity createEntity(int flg) {

        return flg == 0 ? null : DbT3077JuryoininKeiyakuJigyoshaEntityMock.getSpiedInstance();
    }

    private static KeiyakuNo createKeiyakuNo(RString no) {

        return new KeiyakuNo(no);
    }

    private static IKaigoJigyoshaFinder createJigyoshaFinderMock() {

        IKaigoJigyoshaFinder JigyoshaFinderMock = mock(IKaigoJigyoshaFinder.class);
        //TODO n3317塚田萌　get特定の事業者種別かつ事業者番号の介護事業者の修正が完了したらKaigoJigyoshaShubetsuを消す
        when(JigyoshaFinderMock.get特定の事業者種別かつ事業者番号の介護事業者(
                any(KaigoJigyoshaShubetsu.class), any(RString.class))).
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
                any(RString.class), any(RString.class))).thenReturn(list);

        return kozaFinderMock;
    }

    private static JuryoininJigyosha create受領委任事業者() {
        return new JuryoininJigyosha(
                new KeiyakuNo(new RString("1234567890")),
                new Range(new FlexibleDate("20110303"), new FlexibleDate("20130303")),
                RDateTime.of(2014, 1, 10, 11, 12),
                new FlexibleDate("20110203"),
                mock(Todokedesha.class),
                new FlexibleDate("20110208"),
                create契約事業者(),
                true,
                true,
                true,
                true,
                true);
    }

    private static KeiyakuJigyosha create契約事業者() {
        return new KeiyakuJigyosha(
                new JigyoshaNo(new RString("1234567890")),
                createHojin(),
                new TelNo(new RString("0262222222")),
                EigyoKeitai.法人,
                new RString("担当課"),
                createKoza());
    }

    private static DbT3077JuryoininKeiyakuJigyoshaEntity create受領委任事業者Entity() {

        DbT3077JuryoininKeiyakuJigyoshaEntity entity = new DbT3077JuryoininKeiyakuJigyoshaEntity();
        entity.setJigyoshaKeiyakuNo(new RString("1234567890"));
        entity.setKaishiYMD(new FlexibleDate("20110303"));
        entity.setShoriTimestamp(RDateTime.of(2014, 1, 10, 11, 12));
        entity.setShuryoYMD(new FlexibleDate("20130303"));
        entity.setTodokedeYMD(new FlexibleDate("20110203"));
        entity.setTodokedeAddress(new RString("長野市高田"));
        entity.setTodokedeJigyoshaName(new RString("ひまわり"));
        entity.setTodokedeDaihyoshaName(new RString("田中良夫"));
        entity.setShikibetsuCode(new ShikibetsuCode(new RString("0000000001")));
        entity.setJigyoshaFaxNo(new TelNo(new RString("0262222222")));
        entity.setKeiyakuTorokuYMD(new FlexibleDate("20110208"));
        entity.setSofusakiBusho(new RString("担当課"));
        entity.setEigyoKeitai(EigyoKeitai.法人.getCode());
        entity.setJutakuKaishuKeiyakuUmu(true);
        entity.setTokuteiFukushiYoguHanbaiKeiyakuUmu(true);
        entity.setShokanbaraiKyufuKeiyakuUmu(true);
        entity.setKogakuKyufuKeiyakuUmu(true);
        entity.setKeiyakuJigyoshaNo(new JigyoshaNo(new RString("1234567890")));
        entity.setToriatsukaiKakuyakushoUmu(true);

        return entity;
    }

    private static IHojin createHojin() {

        //IShikibetsuTaishoだけnon-null
        IShikibetsuTaisho 識別対象 = createShikibetsuTaisho();
        RString 法人形態 = new RString("有限会社");
        IKojin 法人代表者 = null;
        NinkaChienDantai 認可地縁団体 = null;
        FlexibleDate 認可地縁団体認可年月日 = new FlexibleDate("20131109");

        return new _Hojin(識別対象, 法人形態, 法人代表者, 認可地縁団体, 認可地縁団体認可年月日);
    }

    private static IShikibetsuTaisho createShikibetsuTaisho() {

        return new _ShikibetsuTaisho(
                new ShikibetsuCode(new RString("0000000001")),
                null, 1, null, null, null, null, null, null, null, null,
                null, null, null, null, 1
        );

    }

    private static IKoza createKoza() {
        return new _Koza(new GyomuCode(new RString("URZ")),
                new KamokuCode(new RString("01")),
                new KinyuKikanShitenCode(new RString("101")),
                new KinyuKikanCode(new RString("100")),
                new RString("123456789"),
                true,
                new AtenaKanaMeisho(new RString("メイギニンタロウ")),
                new AtenaMeisho(new RString("名義人太郎")),
                true,
                new AtenaKanaMeisho(new RString("検索次郎")),
                new ShikibetsuCode(new RString("0001")),
                new RString("種別"),
                new RString("234567890"),
                new RString("ABC"),
                new Code(new RString("用途区分")),
                YokinShubetsu.普通預金,
                new FlexibleDate("20170101"),
                new FlexibleDate("20140102"),
                true,
                true,
                create金融機関(),
                create金融機関支店());
    }

    private static IKinyuKikan create金融機関() {
        return new _KinyuKikan(new KinyuKikanCode(new RString("0123")), new RString("金融機関名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }

    private static IKinyuKikanBranch create金融機関支店() {
        return new _KinyuKikanBranch(new RString("0123"), new RString("支店コード"), new RString("支店名称"), new RString("金融機関カナ名称"),
                new Range(new RDate("2014/01/10"), new RDate("2014/01/20")), 1);
    }
}
