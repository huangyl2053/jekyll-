package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;

/**
 * TaishoshaIchiran のクラスファイル
 *
 * @reamsid_L DBC-4471-010 xupeng
 */
public class TaishoshaIchiranDiv extends Panel implements ITaishoshaIchiranDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResultList")
    private DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResultList;
    @JsonProperty("IdoFromYMD")
    private RString IdoFromYMD;
    @JsonProperty("IdoToYMD")
    private RString IdoToYMD;
    @JsonProperty("HihoNo")
    private RString HihoNo;
    @JsonProperty("MenuID")
    private RString MenuID;
    @JsonProperty("DeleteDateFlag")
    private RString DeleteDateFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgJukyushaIdoRenrakuhyoHenkoSearchResultList
     * @return dgJukyushaIdoRenrakuhyoHenkoSearchResultList
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResultList")
    public DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row> getDgJukyushaIdoRenrakuhyoHenkoSearchResultList() {
        return dgJukyushaIdoRenrakuhyoHenkoSearchResultList;
    }

    /*
     * setdgJukyushaIdoRenrakuhyoHenkoSearchResultList
     * @param dgJukyushaIdoRenrakuhyoHenkoSearchResultList dgJukyushaIdoRenrakuhyoHenkoSearchResultList
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResultList")
    public void setDgJukyushaIdoRenrakuhyoHenkoSearchResultList(DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResultList) {
        this.dgJukyushaIdoRenrakuhyoHenkoSearchResultList = dgJukyushaIdoRenrakuhyoHenkoSearchResultList;
    }

    /*
     * getIdoFromYMD
     * @return IdoFromYMD
     */
    @JsonProperty("IdoFromYMD")
    public RString getIdoFromYMD() {
        return IdoFromYMD;
    }

    /*
     * setIdoFromYMD
     * @param IdoFromYMD IdoFromYMD
     */
    @JsonProperty("IdoFromYMD")
    public void setIdoFromYMD(RString IdoFromYMD) {
        this.IdoFromYMD = IdoFromYMD;
    }

    /*
     * getIdoToYMD
     * @return IdoToYMD
     */
    @JsonProperty("IdoToYMD")
    public RString getIdoToYMD() {
        return IdoToYMD;
    }

    /*
     * setIdoToYMD
     * @param IdoToYMD IdoToYMD
     */
    @JsonProperty("IdoToYMD")
    public void setIdoToYMD(RString IdoToYMD) {
        this.IdoToYMD = IdoToYMD;
    }

    /*
     * getHihoNo
     * @return HihoNo
     */
    @JsonProperty("HihoNo")
    public RString getHihoNo() {
        return HihoNo;
    }

    /*
     * setHihoNo
     * @param HihoNo HihoNo
     */
    @JsonProperty("HihoNo")
    public void setHihoNo(RString HihoNo) {
        this.HihoNo = HihoNo;
    }

    /*
     * getMenuID
     * @return MenuID
     */
    @JsonProperty("MenuID")
    public RString getMenuID() {
        return MenuID;
    }

    /*
     * setMenuID
     * @param MenuID MenuID
     */
    @JsonProperty("MenuID")
    public void setMenuID(RString MenuID) {
        this.MenuID = MenuID;
    }

    /*
     * getDeleteDateFlag
     * @return DeleteDateFlag
     */
    @JsonProperty("DeleteDateFlag")
    public RString getDeleteDateFlag() {
        return DeleteDateFlag;
    }

    /*
     * setDeleteDateFlag
     * @param DeleteDateFlag DeleteDateFlag
     */
    @JsonProperty("DeleteDateFlag")
    public void setDeleteDateFlag(RString DeleteDateFlag) {
        this.DeleteDateFlag = DeleteDateFlag;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum State implements ICommonChildDivMode {

        ModifyMode("ModifyMode"),
        SelectMode("SelectMode");

        private final String name;

        private State(final String name) {
            this.name = name;
        }

        public static State getEnum(String str) {
            State[] enumArray = State.values();

            for (State enumStr : enumArray) {
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

    public State getMode_State() {
        return (State) _CommonChildDivModeUtil.getMode( this.modes, State.class );
    }

    public void setMode_State( State value ) {
        _CommonChildDivModeUtil.setMode( this.modes, State.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 表示モード RString
     * @param 削除データ検索 RString
     * @param 対象者一覧情報 List<KyodoJukyushaTaishoshaEntity>
     */
    @JsonIgnore
    @Override
    public void initialize(RString メニューID, HihokenshaNo 被保険者番号, FlexibleDate 異動日From,
            FlexibleDate 異動日To, RString 表示モード, RString 削除データ検索,
            List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報) {
        TaishoshaIchiranDivHandler.of(this).initialize(メニューID, 被保険者番号, 異動日From,
                異動日To, 表示モード, 削除データ検索, 対象者一覧情報);
    }
}
