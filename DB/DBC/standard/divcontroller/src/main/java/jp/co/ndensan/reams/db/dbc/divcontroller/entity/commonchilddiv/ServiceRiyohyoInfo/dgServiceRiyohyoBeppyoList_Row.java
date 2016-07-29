package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jul 29 10:18:28 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgServiceRiyohyoBeppyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceRiyohyoBeppyoList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private RString jigyosha;
    private RString service;
    private RString meisaiGokeiKubun;
    private TextBoxNum tani;
    private TextBoxNum waribikigoRitsu;
    private TextBoxNum waribikigoTani;
    private TextBoxNum kaisu;
    private TextBoxNum serviceTani;
    private TextBoxNum shuruiGendoChokaTani;
    private TextBoxNum shuruiGendonaiTani;
    private TextBoxNum kubunGendoChokaTani;
    private TextBoxNum kubunGendonaiTani;
    private TextBoxNum tanisuTanka;
    private TextBoxNum hiyoSogaku;
    private TextBoxNum kyufuritsu;
    private TextBoxNum hokenKyufugaku;
    private TextBoxNum riyoshaFutangakuHoken;
    private TextBoxNum riyoshaFutangakuZengaku;
    private RString hdnJigyoshaCode;
    private RString hdnServiceShuruiCode;
    private RString hdnGendogakuTaishogaiFlag;
    private RString hdnServiceKomokuCode;
    private RString hdnMeisaiNo;

    public dgServiceRiyohyoBeppyoList_Row() {
        super();
        this.jigyosha = RString.EMPTY;
        this.service = RString.EMPTY;
        this.meisaiGokeiKubun = RString.EMPTY;
        this.tani = new TextBoxNum();
        this.waribikigoRitsu = new TextBoxNum();
        this.waribikigoTani = new TextBoxNum();
        this.kaisu = new TextBoxNum();
        this.serviceTani = new TextBoxNum();
        this.shuruiGendoChokaTani = new TextBoxNum();
        this.shuruiGendonaiTani = new TextBoxNum();
        this.kubunGendoChokaTani = new TextBoxNum();
        this.kubunGendonaiTani = new TextBoxNum();
        this.tanisuTanka = new TextBoxNum();
        this.hiyoSogaku = new TextBoxNum();
        this.kyufuritsu = new TextBoxNum();
        this.hokenKyufugaku = new TextBoxNum();
        this.riyoshaFutangakuHoken = new TextBoxNum();
        this.riyoshaFutangakuZengaku = new TextBoxNum();
        this.hdnJigyoshaCode = RString.EMPTY;
        this.hdnServiceShuruiCode = RString.EMPTY;
        this.hdnGendogakuTaishogaiFlag = RString.EMPTY;
        this.hdnServiceKomokuCode = RString.EMPTY;
        this.hdnMeisaiNo = RString.EMPTY;
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("service", service);
        this.setOriginalData("meisaiGokeiKubun", meisaiGokeiKubun);
        this.setOriginalData("tani", tani);
        this.setOriginalData("waribikigoRitsu", waribikigoRitsu);
        this.setOriginalData("waribikigoTani", waribikigoTani);
        this.setOriginalData("kaisu", kaisu);
        this.setOriginalData("serviceTani", serviceTani);
        this.setOriginalData("shuruiGendoChokaTani", shuruiGendoChokaTani);
        this.setOriginalData("shuruiGendonaiTani", shuruiGendonaiTani);
        this.setOriginalData("kubunGendoChokaTani", kubunGendoChokaTani);
        this.setOriginalData("kubunGendonaiTani", kubunGendonaiTani);
        this.setOriginalData("tanisuTanka", tanisuTanka);
        this.setOriginalData("hiyoSogaku", hiyoSogaku);
        this.setOriginalData("kyufuritsu", kyufuritsu);
        this.setOriginalData("hokenKyufugaku", hokenKyufugaku);
        this.setOriginalData("riyoshaFutangakuHoken", riyoshaFutangakuHoken);
        this.setOriginalData("riyoshaFutangakuZengaku", riyoshaFutangakuZengaku);
        this.setOriginalData("hdnJigyoshaCode", hdnJigyoshaCode);
        this.setOriginalData("hdnServiceShuruiCode", hdnServiceShuruiCode);
        this.setOriginalData("hdnGendogakuTaishogaiFlag", hdnGendogakuTaishogaiFlag);
        this.setOriginalData("hdnServiceKomokuCode", hdnServiceKomokuCode);
        this.setOriginalData("hdnMeisaiNo", hdnMeisaiNo);
    }

    public dgServiceRiyohyoBeppyoList_Row(RString jigyosha, RString service, RString meisaiGokeiKubun, TextBoxNum tani, TextBoxNum waribikigoRitsu, TextBoxNum waribikigoTani, TextBoxNum kaisu, TextBoxNum serviceTani, TextBoxNum shuruiGendoChokaTani, TextBoxNum shuruiGendonaiTani, TextBoxNum kubunGendoChokaTani, TextBoxNum kubunGendonaiTani, TextBoxNum tanisuTanka, TextBoxNum hiyoSogaku, TextBoxNum kyufuritsu, TextBoxNum hokenKyufugaku, TextBoxNum riyoshaFutangakuHoken, TextBoxNum riyoshaFutangakuZengaku, RString hdnJigyoshaCode, RString hdnServiceShuruiCode, RString hdnGendogakuTaishogaiFlag, RString hdnServiceKomokuCode, RString hdnMeisaiNo) {
        super();
        this.setOriginalData("jigyosha", jigyosha);
        this.setOriginalData("service", service);
        this.setOriginalData("meisaiGokeiKubun", meisaiGokeiKubun);
        this.setOriginalData("tani", tani);
        this.setOriginalData("waribikigoRitsu", waribikigoRitsu);
        this.setOriginalData("waribikigoTani", waribikigoTani);
        this.setOriginalData("kaisu", kaisu);
        this.setOriginalData("serviceTani", serviceTani);
        this.setOriginalData("shuruiGendoChokaTani", shuruiGendoChokaTani);
        this.setOriginalData("shuruiGendonaiTani", shuruiGendonaiTani);
        this.setOriginalData("kubunGendoChokaTani", kubunGendoChokaTani);
        this.setOriginalData("kubunGendonaiTani", kubunGendonaiTani);
        this.setOriginalData("tanisuTanka", tanisuTanka);
        this.setOriginalData("hiyoSogaku", hiyoSogaku);
        this.setOriginalData("kyufuritsu", kyufuritsu);
        this.setOriginalData("hokenKyufugaku", hokenKyufugaku);
        this.setOriginalData("riyoshaFutangakuHoken", riyoshaFutangakuHoken);
        this.setOriginalData("riyoshaFutangakuZengaku", riyoshaFutangakuZengaku);
        this.setOriginalData("hdnJigyoshaCode", hdnJigyoshaCode);
        this.setOriginalData("hdnServiceShuruiCode", hdnServiceShuruiCode);
        this.setOriginalData("hdnGendogakuTaishogaiFlag", hdnGendogakuTaishogaiFlag);
        this.setOriginalData("hdnServiceKomokuCode", hdnServiceKomokuCode);
        this.setOriginalData("hdnMeisaiNo", hdnMeisaiNo);
        this.jigyosha = jigyosha;
        this.service = service;
        this.meisaiGokeiKubun = meisaiGokeiKubun;
        this.tani = tani;
        this.waribikigoRitsu = waribikigoRitsu;
        this.waribikigoTani = waribikigoTani;
        this.kaisu = kaisu;
        this.serviceTani = serviceTani;
        this.shuruiGendoChokaTani = shuruiGendoChokaTani;
        this.shuruiGendonaiTani = shuruiGendonaiTani;
        this.kubunGendoChokaTani = kubunGendoChokaTani;
        this.kubunGendonaiTani = kubunGendonaiTani;
        this.tanisuTanka = tanisuTanka;
        this.hiyoSogaku = hiyoSogaku;
        this.kyufuritsu = kyufuritsu;
        this.hokenKyufugaku = hokenKyufugaku;
        this.riyoshaFutangakuHoken = riyoshaFutangakuHoken;
        this.riyoshaFutangakuZengaku = riyoshaFutangakuZengaku;
        this.hdnJigyoshaCode = hdnJigyoshaCode;
        this.hdnServiceShuruiCode = hdnServiceShuruiCode;
        this.hdnGendogakuTaishogaiFlag = hdnGendogakuTaishogaiFlag;
        this.hdnServiceKomokuCode = hdnServiceKomokuCode;
        this.hdnMeisaiNo = hdnMeisaiNo;
    }

    public RString getJigyosha() {
        return jigyosha;
    }

    public RString getService() {
        return service;
    }

    public RString getMeisaiGokeiKubun() {
        return meisaiGokeiKubun;
    }

    public TextBoxNum getTani() {
        return tani;
    }

    public TextBoxNum getWaribikigoRitsu() {
        return waribikigoRitsu;
    }

    public TextBoxNum getWaribikigoTani() {
        return waribikigoTani;
    }

    public TextBoxNum getKaisu() {
        return kaisu;
    }

    public TextBoxNum getServiceTani() {
        return serviceTani;
    }

    public TextBoxNum getShuruiGendoChokaTani() {
        return shuruiGendoChokaTani;
    }

    public TextBoxNum getShuruiGendonaiTani() {
        return shuruiGendonaiTani;
    }

    public TextBoxNum getKubunGendoChokaTani() {
        return kubunGendoChokaTani;
    }

    public TextBoxNum getKubunGendonaiTani() {
        return kubunGendonaiTani;
    }

    public TextBoxNum getTanisuTanka() {
        return tanisuTanka;
    }

    public TextBoxNum getHiyoSogaku() {
        return hiyoSogaku;
    }

    public TextBoxNum getKyufuritsu() {
        return kyufuritsu;
    }

    public TextBoxNum getHokenKyufugaku() {
        return hokenKyufugaku;
    }

    public TextBoxNum getRiyoshaFutangakuHoken() {
        return riyoshaFutangakuHoken;
    }

    public TextBoxNum getRiyoshaFutangakuZengaku() {
        return riyoshaFutangakuZengaku;
    }

    public RString getHdnJigyoshaCode() {
        return hdnJigyoshaCode;
    }

    public RString getHdnServiceShuruiCode() {
        return hdnServiceShuruiCode;
    }

    public RString getHdnGendogakuTaishogaiFlag() {
        return hdnGendogakuTaishogaiFlag;
    }

    public RString getHdnServiceKomokuCode() {
        return hdnServiceKomokuCode;
    }

    public RString getHdnMeisaiNo() {
        return hdnMeisaiNo;
    }

    public void setJigyosha(RString jigyosha) {
        this.setOriginalData("jigyosha", jigyosha);
        this.jigyosha = jigyosha;
    }

    public void setService(RString service) {
        this.setOriginalData("service", service);
        this.service = service;
    }

    public void setMeisaiGokeiKubun(RString meisaiGokeiKubun) {
        this.setOriginalData("meisaiGokeiKubun", meisaiGokeiKubun);
        this.meisaiGokeiKubun = meisaiGokeiKubun;
    }

    public void setTani(TextBoxNum tani) {
        this.setOriginalData("tani", tani);
        this.tani = tani;
    }

    public void setWaribikigoRitsu(TextBoxNum waribikigoRitsu) {
        this.setOriginalData("waribikigoRitsu", waribikigoRitsu);
        this.waribikigoRitsu = waribikigoRitsu;
    }

    public void setWaribikigoTani(TextBoxNum waribikigoTani) {
        this.setOriginalData("waribikigoTani", waribikigoTani);
        this.waribikigoTani = waribikigoTani;
    }

    public void setKaisu(TextBoxNum kaisu) {
        this.setOriginalData("kaisu", kaisu);
        this.kaisu = kaisu;
    }

    public void setServiceTani(TextBoxNum serviceTani) {
        this.setOriginalData("serviceTani", serviceTani);
        this.serviceTani = serviceTani;
    }

    public void setShuruiGendoChokaTani(TextBoxNum shuruiGendoChokaTani) {
        this.setOriginalData("shuruiGendoChokaTani", shuruiGendoChokaTani);
        this.shuruiGendoChokaTani = shuruiGendoChokaTani;
    }

    public void setShuruiGendonaiTani(TextBoxNum shuruiGendonaiTani) {
        this.setOriginalData("shuruiGendonaiTani", shuruiGendonaiTani);
        this.shuruiGendonaiTani = shuruiGendonaiTani;
    }

    public void setKubunGendoChokaTani(TextBoxNum kubunGendoChokaTani) {
        this.setOriginalData("kubunGendoChokaTani", kubunGendoChokaTani);
        this.kubunGendoChokaTani = kubunGendoChokaTani;
    }

    public void setKubunGendonaiTani(TextBoxNum kubunGendonaiTani) {
        this.setOriginalData("kubunGendonaiTani", kubunGendonaiTani);
        this.kubunGendonaiTani = kubunGendonaiTani;
    }

    public void setTanisuTanka(TextBoxNum tanisuTanka) {
        this.setOriginalData("tanisuTanka", tanisuTanka);
        this.tanisuTanka = tanisuTanka;
    }

    public void setHiyoSogaku(TextBoxNum hiyoSogaku) {
        this.setOriginalData("hiyoSogaku", hiyoSogaku);
        this.hiyoSogaku = hiyoSogaku;
    }

    public void setKyufuritsu(TextBoxNum kyufuritsu) {
        this.setOriginalData("kyufuritsu", kyufuritsu);
        this.kyufuritsu = kyufuritsu;
    }

    public void setHokenKyufugaku(TextBoxNum hokenKyufugaku) {
        this.setOriginalData("hokenKyufugaku", hokenKyufugaku);
        this.hokenKyufugaku = hokenKyufugaku;
    }

    public void setRiyoshaFutangakuHoken(TextBoxNum riyoshaFutangakuHoken) {
        this.setOriginalData("riyoshaFutangakuHoken", riyoshaFutangakuHoken);
        this.riyoshaFutangakuHoken = riyoshaFutangakuHoken;
    }

    public void setRiyoshaFutangakuZengaku(TextBoxNum riyoshaFutangakuZengaku) {
        this.setOriginalData("riyoshaFutangakuZengaku", riyoshaFutangakuZengaku);
        this.riyoshaFutangakuZengaku = riyoshaFutangakuZengaku;
    }

    public void setHdnJigyoshaCode(RString hdnJigyoshaCode) {
        this.setOriginalData("hdnJigyoshaCode", hdnJigyoshaCode);
        this.hdnJigyoshaCode = hdnJigyoshaCode;
    }

    public void setHdnServiceShuruiCode(RString hdnServiceShuruiCode) {
        this.setOriginalData("hdnServiceShuruiCode", hdnServiceShuruiCode);
        this.hdnServiceShuruiCode = hdnServiceShuruiCode;
    }

    public void setHdnGendogakuTaishogaiFlag(RString hdnGendogakuTaishogaiFlag) {
        this.setOriginalData("hdnGendogakuTaishogaiFlag", hdnGendogakuTaishogaiFlag);
        this.hdnGendogakuTaishogaiFlag = hdnGendogakuTaishogaiFlag;
    }

    public void setHdnServiceKomokuCode(RString hdnServiceKomokuCode) {
        this.setOriginalData("hdnServiceKomokuCode", hdnServiceKomokuCode);
        this.hdnServiceKomokuCode = hdnServiceKomokuCode;
    }

    public void setHdnMeisaiNo(RString hdnMeisaiNo) {
        this.setOriginalData("hdnMeisaiNo", hdnMeisaiNo);
        this.hdnMeisaiNo = hdnMeisaiNo;
    }

    // </editor-fold>
}
