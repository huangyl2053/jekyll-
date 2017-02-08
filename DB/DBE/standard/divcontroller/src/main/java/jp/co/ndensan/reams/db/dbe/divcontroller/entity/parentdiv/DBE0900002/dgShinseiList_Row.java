package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Feb 08 10:03:54 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">

    private Button btnKojinJokyoShokai;
    private RString hokensha;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private TextBoxFlexibleDate seinengappi;
    private TextBoxNum nenrei;
    private RString seibetsu;
    private TextBoxFlexibleDate ninteiShinseibi;
    private RString shinseikubun;
    private RString nijiHanteiKekka;
    private TextBoxFlexibleDate kaisaiYoteibi;
    private TextBoxFlexibleDate kaisaibi;
    private Boolean hihokenshaDoi;
    private Boolean shujiiDoi;
    private RString shinseishoKanriNo;
    private TextBoxFlexibleDate johoteikyoSiryoOutputYMD;
    private TextBoxFlexibleDate ninteiShinsakaiKanryoYMD;

    public dgShinseiList_Row() {
        super();
        this.btnKojinJokyoShokai = new Button();
        this.hokensha = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaName = RString.EMPTY;
        this.seinengappi = new TextBoxFlexibleDate();
        this.nenrei = new TextBoxNum();
        this.seibetsu = RString.EMPTY;
        this.ninteiShinseibi = new TextBoxFlexibleDate();
        this.shinseikubun = RString.EMPTY;
        this.nijiHanteiKekka = RString.EMPTY;
        this.kaisaiYoteibi = new TextBoxFlexibleDate();
        this.kaisaibi = new TextBoxFlexibleDate();
        this.hihokenshaDoi = false;
        this.shujiiDoi = false;
        this.shinseishoKanriNo = RString.EMPTY;
        this.johoteikyoSiryoOutputYMD = new TextBoxFlexibleDate();
        this.ninteiShinsakaiKanryoYMD = new TextBoxFlexibleDate();
        this.setOriginalData("btnKojinJokyoShokai", btnKojinJokyoShokai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("seinengappi", seinengappi);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.setOriginalData("shinseikubun", shinseikubun);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("kaisaiYoteibi", kaisaiYoteibi);
        this.setOriginalData("kaisaibi", kaisaibi);
        this.setOriginalData("hihokenshaDoi", hihokenshaDoi);
        this.setOriginalData("shujiiDoi", shujiiDoi);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("johoteikyoSiryoOutputYMD", johoteikyoSiryoOutputYMD);
        this.setOriginalData("ninteiShinsakaiKanryoYMD", ninteiShinsakaiKanryoYMD);
    }

    public dgShinseiList_Row(Button btnKojinJokyoShokai, RString hokensha, RString hihokenshaNo, RString hihokenshaName, TextBoxFlexibleDate seinengappi, TextBoxNum nenrei, RString seibetsu, TextBoxFlexibleDate ninteiShinseibi, RString shinseikubun, RString nijiHanteiKekka, TextBoxFlexibleDate kaisaiYoteibi, TextBoxFlexibleDate kaisaibi, Boolean hihokenshaDoi, Boolean shujiiDoi, RString shinseishoKanriNo, TextBoxFlexibleDate johoteikyoSiryoOutputYMD, TextBoxFlexibleDate ninteiShinsakaiKanryoYMD) {
        super();
        this.setOriginalData("btnKojinJokyoShokai", btnKojinJokyoShokai);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.setOriginalData("seinengappi", seinengappi);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.setOriginalData("shinseikubun", shinseikubun);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("kaisaiYoteibi", kaisaiYoteibi);
        this.setOriginalData("kaisaibi", kaisaibi);
        this.setOriginalData("hihokenshaDoi", hihokenshaDoi);
        this.setOriginalData("shujiiDoi", shujiiDoi);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.setOriginalData("johoteikyoSiryoOutputYMD", johoteikyoSiryoOutputYMD);
        this.setOriginalData("ninteiShinsakaiKanryoYMD", ninteiShinsakaiKanryoYMD);
        this.btnKojinJokyoShokai = btnKojinJokyoShokai;
        this.hokensha = hokensha;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaName = hihokenshaName;
        this.seinengappi = seinengappi;
        this.nenrei = nenrei;
        this.seibetsu = seibetsu;
        this.ninteiShinseibi = ninteiShinseibi;
        this.shinseikubun = shinseikubun;
        this.nijiHanteiKekka = nijiHanteiKekka;
        this.kaisaiYoteibi = kaisaiYoteibi;
        this.kaisaibi = kaisaibi;
        this.hihokenshaDoi = hihokenshaDoi;
        this.shujiiDoi = shujiiDoi;
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.johoteikyoSiryoOutputYMD = johoteikyoSiryoOutputYMD;
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
    }

    public Button getBtnKojinJokyoShokai() {
        return btnKojinJokyoShokai;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaName() {
        return hihokenshaName;
    }

    public TextBoxFlexibleDate getSeinengappi() {
        return seinengappi;
    }

    public TextBoxNum getNenrei() {
        return nenrei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxFlexibleDate getNinteiShinseibi() {
        return ninteiShinseibi;
    }

    public RString getShinseikubun() {
        return shinseikubun;
    }

    public RString getNijiHanteiKekka() {
        return nijiHanteiKekka;
    }

    public TextBoxFlexibleDate getKaisaiYoteibi() {
        return kaisaiYoteibi;
    }

    public TextBoxFlexibleDate getKaisaibi() {
        return kaisaibi;
    }

    public Boolean getHihokenshaDoi() {
        return hihokenshaDoi;
    }

    public Boolean getShujiiDoi() {
        return shujiiDoi;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public TextBoxFlexibleDate getJohoteikyoSiryoOutputYMD() {
        return johoteikyoSiryoOutputYMD;
    }

    public TextBoxFlexibleDate getNinteiShinsakaiKanryoYMD() {
        return ninteiShinsakaiKanryoYMD;
    }

    public void setBtnKojinJokyoShokai(Button btnKojinJokyoShokai) {
        this.setOriginalData("btnKojinJokyoShokai", btnKojinJokyoShokai);
        this.btnKojinJokyoShokai = btnKojinJokyoShokai;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaName(RString hihokenshaName) {
        this.setOriginalData("hihokenshaName", hihokenshaName);
        this.hihokenshaName = hihokenshaName;
    }

    public void setSeinengappi(TextBoxFlexibleDate seinengappi) {
        this.setOriginalData("seinengappi", seinengappi);
        this.seinengappi = seinengappi;
    }

    public void setNenrei(TextBoxNum nenrei) {
        this.setOriginalData("nenrei", nenrei);
        this.nenrei = nenrei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setNinteiShinseibi(TextBoxFlexibleDate ninteiShinseibi) {
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.ninteiShinseibi = ninteiShinseibi;
    }

    public void setShinseikubun(RString shinseikubun) {
        this.setOriginalData("shinseikubun", shinseikubun);
        this.shinseikubun = shinseikubun;
    }

    public void setNijiHanteiKekka(RString nijiHanteiKekka) {
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.nijiHanteiKekka = nijiHanteiKekka;
    }

    public void setKaisaiYoteibi(TextBoxFlexibleDate kaisaiYoteibi) {
        this.setOriginalData("kaisaiYoteibi", kaisaiYoteibi);
        this.kaisaiYoteibi = kaisaiYoteibi;
    }

    public void setKaisaibi(TextBoxFlexibleDate kaisaibi) {
        this.setOriginalData("kaisaibi", kaisaibi);
        this.kaisaibi = kaisaibi;
    }

    public void setHihokenshaDoi(Boolean hihokenshaDoi) {
        this.setOriginalData("hihokenshaDoi", hihokenshaDoi);
        this.hihokenshaDoi = hihokenshaDoi;
    }

    public void setShujiiDoi(Boolean shujiiDoi) {
        this.setOriginalData("shujiiDoi", shujiiDoi);
        this.shujiiDoi = shujiiDoi;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public void setJohoteikyoSiryoOutputYMD(TextBoxFlexibleDate johoteikyoSiryoOutputYMD) {
        this.setOriginalData("johoteikyoSiryoOutputYMD", johoteikyoSiryoOutputYMD);
        this.johoteikyoSiryoOutputYMD = johoteikyoSiryoOutputYMD;
    }

    public void setNinteiShinsakaiKanryoYMD(TextBoxFlexibleDate ninteiShinsakaiKanryoYMD) {
        this.setOriginalData("ninteiShinsakaiKanryoYMD", ninteiShinsakaiKanryoYMD);
        this.ninteiShinsakaiKanryoYMD = ninteiShinsakaiKanryoYMD;
    }

    // </editor-fold>
}
