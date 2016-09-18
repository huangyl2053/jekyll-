package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryohokenRirekiCommonChildDiv;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * IryohokenRirekiCommonChildDiv のクラスファイル
 *
 * @reamsid_L DBA-0230-010 hezhenzhen
 *
 */
public class IryohokenRirekiCommonChildDivDiv extends Panel implements IIryohokenRirekiCommonChildDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("plIryohokenRireki")
    private plIryohokenRirekiDiv plIryohokenRireki;
    @JsonProperty("モード")
    private RString モード;
    @JsonProperty("識別コード")
    private RString 識別コード;
    @JsonProperty("市町村コード")
    private RString 市町村コード;
    @JsonProperty("被保険者番号")
    private RString 被保険者番号;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getplIryohokenRireki
     * @return plIryohokenRireki
     */
    @JsonProperty("plIryohokenRireki")
    public plIryohokenRirekiDiv getPlIryohokenRireki() {
        return plIryohokenRireki;
    }

    /*
     * setplIryohokenRireki
     * @param plIryohokenRireki plIryohokenRireki
     */
    @JsonProperty("plIryohokenRireki")
    public void setPlIryohokenRireki(plIryohokenRirekiDiv plIryohokenRireki) {
        this.plIryohokenRireki = plIryohokenRireki;
    }

    /*
     * getモード
     * @return モード
     */
    @JsonProperty("モード")
    public RString getモード() {
        return モード;
    }

    /*
     * setモード
     * @param モード モード
     */
    @JsonProperty("モード")
    public void setモード(RString モード) {
        this.モード = モード;
    }

    /*
     * get識別コード
     * @return 識別コード
     */
    @JsonProperty("識別コード")
    public RString get識別コード() {
        return 識別コード;
    }

    /*
     * set識別コード
     * @param 識別コード 識別コード
     */
    @JsonProperty("識別コード")
    public void set識別コード(RString 識別コード) {
        this.識別コード = 識別コード;
    }

    /*
     * get市町村コード
     * @return 市町村コード
     */
    @JsonProperty("市町村コード")
    public RString get市町村コード() {
        return 市町村コード;
    }

    /*
     * set市町村コード
     * @param 市町村コード 市町村コード
     */
    @JsonProperty("市町村コード")
    public void set市町村コード(RString 市町村コード) {
        this.市町村コード = 市町村コード;
    }

    /*
     * get被保険者番号
     * @return 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public RString get被保険者番号() {
        return 被保険者番号;
    }

    /*
     * set被保険者番号
     * @param 被保険者番号 被保険者番号
     */
    @JsonProperty("被保険者番号")
    public void set被保険者番号(RString 被保険者番号) {
        this.被保険者番号 = 被保険者番号;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnIryohokenTsuika() {
        return this.getPlIryohokenRireki().getBtnIryohokenTsuika();
    }

    @JsonIgnore
    public void setBtnIryohokenTsuika(Button btnIryohokenTsuika) {
        this.getPlIryohokenRireki().setBtnIryohokenTsuika(btnIryohokenTsuika);
    }

    @JsonIgnore
    public DataGrid<dgIryohokenIchiran_Row> getDgIryohokenIchiran() {
        return this.getPlIryohokenRireki().getDgIryohokenIchiran();
    }

    @JsonIgnore
    public void setDgIryohokenIchiran(DataGrid<dgIryohokenIchiran_Row> dgIryohokenIchiran) {
        this.getPlIryohokenRireki().setDgIryohokenIchiran(dgIryohokenIchiran);
    }

    @JsonIgnore
    public pnlIryohokenJohoDiv getPnlIryohokenJoho() {
        return this.getPlIryohokenRireki().getPnlIryohokenJoho();
    }

    @JsonIgnore
    public void setPnlIryohokenJoho(pnlIryohokenJohoDiv pnlIryohokenJoho) {
        this.getPlIryohokenRireki().setPnlIryohokenJoho(pnlIryohokenJoho);
    }

    @JsonIgnore
    public Button getBtnIryohokenKakute() {
        return this.getPlIryohokenRireki().getBtnIryohokenKakute();
    }

    @JsonIgnore
    public void setBtnIryohokenKakute(Button btnIryohokenKakute) {
        this.getPlIryohokenRireki().setBtnIryohokenKakute(btnIryohokenKakute);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPlIryohokenRireki().getBtnCancel();
    }

    @JsonIgnore
    public void setBtnCancel(Button btnCancel) {
        this.getPlIryohokenRireki().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private IryohokenRirekiHandler createHandlerOf(IryohokenRirekiCommonChildDivDiv div) {
        return new IryohokenRirekiHandler(div);
    }

    @Override
    public void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号, LasdecCode 市町村コード) {
        createHandlerOf(this).initialize(モード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        this.set被保険者番号(被保険者番号.getColumnValue());
        this.set市町村コード(市町村コード.getColumnValue());
    }

    @Override
    public void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号) {
        createHandlerOf(this).initialize(モード, 識別コード);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        this.set被保険者番号(被保険者番号.getColumnValue());

        LasdecCode lasdecCode = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード();
        this.set市町村コード(lasdecCode.getColumnValue());
    }

    @Override
    public void initialize(RString モード, RString 識別コード, HihokenshaNo 被保険者番号, LasdecCode 市町村コード, List<dgIryohokenIchiran_Row> 医療保険履歴List) {
        createHandlerOf(this).initialize(モード, 識別コード, 医療保険履歴List);
        ViewStateHolder.put(ViewStateKeys.識別コード, 識別コード);
        this.set被保険者番号(被保険者番号.getColumnValue());
        this.set市町村コード(市町村コード.getColumnValue());
    }

    @Override
    public void save() {
        createHandlerOf(this).save(this);
    }

    /**
     * 医療保険情報を取得します。
     *
     * @return List<dgIryohokenIchiran_Row>
     */
    @Override
    public List<dgIryohokenIchiran_Row> getDataGridList() {
        return this.getDgIryohokenIchiran().getDataSource();
    }

    @Override
    public ArrayList<IryohokenKanyuJokyo> getSaveData() {
        return createHandlerOf(this).createSaveData(this);
    }

    @Override
    public boolean isSavable() {
        return createHandlerOf(this).isSavable(this);
    }
}
