package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Nov 23 15:10:29 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRiyoNentstsuIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRiyoNentstsuIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    private TextBoxDate riyoYM;
    private RString koshinKubun;
    private TextBoxDate koshinYMD;
    private TextBoxDate sofuYM;

    public dgRiyoNentstsuIchiran_Row() {
        super();
        this.riyoYM = new TextBoxDate();
        this.koshinKubun = RString.EMPTY;
        this.koshinYMD = new TextBoxDate();
        this.sofuYM = new TextBoxDate();
        this.setOriginalData("riyoYM", riyoYM);
        this.setOriginalData("koshinKubun", koshinKubun);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("sofuYM", sofuYM);
    }

    public dgRiyoNentstsuIchiran_Row(TextBoxDate riyoYM, RString koshinKubun, TextBoxDate koshinYMD, TextBoxDate sofuYM) {
        super();
        this.setOriginalData("riyoYM", riyoYM);
        this.setOriginalData("koshinKubun", koshinKubun);
        this.setOriginalData("koshinYMD", koshinYMD);
        this.setOriginalData("sofuYM", sofuYM);
        this.riyoYM = riyoYM;
        this.koshinKubun = koshinKubun;
        this.koshinYMD = koshinYMD;
        this.sofuYM = sofuYM;
    }

    public TextBoxDate getRiyoYM() {
        return riyoYM;
    }

    public RString getKoshinKubun() {
        return koshinKubun;
    }

    public TextBoxDate getKoshinYMD() {
        return koshinYMD;
    }

    public TextBoxDate getSofuYM() {
        return sofuYM;
    }

    public void setRiyoYM(TextBoxDate riyoYM) {
        this.setOriginalData("riyoYM", riyoYM);
        this.riyoYM = riyoYM;
    }

    public void setKoshinKubun(RString koshinKubun) {
        this.setOriginalData("koshinKubun", koshinKubun);
        this.koshinKubun = koshinKubun;
    }

    public void setKoshinYMD(TextBoxDate koshinYMD) {
        this.setOriginalData("koshinYMD", koshinYMD);
        this.koshinYMD = koshinYMD;
    }

    public void setSofuYM(TextBoxDate sofuYM) {
        this.setOriginalData("sofuYM", sofuYM);
        this.sofuYM = sofuYM;
    }

    // </editor-fold>
}
