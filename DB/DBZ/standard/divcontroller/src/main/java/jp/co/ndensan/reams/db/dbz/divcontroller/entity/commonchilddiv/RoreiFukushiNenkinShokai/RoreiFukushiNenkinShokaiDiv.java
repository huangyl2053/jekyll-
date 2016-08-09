package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RoreiFukushiNenkinShokai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.roreifukushinenkinjoho.RoreiFukushiNenkinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.service.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyushaManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * RoreiFukushiNenkinShokai のクラスファイル
 *
 * @reamsid_L DBA-0220-010 dongyabin
 * @author 自動生成
 */
public class RoreiFukushiNenkinShokaiDiv extends Panel implements IRoreiFukushiNenkinShokaiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelRireki")
    private panelRirekiDiv panelRireki;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelRireki
     * @return panelRireki
     */
    @JsonProperty("panelRireki")
    public panelRirekiDiv getPanelRireki() {
        return panelRireki;
    }

    /*
     * setpanelRireki
     * @param panelRireki panelRireki
     */
    @JsonProperty("panelRireki")
    public void setPanelRireki(panelRirekiDiv panelRireki) {
        this.panelRireki = panelRireki;
    }

    /*
     * getpanelInput
     * @return panelInput
     */
    @JsonProperty("panelInput")
    public panelInputDiv getPanelInput() {
        return panelInput;
    }

    /*
     * setpanelInput
     * @param panelInput panelInput
     */
    @JsonProperty("panelInput")
    public void setPanelInput(panelInputDiv panelInput) {
        this.panelInput = panelInput;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ModeC implements ICommonChildDivMode {

        init("init");

        private final String name;

        private ModeC(final String name) {
            this.name = name;
        }

        public static ModeC getEnum(String str) {
            ModeC[] enumArray = ModeC.values();

            for (ModeC enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public ModeC getMode_ModeC() {
        return (ModeC) _CommonChildDivModeUtil.getMode(this.modes, ModeC.class);
    }

    public void setMode_ModeC(ModeC value) {
        _CommonChildDivModeUtil.setMode(this.modes, ModeC.class, value);
    }

    public static enum ModeA implements ICommonChildDivMode {

        init("init");

        private final String name;

        private ModeA(final String name) {
            this.name = name;
        }

        public static ModeA getEnum(String str) {
            ModeA[] enumArray = ModeA.values();

            for (ModeA enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public ModeA getMode_ModeA() {
        return (ModeA) _CommonChildDivModeUtil.getMode(this.modes, ModeA.class);
    }

    public void setMode_ModeA(ModeA value) {
        _CommonChildDivModeUtil.setMode(this.modes, ModeA.class, value);
    }

    public static enum ModeB implements ICommonChildDivMode {

        update("update");

        private final String name;

        private ModeB(final String name) {
            this.name = name;
        }

        public static ModeB getEnum(String str) {
            ModeB[] enumArray = ModeB.values();

            for (ModeB enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) {
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public ModeB getMode_ModeB() {
        return (ModeB) _CommonChildDivModeUtil.getMode(this.modes, ModeB.class);
    }

    public void setMode_ModeB(ModeB value) {
        _CommonChildDivModeUtil.setMode(this.modes, ModeB.class, value);
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelRireki().getBtnAdd();
    }

    @JsonIgnore
    public void setBtnAdd(Button btnAdd) {
        this.getPanelRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridRireki_Row> getDatagridRireki() {
        return this.getPanelRireki().getDatagridRireki();
    }

    @JsonIgnore
    public void setDatagridRireki(DataGrid<datagridRireki_Row> datagridRireki) {
        this.getPanelRireki().setDatagridRireki(datagridRireki);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面を初期化します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     */
    @Override
    public void initialize(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {

        RoreiFukushiNenkinJohoMapperParameter param = RoreiFukushiNenkinJohoMapperParameter.createRoreiFukushiParam(
                shikibetsuCode,
                FlexibleDate.EMPTY, HihokenshaNo.EMPTY,
                FlexibleDate.EMPTY);
        this.setHihokenshaNo(hihokenshaNo == null ? RString.EMPTY : hihokenshaNo.getColumnValue());
        this.setShikibetsuCode(shikibetsuCode == null ? RString.EMPTY : shikibetsuCode
                .getColumnValue());
        List<RoreiFukushiNenkinJukyusha> 一覧情報 = getService()
                .getRoreiFukushiNenkinJoho(param);
        getHandler(this).set老齢福祉年金情報一覧表示グリッド(一覧情報);
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = Models.create(一覧情報);
        ViewStateHolder.put(ViewStateKeys.老齢福祉年金情報検索結果一覧, roreiFukushiNenkinJukyusha);
    }

    /**
     * 画面データをデータベースに格納します。
     */
    @Override
    public void click_Save() {
        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = ViewStateHolder.get(ViewStateKeys.老齢福祉年金情報検索結果一覧, Models.class);
        if (roreiFukushiNenkinJukyusha != null) {
            Iterator<RoreiFukushiNenkinJukyusha> iterater = roreiFukushiNenkinJukyusha.iterator();
            while (iterater.hasNext()) {
                getService().save老齢福祉年金受給者(iterater.next());
            }
        }
    }

    /**
     * 老福年金情報を取得します。
     *
     * @return List<datagridRireki_Row>
     */
    @Override
    public List<datagridRireki_Row> getDataGridList() {
        return this.getDatagridRireki().getDataSource();
    }

    private RoreiFukushiNenkinShokaiHandler getHandler(RoreiFukushiNenkinShokaiDiv div) {
        return new RoreiFukushiNenkinShokaiHandler(div);
    }

    private RoreiFukushiNenkinJukyushaManager getService() {
        return RoreiFukushiNenkinJukyushaManager.createInstance();
    }

    @Override
    public boolean isSavable() {

        Models<RoreiFukushiNenkinJukyushaIdentifier, RoreiFukushiNenkinJukyusha> roreiFukushiNenkinJukyusha
                = ViewStateHolder.get(ViewStateKeys.老齢福祉年金情報検索結果一覧, Models.class);
        if (roreiFukushiNenkinJukyusha != null) {
            Iterator<RoreiFukushiNenkinJukyusha> iterater = roreiFukushiNenkinJukyusha.iterator();
            while (iterater.hasNext()) {
                if (iterater.next().hasChanged()) {
                    return true;
                }
            }
        }
        return false;
    }
}
