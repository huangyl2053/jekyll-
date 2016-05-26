package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * TaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaIchiranDiv extends Panel implements ITaishoshaIchiranDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJukyushaIdoRenrakuhyoHenkoSearchResultList")
    private DataGrid<dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row> dgJukyushaIdoRenrakuhyoHenkoSearchResultList;

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

}
