package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba4010011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 27 16:29:18 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgRoreiFukushiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRoreiFukushiRireki_Row extends DataRow {

    private RString jukyushaNo;
    private TextBoxFlexibleDate kaishiYMD;
    private TextBoxFlexibleDate haishiYMD;

    public dgRoreiFukushiRireki_Row() {
        super();
        this.jukyushaNo = RString.EMPTY;
        this.kaishiYMD = new TextBoxFlexibleDate();
        this.haishiYMD = new TextBoxFlexibleDate();
    }

    public dgRoreiFukushiRireki_Row(RString jukyushaNo, TextBoxFlexibleDate kaishiYMD, TextBoxFlexibleDate haishiYMD) {
        super();
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.setOriginalData("kaishiYMD", kaishiYMD);
        this.setOriginalData("haishiYMD", haishiYMD);
        this.jukyushaNo = jukyushaNo;
        this.kaishiYMD = kaishiYMD;
        this.haishiYMD = haishiYMD;
    }

    public RString getJukyushaNo() {
        return jukyushaNo;
    }

    public TextBoxFlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    public TextBoxFlexibleDate getHaishiYMD() {
        return haishiYMD;
    }

    public void setJukyushaNo(RString jukyushaNo) {
        this.setOriginalData("jukyushaNo", jukyushaNo);
        this.jukyushaNo = jukyushaNo;
    }

    public void setKaishiYMD(TextBoxFlexibleDate kaishiYMD) {
        this.setOriginalData("kaishiYMD", kaishiYMD);
        this.kaishiYMD = kaishiYMD;
    }

    public void setHaishiYMD(TextBoxFlexibleDate haishiYMD) {
        this.setOriginalData("haishiYMD", haishiYMD);
        this.haishiYMD = haishiYMD;
    }

}