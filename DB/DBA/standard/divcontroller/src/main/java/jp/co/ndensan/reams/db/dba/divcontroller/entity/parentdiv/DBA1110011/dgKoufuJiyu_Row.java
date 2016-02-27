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
 * dgKoufuJiyu_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKoufuJiyu_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString txtKofuJiyuCode;
    private RString txtKofuJiyu;

    public dgKoufuJiyu_Row() {
        super();
        this.txtKofuJiyuCode = RString.EMPTY;
        this.txtKofuJiyu = RString.EMPTY;
        this.setOriginalData("txtKofuJiyuCode", txtKofuJiyuCode);
        this.setOriginalData("txtKofuJiyu", txtKofuJiyu);
    }

    public dgKoufuJiyu_Row(RString txtKofuJiyuCode, RString txtKofuJiyu) {
        super();
        this.setOriginalData("txtKofuJiyuCode", txtKofuJiyuCode);
        this.setOriginalData("txtKofuJiyu", txtKofuJiyu);
        this.txtKofuJiyuCode = txtKofuJiyuCode;
        this.txtKofuJiyu = txtKofuJiyu;
    }

    public RString getTxtKofuJiyuCode() {
        return txtKofuJiyuCode;
    }

    public RString getTxtKofuJiyu() {
        return txtKofuJiyu;
    }

    public void setTxtKofuJiyuCode(RString txtKofuJiyuCode) {
        this.setOriginalData("txtKofuJiyuCode", txtKofuJiyuCode);
        this.txtKofuJiyuCode = txtKofuJiyuCode;
    }

    public void setTxtKofuJiyu(RString txtKofuJiyu) {
        this.setOriginalData("txtKofuJiyu", txtKofuJiyu);
        this.txtKofuJiyu = txtKofuJiyu;
    }

    // </editor-fold>
}
