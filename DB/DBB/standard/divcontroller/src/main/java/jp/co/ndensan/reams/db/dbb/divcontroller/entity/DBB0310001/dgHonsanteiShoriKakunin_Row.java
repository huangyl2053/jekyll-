package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0310001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 17 15:50:49 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHonsanteiShoriKakunin_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHonsanteiShoriKakunin_Row extends DataRow {

    private RString txtShoriMei;
    private RString txtJokyo;
    private RString txtShoriNichiji;

    public dgHonsanteiShoriKakunin_Row() {
        super();
        this.txtShoriMei = RString.EMPTY;
        this.txtJokyo = RString.EMPTY;
        this.txtShoriNichiji = RString.EMPTY;
    }

    public dgHonsanteiShoriKakunin_Row(RString txtShoriMei, RString txtJokyo, RString txtShoriNichiji) {
        super();
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.setOriginalData("txtJokyo", txtJokyo);
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriMei = txtShoriMei;
        this.txtJokyo = txtJokyo;
        this.txtShoriNichiji = txtShoriNichiji;
    }

    public RString getTxtShoriMei() {
        return txtShoriMei;
    }

    public RString getTxtJokyo() {
        return txtJokyo;
    }

    public RString getTxtShoriNichiji() {
        return txtShoriNichiji;
    }

    public void setTxtShoriMei(RString txtShoriMei) {
        this.setOriginalData("txtShoriMei", txtShoriMei);
        this.txtShoriMei = txtShoriMei;
    }

    public void setTxtJokyo(RString txtJokyo) {
        this.setOriginalData("txtJokyo", txtJokyo);
        this.txtJokyo = txtJokyo;
    }

    public void setTxtShoriNichiji(RString txtShoriNichiji) {
        this.setOriginalData("txtShoriNichiji", txtShoriNichiji);
        this.txtShoriNichiji = txtShoriNichiji;
    }

}