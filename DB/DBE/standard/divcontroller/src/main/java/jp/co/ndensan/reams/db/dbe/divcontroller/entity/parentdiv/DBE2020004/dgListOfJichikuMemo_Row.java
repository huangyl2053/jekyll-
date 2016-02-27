package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Feb 02 16:04:05 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;


/**
 * dgListOfJichikuMemo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgListOfJichikuMemo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">

    private RString no;
    private Button edit;
    private RString jotai;
    private RString creator;
    private RString importance;
    private RString memo;
    private RString memokubun;
    private RString chikucode;
    private RString memono;

    public dgListOfJichikuMemo_Row() {
        super();
        this.no = RString.EMPTY;
        this.edit = new Button();
        this.jotai = RString.EMPTY;
        this.creator = RString.EMPTY;
        this.importance = RString.EMPTY;
        this.memo = RString.EMPTY;
        this.memokubun = RString.EMPTY;
        this.chikucode = RString.EMPTY;
        this.memono = RString.EMPTY;
        this.setOriginalData("no", no);
        this.setOriginalData("edit", edit);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("creator", creator);
        this.setOriginalData("importance", importance);
        this.setOriginalData("memo", memo);
        this.setOriginalData("memokubun", memokubun);
        this.setOriginalData("chikucode", chikucode);
        this.setOriginalData("memono", memono);
    }

    public dgListOfJichikuMemo_Row(RString no, Button edit, RString jotai, RString creator, RString importance, RString memo, RString memokubun, RString chikucode, RString memono) {
        super();
        this.setOriginalData("no", no);
        this.setOriginalData("edit", edit);
        this.setOriginalData("jotai", jotai);
        this.setOriginalData("creator", creator);
        this.setOriginalData("importance", importance);
        this.setOriginalData("memo", memo);
        this.setOriginalData("memokubun", memokubun);
        this.setOriginalData("chikucode", chikucode);
        this.setOriginalData("memono", memono);
        this.no = no;
        this.edit = edit;
        this.jotai = jotai;
        this.creator = creator;
        this.importance = importance;
        this.memo = memo;
        this.memokubun = memokubun;
        this.chikucode = chikucode;
        this.memono = memono;
    }

    public RString getNo() {
        return no;
    }

    public Button getEdit() {
        return edit;
    }

    public RString getJotai() {
        return jotai;
    }

    public RString getCreator() {
        return creator;
    }

    public RString getImportance() {
        return importance;
    }

    public RString getMemo() {
        return memo;
    }

    public RString getMemokubun() {
        return memokubun;
    }

    public RString getChikucode() {
        return chikucode;
    }

    public RString getMemono() {
        return memono;
    }

    public void setNo(RString no) {
        this.setOriginalData("no", no);
        this.no = no;
    }

    public void setEdit(Button edit) {
        this.setOriginalData("edit", edit);
        this.edit = edit;
    }

    public void setJotai(RString jotai) {
        this.setOriginalData("jotai", jotai);
        this.jotai = jotai;
    }

    public void setCreator(RString creator) {
        this.setOriginalData("creator", creator);
        this.creator = creator;
    }

    public void setImportance(RString importance) {
        this.setOriginalData("importance", importance);
        this.importance = importance;
    }

    public void setMemo(RString memo) {
        this.setOriginalData("memo", memo);
        this.memo = memo;
    }

    public void setMemokubun(RString memokubun) {
        this.setOriginalData("memokubun", memokubun);
        this.memokubun = memokubun;
    }

    public void setChikucode(RString chikucode) {
        this.setOriginalData("chikucode", chikucode);
        this.chikucode = chikucode;
    }

    public void setMemono(RString memono) {
        this.setOriginalData("memono", memono);
        this.memono = memono;
    }

    // </editor-fold>
}
