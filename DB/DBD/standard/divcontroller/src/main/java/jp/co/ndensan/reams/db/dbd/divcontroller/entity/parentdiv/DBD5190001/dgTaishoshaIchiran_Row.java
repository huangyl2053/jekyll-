package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 27 15:39:50 CST 2016 
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString hihokenshaNo;
    private RString hihokenshaShimei;
    private RString hihokenshaKanaShimei;
    private RString seibetsu;
    private TextBoxDate birthYMD;
    private TextBoxDate shinseiDay;
    private RString shinseiKubunShinseiji;

    public dgTaishoshaIchiran_Row() {
        super();
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaShimei = RString.EMPTY;
        this.hihokenshaKanaShimei = RString.EMPTY;
        this.seibetsu = RString.EMPTY;
        this.birthYMD = new TextBoxDate();
        this.shinseiDay = new TextBoxDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaKanaShimei", hihokenshaKanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
    }

    public dgTaishoshaIchiran_Row(RString hihokenshaNo, RString hihokenshaShimei, RString hihokenshaKanaShimei, RString seibetsu, TextBoxDate birthYMD, TextBoxDate shinseiDay, RString shinseiKubunShinseiji) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaShimei", hihokenshaShimei);
        this.setOriginalData("hihokenshaKanaShimei", hihokenshaKanaShimei);
        this.setOriginalData("seibetsu", seibetsu);
        this.setOriginalData("birthYMD", birthYMD);
        this.setOriginalData("shinseiDay", shinseiDay);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaShimei = hihokenshaShimei;
        this.hihokenshaKanaShimei = hihokenshaKanaShimei;
        this.seibetsu = seibetsu;
        this.birthYMD = birthYMD;
        this.shinseiDay = shinseiDay;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public RString getHihokenshaNo() {
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

    public TextBoxDate getBirthYMD() {
        return birthYMD;
    }

    public TextBoxDate getShinseiDay() {
        return shinseiDay;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
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

    public void setBirthYMD(TextBoxDate birthYMD) {
        this.setOriginalData("birthYMD", birthYMD);
        this.birthYMD = birthYMD;
    }

    public void setShinseiDay(TextBoxDate shinseiDay) {
        this.setOriginalData("shinseiDay", shinseiDay);
        this.shinseiDay = shinseiDay;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    // </editor-fold>
}
