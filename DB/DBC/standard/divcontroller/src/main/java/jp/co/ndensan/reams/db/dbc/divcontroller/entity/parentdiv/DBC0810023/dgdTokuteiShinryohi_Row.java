package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Feb 15 13:06:23 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgdTokuteiShinryohi_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgdTokuteiShinryohi_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">

    private RString shobyoName;
    private RString shikibetsuNo;
    private RString tani;
    private RString kaisu;
    private RString gokeiTani;
    private RString remban;

    public dgdTokuteiShinryohi_Row() {
        super();
        this.shobyoName = RString.EMPTY;
        this.shikibetsuNo = RString.EMPTY;
        this.tani = RString.EMPTY;
        this.kaisu = RString.EMPTY;
        this.gokeiTani = RString.EMPTY;
        this.remban = RString.EMPTY;
        this.setOriginalData("shobyoName", shobyoName);
        this.setOriginalData("shikibetsuNo", shikibetsuNo);
        this.setOriginalData("tani", tani);
        this.setOriginalData("kaisu", kaisu);
        this.setOriginalData("gokeiTani", gokeiTani);
        this.setOriginalData("remban", remban);
    }

    public dgdTokuteiShinryohi_Row(RString shobyoName, RString shikibetsuNo, RString tani, RString kaisu, RString gokeiTani, RString remban) {
        super();
        this.setOriginalData("shobyoName", shobyoName);
        this.setOriginalData("shikibetsuNo", shikibetsuNo);
        this.setOriginalData("tani", tani);
        this.setOriginalData("kaisu", kaisu);
        this.setOriginalData("gokeiTani", gokeiTani);
        this.setOriginalData("remban", remban);
        this.shobyoName = shobyoName;
        this.shikibetsuNo = shikibetsuNo;
        this.tani = tani;
        this.kaisu = kaisu;
        this.gokeiTani = gokeiTani;
        this.remban = remban;
    }

    public RString getShobyoName() {
        return shobyoName;
    }

    public RString getShikibetsuNo() {
        return shikibetsuNo;
    }

    public RString getTani() {
        return tani;
    }

    public RString getKaisu() {
        return kaisu;
    }

    public RString getGokeiTani() {
        return gokeiTani;
    }

    public RString getRemban() {
        return remban;
    }

    public void setShobyoName(RString shobyoName) {
        this.setOriginalData("shobyoName", shobyoName);
        this.shobyoName = shobyoName;
    }

    public void setShikibetsuNo(RString shikibetsuNo) {
        this.setOriginalData("shikibetsuNo", shikibetsuNo);
        this.shikibetsuNo = shikibetsuNo;
    }

    public void setTani(RString tani) {
        this.setOriginalData("tani", tani);
        this.tani = tani;
    }

    public void setKaisu(RString kaisu) {
        this.setOriginalData("kaisu", kaisu);
        this.kaisu = kaisu;
    }

    public void setGokeiTani(RString gokeiTani) {
        this.setOriginalData("gokeiTani", gokeiTani);
        this.gokeiTani = gokeiTani;
    }

    public void setRemban(RString remban) {
        this.setOriginalData("remban", remban);
        this.remban = remban;
    }

    // </editor-fold>
}
