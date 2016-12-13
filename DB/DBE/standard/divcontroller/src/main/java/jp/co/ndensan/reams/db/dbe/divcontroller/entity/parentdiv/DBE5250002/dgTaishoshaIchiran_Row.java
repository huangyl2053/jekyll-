package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5250002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 12 15:05:35 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">

    private TextBoxCode hihokenshaNo;
    private RString hihokenshaShimei;
    private RString hihokenshaKanaShimei;
    private RString seibetsu;
    private TextBoxFlexibleDate birthYMD;
    private TextBoxFlexibleDate ninteiShinseiDay;
    private RString shinseiKubunShinseiji;
    private RString nijiHanteiKekka;
    private RString kaigoNinteiShinsakaiName;
    private TextBoxFlexibleDate kaisaiYoteiDay;
    private TextBoxFlexibleDate kaisaiDay;
    private RString dataShutsuryoku;
    private RString shinseishoKanriNo;

    public dgTaishoshaIchiran_Row() {
        super();
        this.hihokenshaNo = new TextBoxCode();
        this.hihokenshaShimei = RString.EMPTY;
        this.hihokenshaKanaShimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.birthYMD = new TextBoxFlexibleDate();
        this.ninteiShinseiDay = new TextBoxFlexibleDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.nijiHanteiKekka = RString.EMPTY;
        this.kaigoNinteiShinsakaiName = RString.EMPTY;
        this.kaisaiYoteiDay = new TextBoxFlexibleDate();
        this.kaisaiDay = new TextBoxFlexibleDate();
        this.dataShutsuryoku = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaKanaShimei", hihokenshaKanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("kaigoNinteiShinsakaiName", kaigoNinteiShinsakaiName);
        this.setOriginalData("kaisaiYoteiDay", kaisaiYoteiDay);
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
    }

    public dgTaishoshaIchiran_Row(TextBoxCode hihokenshaNo, RString hihokenshaShimei, RString hihokenshaKanaShimei, RString seibetsu, TextBoxFlexibleDate birthYMD, TextBoxFlexibleDate ninteiShinseiDay, RString shinseiKubunShinseiji, RString nijiHanteiKekka, RString kaigoNinteiShinsakaiName, TextBoxFlexibleDate kaisaiYoteiDay, TextBoxFlexibleDate kaisaiDay, RString dataShutsuryoku, RString shinseishoKanriNo) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaKanaShimei", hihokenshaKanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.setOriginalData("kaigoNinteiShinsakaiName", kaigoNinteiShinsakaiName);
        this.setOriginalData("kaisaiYoteiDay", kaisaiYoteiDay);
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaShimei = hihokenshaShimei;
        this.hihokenshaKanaShimei = hihokenshaKanaShimei;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.nijiHanteiKekka = nijiHanteiKekka;
        this.kaigoNinteiShinsakaiName = kaigoNinteiShinsakaiName;
        this.kaisaiYoteiDay = kaisaiYoteiDay;
        this.kaisaiDay = kaisaiDay;
        this.dataShutsuryoku = dataShutsuryoku;
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public TextBoxCode getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaShimei() {
        return hihokenshaShimei;
    }

    public RString getHihokenshaKanaShimei() {
        return hihokenshaKanaShimei;
    }

    public RString getSeibetsu() {
        return seibetsu;
    }

    public TextBoxFlexibleDate getBirthYMD() {
        return birthYMD;
    }

    public TextBoxFlexibleDate getNinteiShinseiDay() {
        return ninteiShinseiDay;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getNijiHanteiKekka() {
        return nijiHanteiKekka;
    }

    public RString getKaigoNinteiShinsakaiName() {
        return kaigoNinteiShinsakaiName;
    }

    public TextBoxFlexibleDate getKaisaiYoteiDay() {
        return kaisaiYoteiDay;
    }

    public TextBoxFlexibleDate getKaisaiDay() {
        return kaisaiDay;
    }

    public RString getDataShutsuryoku() {
        return dataShutsuryoku;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setHihokenshaNo(TextBoxCode hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaShimei(RString hihokenshaShimei) {
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.hihokenshaShimei = hihokenshaShimei;
    }

    public void setHihokenshaKanaShimei(RString hihokenshaKanaShimei) {
        this.setOriginalData("hihokenshaKanaShimei", hihokenshaKanaShimei);
        this.hihokenshaKanaShimei = hihokenshaKanaShimei;
    }

    public void setSeibetsu(RString seibetsu) {
        this.setOriginalData("seibetsu", seibetsu);
        this.seibetsu = seibetsu;
    }

    public void setBirthYMD(TextBoxFlexibleDate birthYMD) {
        this.setOriginalData("birthYMD", birthYMD);
        this.birthYMD = birthYMD;
    }

    public void setNinteiShinseiDay(TextBoxFlexibleDate ninteiShinseiDay) {
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.ninteiShinseiDay = ninteiShinseiDay;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setNijiHanteiKekka(RString nijiHanteiKekka) {
        this.setOriginalData("nijiHanteiKekka", nijiHanteiKekka);
        this.nijiHanteiKekka = nijiHanteiKekka;
    }

    public void setKaigoNinteiShinsakaiName(RString kaigoNinteiShinsakaiName) {
        this.setOriginalData("kaigoNinteiShinsakaiName", kaigoNinteiShinsakaiName);
        this.kaigoNinteiShinsakaiName = kaigoNinteiShinsakaiName;
    }

    public void setKaisaiYoteiDay(TextBoxFlexibleDate kaisaiYoteiDay) {
        this.setOriginalData("kaisaiYoteiDay", kaisaiYoteiDay);
        this.kaisaiYoteiDay = kaisaiYoteiDay;
    }

    public void setKaisaiDay(TextBoxFlexibleDate kaisaiDay) {
        this.setOriginalData("kaisaiDay", kaisaiDay);
        this.kaisaiDay = kaisaiDay;
    }

    public void setDataShutsuryoku(RString dataShutsuryoku) {
        this.setOriginalData("dataShutsuryoku", dataShutsuryoku);
        this.dataShutsuryoku = dataShutsuryoku;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    // </editor-fold>
}
