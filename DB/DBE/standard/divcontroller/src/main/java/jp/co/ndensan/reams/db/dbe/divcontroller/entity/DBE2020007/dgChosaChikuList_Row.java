package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020007;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Jul 02 09:26:05 JST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgChosaChikuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgChosaChikuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">

    private RString no;
    private RString chosaChikuCode;
    private RString chosaChikuName;
    private RString chosaChikuAbbreviatedName;

    public dgChosaChikuList_Row() {
        super();
        this.no = RString.EMPTY;
        this.chosaChikuCode = RString.EMPTY;
        this.chosaChikuName = RString.EMPTY;
        this.chosaChikuAbbreviatedName = RString.EMPTY;
    }

    public dgChosaChikuList_Row(RString no, RString chosaChikuCode, RString chosaChikuName, RString chosaChikuAbbreviatedName) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("chosaChikuCode", chosaChikuCode);
        this.setOriginalData("chosaChikuName", chosaChikuName);
        this.setOriginalData("chosaChikuAbbreviatedName", chosaChikuAbbreviatedName);
        this.no = no;
        this.chosaChikuCode = chosaChikuCode;
        this.chosaChikuName = chosaChikuName;
        this.chosaChikuAbbreviatedName = chosaChikuAbbreviatedName;
    }

    public RString getNo() {
        return no;
    }

    public RString getChosaChikuCode() {
        return chosaChikuCode;
    }

    public RString getChosaChikuName() {
        return chosaChikuName;
    }

    public RString getChosaChikuAbbreviatedName() {
        return chosaChikuAbbreviatedName;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setChosaChikuCode(RString chosaChikuCode) {
        this.setOriginalData("chosaChikuCode", chosaChikuCode);
        this.chosaChikuCode = chosaChikuCode;
    }

    public void setChosaChikuName(RString chosaChikuName) {
        this.setOriginalData("chosaChikuName", chosaChikuName);
        this.chosaChikuName = chosaChikuName;
    }

    public void setChosaChikuAbbreviatedName(RString chosaChikuAbbreviatedName) {
        this.setOriginalData("chosaChikuAbbreviatedName", chosaChikuAbbreviatedName);
        this.chosaChikuAbbreviatedName = chosaChikuAbbreviatedName;
    }

    // </editor-fold>
}