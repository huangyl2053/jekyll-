package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 19 14:59:25 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;

/**
 * dgShuseiSetaiIn_Row のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class dgShuseiSetaiIn_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtShikibetsuCodeShuseiYo;
    private RString txtShimeiShuseiYo;
    private RString txtKetsugoShuseiYo;

    public dgShuseiSetaiIn_Row() {
        super();
        this.txtShikibetsuCodeShuseiYo = RString.EMPTY;
        this.txtShimeiShuseiYo = RString.EMPTY;
        this.txtKetsugoShuseiYo = RString.EMPTY;
        this.setOriginalData("txtShikibetsuCodeShuseiYo", txtShikibetsuCodeShuseiYo);
        this.setOriginalData("txtShimeiShuseiYo", txtShimeiShuseiYo);
        this.setOriginalData("txtKetsugoShuseiYo", txtKetsugoShuseiYo);
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

    // </editor-fold>
}
