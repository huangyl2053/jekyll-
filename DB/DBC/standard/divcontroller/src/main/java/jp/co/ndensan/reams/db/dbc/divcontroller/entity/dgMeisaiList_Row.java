package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 22 16:35:34 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgMeisaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgMeisaiList_Row extends DataRow {

    private RString txtNo;
    private RString txtServiceShurui;
    private RString txtTanisu;
    private RString txtJigyosha;
    private RString txtJigyoshaKubun;

    public dgMeisaiList_Row() {
        super();
    }

    public dgMeisaiList_Row(RString txtNo, RString txtServiceShurui, RString txtTanisu, RString txtJigyosha, RString txtJigyoshaKubun) {
        super();
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.setOriginalData("txtTanisu", txtTanisu);
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.setOriginalData("txtJigyoshaKubun", txtJigyoshaKubun);
        this.txtNo = txtNo;
        this.txtServiceShurui = txtServiceShurui;
        this.txtTanisu = txtTanisu;
        this.txtJigyosha = txtJigyosha;
        this.txtJigyoshaKubun = txtJigyoshaKubun;
    }

    public RString getTxtNo() {
        return txtNo;
    }

    public RString getTxtServiceShurui() {
        return txtServiceShurui;
    }

    public RString getTxtTanisu() {
        return txtTanisu;
    }

    public RString getTxtJigyosha() {
        return txtJigyosha;
    }

    public RString getTxtJigyoshaKubun() {
        return txtJigyoshaKubun;
    }

    public void setTxtNo(RString txtNo) {
        this.setOriginalData("txtNo", txtNo);
        this.txtNo = txtNo;
    }

    public void setTxtServiceShurui(RString txtServiceShurui) {
        this.setOriginalData("txtServiceShurui", txtServiceShurui);
        this.txtServiceShurui = txtServiceShurui;
    }

    public void setTxtTanisu(RString txtTanisu) {
        this.setOriginalData("txtTanisu", txtTanisu);
        this.txtTanisu = txtTanisu;
    }

    public void setTxtJigyosha(RString txtJigyosha) {
        this.setOriginalData("txtJigyosha", txtJigyosha);
        this.txtJigyosha = txtJigyosha;
    }

    public void setTxtJigyoshaKubun(RString txtJigyoshaKubun) {
        this.setOriginalData("txtJigyoshaKubun", txtJigyoshaKubun);
        this.txtJigyoshaKubun = txtJigyoshaKubun;
    }

}