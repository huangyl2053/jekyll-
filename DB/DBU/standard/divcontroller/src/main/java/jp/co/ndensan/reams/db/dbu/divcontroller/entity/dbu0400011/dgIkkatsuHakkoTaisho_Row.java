package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0400011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 24 15:57:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgIkkatsuHakkoTaisho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgIkkatsuHakkoTaisho_Row extends DataRow {

    private RString hihokenshaNo;
    private RString hihokenshaMeisho;
    private RString shutokuDate;
    private RString henkoDate;
    private RString yokaigoNinteiDate;
    private RString juminShubetsu;

    public dgIkkatsuHakkoTaisho_Row() {
        super();
        this.hihokenshaNo = RString.EMPTY;
        this.hihokenshaMeisho = RString.EMPTY;
        this.shutokuDate = RString.EMPTY;
        this.henkoDate = RString.EMPTY;
        this.yokaigoNinteiDate = RString.EMPTY;
        this.juminShubetsu = RString.EMPTY;
    }

    public dgIkkatsuHakkoTaisho_Row(RString hihokenshaNo, RString hihokenshaMeisho, RString shutokuDate, RString henkoDate, RString yokaigoNinteiDate, RString juminShubetsu) {
        super();
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaMeisho", hihokenshaMeisho);
        this.setOriginalData("shutokuDate", shutokuDate);
        this.setOriginalData("henkoDate", henkoDate);
        this.setOriginalData("yokaigoNinteiDate", yokaigoNinteiDate);
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaMeisho = hihokenshaMeisho;
        this.shutokuDate = shutokuDate;
        this.henkoDate = henkoDate;
        this.yokaigoNinteiDate = yokaigoNinteiDate;
        this.juminShubetsu = juminShubetsu;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaMeisho() {
        return hihokenshaMeisho;
    }

    public RString getShutokuDate() {
        return shutokuDate;
    }

    public RString getHenkoDate() {
        return henkoDate;
    }

    public RString getYokaigoNinteiDate() {
        return yokaigoNinteiDate;
    }

    public RString getJuminShubetsu() {
        return juminShubetsu;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaMeisho(RString hihokenshaMeisho) {
        this.setOriginalData("hihokenshaMeisho", hihokenshaMeisho);
        this.hihokenshaMeisho = hihokenshaMeisho;
    }

    public void setShutokuDate(RString shutokuDate) {
        this.setOriginalData("shutokuDate", shutokuDate);
        this.shutokuDate = shutokuDate;
    }

    public void setHenkoDate(RString henkoDate) {
        this.setOriginalData("henkoDate", henkoDate);
        this.henkoDate = henkoDate;
    }

    public void setYokaigoNinteiDate(RString yokaigoNinteiDate) {
        this.setOriginalData("yokaigoNinteiDate", yokaigoNinteiDate);
        this.yokaigoNinteiDate = yokaigoNinteiDate;
    }

    public void setJuminShubetsu(RString juminShubetsu) {
        this.setOriginalData("juminShubetsu", juminShubetsu);
        this.juminShubetsu = juminShubetsu;
    }

}