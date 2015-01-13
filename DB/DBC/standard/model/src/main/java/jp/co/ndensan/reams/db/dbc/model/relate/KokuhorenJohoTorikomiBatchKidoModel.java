/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model.relate;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiBatchKidoModel implements Serializable {

    private RString 処理名;
    private RString バッチID;
    private RString 交換識別番号;
    private RString 処理年月;
    private RString 再処理フラグ;

    /**
     * デフォルトコンストラクタです。
     */
    public KokuhorenJohoTorikomiBatchKidoModel() {
        処理名 = RString.EMPTY;
        バッチID = RString.EMPTY;
        処理年月 = RString.EMPTY;
        交換識別番号 = RString.EMPTY;
        再処理フラグ = RString.EMPTY;
    }

    /**
     * @return the 処理名
     */
    public RString get処理名() {
        return 処理名;
    }

    /**
     * @param 処理名 the 処理名 to set
     */
    public void set処理名(RString 処理名) {
        this.処理名 = 処理名;
    }

    /**
     * @return the バッチID
     */
    public RString getバッチID() {
        return バッチID;
    }

    /**
     * @param バッチID the バッチID to set
     */
    public void setバッチID(RString バッチID) {
        this.バッチID = バッチID;
    }

    /**
     * @return the 交換識別番号
     */
    public RString get交換識別番号() {
        return 交換識別番号;
    }

    /**
     * @param 交換識別番号 the 交換識別番号 to set
     */
    public void set交換識別番号(RString 交換識別番号) {
        this.交換識別番号 = 交換識別番号;
    }

    /**
     * @return the 処理年月
     */
    public RString get処理年月() {
        return 処理年月;
    }

    /**
     * @param 処理年月 the 処理年月 to set
     */
    public void set処理年月(RString 処理年月) {
        this.処理年月 = 処理年月;
    }

    /**
     * @return the 再処理フラグ
     */
    public RString get再処理フラグ() {
        return 再処理フラグ;
    }

    /**
     * @param 再処理フラグ the 再処理フラグ to set
     */
    public void set再処理フラグ(RString 再処理フラグ) {
        this.再処理フラグ = 再処理フラグ;
    }
}
