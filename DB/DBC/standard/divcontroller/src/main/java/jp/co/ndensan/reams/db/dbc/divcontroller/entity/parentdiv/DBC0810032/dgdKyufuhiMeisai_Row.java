package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810032;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Feb 26 13:30:10 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgdKyufuhiMeisai_Row のクラスファイル
 *
 * @reamsid_L DBC-1010-040 quxiaodong
 */
public class dgdKyufuhiMeisai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString serviceCode;
    private RString tanyi;
    private RString kaisuuNissu;
    private RString serviceTanyi;
    private RString shisetuShozaiHokenshaBango;
    private RString tekiyo;
    private RString hokenshaName;
    private RString servicename;

    public dgdKyufuhiMeisai_Row() {
        super();
        this.serviceCode = RString.EMPTY;
        this.tanyi = RString.EMPTY;
        this.kaisuuNissu = RString.EMPTY;
        this.serviceTanyi = RString.EMPTY;
        this.shisetuShozaiHokenshaBango = RString.EMPTY;
        this.tekiyo = RString.EMPTY;
        this.hokenshaName = RString.EMPTY;
        this.servicename = RString.EMPTY;
        this.setOriginalData("serviceCode", serviceCode);
        this.setOriginalData("tanyi", tanyi);
        this.setOriginalData("kaisuuNissu", kaisuuNissu);
        this.setOriginalData("serviceTanyi", serviceTanyi);
        this.setOriginalData("shisetuShozaiHokenshaBango", shisetuShozaiHokenshaBango);
        this.setOriginalData("tekiyo", tekiyo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("servicename", servicename);
    }

    public dgdKyufuhiMeisai_Row(RString serviceCode, RString tanyi, RString kaisuuNissu, RString serviceTanyi, RString shisetuShozaiHokenshaBango, RString tekiyo, RString hokenshaName, RString servicename) {
        super();
        this.setOriginalData("serviceCode", serviceCode);
        this.setOriginalData("tanyi", tanyi);
        this.setOriginalData("kaisuuNissu", kaisuuNissu);
        this.setOriginalData("serviceTanyi", serviceTanyi);
        this.setOriginalData("shisetuShozaiHokenshaBango", shisetuShozaiHokenshaBango);
        this.setOriginalData("tekiyo", tekiyo);
        this.setOriginalData("hokenshaName", hokenshaName);
        this.setOriginalData("servicename", servicename);
        this.serviceCode = serviceCode;
        this.tanyi = tanyi;
        this.kaisuuNissu = kaisuuNissu;
        this.serviceTanyi = serviceTanyi;
        this.shisetuShozaiHokenshaBango = shisetuShozaiHokenshaBango;
        this.tekiyo = tekiyo;
        this.hokenshaName = hokenshaName;
        this.servicename = servicename;
    }

    public RString getServiceCode() {
        return serviceCode;
    }

    public RString getTanyi() {
        return tanyi;
    }

    public RString getKaisuuNissu() {
        return kaisuuNissu;
    }

    public RString getServiceTanyi() {
        return serviceTanyi;
    }

    public RString getShisetuShozaiHokenshaBango() {
        return shisetuShozaiHokenshaBango;
    }

    public RString getTekiyo() {
        return tekiyo;
    }

    public RString getHokenshaName() {
        return hokenshaName;
    }

    public RString getServicename() {
        return servicename;
    }

    public void setServiceCode(RString serviceCode) {
        this.setOriginalData("serviceCode", serviceCode);
        this.serviceCode = serviceCode;
    }

    public void setTanyi(RString tanyi) {
        this.setOriginalData("tanyi", tanyi);
        this.tanyi = tanyi;
    }

    public void setKaisuuNissu(RString kaisuuNissu) {
        this.setOriginalData("kaisuuNissu", kaisuuNissu);
        this.kaisuuNissu = kaisuuNissu;
    }

    public void setServiceTanyi(RString serviceTanyi) {
        this.setOriginalData("serviceTanyi", serviceTanyi);
        this.serviceTanyi = serviceTanyi;
    }

    public void setShisetuShozaiHokenshaBango(RString shisetuShozaiHokenshaBango) {
        this.setOriginalData("shisetuShozaiHokenshaBango", shisetuShozaiHokenshaBango);
        this.shisetuShozaiHokenshaBango = shisetuShozaiHokenshaBango;
    }

    public void setTekiyo(RString tekiyo) {
        this.setOriginalData("tekiyo", tekiyo);
        this.tekiyo = tekiyo;
    }

    public void setHokenshaName(RString hokenshaName) {
        this.setOriginalData("hokenshaName", hokenshaName);
        this.hokenshaName = hokenshaName;
    }

    public void setServicename(RString servicename) {
        this.setOriginalData("servicename", servicename);
        this.servicename = servicename;
    }

    // </editor-fold>
}
