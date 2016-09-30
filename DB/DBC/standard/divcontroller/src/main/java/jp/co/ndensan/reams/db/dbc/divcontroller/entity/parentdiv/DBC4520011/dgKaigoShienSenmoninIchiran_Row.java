package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Aug 29 15:02:46 CST 2016
 */

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * dgKaigoShienSenmoninIchiran_Row のクラスファイル
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
public class dgKaigoShienSenmoninIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString kaigoShienSenmoninNo;
    private RString kaigoShienSenmoninMei;
    private RString kaigoShienSenmoninMeiKana;
    private RString shozokuJigyoshaNo;
    private RString shozokuJigyoshaMei;
    private TextBoxDate yukoKaishiDate;
    private TextBoxDate yukoShuryoDate;

    public dgKaigoShienSenmoninIchiran_Row() {
        super();
        this.kaigoShienSenmoninNo = RString.EMPTY;
        this.kaigoShienSenmoninMei = RString.EMPTY;
        this.kaigoShienSenmoninMeiKana = RString.EMPTY;
        this.shozokuJigyoshaNo = RString.EMPTY;
        this.shozokuJigyoshaMei = RString.EMPTY;
        this.yukoKaishiDate = new TextBoxDate();
        this.yukoShuryoDate = new TextBoxDate();
        this.setOriginalData("kaigoShienSenmoninNo", kaigoShienSenmoninNo);
        this.setOriginalData("kaigoShienSenmoninMei", kaigoShienSenmoninMei);
        this.setOriginalData("kaigoShienSenmoninMeiKana", kaigoShienSenmoninMeiKana);
        this.setOriginalData("shozokuJigyoshaNo", shozokuJigyoshaNo);
        this.setOriginalData("shozokuJigyoshaMei", shozokuJigyoshaMei);
        this.setOriginalData("yukoKaishiDate", yukoKaishiDate);
        this.setOriginalData("yukoShuryoDate", yukoShuryoDate);
    }

    public dgKaigoShienSenmoninIchiran_Row(RString kaigoShienSenmoninNo, RString kaigoShienSenmoninMei, RString kaigoShienSenmoninMeiKana, RString shozokuJigyoshaNo, RString shozokuJigyoshaMei, TextBoxDate yukoKaishiDate, TextBoxDate yukoShuryoDate) {
        super();
        this.setOriginalData("kaigoShienSenmoninNo", kaigoShienSenmoninNo);
        this.setOriginalData("kaigoShienSenmoninMei", kaigoShienSenmoninMei);
        this.setOriginalData("kaigoShienSenmoninMeiKana", kaigoShienSenmoninMeiKana);
        this.setOriginalData("shozokuJigyoshaNo", shozokuJigyoshaNo);
        this.setOriginalData("shozokuJigyoshaMei", shozokuJigyoshaMei);
        this.setOriginalData("yukoKaishiDate", yukoKaishiDate);
        this.setOriginalData("yukoShuryoDate", yukoShuryoDate);
        this.kaigoShienSenmoninNo = kaigoShienSenmoninNo;
        this.kaigoShienSenmoninMei = kaigoShienSenmoninMei;
        this.kaigoShienSenmoninMeiKana = kaigoShienSenmoninMeiKana;
        this.shozokuJigyoshaNo = shozokuJigyoshaNo;
        this.shozokuJigyoshaMei = shozokuJigyoshaMei;
        this.yukoKaishiDate = yukoKaishiDate;
        this.yukoShuryoDate = yukoShuryoDate;
    }

    public RString getKaigoShienSenmoninNo() {
        return kaigoShienSenmoninNo;
    }

    public RString getKaigoShienSenmoninMei() {
        return kaigoShienSenmoninMei;
    }

    public RString getKaigoShienSenmoninMeiKana() {
        return kaigoShienSenmoninMeiKana;
    }

    public RString getShozokuJigyoshaNo() {
        return shozokuJigyoshaNo;
    }

    public RString getShozokuJigyoshaMei() {
        return shozokuJigyoshaMei;
    }

    public TextBoxDate getYukoKaishiDate() {
        return yukoKaishiDate;
    }

    public TextBoxDate getYukoShuryoDate() {
        return yukoShuryoDate;
    }

    public void setKaigoShienSenmoninNo(RString kaigoShienSenmoninNo) {
        this.setOriginalData("kaigoShienSenmoninNo", kaigoShienSenmoninNo);
        this.kaigoShienSenmoninNo = kaigoShienSenmoninNo;
    }

    public void setKaigoShienSenmoninMei(RString kaigoShienSenmoninMei) {
        this.setOriginalData("kaigoShienSenmoninMei", kaigoShienSenmoninMei);
        this.kaigoShienSenmoninMei = kaigoShienSenmoninMei;
    }

    public void setKaigoShienSenmoninMeiKana(RString kaigoShienSenmoninMeiKana) {
        this.setOriginalData("kaigoShienSenmoninMeiKana", kaigoShienSenmoninMeiKana);
        this.kaigoShienSenmoninMeiKana = kaigoShienSenmoninMeiKana;
    }

    public void setShozokuJigyoshaNo(RString shozokuJigyoshaNo) {
        this.setOriginalData("shozokuJigyoshaNo", shozokuJigyoshaNo);
        this.shozokuJigyoshaNo = shozokuJigyoshaNo;
    }

    public void setShozokuJigyoshaMei(RString shozokuJigyoshaMei) {
        this.setOriginalData("shozokuJigyoshaMei", shozokuJigyoshaMei);
        this.shozokuJigyoshaMei = shozokuJigyoshaMei;
    }

    public void setYukoKaishiDate(TextBoxDate yukoKaishiDate) {
        this.setOriginalData("yukoKaishiDate", yukoKaishiDate);
        this.yukoKaishiDate = yukoKaishiDate;
    }

    public void setYukoShuryoDate(TextBoxDate yukoShuryoDate) {
        this.setOriginalData("yukoShuryoDate", yukoShuryoDate);
        this.yukoShuryoDate = yukoShuryoDate;
    }

    // </editor-fold>
}
