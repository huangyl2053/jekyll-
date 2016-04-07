package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaDaichoIchiran のクラスファイル
 *
 * @reamsid_L DBA-0510-050 wangxiaodong
 */
public class HihokenshaDaichoIchiranDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaDaichoHakko")
    private HihokenshaDaichoHakkoDiv HihokenshaDaichoHakko;
    @JsonProperty("HihokenshaDaichoHakkoList")
    private HihokenshaDaichoHakkoListDiv HihokenshaDaichoHakkoList;
    @JsonProperty("ChohyoShutsuryokujunOya")
    private ChohyoShutsuryokujunOyaDiv ChohyoShutsuryokujunOya;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokenshaDaichoHakko
     * @return HihokenshaDaichoHakko
     */
    @JsonProperty("HihokenshaDaichoHakko")
    public HihokenshaDaichoHakkoDiv getHihokenshaDaichoHakko() {
        return HihokenshaDaichoHakko;
    }

    /*
     * setHihokenshaDaichoHakko
     * @param HihokenshaDaichoHakko HihokenshaDaichoHakko
     */
    @JsonProperty("HihokenshaDaichoHakko")
    public void setHihokenshaDaichoHakko(HihokenshaDaichoHakkoDiv HihokenshaDaichoHakko) {
        this.HihokenshaDaichoHakko = HihokenshaDaichoHakko;
    }

    /*
     * getHihokenshaDaichoHakkoList
     * @return HihokenshaDaichoHakkoList
     */
    @JsonProperty("HihokenshaDaichoHakkoList")
    public HihokenshaDaichoHakkoListDiv getHihokenshaDaichoHakkoList() {
        return HihokenshaDaichoHakkoList;
    }

    /*
     * setHihokenshaDaichoHakkoList
     * @param HihokenshaDaichoHakkoList HihokenshaDaichoHakkoList
     */
    @JsonProperty("HihokenshaDaichoHakkoList")
    public void setHihokenshaDaichoHakkoList(HihokenshaDaichoHakkoListDiv HihokenshaDaichoHakkoList) {
        this.HihokenshaDaichoHakkoList = HihokenshaDaichoHakkoList;
    }

    /*
     * getChohyoShutsuryokujunOya
     * @return ChohyoShutsuryokujunOya
     */
    @JsonProperty("ChohyoShutsuryokujunOya")
    public ChohyoShutsuryokujunOyaDiv getChohyoShutsuryokujunOya() {
        return ChohyoShutsuryokujunOya;
    }

    /*
     * setChohyoShutsuryokujunOya
     * @param ChohyoShutsuryokujunOya ChohyoShutsuryokujunOya
     */
    @JsonProperty("ChohyoShutsuryokujunOya")
    public void setChohyoShutsuryokujunOya(ChohyoShutsuryokujunOyaDiv ChohyoShutsuryokujunOya) {
        this.ChohyoShutsuryokujunOya = ChohyoShutsuryokujunOya;
    }

    // </editor-fold>
}
