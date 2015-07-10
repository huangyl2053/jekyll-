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
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplHenkoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplJutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA2030011.tplShisetsuNyutaishoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.IJushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.IShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.ShikakuHenkoRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.IShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri.ShisetsuNyutaishoRirekiKanriDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShisakuShosaiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabShisakuShosaiRirekiDiv extends TabContainer {
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
    @JsonProperty("tplJutoku")
    public tplJutokuDiv getTplJutoku() {
        return tplJutoku;
    }

    @JsonProperty("tplJutoku")
    public void setTplJutoku(tplJutokuDiv tplJutoku) {
        this.tplJutoku=tplJutoku;
    }

    @JsonProperty("tplHenko")
    public tplHenkoDiv getTplHenko() {
        return tplHenko;
    }

    @JsonProperty("tplHenko")
    public void setTplHenko(tplHenkoDiv tplHenko) {
        this.tplHenko=tplHenko;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public tplShisetsuNyutaishoDiv getTplShisetsuNyutaisho() {
        return tplShisetsuNyutaisho;
    }

    @JsonProperty("tplShisetsuNyutaisho")
    public void setTplShisetsuNyutaisho(tplShisetsuNyutaishoDiv tplShisetsuNyutaisho) {
        this.tplShisetsuNyutaisho=tplShisetsuNyutaisho;
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

}
