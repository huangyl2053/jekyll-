package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShuruiShikyuGendogakuMain のクラスファイル
 *
 * @reamsid_L DBC-3440-010 lihang
 */
public class ShuruiShikyuGendogakuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShuruiShikyuGendogakuIchiran")
    private ShuruiShikyuGendogakuIchiranDiv ShuruiShikyuGendogakuIchiran;
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    private ShuruiShikyuGendogakuShosaiDiv ShuruiShikyuGendogakuShosai;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShuruiShikyuGendogakuIchiran
     * @return ShuruiShikyuGendogakuIchiran
     */
    @JsonProperty("ShuruiShikyuGendogakuIchiran")
    public ShuruiShikyuGendogakuIchiranDiv getShuruiShikyuGendogakuIchiran() {
        return ShuruiShikyuGendogakuIchiran;
    }

    /*
     * setShuruiShikyuGendogakuIchiran
     * @param ShuruiShikyuGendogakuIchiran ShuruiShikyuGendogakuIchiran
     */
    @JsonProperty("ShuruiShikyuGendogakuIchiran")
    public void setShuruiShikyuGendogakuIchiran(ShuruiShikyuGendogakuIchiranDiv ShuruiShikyuGendogakuIchiran) {
        this.ShuruiShikyuGendogakuIchiran = ShuruiShikyuGendogakuIchiran;
    }

    /*
     * getShuruiShikyuGendogakuShosai
     * @return ShuruiShikyuGendogakuShosai
     */
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    public ShuruiShikyuGendogakuShosaiDiv getShuruiShikyuGendogakuShosai() {
        return ShuruiShikyuGendogakuShosai;
    }

    /*
     * setShuruiShikyuGendogakuShosai
     * @param ShuruiShikyuGendogakuShosai ShuruiShikyuGendogakuShosai
     */
    @JsonProperty("ShuruiShikyuGendogakuShosai")
    public void setShuruiShikyuGendogakuShosai(ShuruiShikyuGendogakuShosaiDiv ShuruiShikyuGendogakuShosai) {
        this.ShuruiShikyuGendogakuShosai = ShuruiShikyuGendogakuShosai;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnCancel() {
        return this.getShuruiShikyuGendogakuShosai().getShuruiShikyuGendogakuShosaiFooter().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getShuruiShikyuGendogakuShosai().getShuruiShikyuGendogakuShosaiFooter().setBtnCancel(btnCancel);
    }

    // </editor-fold>
}
