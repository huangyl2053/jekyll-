package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.JukyuIdoKeikakuRirekiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Aug 09 13:49:18 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgKyotakuKeikaku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKyotakuKeikaku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString zanteiKubun;
    private TextBoxFlexibleDate tekiyoKaishiYMD;
    private TextBoxFlexibleDate tekiyoShuryoYMD;
    private RString keikakuJigyoshaNo;
    private RString keikakuJigyoshaName;
    private RString itakusakiJigyoshaNo;
    private RString itakusakiJigyoshaName;

    public dgKyotakuKeikaku_Row() {
        super();
        this.zanteiKubun = RString.EMPTY;
        this.tekiyoKaishiYMD = new TextBoxFlexibleDate();
        this.tekiyoShuryoYMD = new TextBoxFlexibleDate();
        this.keikakuJigyoshaNo = RString.EMPTY;
        this.keikakuJigyoshaName = RString.EMPTY;
        this.itakusakiJigyoshaNo = RString.EMPTY;
        this.itakusakiJigyoshaName = RString.EMPTY;
        this.setOriginalData("zanteiKubun", zanteiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("keikakuJigyoshaNo", keikakuJigyoshaNo);
        this.setOriginalData("keikakuJigyoshaName", keikakuJigyoshaName);
        this.setOriginalData("itakusakiJigyoshaNo", itakusakiJigyoshaNo);
        this.setOriginalData("itakusakiJigyoshaName", itakusakiJigyoshaName);
    }

    public dgKyotakuKeikaku_Row(RString zanteiKubun, TextBoxFlexibleDate tekiyoKaishiYMD, TextBoxFlexibleDate tekiyoShuryoYMD, RString keikakuJigyoshaNo, RString keikakuJigyoshaName, RString itakusakiJigyoshaNo, RString itakusakiJigyoshaName) {
        super();
        this.setOriginalData("zanteiKubun", zanteiKubun);
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.setOriginalData("keikakuJigyoshaNo", keikakuJigyoshaNo);
        this.setOriginalData("keikakuJigyoshaName", keikakuJigyoshaName);
        this.setOriginalData("itakusakiJigyoshaNo", itakusakiJigyoshaNo);
        this.setOriginalData("itakusakiJigyoshaName", itakusakiJigyoshaName);
        this.zanteiKubun = zanteiKubun;
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
        this.keikakuJigyoshaNo = keikakuJigyoshaNo;
        this.keikakuJigyoshaName = keikakuJigyoshaName;
        this.itakusakiJigyoshaNo = itakusakiJigyoshaNo;
        this.itakusakiJigyoshaName = itakusakiJigyoshaName;
    }

    public RString getZanteiKubun() {
        return zanteiKubun;
    }

    public TextBoxFlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    public TextBoxFlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    public RString getKeikakuJigyoshaNo() {
        return keikakuJigyoshaNo;
    }

    public RString getKeikakuJigyoshaName() {
        return keikakuJigyoshaName;
    }

    public RString getItakusakiJigyoshaNo() {
        return itakusakiJigyoshaNo;
    }

    public RString getItakusakiJigyoshaName() {
        return itakusakiJigyoshaName;
    }

    public void setZanteiKubun(RString zanteiKubun) {
        this.setOriginalData("zanteiKubun", zanteiKubun);
        this.zanteiKubun = zanteiKubun;
    }

    public void setTekiyoKaishiYMD(TextBoxFlexibleDate tekiyoKaishiYMD) {
        this.setOriginalData("tekiyoKaishiYMD", tekiyoKaishiYMD);
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    public void setTekiyoShuryoYMD(TextBoxFlexibleDate tekiyoShuryoYMD) {
        this.setOriginalData("tekiyoShuryoYMD", tekiyoShuryoYMD);
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    public void setKeikakuJigyoshaNo(RString keikakuJigyoshaNo) {
        this.setOriginalData("keikakuJigyoshaNo", keikakuJigyoshaNo);
        this.keikakuJigyoshaNo = keikakuJigyoshaNo;
    }

    public void setKeikakuJigyoshaName(RString keikakuJigyoshaName) {
        this.setOriginalData("keikakuJigyoshaName", keikakuJigyoshaName);
        this.keikakuJigyoshaName = keikakuJigyoshaName;
    }

    public void setItakusakiJigyoshaNo(RString itakusakiJigyoshaNo) {
        this.setOriginalData("itakusakiJigyoshaNo", itakusakiJigyoshaNo);
        this.itakusakiJigyoshaNo = itakusakiJigyoshaNo;
    }

    public void setItakusakiJigyoshaName(RString itakusakiJigyoshaName) {
        this.setOriginalData("itakusakiJigyoshaName", itakusakiJigyoshaName);
        this.itakusakiJigyoshaName = itakusakiJigyoshaName;
    }

    // </editor-fold>
}
