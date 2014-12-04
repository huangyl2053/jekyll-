package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Nov 28 10:51:20 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgServiceRiyohyoBeppyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgServiceRiyohyoBeppyoList_Row extends DataRow {

    private Button btnSelect;
    private Button btnDelete;
    private RString txtJigyosha;
    private RString txtService;
    private TextBoxNum txtTani;
    private TextBoxNum txtWaribikigoRitsu;
    private TextBoxNum txtWaribikigoTani;
    private TextBoxNum txtKaisu;
    private TextBoxNum txtServiceTani;
    private TextBoxNum txtShuruiGendoChokaTani;
    private TextBoxNum txtShuruiGendonaiTani;
    private TextBoxNum txtKubunGendoChokaTani;
    private TextBoxNum txtKubunGendonaiTani;
    private TextBoxNum txtTanisuTanka;
    private TextBoxNum txtHiyoSogaku;
    private TextBoxNum txtKyufuritsu;
    private TextBoxNum txtHokenFutangaku;
    private TextBoxNum txtRiyoshaFutangakuHoken;
    private TextBoxNum txtRiyoshaFutangakuZengaku;

    public dgServiceRiyohyoBeppyoList_Row() {
        super();
        this.btnSelect = new Button();
        this.btnDelete = new Button();
        this.txtJigyosha = RString.EMPTY;
        this.txtService = RString.EMPTY;
        this.txtTani = new TextBoxNum();
        this.txtWaribikigoRitsu = new TextBoxNum();
        this.txtWaribikigoTani = new TextBoxNum();
        this.txtKaisu = new TextBoxNum();
        this.txtServiceTani = new TextBoxNum();
        this.txtShuruiGendoChokaTani = new TextBoxNum();
        this.txtShuruiGendonaiTani = new TextBoxNum();
        this.txtKubunGendoChokaTani = new TextBoxNum();
        this.txtKubunGendonaiTani = new TextBoxNum();
        this.txtTanisuTanka = new TextBoxNum();
        this.txtHiyoSogaku = new TextBoxNum();
        this.txtKyufuritsu = new TextBoxNum();
        this.txtHokenFutangaku = new TextBoxNum();
        this.txtRiyoshaFutangakuHoken = new TextBoxNum();
        this.txtRiyoshaFutangakuZengaku = new TextBoxNum();
    }

    public dgServiceRiyohyoBeppyoList_Row(Button btnSelect, Button btnDelete, RString txtJigyosha, RString txtService, TextBoxNum txtTani, TextBoxNum txtWaribikigoRitsu, TextBoxNum txtWaribikigoTani, TextBoxNum txtKaisu, TextBoxNum txtServiceTani, TextBoxNum txtShuruiGendoChokaTani, TextBoxNum txtShuruiGendonaiTani, TextBoxNum txtKubunGendoChokaTani, TextBoxNum txtKubunGendonaiTani, TextBoxNum txtTanisuTanka, TextBoxNum txtHiyoSogaku, TextBoxNum txtKyufuritsu, TextBoxNum txtHokenFutangaku, TextBoxNum txtRiyoshaFutangakuHoken, TextBoxNum txtRiyoshaFutangakuZengaku) {
        super();
        this.setOriginalData("btnSelect", btnSelect);
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtService", txtService);
        this.setOriginalData("txtTani", txtTani);
        this.setOriginalData("txtWaribikigoRitsu", txtWaribikigoRitsu);
        this.setOriginalData("txtWaribikigoTani", txtWaribikigoTani);
        this.setOriginalData("txtKaisu", txtKaisu);
        this.setOriginalData("txtServiceTani", txtServiceTani);
        this.setOriginalData("txtShuruiGendoChokaTani", txtShuruiGendoChokaTani);
        this.setOriginalData("txtShuruiGendonaiTani", txtShuruiGendonaiTani);
        this.setOriginalData("txtKubunGendoChokaTani", txtKubunGendoChokaTani);
        this.setOriginalData("txtKubunGendonaiTani", txtKubunGendonaiTani);
        this.setOriginalData("txtTanisuTanka", txtTanisuTanka);
        this.setOriginalData("txtHiyoSogaku", txtHiyoSogaku);
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.setOriginalData("txtHokenFutangaku", txtHokenFutangaku);
        this.setOriginalData("txtRiyoshaFutangakuHoken", txtRiyoshaFutangakuHoken);
        this.setOriginalData("txtRiyoshaFutangakuZengaku", txtRiyoshaFutangakuZengaku);
        this.btnSelect = btnSelect;
        this.btnDelete = btnDelete;
        this.txtJigyosha = txtJigyosha;
        this.txtService = txtService;
        this.txtTani = txtTani;
        this.txtWaribikigoRitsu = txtWaribikigoRitsu;
        this.txtWaribikigoTani = txtWaribikigoTani;
        this.txtKaisu = txtKaisu;
        this.txtServiceTani = txtServiceTani;
        this.txtShuruiGendoChokaTani = txtShuruiGendoChokaTani;
        this.txtShuruiGendonaiTani = txtShuruiGendonaiTani;
        this.txtKubunGendoChokaTani = txtKubunGendoChokaTani;
        this.txtKubunGendonaiTani = txtKubunGendonaiTani;
        this.txtTanisuTanka = txtTanisuTanka;
        this.txtHiyoSogaku = txtHiyoSogaku;
        this.txtKyufuritsu = txtKyufuritsu;
        this.txtHokenFutangaku = txtHokenFutangaku;
        this.txtRiyoshaFutangakuHoken = txtRiyoshaFutangakuHoken;
        this.txtRiyoshaFutangakuZengaku = txtRiyoshaFutangakuZengaku;
    }

    public Button getBtnSelect() {
        return btnSelect;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtService() {
        return txtService;
    }

    public TextBoxNum getTxtTani() {
        return txtTani;
    }

    public TextBoxNum getTxtWaribikigoRitsu() {
        return txtWaribikigoRitsu;
    }

    public TextBoxNum getTxtWaribikigoTani() {
        return txtWaribikigoTani;
    }

    public TextBoxNum getTxtKaisu() {
        return txtKaisu;
    }

    public TextBoxNum getTxtServiceTani() {
        return txtServiceTani;
    }

    public TextBoxNum getTxtShuruiGendoChokaTani() {
        return txtShuruiGendoChokaTani;
    }

    public TextBoxNum getTxtShuruiGendonaiTani() {
        return txtShuruiGendonaiTani;
    }

    public TextBoxNum getTxtKubunGendoChokaTani() {
        return txtKubunGendoChokaTani;
    }

    public TextBoxNum getTxtKubunGendonaiTani() {
        return txtKubunGendonaiTani;
    }

    public TextBoxNum getTxtTanisuTanka() {
        return txtTanisuTanka;
    }

    public TextBoxNum getTxtHiyoSogaku() {
        return txtHiyoSogaku;
    }

    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    public TextBoxNum getTxtHokenFutangaku() {
        return txtHokenFutangaku;
    }

    public TextBoxNum getTxtRiyoshaFutangakuHoken() {
        return txtRiyoshaFutangakuHoken;
    }

    public TextBoxNum getTxtRiyoshaFutangakuZengaku() {
        return txtRiyoshaFutangakuZengaku;
    }

    public void setBtnSelect(Button btnSelect) {
        this.setOriginalData("btnSelect", btnSelect);
        this.btnSelect = btnSelect;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtService(RString txtService) {
        this.setOriginalData("txtService", txtService);
        this.txtService = txtService;
    }

    public void setTxtTani(TextBoxNum txtTani) {
        this.setOriginalData("txtTani", txtTani);
        this.txtTani = txtTani;
    }

    public void setTxtWaribikigoRitsu(TextBoxNum txtWaribikigoRitsu) {
        this.setOriginalData("txtWaribikigoRitsu", txtWaribikigoRitsu);
        this.txtWaribikigoRitsu = txtWaribikigoRitsu;
    }

    public void setTxtWaribikigoTani(TextBoxNum txtWaribikigoTani) {
        this.setOriginalData("txtWaribikigoTani", txtWaribikigoTani);
        this.txtWaribikigoTani = txtWaribikigoTani;
    }

    public void setTxtKaisu(TextBoxNum txtKaisu) {
        this.setOriginalData("txtKaisu", txtKaisu);
        this.txtKaisu = txtKaisu;
    }

    public void setTxtServiceTani(TextBoxNum txtServiceTani) {
        this.setOriginalData("txtServiceTani", txtServiceTani);
        this.txtServiceTani = txtServiceTani;
    }

    public void setTxtShuruiGendoChokaTani(TextBoxNum txtShuruiGendoChokaTani) {
        this.setOriginalData("txtShuruiGendoChokaTani", txtShuruiGendoChokaTani);
        this.txtShuruiGendoChokaTani = txtShuruiGendoChokaTani;
    }

    public void setTxtShuruiGendonaiTani(TextBoxNum txtShuruiGendonaiTani) {
        this.setOriginalData("txtShuruiGendonaiTani", txtShuruiGendonaiTani);
        this.txtShuruiGendonaiTani = txtShuruiGendonaiTani;
    }

    public void setTxtKubunGendoChokaTani(TextBoxNum txtKubunGendoChokaTani) {
        this.setOriginalData("txtKubunGendoChokaTani", txtKubunGendoChokaTani);
        this.txtKubunGendoChokaTani = txtKubunGendoChokaTani;
    }

    public void setTxtKubunGendonaiTani(TextBoxNum txtKubunGendonaiTani) {
        this.setOriginalData("txtKubunGendonaiTani", txtKubunGendonaiTani);
        this.txtKubunGendonaiTani = txtKubunGendonaiTani;
    }

    public void setTxtTanisuTanka(TextBoxNum txtTanisuTanka) {
        this.setOriginalData("txtTanisuTanka", txtTanisuTanka);
        this.txtTanisuTanka = txtTanisuTanka;
    }

    public void setTxtHiyoSogaku(TextBoxNum txtHiyoSogaku) {
        this.setOriginalData("txtHiyoSogaku", txtHiyoSogaku);
        this.txtHiyoSogaku = txtHiyoSogaku;
    }

    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.setOriginalData("txtKyufuritsu", txtKyufuritsu);
        this.txtKyufuritsu = txtKyufuritsu;
    }

    public void setTxtHokenFutangaku(TextBoxNum txtHokenFutangaku) {
        this.setOriginalData("txtHokenFutangaku", txtHokenFutangaku);
        this.txtHokenFutangaku = txtHokenFutangaku;
    }

    public void setTxtRiyoshaFutangakuHoken(TextBoxNum txtRiyoshaFutangakuHoken) {
        this.setOriginalData("txtRiyoshaFutangakuHoken", txtRiyoshaFutangakuHoken);
        this.txtRiyoshaFutangakuHoken = txtRiyoshaFutangakuHoken;
    }

    public void setTxtRiyoshaFutangakuZengaku(TextBoxNum txtRiyoshaFutangakuZengaku) {
        this.setOriginalData("txtRiyoshaFutangakuZengaku", txtRiyoshaFutangakuZengaku);
        this.txtRiyoshaFutangakuZengaku = txtRiyoshaFutangakuZengaku;
    }

}