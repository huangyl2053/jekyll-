package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1050021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShisakuShosaiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShisakuShosaiRirekiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplJutoku")
    private tplJutokuDiv tplJutoku;
    @JsonProperty("tplHenko")
    private tplHenkoDiv tplHenko;
    @JsonProperty("tplShisetsuNyutaisho")
    private tplShisetsuNyutaishoDiv tplShisetsuNyutaisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplJutoku
     * @return tplJutoku
     */
    @JsonProperty("tplJutoku")
    public tplJutokuDiv getTplJutoku() {
        return tplJutoku;
    }

    /*
     * settplJutoku
     * @param tplJutoku tplJutoku
     */
    @JsonProperty("tplJutoku")
    public void setTplJutoku(tplJutokuDiv tplJutoku) {
        this.tplJutoku = tplJutoku;
    }

    /*
     * gettplHenko
     * @return tplHenko
     */
    @JsonProperty("tplHenko")
    public tplHenkoDiv getTplHenko() {
        return tplHenko;
    }

    /*
     * settplHenko
     * @param tplHenko tplHenko
     */
    @JsonProperty("tplHenko")
    public void setTplHenko(tplHenkoDiv tplHenko) {
        this.tplHenko = tplHenko;
    }

    /*
     * gettplShisetsuNyutaisho
     * @return tplShisetsuNyutaisho
     */
    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    /*
     * settplShisetsuNyutaisho
     * @param tplShisetsuNyutaisho tplShisetsuNyutaisho
     */
    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho = tplShisetsuNyutaisho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JutokuDiv getJutoku() {
        return this.getTplJutoku().getJutoku();
    }

    @JsonIgnore
    public void  setJutoku(JutokuDiv Jutoku) {
        this.getTplJutoku().setJutoku(Jutoku);
    }

    @JsonIgnore
    public IJushochiTokureiRirekiListDiv getCcdJushochiTokureiRirekiList() {
        return this.getTplJutoku().getJutoku().getCcdJushochiTokureiRirekiList();
    }

    @JsonIgnore
    public ShikakuHenkoDiv getShikakuHenko() {
        return this.getTplHenko().getShikakuHenko();
    }

    @JsonIgnore
    public void  setShikakuHenko(ShikakuHenkoDiv ShikakuHenko) {
        this.getTplHenko().setShikakuHenko(ShikakuHenko);
    }

    @JsonIgnore
    public IShikakuHenkoRirekiDiv getCcdShikakuHenkoRireki() {
        return this.getTplHenko().getShikakuHenko().getCcdShikakuHenkoRireki();
    }

    @JsonIgnore
    public ShisetsuNyutaishoRirekiDiv getShisetsuNyutaishoRireki() {
        return this.getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki();
    }

    @JsonIgnore
    public void  setShisetsuNyutaishoRireki(ShisetsuNyutaishoRirekiDiv ShisetsuNyutaishoRireki) {
        this.getTplShisetsuNyutaisho().setShisetsuNyutaishoRireki(ShisetsuNyutaishoRireki);
    }

    @JsonIgnore
    public IShisetsuNyutaishoRirekiKanriDiv getCcdShisetsuNyutaishoRirekiKanri() {
        return this.getTplShisetsuNyutaisho().getShisetsuNyutaishoRireki().getCcdShisetsuNyutaishoRirekiKanri();
    }

    // </editor-fold>
}
