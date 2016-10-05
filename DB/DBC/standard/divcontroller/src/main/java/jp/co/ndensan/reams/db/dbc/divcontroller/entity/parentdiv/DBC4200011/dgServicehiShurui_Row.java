package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。 Tue May 27 09:46:48 JST 2014
 */
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgServicehiShurui_Row のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class dgServicehiShurui_Row extends DataRow {

    private DropDownList shurui;
    private TextBoxNum yokaigo1;
    private TextBoxNum yokaigo2;
    private TextBoxNum yokaigo3;
    private TextBoxNum yokaigo4;
    private TextBoxNum yokaigo5;
    private TextBoxNum kyotakushien;
    private TextBoxNum yoshien1;
    private TextBoxNum yoshien2;

    public dgServicehiShurui_Row() {
        super();
    }

    public dgServicehiShurui_Row(DropDownList shurui, TextBoxNum yokaigo1, TextBoxNum yokaigo2, TextBoxNum yokaigo3, TextBoxNum yokaigo4, TextBoxNum yokaigo5, TextBoxNum kyotakushien, TextBoxNum yoshien1, TextBoxNum yoshien2) {
        super();
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("yokaigo1", yokaigo1);
        this.setOriginalData("yokaigo2", yokaigo2);
        this.setOriginalData("yokaigo3", yokaigo3);
        this.setOriginalData("yokaigo4", yokaigo4);
        this.setOriginalData("yokaigo5", yokaigo5);
        this.setOriginalData("kyotakushien", kyotakushien);
        this.setOriginalData("yoshien1", yoshien1);
        this.setOriginalData("yoshien2", yoshien2);
        this.shurui = shurui;
        this.yokaigo1 = yokaigo1;
        this.yokaigo2 = yokaigo2;
        this.yokaigo3 = yokaigo3;
        this.yokaigo4 = yokaigo4;
        this.yokaigo5 = yokaigo5;
        this.kyotakushien = kyotakushien;
        this.yoshien1 = yoshien1;
        this.yoshien2 = yoshien2;
    }

    public DropDownList getShurui() {
        return shurui;
    }

    public TextBoxNum getYokaigo1() {
        return yokaigo1;
    }

    public TextBoxNum getYokaigo2() {
        return yokaigo2;
    }

    public TextBoxNum getYokaigo3() {
        return yokaigo3;
    }

    public TextBoxNum getYokaigo4() {
        return yokaigo4;
    }

    public TextBoxNum getYokaigo5() {
        return yokaigo5;
    }

    public TextBoxNum getKyotakushien() {
        return kyotakushien;
    }

    public TextBoxNum getYoshien1() {
        return yoshien1;
    }

    public TextBoxNum getYoshien2() {
        return yoshien2;
    }

    public void setShurui(DropDownList shurui) {
        this.setOriginalData("shurui", shurui);
        this.shurui = shurui;
    }

    public void setYokaigo1(TextBoxNum yokaigo1) {
        this.setOriginalData("yokaigo1", yokaigo1);
        this.yokaigo1 = yokaigo1;
    }

    public void setYokaigo2(TextBoxNum yokaigo2) {
        this.setOriginalData("yokaigo2", yokaigo2);
        this.yokaigo2 = yokaigo2;
    }

    public void setYokaigo3(TextBoxNum yokaigo3) {
        this.setOriginalData("yokaigo3", yokaigo3);
        this.yokaigo3 = yokaigo3;
    }

    public void setYokaigo4(TextBoxNum yokaigo4) {
        this.setOriginalData("yokaigo4", yokaigo4);
        this.yokaigo4 = yokaigo4;
    }

    public void setYokaigo5(TextBoxNum yokaigo5) {
        this.setOriginalData("yokaigo5", yokaigo5);
        this.yokaigo5 = yokaigo5;
    }

    public void setKyotakushien(TextBoxNum kyotakushien) {
        this.setOriginalData("kyotakushien", kyotakushien);
        this.kyotakushien = kyotakushien;
    }

    public void setYoshien1(TextBoxNum yoshien1) {
        this.setOriginalData("yoshien1", yoshien1);
        this.yoshien1 = yoshien1;
    }

    public void setYoshien2(TextBoxNum yoshien2) {
        this.setOriginalData("yoshien2", yoshien2);
        this.yoshien2 = yoshien2;
    }

}
