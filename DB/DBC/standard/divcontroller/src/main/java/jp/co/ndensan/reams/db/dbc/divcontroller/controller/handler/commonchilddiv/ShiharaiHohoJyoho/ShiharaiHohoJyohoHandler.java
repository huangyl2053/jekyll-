package jp.co.ndensan.reams.db.dbc.divcontroller.controller.handler.commonchilddiv.ShiharaiHohoJyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.KozaJohoPSM.KozaJohoPSM;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KeiyakushaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.KozaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.service.core.shiharaihohojyoho.ShiharaiHohoJyohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanShitenManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 支払方法情報のコントローラです。
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
     * @param 業務内区分コード 業務内区分コード
     * @param 状態 状態
     */
    public void initialize(SikyuSinseiJyohoParameter 支給申請情報, KamokuCode 業務内区分コード, RString 状態) {
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
                        .getKozaJyoho(new KozaParameter(支給申請情報.getKozaId(), null, null)), 支給申請情報.getKozaId());
            }
            if (ShiharaiHohoKubun.受領委任払.equals(支払方法区分)) {
                div.getRadJyryoinin().setSelectedKey(支払方法区分.getコード());
                JuryoininKeiyakuJigyosha 受領委任契約事業者 = ShiharaiHohoJyohoFinder.createInstance().
                        getKeiyakuJigyosya(KeiyakushaParameter.
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
        div.getTxtTenban().setReadOnly(true);
        div.getTxtKinyuKikanName().setReadOnly(true);
        div.getTxtKozaNo().setReadOnly(true);
        div.getTxtMeigininKana().setReadOnly(true);
        div.getTtxtMeigininKanji().setReadOnly(true);
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
            div.getTxtStartYobi().setValue(new RString(支給申請情報.getStartYMD().getDayOfWeek().getMiddleTerm()));
        }
        if (支給申請情報.getEndYMD() != null) {

            div.getTxtEndYMD().setValue(支給申請情報.getEndYMD());
            div.getTxtEndYobi().setValue(new RString(支給申請情報.getEndYMD().getDayOfWeek().getMiddleTerm()));
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
            if (kinyuKikan != null && kinyuKikanShiten != null) {
                div.getTxtKinyuKikanName().setValue(new RString(kinyuKikan.get金融機関名称() == null
                        ? RString.EMPTY.toString() : kinyuKikan.get金融機関名称().toString()
                        + kinyuKikanShiten.get支店名称() == null ? RString.EMPTY.toString() : kinyuKikanShiten.get支店名称().toString()));
            }
            div.getTxtTenban().setVisible(true);
            div.getTxtTenban().setValue(口座情報.get店番() == null ? RString.EMPTY : 口座情報.get店番());
            div.getTxtKinyuKikanShitenCode().setVisible(false);
            div.getTxtYokinShubetsu().setVisible(false);
        } else {
            KinyuKikan kinyuKikan = 金融機関コードに対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード());
            KinyuKikanShiten kinyuKikanShiten = 支店コードまたは店番に対する名称(口座情報.get金融機関コード() == null
                    ? KinyuKikanCode.EMPTY : 口座情報.get金融機関コード(),
                    口座情報.get支店コード() == null ? KinyuKikanShitenCode.EMPTY : 口座情報.get支店コード());
            if (kinyuKikan != null && kinyuKikanShiten != null) {
                div.getTxtKinyuKikanName().setValue(new RString(kinyuKikan.get金融機関名称() == null
                        ? RString.EMPTY.toString() : kinyuKikan.get金融機関名称().toString()
                        + kinyuKikanShiten.get支店名称() == null ? RString.EMPTY.toString() : kinyuKikanShiten.get支店名称().toString()));
            }
            div.getTxtKinyuKikanShitenCode().setReadOnly(true);
            div.getTxtYokinShubetsu().setReadOnly(true);
            div.getTxtTenban().setVisible(false);
        }
        UzT0007CodeEntity uzT0007CodeEntity = 預金種別に対する略称(nullToEmpty(口座情報.get預金種別()));
        if (uzT0007CodeEntity != null) {

            div.getTxtYokinShubetsu().setValue(uzT0007CodeEntity.getコード略称() == null ? RString.EMPTY : uzT0007CodeEntity.getコード略称());
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
            div.getTxtKinyuKikanShitenCode1().setVisible(false);
            div.getTxtYokinShubetsu1().setVisible(false);
            div.getTxtTenban1().setVisible(true);
            div.getTxtTenban1().setValue(受領委任契約事業者.get支店コード() == null ? RString.EMPTY : 受領委任契約事業者.get支店コード().value());
            if (kinyuKikan != null && kinyuKikanShiten != null) {
                div.getTxtKinyuKikanName().setValue(new RString(kinyuKikan.get金融機関名称() == null ? RString.EMPTY.toString()
                        : kinyuKikan.get金融機関名称().toString() + kinyuKikanShiten.get支店名称() == null
                        ? RString.EMPTY.toString() : kinyuKikanShiten.get支店名称().toString()));
            }
        } else {
            div.getTxtKinyuKikanShitenCode1().setVisible(true);
            div.getTxtYokinShubetsu1().setVisible(true);
            div.getTxtTenban1().setVisible(false);
            div.getTxtKinyuKikanShitenCode().setDomain(受領委任契約事業者.get支店コード());
            if (kinyuKikan != null && kinyuKikanShiten != null) {
                div.getTxtKinyuKikanName().setValue(new RString(kinyuKikan.get金融機関名称() == null ? RString.EMPTY.toString()
                        : kinyuKikan.get金融機関名称().toString() + kinyuKikanShiten.get支店名称() == null
                        ? RString.EMPTY.toString() : kinyuKikanShiten.get支店名称().toString()));
            }
        }
        UzT0007CodeEntity uzT0007CodeEntity = 預金種別に対する略称(nullToEmpty(受領委任契約事業者.get口座種別()));
        if (uzT0007CodeEntity != null) {
            div.getTxtYokinShubetsu1().setValue(uzT0007CodeEntity.getコード略称() == null ? RString.EMPTY : uzT0007CodeEntity.getコード略称());
        }
        div.getTxtKozaNo1().setValue(nullToEmpty(受領委任契約事業者.get口座番号()));
        div.getTxtMeigininKana1().setDomain(受領委任契約事業者.get口座名義人カナ() == null
                ? AtenaKanaMeisho.EMPTY : 受領委任契約事業者.get口座名義人カナ());
        div.getTxtMeigininKanji1().setDomain(受領委任契約事業者.get口座名義人() == null
                ? AtenaMeisho.EMPTY : 受領委任契約事業者.get口座名義人());
    }

    private UzT0007CodeEntity 預金種別に対する略称(RString 口座種別) {

        return CodeMaster.getCode(預金種別, new Code(口座種別));
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
                .getKozaIDList(new KozaParameter(0, 支給申請情報.getShikibetsuCode(), 業務内区分コード)).records();
        div.getDdlKozaID().setDataSource(set口座ID(口座IDリスト));
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
