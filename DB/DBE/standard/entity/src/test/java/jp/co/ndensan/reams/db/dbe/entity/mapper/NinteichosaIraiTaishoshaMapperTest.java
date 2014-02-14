/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaIraiTaishosha;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.ChosainJohoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KaigoJigyoshaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.KojinEntityMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNumber;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.entity.basic.ChosainJohoEntity;
import jp.co.ndensan.reams.ur.urf.entity.basic.KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.entity.basic.KojinEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
        private KojinEntity 個人Enity;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
            個人Enity = mock(KojinEntity.class);
            認定調査委託先Entity = mock(DbT7010NinteichosaItakusakiJohoEntity.class);
            介護事業者Entity = mock(KaigoJigyoshaEntity.class);
            調査員情報Entity = mock(ChosainJohoEntity.class);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの要介護認定申請情報Entityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            要介護認定申請情報Entity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの個人Enityに_Nullを指定した場合_NullPointerExceptionが発生する() {
            個人Enity = null;
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
        }
    }

    public static class toNinteichosaIraiTaishoshaTest extends TestBase {

        private DbT5001NinteiShinseiJohoEntity 要介護認定申請情報Entity;
        private KojinEntity 個人Enity;
        private DbT7010NinteichosaItakusakiJohoEntity 認定調査委託先Entity;
        private KaigoJigyoshaEntity 介護事業者Entity;
        private ChosainJohoEntity 調査員情報Entity;
        private NinteichosaIraiTaishosha sut;

        @Override
        protected void setUp() {
            要介護認定申請情報Entity = mock(DbT5001NinteiShinseiJohoEntity.class);
            when(要介護認定申請情報Entity.getShinseishoKanriNo()).thenReturn(new ShinseishoKanriNo(new RString("0001")));
            when(要介護認定申請情報Entity.getShichosonCode()).thenReturn(new ShichosonCode(new RString("1111")));
            when(要介護認定申請情報Entity.getHihokenshaNo()).thenReturn(new KaigoHihokenshaNumber(new RString("0002")));
            when(要介護認定申請情報Entity.getNinteiShinseiYMD()).thenReturn(new FlexibleDate(new RString("20140101")));
            when(要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()).thenReturn(new RString("0003"));
//            個人Enity = createKojinEntity();
            個人Enity = KojinEntityMock.getSpiedInstance();
            認定調査委託先Entity = mock(DbT7010NinteichosaItakusakiJohoEntity.class);
            when(認定調査委託先Entity.get市町村コード()).thenReturn(new RString("1111市町村コード"));
            when(認定調査委託先Entity.get介護事業者番号()).thenReturn(new KaigoJigyoshaNo(new RString("0001介護事業者番号")));
            when(認定調査委託先Entity.get事業者番号()).thenReturn(new JigyoshaNo(new RString("0002事業者番号")));
            when(認定調査委託先Entity.is介護事業者状況()).thenReturn(true);
            when(認定調査委託先Entity.get調査委託区分()).thenReturn(ChosaItakuKubun.指定なし);
            when(認定調査委託先Entity.get割付定員()).thenReturn(3);
            when(認定調査委託先Entity.get割付地区()).thenReturn(new RString("1114"));
            when(認定調査委託先Entity.get機関の区分()).thenReturn(new RString("1115"));
//            介護事業者Entity = create事業者エンティティ();
            介護事業者Entity = KaigoJigyoshaEntityMock.getSpiedInstance();
//            調査員情報Entity = create調査員情報Entity();
            調査員情報Entity = ChosainJohoEntityMock.getSpiedInstance();
        }

        @Test
        public void 引き渡した_要介護認定申請情報の申請書管理番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get申請書管理番号(), is(要介護認定申請情報Entity.getShinseishoKanriNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の市町村コード_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get市町村コード(), is(要介護認定申請情報Entity.getShichosonCode()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の被保険者番号_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get被保険者番号(), is(要介護認定申請情報Entity.getHihokenshaNo()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請年月日_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請年月日(), is(要介護認定申請情報Entity.getNinteiShinseiYMD()));
        }

        @Test
        public void 引き渡した_要介護認定申請情報の認定申請区分_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定申請区分(), is(要介護認定申請情報Entity.getNinteiShinseiShinseijiKubunCode()));
        }

        @Test
        public void 引き渡した_個人Enityから作成したIKojin_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get個人情報(), instanceOf(IKojin.class));
        }

        @Test
        public void 引き渡した_個人Enityの氏名_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get氏名(), is(個人Enity.get識別対象_名称()));
        }

        @Test
        public void 引き渡した_個人Enityの住所_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get住所(), instanceOf(RString.class));
        }

        @Test
        public void 引き渡した_認定調査委託先_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査委託先().get市町村コード(), is(認定調査委託先Entity.get市町村コード()));
        }

        @Test
        public void 引き渡した_事業者情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get事業者情報().get法人種別(), is(介護事業者Entity.get法人種別()));
        }

        @Test
        public void 引き渡した_認定調査員情報_とtoNinteichosaIraiTaishoshaの結果は一致する() {
            sut = NinteichosaIraiTaishoshaMapper.toNinteichosaIraiTaishosha(要介護認定申請情報Entity,
                    個人Enity, 認定調査委託先Entity, 介護事業者Entity, 調査員情報Entity);
            assertThat(sut.get認定調査員情報().get介護調査員番号(), is(調査員情報Entity.get介護調査員番号()));
        }
    }
//    private static KaigoJigyoshaEntity create事業者エンティティ() {
//        KaigoJigyoshaEntity 事業者エンティティ;
//        事業者エンティティ = new KaigoJigyoshaEntity(
//                new RString("123456"),
//                new RDate("20130101"),
//                new RDate("20140101"),
//                new RString("1234567"),
//                KaigoJigyoshaShubetsu.介護保険施設.getValue(),
//                new RString("テスト事業者略称"),
//                new RString("テストジギョウシャリャクショウ"),
//                new RString("テストジュウショカナ"),
//                new RString("異動事由"),
//                new RDate("20131231"),
//                new RString("社会福祉法人軽減対象区分"),
//                new RString("地域差区分"),
//                new RString("受領委任区分"),
//                new RString("生活保護指定区分"),
//                new RString("法人種別"),
//                new RDate("20130201"),
//                new RDate("20130301"),
//                new RDate("20130401"),
//                new RDate("20130501"));
//        return 事業者エンティティ;
//    }
//    private static ChosainJohoEntity create調査員情報Entity() {
//        ChosainJohoEntity chosainJohoEntity = new ChosainJohoEntity();
//        chosainJohoEntity.set介護事業者番号(new RString("1000000001"));
//        chosainJohoEntity.set介護調査員番号(new RString("00000001"));
//        chosainJohoEntity.set調査員氏名(new RString("調査員太郎"));
//        chosainJohoEntity.set調査員氏名カナ(new RString("ﾁｮｳｻｲﾝﾀﾛｳ"));
//        return chosainJohoEntity;
//    }
//    private static KojinEntity createKojinEntity() {
//        KojinEntity defaultData = new KojinEntity();
//        defaultData.setワークスペース_名称(new RString("ワークスペース_名称"));
//        defaultData.setワークスペース_半角カナ名称(new RString("ワークスペース_半角ｶﾅ名称"));
//        defaultData.setワークスペース住所_住所コード(new RString("1000000000"));
//        defaultData.setワークスペース住所_郵便番号(new RString("3801000"));
//        defaultData.setワークスペース住所_町域(new RString("ワークスペース住所_町域"));
//        defaultData.setワークスペース住所_番地(new RString("ワークスペース住所_番地"));
//        defaultData.setワークスペース住所_方書(new RString("ワークスペース住所_方書"));
//        defaultData.setワークスペース住所_行政区(new RString("ワークスペース住所_行政区"));
//        defaultData.setワークスペース住所_棟部屋(new RString("ワークスペース住所_棟部屋"));
//        defaultData.setワークスペース_電話番号(new RString("08012345678"));
//        defaultData.setワークスペース_電話番号備考(new RString("ワーカー_電話番号備考"));
//        defaultData.setワーカー_入社年月日(new RDate("20000101"));
//        defaultData.setワーカー_退社年月日(new RDate("20000102"));
//        defaultData.set識別対象_識別コード(new RString("2234567890"));
//        defaultData.set識別対象_個人番号(new RString("2000000001"));
//        defaultData.set識別対象住所_住所コード(new RString("2000000002"));
//        defaultData.set識別対象住所_郵便番号(new RString("3802000"));
//        defaultData.set識別対象住所_町域(new RString("識別対象住所_町域"));
//        defaultData.set識別対象住所_番地(new RString("識別対象住所_番地"));
//        defaultData.set識別対象住所_方書(new RString("識別対象住所_方書"));
//        defaultData.set識別対象住所_行政区(new RString("識別対象住所_行政区"));
//        defaultData.set識別対象住所_棟部屋(new RString("識別対象住所_棟部屋"));
//        defaultData.set識別対象_名称(new RString("識別対象_名称"));
//        defaultData.set識別対象_半角カナ名称(new RString("識別対象_半角ｶﾅ名称"));
//        defaultData.set識別対象送付先住所_住所コード(new RString("2000000003"));
//        defaultData.set識別対象送付先住所_郵便番号(new RString("3802001"));
//        defaultData.set識別対象送付先住所_町域(new RString("識別対象送付先住所_町域"));
//        defaultData.set識別対象送付先住所_番地(new RString("識別対象送付先住所_番地"));
//        defaultData.set識別対象送付先住所_方書(new RString("識別対象送付先住所_方書"));
//        defaultData.set識別対象送付先住所_行政区(new RString("識別対象送付先住所_行政区"));
//        defaultData.set識別対象送付先住所_棟部屋(new RString("識別対象送付先住所_棟部屋"));
//        defaultData.set識別対象送付先_名称(new RString("識別対象送付先_名称"));
//        defaultData.set識別対象送付先_半角カナ名称(new RString("識別対象送付先_半角ｶﾅ名称"));
//        defaultData.set識別対象_直近の異動事由(JukiIdoJiyu.転入);
//        defaultData.set個人_旧姓(new RString("個人_旧姓"));
//        defaultData.set個人_生年月日(new RString("20000201"));
//        defaultData.set個人_年齢到達日(AgeArrivalDay.当日);
//        defaultData.set個人_生年月日不明情報(UnknownDate.不明なし);
//        defaultData.set個人_世帯コード(new RString("3000000000"));
//        defaultData.set個人_続柄1(Tsuzukigara.世帯主);
//        defaultData.set個人_続柄2(Tsuzukigara.長男);
//        defaultData.set個人_続柄3(Tsuzukigara.二男);
//        defaultData.set個人_続柄4(Tsuzukigara.三男);
//        defaultData.set個人_住民種別(JuminShubetsu.日本人住民);
//        defaultData.set個人_住民状態(JuminJotai.住民);
//        defaultData.set住基個人_住民となった事由(JukiIdoJiyu.転入);
//        defaultData.set住基個人_住民となった年月日(new RDate("20000301"));
//        defaultData.set住基個人_住民でなくなった事由(JukiIdoJiyu.転居);
//        defaultData.set住基個人_住民でなくなった年月日(new RDate("20000302"));
//        defaultData.set住基個人_住所を定めた事由(JukiIdoJiyu.転入);
//        defaultData.set住基個人_住所を定めた年月日(new RDate("20000303"));
//        defaultData.set日本人_本籍地(new RString("日本人_本籍地"));
//        defaultData.set日本人_筆頭者(new RString("日本人_筆頭者"));
//        defaultData.set日本人_帰化年月日(new RDate("20000401"));
//        defaultData.set外国人_通称名(new RString("外国人_通称名"));
//        defaultData.set外国人_併記名(new RString("外国人_併記名"));
//        defaultData.set外国人_アルファベット氏名(new RString("外国人_アルファベット氏名"));
//        defaultData.set外国人_在留資格(StatusOfResidence.公用);
//        defaultData.set外国人_在留期間(new RString("2009100"));
//        defaultData.set外国人_住基法第30条45規定区分(StatusOfMidToLongTermResidence.中長期在留者);
//        defaultData.set外国人_在留期間等の満了の日(new RDate("20000501"));
//        defaultData.set外国人_国籍地域_コード(new RString("4000000000"));
//        defaultData.set外国人_国籍地域_名称(new RString("外国人_国籍地域_名称"));
//        defaultData.set住民_再転入者(false);
//        defaultData.set住民_最後に転出した時の転出年月日(new RDate("20000601"));
//        defaultData.set住民_転入前住所_住所コード(new RString("5000000000"));
//        defaultData.set住民_転入前住所_郵便番号(new RString("3803001"));
//        defaultData.set住民_転入前住所_町域(new RString("住民_転入前住所_町域"));
//        defaultData.set住民_転入前住所_番地(new RString("住民_転入前住所_番地"));
//        defaultData.set住民_転入前住所_方書(new RString("住民_転入前住所_方書"));
//        defaultData.set住民_転入前住所_行政区(new RString("住民_転入前住所_行政区"));
//        defaultData.set住民_転入前住所_棟部屋(new RString("住民_転入前住所_棟部屋"));
//        defaultData.set死亡者_死亡年月日(new RDate("20000701"));
//        defaultData.set死亡者_死亡年月日不明の文字列(new RString("不明なし文字列"));
//        defaultData.set死亡者_死亡年月日不明情報(UnknownDate.不明なし);
//        defaultData.set消除者_職権消除年月日(new RDate("20000801"));
//        defaultData.set消除者_職権消除事由(JukiIdoJiyu.転居);
//        defaultData.set転出者_転出先住所_住所コード(new RString("6000000000"));
//        defaultData.set転出者_転出先住所_郵便番号(new RString("3804001"));
//        defaultData.set転出者_転出先住所_町域(new RString("転出者_転出先住所_町域"));
//        defaultData.set転出者_転出先住所_番地(new RString("転出者_転出先住所_番地"));
//        defaultData.set転出者_転出先住所_方書(new RString("転出者_転出先住所_方書"));
//        defaultData.set転出者_転出先住所_行政区(new RString("転出者_転出先住所_行政区"));
//        defaultData.set転出者_転出先住所_棟部屋(new RString("転出者_転出先住所_棟部屋"));
//        defaultData.set転出者_転出年月日(new RDate("20000901"));
//        defaultData.set転出者_転出予定住所_住所コード(new RString("6000000001"));
//        defaultData.set転出者_転出予定住所_郵便番号(new RString("3804002"));
//        defaultData.set転出者_転出予定住所_町域(new RString("転出者_転出予定住所_町域"));
//        defaultData.set転出者_転出予定住所_番地(new RString("転出者_転出予定住所_番地"));
//        defaultData.set転出者_転出予定住所_方書(new RString("転出者_転出予定住所_方書"));
//        defaultData.set転出者_転出予定住所_行政区(new RString("転出者_転出予定住所_行政区"));
//        defaultData.set転出者_転出予定住所_棟部屋(new RString("転出者_転出予定住所_棟部屋"));
//        defaultData.set転出者_転出予定年月日(new RDate("20000902"));
//        defaultData.set転出者_転出確定住所_住所コード(new RString("6000000002"));
//        defaultData.set転出者_転出確定住所_郵便番号(new RString("3804003"));
//        defaultData.set転出者_転出確定住所_町域(new RString("転出者_転出確定住所_町域"));
//        defaultData.set転出者_転出確定住所_番地(new RString("転出者_転出確定住所_番地"));
//        defaultData.set転出者_転出確定住所_方書(new RString("転出者_転出確定住所_方書"));
//        defaultData.set転出者_転出確定住所_行政区(new RString("転出者_転出確定住所_行政区"));
//        defaultData.set転出者_転出確定住所_棟部屋(new RString("転出者_転出確定住所_棟部屋"));
//        defaultData.set転出者_転出確定年月日(new RDate("20000903"));
//        defaultData.set管内管外区分(KannaiKangai.管内);
//        defaultData.setワークスペース_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出先住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出予定住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set転出者_転出確定住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set住民_転入前住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set識別対象送付先住所_管内管外区分(KannaiKangai.管内);
//        defaultData.set識別対象送付先_業務(Gyomu.グループウェア);
//        defaultData.set識別対象送付先_有効開始年月日(new RDate("20000903"));
//        defaultData.set識別対象送付先_有効終了年月日(new RDate("20000903"));
//
//        return defaultData;
//    }
}
