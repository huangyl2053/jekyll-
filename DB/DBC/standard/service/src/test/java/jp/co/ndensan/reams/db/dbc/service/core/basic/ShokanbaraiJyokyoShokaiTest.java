/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKinkyuShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShoteiShikkanShisetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiNyushoshaKaigoServiceHiyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryoTokubetsuRyoyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.service.core.shokanbaraijyokyoshokai.ShokanbaraiJyokyoShokai;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;

/**
 *
 * @author SE1007
 */
public class ShokanbaraiJyokyoShokaiTest extends DbcTestBase {

    @Test
    public void getShokanbaraiShinseiJyohoDetail() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanShinsei> returnList = sut.getShokanbaraiShinseiJyohoDetail(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"));

        System.out.print(returnList.size());
    }

    @Test
    public void getShokanbaraiShinseiJyohoList() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanShukei> returnList = sut.getShokanbaraiShinseiJyohoList(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"));

        System.out.print(returnList.size());
    }

    @Test
    public void getShokanbarayiSeikyukihonDetail() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanKihon> returnList = sut.getShokanbarayiSeikyukihonDetail(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("1234"),
                new RString("4567"));

        System.out.print(returnList.size());
    }

    @Test
    public void getTokuteiShinryohiData() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanTokuteiShinryohi> returnList = sut.getTokuteiShinryohiData(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getTokuteyiShinnryouhiTokubeturyoyohi() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanTokuteiShinryoTokubetsuRyoyo> returnList = sut.getTokuteyiShinnryouhiTokubeturyoyohi(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getTokuteyiNyushosyaKaigoserviceHiyo() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanTokuteiNyushoshaKaigoServiceHiyo> returnList = sut.getTokuteyiNyushosyaKaigoserviceHiyo(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getKinkyujiShisetsuRyoyoData() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanKinkyuShisetsuRyoyo> returnList = sut.getKinkyujiShisetsuRyoyoData(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getKinkyujiShisetsuRyoyoData1() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanShoteiShikkanShisetsuRyoyo> returnList = sut.getKinkyujiShisetsuRyoyoData1(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getSeikyuShokujiHiyoTanjyunSearch() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanShokujiHiyo> returnList = sut.getSeikyuShokujiHiyoTanjyunSearch(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString("4444"));

        System.out.print(returnList.size());
    }

    @Test
    public void getShokujiHiyoDataList() {
        ShokanbaraiJyokyoShokai sut = new ShokanbaraiJyokyoShokai();
        List<ShokanMeisai> returnList = sut.getShokujiHiyoDataList(
                new HihokenshaNo("0000030"),
                new FlexibleYearMonth(new RString("201406")),
                new RString("1234"),
                new JigyoshaNo(new RString("00001")),
                new RString("2222"),
                new RString("3333"),
                new RString(""));

        System.out.print(returnList.size());
    }

}
