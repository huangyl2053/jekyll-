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
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseishaKankeiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4150RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4150RenrakusakiJohoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosajokyo.NinteiChosaJokyoDataPass;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiBusinessCollection;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4101NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4102NinteiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4120ShinseitodokedeJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4121ShinseiRirekiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4123NinteiKeikakuJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.DbT4150RenrakusakiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.IryohokenKanyuJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.JukyushaDaichoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShisetsuNyutaishoManager;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.IconName;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 要介護認定申請受付画面のHandlerクラスです。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeHandler {
    private final NinteiShinseiTorokuUketsukeDiv div;
    private ShinseishoKanriNo shinseishoKanriNo;
    private final RString 表示パターン_新規 = new RString("0");
    private final RString 表示パターン_申請中 = new RString("1");
    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");
    private static final RString ZERO_17 = new RString("00000000000000000");
    private static final RString ZERO_3 = new RString("000");
    private static final RString ZERO_4 = new RString("0000");
    private static final RString RSTRING_0001 = new RString("0001");
    private static final RString 申請状況区分_仮データ = new RString("9");
    private static final int INT_4 = 4;
    private static final int 採番番号桁数 = 5;
    private static final int INT_60 = 60;
    private static RString nowState;
    private static boolean jukyudaichoDataUmu;
    private static boolean shinseiDataUmu;
    private static boolean kubunHenkouShinseiDataUmu;
    private static boolean serviceHenkouShinseiDataUmu;

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定申請受付作成のコントロールdiv
     */
    public NinteiShinseiTorokuUketsukeHandler(NinteiShinseiTorokuUketsukeDiv div) {
        this.div = div;
    }

    /**
     * 事前情報をセットします。（受給台帳有無・申請データ有無）
     * @param 被保険者番号 
     */
    public void set事前情報(HihokenshaNo 被保険者番号) {
        nowState = ResponseHolder.getState();
        if (修正存在チェック(被保険者番号)) {
            shinseiDataUmu = true;
        } else {
            shinseiDataUmu = false;
        }
        if (DBD5120001StateName.申請追加.getName().equals(nowState) 
                || DBD5120001StateName.区分変更追加.getName().equals(nowState) 
                || DBD5120001StateName.サービス変更追加.getName().equals(nowState)) {
            init画面状態();
        }
    }

    private boolean 修正存在チェック(HihokenshaNo 被保険者番号) {
        div.setHdnShinseishoKanriNo(null);
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> resultList = manager.get受給者台帳情報(被保険者番号);
        jukyudaichoDataUmu = false;
        kubunHenkouShinseiDataUmu = false;
        serviceHenkouShinseiDataUmu = false;
        boolean 存在フラグ = false;
        for (JukyushaDaicho jukyushaDaicho : resultList) {
            jukyudaichoDataUmu = true;
            if (ZERO_4.equals(jukyushaDaicho.get履歴番号())) {
                div.setHdnShinseishoKanriNo(jukyushaDaicho.get申請書管理番号() != null ? jukyushaDaicho.get申請書管理番号().getColumnValue() : null);
                存在フラグ = true;
                if (jukyushaDaicho.get受給申請事由().toString().equals(JukyuShinseiJiyu.要介護度変更申請.getコード().toString())) {
                    kubunHenkouShinseiDataUmu = true;
                } else if (jukyushaDaicho.get受給申請事由().toString().equals(JukyuShinseiJiyu.指定サービス種類変更申請.getコード().toString())) {
                    serviceHenkouShinseiDataUmu = true;
                }
            }
        }
        return 存在フラグ;
    }

    /**
     * 画面初期化処理です。
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     */
    public void onLoad(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        RString 表示パターン;
        if (shinseiDataUmu) {
            表示パターン = 表示パターン_申請中;
        } else {
            表示パターン = 表示パターン_新規;
        }
        NinteiShinseiTorokuUketsukeManager manager = NinteiShinseiTorokuUketsukeManager.createInstance();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        NinteiShinseiTorokuUketsukeParameter param;
        NinteiShinseiTorokuUketsukeBusiness result;
        if (表示パターン_新規.equals(表示パターン)) {
            param = NinteiShinseiTorokuUketsukeParameter.createParam(
                    被保険者番号, 識別コード, null, 表示パターン, FlexibleDate.getNowDate(),
                    new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
            result = manager.get初期化情報(param);
        } else {
            param = NinteiShinseiTorokuUketsukeParameter.createParam(
                    被保険者番号, 識別コード, new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()), 表示パターン, FlexibleDate.getNowDate(),
                    new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
            result = manager.get初期化情報_申請区分変更サービス変更修正(param);
        }
        loadValidationCheck(result);
        this.edit状態();
        div.getCcdKaigoAtenaInfo().initialize(識別コード);
        RString 市町村コード = null;
        if (!RString.isNullOrEmpty(被保険者番号.getColumnValue())) {
            if (result != null && result.getEntity().getT1001市町村コード() != null && 表示パターン_新規.equals(表示パターン)) {
                市町村コード = result.getEntity().getT1001市町村コード().getColumnValue();
            } else if (result != null && result.getEntity().getT4001市町村コード() != null && 表示パターン_申請中.equals(表示パターン)) {
                市町村コード = result.getEntity().getT4001市町村コード().getColumnValue();
            } else {
                HihokenshaDaichoManager hihokenshaDaichoManager = HihokenshaDaichoManager.createInstance();
                HihokenshaDaicho hihokenshaDaicho = hihokenshaDaichoManager.find被保険者台帳(被保険者番号, FlexibleDate.getNowDate());
                市町村コード = hihokenshaDaicho.get市町村コード().getColumnValue();
            }
            div.getCcdKaigoNinteiShikakuInfo().initialize(市町村コード, 被保険者番号.getColumnValue());
        }
        initControls();
        div.setHdnShikibetsuCode(識別コード != null ? 識別コード.getColumnValue() : null);
        div.setHdnHihokenshaNo(被保険者番号 != null ? 被保険者番号.getColumnValue() : null);
        if (result != null) {
            if (表示パターン_新規.equals(表示パターン)) {
                this.set介護認定申請基本情報_新規(result);
                this.set主治医医療機関_主治医入力(result);
                this.set前回認定結果_新規(result.getEntity().get申請書管理番号());
            } else {
                this.set介護認定申請基本情報(result);
                this.set認定申請届出者(result);
                this.set主治医医療機関_主治医入力(result);
                this.set調査委託先_調査員入力(result);
                this.set認定情報(result);
                this.set前回認定結果(result);
                this.set申請その他情報(result);
                this.set延期タブ表示用の情報(result);
            }
            div.setHdnRirekiNo(result.getEntity().get履歴番号());
            div.setHdnEdaban(result.getEntity().get枝番());
            div.setHdnShichosonRenrakuJiko(result.getEntity().get市町村連絡事項());
            if (表示パターン_申請中.equals(表示パターン)) {
                div.setHdnJukyuShinseiJiyu(result.getEntity().get受給申請事由().getColumnValue());
                set各ダイアログ記入状況();
            } else {
                div.setHdnShinseishoKanriNo(result.getEntity().get申請書管理番号().getColumnValue());
                KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                        = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
                RString jukyuShinseiJiyu = get受給申請事由();
                if (jukyuShinseiJiyu != null) {
                    介護認定申請Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(jukyuShinseiJiyu));
                }
            }
        } else {
            KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                    = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
            介護認定申請Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(JukyuShinseiJiyu.初回申請.getコード()));
            介護認定申請Div.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(NinteiShinseiShinseijiKubunCode.新規申請.getコード()));
            div.setHdnShichosonRenrakuJiko(RString.EMPTY);
            
        }
        ShinseishoKanriNo zenkaiShinseishoKanriNo = this.get前回申請書管理番号(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        List<DbT4150RenrakusakiJoho> renrakusakiJohoDbT4150List = this.get介護連絡先情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        List<DbT4150RenrakusakiJoho> zenkaiRenrakusakiJohoDbT4150List = new ArrayList<>();
        if (zenkaiShinseishoKanriNo != null) {
            zenkaiRenrakusakiJohoDbT4150List = this.get介護連絡先情報(zenkaiShinseishoKanriNo);
        }
        List<RenrakusakiJoho> renrakusakiJohoDbT5150List = this.convertToDbT5150RenrakusakiJoho(renrakusakiJohoDbT4150List);
        List<RenrakusakiJoho> zenkaiRenrakusakiJohoDbT5150List = this.convertToDbT5150RenrakusakiJoho(zenkaiRenrakusakiJohoDbT4150List);
        NinteiShinseiBusinessCollection data = new NinteiShinseiBusinessCollection();
        data.setDbdBusiness(renrakusakiJohoDbT5150List);
        div.setHdnRenrakusakiJoho(DataPassingConverter.serialize(data));
        NinteiShinseiBusinessCollection zenkaiData = new NinteiShinseiBusinessCollection();
        zenkaiData.setDbdBusiness(zenkaiRenrakusakiJohoDbT5150List);
        div.setHdnZenkaiRenrakusakiJoho(DataPassingConverter.serialize(zenkaiData));
        List<ShisetsuNyutaisho> shisetsuNyutaishoList = this.get施設入退所情報(識別コード);
        //div.setHdnNyutaishoJoho(DataPassingConverter.serialize(shisetsuNyutaishoList));
        div.setHdnRenrakusakiReadOnly(new RString("0"));
        div.setHdnShichosonCode(市町村コード);
    }
    
    private void loadValidationCheck(NinteiShinseiTorokuUketsukeBusiness result) {
        if (DBD5120001StateName.申請追加.getName().equals(nowState)) {
        } else if (DBD5120001StateName.申請修正.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.初回申請.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.申請_法施行前.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.再申請_有効期限内.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.再申請_有効期限外.getコード())
                    && !(result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.要介護度変更申請.getコード()) && result.getEntity().is要支援者認定申請区分())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.申請取下.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.初回申請.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.申請_法施行前.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.再申請_有効期限内.getコード()) 
                    && !result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.再申請_有効期限外.getコード())
                    && !(result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.要介護度変更申請.getコード()) && result.getEntity().is要支援者認定申請区分())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.区分変更追加.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.区分変更修正.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.要介護度変更申請.getコード())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.区分変更取下.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.要介護度変更申請.getコード())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.サービス変更修正.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.指定サービス種類変更申請.getコード())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.サービス変更取下.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
            if (!result.getEntity().get受給申請事由().value().equals(JukyuShinseiJiyu.指定サービス種類変更申請.getコード())) {
                kizonShinseiValidationMessage();
            }
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.特殊追加.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.特殊修正.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.特殊削除.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.削除回復.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.職権記載.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        } else if (DBD5120001StateName.職権全喪失.getName().equals(nowState)) {
            if (!jukyudaichoDataUmu) {
                jukyudaichoValidationMessage();
            }
        }
    }
    
    private void jukyudaichoValidationMessage() {
        if (!jukyudaichoDataUmu) {
            Message message;
            message = UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace("被保険者情報");
            throw new ApplicationException(message);
        }
    }
    
    private void kizonShinseiValidationMessage() {
        Message message;
        message = UrErrorMessages.既に存在.getMessage().replace("申請中のデータ");
        throw new ApplicationException(message);
    }

    private void set各ダイアログ記入状況() {
        if (get医療保険状況(new ShikibetsuCode(div.getHdnShikibetsuCode())) != null) {
            div.getBtnIryohokenGuide().setIconNameEnum(IconName.Complete);
        }
        if (get介護連絡先情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo())) != null 
                && !get介護連絡先情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo())).isEmpty()) {
            div.getBtnRenrakusaki().setIconNameEnum(IconName.Complete);
        }
        if (get施設入退所情報(new ShikibetsuCode(div.getHdnShikibetsuCode())) != null 
                && !get施設入退所情報(new ShikibetsuCode(div.getHdnShikibetsuCode())).isEmpty()) {
            div.getBtnNyuinAndShisetsuNyusho().setIconNameEnum(IconName.Complete);
        }
        // TODO 調査状況ダイアログの記入チェックを実装しなければならない。
        // TODO 現状、DbT5590関連のDBアクセス用ファイル群はDbEに格納作成されている。こちらで使用するには、DbZに移す必要がある。
//        if (true) {
//            div.getBtnChosaJokyo().setIconNameEnum(IconName.Complete);
//        }
        if (!div.getHdnShichosonRenrakuJiko().isNull() && !div.getHdnShichosonRenrakuJiko().isEmpty()) {
            div.getBtnShichosonRenrakuJiko().setIconNameEnum(IconName.Complete);
        }
    }
    
    private IryohokenKanyuJokyo get医療保険状況(ShikibetsuCode 識別コード) {
        IryohokenKanyuJokyoManager manager = new IryohokenKanyuJokyoManager();
        IryohokenKanyuJokyo iryohokenKanyuJokyo = manager.get最新介護保険医療保険加入状況論理非削除By識別コード(識別コード);
        return iryohokenKanyuJokyo;
    }
    
    private ShinseishoKanriNo get前回申請書管理番号(ShinseishoKanriNo 申請書管理番号) {
        DbT4121ShinseiRirekiJohoManager manager = new DbT4121ShinseiRirekiJohoManager();
        DbT4121ShinseiRirekiJoho shinseiRirekiJoho = manager.get申請履歴情報ByKey(申請書管理番号);
        if (shinseiRirekiJoho != null && shinseiRirekiJoho.get前回申請管理番号() != null && shinseiRirekiJoho.get前回申請管理番号().isEmpty()) {
            return shinseiRirekiJoho.get前回申請管理番号();
        } else {
            return null;
        }
    } 
    
    private List<DbT4150RenrakusakiJoho> get介護連絡先情報(ShinseishoKanriNo 申請書管理番号) {
        DbT4150RenrakusakiJohoManager manager = new DbT4150RenrakusakiJohoManager();
        List<DbT4150RenrakusakiJoho> renrakusakiDbT4150List = manager.get連絡先情報(申請書管理番号);
        return renrakusakiDbT4150List;
    }
    
    private List<RenrakusakiJoho> convertToDbT5150RenrakusakiJoho(List<DbT4150RenrakusakiJoho> renrakusakiDbT4150List) {
        List<RenrakusakiJoho> renrakusakiDbT5150List = new ArrayList<>();
        for (DbT4150RenrakusakiJoho renrakusakiDbT4150Joho : renrakusakiDbT4150List) {
            DbT5150RenrakusakiJohoEntity renrakusakiJohoEntity = new DbT5150RenrakusakiJohoEntity();
            renrakusakiJohoEntity.setInsertDantaiCd(renrakusakiDbT4150Joho.toEntity().getInsertDantaiCd());
            renrakusakiJohoEntity.setIsDeleted(renrakusakiDbT4150Joho.toEntity().getIsDeleted());
            renrakusakiJohoEntity.setUpdateCount(renrakusakiDbT4150Joho.toEntity().getUpdateCount());
            renrakusakiJohoEntity.setShinseishoKanriNo(renrakusakiDbT4150Joho.toEntity().getShinseishoKanriNo());
            renrakusakiJohoEntity.setRenban(renrakusakiDbT4150Joho.toEntity().getRenban());
            renrakusakiJohoEntity.setRenrakusakiKubunNo(renrakusakiDbT4150Joho.toEntity().getRenrakusakiKubunNo());
            renrakusakiJohoEntity.setShishoCode(renrakusakiDbT4150Joho.toEntity().getShishoCode());
            renrakusakiJohoEntity.setRenrakusakiShimei(renrakusakiDbT4150Joho.toEntity().getRenrakusakiShimei());
            renrakusakiJohoEntity.setRenrakusakiKanaSimei(renrakusakiDbT4150Joho.toEntity().getRenrakusakiKanaSimei());
            renrakusakiJohoEntity.setRenrakusakiTuzukigara(renrakusakiDbT4150Joho.toEntity().getRenrakusakiTuzukigara());
            renrakusakiJohoEntity.setRenrakusakiYubinNo(renrakusakiDbT4150Joho.toEntity().getRenrakusakiYubinNo());
            renrakusakiJohoEntity.setRenrakusakiJusho(renrakusakiDbT4150Joho.toEntity().getRenrakusakiJusho());
            renrakusakiJohoEntity.setRenrakusakiTelNo(renrakusakiDbT4150Joho.toEntity().getRenrakusakiTelNo());
            renrakusakiJohoEntity.setRenrakusakiKeitaiTelNo(renrakusakiDbT4150Joho.toEntity().getRenrakusakiKeitaiTelNo());
            renrakusakiJohoEntity.setPriority(renrakusakiDbT4150Joho.toEntity().getPriority());
            renrakusakiJohoEntity.setState(renrakusakiDbT4150Joho.toEntity().getState());
            RenrakusakiJoho renrakusakiDbT5150Joho = new RenrakusakiJoho(renrakusakiJohoEntity);
            renrakusakiDbT5150List.add(renrakusakiDbT5150Joho);
        }
        return renrakusakiDbT5150List;
    }
    
    private List<DbT4150RenrakusakiJoho> convertToDbT4150RenrakusakiJoho(List<RenrakusakiJoho> renrakusakiDbT5150List) {
        List<DbT4150RenrakusakiJoho> renrakusakiDbT4150List = new ArrayList<>();
        for (RenrakusakiJoho renrakusakiDbT5150Joho : renrakusakiDbT5150List) {
            DbT4150RenrakusakiJohoEntity renrakusakiJohoEntity = new DbT4150RenrakusakiJohoEntity();
            renrakusakiJohoEntity.setInsertDantaiCd(renrakusakiDbT5150Joho.toEntity().getInsertDantaiCd());
            renrakusakiJohoEntity.setIsDeleted(renrakusakiDbT5150Joho.toEntity().getIsDeleted());
            renrakusakiJohoEntity.setUpdateCount(renrakusakiDbT5150Joho.toEntity().getUpdateCount());
            renrakusakiJohoEntity.setShinseishoKanriNo(renrakusakiDbT5150Joho.toEntity().getShinseishoKanriNo());
            renrakusakiJohoEntity.setRenban(renrakusakiDbT5150Joho.toEntity().getRenban());
            renrakusakiJohoEntity.setRenrakusakiKubunNo(renrakusakiDbT5150Joho.toEntity().getRenrakusakiKubunNo());
            renrakusakiJohoEntity.setShishoCode(renrakusakiDbT5150Joho.toEntity().getShishoCode());
            renrakusakiJohoEntity.setRenrakusakiShimei(renrakusakiDbT5150Joho.toEntity().getRenrakusakiShimei());
            renrakusakiJohoEntity.setRenrakusakiKanaSimei(renrakusakiDbT5150Joho.toEntity().getRenrakusakiKanaSimei());
            renrakusakiJohoEntity.setRenrakusakiTuzukigara(renrakusakiDbT5150Joho.toEntity().getRenrakusakiTuzukigara());
            renrakusakiJohoEntity.setRenrakusakiYubinNo(renrakusakiDbT5150Joho.toEntity().getRenrakusakiYubinNo());
            renrakusakiJohoEntity.setRenrakusakiJusho(renrakusakiDbT5150Joho.toEntity().getRenrakusakiJusho());
            renrakusakiJohoEntity.setRenrakusakiTelNo(renrakusakiDbT5150Joho.toEntity().getRenrakusakiTelNo());
            renrakusakiJohoEntity.setRenrakusakiKeitaiTelNo(renrakusakiDbT5150Joho.toEntity().getRenrakusakiKeitaiTelNo());
            renrakusakiJohoEntity.setPriority(renrakusakiDbT5150Joho.toEntity().getPriority());
            renrakusakiJohoEntity.setState(renrakusakiDbT5150Joho.toEntity().getState());
            DbT4150RenrakusakiJoho renrakusakiDbT4150Joho = new DbT4150RenrakusakiJoho(renrakusakiJohoEntity);
            renrakusakiDbT4150List.add(renrakusakiDbT4150Joho);
        }
        return renrakusakiDbT4150List;
    }
    
    private List<ShisetsuNyutaisho> get施設入退所情報(ShikibetsuCode 識別コード) {
        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
        List<ShisetsuNyutaisho> shisetsuNyutaishoList = manager.get介護保険施設入退所(識別コード);
        return shisetsuNyutaishoList;
    }
    
    // TODO 調査状況ダイアログの記入チェックを実装しなければならない。
    // TODO 現状、DbT5590関連のDBアクセス用ファイル群はDbEに格納作成されている。こちらで使用するには、DbZに移す必要がある。
//    private List<ShisetsuNyutaisho> get除外審査員(ShinseishoKanriNo 申請書管理番号) {
//        ShinsakaiIinJogaiJohoManager manager = new ShinsakaiIinJogaiJohoManager();
//        List<ShinsakaiIinJogaiJoho> shisakaiIinJogaiJohoList = manager.get審査会委員除外情報By申請書管理番号(申請書管理番号);
//        return shisakaiIinJogaiJohoList;
//    }
    
    private void init画面状態() {
        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState()) && shinseiDataUmu) {
            init画面状態for申請();
            nowState = DBD5120001StateName.申請修正.getName();
        } else if (DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState()) && kubunHenkouShinseiDataUmu) {
            init画面状態for区分変更();
            nowState = DBD5120001StateName.区分変更修正.getName();
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState()) && serviceHenkouShinseiDataUmu) {
            init画面状態forサービス変更();
            nowState = DBD5120001StateName.サービス変更修正.getName();
        }
    }
    
    private void init画面状態for申請() {
        div.setVisible(true);
        div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
        div.getChosainAndChosainInput().setIsOpen(false);
        div.getCcdShujiiIryokikanAndShujiiInput().setVisible(true);
        div.getCcdChosaItakusakiAndChosainInput().setVisible(true);
        div.getCcdKaigoNinteiShinseiKihon().setVisible(true);
        div.getCcdShinseiTodokedesha().setVisible(true);
        div.getCcdNinteiInput().setVisible(true);
        div.getCcdZenkaiNinteiKekkaJoho().setVisible(true);
        div.getCcdShinseiSonotaJohoInput().setVisible(true);
        div.getCcdKaigoNinteiShikakuInfo().setVisible(true);
        div.getCcdKaigoNinteiAtenaInfo().setVisible(false);
        div.getCcdKaigoKanryoMessage().setVisible(false);
        div.getCcdKaigoAtenaInfo().setVisible(true);
    }
    
    private void init画面状態for区分変更() {
        div.setVisible(true);
        div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
        div.getChosainAndChosainInput().setIsOpen(false);
        div.getCcdShujiiIryokikanAndShujiiInput().setVisible(true);
        div.getCcdChosaItakusakiAndChosainInput().setVisible(true);
        div.getCcdKaigoNinteiShinseiKihon().setVisible(true);
        div.getCcdShinseiTodokedesha().setVisible(true);
        div.getCcdNinteiInput().setVisible(true);
        div.getCcdZenkaiNinteiKekkaJoho().setVisible(true);
        div.getCcdShinseiSonotaJohoInput().setVisible(true);
        div.getCcdKaigoNinteiShikakuInfo().setVisible(true);
        div.getCcdKaigoNinteiAtenaInfo().setVisible(false);
        div.getCcdKaigoKanryoMessage().setVisible(false);
        div.getCcdKaigoAtenaInfo().setVisible(true);
    }
    
    private void init画面状態forサービス変更() {
        div.setVisible(true);
        div.getShujiiAndShujiiIryoKikan().setIsOpen(false);
        div.getChosainAndChosainInput().setIsOpen(false);
        div.getCcdShujiiIryokikanAndShujiiInput().setVisible(true);
        div.getCcdChosaItakusakiAndChosainInput().setVisible(true);
        div.getCcdKaigoNinteiShinseiKihon().setVisible(true);
        div.getCcdShinseiTodokedesha().setVisible(true);
        div.getCcdNinteiInput().setVisible(true);
        div.getCcdZenkaiNinteiKekkaJoho().setVisible(true);
        div.getCcdShinseiSonotaJohoInput().setVisible(true);
        div.getCcdKaigoNinteiShikakuInfo().setVisible(true);
        div.getCcdKaigoNinteiAtenaInfo().setVisible(false);
        div.getCcdKaigoKanryoMessage().setVisible(false);
        div.getCcdKaigoAtenaInfo().setVisible(true);
    }

    private void initControls() {
        KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        介護認定申請Div.initialize();

        INinteiShinseiTodokedeshaDiv iNinteiShinseiTodokedeshaDiv
                = div.getCcdShinseiTodokedesha();
        List<RString> 申請届出代行区分List = new ArrayList<>();
        for (ShinseiTodokedeDaikoKubunCode code : ShinseiTodokedeDaikoKubunCode.values()) {
            申請届出代行区分List.add(code.getCode());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlTodokledeDaikoKubun().setDataSource(setDataSource(申請届出代行区分List, true));
        List<RString> shinseiKankeishaCodeList = new ArrayList<>();
        for (ShinseishaKankeiCode code : ShinseishaKankeiCode.values()) {
            shinseiKankeishaCodeList.add(code.getコード());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlShinseiKankeisha().setDataSource(setDataSource(shinseiKankeishaCodeList, false));
        if (new RString("key0").equals(div.getCcdShinseiTodokedesha().getRadKannaiKangai().getSelectedKey())) {
            div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput().setDisplayNoneMode(ZenkokuJushoInputDiv.DisplayNoneSetMode.使用しない);
            div.getCcdShinseiTodokedesha().getCcdChoikiInput().setDisplayNoneMode(ChoikiInputDiv.DisplayNoneSetMode.使用する);
            div.getCcdShinseiTodokedesha().getTxtYubinNo().setDisplayNone(false);
        } else {
            div.getCcdShinseiTodokedesha().getCcdZenkokuJushoInput().setDisplayNoneMode(ZenkokuJushoInputDiv.DisplayNoneSetMode.使用する);
            div.getCcdShinseiTodokedesha().getCcdChoikiInput().setDisplayNoneMode(ChoikiInputDiv.DisplayNoneSetMode.使用しない);
            div.getCcdShinseiTodokedesha().getTxtYubinNo().setDisplayNone(true);
        }
    }
    
    public boolean getShinseiDataUmu() {
        return shinseiDataUmu;
    }
    
    public boolean getjukyudaichoDataUmu() {
        return jukyudaichoDataUmu;
    }
    
    public RString getNowState() {
        return nowState;
    }

    /**
     * 調査状況ボタン用のデータを準備する。
     *
     */
    public void onBeforeOpenDialog_btnChosaJokyo() {

        NinteiShinseiTorokuUketsukeManager manager = NinteiShinseiTorokuUketsukeManager.createInstance();
        List<NinteiChosaJokyoDataPass> result = manager.get履歴情報(new HihokenshaNo(div.getHdnHihokenshaNo()));

        if (result != null && !result.isEmpty()) {
            div.setHdn今回履歴情報(DataPassingConverter.serialize(result.get(0)));
        }
        if (result != null && result.size() > 1) {
            div.setHdn前回履歴情報(DataPassingConverter.serialize(result.get(1)));
        }
        div.setHdn表示判定キー(new RString("1"));
        div.setHdnSubGyomuCd(SubGyomuCode.DBD介護受給.getColumnValue());
    }

    /**
     * 入院/施設入所OkCloseの処理を行う。
     *
     * @param models Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho>
     */
    public void onOkClose_ShisetsuNyutaisho(Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> models) {
        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
        int 最大履歴番号 = manager.get最大履歴番号(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        ShisetsuNyutaisho shisetsuNyutaisho = models.
                get(new ShisetsuNyutaishoIdentifier(new ShikibetsuCode(div.getHdnShikibetsuCode()), 最大履歴番号));
        div.setHdnNyutaishoJoho(DataPassingConverter.serialize(shisetsuNyutaisho));
    }

    /**
     * 状態編集処理です。
     *
     */
    private void edit状態() {
        if (DBD5120001StateName.申請追加.getName().equals(nowState)) {
            this.edit状態_申請追加();
        } else if (DBD5120001StateName.申請修正.getName().equals(nowState)) {
            this.edit状態_申請修正();
        } else if (DBD5120001StateName.申請取下.getName().equals(nowState)) {
            this.edit状態_申請取下();
        } else if (DBD5120001StateName.区分変更追加.getName().equals(nowState)) {
            this.edit状態_区分変更追加();
        } else if (DBD5120001StateName.区分変更修正.getName().equals(nowState)) {
            this.edit状態_区分変更修正();
        } else if (DBD5120001StateName.区分変更取下.getName().equals(nowState)) {
            this.edit状態_区分変更取消();
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(nowState)) {
            this.edit状態_サービス変更追加();
        } else if (DBD5120001StateName.サービス変更修正.getName().equals(nowState)) {
            this.edit状態_サービス変更修正();
        } else if (DBD5120001StateName.サービス変更取下.getName().equals(nowState)) {
            this.edit状態_サービス変更取消();
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(nowState)) {
            this.edit状態_受給者転入追加();
        } else if (DBD5120001StateName.特殊追加.getName().equals(nowState)) {
            this.edit状態_特殊追加();
        } else if (DBD5120001StateName.特殊修正.getName().equals(nowState)) {
            this.edit状態_特殊修正();
        } else if (DBD5120001StateName.特殊削除.getName().equals(nowState)) {
            this.edit状態_特殊削除();
        } else if (DBD5120001StateName.削除回復.getName().equals(nowState)) {
            this.edit状態_削除回復();
        } else if (DBD5120001StateName.職権記載.getName().equals(nowState)) {
            this.edit状態_職権記載();
        } else if (DBD5120001StateName.職権全喪失.getName().equals(nowState)) {
            this.edit状態_職権取消全喪失();
        }
    }

    /**
     * 保存する処理です。
     *
     */
    public void onClick_btnUpdate() {
        CountedItem countedItem = Saiban.get(
                SubGyomuCode.DBE認定支援, SaibanHanyokeyName.市町村コード_西暦_月.get名称(), FlexibleDate.getNowDate().getNendo());
        RString rstring申請書管理番号 = div.getHdnShichosonCode().concat(
                FlexibleDate.getNowDate().getYearMonth().toString().concat(
                        countedItem.nextString().padZeroToLeft(採番番号桁数).toString()));
        shinseishoKanriNo = new ShinseishoKanriNo(rstring申請書管理番号);
        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_申請();
            insert要介護認定申請情報_申請();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert要介護認定計画情報();
            //insert介護保険施設入退所();
        } else if (DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            update受給者台帳_申請修正();
            update要介護認定申請情報_申請修正();
            update申請届出者();
            update介護連絡先();
            update要介護認定計画情報(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue());
            //update介護保険施設入退所();
        } else if (DBD5120001StateName.申請取下.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更取下.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更取下.getName().equals(ResponseHolder.getState())) {
            update受給者台帳_申請取下();
            update要介護認定申請情報_申請取下();
            update要介護認定計画情報_申請取下(new RDate(div.getTxtEnkiMikomiKikanTo().getValue().toString()));
        } else if (DBD5120001StateName.受給者転入追加.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_転入();
            insert要介護認定申請情報_転入();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            insert要介護認定計画情報();
            //insert介護保険施設入退所();
        } else if (DBD5120001StateName.職権記載.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.職権全喪失.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_職権();
            insert要介護認定申請情報_職権();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            //insert介護保険施設入退所();
        } else if (DBD5120001StateName.特殊追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.特殊修正.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.特殊削除.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.削除回復.getName().equals(ResponseHolder.getState())) {
            insert受給者台帳_特殊();
            insert要介護認定申請情報_特殊();
            insert申請届出者();
            insert介護連絡先();
            insert申請履歴情報();
            //insert介護保険施設入退所();
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setReadOnly(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().setRequired(false);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getBtnIryohokenGuide().setDisabled(false);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinAndShisetsuNyusho().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(false);
        div.getBtnTainoJokyo().setDisabled(false);
        div.getCcdKaigoNinteiShinseiKihon().setInputMode(
                new RString(KaigoNinteiShinseiKihonJohoInputDiv.InputType.ShokkenKisaiMode.toString()));
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlHihokenshaKubun().setDisplayNone(true);
        div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().setDisplayNone(true);
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
        div.getTabShinseishaJoho().setDisplayNone(true);
        div.getBtnIryohokenGuide().setDisplayNone(true);
        div.getBtnRenrakusaki().setDisplayNone(true);
        div.getBtnNyuinAndShisetsuNyusho().setDisplayNone(true);
        div.getBtnShichosonRenrakuJiko().setDisplayNone(true);
        div.getBtnChosaJokyo().setDisplayNone(true);
        div.getBtnTainoJokyo().setDisplayNone(true);
    }

    private RString get受給申請事由() {
        if (DBD5120001StateName.申請追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())) {
            return get受給申請事由for申請();
        } else if (DBD5120001StateName.区分変更追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.区分変更修正.getName().equals(ResponseHolder.getState())) {
            return get受給申請事由for区分変更();
        } else if (DBD5120001StateName.サービス変更追加.getName().equals(ResponseHolder.getState())
                || DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            return get受給申請事由for区分サービス変更();
        }
        return null;
    }

    private RString get受給申請事由for申請() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> resultList = manager.get受給者台帳(
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new ShikibetsuCode(div.getHdnShikibetsuCode()));
        if (resultList == null || resultList.isEmpty()) {
            return JukyuShinseiJiyu.初回申請.getコード();
        }
        boolean 存在フラグ = false;
        boolean 処理なしフラグ = false;
        RString 受給申請事由 = RString.EMPTY;
        for (JukyushaDaicho jukyushaDaicho : resultList) {
            if (ZERO_4.equals(jukyushaDaicho.get履歴番号())) {
                存在フラグ = true;
                受給申請事由 = jukyushaDaicho.get受給申請事由().getColumnValue();
                if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())) {
                    処理なしフラグ = true;
                }
            }
        }
        if (存在フラグ && !処理なしフラグ) {
            return 受給申請事由;
        } else if (存在フラグ && 処理なしフラグ) {
            return null;
        }
        JukyushaDaicho 最大履歴番号レコード = resultList.get(0);
        if (!YukoMukoKubun.有効.getコード().equals(最大履歴番号レコード.get有効無効区分().getColumnValue())
                && 最大履歴番号レコード.get受給申請年月日().isBefore(new FlexibleDate(new RString("20000401")))) {
            return JukyuShinseiJiyu.申請_法施行前.getコード();
        }
        if (!YukoMukoKubun.有効.getコード().equals(最大履歴番号レコード.get有効無効区分().getColumnValue())
                && new FlexibleDate(new RString("20000401")).isBeforeOrEquals(最大履歴番号レコード.get受給申請年月日())) {
            return JukyuShinseiJiyu.初回申請.getコード();
        }
        if (!(FlexibleDate.getNowDate().isBeforeOrEquals(最大履歴番号レコード.get認定有効期間終了年月日())
                && 最大履歴番号レコード.get認定有効期間開始年月日().isBeforeOrEquals(FlexibleDate.getNowDate()))) {
            return JukyuShinseiJiyu.再申請_有効期限外.getコード();
        }
        if (YokaigoJotaiKubun.要支援1.getコード().equals(最大履歴番号レコード.get要介護認定状態区分コード().getColumnValue())
                || YokaigoJotaiKubun.要支援2.getコード().equals(最大履歴番号レコード.get要介護認定状態区分コード().getColumnValue())) {
            return JukyuShinseiJiyu.要介護度変更申請.getコード();
        }
        if (FlexibleDate.getNowDate().isBeforeOrEquals(最大履歴番号レコード.get認定有効期間終了年月日())
                && 最大履歴番号レコード.get認定有効期間開始年月日().isBeforeOrEquals(FlexibleDate.getNowDate())) {
            return JukyuShinseiJiyu.再申請_有効期限内.getコード();
        } else {
            return null;
        }
    }

    private RString get受給申請事由for区分変更() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> resultList = manager.get受給者台帳(
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new ShikibetsuCode(div.getHdnShikibetsuCode()));
        boolean 存在フラグ = false;
        boolean 処理なしフラグ = false;
        RString 受給申請事由 = RString.EMPTY;
        for (JukyushaDaicho jukyushaDaicho : resultList) {
            if (ZERO_4.equals(jukyushaDaicho.get履歴番号())) {
                存在フラグ = true;
                受給申請事由 = jukyushaDaicho.get受給申請事由().getColumnValue();
                if (JukyuShinseiJiyu.初回申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.申請_法施行前.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())) {
                    処理なしフラグ = true;
                }
            }
        }
        if (存在フラグ && !処理なしフラグ) {
            return 受給申請事由;
        } else if (存在フラグ && 処理なしフラグ) {
            return null;
        }
        JukyushaDaicho 最大履歴番号レコード = resultList.get(0);
        if (!YukoMukoKubun.有効.getコード().equals(最大履歴番号レコード.get有効無効区分().getColumnValue())) {
            return null;
        }
        if (最大履歴番号レコード.get受給申請年月日().isBeforeOrEquals(最大履歴番号レコード.get認定有効期間終了年月日())
                && 最大履歴番号レコード.get認定有効期間終了年月日().minusDay(INT_60).isBeforeOrEquals(最大履歴番号レコード.get受給申請年月日())) {
            return JukyuShinseiJiyu.要介護度変更申請.getコード();
        } else {
            return null;
        }
    }

    private RString get受給申請事由for区分サービス変更() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        List<JukyushaDaicho> resultList = manager.get受給者台帳(
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new ShikibetsuCode(div.getHdnShikibetsuCode()));
        boolean 存在フラグ = false;
        boolean 処理なしフラグ = false;
        RString 受給申請事由 = RString.EMPTY;
        for (JukyushaDaicho jukyushaDaicho : resultList) {
            if (ZERO_4.equals(jukyushaDaicho.get履歴番号())) {
                存在フラグ = true;
                受給申請事由 = jukyushaDaicho.get受給申請事由().getColumnValue();
                if (JukyuShinseiJiyu.初回申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.申請_法施行前.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())
                        || JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(jukyushaDaicho.get受給申請事由().getColumnValue())) {
                    処理なしフラグ = true;
                }
            }
        }
        if (存在フラグ && !処理なしフラグ) {
            return 受給申請事由;
        } else if (存在フラグ && 処理なしフラグ) {
            return null;
        }
        JukyushaDaicho 最大履歴番号レコード = resultList.get(0);
        if (YukoMukoKubun.有効.getコード().equals(最大履歴番号レコード.get有効無効区分().getColumnValue())
                && (指定サービス種類1_10判定(最大履歴番号レコード)
                || 指定サービス種類11_20判定(最大履歴番号レコード)
                || 指定サービス種類21_30判定(最大履歴番号レコード))) {
            return JukyuShinseiJiyu.指定サービス種類変更申請.getコード();
        } else {
            return null;
        }
    }

    private boolean 指定サービス種類1_10判定(JukyushaDaicho 最大履歴番号レコード) {
        return !最大履歴番号レコード.get指定サービス種類01().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類02().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類03().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類04().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類05().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類06().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類07().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類08().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類09().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類10().isEmpty();
    }

    private boolean 指定サービス種類11_20判定(JukyushaDaicho 最大履歴番号レコード) {
        return !最大履歴番号レコード.get指定サービス種類11().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類12().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類13().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類14().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類15().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類16().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類17().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類18().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類19().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類20().isEmpty();
    }

    private boolean 指定サービス種類21_30判定(JukyushaDaicho 最大履歴番号レコード) {
        return !最大履歴番号レコード.get指定サービス種類21().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類22().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類23().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類24().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類25().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類26().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類27().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類28().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類29().isEmpty()
                || !最大履歴番号レコード.get指定サービス種類30().isEmpty();
    }

    private void insert受給者台帳_申請() {
        RString 受給申請事由 = get受給申請事由();
        if (受給申請事由 == null) {
            return;
        }
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                new RString("0").padZeroToLeft(INT_4),
                new RString("00"),
                new Code(受給申請事由));
        delete受給者台帳仮データ();
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
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
        builder.set要支援者認定申請区分(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        manager.save受給者台帳(newJukyushaDaicho);
    }
    
    private void delete受給者台帳仮データ() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        RString 最大履歴番号 = manager.get最大履歴番号(LasdecCode.EMPTY, HihokenshaNo.EMPTY);
        List<JukyushaDaicho> jukyushaDaichoList = manager.get受給者台帳情報(new HihokenshaNo(div.getHdnHihokenshaNo()));
        for (JukyushaDaicho jukyushaDaicho : jukyushaDaichoList) {
            if (jukyushaDaicho.get履歴番号().equals(最大履歴番号) && jukyushaDaicho.get申請状況区分().equals(申請状況区分_仮データ)) {
                jukyushaDaicho = jukyushaDaicho.deleted();
                manager.save受給者台帳(jukyushaDaicho);
            }
        }
    }

    private void insert要介護認定申請情報_申請() {
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = new DbT4101NinteiShinseiJoho(shinseishoKanriNo);
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        Code koroshoIFShikibetsuCode = new Code("");
        for (KoroshoInterfaceShikibetsuCode koroshoInterfaceShikibetsuCode : KoroshoInterfaceShikibetsuCode.values()) {
            if (koroshoInterfaceShikibetsuCode.isValidOn(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().toDateString()))) {
                koroshoIFShikibetsuCode = new Code(koroshoInterfaceShikibetsuCode.getCode());
            }
        }
        builder.set厚労省IF識別コード(koroshoIFShikibetsuCode);
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode(ZERO_3));
        builder.set認定申請区分_法令_コード(Code.EMPTY);
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set取下区分コード(new Code("1"));
        // TODO 被保険者区分の区分けについて確認後再設定
        RString hihokenshaKubun;
        if (Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()) < 65) {
            hihokenshaKubun = HihokenshaKubunCode.第２号被保険者.getコード();
        } else {
            hihokenshaKubun = HihokenshaKubunCode.第１号被保険者.getコード();
        }
        builder.set被保険者区分コード(hihokenshaKubun);
        if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
            builder.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get生年月日().toFlexibleDate());
            builder.set年齢(Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()));
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().to個人().get性別() != null) {
                builder.set性別(new Code(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get性別().getCode()));
            }
            builder.set電話番号(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
        }
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoAtenaInfo().get氏名カナ()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        builder.set郵便番号(div.getCcdKaigoAtenaInfo().get郵便番号());
        builder.set住所(div.getCcdKaigoAtenaInfo().get住所());
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        builder.set申請サービス削除の理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().getValue());
        for (YokaigoJotaiKubun yokaigoJotaiKubun : YokaigoJotaiKubun.values()) {
            if (yokaigoJotaiKubun.get名称().equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue())) {
                builder.set前回要介護状態区分コード(new Code(yokaigoJotaiKubun.getCode()));
            }
        }
        builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        builder.set前回認定有効期間_開始(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        builder.set前回認定有効期間_終了(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        //TODO２号医療保険者名 ２号医療保険記号番号 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
//        builder.set2号医療保険者名(null);
//        builder.set2号医療保険記号番号(null);
        builder.set2号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        builder.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        if (!div.getHdnNyutaishoJoho().isNull() && !div.getHdnNyutaishoJoho().isEmpty()) {
            builder.set施設入所の有無(true);
        } else {
            builder.set施設入所の有無(false);
        }
//        builder.set入所施設コード(null);
        builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        builder.set処理状態区分(new Code("0"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        builder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert申請届出者() {
        DbT4120ShinseitodokedeJoho shinseitodokedeJoho = new DbT4120ShinseitodokedeJoho(shinseishoKanriNo);
        DbT4120ShinseitodokedeJohoBuilder builder = shinseitodokedeJoho.createBuilderForEdit();
        builder.set申請届出代行区分コード(new Code(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey()));
        builder.set申請届出者氏名(div.getCcdShinseiTodokedesha().get一覧内容().get氏名());
        builder.set申請届出者氏名カナ(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名());
        builder.set申請届出者続柄(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        if (!RString.EMPTY.equals(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者())) {
            builder.set申請届出代行事業者番号(new JigyoshaNo(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者()));
        }
        builder.set申請届出者電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        if (SELECT_KEY0.equals(div.getCcdShinseiTodokedesha().getRadKannaiKangai().getSelectedKey())) {
            builder.set申請届出者郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
            builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get町域入力住所コード());
        } else {
            builder.set申請届出者郵便番号(new YubinNo(div.getCcdShinseiTodokedesha().get一覧内容().get全国郵便番号()));
            builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所コード());
        }
        DbT4120ShinseitodokedeJoho newShinseitodokedeJoho = builder.build();
        DbT4120ShinseitodokedeJohoManager manager = new DbT4120ShinseitodokedeJohoManager();
        manager.save申請届出情報(newShinseitodokedeJoho);
    }

    private void insert介護連絡先() {
        NinteiShinseiBusinessCollection data = DataPassingConverter.deserialize(div.
                getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        List<RenrakusakiJoho> renrakusakiJohoDbT5150List = data.getDbdBusiness();
        List<DbT4150RenrakusakiJoho> renrakusakiJohoDbT4150List = this.convertToDbT4150RenrakusakiJoho(renrakusakiJohoDbT5150List);
        for (DbT4150RenrakusakiJoho renrakusakiJoho : renrakusakiJohoDbT4150List) {
            DbT4150RenrakusakiJohoBuilder builder = renrakusakiJoho.createBuilderForEdit();
            builder.set申請書管理番号(shinseishoKanriNo);
            DbT4150RenrakusakiJoho newRenrakusakiJoho = builder.build();
            DbT4150RenrakusakiJohoManager manager = new DbT4150RenrakusakiJohoManager();
            manager.save連絡先情報(newRenrakusakiJoho);
        }
    }

    private void insert申請履歴情報() {
        DbT4121ShinseiRirekiJoho shinseiRirekiJoho = new DbT4121ShinseiRirekiJoho(shinseishoKanriNo);
        DbT4121ShinseiRirekiJohoBuilder builder = shinseiRirekiJoho.createBuilderForEdit();
        if (!jukyudaichoDataUmu) {
            builder.set前回申請管理番号(new ShinseishoKanriNo(ZERO_17));
        } else {
            builder.set前回申請管理番号(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        }
        DbT4121ShinseiRirekiJoho newShinseiRirekiJoho = builder.build();
        DbT4121ShinseiRirekiJohoManager manager = new DbT4121ShinseiRirekiJohoManager();
        manager.save申請履歴情報(newShinseiRirekiJoho);
    }

//    private void insert介護保険施設入退所() {
//        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
//
//        int 最大履歴番号 = manager.get最大履歴番号(new ShikibetsuCode(div.getHdnShikibetsuCode()));
//        ShisetsuNyutaisho shisetsuNyutaisho = new ShisetsuNyutaisho(new ShikibetsuCode(div.getHdnShikibetsuCode()), 最大履歴番号 + 1);
//        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
//        ShisetsuNyutaisho hdnShisetsuNyutaisho = DataPassingConverter.deserialize(div.getHdnNyutaishoJoho(), ShisetsuNyutaisho.class);
//        if (hdnShisetsuNyutaisho == null) {
//            return;
//        }
//        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
//        builder.set台帳種別(hdnShisetsuNyutaisho.get台帳種別());
//        builder.set入所施設種類(hdnShisetsuNyutaisho.get入所施設種類());
//        builder.set入所施設コード(hdnShisetsuNyutaisho.get入所施設コード());
//        builder.set入所処理年月日(hdnShisetsuNyutaisho.get入所処理年月日());
//        builder.set入所年月日(hdnShisetsuNyutaisho.get入所年月日());
//        builder.set退所処理年月日(hdnShisetsuNyutaisho.get退所処理年月日());
//        builder.set退所年月日(hdnShisetsuNyutaisho.get退所年月日());
//        builder.set部屋記号番号(hdnShisetsuNyutaisho.get部屋記号番号());
//
//        ShisetsuNyutaisho newShisetsuNyutaisho = builder.build();
//        manager.save介護保険施設入退所(newShisetsuNyutaisho);
//
//    }
    
    private void insert要介護認定計画情報() {
        DbT4123NinteiKeikakuJoho ninteiKeikakuJoho = new DbT4123NinteiKeikakuJoho(shinseishoKanriNo);
        DbT4123NinteiKeikakuJohoBuilder builder = ninteiKeikakuJoho.createBuilderForEdit();
        RDate 申請日 = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue();
        FlexibleDate 申請日FlexibleDate = new FlexibleDate(申請日.toDateString());
        DbT4123NinteiKeikakuJohoManager manager = new DbT4123NinteiKeikakuJohoManager();
        int 認定調査依頼予定年月日 = rstringToInt(manager.get認定調査依頼予定年月日(申請日FlexibleDate));
        int 認定調査予定年月日 = rstringToInt(manager.get認定調査予定年月日(申請日FlexibleDate));
        int 主治医意見書作成依頼予定年月日 =rstringToInt(manager.get主治医意見書作成依頼予定年月日(申請日FlexibleDate));
        int 主治医意見書登録予定年月日 = rstringToInt(manager.get主治医意見書登録予定年月日(申請日FlexibleDate));
        int 要介護認定一次判定予定年月日 = rstringToInt(manager.get要介護認定一次判定予定年月日(申請日FlexibleDate));
        int 認定審査会割当予定年月日 = rstringToInt(manager.get認定審査会割当予定年月日(申請日FlexibleDate));
        int 認定審査会予定年月日 = rstringToInt(manager.get認定審査会予定年月日(申請日FlexibleDate));
        int センター送信予定年月日 = rstringToInt(manager.getセンター送信予定年月日(申請日FlexibleDate));
        
        builder.set認定調査依頼予定年月日(new FlexibleDate(申請日.plusDay(認定調査依頼予定年月日).toDateString()));
        builder.set認定調査予定年月日(new FlexibleDate(申請日.plusDay(認定調査予定年月日).toDateString()));
        builder.set主治医意見書作成依頼予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書作成依頼予定年月日).toDateString()));
        builder.set主治医意見書登録予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書登録予定年月日).toDateString()));
        builder.set要介護認定一次判定予定年月日(new FlexibleDate(申請日.plusDay(要介護認定一次判定予定年月日).toDateString()));
        
        builder.set認定審査会割当予定年月日(new FlexibleDate(申請日.plusDay(認定審査会割当予定年月日).toDateString()));
        builder.set認定審査会予定年月日(new FlexibleDate(申請日.plusDay(認定審査会予定年月日).toDateString()));
        builder.setセンター送信予定年月日(new FlexibleDate(申請日.plusDay(センター送信予定年月日).toDateString()));
        DbT4123NinteiKeikakuJoho newNinteiKeikakuJoho = builder.build();
        manager.save認定計画情報(newNinteiKeikakuJoho);
    }
    
    private int rstringToInt(RString 変換前) {
        int 変換後;
        Decimal 変換中 = new Decimal(変換前.toString());
        変換後 = 変換中.intValue();
        return 変換後;
    }
    
    private void insert受給者台帳_転入() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        RString 最大履歴番号 = manager.get最大履歴番号(new LasdecCode(div.getHdnShichosonCode()), new HihokenshaNo(div.getHdnHihokenshaNo()));
        if (最大履歴番号 == null) {
            最大履歴番号 = RSTRING_0001;
        } else {
            最大履歴番号 = new RString(Integer.parseInt(最大履歴番号.toString()) + 1);
        }
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                最大履歴番号,
                new RString("00"),
                new Code("7"));
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        builder.set申請書管理番号(shinseishoKanriNo);
        builder.set申請状況区分(new RString("0"));
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
        //TODO指定サービス種類 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("00"));
        builder.set有効無効区分(new Code("1"));
        builder.setデータ区分(new Code("21"));
        builder.set同一連番(RSTRING_0001);
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(false);
        builder.set資格取得前申請フラグ(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_転入() {
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = new DbT4101NinteiShinseiJoho(shinseishoKanriNo);
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        Code koroshoIFShikibetsuCode = new Code("");
        for (KoroshoInterfaceShikibetsuCode koroshoInterfaceShikibetsuCode : KoroshoInterfaceShikibetsuCode.values()) {
            if (koroshoInterfaceShikibetsuCode.isValidOn(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().toDateString()))) {
                koroshoIFShikibetsuCode = new Code(koroshoInterfaceShikibetsuCode.getCode());
            }
        }
        builder.set厚労省IF識別コード(koroshoIFShikibetsuCode);
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode(ZERO_3));
        builder.set認定申請区分_法令_コード(new Code("4"));
        builder.set認定申請区分_申請時_コード(new Code("5"));
        builder.set取下区分コード(new Code("1"));
        // TODO 被保険者区分の区分けについて確認後再設定
        RString hihokenshaKubun;
        if (Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()) < 65) {
            hihokenshaKubun = HihokenshaKubunCode.第２号被保険者.getコード();
        } else {
            hihokenshaKubun = HihokenshaKubunCode.第１号被保険者.getコード();
        }
        builder.set被保険者区分コード(hihokenshaKubun);
        if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
            builder.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get生年月日().toFlexibleDate());
            builder.set年齢(Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()));
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().to個人().get性別() != null) {
                builder.set性別(new Code(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get性別().getCode()));
            }
            builder.set電話番号(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
        }
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoAtenaInfo().get氏名カナ()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        builder.set郵便番号(div.getCcdKaigoAtenaInfo().get郵便番号());
        builder.set住所(div.getCcdKaigoAtenaInfo().get住所());
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
        //TODO２号医療保険者名 ２号医療保険記号番号 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
//        builder.set2号医療保険者名(null);
//        builder.set2号医療保険記号番号(null);
        builder.set2号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        builder.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード 市町村連絡事項 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        if (!div.getHdnNyutaishoJoho().isNull() && !div.getHdnNyutaishoJoho().isEmpty()) {
            builder.set施設入所の有無(true);
        } else {
            builder.set施設入所の有無(false);
        }
//        builder.set入所施設コード(null);
        builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        builder.set処理状態区分(new Code("0"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        builder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert受給者台帳_職権() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        RString 最大履歴番号 = manager.get最大履歴番号(new LasdecCode(div.getHdnShichosonCode()), new HihokenshaNo(div.getHdnHihokenshaNo()));
        if (最大履歴番号 == null) {
            最大履歴番号 = RSTRING_0001;
        } else {
            最大履歴番号 = new RString(Integer.parseInt(最大履歴番号.toString()) + 1);
        }
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                最大履歴番号,
                new RString("00"),
                new Code("7"));
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
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
        //TODO指定サービス種類 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("10"));
        builder.set有効無効区分(new Code("0"));
        builder.setデータ区分(new Code("24"));
        builder.set同一連番(最大履歴番号);
        builder.set異動理由(div.getCcdShinseiSonotaJohoInput().get理由());
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(false);
        builder.set資格取得前申請フラグ(false);
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_職権() {
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = new DbT4101NinteiShinseiJoho(shinseishoKanriNo);
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        Code koroshoIFShikibetsuCode = new Code("");
        for (KoroshoInterfaceShikibetsuCode koroshoInterfaceShikibetsuCode : KoroshoInterfaceShikibetsuCode.values()) {
            if (koroshoInterfaceShikibetsuCode.isValidOn(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().toDateString()))) {
                koroshoIFShikibetsuCode = new Code(koroshoInterfaceShikibetsuCode.getCode());
            }
        }
        builder.set厚労省IF識別コード(koroshoIFShikibetsuCode);
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode(ZERO_3));
        builder.set認定申請区分_法令_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunHorei().getSelectedKey()));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set取下区分コード(new Code("1"));
        // TODO 被保険者区分の区分けについて確認後再設定
        RString hihokenshaKubun;
        if (Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()) < 65) {
            hihokenshaKubun = HihokenshaKubunCode.第２号被保険者.getコード();
        } else {
            hihokenshaKubun = HihokenshaKubunCode.第１号被保険者.getコード();
        }
        builder.set被保険者区分コード(hihokenshaKubun);
        if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
            builder.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get生年月日().toFlexibleDate());
            builder.set年齢(Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()));
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().to個人().get性別() != null) {
                builder.set性別(new Code(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get性別().getCode()));
            }
            builder.set電話番号(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
        }
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoAtenaInfo().get氏名カナ()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        builder.set郵便番号(div.getCcdKaigoAtenaInfo().get郵便番号());
        builder.set住所(div.getCcdKaigoAtenaInfo().get住所());
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
        //TODO２号医療保険者名 ２号医療保険記号番号 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
//        builder.set2号医療保険者名(null);
//        builder.set2号医療保険記号番号(null);
        builder.set2号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        builder.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード  QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        if (!div.getHdnNyutaishoJoho().isNull() && !div.getHdnNyutaishoJoho().isEmpty()) {
            builder.set施設入所の有無(true);
        } else {
            builder.set施設入所の有無(false);
        }
//        builder.set入所施設コード(null);
        builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        builder.set処理状態区分(new Code("0"));
        builder.set延期通知発行回数(0);
        builder.set介護認定審査会優先振分区分コード(new Code("0"));
        builder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);
        
        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void insert受給者台帳_特殊() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        RString 最大履歴番号 = manager.get最大履歴番号(new LasdecCode(div.getHdnShichosonCode()), new HihokenshaNo(div.getHdnHihokenshaNo()));

        if (最大履歴番号 == null) {
            最大履歴番号 = RSTRING_0001;
        } else {
            最大履歴番号 = new RString(Integer.parseInt(最大履歴番号.toString()) + 1);
        }
        JukyushaDaicho jukyushaDaicho = new JukyushaDaicho(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                最大履歴番号,
                new RString("00"),
                new Code("7"));
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
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
        //TODO指定サービス種類 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        builder.set直近異動年月日(FlexibleDate.getNowDate());
        builder.set直近異動事由コード(new Code("01"));
        builder.set有効無効区分(new Code("0"));
        builder.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));
        builder.set同一連番(最大履歴番号);
        builder.set異動理由(div.getCcdShinseiSonotaJohoInput().get理由());
        builder.set申請書区分(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set要支援者認定申請区分(new RString("1").equals(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey()));
        builder.set旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().isAllSelected());
        builder.set論理削除フラグ(false);

        JukyushaDaicho newJukyushaDaicho = builder.build();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void insert要介護認定申請情報_特殊() {
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = new DbT4101NinteiShinseiJoho(shinseishoKanriNo);
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        Code koroshoIFShikibetsuCode = new Code("");
        for (KoroshoInterfaceShikibetsuCode koroshoInterfaceShikibetsuCode : KoroshoInterfaceShikibetsuCode.values()) {
            if (koroshoInterfaceShikibetsuCode.isValidOn(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().toDateString()))) {
                koroshoIFShikibetsuCode = new Code(koroshoInterfaceShikibetsuCode.getCode());
            }
        }
        builder.set厚労省IF識別コード(koroshoIFShikibetsuCode);
        builder.set証記載保険者番号(div.getCcdKaigoNinteiShikakuInfo().getHookenshaCode());
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set被保険者番号(div.getHdnHihokenshaNo());
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請枝番コード(new EdabanCode(ZERO_3));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        builder.set取下区分コード(new Code("1"));
        // TODO 被保険者区分の区分けについて確認後再設定
        RString hihokenshaKubun;
        if (Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()) < 65) {
            hihokenshaKubun = HihokenshaKubunCode.第２号被保険者.getコード();
        } else {
            hihokenshaKubun = HihokenshaKubunCode.第１号被保険者.getコード();
        }
        builder.set被保険者区分コード(hihokenshaKubun);
        if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
            builder.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get生年月日().toFlexibleDate());
            builder.set年齢(Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()));
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().to個人().get性別() != null) {
                builder.set性別(new Code(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get性別().getCode()));
            }
            builder.set電話番号(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
        }
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoAtenaInfo().get氏名カナ()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        builder.set郵便番号(div.getCcdKaigoAtenaInfo().get郵便番号());
        builder.set住所(div.getCcdKaigoAtenaInfo().get住所());
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(new ShikibetsuCode(div.getHdnShikibetsuCode()));
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        for (YokaigoJotaiKubun yokaigoJotaiKubun : YokaigoJotaiKubun.values()) {
            if (yokaigoJotaiKubun.get名称().equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue())) {
                builder.set前回要介護状態区分コード(new Code(yokaigoJotaiKubun.getCode()));
            }
        }
        builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
        builder.set前回認定有効期間_開始(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
        builder.set前回認定有効期間_終了(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        //TODO２号医療保険者名 ２号医療保険記号番号 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
//        builder.set2号医療保険者名(null);
//        builder.set2号医療保険記号番号(null);
        builder.set2号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        builder.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード  QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        if (!div.getHdnNyutaishoJoho().isNull() && !div.getHdnNyutaishoJoho().isEmpty()) {
            builder.set施設入所の有無(true);
        } else {
            builder.set施設入所の有無(false);
        }
//        builder.set入所施設コード(null);
        builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        builder.set認定申請情報登録年月日(FlexibleDate.getNowDate());
        builder.set論理削除フラグ(false);

        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void update受給者台帳_申請修正() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給者台帳(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                div.getHdnRirekiNo(),
                div.getHdnEdaban(),
                new Code(div.getHdnJukyuShinseiJiyu()));
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
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
        newJukyushaDaicho = newJukyushaDaicho.modifiedModel();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void update要介護認定申請情報_申請修正() {
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = manager.get要介護認定申請情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        builder.set申請年度(new FlexibleYear(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getValue().getYear().toDateString()));
        builder.set認定申請年月日(new FlexibleDate(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getTxtShinseiYMD().getText()));
        builder.set認定申請区分_申請時_コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShinseiKubunShinseiji().getSelectedKey()));
        // TODO 被保険者区分の区分けについて確認後再設定
        RString hihokenshaKubun;
        if (Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()) < 65) {
            hihokenshaKubun = HihokenshaKubunCode.第２号被保険者.getコード();
        } else {
            hihokenshaKubun = HihokenshaKubunCode.第１号被保険者.getコード();
        }
        builder.set被保険者区分コード(hihokenshaKubun);
        if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().canBe個人()) {
            builder.set生年月日(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get生年月日().toFlexibleDate());
            builder.set年齢(Integer.parseInt(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get年齢算出().get年齢().toString()));
            if (div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().to個人().get性別() != null) {
                builder.set性別(new Code(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                        .getShikibetsuTaishoHisory().get直近().to個人().get性別().getCode()));
            }
            builder.set電話番号(div.getCcdKaigoAtenaInfo().getAtenaInfoDiv().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().to個人().get連絡先１());
        }
        builder.set被保険者氏名カナ(new AtenaKanaMeisho(div.getCcdKaigoAtenaInfo().get氏名カナ()));
        builder.set被保険者氏名(new AtenaMeisho(div.getCcdKaigoAtenaInfo().get氏名漢字()));
        builder.set郵便番号(div.getCcdKaigoAtenaInfo().get郵便番号());
        builder.set住所(div.getCcdKaigoAtenaInfo().get住所());
        builder.set支所コード(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlShisho().getSelectedKey());
        builder.set識別コード(div.getCcdKaigoAtenaInfo().getShokaiData().getTxtShikibetsuCode().getDomain());
        builder.setみなし２号等対象フラグ(false);
        builder.set広域内転居区分(new Code("0"));
        builder.set認定申請有効区分(new Code("1"));
        builder.set要介護申請_要支援申請の区分(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getRadShinseishoKubun().getSelectedKey());
        builder.set認定申請理由(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getNinteiShinseiRiyu().getTxtNinteiShinseRiyu().getText());
        if (DBD5120001StateName.サービス変更修正.getName().equals(ResponseHolder.getState())) {
            builder.set申請サービス削除の理由(div.getCcdKaigoNinteiShinseiKihon().
                    getKaigoNinteiShinseiKihonJohoInputDiv().getTxtServiceSakujo().getValue());
        }
        for (YokaigoJotaiKubun yokaigoJotaiKubun : YokaigoJotaiKubun.values()) {
            if (yokaigoJotaiKubun.get名称().equals(div.getCcdZenkaiNinteiKekkaJoho().getTxtYokaigodo().getValue())) {
                builder.set前回要介護状態区分コード(new Code(yokaigoJotaiKubun.getCode()));
            }
        }
        if (!DBD5120001StateName.申請修正.getName().equals(ResponseHolder.getState())) {
            builder.set前回認定年月日(div.getCcdZenkaiNinteiKekkaJoho().getTxtNinteiDay().getValue());
            builder.set前回認定有効期間_開始(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanFrom().getValue());
            builder.set前回認定有効期間_終了(div.getCcdZenkaiNinteiKekkaJoho().getTxtYukoKikanTo().getValue());
        }
        //TODO２号医療保険者名 ２号医療保険記号番号 QA90931ご回答されたが、納品まで対応確認すれば間に合わない
//        builder.set2号医療保険者名(null);
//        builder.set2号医療保険記号番号(null);
        builder.set2号特定疾病コード(new Code(div.getCcdKaigoNinteiShinseiKihon().
                getKaigoNinteiShinseiKihonJohoInputDiv().getDdlTokuteiShippei().getSelectedKey()));
        builder.set自動割当除外者区分(new RString("2"));
        builder.set情報提供への同意有無(div.getChkJohoTeikyoDoi().isAllSelected());
        builder.set認定調査委託先コード(new ChosaItakusakiCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosaItakusakiCode().getValue()));
        builder.set認定調査員コード(new ChosainCode(div.getCcdChosaItakusakiAndChosainInput().getTxtChosainCode().getValue()));
        builder.set調査員への連絡事項(div.getCcdChosaItakusakiAndChosainInput().getChosainRenrakuJiko());
        builder.set主治医医療機関コード(div.getCcdShujiiIryokikanAndShujiiInput().getIryoKikanCode());
        builder.set主治医コード(div.getCcdShujiiIryokikanAndShujiiInput().getShujiiCode());
        builder.set指定医フラグ(div.getCcdShujiiIryokikanAndShujiiInput().hasShiteii());
        builder.set主治医への連絡事項(div.getCcdShujiiIryokikanAndShujiiInput().getRenrakuJiko());
        builder.set認定延期通知発行しないことに対する同意有無(div.getChkNinteiTsuchishoDoi().isAllSelected());
        //TODO施設入所の有無 入所施設コード  QA90931ご回答されたが、納品まで対応確認すれば間に合わない
        if (!div.getHdnNyutaishoJoho().isNull() && !div.getHdnNyutaishoJoho().isEmpty()) {
            builder.set施設入所の有無(true);
        } else {
            builder.set施設入所の有無(false);
        }
//        builder.set入所施設コード(null);
        builder.set市町村連絡事項(div.getHdnShichosonRenrakuJiko());
        builder.set延期通知発行回数(0);
        builder.set再調査依頼回数(0);
        builder.set再作成依頼回数(0);
        builder.set論理削除フラグ(false);

        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        newNinteiShinseiJoho = newNinteiShinseiJoho.modifiedModel();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }

    private void update受給者台帳_申請取下() {
        JukyushaDaichoManager manager = new JukyushaDaichoManager();
        JukyushaDaicho jukyushaDaicho = manager.get受給者台帳(
                new LasdecCode(div.getHdnShichosonCode()),
                new HihokenshaNo(div.getHdnHihokenshaNo()),
                div.getHdnRirekiNo(),
                div.getHdnEdaban(),
                new Code(div.getHdnJukyuShinseiJiyu()));
        JukyushaDaichoBuilder builder = jukyushaDaicho.createBuilderForEdit();
        builder.set直近異動事由コード(new Code("00"));
        builder.set有効無効区分(new Code("2"));
        builder.setデータ区分(new Code(div.getCcdShinseiSonotaJohoInput().get異動事由()));

        JukyushaDaicho newJukyushaDaicho = builder.build();
        newJukyushaDaicho = newJukyushaDaicho.modifiedModel();
        manager.save受給者台帳(newJukyushaDaicho);
    }

    private void update要介護認定申請情報_申請取下() {
        DbT4101NinteiShinseiJohoManager manager = new DbT4101NinteiShinseiJohoManager();
        DbT4101NinteiShinseiJoho ninteiShinseiJoho = manager.
                get要介護認定申請情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        DbT4101NinteiShinseiJohoBuilder builder = ninteiShinseiJoho.createBuilderForEdit();
        builder.set取下区分コード(new Code("3"));
        builder.set取下年月日(div.getCcdShinseiSonotaJohoInput().get取消日());
        builder.set取下理由(div.getCcdShinseiSonotaJohoInput().get削除事由());

        DbT4101NinteiShinseiJoho newNinteiShinseiJoho = builder.build();
        newNinteiShinseiJoho = newNinteiShinseiJoho.modifiedModel();
        manager.save要介護認定申請情報(newNinteiShinseiJoho);
    }
    
    private void update要介護認定計画情報_申請取下(RDate 申請日) {
        DbT4123NinteiKeikakuJoho ninteiKeikakuJoho = new DbT4123NinteiKeikakuJoho(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        DbT4123NinteiKeikakuJohoBuilder builder = ninteiKeikakuJoho.createBuilderForEdit();
        FlexibleDate 申請日FlexibleDate = new FlexibleDate(申請日.toDateString());
        DbT4123NinteiKeikakuJohoManager manager = new DbT4123NinteiKeikakuJohoManager();
        int 認定調査依頼予定年月日 = rstringToInt(manager.get認定調査依頼予定年月日(申請日FlexibleDate));
        int 認定調査予定年月日 = rstringToInt(manager.get認定調査予定年月日(申請日FlexibleDate));
        int 主治医意見書作成依頼予定年月日 =rstringToInt(manager.get主治医意見書作成依頼予定年月日(申請日FlexibleDate));
        int 主治医意見書登録予定年月日 = rstringToInt(manager.get主治医意見書登録予定年月日(申請日FlexibleDate));
        int 要介護認定一次判定予定年月日 = rstringToInt(manager.get要介護認定一次判定予定年月日(申請日FlexibleDate));
        int 認定審査会割当予定年月日 = rstringToInt(manager.get認定審査会割当予定年月日(申請日FlexibleDate));
        int 認定審査会予定年月日 = rstringToInt(manager.get認定審査会予定年月日(申請日FlexibleDate));
        int センター送信予定年月日 = rstringToInt(manager.getセンター送信予定年月日(申請日FlexibleDate));
        builder.set認定調査依頼予定年月日(new FlexibleDate(申請日.plusDay(認定調査依頼予定年月日).toDateString()));
        builder.set認定調査予定年月日(new FlexibleDate(申請日.plusDay(認定調査予定年月日).toDateString()));
        builder.set主治医意見書作成依頼予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書作成依頼予定年月日).toDateString()));
        builder.set主治医意見書登録予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書登録予定年月日).toDateString()));
        builder.set要介護認定一次判定予定年月日(new FlexibleDate(申請日.plusDay(要介護認定一次判定予定年月日).toDateString()));
        builder.set認定審査会割当予定年月日(new FlexibleDate(申請日.plusDay(認定審査会割当予定年月日).toDateString()));
        builder.set認定審査会予定年月日(new FlexibleDate(申請日.plusDay(認定審査会予定年月日).toDateString()));
        builder.setセンター送信予定年月日(new FlexibleDate(申請日.plusDay(センター送信予定年月日).toDateString()));
        DbT4123NinteiKeikakuJoho newNinteiKeikakuJoho = builder.build().modifiedModel();
        manager.save認定計画情報(newNinteiKeikakuJoho);
    }

    private void update申請届出者() {
        DbT4120ShinseitodokedeJohoManager manager = new DbT4120ShinseitodokedeJohoManager();
        DbT4120ShinseitodokedeJoho shinseitodokedeJoho = manager.
                get申請届出情報(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        DbT4120ShinseitodokedeJohoBuilder builder = shinseitodokedeJoho.createBuilderForEdit();
        builder.set申請届出代行区分コード(new Code(div.getCcdShinseiTodokedesha().getDdlTodokledeDaikoKubun().getSelectedKey()));
        builder.set申請届出者氏名(div.getCcdShinseiTodokedesha().get一覧内容().get氏名());
        builder.set申請届出者氏名カナ(div.getCcdShinseiTodokedesha().get一覧内容().getカナ氏名());
        builder.set申請届出者続柄(div.getCcdShinseiTodokedesha().get一覧内容().get本人との関係性());
        if (!RString.EMPTY.equals(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者())) {
            builder.set申請届出代行事業者番号(new JigyoshaNo(div.getCcdShinseiTodokedesha().get一覧内容().get申請関係者()));
        }
        builder.set申請届出者電話番号(new TelNo(div.getCcdShinseiTodokedesha().get一覧内容().get電話番号()));
        if (SELECT_KEY0.equals(div.getCcdShinseiTodokedesha().getRadKannaiKangai().getSelectedKey())) {
            builder.set申請届出者郵便番号(div.getCcdShinseiTodokedesha().get一覧内容().get郵便番号());
            builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get町域入力住所コード());
        } else {
            builder.set申請届出者郵便番号(new YubinNo(div.getCcdShinseiTodokedesha().get一覧内容().get全国郵便番号()));
            builder.set申請届出者住所(div.getCcdShinseiTodokedesha().get一覧内容().get全国住所コード());
        }

        DbT4120ShinseitodokedeJoho newShinseitodokedeJoho = builder.build();
        newShinseitodokedeJoho = newShinseitodokedeJoho.modifiedModel();
        manager.save申請届出情報(newShinseitodokedeJoho);
    }

    private void update介護連絡先() {
        NinteiShinseiBusinessCollection data = DataPassingConverter.deserialize(div.
                getHdnRenrakusakiJoho(), NinteiShinseiBusinessCollection.class);
        List<RenrakusakiJoho> renrakusakiJohoDbT5150List = data.getDbdBusiness();
        List<DbT4150RenrakusakiJoho> renrakusakiJohoDbT4150List = this.convertToDbT4150RenrakusakiJoho(renrakusakiJohoDbT5150List);
        for (DbT4150RenrakusakiJoho renrakusakiJoho : renrakusakiJohoDbT4150List) {
            DbT4150RenrakusakiJohoBuilder builder = renrakusakiJoho.createBuilderForEdit();
            builder.set申請書管理番号(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
            DbT4150RenrakusakiJoho newRenrakusakiJoho = builder.build();
            DbT4150RenrakusakiJohoManager manager = new DbT4150RenrakusakiJohoManager();
            manager.save連絡先情報(newRenrakusakiJoho);
        }
    }

//    private void update介護保険施設入退所() {
//        ShisetsuNyutaishoManager manager = new ShisetsuNyutaishoManager();
//
//        int 最大履歴番号 = manager.get最大履歴番号(new ShikibetsuCode(div.getHdnShikibetsuCode()));
//        ShisetsuNyutaisho shisetsuNyutaisho
//                = manager.get介護保険施設入退所(new ShikibetsuCode(div.getCcdKaigoNinteiAtenaInfo().get識別コード()), 最大履歴番号 + 1);
//        ShisetsuNyutaishoBuilder builder = shisetsuNyutaisho.createBuilderForEdit();
//
//        ShisetsuNyutaisho hdnShisetsuNyutaisho = DataPassingConverter.deserialize(div.getHdnNyutaishoJoho(), ShisetsuNyutaisho.class);
//        if (hdnShisetsuNyutaisho == null) {
//            return;
//        }
//        builder.set市町村コード(new LasdecCode(div.getHdnShichosonCode()));
//        builder.set台帳種別(hdnShisetsuNyutaisho.get台帳種別());
//        builder.set入所施設種類(hdnShisetsuNyutaisho.get入所施設種類());
//        builder.set入所施設コード(hdnShisetsuNyutaisho.get入所施設コード());
//        builder.set入所処理年月日(hdnShisetsuNyutaisho.get入所処理年月日());
//        builder.set入所年月日(hdnShisetsuNyutaisho.get入所年月日());
//        builder.set退所処理年月日(hdnShisetsuNyutaisho.get退所処理年月日());
//        builder.set退所年月日(hdnShisetsuNyutaisho.get退所年月日());
//        builder.set部屋記号番号(hdnShisetsuNyutaisho.get部屋記号番号());
//
//        ShisetsuNyutaisho newShisetsuNyutaisho = builder.build();
//        newShisetsuNyutaisho = newShisetsuNyutaisho.modifiedModel();
//        manager.save介護保険施設入退所(newShisetsuNyutaisho);
//
//    }
    
    private void update要介護認定計画情報(RDate 申請日) {
        DbT4123NinteiKeikakuJohoManager manager = new DbT4123NinteiKeikakuJohoManager();
        DbT4123NinteiKeikakuJoho ninteiKeikakuJoho = manager.get申請履歴情報ByKey(new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()));
        DbT4123NinteiKeikakuJohoBuilder builder = ninteiKeikakuJoho.createBuilderForEdit();
        FlexibleDate 申請日FlexibleDate = new FlexibleDate(申請日.toDateString());
        int 認定調査依頼予定年月日 = rstringToInt(manager.get認定調査依頼予定年月日(申請日FlexibleDate));
        int 認定調査予定年月日 = rstringToInt(manager.get認定調査予定年月日(申請日FlexibleDate));
        int 主治医意見書作成依頼予定年月日 =rstringToInt(manager.get主治医意見書作成依頼予定年月日(申請日FlexibleDate));
        int 主治医意見書登録予定年月日 = rstringToInt(manager.get主治医意見書登録予定年月日(申請日FlexibleDate));
        int 要介護認定一次判定予定年月日 = rstringToInt(manager.get要介護認定一次判定予定年月日(申請日FlexibleDate));
        int 認定審査会割当予定年月日 = rstringToInt(manager.get認定審査会割当予定年月日(申請日FlexibleDate));
        int 認定審査会予定年月日 = rstringToInt(manager.get認定審査会予定年月日(申請日FlexibleDate));
        int センター送信予定年月日 = rstringToInt(manager.getセンター送信予定年月日(申請日FlexibleDate));
        builder.set認定調査依頼予定年月日(new FlexibleDate(申請日.plusDay(認定調査依頼予定年月日).toDateString()));
        builder.set認定調査予定年月日(new FlexibleDate(申請日.plusDay(認定調査予定年月日).toDateString()));
        builder.set主治医意見書作成依頼予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書作成依頼予定年月日).toDateString()));
        builder.set主治医意見書登録予定年月日(new FlexibleDate(申請日.plusDay(主治医意見書登録予定年月日).toDateString()));
        builder.set要介護認定一次判定予定年月日(new FlexibleDate(申請日.plusDay(要介護認定一次判定予定年月日).toDateString()));
        builder.set認定審査会割当予定年月日(new FlexibleDate(申請日.plusDay(認定審査会割当予定年月日).toDateString()));
        builder.set認定審査会予定年月日(new FlexibleDate(申請日.plusDay(認定審査会予定年月日).toDateString()));
        builder.setセンター送信予定年月日(new FlexibleDate(申請日.plusDay(センター送信予定年月日).toDateString()));
        DbT4123NinteiKeikakuJoho newNinteiKeikakuJoho = builder.build().modifiedModel();
        manager.save認定計画情報(newNinteiKeikakuJoho);
    }
    
    private void set介護認定申請基本情報(NinteiShinseiTorokuUketsukeBusiness result) {
        KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        介護認定申請Div.initialize();
        介護認定申請Div.setRadShinseishoKubun(result.getEntity().get申請書区分());
        if (!RString.isNullOrEmpty(result.getEntity().get申請状況())) {
            介護認定申請Div.setTxtShinseiJokyo(ShinseiJokyoKubun.toValue(result.getEntity().get申請状況()).get名称());
        }
        if (result.getEntity().get申請日() != null) {
            介護認定申請Div.setTxtShinseiYMD(new RDate(result.getEntity().get申請日().toString()));
        }
        if (result.getEntity().get申請種別() != null) {
            介護認定申請Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(result.getEntity().get申請種別().getColumnValue()));
        }
        if (!RString.isNullOrEmpty(result.getEntity().get認定申請区分コード_申請時().getColumnValue())) {
            介護認定申請Div.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(result.getEntity().get認定申請区分コード_申請時().getColumnValue()));
        }
        if (!RString.isNullOrEmpty(result.getEntity().get認定申請区分コード_法令().getColumnValue())) {
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
        List<RString> dataSource1 = new ArrayList<>();
        if (result.getEntity().is資格取得前申請フラグ()) {
            dataSource1.add(SELECT_KEY0);
        }
        介護認定申請Div.setChkShikakuShutokuMae(dataSource1);
        if (!RString.isNullOrEmpty(result.getEntity().get二号特定疾病コード().getColumnValue())) {
            介護認定申請Div.setTokuteiShippei(
                    TokuteiShippei.toValue(result.getEntity().get二号特定疾病コード().getColumnValue()));
        }
        介護認定申請Div.setServiceSakujoTeikeibun(result.getEntity().get申請サービス削除の理由());
        介護認定申請Div.setNinteiShinseRiyuTeikeibun(result.getEntity().get認定申請理由());
    }
    
    private void set介護認定申請基本情報_新規(NinteiShinseiTorokuUketsukeBusiness result) {
        KaigoNinteiShinseiKihonJohoInputDiv 介護認定申請Div
                = div.getCcdKaigoNinteiShinseiKihon().getKaigoNinteiShinseiKihonJohoInputDiv();
        介護認定申請Div.initialize();
        if (!RString.isNullOrEmpty(result.getEntity().get二号特定疾病コード().getColumnValue())) {
            介護認定申請Div.setTokuteiShippei(
                    TokuteiShippei.toValue(result.getEntity().get二号特定疾病コード().getColumnValue()));
        }
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
            RString 事業者番号 = result.getEntity().get事業者番号().getColumnValue();
            iNinteiShinseiTodokedeshaDiv.getTxtJigyoshaCode().setValue(事業者番号);
        }
        List<RString> shinseiKankeishaCodeList = new ArrayList<>();
        for (ShinseishaKankeiCode code : ShinseishaKankeiCode.values()) {
            shinseiKankeishaCodeList.add(code.getコード());
        }
        iNinteiShinseiTodokedeshaDiv.getDdlShinseiKankeisha().setDataSource(setDataSource(shinseiKankeishaCodeList, false));
        iNinteiShinseiTodokedeshaDiv.getDdlShinseiKankeisha().setSelectedKey(result.getEntity().get届出者_申請者関係コード().getColumnValue());
        RString 氏名 = result.getEntity().get申請届出者氏名();
        iNinteiShinseiTodokedeshaDiv.getTxtShimei().setValue(氏名);
        RString カナ氏名 = result.getEntity().get申請届出者氏名カナ();
        iNinteiShinseiTodokedeshaDiv.getTxtKanaShimei().setValue(カナ氏名);
        RString 本人との関係性 = result.getEntity().get届出者_本人との関係();
        iNinteiShinseiTodokedeshaDiv.getTxtHonninKankeisei().setValue(本人との関係性);
        if (new RString("0").equals(result.getEntity().get管内管外区分())) {
            iNinteiShinseiTodokedeshaDiv.getRadKannaiKangai().setSelectedKey(SELECT_KEY0);
            iNinteiShinseiTodokedeshaDiv.set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管内.toString()));
            TelNo 電話番号 = result.getEntity().get申請届出者電話番号();
            iNinteiShinseiTodokedeshaDiv.getTxtTelNo().setDomain(電話番号);
            YubinNo 郵便番号 = result.getEntity().get申請届出者郵便番号();
            iNinteiShinseiTodokedeshaDiv.getTxtYubinNo().setValue(郵便番号);
            iNinteiShinseiTodokedeshaDiv.getCcdChoikiInput().load(new ChoikiCode(result.getEntity().get申請届出者住所()));
        } else if (new RString("1").equals(result.getEntity().get管内管外区分())) {
            iNinteiShinseiTodokedeshaDiv.getRadKannaiKangai().setSelectedKey(SELECT_KEY1);
            iNinteiShinseiTodokedeshaDiv.set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管外.toString()));
            TelNo 電話番号 = result.getEntity().get申請届出者電話番号();
            iNinteiShinseiTodokedeshaDiv.getTxtTelNo().setDomain(電話番号);
            YubinNo 郵便番号 = result.getEntity().get申請届出者郵便番号();
            // TODO 申請情報ロード時にエラー。住所コード11桁の文字列か空白を指定してください。ロード時に必要ないため一時コメントアウト  ---　龍野
//            iNinteiShinseiTodokedeshaDiv.getCcdZenkokuJushoInput().load(new ZenkokuJushoCode(result.getEntity().get申請届出者住所()), 郵便番号);
//            
//            IZenkokuJushoInputDiv test = iNinteiShinseiTodokedeshaDiv.getCcdZenkokuJushoInput();
//            RString 申請届出者住所 = result.getEntity().get申請届出者住所();
//            
//            //TODO 郵便番号から全国住所コードをとる。又はそれ以外の方法で全国住所コードをとる。
//            IZenkokuJushoFinder finder = ZenkokuJushoFinderFactory.createInstance();
//            List<ZenkokuJushoItem> zenkokuJushoItemList = finder.get全国住所by郵便番号(郵便番号);
//            ZenkokuJushoCode code = null;
//            if(zenkokuJushoItemList.size() > 0){
//                ZenkokuJushoItem zi = zenkokuJushoItemList.get(0);
//                code = zi.get全国住所コード(); //11桁来ない
//            }
////            ZenkokuJushoCode 全国住所コード = new ZenkokuJushoCode(申請届出者住所); //本来ほしいのは全国住所コード自体。ZenkokuJushoCodeはただの入れ物に近い
//            test.load(code, 郵便番号);
        }
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
        主治医div.getTxtIryoKikanCode().setValue(result.getEntity().get主治医医療機関コード());
        主治医div.getTxtIryoKikanName().setValue(result.getEntity().get医療機関名称());
        主治医div.getTxtShujiiCode().setValue(result.getEntity().get主治医コード());
        主治医div.getTxtShujiiName().setValue(result.getEntity().get主治医氏名());
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
        if (result.getEntity().get異動事由() != null) {
            if (new RString("00").equals(result.getEntity().get異動事由().getColumnValue())) {
                認定div.getNinteiJoho().getRadNinteiKubun().setSelectedKey(new RString("1"));
            } else {
                認定div.getNinteiJoho().getRadNinteiKubun().setSelectedKey(new RString("2"));
            }
        }
        if (result.getEntity().get要介護認定状態区分コード() != null) {
            認定div.getNinteiJoho().getTxtYokaigodoCode().setValue(result.getEntity().get要介護認定状態区分コード().getColumnValue());
            認定div.getNinteiJoho().getTxtYokaigodoName().setValue(
                    YokaigoJotaiKubun.toValue(result.getEntity().get要介護認定状態区分コード().getColumnValue()).get名称());
        }
        認定div.getNinteiJoho().getTxtNinteiYMD().setValue(result.getEntity().get認定年月日());
        認定div.getNinteiJoho().getTxtYukoKaishiYMD().setValue(result.getEntity().get認定有効期間開始年月日());
        認定div.getNinteiJoho().getTxtYukoShuryoYMD().setValue(result.getEntity().get認定有効期間終了年月日());
        認定div.getTxtShinsakaiIken().setValue(result.getEntity().get介護認定審査会意見());
    }

    private void set前回認定結果(NinteiShinseiTorokuUketsukeBusiness result) {
        IZenkaiNinteiKekkaJohoDiv 前回認定結果div = div.getCcdZenkaiNinteiKekkaJoho();
        if (result.getEntity().get前回要介護状態区分コード() != null 
                && !RString.isNullOrEmpty(result.getEntity().get前回要介護状態区分コード().getColumnValue())) {
            前回認定結果div.getTxtYokaigodo().setValue(
                    YokaigoJotaiKubun.toValue(result.getEntity().get前回要介護状態区分コード().getColumnValue()).get名称());
        }
        前回認定結果div.getTxtNinteiDay().setValue(result.getEntity().get前回認定年月日());
        前回認定結果div.getTxtYukoKikanFrom().setValue(result.getEntity().get前回認定有効期間_開始());
        前回認定結果div.getTxtYukoKikanTo().setValue(result.getEntity().get前回認定有効期間_終了());
    }
    
    private void set前回認定結果_新規(ShinseishoKanriNo zenkaiShinseishoKanriNo) {
        IZenkaiNinteiKekkaJohoDiv 前回認定結果div = div.getCcdZenkaiNinteiKekkaJoho();
        DbT4102NinteiKekkaJohoManager manager = new DbT4102NinteiKekkaJohoManager();
        DbT4102NinteiKekkaJoho result = manager.get要介護認定申請情報(zenkaiShinseishoKanriNo);
        if (result == null) {
            return;
        }
        if (!RString.isNullOrEmpty(result.get二次判定要介護状態区分コード().getColumnValue())) {
            前回認定結果div.getTxtYokaigodo().setValue(YokaigoJotaiKubun.toValue(result.get二次判定要介護状態区分コード().getColumnValue()).get名称());
        }
        if (result.get二次判定年月日() != null) {
            前回認定結果div.getTxtNinteiDay().setValue(result.get二次判定年月日());
        }
        if (result.get二次判定認定有効開始年月日() != null) {
            前回認定結果div.getTxtYukoKikanFrom().setValue(result.get二次判定認定有効開始年月日());
        }
        if (result.get二次判定認定有効終了年月日() != null) {
            前回認定結果div.getTxtYukoKikanTo().setValue(result.get二次判定認定有効終了年月日());
        }
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
        div.getTxtEnkiTsuchishoHakkoCount().setValue(new Decimal(result.getEntity().get延期通知発行回数()));
    }
}
