package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Dec 27 14:31:24 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgNinteiTaskList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiTaskList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">

    private RString hokensha;
    private TextBoxDate ninteiShinseiDay;
    private RString hihoNumber;
    private RString hihoShimei;
    private RString shinseiKubunShinseiji;
    private RString shinseishoKanriNo;

    public dgNinteiTaskList_Row() {
        super();
        this.hokensha = RString.EMPTY;
        this.ninteiShinseiDay = new TextBoxDate();
        this.hihoNumber = RString.EMPTY;
        this.hihoShimei = RString.EMPTY;
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.shinseishoKanriNo = RString.EMPTY;
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
    }

    public dgNinteiTaskList_Row(RString hokensha, TextBoxDate ninteiShinseiDay, RString hihoNumber, RString hihoShimei, RString shinseiKubunShinseiji, RString shinseishoKanriNo) {
        super();
        this.setOriginalData("hokensha", hokensha);
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.setOriginalData("hihoNumber", hihoNumber);
        this.setOriginalData("hihoShimei", hihoShimei);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.hokensha = hokensha;
        this.ninteiShinseiDay = ninteiShinseiDay;
        this.hihoNumber = hihoNumber;
        this.hihoShimei = hihoShimei;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public TextBoxDate getNinteiShinseiDay() {
        return ninteiShinseiDay;
    }

    public RString getHihoNumber() {
        return hihoNumber;
    }

    public RString getHihoShimei() {
        return hihoShimei;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    public void setNinteiShinseiDay(TextBoxDate ninteiShinseiDay) {
        this.setOriginalData("ninteiShinseiDay", ninteiShinseiDay);
        this.ninteiShinseiDay = ninteiShinseiDay;
    }

    public void setHihoNumber(RString hihoNumber) {
        this.setOriginalData("hihoNumber", hihoNumber);
        this.hihoNumber = hihoNumber;
    }

    public void setHihoShimei(RString hihoShimei) {
        this.setOriginalData("hihoShimei", hihoShimei);
        this.hihoShimei = hihoShimei;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setShinseishoKanriNo(RString shinseishoKanriNo) {
        this.setOriginalData("shinseishoKanriNo", shinseishoKanriNo);
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    // </editor-fold>
}
