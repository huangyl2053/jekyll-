package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 16 19:04:00 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgFutanWariai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgFutanWariai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString shikaku;
    private RString futanWariai;
    private TextBoxDate tekiyoKaishibi;
    private TextBoxDate tekiyoShuryobi;
    private TextBoxNum gokeiShotoku;
    private TextBoxNum setaiinsu;
    private TextBoxNum nenkinShunyuGokei;
    private TextBoxNum sonotaGokeiShotoku;
    private RString biko;
    private Boolean logicalDeletedFlag;
    private RString nendo;
    private RString rirekiNo;
    private RString edaNo;
    private RString shikakuCode;
    private RString futanWariaiCode;

    public dgFutanWariai_Row() {
        super();
        this.shikaku = RString.EMPTY;
        this.futanWariai = RString.EMPTY;
        this.tekiyoKaishibi = new TextBoxDate();
        this.tekiyoShuryobi = new TextBoxDate();
        this.gokeiShotoku = new TextBoxNum();
        this.setaiinsu = new TextBoxNum();
        this.nenkinShunyuGokei = new TextBoxNum();
        this.sonotaGokeiShotoku = new TextBoxNum();
        this.biko = RString.EMPTY;
        this.logicalDeletedFlag = false;
        this.nendo = RString.EMPTY;
        this.rirekiNo = RString.EMPTY;
        this.edaNo = RString.EMPTY;
        this.shikakuCode = RString.EMPTY;
        this.futanWariaiCode = RString.EMPTY;
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("futanWariai", futanWariai);
        this.setOriginalData("tekiyoKaishibi", tekiyoKaishibi);
        this.setOriginalData("tekiyoShuryobi", tekiyoShuryobi);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("setaiinsu", setaiinsu);
        this.setOriginalData("nenkinShunyuGokei", nenkinShunyuGokei);
        this.setOriginalData("sonotaGokeiShotoku", sonotaGokeiShotoku);
        this.setOriginalData("biko", biko);
        this.setOriginalData("logicalDeletedFlag", logicalDeletedFlag);
        this.setOriginalData("nendo", nendo);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("shikakuCode", shikakuCode);
        this.setOriginalData("futanWariaiCode", futanWariaiCode);
    }

    public dgFutanWariai_Row(RString shikaku, RString futanWariai, TextBoxDate tekiyoKaishibi, TextBoxDate tekiyoShuryobi, TextBoxNum gokeiShotoku, TextBoxNum setaiinsu, TextBoxNum nenkinShunyuGokei, TextBoxNum sonotaGokeiShotoku, RString biko, Boolean logicalDeletedFlag, RString nendo, RString rirekiNo, RString edaNo, RString shikakuCode, RString futanWariaiCode) {
        super();
        this.setOriginalData("shikaku", shikaku);
        this.setOriginalData("futanWariai", futanWariai);
        this.setOriginalData("tekiyoKaishibi", tekiyoKaishibi);
        this.setOriginalData("tekiyoShuryobi", tekiyoShuryobi);
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.setOriginalData("setaiinsu", setaiinsu);
        this.setOriginalData("nenkinShunyuGokei", nenkinShunyuGokei);
        this.setOriginalData("sonotaGokeiShotoku", sonotaGokeiShotoku);
        this.setOriginalData("biko", biko);
        this.setOriginalData("logicalDeletedFlag", logicalDeletedFlag);
        this.setOriginalData("nendo", nendo);
        this.setOriginalData("rirekiNo", rirekiNo);
        this.setOriginalData("edaNo", edaNo);
        this.setOriginalData("shikakuCode", shikakuCode);
        this.setOriginalData("futanWariaiCode", futanWariaiCode);
        this.shikaku = shikaku;
        this.futanWariai = futanWariai;
        this.tekiyoKaishibi = tekiyoKaishibi;
        this.tekiyoShuryobi = tekiyoShuryobi;
        this.gokeiShotoku = gokeiShotoku;
        this.setaiinsu = setaiinsu;
        this.nenkinShunyuGokei = nenkinShunyuGokei;
        this.sonotaGokeiShotoku = sonotaGokeiShotoku;
        this.biko = biko;
        this.logicalDeletedFlag = logicalDeletedFlag;
        this.nendo = nendo;
        this.rirekiNo = rirekiNo;
        this.edaNo = edaNo;
        this.shikakuCode = shikakuCode;
        this.futanWariaiCode = futanWariaiCode;
    }

    public RString getShikaku() {
        return shikaku;
    }

    public RString getFutanWariai() {
        return futanWariai;
    }

    public TextBoxDate getTekiyoKaishibi() {
        return tekiyoKaishibi;
    }

    public TextBoxDate getTekiyoShuryobi() {
        return tekiyoShuryobi;
    }

    public TextBoxNum getGokeiShotoku() {
        return gokeiShotoku;
    }

    public TextBoxNum getSetaiinsu() {
        return setaiinsu;
    }

    public TextBoxNum getNenkinShunyuGokei() {
        return nenkinShunyuGokei;
    }

    public TextBoxNum getSonotaGokeiShotoku() {
        return sonotaGokeiShotoku;
    }

    public RString getBiko() {
        return biko;
    }

    public Boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    public RString getNendo() {
        return nendo;
    }

    public RString getRirekiNo() {
        return rirekiNo;
    }

    public RString getEdaNo() {
        return edaNo;
    }

    public RString getShikakuCode() {
        return shikakuCode;
    }

    public RString getFutanWariaiCode() {
        return futanWariaiCode;
    }

    public void setShikaku(RString shikaku) {
        this.setOriginalData("shikaku", shikaku);
        this.shikaku = shikaku;
    }

    public void setFutanWariai(RString futanWariai) {
        this.setOriginalData("futanWariai", futanWariai);
        this.futanWariai = futanWariai;
    }

    public void setTekiyoKaishibi(TextBoxDate tekiyoKaishibi) {
        this.setOriginalData("tekiyoKaishibi", tekiyoKaishibi);
        this.tekiyoKaishibi = tekiyoKaishibi;
    }

    public void setTekiyoShuryobi(TextBoxDate tekiyoShuryobi) {
        this.setOriginalData("tekiyoShuryobi", tekiyoShuryobi);
        this.tekiyoShuryobi = tekiyoShuryobi;
    }

    public void setGokeiShotoku(TextBoxNum gokeiShotoku) {
        this.setOriginalData("gokeiShotoku", gokeiShotoku);
        this.gokeiShotoku = gokeiShotoku;
    }

    public void setSetaiinsu(TextBoxNum setaiinsu) {
        this.setOriginalData("setaiinsu", setaiinsu);
        this.setaiinsu = setaiinsu;
    }

    public void setNenkinShunyuGokei(TextBoxNum nenkinShunyuGokei) {
        this.setOriginalData("nenkinShunyuGokei", nenkinShunyuGokei);
        this.nenkinShunyuGokei = nenkinShunyuGokei;
    }

    public void setSonotaGokeiShotoku(TextBoxNum sonotaGokeiShotoku) {
        this.setOriginalData("sonotaGokeiShotoku", sonotaGokeiShotoku);
        this.sonotaGokeiShotoku = sonotaGokeiShotoku;
    }

    public void setBiko(RString biko) {
        this.setOriginalData("biko", biko);
        this.biko = biko;
    }

    public void setLogicalDeletedFlag(Boolean logicalDeletedFlag) {
        this.setOriginalData("logicalDeletedFlag", logicalDeletedFlag);
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    public void setNendo(RString nendo) {
        this.setOriginalData("nendo", nendo);
        this.nendo = nendo;
    }

    public void setRirekiNo(RString rirekiNo) {
        this.setOriginalData("rirekiNo", rirekiNo);
        this.rirekiNo = rirekiNo;
    }

    public void setEdaNo(RString edaNo) {
        this.setOriginalData("edaNo", edaNo);
        this.edaNo = edaNo;
    }

    public void setShikakuCode(RString shikakuCode) {
        this.setOriginalData("shikakuCode", shikakuCode);
        this.shikakuCode = shikakuCode;
    }

    public void setFutanWariaiCode(RString futanWariaiCode) {
        this.setOriginalData("futanWariaiCode", futanWariaiCode);
        this.futanWariaiCode = futanWariaiCode;
    }

    // </editor-fold>
}
