package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KakushuTsuchishoSakuseiKobetsu のクラスファイル
 *
 * @reamsid_L DBB-0740-010 wangkanglei
 */
public class KakushuTsuchishoSakuseiKobetsuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JuminFukaShokai")
    private JuminFukaShokaiDiv JuminFukaShokai;
    @JsonProperty("TsuchishoSakuseiKobetsu")
    private TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu;
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    private FukaShokaiGrandsonTsuchishoDiv FukaShokaiGrandsonTsuchisho;
    @JsonProperty("hdnPublishFlag")
    private RString hdnPublishFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJuminFukaShokai
     * @return JuminFukaShokai
     */
    @JsonProperty("JuminFukaShokai")
    public JuminFukaShokaiDiv getJuminFukaShokai() {
        return JuminFukaShokai;
    }

    /*
     * setJuminFukaShokai
     * @param JuminFukaShokai JuminFukaShokai
     */
    @JsonProperty("JuminFukaShokai")
    public void setJuminFukaShokai(JuminFukaShokaiDiv JuminFukaShokai) {
        this.JuminFukaShokai = JuminFukaShokai;
    }

    /*
     * getTsuchishoSakuseiKobetsu
     * @return TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public TsuchishoSakuseiKobetsuDiv getTsuchishoSakuseiKobetsu() {
        return TsuchishoSakuseiKobetsu;
    }

    /*
     * setTsuchishoSakuseiKobetsu
     * @param TsuchishoSakuseiKobetsu TsuchishoSakuseiKobetsu
     */
    @JsonProperty("TsuchishoSakuseiKobetsu")
    public void setTsuchishoSakuseiKobetsu(TsuchishoSakuseiKobetsuDiv TsuchishoSakuseiKobetsu) {
        this.TsuchishoSakuseiKobetsu = TsuchishoSakuseiKobetsu;
    }

    /*
     * getFukaShokaiGrandsonTsuchisho
     * @return FukaShokaiGrandsonTsuchisho
     */
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    public FukaShokaiGrandsonTsuchishoDiv getFukaShokaiGrandsonTsuchisho() {
        return FukaShokaiGrandsonTsuchisho;
    }

    /*
     * setFukaShokaiGrandsonTsuchisho
     * @param FukaShokaiGrandsonTsuchisho FukaShokaiGrandsonTsuchisho
     */
    @JsonProperty("FukaShokaiGrandsonTsuchisho")
    public void setFukaShokaiGrandsonTsuchisho(FukaShokaiGrandsonTsuchishoDiv FukaShokaiGrandsonTsuchisho) {
        this.FukaShokaiGrandsonTsuchisho = FukaShokaiGrandsonTsuchisho;
    }

    /*
     * gethdnPublishFlag
     * @return hdnPublishFlag
     */
    @JsonProperty("hdnPublishFlag")
    public RString getHdnPublishFlag() {
        return hdnPublishFlag;
    }

    /*
     * sethdnPublishFlag
     * @param hdnPublishFlag hdnPublishFlag
     */
    @JsonProperty("hdnPublishFlag")
    public void setHdnPublishFlag(RString hdnPublishFlag) {
        this.hdnPublishFlag = hdnPublishFlag;
    }

    // </editor-fold>
}
