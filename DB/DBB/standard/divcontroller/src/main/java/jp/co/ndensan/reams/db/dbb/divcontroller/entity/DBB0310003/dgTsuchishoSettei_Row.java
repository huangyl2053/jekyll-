package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310003;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 23 11:19:58 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgTsuchishoSettei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTsuchishoSettei_Row extends DataRow {

    private RString txtChosyuHoho;
    private RString txtJotai;
    private DropDownList txtTsuchisyoShitei;
    private DropDownList txtGenkinKozaShitei;
    private TextBox txtHakkojiGroup;

    public dgTsuchishoSettei_Row() {
        super();
        this.txtChosyuHoho = RString.EMPTY;
        this.txtJotai = RString.EMPTY;
        this.txtTsuchisyoShitei = new DropDownList();
        this.txtGenkinKozaShitei = new DropDownList();
        this.txtHakkojiGroup = new TextBox();
    }

    public dgTsuchishoSettei_Row(RString txtChosyuHoho, RString txtJotai, DropDownList txtTsuchisyoShitei, DropDownList txtGenkinKozaShitei, TextBox txtHakkojiGroup) {
        super();
        this.setOriginalData("txtChosyuHoho", txtChosyuHoho);
        this.setOriginalData("txtJotai", txtJotai);
        this.setOriginalData("txtTsuchisyoShitei", txtTsuchisyoShitei);
        this.setOriginalData("txtGenkinKozaShitei", txtGenkinKozaShitei);
        this.setOriginalData("txtHakkojiGroup", txtHakkojiGroup);
        this.txtChosyuHoho = txtChosyuHoho;
        this.txtJotai = txtJotai;
        this.txtTsuchisyoShitei = txtTsuchisyoShitei;
        this.txtGenkinKozaShitei = txtGenkinKozaShitei;
        this.txtHakkojiGroup = txtHakkojiGroup;
    }

    public dgTsuchishoSettei_Row(DataGridSetting gridSetting) {
        super();
        this.txtChosyuHoho = RString.EMPTY;
        this.txtJotai = RString.EMPTY;
        this.txtTsuchisyoShitei = DropDownList.createInstance(gridSetting.getColumn("txtTsuchisyoShitei").getCellDetails());
        this.setOriginalData("txtTsuchisyoShitei", txtTsuchisyoShitei);
        this.txtGenkinKozaShitei = DropDownList.createInstance(gridSetting.getColumn("txtGenkinKozaShitei").getCellDetails());
        this.setOriginalData("txtGenkinKozaShitei", txtGenkinKozaShitei);
        this.txtHakkojiGroup = new TextBox();
    }

    public RString getTxtChosyuHoho() {
        return txtChosyuHoho;
    }

    public RString getTxtJotai() {
        return txtJotai;
    }

    public DropDownList getTxtTsuchisyoShitei() {
        return txtTsuchisyoShitei;
    }

    public DropDownList getTxtGenkinKozaShitei() {
        return txtGenkinKozaShitei;
    }

    public TextBox getTxtHakkojiGroup() {
        return txtHakkojiGroup;
    }

    public void setTxtChosyuHoho(RString txtChosyuHoho) {
        this.setOriginalData("txtChosyuHoho", txtChosyuHoho);
        this.txtChosyuHoho = txtChosyuHoho;
    }

    public void setTxtJotai(RString txtJotai) {
        this.setOriginalData("txtJotai", txtJotai);
        this.txtJotai = txtJotai;
    }

    public void setTxtTsuchisyoShitei(DropDownList txtTsuchisyoShitei) {
        this.setOriginalData("txtTsuchisyoShitei", txtTsuchisyoShitei);
        this.txtTsuchisyoShitei = txtTsuchisyoShitei;
    }

    public void setTxtGenkinKozaShitei(DropDownList txtGenkinKozaShitei) {
        this.setOriginalData("txtGenkinKozaShitei", txtGenkinKozaShitei);
        this.txtGenkinKozaShitei = txtGenkinKozaShitei;
    }

    public void setTxtHakkojiGroup(TextBox txtHakkojiGroup) {
        this.setOriginalData("txtHakkojiGroup", txtHakkojiGroup);
        this.txtHakkojiGroup = txtHakkojiGroup;
    }

}