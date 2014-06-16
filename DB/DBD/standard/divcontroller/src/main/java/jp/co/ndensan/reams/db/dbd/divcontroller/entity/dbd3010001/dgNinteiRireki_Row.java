package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 14:47:14 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgNinteiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNinteiRireki_Row extends DataRow {

    private Button btnDetail;
    private TextBoxFlexibleDate ninteiShinseiDate;
    private RString shinseiKubunHorei;
    private TextBoxFlexibleDate ninteiDate;
    private RString yokaigodo;
    private TextBoxFlexibleDate kaishiDate;
    private TextBoxFlexibleDate shuryoDate;
    private RString shinsakaiIken;

    public dgNinteiRireki_Row() {
        super();
        this.btnDetail = new Button();
        this.ninteiShinseiDate = new TextBoxFlexibleDate();
        this.shinseiKubunHorei = RString.EMPTY;
        this.ninteiDate = new TextBoxFlexibleDate();
        this.yokaigodo = RString.EMPTY;
        this.kaishiDate = new TextBoxFlexibleDate();
        this.shuryoDate = new TextBoxFlexibleDate();
        this.shinsakaiIken = RString.EMPTY;
    }

    public dgNinteiRireki_Row(Button btnDetail, TextBoxFlexibleDate ninteiShinseiDate, RString shinseiKubunHorei, TextBoxFlexibleDate ninteiDate, RString yokaigodo, TextBoxFlexibleDate kaishiDate, TextBoxFlexibleDate shuryoDate, RString shinsakaiIken) {
        super();
        this.setOriginalData("btnDetail", btnDetail);
        this.setOriginalData("ninteiShinseiDate", ninteiShinseiDate);
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.setOriginalData("ninteiDate", ninteiDate);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("kaishiDate", kaishiDate);
        this.setOriginalData("shuryoDate", shuryoDate);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.btnDetail = btnDetail;
        this.ninteiShinseiDate = ninteiShinseiDate;
        this.shinseiKubunHorei = shinseiKubunHorei;
        this.ninteiDate = ninteiDate;
        this.yokaigodo = yokaigodo;
        this.kaishiDate = kaishiDate;
        this.shuryoDate = shuryoDate;
        this.shinsakaiIken = shinsakaiIken;
    }

    public Button getBtnDetail() {
        return btnDetail;
    }

    public TextBoxFlexibleDate getNinteiShinseiDate() {
        return ninteiShinseiDate;
    }

    public RString getShinseiKubunHorei() {
        return shinseiKubunHorei;
    }

    public TextBoxFlexibleDate getNinteiDate() {
        return ninteiDate;
    }

    public RString getYokaigodo() {
        return yokaigodo;
    }

    public TextBoxFlexibleDate getKaishiDate() {
        return kaishiDate;
    }

    public TextBoxFlexibleDate getShuryoDate() {
        return shuryoDate;
    }

    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    public void setBtnDetail(Button btnDetail) {
        this.setOriginalData("btnDetail", btnDetail);
        this.btnDetail = btnDetail;
    }

    public void setNinteiShinseiDate(TextBoxFlexibleDate ninteiShinseiDate) {
        this.setOriginalData("ninteiShinseiDate", ninteiShinseiDate);
        this.ninteiShinseiDate = ninteiShinseiDate;
    }

    public void setShinseiKubunHorei(RString shinseiKubunHorei) {
        this.setOriginalData("shinseiKubunHorei", shinseiKubunHorei);
        this.shinseiKubunHorei = shinseiKubunHorei;
    }

    public void setNinteiDate(TextBoxFlexibleDate ninteiDate) {
        this.setOriginalData("ninteiDate", ninteiDate);
        this.ninteiDate = ninteiDate;
    }

    public void setYokaigodo(RString yokaigodo) {
        this.setOriginalData("yokaigodo", yokaigodo);
        this.yokaigodo = yokaigodo;
    }

    public void setKaishiDate(TextBoxFlexibleDate kaishiDate) {
        this.setOriginalData("kaishiDate", kaishiDate);
        this.kaishiDate = kaishiDate;
    }

    public void setShuryoDate(TextBoxFlexibleDate shuryoDate) {
        this.setOriginalData("shuryoDate", shuryoDate);
        this.shuryoDate = shuryoDate;
    }

    public void setShinsakaiIken(RString shinsakaiIken) {
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.shinsakaiIken = shinsakaiIken;
    }

}