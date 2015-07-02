package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020008;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 02 10:32:14 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaChikuGroupChosaChikuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaChikuGroupChosaChikuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">

    private RString yusenNo;
    private RString chosaChikuCode;
    private RString chosaChikuName;
    private RString chosaChikuGroupCode;
    private RString chosaChikuGroupName;

    public dgChosaChikuGroupChosaChikuList_Row() {
        super();
        this.yusenNo = RString.EMPTY;
        this.chosaChikuCode = RString.EMPTY;
        this.chosaChikuName = RString.EMPTY;
        this.chosaChikuGroupCode = RString.EMPTY;
        this.chosaChikuGroupName = RString.EMPTY;
    }

    public dgChosaChikuGroupChosaChikuList_Row(RString yusenNo, RString chosaChikuCode, RString chosaChikuName, RString chosaChikuGroupCode, RString chosaChikuGroupName) {
        super();
        this.setOriginalData("yusenNo", yusenNo);
        this.setOriginalData("chosaChikuCode", chosaChikuCode);
        this.setOriginalData("chosaChikuName", chosaChikuName);
        this.setOriginalData("chosaChikuGroupCode", chosaChikuGroupCode);
        this.setOriginalData("chosaChikuGroupName", chosaChikuGroupName);
        this.yusenNo = yusenNo;
        this.chosaChikuCode = chosaChikuCode;
        this.chosaChikuName = chosaChikuName;
        this.chosaChikuGroupCode = chosaChikuGroupCode;
        this.chosaChikuGroupName = chosaChikuGroupName;
    }

    public RString getYusenNo() {
        return yusenNo;
    }

    public RString getChosaChikuCode() {
        return chosaChikuCode;
    }

    public RString getChosaChikuName() {
        return chosaChikuName;
    }

    public RString getChosaChikuGroupCode() {
        return chosaChikuGroupCode;
    }

    public RString getChosaChikuGroupName() {
        return chosaChikuGroupName;
    }

    public void setYusenNo(RString yusenNo) {
        this.setOriginalData("yusenNo", yusenNo);
        this.yusenNo = yusenNo;
    }

    public void setChosaChikuCode(RString chosaChikuCode) {
        this.setOriginalData("chosaChikuCode", chosaChikuCode);
        this.chosaChikuCode = chosaChikuCode;
    }

    public void setChosaChikuName(RString chosaChikuName) {
        this.setOriginalData("chosaChikuName", chosaChikuName);
        this.chosaChikuName = chosaChikuName;
    }

    public void setChosaChikuGroupCode(RString chosaChikuGroupCode) {
        this.setOriginalData("chosaChikuGroupCode", chosaChikuGroupCode);
        this.chosaChikuGroupCode = chosaChikuGroupCode;
    }

    public void setChosaChikuGroupName(RString chosaChikuGroupName) {
        this.setOriginalData("chosaChikuGroupName", chosaChikuGroupName);
        this.chosaChikuGroupName = chosaChikuGroupName;
    }

    // </editor-fold>
}