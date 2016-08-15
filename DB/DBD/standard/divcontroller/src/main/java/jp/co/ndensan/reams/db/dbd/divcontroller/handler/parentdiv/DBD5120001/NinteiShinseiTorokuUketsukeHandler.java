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
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseishaKankeiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJohoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
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
import jp.co.ndensan.reams.db.dbz.service.core.basic.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShinseitodokedeJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 要介護認定申請受付画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeHandler {

    private final NinteiShinseiTorokuUketsukeDiv div;
    private ShinseishoKanriNo shinseishoKanriNo;

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
    private static final RString ZERO_17 = new RString("00000000000000000");

    private static final int INT_4 = 4;

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

        this.edit状態();

        NinteiShinseiTorokuUketsukeManager manager = NinteiShinseiTorokuUketsukeManager.createInstance();

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        NinteiShinseiTorokuUketsukeParameter param = NinteiShinseiTorokuUketsukeParameter.createParam(
                被保険者番号, 識別コード, 申請書管理番号, 表示パターン, FlexibleDate.getNowDate(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));

        NinteiShinseiTorokuUketsukeBusiness result = manager.get初期化情報(param);

        div.getCcdKaigoNinteiAtenaInfo().initialize();
        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(申請書管理番号, 識別コード);

        RString 市町村コード = null;
        if (result != null
                && result.getEntity().get市町村コード() != null) {
            市町村コード = result.getEntity().get市町村コード().getColumnValue();
        }

        div.getCcdKaigoNinteiShikakuInfo().initialize(
                市町村コード,
                被保険者番号 != null ? 被保険者番号.getColumnValue() : null);

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

        div.setHdnRenrakusakiReadOnly(new RString("0"));
        div.setHdnShichosonCode(市町村コード);
        div.setHdnShinseishoKanriNo(申請書管理番号 != null ? 申請書管理番号.getColumnValue() : null);
        div.setHdnShikibetsuCode(識別コード != null ? 識別コード.getColumnValue() : null);
        div.setHdnHihokenshaNo(被保険者番号 != null ? 被保険者番号.getColumnValue() : null);

    }

    /**
     * 表示パターン取得処理です。
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
     * 状態編集処理です。
     *
     */
    private void edit状態() {

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
     */
    public void onClick_btnUpdate() {

        CountedItem countedItem = Saiban.get(
                SubGyomuCode.DBD介護受給, SaibanHanyokeyName.市町村コード_西暦_月.get名称(), FlexibleDate.getNowDate().getNendo());

        shinseishoKanriNo = new ShinseishoKanriNo(countedItem.nextString());

        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_申請();
            insert要介護認定申請情報_申請();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert介護保険施設入退所();
            insert介護保険医療機関加入状況();
        } else if (DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            update受給者台帳_申請修正();
            update要介護認定申請情報_申請修正();
            update申請届出者();
            update介護連絡先();
            update介護保険施設入退所();
            update介護保険医療機関加入状況();
        } else if (DBD5120001StateName.申請取下.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更取下.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更取下.getName().equals(ResponseHolder.getState())) {
            update受給者台帳_申請取下();
            update要介護認定申請情報_申請取下();
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_転入();
            insert要介護認定申請情報_転入();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert介護保険施設入退所();
            insert介護保険医療機関加入状況();
        } else if (DBD5120001StateName.職権記載.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.職権全喪失.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_職権();
            insert要介護認定申請情報_職権();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert介護保険施設入退所();
            insert介護保険医療機関加入状況();
        } else if (DBD5120001StateName.特殊追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.特殊修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.特殊削除.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.削除回復.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_特殊();
            insert要介護認定申請情報_特殊();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert介護保険施設入退所();
            insert介護保険医療機関加入状況();
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

    private void insert受給者台帳_申請() {

        //TODO受給申請事由
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code(""));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set申請書管理番号(shinseishoKanriNo);
        builder.set申請状況区分(new RString("0"));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set直近フラグ(false);
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set届出者_申請者関係コード(new Code(div.getCcdShinseiTodokedesha().getDdlShinseiKankeisha().getSelectedKey()));
        builder.set届出者_本人との関係(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("00"));
        builder.set有効無効区分(new Code("0"));
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        //TODO
        builder.set要支援者認定申請区分(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_申請() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(new ShinseishoKanriNo(""));
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set厚労省IF識別コード(new Code(""));
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode("00"));
        //TODO
        builder.set認定申請区分_法令_コード(Code.EMPTY);
        //TODO
        builder.set認定申請区分_申請時_コード(Code.EMPTY);
        builder.set取下区分コード(new Code("1"));
        builder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey());
        builder.set生年月日(new FlexibleDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日().toDateString()));
        builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        builder.set性別(new Code(div.getCcdKaigoNinteiAtenaInfo().get性別()));
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().get氏名()));
        builder.set郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set住所(new AtenaJusho(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称()));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        //TODO
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        //TODO
        builder.set申請サービス削除の理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().getValue());
        //TODO
        builder.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue()));
        //TODO
        builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        //TODO
        builder.set前回認定有効期間_開始_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        //TODO
        builder.set前回認定有効期間_終了_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        //TODO２号医療保険者名 ２号医療保険記号番号
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        //TODO調査員への連絡事項
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        //TODO主治医への連絡事項
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項
        builder.set処理状態区分(new Code("1"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        //更新通知発行年月日 更新通知発行完了年月日
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert申請届出者() {

        //TODO
        ShinseitodokedeJoho shinseitodokedeJoho = new ShinseitodokedeJoho(new ShinseishoKanriNo(""));
        ShinseitodokedeJohoBuilder builder = shinseitodokedeJoho.createBuilderForEdit();

        builder.set申請届出代行区分コード(new Code(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey()));
        builder.set申請届出者氏名(div.getCcdShinseiTodokedesha().get一覧内容().get氏名());
        builder.set申請届出者氏名カナ(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名());
        builder.set申請届出者続柄コード(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set申請届出代行事業者番号(new JigyoshaNo(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者()));
        builder.set申請届出者郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称());
        builder.set申請届出者電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));

        ShinseitodokedeJoho newShinseitodokedeJoho = builder.build();
        ShinseitodokedeJohoManager manager = new ShinseitodokedeJohoManager();
        manager.save申請届出情報(newShinseitodokedeJoho);
    }

    private void insert介護連絡先() {
        //TODO
    }

    private void insert申請履歴情報() {
        //TODO
        ShinseiRirekiJoho shinseiRirekiJoho = new ShinseiRirekiJoho(new ShinseishoKanriNo(""));
        ShinseiRirekiJohoBuilder builder = shinseiRirekiJoho.createBuilderForEdit();
        //TODO
        builder.set前回申請管理番号(new ShinseishoKanriNo(ZERO_17));

        ShinseiRirekiJoho newShinseiRirekiJoho = builder.build();
        ShinseiRirekiJohoManager manager = new ShinseiRirekiJohoManager();
        manager.save申請履歴情報(newShinseiRirekiJoho);

    }

    private void insert介護保険施設入退所() {
        //TODO
        ShisetsuNyutaisho shisetsuNyutaisho = new ShisetsuNyutaisho(new ShikibetsuCode(div.getHdnShikibetsuCode()), 0);
        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
        //TODO
        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
        //TODO

        ShisetsuNyutaisho newShisetsuNyutaisho = builder.build();
        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
        manager.save介護保険施設入退所(newShisetsuNyutaisho);

    }

    private void insert介護保険医療機関加入状況() {
        //TODO
        IryohokenKanyuJokyo iryohokenKanyuJokyo = new IryohokenKanyuJokyo(new ShikibetsuCode(div.getHdnShikibetsuCode()), 0);
        IryohokenKanyuJokyoBuilder builder = iryohokenKanyuJokyo.createBuilderForEdit();
        //TODO
        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
        builder.set被保険者番号(new HihokenshaNo(div.getHdnHihokenshaNo()));
        //TODO

        IryohokenKanyuJokyo newIryohokenKanyuJokyo = builder.build();
        IryohokenKanyuJokyoManager manager = new IryohokenKanyuJokyoManager();
        manager.save介護保険医療保険加入状況(newIryohokenKanyuJokyo);

    }

    private void insert受給者台帳_転入() {

        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code("7"));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set申請書管理番号(shinseishoKanriNo);
        builder.set申請状況区分(new RString("0"));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set直近フラグ(true);
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        //TODO
        builder.set申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set届出者_申請者関係コード(new Code(div.getCcdShinseiTodokedesha().getDdlShinseiKankeisha().getSelectedKey()));
        builder.set届出者_本人との関係(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set要介護認定状態区分コード(new Code(div.getCcdNinteiInput().getNaiyo().get要介護度コード()));
        builder.set認定有効期間開始年月日(div.getCcdNinteiInput().getNaiyo().get有効開始年月日());
        builder.set認定有効期間終了年月日(div.getCcdNinteiInput().getNaiyo().get有効終了年月日());
        builder.set認定年月日(div.getCcdNinteiInput().getNaiyo().get認定年月日());
        //TODO指定サービス種類
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("00"));
        builder.set有効無効区分(new Code("1"));
        builder.setデータ区分(new Code("21"));
        builder.set同一連番(new RString("0001"));
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(false);
        builder.set資格取得前申請フラグ(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_転入() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(new ShinseishoKanriNo(""));
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set厚労省IF識別コード(new Code(""));
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode("00"));
        builder.set認定申請区分_法令_コード(new Code("4"));
        builder.set認定申請区分_申請時_コード(new Code("5"));
        builder.set取下区分コード(new Code("1"));
        builder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey());
        builder.set生年月日(new FlexibleDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日().toDateString()));
        builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        builder.set性別(new Code(div.getCcdKaigoNinteiAtenaInfo().get性別()));
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().get氏名()));
        builder.set郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set住所(new AtenaJusho(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称()));
        builder.set電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.setみなし２号等対象フラグ(false);
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        //TODO２号医療保険者名 ２号医療保険記号番号
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        //TODO調査員への連絡事項
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        //TODO主治医への連絡事項
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項
        builder.set処理状態区分(new Code("1"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        //更新通知発行年月日 更新通知発行完了年月日
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert受給者台帳_職権() {

        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code("7"));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set申請書管理番号(shinseishoKanriNo);
        builder.set申請状況区分(new RString("1"));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set直近フラグ(true);
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set届出者_申請者関係コード(new Code(div.getCcdShinseiTodokedesha().getDdlShinseiKankeisha().getSelectedKey()));
        builder.set届出者_本人との関係(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set要介護認定状態区分コード(new Code(div.getCcdNinteiInput().getNaiyo().get要介護度コード()));
        builder.set認定有効期間開始年月日(div.getCcdNinteiInput().getNaiyo().get有効開始年月日());
        builder.set認定有効期間終了年月日(div.getCcdNinteiInput().getNaiyo().get有効終了年月日());
        builder.set認定年月日(div.getCcdNinteiInput().getNaiyo().get認定年月日());
        //TODO指定サービス種類
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("10"));
        builder.set有効無効区分(new Code("0"));
        builder.setデータ区分(new Code("24"));
        // 履歴番号と同一
        builder.set同一連番(new RString("0001"));
        builder.set異動理由(div.getCcdShinseiSonotaJohoInput().get理由());
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(false);
        builder.set資格取得前申請フラグ(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_職権() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(new ShinseishoKanriNo(""));
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set厚労省IF識別コード(new Code(""));
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode("00"));
        builder.set認定申請区分_法令_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().getSelectedKey()));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set取下区分コード(new Code("1"));
        builder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey());
        builder.set生年月日(new FlexibleDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日().toDateString()));
        builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        builder.set性別(new Code(div.getCcdKaigoNinteiAtenaInfo().get性別()));
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().get氏名()));
        builder.set郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set住所(new AtenaJusho(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称()));
        builder.set電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.setみなし２号等対象フラグ(false);
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        //TODO２号医療保険者名 ２号医療保険記号番号
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        //TODO調査員への連絡事項
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        //TODO主治医への連絡事項
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項
        builder.set処理状態区分(new Code("1"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        //更新通知発行年月日 更新通知発行完了年月日
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert受給者台帳_特殊() {

        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code("7"));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set申請書管理番号(shinseishoKanriNo);
        builder.set申請状況区分(new RString("1"));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set直近フラグ(true);
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set届出者_申請者関係コード(new Code(div.getCcdShinseiTodokedesha().getDdlShinseiKankeisha().getSelectedKey()));
        builder.set届出者_本人との関係(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set要介護認定状態区分コード(new Code(div.getCcdNinteiInput().getNaiyo().get要介護度コード()));
        builder.set認定有効期間開始年月日(div.getCcdNinteiInput().getNaiyo().get有効開始年月日());
        builder.set認定有効期間終了年月日(div.getCcdNinteiInput().getNaiyo().get有効終了年月日());
        builder.set認定年月日(div.getCcdNinteiInput().getNaiyo().get認定年月日());
        //TODO指定サービス種類
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("01"));
        builder.set有効無効区分(new Code("0"));
        builder.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));
        // 履歴番号と同一
        builder.set同一連番(new RString("0001"));
        builder.set異動理由(div.getCcdShinseiSonotaJohoInput().get理由());
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(new RString("1").equals(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_特殊() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(new ShinseishoKanriNo(""));
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set厚労省IF識別コード(new Code(""));
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode("00"));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set取下区分コード(new Code("1"));
        builder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey());
        builder.set生年月日(new FlexibleDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日().toDateString()));
        builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        builder.set性別(new Code(div.getCcdKaigoNinteiAtenaInfo().get性別()));
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().get氏名()));
        builder.set郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set住所(new AtenaJusho(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称()));
        builder.set電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue()));
        builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        builder.set前回認定有効期間_開始_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        builder.set前回認定有効期間_終了_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        //TODO２号医療保険者名 ２号医療保険記号番号
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        //TODO調査員への連絡事項
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        //TODO主治医への連絡事項
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項
        //更新通知発行年月日 更新通知発行完了年月日
        builder.set論理削除フラグ(false);

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void update受給者台帳_申請修正() {

        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code(""));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set直近フラグ(true);
        builder.set申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set届出者_申請者関係コード(new Code(div.getCcdShinseiTodokedesha().getDdlShinseiKankeisha().getSelectedKey()));
        builder.set届出者_本人との関係(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set受給申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set有効無効区分(new Code("0"));
        builder.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void update要介護認定申請情報_申請修正() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(shinseishoKanriNo);
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set被保険者区分コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().getSelectedKey());
        builder.set生年月日(new FlexibleDate(div.getCcdKaigoNinteiAtenaInfo().get生年月日().toDateString()));
        builder.set年齢(Integer.parseInt(div.getCcdKaigoNinteiAtenaInfo().get年齢().toString()));
        builder.set性別(new Code(div.getCcdKaigoNinteiAtenaInfo().get性別()));
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdShinseiTodokedesha().get一覧内容().get氏名()));
        builder.set郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set住所(new AtenaJusho(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称()));
        builder.set電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getCcdKaigoNinteiAtenaInfo().get識別コード()));
        //TODO地区コード
        builder.setみなし２号等対象フラグ(false);
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        //TODO申請サービス削除の理由
        builder.set申請サービス削除の理由(new RString(""));
        builder.set前回要介護状態区分コード(new Code(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue()));
        //TODO
        builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        //TODO
        builder.set前回認定有効期間_開始_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        //TODO
        builder.set前回認定有効期間_終了_(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        //TODO２号医療保険者名 ２号医療保険記号番号
        builder.set２号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set情報提供資料出力年月日(null);
        builder.set調査区分(null);
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        //TODO調査員への連絡事項
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set意見書データ種別(null);
        //TODO主治医への連絡事項
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項
        builder.set取下年月日(null);
        builder.set取下理由(null);
        builder.set却下年月日(null);
        builder.set却下理由(null);
        builder.set延期決定年月日(null);
        builder.set延期理由(null);
        builder.set延期通知発行年月日(null);
        builder.set延期通知発行回数(0);
        builder.set延期見込期間開始年月日(null);
        builder.set延期見込期間終了年月日(null);
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.setＩＦ送付年月日(null);
        builder.set論理削除フラグ(false);

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void update受給者台帳_申請取下() {

        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code(""));

        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        //TODO
        builder.set直近異動事由コード(new Code("00"));
        builder.set有効無効区分(new Code("2"));
        builder.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));

        JukyushaDaicho newJukyushaDaicho = builder.build();

        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void update要介護認定申請情報_申請取下() {
        //TODO
        NinteiShinseiJoho ninteiShinseiJoho = new NinteiShinseiJoho(shinseishoKanriNo);
        NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();

        //TODO
        builder.set取下区分コード(new Code("3"));
        builder.set取下年月日(div.getCcdShinseiSonotaJohoInput().get取消日());
        builder.set取下理由(div.getCcdShinseiSonotaJohoInput().get削除事由());

        NinteiShinseiJoho newNinteiShinseiJoho = builder.build();

        NinteiShinseiJohoManager manager = new NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void update申請届出者() {

        //TODO
        ShinseitodokedeJoho shinseitodokedeJoho = new ShinseitodokedeJoho(shinseishoKanriNo);
        ShinseitodokedeJohoBuilder builder = shinseitodokedeJoho.createBuilderForEdit();

        builder.set申請届出代行区分コード(new Code(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey()));
        builder.set申請届出者氏名(div.getCcdShinseiTodokedesha().get一覧内容().get氏名());
        builder.set申請届出者氏名カナ(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名());
        builder.set申請届出者続柄コード(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        builder.set申請届出代行事業者番号(new JigyoshaNo(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者()));
        builder.set申請届出者郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
        builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所名称());
        builder.set申請届出者電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));

        ShinseitodokedeJoho newShinseitodokedeJoho = builder.build();
        ShinseitodokedeJohoManager manager = new ShinseitodokedeJohoManager();
        manager.save申請届出情報(newShinseitodokedeJoho);
    }

    private void update介護連絡先() {
        //TODO
    }

    private void update介護保険施設入退所() {
        //TODO
        ShisetsuNyutaisho shisetsuNyutaisho = new ShisetsuNyutaisho(new ShikibetsuCode(div.getCcdKaigoNinteiAtenaInfo().get識別コード()), 0);
        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
        //TODO
        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
        //TODO

        ShisetsuNyutaisho newShisetsuNyutaisho = builder.build();
        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
        manager.save介護保険施設入退所(newShisetsuNyutaisho);

    }

    private void update介護保険医療機関加入状況() {
        //TODO
        IryohokenKanyuJokyo iryohokenKanyuJokyo = new IryohokenKanyuJokyo(new ShikibetsuCode(div.getCcdKaigoNinteiAtenaInfo().get識別コード()), 0);
        IryohokenKanyuJokyoBuilder builder = iryohokenKanyuJokyo.createBuilderForEdit();
        //TODO
        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
        builder.set被保険者番号(new HihokenshaNo(div.getHdnHihokenshaNo()));
        //TODO

        IryohokenKanyuJokyo newIryohokenKanyuJokyo = builder.build();
        IryohokenKanyuJokyoManager manager = new IryohokenKanyuJokyoManager();
        manager.save介護保険医療保険加入状況(newIryohokenKanyuJokyo);

    }

    private void set介護認定申請基本情報(NinteiShinseiTorokuUketsukeBusiness result) {

        KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        介護認定申請Div.initialize();
        介護認定申請Div.setRadShinseishoKubun(result.getEntity().get申請書区分());
        介護認定申請Div.setTxtShinseiJokyo(result.getEntity().get申請状況());
        if (result.getEntity().get申請日() != null) {
            介護認定申請Div.setTxtShinseiYMD(new RDate(result.getEntity().get申請日().toString()));
        }
        if (result.getEntity().get申請種別() != null) {
            介護認定申請Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(result.getEntity().get申請種別().getColumnValue()));
        }
        if (result.getEntity().get認定申請区分コード_申請時() != null) {
            介護認定申請Div.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(result.getEntity().get認定申請区分コード_申請時().getColumnValue()));
        }
        if (result.getEntity().get認定申請区分コード_法令() != null) {
            介護認定申請Div.setShinseiKubunHorei(
                    NinteiShinseiHoreiCode.toValue(result.getEntity().get認定申請区分コード_法令().getColumnValue()));
        }
        介護認定申請Div.setShisho(
                new ShishoCode(result.getEntity().get支所コード()));

        List<RString> dataSource = new ArrayList<>();
        if (result.getEntity().is旧措置者フラグ()) {
            dataSource.add(SELECT_KEY0);
        }
        介護認定申請Div.setKyuSochisha(dataSource);

        if (result.getEntity().get被保険者区分コード() != null) {
            介護認定申請Div.setHihokenshaKubun(
                    HihokenshaKubunCode.toValue(result.getEntity().get被保険者区分コード()));
        }

        List<RString> dataSource1 = new ArrayList<>();
        if (result.getEntity().is資格取得前申請フラグ()) {
            dataSource1.add(SELECT_KEY0);
        }
        介護認定申請Div.setChkShikakuShutokuMae(dataSource1);

        if (result.getEntity().get二号特定疾病コード() != null) {
            介護認定申請Div.setTokuteiShippei(
                    TokuteiShippei.toValue(result.getEntity().get二号特定疾病コード().getColumnValue()));
        }
        介護認定申請Div.setServiceSakujoTeikeibun(result.getEntity().get申請サービス削除の理由());
        介護認定申請Div.setNinteiShinseRiyuTeikeibun(result.getEntity().get認定申請理由());
    }

    private void set認定申請届出者(NinteiShinseiTorokuUketsukeBusiness result) {

        INinteiShinseiTodokedeshaDiv iNinteiShinseiTodokedeshaDiv
                = div.getCcdShinseiTodokedesha();

        List<RString> 申請届出代行区分List = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            申請届出代行区分List.add(code.getCode());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlTodokledeDaikoKubun().setDataSource(setDataSource(申請届出代行区分List, true));
        if (result.getEntity().get申請届出代行区分コード() != null) {
            iNinteiShinseiTodokedeshaDiv.getDdlTodokledeDaikoKubun().setSelectedKey(result.getEntity().get申請届出代行区分コード().getColumnValue());
        }
        if (result.getEntity().get事業者番号() != null) {
            TextBox 事業者番号 = new TextBox();
            事業者番号.setValue(result.getEntity().get事業者番号().getColumnValue());
            iNinteiShinseiTodokedeshaDiv.setTxtJigyoshaCode(事業者番号);
        }

        List<RString> shinseiKankeishaCodeList = new ArrayList<>();
        for (ShinseishaKankeiCode code : ShinseishaKankeiCode.values()) {
            shinseiKankeishaCodeList.add(code.getコード());
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
                keyValue.setValue(new RString(ShinseishaKankeiCode.toValue(code).name()));
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
