package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jun 12 19:19:38 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShiteiServiceShurui_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShiteiServiceShurui_Row extends DataRow {

    private TextBoxNum Ｎｏ;
    private RString サービス種類;

    public dgShiteiServiceShurui_Row() {
        super();
        this.Ｎｏ = new TextBoxNum();
        this.サービス種類 = RString.EMPTY;
    }

    public dgShiteiServiceShurui_Row(TextBoxNum Ｎｏ, RString サービス種類) {
        super();
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.setOriginalData("サービス種類", サービス種類);
        this.Ｎｏ = Ｎｏ;
        this.サービス種類 = サービス種類;
    }

    public TextBoxNum getＮｏ() {
        return Ｎｏ;
    }

    public RString getサービス種類() {
        return サービス種類;
    }

    public void setＮｏ(TextBoxNum Ｎｏ) {
        this.setOriginalData("Ｎｏ", Ｎｏ);
        this.Ｎｏ = Ｎｏ;
    }

    public void setサービス種類(RString サービス種類) {
        this.setOriginalData("サービス種類", サービス種類);
        this.サービス種類 = サービス種類;
    }

}