package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujikouseiFukakonkyo のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujikouseiFukakonkyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("FukakonkyoMae")
    private FukakonkyoMaeDiv FukakonkyoMae;
    @JsonProperty("FukakonkyoAto")
    private FukakonkyoAtoDiv FukakonkyoAto;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getFukakonkyoMae
     * @return FukakonkyoMae
     */
    @JsonProperty("FukakonkyoMae")
    public FukakonkyoMaeDiv getFukakonkyoMae() {
        return FukakonkyoMae;
    }

    /*
     * setFukakonkyoMae
     * @param FukakonkyoMae FukakonkyoMae
     */
    @JsonProperty("FukakonkyoMae")
    public void setFukakonkyoMae(FukakonkyoMaeDiv FukakonkyoMae) {
        this.FukakonkyoMae = FukakonkyoMae;
    }

    /*
     * getFukakonkyoAto
     * @return FukakonkyoAto
     */
    @JsonProperty("FukakonkyoAto")
    public FukakonkyoAtoDiv getFukakonkyoAto() {
        return FukakonkyoAto;
    }

    /*
     * setFukakonkyoAto
     * @param FukakonkyoAto FukakonkyoAto
     */
    @JsonProperty("FukakonkyoAto")
    public void setFukakonkyoAto(FukakonkyoAtoDiv FukakonkyoAto) {
        this.FukakonkyoAto = FukakonkyoAto;
    }

    // </editor-fold>
}
