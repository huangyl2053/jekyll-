package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5140003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 12 15:28:37 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * dgShinsakaiScheduleKagami_Row のクラスファイル。
 *
 * @reamsid_L DBE-0130-030 yaodongsheng
 */
public class dgShinsakaiScheduleKagami_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private RString shinsakaiIinCode;
    private RString shinsakaiIinName;
    private RString shozokuGogitaiBango;
    private RString shozokuGogitaiMeisho;
    private RString jusho;

    public dgShinsakaiScheduleKagami_Row() {
        super();
        this.shinsakaiIinCode = RString.EMPTY;
        this.shinsakaiIinName = RString.EMPTY;
        this.shozokuGogitaiBango = RString.EMPTY;
        this.shozokuGogitaiMeisho = RString.EMPTY;
        this.jusho = RString.EMPTY;
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("shozokuGogitaiBango", shozokuGogitaiBango);
        this.setOriginalData("shozokuGogitaiMeisho", shozokuGogitaiMeisho);
        this.setOriginalData("jusho", jusho);
    }

    public dgShinsakaiScheduleKagami_Row(RString shinsakaiIinCode, RString shinsakaiIinName, RString shozokuGogitaiBango, RString shozokuGogitaiMeisho, RString jusho) {
        super();
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.setOriginalData("shozokuGogitaiBango", shozokuGogitaiBango);
        this.setOriginalData("shozokuGogitaiMeisho", shozokuGogitaiMeisho);
        this.setOriginalData("jusho", jusho);
        this.shinsakaiIinCode = shinsakaiIinCode;
        this.shinsakaiIinName = shinsakaiIinName;
        this.shozokuGogitaiBango = shozokuGogitaiBango;
        this.shozokuGogitaiMeisho = shozokuGogitaiMeisho;
        this.jusho = jusho;
    }

    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    public RString getShinsakaiIinName() {
        return shinsakaiIinName;
    }

    public RString getShozokuGogitaiBango() {
        return shozokuGogitaiBango;
    }

    public RString getShozokuGogitaiMeisho() {
        return shozokuGogitaiMeisho;
    }

    public RString getJusho() {
        return jusho;
    }

    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.setOriginalData("shinsakaiIinCode", shinsakaiIinCode);
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    public void setShinsakaiIinName(RString shinsakaiIinName) {
        this.setOriginalData("shinsakaiIinName", shinsakaiIinName);
        this.shinsakaiIinName = shinsakaiIinName;
    }

    public void setShozokuGogitaiBango(RString shozokuGogitaiBango) {
        this.setOriginalData("shozokuGogitaiBango", shozokuGogitaiBango);
        this.shozokuGogitaiBango = shozokuGogitaiBango;
    }

    public void setShozokuGogitaiMeisho(RString shozokuGogitaiMeisho) {
        this.setOriginalData("shozokuGogitaiMeisho", shozokuGogitaiMeisho);
        this.shozokuGogitaiMeisho = shozokuGogitaiMeisho;
    }

    public void setJusho(RString jusho) {
        this.setOriginalData("jusho", jusho);
        this.jusho = jusho;
    }

    // </editor-fold>
}
