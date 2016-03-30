package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShotokuJohoChushutsu のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShotokuJohoChushutsuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    private ShotokuJohoChushutsuBatchParameterDiv ShotokuJohoChushutsuBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuJohoChushutsuBatchParameter
     * @return ShotokuJohoChushutsuBatchParameter
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    public ShotokuJohoChushutsuBatchParameterDiv getShotokuJohoChushutsuBatchParameter() {
        return ShotokuJohoChushutsuBatchParameter;
    }

    /*
     * setShotokuJohoChushutsuBatchParameter
     * @param ShotokuJohoChushutsuBatchParameter ShotokuJohoChushutsuBatchParameter
     */
    @JsonProperty("ShotokuJohoChushutsuBatchParameter")
    public void setShotokuJohoChushutsuBatchParameter(ShotokuJohoChushutsuBatchParameterDiv ShotokuJohoChushutsuBatchParameter) {
        this.ShotokuJohoChushutsuBatchParameter = ShotokuJohoChushutsuBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShoriNendo() {
        return this.getShotokuJohoChushutsuBatchParameter().getTxtShoriNendo();
    }

    @JsonIgnore
    public void  setTxtShoriNendo(TextBoxDate txtShoriNendo) {
        this.getShotokuJohoChushutsuBatchParameter().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShotokuJohoChushutsuBatchParameter().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getShotokuJohoChushutsuBatchParameter().setLin1(lin1);
    }

    @JsonIgnore
    public ShichosonIchiranDiv getShichosonIchiran() {
        return this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran();
    }

    @JsonIgnore
    public void  setShichosonIchiran(ShichosonIchiranDiv ShichosonIchiran) {
        this.getShotokuJohoChushutsuBatchParameter().setShichosonIchiran(ShichosonIchiran);
    }

    @JsonIgnore
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran().getDgShichosonIchiran();
    }

    @JsonIgnore
    public void  setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.getShotokuJohoChushutsuBatchParameter().getShichosonIchiran().setDgShichosonIchiran(dgShichosonIchiran);
    }

    @JsonIgnore
    public ShotokuRenkeiJohoIchiranDiv getShotokuRenkeiJohoIchiran() {
        return this.getShotokuJohoChushutsuBatchParameter().getShotokuRenkeiJohoIchiran();
    }

    @JsonIgnore
    public void  setShotokuRenkeiJohoIchiran(ShotokuRenkeiJohoIchiranDiv ShotokuRenkeiJohoIchiran) {
        this.getShotokuJohoChushutsuBatchParameter().setShotokuRenkeiJohoIchiran(ShotokuRenkeiJohoIchiran);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShotokuJohoChushutsuBatchParameter().getShotokuRenkeiJohoIchiran().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
