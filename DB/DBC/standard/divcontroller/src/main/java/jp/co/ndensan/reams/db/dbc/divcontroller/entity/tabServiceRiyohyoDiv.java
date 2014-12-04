package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoGokeiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoMeisaiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoBeppyoRiyoNissuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgServiceRiyohyoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabServiceRiyohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabServiceRiyohyoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ServiceRiyohyo")
    private ServiceRiyohyoDiv ServiceRiyohyo;
    @JsonProperty("ServiceRiyohyoBeppyo")
    private ServiceRiyohyoBeppyoDiv ServiceRiyohyoBeppyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ServiceRiyohyo")
    public ServiceRiyohyoDiv getServiceRiyohyo() {
        return ServiceRiyohyo;
    }

    @JsonProperty("ServiceRiyohyo")
    public void setServiceRiyohyo(ServiceRiyohyoDiv ServiceRiyohyo) {
        this.ServiceRiyohyo=ServiceRiyohyo;
    }

    @JsonProperty("ServiceRiyohyoBeppyo")
    public ServiceRiyohyoBeppyoDiv getServiceRiyohyoBeppyo() {
        return ServiceRiyohyoBeppyo;
    }

    @JsonProperty("ServiceRiyohyoBeppyo")
    public void setServiceRiyohyoBeppyo(ServiceRiyohyoBeppyoDiv ServiceRiyohyoBeppyo) {
        this.ServiceRiyohyoBeppyo=ServiceRiyohyoBeppyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblServiceRiyohyoList() {
        return this.getServiceRiyohyo().getLblServiceRiyohyoList();
    }

    @JsonIgnore
    public void  setLblServiceRiyohyoList(Label lblServiceRiyohyoList) {
        this.getServiceRiyohyo().setLblServiceRiyohyoList(lblServiceRiyohyoList);
    }

    @JsonIgnore
    public Button getBtnRiyohyoMeisaiAdd() {
        return this.getServiceRiyohyo().getBtnRiyohyoMeisaiAdd();
    }

    @JsonIgnore
    public void  setBtnRiyohyoMeisaiAdd(Button btnRiyohyoMeisaiAdd) {
        this.getServiceRiyohyo().setBtnRiyohyoMeisaiAdd(btnRiyohyoMeisaiAdd);
    }

    @JsonIgnore
    public DataGrid<dgServiceRiyohyoList_Row> getDgServiceRiyohyoList() {
        return this.getServiceRiyohyo().getDgServiceRiyohyoList();
    }

    @JsonIgnore
    public void  setDgServiceRiyohyoList(DataGrid<dgServiceRiyohyoList_Row> dgServiceRiyohyoList) {
        this.getServiceRiyohyo().setDgServiceRiyohyoList(dgServiceRiyohyoList);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoRiyoNissuDiv getServiceRiyohyoBeppyoRiyoNissu() {
        return this.getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoRiyoNissu();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu) {
        this.getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissu);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoListDiv getServiceRiyohyoBeppyoList() {
        return this.getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoList();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList) {
        this.getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoList);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoMeisaiDiv getServiceRiyohyoBeppyoMeisai() {
        return this.getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoMeisai();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai) {
        this.getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisai);
    }

    @JsonIgnore
    public ServiceRiyohyoBeppyoGokeiDiv getServiceRiyohyoBeppyoGokei() {
        return this.getServiceRiyohyoBeppyo().getServiceRiyohyoBeppyoGokei();
    }

    @JsonIgnore
    public void  setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei) {
        this.getServiceRiyohyoBeppyo().setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokei);
    }

}
