/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.RirekiShusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.rirekishusei.RirekiShuseiDataPass;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiKoshinNintei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.dgServiceIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 共有子Div「履歴修正」のhandlerクラスです
 *
 * @reamsid_L DBZ-1330-030 chengsanyuan
 */
public class RirekiShuseiHandler {

    private final RirekiShuseiDiv div;

    private static final int 指定サービス種類_1 = 1;
    private static final int 指定サービス種類_2 = 2;
    private static final int 指定サービス種類_3 = 3;
    private static final int 指定サービス種類_4 = 4;
    private static final int 指定サービス種類_5 = 5;
    private static final int 指定サービス種類_6 = 6;
    private static final int 指定サービス種類_7 = 7;
    private static final int 指定サービス種類_8 = 8;
    private static final int 指定サービス種類_9 = 9;
    private static final int 指定サービス種類_10 = 10;
    private static final int 指定サービス種類_11 = 11;
    private static final int 指定サービス種類_12 = 12;
    private static final int 指定サービス種類_13 = 13;
    private static final int 指定サービス種類_14 = 14;
    private static final int 指定サービス種類_15 = 15;
    private static final int 指定サービス種類_16 = 16;
    private static final int 指定サービス種類_17 = 17;
    private static final int 指定サービス種類_18 = 18;
    private static final int 指定サービス種類_19 = 19;
    private static final int 指定サービス種類_20 = 20;
    private static final int 指定サービス種類_21 = 21;
    private static final int 指定サービス種類_22 = 22;
    private static final int 指定サービス種類_23 = 23;
    private static final int 指定サービス種類_24 = 24;
    private static final int 指定サービス種類_25 = 25;
    private static final int 指定サービス種類_26 = 26;
    private static final int 指定サービス種類_27 = 27;
    private static final int 指定サービス種類_28 = 28;
    private static final int 指定サービス種類_29 = 29;
    private static final int 指定サービス種類_30 = 30;
    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString SHOKAI_MODE = new RString("ShokaiMode");
    private static final RString INPUT_MODE = new RString("InputMode");
    private static final RString TOKUSHU_TSUIKA_MODE = new RString("TokushuTsuikaMode");

    /**
     * コンストラクタです。
     *
     * @param div 履歴修正Div
     */
    public RirekiShuseiHandler(RirekiShuseiDiv div) {
        this.div = div;
    }

    /**
     * 認定調査状況初期化処理です。
     */
    public void load() {
        RString deleteKey = div.getHdnDeleteKey();
        RirekiShuseiDataPass konkai = DataPassingConverter.deserialize(div.getHdnKonkaiJohoSerialized(),
                RirekiShuseiDataPass.class);
        if (konkai != null) {
            if (!RString.isNullOrEmpty(deleteKey)) {
                div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(SHOKAI_MODE);
                div.getCcdNinteiShinseiTodokedesha().set状態(SHOKAI_MODE);
                div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
                div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
                div.getCcdNinteiJohoInput().set状態(SHOKAI_MODE);
                div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuSakujyoMode);
                div.setHdnDisplayModeKey(new RString("1"));
                div.getBtnKakutei().setDisabled(false);
            } else if (konkai.get削除事由コード() != null && !konkai.get削除事由コード().isEmpty()) {
                div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString("RirekiShuseiMode"));
                div.getCcdNinteiShinseiTodokedesha().set状態(SHOKAI_MODE);
                div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
                div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
                div.getCcdNinteiJohoInput().set状態(SHOKAI_MODE);
                div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.RirekiSakujoShuseiMode);
                div.setHdnDisplayModeKey(new RString("2"));
                div.getBtnKakutei().setDisabled(false);
            } else {
                if (konkai.getデータ区分() != null && konkai.getデータ区分().value().equals(new RString("00"))) {
                    div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(new RString("RirekiShuseiMode"));
                    div.getCcdNinteiShinseiTodokedesha().set状態(INPUT_MODE);
                    div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
                    div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleShokaiMode);
                    div.getCcdNinteiJohoInput().set状態(new RString("TokushuShuseiMode"));
                    div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuRirekiShuseiMode);
                    div.setHdnDisplayModeKey(new RString("2"));
                    div.getBtnKakutei().setDisabled(false);
                } else {
                    set状態(konkai.getデータ区分().value());
                }
            }

            set介護認定申請基本情報入力(konkai);
            NinteiShinseiTodokedeshaDataPassModel dataPass = new NinteiShinseiTodokedeshaDataPassModel();
            dataPass.set申請書管理番号(konkai.get申請書管理番号().value());
            dataPass.setカナ氏名(ObjectUtil.defaultIfNull(konkai.getカナ氏名(), RString.EMPTY));
            dataPass.set事業者区分(ObjectUtil.defaultIfNull(konkai.get事業者区分(), RString.EMPTY));
            dataPass.set住所(ObjectUtil.defaultIfNull(konkai.get住所(), RString.EMPTY));
            if (konkai.get事業者番号() != null) {
                dataPass.set申請届出代行事業者番号(konkai.get事業者番号().value());
            }
            if (konkai.get届出代行区分() != null) {
                dataPass.set申請届出代行区分コード(konkai.get届出代行区分().value());
            }
            dataPass.set続柄(ObjectUtil.defaultIfNull(konkai.get本人との関係性(), RString.EMPTY));
            if (konkai.get郵便番号() != null) {
                dataPass.set郵便番号(konkai.get郵便番号().value());
            }
            if (konkai.get電話番号() != null) {
                dataPass.set電話番号(konkai.get電話番号().value());
            }
            dataPass.set氏名(konkai.get氏名());
            div.getCcdNinteiShinseiTodokedesha().initialize(dataPass);

            div.getCcdShujiiIryokikanAndShujiiInput().initialize(konkai.get市町村コード(),
                    konkai.get申請書管理番号(), new SubGyomuCode(div.getHdnSubGyomuCd()),
                    ObjectUtil.defaultIfNull(konkai.get主治医医療機関コード(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get医療機関名称(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get主治医コード(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get主治医氏名(), RString.EMPTY));
            div.getCcdShujiiIryokikanAndShujiiInput().setShiteii(konkai.is指定医フラグ());

            div.getCcdChosaItakusakiAndChosainInput().initialize(RString.EMPTY,
                    ObjectUtil.defaultIfNull(konkai.get認定調査委託先コード(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get事業者名称(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get認定調査員コード(), RString.EMPTY),
                    ObjectUtil.defaultIfNull(konkai.get調査員氏名(), RString.EMPTY));
            div.getCcdChosaItakusakiAndChosainInput().setHdnShinseishoKanriNo(konkai.get申請書管理番号().value());
            div.getCcdChosaItakusakiAndChosainInput().setHdnShichosonCode(konkai.get市町村コード().value());

            set認定情報(konkai);
            set前回情報(konkai);
            set申請その他情報(konkai);
            div.setHdnInput(this.get画面項目());
            RirekiShuseiDataPass zenkai = DataPassingConverter.deserialize(div.getHdnZenkaiJohoSerialized(),
                    RirekiShuseiDataPass.class);
            div.setHdnKonkaiJoho(DataPassingConverter.serialize(konkai.get調査状況用情報()));
            if (zenkai != null) {
                div.setHdnZenkaiJoho(DataPassingConverter.serialize(zenkai.get調査状況用情報()));
            }
        }
    }

    /**
     * 異動事由の選択値により、入力可不可を設定する
     *
     * @param データ区分 データ区分
     */
    public void set状態(RString データ区分) {
        if (データ区分.isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(SHOKAI_MODE);
            div.getCcdNinteiShinseiTodokedesha().set状態(SHOKAI_MODE);
            div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
            div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
            div.getCcdNinteiJohoInput().set状態(SHOKAI_MODE);
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.RirekiTsuikaMode);
            div.setHdnDisplayModeKey(new RString("1"));
            div.getBtnKakutei().setDisabled(true);
        } else if (データ区分.startsWith(new RString("1"))) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(TOKUSHU_TSUIKA_MODE);
            div.getCcdNinteiShinseiTodokedesha().set状態(INPUT_MODE);
            div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdNinteiJohoInput().set状態(new RString("TokushuShuseiMode"));
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TorikeshiRirekiTsuikaMode);
            div.setHdnDisplayModeKey(new RString("2"));
            div.getBtnKakutei().setDisabled(false);
        } else if (データ区分.startsWith(new RString("2"))) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(TOKUSHU_TSUIKA_MODE);
            div.getCcdNinteiShinseiTodokedesha().set状態(INPUT_MODE);
            div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdNinteiJohoInput().set状態(new RString("TokushuShuseiMode"));
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.RirekiTsuikaKyakkaMode);
            div.setHdnDisplayModeKey(new RString("2"));
            div.getBtnKakutei().setDisabled(false);
        } else if (データ区分.startsWith(new RString("3"))) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(TOKUSHU_TSUIKA_MODE);
            div.getCcdNinteiShinseiTodokedesha().set状態(INPUT_MODE);
            div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdNinteiJohoInput().set状態(new RString("KyakkaRirekiTsuikaMode"));
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.RirekiTsuikaKyakkaMode);
            div.setHdnDisplayModeKey(new RString("2"));
        } else if (データ区分.startsWith(new RString("4"))) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setInputMode(TOKUSHU_TSUIKA_MODE);
            div.getCcdNinteiShinseiTodokedesha().set状態(INPUT_MODE);
            div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.SimpleShokaiMode);
            div.getCcdNinteiJohoInput().set状態(new RString("ShinseiTorikeshiRirekiMode"));
            div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ShinseiTorikeshiTsuikaMode);
            div.setHdnDisplayModeKey(new RString("2"));
            div.getBtnKakutei().setDisabled(false);
        }
    }

    /**
     * 画面の項目値をhiddenInputに設定します。
     *
     * @return 画面の項目値
     */
    public RString get画面項目() {
        RStringBuilder rsb = new RStringBuilder();
        KaigoNinteiShinseiKihonJohoInputDiv inputDiv = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv();
        rsb.append(inputDiv.getTxtShinseiYMD().getValue());
        rsb.append(inputDiv.getTxtShinseiJokyo().getValue());
        rsb.append(inputDiv.getRadShinseishoKubun().getSelectedKey());
        rsb.append(inputDiv.getDdlShinseiShubetsu().getSelectedKey());
        rsb.append(inputDiv.getDdlShinseiKubunShinseiji().getSelectedKey());
        rsb.append(inputDiv.getDdlShinseiKubunHorei().getSelectedKey());
        rsb.append(inputDiv.getDdlShisho().getSelectedKey());
        rsb.append(inputDiv.getChkKyuSochisha().isAllSelected());
        rsb.append(inputDiv.getDdlHihokenshaKubun().getSelectedKey());
        rsb.append(inputDiv.getChkShikakuShutokuMae().isAllSelected());
        rsb.append(inputDiv.getDdlTokuteiShippei().getSelectedKey());
        rsb.append(inputDiv.getTxtNinteiShinseRiyu().getValue());

        NinteiShinseiTodokedeshaNaiyo naiyo = div.getCcdNinteiShinseiTodokedesha().get一覧内容();
        rsb.append(naiyo.getカナ氏名());
        rsb.append(naiyo.get申請関係者());
        if (KEY_0.equals(naiyo.get管内管外区分())) {
            rsb.append(naiyo.get町域入力住所名称());
            rsb.append(naiyo.get郵便番号());
        }
        if (KEY_1.equals(naiyo.get管内管外区分())) {
            rsb.append(naiyo.get全国住所名称());
            rsb.append(naiyo.get全国郵便番号());
        }
        rsb.append(naiyo.get電話番号());
        rsb.append(naiyo.get事業者コード());
        rsb.append(naiyo.get届出代行区分());
        rsb.append(naiyo.get本人との関係性());

        NinteiInputNaiyo inputNaiyo = div.getCcdNinteiJohoInput().getNaiyo();
        rsb.append(inputNaiyo.get要介護度コード());
        rsb.append(inputNaiyo.get認定年月日());
        rsb.append(inputNaiyo.get有効開始年月日());
        rsb.append(inputNaiyo.get有効終了年月日());
        rsb.append(inputNaiyo.get審査会意見());
        if (inputNaiyo.getみなし更新認定() != null && !inputNaiyo.getみなし更新認定().isEmpty()) {
            rsb.append(inputNaiyo.getみなし更新認定().get(0));
        }
        List<dgServiceIchiran_Row> serviceCodeList = div.getCcdNinteiJohoInput().getServiceRow();
        for (dgServiceIchiran_Row row : serviceCodeList) {
            rsb.append(row.getCode());
        }
        rsb.append(div.getCcdShinseiSonotaJohoInput().get削除事由());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get理由());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get取消日());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get喪失日());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get受給資格者証発効日２());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get受給資格者証発行日１());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get当初認定期間開始());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get当初認定期間終了());
        rsb.append(div.getCcdShinseiSonotaJohoInput().get異動事由());

        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanName());
        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiName());
        rsb.append(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());

        rsb.append(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        rsb.append(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue());
        rsb.append(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiName().getValue());
        rsb.append(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue());
        rsb.append(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainName().getValue());
        return rsb.toRString();
    }

    /**
     * 確定ボタンをクリックの時、結果を親画面に渡します
     *
     * @return 画面項目
     */
    public RirekiShuseiDataPass get画面項目ForDataPass() {
        RirekiShuseiDataPass konkai = new RirekiShuseiDataPass();
        NinteiChosaJokyoDataPass konkaiDataPass = DataPassingConverter.deserialize(div.getHdnKonkaiJoho(),
                NinteiChosaJokyoDataPass.class);
        konkai.set調査状況用情報(konkaiDataPass);
        KaigoNinteiShinseiKihonJohoInputDiv inputDiv = div.getCcdKaigoNinteiShinseiKihonJohoInput().getKaigoNinteiShinseiKihonJohoInputDiv();
        konkai.set認定申請年月日(rDateToFlex(inputDiv.getTxtShinseiYMD().getValue()));
        konkai.set申請状況区分(inputDiv.getTxtShinseiJokyo().getValue());
        konkai.set要介護申請_要支援申請の区分(inputDiv.getRadShinseishoKubun().getSelectedKey());
        konkai.set受給申請事由(new Code(inputDiv.getDdlShinseiShubetsu().getSelectedKey()));
        konkai.set認定申請区分_申請時_コード(new Code(inputDiv.getDdlShinseiKubunShinseiji().getSelectedKey()));
        konkai.set認定申請区分_法令_コード(new Code(inputDiv.getDdlShinseiKubunHorei().getSelectedKey()));
        konkai.set支所コード(inputDiv.getDdlShisho().getSelectedKey());
        konkai.set旧措置フラグ(inputDiv.getChkKyuSochisha().isAllSelected());
        konkai.set被保険者区分コード(inputDiv.getDdlHihokenshaKubun().getSelectedKey());
        konkai.set資格取得前申請フラグ(inputDiv.getChkShikakuShutokuMae().isAllSelected());
        konkai.set二号特定疾病コード(new Code(inputDiv.getDdlTokuteiShippei().getSelectedKey()));
        konkai.set認定申請理由(inputDiv.getTxtNinteiShinseRiyu().getValue());

        NinteiShinseiTodokedeshaNaiyo naiyo = div.getCcdNinteiShinseiTodokedesha().get一覧内容();
        konkai.setカナ氏名(naiyo.getカナ氏名());
        konkai.set事業者区分(naiyo.get申請関係者());
        if (KEY_0.equals(naiyo.get管内管外区分())) {
            konkai.set住所(naiyo.get町域入力住所名称());
            konkai.set郵便番号(naiyo.get郵便番号());
        }
        if (KEY_1.equals(naiyo.get管内管外区分())) {
            konkai.set住所(naiyo.get全国住所名称());
            konkai.set郵便番号(new YubinNo(naiyo.get全国郵便番号()));
        }
        konkai.set電話番号(new TelNo(naiyo.get電話番号()));
        konkai.set事業者番号(new JigyoshaNo(naiyo.get事業者コード()));
        konkai.set届出代行区分(new Code(naiyo.get届出代行区分()));
        konkai.set本人との関係性(naiyo.get本人との関係性());
        konkai.set氏名(naiyo.get氏名());

        konkai.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        konkai.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());

        NinteiInputNaiyo inputNaiyo = div.getCcdNinteiJohoInput().getNaiyo();
        konkai.set要介護状態区分コード(new Code(inputNaiyo.get要介護度コード()));
        konkai.set認定年月日(inputNaiyo.get認定年月日());
        konkai.set認定有効開始年月日(inputNaiyo.get有効開始年月日());
        konkai.set認定有効終了年月日(inputNaiyo.get有効終了年月日());
        konkai.set介護認定審査会意見(inputNaiyo.get審査会意見());

        if (inputNaiyo.getみなし更新認定() != null && !inputNaiyo.getみなし更新認定().isEmpty()) {
            konkai.setみなし要介護区分コード(new Code(MinashiKoshinNintei.みなし更新認定.getコード()));
        } else {
            konkai.setみなし要介護区分コード(new Code(MinashiKoshinNintei.通常認定.getコード()));
        }
        List<dgServiceIchiran_Row> serviceCodeList = div.getCcdNinteiJohoInput().getServiceRow();
        int count = 1;
        for (dgServiceIchiran_Row row : serviceCodeList) {
            if (count < 指定サービス種類_17) {
                set指定サービス種類16以下(row.getCode(), count, konkai);
            } else {
                set指定サービス種類以上(row.getCode(), count, konkai);
            }
            count = count + 1;
        }
        konkai.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekka().get要介護状態区分コード(
                new SubGyomuCode(div.getHdnSubGyomuCd()), konkai.get申請書管理番号(), new RString("1"))));
        konkai.set前回認定年月日(div.getCcdZenkaiNinteiKekka().getTxtNinteiDay().getValue());
        konkai.set前回認定有効開始年月日(div.getCcdZenkaiNinteiKekka().getTxtYukoKikanFrom().getValue());
        konkai.set前回認定有効終了年月日(div.getCcdZenkaiNinteiKekka().getTxtYukoKikanTo().getValue());

        konkai.set削除事由コード(new Code(div.getCcdShinseiSonotaJohoInput().get削除事由()));
        konkai.set異動理由(div.getCcdShinseiSonotaJohoInput().get理由());
        konkai.set取下年月日(div.getCcdShinseiSonotaJohoInput().get取消日());
        konkai.set喪失年月日(div.getCcdShinseiSonotaJohoInput().get喪失日());
        konkai.set受給資格証明書発行年月日２(div.getCcdShinseiSonotaJohoInput().get受給資格者証発効日２());
        konkai.set受給資格証明書発行年月日１(div.getCcdShinseiSonotaJohoInput().get受給資格者証発行日１());
        konkai.set当初認定有効開始年月日(div.getCcdShinseiSonotaJohoInput().get当初認定期間開始());
        konkai.set当初認定有効終了年月日(div.getCcdShinseiSonotaJohoInput().get当初認定期間終了());
        konkai.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));

        return konkai;
    }

    private FlexibleDate rDateToFlex(RDate fromValue) {
        if (fromValue == null) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(fromValue.getYearValue(), fromValue.getMonthValue(), fromValue.getDayValue());
    }

    private void set指定サービス種類以上(RString サービスコード, int count, RirekiShuseiDataPass konkai) {
        if (RString.isNullOrEmpty(サービスコード)) {
            return;
        }
        switch (count) {
            case 指定サービス種類_17:
                konkai.set指定サービス種類17(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_18:
                konkai.set指定サービス種類18(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_19:
                konkai.set指定サービス種類19(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_20:
                konkai.set指定サービス種類20(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_21:
                konkai.set指定サービス種類21(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_22:
                konkai.set指定サービス種類22(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_23:
                konkai.set指定サービス種類23(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_24:
                konkai.set指定サービス種類24(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_25:
                konkai.set指定サービス種類25(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_26:
                konkai.set指定サービス種類26(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_27:
                konkai.set指定サービス種類27(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_28:
                konkai.set指定サービス種類28(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_29:
                konkai.set指定サービス種類29(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_30:
                konkai.set指定サービス種類30(new ServiceShuruiCode(サービスコード));
                break;
            default:
                break;
        }
    }

    private void set指定サービス種類16以下(RString サービスコード, int count, RirekiShuseiDataPass konkai) {
        if (RString.isNullOrEmpty(サービスコード)) {
            return;
        }
        switch (count) {
            case 指定サービス種類_1:
                konkai.set指定サービス種類01(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_2:
                konkai.set指定サービス種類02(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_3:
                konkai.set指定サービス種類03(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_4:
                konkai.set指定サービス種類04(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_5:
                konkai.set指定サービス種類05(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_6:
                konkai.set指定サービス種類06(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_7:
                konkai.set指定サービス種類07(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_8:
                konkai.set指定サービス種類08(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_9:
                konkai.set指定サービス種類09(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_10:
                konkai.set指定サービス種類10(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_11:
                konkai.set指定サービス種類11(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_12:
                konkai.set指定サービス種類12(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_13:
                konkai.set指定サービス種類13(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_14:
                konkai.set指定サービス種類14(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_15:
                konkai.set指定サービス種類15(new ServiceShuruiCode(サービスコード));
                break;
            case 指定サービス種類_16:
                konkai.set指定サービス種類16(new ServiceShuruiCode(サービスコード));
                break;
            default:
                break;
        }
    }

    private void set申請その他情報(RirekiShuseiDataPass konkai) {
        div.getCcdShinseiSonotaJohoInput().initialize();
        if (konkai.get削除事由コード() != null && !konkai.get削除事由コード().isEmpty()) {
            div.getCcdShinseiSonotaJohoInput().set削除事由(konkai.get削除事由コード().value());
        }
        div.getCcdShinseiSonotaJohoInput().set理由(ObjectUtil.defaultIfNull(konkai.get異動理由(), RString.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set取消日(ObjectUtil.defaultIfNull(konkai.get取下年月日(), FlexibleDate.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set喪失日(ObjectUtil.defaultIfNull(konkai.get喪失年月日(), FlexibleDate.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set発行日2(ObjectUtil.defaultIfNull(konkai.get受給資格証明書発行年月日２(), FlexibleDate.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set発行日１(ObjectUtil.defaultIfNull(konkai.get受給資格証明書発行年月日１(), FlexibleDate.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set当初認定期間From(ObjectUtil.defaultIfNull(konkai.get当初認定有効開始年月日(), FlexibleDate.EMPTY));
        div.getCcdShinseiSonotaJohoInput().set当初認定期間To(ObjectUtil.defaultIfNull(konkai.get当初認定有効終了年月日(), FlexibleDate.EMPTY));
        if (konkai.getデータ区分() != null && !konkai.getデータ区分().isEmpty()) {
            div.getCcdShinseiSonotaJohoInput().set異動事由(konkai.getデータ区分().value());
        }
    }

    private void set前回情報(RirekiShuseiDataPass konkai) {
        div.getCcdZenkaiNinteiKekka().onLoad(new SubGyomuCode(div.getHdnSubGyomuCd()), konkai.get申請書管理番号(), new RString("1"));
        RirekiShuseiDataPass zenkai = DataPassingConverter.deserialize(div.getHdnZenkaiJohoSerialized(),
                RirekiShuseiDataPass.class);
        if (zenkai != null) {
            div.getCcdZenkaiNinteiKekka().getTxtNinteiDay().setValue(rDateTOFlexDate(zenkai.get認定年月日()));
            div.getCcdZenkaiNinteiKekka().getTxtYokaigodo().setValue(
                    get要介護状態区分名称(zenkai.get厚労省IF識別コード().value(), zenkai.get要介護状態区分コード()));
            div.getCcdZenkaiNinteiKekka().getTxtYukoKikanFrom().setValue(rDateTOFlexDate(zenkai.get認定有効開始年月日()));
            div.getCcdZenkaiNinteiKekka().getTxtYukoKikanTo().setValue(rDateTOFlexDate(zenkai.get認定有効終了年月日()));
        }
    }

    private FlexibleDate rDateTOFlexDate(RDate fromDate) {
        if (fromDate != null) {
            return new FlexibleDate(fromDate.getYearValue(), fromDate.getMonthValue(), fromDate.getDayValue());
        }
        return FlexibleDate.EMPTY;
    }

    private void set認定情報(RirekiShuseiDataPass konkai) {
        NinteiInputDataPassModel ninteiInput = new NinteiInputDataPassModel();
        ninteiInput.setSubGyomuCode(div.getHdnSubGyomuCd());
        if (konkai.getデータ区分().value().startsWith(new RString("3"))) {
            ninteiInput.set認定区分(new RString("2"));
        }
        if (konkai.getデータ区分().value().equals(new RString("00"))) {
            ninteiInput.set認定区分(new RString("1"));
        }
        ninteiInput.set要介護度コード(konkai.get要介護状態区分コード().value());
        ninteiInput.set要介護度名称(get要介護状態区分名称(konkai.get厚労省IF識別コード().value(), konkai.get要介護状態区分コード()));
        if (MinashiKoshinNintei.みなし更新認定.getコード().equals(konkai.getみなし要介護区分コード().value())) {
            List<RString> selKey = new ArrayList<>();
            selKey.add(KEY_0);
            ninteiInput.setみなし更新認定(selKey);
        }
        ninteiInput.set認定年月日(konkai.get認定年月日());
        ninteiInput.set有効開始年月日(konkai.get認定有効開始年月日());
        ninteiInput.set有効終了年月日(konkai.get認定有効終了年月日());
        ninteiInput.set審査会意見(ObjectUtil.defaultIfNull(konkai.get介護認定審査会意見(), RString.EMPTY));
        ninteiInput.setサービス一覧リスト(getサービス種類リスト(konkai));
        ninteiInput.set申請書管理番号(konkai.get申請書管理番号());
        div.getCcdNinteiJohoInput().initialize(ninteiInput);
    }

    private void set介護認定申請基本情報入力(RirekiShuseiDataPass konkai) {
        div.getCcdKaigoNinteiShinseiKihonJohoInput().initialize();
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setTxtShinseiYMD(new RDate(konkai.get認定申請年月日().getYearValue(),
                konkai.get認定申請年月日().getMonthValue(), konkai.get認定申請年月日().getDayValue()));
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setTxtShinseiJokyo(konkai.get申請状況区分());
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setRadShinseishoKubun(konkai.get要介護申請_要支援申請の区分());
        if (konkai.get受給申請事由() != null && !konkai.get受給申請事由().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setShinseiShubetsu(JukyuShinseiJiyu.toValue(konkai.get受給申請事由().value()));
        }
        if (konkai.get認定申請区分_申請時_コード() != null && !konkai.get認定申請区分_申請時_コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(konkai.get認定申請区分_申請時_コード().value()));
        }
        if (konkai.get認定申請区分_法令_コード() != null && !konkai.get認定申請区分_法令_コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setShinseiKubunHorei(NinteiShinseiHoreiCode.toValue(konkai.get認定申請区分_法令_コード().value()));
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setShisho(new ShishoCode(konkai.get支所コード()));
        if (konkai.is旧措置フラグ()) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY_0);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setKyuSochisha(keyList);
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setHihokenshaKubun(HihokenshaKubunCode.toValue(konkai.get被保険者区分コード()));
        if (konkai.is資格取得前申請フラグ()) {
            List<RString> keyList = new ArrayList<>();
            keyList.add(KEY_0);
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setChkShikakuShutokuMae(keyList);
        }
        if (konkai.get二号特定疾病コード() != null && !konkai.get二号特定疾病コード().isEmpty()) {
            div.getCcdKaigoNinteiShinseiKihonJohoInput().setTokuteiShippei(TokuteiShippei.toValue(konkai.get二号特定疾病コード().value()));
        }
        div.getCcdKaigoNinteiShinseiKihonJohoInput().setNinteiShinseRiyuTeikeibun(konkai.get認定申請理由());

    }

    private RString get要介護状態区分名称(RString 厚労省IF識別コード, Code 要介護状態区分コード) {
        RString 要介護度名称 = RString.EMPTY;
        if (new RString("99A").equals(厚労省IF識別コード) && 要介護状態区分コード != null && !要介護状態区分コード.isEmpty()) {
            要介護度名称 = YokaigoJotaiKubun99.toValue(要介護状態区分コード.value()).get名称();
        }
        if (new RString("02A").equals(厚労省IF識別コード) && 要介護状態区分コード != null && !要介護状態区分コード.isEmpty()) {
            要介護度名称 = YokaigoJotaiKubun02.toValue(要介護状態区分コード.value()).get名称();
        }
        if (new RString("06A").equals(厚労省IF識別コード) && 要介護状態区分コード != null && !要介護状態区分コード.isEmpty()) {
            要介護度名称 = YokaigoJotaiKubun06.toValue(要介護状態区分コード.value()).get名称();
        }
        if ((new RString("09A").equals(厚労省IF識別コード)
                || new RString("09B").equals(厚労省IF識別コード)) && 要介護状態区分コード != null && !要介護状態区分コード.isEmpty()) {
            要介護度名称 = YokaigoJotaiKubun09.toValue(要介護状態区分コード.value()).get名称();
        }
        return 要介護度名称;
    }

    private List<RString> getサービス種類リスト(RirekiShuseiDataPass konkai) {
        List<RString> サービス種類リスト = new ArrayList<>();
        サービス種類リスト = getValue(konkai.get指定サービス種類01(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類02(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類03(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類04(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類05(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類06(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類07(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類08(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類09(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類10(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類11(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類12(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類13(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類14(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類15(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類16(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類17(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類18(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類19(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類20(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類21(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類22(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類23(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類24(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類25(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類26(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類27(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類28(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類29(), サービス種類リスト);
        サービス種類リスト = getValue(konkai.get指定サービス種類30(), サービス種類リスト);
        return サービス種類リスト;
    }

    private List<RString> getValue(ServiceShuruiCode target, List<RString> サービス種類リスト) {
        if (target != null && !target.isEmpty()) {
            サービス種類リスト.add(target.value());
        }
        return サービス種類リスト;
    }
}
