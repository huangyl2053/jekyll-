package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HikazeiNenkinShokai.HikazeiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Apr 28 10:26:43 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgHikazeiNenkinShokai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHikazeiNenkinShokai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString shimei;
    private RString seinengappiSeibetsu;
    private RString nenkinHokenshaCode;
    private TextBoxCode kisoNenkinNo;
    private TextBoxCode genKisoNenkinNo;
    private TextBoxCode nenkinCode;
    private TextBoxNum kingaku;
    private RString tsuchiNaiyo;
    private TextBoxFlexibleDate sakuseiDate;
    private RString teiseiHyoji;
    private RString kakushuKubun;
    private RString shoriKekka;
    private RString jusho;
    private RString torokuKubun;

    public dgHikazeiNenkinShokai_Row() {
        super();
        this.shimei = RString.EMPTY;
        this.seinengappiSeibetsu = RString.EMPTY;
        this.nenkinHokenshaCode = RString.EMPTY;
        this.kisoNenkinNo = new TextBoxCode();
        this.genKisoNenkinNo = new TextBoxCode();
        this.nenkinCode = new TextBoxCode();
        this.kingaku = new TextBoxNum();
        this.tsuchiNaiyo = RString.EMPTY;
        this.sakuseiDate = new TextBoxFlexibleDate();
        this.teiseiHyoji = RString.EMPTY;
        this.kakushuKubun = RString.EMPTY;
        this.shoriKekka = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.torokuKubun = RString.EMPTY;
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seinengappiSeibetsu", seinengappiSeibetsu);
        this.setOriginalData("nenkinHokenshaCode", nenkinHokenshaCode);
        this.setOriginalData("kisoNenkinNo", kisoNenkinNo);
        this.setOriginalData("genKisoNenkinNo", genKisoNenkinNo);
        this.setOriginalData("nenkinCode", nenkinCode);
        this.setOriginalData("kingaku", kingaku);
        this.setOriginalData("tsuchiNaiyo", tsuchiNaiyo);
        this.setOriginalData("sakuseiDate", sakuseiDate);
        this.setOriginalData("teiseiHyoji", teiseiHyoji);
        this.setOriginalData("kakushuKubun", kakushuKubun);
        this.setOriginalData("shoriKekka", shoriKekka);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("torokuKubun", torokuKubun);
    }

    public dgHikazeiNenkinShokai_Row(RString shimei, RString seinengappiSeibetsu, RString nenkinHokenshaCode, TextBoxCode kisoNenkinNo, TextBoxCode genKisoNenkinNo, TextBoxCode nenkinCode, TextBoxNum kingaku, RString tsuchiNaiyo, TextBoxFlexibleDate sakuseiDate, RString teiseiHyoji, RString kakushuKubun, RString shoriKekka, RString jusho, RString torokuKubun) {
        super();
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("seinengappiSeibetsu", seinengappiSeibetsu);
        this.setOriginalData("nenkinHokenshaCode", nenkinHokenshaCode);
        this.setOriginalData("kisoNenkinNo", kisoNenkinNo);
        this.setOriginalData("genKisoNenkinNo", genKisoNenkinNo);
        this.setOriginalData("nenkinCode", nenkinCode);
        this.setOriginalData("kingaku", kingaku);
        this.setOriginalData("tsuchiNaiyo", tsuchiNaiyo);
        this.setOriginalData("sakuseiDate", sakuseiDate);
        this.setOriginalData("teiseiHyoji", teiseiHyoji);
        this.setOriginalData("kakushuKubun", kakushuKubun);
        this.setOriginalData("shoriKekka", shoriKekka);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("torokuKubun", torokuKubun);
        this.shimei = shimei;
        this.seinengappiSeibetsu = seinengappiSeibetsu;
        this.nenkinHokenshaCode = nenkinHokenshaCode;
        this.kisoNenkinNo = kisoNenkinNo;
        this.genKisoNenkinNo = genKisoNenkinNo;
        this.nenkinCode = nenkinCode;
        this.kingaku = kingaku;
        this.tsuchiNaiyo = tsuchiNaiyo;
        this.sakuseiDate = sakuseiDate;
        this.teiseiHyoji = teiseiHyoji;
        this.kakushuKubun = kakushuKubun;
        this.shoriKekka = shoriKekka;
        this.jusho = jusho;
        this.torokuKubun = torokuKubun;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getSeinengappiSeibetsu() {
        return seinengappiSeibetsu;
    }

    public RString getNenkinHokenshaCode() {
        return nenkinHokenshaCode;
    }

    public TextBoxCode getKisoNenkinNo() {
        return kisoNenkinNo;
    }

    public TextBoxCode getGenKisoNenkinNo() {
        return genKisoNenkinNo;
    }

    public TextBoxCode getNenkinCode() {
        return nenkinCode;
    }

    public TextBoxNum getKingaku() {
        return kingaku;
    }

    public RString getTsuchiNaiyo() {
        return tsuchiNaiyo;
    }

    public TextBoxFlexibleDate getSakuseiDate() {
        return sakuseiDate;
    }

    public RString getTeiseiHyoji() {
        return teiseiHyoji;
    }

    public RString getKakushuKubun() {
        return kakushuKubun;
    }

    public RString getShoriKekka() {
        return shoriKekka;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getTorokuKubun() {
        return torokuKubun;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setSeinengappiSeibetsu(RString seinengappiSeibetsu) {
        this.setOriginalData("seinengappiSeibetsu", seinengappiSeibetsu);
        this.seinengappiSeibetsu = seinengappiSeibetsu;
    }

    public void setNenkinHokenshaCode(RString nenkinHokenshaCode) {
        this.setOriginalData("nenkinHokenshaCode", nenkinHokenshaCode);
        this.nenkinHokenshaCode = nenkinHokenshaCode;
    }

    public void setKisoNenkinNo(TextBoxCode kisoNenkinNo) {
        this.setOriginalData("kisoNenkinNo", kisoNenkinNo);
        this.kisoNenkinNo = kisoNenkinNo;
    }

    public void setGenKisoNenkinNo(TextBoxCode genKisoNenkinNo) {
        this.setOriginalData("genKisoNenkinNo", genKisoNenkinNo);
        this.genKisoNenkinNo = genKisoNenkinNo;
    }

    public void setNenkinCode(TextBoxCode nenkinCode) {
        this.setOriginalData("nenkinCode", nenkinCode);
        this.nenkinCode = nenkinCode;
    }

    public void setKingaku(TextBoxNum kingaku) {
        this.setOriginalData("kingaku", kingaku);
        this.kingaku = kingaku;
    }

    public void setTsuchiNaiyo(RString tsuchiNaiyo) {
        this.setOriginalData("tsuchiNaiyo", tsuchiNaiyo);
        this.tsuchiNaiyo = tsuchiNaiyo;
    }

    public void setSakuseiDate(TextBoxFlexibleDate sakuseiDate) {
        this.setOriginalData("sakuseiDate", sakuseiDate);
        this.sakuseiDate = sakuseiDate;
    }

    public void setTeiseiHyoji(RString teiseiHyoji) {
        this.setOriginalData("teiseiHyoji", teiseiHyoji);
        this.teiseiHyoji = teiseiHyoji;
    }

    public void setKakushuKubun(RString kakushuKubun) {
        this.setOriginalData("kakushuKubun", kakushuKubun);
        this.kakushuKubun = kakushuKubun;
    }

    public void setShoriKekka(RString shoriKekka) {
        this.setOriginalData("shoriKekka", shoriKekka);
        this.shoriKekka = shoriKekka;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setTorokuKubun(RString torokuKubun) {
        this.setOriginalData("torokuKubun", torokuKubun);
        this.torokuKubun = torokuKubun;
    }

    // </editor-fold>
}
