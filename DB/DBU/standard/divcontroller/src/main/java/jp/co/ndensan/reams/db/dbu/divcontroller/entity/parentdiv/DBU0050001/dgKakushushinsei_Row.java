package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0050001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu May 05 15:25:10 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKakushushinsei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKakushushinsei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">

    private Boolean sentaku;
    private RString gyomu;
    private RString shinseisho;

    public dgKakushushinsei_Row() {
        super();
        this.sentaku = false;
        this.gyomu = RString.EMPTY;
        this.shinseisho = RString.EMPTY;
        this.setOriginalData("sentaku", sentaku);
        this.setOriginalData("gyomu", gyomu);
        this.setOriginalData("shinseisho", shinseisho);
    }

    public dgKakushushinsei_Row(Boolean sentaku, RString gyomu, RString shinseisho) {
        super();
        this.setOriginalData("sentaku", sentaku);
        this.setOriginalData("gyomu", gyomu);
        this.setOriginalData("shinseisho", shinseisho);
        this.sentaku = sentaku;
        this.gyomu = gyomu;
        this.shinseisho = shinseisho;
    }

    public Boolean getSentaku() {
        return sentaku;
    }

    public RString getGyomu() {
        return gyomu;
    }

    public RString getShinseisho() {
        return shinseisho;
    }

    public void setSentaku(Boolean sentaku) {
        this.setOriginalData("sentaku", sentaku);
        this.sentaku = sentaku;
    }

    public void setGyomu(RString gyomu) {
        this.setOriginalData("gyomu", gyomu);
        this.gyomu = gyomu;
    }

    public void setShinseisho(RString shinseisho) {
        this.setOriginalData("shinseisho", shinseisho);
        this.shinseisho = shinseisho;
    }

    // </editor-fold>
}
