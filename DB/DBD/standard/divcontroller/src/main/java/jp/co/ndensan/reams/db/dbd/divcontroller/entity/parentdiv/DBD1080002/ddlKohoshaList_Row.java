package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 11 20:17:05 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * ddlKohoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class ddlKohoshaList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString shinkiKoshin;
    private RString hihoNo;
    private RString shikibetsuCode;
    private RString shimei;
    private RString kana;
    private RString nenrei;
    private RString jigyoshaNo;
    private Boolean chkSetaiKazei;
    private Button btnSetaiShotoku;
    private Button btnKyufuJisseki;
    private RString jusho;
    private RString shichosonCode;
    private Boolean chkRofuku;
    private Boolean chkSeiho;
    private Boolean chkKyusochi;
    private RString yokaigodo;
    private TextBoxFlexibleDate txtNinteiKaishiYMD;
    private TextBoxFlexibleDate txtNinteiShuryoYMD;
    private RString riyoshaFutanDankai;
    private TextBoxNum gokeiShotokuKingaku;
    private TextBoxNum nenkinShunyuGaku;
    private TextBoxNum hikazeinenkinKananGaku;
    private RString haakuShoriID;

    public ddlKohoshaList_Row() {
        super();
        this.shinkiKoshin = RString.EMPTY;
        this.hihoNo = RString.EMPTY;
        this.shikibetsuCode = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kana = RString.EMPTY;
        this.nenrei = RString.EMPTY;
        this.jigyoshaNo = RString.EMPTY;
        this.chkSetaiKazei = false;
        this.btnSetaiShotoku = new Button();
        this.btnKyufuJisseki = new Button();
        this.jusho = RString.EMPTY;
        this.shichosonCode = RString.EMPTY;
        this.chkRofuku = false;
        this.chkSeiho = false;
        this.chkKyusochi = false;
        this.yokaigodo = RString.EMPTY;
        this.txtNinteiKaishiYMD = new TextBoxFlexibleDate();
        this.txtNinteiShuryoYMD = new TextBoxFlexibleDate();
        this.riyoshaFutanDankai = RString.EMPTY;
        this.gokeiShotokuKingaku = new TextBoxNum();
        this.nenkinShunyuGaku = new TextBoxNum();
        this.hikazeinenkinKananGaku = new TextBoxNum();
        this.haakuShoriID = RString.EMPTY;
        this.setOriginalData("shinkiKoshin", shinkiKoshin);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kana", kana);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("chkSetaiKazei", chkSetaiKazei);
        this.setOriginalData("btnSetaiShotoku", btnSetaiShotoku);
        this.setOriginalData("btnKyufuJisseki", btnKyufuJisseki);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("chkRofuku", chkRofuku);
        this.setOriginalData("chkSeiho", chkSeiho);
        this.setOriginalData("chkKyusochi", chkKyusochi);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("txtNinteiKaishiYMD", txtNinteiKaishiYMD);
        this.setOriginalData("txtNinteiShuryoYMD", txtNinteiShuryoYMD);
        this.setOriginalData("riyoshaFutanDankai", riyoshaFutanDankai);
        this.setOriginalData("gokeiShotokuKingaku", gokeiShotokuKingaku);
        this.setOriginalData("nenkinShunyuGaku", nenkinShunyuGaku);
        this.setOriginalData("hikazeinenkinKananGaku", hikazeinenkinKananGaku);
        this.setOriginalData("haakuShoriID", haakuShoriID);
    }

    public ddlKohoshaList_Row(RString shinkiKoshin, RString hihoNo, RString shikibetsuCode, RString shimei, RString kana, RString nenrei, RString jigyoshaNo, Boolean chkSetaiKazei, Button btnSetaiShotoku, Button btnKyufuJisseki, RString jusho, RString shichosonCode, Boolean chkRofuku, Boolean chkSeiho, Boolean chkKyusochi, RString yokaigodo, TextBoxFlexibleDate txtNinteiKaishiYMD, TextBoxFlexibleDate txtNinteiShuryoYMD, RString riyoshaFutanDankai, TextBoxNum gokeiShotokuKingaku, TextBoxNum nenkinShunyuGaku, TextBoxNum hikazeinenkinKananGaku, RString haakuShoriID) {
        super();
        this.setOriginalData("shinkiKoshin", shinkiKoshin);
        this.setOriginalData("hihoNo", hihoNo);
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kana", kana);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("chkSetaiKazei", chkSetaiKazei);
        this.setOriginalData("btnSetaiShotoku", btnSetaiShotoku);
        this.setOriginalData("btnKyufuJisseki", btnKyufuJisseki);
        this.setOriginalData("jusho", jusho);
        this.setOriginalData("shichosonCode", shichosonCode);
        this.setOriginalData("chkRofuku", chkRofuku);
        this.setOriginalData("chkSeiho", chkSeiho);
        this.setOriginalData("chkKyusochi", chkKyusochi);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("txtNinteiKaishiYMD", txtNinteiKaishiYMD);
        this.setOriginalData("txtNinteiShuryoYMD", txtNinteiShuryoYMD);
        this.setOriginalData("riyoshaFutanDankai", riyoshaFutanDankai);
        this.setOriginalData("gokeiShotokuKingaku", gokeiShotokuKingaku);
        this.setOriginalData("nenkinShunyuGaku", nenkinShunyuGaku);
        this.setOriginalData("hikazeinenkinKananGaku", hikazeinenkinKananGaku);
        this.setOriginalData("haakuShoriID", haakuShoriID);
        this.shinkiKoshin = shinkiKoshin;
        this.hihoNo = hihoNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shimei = shimei;
        this.kana = kana;
        this.nenrei = nenrei;
        this.jigyoshaNo = jigyoshaNo;
        this.chkSetaiKazei = chkSetaiKazei;
        this.btnSetaiShotoku = btnSetaiShotoku;
        this.btnKyufuJisseki = btnKyufuJisseki;
        this.jusho = jusho;
        this.shichosonCode = shichosonCode;
        this.chkRofuku = chkRofuku;
        this.chkSeiho = chkSeiho;
        this.chkKyusochi = chkKyusochi;
        this.yokaigodo = yokaigodo;
        this.txtNinteiKaishiYMD = txtNinteiKaishiYMD;
        this.txtNinteiShuryoYMD = txtNinteiShuryoYMD;
        this.riyoshaFutanDankai = riyoshaFutanDankai;
        this.gokeiShotokuKingaku = gokeiShotokuKingaku;
        this.nenkinShunyuGaku = nenkinShunyuGaku;
        this.hikazeinenkinKananGaku = hikazeinenkinKananGaku;
        this.haakuShoriID = haakuShoriID;
    }

    public RString getShinkiKoshin() {
        return shinkiKoshin;
    }

    public RString getHihoNo() {
        return hihoNo;
    }

    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKana() {
        return kana;
    }

    public RString getNenrei() {
        return nenrei;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public Boolean getChkSetaiKazei() {
        return chkSetaiKazei;
    }

    public Button getBtnSetaiShotoku() {
        return btnSetaiShotoku;
    }

    public Button getBtnKyufuJisseki() {
        return btnKyufuJisseki;
    }

    public RString getJusho() {
        return jusho;
    }

    public RString getShichosonCode() {
        return shichosonCode;
    }

    public Boolean getChkRofuku() {
        return chkRofuku;
    }

    public Boolean getChkSeiho() {
        return chkSeiho;
    }

    public Boolean getChkKyusochi() {
        return chkKyusochi;
    }

    public RString getYokaigodo() {
        return yokaigodo;
    }

    public TextBoxFlexibleDate getTxtNinteiKaishiYMD() {
        return txtNinteiKaishiYMD;
    }

    public TextBoxFlexibleDate getTxtNinteiShuryoYMD() {
        return txtNinteiShuryoYMD;
    }

    public RString getRiyoshaFutanDankai() {
        return riyoshaFutanDankai;
    }

    public TextBoxNum getGokeiShotokuKingaku() {
        return gokeiShotokuKingaku;
    }

    public TextBoxNum getNenkinShunyuGaku() {
        return nenkinShunyuGaku;
    }

    public TextBoxNum getHikazeinenkinKananGaku() {
        return hikazeinenkinKananGaku;
    }

    public RString getHaakuShoriID() {
        return haakuShoriID;
    }

    public void setShinkiKoshin(RString shinkiKoshin) {
        this.setOriginalData("shinkiKoshin", shinkiKoshin);
        this.shinkiKoshin = shinkiKoshin;
    }

    public void setHihoNo(RString hihoNo) {
        this.setOriginalData("hihoNo", hihoNo);
        this.hihoNo = hihoNo;
    }

    public void setShikibetsuCode(RString shikibetsuCode) {
        this.setOriginalData("shikibetsuCode", shikibetsuCode);
        this.shikibetsuCode = shikibetsuCode;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKana(RString kana) {
        this.setOriginalData("kana", kana);
        this.kana = kana;
    }

    public void setNenrei(RString nenrei) {
        this.setOriginalData("nenrei", nenrei);
        this.nenrei = nenrei;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setChkSetaiKazei(Boolean chkSetaiKazei) {
        this.setOriginalData("chkSetaiKazei", chkSetaiKazei);
        this.chkSetaiKazei = chkSetaiKazei;
    }

    public void setBtnSetaiShotoku(Button btnSetaiShotoku) {
        this.setOriginalData("btnSetaiShotoku", btnSetaiShotoku);
        this.btnSetaiShotoku = btnSetaiShotoku;
    }

    public void setBtnKyufuJisseki(Button btnKyufuJisseki) {
        this.setOriginalData("btnKyufuJisseki", btnKyufuJisseki);
        this.btnKyufuJisseki = btnKyufuJisseki;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    public void setShichosonCode(RString shichosonCode) {
        this.setOriginalData("shichosonCode", shichosonCode);
        this.shichosonCode = shichosonCode;
    }

    public void setChkRofuku(Boolean chkRofuku) {
        this.setOriginalData("chkRofuku", chkRofuku);
        this.chkRofuku = chkRofuku;
    }

    public void setChkSeiho(Boolean chkSeiho) {
        this.setOriginalData("chkSeiho", chkSeiho);
        this.chkSeiho = chkSeiho;
    }

    public void setChkKyusochi(Boolean chkKyusochi) {
        this.setOriginalData("chkKyusochi", chkKyusochi);
        this.chkKyusochi = chkKyusochi;
    }

    public void setYokaigodo(RString yokaigodo) {
        this.setOriginalData("yokaigodo", yokaigodo);
        this.yokaigodo = yokaigodo;
    }

    public void setTxtNinteiKaishiYMD(TextBoxFlexibleDate txtNinteiKaishiYMD) {
        this.setOriginalData("txtNinteiKaishiYMD", txtNinteiKaishiYMD);
        this.txtNinteiKaishiYMD = txtNinteiKaishiYMD;
    }

    public void setTxtNinteiShuryoYMD(TextBoxFlexibleDate txtNinteiShuryoYMD) {
        this.setOriginalData("txtNinteiShuryoYMD", txtNinteiShuryoYMD);
        this.txtNinteiShuryoYMD = txtNinteiShuryoYMD;
    }

    public void setRiyoshaFutanDankai(RString riyoshaFutanDankai) {
        this.setOriginalData("riyoshaFutanDankai", riyoshaFutanDankai);
        this.riyoshaFutanDankai = riyoshaFutanDankai;
    }

    public void setGokeiShotokuKingaku(TextBoxNum gokeiShotokuKingaku) {
        this.setOriginalData("gokeiShotokuKingaku", gokeiShotokuKingaku);
        this.gokeiShotokuKingaku = gokeiShotokuKingaku;
    }

    public void setNenkinShunyuGaku(TextBoxNum nenkinShunyuGaku) {
        this.setOriginalData("nenkinShunyuGaku", nenkinShunyuGaku);
        this.nenkinShunyuGaku = nenkinShunyuGaku;
    }

    public void setHikazeinenkinKananGaku(TextBoxNum hikazeinenkinKananGaku) {
        this.setOriginalData("hikazeinenkinKananGaku", hikazeinenkinKananGaku);
        this.hikazeinenkinKananGaku = hikazeinenkinKananGaku;
    }

    public void setHaakuShoriID(RString haakuShoriID) {
        this.setOriginalData("haakuShoriID", haakuShoriID);
        this.haakuShoriID = haakuShoriID;
    }

    // </editor-fold>
}
