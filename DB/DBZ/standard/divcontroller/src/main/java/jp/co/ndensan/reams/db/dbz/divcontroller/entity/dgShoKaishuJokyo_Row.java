package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat May 24 14:35:42 JST 2014 
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
    private TextBoxFlexibleDate kaishuDate;
    private RString kaishuJiyu;
    private TextBoxFlexibleDate yukoKigen;

    public dgShoKaishuJokyo_Row() {
        super();
    }

    public dgShoKaishuJokyo_Row(Button btnSelect, RString kofushoShurui, TextBoxFlexibleDate kofuDate, RString kofuJiyu, TextBoxFlexibleDate kaishuDate, RString kaishuJiyu, TextBoxFlexibleDate yukoKigen) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("kofushoShurui", kofushoShurui);
        this.setOriginalData("kofuDate", kofuDate);
        this.setOriginalData("kofuJiyu", kofuJiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.btnSelect = btnSelect;
        this.kofushoShurui = kofushoShurui;
        this.kofuDate = kofuDate;
        this.kofuJiyu = kofuJiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyu = kaishuJiyu;
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

    public TextBoxFlexibleDate getKaishuDate() {
        return kaishuDate;
    }

    public RString getKaishuJiyu() {
        return kaishuJiyu;
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

    public void setKaishuDate(TextBoxFlexibleDate kaishuDate) {
        this.setOriginalData("kaishuDate", kaishuDate);
        this.kaishuDate = kaishuDate;
    }

    public void setKaishuJiyu(RString kaishuJiyu) {
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.kaishuJiyu = kaishuJiyu;
    }

    public void setYukoKigen(TextBoxFlexibleDate yukoKigen) {
        this.setOriginalData("yukoKigen", yukoKigen);
        this.yukoKigen = yukoKigen;
    }

}