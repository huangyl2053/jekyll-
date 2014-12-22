package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.business.searchkey.KaigoShikakuKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KaigoShikakuKihonHandler;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;

/**
 * KaigoShikakuKihon のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoShikakuKihonDiv extends Panel implements IKaigoShikakuKihonDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShutokuYmd")
    private TextBoxDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxDate txtSoshitsuYmd;
    @JsonProperty("txtSoshitsuJiyu")
    private TextBox txtSoshitsuJiyu;
    @JsonProperty("txtJutokuKubun")
    private TextBox txtJutokuKubun;
    @JsonProperty("txtYokaigoJotaiKubun")
    private TextBox txtYokaigoJotaiKubun;
    @JsonProperty("txtNinteiKaishiYmd")
    private TextBoxDate txtNinteiKaishiYmd;
    @JsonProperty("txtNinteiShuryoYmd")
    private TextBoxDate txtNinteiShuryoYmd;
    @JsonProperty("btnNinteiRireki")
    private ButtonDialog btnNinteiRireki;
    @JsonProperty("btnHihoRireki")
    private ButtonDialog btnHihoRireki;
    @JsonProperty("btnRenrakusaki")
    private ButtonDialog btnRenrakusaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    @JsonProperty("txtShutokuYmd")
    public TextBoxDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxDate txtShutokuYmd) {
        this.txtShutokuYmd = txtShutokuYmd;
    }

    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu = txtShutokuJiyu;
    }

    @JsonProperty("txtSoshitsuYmd")
    public TextBoxDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd = txtSoshitsuYmd;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu = txtSoshitsuJiyu;
    }

    @JsonProperty("txtJutokuKubun")
    public TextBox getTxtJutokuKubun() {
        return txtJutokuKubun;
    }

    @JsonProperty("txtJutokuKubun")
    public void setTxtJutokuKubun(TextBox txtJutokuKubun) {
        this.txtJutokuKubun = txtJutokuKubun;
    }

    @JsonProperty("txtYokaigoJotaiKubun")
    public TextBox getTxtYokaigoJotaiKubun() {
        return txtYokaigoJotaiKubun;
    }

    @JsonProperty("txtYokaigoJotaiKubun")
    public void setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.txtYokaigoJotaiKubun = txtYokaigoJotaiKubun;
    }

    @JsonProperty("txtNinteiKaishiYmd")
    public TextBoxDate getTxtNinteiKaishiYmd() {
        return txtNinteiKaishiYmd;
    }

    @JsonProperty("txtNinteiKaishiYmd")
    public void setTxtNinteiKaishiYmd(TextBoxDate txtNinteiKaishiYmd) {
        this.txtNinteiKaishiYmd = txtNinteiKaishiYmd;
    }

    @JsonProperty("txtNinteiShuryoYmd")
    public TextBoxDate getTxtNinteiShuryoYmd() {
        return txtNinteiShuryoYmd;
    }

    @JsonProperty("txtNinteiShuryoYmd")
    public void setTxtNinteiShuryoYmd(TextBoxDate txtNinteiShuryoYmd) {
        this.txtNinteiShuryoYmd = txtNinteiShuryoYmd;
    }

    @JsonProperty("btnNinteiRireki")
    public ButtonDialog getBtnNinteiRireki() {
        return btnNinteiRireki;
    }

    @JsonProperty("btnNinteiRireki")
    public void setBtnNinteiRireki(ButtonDialog btnNinteiRireki) {
        this.btnNinteiRireki = btnNinteiRireki;
    }

    @JsonProperty("btnHihoRireki")
    public ButtonDialog getBtnHihoRireki() {
        return btnHihoRireki;
    }

    @JsonProperty("btnHihoRireki")
    public void setBtnHihoRireki(ButtonDialog btnHihoRireki) {
        this.btnHihoRireki = btnHihoRireki;
    }

    @JsonProperty("btnRenrakusaki")
    public ButtonDialog getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum HihokenrirekiNashiMode implements ICommonChildDivMode {

        HihokenrirekiNashi("HihokenrirekiNashi");

        private final String name;

        private HihokenrirekiNashiMode(final String name) {
            this.name = name;
        }

        public static HihokenrirekiNashiMode getEnum(String str) {
            HihokenrirekiNashiMode[] enumArray = HihokenrirekiNashiMode.values();

            for (HihokenrirekiNashiMode enumStr : enumArray) {
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

    public HihokenrirekiNashiMode getMode_HihokenrirekiNashiMode() {
        return (HihokenrirekiNashiMode) _CommonChildDivModeUtil.getMode(this.modes, HihokenrirekiNashiMode.class);
    }

    public void setMode_HihokenrirekiNashiMode(HihokenrirekiNashiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, HihokenrirekiNashiMode.class, value);
    }

    public static enum RenrakusakiAriMode implements ICommonChildDivMode {

        RenrakusakiAri("RenrakusakiAri");

        private final String name;

        private RenrakusakiAriMode(final String name) {
            this.name = name;
        }

        public static RenrakusakiAriMode getEnum(String str) {
            RenrakusakiAriMode[] enumArray = RenrakusakiAriMode.values();

            for (RenrakusakiAriMode enumStr : enumArray) {
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

    public RenrakusakiAriMode getMode_RenrakusakiAriMode() {
        return (RenrakusakiAriMode) _CommonChildDivModeUtil.getMode(this.modes, RenrakusakiAriMode.class);
    }

    public void setMode_RenrakusakiAriMode(RenrakusakiAriMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, RenrakusakiAriMode.class, value);
    }

    public static enum NinteirirekiNashiMode implements ICommonChildDivMode {

        NinteirirekiAri("NinteirirekiAri");

        private final String name;

        private NinteirirekiNashiMode(final String name) {
            this.name = name;
        }

        public static NinteirirekiNashiMode getEnum(String str) {
            NinteirirekiNashiMode[] enumArray = NinteirirekiNashiMode.values();

            for (NinteirirekiNashiMode enumStr : enumArray) {
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

    public NinteirirekiNashiMode getMode_NinteirirekiNashiMode() {
        return (NinteirirekiNashiMode) _CommonChildDivModeUtil.getMode(this.modes, NinteirirekiNashiMode.class);
    }

    public void setMode_NinteirirekiNashiMode(NinteirirekiNashiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, NinteirirekiNashiMode.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(KaigoShikakuKihonSearchKey 検索キー) {
        getHandler().load(検索キー);
    }

    @JsonIgnore
    public KaigoShikakuKihonHandler getHandler() {
        return new KaigoShikakuKihonHandler(this);
    }
}
