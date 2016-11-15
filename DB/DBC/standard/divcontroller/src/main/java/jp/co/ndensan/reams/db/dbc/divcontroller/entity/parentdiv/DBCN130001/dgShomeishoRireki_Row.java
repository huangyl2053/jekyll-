package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Nov 14 22:19:26 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShomeishoRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShomeishoRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    private Button shokai;
    private Button shusei;
    private Button sakujo;
    private RString taishoNendo;
    private RString shokisaiHokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private RString tennyumaeShokisaiHokensha;
    private RString rirekiNo;
    private RString hihokenshaKikan;
    private TextBoxFlexibleDate uketsukeDate;
    private RString taishoNendoKouSin;

    public dgShomeishoRireki_Row() {
        super();
        this.shokai = new Button();
        this.shusei = new Button();
        this.sakujo = new Button();
        this.taishoNendo = RString.EMPTY;
        this.shokisaiHokenshaNo = RString.EMPTY;
        this.shikyuShinseishoSeiriNo = RString.EMPTY;
        this.tennyumaeShokisaiHokensha = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.hihokenshaKikan = RString.EMPTY;
        this.uketsukeDate = new TextBoxFlexibleDate();
        this.taishoNendoKouSin = RString.EMPTY;
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("shusei", shusei);
        this.setOriginalData("sakujo", sakujo);
        this.setOriginalData("taishoNendo", taishoNendo);
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.setOriginalData("shikyuShinseishoSeiriNo", shikyuShinseishoSeiriNo);
        this.setOriginalData("tennyumaeShokisaiHokensha", tennyumaeShokisaiHokensha);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("hihokenshaKikan", hihokenshaKikan);
        this.setOriginalData("uketsukeDate", uketsukeDate);
        this.setOriginalData("taishoNendoKouSin", taishoNendoKouSin);
    }

    public dgShomeishoRireki_Row(Button shokai, Button shusei, Button sakujo, RString taishoNendo, RString shokisaiHokenshaNo, RString shikyuShinseishoSeiriNo, RString tennyumaeShokisaiHokensha, RString rirekiNo, RString hihokenshaKikan, TextBoxFlexibleDate uketsukeDate, RString taishoNendoKouSin) {
        super();
        this.setOriginalData("shokai", shokai);
        this.setOriginalData("shusei", shusei);
        this.setOriginalData("sakujo", sakujo);
        this.setOriginalData("taishoNendo", taishoNendo);
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.setOriginalData("shikyuShinseishoSeiriNo", shikyuShinseishoSeiriNo);
        this.setOriginalData("tennyumaeShokisaiHokensha", tennyumaeShokisaiHokensha);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("hihokenshaKikan", hihokenshaKikan);
        this.setOriginalData("uketsukeDate", uketsukeDate);
        this.setOriginalData("taishoNendoKouSin", taishoNendoKouSin);
        this.shokai = shokai;
        this.shusei = shusei;
        this.sakujo = sakujo;
        this.taishoNendo = taishoNendo;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
        this.tennyumaeShokisaiHokensha = tennyumaeShokisaiHokensha;
        this.rirekiNo = rirekiNo;
        this.hihokenshaKikan = hihokenshaKikan;
        this.uketsukeDate = uketsukeDate;
        this.taishoNendoKouSin = taishoNendoKouSin;
    }

    public Button getShokai() {
        return shokai;
    }

    public Button getShusei() {
        return shusei;
    }

    public Button getSakujo() {
        return sakujo;
    }

    public RString getTaishoNendo() {
        return taishoNendo;
    }

    public RString getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    public RString getShikyuShinseishoSeiriNo() {
        return shikyuShinseishoSeiriNo;
    }

    public RString getTennyumaeShokisaiHokensha() {
        return tennyumaeShokisaiHokensha;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getHihokenshaKikan() {
        return hihokenshaKikan;
    }

    public TextBoxFlexibleDate getUketsukeDate() {
        return uketsukeDate;
    }

    public RString getTaishoNendoKouSin() {
        return taishoNendoKouSin;
    }

    public void setShokai(Button shokai) {
        this.setOriginalData("shokai", shokai);
        this.shokai = shokai;
    }

    public void setShusei(Button shusei) {
        this.setOriginalData("shusei", shusei);
        this.shusei = shusei;
    }

    public void setSakujo(Button sakujo) {
        this.setOriginalData("sakujo", sakujo);
        this.sakujo = sakujo;
    }

    public void setTaishoNendo(RString taishoNendo) {
        this.setOriginalData("taishoNendo", taishoNendo);
        this.taishoNendo = taishoNendo;
    }

    public void setShokisaiHokenshaNo(RString shokisaiHokenshaNo) {
        this.setOriginalData("shokisaiHokenshaNo", shokisaiHokenshaNo);
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    public void setShikyuShinseishoSeiriNo(RString shikyuShinseishoSeiriNo) {
        this.setOriginalData("shikyuShinseishoSeiriNo", shikyuShinseishoSeiriNo);
        this.shikyuShinseishoSeiriNo = shikyuShinseishoSeiriNo;
    }

    public void setTennyumaeShokisaiHokensha(RString tennyumaeShokisaiHokensha) {
        this.setOriginalData("tennyumaeShokisaiHokensha", tennyumaeShokisaiHokensha);
        this.tennyumaeShokisaiHokensha = tennyumaeShokisaiHokensha;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setHihokenshaKikan(RString hihokenshaKikan) {
        this.setOriginalData("hihokenshaKikan", hihokenshaKikan);
        this.hihokenshaKikan = hihokenshaKikan;
    }

    public void setUketsukeDate(TextBoxFlexibleDate uketsukeDate) {
        this.setOriginalData("uketsukeDate", uketsukeDate);
        this.uketsukeDate = uketsukeDate;
    }

    public void setTaishoNendoKouSin(RString taishoNendoKouSin) {
        this.setOriginalData("taishoNendoKouSin", taishoNendoKouSin);
        this.taishoNendoKouSin = taishoNendoKouSin;
    }

    // </editor-fold>
}
