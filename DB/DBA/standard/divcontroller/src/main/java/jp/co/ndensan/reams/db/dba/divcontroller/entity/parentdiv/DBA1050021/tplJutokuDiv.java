package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplJutoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplJutokuDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Jutoku")
    private JutokuDiv Jutoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJutoku
     * @return Jutoku
     */
    @JsonProperty("Jutoku")
    public JutokuDiv getJutoku() {
        return Jutoku;
    }

    /*
     * setJutoku
     * @param Jutoku Jutoku
     */
    @JsonProperty("Jutoku")
    public void setJutoku(JutokuDiv Jutoku) {
        this.Jutoku = Jutoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IJushochiTokureiRirekiListDiv getCcdJushochiTokureiRirekiList() {
        return this.getJutoku().getCcdJushochiTokureiRirekiList();
    }

    // </editor-fold>
}
