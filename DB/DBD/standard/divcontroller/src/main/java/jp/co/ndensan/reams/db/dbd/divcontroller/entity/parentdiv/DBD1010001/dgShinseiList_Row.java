package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 08 09:39:13 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgShinseiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinseiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString jotai;
    private TextBoxFlexibleDate txtShinseiYMD;
    private RString shinseiRiyu;
    private RString haigushaKazeiKubun;
    private Boolean shisanHoyuu;
    private RString ketteiKubun;
    private TextBoxFlexibleDate txtKetteiYMD;
    private TextBoxFlexibleDate txtTekiyoYMD;
    private TextBoxFlexibleDate txtYukoKigenYMD;
    private Boolean isKyusochisha;
    private RString riyoshaHutanDankai;
    private RString kyoshitsuShubetsu;
    private Boolean isKyokaisho;
    private Boolean isGekihenKanwaTaisho;
    private TextBoxNum txtShokuhiHutanGendogaku;
    private TextBoxNum txtUnitGataKoshitsu;
    private TextBoxNum txtUnitGataJunKoshitsu;
    private TextBoxNum txtJuraigataKoshitsuTokuyo;
    private TextBoxNum txtJuraigataKoshitsuRoken;
    private TextBoxNum txtTashoshitsu;
    private RString shoninShinaiRiyu;

    public dgShinseiList_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.txtShinseiYMD = new TextBoxFlexibleDate();
        this.shinseiRiyu = RString.EMPTY;
        this.haigushaKazeiKubun = RString.EMPTY;
        this.shisanHoyuu = false;
        this.ketteiKubun = RString.EMPTY;
        this.txtKetteiYMD = new TextBoxFlexibleDate();
        this.txtTekiyoYMD = new TextBoxFlexibleDate();
        this.txtYukoKigenYMD = new TextBoxFlexibleDate();
        this.isKyusochisha = false;
        this.riyoshaHutanDankai = RString.EMPTY;
        this.kyoshitsuShubetsu = RString.EMPTY;
        this.isKyokaisho = false;
        this.isGekihenKanwaTaisho = false;
        this.txtShokuhiHutanGendogaku = new TextBoxNum();
        this.txtUnitGataKoshitsu = new TextBoxNum();
        this.txtUnitGataJunKoshitsu = new TextBoxNum();
        this.txtJuraigataKoshitsuTokuyo = new TextBoxNum();
        this.txtJuraigataKoshitsuRoken = new TextBoxNum();
        this.txtTashoshitsu = new TextBoxNum();
        this.shoninShinaiRiyu = RString.EMPTY;
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("haigushaKazeiKubun", haigushaKazeiKubun);
        this.setOriginalData("shisanHoyuu", shisanHoyuu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("isKyusochisha", isKyusochisha);
        this.setOriginalData("riyoshaHutanDankai", riyoshaHutanDankai);
        this.setOriginalData("kyoshitsuShubetsu", kyoshitsuShubetsu);
        this.setOriginalData("isKyokaisho", isKyokaisho);
        this.setOriginalData("isGekihenKanwaTaisho", isGekihenKanwaTaisho);
        this.setOriginalData("txtShokuhiHutanGendogaku", txtShokuhiHutanGendogaku);
        this.setOriginalData("txtUnitGataKoshitsu", txtUnitGataKoshitsu);
        this.setOriginalData("txtUnitGataJunKoshitsu", txtUnitGataJunKoshitsu);
        this.setOriginalData("txtJuraigataKoshitsuTokuyo", txtJuraigataKoshitsuTokuyo);
        this.setOriginalData("txtJuraigataKoshitsuRoken", txtJuraigataKoshitsuRoken);
        this.setOriginalData("txtTashoshitsu", txtTashoshitsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
    }

    public dgShinseiList_Row(RString jotai, TextBoxFlexibleDate txtShinseiYMD, RString shinseiRiyu, RString haigushaKazeiKubun, Boolean shisanHoyuu, RString ketteiKubun, TextBoxFlexibleDate txtKetteiYMD, TextBoxFlexibleDate txtTekiyoYMD, TextBoxFlexibleDate txtYukoKigenYMD, Boolean isKyusochisha, RString riyoshaHutanDankai, RString kyoshitsuShubetsu, Boolean isKyokaisho, Boolean isGekihenKanwaTaisho, TextBoxNum txtShokuhiHutanGendogaku, TextBoxNum txtUnitGataKoshitsu, TextBoxNum txtUnitGataJunKoshitsu, TextBoxNum txtJuraigataKoshitsuTokuyo, TextBoxNum txtJuraigataKoshitsuRoken, TextBoxNum txtTashoshitsu, RString shoninShinaiRiyu) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.setOriginalData("haigushaKazeiKubun", haigushaKazeiKubun);
        this.setOriginalData("shisanHoyuu", shisanHoyuu);
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.setOriginalData("isKyusochisha", isKyusochisha);
        this.setOriginalData("riyoshaHutanDankai", riyoshaHutanDankai);
        this.setOriginalData("kyoshitsuShubetsu", kyoshitsuShubetsu);
        this.setOriginalData("isKyokaisho", isKyokaisho);
        this.setOriginalData("isGekihenKanwaTaisho", isGekihenKanwaTaisho);
        this.setOriginalData("txtShokuhiHutanGendogaku", txtShokuhiHutanGendogaku);
        this.setOriginalData("txtUnitGataKoshitsu", txtUnitGataKoshitsu);
        this.setOriginalData("txtUnitGataJunKoshitsu", txtUnitGataJunKoshitsu);
        this.setOriginalData("txtJuraigataKoshitsuTokuyo", txtJuraigataKoshitsuTokuyo);
        this.setOriginalData("txtJuraigataKoshitsuRoken", txtJuraigataKoshitsuRoken);
        this.setOriginalData("txtTashoshitsu", txtTashoshitsu);
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.jotai = jotai;
        this.txtShinseiYMD = txtShinseiYMD;
        this.shinseiRiyu = shinseiRiyu;
        this.haigushaKazeiKubun = haigushaKazeiKubun;
        this.shisanHoyuu = shisanHoyuu;
        this.ketteiKubun = ketteiKubun;
        this.txtKetteiYMD = txtKetteiYMD;
        this.txtTekiyoYMD = txtTekiyoYMD;
        this.txtYukoKigenYMD = txtYukoKigenYMD;
        this.isKyusochisha = isKyusochisha;
        this.riyoshaHutanDankai = riyoshaHutanDankai;
        this.kyoshitsuShubetsu = kyoshitsuShubetsu;
        this.isKyokaisho = isKyokaisho;
        this.isGekihenKanwaTaisho = isGekihenKanwaTaisho;
        this.txtShokuhiHutanGendogaku = txtShokuhiHutanGendogaku;
        this.txtUnitGataKoshitsu = txtUnitGataKoshitsu;
        this.txtUnitGataJunKoshitsu = txtUnitGataJunKoshitsu;
        this.txtJuraigataKoshitsuTokuyo = txtJuraigataKoshitsuTokuyo;
        this.txtJuraigataKoshitsuRoken = txtJuraigataKoshitsuRoken;
        this.txtTashoshitsu = txtTashoshitsu;
        this.shoninShinaiRiyu = shoninShinaiRiyu;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    public RString getHaigushaKazeiKubun() {
        return haigushaKazeiKubun;
    }

    public Boolean getShisanHoyuu() {
        return shisanHoyuu;
    }

    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return txtKetteiYMD;
    }

    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return txtTekiyoYMD;
    }

    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return txtYukoKigenYMD;
    }

    public Boolean getIsKyusochisha() {
        return isKyusochisha;
    }

    public RString getRiyoshaHutanDankai() {
        return riyoshaHutanDankai;
    }

    public RString getKyoshitsuShubetsu() {
        return kyoshitsuShubetsu;
    }

    public Boolean getIsKyokaisho() {
        return isKyokaisho;
    }

    public Boolean getIsGekihenKanwaTaisho() {
        return isGekihenKanwaTaisho;
    }

    public TextBoxNum getTxtShokuhiHutanGendogaku() {
        return txtShokuhiHutanGendogaku;
    }

    public TextBoxNum getTxtUnitGataKoshitsu() {
        return txtUnitGataKoshitsu;
    }

    public TextBoxNum getTxtUnitGataJunKoshitsu() {
        return txtUnitGataJunKoshitsu;
    }

    public TextBoxNum getTxtJuraigataKoshitsuTokuyo() {
        return txtJuraigataKoshitsuTokuyo;
    }

    public TextBoxNum getTxtJuraigataKoshitsuRoken() {
        return txtJuraigataKoshitsuRoken;
    }

    public TextBoxNum getTxtTashoshitsu() {
        return txtTashoshitsu;
    }

    public RString getShoninShinaiRiyu() {
        return shoninShinaiRiyu;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.setOriginalData("txtShinseiYMD", txtShinseiYMD);
        this.txtShinseiYMD = txtShinseiYMD;
    }

    public void setShinseiRiyu(RString shinseiRiyu) {
        this.setOriginalData("shinseiRiyu", shinseiRiyu);
        this.shinseiRiyu = shinseiRiyu;
    }

    public void setHaigushaKazeiKubun(RString haigushaKazeiKubun) {
        this.setOriginalData("haigushaKazeiKubun", haigushaKazeiKubun);
        this.haigushaKazeiKubun = haigushaKazeiKubun;
    }

    public void setShisanHoyuu(Boolean shisanHoyuu) {
        this.setOriginalData("shisanHoyuu", shisanHoyuu);
        this.shisanHoyuu = shisanHoyuu;
    }

    public void setKetteiKubun(RString ketteiKubun) {
        this.setOriginalData("ketteiKubun", ketteiKubun);
        this.ketteiKubun = ketteiKubun;
    }

    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.setOriginalData("txtKetteiYMD", txtKetteiYMD);
        this.txtKetteiYMD = txtKetteiYMD;
    }

    public void setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.setOriginalData("txtTekiyoYMD", txtTekiyoYMD);
        this.txtTekiyoYMD = txtTekiyoYMD;
    }

    public void setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.setOriginalData("txtYukoKigenYMD", txtYukoKigenYMD);
        this.txtYukoKigenYMD = txtYukoKigenYMD;
    }

    public void setIsKyusochisha(Boolean isKyusochisha) {
        this.setOriginalData("isKyusochisha", isKyusochisha);
        this.isKyusochisha = isKyusochisha;
    }

    public void setRiyoshaHutanDankai(RString riyoshaHutanDankai) {
        this.setOriginalData("riyoshaHutanDankai", riyoshaHutanDankai);
        this.riyoshaHutanDankai = riyoshaHutanDankai;
    }

    public void setKyoshitsuShubetsu(RString kyoshitsuShubetsu) {
        this.setOriginalData("kyoshitsuShubetsu", kyoshitsuShubetsu);
        this.kyoshitsuShubetsu = kyoshitsuShubetsu;
    }

    public void setIsKyokaisho(Boolean isKyokaisho) {
        this.setOriginalData("isKyokaisho", isKyokaisho);
        this.isKyokaisho = isKyokaisho;
    }

    public void setIsGekihenKanwaTaisho(Boolean isGekihenKanwaTaisho) {
        this.setOriginalData("isGekihenKanwaTaisho", isGekihenKanwaTaisho);
        this.isGekihenKanwaTaisho = isGekihenKanwaTaisho;
    }

    public void setTxtShokuhiHutanGendogaku(TextBoxNum txtShokuhiHutanGendogaku) {
        this.setOriginalData("txtShokuhiHutanGendogaku", txtShokuhiHutanGendogaku);
        this.txtShokuhiHutanGendogaku = txtShokuhiHutanGendogaku;
    }

    public void setTxtUnitGataKoshitsu(TextBoxNum txtUnitGataKoshitsu) {
        this.setOriginalData("txtUnitGataKoshitsu", txtUnitGataKoshitsu);
        this.txtUnitGataKoshitsu = txtUnitGataKoshitsu;
    }

    public void setTxtUnitGataJunKoshitsu(TextBoxNum txtUnitGataJunKoshitsu) {
        this.setOriginalData("txtUnitGataJunKoshitsu", txtUnitGataJunKoshitsu);
        this.txtUnitGataJunKoshitsu = txtUnitGataJunKoshitsu;
    }

    public void setTxtJuraigataKoshitsuTokuyo(TextBoxNum txtJuraigataKoshitsuTokuyo) {
        this.setOriginalData("txtJuraigataKoshitsuTokuyo", txtJuraigataKoshitsuTokuyo);
        this.txtJuraigataKoshitsuTokuyo = txtJuraigataKoshitsuTokuyo;
    }

    public void setTxtJuraigataKoshitsuRoken(TextBoxNum txtJuraigataKoshitsuRoken) {
        this.setOriginalData("txtJuraigataKoshitsuRoken", txtJuraigataKoshitsuRoken);
        this.txtJuraigataKoshitsuRoken = txtJuraigataKoshitsuRoken;
    }

    public void setTxtTashoshitsu(TextBoxNum txtTashoshitsu) {
        this.setOriginalData("txtTashoshitsu", txtTashoshitsu);
        this.txtTashoshitsu = txtTashoshitsu;
    }

    public void setShoninShinaiRiyu(RString shoninShinaiRiyu) {
        this.setOriginalData("shoninShinaiRiyu", shoninShinaiRiyu);
        this.shoninShinaiRiyu = shoninShinaiRiyu;
    }

    // </editor-fold>
}
