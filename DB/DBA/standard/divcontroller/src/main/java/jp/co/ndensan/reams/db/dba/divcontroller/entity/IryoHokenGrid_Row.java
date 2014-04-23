package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 23 14:40:00 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * IryoHokenGrid_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class IryoHokenGrid_Row extends DataRow {

    private RString shubetsu;
    private RString hokenshaNo;
    private RString meisho;
    private RString kigoNo;
    private RString kanyuYMD;
    private RString dattaiYMD;

    public IryoHokenGrid_Row() {
        super();
    }

    public IryoHokenGrid_Row(RString shubetsu, RString hokenshaNo, RString meisho, RString kigoNo, RString kanyuYMD, RString dattaiYMD) {
        super();
        this.setOriginalData("shubetsu", shubetsu);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("meisho", meisho);
        this.setOriginalData("kigoNo", kigoNo);
        this.setOriginalData("kanyuYMD", kanyuYMD);
        this.setOriginalData("dattaiYMD", dattaiYMD);
        this.shubetsu = shubetsu;
        this.hokenshaNo = hokenshaNo;
        this.meisho = meisho;
        this.kigoNo = kigoNo;
        this.kanyuYMD = kanyuYMD;
        this.dattaiYMD = dattaiYMD;
    }

    public RString getShubetsu() {
        return shubetsu;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getMeisho() {
        return meisho;
    }

    public RString getKigoNo() {
        return kigoNo;
    }

    public RString getKanyuYMD() {
        return kanyuYMD;
    }

    public RString getDattaiYMD() {
        return dattaiYMD;
    }

    public void setShubetsu(RString shubetsu) {
        this.setOriginalData("shubetsu", shubetsu);
        this.shubetsu = shubetsu;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setMeisho(RString meisho) {
        this.setOriginalData("meisho", meisho);
        this.meisho = meisho;
    }

    public void setKigoNo(RString kigoNo) {
        this.setOriginalData("kigoNo", kigoNo);
        this.kigoNo = kigoNo;
    }

    public void setKanyuYMD(RString kanyuYMD) {
        this.setOriginalData("kanyuYMD", kanyuYMD);
        this.kanyuYMD = kanyuYMD;
    }

    public void setDattaiYMD(RString dattaiYMD) {
        this.setOriginalData("dattaiYMD", dattaiYMD);
        this.dattaiYMD = dattaiYMD;
    }

}