package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 18:33:40 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgKaigohokenryo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKaigohokenryo_Row extends DataRow {

    private RString tagai;
    private TextBoxNum hokeryuo;

    public dgKaigohokenryo_Row() {
        super();
        this.tagai = RString.EMPTY;
        this.hokeryuo = new TextBoxNum();
    }

    public dgKaigohokenryo_Row(RString tagai, TextBoxNum hokeryuo) {
        super();
        this.setOriginalData("tagai", tagai);
        this.setOriginalData("hokeryuo", hokeryuo);
        this.tagai = tagai;
        this.hokeryuo = hokeryuo;
    }

    public RString getTagai() {
        return tagai;
    }

    public TextBoxNum getHokeryuo() {
        return hokeryuo;
    }

    public void setTagai(RString tagai) {
        this.setOriginalData("tagai", tagai);
        this.tagai = tagai;
    }

    public void setHokeryuo(TextBoxNum hokeryuo) {
        this.setOriginalData("hokeryuo", hokeryuo);
        this.hokeryuo = hokeryuo;
    }

}