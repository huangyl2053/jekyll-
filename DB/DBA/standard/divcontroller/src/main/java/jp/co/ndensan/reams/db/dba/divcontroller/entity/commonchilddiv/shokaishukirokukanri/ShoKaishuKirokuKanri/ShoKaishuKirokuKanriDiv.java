package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.shokaishukirokukanri.ShoKaishuKirokuKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuKirokuKanri のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuKirokuKanriDiv extends Panel implements IShoKaishuKirokuKanriDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKoufuList")
    private panelKoufuListDiv panelKoufuList;
    @JsonProperty("panelInput")
    private panelInputDiv panelInput;
    @JsonProperty("モード")
    private RString モード;
    @JsonProperty("被保険者番号")
    private RString 被保険者番号;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKoufuList
     * @return panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public panelKoufuListDiv getPanelKoufuList() {
        return panelKoufuList;
    }

    /*
     * setpanelKoufuList
     * @param panelKoufuList panelKoufuList
     */
    @JsonProperty("panelKoufuList")
    public void setPanelKoufuList(panelKoufuListDiv panelKoufuList) {
        this.panelKoufuList = panelKoufuList;
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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ModeA implements ICommonChildDivMode {

        SyoKai("SyoKai");

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
        return (ModeA) _CommonChildDivModeUtil.getMode( this.modes, ModeA.class );
    }

    public void setMode_ModeA( ModeA value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeA.class , value );
    }

    public static enum ModeB implements ICommonChildDivMode {

        Update("Update");

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
        return (ModeB) _CommonChildDivModeUtil.getMode( this.modes, ModeB.class );
    }

    public void setMode_ModeB( ModeB value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeB.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgKoufuKaishu_Row> getDgKoufuKaishu() {
        return this.getPanelKoufuList().getDgKoufuKaishu();
    }

    @JsonIgnore
    public void  setDgKoufuKaishu(DataGrid<dgKoufuKaishu_Row> dgKoufuKaishu) {
        this.getPanelKoufuList().setDgKoufuKaishu(dgKoufuKaishu);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
