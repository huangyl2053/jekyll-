package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed May 25 19:11:07 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgTeishiRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTeishiRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString txtJotai;
    private TextBoxDate txtTeishiKaishiYMD;
    private TextBoxDate txtTeishiShuryoYMD;

    public dgTeishiRireki_Row() {
        super();
        this.txtJotai = RString.EMPTY;
        this.txtTeishiKaishiYMD = new TextBoxDate();
        this.txtTeishiShuryoYMD = new TextBoxDate();
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtTeishiKaishiYMD", txtTeishiKaishiYMD);
        this.setOriginalData("txtTeishiShuryoYMD", txtTeishiShuryoYMD);
    }

    public dgTeishiRireki_Row(RString txtJotai, TextBoxDate txtTeishiKaishiYMD, TextBoxDate txtTeishiShuryoYMD) {
        super();
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtTeishiKaishiYMD", txtTeishiKaishiYMD);
        this.setOriginalData("txtTeishiShuryoYMD", txtTeishiShuryoYMD);
        this.txtJotai = txtJotai;
        this.txtTeishiKaishiYMD = txtTeishiKaishiYMD;
        this.txtTeishiShuryoYMD = txtTeishiShuryoYMD;
    }

    public RString getTxtJotai() {
        return txtJotai;
    }

    public TextBoxDate getTxtTeishiKaishiYMD() {
        return txtTeishiKaishiYMD;
    }

    public TextBoxDate getTxtTeishiShuryoYMD() {
        return txtTeishiShuryoYMD;
    }

    public void setTxtJotai(RString txtJotai) {
        this.setOriginalData("txtJotai", txtJotai);
        this.txtJotai = txtJotai;
    }

    public void setTxtTeishiKaishiYMD(TextBoxDate txtTeishiKaishiYMD) {
        this.setOriginalData("txtTeishiKaishiYMD", txtTeishiKaishiYMD);
        this.txtTeishiKaishiYMD = txtTeishiKaishiYMD;
    }

    public void setTxtTeishiShuryoYMD(TextBoxDate txtTeishiShuryoYMD) {
        this.setOriginalData("txtTeishiShuryoYMD", txtTeishiShuryoYMD);
        this.txtTeishiShuryoYMD = txtTeishiShuryoYMD;
    }

    // </editor-fold>
}
