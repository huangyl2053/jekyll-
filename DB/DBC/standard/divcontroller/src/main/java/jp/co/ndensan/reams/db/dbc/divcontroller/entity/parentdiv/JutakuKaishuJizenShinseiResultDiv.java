package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuJizenShinseiResetInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuJizenShinseiShinsaResultDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.JutakuKaishuJizenShoninKetteiTsuchishoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuJizenShinseiResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuJizenShinseiResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiShinsaResult")
    private JutakuKaishuJizenShinseiShinsaResultDiv JutakuKaishuJizenShinseiShinsaResult;
    @JsonProperty("JutakuKaishuJizenShinseiResetInfo")
    private JutakuKaishuJizenShinseiResetInfoDiv JutakuKaishuJizenShinseiResetInfo;
    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    private JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuJizenShinseiShinsaResult")
    public JutakuKaishuJizenShinseiShinsaResultDiv getJutakuKaishuJizenShinseiShinsaResult() {
        return JutakuKaishuJizenShinseiShinsaResult;
    }

    @JsonProperty("JutakuKaishuJizenShinseiShinsaResult")
    public void setJutakuKaishuJizenShinseiShinsaResult(JutakuKaishuJizenShinseiShinsaResultDiv JutakuKaishuJizenShinseiShinsaResult) {
        this.JutakuKaishuJizenShinseiShinsaResult=JutakuKaishuJizenShinseiShinsaResult;
    }

    @JsonProperty("JutakuKaishuJizenShinseiResetInfo")
    public JutakuKaishuJizenShinseiResetInfoDiv getJutakuKaishuJizenShinseiResetInfo() {
        return JutakuKaishuJizenShinseiResetInfo;
    }

    @JsonProperty("JutakuKaishuJizenShinseiResetInfo")
    public void setJutakuKaishuJizenShinseiResetInfo(JutakuKaishuJizenShinseiResetInfoDiv JutakuKaishuJizenShinseiResetInfo) {
        this.JutakuKaishuJizenShinseiResetInfo=JutakuKaishuJizenShinseiResetInfo;
    }

    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    public JutakuKaishuJizenShoninKetteiTsuchishoDiv getJutakuKaishuJizenShoninKetteiTsuchisho() {
        return JutakuKaishuJizenShoninKetteiTsuchisho;
    }

    @JsonProperty("JutakuKaishuJizenShoninKetteiTsuchisho")
    public void setJutakuKaishuJizenShoninKetteiTsuchisho(JutakuKaishuJizenShoninKetteiTsuchishoDiv JutakuKaishuJizenShoninKetteiTsuchisho) {
        this.JutakuKaishuJizenShoninKetteiTsuchisho=JutakuKaishuJizenShoninKetteiTsuchisho;
    }

}
