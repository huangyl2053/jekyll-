package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.JutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.ShikakuHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.ShisetsuNyutaishoRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tabShisakuShosaiRirekiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tblShikakuShosaiDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplJutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShikakuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuShosaiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblShikakuShosai")
    private tblShikakuShosaiDiv tblShikakuShosai;
    @JsonProperty("tabShisakuShosaiRireki")
    private tabShisakuShosaiRirekiDiv tabShisakuShosaiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblShikakuShosai")
    public tblShikakuShosaiDiv getTblShikakuShosai() {
        return tblShikakuShosai;
    }

    @JsonProperty("tblShikakuShosai")
    public void setTblShikakuShosai(tblShikakuShosaiDiv tblShikakuShosai) {
        this.tblShikakuShosai=tblShikakuShosai;
    }

    @JsonProperty("tabShisakuShosaiRireki")
    public tabShisakuShosaiRirekiDiv getTabShisakuShosaiRireki() {
        return tabShisakuShosaiRireki;
    }

    @JsonProperty("tabShisakuShosaiRireki")
    public void setTabShisakuShosaiRireki(tabShisakuShosaiRirekiDiv tabShisakuShosaiRireki) {
        this.tabShisakuShosaiRireki=tabShisakuShosaiRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.getTblShikakuShosai().getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.getTblShikakuShosai().getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.getTblShikakuShosai().getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuTodokedeDate() {
        return this.getTblShikakuShosai().getTxtShutokuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.getTblShikakuShosai().getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuJiyu() {
        return this.getTblShikakuShosai().getDdlShutokuJiyu();
    }

    @JsonIgnore
    public Label getLblHihoKubun() {
        return this.getTblShikakuShosai().getLblHihoKubun();
    }

    @JsonIgnore
    public DropDownList getDdlHihoKubun() {
        return this.getTblShikakuShosai().getDdlHihoKubun();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.getTblShikakuShosai().getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuShozaiHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuShozaiHokensha();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.getTblShikakuShosai().getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.getTblShikakuShosai().getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.getTblShikakuShosai().getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblSoshitsuDate() {
        return this.getTblShikakuShosai().getLblSoshitsuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuDate() {
        return this.getTblShikakuShosai().getTxtSoshitsuDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuTodokedeDate() {
        return this.getTblShikakuShosai().getLblSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSoshitsuTodokedeDate() {
        return this.getTblShikakuShosai().getTxtSoshitsuTodokedeDate();
    }

    @JsonIgnore
    public Label getLblSoshitsuJiyu() {
        return this.getTblShikakuShosai().getLblSoshitsuJiyu();
    }

    @JsonIgnore
    public DropDownList getDdlSoshitsuJiyu() {
        return this.getTblShikakuShosai().getDdlSoshitsuJiyu();
    }

    @JsonIgnore
    public tplJutokuDiv getTplJutoku() {
        return this.getTabShisakuShosaiRireki().getTplJutoku();
    }

    @JsonIgnore
    public void  setTplJutoku(tplJutokuDiv tplJutoku) {
        this.getTabShisakuShosaiRireki().setTplJutoku(tplJutoku);
    }

    @JsonIgnore
    public JutokuDiv getJutoku() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutoku();
    }

    @JsonIgnore
    public void  setJutoku(JutokuDiv Jutoku) {
        this.getTabShisakuShosaiRireki().getTplJutoku().setJutoku(Jutoku);
    }

    @JsonIgnore
    public IJushochiTokureiRirekiListDiv getCcdJushochiTokureiRirekiList() {
        return this.getTabShisakuShosaiRireki().getTplJutoku().getJutoku().getCcdJushochiTokureiRirekiList();
    }

    @JsonIgnore
    public tplHenkoDiv getTplHenko() {
        return this.getTabShisakuShosaiRireki().getTplHenko();
    }

    @JsonIgnore
    public void  setTplHenko(tplHenkoDiv tplHenko) {
        this.getTabShisakuShosaiRireki().setTplHenko(tplHenko);
    }

    @JsonIgnore
    public ShikakuHenkoDiv getShikakuHenko() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getShikakuHenko();
    }

    @JsonIgnore
    public void  setShikakuHenko(ShikakuHenkoDiv ShikakuHenko) {
        this.getTabShisakuShosaiRireki().getTplHenko().setShikakuHenko(ShikakuHenko);
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDiv getCcdShikakuHenkoRireki() {
        return this.getTabShisakuShosaiRireki().getTplHenko().getShikakuHenko().getCcdShikakuHenkoRireki();
    }

    @JsonIgnore
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return this.getTabShisakuShosaiRireki().getTplShisetsuNyutaisho();
    }

    @JsonIgnore
    public void  setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.getTabShisakuShosaiRireki().setTplShisetsuNyutaisho(tplShisetsuNyutaisho);
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiDiv getShisetsuNyutaishoRireki() {
        return this.getTabShisakuShosaiRireki().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void  setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki) {
        this.getTabShisakuShosaiRireki().getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return this.getTabShisakuShosaiRireki().getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri();
    }

}
