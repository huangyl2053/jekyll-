/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.IShichosonJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.KoikiType;
import jp.co.ndensan.reams.db.dbx.definition.core.koseishichoson.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestDacBase;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.ILoginInfo;
import jp.co.ndensan.reams.uz.uza.auth.AuthItem;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(Enclosed.class)
public class ShichosonSecurityJohoFinderTest extends DbxTestDacBase {

    private static DbT7051KoseiShichosonMasterDac koseiShichosonMasterDac;
    private static DbT7908KaigoDonyuKeitaiDac kaigoDonyuKeitaiDac;

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({AuthorityItem.class, AuthItem.class, BusinessConfig.class, RDate.class,
        IAssociationFinder.class, AssociationFinderFactory.class, Association.class,
        IUrControlData.class, ILoginInfo.class, UrControlDataFactory.class})
    public static class 介護事務_事務広域 extends DbxTestDacBase {

        private RString defaultValueOfConfig;
        private Association association;

        @Before
        public void setUp() {
            koseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
            kaigoDonyuKeitaiDac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
            DbT7051KoseiShichosonMasterEntity entity01 = TestSupport.createDbT7051KoseiShichosonMasterEntity(new RString("01"));
            DbT7051KoseiShichosonMasterEntity entity99 = TestSupport.createDbT7051KoseiShichosonMasterEntity(new RString("99"));
            koseiShichosonMasterDac.save(entity01);
            koseiShichosonMasterDac.save(entity99);
            setKeiTai();
            setUpMocks();
        }

        private void setKeiTai() {
            DbT7908KaigoDonyuKeitaiEntity entityDbT7908 = TestSupport.createDbT7908KaigoDonyuKeitaiEntity(
                    GyomuBunrui.介護事務, DonyuKeitaiCode.事務広域
            );
            kaigoDonyuKeitaiDac.save(entityDbT7908);
        }

        private void setUpMocks() {
//            IUrControlData urControlData = PowerMockito.mock(IUrControlData.class);
//            ILoginInfo loginInfo = PowerMockito.mock(ILoginInfo.class);
//            PowerMockito.mockStatic(UrControlDataFactory.class);
//            PowerMockito.when(UrControlDataFactory.createInstance()).thenReturn(urControlData);
//            PowerMockito.when(urControlData.getLoginInfo()).thenReturn(loginInfo);
//            PowerMockito.when(loginInfo.getUserId()).thenReturn(new RString("userTest"));

//            IAssociationFinder associationFinder = PowerMockito.mock(IAssociationFinder.class);
//            association = TestSupport.mockAssociation();
//            PowerMockito.mockStatic(AssociationFinderFactory.class);
//            PowerMockito.when(AssociationFinderFactory.createInstance()).thenReturn(associationFinder);
//            PowerMockito.mockStatic(IAssociationFinder.class);
//            PowerMockito.when(associationFinder.getAssociation()).thenReturn(association);
            RDate rDate = new RDate("20140401");
//            PowerMockito.mockStatic(RDate.class);
//            PowerMockito.when(RDate.getNowDate()).thenReturn(rDate);

            defaultValueOfConfig = new RString("1");
//            PowerMockito.mockStatic(BusinessConfig.class);
//            PowerMockito.when(BusinessConfig.get((Enum) anyObject(), same(rDate), (SubGyomuCode) anyObject()))
//                    .thenReturn(defaultValueOfConfig);
            RString yubinNo = new RString("1234567");
//            PowerMockito.when(BusinessConfig.get(same(ConfigKeysHokenshaJoho.保険者情報_郵便番号), same(rDate), (SubGyomuCode) anyObject()))
//                    .thenReturn(yubinNo);
        }

        private void setAutorityItem(ShichosonShikibetsuID shichosonShikibetsuID) {
//            AuthorityItem authorityItem = PowerMockito.mock(AuthorityItem.class);
//            PowerMockito.when(authorityItem.getItemId()).thenReturn(shichosonShikibetsuID.value());
            List<AuthorityItem> authorityItems = new ArrayList<>();
//            authorityItems.add(authorityItem);
//            PowerMockito.mockStatic(AuthItem.class);
//            PowerMockito.when(AuthItem.getAuthorities((RString) anyObject(), (AuthType) anyObject(), (RDate) anyObject()))
//                    .thenReturn(authorityItems);
        }

        @Test
        public void getShichosonSecurityJohoは_業務分類が介護事務_導入形態が事務広域_で_市町村識別IDが00の場合_管理情報からShichosonSecurityJohoを生成する() {
            ShichosonShikibetsuID shichosonShikibetsuID = ShichosonShikibetsuID.KOIKI;
            setAutorityItem(shichosonShikibetsuID);

            ShichosonSecurityJohoFinder joho = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho shichosonJohoEntity = joho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            assertThat(shichosonJohoEntity.get導入形態コード(), is(DonyuKeitaiCode.事務広域));
            assertThat(shichosonJohoEntity.get広域タイプ(), is(KoikiType.toValue(defaultValueOfConfig)));
            assertThat(shichosonJohoEntity.get市町村ID有効桁数(), is(new RString("2")));
            IShichosonJoho shichosonJoho = shichosonJohoEntity.get市町村情報();
            assertThat(shichosonJoho.get証記載保険者番号().value(), is(defaultValueOfConfig));
            assertThat(shichosonJoho.get都道府県名称(), is(association.get都道府県名()));
            assertThat(shichosonJoho.get郡名称(), is(association.get郡名()));
            assertThat(shichosonJoho.get市町村コード(), is(association.get地方公共団体コード()));
        }

        @Test
        public void getShichosonSecurityJohoは_業務分類が介護事務_導入形態が事務広域_で_市町村識別IDが01の場合_構成市町村マスタから情報を取得しShichosonSecurityJohoを生成する() {
            ShichosonShikibetsuID shichosonShikibetsuID = new ShichosonShikibetsuID("01");
            setAutorityItem(shichosonShikibetsuID);

            ShichosonSecurityJohoFinder joho = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho shichosonJohoEntity = joho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            assertThat(shichosonJohoEntity.get導入形態コード(), is(DonyuKeitaiCode.事務広域));
            assertThat(shichosonJohoEntity.get広域タイプ(), is(KoikiType.toValue(defaultValueOfConfig)));
            assertThat(shichosonJohoEntity.get市町村ID有効桁数(), is(new RString("2")));
            IShichosonJoho shichosonJoho = shichosonJohoEntity.get市町村情報();
            assertThat(shichosonJoho.get市町村識別ID(), is(shichosonShikibetsuID));
        }

        @Test
        public void getShichosonSecurityJohoは_業務分類が介護事務_導入形態が事務広域_で_市町村識別IDが08の場合_構成市町村マスタから情報を取得しShichosonSecurityJohoを生成する() {
            ShichosonShikibetsuID shichosonShikibetsuID = new ShichosonShikibetsuID("99");
            setAutorityItem(shichosonShikibetsuID);

            ShichosonSecurityJohoFinder joho = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho shichosonJohoEntity = joho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            assertThat(shichosonJohoEntity.get導入形態コード(), is(DonyuKeitaiCode.事務広域));
            assertThat(shichosonJohoEntity.get広域タイプ(), is(KoikiType.toValue(defaultValueOfConfig)));
            assertThat(shichosonJohoEntity.get市町村ID有効桁数(), is(new RString("2")));
            IShichosonJoho shichosonJoho = shichosonJohoEntity.get市町村情報();
            assertThat(shichosonJoho.get市町村識別ID(), is(shichosonShikibetsuID));
        }

        @Test
        public void getShichosonSecurityJohoは_指定の業務分類に該当する情報が存在しない場合_null_を返す() {
            ShichosonSecurityJohoFinder joho = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho shichosonJoho = joho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
            assertThat(shichosonJoho, is(nullValue()));
        }
    }

    @RunWith(PowerMockRunner.class)
    @PrepareForTest({AuthorityItem.class, AuthItem.class, RDate.class, BusinessConfig.class, IAssociationFinder.class,
        AssociationFinderFactory.class, Association.class, ShichosonSecurityJohoFinder.class})
    public static class 介護事務_事務単一 extends DbxTestDacBase {

        @Before
        public void setKaigoDonyuKeiTai() {
            DbT7908KaigoDonyuKeitaiEntity entityDbT7908 = TestSupport.createDbT7908KaigoDonyuKeitaiEntity(
                    GyomuBunrui.介護事務, DonyuKeitaiCode.事務単一
            );
            kaigoDonyuKeitaiDac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
            kaigoDonyuKeitaiDac.save(entityDbT7908);
        }

        @Test
        public void getShichosonSecurityJohoは_指定の業務分類に該当する情報が存在しない場合_null_を返す()
                throws Exception {
            ShichosonSecurityJohoFinder joho = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho result = joho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
            assertThat(result, is(nullValue()));
        }

        @Test
        public void getShichosonSecurityJohoは_業務分類が介護事務_導入形態が事務単一120_のとき_業務コンフィグからShichosonSecurityJohoを生成する()
                throws Exception {
//            Association association = TestSupport.mockAssociation();
//            IAssociationFinder associationFinder = PowerMockito.mock(IAssociationFinder.class);
//            PowerMockito.when(associationFinder.getAssociation()).thenReturn(association);
//            PowerMockito.mockStatic(AssociationFinderFactory.class);
//            PowerMockito.when(AssociationFinderFactory.createInstance()).thenReturn(associationFinder);

            RDate rDate = new RDate("20140401");
//            PowerMockito.mockStatic(RDate.class);
//            PowerMockito.when(RDate.getNowDate()).thenReturn(rDate);

            RString defaultValueOfConfig = new RString("1");
//            PowerMockito.mockStatic(BusinessConfig.class);
//            PowerMockito.when(BusinessConfig.get((Enum) anyObject(), same(rDate), (SubGyomuCode) anyObject()))
//                    .thenReturn(defaultValueOfConfig);
            RString yubinNo = new RString("1234567");
//            PowerMockito.when(BusinessConfig.get(same(ConfigKeysHokenshaJoho.保険者情報_郵便番号), same(rDate), (SubGyomuCode) anyObject()))
//                    .thenReturn(yubinNo);

            ShichosonSecurityJohoFinder sut = new ShichosonSecurityJohoFinder();
            ShichosonSecurityJoho shichosonJohoEntity = sut.getShichosonSecurityJoho(GyomuBunrui.介護事務);
            assertThat(shichosonJohoEntity.get導入形態コード(), is(DonyuKeitaiCode.事務単一));
            assertThat(shichosonJohoEntity.get広域タイプ(), is(KoikiType.toValue(defaultValueOfConfig)));
            assertThat(shichosonJohoEntity.get市町村ID有効桁数(), is(new RString("2")));
            IShichosonJoho shichosonJoho = shichosonJohoEntity.get市町村情報();
            assertThat(shichosonJoho.get証記載保険者番号().value(), is(defaultValueOfConfig));
            assertThat(shichosonJoho.get郵便番号(), is(yubinNo));
        }
    }

    private static class TestSupport {

        public static void insert(DbT7051KoseiShichosonMasterEntity entity) {
            koseiShichosonMasterDac.save(entity);
        }

//        public static Association mockAssociation() {
//            Association finder = PowerMockito.mock(Association.class);
//            PowerMockito.when(finder.get都道府県名()).thenReturn(new RString("都道府県名"));
//            PowerMockito.when(finder.get郡名()).thenReturn(new RString("郡名"));
//            PowerMockito.when(finder.get地方公共団体コード()).thenReturn(new LasdecCode("010102"));
//            return finder;
//        }
        public static DbT7908KaigoDonyuKeitaiEntity createDbT7908KaigoDonyuKeitaiEntity(GyomuBunrui GyomuBunrui, DonyuKeitaiCode DonyuKeitaiCode) {
            DbT7908KaigoDonyuKeitaiEntity entity = new DbT7908KaigoDonyuKeitaiEntity();
            entity.setDonyuKeitaiCode(new Code(DonyuKeitaiCode.getCode()));
            entity.setGyomuBunrui(GyomuBunrui.code());
            entity.setShishoKanriUmuFlag(true);
            return entity;
        }

        public static DbT7051KoseiShichosonMasterEntity createDbT7051KoseiShichosonMasterEntity(
                RString ShichosonShokibetsuID) {
            DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
            entity.setShichosonShokibetsuID(ShichosonShokibetsuID);
            entity.setShichosonCode(new LasdecCode(new RString("888888")));
            entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(new RString("888888")));
            entity.setKokuhorenKoikiShichosonNo(new RString("88"));
            entity.setShichosonMeisho(new RString("88"));
            entity.setTodofukenMeisho(new RString("88"));
            entity.setGunMeisho(new RString("88"));
            entity.setYusenChikuCode(new RString("8"));
            entity.setTyohyoTodoufukenHyojiUmu(new RString("8"));
            entity.setTyohyoGunHyojiUmu(new RString("8"));
            entity.setTyohyoShichosonHyojiUmu(new RString("8"));
            entity.setTyohyoJushoHenshuHouhou(new RString("8"));
            entity.setTyohyoKatagakiHyojiUmu(new RString("8"));
            entity.setRojinhokenShichosonNo(new RString("8"));
            entity.setRokenJukyushaNoTaikei(new RString("8"));
            entity.setTokuchoBunpaishuyaku(new RString("8"));
            entity.setKanyuYMD(new FlexibleDate("88888888"));
            entity.setGappeiKyuShichosonKubun(new RString("8"));
            entity.setGappeiKyuShichosonHyojiUmu(new RString("8"));
            entity.setGappeiChiikiNo(new RString("8"));
            entity.setUnyoHokenshaNo(new ShoKisaiHokenshaNo(new RString("888888")));
            entity.setUnyoKaishiYMD(new FlexibleDate("88888888"));
            entity.setUnyoShuryoYMD(new FlexibleDate("88888888"));
            entity.setUnyoKeitaiKubun(new RString("8"));
            entity.setGaikokujinHyojiHouhou(new RString("8"));
            return entity;
        }

        private TestSupport() {
        }
    }
}
