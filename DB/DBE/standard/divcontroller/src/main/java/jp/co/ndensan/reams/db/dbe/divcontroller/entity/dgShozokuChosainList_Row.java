package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon May 26 17:07:13 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShozokuChosainList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShozokuChosainList_Row extends DataRow {

    private RString chosainNo;
    private RString chosainName;
    private RString waritsukeNum;
    private RString chiku;
    private RString chousaItakusakiNo;

    public dgShozokuChosainList_Row() {
        super();
    }

    public dgShozokuChosainList_Row(RString chosainNo, RString chosainName, RString waritsukeNum, RString chiku, RString chousaItakusakiNo) {
        super();
        this.setOriginalData("chosainNo", chosainNo);
        this.setOriginalData("chosainName", chosainName);
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.setOriginalData("chiku", chiku);
        this.setOriginalData("chousaItakusakiNo", chousaItakusakiNo);
        this.chosainNo = chosainNo;
        this.chosainName = chosainName;
        this.waritsukeNum = waritsukeNum;
        this.chiku = chiku;
        this.chousaItakusakiNo = chousaItakusakiNo;
    }

    public RString getChosainNo() {
        return chosainNo;
    }

    public RString getChosainName() {
        return chosainName;
    }

    public RString getWaritsukeNum() {
        return waritsukeNum;
    }

    public RString getChiku() {
        return chiku;
    }

    public RString getChousaItakusakiNo() {
        return chousaItakusakiNo;
    }

    public void setChosainNo(RString chosainNo) {
        this.setOriginalData("chosainNo", chosainNo);
        this.chosainNo = chosainNo;
    }

    public void setChosainName(RString chosainName) {
        this.setOriginalData("chosainName", chosainName);
        this.chosainName = chosainName;
    }

    public void setWaritsukeNum(RString waritsukeNum) {
        this.setOriginalData("waritsukeNum", waritsukeNum);
        this.waritsukeNum = waritsukeNum;
    }

    public void setChiku(RString chiku) {
        this.setOriginalData("chiku", chiku);
        this.chiku = chiku;
    }

    public void setChousaItakusakiNo(RString chousaItakusakiNo) {
        this.setOriginalData("chousaItakusakiNo", chousaItakusakiNo);
        this.chousaItakusakiNo = chousaItakusakiNo;
    }

}