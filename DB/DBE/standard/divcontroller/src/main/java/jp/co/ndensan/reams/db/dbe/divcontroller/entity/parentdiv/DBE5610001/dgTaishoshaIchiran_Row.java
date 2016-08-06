package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5610001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Aug 06 14:28:32 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString hokenshano;
    private RString hokensha;
    private RString hihokenshaBango;
    private RString hihokenshaShimei;
    private RString hihokenshaShimeiKana;
    private RString sex;
    private TextBoxDate birthDate;
    private TextBoxDate ninteiShinseibi;
    private RString shinseiKubunShin;
    private RString shinseiKubunHo;
    private RString nijiHanteiKekka;
    private RString ninteiYukoKikan;
    private TextBoxDate yukoKikanstart;
    private TextBoxDate yukokikanend;
    private TextBoxDate dataShutsuryoku;
    private RString shinseishokanrino;

    public dgTaishoshaIchiran_Row() {
        super();
        this.hokenshano = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.hihokenshaBango = RString.EMPTY;
        this.hihokenshaShimei = RString.EMPTY;
        this.hihokenshaShimeiKana = RString.EMPTY;
        this.sex = RString.EMPTY;
        this.birthDate = new TextBoxDate();
        this.ninteiShinseibi = new TextBoxDate();
        this.shinseiKubunShin = RString.EMPTY;
        this.shinseiKubunHo = RString.EMPTY;
        this.nijiHanteiKekka = RString.EMPTY;
        this.ninteiYukoKikan = RString.EMPTY;
        this.yukoKikanstart = new TextBoxDate();
        this.yukokikanend = new TextBoxDate();
        this.dataShutsuryoku = new TextBoxDate();
        this.shinseishokanrino = RString.EMPTY;
        this.setOriginalData("hokenshano", hokenshano);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.setOriginalData("sex", sex);
        this.setOriginalData("birthDate", birthDate);
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.setOriginalData("shinseiKubunShin", shinseiKubunShin);
        this.setOriginalData("shinseiKubunHo", shinseiKubunHo);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("ninteiYukoKikan", ninteiYukoKikan);
        this.setOriginalData("yukoKikanstart", yukoKikanstart);
        this.setOriginalData("yukokikanend", yukokikanend);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shinseishokanrino", shinseishokanrino);
    }

    public dgTaishoshaIchiran_Row(RString hokenshano, RString hokensha, RString hihokenshaBango, RString hihokenshaShimei, RString hihokenshaShimeiKana, RString sex, TextBoxDate birthDate, TextBoxDate ninteiShinseibi, RString shinseiKubunShin, RString shinseiKubunHo, RString nijiHanteiKekka, RString ninteiYukoKikan, TextBoxDate yukoKikanstart, TextBoxDate yukokikanend, TextBoxDate dataShutsuryoku, RString shinseishokanrino) {
        super();
        this.setOriginalData("hokenshano", hokenshano);
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.setOriginalData("sex", sex);
        this.setOriginalData("birthDate", birthDate);
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.setOriginalData("shinseiKubunShin", shinseiKubunShin);
        this.setOriginalData("shinseiKubunHo", shinseiKubunHo);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("ninteiYukoKikan", ninteiYukoKikan);
        this.setOriginalData("yukoKikanstart", yukoKikanstart);
        this.setOriginalData("yukokikanend", yukokikanend);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shinseishokanrino", shinseishokanrino);
        this.hokenshano = hokenshano;
        this.hokensha = hokensha;
        this.hihokenshaBango = hihokenshaBango;
        this.hihokenshaShimei = hihokenshaShimei;
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
        this.sex = sex;
        this.birthDate = birthDate;
        this.ninteiShinseibi = ninteiShinseibi;
        this.shinseiKubunShin = shinseiKubunShin;
        this.shinseiKubunHo = shinseiKubunHo;
        this.nijiHanteiKekka = nijiHanteiKekka;
        this.ninteiYukoKikan = ninteiYukoKikan;
        this.yukoKikanstart = yukoKikanstart;
        this.yukokikanend = yukokikanend;
        this.dataShutsuryoku = dataShutsuryoku;
        this.shinseishokanrino = shinseishokanrino;
    }

    public RString getHokenshano() {
        return hokenshano;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public RString getHihokenshaBango() {
        return hihokenshaBango;
    }

    public RString getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    public RString getHihokenshaShimeiKana() {
        return hihokenshaShimeiKana;
    }

    public RString getSex() {
        return sex;
    }

    public TextBoxDate getBirthDate() {
        return birthDate;
    }

    public TextBoxDate getNinteiShinseibi() {
        return ninteiShinseibi;
    }

    public RString getShinseiKubunShin() {
        return shinseiKubunShin;
    }

    public RString getShinseiKubunHo() {
        return shinseiKubunHo;
    }

    public RString getNijiHanteiKekka() {
        return nijiHanteiKekka;
    }

    public RString getNinteiYukoKikan() {
        return ninteiYukoKikan;
    }

    public TextBoxDate getYukoKikanstart() {
        return yukoKikanstart;
    }

    public TextBoxDate getYukokikanend() {
        return yukokikanend;
    }

    public TextBoxDate getDataShutsuryoku() {
        return dataShutsuryoku;
    }

    public RString getShinseishokanrino() {
        return shinseishokanrino;
    }

    public void setHokenshano(RString hokenshano) {
        this.setOriginalData("hokenshano", hokenshano);
        this.hokenshano = hokenshano;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setHihokenshaBango(RString hihokenshaBango) {
        this.setOriginalData("hihokenshaBango", hihokenshaBango);
        this.hihokenshaBango = hihokenshaBango;
    }

    public void setHihokenshaShimei(RString hihokenshaShimei) {
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.hihokenshaShimei = hihokenshaShimei;
    }

    public void setHihokenshaShimeiKana(RString hihokenshaShimeiKana) {
        this.setOriginalData("hihokenshaShimeiKana", hihokenshaShimeiKana);
        this.hihokenshaShimeiKana = hihokenshaShimeiKana;
    }

    public void setSex(RString sex) {
        this.setOriginalData("sex", sex);
        this.sex = sex;
    }

    public void setBirthDate(TextBoxDate birthDate) {
        this.setOriginalData("birthDate", birthDate);
        this.birthDate = birthDate;
    }

    public void setNinteiShinseibi(TextBoxDate ninteiShinseibi) {
        this.setOriginalData("ninteiShinseibi", ninteiShinseibi);
        this.ninteiShinseibi = ninteiShinseibi;
    }

    public void setShinseiKubunShin(RString shinseiKubunShin) {
        this.setOriginalData("shinseiKubunShin", shinseiKubunShin);
        this.shinseiKubunShin = shinseiKubunShin;
    }

    public void setShinseiKubunHo(RString shinseiKubunHo) {
        this.setOriginalData("shinseiKubunHo", shinseiKubunHo);
        this.shinseiKubunHo = shinseiKubunHo;
    }

    public void setNijiHanteiKekka(RString nijiHanteiKekka) {
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.nijiHanteiKekka = nijiHanteiKekka;
    }

    public void setNinteiYukoKikan(RString ninteiYukoKikan) {
        this.setOriginalData("ninteiYukoKikan", ninteiYukoKikan);
        this.ninteiYukoKikan = ninteiYukoKikan;
    }

    public void setYukoKikanstart(TextBoxDate yukoKikanstart) {
        this.setOriginalData("yukoKikanstart", yukoKikanstart);
        this.yukoKikanstart = yukoKikanstart;
    }

    public void setYukokikanend(TextBoxDate yukokikanend) {
        this.setOriginalData("yukokikanend", yukokikanend);
        this.yukokikanend = yukokikanend;
    }

    public void setDataShutsuryoku(TextBoxDate dataShutsuryoku) {
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.dataShutsuryoku = dataShutsuryoku;
    }

    public void setShinseishokanrino(RString shinseishokanrino) {
        this.setOriginalData("shinseishokanrino", shinseishokanrino);
        this.shinseishokanrino = shinseishokanrino;
    }

    // </editor-fold>
}
