package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0010000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri May 02 10:16:24 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJutakuKaishuhi_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJutakuKaishuhi_Row extends DataRow {

    private RString txtService;
    private RString txtChakkoYMD;
    private RString txtJigyoshaName;
    private RString txtJusho;
    private RString txtHiyo;
    private RString txtShinsaYM;

    public dgJutakuKaishuhi_Row() {
        super();
    }

    public dgJutakuKaishuhi_Row(RString txtService, RString txtChakkoYMD, RString txtJigyoshaName, RString txtJusho, RString txtHiyo, RString txtShinsaYM) {
        super();
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtChakkoYMD", txtChakkoYMD);
        this.setOriginalData("txtJigyoshaName", txtJigyoshaName);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtHiyo", txtHiyo);
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.txtService = txtService;
        this.txtChakkoYMD = txtChakkoYMD;
        this.txtJigyoshaName = txtJigyoshaName;
        this.txtJusho = txtJusho;
        this.txtHiyo = txtHiyo;
        this.txtShinsaYM = txtShinsaYM;
    }

    public RString getTxtService() {
        return txtService;
    }

    public RString getTxtChakkoYMD() {
        return txtChakkoYMD;
    }

    public RString getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    public RString getTxtJusho() {
        return txtJusho;
    }

    public RString getTxtHiyo() {
        return txtHiyo;
    }

    public RString getTxtShinsaYM() {
        return txtShinsaYM;
    }

    public void setTxtService(RString txtService) {
        this.setOriginalData("txtService", txtService);
        this.txtService = txtService;
    }

    public void setTxtChakkoYMD(RString txtChakkoYMD) {
        this.setOriginalData("txtChakkoYMD", txtChakkoYMD);
        this.txtChakkoYMD = txtChakkoYMD;
    }

    public void setTxtJigyoshaName(RString txtJigyoshaName) {
        this.setOriginalData("txtJigyoshaName", txtJigyoshaName);
        this.txtJigyoshaName = txtJigyoshaName;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setTxtHiyo(RString txtHiyo) {
        this.setOriginalData("txtHiyo", txtHiyo);
        this.txtHiyo = txtHiyo;
    }

    public void setTxtShinsaYM(RString txtShinsaYM) {
        this.setOriginalData("txtShinsaYM", txtShinsaYM);
        this.txtShinsaYM = txtShinsaYM;
    }

}