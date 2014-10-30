package jp.co.ndensan.reams.db.dbz.divcontroller.entity.reportview;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 02 17:48:29 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgReportView_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgReportView_Row extends DataRow {

    private RString errorCode;
    private RString errorCase;
    private RString key;
    private RString subGyomuCode;
    private RString executeDivId;
    private RString item1;
    private RString item2;
    private RString item3;
    private RString item4;
    private RString item5;

    public dgReportView_Row() {
        super();
        this.errorCode = RString.EMPTY;
        this.errorCase = RString.EMPTY;
        this.key = RString.EMPTY;
        this.subGyomuCode = RString.EMPTY;
        this.executeDivId = RString.EMPTY;
        this.item1 = RString.EMPTY;
        this.item2 = RString.EMPTY;
        this.item3 = RString.EMPTY;
        this.item4 = RString.EMPTY;
        this.item5 = RString.EMPTY;
    }

    public dgReportView_Row(RString errorCode, RString errorCase, RString key, RString subGyomuCode, RString executeDivId, RString item1, RString item2, RString item3, RString item4, RString item5) {
        super();
        this.setOriginalData("errorCode", errorCode);
        this.setOriginalData("errorCase", errorCase);
        this.setOriginalData("key", key);
        this.setOriginalData("subGyomuCode", subGyomuCode);
        this.setOriginalData("executeDivId", executeDivId);
        this.setOriginalData("item1", item1);
        this.setOriginalData("item2", item2);
        this.setOriginalData("item3", item3);
        this.setOriginalData("item4", item4);
        this.setOriginalData("item5", item5);
        this.errorCode = errorCode;
        this.errorCase = errorCase;
        this.key = key;
        this.subGyomuCode = subGyomuCode;
        this.executeDivId = executeDivId;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
    }

    public RString getErrorCode() {
        return errorCode;
    }

    public RString getErrorCase() {
        return errorCase;
    }

    public RString getKey() {
        return key;
    }

    public RString getSubGyomuCode() {
        return subGyomuCode;
    }

    public RString getExecuteDivId() {
        return executeDivId;
    }

    public RString getItem1() {
        return item1;
    }

    public RString getItem2() {
        return item2;
    }

    public RString getItem3() {
        return item3;
    }

    public RString getItem4() {
        return item4;
    }

    public RString getItem5() {
        return item5;
    }

    public void setErrorCode(RString errorCode) {
        this.setOriginalData("errorCode", errorCode);
        this.errorCode = errorCode;
    }

    public void setErrorCase(RString errorCase) {
        this.setOriginalData("errorCase", errorCase);
        this.errorCase = errorCase;
    }

    public void setKey(RString key) {
        this.setOriginalData("key", key);
        this.key = key;
    }

    public void setSubGyomuCode(RString subGyomuCode) {
        this.setOriginalData("subGyomuCode", subGyomuCode);
        this.subGyomuCode = subGyomuCode;
    }

    public void setExecuteDivId(RString executeDivId) {
        this.setOriginalData("executeDivId", executeDivId);
        this.executeDivId = executeDivId;
    }

    public void setItem1(RString item1) {
        this.setOriginalData("item1", item1);
        this.item1 = item1;
    }

    public void setItem2(RString item2) {
        this.setOriginalData("item2", item2);
        this.item2 = item2;
    }

    public void setItem3(RString item3) {
        this.setOriginalData("item3", item3);
        this.item3 = item3;
    }

    public void setItem4(RString item4) {
        this.setOriginalData("item4", item4);
        this.item4 = item4;
    }

    public void setItem5(RString item5) {
        this.setOriginalData("item5", item5);
        this.item5 = item5;
    }

}