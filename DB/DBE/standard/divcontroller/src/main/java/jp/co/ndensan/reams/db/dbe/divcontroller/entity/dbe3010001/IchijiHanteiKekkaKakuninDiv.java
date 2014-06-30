package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.IchijiHanteiKakuninTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe3010001.IchijiHanteiKakuninTaishoshaJohoDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ichijiHanteiKekkaInfo.IchijiHanteiKekkaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * IchijiHanteiKekkaKakunin のクラスファイル
 *
 * @author 自動生成
 */
public class IchijiHanteiKekkaKakuninDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtKensu")
    private TextBox txtKensu;
    @JsonProperty("IchijiHanteiKakuninTaishoshaJoho")
    private IchijiHanteiKakuninTaishoshaJohoDiv IchijiHanteiKakuninTaishoshaJoho;
    @JsonProperty("ccdIchijiHanteiKakuninJoho")
    private IchijiHanteiKekkaInfoDiv ccdIchijiHanteiKakuninJoho;
    @JsonProperty("hidIdxNo")
    private RString hidIdxNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKensu")
    public TextBox getTxtKensu() {
        return txtKensu;
    }

    @JsonProperty("txtKensu")
    public void setTxtKensu(TextBox txtKensu) {
        this.txtKensu = txtKensu;
    }

    @JsonProperty("IchijiHanteiKakuninTaishoshaJoho")
    public IchijiHanteiKakuninTaishoshaJohoDiv getIchijiHanteiKakuninTaishoshaJoho() {
        return IchijiHanteiKakuninTaishoshaJoho;
    }

    @JsonProperty("IchijiHanteiKakuninTaishoshaJoho")
    public void setIchijiHanteiKakuninTaishoshaJoho(IchijiHanteiKakuninTaishoshaJohoDiv IchijiHanteiKakuninTaishoshaJoho) {
        this.IchijiHanteiKakuninTaishoshaJoho = IchijiHanteiKakuninTaishoshaJoho;
    }

    @JsonProperty("ccdIchijiHanteiKakuninJoho")
    public IchijiHanteiKekkaInfoDiv getCcdIchijiHanteiKakuninJoho() {
        return ccdIchijiHanteiKakuninJoho;
    }

    @JsonProperty("ccdIchijiHanteiKakuninJoho")
    public void setCcdIchijiHanteiKakuninJoho(IchijiHanteiKekkaInfoDiv ccdIchijiHanteiKakuninJoho) {
        this.ccdIchijiHanteiKakuninJoho = ccdIchijiHanteiKakuninJoho;
    }

    @JsonProperty("hidIdxNo")
    public RString getHidIdxNo() {
        return hidIdxNo;
    }

    @JsonProperty("hidIdxNo")
    public void setHidIdxNo(RString hidIdxNo) {
        this.hidIdxNo = hidIdxNo;
    }

}
