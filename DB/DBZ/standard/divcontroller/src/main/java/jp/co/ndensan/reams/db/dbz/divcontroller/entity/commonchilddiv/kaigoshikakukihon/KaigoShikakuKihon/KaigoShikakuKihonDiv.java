package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.kaigoatenakihon.KaigoAtenaKihonBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.service.core.kaigoatenakihon.KaigoAtenaKihonFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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

/**
 * KaigoShikakuKihon のクラスファイル
 *
 * @reamsid_L DBA-0030-012 liangbc
 */
public class KaigoShikakuKihonDiv extends Panel implements IKaigoShikakuKihonDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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

    public static enum NinteiRirekiButtonWo implements ICommonChildDivMode {

        HyojiSuru("HyojiSuru"),
        HyojiShinai("HyojiShinai");

        private final String name;

        private NinteiRirekiButtonWo(final String name) {
            this.name = name;
        }

        public static NinteiRirekiButtonWo getEnum(String str) {
            NinteiRirekiButtonWo[] enumArray = NinteiRirekiButtonWo.values();

            for (NinteiRirekiButtonWo enumStr : enumArray) {
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

    public NinteiRirekiButtonWo getMode_NinteiRirekiButtonWo() {
        return (NinteiRirekiButtonWo) _CommonChildDivModeUtil.getMode(this.modes, NinteiRirekiButtonWo.class);
    }

    public void setMode_NinteiRirekiButtonWo(NinteiRirekiButtonWo value) {
        _CommonChildDivModeUtil.setMode(this.modes, NinteiRirekiButtonWo.class, value);
    }

    public static enum HihoRirekiButtonWo implements ICommonChildDivMode {

        HyojiSuru("HyojiSuru"),
        HyojiShinai("HyojiShinai");

        private final String name;

        private HihoRirekiButtonWo(final String name) {
            this.name = name;
        }

        public static HihoRirekiButtonWo getEnum(String str) {
            HihoRirekiButtonWo[] enumArray = HihoRirekiButtonWo.values();

            for (HihoRirekiButtonWo enumStr : enumArray) {
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

    public HihoRirekiButtonWo getMode_HihoRirekiButtonWo() {
        return (HihoRirekiButtonWo) _CommonChildDivModeUtil.getMode(this.modes, HihoRirekiButtonWo.class);
    }

    public void setMode_HihoRirekiButtonWo(HihoRirekiButtonWo value) {
        _CommonChildDivModeUtil.setMode(this.modes, HihoRirekiButtonWo.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private static final RDate 有効期間2009年04月 = new RDate(2009, 04, 01);
    private static final RDate 有効期間2006年04月 = new RDate(2006, 04, 01);
    private static final RDate 有効期間2002年04月 = new RDate(2002, 04, 01);
    private static final RDate 有効期間2000年04月 = new RDate(2000, 04, 01);

    /**
     * 介護資格基本の初期化
     *
     * @param 識別コード 識別コード
     */
    @Override
    @JsonIgnore
    public void initialize(ShikibetsuCode 識別コード) {
        KaigoAtenaKihonFinder finder = KaigoAtenaKihonFinder.createInstance();
        KaigoAtenaKihonBusiness result = null;
        try {
            result = finder.getKaigoShikakuKihon(識別コード);
        } catch (RuntimeException e) {
            if (e.getMessage().equals(UrErrorMessages.対象データなし.getMessage().evaluate())) {
                setReadOnly();
            } else {
                throw e;
            }
        }
        if (result != null) {
            initialization(result);
        }
    }

    /**
     * 介護資格基本の初期化
     *
     * @param 被保険者番号 被保険者番号
     */
    @Override
    @JsonIgnore
    public void initialize(HihokenshaNo 被保険者番号) {
        KaigoAtenaKihonFinder finder = KaigoAtenaKihonFinder.createInstance();
        KaigoAtenaKihonBusiness result = null;
        try {
            result = finder.getKaigoHihokenshaNo(被保険者番号);
        } catch (RuntimeException e) {
            if (e.getMessage().equals(UrErrorMessages.対象データなし.getMessage().evaluate())) {
                setReadOnly();
            }
        }
        if (result != null) {
            initialization(result);
        }
    }

    @Override
    @JsonIgnore
    public void set認定履歴ボタンDisable(boolean isdisabled) {
        if (isdisabled) {
            setMode_NinteiRirekiButtonWo(NinteiRirekiButtonWo.HyojiShinai);
        } else {
            setMode_NinteiRirekiButtonWo(NinteiRirekiButtonWo.HyojiSuru);
        }
    }

    @Override
    @JsonIgnore
    public void set被保履歴ボタンDisable(boolean isdisabled) {
        if (isdisabled) {
            setMode_HihoRirekiButtonWo(HihoRirekiButtonWo.HyojiShinai);
        } else {
            setMode_HihoRirekiButtonWo(HihoRirekiButtonWo.HyojiSuru);
        }
    }

    @Override
    @JsonIgnore
    public RString get被保険者番号() {
        return getTxtHihokenshaNo().getValue();
    }

    @Override
    @JsonIgnore
    public FlexibleDate get資格取得年月日() {
        return getTxtShutokuYmd().getValue();
    }

    @Override
    @JsonIgnore
    public FlexibleDate get資格喪失年月日() {
        return getTxtSoshitsuYmd().getValue();
    }

    @JsonIgnore
    private RString get要介護状態区分コード(RDate 認定有効期間終了年月日, Code 要介護認定状態区分コード) {
        if (認定有効期間終了年月日 == null || 要介護認定状態区分コード == null || 認定有効期間終了年月日.isBefore(有効期間2000年04月)) {
            return RString.EMPTY;
        }
        if (認定有効期間終了年月日.isBefore(有効期間2002年04月)) {
            return YokaigoJotaiKubun99.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        if (認定有効期間終了年月日.isBefore(有効期間2006年04月)) {
            return YokaigoJotaiKubun02.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        if (認定有効期間終了年月日.isBefore(有効期間2009年04月)) {
            return YokaigoJotaiKubun06.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
        }
        return YokaigoJotaiKubun09.toValue(要介護認定状態区分コード.getColumnValue()).get名称();
    }

    @JsonIgnore
    private void initialization(KaigoAtenaKihonBusiness result) {
        this.txtHihokenshaNo.setValue(result.get被保険者番号().getColumnValue());
        this.txtShutokuYmd.setValue(result.get資格取得年月日());
        if (!RString.isNullOrEmpty(result.get資格取得事由コード())) {
            this.txtShutokuJiyu.setValue(ShikakuShutokuJiyu.toValue(result.get資格取得事由コード()).get名称());
        } else {
            this.txtShutokuJiyu.setValue(RString.EMPTY);
        }
        this.txtSoshitsuYmd.setValue(result.get資格喪失年月日());
        if (!RString.isNullOrEmpty(result.get資格喪失事由コード())) {
            this.txtSoshitsuJiyu.setValue(ShikakuSoshitsuJiyu.toValue(result.get資格喪失事由コード()).get名称());
        } else {
            this.txtSoshitsuJiyu.setValue(RString.EMPTY);
        }
        this.txtJutokuKubun.setValue(new RString("1").equals(result.get住所地特例フラグ()) ? new RString("住特") : RString.EMPTY);
        RDate 認定有効期間開始年月日 = result.get認定有効期間開始年月日() == null ? null : new RDate(result.get認定有効期間開始年月日().toString());
        RDate 認定有効期間終了年月日 = result.get認定有効期間終了年月日() == null ? null : new RDate(result.get認定有効期間終了年月日().toString());
        this.txtYokaigoJotaiKubun.setValue(get要介護状態区分コード(認定有効期間終了年月日, result.get要介護認定状態区分コード()));
        this.txtNinteiKaishiYmd.setValue(認定有効期間開始年月日);
        this.txtNinteiShuryoYmd.setValue(認定有効期間終了年月日);
        setReadOnly();
    }

    @JsonIgnore
    private void setReadOnly() {
        this.txtHihokenshaNo.setReadOnly(true);
        this.txtShutokuYmd.setReadOnly(true);
        this.txtShutokuJiyu.setReadOnly(true);
        this.txtSoshitsuYmd.setReadOnly(true);
        this.txtSoshitsuJiyu.setReadOnly(true);
        this.txtJutokuKubun.setReadOnly(true);
        this.txtNinteiKaishiYmd.setReadOnly(true);
        this.txtNinteiShuryoYmd.setReadOnly(true);
    }
}
