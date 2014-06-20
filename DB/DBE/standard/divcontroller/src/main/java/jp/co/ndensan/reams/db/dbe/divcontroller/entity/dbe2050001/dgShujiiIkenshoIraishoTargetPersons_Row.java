package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jun 17 18:15:39 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShujiiIkenshoIraishoTargetPersons_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShujiiIkenshoIraishoTargetPersons_Row extends DataRow {

    private RString iryoKikanNo;
    private RString iryoKikanName;
    private RString shujiiNo;
    private RString shujiiName;
    private RString hihokenshaNo;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiWithKanaShimei;
    private TextBoxFlexibleDate shinseiDate;
    private RString shinseiKubun;
    private TextBoxFlexibleDate sakuseiIraiDate;
    private TextBoxFlexibleDate iraishoHakkoDate;

    public dgShujiiIkenshoIraishoTargetPersons_Row() {
        super();
        this.iryoKikanNo = RString.EMPTY;
        this.iryoKikanName = RString.EMPTY;
        this.shujiiNo = RString.EMPTY;
        this.shujiiName = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.shimeiWithKanaShimei = RString.EMPTY;
        this.shinseiDate = new TextBoxFlexibleDate();
        this.shinseiKubun = RString.EMPTY;
        this.sakuseiIraiDate = new TextBoxFlexibleDate();
        this.iraishoHakkoDate = new TextBoxFlexibleDate();
    }

    public dgShujiiIkenshoIraishoTargetPersons_Row(RString iryoKikanNo, RString iryoKikanName, RString shujiiNo, RString shujiiName, RString hihokenshaNo, RString shimei, RString kanaShimei, RString shimeiWithKanaShimei, TextBoxFlexibleDate shinseiDate, RString shinseiKubun, TextBoxFlexibleDate sakuseiIraiDate, TextBoxFlexibleDate iraishoHakkoDate) {
        super();
        this.setOriginalData("iryoKikanNo", iryoKikanNo);
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.setOriginalData("shujiiNo", shujiiNo);
        this.setOriginalData("shujiiName", shujiiName);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiWithKanaShimei", shimeiWithKanaShimei);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("sakuseiIraiDate", sakuseiIraiDate);
        this.setOriginalData("iraishoHakkoDate", iraishoHakkoDate);
        this.iryoKikanNo = iryoKikanNo;
        this.iryoKikanName = iryoKikanName;
        this.shujiiNo = shujiiNo;
        this.shujiiName = shujiiName;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiWithKanaShimei = shimeiWithKanaShimei;
        this.shinseiDate = shinseiDate;
        this.shinseiKubun = shinseiKubun;
        this.sakuseiIraiDate = sakuseiIraiDate;
        this.iraishoHakkoDate = iraishoHakkoDate;
    }

    public RString getIryoKikanNo() {
        return iryoKikanNo;
    }

    public RString getIryoKikanName() {
        return iryoKikanName;
    }

    public RString getShujiiNo() {
        return shujiiNo;
    }

    public RString getShujiiName() {
        return shujiiName;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiWithKanaShimei() {
        return shimeiWithKanaShimei;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public TextBoxFlexibleDate getSakuseiIraiDate() {
        return sakuseiIraiDate;
    }

    public TextBoxFlexibleDate getIraishoHakkoDate() {
        return iraishoHakkoDate;
    }

    public void setIryoKikanNo(RString iryoKikanNo) {
        this.setOriginalData("iryoKikanNo", iryoKikanNo);
        this.iryoKikanNo = iryoKikanNo;
    }

    public void setIryoKikanName(RString iryoKikanName) {
        this.setOriginalData("iryoKikanName", iryoKikanName);
        this.iryoKikanName = iryoKikanName;
    }

    public void setShujiiNo(RString shujiiNo) {
        this.setOriginalData("shujiiNo", shujiiNo);
        this.shujiiNo = shujiiNo;
    }

    public void setShujiiName(RString shujiiName) {
        this.setOriginalData("shujiiName", shujiiName);
        this.shujiiName = shujiiName;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiWithKanaShimei(RString shimeiWithKanaShimei) {
        this.setOriginalData("shimeiWithKanaShimei", shimeiWithKanaShimei);
        this.shimeiWithKanaShimei = shimeiWithKanaShimei;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setSakuseiIraiDate(TextBoxFlexibleDate sakuseiIraiDate) {
        this.setOriginalData("sakuseiIraiDate", sakuseiIraiDate);
        this.sakuseiIraiDate = sakuseiIraiDate;
    }

    public void setIraishoHakkoDate(TextBoxFlexibleDate iraishoHakkoDate) {
        this.setOriginalData("iraishoHakkoDate", iraishoHakkoDate);
        this.iraishoHakkoDate = iraishoHakkoDate;
    }

}