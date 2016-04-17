/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShichosonResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu.JutakukaishuShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011.dgJutakuKaishuShinseiList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuDataParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShikyuShiseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakuKaishuShikyuGendogakuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterNoOption;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 住宅改修費支給申請_申請情報登録ハンドラークラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public final class JutakuKaishuShinseiJyohoTorokuHandler {

    private final JutakuKaishuShinseiJyohoTorokuDiv div;
    private final RString 画面モード_登録 = new RString("登録モード");
    private final RString 画面モード_事前申請 = new RString("事前申請登録モード");
    private final RString 画面モード_修正 = new RString("修正モード");
    private final RString 画面モード_審査 = new RString("審査モード");
    private final RString 画面モード_照会 = new RString("照会モード");
    private final RString 画面モード_削除 = new RString("削除モード");
    private final RString 画面モード_取消 = new RString("取消モード");
    private final RString 状態_修正 = new RString("修正");
    private final RString 状態_登録 = new RString("登録");
    private final RString 給付実績連動_受託なし = new RString("1");
    private final RString 給付実績緋連動_受託あり = new RString("2");
    private final RString 要介護状態区分3段階変更による = new RString("threeUp");
    private final RString 住宅住所変更による = new RString("changeAddress");
    private final Code 非該当 = new Code("01");
    private final Code 要支援1 = new Code("12");
    private final Code 要支援2 = new Code("13");
    private final Code 要支援_経過的要介護 = new Code("11");
    private final Code 要介護1 = new Code("21");
    private final Code 要介護2 = new Code("22");
    private final Code 要介護3 = new Code("23");
    private final Code 要介護4 = new Code("24");
    private final Code 要介護5 = new Code("25");
    private final RString 証明書1 = new RString("21D1");
    private final RString 証明書2 = new RString("21D2");
    private final RString 送付区分_送付済 = new RString("1");
    private final RString 償還払請求基本_明細番号 = new RString("0001");
    private final RString 審査結果_承認する = new RString("1");
    private final RString 審査結果_却下する = new RString("2");
    private final RString 証明書様式内容_NULL = new RString("証明書様式内容");
    private final JigyoshaNo 償還払請求基本_事業者番号 = new JigyoshaNo("0000000000");
    private final RString 償還払給付費 = new RString("001");
    private final RString 提供着工年月MSG = new RString("提供（着工）年月");
    private final RString 申請者区分_空 = new RString("0");

    private JutakuKaishuShinseiJyohoTorokuHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static JutakuKaishuShinseiJyohoTorokuHandler of(JutakuKaishuShinseiJyohoTorokuDiv div) {
        return new JutakuKaishuShinseiJyohoTorokuHandler(div);
    }

    /**
     * 画面の初期化するメソッド
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 RDate
     * @param 整理番号 RString
     * @param 画面モード RString
     */
    public void onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, RString 画面モード) {
        RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);

        List<dgJutakuKaishuShinseiList_Row> rows = new ArrayList<>();
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();

        // １．8　保険者ドロップダウンリストを初期化する
        FukushiyoguKonyuhiShikyuShinsei 保険者 = FukushiyoguKonyuhiShikyuShinsei.createInstance();
//        List<ShichosonResult> 保険者リスト = 保険者.getHokensyaList(被保険者番号, サービス提供年月);
//        set保険者初期化(保険者リスト);
        // １．９　証明書ドロップダウンリストを初期化する
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        if (画面モード_登録.equals(画面モード)) {
            // １．４．１　整理番号の初期化
            div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                    SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString());
            // １．４．２　以下の共有子Divが登録モードとして初期化する
            // ・「住宅改修内容一覧」共有子Div
//            div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().load(
//                    被保険者番号, サービス提供年月, 整理番号, 様式番号);
            // ・「支払方法情報」共有子Div
            SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
            支給申請情報.setShikibetsuCode(識別コード);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(支給申請情報,
                    new KamokuCode(償還払給付費), 状態_登録);
            ShiharaiKekkaResult 最新住宅改修費支払結果 = 住宅改修費事前申請.getNewJutakuKaishuHi(被保険者番号);
            前回まで支払結果の初期化(最新住宅改修費支払結果);
            RString month = BusinessConfig.get(ConfigNameDBC.初期表示_償還支給申請登録初期, SubGyomuCode.DBC介護給付);
            div.getTxtTeikyoYM().setValue(new RDate(
                    FlexibleDate.getNowDate().getYearMonth().minusMonth(Integer.parseInt(month.toString())).toString()));
            証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード);
            ViewStateHolder.put(ViewStateKeys.申請情報登録_更新前データ, (Serializable) get更新前データ());
            div.getBtnShokanKetteiJyoho().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
            set費用額合計など入力不可();
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setVisible(false);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setSelectedKey(
                    申請者区分_空);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setVisible(false);
        } else if (画面モード_事前申請.equals(画面モード)) {
            // １．５．１　整理番号の初期化 画面の整理番号に設定する
            div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                    SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString());
            // １．５．２　画面申請内容の初期化
            ShokanJutakuKaishuJizenShinsei 申請情報 = 住宅改修費事前申請.getJutakuKaishuJizenShinseiJyoho(被保険者番号,
                    サービス提供年月, 整理番号);
            if (申請情報 == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            // TODO 申請内容エリアを初期かする
            事前申請内容エリアを初期(申請情報);
            // １．５．3　「住宅改修内容一覧」共有子Div の初期化
            RString 様式番号 = 住宅改修費事前申請.getYoshikiNo(被保険者番号, サービス提供年月, 整理番号);
//            div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().load(
//                    被保険者番号, サービス提供年月, 整理番号, 様式番号);
            // １．５．４　前回まで支払結果の初期化
            ShiharaiKekkaResult 過去住宅改修費支払結果 = 住宅改修費事前申請.getOldJutakuKaishuHi(
                    被保険者番号, サービス提供年月, 整理番号);
            前回まで支払結果の初期化(過去住宅改修費支払結果);
            // １．５．５　「支払方法情報」共有子Div の初期化
            SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
            set事前支給申請情報(支給申請情報, 申請情報);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, new KamokuCode(償還払給付費), 状態_修正);
            ViewStateHolder.put(ViewStateKeys.申請情報登録_更新前データ, (Serializable) get更新前データ());
            div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setVisible(false);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setVisible(false);
            set費用額合計など入力不可();
        } else if (画面モード_修正.equals(画面モード) || 画面モード_審査.equals(画面モード)
                || 画面モード_照会.equals(画面モード) || 画面モード_削除.equals(画面モード)
                || 画面モード_取消.equals(画面モード)) {
            // １．６．１　画面申請内容の初期化
            // ①
            ShokanShinsei 償還払支給申請情報 = 住宅改修費支給申請.getShokanKihonShinsei(
                    被保険者番号, サービス提供年月, 整理番号);
            if (償還払支給申請情報 == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            // TODO 申請内容エリアを初期かする
            支給申請内容エリアを初期(償還払支給申請情報);
            // ②
            ShokanKihon 償還払請求基本 = 住宅改修費支給申請.getShokanKihon(被保険者番号, サービス提供年月, 整理番号);
            if (償還払請求基本 == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            div.getTxtKyufuritsu().setValue(償還払請求基本.get保険給付率().value());

            証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード);
            div.getDdlSyomeisyo().setSelectedKey(償還払請求基本.get様式番号());
            // ③
            ShokanShukei 償還払請求集計 = 住宅改修費支給申請.getShokanSyukei(償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(), 償還払請求基本.get整理番号(), 償還払請求基本.get事業者番号(),
                    償還払請求基本.get様式番号(), 償還払請求基本.get明細番号());
            if (償還払請求集計 == null) {
                throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
            }
            // １．６．２　「住宅改修内容一覧」共有子Div の初期化 QA
            // １．６．３　前回まで支払結果の初期化
            ShiharaiKekkaResult 過去住宅改修費支払結果 = 住宅改修費事前申請.getOldJutakuKaishuHi(
                    被保険者番号, サービス提供年月, 整理番号);
            前回まで支払結果の初期化(過去住宅改修費支払結果);
            // １．６．４　「支払方法情報」共有子Div の初期化
            SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
            set支給申請情報(支給申請情報, 償還払支給申請情報);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, new KamokuCode(償還払給付費), 状態_修正);
            // １．６．５　｢償還払決定情報｣ボタンの表示
            ShokanHanteiKekka 償還払支給判定結果 = 住宅改修費支給申請.getShokanHanteiKekka(償還払請求基本.get被保険者番号(),
                    償還払請求基本.getサービス提供年月(), 償還払請求基本.get整理番号());
            ViewStateHolder.put(ViewStateKeys.償還払支給判定結果, 償還払支給判定結果);
            if (画面モード_審査.equals(画面モード)) {
                div.getBtnShokanKetteiJyoho().setDisabled(true);
            } else if (画面モード_照会.equals(画面モード)) {
                div.getBtnShokanKetteiJyoho().setDisabled(true);
                if (償還払支給判定結果 != null) {
                    div.getBtnShokanKetteiJyoho().setDisabled(false);
                }
                // ④　画面モードが修正モード
            } else if (画面モード_修正.equals(画面モード)) {
                設定償還払決定情報ボタンの表示(給付実績連動_受託なし, 償還払支給判定結果, 償還払支給申請情報, 画面モード, 支給申請情報, 住宅改修費支給申請, 償還払請求基本, 被保険者番号, サービス提供年月, 整理番号);
            } else {
                設定償還払決定情報ボタンの表示(償還, 償還払支給判定結果, 償還払支給申請情報, 画面モード, 支給申請情報, 住宅改修費支給申請, 償還払請求基本, 被保険者番号, サービス提供年月, 整理番号);
            }

            証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード);
            ViewStateHolder.put(ViewStateKeys.申請情報登録_更新前データ, (Serializable) get更新前データ());
        }
    }

    private void set費用額合計など入力不可() {
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountMae()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalNow().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoNow()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountNow()
                .setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow()
                .setDisabled(true);
    }

    private void 設定償還払決定情報ボタンの表示(RString 償還, ShokanHanteiKekka 償還払支給判定結果, ShokanShinsei 償還払支給申請情報, RString 画面モード, SikyuSinseiJyohoParameter 支給申請情報, JutakukaishuSikyuShinseiManager 住宅改修費支給申請, ShokanKihon 償還払請求基本, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) throws NullPointerException, ApplicationException, IllegalArgumentException {
        if (給付実績連動_受託なし.equals(償還)) {
            div.getBtnShokanKetteiJyoho().setDisabled(true);
            if (償還払支給判定結果 != null) {
                div.getBtnShokanKetteiJyoho().setDisabled(false);
            }
        } else if (給付実績緋連動_受託あり.equals(償還)) {
            if (償還払支給判定結果 == null && 償還払支給申請情報.get送付年月() != null) {
                set画面照会モードに変更();
            } else if (償還払支給判定結果 == null && 償還払支給申請情報.get送付年月() == null) {
                div.getBtnShokanKetteiJyoho().setDisabled(true);
            } else if (償還払支給判定結果 != null) {
                div.getBtnShokanKetteiJyoho().setDisabled(false);
                RString 支給不支給区分 = 償還払支給判定結果.get支給_不支給決定区分();
                if (ShikyuFushikyuKubun.支給.getコード().equals(支給不支給区分)) {
                    List<KyufujissekiKihon> 給付実績基本情報リスト = 住宅改修費支給申請.getKyufuJissekiKihonList(
                            償還払請求基本.get様式番号(), new HokenshaNo(div.getJutakuKaishuShinseiContents()
                                    .getDdlHokensha().getSelectedKey()), 被保険者番号, サービス提供年月, 整理番号,
                            KyufuJissekiKubun.償還.getコード());
                    if (給付実績基本情報リスト.isEmpty()) {
                        set画面照会モードに変更();
                    } else {
                        int 最新審査年月count = 0;
                        FlexibleYearMonth 最新審査年月 = 給付実績基本情報リスト.get(0).get審査年月();
                        KyufujissekiKihon 最新審査年月給付実績基本情報 = 給付実績基本情報リスト.get(0);
                        for (KyufujissekiKihon 給付実績基本情報 : 給付実績基本情報リスト) {
                            FlexibleYearMonth 審査年月 = 給付実績基本情報.get審査年月();
                            if (最新審査年月.isBeforeOrEquals(審査年月)) {
                                最新審査年月 = 審査年月;
                                最新審査年月給付実績基本情報 = 給付実績基本情報;
                            }
                        }
                        for (KyufujissekiKihon 給付実績基本情報 : 給付実績基本情報リスト) {
                            FlexibleYearMonth 審査年月 = 給付実績基本情報.get審査年月();
                            if (最新審査年月.equals(審査年月)) {
                                最新審査年月count++;
                            }
                        }
                        if (最新審査年月count > 1) {
                            throw new ApplicationException(DbcErrorMessages.給付実績複数件取得.getMessage());
                        } else if (最新審査年月給付実績基本情報.get後_保険_請求額().intValue()
                                == 償還払支給申請情報.get保険給付額()) {
                            div.getBtnShokanKetteiJyoho().setDisabled(false);
                        } else if (最新審査年月給付実績基本情報.get後_保険_請求額().intValue()
                                != 償還払支給申請情報.get保険給付額()) {
                            set画面照会モードに変更();
                            div.getBtnShokanKetteiJyoho().setDisabled(false);
                        }
                    }
                } else if (ShikyuFushikyuKubun.不支給.getコード().equals(支給不支給区分)) {
                    div.getBtnShokanKetteiJyoho().setDisabled(false);
                }
            }
        }
    }

    private void set画面照会モードに変更() {
        div.getCommHeadPanel().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getDdlHokensha().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShiharaiHohoJyohoPanle().setDisabled(false);
        div.getJutakuKaishuShinseiContents().getChkKokubo().setDisabled(false);
        // 「支払方法情報」共有子Div の初期化
//                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(支給申請情報,
//                        new KamokuCode(償還払給付費), 状態_登録);
    }

    private void set事前支給申請情報(SikyuSinseiJyohoParameter 支給申請情報, ShokanJutakuKaishuJizenShinsei 事前申請情報) {
        支給申請情報.setShikibetsuCode(new ShikibetsuCode("000000000000010"));
        支給申請情報.setHihokenshaNo(事前申請情報.get被保険者番号());
        支給申請情報.setShikyushinseiServiceYM(事前申請情報.getサービス提供年月());
        支給申請情報.setShikyushinseiSeiriNo(事前申請情報.get整理番号());
        支給申請情報.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(事前申請情報.get支払方法区分コード()));
        支給申請情報.setShiharaiBasho(事前申請情報.get支払場所());
        支給申請情報.setStartYMD(new RDate(事前申請情報.get支払期間開始年月日().toString()));
        支給申請情報.setEndYMD(new RDate(事前申請情報.get支払期間終了年月日().toString()));
        支給申請情報.setStartHHMM(new RTime(事前申請情報.get支払窓口開始時間()));
        支給申請情報.setEndHHMM(new RTime(事前申請情報.get支払窓口終了時間()));
        支給申請情報.setKozaId(事前申請情報.get口座ID());
        支給申請情報.setKeiyakuNo(事前申請情報.get受領委任契約番号());
    }

    private void set支給申請情報(SikyuSinseiJyohoParameter 支給申請情報, ShokanShinsei 申請情報) {
        支給申請情報.setShikibetsuCode(new ShikibetsuCode("000000000000010"));
        支給申請情報.setHihokenshaNo(申請情報.get被保険者番号());
        支給申請情報.setShikyushinseiServiceYM(申請情報.getサービス提供年月());
        支給申請情報.setShikyushinseiSeiriNo(申請情報.get整理番号());
        支給申請情報.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(申請情報.get支払方法区分コード()));
        支給申請情報.setShiharaiBasho(申請情報.get支払場所());
        支給申請情報.setStartYMD(new RDate(申請情報.get支払期間開始年月日().toString()));
        支給申請情報.setEndYMD(new RDate(申請情報.get支払期間終了年月日().toString()));
        支給申請情報.setStartHHMM(new RTime(申請情報.get支払窓口開始時間()));
        支給申請情報.setEndHHMM(new RTime(申請情報.get支払窓口終了時間()));
        支給申請情報.setKozaId(申請情報.get口座ID());
        支給申請情報.setKeiyakuNo(申請情報.get受領委任契約番号());
    }

    private void 事前申請内容エリアを初期(ShokanJutakuKaishuJizenShinsei 償還事前申請情報) {
        div.getTxtTeikyoYM().setValue(new RDate(償還事前申請情報.getサービス提供年月().toString()));
        div.getTxtKyufuritsu().setValue(償還事前申請情報.get保険給付率().value());
        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setValue(償還事前申請情報.get住宅所有者());
        div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setValue(
                償還事前申請情報.get被保険者との関係());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalNow().setValue(
                new Decimal(償還事前申請情報.get給付額等_費用額合計()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoNow().setValue(
                new Decimal(償還事前申請情報.get給付額等_保険対象費用額()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountNow().setValue(
                new Decimal(償還事前申請情報.get給付額等_保険給付費額()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow().setValue(
                new Decimal(償還事前申請情報.get給付額等_利用者自己負担額()));
        List<RString> 限度額リセット = new ArrayList<>();
        if (償還事前申請情報.is要介護状態３段階変更()) {
            限度額リセット.add(要介護状態区分3段階変更による);
        }
        if (償還事前申請情報.is住宅住所変更()) {
            限度額リセット.add(住宅住所変更による);
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().setSelectedItemsByKey(限度額リセット);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().setValue(
                new RDate(償還事前申請情報.get申請年月日().toString()));
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setSelectedKey(
                ShinseishaKubun.toValue(償還事前申請情報.get申請者区分()).getコード());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().setValue(
                償還事前申請情報.get申請理由());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo().setValue(
                償還事前申請情報.get事業者番号().value());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                償還事前申請情報.get申請者氏名カナ());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setValue(
                償還事前申請情報.get申請者氏名());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDomain(
                償還事前申請情報.get申請者電話番号());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setValue(
                償還事前申請情報.get申請者郵便番号());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDomain(
                new AtenaJusho(償還事前申請情報.get申請者住所()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().setValue(
                new RDate(償還事前申請情報.get理由書作成日().toString()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setPlaceHolder(
                償還事前申請情報.get理由書作成者カナ());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setDomain(
                new AtenaMeisho(償還事前申請情報.get理由書作成者()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(
                償還事前申請情報.get理由書作成事業者番号().value());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setDomain(
                new AtenaMeisho(償還事前申請情報.get理由書作成事業者番号().value()));
    }

    private void 前回まで支払結果の初期化(ShiharaiKekkaResult 住宅改修費支払結果) {
        ShiharaiKekaEntity entity = 住宅改修費支払結果.getEntity();
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae().setValue(
                entity.get費用額合計());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae().setValue(
                entity.get保険対象費用額());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountMae().setValue(
                entity.get保険給付額());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae().setValue(
                entity.get利用者負担額());
    }

    private void 支給申請内容エリアを初期(ShokanShinsei 償還払支給申請情報) {
        div.getTxtTeikyoYM().setValue(new RDate(償還払支給申請情報.getサービス提供年月().toString()));
        div.getTxtSeiriNo().setValue(償還払支給申請情報.get整理番号());
        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setValue(償還払支給申請情報.get住宅所有者());
        div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setValue(
                償還払支給申請情報.get被保険者との関係());
        List<RString> 限度額リセット = new ArrayList<>();
        if (償還払支給申請情報.is要介護状態３段階変更()) {
            限度額リセット.add(要介護状態区分3段階変更による);
        }
        if (償還払支給申請情報.is住宅住所変更()) {
            限度額リセット.add(住宅住所変更による);
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().setSelectedItemsByKey(限度額リセット);
        div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().setValue(
                new RDate(償還払支給申請情報.get領収年月日().toString()));
        // TODO 証記載保険者番号
//        div.getJutakuKaishuShinseiContents().getDdlHokensha().setSelectedKey(償還払支給申請情報.get証記載保険者番号().value());
        List<RString> key = new ArrayList<>();
        key.add(new RString("0"));
        if (償還払支給申請情報.is国保連再送付フラグ()) {
            div.getJutakuKaishuShinseiContents().getChkKokubo().setSelectedItemsByKey(key);
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae().setValue(
                償還払支給申請情報.get支払金額合計());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae().setValue(
                償還払支給申請情報.get支払金額合計());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountMae().setValue(
                new Decimal(償還払支給申請情報.get保険給付額()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae().setValue(
                new Decimal(償還払支給申請情報.get利用者負担額()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalNow().setValue(
                償還払支給申請情報.get支払金額合計());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoNow().setValue(
                償還払支給申請情報.get保険対象費用額());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountNow().setValue(
                new Decimal(償還払支給申請情報.get保険給付額()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow().setValue(
                new Decimal(償還払支給申請情報.get利用者負担額()));
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo().setSelectedKey(
                償還払支給申請情報.get審査結果());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().setValue(
                new RDate(償還払支給申請情報.get申請年月日().toString()));
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setSelectedKey(
                ShinseishaKubun.toValue(償還払支給申請情報.get申請者区分()).getコード());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().setValue(
                償還払支給申請情報.get申請理由());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo().setValue(
                償還払支給申請情報.get申請事業者コード().value());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                償還払支給申請情報.get申請者氏名カナ());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setValue(
                償還払支給申請情報.get申請者氏名());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDomain(
                償還払支給申請情報.get申請者電話番号());
        RString 申請取消事由コード = 償還払支給申請情報.get住宅改修申請取消事由コード();
        RString 申請取消事由 = CodeMasterNoOption.getCodeRyakusho(
                new CodeShubetsu("0028"), new Code(申請取消事由コード));
        List<KeyValueDataSource> torikesuJiyu = new ArrayList<>();
        torikesuJiyu.add(new KeyValueDataSource(申請取消事由コード, 申請取消事由));
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDataSource(torikesuJiyu);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setSelectedKey(
                申請取消事由コード);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setValue(償還払支給申請情報.get申請者郵便番号());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDomain(
                new AtenaJusho(償還払支給申請情報.get申請者住所()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().setValue(
                new RDate(償還払支給申請情報.get理由書作成日().toString()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setPlaceHolder(
                償還払支給申請情報.get理由書作成者カナ());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setDomain(
                new AtenaMeisho(償還払支給申請情報.get理由書作成者()));
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(
                償還払支給申請情報.get理由書作成事業者番号().value());
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setDomain(
                new AtenaMeisho(償還払支給申請情報.get理由書作成事業者番号().value()));
    }

    // 8．保険者表示設定
    private void set保険者初期化(List<ShichosonResult> 保険者リスト) {
        List<KeyValueDataSource> 保険者ddl = new ArrayList<>();
        for (ShichosonResult 保険者 : 保険者リスト) {
            保険者ddl.add(new KeyValueDataSource(保険者.get証記載保険者番号().value(), 保険者.get市町村名称()));
        }
        div.getJutakuKaishuShinseiContents().getDdlHokensha().setDataSource(保険者ddl);
    }

    /**
     * 証明書表示設定するメソッドです。
     *
     * @param 住宅改修費支給申請 住宅改修費支給申請
     * @param 被保険者番号 被保険者番号
     * @param 画面モード 画面モード
     */
    public void 証明書表示設定(JutakukaishuSikyuShinseiManager 住宅改修費支給申請, HihokenshaNo 被保険者番号,
            RString 画面モード) {
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        FlexibleYearMonth 提供着工年月 = new FlexibleYearMonth(画面提供着工年月.getYearMonth().toDateString());
        List<ShikibetsuNoKanri> 様式名称 = 住宅改修費支給申請.getYoshikiName(提供着工年月);
        if (様式名称 == null) {
            throw new ApplicationException(
                    UrErrorMessages.存在しない.getMessage().replace(証明書様式内容_NULL.toString()));
        }
        set証明書DataSource(様式名称);
        RString 制度改正施行年月日 = DbBusinessConifg.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        if (画面提供着工年月.toDateString().compareTo(制度改正施行年月日) < 0) {
            set証明書値(証明書1);
        } else if (画面提供着工年月.toDateString().compareTo(制度改正施行年月日) >= 0) {
            JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
            YokaigoNinteiJyoho 要介護認定情報 = 住宅改修費事前申請.getYokaigoNinteiJyoho(被保険者番号, 提供着工年月);
            if (要支援1.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要支援2.equals(要介護認定情報.get要介護認定状態区分コード())) {
                set証明書値(証明書2);
            } else if (要支援_経過的要介護.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護1.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護2.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護3.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護4.equals(要介護認定情報.get要介護認定状態区分コード())
                    || 要介護5.equals(要介護認定情報.get要介護認定状態区分コード())) {
                div.getDdlSyomeisyo().setSelectedKey(証明書1);
                div.getDdlSyomeisyo().setDisabled(false);
                if (!画面モード_登録.equals(画面モード) && !画面モード_事前申請.equals(画面モード)) {
                    div.getDdlSyomeisyo().setDisabled(true);
                }
            } else {
                set証明書値(証明書1);
            }
        }
    }

    private void set証明書値(RString 証明書) {
        div.getDdlSyomeisyo().setSelectedKey(証明書);
        div.getDdlSyomeisyo().setDisabled(true);
    }

    private void set証明書DataSource(List<ShikibetsuNoKanri> 様式名称) {
        List<KeyValueDataSource> 証明書ddl = new ArrayList<>();
        if (様式名称 != null && !様式名称.isEmpty()) {
            for (ShikibetsuNoKanri 識別番号 : 様式名称) {
                証明書ddl.add(new KeyValueDataSource(識別番号.get識別番号(), 識別番号.get名称()));
            }
        }
        div.getDdlSyomeisyo().setDataSource(証明書ddl);
    }

    /**
     * 申請内容の保存するメソッドです。
     *
     * @param 引き継ぎデータEntity 引き継ぎデータEntity
     */
    public void save(ShokanharaKeteiJyohoParameter 引き継ぎデータEntity) {
        RString 画面モード = 引き継ぎデータEntity.get画面モード();
        HihokenshaNo 引き継ぎ被保険者番号 = 引き継ぎデータEntity.get被保険者番号();
        FlexibleYearMonth 引き継ぎサービス提供年月 = 引き継ぎデータEntity.getサービス提供年月();
        RString 引き継ぎ整理番号 = 引き継ぎデータEntity.get整理番号();
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString());
        RString 整理番号 = div.getTxtSeiriNo().getValue();
        RString 保険者 = div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey();
        FlexibleDate 受付年月日 = FlexibleDate.getNowDate();
        RDate 申請年月日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue();
        RString 申請理由 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue();
        RString 申請者区分 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun()
                .getSelectedKey();
        RString 申請者氏名 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().getValue();
        RString 申請者氏名カナ = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana()
                .getValue();
        YubinNo 申請者郵便番号 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().getValue();
        AtenaJusho 申請者住所 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain();
        TelNo 申請者電話番号 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().getDomain();
        RString 申請事業者番号 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo()
                .getValue();
        RDate 理由書作成日 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD()
                .getValue();
        AtenaMeisho 理由書作成者 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorName().getDomain();
        RString 理由書作成者カナ = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorKanaName().getPlaceHolder();
        RString 理由書作成事業者番号 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreationJigyoshaNo().getValue();
        Decimal 支払金額合計 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalNow().getValue();
        Decimal 保険対象費用額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenTaishoHiyoNow().getValue();
        Decimal 保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenKyufuAmountNow().getValue();
        Decimal 利用者負担額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtRiyoshaFutanAmountNow().getValue();
//        審査方法区分 TODO
        boolean 国保連再送付フラグ = false;
        RString 送付区分 = null;
        FlexibleYearMonth 送付年月 = null;
        if (div.getJutakuKaishuShinseiContents().getChkKokubo().isVisible()) {
            List<KeyValueDataSource> 国保連再送付チェックON = div.getJutakuKaishuShinseiContents().getChkKokubo()
                    .getSelectedItems();
            if (!国保連再送付チェックON.isEmpty()) {
                送付区分 = 送付区分_送付済;
                送付年月 = new FlexibleYearMonth(FlexibleDate.getNowDate().getYearMonth().toDateString());
                国保連再送付フラグ = true;
            }
        }
        RString 住宅所有者 = div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue();
        RString 被保険者の関係 = div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue();
//        if (画面モード_事前申請.equals(画面モード)) {
//            FlexibleYearMonth 事前申請サービス提供年月 = サービス提供年月;
//            RString 事前申請整理番号 = 整理番号;
//        }
        RString 住宅改修申請区分 = JutakukaishuShinseiKubun.支給申請.getCode();
        FlexibleDate 領収年月日 = new FlexibleDate(
                div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue().toString());
// 支払方法区分コード
//        div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho()
        RString 証明書 = div.getDdlSyomeisyo().getSelectedKey();
        HokenKyufuRitsu 給付率 = new HokenKyufuRitsu(div.getTxtKyufuritsu().getValue());
        List<KeyValueDataSource> 限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedItems();
        boolean 要介護状態区分3段階変更 = false;
        boolean 住宅住所変更 = false;
        for (KeyValueDataSource 限度額 : 限度額リセット) {
            if (要介護状態区分3段階変更による.equals(限度額.getKey())) {
                要介護状態区分3段階変更 = true;
                break;
            } else if (住宅住所変更による.equals(限度額.getKey())) {
                住宅住所変更 = true;
                break;
            }
        }
        RString 審査結果 = div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo()
                .getSelectedKey();

        RString 支給不支給決定区分 = null;
        if (審査結果_承認する.equals(審査結果)) {
            支給不支給決定区分 = ShikyuFushikyuKubun.支給.getコード();
        } else if (審査結果_承認する.equals(審査結果)) {
            支給不支給決定区分 = ShikyuFushikyuKubun.不支給.getコード();

        }
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        ShokanHanteiKekka 償還払支給判定結果 = ViewStateHolder.get(ViewStateKeys.償還払支給判定結果,
                ShokanHanteiKekka.class);

        if (画面モード_登録.equals(画面モード)
                || 画面モード_事前申請.equals(画面モード)) {
            RString 理由書作成日DB = 理由書作成日 == null ? null : 理由書作成日.toDateString();
            int 保険給付額DB = 保険給付額 == null ? null : 保険給付額.intValue();
            int 利用者負担額DB = 利用者負担額 == null ? null : 利用者負担額.intValue();
            ShokanShinsei dbt3034 = new ShokanShinsei(引き継ぎ被保険者番号, サービス提供年月, 整理番号);
            dbt3034 = dbt3034.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(保険者))
                    .set受付年月日(受付年月日).set申請年月日(new FlexibleDate(申請年月日.toString()))
                    .set申請理由(申請理由).set申請者区分(申請者区分).set申請者氏名(申請者氏名)
                    .set申請者氏名カナ(申請者氏名カナ).set申請者郵便番号(申請者郵便番号)
                    .set申請者住所(申請者住所.value()).set申請者電話番号(申請者電話番号).set申請事業者番号(
                            new JigyoshaNo(申請事業者番号)).set理由書作成日(new FlexibleDate(理由書作成日DB))
                    .set理由書作成者(理由書作成者カナ).set理由書作成者カナ(理由書作成者カナ).set理由書作成事業者番号(
                            new JigyoshaNo(理由書作成事業者番号)).set支払金額合計(支払金額合計)
                    .set保険対象費用額(保険対象費用額).set保険給付額(保険給付額DB).
                    set利用者負担額(利用者負担額DB).set支給申請審査区分(null).set送付区分(送付区分)
                    .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(住宅所有者)
                    .set被保険者の関係(被保険者の関係).set要介護状態３段階変更(要介護状態区分3段階変更)
                    .set住宅住所変更(住宅住所変更).set審査年月日(null).set審査結果(null).set住宅改修申請区分(
                            住宅改修申請区分).set住宅改修申請取消事由コード(null).set領収年月日(領収年月日).build();
            if (画面モード_事前申請.equals(画面モード)) {
                dbt3034 = dbt3034.createBuilderForEdit().set事前申請サービス提供年月(サービス提供年月)
                        .set事前申請整理番号(整理番号).build();
            }
            ShokanKihon dbt3038 = new ShokanKihon(引き継ぎ被保険者番号, サービス提供年月, 整理番号, 償還払請求基本_事業者番号,
                    証明書, 償還払請求基本_明細番号);
            dbt3038 = dbt3038.createBuilderForEdit().set保険給付率(給付率).setサービス単位数(支払金額合計.intValue())
                    .set保険請求額(保険給付額).set利用者負担額(利用者負担額.intValue()).build();
            ShokanShukei dbt3053 = new ShokanShukei(引き継ぎ被保険者番号, サービス提供年月, 整理番号, 償還払請求基本_事業者番号,
                    証明書, 償還払請求基本_明細番号, new RString("01"));
            JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
            ServiceShuruiCode サービス種類コード = 住宅改修費事前申請.getServiceShuruiCode(引き継ぎ被保険者番号, サービス提供年月);
            dbt3053 = dbt3053.createBuilderForEdit().setサービス種類コード(サービス種類コード)
                    .set請求額(保険給付額).set利用者負担額(利用者負担額.intValue()).build();
            ShokanJutakuKaishu dbt3049 = new ShokanJutakuKaishu(引き継ぎ被保険者番号, サービス提供年月, 整理番号,
                    償還払請求基本_事業者番号, 証明書, 償還払請求基本_明細番号, new RString("01"));
            dbt3049 = dbt3049.createBuilderForEdit().setサービスコード(
                    new ServiceCode(サービス種類コード.value().concat("0000"))).
                    set事前申請サービス提供年月(サービス提供年月).set事前申請整理番号(整理番号).build();
            // TODO 住宅改修内容リストを子DIVから取得が不明
            List<ShokanJutakuKaishu> dbt3049List = new ArrayList<>();
            dbt3049List.add(dbt3049);
            住宅改修費支給申請.saveDBDate(dbt3034, dbt3038, dbt3053, dbt3049List);
        } else if (画面モード_削除.equals(画面モード)) {
            List<ShokanJutakuKaishu> dbt3049List = new ArrayList<>();
            ShokanShinsei dbt3034 = new ShokanShinsei(引き継ぎ被保険者番号, 引き継ぎサービス提供年月, 引き継ぎ整理番号);
            住宅改修費支給申請.delDBDate(引き継ぎ被保険者番号, 引き継ぎサービス提供年月,
                    引き継ぎ整理番号, new FlexibleDate(申請年月日.toString()),
                    引き継ぎデータEntity.get識別コード(), new HokenshaNo(
                            div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()), dbt3049List,
                    null, dbt3034, null, (償還払支給判定結果 == null ? null : 償還払支給判定結果));
        } else if (画面モード_修正.equals(画面モード)
                || 画面モード_審査.equals(画面モード)
                || 画面モード_取消.equals(画面モード)) {
            ShokanShinsei dbt3034 = new ShokanShinsei(引き継ぎ被保険者番号, 引き継ぎサービス提供年月, 引き継ぎ整理番号);
            ShokanKihon dbt3038 = null;
            ShokanShukei dbt3053 = null;
            if (画面モード_修正.equals(画面モード)) {
                dbt3034 = dbt3034.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(保険者))
                        .set申請年月日(new FlexibleDate(申請年月日.toString()))
                        .set申請理由(申請理由).set申請者区分(申請者区分).set申請者氏名(申請者氏名)
                        .set申請者氏名カナ(申請者氏名カナ).set申請者郵便番号(申請者郵便番号)
                        .set申請者住所(申請者住所.value()).set申請者電話番号(申請者電話番号).set申請事業者番号(
                                new JigyoshaNo(申請事業者番号)).set理由書作成日(new FlexibleDate(理由書作成日.toString()))
                        .set理由書作成者(理由書作成者カナ).set理由書作成者カナ(理由書作成者カナ).set理由書作成事業者番号(
                                new JigyoshaNo(理由書作成事業者番号)).set支払金額合計(支払金額合計)
                        .set保険対象費用額(保険対象費用額).set保険給付額(保険給付額.intValue()).
                        set利用者負担額(利用者負担額.intValue())
                        .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(住宅所有者)
                        .set被保険者の関係(被保険者の関係).set要介護状態３段階変更(要介護状態区分3段階変更)
                        .set住宅住所変更(住宅住所変更).set領収年月日(領収年月日).build();
                dbt3038 = new ShokanKihon(引き継ぎ被保険者番号, サービス提供年月, 整理番号,
                        償還払請求基本_事業者番号, 証明書, 償還払請求基本_明細番号);
                dbt3038 = dbt3038.createBuilderForEdit().set保険給付率(給付率).setサービス単位数(支払金額合計.intValue())
                        .set保険請求額(保険給付額).set利用者負担額(利用者負担額.intValue()).build();
                dbt3053 = new ShokanShukei(引き継ぎ被保険者番号, サービス提供年月, 整理番号, 償還払請求基本_事業者番号,
                        証明書, 償還払請求基本_明細番号, new RString("01"));
                dbt3053.createBuilderForEdit().set請求額(保険給付額).set利用者負担額(利用者負担額.intValue()).build();
            } else if (画面モード_審査.equals(画面モード)) {
                dbt3034 = dbt3034.createBuilderForEdit().set証記載保険者番号(new ShoKisaiHokenshaNo(保険者))
                        .set申請年月日(new FlexibleDate(申請年月日.toString()))
                        .set申請理由(申請理由).set申請者区分(申請者区分).set申請者氏名(申請者氏名)
                        .set申請者氏名カナ(申請者氏名カナ).set申請者郵便番号(申請者郵便番号)
                        .set申請者住所(申請者住所.value()).set申請者電話番号(申請者電話番号).set申請事業者番号(
                                new JigyoshaNo(申請事業者番号))
                        .set支給申請審査区分(ShikyushinseiShinsaKubun.審査済.getコード())
                        .set理由書作成日(new FlexibleDate(理由書作成日.toString()))
                        .set理由書作成者(理由書作成者カナ).set理由書作成者カナ(理由書作成者カナ).set理由書作成事業者番号(
                                new JigyoshaNo(理由書作成事業者番号))
                        .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(住宅所有者)
                        .set被保険者の関係(被保険者の関係).set要介護状態３段階変更(要介護状態区分3段階変更)
                        .set住宅住所変更(住宅住所変更).set審査年月日(FlexibleDate.getNowDate())
                        .set審査結果(審査結果).build();
                dbt3038 = new ShokanKihon(引き継ぎ被保険者番号, サービス提供年月, 整理番号,
                        償還払請求基本_事業者番号, 証明書, 償還払請求基本_明細番号);
                dbt3038 = dbt3038.createBuilderForEdit().set保険給付率(給付率).build();
                dbt3053 = new ShokanShukei(引き継ぎ被保険者番号, サービス提供年月, 整理番号, 償還払請求基本_事業者番号,
                        証明書, 償還払請求基本_明細番号, new RString("01"));
                dbt3053 = dbt3053.createBuilderForEdit().set請求額(保険給付額).set利用者負担額(利用者負担額.intValue())
                        .set審査年月(new FlexibleYearMonth(
                                        FlexibleDate.getNowDate().getYearMonth().toDateString()))
                        .set支給区分コード(支給不支給決定区分).build();
            } else if (画面モード_取消.equals(画面モード)) {
                dbt3034 = dbt3034.createBuilderForEdit().set住宅改修申請区分(JutakukaishuShinseiKubun.取消.getCode())
                        .build();
            }
            if (償還払支給判定結果 != null) {
                償還払支給判定結果 = 償還払支給判定結果.createBuilderForEdit().set決定年月日(FlexibleDate.getNowDate())
                        .set支給_不支給決定区分(支給不支給決定区分).set支払金額(保険給付額).build();
            }
            住宅改修費支給申請.updDBDate(引き継ぎ被保険者番号, 引き継ぎサービス提供年月,
                    引き継ぎ整理番号, 画面モード, 引き継ぎデータEntity.get識別コード(),
                    new HokenshaNo(div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()),
                    dbt3034, dbt3038, null, dbt3053, (償還払支給判定結果 == null ? null : 償還払支給判定結果));
        }
    }

    /**
     * 償還払決定情報画面へ遷移、パラメータ設定するメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 画面モード 画面モード
     */
    public void set画面遷移パラメータ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RString 画面モード) {
        ShokanharaKeteiJyohoParameter 償還払決定情報 = new ShokanharaKeteiJyohoParameter();
        償還払決定情報.set識別コード(識別コード);
        償還払決定情報.set被保険者番号(被保険者番号);
        償還払決定情報.setサービス提供年月(new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()));
        償還払決定情報.set整理番号(div.getTxtSeiriNo().getValue());
        償還払決定情報.set証明書(div.getDdlSyomeisyo().getSelectedKey());
        償還払決定情報.set給付率(div.getTxtKyufuritsu().getValue());
        償還払決定情報.set画面モード(画面モード);
        ViewStateHolder.put(ViewStateKeys.検索情報キー, 償還払決定情報);
    }

    private Map<RString, RString> get更新前データ() {
        return 画面データ取得();
    }

    private Map<RString, RString> 画面データ取得() {
        Map<RString, RString> 画面データ = new HashMap<>();
        RDate 提供着工年月 = div.getTxtTeikyoYM().getValue();
        画面データ.put(new RString("txtTeikyoYM"), 提供着工年月 == null ? null : 提供着工年月.toDateString());
        画面データ.put(new RString("ddlSyomeisyo"), div.getDdlSyomeisyo().getSelectedKey());
        画面データ.put(new RString("txtJutakuOwner"),
                div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue());
        画面データ.put(new RString("txtRelationWithHihokensha"),
                div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue());
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        画面データ.put(new RString("txtRyoshuYMD"),
                領収日 == null ? null : 領収日.toDateString());
        画面データ.put(new RString("ddlHokensha"),
                div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey());
        List<RString> 国保連再送付 = div.getJutakuKaishuShinseiContents().getChkKokubo().getSelectedKeys();
        画面データ.put(new RString("chkKokubo"),
                国保連再送付.isEmpty() ? null : 国保連再送付.get(0));
        画面データ.put(new RString("radShinseiNaiyoyo"),
                div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo().getSelectedKey());
        RDate 申請日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue();
        画面データ.put(new RString("txtShinseiYMD"),
                申請日 == null ? null : 申請日.toDateString());
        画面データ.put(new RString("ddlShinseishaKubun"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        画面データ.put(new RString("txtShinseiRiyu"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue());
        画面データ.put(new RString("txtShinseishaNameKana"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().getValue());
        画面データ.put(new RString("txtShinseishaName"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().getValue());
        画面データ.put(new RString("txtTelNo"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().getDomain().value());
        画面データ.put(new RString("ddlShinseiTorikesuJiyu"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        画面データ.put(new RString("txtYubinNo"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().getValue().value());
        画面データ.put(new RString("txtAddress"),
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain().value());
        RDate 作成日 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().getValue();
        画面データ.put(new RString("txtCreateYMD"),
                作成日 == null ? null : 作成日.toDateString());
        画面データ.put(new RString("txtCreatorKanaName"),
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().getPlaceHolder());
        画面データ.put(new RString("txtCreatorName"),
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().getDomain().value());
        画面データ.put(new RString("txtCreationJigyoshaNo"),
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().getValue());
        return 画面データ;
    }

    private Map<RString, RString> get画面データ() {
        return 画面データ取得();
    }

    /**
     * 画面のデータが変更されているがないかの判断
     *
     * @return (true:画面データが変更される ; false:画面データが変更されない)
     */
    public boolean is画面データが変更() {
        Map<RString, RString> 更新前データmap = ViewStateHolder.get(ViewStateKeys.申請情報登録_更新前データ, Map.class);
        Map<RString, RString> 画面データmap = get画面データ();
        for (Entry<RString, RString> entry : 更新前データmap.entrySet()) {
            RString 更新前データkey = entry.getKey();
            for (Entry<RString, RString> entry1 : 画面データmap.entrySet()) {
                RString 画面データkey = entry1.getKey();
                if (更新前データkey.equals(画面データkey)) {
                    if ((entry.getValue() == null && entry1.getValue() != null)
                            || (entry.getValue() != null && entry1.getValue() == null)
                            || (!entry.getValue().equals(entry1.getValue()))) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 住宅改修内容のチェックするメソッドです。
     */
//    public void 住宅改修内容のチェック() {
//        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
//        RYearMonth 申請日年月 = div.getJutakuKaishuShinseiContents().getShinseishaInfo()
//                .getTxtShinseiYMD().getValue().getYearMonth();
//        if (画面提供着工年月 == null) {
//            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(提供着工年月MSG.toString()));
//        }
//        // ６．２　TODO　Interfaceが未提供
//        // ６．３　提供（着工）年月と申請日のチェック
//        RString 償還 = BusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, SubGyomuCode.DBC介護給付);
//        if (給付実績連動_受託なし.equals(償還)) {
//            if (!画面提供着工年月.getYearMonth().equals(申請日年月)) {
//                // TODO
//                throw new ApplicationException(DbcErrorMessages.サービス年月と不一致.getMessage());
//            }
//        }
//    }
    /**
     * 費用額合計の取得するメソッドです。
     */
    public Decimal 費用額合計の取得() {
// TODO 「住宅改修内容一覧」共有子DIVのグリッドのレコード
        return Decimal.ONE;
    }

    /**
     * 限度額リセット有効性チェックするメソッドです。
     */
    public void 支払結果の設定() {
        ShikyuShiseiJyohoParameter 引き継ぎデータEntity = new ShikyuShiseiJyohoParameter();
        引き継ぎデータEntity.set被保険者番号(new RString("000000003"));
        HihokenshaNo 被保険者番号 = new HihokenshaNo(引き継ぎデータEntity.get被保険者番号());
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toString());
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        Decimal 支給限度額 = 住宅改修費事前申請.getShikyuGendoGaku(被保険者番号, 画面提供着工年月);
        // 5．２　今回の支払結果を設定する
        // 5．２．１　両方をチェックしない場合
        Decimal 費用額合計 = this.費用額合計の取得();
        Decimal 前回までの費用額合計 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalMae().getValue();
        Decimal 前回までの被保険対象額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenTaishoHiyoMae().getValue();
        Decimal 前回までの保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenKyufuAmountMae().getValue();
        Decimal 今回の被保険対象額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenTaishoHiyoNow().getValue();
//            Decimal 今回の保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
//                    .getTxtHokenKyufuAmountNow().getValue();
        Decimal 今回の利用者負担額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtRiyoshaFutanAmountNow().getValue();
        Decimal 給付率 = div.getTxtKyufuritsu().getValue();
        if (!div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().isAllSelected()) {
            // ①
            if (費用額合計.add(前回までの費用額合計).compareTo(支給限度額) > 0) {
                Decimal 今回被保険対象額 = 支給限度額.subtract(前回までの被保険対象額);
                // 1
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(今回被保険対象額);
                if (今回被保険対象額.compareTo(Decimal.ONE) > 0) {
                    Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(100).subtract(前回までの保険給付額);
                    // 2
                    div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                } else if (Decimal.ZERO.equals(今回被保険対象額)) {
                    // 3
                    div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenKyufuAmountNow().setValue(Decimal.ZERO);
                }
                // 4
                Decimal 今回の保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                        .setValue(費用額合計.subtract(今回の保険給付額));
                // ②
            } else if (費用額合計.add(前回までの費用額合計).compareTo(支給限度額) <= 0) {
                // 1
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(費用額合計);
                // 2
                Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(100);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                // 3
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                        .setValue(費用額合計.subtract(今回保険給付額));
            }
            // 5．１．２　その以外の場合
        } else {
            // ①
            if (費用額合計.compareTo(支給限度額) > 0) {
                // 1
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(支給限度額);
                // 2
                Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(100);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                // 3
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                        .setValue(費用額合計.subtract(今回保険給付額));
            } else if (費用額合計.compareTo(支給限度額) <= 0) {
                // ②
                // 1
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(費用額合計);
                // 2
                Decimal 今回の保険給付額 = 今回の被保険対象額.multiply(給付率).divide(100);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                // 3
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                        .setValue(費用額合計.subtract(今回保険給付額));
            }
        }
    }

    /**
     * 限度額チェックするメソッドです。
     *
     * @return (OK：限度額を超えない、NG:限度額を超える)
     */
    public boolean is限度額を超えない() {
        ShikyuShiseiJyohoParameter 引き継ぎデータEntity = new ShikyuShiseiJyohoParameter();
        引き継ぎデータEntity.set被保険者番号(new RString("000000003"));
        RString 整理番号 = new RString("0000000003");
        HihokenshaNo 被保険者番号 = new HihokenshaNo(引き継ぎデータEntity.get被保険者番号());
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toString());
        Decimal 今回の保険対象費用額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalNow().getValue();
        boolean 限度リセットフラグ = true;
        if (div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys().isEmpty()) {
            限度リセットフラグ = false;
        }
        JutakuKaishuShikyuGendogakuHantei 支給限度額判定 = new JutakuKaishuShikyuGendogakuHantei();
        return 支給限度額判定.checkJutakukaishuShikyuGendogaku(
                被保険者番号, 画面提供着工年月, 整理番号, 限度リセットフラグ, 今回の保険対象費用額);
    }

    /**
     * 確認対象変更有無チェックするメソッドです。
     *
     * @return (true;変更有、false:変更無)
     */
    public boolean is確認対象変更有無チェック(JutakuGaisuDataParameter 住宅改修データ) {
        RString 住宅改修データdgList = 住宅改修データ.get住宅改修データ();
        List<RString> 限度額リセット = 住宅改修データ.get限度額リセット();
        List<RString> 画面限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys();
        if (限度額リセット.size() != 画面限度額リセット.size()) {
            return true;
        }
        return false;
    }

    /**
     * 本人情報をコピーするメソッドです。
     */
    public void set本人情報() {
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDomain(
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get住所());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名カナ());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setValue(
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get氏名漢字());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setValue(
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().get郵便番号());
    }
}
