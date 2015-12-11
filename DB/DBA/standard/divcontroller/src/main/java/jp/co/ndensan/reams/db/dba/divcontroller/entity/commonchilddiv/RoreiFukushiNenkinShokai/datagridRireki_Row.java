package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Dec 10 11:00:25 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * datagridRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class datagridRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">

    private RString startDate;
    private RString endDate;

    public datagridRireki_Row() {
        super();
        this.startDate = RString.EMPTY;
        this.endDate = RString.EMPTY;
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
    }

    public datagridRireki_Row(RString startDate, RString endDate) {
        super();
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RString getStartDate() {
        return startDate;
    }

    public RString getEndDate() {
        return endDate;
    }

    public void setStartDate(RString startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(RString endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

    // </editor-fold>
}
