package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NenpoYoushiki1Hosei のクラスファイル 
 * 
 * @author 自動生成
 */
public class NenpoYoushiki1HoseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("hihokenshabango")
    private hihokenshabangoDiv hihokenshabango;
    @JsonProperty("YoshikiichihoseiMeisai")
    private YoshikiichihoseiMeisaiDiv YoshikiichihoseiMeisai;
    @JsonProperty("KanryoMessge")
    private KanryoMessgeDiv KanryoMessge;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gethihokenshabango
     * @return hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public hihokenshabangoDiv getHihokenshabango() {
        return hihokenshabango;
    }

    /*
     * sethihokenshabango
     * @param hihokenshabango hihokenshabango
     */
    @JsonProperty("hihokenshabango")
    public void setHihokenshabango(hihokenshabangoDiv hihokenshabango) {
        this.hihokenshabango = hihokenshabango;
    }

    /*
     * getYoshikiichihoseiMeisai
     * @return YoshikiichihoseiMeisai
     */
    @JsonProperty("YoshikiichihoseiMeisai")
    public YoshikiichihoseiMeisaiDiv getYoshikiichihoseiMeisai() {
        return YoshikiichihoseiMeisai;
    }

    /*
     * setYoshikiichihoseiMeisai
     * @param YoshikiichihoseiMeisai YoshikiichihoseiMeisai
     */
    @JsonProperty("YoshikiichihoseiMeisai")
    public void setYoshikiichihoseiMeisai(YoshikiichihoseiMeisaiDiv YoshikiichihoseiMeisai) {
        this.YoshikiichihoseiMeisai = YoshikiichihoseiMeisai;
    }

    /*
     * getKanryoMessge
     * @return KanryoMessge
     */
    @JsonProperty("KanryoMessge")
    public KanryoMessgeDiv getKanryoMessge() {
        return KanryoMessge;
    }

    /*
     * setKanryoMessge
     * @param KanryoMessge KanryoMessge
     */
    @JsonProperty("KanryoMessge")
    public void setKanryoMessge(KanryoMessgeDiv KanryoMessge) {
        this.KanryoMessge = KanryoMessge;
    }

    // </editor-fold>
}
