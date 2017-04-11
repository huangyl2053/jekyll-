package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.SeikatsuHogoJohoCommonDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Apr 03 15:44:07 JST 2017 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJyukyuTeishiKikanIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJyukyuTeishiKikanIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-27_09-11-55">

    private RString jukyuTeishiKaishiYMD;
    private RString jukyuTeishiShuryoYMD;

    public dgJyukyuTeishiKikanIchiran_Row() {
        super();
        this.jukyuTeishiKaishiYMD = RString.EMPTY;
        this.jukyuTeishiShuryoYMD = RString.EMPTY;
        this.setOriginalData("jukyuTeishiKaishiYMD", jukyuTeishiKaishiYMD);
        this.setOriginalData("jukyuTeishiShuryoYMD", jukyuTeishiShuryoYMD);
    }

    public dgJyukyuTeishiKikanIchiran_Row(RString jukyuTeishiKaishiYMD, RString jukyuTeishiShuryoYMD) {
        super();
        this.setOriginalData("jukyuTeishiKaishiYMD", jukyuTeishiKaishiYMD);
        this.setOriginalData("jukyuTeishiShuryoYMD", jukyuTeishiShuryoYMD);
        this.jukyuTeishiKaishiYMD = jukyuTeishiKaishiYMD;
        this.jukyuTeishiShuryoYMD = jukyuTeishiShuryoYMD;
    }

    public RString getJukyuTeishiKaishiYMD() {
        return jukyuTeishiKaishiYMD;
    }

    public RString getJukyuTeishiShuryoYMD() {
        return jukyuTeishiShuryoYMD;
    }

    public void setJukyuTeishiKaishiYMD(RString jukyuTeishiKaishiYMD) {
        this.setOriginalData("jukyuTeishiKaishiYMD", jukyuTeishiKaishiYMD);
        this.jukyuTeishiKaishiYMD = jukyuTeishiKaishiYMD;
    }

    public void setJukyuTeishiShuryoYMD(RString jukyuTeishiShuryoYMD) {
        this.setOriginalData("jukyuTeishiShuryoYMD", jukyuTeishiShuryoYMD);
        this.jukyuTeishiShuryoYMD = jukyuTeishiShuryoYMD;
    }

    // </editor-fold>
}
