package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FileTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class FileTorikomiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("uplFileTorikomi")
    private UploadPanel uplFileTorikomi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getuplFileTorikomi
     * @return uplFileTorikomi
     */
    @JsonProperty("uplFileTorikomi")
    public UploadPanel getUplFileTorikomi() {
        return uplFileTorikomi;
    }

    /*
     * setuplFileTorikomi
     * @param uplFileTorikomi uplFileTorikomi
     */
    @JsonProperty("uplFileTorikomi")
    public void setUplFileTorikomi(UploadPanel uplFileTorikomi) {
        this.uplFileTorikomi = uplFileTorikomi;
    }

    // </editor-fold>
}
