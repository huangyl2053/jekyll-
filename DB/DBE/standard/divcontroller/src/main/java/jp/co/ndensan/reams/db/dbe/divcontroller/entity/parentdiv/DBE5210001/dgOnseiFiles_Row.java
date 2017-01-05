package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jan 04 13:56:33 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgOnseiFiles_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgOnseiFiles_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">

    private TextBoxNum no;
    private RString insDate;

    public dgOnseiFiles_Row() {
        super();
        this.no = new TextBoxNum();
        this.insDate = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("insDate", insDate);
    }

    public dgOnseiFiles_Row(TextBoxNum no, RString insDate) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("insDate", insDate);
        this.no = no;
        this.insDate = insDate;
    }

    public TextBoxNum getNo() {
        return no;
    }

    public RString getInsDate() {
        return insDate;
    }

    public void setNo(TextBoxNum no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setInsDate(RString insDate) {
        this.setOriginalData("insDate", insDate);
        this.insDate = insDate;
    }

    // </editor-fold>
}
