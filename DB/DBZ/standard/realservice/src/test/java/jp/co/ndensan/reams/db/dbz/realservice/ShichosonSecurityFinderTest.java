/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HokenshaKoseiKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.model.KoikiShichosonSecurityModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.items.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KoikiShichosonSecurityDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.auth.GroupEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.entities.UzT0010SubGyomuCodeEntity;
import jp.co.ndensan.reams.uz.uza.util.gyomu.IntroductionGyomuWithTanitsuFg;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 市町村情報のセキュリティを取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShichosonSecurityFinderTest extends DbzTestBase {

    private static final int 介護導入あり = 0;
    private static final int 介護導入なし = 1;
    private static final int 単一市町村 = 2;
    private static final int 広域保険者 = 3;
    private static final int 保険者構成不正 = 4;
    private static final int グループリストあり = 5;
    private static final int グループリストなし = 6;
    private static final int セキュリティリストあり = 7;
    private static final int セキュリティリストなし = 8;
    private static final int 指定なし = 9;

    private static final ShichosonShikibetsuID 市町村識別ID_デフォルト = new ShichosonShikibetsuID("00");
    private static final ShichosonShikibetsuID 市町村識別ID_DB = new ShichosonShikibetsuID("01");
    private static final ShichosonCode 市町村コード_コンフィグ = new ShichosonCode("12345");
    private static final ShichosonCode 市町村コード_DB = new ShichosonCode("00003");
    private static final RString グループID = new RString("0000000004");

    public static class getSecurity {

        @Test
        public void 介護導入あり_単一市町村の時_getSecurity_市町村識別IDは_デフォルト値を返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 単一市町村, 指定なし, 指定なし);
            assertThat(sut.getSecurity().get市町村識別ID(), is(市町村識別ID_デフォルト));
        }

        @Test
        public void 介護導入あり_単一市町村の時_getSecurity_市町村コードは_コンフィグ値を返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 単一市町村, 指定なし, 指定なし);
            assertThat(sut.getSecurity().get市町村コード(), is(市町村コード_コンフィグ));
        }

        @Test
        public void 介護導入あり_広域保険者_グループリストあり_セキュリティリストありの時_getSecurity_市町村識別IDは_DB値を返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 広域保険者, グループリストあり, セキュリティリストあり);
            assertThat(sut.getSecurity().get市町村識別ID(), is(市町村識別ID_DB));
        }

        @Test
        public void 介護導入あり_広域保険者_グループリストあり_セキュリティリストありの時_getSecurity_市町村コードは_DB値を返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 広域保険者, グループリストあり, セキュリティリストあり);
            assertThat(sut.getSecurity().get市町村コード(), is(市町村コード_DB));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護導入あり_広域保険者_グループリストあり_セキュリティリストなしの時_getSecurityは_IllegalArgumentExceptionを投げる() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 広域保険者, グループリストあり, セキュリティリストなし);
            sut.getSecurity();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護導入あり_広域保険者_グループリストなしの時_getSecurityは_IllegalArgumentExceptionを投げる() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 広域保険者, グループリストなし, 指定なし);
            sut.getSecurity();
        }

        @Test(expected = IllegalArgumentException.class)
        public void 介護導入あり_保険者構成不正の時_getSecurityは_IllegalArgumentExceptionを投げる() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入あり, 保険者構成不正, 指定なし, 指定なし);
            sut.getSecurity();
        }

        @Test
        public void 介護導入なしの時_getSecurity_市町村識別IDは_nullを返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入なし, 指定なし, 指定なし, 指定なし);
            assertThat(sut.getSecurity().get市町村識別ID(), nullValue());
        }

        @Test
        public void 介護導入なしの時_getSecurity_市町村コードは_nullを返す() {
            ShichosonSecurityFinder sut = createShichosonSecurityFinder(介護導入なし, 指定なし, 指定なし, 指定なし);
            assertThat(sut.getSecurity().get市町村コード(), nullValue());
        }
    }

    private static ShichosonSecurityFinder createShichosonSecurityFinder(int 導入, int 構成, int グループ, int セキュリティ) {
        return new ShichosonSecurityFinder(createSecurityDac(セキュリティ), createHokenshaJohoConfig(構成), createGroupList(グループ), createGyomuList(導入));
    }

    private static KoikiShichosonSecurityDac createSecurityDac(int flg) {
        KoikiShichosonSecurityDac dac = mock(KoikiShichosonSecurityDac.class);
        IItemList<KoikiShichosonSecurityModel> list = createKoikiShichosonSecurityList(flg);
        when(dac.select(any(ITrueFalseCriteria.class))).thenReturn(list);
        return dac;
    }

    private static HokenshaJohoConfig createHokenshaJohoConfig(int flg) {
        Map<ConfigKeysHokenshaJoho, RString> configs = new HashMap<>();
        configs.put(ConfigKeysHokenshaJoho.保険者情報_保険者構成, createHokenshaKosei(flg).getCode());
        return new HokenshaJohoConfig(configs);
    }

    private static List<GroupEntity> createGroupList(int flg) {
        List<GroupEntity> list = new ArrayList<>();
        if (flg == グループリストあり) {
            list.add(createGroup());
        }
        return list;
    }

    private static GroupEntity createGroup() {
        GroupEntity group = mock(GroupEntity.class);
        when(group.getGroupId()).thenReturn(グループID);
        return group;
    }

    private static IntroductionGyomuWithTanitsuFg[] createGyomuList(int flg) {
        List<IntroductionGyomuWithTanitsuFg> list = new ArrayList<>();
        if (flg == 介護導入あり) {
            list.add(createGyomu());
        }
        return (IntroductionGyomuWithTanitsuFg[]) list.toArray(new IntroductionGyomuWithTanitsuFg[]{});
    }

    private static IntroductionGyomuWithTanitsuFg createGyomu() {
        IntroductionGyomuWithTanitsuFg gyomu = mock(IntroductionGyomuWithTanitsuFg.class);
        UzT0010SubGyomuCodeEntity entity = mock(UzT0010SubGyomuCodeEntity.class);
        SubGyomuCode code = SubGyomuCode.DBU介護統計報告;
        when(entity.getSubGyomuCode()).thenReturn(code);
        when(gyomu.getSubGyomu()).thenReturn(entity);
        return gyomu;
    }

    private static IItemList<KoikiShichosonSecurityModel> createKoikiShichosonSecurityList(int flg) {
        List<KoikiShichosonSecurityModel> list = new ArrayList<>();
        if (flg == セキュリティリストあり) {
            list.add(createKoikiShichosonSecurity(市町村識別ID_DB, 市町村コード_DB));
        }
        return ItemList.of(list);
    }

    private static KoikiShichosonSecurityModel createKoikiShichosonSecurity(ShichosonShikibetsuID 市町村識別ID, ShichosonCode 市町村コード) {
        KoikiShichosonSecurityModel security = mock(KoikiShichosonSecurityModel.class);
        when(security.get市町村識別ID()).thenReturn(市町村識別ID);
        when(security.get市町村コード()).thenReturn(市町村コード);
        return security;
    }

    private static HokenshaKoseiKubun createHokenshaKosei(int flg) {
        switch (flg) {
            case 単一市町村:
                return HokenshaKoseiKubun.単一市町村;
            case 広域保険者:
                return HokenshaKoseiKubun.広域保険者;
            default:
                break;
        }
        return HokenshaKoseiKubun.UNKNOWN;
    }
}
