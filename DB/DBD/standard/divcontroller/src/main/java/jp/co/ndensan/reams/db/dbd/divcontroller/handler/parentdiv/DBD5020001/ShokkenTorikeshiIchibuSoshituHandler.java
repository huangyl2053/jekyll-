/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJohoBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceIchoTorikomi;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoOutModel;
import jp.co.ndensan.reams.db.dbz.business.core.kekkashosaijoho.KekkaShosaiJohoServiceShuri;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteiinput.NinteiInputNaiyo;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.TorisageKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv.InputType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KekkaShosaiJoho.KekkaShosaiJoho.KekkaShosaiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 要介護認定処理画面のハンドラクラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public class ShokkenTorikeshiIchibuSoshituHandler {

    private final ShokkenTorikeshiIchibuSoshituDiv div;
    private final Association association;

    private static final RString 連絡符号 = new RString(",");
    private static int index = 0;
    private static final int 年の月数 = 12;

    /**
     * 画面タイトルのenum
     */
    private enum 画面タイトル {

        /**
         * 要介護認定
         */
        要介護認定("要介護認定"),
        /**
         * 要介護認定　新規認定
         */
        要介護認定新規認定("要介護認定　新規認定"),
        /**
         * 要介護認定　新規却下
         */
        要介護認定新規却下("要介護認定　新規却下"),
        /**
         * 要介護認定　更新認定
         */
        要介護認定更新認定("要介護認定　更新認定"),
        /**
         * 要介護認定　更新却下
         */
        要介護認定更新却下("要介護認定　更新却下");

        private final String title;

        画面タイトル(String title) {
            this.title = title;
        }

        /**
         * タイトルを返す。
         *
         * @return タイトル
         */
        public RString getTitle() {
            return new RString(title);
        }
    }

    /**
     * 画面表示エリアのenum
     */
    private enum 画面表示エリア {

        /**
         * 調査委託先と調査員コード
         */
        調査委託先と調査員,
        /**
         * 主治医と医療機関
         */
        主治医と医療機関;
    }

    /**
     * コンストラクタです。
     *
     * @param div 要介護認定処理のコントロールdiv
     */
    public ShokkenTorikeshiIchibuSoshituHandler(ShokkenTorikeshiIchibuSoshituDiv div) {
        this.div = div;
        this.association = AssociationFinderFactory.createInstance().getAssociation();
    }

    /**
     * 画面初期化処理です。
     *
     * @param 申請書管理番号 RString
     * @param 被保険者番号 RString
     *
     * @return 画面更新用情報
     */
    public ShokkenTorikeshiIchibuSoshituGamenJoho onLoad(RString 申請書管理番号, RString 被保険者番号) {
        if (null == 申請書管理番号 || 申請書管理番号.isEmpty() || null == 被保険者番号 || 被保険者番号.isEmpty()) {
            return null;
        }

        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (null == 市町村セキュリティ情報) {
            return null;
        }
        YokaigoNinteiJoho 今回情報 = get今回情報(市町村セキュリティ情報.get導入形態コード(), 申請書管理番号);
        YokaigoNinteiJoho 前回情報 = get前回情報(申請書管理番号);

        setHdnArea(今回情報, 申請書管理番号, 被保険者番号);

        ヘッダ初期化();
        認定申請情報初期化(今回情報, 市町村セキュリティ情報.get導入形態コード());
        認定情報初期化(今回情報, 前回情報, 市町村セキュリティ情報.get導入形態コード());

        set画面タイトル(今回情報);
        set子Divモード(div.getTitle().equals(画面タイトル.要介護認定.getTitle()));

        ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報 = new ShokkenTorikeshiIchibuSoshituGamenJoho();
        画面更新用情報.set導入形態コード(市町村セキュリティ情報.get導入形態コード());
        画面更新用情報.set今回情報(今回情報);
        画面更新用情報.set前回情報(前回情報);
        return 画面更新用情報;
    }

    private void setHdnArea(YokaigoNinteiJoho 今回情報, RString 申請書管理番号, RString 被保険者番号) {
        div.setHdnHihokenshaNo(被保険者番号);
        div.setHdnShinseishoKanriNo(申請書管理番号);
        if (null != 今回情報) {
            div.setHdnShikibetsuCode(null != 今回情報.get識別コード受給者台帳() ? 今回情報.get識別コード受給者台帳().value() : RString.EMPTY);
            div.setHdnRenrakuJiko(今回情報.get市町村連絡事項受給());
        }
    }

    /**
     * 保存ボタンのイベントです。
     *
     * @param 画面更新用情報 ShokkenTorikeshiIchibuSoshituGamenJoho
     */
    public void save(ShokkenTorikeshiIchibuSoshituGamenJoho 画面更新用情報) {
        YokaigoNinteiJoho 今回情報 = 画面更新用情報.get今回情報();
        Code 導入形態コード = 画面更新用情報.get導入形態コード();
        KekkaShosaiJohoOutModel model = null;
        if (null != div.getHdnKekkaShosaiJohoOutModel() && !div.getHdnKekkaShosaiJohoOutModel().isEmpty()) {
            model = DataPassingConverter.deserialize(div.getHdnKekkaShosaiJohoOutModel(), KekkaShosaiJohoOutModel.class);
        }

        今回情報 = edit受給者台帳(今回情報, 導入形態コード, model);

        if (div.getHdnKonkaiRirekiNo().equals(new RString("0000"))) {
            今回情報 = edit要介護認定申請情報(今回情報, model);

            if (DonyuKeitaiCode.認定広域.getCode().equals(convertCodeToRString(導入形態コード))) {
                今回情報 = edit認定結果情報(今回情報, true, 導入形態コード);
                今回情報 = edit要介護認定インターフェース情報(今回情報);
            } else if (DonyuKeitaiCode.認定単一.getCode().equals(convertCodeToRString(導入形態コード))) {
                今回情報 = edit認定結果情報(今回情報, false, 導入形態コード);
            }
        }

        YokaigoNinteiJohoManager.createInstance().save(今回情報, is履歴番号更新要());
    }

    /**
     * 「今回認定値」ダイアログ或は「前回認定値」ダイアログOPENボタン押した後のメソッドです。
     *
     * @param 認定情報 YokaigoNinteiJoho
     * @return KekkaShosaiJohoModel
     */
    public KekkaShosaiJohoModel getKekkaShosaiJohoModel(YokaigoNinteiJoho 認定情報, boolean is今回) {
        NinteiInputDataPassModel passModel = new NinteiInputDataPassModel();
        passModel.setSubGyomuCode(SubGyomuCode.DBD介護受給.value());
        passModel.set厚労省IFコード(convertCodeToRString(認定情報.get厚労省IF識別コード()));
        passModel.set申請書管理番号(new ShinseishoKanriNo(認定情報.get申請書管理番号受給()));
        passModel.set認定区分(new RString("1"));
        passModel.setみなし更新認定(new ArrayList<RString>());

        KekkaShosaiJohoModel model = new KekkaShosaiJohoModel();
        model.setIdoJiyuCode(convertCodeToRString(認定情報.getデータ区分()));
        model.setJukyuShikakuHakkoDay1(認定情報.get受給資格証明書発行年月日１());
        model.setJukyuShikakuHakkoDay2(認定情報.get受給資格証明書発行年月日２());
        model.setRiyu(認定情報.get異動理由());
        model.setSakujoJiyuCode(convertCodeToRString(認定情報.get削除事由コード()));
        model.setShinseiKubunLaw(convertCodeToRString(認定情報.get認定申請区分法令コード受給()));
        model.setShinseiKubunShinsei(convertCodeToRString(認定情報.get認定申請区分申請時コード受給()));
        model.setSoshitsuDay(認定情報.get喪失年月日());
        model.setTorisageDay(認定情報.get取下年月日受給());
        model.setToshoNinteiKikanFrom(認定情報.get当初認定有効開始年月日());
        model.setToshoNinteiKikanTo(認定情報.get当初認定有効終了年月日());
        model.setMode(is今回 ? div.getHdnKekkaCommonDivMode() : new RString(KekkaShosaiJohoDiv.ShoriType.ShokaiMode.toString()));
        model.setDataPassModel(passModel);
        return model;
    }

    /**
     * 「今回認定値」ダイアログのOKボタンを押した後のメソッドです。
     *
     * @param model KekkaShosaiJohoOutModel
     */
    public void setKonkaiNinteichiAreaAfterOkClose(KekkaShosaiJohoOutModel model) {
        if (null != model) {
            NinteiInputNaiyo 認定内容 = model.get認定内容();
            div.setHdnYokaigodoCodeKonkai(認定内容.get要介護度コード());
            div.getTxtYokaigodoKonkai().setValue(認定内容.get要介護度名称());
            div.getTxtYukoKaishibiKonkai().setValue(認定内容.get有効開始年月日());
            div.getTxtYukoShuryobiKonkai().setValue(認定内容.get有効終了年月日());
            div.getTxtNinteibiKonkai().setValue(認定内容.get認定年月日());
            RString サービス種類Str = RString.EMPTY;
            List<KekkaShosaiJohoServiceShuri> サービス類リスト = model.getサービス類リスト();
            if (null != サービス類リスト && サービス類リスト.size() > 0) {
                for (int i = 0; i < サービス類リスト.size(); i++) {
                    if (i == 0) {
                        サービス種類Str = サービス類リスト.get(i).getServiceShuriCode();
                    } else {
                        サービス種類Str = サービス種類Str.concat(連絡符号).concat(サービス類リスト.get(i).getServiceShuriCode());
                    }
                }
            }
            div.getTxtServiceShuruiKonkai().setValue(サービス種類Str);
            div.getTxtShinsakaiIkenKonkai().setValue(認定内容.get審査会意見());
        }
    }

    private void ヘッダ初期化() {
        div.getCcdKaigoNinteiAtenaInfo().initialize();
        div.getCcdKaigoNinteiAtenaInfo().setShinseishaJohoByShikibetsuCode(
                new ShinseishoKanriNo(div.getHdnShinseishoKanriNo()),
                new ShikibetsuCode(div.getHdnShikibetsuCode()));
        // TODO. initialize方法がない。　
//        div.getCcdKaigoNinteiShikakuInfo().initialize(
//                association.get地方公共団体コード().value(), RString.EMPTY,
//                RString.EMPTY, div.getHdnHihokenshaNo());

        div.getBtnIryohokenGuide().setDisabled(true);
        div.getBtnRenrakusaki().setDisabled(false);
        div.getBtnNyuinShisetsuNyujo().setDisabled(false);
        div.getBtnShichosonRenrakuJiko().setDisabled(false);
        div.getBtnChosaJokyo().setDisabled(true);
        div.getBtnTainoJokyo().setDisabled(true);
        div.getBtnJogaiShinsain().setDisabled(true);
    }

    private void 認定申請情報初期化(YokaigoNinteiJoho 今回情報, Code 導入形態コード) {
        RString 申請書管理番号 = div.getHdnShinseishoKanriNo();
        IKaigoNinteiShinseiKihonJohoInputDiv 介護認定申請基本情報入力Div = div.getCcdKaigoNinteiShinseiKihonJohoInput();
        介護認定申請基本情報入力Div.initialize();
        介護認定申請基本情報入力Div.setRadShinseishoKubun(今回情報.get要支援申請の区分受給());
        介護認定申請基本情報入力Div.setTxtShinseiYMD(convertFlexibleDateToRDate(今回情報.get認定申請年月日受給()));
        try {
            介護認定申請基本情報入力Div.setShinseiKubunHorei(
                    NinteiShinseiHoreiCode.toValue(convertCodeToRString(今回情報.get認定申請区分法令コード受給())));
        } catch (IllegalArgumentException e) {
        }
        try {
            介護認定申請基本情報入力Div.setShinseiKubunShinseiji(
                    NinteiShinseiShinseijiKubunCode.toValue(convertCodeToRString(今回情報.get認定申請区分申請時コード受給())));
        } catch (IllegalArgumentException e) {
        }
        try {
            介護認定申請基本情報入力Div.setHihokenshaKubun(HihokenshaKubunCode.toValue(今回情報.get被保険者区分コード受給()));
        } catch (IllegalArgumentException e) {
        }
        try {
            介護認定申請基本情報入力Div.setTokuteiShippei(TokuteiShippei.toValue(convertCodeToRString(今回情報.get二号特定疾病コード受給())));
        } catch (IllegalArgumentException e) {
        }
        介護認定申請基本情報入力Div.setShisho(new ShishoCode(今回情報.get支所コード受給()));
        介護認定申請基本情報入力Div.setNinteiShinseRiyuTeikeibun(今回情報.get認定申請理由受給());
        try {
            介護認定申請基本情報入力Div.setShinseiShubetsu(JukyuShinseiJiyu.toValue(今回情報.get受給申請事由()));
        } catch (IllegalArgumentException e) {
        }
        介護認定申請基本情報入力Div.setTxtShinseiJokyo(今回情報.get申請状況区分());
        介護認定申請基本情報入力Div.setKyuSochisha(今回情報.get旧措置者フラグ() ? Arrays.asList(new RString("key0")) : new ArrayList<RString>());
        介護認定申請基本情報入力Div.setChkShikakuShutokuMae(今回情報.get資格取得前申請フラグ()
                ? Arrays.asList(new RString("key0")) : new ArrayList<RString>());

        介護認定申請基本情報入力Div.setInputMode(new RString(InputType.NinteiMode.toString()));

        INinteiShinseiTodokedeshaDiv 申請届出者Div = div.getCcdShinseiTodokedesha();
        NinteiShinseiTodokedeshaDataPassModel model = new NinteiShinseiTodokedeshaDataPassModel();
        model.set申請書管理番号(申請書管理番号);
        申請届出者Div.initialize(model);
        申請届出者Div.set状態(new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        申請届出者Div.set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管内.toString()));

        IShujiiIryokikanAndShujiiInputDiv 主治医Div = div.getShujiiIryokikanAndShujii().getCcdShujiiIryokikanAndShujiiInput();
        主治医Div.setMode_ShoriType(ShujiiIryokikanAndShujiiInputDiv.ShoriType.ShokaiMode);
        if (is表示(画面表示エリア.主治医と医療機関, 導入形態コード)) {
            主治医Div.initialize(
                    association.get地方公共団体コード(),
                    new ShinseishoKanriNo(申請書管理番号),
                    SubGyomuCode.DBD介護受給,
                    今回情報.get主治医医療機関コード受給(),
                    今回情報.get医療機関名称受給(),
                    今回情報.get主治医コード受給(),
                    今回情報.get主治医氏名受給());
            主治医Div.setShiteii(今回情報.get指定医フラグ受給());
        } else {
            主治医Div.initialize(association.get地方公共団体コード(), new ShinseishoKanriNo(申請書管理番号), SubGyomuCode.DBD介護受給);
        }

        IChosaItakusakiAndChosainInputDiv 調査Div = div.getChosaItakusakiAndChosain().getCcdChosaItakusakiAndChosainInput();
        調査Div.setMode_ShoriType(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode);
        if (is表示(画面表示エリア.調査委託先と調査員, 導入形態コード)) {
            調査Div.initialize(
                    new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode.toString()),
                    null == 今回情報.get認定調査委託先コード受給() ? RString.EMPTY : 今回情報.get認定調査委託先コード受給().value(),
                    今回情報.get事業者名称(),
                    null == 今回情報.get認定調査員コード受給() ? RString.EMPTY : 今回情報.get認定調査員コード受給().value(),
                    今回情報.get調査員氏名());
        } else {
            調査Div.initialize(new RString(ChosaItakusakiAndChosainInputDiv.ShoriType.ShokaiMode.toString()));
        }

        div.getTxtSoshitsubi().setValue(convertFlexibleDateToRDate(今回情報.get喪失年月日()));
        div.getTxtSoshitsubi().setDisabled(true);
    }

    private void 認定情報初期化(YokaigoNinteiJoho 今回情報, YokaigoNinteiJoho 前回情報, Code 導入形態コード) {
        if (null != 前回情報) {
            div.getBtnZenkaiNinteichi().setDisabled(false);
            div.setHdnYokaigodoCodeZenkai(convertCodeToRString(前回情報.get要介護認定状態区分コード()));
            div.getTxtYokaigodoZenkai().setValue(get要介護度名(前回情報.get厚労省IF識別コード(), convertCodeToRString(前回情報.get要介護認定状態区分コード())));
            div.setHdnZenkaiRirekiNo(前回情報.get履歴番号());

            div.getTxtYukoKaishibiZenkai().setValue(前回情報.get認定有効期間開始年月日());
            div.getTxtYukoShuryobiZenkai().setValue(前回情報.get認定有効期間終了年月日());
            div.getTxtNinteibiZenkai().setValue(前回情報.get認定年月日());
            div.getTxtServiceShuruiZenkai().setValue(getサービス種類(前回情報));
            div.getTxtShinsakaiIkenZenkai().setValue(前回情報.get介護認定審査会意見());
        } else {
            div.getBtnZenkaiNinteichi().setDisabled(true);
        }

        div.getBtnKonkaiNinteichi().setDisabled(false);

        if (null != 今回情報) {
            div.setHdnKonkaiRirekiNo(今回情報.get履歴番号());
            if (DonyuKeitaiCode.認定広域.getCode().equals(convertCodeToRString(導入形態コード))) {
                div.setHdnYokaigodoCodeKonkai(今回情報.getインターフェース二次判定結果());
                div.getTxtYokaigodoKonkai().setValue(get要介護度名(今回情報.get厚労省IF識別コード(), 今回情報.getインターフェース二次判定結果()));
                div.getTxtYukoKaishibiKonkai().setValue(今回情報.getインターフェース認定有効期間開始年月日());
                div.getTxtYukoShuryobiKonkai().setValue(今回情報.getインターフェース認定有効期間終了年月日());
                div.getTxtNinteibiKonkai().setValue(今回情報.getインターフェース認定年月日());
                div.getTxtServiceShuruiKonkai().setValue(getサービス種類(今回情報));
                div.getTxtShinsakaiIkenKonkai().setValue(今回情報.getインターフェース介護認定審査会意見());
            } else if (DonyuKeitaiCode.認定単一.getCode().equals(convertCodeToRString(導入形態コード))) {
                div.setHdnYokaigodoCodeKonkai(convertCodeToRString(今回情報.get二次判定要介護状態区分コード()));
                div.getTxtYokaigodoKonkai().setValue(
                        get要介護度名(今回情報.get厚労省IF識別コード(), convertCodeToRString(今回情報.get二次判定要介護状態区分コード())));
                div.getTxtYukoKaishibiKonkai().setValue(今回情報.get二次判定認定有効開始年月日());
                div.getTxtYukoShuryobiKonkai().setValue(今回情報.get二次判定認定有効終了年月日());
                div.getTxtNinteibiKonkai().setValue(今回情報.get二次判定日());
                div.getTxtServiceShuruiKonkai().setValue(getサービス種類(今回情報));
                div.getTxtShinsakaiIkenKonkai().setValue(今回情報.get審査会メモ());
            }
        }
    }

    private boolean is表示(画面表示エリア shurui, Code 導入形態コード) {
        if (!DonyuKeitaiCode.認定広域.getCode().equals(convertCodeToRString(導入形態コード))) {
            return true;
        }

        RString 要介護ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        RString 要介護ＩＦ医調取込み = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_医調取込み, RDate.getNowDate(), SubGyomuCode.DBD介護受給);

        if (YokaigoInterfaceShurui.富士通１.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.ＢＳＮ.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.富士通２.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.ＦＮＳ.getコード().equals(要介護ＩＦ種類)) {
            return false;
        } else if (YokaigoInterfaceShurui.電算.getコード().equals(要介護ＩＦ種類)) {
            return true;
        } else if (YokaigoInterfaceShurui.厚労省.getコード().equals(要介護ＩＦ種類)) {
            if (YokaigoInterfaceIchoTorikomi.両方取込む.getコード().equals(要介護ＩＦ医調取込み)) {
                return true;
            } else if (YokaigoInterfaceIchoTorikomi.主治医のみ.getコード().equals(要介護ＩＦ医調取込み)) {
                return shurui.equals(画面表示エリア.主治医と医療機関);
            } else if (YokaigoInterfaceIchoTorikomi.調査員のみ.getコード().equals(要介護ＩＦ医調取込み)) {
                return shurui.equals(画面表示エリア.調査委託先と調査員);
            } else if (YokaigoInterfaceIchoTorikomi.両方取込まない.getコード().equals(要介護ＩＦ医調取込み)) {
                return false;
            }
        }

        return false;
    }

    private void set画面タイトル(YokaigoNinteiJoho 今回情報) {
        RString 認定申請区分申請時コード = convertCodeToRString(今回情報.get認定申請区分申請時コード受給());
        RString 取下区分コード = convertCodeToRString(今回情報.get取下区分コード受給());
        RString タイトル = 画面タイトル.要介護認定.getTitle();
        if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(認定申請区分申請時コード)) {
            if (TorisageKubunCode.認定申請有効.getコード().equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定新規認定.getTitle();
            } else if (TorisageKubunCode.却下.getコード().equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定新規却下.getTitle();
            }
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(認定申請区分申請時コード)) {
            if (TorisageKubunCode.認定申請有効.getコード().equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定更新認定.getTitle();
            } else if (TorisageKubunCode.却下.getコード().equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定更新却下.getTitle();
            }
        }
        div.setTitle(タイトル);
    }

    private void set子Divモード(boolean shokaiModeFlg) {
        if (shokaiModeFlg) {
            div.setHdnKekkaCommonDivMode(new RString(KekkaShosaiJohoDiv.ShoriType.ShokaiMode.toString()));
        } else {
            div.setHdnKekkaCommonDivMode(new RString(KekkaShosaiJohoDiv.ShoriType.InputMode.toString()));
        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), shokaiModeFlg);
    }

    private YokaigoNinteiJoho get今回情報(Code 導入形態コード, RString 申請書管理番号) {
        return YokaigoNinteiJohoManager.createInstance().get今回認定情報(申請書管理番号,
                DonyuKeitaiCode.認定広域.getCode().equals(convertCodeToRString(導入形態コード)));
    }

    private YokaigoNinteiJoho get前回情報(RString 申請書管理番号) {
        return YokaigoNinteiJohoManager.createInstance().get前回認定情報(申請書管理番号);
    }

    private RString get要介護度名(Code 厚労省IF識別コード, RString 要介護度コード) {
        RString 厚労省IF識別コードStr = convertCodeToRString(厚労省IF識別コード);
        try {
            if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コードStr)) {
                return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コードStr)) {
                return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コードStr)) {
                return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
            } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コードStr)
                    || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コードStr)) {
                return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
            }
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private RString getサービス種類(YokaigoNinteiJoho 介護認定情報) {
        RString result = RString.EMPTY;
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類01());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類02());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類03());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類04());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類05());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類06());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類07());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類08());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類09());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類10());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類11());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類12());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類13());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類14());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類15());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類16());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類17());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類18());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類19());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類20());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類21());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類22());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類23());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類24());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類25());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類26());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類27());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類28());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類29());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類30());

        return result;
    }

    private RString get連絡後文字列(RString 連絡前文字列, ServiceShuruiCode サービス種類) {
        if (null == サービス種類 || サービス種類.isEmpty()) {
            return 連絡前文字列;
        }

        if (null == 連絡前文字列 || 連絡前文字列.isEmpty()) {
            return サービス種類.value();
        }

        return 連絡前文字列.concat(連絡符号).concat(サービス種類.value());
    }

    private boolean is履歴番号更新要() {

        if (div.getTitle().equals(画面タイトル.要介護認定新規認定.getTitle())
                && null != div.getHdnZenkaiRirekiNo() && !div.getHdnZenkaiRirekiNo().isEmpty()) {
            return false;
        }

        if (div.getTitle().equals(画面タイトル.要介護認定更新認定.getTitle())
                && !div.getHdnKonkaiRirekiNo().equals(new RString("0000"))) {
            return false;
        }

        return true;
    }

    private YokaigoNinteiJoho edit受給者台帳(YokaigoNinteiJoho 認定情報, Code 導入形態コード, KekkaShosaiJohoOutModel model) {
        if (!is履歴番号更新要()) {
            YokaigoNinteiJohoBuilder builder = 認定情報.createOldJukyushaEntityBuilderForEdit();
            builder.set受給者台帳直近フラグ(false);
            builder.set受給者台帳直近異動年月日(FlexibleDate.getNowDate());
            return builder.build();
        }

        YokaigoNinteiJohoBuilder builder = 認定情報.createNewJukyushaEntityBuilderForEdit();
        RString 履歴番号 = getMax履歴番号(認定情報.get申請書管理番号受給());
        builder.set登録用受給者台帳履歴番号(履歴番号);
        builder.set登録用受給者台帳同一連番(履歴番号);
        builder.set登録用受給者台帳申請状況区分(ShinseiJokyoKubun.認定完了.getコード());
        builder.set登録用受給者台帳直近フラグ(true);
        if (DonyuKeitaiCode.事務単一.getCode().equals(convertCodeToRString(導入形態コード))) {
            builder.set登録用受給者台帳審査会依頼年月日(認定情報.get介護認定審査会資料作成年月日());
        } else if (is審査依頼日更新(認定情報, 導入形態コード)) {
            builder.set登録用受給者台帳審査会依頼年月日(認定情報.get審査会資料作成年月日());
        }
        builder.set登録用受給者台帳認定年月日(div.getTxtNinteibiKonkai().getValue());
        index = 0;
        builder.set登録用受給者台帳指定サービス種類01(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類02(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類03(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類04(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類05(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類06(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類07(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類08(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類09(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類10(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類11(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類12(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類13(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類14(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類15(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類16(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類17(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類18(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類19(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類20(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類21(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類22(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類23(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類24(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類25(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類26(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類27(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類28(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類29(get指定サービス種類(index));
        builder.set登録用受給者台帳指定サービス種類30(get指定サービス種類(index));

        if (!div.getTitle().contains("却下")) {
            builder.set登録用受給者台帳要介護認定状態区分コード(new Code(div.getHdnYokaigodoCodeKonkai()));
            builder.set登録用受給者台帳認定有効期間開始年月日(div.getTxtYukoKaishibiKonkai().getValue());
            builder.set登録用受給者台帳認定有効期間終了年月日(div.getTxtYukoShuryobiKonkai().getValue());
            builder.set登録用受給者台帳みなし要介護区分コード(認定情報.getみなし２号等対象フラグ());
            builder.set登録用受給者台帳直近異動事由コード(new Code(ChokkinIdoJiyuCode.追加_認定.getコード()));
            builder.set登録用受給者台帳有効無効区分(div.getHdnYokaigodoCodeKonkai().equals(new RString("01"))
                    ? new Code(YukoMukoKubun.無効.getコード())
                    : new Code(YukoMukoKubun.有効.getコード()));
            builder.set登録用受給者台帳データ区分(new Code(Datakubun.通常_認定.getコード()));
            builder.set登録用受給者台帳旧措置者フラグ(div.getCcdKaigoNinteiShinseiKihonJohoInput()
                    .getKaigoNinteiShinseiKihonJohoInputDiv().getChkKyuSochisha().getSelectedKeys().contains(new RString("key0")));
        } else {
            builder.set登録用受給者台帳直近異動事由コード(new Code(ChokkinIdoJiyuCode.受給申請却下.getコード()));
            builder.set登録用受給者台帳有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
            if (model != null) {
                builder.set登録用受給者台帳データ区分(null != model.get異動事由コード()
                        ? new Code(model.get異動事由コード()) : Code.EMPTY);
                builder.set登録用受給者台帳異動理由(model.get理由());
            }
        }

        return builder.build();
    }

    private YokaigoNinteiJoho edit要介護認定申請情報(YokaigoNinteiJoho 認定情報, KekkaShosaiJohoOutModel model) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        if (div.getTitle().contains("却下")) {
            builder.set要介護認定申請情報受給取下区分コード(new Code(TorisageKubunCode.却下.getコード()));
            builder.set要介護認定申請情報受給却下年月日(div.getTxtNinteibiKonkai().getValue());
            if (null != model) {
                builder.set要介護認定申請情報受給却下理由(model.get理由());
            }
        } else {
            builder.set要介護認定申請情報受給取下区分コード(new Code(TorisageKubunCode.認定申請有効.getコード()));
        }
        builder.set要介護認定申請情報受給市町村連絡事項(div.getHdnRenrakuJiko());
        builder.set要介護認定申請情報受給審査継続区分(false);

        return builder.build();
    }

    private YokaigoNinteiJoho edit認定結果情報(YokaigoNinteiJoho 認定情報, boolean insertFlg, Code 導入形態コード) {
        YokaigoNinteiJohoBuilder builder;
        if (insertFlg) {
            builder = 認定情報.createNewKekkaEntityBuilderForEdit();
            builder.set要介護認定結果情報申請書管理番号(new ShinseishoKanriNo(認定情報.get申請書管理番号受給()));
            builder.set要介護認定結果情報二次判定年月日(div.getTxtNinteibiKonkai().getValue());
            if (is審査依頼日更新(認定情報, 導入形態コード)) {
                builder.set要介護認定結果情報介護認定審査会資料作成年月日(認定情報.get審査会資料作成年月日());
                builder.set要介護認定結果情報二次判定要介護状態区分コード(new Code());
                builder.set要介護認定結果情報二次判定認定有効期間(new Integer(0));
            }
            if (!div.getTitle().contains("却下")) {
                builder.set要介護認定結果情報二次判定要介護状態区分コード(new Code(div.getHdnYokaigodoCodeKonkai()));
                FlexibleDate 有効開始年月日 = div.getTxtYukoKaishibiKonkai().getValue();
                FlexibleDate 有効終了年月日 = div.getTxtYukoShuryobiKonkai().getValue();
                builder.set要介護認定結果情報二次判定認定有効期間(get有効期間月数(有効開始年月日, 有効終了年月日));
                builder.set要介護認定結果情報二次判定認定有効開始年月日(有効開始年月日);
                builder.set要介護認定結果情報二次判定認定有効終了年月日(有効終了年月日);
            }
        } else {
            builder = 認定情報.createBuilderForEdit();
        }

        if (!div.getTitle().contains("却下")) {
            builder.set要介護認定結果情報介護認定審査会意見(div.getTxtShinsakaiIkenKonkai().getValue());
        }

        return builder.build();
    }

    private YokaigoNinteiJoho edit要介護認定インターフェース情報(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set要介護認定インターフェース情報消し込みフラグ(new RString("1"));
        builder.set要介護認定インターフェース情報消し込み日時(YMDHMS.now());
        return builder.build();
    }

    private ServiceShuruiCode get指定サービス種類(int サービス種類番号) {
        index = index + 1;
        List<RString> サービス種類 = div.getTxtServiceShuruiKonkai().getValue().split(",");
        if (null != サービス種類 && サービス種類.size() > サービス種類番号 && !サービス種類.get(サービス種類番号).isEmpty()) {
            return new ServiceShuruiCode(サービス種類.get(サービス種類番号));
        }
        return null;
    }

    private boolean is審査依頼日更新(YokaigoNinteiJoho 認定情報, Code 導入形態コード) {
        if (!DonyuKeitaiCode.認定広域.getCode().equals(convertCodeToRString(導入形態コード))) {
            return false;
        }

        RString 要介護ＩＦ種類 = DbBusinessConfig.get(ConfigNameDBD.要介護ＩＦ_ＩＦ種類, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
        if (YokaigoInterfaceShurui.厚労省.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.電算.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.富士通１.getコード().equals(要介護ＩＦ種類)
                || YokaigoInterfaceShurui.ＢＳＮ.getコード().equals(要介護ＩＦ種類)) {
            return true;
        } else if (YokaigoInterfaceShurui.富士通２.getコード().equals(要介護ＩＦ種類)) {
            return false;
        } else if (YokaigoInterfaceShurui.ＦＮＳ.getコード().equals(要介護ＩＦ種類)) {
            if (!(null == 認定情報.get審査会依頼年月日()
                    || 認定情報.get審査会依頼年月日().isEmpty())
                    && (null == 認定情報.get審査会資料作成年月日()
                    || 認定情報.get審査会資料作成年月日().isEmpty())) {
                return true;
            }
        }

        return false;
    }

    private RString getMax履歴番号(RString 申請書管理番号) {
        RString Max履歴番号 = YokaigoNinteiJohoManager.createInstance().getMax履歴番号(申請書管理番号);
        if (null == Max履歴番号 || Max履歴番号.isEmpty()) {
            return new RString("0001");
        }
        return new RString(String.format("%04d", Integer.parseInt(Max履歴番号.toString()) + 1));
    }

    private int get有効期間月数(FlexibleDate 開始年月日, FlexibleDate 終了年月日) {
        if (null == 開始年月日 || 開始年月日.isEmpty() || null == 終了年月日 || 終了年月日.isEmpty()
                || 終了年月日.isBefore(開始年月日)) {
            return 0;
        }
        int 月数 = (終了年月日.getYearValue() - 開始年月日.getYearValue()) * 年の月数 + (終了年月日.getMonthValue() - 開始年月日.getMonthValue());
        return 開始年月日.getDayValue() == 1 ? 月数 + 1 : 月数;
    }

    private RDate convertFlexibleDateToRDate(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return null;
        }
        return new RDate(target.toString());
    }

    private RString convertCodeToRString(Code target) {
        return null == target || target.isEmpty() ? RString.EMPTY : target.value();
    }
}
