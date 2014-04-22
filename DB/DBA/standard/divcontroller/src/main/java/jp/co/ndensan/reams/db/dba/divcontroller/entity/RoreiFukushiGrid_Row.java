package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 22 14:56:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * RoreiFukushiGrid_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class RoreiFukushiGrid_Row extends DataRow {

    private RString jukyushaNo;
    private RString kaishiYMD;
    private RString haishiYMD;

    public RoreiFukushiGrid_Row() {
        super();
    }

    public RoreiFukushiGrid_Row(RString jukyushaNo, RString kaishiYMD, RString haishiYMD) {
        super();
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.setOriginalData("kaishiYMD", kaishiYMD);
        this.setOriginalData("haishiYMD", haishiYMD);
        this.jukyushaNo = jukyushaNo;
        this.kaishiYMD = kaishiYMD;
        this.haishiYMD = haishiYMD;
    }

    public RString getJukyushaNo() {
        return jukyushaNo;
    }

    public RString getKaishiYMD() {
        return kaishiYMD;
    }

    public RString getHaishiYMD() {
        return haishiYMD;
    }

    public void setJukyushaNo(RString jukyushaNo) {
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.jukyushaNo = jukyushaNo;
    }

    public void setKaishiYMD(RString kaishiYMD) {
        this.setOriginalData("kaishiYMD", kaishiYMD);
        this.kaishiYMD = kaishiYMD;
    }

    public void setHaishiYMD(RString haishiYMD) {
        this.setOriginalData("haishiYMD", haishiYMD);
        this.haishiYMD = haishiYMD;
    }

}