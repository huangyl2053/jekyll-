package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Aug 06 10:12:14 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * datagridRireki_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class datagridRireki_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString jotai;
    private TextBoxDate startDate;
    private TextBoxDate endDate;

    public datagridRireki_Row() {
        super();
        this.jotai = RString.EMPTY;
        this.startDate = new TextBoxDate();
        this.endDate = new TextBoxDate();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
    }

    public datagridRireki_Row(RString jotai, TextBoxDate startDate, TextBoxDate endDate) {
        super();
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.jotai = jotai;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RString getJotai() {
        return jotai;
    }

    public TextBoxDate getStartDate() {
        return startDate;
    }

    public TextBoxDate getEndDate() {
        return endDate;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setStartDate(TextBoxDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

    // </editor-fold>
}
