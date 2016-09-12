package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinJoho.RoreiFukushiNenkinJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 13 11:41:57 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgRoreiFukushiNenkinJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRoreiFukushiNenkinJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxFlexibleDate startDate;
    private TextBoxFlexibleDate endDate;

    public dgRoreiFukushiNenkinJoho_Row() {
        super();
        this.startDate = new TextBoxFlexibleDate();
        this.endDate = new TextBoxFlexibleDate();
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
    }

    public dgRoreiFukushiNenkinJoho_Row(TextBoxFlexibleDate startDate, TextBoxFlexibleDate endDate) {
        super();
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TextBoxFlexibleDate getStartDate() {
        return startDate;
    }

    public TextBoxFlexibleDate getEndDate() {
        return endDate;
    }

    public void setStartDate(TextBoxFlexibleDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxFlexibleDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

    // </editor-fold>
}
