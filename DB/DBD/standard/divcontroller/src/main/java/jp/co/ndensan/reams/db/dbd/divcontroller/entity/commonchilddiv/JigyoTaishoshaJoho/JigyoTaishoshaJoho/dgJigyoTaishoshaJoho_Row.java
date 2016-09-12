package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.JigyoTaishoshaJoho.JigyoTaishoshaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sun Jun 12 10:58:52 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgJigyoTaishoshaJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJigyoTaishoshaJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private TextBoxFlexibleDate tekiyoStartDate;
    private TextBoxFlexibleDate tekiyoEndDate;
    private TextBoxFlexibleDate checkListJisshiDate;

    public dgJigyoTaishoshaJoho_Row() {
        super();
        this.tekiyoStartDate = new TextBoxFlexibleDate();
        this.tekiyoEndDate = new TextBoxFlexibleDate();
        this.checkListJisshiDate = new TextBoxFlexibleDate();
        this.setOriginalData("tekiyoStartDate", tekiyoStartDate);
        this.setOriginalData("tekiyoEndDate", tekiyoEndDate);
        this.setOriginalData("checkListJisshiDate", checkListJisshiDate);
    }

    public dgJigyoTaishoshaJoho_Row(TextBoxFlexibleDate tekiyoStartDate, TextBoxFlexibleDate tekiyoEndDate, TextBoxFlexibleDate checkListJisshiDate) {
        super();
        this.setOriginalData("tekiyoStartDate", tekiyoStartDate);
        this.setOriginalData("tekiyoEndDate", tekiyoEndDate);
        this.setOriginalData("checkListJisshiDate", checkListJisshiDate);
        this.tekiyoStartDate = tekiyoStartDate;
        this.tekiyoEndDate = tekiyoEndDate;
        this.checkListJisshiDate = checkListJisshiDate;
    }

    public TextBoxFlexibleDate getTekiyoStartDate() {
        return tekiyoStartDate;
    }

    public TextBoxFlexibleDate getTekiyoEndDate() {
        return tekiyoEndDate;
    }

    public TextBoxFlexibleDate getCheckListJisshiDate() {
        return checkListJisshiDate;
    }

    public void setTekiyoStartDate(TextBoxFlexibleDate tekiyoStartDate) {
        this.setOriginalData("tekiyoStartDate", tekiyoStartDate);
        this.tekiyoStartDate = tekiyoStartDate;
    }

    public void setTekiyoEndDate(TextBoxFlexibleDate tekiyoEndDate) {
        this.setOriginalData("tekiyoEndDate", tekiyoEndDate);
        this.tekiyoEndDate = tekiyoEndDate;
    }

    public void setCheckListJisshiDate(TextBoxFlexibleDate checkListJisshiDate) {
        this.setOriginalData("checkListJisshiDate", checkListJisshiDate);
        this.checkListJisshiDate = checkListJisshiDate;
    }

    // </editor-fold>
}
