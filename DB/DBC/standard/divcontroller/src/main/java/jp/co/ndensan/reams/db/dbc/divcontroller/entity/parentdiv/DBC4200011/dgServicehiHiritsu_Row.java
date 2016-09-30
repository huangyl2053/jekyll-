package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。 Tue May 27 09:46:48 JST 2014
 */
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * dgServicehiHiritsu_Row のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class dgServicehiHiritsu_Row extends DataRow {

    private DropDownList shurui;
    private TextBoxNum hiritsu;

    public dgServicehiHiritsu_Row() {
        super();
    }

    public dgServicehiHiritsu_Row(DropDownList shurui, TextBoxNum hiritsu) {
        super();
        this.setOriginalData("shurui", shurui);
        this.setOriginalData("hiritsu", hiritsu);
        this.shurui = shurui;
        this.hiritsu = hiritsu;
    }

    public DropDownList getShurui() {
        return shurui;
    }

    public TextBoxNum getHiritsu() {
        return hiritsu;
    }

    public void setShurui(DropDownList shurui) {
        this.setOriginalData("shurui", shurui);
        this.shurui = shurui;
    }

    public void setHiritsu(TextBoxNum hiritsu) {
        this.setOriginalData("hiritsu", hiritsu);
        this.hiritsu = hiritsu;
    }

}
