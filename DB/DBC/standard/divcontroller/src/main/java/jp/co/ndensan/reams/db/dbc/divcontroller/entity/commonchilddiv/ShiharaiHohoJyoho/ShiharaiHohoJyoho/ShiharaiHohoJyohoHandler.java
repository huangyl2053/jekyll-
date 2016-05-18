package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihoho.UzT0007CodeBusiness;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.kozajohopsm.KozaJohoPSM;
import jp.co.ndensan.reams.db.dbc.definition.core.kozabunrui.KozaBunruiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho.ShiharaiHohoJyohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanShitenManager;
import jp.co.ndensan.reams.ur.urz.business.IUrControlData;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 支払方法情報のコントローラです。
 *
 * @reamsid_L DBC-0300-010 houtianpeng
 */
public class ShiharaiHohoJyohoHandler {

    private final RString ゆうちょ銀行 = new RString("9900");
    private final CodeShubetsu 預金種別 = new CodeShubetsu("0085");
    private final RString 修正 = new RString("修正");
    private final RString 照会 = new RString("照会");
    private final RString 登録 = new RString("登録");
    private final RString 償還払給付費 = new RString("001");
    private final RString 高額給付費 = new RString("002");
    private final RString 高額合算給付費 = new RString("003");
    private final RString 償還払い状況照会 = new RString("DBCMN11006");
    private final RString 福祉用具購入費支給申請 = new RString("DBCMN51001");
    private final RString 住宅改修費支給申請 = new RString("DBCMN52002");
    private final RString 住宅改修費事前申請 = new RString("DBCMN52001");
    private final RString 償還払い費支給申請 = new RString("DBCMN53001");
    private final RString 高額サービス費支給申請 = new RString("DBCMN42001");
    private final RString 高額合算支給申請1 = new RString("DBCMN61001");
    private final RString 高額合算支給申請2 = new RString("DBCMN61002");
    private final RString 高額合算支給申請3 = new RString("DBCMN61003");
    private final RString 高額合算支給申請4 = new RString("DBCMN61004");
    private final RString 高額合算支給申請5 = new RString("DBCMN61005");
    private final RString 高額合算支給申請6 = new RString("DBCMN61006");
    private final RString 高額合算支給申請7 = new RString("DBCMN61007");
    private final RString 高額合算支給申請8 = new RString("DBCMN61008");
    private final RString 高額合算支給申請9 = new RString("DBCMN61009");
    private final RString 高額合算支給申請10 = new RString("DBCMN61010");
    private final RString 高額合算支給申請11 = new RString("DBCMN61011");
    private final RString 高額合算支給申請12 = new RString("DBCMN61012");
    private final RString 高額合算支給決定情報補正 = new RString("DBCMN62004");
    private final RString 曜日_日 = new RString("日曜");
    private final RString 曜日_土 = new RString("土曜");
    private final ShiharaiHohoJyohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 支払方法情報画面
     */
    public ShiharaiHohoJyohoHandler(ShiharaiHohoJyohoDiv div) {
        this.div = div;
    }

    /**
     * 画面モードで画面初期化表示します。
     *
     *
     * @param 支給申請情報 支給申請情報
     * @param 状態 状態
     */
    public void initialize(SikyuSinseiJyohoParameter 支給申請情報, RString 状態) {
        div.setサブ業務コード(SubGyomuCode.DBC介護給付.value());
        div.set識別コード(支給申請情報.getShikibetsuCode() == null ? RString.EMPTY : 支給申請情報.getShikibetsuCode().value());
        KamokuCode 業務内区分コード = KamokuCode.EMPTY;

        業務内区分コード = get業務内区分コード(業務内区分コード);

        set口座ID(支給申請情報, 業務内区分コード);

        ViewStateHolder.put(ViewStateKeys.支給申請情報パラメータ, 支給申請情報);
        if (状態.equals(修正) || 状態.equals(照会)) {

            ShiharaiHohoKubun 支払方法区分 = 支給申請情報.getShiharaiHohoKubun();
            if (ShiharaiHohoKubun.窓口払.equals(支払方法区分)) {
                div.getRadMadoguti().setSelectedKey(支払方法区分.getコード());
                窓口払いエリアの初期化(支給申請情報);
            }
            if (ShiharaiHohoKubun.口座払.equals(支払方法区分)) {
                div.getRadKoza().setSelectedKey(支払方法区分.getコード());
                口座払いエリアの初期化(ShiharaiHohoJyohoFinder.createInstance()
                        .getKozaJyoho(KozaParameter.createParam(支給申請情報.
                                        getKozaId(), null, null)).records().get(0), 支給申請情報.getKozaId());
            }
            if (ShiharaiHohoKubun.受領委任払.equals(支払方法区分)) {
                div.getRadJyryoinin().setSelectedKey(支払方法区分.getコード());
                JuryoininKeiyakuJigyosha 受領委任契約事業者 = ShiharaiHohoJyohoFinder.createInstance().
                        getKeiyakuJigyosya(new KeiyakushaParameter(null, null, null, null).
                                createParam(支給申請情報.getHihokenshaNo(), 支給申請情報.
                                        getShikyushinseiServiceYM(), 支給申請情報.getShikyushinseiSeiriNo(), 支給申請情報.getShiharaiBasho()));
                受領委任払いエリアの初期化(支給申請情報, 受領委任契約事業者);
            }
        }
        if ((業務内区分コード.equals(new KamokuCode(償還払給付費)) || 業務内区分コード.equals(new KamokuCode(高額給付費)))) {

            if (状態.equals(照会)) {

                償還払給付または高額給付の照会モード();
            }
            if (状態.equals(登録)) {

                償還払給付または高額給付の登録モード();
            }
            if (状態.equals(修正)) {

                償還払給付または高額給付の修正モード(支給申請情報.getShiharaiHohoKubun());
            }
        }
        if (業務内区分コード.equals(new KamokuCode(高額合算給付費))) {

            if (状態.equals(照会)) {

                高額合算の照会モード();
            }
            if (状態.equals(登録)) {

                高額合算の登録モード();
            }
            if (状態.equals(修正)) {

                高額合算の修正モード(支給申請情報.getShiharaiHohoKubun());
            }
        }
    }

    /**
     * 画面口座IDを設定します。
     *
     * @param list 口座IDリスト
     * @return List<KeyValueDataSource>
     */
    public List<KeyValueDataSource> set口座ID(List<KozaJohoPSM> list) {
        List<KeyValueDataSource> 口座IDリスト = new ArrayList<>();
        for (KozaJohoPSM kozaId : list) {
            RString 口座ID = new RString(String.valueOf(kozaId.get口座ID()));
            口座IDリスト.add(new KeyValueDataSource(口座ID, 口座ID));
        }
        return 口座IDリスト;
    }

    /**
     * 口座払い情報をクリアします。
     *
     */
    public void clear口座払い() {
        div.getTxtKinyuKikanCode().clearDomain();
        div.getTxtKinyuKikanShitenCode().clearDomain();
        div.getTxtYokinShubetsu().clearValue();
        div.getTxtKozaNo().clearValue();
        div.getTxtKinyuKikanName().clearValue();
        div.getTxtMeigininKana().clearDomain();
        div.getTtxtMeigininKanji().clearDomain();
    }

    /**
     * 受領委任払い情報をクリアします。
     *
     */
    public void clear受領委任払い() {
        div.getTxtKeiyakuName().clearDomain();
        div.getTxtKinyuKikanCode1().clearDomain();
        div.getTxtKinyuKikanShitenCode1().clearDomain();
        div.getTxtYokinShubetsu1().clearValue();
        div.getTxtKozaNo1().clearValue();
        div.getTxtKinyuKikanName1().clearValue();
        div.getTxtMeigininKana1().clearDomain();
        div.getTxtMeigininKanji1().clearDomain();
    }

    private void 償還払給付または高額給付の照会モード() {

        償還払給付または高額給付の照会モード_支払方法情報エリアの状態処理();
        償還払給付または高額給付の照会モード_窓口払いエリアの状態処理();
        償還払給付または高額給付の照会モード_口座払いエリアの状態処理();
        償還払給付または高額給付の照会モード_受領委任払いエリアの状態処理();
    }

    private void 償還払給付または高額給付の修正モード(ShiharaiHohoKubun 支払方法区分) {

        償還払給付または高額給付の修正モード_支払方法情報エリアの状態処理();
        償還払給付または高額給付の修正モード_窓口払いエリアの状態処理(支払方法区分);
        償還払給付または高額給付の修正モード_口座払いエリアの状態処理(支払方法区分);
        償還払給付または高額給付の修正モード_受領委任払いエリアの状態処理(支払方法区分);
    }

    private void 償還払給付または高額給付の登録モード() {

        償還払給付または高額給付の登録モード_支払方法情報エリアの状態処理();
        償還払給付または高額給付の登録モード_窓口払いエリアの状態処理();
        償還払給付または高額給付の登録モード_口座払いエリアの状態処理();
        償還払給付または高額給付の登録モード_受領委任払いエリアの状態処理();
    }

    private void 高額合算の照会モード() {

        高額合算の照会モード_支払方法情報エリアの状態処理();
        高額合算の照会モード_窓口払いエリアの状態処理();
        高額合算の照会モード_口座払いエリアの状態処理();
        div.setMode_PageMode(ShiharaiHohoJyohoDiv.PageMode.KogakuGassan);
    }

    private void 高額合算の登録モード() {

        高額合算の登録モード_支払方法情報エリアの状態処理();
        高額合算の登録モード_窓口払いエリアの状態処理();
        高額合算の登録モード_口座払いエリアの状態処理();
        div.setMode_PageMode(ShiharaiHohoJyohoDiv.PageMode.KogakuGassan);
    }

    private void 高額合算の修正モード(ShiharaiHohoKubun 支払方法区分) {

        高額合算の修正モード_支払方法情報エリアの状態処理();
        高額合算の修正モード_窓口払いエリアの状態処理(支払方法区分);
        高額合算の修正モード_口座払いエリアの状態処理(支払方法区分);
        div.setMode_PageMode(ShiharaiHohoJyohoDiv.PageMode.KogakuGassan);
    }

    private void 高額合算の登録モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setVisible(true);
        div.getRadKoza().setVisible(true);
    }

    private void 高額合算の修正モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setVisible(true);
        div.getRadKoza().setVisible(true);
        div.getRadJyryoinin().setVisible(true);
    }

    private void 高額合算の照会モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setDisabled(true);
        div.getRadKoza().setDisabled(true);
        div.getRadMadoguti().setVisible(true);
        div.getRadKoza().setVisible(true);
        div.getRadJyryoinin().setVisible(false);
    }

    private void 償還払給付または高額給付の照会モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setDisabled(true);
        div.getRadKoza().setDisabled(true);
        div.getRadJyryoinin().setDisabled(true);
    }

    private void 償還払給付または高額給付の修正モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setVisible(true);
        div.getRadKoza().setVisible(true);
        div.getRadJyryoinin().setVisible(true);
        div.getRadMadoguti().setDisabled(false);
        div.getRadKoza().setDisabled(false);
        div.getRadJyryoinin().setDisabled(false);
    }

    private void 償還払給付または高額給付の登録モード_支払方法情報エリアの状態処理() {

        div.getRadMadoguti().setDisabled(false);
        div.getRadKoza().setDisabled(false);
        div.getRadJyryoinin().setDisabled(false);
    }

    private void 償還払給付または高額給付の照会モード_口座払いエリアの状態処理() {

        div.getDdlKozaID().setDisabled(true);
        div.getBtnKozaToroku().setDisabled(true);
        div.getTxtKinyuKikanCode().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode().setReadOnly(true);
        div.getTxtTenban().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
        div.getTxtYokinShubetsu().setReadOnly(true);
    }

    private void 償還払給付または高額給付の登録モード_口座払いエリアの状態処理() {

        div.getDdlKozaID().setDisabled(true);
        div.getBtnKozaToroku().setDisabled(true);
        div.getTxtKinyuKikanCode().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode().setReadOnly(true);
        div.getTxtTenban().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtYokinShubetsu().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
    }

    private void 高額合算の登録モード_口座払いエリアの状態処理() {

        div.getDdlKozaID().setDisabled(true);
        div.getBtnKozaToroku().setDisabled(true);
        div.getTxtKinyuKikanCode().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode().setReadOnly(true);
        div.getTxtTenban().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtYokinShubetsu().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
    }

    private void 高額合算の照会モード_口座払いエリアの状態処理() {

        div.getDdlKozaID().setDisabled(true);
        div.getBtnKozaToroku().setDisabled(true);
        div.getTxtKinyuKikanCode().setReadOnly(true);
        div.getTxtTenban().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
    }

    private void 償還払給付または高額給付の照会モード_受領委任払いエリアの状態処理() {

        div.getTxtKeiyakuNo().setReadOnly(true);
        div.getBtnSelect().setDisabled(true);
        div.getTxtKeiyakuCode().setReadOnly(true);
        div.getTxtKeiyakuName().setReadOnly(true);
        div.getTxtKinyuKikanCode1().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode1().setReadOnly(true);
        div.getTxtYokinShubetsu1().setReadOnly(true);
        div.getTxtKozaNo1().setReadOnly(true);
        div.getTxtTenban1().setReadOnly(true);
        div.getTxtKinyuKikanName1().setReadOnly(true);
        div.getTxtMeigininKana1().setReadOnly(true);
        div.getTxtMeigininKanji1().setReadOnly(true);
    }

    private void 償還払給付または高額給付の修正モード_受領委任払いエリアの状態処理(ShiharaiHohoKubun 支払方法区分) {

        if (ShiharaiHohoKubun.受領委任払.equals(支払方法区分)) {
            div.getTxtKeiyakuNo().setReadOnly(false);
            div.getBtnSelect().setDisabled(false);
            div.getTxtKeiyakuCode().setReadOnly(true);
            div.getTxtKeiyakuName().setReadOnly(true);
            div.getTxtKinyuKikanCode1().setReadOnly(true);
            div.getTxtTenban1().setReadOnly(true);
            div.getTxtKozaNo1().setReadOnly(true);
            div.getTxtKinyuKikanName1().setReadOnly(true);
            div.getTxtMeigininKana1().setReadOnly(true);
            div.getTxtMeigininKanji1().setReadOnly(true);
        } else {
            div.getTxtKeiyakuNo().setReadOnly(true);
            div.getBtnSelect().setDisabled(true);
            div.getTxtKeiyakuCode().setReadOnly(true);
            div.getTxtKeiyakuName().setReadOnly(true);
            div.getTxtKinyuKikanCode1().setReadOnly(true);
            div.getTxtTenban().setReadOnly(true);
            div.getTxtKozaNo1().setReadOnly(true);
            div.getTxtKinyuKikanName1().setReadOnly(true);
            div.getTxtMeigininKana1().setReadOnly(true);
            div.getTxtMeigininKanji1().setReadOnly(true);
        }
        div.getTxtKinyuKikanShitenCode1().setReadOnly(true);
        div.getTxtTenban1().setReadOnly(true);
        div.getTxtYokinShubetsu1().setReadOnly(true);
    }

    private void 償還払給付または高額給付の登録モード_受領委任払いエリアの状態処理() {

        div.getTxtKeiyakuNo().setReadOnly(true);
        div.getBtnSelect().setDisabled(true);
        div.getTxtKeiyakuCode().setReadOnly(true);
        div.getTxtKeiyakuName().setReadOnly(true);
        div.getTxtKinyuKikanCode1().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode1().setReadOnly(true);
        div.getTxtTenban1().setReadOnly(true);
        div.getTxtYokinShubetsu1().setReadOnly(true);
        div.getTxtKozaNo1().setReadOnly(true);
        div.getTxtKinyuKikanName1().setReadOnly(true);
        div.getTxtMeigininKana1().setReadOnly(true);
        div.getTxtMeigininKanji1().setReadOnly(true);
    }

    private void 高額合算の登録モード_窓口払いエリアの状態処理() {

        div.getTxtShiharaiBasho().setReadOnly(false);
        div.getTxtStartYMD().setReadOnly(false);
        div.getTxtEndYMD().setReadOnly(false);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(false);
        div.getTxtEndHHMM().setReadOnly(false);
    }

    private void 高額合算の修正モード_窓口払いエリアの状態処理(ShiharaiHohoKubun 支払方法区分) {

        if (ShiharaiHohoKubun.窓口払.equals(支払方法区分)) {
            div.getTxtShiharaiBasho().setReadOnly(false);
            div.getTxtStartYMD().setReadOnly(false);
            div.getTxtEndYMD().setReadOnly(false);
            div.getTxtStartYobi().setReadOnly(true);
            div.getTxtEndYobi().setReadOnly(true);
            div.getTxtStartHHMM().setReadOnly(false);
            div.getTxtEndHHMM().setReadOnly(false);
        } else {
            div.getTxtShiharaiBasho().setReadOnly(true);
            div.getTxtStartYMD().setReadOnly(true);
            div.getTxtEndYMD().setReadOnly(true);
            div.getTxtStartYobi().setReadOnly(true);
            div.getTxtEndYobi().setReadOnly(true);
            div.getTxtStartHHMM().setReadOnly(true);
            div.getTxtEndHHMM().setReadOnly(true);
        }
    }

    private void 償還払給付または高額給付の照会モード_窓口払いエリアの状態処理() {

        div.getTxtShiharaiBasho().setReadOnly(true);
        div.getTxtStartYMD().setReadOnly(true);
        div.getTxtEndYMD().setReadOnly(true);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(true);
        div.getTxtEndHHMM().setReadOnly(true);
    }

    private void 償還払給付または高額給付の修正モード_窓口払いエリアの状態処理(ShiharaiHohoKubun 支払方法区分) {

        if (ShiharaiHohoKubun.窓口払.equals(支払方法区分)) {
            div.getTxtShiharaiBasho().setReadOnly(false);
            div.getTxtStartYMD().setReadOnly(false);
            div.getTxtEndYMD().setReadOnly(false);
            div.getTxtStartYobi().setReadOnly(true);
            div.getTxtEndYobi().setReadOnly(true);
            div.getTxtStartHHMM().setReadOnly(false);
            div.getTxtEndHHMM().setReadOnly(false);
        } else {
            div.getTxtShiharaiBasho().setReadOnly(true);
            div.getTxtStartYMD().setReadOnly(true);
            div.getTxtEndYMD().setReadOnly(true);
            div.getTxtStartYobi().setReadOnly(true);
            div.getTxtEndYobi().setReadOnly(true);
            div.getTxtStartHHMM().setReadOnly(true);
            div.getTxtEndHHMM().setReadOnly(true);
        }
    }

    private void 償還払給付または高額給付の修正モード_口座払いエリアの状態処理(ShiharaiHohoKubun 支払方法区分) {

        if (ShiharaiHohoKubun.口座払.equals(支払方法区分)) {

            div.getDdlKozaID().setReadOnly(false);
            div.getBtnKozaToroku().setDisabled(false);
            div.getTxtKinyuKikanCode().setReadOnly(true);
            div.getTxtKinyuKikanName().setReadOnly(true);
            div.getTxtKozaNo().setReadOnly(true);
            div.getTxtMeigininKana().setReadOnly(true);
            div.getTtxtMeigininKanji().setReadOnly(true);
        } else {

            div.getDdlKozaID().setDisabled(true);
            div.getBtnKozaToroku().setDisabled(true);
            div.getTxtKinyuKikanCode().setReadOnly(true);
            div.getTxtKinyuKikanName().setReadOnly(true);
            div.getTxtKozaNo().setReadOnly(true);
            div.getTxtMeigininKana().setReadOnly(true);
            div.getTtxtMeigininKanji().setReadOnly(true);
        }
        div.getTxtKinyuKikanShitenCode().setReadOnly(true);
        div.getTxtTenban().setReadOnly(true);
        div.getTxtYokinShubetsu().setReadOnly(true);
    }

    private void 高額合算の修正モード_口座払いエリアの状態処理(ShiharaiHohoKubun 支払方法区分) {

        if (ShiharaiHohoKubun.口座払.equals(支払方法区分)) {

            div.getDdlKozaID().setReadOnly(true);
            div.getBtnKozaToroku().setDisabled(false);
            div.getTxtKinyuKikanCode().setReadOnly(true);
            div.getTxtKinyuKikanName().setReadOnly(true);
            div.getTxtKozaNo().setReadOnly(true);
            div.getTxtMeigininKana().setReadOnly(true);
            div.getTtxtMeigininKanji().setReadOnly(true);
        } else {

            div.getDdlKozaID().setDisabled(true);
            div.getBtnKozaToroku().setDisabled(true);
            div.getTxtKinyuKikanCode().setReadOnly(true);
            div.getTxtKinyuKikanName().setReadOnly(true);
            div.getTxtKozaNo().setReadOnly(true);
            div.getTxtMeigininKana().setReadOnly(true);
            div.getTtxtMeigininKanji().setReadOnly(true);
        }
    }

    private void 高額合算の照会モード_窓口払いエリアの状態処理() {

        div.getTxtShiharaiBasho().setReadOnly(true);
        div.getTxtStartYMD().setReadOnly(true);
        div.getTxtEndYMD().setReadOnly(true);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(true);
        div.getTxtEndHHMM().setReadOnly(true);
    }

    private void 窓口払いエリアの初期化(SikyuSinseiJyohoParameter 支給申請情報) {

        div.getTxtShiharaiBasho().setValue(支給申請情報.getShiharaiBasho() == null ? RString.EMPTY : 支給申請情報.getShiharaiBasho());
        if (支給申請情報.getStartYMD() != null) {

            div.getTxtStartYMD().setValue(支給申請情報.getStartYMD());
            RString 曜日 = new RString(支給申請情報.getStartYMD().getDayOfWeek().getMiddleTerm());
            開始日_曜日の表示色(曜日);
            div.getTxtStartYobi().setValue(曜日);
        }
        if (支給申請情報.getEndYMD() != null) {

            div.getTxtEndYMD().setValue(支給申請情報.getEndYMD());
            RString 曜日 = new RString(支給申請情報.getEndYMD().getDayOfWeek().getMiddleTerm());
            終了日_曜日の表示色(曜日);
            div.getTxtEndYobi().setValue(曜日);
        }
        if (支給申請情報.getStartHHMM() != null) {

            div.getTxtStartHHMM().setValue(支給申請情報.getStartHHMM());
        }
        if (支給申請情報.getEndHHMM() != null) {

            div.getTxtEndHHMM().setValue(支給申請情報.getEndHHMM());
        }
    }

    /**
     * 口座払いエリアの初期化。
     *
     * @param 口座情報 口座情報
     * @param kozaID 口座番号
     */
    public void 口座払いエリアの初期化(KozaJohoPSM 口座情報, Long kozaID) {
        KinyuKikanCode 金融機関コード = 口座情報.get金融機関コード() == null
                ? new KinyuKikanCode(RString.EMPTY) : 口座情報.get金融機関コード();
        div.getTxtKinyuKikanCode().setDomain(金融機関コード);
        div.getTxtKinyuKikanShitenCode().setDomain(口座情報.get支店コード());
        if (ゆうちょ銀行.equals(金融機関コード.value())) {
            KinyuKikan kinyuKikan = 金融機関コードに対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード());
            KinyuKikanShiten kinyuKikanShiten = 支店コードまたは店番に対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード(),
                    new KinyuKikanShitenCode(口座情報.get店番() == null ? RString.EMPTY : 口座情報.get店番()));
            口座払いエリアの初期化Private(kinyuKikan, kinyuKikanShiten);
            div.getTxtTenban().setDisplayNone(false);
            div.getTxtTenban().setValue(口座情報.get店番() == null ? RString.EMPTY : 口座情報.get店番());
            div.getTxtKinyuKikanShitenCode().setDisplayNone(true);
            div.getTxtYokinShubetsu().setDisplayNone(true);
        } else {
            KinyuKikan kinyuKikan = 金融機関コードに対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード());
            KinyuKikanShiten kinyuKikanShiten = 支店コードまたは店番に対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード(),
                    口座情報.get支店コード() == null ? KinyuKikanShitenCode.EMPTY : 口座情報.get支店コード());
            口座払いエリアの初期化Private(kinyuKikan, kinyuKikanShiten);
            div.getTxtKinyuKikanShitenCode().setDisplayNone(false);
            div.getTxtYokinShubetsu().setDisplayNone(false);
            div.getTxtTenban().setDisplayNone(true);
        }
        UzT0007CodeBusiness uzT0007CodeBusiness = 預金種別に対する略称(nullToEmpty(口座情報.get預金種別()));
        if (uzT0007CodeBusiness != null) {

            div.getTxtYokinShubetsu().setValue(uzT0007CodeBusiness.getコード略称() == null ? RString.EMPTY : uzT0007CodeBusiness.getコード略称());
        }
        div.getTxtKozaNo().setValue(口座情報.get口座番号());
        div.getTxtMeigininKana().setDomain(口座情報.get口座名義人());
        div.getTtxtMeigininKanji().setDomain(口座情報.get口座名義人漢字());
    }

    /**
     * 受領委任払いエリアの初期化。
     *
     * @param 支給申請情報 支給申請情報
     * @param 受領委任契約事業者 受領委任契約事業者
     */
    public void 受領委任払いエリアの初期化(SikyuSinseiJyohoParameter 支給申請情報, JuryoininKeiyakuJigyosha 受領委任契約事業者) {

        div.getRadJyryoinin().setSelectedKey(new RString("3"));
        div.getTxtKeiyakuNo().setDisabled(false);
        div.getBtnSelect().setDisabled(false);
        div.getTxtKeiyakuCode().setValue(nullToEmpty(受領委任契約事業者.get契約事業者番号()));
        div.getTxtKeiyakuName().setDomain(受領委任契約事業者.get契約事業者名称() == null
                ? AtenaMeisho.EMPTY : 受領委任契約事業者.get契約事業者名称());
        div.getTxtKinyuKikanCode1().setDomain(受領委任契約事業者.get金融機関コード() == null
                ? KinyuKikanCode.EMPTY : 受領委任契約事業者.get金融機関コード());
        div.getTxtKinyuKikanShitenCode1().setDomain(受領委任契約事業者.get支店コード() == null
                ? KinyuKikanShitenCode.EMPTY : 受領委任契約事業者.get支店コード());
        KinyuKikan kinyuKikan = 金融機関コードに対する名称(受領委任契約事業者.get金融機関コード() == null
                ? KinyuKikanCode.EMPTY : 受領委任契約事業者.get金融機関コード());
        KinyuKikanShiten kinyuKikanShiten = 支店コードまたは店番に対する名称(受領委任契約事業者.get金融機関コード() == null
                ? KinyuKikanCode.EMPTY : 受領委任契約事業者.get金融機関コード(),
                受領委任契約事業者.get支店コード() == null ? KinyuKikanShitenCode.EMPTY : 受領委任契約事業者.get支店コード());
        KinyuKikanCode 金融機関コード = 受領委任契約事業者.get金融機関コード() == null
                ? new KinyuKikanCode(RString.EMPTY) : 受領委任契約事業者.get金融機関コード();
        if (ゆうちょ銀行.equals(金融機関コード.value())) {
            div.getTxtKinyuKikanShitenCode1().setDisplayNone(true);
            div.getTxtYokinShubetsu1().setDisplayNone(true);
            div.getTxtTenban1().setDisplayNone(false);
            div.getTxtTenban1().setValue(受領委任契約事業者.get支店コード() == null ? RString.EMPTY : 受領委任契約事業者.get支店コード().value());
            口座払いエリアの初期化Private(kinyuKikan, kinyuKikanShiten);
        } else {
            div.getTxtKinyuKikanShitenCode1().setDisplayNone(false);
            div.getTxtYokinShubetsu1().setDisplayNone(false);
            div.getTxtTenban1().setDisplayNone(true);
            div.getTxtKinyuKikanShitenCode().setDomain(受領委任契約事業者.get支店コード());
            口座払いエリアの初期化Private(kinyuKikan, kinyuKikanShiten);
        }
        UzT0007CodeBusiness uzT0007CodeBusiness = 預金種別に対する略称(nullToEmpty(受領委任契約事業者.get口座種別()));
        if (uzT0007CodeBusiness != null) {
            div.getTxtYokinShubetsu1().setValue(uzT0007CodeBusiness.getコード略称() == null ? RString.EMPTY : uzT0007CodeBusiness.getコード略称());
        }
        div.getTxtKozaNo1().setValue(nullToEmpty(受領委任契約事業者.get口座番号()));
        div.getTxtMeigininKana1().setDomain(受領委任契約事業者.get口座名義人カナ() == null
                ? AtenaKanaMeisho.EMPTY : 受領委任契約事業者.get口座名義人カナ());
        div.getTxtMeigininKanji1().setDomain(受領委任契約事業者.get口座名義人() == null
                ? AtenaMeisho.EMPTY : 受領委任契約事業者.get口座名義人());
    }

    private void 口座払いエリアの初期化Private(KinyuKikan kinyuKikan, KinyuKikanShiten kinyuKikanShiten) {
        if (kinyuKikan != null && kinyuKikanShiten != null) {
            StringBuilder builder = new StringBuilder();
            builder.append(kinyuKikan.get金融機関名称() == null ? RString.EMPTY.toString() : kinyuKikan.get金融機関名称().toString())
                    .append(kinyuKikanShiten.get支店名称() == null ? RString.EMPTY.toString() : kinyuKikanShiten.get支店名称().toString());
            div.getTxtKinyuKikanName().setValue(new RString(builder.toString()));
        }
    }

    private UzT0007CodeBusiness 預金種別に対する略称(RString 口座種別) {

        return new UzT0007CodeBusiness(CodeMaster.getCode(預金種別, new Code(口座種別)) == null
                ? new UzT0007CodeEntity() : CodeMaster.getCode(預金種別, new Code(口座種別)));
    }

    private KinyuKikan 金融機関コードに対する名称(KinyuKikanCode 金融機関コード) {

        return KinyuKikanManager.createInstance().getValidKinyuKikanOn(FlexibleDate.getNowDate(),
                金融機関コード == null ? RString.EMPTY : 金融機関コード.value());
    }

    private KinyuKikanShiten 支店コードまたは店番に対する名称(KinyuKikanCode 金融機関コード, KinyuKikanShitenCode コード) {

        return KinyuKikanShitenManager.createInstance().get金融機関支店(金融機関コード,
                コード, FlexibleDate.getNowDate());
    }

    private void 償還払給付または高額給付の登録モード_窓口払いエリアの状態処理() {

        div.getTxtShiharaiBasho().setReadOnly(false);
        div.getTxtStartYMD().setReadOnly(false);
        div.getTxtEndYMD().setReadOnly(false);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(false);
        div.getTxtEndHHMM().setReadOnly(false);
    }

    /**
     * 窓口払いを入力可になります。
     *
     */
    public void 入力可_窓口払い() {

        div.getTxtShiharaiBasho().setReadOnly(false);
        div.getTxtStartYMD().setReadOnly(false);
        div.getTxtEndYMD().setReadOnly(false);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(false);
        div.getTxtEndHHMM().setReadOnly(false);
    }

    /**
     * 曜日の表示色を表示します。
     *
     * @param 曜日 RString
     */
    public void 開始日_曜日の表示色(RString 曜日) {

        if (曜日_日.equals(曜日)) {
            div.getTxtStartYobi().setDecorationClass(new RString("DBCFontcolor_red"));
        } else if (曜日_土.equals(曜日)) {
            div.getTxtStartYobi().setDecorationClass(new RString("DBCFontcolor_green"));
        } else {
            div.getTxtStartYobi().setDecorationClass(new RString("DBCFontcolor_black"));
        }
    }

    /**
     * 曜日の表示色を表示します。
     *
     * @param 曜日 RString
     */
    public void 終了日_曜日の表示色(RString 曜日) {

        if (曜日_日.equals(曜日)) {
            div.getTxtEndYobi().setDecorationClass(new RString("DBCFontcolor_red"));
        } else if (曜日_土.equals(曜日)) {
            div.getTxtEndYobi().setDecorationClass(new RString("DBCFontcolor_green"));
        } else {
            div.getTxtEndYobi().setDecorationClass(new RString("DBCFontcolor_black"));
        }
    }

    /**
     * 窓口払いを入力不可になります。
     *
     */
    public void 入力不可_窓口払い() {

        div.getTxtShiharaiBasho().setReadOnly(true);
        div.getTxtStartYMD().setReadOnly(true);
        div.getTxtEndYMD().setReadOnly(true);
        div.getTxtEndYobi().setReadOnly(true);
        div.getTxtStartYobi().setReadOnly(true);
        div.getTxtStartHHMM().setReadOnly(true);
        div.getTxtEndHHMM().setReadOnly(true);
    }

    /**
     * 口座払いを入力可になります。
     *
     */
    public void 入力不可_口座払い() {

        div.getDdlKozaID().setDisabled(true);
        div.getBtnKozaToroku().setDisabled(true);
        div.getTxtKinyuKikanCode().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode().setReadOnly(true);
        div.getTxtYokinShubetsu().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
    }

    /**
     * 支払方法を取得します。
     *
     * @return 支払方法
     */
    public RString getShiharaiHoho() {

        if (!div.getRadMadoguti().getSelectedKey().isNullOrEmpty()) {

            return div.getRadMadoguti().getSelectedKey();
        }
        if (!div.getRadKoza().getSelectedKey().isNullOrEmpty()) {

            return div.getRadKoza().getSelectedKey();
        }
        if (!div.getRadJyryoinin().getSelectedKey().isNullOrEmpty()) {

            return div.getRadJyryoinin().getSelectedKey();
        }
        return RString.EMPTY;
    }

    /**
     * 開始日を取得します。
     *
     * @return RDate
     */
    public RDate getStartYMD() {

        return div.getTxtStartYMD().getValue();
    }

    /**
     * 終了日を取得します。
     *
     * @return RDate
     */
    public RDate getEndYMD() {

        return div.getTxtEndYMD().getValue();
    }

    /**
     * 開始時間を取得します。
     *
     * @return RTime
     */
    public RTime getStartHHMM() {

        return div.getTxtStartHHMM().getValue();
    }

    /**
     * 終了時間を取得します。
     *
     * @return RTime
     */
    public RTime getEndHHMM() {

        return div.getTxtEndHHMM().getValue();
    }

    /**
     * 口座IDを取得します。
     *
     * @return RString
     */
    public RString getKozaNo() {

        return div.getDdlKozaID().getSelectedKey();
    }

    /**
     * 契約番号を取得します。
     *
     * @return RString
     */
    public RString getKeiyakuNo() {

        return div.getTxtKeiyakuNo().getValue();
    }

    /**
     * 支払場所を取得します。
     *
     * @return RString
     */
    public RString getShiharaiBasho() {

        return div.getTxtShiharaiBasho().getValue();
    }

    /**
     * 口座IDを取得します。
     *
     * @return RString
     */
    public RString getKozaID() {
        RString kozaID = div.getDdlKozaID().getSelectedValue();
        return kozaID == null ? RString.EMPTY : kozaID;
    }

    /**
     * 受領委任払いエリアを入力可になります。
     *
     */
    public void 入力不可_受領委任払い() {

        div.getTxtKeiyakuNo().setReadOnly(true);
        div.getBtnSelect().setDisabled(true);
        div.getTxtKeiyakuCode().setReadOnly(true);
        div.getTxtKeiyakuName().setReadOnly(true);
        div.getTxtKinyuKikanCode1().setReadOnly(true);
        div.getTxtKinyuKikanShitenCode1().setReadOnly(true);
        div.getTxtYokinShubetsu1().setReadOnly(true);
        div.getTxtKozaNo1().setReadOnly(true);
        div.getTxtKinyuKikanName1().setReadOnly(true);
        div.getTxtMeigininKana1().setReadOnly(true);
        div.getTxtMeigininKanji1().setReadOnly(true);
    }

    private void set口座ID(SikyuSinseiJyohoParameter 支給申請情報, KamokuCode 業務内区分コード) {
        List<KozaJohoPSM> 口座IDリスト = ShiharaiHohoJyohoFinder.createInstance()
                .getKozaIDList(KozaParameter.createParam(0, 支給申請情報.getShikibetsuCode(), 業務内区分コード)).records();
        div.getDdlKozaID().setDataSource(set口座ID(口座IDリスト));
    }

    private KamokuCode get業務内区分コード(KamokuCode 業務内区分コード) {

        IUrControlData controlData = UrControlDataFactory.createInstance();
        RString menuID = controlData.getMenuID();

        if (償還払い状況照会.equals(menuID) || 福祉用具購入費支給申請.equals(menuID)
                || 住宅改修費支給申請.equals(menuID) || 住宅改修費事前申請.equals(menuID)
                || 償還払い費支給申請.equals(menuID)) {

            業務内区分コード = new KamokuCode(String.format("%03d", Integer.valueOf(KozaBunruiKubun.償還払い支給.getコード().toString())));
        }
        if (高額サービス費支給申請.equals(menuID)) {

            業務内区分コード = new KamokuCode(String.format("%03d", Integer.valueOf(KozaBunruiKubun.高額介護サービス費支給.getコード().toString())));
        }
        if (高額合算支給申請1.equals(menuID)
                || 高額合算支給申請2.equals(menuID)
                || 高額合算支給申請3.equals(menuID)
                || 高額合算支給申請4.equals(menuID)
                || 高額合算支給申請5.equals(menuID)
                || 高額合算支給申請6.equals(menuID)
                || 高額合算支給申請7.equals(menuID)
                || 高額合算支給申請8.equals(menuID)
                || 高額合算支給申請9.equals(menuID)
                || 高額合算支給申請10.equals(menuID)
                || 高額合算支給申請11.equals(menuID)
                || 高額合算支給申請12.equals(menuID)
                || 高額合算支給決定情報補正.equals(menuID)) {
            業務内区分コード = new KamokuCode(String.format("%03d", Integer.valueOf(KozaBunruiKubun.高額合算費支給.getコード().toString())));
        }
        return 業務内区分コード;
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
