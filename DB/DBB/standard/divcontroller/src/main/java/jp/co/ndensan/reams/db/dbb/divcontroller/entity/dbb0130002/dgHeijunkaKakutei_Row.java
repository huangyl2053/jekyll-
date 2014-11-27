package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0130002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Nov 27 20:32:52 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgHeijunkaKakutei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHeijunkaKakutei_Row extends DataRow {

    private RString txtHokenryoDankai;
    private TextBoxNum txtSagaku;
    private RString txtHeijunkaKensu;
    private RString txtKakuteiKensu;
    private RString txtTaishogaiKensu;

    public dgHeijunkaKakutei_Row() {
        super();
        this.txtHokenryoDankai = RString.EMPTY;
        this.txtSagaku = new TextBoxNum();
        this.txtHeijunkaKensu = RString.EMPTY;
        this.txtKakuteiKensu = RString.EMPTY;
        this.txtTaishogaiKensu = RString.EMPTY;
    }

    public dgHeijunkaKakutei_Row(RString txtHokenryoDankai, TextBoxNum txtSagaku, RString txtHeijunkaKensu, RString txtKakuteiKensu, RString txtTaishogaiKensu) {
        super();
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.setOriginalData("txtSagaku", txtSagaku);
        this.setOriginalData("txtHeijunkaKensu", txtHeijunkaKensu);
        this.setOriginalData("txtKakuteiKensu", txtKakuteiKensu);
        this.setOriginalData("txtTaishogaiKensu", txtTaishogaiKensu);
        this.txtHokenryoDankai = txtHokenryoDankai;
        this.txtSagaku = txtSagaku;
        this.txtHeijunkaKensu = txtHeijunkaKensu;
        this.txtKakuteiKensu = txtKakuteiKensu;
        this.txtTaishogaiKensu = txtTaishogaiKensu;
    }

    public RString getTxtHokenryoDankai() {
        return txtHokenryoDankai;
    }

    public TextBoxNum getTxtSagaku() {
        return txtSagaku;
    }

    public RString getTxtHeijunkaKensu() {
        return txtHeijunkaKensu;
    }

    public RString getTxtKakuteiKensu() {
        return txtKakuteiKensu;
    }

    public RString getTxtTaishogaiKensu() {
        return txtTaishogaiKensu;
    }

    public void setTxtHokenryoDankai(RString txtHokenryoDankai) {
        this.setOriginalData("txtHokenryoDankai", txtHokenryoDankai);
        this.txtHokenryoDankai = txtHokenryoDankai;
    }

    public void setTxtSagaku(TextBoxNum txtSagaku) {
        this.setOriginalData("txtSagaku", txtSagaku);
        this.txtSagaku = txtSagaku;
    }

    public void setTxtHeijunkaKensu(RString txtHeijunkaKensu) {
        this.setOriginalData("txtHeijunkaKensu", txtHeijunkaKensu);
        this.txtHeijunkaKensu = txtHeijunkaKensu;
    }

    public void setTxtKakuteiKensu(RString txtKakuteiKensu) {
        this.setOriginalData("txtKakuteiKensu", txtKakuteiKensu);
        this.txtKakuteiKensu = txtKakuteiKensu;
    }

    public void setTxtTaishogaiKensu(RString txtTaishogaiKensu) {
        this.setOriginalData("txtTaishogaiKensu", txtTaishogaiKensu);
        this.txtTaishogaiKensu = txtTaishogaiKensu;
    }

}