package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 26 17:31:39 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsakaiTargetPersons_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsakaiTargetPersons_Row extends DataRow {

    private RString shinsaOrder;
    private RString hokenshaNo;
    private RString hokenshaMeisho;
    private RString hihokenshaNo;
    private RString hihokenshaKubun;
    private RString shimei;
    private RString kanaShimei;
    private RString shimeiAndKanaShimsei;
    private RString gender;
    private TextBoxFlexibleDate shinseiDate;
    private RString shinseiKubun;
    private RString ichijiHanteiResult;
    private RString yokaigodo;
    private RString yukokikan;
    private TextBoxFlexibleDate startDate;
    private TextBoxFlexibleDate endDate;
    private RString latestYokaigodo;
    private RString latestYukokikan;
    private TextBoxFlexibleDate latestStartDate;
    private TextBoxFlexibleDate latestEndDate;

    public dgShinsakaiTargetPersons_Row() {
        super();
    }

    public dgShinsakaiTargetPersons_Row(RString shinsaOrder, RString hokenshaNo, RString hokenshaMeisho, RString hihokenshaNo, RString hihokenshaKubun, RString shimei, RString kanaShimei, RString shimeiAndKanaShimsei, RString gender, TextBoxFlexibleDate shinseiDate, RString shinseiKubun, RString ichijiHanteiResult, RString yokaigodo, RString yukokikan, TextBoxFlexibleDate startDate, TextBoxFlexibleDate endDate, RString latestYokaigodo, RString latestYukokikan, TextBoxFlexibleDate latestStartDate, TextBoxFlexibleDate latestEndDate) {
        super();
        this.setOriginalData("shinsaOrder", shinsaOrder);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("shimeiAndKanaShimsei", shimeiAndKanaShimsei);
        this.setOriginalData("gender", gender);
        this.setOriginalData("shinseiDate", shinseiDate);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("ichijiHanteiResult", ichijiHanteiResult);
        this.setOriginalData("yokaigodo", yokaigodo);
        this.setOriginalData("yukokikan", yukokikan);
        this.setOriginalData("startDate", startDate);
        this.setOriginalData("endDate", endDate);
        this.setOriginalData("latestYokaigodo", latestYokaigodo);
        this.setOriginalData("latestYukokikan", latestYukokikan);
        this.setOriginalData("latestStartDate", latestStartDate);
        this.setOriginalData("latestEndDate", latestEndDate);
        this.shinsaOrder = shinsaOrder;
        this.hokenshaNo = hokenshaNo;
        this.hokenshaMeisho = hokenshaMeisho;
        this.hihokenshaNo = hihokenshaNo;
        this.hihokenshaKubun = hihokenshaKubun;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.shimeiAndKanaShimsei = shimeiAndKanaShimsei;
        this.gender = gender;
        this.shinseiDate = shinseiDate;
        this.shinseiKubun = shinseiKubun;
        this.ichijiHanteiResult = ichijiHanteiResult;
        this.yokaigodo = yokaigodo;
        this.yukokikan = yukokikan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.latestYokaigodo = latestYokaigodo;
        this.latestYukokikan = latestYukokikan;
        this.latestStartDate = latestStartDate;
        this.latestEndDate = latestEndDate;
    }

    public RString getShinsaOrder() {
        return shinsaOrder;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getHokenshaMeisho() {
        return hokenshaMeisho;
    }

    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    public RString getHihokenshaKubun() {
        return hihokenshaKubun;
    }

    public RString getShimei() {
        return shimei;
    }

    public RString getKanaShimei() {
        return kanaShimei;
    }

    public RString getShimeiAndKanaShimsei() {
        return shimeiAndKanaShimsei;
    }

    public RString getGender() {
        return gender;
    }

    public TextBoxFlexibleDate getShinseiDate() {
        return shinseiDate;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public RString getIchijiHanteiResult() {
        return ichijiHanteiResult;
    }

    public RString getYokaigodo() {
        return yokaigodo;
    }

    public RString getYukokikan() {
        return yukokikan;
    }

    public TextBoxFlexibleDate getStartDate() {
        return startDate;
    }

    public TextBoxFlexibleDate getEndDate() {
        return endDate;
    }

    public RString getLatestYokaigodo() {
        return latestYokaigodo;
    }

    public RString getLatestYukokikan() {
        return latestYukokikan;
    }

    public TextBoxFlexibleDate getLatestStartDate() {
        return latestStartDate;
    }

    public TextBoxFlexibleDate getLatestEndDate() {
        return latestEndDate;
    }

    public void setShinsaOrder(RString shinsaOrder) {
        this.setOriginalData("shinsaOrder", shinsaOrder);
        this.shinsaOrder = shinsaOrder;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setHokenshaMeisho(RString hokenshaMeisho) {
        this.setOriginalData("hokenshaMeisho", hokenshaMeisho);
        this.hokenshaMeisho = hokenshaMeisho;
    }

    public void setHihokenshaNo(RString hihokenshaNo) {
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.hihokenshaNo = hihokenshaNo;
    }

    public void setHihokenshaKubun(RString hihokenshaKubun) {
        this.setOriginalData("hihokenshaKubun", hihokenshaKubun);
        this.hihokenshaKubun = hihokenshaKubun;
    }

    public void setShimei(RString shimei) {
        this.setOriginalData("shimei", shimei);
        this.shimei = shimei;
    }

    public void setKanaShimei(RString kanaShimei) {
        this.setOriginalData("kanaShimei", kanaShimei);
        this.kanaShimei = kanaShimei;
    }

    public void setShimeiAndKanaShimsei(RString shimeiAndKanaShimsei) {
        this.setOriginalData("shimeiAndKanaShimsei", shimeiAndKanaShimsei);
        this.shimeiAndKanaShimsei = shimeiAndKanaShimsei;
    }

    public void setGender(RString gender) {
        this.setOriginalData("gender", gender);
        this.gender = gender;
    }

    public void setShinseiDate(TextBoxFlexibleDate shinseiDate) {
        this.setOriginalData("shinseiDate", shinseiDate);
        this.shinseiDate = shinseiDate;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setIchijiHanteiResult(RString ichijiHanteiResult) {
        this.setOriginalData("ichijiHanteiResult", ichijiHanteiResult);
        this.ichijiHanteiResult = ichijiHanteiResult;
    }

    public void setYokaigodo(RString yokaigodo) {
        this.setOriginalData("yokaigodo", yokaigodo);
        this.yokaigodo = yokaigodo;
    }

    public void setYukokikan(RString yukokikan) {
        this.setOriginalData("yukokikan", yukokikan);
        this.yukokikan = yukokikan;
    }

    public void setStartDate(TextBoxFlexibleDate startDate) {
        this.setOriginalData("startDate", startDate);
        this.startDate = startDate;
    }

    public void setEndDate(TextBoxFlexibleDate endDate) {
        this.setOriginalData("endDate", endDate);
        this.endDate = endDate;
    }

    public void setLatestYokaigodo(RString latestYokaigodo) {
        this.setOriginalData("latestYokaigodo", latestYokaigodo);
        this.latestYokaigodo = latestYokaigodo;
    }

    public void setLatestYukokikan(RString latestYukokikan) {
        this.setOriginalData("latestYukokikan", latestYukokikan);
        this.latestYukokikan = latestYukokikan;
    }

    public void setLatestStartDate(TextBoxFlexibleDate latestStartDate) {
        this.setOriginalData("latestStartDate", latestStartDate);
        this.latestStartDate = latestStartDate;
    }

    public void setLatestEndDate(TextBoxFlexibleDate latestEndDate) {
        this.setOriginalData("latestEndDate", latestEndDate);
        this.latestEndDate = latestEndDate;
    }

}