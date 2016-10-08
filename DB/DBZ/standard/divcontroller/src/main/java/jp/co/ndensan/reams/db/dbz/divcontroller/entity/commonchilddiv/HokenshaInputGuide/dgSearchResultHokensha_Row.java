package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaInputGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Oct 07 19:26:30 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSearchResultHokensha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSearchResultHokensha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-09-23_20-45-52">

    private RString hokenshaNo;
    private RString hokenshaMeisho;
    private RString hokensha;

    public dgSearchResultHokensha_Row() {
        super();
        this.hokenshaNo = RString.EMPTY;
        this.hokenshaMeisho = RString.EMPTY;
        this.hokensha = RString.EMPTY;
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hokensha", hokensha);
    }

    public dgSearchResultHokensha_Row(RString hokenshaNo, RString hokenshaMeisho, RString hokensha) {
        super();
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hokensha", hokensha);
        this.hokenshaNo = hokenshaNo;
        this.hokenshaMeisho = hokenshaMeisho;
        this.hokensha = hokensha;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    public RString getHokensha() {
        return hokensha;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.hokenshaMeisho = hokenshaMeisho;
    }

    public void setHokensha(RString hokensha) {
        this.setOriginalData("hokensha", hokensha);
        this.hokensha = hokensha;
    }

    // </editor-fold>
}
