package jp.co.ndensan.reams.db.dba.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Apr 22 14:56:45 JST 2014 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * ShisetsuNyutaishoGrid_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class ShisetsuNyutaishoGrid_Row extends DataRow {

    private RString nyushoShoriYMD;
    private RString nyushoYMD;
    private RString taishoShoriYMD;
    private RString taishoYMD;
    private RString jigyoshaShubetsu;
    private RString jigyoshaNo;
    private RString shisetsuMeisho;
    private RString shisetsuKanaMeisho;
    private RString shozaichiJusho;

    public ShisetsuNyutaishoGrid_Row() {
        super();
    }

    public ShisetsuNyutaishoGrid_Row(RString nyushoShoriYMD, RString nyushoYMD, RString taishoShoriYMD, RString taishoYMD, RString jigyoshaShubetsu, RString jigyoshaNo, RString shisetsuMeisho, RString shisetsuKanaMeisho, RString shozaichiJusho) {
        super();
        this.setOriginalData("nyushoShoriYMD", nyushoShoriYMD);
        this.setOriginalData("nyushoYMD", nyushoYMD);
        this.setOriginalData("taishoShoriYMD", taishoShoriYMD);
        this.setOriginalData("taishoYMD", taishoYMD);
        this.setOriginalData("jigyoshaShubetsu", jigyoshaShubetsu);
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.setOriginalData("shisetsuKanaMeisho", shisetsuKanaMeisho);
        this.setOriginalData("shozaichiJusho", shozaichiJusho);
        this.nyushoShoriYMD = nyushoShoriYMD;
        this.nyushoYMD = nyushoYMD;
        this.taishoShoriYMD = taishoShoriYMD;
        this.taishoYMD = taishoYMD;
        this.jigyoshaShubetsu = jigyoshaShubetsu;
        this.jigyoshaNo = jigyoshaNo;
        this.shisetsuMeisho = shisetsuMeisho;
        this.shisetsuKanaMeisho = shisetsuKanaMeisho;
        this.shozaichiJusho = shozaichiJusho;
    }

    public RString getNyushoShoriYMD() {
        return nyushoShoriYMD;
    }

    public RString getNyushoYMD() {
        return nyushoYMD;
    }

    public RString getTaishoShoriYMD() {
        return taishoShoriYMD;
    }

    public RString getTaishoYMD() {
        return taishoYMD;
    }

    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    public RString getShisetsuMeisho() {
        return shisetsuMeisho;
    }

    public RString getShisetsuKanaMeisho() {
        return shisetsuKanaMeisho;
    }

    public RString getShozaichiJusho() {
        return shozaichiJusho;
    }

    public void setNyushoShoriYMD(RString nyushoShoriYMD) {
        this.setOriginalData("nyushoShoriYMD", nyushoShoriYMD);
        this.nyushoShoriYMD = nyushoShoriYMD;
    }

    public void setNyushoYMD(RString nyushoYMD) {
        this.setOriginalData("nyushoYMD", nyushoYMD);
        this.nyushoYMD = nyushoYMD;
    }

    public void setTaishoShoriYMD(RString taishoShoriYMD) {
        this.setOriginalData("taishoShoriYMD", taishoShoriYMD);
        this.taishoShoriYMD = taishoShoriYMD;
    }

    public void setTaishoYMD(RString taishoYMD) {
        this.setOriginalData("taishoYMD", taishoYMD);
        this.taishoYMD = taishoYMD;
    }

    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.setOriginalData("jigyoshaShubetsu", jigyoshaShubetsu);
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    public void setJigyoshaNo(RString jigyoshaNo) {
        this.setOriginalData("jigyoshaNo", jigyoshaNo);
        this.jigyoshaNo = jigyoshaNo;
    }

    public void setShisetsuMeisho(RString shisetsuMeisho) {
        this.setOriginalData("shisetsuMeisho", shisetsuMeisho);
        this.shisetsuMeisho = shisetsuMeisho;
    }

    public void setShisetsuKanaMeisho(RString shisetsuKanaMeisho) {
        this.setOriginalData("shisetsuKanaMeisho", shisetsuKanaMeisho);
        this.shisetsuKanaMeisho = shisetsuKanaMeisho;
    }

    public void setShozaichiJusho(RString shozaichiJusho) {
        this.setOriginalData("shozaichiJusho", shozaichiJusho);
        this.shozaichiJusho = shozaichiJusho;
    }

}