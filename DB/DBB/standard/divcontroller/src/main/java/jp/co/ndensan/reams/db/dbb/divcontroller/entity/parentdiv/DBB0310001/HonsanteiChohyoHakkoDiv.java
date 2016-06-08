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
 * @author 自動生成
 */
public class HonsanteiChohyoHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("HonChoteibo")
    public HonChoteiboDiv getHonChoteibo() {
        return HonChoteibo;
    }

    @JsonProperty("HonChoteibo")
    public void setHonChoteibo(HonChoteiboDiv HonChoteibo) {
        this.HonChoteibo=HonChoteibo;
    }

    @JsonProperty("HonTokuKaishiTsuchi")
    public HonTokuKaishiTsuchiDiv getHonTokuKaishiTsuchi() {
        return HonTokuKaishiTsuchi;
    }

    @JsonProperty("HonTokuKaishiTsuchi")
    public void setHonTokuKaishiTsuchi(HonTokuKaishiTsuchiDiv HonTokuKaishiTsuchi) {
        this.HonTokuKaishiTsuchi=HonTokuKaishiTsuchi;
    }

    @JsonProperty("HonKetteTsuchi")
    public HonKetteTsuchiDiv getHonKetteTsuchi() {
        return HonKetteTsuchi;
    }

    @JsonProperty("HonKetteTsuchi")
    public void setHonKetteTsuchi(HonKetteTsuchiDiv HonKetteTsuchi) {
        this.HonKetteTsuchi=HonKetteTsuchi;
    }

    @JsonProperty("HonNotsu")
    public HonNotsuDiv getHonNotsu() {
        return HonNotsu;
    }

    @JsonProperty("HonNotsu")
    public void setHonNotsu(HonNotsuDiv HonNotsu) {
        this.HonNotsu=HonNotsu;
    }

    @JsonProperty("HonFukadaicho")
    public HonFukadaichoDiv getHonFukadaicho() {
        return HonFukadaicho;
    }

    @JsonProperty("HonFukadaicho")
    public void setHonFukadaicho(HonFukadaichoDiv HonFukadaicho) {
        this.HonFukadaicho=HonFukadaicho;
    }

    // </editor-fold>
}
