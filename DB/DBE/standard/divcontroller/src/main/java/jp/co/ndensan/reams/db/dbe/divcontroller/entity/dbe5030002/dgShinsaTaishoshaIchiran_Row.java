package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Jun 27 19:30:44 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShinsaTaishoshaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShinsaTaishoshaIchiran_Row extends DataRow {

    private Button select;
    private RString shinsaJun;
    private RString hokenshaNo;
    private RString shichoson;
    private RString hihokenshaNo;
    private RString shimei;
    private RString kanaShimei;
    private RString sex;
    private TextBoxFlexibleDate shinseibi;
    private RString beforeYokaigodo;
    private RString beforeYukoKikan;
    private TextBoxFlexibleDate beforeYukoStartDate;
    private TextBoxFlexibleDate beforeYukoEndDate;
    private RString ichijiHantei;
    private RString ninteiResult;
    private RString yukoKikan;
    private TextBoxFlexibleDate yukoStartDate;
    private TextBoxFlexibleDate yukoEndDate;
    private RString shinseiKubun;
    private RString seinengappi;
    private RString nenrei;
    private RString ninteiResultItem;
    private RString yukoKikanItem;
    private RString shinsakaiIken;

    public dgShinsaTaishoshaIchiran_Row() {
        super();
        this.select = new Button();
        this.shinsaJun = RString.EMPTY;
        this.hokenshaNo = RString.EMPTY;
        this.shichoson = RString.EMPTY;
        this.hihokenshaNo = RString.EMPTY;
        this.shimei = RString.EMPTY;
        this.kanaShimei = RString.EMPTY;
        this.sex = RString.EMPTY;
        this.shinseibi = new TextBoxFlexibleDate();
        this.beforeYokaigodo = RString.EMPTY;
        this.beforeYukoKikan = RString.EMPTY;
        this.beforeYukoStartDate = new TextBoxFlexibleDate();
        this.beforeYukoEndDate = new TextBoxFlexibleDate();
        this.ichijiHantei = RString.EMPTY;
        this.ninteiResult = RString.EMPTY;
        this.yukoKikan = RString.EMPTY;
        this.yukoStartDate = new TextBoxFlexibleDate();
        this.yukoEndDate = new TextBoxFlexibleDate();
        this.shinseiKubun = RString.EMPTY;
        this.seinengappi = RString.EMPTY;
        this.nenrei = RString.EMPTY;
        this.ninteiResultItem = RString.EMPTY;
        this.yukoKikanItem = RString.EMPTY;
        this.shinsakaiIken = RString.EMPTY;
    }

    public dgShinsaTaishoshaIchiran_Row(Button select, RString shinsaJun, RString hokenshaNo, RString shichoson, RString hihokenshaNo, RString shimei, RString kanaShimei, RString sex, TextBoxFlexibleDate shinseibi, RString beforeYokaigodo, RString beforeYukoKikan, TextBoxFlexibleDate beforeYukoStartDate, TextBoxFlexibleDate beforeYukoEndDate, RString ichijiHantei, RString ninteiResult, RString yukoKikan, TextBoxFlexibleDate yukoStartDate, TextBoxFlexibleDate yukoEndDate, RString shinseiKubun, RString seinengappi, RString nenrei, RString ninteiResultItem, RString yukoKikanItem, RString shinsakaiIken) {
        super();
        this.setOriginalData("select", select);
        this.setOriginalData("shinsaJun", shinsaJun);
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.setOriginalData("shichoson", shichoson);
        this.setOriginalData("hihokenshaNo", hihokenshaNo);
        this.setOriginalData("shimei", shimei);
        this.setOriginalData("kanaShimei", kanaShimei);
        this.setOriginalData("sex", sex);
        this.setOriginalData("shinseibi", shinseibi);
        this.setOriginalData("beforeYokaigodo", beforeYokaigodo);
        this.setOriginalData("beforeYukoKikan", beforeYukoKikan);
        this.setOriginalData("beforeYukoStartDate", beforeYukoStartDate);
        this.setOriginalData("beforeYukoEndDate", beforeYukoEndDate);
        this.setOriginalData("ichijiHantei", ichijiHantei);
        this.setOriginalData("ninteiResult", ninteiResult);
        this.setOriginalData("yukoKikan", yukoKikan);
        this.setOriginalData("yukoStartDate", yukoStartDate);
        this.setOriginalData("yukoEndDate", yukoEndDate);
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.setOriginalData("seinengappi", seinengappi);
        this.setOriginalData("nenrei", nenrei);
        this.setOriginalData("ninteiResultItem", ninteiResultItem);
        this.setOriginalData("yukoKikanItem", yukoKikanItem);
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.select = select;
        this.shinsaJun = shinsaJun;
        this.hokenshaNo = hokenshaNo;
        this.shichoson = shichoson;
        this.hihokenshaNo = hihokenshaNo;
        this.shimei = shimei;
        this.kanaShimei = kanaShimei;
        this.sex = sex;
        this.shinseibi = shinseibi;
        this.beforeYokaigodo = beforeYokaigodo;
        this.beforeYukoKikan = beforeYukoKikan;
        this.beforeYukoStartDate = beforeYukoStartDate;
        this.beforeYukoEndDate = beforeYukoEndDate;
        this.ichijiHantei = ichijiHantei;
        this.ninteiResult = ninteiResult;
        this.yukoKikan = yukoKikan;
        this.yukoStartDate = yukoStartDate;
        this.yukoEndDate = yukoEndDate;
        this.shinseiKubun = shinseiKubun;
        this.seinengappi = seinengappi;
        this.nenrei = nenrei;
        this.ninteiResultItem = ninteiResultItem;
        this.yukoKikanItem = yukoKikanItem;
        this.shinsakaiIken = shinsakaiIken;
    }

    public Button getSelect() {
        return select;
    }

    public RString getShinsaJun() {
        return shinsaJun;
    }

    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    public RString getShichoson() {
        return shichoson;
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

    public RString getSex() {
        return sex;
    }

    public TextBoxFlexibleDate getShinseibi() {
        return shinseibi;
    }

    public RString getBeforeYokaigodo() {
        return beforeYokaigodo;
    }

    public RString getBeforeYukoKikan() {
        return beforeYukoKikan;
    }

    public TextBoxFlexibleDate getBeforeYukoStartDate() {
        return beforeYukoStartDate;
    }

    public TextBoxFlexibleDate getBeforeYukoEndDate() {
        return beforeYukoEndDate;
    }

    public RString getIchijiHantei() {
        return ichijiHantei;
    }

    public RString getNinteiResult() {
        return ninteiResult;
    }

    public RString getYukoKikan() {
        return yukoKikan;
    }

    public TextBoxFlexibleDate getYukoStartDate() {
        return yukoStartDate;
    }

    public TextBoxFlexibleDate getYukoEndDate() {
        return yukoEndDate;
    }

    public RString getShinseiKubun() {
        return shinseiKubun;
    }

    public RString getSeinengappi() {
        return seinengappi;
    }

    public RString getNenrei() {
        return nenrei;
    }

    public RString getNinteiResultItem() {
        return ninteiResultItem;
    }

    public RString getYukoKikanItem() {
        return yukoKikanItem;
    }

    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    public void setSelect(Button select) {
        this.setOriginalData("select", select);
        this.select = select;
    }

    public void setShinsaJun(RString shinsaJun) {
        this.setOriginalData("shinsaJun", shinsaJun);
        this.shinsaJun = shinsaJun;
    }

    public void setHokenshaNo(RString hokenshaNo) {
        this.setOriginalData("hokenshaNo", hokenshaNo);
        this.hokenshaNo = hokenshaNo;
    }

    public void setShichoson(RString shichoson) {
        this.setOriginalData("shichoson", shichoson);
        this.shichoson = shichoson;
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

    public void setSex(RString sex) {
        this.setOriginalData("sex", sex);
        this.sex = sex;
    }

    public void setShinseibi(TextBoxFlexibleDate shinseibi) {
        this.setOriginalData("shinseibi", shinseibi);
        this.shinseibi = shinseibi;
    }

    public void setBeforeYokaigodo(RString beforeYokaigodo) {
        this.setOriginalData("beforeYokaigodo", beforeYokaigodo);
        this.beforeYokaigodo = beforeYokaigodo;
    }

    public void setBeforeYukoKikan(RString beforeYukoKikan) {
        this.setOriginalData("beforeYukoKikan", beforeYukoKikan);
        this.beforeYukoKikan = beforeYukoKikan;
    }

    public void setBeforeYukoStartDate(TextBoxFlexibleDate beforeYukoStartDate) {
        this.setOriginalData("beforeYukoStartDate", beforeYukoStartDate);
        this.beforeYukoStartDate = beforeYukoStartDate;
    }

    public void setBeforeYukoEndDate(TextBoxFlexibleDate beforeYukoEndDate) {
        this.setOriginalData("beforeYukoEndDate", beforeYukoEndDate);
        this.beforeYukoEndDate = beforeYukoEndDate;
    }

    public void setIchijiHantei(RString ichijiHantei) {
        this.setOriginalData("ichijiHantei", ichijiHantei);
        this.ichijiHantei = ichijiHantei;
    }

    public void setNinteiResult(RString ninteiResult) {
        this.setOriginalData("ninteiResult", ninteiResult);
        this.ninteiResult = ninteiResult;
    }

    public void setYukoKikan(RString yukoKikan) {
        this.setOriginalData("yukoKikan", yukoKikan);
        this.yukoKikan = yukoKikan;
    }

    public void setYukoStartDate(TextBoxFlexibleDate yukoStartDate) {
        this.setOriginalData("yukoStartDate", yukoStartDate);
        this.yukoStartDate = yukoStartDate;
    }

    public void setYukoEndDate(TextBoxFlexibleDate yukoEndDate) {
        this.setOriginalData("yukoEndDate", yukoEndDate);
        this.yukoEndDate = yukoEndDate;
    }

    public void setShinseiKubun(RString shinseiKubun) {
        this.setOriginalData("shinseiKubun", shinseiKubun);
        this.shinseiKubun = shinseiKubun;
    }

    public void setSeinengappi(RString seinengappi) {
        this.setOriginalData("seinengappi", seinengappi);
        this.seinengappi = seinengappi;
    }

    public void setNenrei(RString nenrei) {
        this.setOriginalData("nenrei", nenrei);
        this.nenrei = nenrei;
    }

    public void setNinteiResultItem(RString ninteiResultItem) {
        this.setOriginalData("ninteiResultItem", ninteiResultItem);
        this.ninteiResultItem = ninteiResultItem;
    }

    public void setYukoKikanItem(RString yukoKikanItem) {
        this.setOriginalData("yukoKikanItem", yukoKikanItem);
        this.yukoKikanItem = yukoKikanItem;
    }

    public void setShinsakaiIken(RString shinsakaiIken) {
        this.setOriginalData("shinsakaiIken", shinsakaiIken);
        this.shinsakaiIken = shinsakaiIken;
    }

}