/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ChosainJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5001NinteiShinseiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT7010NinteichosaItakusakiJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.business.IDateOfBirth;
import jp.co.ndensan.reams.ur.urz.business.IJusho;
import jp.co.ndensan.reams.ur.urz.business.IWorker;
import jp.co.ndensan.reams.ur.urz.business.IYubinNo;
import jp.co.ndensan.reams.ur.urz.business._DateOfBirth;
import jp.co.ndensan.reams.ur.urz.business._Jusho;
import jp.co.ndensan.reams.ur.urz.business._Worker;
import jp.co.ndensan.reams.ur.urz.business._YubinNo;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IIdoRiyu;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.ISangyoBunrui;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.TsuzukigaraList;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Kojin;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._Name;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._SangyoBunrui;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho._ShikibetsuTaisho;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.Gender;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.KannaiKangai;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.shikibetsutaisho.enumeratedtype.Tsuzukigara;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 * 認定調査対象者のビジネスクラスとエンティティの変換を行うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaIraiTaishoshaMapperTest extends TestBase {

    public static class ConstructorTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
//        private KojinEntity 個人Entity;
        private IKojin 個人;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
//            個人Entity = mock(KojinEntity.class);
            個人 = mock(IKojin.class);
            認定調査委託先Entity = mock(DbT7010NinteichosaItakusakiJohoEntity.class);
            介護事業者Entity = mock(KaigoJigyoshaEntity.class);
            調査員情報Entity = mock(ChosainJohoEntity.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの要介護認定申請情報Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            要介護認定申請情報Entity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    //                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
//            個人Entity = null;
            個人 = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    //                    個人Entity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }
    }

    public static class toNinteichosaIraiTaishoshaTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
        private KojinEntity 個人Entity;
        private IKojin 個人;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = DbT5001NinteiShinseiJohoEntityMock.getSpiedInstance();
            要介護認定申請情報Entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("0001")));
            要介護認定申請情報Entity.setShichosonCode(new ShichosonCode(new RString("1111")));
            要介護認定申請情報Entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("0002")));
            要介護認定申請情報Entity.setNinteiShinseiYMD(new FlexibleDate(new RString("20140101")));
            要介護認定申請情報Entity.setNinteiShinseiShinseijiKubunCode(NinteiShinseiKubunShinsei.新規申請);
            個人Entity = KojinEntityMock.getSpiedInstance();
            個人 = 個人インスタンス作成();
            認定調査委託先Entity = DbT7010NinteichosaItakusakiJohoEntityMock.getSpiedInstance();
            認定調査委託先Entity.set市町村コード(new RString("1111市町村コード"));
            認定調査委託先Entity.set介護事業者番号(new KaigoJigyoshaNo(new RString("0001介護事業者番号")));
            認定調査委託先Entity.set事業者番号(new JigyoshaNo(new RString("0002事業者番号")));
            認定調査委託先Entity.set介護事業者状況(true);
            認定調査委託先Entity.set調査委託区分(ChosaItakuKubun.指定なし);
            認定調査委託先Entity.set割付定員(3);
            認定調査委託先Entity.set割付地区(new RString("1114"));
            認定調査委託先Entity.set機関の区分(new RString("1115"));
            介護事業者Entity = KaigoJigyoshaEntityMock.getSpiedInstance();
            調査員情報Entity = ChosainJohoEntityMock.getSpiedInstance();
        }

        @Test
        public void 引き渡した_要介護認定申請情報の申請書管理番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get申請書管理番号(), is(要介護認定申請情報Entity.getShinseishoKanriNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の市町村コード_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get市町村コード(), is(要介護認定申請情報Entity.getShichosonCode()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の被保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get被保険者番号(), is(要介護認定申請情報Entity.getHihokenshaNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請年月日_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請年月日(), is(要介護認定申請情報Entity.getNinteiShinseiYMD()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請区分_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請区分(), is(要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()));
        }

        @Test
        public void 引き渡した_個人Entityから作成したIKojin_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get個人情報(), instanceOf(IKojin.class));
        }

        @Test
        public void 引き渡した_個人Entityの氏名_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get氏名(), is(個人.get氏名().getName()));
        }

        @Test
        public void 引き渡した_個人Entityの住所_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get住所(), instanceOf(RString.class));
        }

        @Test
        public void 引き渡した_認定調査委託先_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査委託先().get市町村コード(), is(認定調査委託先Entity.get市町村コード()));
        }

        @Test
        public void 引き渡した_事業者情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get事業者情報().get法人種別(), is(介護事業者Entity.get法人種別()));
        }

        @Test
        public void 引き渡した_認定調査員情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査員情報().get介護調査員番号(), is(調査員情報Entity.get介護調査員番号()));
        }
    }

    private static IKojin 個人インスタンス作成() {
        IShikibetsuTaisho 識別対象 = 識別対象インスタンス作成();
        IWorker iworker = new _Worker(null);
        RString 個人旧姓 = new RString("電算");
        Gender 性別 = Gender.FEMALE;
        IDateOfBirth 個人生年月日 = new _DateOfBirth(new RDate("20120101"));
        RString 世帯コード = new RString("000000001");
        TsuzukigaraList 続き柄 = new TsuzukigaraList();
        続き柄.add(Tsuzukigara.七女);
        return new _Kojin(識別対象,
                iworker,
                個人旧姓,
                個人生年月日,
                性別,
                世帯コード,
                続き柄,
                JuminJotai.住民, 0, new RString("1234"));
    }

    private static IShikibetsuTaisho 識別対象インスタンス作成() {
        ShikibetsuCode sikibetuCode = mock(ShikibetsuCode.class);
        IIdoJiyu idojiyu = mock(IIdoJiyu.class);
        IShikibetsuTaisho shikibetsuTaisho = new _ShikibetsuTaisho(sikibetuCode,
                RDateTime.of(2014, 1, 20, 12, 50),
                0,
                create住所(),
                idojiyu,
                null,
                new FlexibleDate("20140101"),
                new RString("123456789008"),
                JuminShubetsu.日本人住民,
                new _Name(new RString(""), new RString("")),
                null,
                null,
                null,
                null,
                null,
                0);
        return shikibetsuTaisho;
    }

    private static IJusho create住所() {
        RString 住所コード値 = new RString("住所コード");
        IYubinNo 郵便番号値 = mock(IYubinNo.class);
        RString 町域 = new RString("長野市");
        RString 番地 = new RString("鶴賀七瀬中町276-6");
        RString katagaki = new RString("電算ビル1F");
        RString gyoseiku = new RString("長野県");
        RString muneheya = new RString("北棟");
        return new _Jusho(住所コード値, 郵便番号値, 町域, 番地, katagaki, gyoseiku, muneheya, KannaiKangai.管内, new RString("01"));
    }

}
