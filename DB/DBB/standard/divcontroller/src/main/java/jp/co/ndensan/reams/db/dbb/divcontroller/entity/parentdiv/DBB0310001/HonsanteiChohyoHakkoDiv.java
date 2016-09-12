package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HonsanteiChohyoHakko のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiChohyoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonChoteibo")
    private HonChoteiboDiv HonChoteibo;
    @JsonProperty("HonTokuKaishiTsuchi")
    private HonTokuKaishiTsuchiDiv HonTokuKaishiTsuchi;
    @JsonProperty("HonKetteTsuchi")
    private HonKetteTsuchiDiv HonKetteTsuchi;
    @JsonProperty("HonNotsu")
    private HonNotsuDiv HonNotsu;
    @JsonProperty("HonFukadaicho")
    private HonFukadaichoDiv HonFukadaicho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonChoteibo
     * @return HonChoteibo
     */
    @JsonProperty("HonChoteibo")
    public HonChoteiboDiv getHonChoteibo() {
        return HonChoteibo;
    }

    /*
     * setHonChoteibo
     * @param HonChoteibo HonChoteibo
     */
    @JsonProperty("HonChoteibo")
    public void setHonChoteibo(HonChoteiboDiv HonChoteibo) {
        this.HonChoteibo = HonChoteibo;
    }

    /*
     * getHonTokuKaishiTsuchi
     * @return HonTokuKaishiTsuchi
     */
    @JsonProperty("HonTokuKaishiTsuchi")
    public HonTokuKaishiTsuchiDiv getHonTokuKaishiTsuchi() {
        return HonTokuKaishiTsuchi;
    }

    /*
     * setHonTokuKaishiTsuchi
     * @param HonTokuKaishiTsuchi HonTokuKaishiTsuchi
     */
    @JsonProperty("HonTokuKaishiTsuchi")
    public void setHonTokuKaishiTsuchi(HonTokuKaishiTsuchiDiv HonTokuKaishiTsuchi) {
        this.HonTokuKaishiTsuchi = HonTokuKaishiTsuchi;
    }

    /*
     * getHonKetteTsuchi
     * @return HonKetteTsuchi
     */
    @JsonProperty("HonKetteTsuchi")
    public HonKetteTsuchiDiv getHonKetteTsuchi() {
        return HonKetteTsuchi;
    }

    /*
     * setHonKetteTsuchi
     * @param HonKetteTsuchi HonKetteTsuchi
     */
    @JsonProperty("HonKetteTsuchi")
    public void setHonKetteTsuchi(HonKetteTsuchiDiv HonKetteTsuchi) {
        this.HonKetteTsuchi = HonKetteTsuchi;
    }

    /*
     * getHonNotsu
     * @return HonNotsu
     */
    @JsonProperty("HonNotsu")
    public HonNotsuDiv getHonNotsu() {
        return HonNotsu;
    }

    /*
     * setHonNotsu
     * @param HonNotsu HonNotsu
     */
    @JsonProperty("HonNotsu")
    public void setHonNotsu(HonNotsuDiv HonNotsu) {
        this.HonNotsu = HonNotsu;
    }

    /*
     * getHonFukadaicho
     * @return HonFukadaicho
     */
    @JsonProperty("HonFukadaicho")
    public HonFukadaichoDiv getHonFukadaicho() {
        return HonFukadaicho;
    }

    /*
     * setHonFukadaicho
     * @param HonFukadaicho HonFukadaicho
     */
    @JsonProperty("HonFukadaicho")
    public void setHonFukadaicho(HonFukadaichoDiv HonFukadaicho) {
        this.HonFukadaicho = HonFukadaicho;
    }

    // </editor-fold>
}
