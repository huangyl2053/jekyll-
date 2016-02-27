package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Dec 28 18:19:11 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKaishuJiyu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKaishuJiyu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString txtKaishuJiyuCode;
    private RString txtKaishuJiyu;

    public dgKaishuJiyu_Row() {
        super();
        this.txtKaishuJiyuCode = RString.EMPTY;
        this.txtKaishuJiyu = RString.EMPTY;
        this.setOriginalData("txtKaishuJiyuCode", txtKaishuJiyuCode);
        this.setOriginalData("txtKaishuJiyu", txtKaishuJiyu);
    }

    public dgKaishuJiyu_Row(RString txtKaishuJiyuCode, RString txtKaishuJiyu) {
        super();
        this.setOriginalData("txtKaishuJiyuCode", txtKaishuJiyuCode);
        this.setOriginalData("txtKaishuJiyu", txtKaishuJiyu);
        this.txtKaishuJiyuCode = txtKaishuJiyuCode;
        this.txtKaishuJiyu = txtKaishuJiyu;
    }

    public RString getTxtKaishuJiyuCode() {
        return txtKaishuJiyuCode;
    }

    public RString getTxtKaishuJiyu() {
        return txtKaishuJiyu;
    }

    public void setTxtKaishuJiyuCode(RString txtKaishuJiyuCode) {
        this.setOriginalData("txtKaishuJiyuCode", txtKaishuJiyuCode);
        this.txtKaishuJiyuCode = txtKaishuJiyuCode;
    }

    public void setTxtKaishuJiyu(RString txtKaishuJiyu) {
        this.setOriginalData("txtKaishuJiyu", txtKaishuJiyu);
        this.txtKaishuJiyu = txtKaishuJiyu;
    }

    // </editor-fold>
}
