package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.YokaigodoGuide.YokaigodoGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Mar 22 20:11:04 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgYokaigodoGuide_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgYokaigodoGuide_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">

    private RString code;
    private RString meisho;

    public dgYokaigodoGuide_Row() {
        super();
        this.code = RString.EMPTY;
        this.meisho = RString.EMPTY;
        this.setOriginalData("code", code);
        this.setOriginalData("meisho", meisho);
    }

    public dgYokaigodoGuide_Row(RString code, RString meisho) {
        super();
        this.setOriginalData("code", code);
        this.setOriginalData("meisho", meisho);
        this.code = code;
        this.meisho = meisho;
    }

    public RString getCode() {
        return code;
    }

    public RString getMeisho() {
        return meisho;
    }

    public void setCode(RString code) {
        this.setOriginalData("code", code);
        this.code = code;
    }

    public void setMeisho(RString meisho) {
        this.setOriginalData("meisho", meisho);
        this.meisho = meisho;
    }

    // </editor-fold>
}
