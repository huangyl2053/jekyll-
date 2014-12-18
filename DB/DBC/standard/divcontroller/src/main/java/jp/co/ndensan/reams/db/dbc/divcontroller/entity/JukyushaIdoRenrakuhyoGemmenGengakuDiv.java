package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuSubDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JukyushaIdoRenrakuhyoGemmenGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoGemmenGengakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radGemmenShinseichuKubun")
    private RadioButton radGemmenShinseichuKubun;
    @JsonProperty("Button5")
    private Button Button5;
    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    private JukyushaIdoRenrakuhyoGemmenGengakuSubDiv JukyushaIdoRenrakuhyoGemmenGengakuSub;
    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    private JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radGemmenShinseichuKubun")
    public RadioButton getRadGemmenShinseichuKubun() {
        return radGemmenShinseichuKubun;
    }

    @JsonProperty("radGemmenShinseichuKubun")
    public void setRadGemmenShinseichuKubun(RadioButton radGemmenShinseichuKubun) {
        this.radGemmenShinseichuKubun=radGemmenShinseichuKubun;
    }

    @JsonProperty("Button5")
    public Button getButton5() {
        return Button5;
    }

    @JsonProperty("Button5")
    public void setButton5(Button Button5) {
        this.Button5=Button5;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    public JukyushaIdoRenrakuhyoGemmenGengakuSubDiv getJukyushaIdoRenrakuhyoGemmenGengakuSub() {
        return JukyushaIdoRenrakuhyoGemmenGengakuSub;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoGemmenGengakuSub")
    public void setJukyushaIdoRenrakuhyoGemmenGengakuSub(JukyushaIdoRenrakuhyoGemmenGengakuSubDiv JukyushaIdoRenrakuhyoGemmenGengakuSub) {
        this.JukyushaIdoRenrakuhyoGemmenGengakuSub=JukyushaIdoRenrakuhyoGemmenGengakuSub;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    public JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv getJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi() {
        return JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;
    }

    @JsonProperty("JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi")
    public void setJukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi(JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHiDiv JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi) {
        this.JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi=JukyushaIdoRenrakuhyoTokuteiNyushoshaServiceHi;
    }

}
