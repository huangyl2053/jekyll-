package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NijiHanteiKekka のクラスファイル 
 * 
 * @author 自動生成
 */
public class NijiHanteiKekkaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-04-17_13-55-22">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShujiiRenraku")
    private RadioButton radShujiiRenraku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShujiiRenraku
     * @return radShujiiRenraku
     */
    @JsonProperty("radShujiiRenraku")
    public RadioButton getRadShujiiRenraku() {
        return radShujiiRenraku;
    }

    /*
     * setradShujiiRenraku
     * @param radShujiiRenraku radShujiiRenraku
     */
    @JsonProperty("radShujiiRenraku")
    public void setRadShujiiRenraku(RadioButton radShujiiRenraku) {
        this.radShujiiRenraku = radShujiiRenraku;
    }

    // </editor-fold>
}
