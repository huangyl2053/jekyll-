/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5120001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseitorokuuketsuke.NinteiShinseiTorokuUketsukeBusiness;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5120001.NinteiShinseiTorokuUketsukeParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.DBD5120001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001.NinteiShinseiTorokuUketsukeDiv;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5120001.NinteiShinseiTorokuUketsukeManager;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.NinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.ShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 要介護認定申請受付画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeHandler {

    private final NinteiShinseiTorokuUketsukeDiv div;

    private static final RString DBDMN51001 = new RString("DBDMN51001");
    private static final RString DBDMN51003 = new RString("DBDMN51003");
    private static final RString DBDMN51004 = new RString("DBDMN51004");
    private static final RString DBDMN51005 = new RString("DBDMN51005");
    private static final RString DBDMN55001 = new RString("DBDMN55001");
    private static final RString DBDMN55003 = new RString("DBDMN55003");
    private static final RString DBDMN55005 = new RString("DBDMN55005");
    private static final RString DBDMN55006 = new RString("DBDMN55006");
    private static final RString DBDMN55007 = new RString("DBDMN55007");
    private static final RString DBDMN55008 = new RString("DBDMN55008");

    private final RString 表示パターン_新規 = new RString("0");
    private final RString 表示パターン_申請中 = new RString("1");
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定申請受付作成のコントロールdiv
     */
    public NinteiShinseiTorokuUketsukeHandler(NinteiShinseiTorokuUketsukeDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 申請書管理番号 ShinseishoKanriNo
     */
    public void onLoad(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            ShinseishoKanriNo 申請書管理番号) {

        RString 表示パターン = get表示パターン();

        NinteiShinseiTorokuUketsukeManager manager = NinteiShinseiTorokuUketsukeManager.createInstance();

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.set識別コード(識別コード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        NinteiShinseiTorokuUketsukeParameter param = NinteiShinseiTorokuUketsukeParameter.createParam(
                被保険者番号, 識別コード, 申請書管理番号, 表示パターン, FlexibleDate.getNowDate(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));

        NinteiShinseiTorokuUketsukeBusiness result = manager.get初期化情報(param);

        div.getCcdKaigoNinteiAtenaInfo().initialize();
        //TODO
        //div.getCcdKaigoNinteiShikakuInfo().initialize(DBDMN51001, DBDMN51001, DBDMN51001, DBDMN51001);

        if (result != null) {

            this.set介護認定申請基本情報(result);
            this.set認定申請届出者(result);
            this.set主治医医療機関_主治医入力(result);
            this.set調査委託先_調査員入力(result);
            this.set認定情報(result);
            this.set前回認定結果(result);
            this.set申請その他情報(result);
            this.set延期タブ表示用の情報(result);
        }

        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())) {
            this.edit状態_申請追加();
        } else if (DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())) {
            this.edit状態_申請修正();
        } else if (DBD5120001StateName.申請取下.getName().equals(ResponseHolder.getState())) {
            this.edit状態_申請取下();
        } else if (DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())) {
            this.edit状態_区分変更追加();
        } else if (DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())) {
            this.edit状態_区分変更修正();
        } else if (DBD5120001StateName.区分変更取下.getName().equals(ResponseHolder.getState())) {
            this.edit状態_区分変更取消();
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {
            this.edit状態_サービス変更追加();
        } else if (DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            this.edit状態_サービス変更修正();
        } else if (DBD5120001StateName.サービス変更取下.getName().equals(ResponseHolder.getState())) {
            this.edit状態_サービス変更取消();
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(ResponseHolder.getState())) {
            this.edit状態_受給者転入追加();
        } else if (DBD5120001StateName.特殊追加.getName().equals(ResponseHolder.getState())) {
            this.edit状態_特殊追加();
        } else if (DBD5120001StateName.特殊修正.getName().equals(ResponseHolder.getState())) {
            this.edit状態_特殊修正();
        } else if (DBD5120001StateName.特殊削除.getName().equals(ResponseHolder.getState())) {
            this.edit状態_特殊削除();
        } else if (DBD5120001StateName.削除回復.getName().equals(ResponseHolder.getState())) {
            this.edit状態_削除回復();
        } else if (DBD5120001StateName.職権記載.getName().equals(ResponseHolder.getState())) {
            this.edit状態_職権記載();
        } else if (DBD5120001StateName.職権全喪失.getName().equals(ResponseHolder.getState())) {
            this.edit状態_職権取消全喪失();
        }

    }

    /**
     * 保存する処理です。
     *
     * @return RString
     */
    public RString get表示パターン() {

        if (DBDMN51001.equals(ResponseHolder.getMenuID())
                || DBDMN51003.equals(ResponseHolder.getMenuID())
                || DBDMN51004.equals(ResponseHolder.getMenuID())
                || DBDMN51005.equals(ResponseHolder.getMenuID())
                || DBDMN55001.equals(ResponseHolder.getMenuID())
                || DBDMN55003.equals(ResponseHolder.getMenuID())
                || DBDMN55005.equals(ResponseHolder.getMenuID())
                || DBDMN55006.equals(ResponseHolder.getMenuID())
                || DBDMN55007.equals(ResponseHolder.getMenuID())
                || DBDMN55008.equals(ResponseHolder.getMenuID())) {
            return 表示パターン_新規;
        } else {
            return 表示パターン_申請中;
        }
    }

    /**
     * 保存する処理です。
     *
     */
    public void onClick_btnUpdate() {

        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {

            return;
        }

    }

    /**
     * 申請追加状態の具体設定。
     *
     */
    public void edit状態_申請追加() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShinseiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);

    }

    /**
     * 申請修正状態の具体設定。
     *
     */
    public void edit状態_申請修正() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShinseiShuseiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 申請取下状態の具体設定。
     *
     */
    public void edit状態_申請取下() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TorikeshiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 区分変更追加状態の具体設定。
     *
     */
    public void edit状態_区分変更追加() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.KubunHenkoMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 区分変更修正状態の具体設定。
     *
     */
    public void edit状態_区分変更修正() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.KubunHenkoMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 区分変更取消状態の具体設定。
     *
     */
    public void edit状態_区分変更取消() {

        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TorikeshiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(true);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * サービス変更追加状態の具体設定。
     *
     */
    public void edit状態_サービス変更追加() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ServiceHenkoMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * サービス変更修正状態の具体設定。
     *
     */
    public void edit状態_サービス変更修正() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ServiceHenkoMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * サービス変更取消状態の具体設定。
     *
     */
    public void edit状態_サービス変更取消() {

        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TorikeshiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(true);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 受給者転入追加状態の具体設定。
     *
     */
    public void edit状態_受給者転入追加() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ServiceHenkoMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.JukyuShikakushashoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 特殊追加状態の具体設定。
     *
     */
    public void edit状態_特殊追加() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.TokushuTsuikaMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.TokushuTsuikaMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuTsuikaMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(false);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 特殊修正状態の具体設定。
     *
     */
    public void edit状態_特殊修正() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.TokushuShuseiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.TokushuShuseiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuShuseiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(false);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 特殊削除状態の具体設定。
     *
     */
    public void edit状態_特殊削除() {

        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.TokushuSakujyoMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(true);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 削除回復状態の具体設定。
     *
     */
    public void edit状態_削除回復() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ShokaiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(true);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 職権記載状態の具体設定。
     *
     */
    public void edit状態_職権記載() {

        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(true);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokkenKisaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.InputMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.InputMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.InputMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.InputMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ShokkenKisaiMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(false);
        div.getChkJohoTeikyoDoi().setDisabled(false);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 職権取消全喪失状態の具体設定。
     *
     */
    public void edit状態_職権取消全喪失() {

        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);

        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokaiMode.toString()));
        div.getCcdShinseiTodokedesha().set状態(
                new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdShujiiIryokikanAndShujiiInput().setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        div.getCcdChosaItakusakiAndChosainInput().setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        div.getCcdNinteiInput().set状態(new RString(NinteiInputDiv.ShoriType.ShokaiMode.toString()));
        div.getCcdZenkaiNinteiKekkaJoho().setMode_ShokaiButtonType(ZenkaiNinteiKekkaJohoDiv.ShokaiButtonType.ShokaiButtonNoneMode);
        div.getCcdShinseiSonotaJohoInput().setMode_ShoriType(ShinseiSonotaJohoInputDiv.ShoriType.ZenbuSoshitsuMode);
        div.getChkNinteiTsuchishoDoi().setDisabled(true);
        div.getChkJohoTeikyoDoi().setDisabled(true);

        div.getTplEnki().setDisabled(true);
    }

    /**
     * 完了状態の具体設定。
     *
     */
    public void edit状態_完了() {

    }

    private void set介護認定申請基本情報(NinteiShinseiTorokuUketsukeBusiness result) {

        KaigoNinteiShinseiKihonJohoInputDiv kaigoNinteiShinseiKihonJohoInputDiv
                = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        kaigoNinteiShinseiKihonJohoInputDiv.initialize();
        kaigoNinteiShinseiKihonJohoInputDiv.setRadShinseishoKubun(result.getEntity().get申請書区分());
        kaigoNinteiShinseiKihonJohoInputDiv.setTxtShinseiJokyo(result.getEntity().get申請状況());
        if (result.getEntity().get申請日() != null) {
            kaigoNinteiShinseiKihonJohoInputDiv.setTxtShinseiYMD(new RDate(result.getEntity().get申請日().toString()));
        }
        if (result.getEntity().get申請種別() != null) {
            kaigoNinteiShinseiKihonJohoInputDiv.setShinseiShubetsu(JukyuShinseiJiyu.toValue(result.getEntity().get申請種別().getColumnValue()));
        }
        if (result.getEntity().get認定申請区分コード_申請時() != null) {
            kaigoNinteiShinseiKihonJohoInputDiv.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(result.getEntity().get認定申請区分コード_申請時().getColumnValue()));
        }
        if (result.getEntity().get認定申請区分コード_法令() != null) {
            kaigoNinteiShinseiKihonJohoInputDiv.setShinseiKubunHorei(
                    NinteiShinseiHoreiCode.toValue(result.getEntity().get認定申請区分コード_法令().getColumnValue()));
        }
        kaigoNinteiShinseiKihonJohoInputDiv.setShisho(
                new ShishoCode(result.getEntity().get支所コード()));

        List<RString> dataSource = new ArrayList<>();
        if (result.getEntity().is旧措置者フラグ()) {
            dataSource.add(SELECT_KEY0);
        }
        kaigoNinteiShinseiKihonJohoInputDiv.setKyuSochisha(dataSource);

        kaigoNinteiShinseiKihonJohoInputDiv.setHihokenshaKubun(
                HihokenshaKubunCode.toValue(result.getEntity().get被保険者区分コード()));

        List<RString> dataSource1 = new ArrayList<>();
        if (result.getEntity().is資格取得前申請フラグ()) {
            dataSource1.add(SELECT_KEY0);
        }
        kaigoNinteiShinseiKihonJohoInputDiv.setChkShikakuShutokuMae(dataSource1);

        if (result.getEntity().get二号特定疾病コード() != null) {
            kaigoNinteiShinseiKihonJohoInputDiv.setTokuteiShippei(
                    TokuteiShippei.toValue(result.getEntity().get二号特定疾病コード().getColumnValue()));
        }
        kaigoNinteiShinseiKihonJohoInputDiv.setServiceSakujoTeikeibun(result.getEntity().get申請サービス削除の理由());
        kaigoNinteiShinseiKihonJohoInputDiv.setNinteiShinseRiyuTeikeibun(result.getEntity().get認定申請理由());
    }

    private void set認定申請届出者(NinteiShinseiTorokuUketsukeBusiness result) {

        INinteiShinseiTodokedeshaDiv iNinteiShinseiTodokedeshaDiv
                = div.getCcdShinseiTodokedesha();

        List<RString> 申請届出代行区分List = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            申請届出代行区分List.add(code.getCode());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlTodokledeDaikoKubun().setDataSource(setDataSource(申請届出代行区分List, false));
        if (result.getEntity().get申請届出代行区分コード() != null) {
            iNinteiShinseiTodokedeshaDiv.getDdlTodokledeDaikoKubun().setSelectedKey(result.getEntity().get申請届出代行区分コード().getColumnValue());
        }
        if (result.getEntity().get事業者番号() != null) {
            TextBox 事業者番号 = new TextBox();
            事業者番号.setValue(result.getEntity().get事業者番号().getColumnValue());
            iNinteiShinseiTodokedeshaDiv.setTxtJigyoshaCode(事業者番号);
        }

        List<RString> shinseiKankeishaCodeList = new ArrayList<>();
        for (JigyoshaKubun code : JigyoshaKubun.values()) {
            shinseiKankeishaCodeList.add(code.getCode());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlShinseiKankeisha().setDataSource(setDataSource(shinseiKankeishaCodeList, false));

        TextBox 氏名 = new TextBox();
        氏名.setValue(result.getEntity().get申請届出者氏名());
        iNinteiShinseiTodokedeshaDiv.setTxtShimei(氏名);

        TextBox カナ氏名 = new TextBox();
        カナ氏名.setValue(result.getEntity().get申請届出者氏名カナ());
        iNinteiShinseiTodokedeshaDiv.setTxtKanaShimei(カナ氏名);

        TextBox 本人との関係性 = new TextBox();
        本人との関係性.setValue(result.getEntity().get届出者_本人との関係());
        iNinteiShinseiTodokedeshaDiv.setTxtHonninKankeisei(本人との関係性);

        if (new RString("0").equals(result.getEntity().get管内管外区分())) {
            iNinteiShinseiTodokedeshaDiv.getRadKannaiKangai().setSelectedKey(SELECT_KEY0);
        } else if (new RString("1").equals(result.getEntity().get管内管外区分())) {
            iNinteiShinseiTodokedeshaDiv.getRadKannaiKangai().setSelectedKey(SELECT_KEY1);
        }

        TextBoxTelNo 電話番号 = new TextBoxTelNo();
        電話番号.setDomain(result.getEntity().get申請届出者電話番号());
        iNinteiShinseiTodokedeshaDiv.setTxtTelNo(電話番号);

        TextBoxYubinNo 郵便番号 = new TextBoxYubinNo();
        郵便番号.setValue(result.getEntity().get申請届出者郵便番号());
        iNinteiShinseiTodokedeshaDiv.setTxtYubinNo(郵便番号);

    }

    private List<KeyValueDataSource> setDataSource(List<RString> codeList, boolean kubun) {
        Collections.sort(codeList);
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        KeyValueDataSource data = new KeyValueDataSource();
        data.setKey(RString.EMPTY);
        data.setValue(RString.EMPTY);
        dataSourceList.add(data);
        for (RString code : codeList) {
            KeyValueDataSource keyValue = new KeyValueDataSource();
            keyValue.setKey(code);
            if (kubun) {
                keyValue.setValue(new RString(ShinseiTodokedeDaikoKubunCode.toValue(code).name()));
            } else {
                keyValue.setValue(new RString(JigyoshaKubun.toValue(code).name()));
            }
            dataSourceList.add(keyValue);
        }
        return dataSourceList;
    }

    private void set主治医医療機関_主治医入力(NinteiShinseiTorokuUketsukeBusiness result) {

        IShujiiIryokikanAndShujiiInputDiv 主治医div = div.getCcdShujiiIryokikanAndShujiiInput();

        TextBoxCode 主治医医療機関 = new TextBoxCode();
        主治医医療機関.setValue(result.getEntity().get主治医医療機関コード());
        主治医div.setTxtIryoKikanCode(主治医医療機関);

        TextBox 主治医医療機関名 = new TextBox();
        主治医医療機関名.setValue(result.getEntity().get医療機関名称());
        主治医div.setTxtIryoKikanName(主治医医療機関名);

        TextBoxCode 主治医 = new TextBoxCode();
        主治医.setValue(result.getEntity().get主治医コード());
        主治医div.setTxtShujiiCode(主治医);

        TextBox 主治医名 = new TextBox();
        主治医名.setValue(result.getEntity().get主治医氏名());
        主治医div.setTxtShujiiName(主治医名);

        主治医div.setShiteii(result.getEntity().is指定医フラグ());
    }

    private void set調査委託先_調査員入力(NinteiShinseiTorokuUketsukeBusiness result) {

        IChosaItakusakiAndChosainInputDiv 調査委託先div = div.getChosainAndChosainInput().getCcdChosaItakusakiAndChosainInput();

        if (result.getEntity().get認定調査委託先コード() != null) {
            調査委託先div.getTxtChosaItakusakiCode().setValue(result.getEntity().get認定調査委託先コード().getColumnValue());
        }

        調査委託先div.getTxtChosaItakusakiName().setValue(result.getEntity().get事業者名称());
        調査委託先div.getTxtChosainCode().setValue(result.getEntity().get認定調査員コード());
        調査委託先div.getTxtChosainName().setValue(result.getEntity().get調査員氏名());
    }

    private void set認定情報(NinteiShinseiTorokuUketsukeBusiness result) {

        INinteiInputDiv 認定div = div.getCcdNinteiInput();

        if (result.getEntity().get要介護認定状態区分コード() != null) {
            認定div.getNinteiJoho().getTxtYokaigodoCode().setValue(result.getEntity().get要介護認定状態区分コード().getColumnValue());
        }
        認定div.getNinteiJoho().getTxtNinteiYMD().setValue(result.getEntity().get認定年月日());
        認定div.getNinteiJoho().getTxtYukoKaishiYMD().setValue(result.getEntity().get認定有効期間開始年月日());
        認定div.getNinteiJoho().getTxtYukoShuryoYMD().setValue(result.getEntity().get認定有効期間終了年月日());
        認定div.getTxtShinsakaiIken().setValue(result.getEntity().get介護認定審査会意見());
    }

    private void set前回認定結果(NinteiShinseiTorokuUketsukeBusiness result) {

        IZenkaiNinteiKekkaJohoDiv 前回認定結果div = div.getCcdZenkaiNinteiKekkaJoho();

        if (result.getEntity().get前回要介護状態区分コード() != null) {
            前回認定結果div.getTxtYokaigodo().setValue(result.getEntity().get前回要介護状態区分コード().getColumnValue());
        }
        前回認定結果div.getTxtNinteiDay().setValue(result.getEntity().get前回認定年月日());
        前回認定結果div.getTxtYukoKikanFrom().setValue(result.getEntity().get前回認定有効期間_開始());
        前回認定結果div.getTxtYukoKikanTo().setValue(result.getEntity().get前回認定有効期間_終了());
    }

    private void set申請その他情報(NinteiShinseiTorokuUketsukeBusiness result) {

        IShinseiSonotaJohoInputDiv 申請その他情報div = div.getCcdShinseiSonotaJohoInput();

        申請その他情報div.initialize();
        if (result.getEntity().get異動事由() != null) {
            申請その他情報div.set異動事由(result.getEntity().get異動事由().getColumnValue());
        }
        if (result.getEntity().get削除事由コード() != null) {
            申請その他情報div.set削除事由(result.getEntity().get削除事由コード().getColumnValue());
        }
        申請その他情報div.set理由(result.getEntity().get理由());
        申請その他情報div.set喪失日(result.getEntity().get喪失年月日());
        申請その他情報div.set取消日(result.getEntity().get取下年月日());
        申請その他情報div.set当初認定期間From(result.getEntity().get当初認定有効開始年月日());
        申請その他情報div.set当初認定期間To(result.getEntity().get当初認定有効終了年月日());
        申請その他情報div.set発行日１(result.getEntity().get受給資格証明書発行年月日１());
        申請その他情報div.set発行日2(result.getEntity().get受給資格証明書発行年月日２());
    }

    private void set延期タブ表示用の情報(NinteiShinseiTorokuUketsukeBusiness result) {

        div.getTxtEnkiKetteiYMD().setValue(result.getEntity().get延期決定年月日());
        div.getTxtEnkiMikomiKikanFrom().setValue(result.getEntity().get延期見込期間開始年月日());
        div.getTxtEnkiMikomiKikanTo().setValue(result.getEntity().get延期見込期間終了年月日());
        div.getTxtEnkiRiyu().setValue(result.getEntity().get延期理由());
        div.getTxtEnkiTsuchiHakkoYMD().setValue(result.getEntity().get延期通知発行年月日());
        div.getTxtEnkiTsuchishoHakkoCount().setValue(result.getEntity().get延期通知発行回数());
    }

}
