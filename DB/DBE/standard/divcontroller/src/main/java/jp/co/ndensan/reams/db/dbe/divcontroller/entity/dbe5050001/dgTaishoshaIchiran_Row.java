package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 01 15:07:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTaishoshaIchiran_Row extends DataRow {

    private TextBoxNum number;
    private RString hihokenshaNo;
    private RString shimei;
    private RString kanaShimei;
    private TextBoxFlexibleDate shinseibi;
    private RString shinseiKubunShinseiji;
    private RString shinseiKubunHorei;
    private RString jotai;
    private TextBoxFlexibleDate nijiHanteibi;
    private TextBoxFlexibleDate dataOutputDate;

    public dgTaishoshaIchiran_Row() {
        super();
        this.number = new TextBoxNum();
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shinseibi = new TextBoxFlexibleDate();
        this.shinseiKubunShinseiji = RString.EMPTY;
        this.shinseiKubunHorei = RString.EMPTY;
        this.jotai = RString.EMPTY;
        this.nijiHanteibi = new TextBoxFlexibleDate();
        this.dataOutputDate = new TextBoxFlexibleDate();
    }

    public dgTaishoshaIchiran_Row(TextBoxNum number, RString hihokenshaNo, RString shimei, RString kanaShimei, TextBoxFlexibleDate shinseibi, RString shinseiKubunShinseiji, RString shinseiKubunHorei, RString jotai, TextBoxFlexibleDate nijiHanteibi, TextBoxFlexibleDate dataOutputDate) {
        super();
        this.setOriginalData("number", number);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("nijiHanteibi", nijiHanteibi);
        this.setOriginalData("dataOutputDate", dataOutputDate);
        this.number = number;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shinseibi = shinseibi;
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
        this.shinseiKubunHorei = shinseiKubunHorei;
        this.jotai = jotai;
        this.nijiHanteibi = nijiHanteibi;
        this.dataOutputDate = dataOutputDate;
    }

    public TextBoxNum getNumber() {
        return number;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public TextBoxFlexibleDate getShinseibi() {
        return shinseibi;
    }

    public RString getShinseiKubunShinseiji() {
        return shinseiKubunShinseiji;
    }

    public RString getShinseiKubunHorei() {
        return shinseiKubunHorei;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxFlexibleDate getNijiHanteibi() {
        return nijiHanteibi;
    }

    public TextBoxFlexibleDate getDataOutputDate() {
        return dataOutputDate;
    }

    public void setNumber(TextBoxNum number) {
        this.setOriginalData("number", number);
        this.number = number;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShinseibi(TextBoxFlexibleDate shinseibi) {
        this.setOriginalData("shinseibi", shinseibi);
        this.shinseibi = shinseibi;
    }

    public void setShinseiKubunShinseiji(RString shinseiKubunShinseiji) {
        this.setOriginalData("shinseiKubunShinseiji", shinseiKubunShinseiji);
        this.shinseiKubunShinseiji = shinseiKubunShinseiji;
    }

    public void setShinseiKubunHorei(RString shinseiKubunHorei) {
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.shinseiKubunHorei = shinseiKubunHorei;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setNijiHanteibi(TextBoxFlexibleDate nijiHanteibi) {
        this.setOriginalData("nijiHanteibi", nijiHanteibi);
        this.nijiHanteibi = nijiHanteibi;
    }

    public void setDataOutputDate(TextBoxFlexibleDate dataOutputDate) {
        this.setOriginalData("dataOutputDate", dataOutputDate);
        this.dataOutputDate = dataOutputDate;
    }

}