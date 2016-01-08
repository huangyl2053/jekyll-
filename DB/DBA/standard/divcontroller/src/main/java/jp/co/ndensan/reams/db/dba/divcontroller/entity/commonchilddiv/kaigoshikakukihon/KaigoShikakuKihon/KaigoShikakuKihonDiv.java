package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigoatenakihon.KaigoAtenaKihonBusiness;
import jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dba.service.core.kaigoatenakihon.KaigoAtenaKihonFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * KaigoShikakuKihon のクラスファイル
 *
 * @author 自動生成
 */
public class KaigoShikakuKihonDiv extends Panel implements IKaigoShikakuKihonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShutokuYmd")
    private TextBoxFlexibleDate txtShutokuYmd;
    @JsonProperty("txtShutokuJiyu")
    private TextBox txtShutokuJiyu;
    @JsonProperty("txtSoshitsuYmd")
    private TextBoxFlexibleDate txtSoshitsuYmd;
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
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtShutokuYmd
     * @return txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public TextBoxFlexibleDate getTxtShutokuYmd() {
        return txtShutokuYmd;
    }

    /*
     * settxtShutokuYmd
     * @param txtShutokuYmd txtShutokuYmd
     */
    @JsonProperty("txtShutokuYmd")
    public void setTxtShutokuYmd(TextBoxFlexibleDate txtShutokuYmd) {
        this.txtShutokuYmd = txtShutokuYmd;
    }

    /*
     * gettxtShutokuJiyu
     * @return txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public TextBox getTxtShutokuJiyu() {
        return txtShutokuJiyu;
    }

    /*
     * settxtShutokuJiyu
     * @param txtShutokuJiyu txtShutokuJiyu
     */
    @JsonProperty("txtShutokuJiyu")
    public void setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.txtShutokuJiyu = txtShutokuJiyu;
    }

    /*
     * gettxtSoshitsuYmd
     * @return txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public TextBoxFlexibleDate getTxtSoshitsuYmd() {
        return txtSoshitsuYmd;
    }

    /*
     * settxtSoshitsuYmd
     * @param txtSoshitsuYmd txtSoshitsuYmd
     */
    @JsonProperty("txtSoshitsuYmd")
    public void setTxtSoshitsuYmd(TextBoxFlexibleDate txtSoshitsuYmd) {
        this.txtSoshitsuYmd = txtSoshitsuYmd;
    }

    /*
     * gettxtSoshitsuJiyu
     * @return txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public TextBox getTxtSoshitsuJiyu() {
        return txtSoshitsuJiyu;
    }

    /*
     * settxtSoshitsuJiyu
     * @param txtSoshitsuJiyu txtSoshitsuJiyu
     */
    @JsonProperty("txtSoshitsuJiyu")
    public void setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.txtSoshitsuJiyu = txtSoshitsuJiyu;
    }

    /*
     * gettxtJutokuKubun
     * @return txtJutokuKubun
     */
    @JsonProperty("txtJutokuKubun")
    public TextBox getTxtJutokuKubun() {
        return txtJutokuKubun;
    }

    /*
     * settxtJutokuKubun
     * @param txtJutokuKubun txtJutokuKubun
     */
    @JsonProperty("txtJutokuKubun")
    public void setTxtJutokuKubun(TextBox txtJutokuKubun) {
        this.txtJutokuKubun = txtJutokuKubun;
    }

    /*
     * gettxtYokaigoJotaiKubun
     * @return txtYokaigoJotaiKubun
     */
    @JsonProperty("txtYokaigoJotaiKubun")
    public TextBox getTxtYokaigoJotaiKubun() {
        return txtYokaigoJotaiKubun;
    }

    /*
     * settxtYokaigoJotaiKubun
     * @param txtYokaigoJotaiKubun txtYokaigoJotaiKubun
     */
    @JsonProperty("txtYokaigoJotaiKubun")
    public void setTxtYokaigoJotaiKubun(TextBox txtYokaigoJotaiKubun) {
        this.txtYokaigoJotaiKubun = txtYokaigoJotaiKubun;
    }

    /*
     * gettxtNinteiKaishiYmd
     * @return txtNinteiKaishiYmd
     */
    @JsonProperty("txtNinteiKaishiYmd")
    public TextBoxDate getTxtNinteiKaishiYmd() {
        return txtNinteiKaishiYmd;
    }

    /*
     * settxtNinteiKaishiYmd
     * @param txtNinteiKaishiYmd txtNinteiKaishiYmd
     */
    @JsonProperty("txtNinteiKaishiYmd")
    public void setTxtNinteiKaishiYmd(TextBoxDate txtNinteiKaishiYmd) {
        this.txtNinteiKaishiYmd = txtNinteiKaishiYmd;
    }

    /*
     * gettxtNinteiShuryoYmd
     * @return txtNinteiShuryoYmd
     */
    @JsonProperty("txtNinteiShuryoYmd")
    public TextBoxDate getTxtNinteiShuryoYmd() {
        return txtNinteiShuryoYmd;
    }

    /*
     * settxtNinteiShuryoYmd
     * @param txtNinteiShuryoYmd txtNinteiShuryoYmd
     */
    @JsonProperty("txtNinteiShuryoYmd")
    public void setTxtNinteiShuryoYmd(TextBoxDate txtNinteiShuryoYmd) {
        this.txtNinteiShuryoYmd = txtNinteiShuryoYmd;
    }

    /*
     * getbtnNinteiRireki
     * @return btnNinteiRireki
     */
    @JsonProperty("btnNinteiRireki")
    public ButtonDialog getBtnNinteiRireki() {
        return btnNinteiRireki;
    }

    /*
     * setbtnNinteiRireki
     * @param btnNinteiRireki btnNinteiRireki
     */
    @JsonProperty("btnNinteiRireki")
    public void setBtnNinteiRireki(ButtonDialog btnNinteiRireki) {
        this.btnNinteiRireki = btnNinteiRireki;
    }

    /*
     * getbtnHihoRireki
     * @return btnHihoRireki
     */
    @JsonProperty("btnHihoRireki")
    public ButtonDialog getBtnHihoRireki() {
        return btnHihoRireki;
    }

    /*
     * setbtnHihoRireki
     * @param btnHihoRireki btnHihoRireki
     */
    @JsonProperty("btnHihoRireki")
    public void setBtnHihoRireki(ButtonDialog btnHihoRireki) {
        this.btnHihoRireki = btnHihoRireki;
    }

    /*
     * getbtnRenrakusaki
     * @return btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public ButtonDialog getBtnRenrakusaki() {
        return btnRenrakusaki;
    }

    /*
     * setbtnRenrakusaki
     * @param btnRenrakusaki btnRenrakusaki
     */
    @JsonProperty("btnRenrakusaki")
    public void setBtnRenrakusaki(ButtonDialog btnRenrakusaki) {
        this.btnRenrakusaki = btnRenrakusaki;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 連絡先ボタンを implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 連絡先ボタンを(final String name) {
            this.name = name;
        }

        public static 連絡先ボタンを getEnum(String str) {
            連絡先ボタンを[] enumArray = 連絡先ボタンを.values();

            for (連絡先ボタンを enumStr : enumArray) {
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

    public 連絡先ボタンを getMode_連絡先ボタンを() {
        return (連絡先ボタンを) _CommonChildDivModeUtil.getMode(this.modes, 連絡先ボタンを.class);
    }

    public void setMode_連絡先ボタンを(連絡先ボタンを value) {
        _CommonChildDivModeUtil.setMode(this.modes, 連絡先ボタンを.class, value);
    }

    public static enum 認定履歴ボタンを implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 認定履歴ボタンを(final String name) {
            this.name = name;
        }

        public static 認定履歴ボタンを getEnum(String str) {
            認定履歴ボタンを[] enumArray = 認定履歴ボタンを.values();

            for (認定履歴ボタンを enumStr : enumArray) {
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

    public 認定履歴ボタンを getMode_認定履歴ボタンを() {
        return (認定履歴ボタンを) _CommonChildDivModeUtil.getMode(this.modes, 認定履歴ボタンを.class);
    }

    public void setMode_認定履歴ボタンを(認定履歴ボタンを value) {
        _CommonChildDivModeUtil.setMode(this.modes, 認定履歴ボタンを.class, value);
    }

    public static enum 被保履歴ボタンを implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 被保履歴ボタンを(final String name) {
            this.name = name;
        }

        public static 被保履歴ボタンを getEnum(String str) {
            被保履歴ボタンを[] enumArray = 被保履歴ボタンを.values();

            for (被保履歴ボタンを enumStr : enumArray) {
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

    public 被保履歴ボタンを getMode_被保履歴ボタンを() {
        return (被保履歴ボタンを) _CommonChildDivModeUtil.getMode(this.modes, 被保履歴ボタンを.class);
    }

    public void setMode_被保履歴ボタンを(被保履歴ボタンを value) {
        _CommonChildDivModeUtil.setMode(this.modes, 被保履歴ボタンを.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 介護資格基本の初期化
     *
     * @param 識別コード 識別コード
     */
    @Override
    public void onLoad(ShikibetsuCode 識別コード) {
        KaigoAtenaKihonFinder finder = KaigoAtenaKihonFinder.createInstance();
        SearchResult<KaigoAtenaKihonBusiness> result = finder.getKaigoShikakuKihon(識別コード);
        List<KaigoAtenaKihonBusiness> list = result.records();
        if (list.isEmpty()) {
            return;
        }
        KaigoAtenaKihonBusiness kihonBusiness = list.get(0);
        this.txtHihokenshaNo.setValue(kihonBusiness.get被保険者番号().getColumnValue());
        this.txtHihokenshaNo.setReadOnly(true);
        this.txtShutokuYmd.setValue(kihonBusiness.get資格取得年月日());
        this.txtShutokuYmd.setReadOnly(true);
        this.txtShutokuJiyu.setValue(ShikakuShutokuJiyu.toValue(kihonBusiness.get資格取得事由コード()).get名称());
        this.txtShutokuJiyu.setReadOnly(true);
        this.txtSoshitsuYmd.setValue(kihonBusiness.get資格喪失年月日());
        this.txtSoshitsuYmd.setReadOnly(true);
        this.txtSoshitsuJiyu.setValue(ShikakuSoshitsuJiyu.toValue(kihonBusiness.get資格喪失事由コード()).getName());
        this.txtSoshitsuJiyu.setReadOnly(true);
        this.txtJutokuKubun.setValue(kihonBusiness.get住所地特例フラグ().equals(new RString("1")) ? new RString("住特") : RString.EMPTY);
        this.txtJutokuKubun.setReadOnly(true);
        //TODO 要介護認定状態区分?
        //this.txtYokaigoJotaiKubun
        this.txtYokaigoJotaiKubun.setReadOnly(true);
        this.txtNinteiKaishiYmd.setValue(new RDate(kihonBusiness.get認定有効期間開始年月日().toString()));
        this.txtNinteiKaishiYmd.setReadOnly(true);
        this.txtNinteiShuryoYmd.setValue(new RDate(kihonBusiness.get認定有効期間終了年月日().toString()));
        this.txtNinteiShuryoYmd.setReadOnly(true);
    }
}
