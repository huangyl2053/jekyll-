/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020001;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJoho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiJohoBuilder;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceIchoTorikomi;
import jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface.YokaigoInterfaceShurui;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001.ShokkenTorikeshiIchibuSoshituMainDiv;
import jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho.YokaigoNinteiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseiJokyoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInputDiv.InputType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.NinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 *
 * 要介護認定処理画面のハンドラクラスです。
 *
 * @reamsid_L DBD-1530-010 lit
 */
public class ShokkenTorikeshiIchibuSoshituHandler {

    private final ShokkenTorikeshiIchibuSoshituDiv div;
    private final ShokkenTorikeshiIchibuSoshituMainDiv mainDiv;

    private static final RString 連絡符号 = new RString(",");
    private static int index = 0;

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
        this.mainDiv = div.getShokkenTorikeshiIchibuSoshituMain();
    }

    /**
     * 画面初期化処理です。
     *
     * @param 申請書管理番号 RString
     * @param 被保険者番号 RString
     *
     * @return 画面更新用情報
     */
    public GamenJoho onLoad(RString 申請書管理番号, RString 被保険者番号) {
        if (null == 申請書管理番号 || 申請書管理番号.isEmpty() || null == 被保険者番号 || 被保険者番号.isEmpty()) {
            return null;
        }

        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        if (null == 市町村セキュリティ情報) {
            return null;
        }

        YokaigoNinteiJoho 今回情報 = get今回情報(市町村セキュリティ情報.get導入形態コード(), 申請書管理番号);

        YokaigoNinteiJoho 前回情報 = get前回情報(申請書管理番号);

        ヘッダ初期化(被保険者番号);
        認定申請情報初期化(今回情報, 申請書管理番号, 市町村セキュリティ情報.get導入形態コード());
        認定情報初期化(今回情報, 前回情報, 市町村セキュリティ情報.get導入形態コード());

        set画面タイトル(今回情報);
        set子Divモード(div.getTitle().equals(new RString("要介護認定")));

        GamenJoho 画面更新用情報 = new GamenJoho();
        画面更新用情報.set導入形態コード(市町村セキュリティ情報.get導入形態コード());
        画面更新用情報.set今回情報(今回情報);
        画面更新用情報.set前回情報(前回情報);
        return 画面更新用情報;
    }

    /**
     * 保存ボタンのイベントです。
     *
     * @param 画面更新用情報 GamenJoho
     */
    public void save(GamenJoho 画面更新用情報) {
        YokaigoNinteiJoho 今回情報 = 画面更新用情報.get今回情報();
        YokaigoNinteiJoho 前回情報 = 画面更新用情報.get前回情報();
        Code 導入形態コード = 画面更新用情報.get導入形態コード();
        if (null != 前回情報) {
            edit受給者台帳(前回情報, false, 導入形態コード);
        }

        edit受給者台帳(今回情報, true, 導入形態コード);

        if (div.getHdnKonkaiRirekiNo().equals(new RString("0000"))) {
            edit要介護認定申請情報(今回情報);

            if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.value())) {
                edit認定結果情報(今回情報, true, 導入形態コード);
                edit要介護認定インターフェース情報(今回情報);
            } else if (DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード.value())) {
                edit認定結果情報(今回情報, false, 導入形態コード);
            }
        }

        YokaigoNinteiJohoManager.createInstance().save(前回情報, 今回情報);
    }

    private void ヘッダ初期化(RString 被保険者番号) {
        // TOOD. 引数：ViewState.申請書管理番号
        mainDiv.getCcdKaigoNinteiAtenaInfo().initialize();
        // TODO. initialize方法がない。　
        mainDiv.getCcdKaigoNinteiShikakuInfo().set被保険者番号(被保険者番号);

        mainDiv.getBtnIryohokenGuide().setDisabled(true);
        mainDiv.getBtnRenrakusaki().setDisabled(false);
        mainDiv.getBtnNyuinShisetsuNyujo().setDisabled(false);
        mainDiv.getBtnShichosonRenrakuJiko().setDisabled(false);
        mainDiv.getBtnChosaJokyo().setDisabled(true);
        mainDiv.getBtnTainoJokyo().setDisabled(true);
        mainDiv.getBtnJogaiShinsain().setDisabled(true);
    }

    private void 認定申請情報初期化(YokaigoNinteiJoho 今回情報, RString 申請書管理番号, Code 導入形態コード) {
        IKaigoNinteiShinseiKihonJohoInputDiv 介護認定申請基本情報入力Div = mainDiv.getCcdKaigoNinteiShinseiKihonJohoInput();
        介護認定申請基本情報入力Div.initialize();
        // TODO. 要介護申請・要支援申請の区分
        介護認定申請基本情報入力Div.setTxtShinseiYMD(convertFlexibleDateToRDate(今回情報.get認定申請年月日()));
        介護認定申請基本情報入力Div.setShinseiKubunHorei(NinteiShinseiHoreiCode.toValue(今回情報.get認定申請区分法令コード().value()));
        介護認定申請基本情報入力Div.setShinseiKubunShinseiji(
                NinteiShinseiShinseijiKubunCode.toValue(今回情報.get認定申請区分申請時コード().value()));
        介護認定申請基本情報入力Div.setHihokenshaKubun(HihokenshaKubunCode.toValue(今回情報.get被保険者区分コード()));
        介護認定申請基本情報入力Div.setTokuteiShippei(TokuteiShippei.toValue(今回情報.get二号特定疾病コード().value()));
        介護認定申請基本情報入力Div.setShisho(new ShishoCode(今回情報.get支所コード()));
        介護認定申請基本情報入力Div.setNinteiShinseRiyuTeikeibun(今回情報.get認定申請理由());
        // TODO. 受給申請事由
        介護認定申請基本情報入力Div.setTxtShinseiJokyo(今回情報.get申請状況区分());
        // TODO. 旧措置者フラグ
//        介護認定申請基本情報入力Div.getKaigoNinteiShinseiKihonJohoInputDiv().setChkKyuSochisha(今回情報.get旧措置者フラグ());
        // TODO. 資格取得前申請フラグ
//        介護認定申請基本情報入力Div.getKaigoNinteiShinseiKihonJohoInputDiv().setChkShikakuShutokuMae(今回情報.get資格取得前申請フラグ());

//        介護認定申請基本情報入力Div.setRadShinseishoKubun(被保険者番号);
//        介護認定申請基本情報入力Div.setServiceSakujoTeikeibun(被保険者番号);
//        介護認定申請基本情報入力Div.setShinseiShubetsu(JukyuShinseiJiyu.初回申請);
        介護認定申請基本情報入力Div.setInputMode(new RString(InputType.NinteiMode.toString()));

        INinteiShinseiTodokedeshaDiv 申請届出者Div = mainDiv.getCcdShinseiTodokedesha();
        NinteiShinseiTodokedeshaDataPassModel model = new NinteiShinseiTodokedeshaDataPassModel();
        model.set申請書管理番号(申請書管理番号);
        申請届出者Div.initialize(model);
        申請届出者Div.set状態(new RString(NinteiShinseiTodokedeshaDiv.ShoriType.ShokaiMode.toString()));
        申請届出者Div.set状態(new RString(NinteiShinseiTodokedeshaDiv.DisplayType.管内.toString()));

        ShujiiIryokikanAndShujiiInputDiv 主治医Div = mainDiv.getShujiiIryokikanAndShujii().getCcdShujiiIryokikanAndShujiiInput();
        // TOOD. initializeとセット方法がない。
        // TODO. mode:ShoriType=ShokaiMode設定できない。
//        主治医Div.
        if (is表示(画面表示エリア.主治医と医療機関, 導入形態コード)) {
            // TODO. 項目設定がない。
//        主治医Div.getCcdShujiiIryokikanAndShujiiInput().setTxtIryoKikanCode(今回情報.get主治医医療機関コード());
//        主治医Div.getCcdShujiiIryokikanAndShujiiInput().setTxtIryoKikanName(今回情報.get医療機関名称());
//        主治医Div.getCcdShujiiIryokikanAndShujiiInput().setShiteiiFlag(今回情報.get指定医フラグ());
//        主治医Div.getCcdShujiiIryokikanAndShujiiInput().setTxtShujiiCode(今回情報.get主治医コード());
//        主治医Div.getCcdShujiiIryokikanAndShujiiInput().setTxtShujiiName(今回情報.get主治医氏名());
        }

        ChosaItakusakiAndChosainInputDiv 調査Div = mainDiv.getChosaItakusakiAndChosain().getCcdChosaItakusakiAndChosainInput();
        // TODO. initialinze方法がない。
        // TODO. mode:ShoriType=ShokaiMode設定できない。
        if (is表示(画面表示エリア.調査委託先と調査員, 導入形態コード)) {
            // TODO. 項目設定がない。
        }

//        調査Div.
        mainDiv.getTxtSoshitsubi().setValue(convertFlexibleDateToRDate(今回情報.get喪失年月日()));
        mainDiv.getTxtSoshitsubi().setDisabled(true);
    }

    private void 認定情報初期化(YokaigoNinteiJoho 今回情報, YokaigoNinteiJoho 前回情報, Code 導入形態コード) {
        mainDiv.getBtnZenkaiNinteichi().setDisabled(false);

        if (null != 前回情報) {
            div.setHdnYokaigodoCodeZenkai(前回情報.get要介護認定状態区分コード().value());
            div.setHdnZenkaiRirekiNo(前回情報.get履歴番号());

            mainDiv.getTxtYokaigodoZenkai().setValue(get要介護度名(前回情報.get厚労省IF識別コード(), 前回情報.get要介護認定状態区分コード().value()));
            mainDiv.getTxtYukoKaishibiZenkai().setValue(convertFlexibleDateToRString(前回情報.get認定有効期間開始年月日()));
            mainDiv.getTxtYukoShuryobiZenkai().setValue(convertFlexibleDateToRString(前回情報.get認定有効期間終了年月日()));
            mainDiv.getTxtNinteibiZenkai().setValue(convertFlexibleDateToRString(前回情報.get認定年月日()));
            mainDiv.getTxtServiceShuruiZenkai().setValue(getサービス種類(前回情報));
            mainDiv.getTxtShinsakaiIkenZenkai().setValue(前回情報.get介護認定審査会意見());
        }

        mainDiv.getBtnKonkaiNinteichi().setDisabled(false);

        if (null != 今回情報) {
            div.setHdnKonkaiRirekiNo(今回情報.get履歴番号());
            if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.value())) {
                div.setHdnYokaigodoCodeKonkai(今回情報.getインターフェース二次判定結果());
                mainDiv.getTxtYokaigodoKonkai().setValue(get要介護度名(今回情報.get厚労省IF識別コード(), 今回情報.getインターフェース二次判定結果()));
                mainDiv.getTxtYukoKaishibiKonkai().setValue(convertFlexibleDateToRString(今回情報.getインターフェース認定有効期間開始年月日()));
                mainDiv.getTxtYukoShuryobiKonkai().setValue(convertFlexibleDateToRString(今回情報.getインターフェース認定有効期間終了年月日()));
                mainDiv.getTxtNinteibiKonkai().setValue(convertFlexibleDateToRString(今回情報.getインターフェース認定年月日()));
                mainDiv.getTxtServiceShuruiKonkai().setValue(getサービス種類(今回情報));
                mainDiv.getTxtShinsakaiIkenKonkai().setValue(今回情報.getインターフェース介護認定審査会意見());
            } else if (DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード.value())) {
                div.setHdnYokaigodoCodeKonkai(今回情報.get二次判定要介護状態区分コード().value());
                mainDiv.getTxtYokaigodoKonkai().setValue(
                        get要介護度名(今回情報.get厚労省IF識別コード(), 今回情報.get二次判定要介護状態区分コード().value()));
                mainDiv.getTxtYukoKaishibiKonkai().setValue(convertFlexibleDateToRString(今回情報.get二次判定認定有効開始年月日()));
                mainDiv.getTxtYukoShuryobiKonkai().setValue(convertFlexibleDateToRString(今回情報.get二次判定認定有効終了年月日()));
                mainDiv.getTxtNinteibiKonkai().setValue(convertFlexibleDateToRString(今回情報.get二次判定日()));
                mainDiv.getTxtServiceShuruiKonkai().setValue(getサービス種類(今回情報));
                mainDiv.getTxtShinsakaiIkenKonkai().setValue(今回情報.get審査会メモ());
            }
        }
    }

    private boolean is表示(画面表示エリア shurui, Code 導入形態コード) {
        if (!DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.value())) {
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
        Code 認定申請区分申請時コード = 今回情報.get認定申請区分申請時コード();
        Code 取下区分コード = 今回情報.get取下区分コード();
        RString タイトル = 画面タイトル.要介護認定.getTitle();
        // TODO. NinteiShinseijiKubunがDBEのEnumですので
//        if (NinteiShinseijiKubun.新規申請.getCode().equals(認定申請区分申請時コード.value())) {
        if (new RString("01").equals(認定申請区分申請時コード.value())) {
            // TODO. TorisageKubunにCodeがない。
            if (TorisageKubun.認定申請有効.equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定新規認定.getTitle();
            } else if (TorisageKubun.区分変更却下.equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定新規却下.getTitle();
            }
//        } else if (NinteiShinseijiKubun.更新申請.getCode().equals(認定申請区分申請時コード.value())) {
        } else if (new RString("02").equals(認定申請区分申請時コード.value())) {
            // TODO. TorisageKubunにCodeがない。
            if (TorisageKubun.認定申請有効.equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定更新認定.getTitle();
            } else if (TorisageKubun.区分変更却下.equals(取下区分コード)) {
                タイトル = 画面タイトル.要介護認定更新却下.getTitle();
            }
        }
        div.setTitle(タイトル);
    }

    private void set子Divモード(boolean inputModeFlg) {
        // TODO.2.　6.　1.　結果詳細情報共有子Divのモードを「ShokaiMode」にする。
        if (inputModeFlg) {

        } else {

        }
        CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnSave"), !inputModeFlg);
    }

    private YokaigoNinteiJoho get今回情報(Code 導入形態コード, RString 申請書管理番号) {
        return YokaigoNinteiJohoManager.createInstance().get今回認定情報(申請書管理番号,
                DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.value()));
    }

    private YokaigoNinteiJoho get前回情報(RString 申請書管理番号) {
        return YokaigoNinteiJohoManager.createInstance().get前回認定情報(申請書管理番号);
    }

    private RString get要介護度名(Code 厚労省IF識別コード, RString 要介護度コード) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            return YokaigoJotaiKubun99.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            return YokaigoJotaiKubun02.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return YokaigoJotaiKubun06.toValue(要介護度コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            return YokaigoJotaiKubun09.toValue(要介護度コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString getサービス種類(YokaigoNinteiJoho 介護認定情報) {
        RString result = RString.EMPTY;
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類01().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類02().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類03().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類04().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類05().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類06().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類07().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類08().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類09().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類10().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類11().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類12().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類13().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類14().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類15().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類16().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類17().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類18().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類19().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類20().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類21().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類22().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類23().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類24().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類25().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類26().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類27().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類28().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類29().value());
        result = get連絡後文字列(result, 介護認定情報.get指定サービス種類30().value());

        return result;
    }

    private RString get連絡後文字列(RString 連絡前文字列, RString 連絡用文字列) {
        if (null == 連絡用文字列 || 連絡用文字列.isEmpty()) {
            return 連絡前文字列;
        }

        if (null == 連絡前文字列 || 連絡前文字列.isEmpty()) {
            return 連絡用文字列;
        }

        return 連絡前文字列.concat(連絡符号).concat(連絡用文字列);
    }

    private void edit受給者台帳(YokaigoNinteiJoho 認定情報, boolean 今回Flg, Code 導入形態コード) {

        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set受給者台帳直近フラグ(false);
        builder.set受給者台帳直近異動年月日(FlexibleDate.getNowDate());

        if (今回Flg && div.getHdnKonkaiRirekiNo().equals(new RString("0000"))) {
            RString 履歴番号 = getMax履歴番号(認定情報.get申請書管理番号());
            builder.set受給者台帳履歴番号(履歴番号);
            builder.set受給者台帳同一連番(履歴番号);
            builder.set受給者台帳申請状況区分(ShinseiJokyoKubun.認定完了.getコード());
            builder.set受給者台帳直近フラグ(true);
            if (is審査依頼日更新(認定情報, 導入形態コード)) {
                builder.set受給者台帳審査会依頼年月日(認定情報.get審査会資料作成年月日());
            }
            builder.set受給者台帳認定年月日(new FlexibleDate(div.getTxtNinteibiKonkai().getValue()));
            index = 0;
            builder.set受給者台帳指定サービス種類01(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類02(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類03(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類04(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類05(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類06(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類07(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類08(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類09(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類10(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類11(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類12(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類13(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類14(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類15(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類16(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類17(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類18(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類19(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類20(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類21(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類22(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類23(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類24(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類25(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類26(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類27(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類28(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類29(get指定サービス種類(index));
            builder.set受給者台帳指定サービス種類30(get指定サービス種類(index));

            if (!div.getTitle().contains("却下")) {
                builder.set受給者台帳要介護認定状態区分コード(new Code(div.getHdnYokaigodoCodeKonkai()));
                builder.set受給者台帳認定有効期間開始年月日(new FlexibleDate(div.getTxtYukoKaishibiKonkai().getValue()));
                builder.set受給者台帳認定有効期間終了年月日(new FlexibleDate(div.getTxtYukoShuryobiKonkai().getValue()));
                builder.set受給者台帳みなし要介護区分コード(認定情報.getみなし２号等対象フラグ());
                builder.set受給者台帳直近異動事由コード(new Code(ChokkinIdoJiyuCode.追加_認定.getコード()));
                builder.set受給者台帳有効無効区分(div.getHdnYokaigodoCodeKonkai().equals(new RString("01"))
                        ? new Code(YukoMukoKubun.無効.getコード())
                        : new Code(YukoMukoKubun.有効.getコード()));
                builder.set受給者台帳データ区分(new Code(Datakubun.通常_認定.getコード()));
                // TODO.結果詳細情報ダイアログで入力された旧措置フラグ
                //                builder.set受給者台帳旧措置者フラグ();
            } else {
                builder.set受給者台帳直近異動事由コード(new Code(ChokkinIdoJiyuCode.受給申請却下.getコード()));
                builder.set受給者台帳有効無効区分(new Code(YukoMukoKubun.無効.getコード()));
                // TODO. 結果詳細情報ダイアログで選択された異動事由(3*)
//                builder.set受給者台帳データ区分(Datakubun.通常_認定);
//                builder.set受給者台帳異動理由();
            }
        }

        認定情報 = builder.build();
    }

    private void edit要介護認定申請情報(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        if (div.getTitle().contains("却下")) {
            // TODO. codeがない。
            builder.set要介護認定申請情報取下区分コード(new Code(TorisageKubun.認定申請有効.name()));

            builder.set要介護認定申請情報却下年月日(new FlexibleDate(div.getTxtNinteibiKonkai().getValue()));
            // TODO. 結果詳細ダイアログの理由
//            builder.set要介護認定申請情報却下理由(new Code(TorisageKubun.認定申請有効.name()));
        } else {
            // TODO. codeがない。
            builder.set要介護認定申請情報取下区分コード(new Code(TorisageKubun.区分変更却下.name()));
        }
        builder.set要介護認定申請情報市町村連絡事項(連絡符号);
        builder.set要介護認定申請情報審査継続区分(false);

        認定情報 = builder.build();
    }

    private void edit認定結果情報(YokaigoNinteiJoho 認定情報, boolean insertFlg, Code 導入形態コード) {
        YokaigoNinteiJohoBuilder builder;
        if (insertFlg) {
            builder = 認定情報.createNewKekkaEntityBuilderForEdit();
            builder.set要介護認定結果情報申請書管理番号(new ShinseishoKanriNo(認定情報.get申請書管理番号()));
            builder.set要介護認定結果情報二次判定年月日(new FlexibleDate(div.getTxtNinteibiKonkai().getValue()));
            if (is審査依頼日更新(認定情報, 導入形態コード)) {
                builder.set要介護認定結果情報介護認定審査会資料作成年月日(認定情報.get審査会資料作成年月日());
            }
            if (!div.getTitle().contains("却下")) {
                builder.set要介護認定結果情報二次判定要介護状態区分コード(new Code(div.getHdnYokaigodoCodeKonkai()));
                FlexibleDate 有効開始年月日 = new FlexibleDate(div.getTxtYukoKaishibiKonkai().getValue());
                FlexibleDate 有効終了年月日 = new FlexibleDate(div.getTxtYukoShuryobiKonkai().getValue());
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

        認定情報 = builder.build();
    }

    private void edit要介護認定インターフェース情報(YokaigoNinteiJoho 認定情報) {
        YokaigoNinteiJohoBuilder builder = 認定情報.createBuilderForEdit();
        builder.set要介護認定インターフェース情報消し込みフラグ(new RString("1"));
        builder.set要介護認定インターフェース情報消し込み日時(YMDHMS.now());
        認定情報 = builder.build();
    }

    private ServiceShuruiCode get指定サービス種類(int サービス種類番号) {
        List<RString> サービス種類 = div.getTxtServiceShuruiKonkai().getValue().split(",");
        if (null != サービス種類 && サービス種類.size() > サービス種類番号) {
            return new ServiceShuruiCode(サービス種類.get(サービス種類番号));
        }
        index = index + 1;
        return ServiceShuruiCode.EMPTY;
    }

    private boolean is審査依頼日更新(YokaigoNinteiJoho 認定情報, Code 導入形態コード) {
        if (!DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.value())) {
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
        return new RString(String.format("04d%", Integer.parseInt(Max履歴番号.toString()) + 1));
    }

    private int get有効期間月数(FlexibleDate 開始年月日, FlexibleDate 終了年月日) {
        if (null == 開始年月日 || 開始年月日.isEmpty() || null == 終了年月日 || 終了年月日.isEmpty()
                || 終了年月日.isBefore(開始年月日)) {
            return 0;
        }
        int 月数 = (終了年月日.getYearValue() - 開始年月日.getYearValue()) * 12 + (終了年月日.getMonthValue() - 開始年月日.getMonthValue());
        return 開始年月日.getDayValue() == 1 ? 月数 + 1 : 月数;
    }

    private RString convertFlexibleDateToRString(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return RString.EMPTY;
        }
        return target.wareki().toDateString();
    }

    private RDate convertFlexibleDateToRDate(FlexibleDate target) {
        if (null == target || target.isEmpty()) {
            return null;
        }
        return new RDate(target.toString());
    }

    /**
     * 画面更新用クラス。
     */
    @lombok.Getter
    @lombok.Setter
    public final class GamenJoho implements Serializable {

        private YokaigoNinteiJoho 今回情報;
        private YokaigoNinteiJoho 前回情報;
        private Code 導入形態コード;
    }

}
