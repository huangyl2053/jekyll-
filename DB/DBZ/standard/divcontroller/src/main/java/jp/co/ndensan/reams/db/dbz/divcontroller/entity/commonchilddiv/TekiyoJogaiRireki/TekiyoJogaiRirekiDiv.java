package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IShisetsuJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.ShisetsuJohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * TekiyoJogaiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiRirekiDiv extends Panel implements ITekiyoJogaiRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelTekiyoRireki")
    private panelTekiyoRirekiDiv panelTekiyoRireki;
    @JsonProperty("panelTekiyoInput")
    private panelTekiyoInputDiv panelTekiyoInput;
    @JsonProperty("panelTekiyoJokaiTekiInput")
    private panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput;
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    private panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput;
    @JsonProperty("TekiyoJogaiTorokuHenkoIchiran")
    private TekiyoJogaiTorokuHenkoIchiranDiv TekiyoJogaiTorokuHenkoIchiran;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelTekiyoRireki
     * @return panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public panelTekiyoRirekiDiv getPanelTekiyoRireki() {
        return panelTekiyoRireki;
    }

    /*
     * setpanelTekiyoRireki
     * @param panelTekiyoRireki panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public void setPanelTekiyoRireki(panelTekiyoRirekiDiv panelTekiyoRireki) {
        this.panelTekiyoRireki = panelTekiyoRireki;
    }

    /*
     * getpanelTekiyoInput
     * @return panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public panelTekiyoInputDiv getPanelTekiyoInput() {
        return panelTekiyoInput;
    }

    /*
     * setpanelTekiyoInput
     * @param panelTekiyoInput panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public void setPanelTekiyoInput(panelTekiyoInputDiv panelTekiyoInput) {
        this.panelTekiyoInput = panelTekiyoInput;
    }

    /*
     * getpanelTekiyoJokaiTekiInput
     * @return panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public panelTekiyoJokaiTekiInputDiv getPanelTekiyoJokaiTekiInput() {
        return panelTekiyoJokaiTekiInput;
    }

    /*
     * setpanelTekiyoJokaiTekiInput
     * @param panelTekiyoJokaiTekiInput panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public void setPanelTekiyoJokaiTekiInput(panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput) {
        this.panelTekiyoJokaiTekiInput = panelTekiyoJokaiTekiInput;
    }

    /*
     * getpanelTekiyoJokaiKaiJyoInput
     * @return panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public panelTekiyoJokaiKaiJyoInputDiv getPanelTekiyoJokaiKaiJyoInput() {
        return panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * setpanelTekiyoJokaiKaiJyoInput
     * @param panelTekiyoJokaiKaiJyoInput panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public void setPanelTekiyoJokaiKaiJyoInput(panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput) {
        this.panelTekiyoJokaiKaiJyoInput = panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * getTekiyoJogaiTorokuHenkoIchiran
     * @return TekiyoJogaiTorokuHenkoIchiran
     */
    @JsonProperty("TekiyoJogaiTorokuHenkoIchiran")
    public TekiyoJogaiTorokuHenkoIchiranDiv getTekiyoJogaiTorokuHenkoIchiran() {
        return TekiyoJogaiTorokuHenkoIchiran;
    }

    /*
     * setTekiyoJogaiTorokuHenkoIchiran
     * @param TekiyoJogaiTorokuHenkoIchiran TekiyoJogaiTorokuHenkoIchiran
     */
    @JsonProperty("TekiyoJogaiTorokuHenkoIchiran")
    public void setTekiyoJogaiTorokuHenkoIchiran(TekiyoJogaiTorokuHenkoIchiranDiv TekiyoJogaiTorokuHenkoIchiran) {
        this.TekiyoJogaiTorokuHenkoIchiran = TekiyoJogaiTorokuHenkoIchiran;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 除外異動訂正 implements ICommonChildDivMode {

        訂正("訂正");

        private final String name;

        private 除外異動訂正(final String name) {
            this.name = name;
        }

        public static 除外異動訂正 getEnum(String str) {
            除外異動訂正[] enumArray = 除外異動訂正.values();

            for (除外異動訂正 enumStr : enumArray) {
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

    public 除外異動訂正 getMode_除外異動訂正() {
        return (除外異動訂正) _CommonChildDivModeUtil.getMode( this.modes, 除外異動訂正.class );
    }

    public void setMode_除外異動訂正( 除外異動訂正 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 除外異動訂正.class , value );
    }

    public static enum 除外施設退所解除 implements ICommonChildDivMode {

        解除("解除");

        private final String name;

        private 除外施設退所解除(final String name) {
            this.name = name;
        }

        public static 除外施設退所解除 getEnum(String str) {
            除外施設退所解除[] enumArray = 除外施設退所解除.values();

            for (除外施設退所解除 enumStr : enumArray) {
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

    public 除外施設退所解除 getMode_除外施設退所解除() {
        return (除外施設退所解除) _CommonChildDivModeUtil.getMode( this.modes, 除外施設退所解除.class );
    }

    public void setMode_除外施設退所解除( 除外施設退所解除 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 除外施設退所解除.class , value );
    }

    public static enum 除外施設変更変更 implements ICommonChildDivMode {

        変更("変更");

        private final String name;

        private 除外施設変更変更(final String name) {
            this.name = name;
        }

        public static 除外施設変更変更 getEnum(String str) {
            除外施設変更変更[] enumArray = 除外施設変更変更.values();

            for (除外施設変更変更 enumStr : enumArray) {
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

    public 除外施設変更変更 getMode_除外施設変更変更() {
        return (除外施設変更変更) _CommonChildDivModeUtil.getMode( this.modes, 除外施設変更変更.class );
    }

    public void setMode_除外施設変更変更( 除外施設変更変更 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 除外施設変更変更.class , value );
    }

    public static enum ModeD implements ICommonChildDivMode {

        Hyoji("Hyoji");

        private final String name;

        private ModeD(final String name) {
            this.name = name;
        }

        public static ModeD getEnum(String str) {
            ModeD[] enumArray = ModeD.values();

            for (ModeD enumStr : enumArray) {
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

    public ModeD getMode_ModeD() {
        return (ModeD) _CommonChildDivModeUtil.getMode( this.modes, ModeD.class );
    }

    public void setMode_ModeD( ModeD value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeD.class , value );
    }

    public static enum ModeC implements ICommonChildDivMode {

        HenKo("HenKo");

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
        return (ModeC) _CommonChildDivModeUtil.getMode( this.modes, ModeC.class );
    }

    public void setMode_ModeC( ModeC value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ModeC.class , value );
    }

    public static enum ModeA implements ICommonChildDivMode {

        Shinki("Shinki");

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

        Kaijo("Kaijo");

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

    public static enum 除外施設入所適用 implements ICommonChildDivMode {

        適用("適用");

        private final String name;

        private 除外施設入所適用(final String name) {
            this.name = name;
        }

        public static 除外施設入所適用 getEnum(String str) {
            除外施設入所適用[] enumArray = 除外施設入所適用.values();

            for (除外施設入所適用 enumStr : enumArray) {
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

    public 除外施設入所適用 getMode_除外施設入所適用() {
        return (除外施設入所適用) _CommonChildDivModeUtil.getMode( this.modes, 除外施設入所適用.class );
    }

    public void setMode_除外施設入所適用( 除外施設入所適用 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 除外施設入所適用.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelTekiyoRireki().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelTekiyoRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridTekiyoJogai_Row> getDatagridTekiyoJogai() {
        return this.getPanelTekiyoRireki().getDatagridTekiyoJogai();
    }

    @JsonIgnore
    public void  setDatagridTekiyoJogai(DataGrid<datagridTekiyoJogai_Row> datagridTekiyoJogai) {
        this.getPanelTekiyoRireki().setDatagridTekiyoJogai(datagridTekiyoJogai);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyusyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtNyusyoDateInput();
    }

    @JsonIgnore
    public void  setTxtNyusyoDateInput(TextBoxDate txtNyusyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtNyusyoDateInput(txtNyusyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTekiyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTekiyoDateInput(TextBoxDate txtTekiyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTekiyoDateInput(txtTekiyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTkyoTododkDateIn() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTkyoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtTkyoTododkDateIn(TextBoxDate txtTkyoTododkDateIn) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTkyoTododkDateIn(txtTkyoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyuInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getDdlTekiyoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyuInput(DropDownList ddlTekiyoJiyuInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setDdlTekiyoJiyuInput(ddlTekiyoJiyuInput);
    }

    @JsonIgnore
    public IShisetsuJohoDiv getCcdShisetsuJoho() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtTaisyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTaisyoDateInput(TextBoxDate txtTaisyoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtTaisyoDateInput(txtTaisyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoDateInput();
    }

    @JsonIgnore
    public void  setTxtKaijoDateInput(TextBoxDate txtKaijoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoDateInput(txtKaijoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoTododkDateIn() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtKaijoTododkDateIn(TextBoxDate txtKaijoTododkDateIn) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoTododkDateIn(txtKaijoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyuInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getDdlKaijoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyuInput(DropDownList ddlKaijoJiyuInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setDdlKaijoJiyuInput(ddlKaijoJiyuInput);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
