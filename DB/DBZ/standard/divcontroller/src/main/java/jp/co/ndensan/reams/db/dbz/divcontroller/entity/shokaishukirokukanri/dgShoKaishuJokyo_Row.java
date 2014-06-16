package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishukirokukanri;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 16 16:13:42 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShoKaishuJokyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShoKaishuJokyo_Row extends DataRow {

    private Button btnSelect;
    private RString kofushoShurui;
    private TextBoxFlexibleDate kofuDate;
    private RString kofuJiyu;
    private RString kofuRiyu;
    private TextBoxFlexibleDate kaishuDate;
    private RString kaishuJiyu;
    private RString kaishuRiyu;
    private TextBoxFlexibleDate yukoKigen;

    public dgShoKaishuJokyo_Row() {
        super();
        this.btnSelect = new Button();
        this.kofushoShurui = RString.EMPTY;
        this.kofuDate = new TextBoxFlexibleDate();
        this.kofuJiyu = RString.EMPTY;
        this.kofuRiyu = RString.EMPTY;
        this.kaishuDate = new TextBoxFlexibleDate();
        this.kaishuJiyu = RString.EMPTY;
        this.kaishuRiyu = RString.EMPTY;
        this.yukoKigen = new TextBoxFlexibleDate();
    }

    public dgShoKaishuJokyo_Row(Button btnSelect, RString kofushoShurui, TextBoxFlexibleDate kofuDate, RString kofuJiyu, RString kofuRiyu, TextBoxFlexibleDate kaishuDate, RString kaishuJiyu, RString kaishuRiyu, TextBoxFlexibleDate yukoKigen) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("kofushoShurui", kofushoShurui);
        this.setOriginalData("kofuDate", kofuDate);
        this.setOriginalData("kofuJiyu", kofuJiyu);
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.btnSelect = btnSelect;
        this.kofushoShurui = kofushoShurui;
        this.kofuDate = kofuDate;
        this.kofuJiyu = kofuJiyu;
        this.kofuRiyu = kofuRiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyu = kaishuJiyu;
        this.kaishuRiyu = kaishuRiyu;
        this.yukoKigen = yukoKigen;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public RString getKofushoShurui() {
        return kofushoShurui;
    }

    public TextBoxFlexibleDate getKofuDate() {
        return kofuDate;
    }

    public RString getKofuJiyu() {
        return kofuJiyu;
    }

    public RString getKofuRiyu() {
        return kofuRiyu;
    }

    public TextBoxFlexibleDate getKaishuDate() {
        return kaishuDate;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
    }

    public RString getKaishuRiyu() {
        return kaishuRiyu;
    }

    public TextBoxFlexibleDate getYukoKigen() {
        return yukoKigen;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setKofushoShurui(RString kofushoShurui) {
        this.setOriginalData("kofushoShurui", kofushoShurui);
        this.kofushoShurui = kofushoShurui;
    }

    public void setKofuDate(TextBoxFlexibleDate kofuDate) {
        this.setOriginalData("kofuDate", kofuDate);
        this.kofuDate = kofuDate;
    }

    public void setKofuJiyu(RString kofuJiyu) {
        this.setOriginalData("kofuJiyu", kofuJiyu);
        this.kofuJiyu = kofuJiyu;
    }

    public void setKofuRiyu(RString kofuRiyu) {
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.kofuRiyu = kofuRiyu;
    }

    public void setKaishuDate(TextBoxFlexibleDate kaishuDate) {
        this.setOriginalData("kaishuDate", kaishuDate);
        this.kaishuDate = kaishuDate;
    }

    public void setKaishuJiyu(RString kaishuJiyu) {
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.kaishuJiyu = kaishuJiyu;
    }

    public void setKaishuRiyu(RString kaishuRiyu) {
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.kaishuRiyu = kaishuRiyu;
    }

    public void setYukoKigen(TextBoxFlexibleDate yukoKigen) {
        this.setOriginalData("yukoKigen", yukoKigen);
        this.yukoKigen = yukoKigen;
    }

}