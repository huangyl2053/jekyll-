package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2200011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 22 14:14:50 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgServiceNaiyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceNaiyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString serviceCode;
    private RString serviceYukoKikanKaishiYMD;
    private RString serviceYukoKikanShuryoYMD;
    private RString serviceSeishikiName;
    private RString serviceKubun;
    private RString tanisuNissu;
    private RString shikyuGendogaku;
    private RString rirekiNo;
    private RString serviceRyakushoName;
    private RString chokkinFlag;
    private TextBoxDate serviceYukoKikanKaishiYMDSeireki;
    private TextBoxDate serviceYukoKikanShuryoYMDSeireki;

    public dgServiceNaiyo_Row() {
        super();
        this.serviceCode = RString.EMPTY;
        this.serviceYukoKikanKaishiYMD = RString.EMPTY;
        this.serviceYukoKikanShuryoYMD = RString.EMPTY;
        this.serviceSeishikiName = RString.EMPTY;
        this.serviceKubun = RString.EMPTY;
        this.tanisuNissu = RString.EMPTY;
        this.shikyuGendogaku = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.serviceRyakushoName = RString.EMPTY;
        this.chokkinFlag = RString.EMPTY;
        this.serviceYukoKikanKaishiYMDSeireki = new TextBoxDate();
        this.serviceYukoKikanShuryoYMDSeireki = new TextBoxDate();
        this.setOriginalData("serviceCode", serviceCode);
        this.setOriginalData("serviceYukoKikanKaishiYMD", serviceYukoKikanKaishiYMD);
        this.setOriginalData("serviceYukoKikanShuryoYMD", serviceYukoKikanShuryoYMD);
        this.setOriginalData("serviceSeishikiName", serviceSeishikiName);
        this.setOriginalData("serviceKubun", serviceKubun);
        this.setOriginalData("tanisuNissu", tanisuNissu);
        this.setOriginalData("shikyuGendogaku", shikyuGendogaku);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("serviceRyakushoName", serviceRyakushoName);
        this.setOriginalData("chokkinFlag", chokkinFlag);
        this.setOriginalData("serviceYukoKikanKaishiYMDSeireki", serviceYukoKikanKaishiYMDSeireki);
        this.setOriginalData("serviceYukoKikanShuryoYMDSeireki", serviceYukoKikanShuryoYMDSeireki);
    }

    public dgServiceNaiyo_Row(RString serviceCode, RString serviceYukoKikanKaishiYMD, RString serviceYukoKikanShuryoYMD, RString serviceSeishikiName, RString serviceKubun, RString tanisuNissu, RString shikyuGendogaku, RString rirekiNo, RString serviceRyakushoName, RString chokkinFlag, TextBoxDate serviceYukoKikanKaishiYMDSeireki, TextBoxDate serviceYukoKikanShuryoYMDSeireki) {
        super();
        this.setOriginalData("serviceCode", serviceCode);
        this.setOriginalData("serviceYukoKikanKaishiYMD", serviceYukoKikanKaishiYMD);
        this.setOriginalData("serviceYukoKikanShuryoYMD", serviceYukoKikanShuryoYMD);
        this.setOriginalData("serviceSeishikiName", serviceSeishikiName);
        this.setOriginalData("serviceKubun", serviceKubun);
        this.setOriginalData("tanisuNissu", tanisuNissu);
        this.setOriginalData("shikyuGendogaku", shikyuGendogaku);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("serviceRyakushoName", serviceRyakushoName);
        this.setOriginalData("chokkinFlag", chokkinFlag);
        this.setOriginalData("serviceYukoKikanKaishiYMDSeireki", serviceYukoKikanKaishiYMDSeireki);
        this.setOriginalData("serviceYukoKikanShuryoYMDSeireki", serviceYukoKikanShuryoYMDSeireki);
        this.serviceCode = serviceCode;
        this.serviceYukoKikanKaishiYMD = serviceYukoKikanKaishiYMD;
        this.serviceYukoKikanShuryoYMD = serviceYukoKikanShuryoYMD;
        this.serviceSeishikiName = serviceSeishikiName;
        this.serviceKubun = serviceKubun;
        this.tanisuNissu = tanisuNissu;
        this.shikyuGendogaku = shikyuGendogaku;
        this.rirekiNo = rirekiNo;
        this.serviceRyakushoName = serviceRyakushoName;
        this.chokkinFlag = chokkinFlag;
        this.serviceYukoKikanKaishiYMDSeireki = serviceYukoKikanKaishiYMDSeireki;
        this.serviceYukoKikanShuryoYMDSeireki = serviceYukoKikanShuryoYMDSeireki;
    }

    public RString getServiceCode() {
        return serviceCode;
    }

    public RString getServiceYukoKikanKaishiYMD() {
        return serviceYukoKikanKaishiYMD;
    }

    public RString getServiceYukoKikanShuryoYMD() {
        return serviceYukoKikanShuryoYMD;
    }

    public RString getServiceSeishikiName() {
        return serviceSeishikiName;
    }

    public RString getServiceKubun() {
        return serviceKubun;
    }

    public RString getTanisuNissu() {
        return tanisuNissu;
    }

    public RString getShikyuGendogaku() {
        return shikyuGendogaku;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getServiceRyakushoName() {
        return serviceRyakushoName;
    }

    public RString getChokkinFlag() {
        return chokkinFlag;
    }

    public TextBoxDate getServiceYukoKikanKaishiYMDSeireki() {
        return serviceYukoKikanKaishiYMDSeireki;
    }

    public TextBoxDate getServiceYukoKikanShuryoYMDSeireki() {
        return serviceYukoKikanShuryoYMDSeireki;
    }

    public void setServiceCode(RString serviceCode) {
        this.setOriginalData("serviceCode", serviceCode);
        this.serviceCode = serviceCode;
    }

    public void setServiceYukoKikanKaishiYMD(RString serviceYukoKikanKaishiYMD) {
        this.setOriginalData("serviceYukoKikanKaishiYMD", serviceYukoKikanKaishiYMD);
        this.serviceYukoKikanKaishiYMD = serviceYukoKikanKaishiYMD;
    }

    public void setServiceYukoKikanShuryoYMD(RString serviceYukoKikanShuryoYMD) {
        this.setOriginalData("serviceYukoKikanShuryoYMD", serviceYukoKikanShuryoYMD);
        this.serviceYukoKikanShuryoYMD = serviceYukoKikanShuryoYMD;
    }

    public void setServiceSeishikiName(RString serviceSeishikiName) {
        this.setOriginalData("serviceSeishikiName", serviceSeishikiName);
        this.serviceSeishikiName = serviceSeishikiName;
    }

    public void setServiceKubun(RString serviceKubun) {
        this.setOriginalData("serviceKubun", serviceKubun);
        this.serviceKubun = serviceKubun;
    }

    public void setTanisuNissu(RString tanisuNissu) {
        this.setOriginalData("tanisuNissu", tanisuNissu);
        this.tanisuNissu = tanisuNissu;
    }

    public void setShikyuGendogaku(RString shikyuGendogaku) {
        this.setOriginalData("shikyuGendogaku", shikyuGendogaku);
        this.shikyuGendogaku = shikyuGendogaku;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setServiceRyakushoName(RString serviceRyakushoName) {
        this.setOriginalData("serviceRyakushoName", serviceRyakushoName);
        this.serviceRyakushoName = serviceRyakushoName;
    }

    public void setChokkinFlag(RString chokkinFlag) {
        this.setOriginalData("chokkinFlag", chokkinFlag);
        this.chokkinFlag = chokkinFlag;
    }

    public void setServiceYukoKikanKaishiYMDSeireki(TextBoxDate serviceYukoKikanKaishiYMDSeireki) {
        this.setOriginalData("serviceYukoKikanKaishiYMDSeireki", serviceYukoKikanKaishiYMDSeireki);
        this.serviceYukoKikanKaishiYMDSeireki = serviceYukoKikanKaishiYMDSeireki;
    }

    public void setServiceYukoKikanShuryoYMDSeireki(TextBoxDate serviceYukoKikanShuryoYMDSeireki) {
        this.setOriginalData("serviceYukoKikanShuryoYMDSeireki", serviceYukoKikanShuryoYMDSeireki);
        this.serviceYukoKikanShuryoYMDSeireki = serviceYukoKikanShuryoYMDSeireki;
    }

    // </editor-fold>
}
