/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiBatchParameter extends BatchParameterBase {

    public final static String SHORIYM = "shoriym";
    public final static String SHUTURYOKUJUNID = "shutsuryokujunid";
    public final static String SAISHORIKUBUN = "saishorikubun";
    public final static String KOKANJOHOSHIKIBETSUNO = "kokanjohoshikibetsuno";

    @BatchParameter(key = SHORIYM, name = "処理対象年月")
    private RString shoriYM;

    @BatchParameter(key = SHUTURYOKUJUNID, name = "出力順ID")
    private RString shutsuryokujunID;

    @BatchParameter(key = SAISHORIKUBUN, name = "再処理区分")
    private RString saishoriKubun;

    @BatchParameter(key = KOKANJOHOSHIKIBETSUNO, name = "交換情報識別番号")
    private RString kokanjohoShikibetsuNo;

    // 制御情報を格納するフィールド
    @BatchParameter(name = "処理区分")
    private RString shoriKubun;

    /**
     * @return the shoriYM
     */
    public RString getShoriYM() {
        return shoriYM;
    }

    /**
     * @param shoriYM the shoriYM to set
     */
    public void setShoriYM(RString shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * @return the shutsuryokujunID
     */
    public RString getShutsuryokujunID() {
        return shutsuryokujunID;
    }

    /**
     * @param shutsuryokujunID the shutsuryokujunID to set
     */
    public void setShutsuryokujunID(RString shutsuryokujunID) {
        this.shutsuryokujunID = shutsuryokujunID;
    }

    /**
     * @return the saishoriKubun
     */
    public RString getSaishoriKubun() {
        return saishoriKubun;
    }

    /**
     * @param saishoriKubun the saishoriKubun to set
     */
    public void setSaishoriKubun(RString saishoriKubun) {
        this.saishoriKubun = saishoriKubun;
    }

    /**
     * @return the kokanjohoShikibetsuNo
     */
    public RString getKokanjohoShikibetsuNo() {
        return kokanjohoShikibetsuNo;
    }

    /**
     * @param kokanjohoShikibetsuNo the kokanjohoShikibetsuNo to set
     */
    public void setKokanjohoShikibetsuNo(RString kokanjohoShikibetsuNo) {
        this.kokanjohoShikibetsuNo = kokanjohoShikibetsuNo;
    }

    /**
     * @return the shoriKubun
     */
    public RString getShoriKubun() {
        return shoriKubun;
    }

    /**
     * @param shoriKubun the shoriKubun to set
     */
    public void setShoriKubun(RString shoriKubun) {
        this.shoriKubun = shoriKubun;
    }

}
