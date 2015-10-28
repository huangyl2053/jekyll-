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

    public static final String SHORIYM = "shoriym";
    public static final String SHUTURYOKUJUNID = "shutsuryokujunid";
    public static final String SAISHORIKUBUN = "saishorikubun";
    public static final String KOKANJOHOSHIKIBETSUNO = "kokanjohoshikibetsuno";
    public static final String SHORINICHIJI = "shorinichiji";
    public static final String HOKENSHAKOSEIKUBUN = "hokenshakoseikubun";
    public static final String GAPPEIJOHOKBN = "gappeijohokubun";

    @BatchParameter(key = SHORIYM, name = "処理対象年月")
    private RString shoriYM;

    @BatchParameter(key = SHUTURYOKUJUNID, name = "出力順ID")
    private RString shutsuryokujunID;

    @BatchParameter(key = SAISHORIKUBUN, name = "再処理区分")
    private RString saishoriKubun;

    @BatchParameter(key = KOKANJOHOSHIKIBETSUNO, name = "交換情報識別番号")
    private RString kokanjohoShikibetsuNo;

    @BatchParameter(key = SHORINICHIJI, name = "処理日時")
    private RString shoriNichiji;

    @BatchParameter(key = HOKENSHAKOSEIKUBUN, name = "保険者構成区分")
    private RString hokenshaKoseiKubun;

    @BatchParameter(key = GAPPEIJOHOKBN, name = "合併情報区分")
    private RString gappeiJohoKubun;

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
     * @return the shoriNichiji
     */
    public RString getShoriNichiji() {
        return shoriNichiji;
    }

    /**
     * @param shoriNichiji the shoriNichiji to set
     */
    public void setShoriNichiji(RString shoriNichiji) {
        this.shoriNichiji = shoriNichiji;
    }

    /**
     * @return the hokenshaKoseiKubun
     */
    public RString getHokenshaKoseiKubun() {
        return hokenshaKoseiKubun;
    }

    /**
     * @param hokenshaKoseiKubun the hokenshaKoseiKubun to set
     */
    public void setHokenshaKoseiKubun(RString hokenshaKoseiKubun) {
        this.hokenshaKoseiKubun = hokenshaKoseiKubun;
    }

    /**
     * @return the gappeiJohoKubun
     */
    public RString getGappeiJohoKubun() {
        return gappeiJohoKubun;
    }

    /**
     * @param gappeiJohoKubun the gappeiJohoKubun to set
     */
    public void setGappeiJohoKubun(RString gappeiJohoKubun) {
        this.gappeiJohoKubun = gappeiJohoKubun;
    }
}
