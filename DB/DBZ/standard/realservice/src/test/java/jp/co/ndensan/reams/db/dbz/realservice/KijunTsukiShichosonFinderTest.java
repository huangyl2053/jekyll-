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
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShinKyuHokenshaNoHenkanKubun;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.gappei.GappeiShichosonJohoModel;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiJoho;
import jp.co.ndensan.reams.db.dbz.model.gappei.IGappeiShichoson;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.koiki.IKoikiKoseiShichoson;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.realservice.gappei.IGappeiShichosonFinder;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GesshoGetsumatsuKubun.*;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShikakuSoshitsuJiyu;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 基準月時点の市町村情報を取得するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KijunTsukiShichosonFinderTest extends DbzTestBase {

    private static List<HihokenshaDaichoModel> 被保険者台帳List;

    private static Map<Integer, IGappeiJoho> 合併情報Map;
    private static Map<Integer, IGappeiShichoson> 合併市町村Map;
    private static Map<Integer, IKoikiKoseiShichoson> 構成市町村Map;

    private static HokenshaKosei 保険者構成区分;

    private static GappeiShichosonJohoModel 最新合併市町村情報By市町村コード;
    private static GappeiShichosonJohoModel 最新合併市町村情報By保険者番号;
    private static GappeiShichosonJohoModel 最新合併市町村情報By保険者番号And基準年月;
    private static GappeiShichosonJohoModel 最古合併市町村情報By旧市町村コード;
    private static List<GappeiShichosonJohoModel> 合併市町村情報By旧市町村コード;
    private static GappeiShichosonJohoModel 直近合併市町村情報By旧保険者番号;
    private static GappeiShichosonJohoModel 直近合併市町村情報By旧保険者番号And基準年月;
    private static GappeiShichosonJohoModel 市町村情報By市町村コード;
    private static GappeiShichosonJohoModel 市町村情報By保険者番号;
    private static GappeiShichosonJohoModel 最古市町村情報;

    private static IGappeiJoho param合併情報;
    private static List<IGappeiShichoson> param合併市町村;
    private static List<IKoikiKoseiShichoson> param構成市町村;

    public static class パターン１_単一市町村合併 {

        @Before
        public void setup() {

            initialize();

            合併情報Map.put(1, createGappeiJoho("20041101", "01", "000100", "1", "100100", "", "20041101"));
            合併情報Map.put(2, createGappeiJoho("20051001", "01", "000100", "2", "100100", "", "20051001"));
            合併情報Map.put(3, createGappeiJoho("20060610", "01", "000100", "2", "100100", "", "20060630"));

            合併市町村Map.put(1, createGappeiShichoson("20041101", "01", "000001", "20000401", "20041031", "100001", "A市", "1"));
            合併市町村Map.put(2, createGappeiShichoson("20041101", "01", "000002", "20000401", "20041031", "100002", "B市", "1"));
            合併市町村Map.put(3, createGappeiShichoson("20051001", "01", "000100", "20041101", "20050930", "100100", "C市", "1"));
            合併市町村Map.put(4, createGappeiShichoson("20051001", "01", "000003", "20000401", "20050930", "100003", "D市", "1"));
            合併市町村Map.put(5, createGappeiShichoson("20060610", "01", "000100", "20051001", "20060609", "100100", "C市", "1"));
            合併市町村Map.put(6, createGappeiShichoson("20060610", "01", "000004", "20000401", "20060609", "100004", "E市", "1"));

            保険者構成区分 = 単一市町村;
        }

        @Test
        public void 例１() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20010316083001", "02", "20010316", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200410"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(1)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(1)));
        }

        @Test
        public void 例２() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20041001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(2), get合併市町村(3)));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(3), get合併市町村(5)));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200411"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(3)));
        }

        @Test
        public void 例３() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(2), get合併市町村(3)));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(3), get合併市町村(5)));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200509"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(3)));
        }

        @Test
        public void 例４() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(2), get合併市町村(3)));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(3), get合併市町村(5)));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200510"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(3)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例５() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(2), get合併市町村(3)));
            合併市町村情報By旧市町村コード.add(getParam(get合併情報(3), get合併市町村(5)));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200605"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(3)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例６() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200606"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(3)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例７() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", "000001"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", "000001"));

            最新合併市町村情報By市町村コード = getParam(get合併情報(3), get合併市町村(5), get合併市町村(6));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(1), get合併市町村(1));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200607"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(3)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例８() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000401010101", "02", "20000401", "51", "20000701", ""));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "", "", ""));

            市町村情報By市町村コード = getParam(null, get合併市町村(5));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200607"), 月初).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例９() {
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000601010101", "02", "20000601", "51", "20000701", ""));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20000701010102", "05", "20000701", "92", "20041101", ""));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20041101083001", "42", "20041101", "55", "20051001", ""));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20051001083001", "55", "20051001", "", "", ""));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            Optional<GappeiShichosonJohoModel> result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200004"), 月初);

            assertThat(result.isPresent(), is(false));
        }
    }

    public static class パターン２_広域合併市町村 {

        @Before
        public void setup() {

            initialize();

            被保険者台帳List.add(createHihokenshaDaicho("000200", "0000000001", "20000401010101", "02", "20000401", "91", "20030401", "000046"));
            被保険者台帳List.add(createHihokenshaDaicho("000200", "0000000001", "20030401010101", "41", "20030401", "61", "20050106", "000046"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20060101083001", "11", "20050106", "92", "20060101", "000043"));
            被保険者台帳List.add(createHihokenshaDaicho("000100", "0000000001", "20060101083001", "42", "20060101", "", "", "000043"));

            合併情報Map.put(1, createGappeiJoho("20061001", "01", "000100", "1", "100056", "", "20061001"));
            合併情報Map.put(2, createGappeiJoho("20061001", "02", "000200", "2", "100057", "", "20061001"));

            構成市町村Map.put(1, createKoikiKoseiShichoson("01", "000001", "100001", "電算１", "20030401", "", "0", "0", ""));
            構成市町村Map.put(2, createKoikiKoseiShichoson("02", "000002", "100002", "電算２", "20030401", "", "0", "0", ""));
            構成市町村Map.put(3, createKoikiKoseiShichoson("03", "000003", "100003", "電算３", "20030401", "", "0", "0", ""));
            構成市町村Map.put(4, createKoikiKoseiShichoson("04", "000004", "100004", "電算４", "20030401", "", "0", "0", ""));
            構成市町村Map.put(5, createKoikiKoseiShichoson("21", "000021", "100021", "電算２１", "20030401", "", "0", "0", ""));
            構成市町村Map.put(6, createKoikiKoseiShichoson("22", "000022", "100022", "電算２２", "20030401", "20050331", "", "", ""));
            構成市町村Map.put(7, createKoikiKoseiShichoson("23", "000023", "100023", "電算２３", "20030401", "20050331", "", "", ""));
            構成市町村Map.put(8, createKoikiKoseiShichoson("43", "000043", "100043", "電算４３", "20030401", "20051231", "1", "1", "01"));
            構成市町村Map.put(9, createKoikiKoseiShichoson("44", "000044", "100044", "電算４４", "20030401", "20051231", "1", "1", "01"));
            構成市町村Map.put(10, createKoikiKoseiShichoson("45", "000045", "100045", "電算４５", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(11, createKoikiKoseiShichoson("46", "000046", "100046", "電算４６", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(12, createKoikiKoseiShichoson("47", "000047", "100047", "電算４７", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(13, createKoikiKoseiShichoson("48", "000048", "100048", "電算４８", "20030401", "", "0", "0", ""));
            構成市町村Map.put(14, createKoikiKoseiShichoson("49", "000049", "100049", "電算４９", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(15, createKoikiKoseiShichoson("56", "000100", "100056", "電算５６", "20060101", "", "0", "0", ""));
            構成市町村Map.put(16, createKoikiKoseiShichoson("57", "000200", "100057", "電算５７", "20060101", "", "0", "0", ""));

            構成市町村Map.put(21, createKoikiKoseiShichoson("43", "000043", "100043", "電算４３", "20030401", "", "0", "0", ""));
            構成市町村Map.put(22, createKoikiKoseiShichoson("44", "000044", "100044", "電算４４", "20030401", "", "0", "0", ""));
            構成市町村Map.put(23, createKoikiKoseiShichoson("45", "000045", "100045", "電算４５", "20030401", "", "0", "0", ""));
            構成市町村Map.put(24, createKoikiKoseiShichoson("46", "000046", "100046", "電算４６", "20030401", "", "0", "0", ""));
            構成市町村Map.put(25, createKoikiKoseiShichoson("47", "000047", "100047", "電算４７", "20030401", "", "0", "0", ""));
            構成市町村Map.put(26, createKoikiKoseiShichoson("49", "000049", "100049", "電算４９", "20030401", "", "0", "0", ""));

            保険者構成区分 = 広域市町村;
        }

        @Test
        public void 例１() {
            最新合併市町村情報By市町村コード = getParam(get合併情報(2), get構成市町村(16));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(2), get構成市町村(11));
            最古市町村情報 = getParam(null, get構成市町村(11));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200501"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(11)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例２() {
            最新合併市町村情報By市町村コード = getParam(get合併情報(1), get構成市町村(15));
            最古市町村情報 = getParam(null, get構成市町村(15));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200611"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(1)));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(15)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例３() {
            最新合併市町村情報By市町村コード = getParam(get合併情報(2), get構成市町村(16));
            最古合併市町村情報By旧市町村コード = getParam(get合併情報(2), get構成市町村(11));
            最古市町村情報 = getParam(null, get構成市町村(11));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200303"), 月初).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(11)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換必要));
        }

        @Test
        public void 例４() {
            市町村情報By市町村コード = getParam(null, get構成市町村(24));
            最古市町村情報 = getParam(null, get構成市町村(24));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200501"), 月初).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(24)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例５() {
            市町村情報By市町村コード = getParam(null, get構成市町村(21));
            最古市町村情報 = getParam(null, get構成市町村(21));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200607"), 月初).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(21)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例６() {
            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            Optional<GappeiShichosonJohoModel> result = sut.get基準月市町村情報(被保険者台帳List, get基準年月("200001"), 月初);

            assertThat(result.isPresent(), is(false));
        }
    }

    public static class パターン３_単一市町村合併 {

        @Before
        public void setup() {

            initialize();

            合併情報Map.put(1, createGappeiJoho("20041101", "01", "000100", "1", "100100", "", "20041101"));
            合併情報Map.put(2, createGappeiJoho("20051001", "01", "000100", "2", "100100", "", "20051001"));
            合併情報Map.put(3, createGappeiJoho("20060610", "01", "000100", "2", "100100", "", "20060630"));

            合併市町村Map.put(1, createGappeiShichoson("20041101", "01", "000001", "20000401", "20041031", "100001", "A市", "1"));
            合併市町村Map.put(2, createGappeiShichoson("20041101", "01", "000002", "20000401", "20041031", "100002", "B市", "1"));
            合併市町村Map.put(3, createGappeiShichoson("20051001", "01", "000100", "20041101", "20050930", "100100", "C市", "1"));
            合併市町村Map.put(4, createGappeiShichoson("20051001", "01", "000003", "20000401", "20050930", "100003", "D市", "1"));
            合併市町村Map.put(5, createGappeiShichoson("20060610", "01", "000100", "20051001", "20060609", "100100", "C市", "1"));
            合併市町村Map.put(6, createGappeiShichoson("20060610", "01", "000004", "20000401", "20060609", "100004", "E市", "1"));

            構成市町村Map.put(1, createKoikiKoseiShichoson("01", "000001", "100001", "電算１", "20030401", "", "0", "0", ""));
            構成市町村Map.put(2, createKoikiKoseiShichoson("02", "000002", "100002", "電算２", "20030401", "", "0", "0", ""));

            保険者構成区分 = 単一市町村;
        }

        @Test
        public void 例１() {
            直近合併市町村情報By旧保険者番号 = getParam(get合併情報(3), get合併市町村(5));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200410"), get保険者番号("100100")).get();

            assertThat(result.get合併情報().get(), is(get合併情報(3)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例２() {
            最新合併市町村情報By保険者番号And基準年月 = getParam(get合併情報(1), get合併市町村(1), get合併市町村(2));
            直近合併市町村情報By旧保険者番号And基準年月 = getParam(get合併情報(2), get合併市町村(3));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100100")).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(3)));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 例３() {
            最新合併市町村情報By保険者番号 = getParam(get合併情報(1), get合併市町村(1), get合併市町村(2));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            sut.get基準月市町村情報(get基準年月("200410"), get保険者番号("100100"));
        }

        @Test
        public void 例４() {
            最新合併市町村情報By保険者番号And基準年月 = getParam(get合併情報(1), get合併市町村(1), get合併市町村(2));
            市町村情報By保険者番号 = getParam(null, get合併市町村(5));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100100")).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }

        @Test
        public void 例５() {
            市町村情報By保険者番号 = getParam(null, get合併市町村(5));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100100")).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get単一市町村情報().toList().get(0), is(get合併市町村(5)));
        }
    }

    public static class パターン４_広域市町村合併 {

        @Before
        public void setup() {

            initialize();

            合併情報Map.put(1, createGappeiJoho("20061001", "01", "000100", "1", "100100", "", "20061001"));
            合併情報Map.put(2, createGappeiJoho("20061001", "02", "000200", "2", "100200", "", "20061001"));

            構成市町村Map.put(1, createKoikiKoseiShichoson("01", "000001", "100001", "電算１", "20030401", "", "0", "0", ""));
            構成市町村Map.put(2, createKoikiKoseiShichoson("02", "000002", "100002", "電算２", "20030401", "", "0", "0", ""));
            構成市町村Map.put(3, createKoikiKoseiShichoson("03", "000003", "100003", "電算３", "20030401", "", "0", "0", ""));
            構成市町村Map.put(4, createKoikiKoseiShichoson("04", "000004", "100004", "電算４", "20030401", "", "0", "0", ""));
            構成市町村Map.put(5, createKoikiKoseiShichoson("21", "000021", "100021", "電算２１", "20030401", "", "0", "0", ""));
            構成市町村Map.put(6, createKoikiKoseiShichoson("22", "000022", "100022", "電算２２", "20030401", "20050331", "", "", ""));
            構成市町村Map.put(7, createKoikiKoseiShichoson("23", "000023", "100023", "電算２３", "20030401", "20050331", "", "", ""));
            構成市町村Map.put(8, createKoikiKoseiShichoson("43", "000043", "100043", "電算４３", "20030401", "20051231", "1", "1", "01"));
            構成市町村Map.put(9, createKoikiKoseiShichoson("44", "000044", "100044", "電算４４", "20030401", "20051231", "1", "1", "01"));
            構成市町村Map.put(10, createKoikiKoseiShichoson("45", "000045", "100045", "電算４５", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(11, createKoikiKoseiShichoson("46", "000046", "100046", "電算４６", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(12, createKoikiKoseiShichoson("47", "000047", "100047", "電算４７", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(13, createKoikiKoseiShichoson("48", "000048", "100048", "電算４８", "20030401", "", "0", "0", ""));
            構成市町村Map.put(14, createKoikiKoseiShichoson("49", "000049", "100049", "電算４９", "20030401", "20051231", "1", "1", "02"));
            構成市町村Map.put(15, createKoikiKoseiShichoson("56", "000100", "100100", "電算５６", "20060101", "", "0", "0", ""));
            構成市町村Map.put(16, createKoikiKoseiShichoson("57", "000200", "100200", "電算５７", "20060101", "", "0", "0", ""));

            構成市町村Map.put(21, createKoikiKoseiShichoson("43", "000043", "100043", "電算４３", "20030401", "", "0", "0", ""));
            構成市町村Map.put(22, createKoikiKoseiShichoson("44", "000044", "100044", "電算４４", "20030401", "", "0", "0", ""));
            構成市町村Map.put(23, createKoikiKoseiShichoson("45", "000045", "100045", "電算４５", "20030401", "", "0", "0", ""));
            構成市町村Map.put(24, createKoikiKoseiShichoson("46", "000046", "100046", "電算４６", "20030401", "", "0", "0", ""));
            構成市町村Map.put(25, createKoikiKoseiShichoson("47", "000047", "100047", "電算４７", "20030401", "", "0", "0", ""));
            構成市町村Map.put(26, createKoikiKoseiShichoson("49", "000049", "100049", "電算４９", "20030401", "", "0", "0", ""));

            保険者構成区分 = 広域市町村;
        }

        @Test(expected = IllegalArgumentException.class)
        public void 例１() {
            最新合併市町村情報By保険者番号 = getParam(get合併情報(1), get構成市町村(8), get構成市町村(9));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            sut.get基準月市町村情報(get基準年月("200410"), get保険者番号("100100"));
        }

        @Test
        public void 例２() {
            直近合併市町村情報By旧保険者番号 = getParam(get合併情報(2), get構成市町村(11));
            最古市町村情報 = getParam(null, get構成市町村(11));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100046")).get();

            assertThat(result.get合併情報().get(), is(get合併情報(2)));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(11)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例３() {
            市町村情報By保険者番号 = getParam(null, get構成市町村(13));
            最古市町村情報 = getParam(null, get構成市町村(13));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100048")).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(13)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }

        @Test
        public void 例４() {
            最新合併市町村情報By保険者番号And基準年月 = getParam(get合併情報(1), get構成市町村(8), get構成市町村(9));
            市町村情報By保険者番号 = getParam(get合併情報(1), get構成市町村(15));
            最古市町村情報 = getParam(null, get構成市町村(15));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200411"), get保険者番号("100100")).get();

            assertThat(result.get合併情報().get(), is(get合併情報(1)));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(15)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換必要));
        }

        @Test
        public void 例５() {
            市町村情報By保険者番号 = getParam(null, get構成市町村(24));
            最古市町村情報 = getParam(null, get構成市町村(24));

            KijunTsukiShichosonFinder sut = createKijunTsukiShichosonFinder();
            GappeiShichosonJohoModel result = sut.get基準月市町村情報(get基準年月("200410"), get保険者番号("100046")).get();

            assertThat(result.get合併情報().isPresent(), is(false));
            assertThat(result.get広域市町村情報().toList().get(0), is(get構成市町村(24)));
            assertThat(result.get新旧保険者番号変換区分(), is(ShinKyuHokenshaNoHenkanKubun.変換不要));
        }
    }

    private static void initialize() {
        被保険者台帳List = new ArrayList<>();

        合併情報Map = new HashMap<>();
        合併市町村Map = new HashMap<>();
        構成市町村Map = new HashMap<>();

        保険者構成区分 = 単一市町村;

        最新合併市町村情報By市町村コード = null;
        最新合併市町村情報By保険者番号 = null;
        最新合併市町村情報By保険者番号And基準年月 = null;
        最古合併市町村情報By旧市町村コード = null;
        合併市町村情報By旧市町村コード = new ArrayList<>();
        直近合併市町村情報By旧保険者番号 = null;
        直近合併市町村情報By旧保険者番号And基準年月 = null;
        市町村情報By市町村コード = null;
        市町村情報By保険者番号 = null;
        最古市町村情報 = null;
    }

    private static KijunTsukiShichosonFinder createKijunTsukiShichosonFinder() {
        return new KijunTsukiShichosonFinder(createGappeiShichosonFinder());
    }

    private static IGappeiShichosonFinder createGappeiShichosonFinder() {
        IGappeiShichosonFinder finder = mock(IGappeiShichosonFinder.class);
        when(finder.get最新合併市町村情報(any(LasdecCode.class))).thenReturn(Optional.ofNullable(最新合併市町村情報By市町村コード));
        when(finder.get最新合併市町村情報(any(ShoKisaiHokenshaNo.class))).thenReturn(Optional.ofNullable(最新合併市町村情報By保険者番号));
        when(finder.get最新合併市町村情報(any(ShoKisaiHokenshaNo.class), any(FlexibleYearMonth.class))).thenReturn(Optional.ofNullable(最新合併市町村情報By保険者番号And基準年月));
        when(finder.get最古合併市町村情報(any(LasdecCode.class))).thenReturn(Optional.ofNullable(最古合併市町村情報By旧市町村コード));
        when(finder.get合併市町村情報(any(LasdecCode.class))).thenReturn(ItemList.of(合併市町村情報By旧市町村コード));
        when(finder.get直近合併市町村情報(any(ShoKisaiHokenshaNo.class))).thenReturn(Optional.ofNullable(直近合併市町村情報By旧保険者番号));
        when(finder.get直近合併市町村情報(any(ShoKisaiHokenshaNo.class), any(FlexibleYearMonth.class))).thenReturn(Optional.ofNullable(直近合併市町村情報By旧保険者番号And基準年月));
        when(finder.get市町村情報(any(LasdecCode.class))).thenReturn(Optional.ofNullable(市町村情報By市町村コード));
        when(finder.get市町村情報(any(ShoKisaiHokenshaNo.class))).thenReturn(Optional.ofNullable(市町村情報By保険者番号));
        when(finder.get最古市町村情報(any(LasdecCode.class))).thenReturn(Optional.ofNullable(最古市町村情報));
        return finder;
    }

    private static HihokenshaDaichoModel createHihokenshaDaicho(
            String 市町村コード, String 被保険者番号, String 処理日時, String 資格取得事由コード, String 資格取得日,
            String 資格喪失事由コード, String 資格喪失日, String 旧市町村コード) {
        HihokenshaDaichoModel mock = mock(HihokenshaDaichoModel.class);
        when(mock.get市町村コード()).thenReturn(new LasdecCode(市町村コード));
        when(mock.get被保険者番号()).thenReturn(new HihokenshaNo(new RString(被保険者番号)));
        when(mock.get処理日時()).thenReturn(new YMDHMS(処理日時));
        when(mock.get資格取得事由()).thenReturn(ShikakuShutokuJiyu.toValue(new RString(資格取得事由コード)));
        when(mock.get資格取得年月日()).thenReturn(new FlexibleDate(資格取得日));
        when(mock.get資格喪失事由()).thenReturn(ShikakuSoshitsuJiyu.toValue(new RString(資格喪失事由コード)));
        when(mock.get資格喪失年月日()).thenReturn(new FlexibleDate(資格喪失日));
        when(mock.get旧市町村コード()).thenReturn(new LasdecCode(旧市町村コード));
        return mock;
    }

    private static GappeiShichosonJohoModel createGappeiShichosonJoho(IGappeiJoho 合併情報, List<IGappeiShichoson> 合併市町村List, List<IKoikiKoseiShichoson> 構成市町村List) {
        GappeiShichosonJohoModel mock = mock(GappeiShichosonJohoModel.class);
        when(mock.get合併情報()).thenReturn(Optional.ofNullable(合併情報));
        when(mock.get保険者構成区分()).thenReturn(保険者構成区分);
        when(mock.get単一市町村情報()).thenReturn(ItemList.of(合併市町村List));
        when(mock.get広域市町村情報()).thenReturn(ItemList.of(構成市町村List));
        when(mock.get新旧保険者番号変換区分()).thenReturn(ShinKyuHokenshaNoHenkanKubun.UNKNOWN);
        return mock;
    }

    private static IGappeiJoho createGappeiJoho(
            String 合併日, String 地域番号, String 市町村コード, String 合併種類, String 保険者番号,
            String 旧市町村情報付与終了日, String 国保連データ連携開始日) {
        IGappeiJoho mock = mock(IGappeiJoho.class);
        when(mock.get合併日()).thenReturn(new FlexibleDate(合併日));
        when(mock.get地域番号()).thenReturn(new RString(地域番号));
        when(mock.get市町村コード()).thenReturn(new LasdecCode(市町村コード));
        when(mock.get合併種類()).thenReturn(new RString(合併種類));
        when(mock.get保険者番号()).thenReturn(new ShoKisaiHokenshaNo(new RString(保険者番号)));
        when(mock.get旧市町村情報付与終了日()).thenReturn(new FlexibleDate(旧市町村情報付与終了日));
        when(mock.get国保連データ連携開始日()).thenReturn(new FlexibleDate(国保連データ連携開始日));
        return mock;
    }

    private static IGappeiShichoson createGappeiShichoson(
            String 合併日, String 地域番号, String 旧市町村コード, String 運用開始日, String 運用終了日,
            String 旧保険者番号, String 旧市町村名称, String 表示有無) {
        IGappeiShichoson mock = mock(IGappeiShichoson.class);
        when(mock.get合併日()).thenReturn(new FlexibleDate(合併日));
        when(mock.get地域番号()).thenReturn(new RString(地域番号));
        when(mock.get旧市町村コード()).thenReturn(new LasdecCode(旧市町村コード));
        when(mock.get運用開始日()).thenReturn(new FlexibleDate(運用開始日));
        when(mock.get運用終了日()).thenReturn(new FlexibleDate(運用終了日));
        when(mock.get旧保険者番号()).thenReturn(new ShoKisaiHokenshaNo(new RString(旧保険者番号)));
        when(mock.get旧市町村名称()).thenReturn(new RString(旧市町村名称));
        when(mock.get表示有無()).thenReturn(new RString(表示有無));
        return mock;
    }

    private static IKoikiKoseiShichoson createKoikiKoseiShichoson(
            String 市町村識別ID, String 市町村コード, String 証記載保険者番号, String 市町村名称, String 加入日,
            String 離脱日, String 合併旧市町村区分, String 合併旧市町村表示有無, String 合併情報地域番号) {
        IKoikiKoseiShichoson mock = mock(IKoikiKoseiShichoson.class);
        when(mock.get市町村識別ID()).thenReturn(new RString(市町村識別ID));
        when(mock.get市町村コード()).thenReturn(new LasdecCode(市町村コード));
        when(mock.get証記載保険者番号()).thenReturn(new ShoKisaiHokenshaNo(証記載保険者番号));
        when(mock.get市町村名称()).thenReturn(new RString(市町村名称));
        when(mock.get加入日()).thenReturn(new FlexibleDate(加入日));
        when(mock.get離脱日()).thenReturn(new FlexibleDate(離脱日));
        when(mock.get合併旧市町村区分()).thenReturn(new RString(合併旧市町村区分));
        when(mock.get合併旧市町村表示有無()).thenReturn(new RString(合併旧市町村表示有無));
        when(mock.get合併情報地域番号()).thenReturn(new RString(合併情報地域番号));
        return mock;
    }

    private static FlexibleYearMonth get基準年月(String 基準年月) {
        return new FlexibleYearMonth(基準年月);
    }

    private static ShoKisaiHokenshaNo get保険者番号(String 保険者番号) {
        return new ShoKisaiHokenshaNo(保険者番号);
    }

    private static IGappeiJoho get合併情報(int key) {
        return 合併情報Map.get(key);
    }

    private static IGappeiShichoson get合併市町村(int key) {
        return 合併市町村Map.get(key);
    }

    private static IKoikiKoseiShichoson get構成市町村(int key) {
        return 構成市町村Map.get(key);
    }

    private static void initParam() {
        param合併情報 = null;
        param合併市町村 = new ArrayList<>();
        param構成市町村 = new ArrayList<>();
    }

    private static GappeiShichosonJohoModel getParam(IGappeiJoho param1, IGappeiShichoson param2) {
        initParam();
        param合併情報 = param1;
        param合併市町村.add(param2);
        return getParam();
    }

    private static GappeiShichosonJohoModel getParam(IGappeiJoho param1, IGappeiShichoson param2, IGappeiShichoson param3) {
        initParam();
        param合併情報 = param1;
        param合併市町村.add(param2);
        param合併市町村.add(param3);
        return getParam();
    }

    private static GappeiShichosonJohoModel getParam(IGappeiJoho param1, IKoikiKoseiShichoson param2) {
        initParam();
        param合併情報 = param1;
        param構成市町村.add(param2);
        return getParam();
    }

    private static GappeiShichosonJohoModel getParam(IGappeiJoho param1, IKoikiKoseiShichoson param2, IKoikiKoseiShichoson param3) {
        initParam();
        param合併情報 = param1;
        param構成市町村.add(param2);
        param構成市町村.add(param3);
        return getParam();
    }

    private static GappeiShichosonJohoModel getParam() {
        return createGappeiShichosonJoho(param合併情報, param合併市町村, param構成市町村);
    }
}
