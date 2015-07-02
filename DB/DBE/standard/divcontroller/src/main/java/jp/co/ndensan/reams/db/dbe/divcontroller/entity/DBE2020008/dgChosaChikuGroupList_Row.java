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
 * dgChosaChikuGroupList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaChikuGroupList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">

    private RString no;
    private RString chosaChikuGroupCode;
    private RString chosaChikuGroupName;

    public dgChosaChikuGroupList_Row() {
        super();
        this.no = RString.EMPTY;
        this.chosaChikuGroupCode = RString.EMPTY;
        this.chosaChikuGroupName = RString.EMPTY;
    }

    public dgChosaChikuGroupList_Row(RString no, RString chosaChikuGroupCode, RString chosaChikuGroupName) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("chosaChikuGroupCode", chosaChikuGroupCode);
        this.setOriginalData("chosaChikuGroupName", chosaChikuGroupName);
        this.no = no;
        this.chosaChikuGroupCode = chosaChikuGroupCode;
        this.chosaChikuGroupName = chosaChikuGroupName;
    }

    public RString getNo() {
        return no;
    }

    public RString getChosaChikuGroupCode() {
        return chosaChikuGroupCode;
    }

    public RString getChosaChikuGroupName() {
        return chosaChikuGroupName;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
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