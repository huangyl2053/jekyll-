package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 17:14:03 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShuseiSetaiIn_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShuseiSetaiIn_Row extends DataRow {

    private RString txtShikibetsuCodeShuseiYo;
    private RString txtShimeiShuseiYo;
    private RString txtKetsugoShuseiYo;

    public dgShuseiSetaiIn_Row() {
        super();
    }

    public dgShuseiSetaiIn_Row(RString txtShikibetsuCodeShuseiYo, RString txtShimeiShuseiYo, RString txtKetsugoShuseiYo) {
        super();
        this.setOriginalData("txtShikibetsuCodeShuseiYo", txtShikibetsuCodeShuseiYo);
        this.setOriginalData("txtShimeiShuseiYo", txtShimeiShuseiYo);
        this.setOriginalData("txtKetsugoShuseiYo", txtKetsugoShuseiYo);
        this.txtShikibetsuCodeShuseiYo = txtShikibetsuCodeShuseiYo;
        this.txtShimeiShuseiYo = txtShimeiShuseiYo;
        this.txtKetsugoShuseiYo = txtKetsugoShuseiYo;
    }

    public RString getTxtShikibetsuCodeShuseiYo() {
        return txtShikibetsuCodeShuseiYo;
    }

    public RString getTxtShimeiShuseiYo() {
        return txtShimeiShuseiYo;
    }

    public RString getTxtKetsugoShuseiYo() {
        return txtKetsugoShuseiYo;
    }

    public void setTxtShikibetsuCodeShuseiYo(RString txtShikibetsuCodeShuseiYo) {
        this.setOriginalData("txtShikibetsuCodeShuseiYo", txtShikibetsuCodeShuseiYo);
        this.txtShikibetsuCodeShuseiYo = txtShikibetsuCodeShuseiYo;
    }

    public void setTxtShimeiShuseiYo(RString txtShimeiShuseiYo) {
        this.setOriginalData("txtShimeiShuseiYo", txtShimeiShuseiYo);
        this.txtShimeiShuseiYo = txtShimeiShuseiYo;
    }

    public void setTxtKetsugoShuseiYo(RString txtKetsugoShuseiYo) {
        this.setOriginalData("txtKetsugoShuseiYo", txtKetsugoShuseiYo);
        this.txtKetsugoShuseiYo = txtKetsugoShuseiYo;
    }

}