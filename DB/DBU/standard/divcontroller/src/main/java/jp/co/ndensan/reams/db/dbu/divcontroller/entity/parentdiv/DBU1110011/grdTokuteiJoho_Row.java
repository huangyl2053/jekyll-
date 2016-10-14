package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU1110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Oct 13 14:32:33 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridColumnCheckBox;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * grdTokuteiJoho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class grdTokuteiJoho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private DataGridColumnCheckBox chkSeiGyo;
    private RString tokuteiKojinJohoNo;
    private RString tokuteiKojinJoho;
    private RString hanBangou;

    public grdTokuteiJoho_Row() {
        super();
        this.chkSeiGyo = new DataGridColumnCheckBox();
        this.tokuteiKojinJohoNo = RString.EMPTY;
        this.tokuteiKojinJoho = RString.EMPTY;
        this.hanBangou = RString.EMPTY;
        this.setOriginalData("chkSeiGyo", chkSeiGyo);
        this.setOriginalData("tokuteiKojinJohoNo", tokuteiKojinJohoNo);
        this.setOriginalData("tokuteiKojinJoho", tokuteiKojinJoho);
        this.setOriginalData("hanBangou", hanBangou);
    }

    public grdTokuteiJoho_Row(DataGridColumnCheckBox chkSeiGyo, RString tokuteiKojinJohoNo, RString tokuteiKojinJoho, RString hanBangou) {
        super();
        this.setOriginalData("chkSeiGyo", chkSeiGyo);
        this.setOriginalData("tokuteiKojinJohoNo", tokuteiKojinJohoNo);
        this.setOriginalData("tokuteiKojinJoho", tokuteiKojinJoho);
        this.setOriginalData("hanBangou", hanBangou);
        this.chkSeiGyo = chkSeiGyo;
        this.tokuteiKojinJohoNo = tokuteiKojinJohoNo;
        this.tokuteiKojinJoho = tokuteiKojinJoho;
        this.hanBangou = hanBangou;
    }

    public grdTokuteiJoho_Row(DataGridSetting gridSetting) {
        super();
        this.chkSeiGyo = DataGridColumnCheckBox.createInstance(gridSetting.getColumn("chkSeiGyo").getCellDetails());
        this.tokuteiKojinJohoNo = RString.EMPTY;
        this.tokuteiKojinJoho = RString.EMPTY;
        this.hanBangou = RString.EMPTY;
        this.setOriginalData("chkSeiGyo", chkSeiGyo);
        this.setOriginalData("tokuteiKojinJohoNo", tokuteiKojinJohoNo);
        this.setOriginalData("tokuteiKojinJoho", tokuteiKojinJoho);
        this.setOriginalData("hanBangou", hanBangou);
    }

    public DataGridColumnCheckBox getChkSeiGyo() {
        return chkSeiGyo;
    }

    public RString getTokuteiKojinJohoNo() {
        return tokuteiKojinJohoNo;
    }

    public RString getTokuteiKojinJoho() {
        return tokuteiKojinJoho;
    }

    public RString getHanBangou() {
        return hanBangou;
    }

    public void setChkSeiGyo(DataGridColumnCheckBox chkSeiGyo) {
        this.setOriginalData("chkSeiGyo", chkSeiGyo);
        this.chkSeiGyo = chkSeiGyo;
    }

    public void setTokuteiKojinJohoNo(RString tokuteiKojinJohoNo) {
        this.setOriginalData("tokuteiKojinJohoNo", tokuteiKojinJohoNo);
        this.tokuteiKojinJohoNo = tokuteiKojinJohoNo;
    }

    public void setTokuteiKojinJoho(RString tokuteiKojinJoho) {
        this.setOriginalData("tokuteiKojinJoho", tokuteiKojinJoho);
        this.tokuteiKojinJoho = tokuteiKojinJoho;
    }

    public void setHanBangou(RString hanBangou) {
        this.setOriginalData("hanBangou", hanBangou);
        this.hanBangou = hanBangou;
    }

    // </editor-fold>
}
