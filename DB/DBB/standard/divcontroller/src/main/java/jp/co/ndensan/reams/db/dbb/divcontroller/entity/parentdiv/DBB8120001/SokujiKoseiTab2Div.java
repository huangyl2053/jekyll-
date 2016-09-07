package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * SokujiKoseiTab2 のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiKoseiTab2Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SokujikouseiSanteinoKiso")
    private SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso;
    @JsonProperty("SokujikouseiJiyu")
    private SokujikouseiJiyuDiv SokujikouseiJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSokujikouseiSanteinoKiso
     * @return SokujikouseiSanteinoKiso
     */
    @JsonProperty("SokujikouseiSanteinoKiso")
    public SokujikouseiSanteinoKisoDiv getSokujikouseiSanteinoKiso() {
        return SokujikouseiSanteinoKiso;
    }

    /*
     * setSokujikouseiSanteinoKiso
     * @param SokujikouseiSanteinoKiso SokujikouseiSanteinoKiso
     */
    @JsonProperty("SokujikouseiSanteinoKiso")
    public void setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso) {
        this.SokujikouseiSanteinoKiso = SokujikouseiSanteinoKiso;
    }

    /*
     * getSokujikouseiJiyu
     * @return SokujikouseiJiyu
     */
    @JsonProperty("SokujikouseiJiyu")
    public SokujikouseiJiyuDiv getSokujikouseiJiyu() {
        return SokujikouseiJiyu;
    }

    /*
     * setSokujikouseiJiyu
     * @param SokujikouseiJiyu SokujikouseiJiyu
     */
    @JsonProperty("SokujikouseiJiyu")
    public void setSokujikouseiJiyu(SokujikouseiJiyuDiv SokujikouseiJiyu) {
        this.SokujikouseiJiyu = SokujikouseiJiyu;
    }

    // </editor-fold>
}
