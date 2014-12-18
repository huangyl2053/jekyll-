package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 14 20:15:01 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShoKaishuJokyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShoKaishuJokyo_Row extends DataRow {

    private RString state;
    private RString kofushoShurui;
    private TextBoxFlexibleDate kofuDate;
    private RString kofuJiyuKey;
    private RString kofuJiyu;
    private RString kofuRiyu;
    private TextBoxFlexibleDate kaishuDate;
    private RString kaishuJiyuKey;
    private RString kaishuJiyu;
    private RString kaishuRiyu;
    private TextBoxFlexibleDate yukoKigen;

    public dgShoKaishuJokyo_Row() {
        super();
        this.state = RString.EMPTY;
        this.kofushoShurui = RString.EMPTY;
        this.kofuDate = new TextBoxFlexibleDate();
        this.kofuJiyuKey = RString.EMPTY;
        this.kofuJiyu = RString.EMPTY;
        this.kofuRiyu = RString.EMPTY;
        this.kaishuDate = new TextBoxFlexibleDate();
        this.kaishuJiyuKey = RString.EMPTY;
        this.kaishuJiyu = RString.EMPTY;
        this.kaishuRiyu = RString.EMPTY;
        this.yukoKigen = new TextBoxFlexibleDate();
    }

    public dgShoKaishuJokyo_Row(RString state, RString kofushoShurui, TextBoxFlexibleDate kofuDate, RString kofuJiyuKey, RString kofuJiyu, RString kofuRiyu, TextBoxFlexibleDate kaishuDate, RString kaishuJiyuKey, RString kaishuJiyu, RString kaishuRiyu, TextBoxFlexibleDate yukoKigen) {
        super();
        this.setOriginalData("state", state);
        this.setOriginalData("kofushoShurui", kofushoShurui);
        this.setOriginalData("kofuDate", kofuDate);
        this.setOriginalData("kofuJiyuKey", kofuJiyuKey);
        this.setOriginalData("kofuJiyu", kofuJiyu);
        this.setOriginalData("kofuRiyu", kofuRiyu);
        this.setOriginalData("kaishuDate", kaishuDate);
        this.setOriginalData("kaishuJiyuKey", kaishuJiyuKey);
        this.setOriginalData("kaishuJiyu", kaishuJiyu);
        this.setOriginalData("kaishuRiyu", kaishuRiyu);
        this.setOriginalData("yukoKigen", yukoKigen);
        this.state = state;
        this.kofushoShurui = kofushoShurui;
        this.kofuDate = kofuDate;
        this.kofuJiyuKey = kofuJiyuKey;
        this.kofuJiyu = kofuJiyu;
        this.kofuRiyu = kofuRiyu;
        this.kaishuDate = kaishuDate;
        this.kaishuJiyuKey = kaishuJiyuKey;
        this.kaishuJiyu = kaishuJiyu;
        this.kaishuRiyu = kaishuRiyu;
        this.yukoKigen = yukoKigen;
    }

    public RString getState() {
        return state;
    }

    public RString getKofushoShurui() {
        return kofushoShurui;
    }

    public TextBoxFlexibleDate getKofuDate() {
        return kofuDate;
    }

    public RString getKofuJiyuKey() {
        return kofuJiyuKey;
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

    public RString getKaishuJiyuKey() {
        return kaishuJiyuKey;
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

    public void setState(RString state) {
        this.setOriginalData("state", state);
        this.state = state;
    }

    public void setKofushoShurui(RString kofushoShurui) {
        this.setOriginalData("kofushoShurui", kofushoShurui);
        this.kofushoShurui = kofushoShurui;
    }

    public void setKofuDate(TextBoxFlexibleDate kofuDate) {
        this.setOriginalData("kofuDate", kofuDate);
        this.kofuDate = kofuDate;
    }

    public void setKofuJiyuKey(RString kofuJiyuKey) {
        this.setOriginalData("kofuJiyuKey", kofuJiyuKey);
        this.kofuJiyuKey = kofuJiyuKey;
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

    public void setKaishuJiyuKey(RString kaishuJiyuKey) {
        this.setOriginalData("kaishuJiyuKey", kaishuJiyuKey);
        this.kaishuJiyuKey = kaishuJiyuKey;
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