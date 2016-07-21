/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKihon;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihonBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinseiBuilder;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukeiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei.ShichosonResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinsei.JyutakuGaisyunaiyoListParameter;
import jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListDataPassModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu.JutakukaishuShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun.KyufuJissekiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa.ShikyushinseiShinsaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuDataParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuListDataParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.JutakuGaisuViewStateHolderParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710021.ShokanharaKeteiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.service.core.fukushiyogukonyuhishikyushisei.FukushiyoguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakuKaishuShikyuGendogakuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakukaishuSikyuShinseiManager;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修費支給申請_申請情報登録ハンドラークラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public final class JutakuKaishuShinseiJyohoTorokuHandler {

    private final JutakuKaishuShinseiJyohoTorokuDiv div;
    private static final RString 画面モード_登録 = new RString("登録モード");
    private static final RString 画面モード_事前申請 = new RString("事前申請登録モード");
    private static final RString 画面モード_修正 = new RString("修正モード");
    private static final RString 画面モード_審査 = new RString("審査モード");
    private static final RString 画面モード_照会 = new RString("照会モード");
    private static final RString 画面モード_削除 = new RString("削除モード");
    private static final RString 画面モード_取消 = new RString("取消モード");
    private static final RString 支払方法状態_修正 = new RString("修正");
    private static final RString 支払方法状態_登録 = new RString("登録");
    private static final RString 支払方法状態_照会 = new RString("照会");
    private static final RString 給付実績連動_受託なし = new RString("1");
    private static final RString 給付実績緋連動_受託あり = new RString("2");
    private static final RString 要介護状態区分3段階変更による = new RString("threeUp");
    private static final RString 住宅住所変更による = new RString("changeAddress");
    private static final Code 要支援1 = new Code("12");
    private static final Code 要支援2 = new Code("13");
    private static final Code 要支援_経過的要介護 = new Code("11");
    private static final Code 要介護1 = new Code("21");
    private static final Code 要介護2 = new Code("22");
    private static final Code 要介護3 = new Code("23");
    private static final Code 要介護4 = new Code("24");
    private static final Code 要介護5 = new Code("25");
    private static final RString 証明書1 = new RString("21D1");
    private static final RString 証明書2 = new RString("21D2");
    private static final RString 送付区分_送付済 = new RString("1");
    private static final RString 償還払請求基本_明細番号 = new RString("0001");
    private static final RString 審査結果_承認する = new RString("1");
    private static final RString 審査結果_却下する = new RString("2");
    private static final RString 証明書様式内容_NULL = new RString("証明書様式内容");
    private static final JigyoshaNo 償還払請求基本_事業者番号 = new JigyoshaNo("0000000000");
    private static final RString 申請者区分_空 = new RString("0");
    private static final RString 申請取消事由_空 = new RString("0");
    private static final RString 連番_固定値 = new RString("01");
    private static final RString コロン = new RString(":");
    private static final int 被除数 = 100;
    private static final RString 改修状態_登録 = new RString("toroku");
    private static final RString 改修状態_参照 = new RString("sansyo");
    private static final RString 支払方法情報_窓口 = new RString("1");
    private static final RString 支払方法情報_口座 = new RString("2");
    private static final RString 支払方法情報_受領委任 = new RString("3");
    private static final RString コード種別 = new RString("0028");
    private static final RString 受領委任契約番号_キー = new RString("shiharaiKeiyakuNo");
    private static final RString 口座_キー = new RString("shiharaiKozaNo");
    private static final RString 支払窓口終了時間_キー = new RString("shiharaiEndHHMM");
    private static final RString 支払窓口開始時間_キー = new RString("shiharaiStartHHMM");
    private static final RString 支払期間終了年月日_キー = new RString("shiharaiEndYMD");
    private static final RString 支払期間開始年月日_キー = new RString("shiharaiStartYMD");
    private static final RString 支払場所_キー = new RString("shiharaibasho");
    private static final RString 支払方法_キー = new RString("shiharaijyoho");
    private static final RString 作成事業者_キー = new RString("txtCreationJigyoshaNo");
    private static final RString 作成者氏名_キー = new RString("txtCreatorName");
    private static final RString 作成者氏名から_キー = new RString("txtCreatorKanaName");
    private static final RString 作成日_キー = new RString("txtCreateYMD");
    private static final RString 住所_キー = new RString("txtAddress");
    private static final RString 郵便番号_キー = new RString("txtYubinNo");
    private static final RString 申請取消事由_キー = new RString("ddlShinseiTorikesuJiyu");
    private static final RString 電話番号_キー = new RString("txtTelNo");
    private static final RString 氏名_キー = new RString("txtShinseishaName");
    private static final RString 氏名から_キー = new RString("txtShinseishaNameKana");
    private static final RString 申請理由_キー = new RString("txtShinseiRiyu");
    private static final RString 申請者区分_キー = new RString("ddlShinseishaKubun");
    private static final RString 申請日_キー = new RString("txtShinseiYMD");
    private static final RString 申請内容_キー = new RString("radShinseiNaiyoyo");
    private static final RString 住宅住所変更_キー = new RString("changeAddress");
    private static final RString 要介護状態区分3段階変更_キー = new RString("threeUp");
    private static final RString 限度額リセットサイズ_キー = new RString("resetInfoSize");
    private static final RString 国保連再送付_キー = new RString("chkKokubo");
    private static final RString 保険者_キー = new RString("ddlHokensha");
    private static final RString 領収日_キー = new RString("txtRyoshuYMD");
    private static final RString 被保険者との関係_キー = new RString("txtRelationWithHihokensha");
    private static final RString 住宅所有者_キー = new RString("txtJutakuOwner");
    private static final RString 証明書_キー = new RString("ddlSyomeisyo");
    private static final RString 提供着工年月_キー = new RString("txtTeikyoYM");
    private static final RString サービス種類コード固定 = new RString("0000");
    private static final RString 連番から = new RString("01");
    private static final RString 国保連再送付_チェック = new RString("0");
    private static final RString 行状態_削除 = new RString("削除");
    private static final RString 行状態_更新 = new RString("更新");
    private static final RString 行状態_更新なし = RString.EMPTY;
    private static final RString FORMAT = new RString("%02d");
    private static final RString 住宅改修_状態 = new RString("Unchanged");
    private static final RString 申請を保存ボタン = new RString("btnAddShikyuShinsei");
    private static final FlexibleYearMonth 平成21年03月 = new FlexibleYearMonth(new RString("200903"));

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
     * @param param JutakuGaisuViewStateHolderParameter
     */
    public void onLoad(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号, RString 画面モード, JutakuGaisuViewStateHolderParameter param) {
        RString 償還 = DbBusinessConfig.get(
                ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(), SubGyomuCode.DBC介護給付);

        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();

        FukushiyoguKonyuhiShikyuShinsei 保険者 = FukushiyoguKonyuhiShikyuShinsei.createInstance();
        if (サービス提供年月 != null) {
            List<ShichosonResult> 保険者リスト = 保険者.getHokensyaList(被保険者番号, サービス提供年月);
            set保険者初期化(保険者リスト);
        }
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        set費用額合計など入力不可();
        set申請者区分DataSource();
        set国保連再送付表示非表示(償還);
        if (画面モード_登録.equals(画面モード)) {
            登録モード画面初期化(識別コード, 住宅改修費事前申請, 被保険者番号, 住宅改修費支給申請, 画面モード, 保険者, param);
        } else if (画面モード_事前申請.equals(画面モード)) {
            事前申請モード画面初期化(住宅改修費事前申請, 被保険者番号, サービス提供年月, 整理番号, 識別コード,
                    住宅改修費支給申請, 画面モード, param);
        } else if (画面モード_修正.equals(画面モード) || 画面モード_審査.equals(画面モード)
                || 画面モード_照会.equals(画面モード) || 画面モード_削除.equals(画面モード)
                || 画面モード_取消.equals(画面モード)) {
            修正モードなど画面初期化(住宅改修費支給申請, 被保険者番号, サービス提供年月, 整理番号, 画面モード,
                    住宅改修費事前申請, 識別コード, 償還, param);
        }
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        JutakuGaisuDataParameter 住宅改修データ = new JutakuGaisuDataParameter();
        住宅改修データ.set住宅改修データ(get住宅改修内容一覧データ(gridList));
        List<RString> 画面限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys();
        住宅改修データ.set限度額リセット(画面限度額リセット);
        param.set住宅改修データ(住宅改修データ);
    }

    private void 修正モードなど画面初期化(JutakukaishuSikyuShinseiManager 住宅改修費支給申請,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 画面モード,
            JutakuKaishuJizenShinsei 住宅改修費事前申請, ShikibetsuCode 識別コード, RString 償還,
            JutakuGaisuViewStateHolderParameter param) {
        if (画面モード_照会.equals(画面モード)) {
            RString date = param.get償還払申請一覧_サービス年月();
            サービス提供年月 = new FlexibleYearMonth(new RDate(date.toString()).getYearMonth().toDateString());
            被保険者番号 = param.get償還払申請一覧_被保険者番号();
            整理番号 = param.get償還払申請一覧_整理番号();
            FukushiyoguKonyuhiShikyuShinsei 保険者 = FukushiyoguKonyuhiShikyuShinsei.createInstance();
            List<ShichosonResult> 保険者リスト = 保険者.getHokensyaList(被保険者番号, サービス提供年月);
            set保険者初期化(保険者リスト);
        }
        div.getTxtTeikyoYM().setDisabled(true);
        ShokanShinsei 償還払支給申請情報 = 住宅改修費支給申請.getShokanKihonShinsei(
                被保険者番号, サービス提供年月, 整理番号);
        if (償還払支給申請情報 == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        param.set償還払支給申請情報(償還払支給申請情報);
        支給申請内容エリアを初期(償還払支給申請情報);
        ShokanKihon 償還払請求基本 = 住宅改修費支給申請.getShokanKihon(被保険者番号, サービス提供年月, 整理番号);
        if (償還払請求基本 == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        param.set償還払請求基本(償還払請求基本);
        修正モードなど給付率初期化(償還払請求基本);

        証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, false);
        div.getDdlSyomeisyo().setSelectedKey(償還払請求基本.get様式番号());
        ShokanShukei 償還払請求集計 = 住宅改修費支給申請.getShokanSyukei(償還払請求基本.get被保険者番号(),
                償還払請求基本.getサービス提供年月(), 償還払請求基本.get整理番号(), 償還払請求基本.get事業者番号(),
                償還払請求基本.get様式番号(), 償還払請求基本.get明細番号());
        if (償還払請求集計 == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        param.set償還払請求集計(償還払請求集計);
        JyutakugaisyunaiyoListDataPassModel model = new JyutakugaisyunaiyoListDataPassModel();
        model.set被保険者番号(被保険者番号);
        model.setサービス提供年月(サービス提供年月);
        model.set状態(改修状態_参照);
        if (画面モード_審査.equals(画面モード) || 画面モード_修正.equals(画面モード)) {
            model.set状態(改修状態_登録);
        }
        model.set様式番号(償還払請求基本.get様式番号());
        model.set整理番号(整理番号);
        model.set識別コード(識別コード);
        div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().initialize(model);
        ShiharaiKekkaResult 過去住宅改修費支払結果 = 住宅改修費事前申請.getOldJutakuKaishuHi(
                被保険者番号, サービス提供年月, 整理番号);
        param.set過去住宅改修費支払結果(過去住宅改修費支払結果);
        前回まで支払結果の初期化(過去住宅改修費支払結果, false, 被保険者番号);
        SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
        set支給申請情報(支給申請情報, 償還払支給申請情報, 識別コード);
        ShokanHanteiKekka 償還払支給判定結果 = 住宅改修費支給申請.getShokanHanteiKekka(償還払請求基本.get被保険者番号(),
                償還払請求基本.getサービス提供年月(), 償還払請求基本.get整理番号());
        param.set償還払支給判定結果(償還払支給判定結果);
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(true);
        if (画面モード_削除.equals(画面モード)) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getBtnRireki().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_照会);
            div.getCommHeadPanel().getTxtTeikyoYM().setDisabled(true);
            div.getCommHeadPanel().getDdlSyomeisyo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getDdlHokensha().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().setDisabled(true);
            if (給付実績緋連動_受託あり.equals(償還)) {
                div.getJutakuKaishuShinseiContents().getChkKokubo().setDisabled(true);
            }
        }
        if (画面モード_取消.equals(画面モード)) {
            div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getDdlHokensha().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getBtnJigyosha().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getBtnHonninJohoCopy().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_照会);
        }
        if (画面モード_審査.equals(画面モード)) {
            div.getBtnShokanKetteiJyoho().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(false);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_修正);
        } else if (画面モード_照会.equals(画面モード)) {
            set画面照会モードに変更();
            div.getJutakuKaishuShinseiContents().getChkKokubo().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getBtnRireki().setDisabled(true);
            div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
            div.getBtnShokanKetteiJyoho().setDisabled(true);
            if (償還払支給判定結果 != null) {
                div.getBtnShokanKetteiJyoho().setDisabled(false);
            }
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_照会);
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(申請を保存ボタン, true);
        } else if (画面モード_修正.equals(画面モード)) {
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setVisible(false);
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setVisible(false);
            設定償還払決定情報ボタンの表示(償還, 償還払支給判定結果, 償還払支給申請情報,
                    住宅改修費支給申請, 償還払請求基本, 被保険者番号, サービス提供年月, 整理番号, 支給申請情報);
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_修正);
        } else {
            設定償還払決定情報ボタンの表示(償還, 償還払支給判定結果, 償還払支給申請情報,
                    住宅改修費支給申請, 償還払請求基本, 被保険者番号, サービス提供年月, 整理番号, 支給申請情報);
        }
        if (画面モード_修正.equals(画面モード) || 画面モード_削除.equals(画面モード) || 画面モード_審査.equals(画面モード)) {
            ShokanJutakuKaishuJizenShinsei 事前申請情報 = JutakuKaishuJizenShinsei.createInstance()
                    .getJutakuKaishuJizenShinseiJyoho(被保険者番号, サービス提供年月, 整理番号);
            if (事前申請情報 != null) {
                div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(false);
            } else {
                div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
            }
        }

        param.set申請情報登録_更新前データ(get更新前データ());
        set住宅改修内容更新前データ(param);
    }

    private void 修正モードなど給付率初期化(ShokanKihon 償還払請求基本) {
        if (償還払請求基本.get保険給付率() != null) {
            div.getTxtKyufuritsu().setValue(償還払請求基本.get保険給付率().value());
        }
    }

    private void set住宅改修内容更新前データ(JutakuGaisuViewStateHolderParameter param) {
        List<JutakuGaisuListDataParameter> 住宅改修内容 = get住宅改修内容一覧データ(
                div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧());
        param.set住宅改修内容(住宅改修内容);
    }

    /**
     * 住宅改修内容一覧からデータ転換するメソッドです。
     *
     * @param 住宅改修内容一覧 List<dgGaisyuList_Row>
     * @return 住宅改修内容一覧
     */
    public List<JutakuGaisuListDataParameter> get住宅改修内容一覧データ(List<dgGaisyuList_Row> 住宅改修内容一覧) {
        List<JutakuGaisuListDataParameter> 住宅改修内容 = new ArrayList<>();
        JutakuGaisuListDataParameter 住宅改修;
        if (!住宅改修内容一覧.isEmpty()) {
            for (dgGaisyuList_Row row : 住宅改修内容一覧) {
                住宅改修 = new JutakuGaisuListDataParameter();
                住宅改修.setTxtChakkoYoteibi(row.getTxtChakkoYoteibi());
                住宅改修.setTxtJigyosha(row.getTxtJigyosha());
                住宅改修.setTxtJigyoshaNo(row.getTxtJigyoshaNo());
                住宅改修.setTxtJutakuAddress(row.getTxtJutakuAddress());
                住宅改修.setTxtJyotai(row.getTxtJyotai());
                住宅改修.setTxtKaishuKingaku(row.getTxtKaishuKingaku());
                住宅改修.setTxtKaishuNaiyo(row.getTxtKaishuNaiyo());
                住宅改修.setTxtKanseiYoteibi(row.getTxtKanseiYoteibi());
                住宅改修.setTxtMeseiNo(row.getTxtMeseiNo());
                住宅改修.setTxtRenban(row.getTxtRenban());
                住宅改修.setTxtSeiriNo(row.getTxtSeiriNo());
                住宅改修内容.add(住宅改修);
            }
        }
        return 住宅改修内容;
    }

    private void 事前申請モード画面初期化(JutakuKaishuJizenShinsei 住宅改修費事前申請, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, ShikibetsuCode 識別コード,
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請, RString 画面モード,
            JutakuGaisuViewStateHolderParameter param) {
        div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString());
        ShokanJutakuKaishuJizenShinsei 申請情報 = 住宅改修費事前申請.getJutakuKaishuJizenShinseiJyoho(被保険者番号,
                サービス提供年月, 整理番号);
        if (申請情報 == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        param.set申請情報(申請情報);
        事前申請内容エリアを初期(申請情報);
        RString 様式番号 = 住宅改修費事前申請.getYoshikiNo(被保険者番号, サービス提供年月, 整理番号);
        JyutakugaisyunaiyoListDataPassModel model = new JyutakugaisyunaiyoListDataPassModel();
        model.set被保険者番号(被保険者番号);
        model.setサービス提供年月(サービス提供年月);
        model.set状態(改修状態_登録);
        model.set様式番号(様式番号);
        model.set識別コード(識別コード);
        model.set整理番号(整理番号);
        div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().initialize(model);
        ShiharaiKekkaResult 過去住宅改修費支払結果 = 住宅改修費事前申請.getOldJutakuKaishuHi(
                被保険者番号, サービス提供年月, 整理番号);
        param.set過去住宅改修費支払結果(過去住宅改修費支払結果);
        前回まで支払結果の初期化(過去住宅改修費支払結果, false, 被保険者番号);
        SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
        set事前支給申請情報(支給申請情報, 申請情報, 識別コード);
        div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                支給申請情報, 支払方法状態_修正);
        param.set申請情報登録_更新前データ(get更新前データ());
        set住宅改修内容更新前データ(param);
        証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, false);
        div.getBtnShokanKetteiJyoho().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setVisible(false);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setVisible(false);
    }

    private void 登録モード画面初期化(ShikibetsuCode 識別コード, JutakuKaishuJizenShinsei 住宅改修費事前申請,
            HihokenshaNo 被保険者番号, JutakukaishuSikyuShinseiManager 住宅改修費支給申請, RString 画面モード,
            FukushiyoguKonyuhiShikyuShinsei 保険者, JutakuGaisuViewStateHolderParameter param) {
        div.getCommHeadPanel().getTxtSeiriNo().setValue(Saiban.get(
                SubGyomuCode.DBC介護給付, SaibanHanyokeyName.償還整理番号.getコード()).nextString());
        JyutakugaisyunaiyoListDataPassModel model = new JyutakugaisyunaiyoListDataPassModel();
        model.set被保険者番号(被保険者番号);
        model.set状態(改修状態_登録);
        model.set識別コード(識別コード);
        div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList().initialize(model);
        SikyuSinseiJyohoParameter 支給申請情報 = new SikyuSinseiJyohoParameter();
        支給申請情報.setShikibetsuCode(識別コード);
        div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(支給申請情報, 支払方法状態_登録);
        ShiharaiKekkaResult 最新住宅改修費支払結果 = 住宅改修費事前申請.getNewJutakuKaishuHi(被保険者番号);
        param.set過去住宅改修費支払結果(最新住宅改修費支払結果);
        RString month = DbBusinessConfig.get(
                ConfigNameDBC.初期表示_償還支給申請登録初期, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RDate 提供着工年月 = new RDate(
                FlexibleDate.getNowDate().getYearMonth().minusMonth(Integer.parseInt(month.toString())).toString());
        div.getTxtTeikyoYM().setValue(提供着工年月);
        前回まで支払結果の初期化(最新住宅改修費支払結果, false, 被保険者番号);
        List<ShichosonResult> 元保険者リスト = 保険者.getHokensyaList(
                被保険者番号, new FlexibleYearMonth(提供着工年月.getYearMonth().toDateString()));
        set保険者初期化(元保険者リスト);
        証明書表示設定(住宅改修費支給申請, 被保険者番号, 画面モード, false);
        param.set申請情報登録_更新前データ(get更新前データ());
        set住宅改修内容更新前データ(param);
        div.getBtnShokanKetteiJyoho().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setVisible(false);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setSelectedKey(
                申請者区分_空);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setVisible(false);
        List<KeyValueDataSource> 保険者リスト = div.getJutakuKaishuShinseiContents().getDdlHokensha().getDataSource();
        if (!保険者リスト.isEmpty()) {
            div.getJutakuKaishuShinseiContents().getDdlHokensha().setSelectedKey(保険者リスト.get(0).getKey());
        }
        HokenKyufuRitsu 給付率 = 住宅改修費事前申請.getKyufuritsu(被保険者番号,
                new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth().toString()));
        if (給付率 != null) {
            div.getTxtKyufuritsu().setValue(給付率.value());
        }
    }

    private void set申請者区分DataSource() {
        List<KeyValueDataSource> 申請者区分リスト = new ArrayList<>();
        申請者区分リスト.add(new KeyValueDataSource(申請者区分_空, RString.EMPTY));
        申請者区分リスト.add(new KeyValueDataSource(ShinseishaKubun.本人.getコード(), ShinseishaKubun.本人.get名称()));
        申請者区分リスト.add(new KeyValueDataSource(ShinseishaKubun.代理人.getコード(), ShinseishaKubun.代理人.get名称()));
        申請者区分リスト.add(new KeyValueDataSource(ShinseishaKubun.受領委任事業者.getコード(),
                ShinseishaKubun.受領委任事業者.get名称()));
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setDataSource(申請者区分リスト);
    }

    private void set国保連再送付表示非表示(RString 償還) {
        if (給付実績連動_受託なし.equals(償還)) {
            div.getJutakuKaishuShinseiContents().getChkKokubo().setVisible(false);
        }
    }

    private void set費用額合計など入力不可() {
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae().setDisabled(true);
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

    private void 設定償還払決定情報ボタンの表示(RString 償還, ShokanHanteiKekka 償還払支給判定結果,
            ShokanShinsei 償還払支給申請情報,
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請, ShokanKihon 償還払請求基本, HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, SikyuSinseiJyohoParameter 支給申請情報) {
        if (給付実績連動_受託なし.equals(償還)) {
            div.getBtnShokanKetteiJyoho().setDisabled(true);
            if (償還払支給判定結果 != null) {
                div.getBtnShokanKetteiJyoho().setDisabled(false);
            }
        } else if (給付実績緋連動_受託あり.equals(償還)) {
            if (償還払支給判定結果 == null && 償還払支給申請情報.get送付年月() != null) {
                set画面照会モードに変更();
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(支給申請情報, 支払方法状態_登録);
            } else if (償還払支給判定結果 == null && 償還払支給申請情報.get送付年月() == null) {
                div.getBtnShokanKetteiJyoho().setDisabled(true);
            } else if (償還払支給判定結果 != null) {
                div.getBtnShokanKetteiJyoho().setDisabled(false);
                RString 支給不支給区分 = 償還払支給判定結果.get支給_不支給決定区分();
                set償還払決定情報ボタン制御(支給不支給区分, 住宅改修費支給申請, 償還払請求基本, 被保険者番号,
                        サービス提供年月, 整理番号, 償還払支給申請情報, 支給申請情報);
            }
        }
    }

    private void set償還払決定情報ボタン制御(RString 支給不支給区分, JutakukaishuSikyuShinseiManager 住宅改修費支給申請,
            ShokanKihon 償還払請求基本, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号,
            ShokanShinsei 償還払支給申請情報, SikyuSinseiJyohoParameter 支給申請情報) {
        if (ShikyuFushikyuKubun.支給.getコード().equals(支給不支給区分)) {
            List<KyufujissekiKihon> 給付実績基本情報リスト = 住宅改修費支給申請.getKyufuJissekiKihonList(
                    償還払請求基本.get様式番号(), new HokenshaNo(div.getJutakuKaishuShinseiContents()
                            .getDdlHokensha().getSelectedKey()), 被保険者番号, サービス提供年月, 整理番号,
                    KyufuJissekiKubun.償還.getコード());
            if (給付実績基本情報リスト.isEmpty()) {
                set画面照会モードに変更();
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                        支給申請情報, 支払方法状態_登録);
            } else {
                最新の審査年月より活性判断(給付実績基本情報リスト, 償還払支給申請情報, 支給申請情報);
            }
        } else if (ShikyuFushikyuKubun.不支給.getコード().equals(支給不支給区分)) {
            div.getBtnShokanKetteiJyoho().setDisabled(false);
        }
    }

    private void 最新の審査年月より活性判断(List<KyufujissekiKihon> 給付実績基本情報リスト,
            ShokanShinsei 償還払支給申請情報, SikyuSinseiJyohoParameter 支給申請情報) {
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
        } else if ((最新審査年月給付実績基本情報.get後_保険_請求額() == null)
                || (最新審査年月給付実績基本情報.get後_保険_請求額().intValue() != 償還払支給申請情報.get保険給付額())) {
            set画面照会モードに変更();
            div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().initialize(
                    支給申請情報, 支払方法状態_登録);
            div.getBtnShokanKetteiJyoho().setDisabled(false);
        } else if (最新審査年月給付実績基本情報.get後_保険_請求額().intValue() == 償還払支給申請情報.get保険給付額()) {
            div.getBtnShokanKetteiJyoho().setDisabled(false);
        }
    }

    private void set画面照会モードに変更() {
        div.getCommHeadPanel().getTxtTeikyoYM().setDisabled(true);
        div.getCommHeadPanel().getDdlSyomeisyo().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getDdlHokensha().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisabled(true);
        div.getJutakuKaishuShinseiContents().getShiharaiHohoJyohoPanle().setDisabled(false);
        div.getJutakuKaishuShinseiContents().getChkKokubo().setDisabled(false);
    }

    private void set事前支給申請情報(SikyuSinseiJyohoParameter 支給申請情報, ShokanJutakuKaishuJizenShinsei 事前申請情報,
            ShikibetsuCode 識別コード) {
        支給申請情報.setShikibetsuCode(識別コード);
        支給申請情報.setHihokenshaNo(事前申請情報.get被保険者番号());
        支給申請情報.setShikyushinseiServiceYM(事前申請情報.getサービス提供年月());
        支給申請情報.setShikyushinseiSeiriNo(事前申請情報.get整理番号());
        if (事前申請情報.get支払方法区分コード() != null) {
            支給申請情報.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(事前申請情報.get支払方法区分コード()));
        }
        支給申請情報.setShiharaiBasho(事前申請情報.get支払場所());
        if (事前申請情報.get支払期間開始年月日() != null) {
            支給申請情報.setStartYMD(new RDate(事前申請情報.get支払期間開始年月日().toString()));
        }
        if (事前申請情報.get支払期間終了年月日() != null) {
            支給申請情報.setEndYMD(new RDate(事前申請情報.get支払期間終了年月日().toString()));
        }
        if (事前申請情報.get支払窓口開始時間() != null) {
            支給申請情報.setStartHHMM(new RTime(事前申請情報.get支払窓口開始時間()));
        }
        if (事前申請情報.get支払窓口終了時間() != null) {
            支給申請情報.setEndHHMM(new RTime(事前申請情報.get支払窓口終了時間()));
        }
        支給申請情報.setKozaId(事前申請情報.get口座ID());
        支給申請情報.setKeiyakuNo(事前申請情報.get受領委任契約番号());
    }

    private void set支給申請情報(SikyuSinseiJyohoParameter 支給申請情報, ShokanShinsei 申請情報,
            ShikibetsuCode 識別コード) {
        支給申請情報.setShikibetsuCode(識別コード);
        支給申請情報.setHihokenshaNo(申請情報.get被保険者番号());
        支給申請情報.setShikyushinseiServiceYM(申請情報.getサービス提供年月());
        支給申請情報.setShikyushinseiSeiriNo(申請情報.get整理番号());
        if (申請情報.get支払方法区分コード() != null) {
            支給申請情報.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(申請情報.get支払方法区分コード()));
        }
        支給申請情報.setShiharaiBasho(申請情報.get支払場所());
        if (申請情報.get支払期間開始年月日() != null) {
            支給申請情報.setStartYMD(new RDate(申請情報.get支払期間開始年月日().toString()));
        }
        if (申請情報.get支払期間終了年月日() != null) {
            支給申請情報.setEndYMD(new RDate(申請情報.get支払期間終了年月日().toString()));
        }
        if (申請情報.get支払窓口開始時間() != null) {
            支給申請情報.setStartHHMM(new RTime(申請情報.get支払窓口開始時間()));
        }
        if (申請情報.get支払窓口終了時間() != null) {
            支給申請情報.setEndHHMM(new RTime(申請情報.get支払窓口終了時間()));
        }
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
                償還事前申請情報.get申請者区分());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().setValue(
                償還事前申請情報.get申請理由());
        if (償還事前申請情報.get事業者番号() != null) {
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo().setValue(
                    償還事前申請情報.get事業者番号().value());
        }
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                償還事前申請情報.get申請者氏名カナ());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setValue(
                償還事前申請情報.get申請者氏名());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDomain(
                償還事前申請情報.get申請者電話番号());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setValue(
                償還事前申請情報.get申請者郵便番号());
        if (償還事前申請情報.get申請者住所() != null) {
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDomain(
                    new AtenaJusho(償還事前申請情報.get申請者住所()));
        }
        if (償還事前申請情報.get理由書作成日() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().setValue(
                    new RDate(償還事前申請情報.get理由書作成日().toString()));
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setDomain(
                new AtenaKanaMeisho(償還事前申請情報.get理由書作成者カナ()));
        if (償還事前申請情報.get理由書作成者() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setDomain(
                    new AtenaMeisho(償還事前申請情報.get理由書作成者()));
        }
        if (償還事前申請情報.get理由書作成事業者番号() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(
                    償還事前申請情報.get理由書作成事業者番号().value());
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setDomain(
                    new AtenaMeisho(償還事前申請情報.get理由書作成事業者番号().value()));
            get作成事業者名();
        }
        List<KeyValueDataSource> 保険者リスト = div.getJutakuKaishuShinseiContents().getDdlHokensha().getDataSource();
        if (!保険者リスト.isEmpty()) {
            div.getJutakuKaishuShinseiContents().getDdlHokensha().setSelectedKey(保険者リスト.get(0).getKey());
        }
    }

    private void 前回まで支払結果の初期化(ShiharaiKekkaResult 住宅改修費支払結果, boolean 過去, HihokenshaNo 被保険者番号) {
        if (住宅改修費支払結果 != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae().setValue(
                    住宅改修費支払結果.get費用額合計());
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae().setValue(
                    住宅改修費支払結果.get費用額合計());
            Decimal 支給限度額 = 支給限度額の取得(被保険者番号);
            if (!過去 && 住宅改修費支払結果.get費用額合計() != null
                    && 住宅改修費支払結果.get費用額合計().compareTo(支給限度額) > 0) {
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae()
                        .setValue(支給限度額);
            }
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountMae().setValue(
                    住宅改修費支払結果.get保険給付額());
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                    .setValue(住宅改修費支払結果.get利用者負担額());
        } else {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHiyoTotalMae().setValue(
                    Decimal.ZERO);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenTaishoHiyoMae().setValue(
                    Decimal.ZERO);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtHokenKyufuAmountMae().setValue(
                    Decimal.ZERO);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountMae()
                    .setValue(Decimal.ZERO);
        }
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
        List<KeyValueDataSource> 保険者リスト = div.getJutakuKaishuShinseiContents().getDdlHokensha().getDataSource();
        for (KeyValueDataSource 保険者 : 保険者リスト) {
            if (保険者.getKey().equals(償還払支給申請情報.get証記載保険者番号().value())) {
                div.getJutakuKaishuShinseiContents().getDdlHokensha().setSelectedKey(
                        償還払支給申請情報.get証記載保険者番号().value());
            }
        }
        List<RString> key = new ArrayList<>();
        key.add(国保連再送付_チェック);
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
        if (償還払支給申請情報.get審査結果() != null) {
            div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo().setSelectedKey(
                    償還払支給申請情報.get審査結果());
        }
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().setValue(
                new RDate(償還払支給申請情報.get申請年月日().toString()));
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().setSelectedKey(
                償還払支給申請情報.get申請者区分());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().setValue(
                償還払支給申請情報.get申請理由());
        if (償還払支給申請情報.get申請事業者コード() != null) {
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo().setValue(
                    償還払支給申請情報.get申請事業者コード().value());
        }
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().setValue(
                償還払支給申請情報.get申請者氏名カナ());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().setValue(
                償還払支給申請情報.get申請者氏名());
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDomain(
                償還払支給申請情報.get申請者電話番号());
        RString 申請取消事由コード = 償還払支給申請情報.get住宅改修申請取消事由コード();
        List<UzT0007CodeEntity> costlist = CodeMaster.getCode(
                SubGyomuCode.DBC介護給付, new CodeShubetsu(コード種別), FlexibleDate.getNowDate());
        List<KeyValueDataSource> torikesuJiyu = new ArrayList<>();
        torikesuJiyu.add(new KeyValueDataSource(申請取消事由_空, RString.EMPTY));
        for (UzT0007CodeEntity list : costlist) {
            KeyValueDataSource dataSource = new KeyValueDataSource(list.getコード().value(), list.getコード略称());
            torikesuJiyu.add(dataSource);
        }
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDataSource(
                torikesuJiyu);
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setSelectedKey(
                申請取消事由_空);
        if (申請取消事由コード != null) {
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setSelectedKey(
                    申請取消事由コード);
        }
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().setValue(
                償還払支給申請情報.get申請者郵便番号());
        if (償還払支給申請情報.get申請者住所() != null) {
            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().setDomain(
                    new AtenaJusho(償還払支給申請情報.get申請者住所()));
        }
        if (償還払支給申請情報.get理由書作成日() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().setValue(
                    new RDate(償還払支給申請情報.get理由書作成日().toString()));
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setDomain(
                new AtenaKanaMeisho(償還払支給申請情報.get理由書作成者カナ()));
        if (償還払支給申請情報.get理由書作成者() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setDomain(
                    new AtenaMeisho(償還払支給申請情報.get理由書作成者()));
        }
        if (償還払支給申請情報.get理由書作成事業者番号() != null) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(
                    償還払支給申請情報.get理由書作成事業者番号().value());
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setDomain(
                    new AtenaMeisho(償還払支給申請情報.get理由書作成事業者番号().value()));
            get作成事業者名();
        }
    }

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
     * @param 住宅改修費支給申請 JutakukaishuSikyuShinseiManager
     * @param 被保険者番号 HihokenshaNo
     * @param 画面モード RString
     * @param is提供着工年月切替Flag boolean
     */
    public void 証明書表示設定(JutakukaishuSikyuShinseiManager 住宅改修費支給申請, HihokenshaNo 被保険者番号,
            RString 画面モード, boolean is提供着工年月切替Flag) {
        RDate 画面提供着工年月 = div.getTxtTeikyoYM().getValue();
        FlexibleYearMonth 提供着工年月 = new FlexibleYearMonth(画面提供着工年月.getYearMonth().toDateString());
        List<ShikibetsuNoKanri> 様式名称 = 住宅改修費支給申請.getYoshikiName(提供着工年月);
        if (様式名称 == null) {
            throw new ApplicationException(
                    UrErrorMessages.存在しない.getMessage().replace(証明書様式内容_NULL.toString()));
        }
        RString 制度改正施行年月日 = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        YokaigoNinteiJyoho 要介護認定情報 = 住宅改修費事前申請.getYokaigoNinteiJyoho(被保険者番号, 提供着工年月);
        set証明書DataSource(様式名称);
        if (is提供着工年月切替Flag) {
            set証明書DataSource空項目ある(様式名称);
        }
        if (要介護認定情報 == null) {
            set証明書DataSource空項目ある(様式名称);
            div.getDdlSyomeisyo().setSelectedKey(RString.EMPTY);
        } else if (画面提供着工年月.toDateString().compareTo(制度改正施行年月日) < 0) {
            証明書表示設定平成18年04月以前(要介護認定情報.get要介護認定状態区分コード(), is提供着工年月切替Flag);
        } else if (画面提供着工年月.toDateString().compareTo(制度改正施行年月日) >= 0) {
            証明書表示設定(画面モード, 要介護認定情報.get要介護認定状態区分コード(), 提供着工年月, is提供着工年月切替Flag);
        }
    }

    private void set証明書DataSource空項目ある(List<ShikibetsuNoKanri> 様式名称) {
        List<KeyValueDataSource> 証明書ddl = new ArrayList<>();
        証明書ddl.add(new KeyValueDataSource(RString.EMPTY, RString.EMPTY));
        if (!様式名称.isEmpty()) {
            for (ShikibetsuNoKanri 識別番号 : 様式名称) {
                証明書ddl.add(new KeyValueDataSource(識別番号.get識別番号(), 識別番号.get識別番号()));
            }
        }
        div.getDdlSyomeisyo().setDataSource(証明書ddl);
    }

    private void 証明書表示設定平成18年04月以前(Code 要介護認定状態区分コード, boolean is提供着工年月切替Flag) {
        if (要支援_経過的要介護.equals(要介護認定状態区分コード) || 要介護1.equals(要介護認定状態区分コード)
                || 要介護2.equals(要介護認定状態区分コード) || 要介護3.equals(要介護認定状態区分コード)
                || 要介護4.equals(要介護認定状態区分コード) || 要介護5.equals(要介護認定状態区分コード)) {
            div.getDdlSyomeisyo().setSelectedKey(証明書1);
            div.getDdlSyomeisyo().setDisabled(true);
        } else if (is提供着工年月切替Flag) {
            div.getDdlSyomeisyo().setSelectedKey(RString.EMPTY);
        } else {
            throw new ApplicationException(DbcErrorMessages.受給者登録なし.getMessage());
        }
    }

    private void 証明書表示設定(RString 画面モード, Code 要介護認定状態区分コード, FlexibleYearMonth 提供着工年月,
            boolean is提供着工年月切替Flag) {
        if (要支援1.equals(要介護認定状態区分コード)
                || 要支援2.equals(要介護認定状態区分コード)) {
            set証明書値(証明書2);
        } else if ((要支援_経過的要介護.equals(要介護認定状態区分コード) && 提供着工年月.isBeforeOrEquals(平成21年03月))
                || 要介護1.equals(要介護認定状態区分コード) || 要介護2.equals(要介護認定状態区分コード)
                || 要介護3.equals(要介護認定状態区分コード) || 要介護4.equals(要介護認定状態区分コード)
                || 要介護5.equals(要介護認定状態区分コード)) {
            div.getDdlSyomeisyo().setSelectedKey(証明書1);
            div.getDdlSyomeisyo().setDisabled(false);
            if (!画面モード_登録.equals(画面モード) && !画面モード_事前申請.equals(画面モード)) {
                div.getDdlSyomeisyo().setDisabled(true);
            }
        } else if (is提供着工年月切替Flag) {
            div.getDdlSyomeisyo().setSelectedKey(RString.EMPTY);
        } else {
            throw new ApplicationException(DbcErrorMessages.受給者登録なし.getMessage());
        }
    }

    private void set証明書値(RString 証明書) {
        List<KeyValueDataSource> 証明書ddl = div.getDdlSyomeisyo().getDataSource();
        boolean 証明書keyが存在 = false;
        for (KeyValueDataSource 証明書key : 証明書ddl) {
            if (証明書.equals(証明書key.getKey())) {
                証明書keyが存在 = true;
                break;
            }
        }
        if (証明書keyが存在) {
            div.getDdlSyomeisyo().setSelectedKey(証明書);
        }
        div.getDdlSyomeisyo().setDisabled(true);
    }

    private void set証明書DataSource(List<ShikibetsuNoKanri> 様式名称) {
        List<KeyValueDataSource> 証明書ddl = new ArrayList<>();
        if (様式名称 != null && !様式名称.isEmpty()) {
            for (ShikibetsuNoKanri 識別番号 : 様式名称) {
                証明書ddl.add(new KeyValueDataSource(識別番号.get識別番号(), 識別番号.get識別番号()));
            }
        }
        div.getDdlSyomeisyo().setDataSource(証明書ddl);
    }

    /**
     * 申請内容の保存するメソッドです。
     *
     * @param 引き継ぎデータEntity 引き継ぎデータEntity
     * @param param JutakuGaisuViewStateHolderParameter
     */
    public void save(ShokanharaKeteiJyohoParameter 引き継ぎデータEntity, JutakuGaisuViewStateHolderParameter param) {
        RString 画面モード = 引き継ぎデータEntity.get画面モード();
        HihokenshaNo 引き継ぎ被保険者番号 = 引き継ぎデータEntity.get被保険者番号();
        FlexibleYearMonth 引き継ぎサービス提供年月 = 引き継ぎデータEntity.getサービス提供年月();
        RString 引き継ぎ整理番号 = 引き継ぎデータEntity.get整理番号();
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
        RString 支払方法区分コード = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getShiharaiHohoRad();
        RString 支払場所 = RString.EMPTY;
        FlexibleDate 支払期間開始年月日save = null;
        FlexibleDate 支払期間終了年月日save = null;
        RString 支払窓口開始時間save = RString.EMPTY;
        RString 支払窓口終了時間save = RString.EMPTY;
        long 口座IDsave = 0;
        RString 受領委任契約番号 = RString.EMPTY;
        if (支払方法情報_窓口.equals(支払方法区分コード)) {
            支払場所 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getShiharaiBasho();
            RDate 支払期間開始年月日 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getStartYMD();
            支払期間開始年月日save = 支払期間開始年月日 == null ? null : new FlexibleDate(
                    支払期間開始年月日.toDateString());
            RDate 支払期間終了年月日 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getEndYMD();
            支払期間終了年月日save = 支払期間終了年月日 == null ? null : new FlexibleDate(
                    支払期間終了年月日.toDateString());
            RTime 支払窓口開始時間 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getStartHHMM();
            支払窓口開始時間save = get支払窓口終了時間save(支払窓口開始時間);
            RTime 支払窓口終了時間 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getEndHHMM();
            支払窓口終了時間save = get支払窓口終了時間save(支払窓口終了時間);
        } else if (支払方法情報_口座.equals(支払方法区分コード)) {
            RString 口座ID = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getKozaID();
            口座IDsave = get口座IDsave(口座ID, 口座IDsave);
        } else if (支払方法情報_受領委任.equals(支払方法区分コード)) {
            受領委任契約番号 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getKeiyakuNo();
        }
        List<KeyValueDataSource> 限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedItems();
        boolean 要介護状態区分3段階変更 = false;
        boolean 住宅住所変更 = false;
        for (KeyValueDataSource 限度額 : 限度額リセット) {
            if (要介護状態区分3段階変更による.equals(限度額.getKey())) {
                要介護状態区分3段階変更 = true;
            } else if (住宅住所変更による.equals(限度額.getKey())) {
                住宅住所変更 = true;
            }
        }
        RString 審査結果 = div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo()
                .getSelectedKey();
        RString 支給不支給決定区分 = get支給不支給決定区分(審査結果);
        JutakukaishuSikyuShinseiManager 住宅改修費支給申請 = JutakukaishuSikyuShinseiManager.createInstance();
        ShokanHanteiKekka 償還払支給判定結果 = param.get償還払支給判定結果();
        ShokanKihon 償還払請求基本 = param.get償還払請求基本();
        ShokanShukei 償還払請求集計 = param.get償還払請求集計();
        ShokanShinsei dbt3034 = param.get償還払支給申請情報();
        List<ShokanJutakuKaishu> dbt3049List = new ArrayList<>();
        Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> jyutakugaisyu = param.get住宅改修内容一覧_検索結果();
        for (Iterator i = jyutakugaisyu.iterator(); i.hasNext();) {
            dbt3049List.add((ShokanJutakuKaishu) i.next());
        }
        if (画面モード_登録.equals(画面モード)
                || 画面モード_事前申請.equals(画面モード)) {
            set登録モードDB保存(引き継ぎ被保険者番号, 送付区分, 送付年月, 国保連再送付フラグ, 要介護状態区分3段階変更,
                    住宅住所変更, 画面モード, 住宅改修費支給申請, 支払方法区分コード, 支払場所, 支払期間開始年月日save,
                    支払期間終了年月日save, 支払窓口開始時間save, 支払窓口終了時間save, 口座IDsave, 受領委任契約番号, param);
        } else if (画面モード_削除.equals(画面モード)) {
            住宅改修費支給申請.delDBDate(引き継ぎ被保険者番号, 引き継ぎサービス提供年月,
                    引き継ぎ整理番号, 償還払支給判定結果 == null ? null : 償還払支給判定結果.get決定年月日(),
                    引き継ぎデータEntity.get識別コード(), new HokenshaNo(
                            div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()), dbt3049List,
                    償還払請求集計, dbt3034, 償還払請求基本, 償還払支給判定結果);
        } else if (画面モード_修正.equals(画面モード)
                || 画面モード_審査.equals(画面モード)
                || 画面モード_取消.equals(画面モード)) {
            set更新DB保存(引き継ぎ被保険者番号, 引き継ぎサービス提供年月, 引き継ぎ整理番号, 画面モード, 送付年月,
                    国保連再送付フラグ, 要介護状態区分3段階変更, 住宅住所変更, 審査結果, 支給不支給決定区分,
                    償還払支給判定結果, 住宅改修費支給申請, 引き継ぎデータEntity, 支払方法区分コード,
                    支払場所, 支払期間開始年月日save, 支払期間終了年月日save, 支払窓口開始時間save, 支払窓口終了時間save,
                    口座IDsave, 受領委任契約番号, 償還払請求基本, dbt3034, 償還払請求集計, param);
        }
    }

    private RString get支給不支給決定区分(RString 審査結果) {
        RString 支給不支給決定区分 = null;
        if (審査結果_承認する.equals(審査結果)) {
            支給不支給決定区分 = ShikyuFushikyuKubun.支給.getコード();
        } else if (審査結果_却下する.equals(審査結果)) {
            支給不支給決定区分 = ShikyuFushikyuKubun.不支給.getコード();
        }
        return 支給不支給決定区分;
    }

    private RString get支払窓口終了時間save(RTime 支払窓口終了時間) {
        RString 支払窓口終了時間save = RString.EMPTY;
        if (支払窓口終了時間 != null) {
            支払窓口終了時間save = new RString(支払窓口終了時間.toString().split(コロン.toString())[0].concat(
                    支払窓口終了時間.toString().split(コロン.toString())[1]));
        }
        return 支払窓口終了時間save;
    }

    private long get口座IDsave(RString 口座ID, long 口座IDsave) {
        if (!口座ID.isNullOrEmpty()) {
            口座IDsave = Long.parseLong(口座ID.toString());
        }
        return 口座IDsave;
    }

    private void set更新DB保存(HihokenshaNo 引き継ぎ被保険者番号, FlexibleYearMonth 引き継ぎサービス提供年月,
            RString 引き継ぎ整理番号, RString 画面モード, FlexibleYearMonth 送付年月, boolean 国保連再送付フラグ,
            boolean 要介護状態区分3段階変更, boolean 住宅住所変更,
            RString 審査結果, RString 支給不支給決定区分, ShokanHanteiKekka 償還払支給判定結果,
            JutakukaishuSikyuShinseiManager 住宅改修費支給申請, ShokanharaKeteiJyohoParameter 引き継ぎデータEntity,
            RString 支払方法区分コード, RString 支払場所, FlexibleDate 支払期間開始年月日, FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間, RString 支払窓口終了時間, long 口座ID, RString 受領委任契約番号,
            ShokanKihon 償還払請求基本, ShokanShinsei dbt3034, ShokanShukei 償還払請求集計,
            JutakuGaisuViewStateHolderParameter param) {
        ShokanShukei dbt3053 = 償還払請求集計.createBuilderForEdit().build();
        ShokanKihon dbt3038 = 償還払請求基本.createBuilderForEdit().build();
        ShokanKihonBuilder dbt3038Builder = dbt3038.createBuilderForEdit().set保険給付率(
                new HokenKyufuRitsu(div.getTxtKyufuritsu().getValue()))
                .set保険請求額(div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue());
        Decimal 支払金額合計 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalNow().getValue();
        if (支払金額合計 != null) {
            dbt3038Builder.setサービス単位数(支払金額合計.intValue());
        }
        if (償還払支給判定結果 != null) {
            償還払支給判定結果 = 償還払支給判定結果.createBuilderForEdit().set決定年月日(FlexibleDate.getNowDate())
                    .set支給_不支給決定区分(支給不支給決定区分).set支払金額(
                            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenKyufuAmountNow().getValue()).build();
            償還払支給判定結果 = 償還払支給判定結果.modified();
        } else {
            償還払支給判定結果 = new ShokanHanteiKekka(引き継ぎ被保険者番号,
                    new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth().toDateString()),
                    div.getTxtSeiriNo().getValue()).createBuilderForEdit().build();
            償還払支給判定結果 = 償還払支給判定結果.createBuilderForEdit()
                    .set証記載保険者番号(
                            new ShoKisaiHokenshaNo(div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()))
                    .set決定年月日(FlexibleDate.getNowDate())
                    .set支給_不支給決定区分(支給不支給決定区分)
                    .set支払金額(div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenKyufuAmountNow().getValue()).build();
            償還払支給判定結果 = 償還払支給判定結果.added();
        }
        AtenaMeisho 画面理由書作成者 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorName().getDomain();
        RString 理由書作成者 = 画面理由書作成者 == null ? RString.EMPTY : 画面理由書作成者.value();
        RDate 理由書作成日 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD()
                .getValue();
        FlexibleDate 理由書作成日Save = 理由書作成日 == null ? null : new FlexibleDate(理由書作成日.toDateString());
        List<ShokanJutakuKaishu> 住宅改修内容一覧 = new ArrayList<>();
        if (画面モード_修正.equals(画面モード)) {
            ShokanShinseiBuilder dbt3034Builder = dbt3034.createBuilderForEdit().set証記載保険者番号(
                    new ShoKisaiHokenshaNo(div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()))
                    .set申請年月日(new FlexibleDate(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                                    .getTxtShinseiYMD().getValue().toString()))
                    .set申請理由(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue())
                    .set申請者区分(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun()
                            .getSelectedKey()).set申請者氏名(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getTxtShinseishaName().getValue())
                    .set申請者氏名カナ(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana()
                            .getValue()).set申請者郵便番号(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getTxtYubinNo().getValue())
                    .set申請者住所(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain()
                            .value()).set理由書作成日(理由書作成日Save).set申請者電話番号(
                            div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().getDomain())
                    .set理由書作成者(理由書作成者).set理由書作成者カナ(
                            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                            .getTxtCreatorKanaName().getDomain().value()).set支払金額合計(支払金額合計)
                    .set保険対象費用額(div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenTaishoHiyoNow().getValue()).set保険給付額(div.getJutakuKaishuShinseiContents()
                            .getJutakuKaishuShinseiResetInfo()
                            .getTxtHokenKyufuAmountNow().getValue().intValue())
                    .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(
                            div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue())
                    .set被保険者の関係(div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue())
                    .set要介護状態３段階変更(要介護状態区分3段階変更)
                    .set住宅住所変更(住宅住所変更).set領収年月日(new FlexibleDate(
                                    div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue().toString()))
                    .set支払方法区分コード(支払方法区分コード)
                    .set支払場所(支払場所).set支払期間開始年月日(支払期間開始年月日)
                    .set支払期間終了年月日(支払期間終了年月日).set支払窓口開始時間(支払窓口開始時間)
                    .set支払窓口終了時間(支払窓口終了時間).set口座ID(口座ID).set受領委任契約番号(受領委任契約番号);
            ShokanShukeiBuilder dbt3053Builder = dbt3053.createBuilderForEdit().set請求額(
                    div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtHokenKyufuAmountNow().getValue());
            Decimal 利用者負担額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtRiyoshaFutanAmountNow().getValue();
            if (利用者負担額 != null) {
                dbt3038Builder.set利用者負担額(利用者負担額.intValue());
                dbt3053Builder.set利用者負担額(利用者負担額.intValue());
                dbt3034Builder.set利用者負担額(利用者負担額.intValue());
            }
            申請事業者理由書作成事業者番号設定(dbt3034Builder);
            dbt3034 = dbt3034Builder.build().modifiedModel();
            dbt3038 = dbt3038Builder.build().modified();
            dbt3053 = dbt3053Builder.build().modified();
            住宅改修内容一覧 = get住宅改修内容一覧(償還払請求基本, 引き継ぎ被保険者番号, dbt3034, param);
        } else if (画面モード_審査.equals(画面モード)) {
            ShokanShinseiBuilder dbt3034Builder = dbt3034.createBuilderForEdit().set証記載保険者番号(
                    new ShoKisaiHokenshaNo(div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()))
                    .set申請年月日(new FlexibleDate(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                                    .getTxtShinseiYMD().getValue().toString()))
                    .set申請理由(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue())
                    .set申請者区分(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun()
                            .getSelectedKey()).set申請者氏名(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getTxtShinseishaName().getValue())
                    .set申請者氏名カナ(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana()
                            .getValue()).set申請者郵便番号(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getTxtYubinNo().getValue())
                    .set申請者住所(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain()
                            .value()).set申請者電話番号(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getTxtTelNo().getDomain())
                    .set支給申請審査区分(ShikyushinseiShinsaKubun.審査済.getコード()).set理由書作成日(理由書作成日Save)
                    .set理由書作成者(理由書作成者).set理由書作成者カナ(div.getJutakuKaishuShinseiContents()
                            .getJutakuKaishuShinseiReason().getTxtCreatorKanaName().getDomain().value())
                    .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(
                            div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue())
                    .set被保険者の関係(div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue())
                    .set要介護状態３段階変更(要介護状態区分3段階変更)
                    .set住宅住所変更(住宅住所変更).set審査年月日(FlexibleDate.getNowDate()).set審査結果(審査結果)
                    .set支払方法区分コード(支払方法区分コード).set支払場所(支払場所).set支払期間開始年月日(支払期間開始年月日)
                    .set支払期間終了年月日(支払期間終了年月日).set支払窓口開始時間(支払窓口開始時間)
                    .set支払窓口終了時間(支払窓口終了時間).set口座ID(口座ID).set受領委任契約番号(受領委任契約番号);
            ShokanShukeiBuilder dbt3053Builder = dbt3053.createBuilderForEdit().set請求額(
                    div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtHokenKyufuAmountNow().getValue())
                    .set審査年月(new FlexibleYearMonth(FlexibleDate.getNowDate().getYearMonth().toDateString()))
                    .set支給区分コード(支給不支給決定区分);
            Decimal 利用者負担額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtRiyoshaFutanAmountNow().getValue();
            if (利用者負担額 != null) {
                dbt3053Builder.set利用者負担額(利用者負担額.intValue());
                dbt3038Builder.set利用者負担額(利用者負担額.intValue());
                dbt3034Builder.set利用者負担額(利用者負担額.intValue());
            }
            dbt3053 = dbt3053Builder.build().modified();
            dbt3038 = dbt3038Builder.build().modified();
            申請事業者理由書作成事業者番号設定(dbt3034Builder);
            dbt3034 = dbt3034Builder.build().modifiedModel();
            住宅改修内容一覧 = get住宅改修内容一覧(償還払請求基本, 引き継ぎ被保険者番号, dbt3034, param);
        } else if (画面モード_取消.equals(画面モード)) {
            dbt3034 = dbt3034.createBuilderForEdit().set住宅改修申請区分(JutakukaishuShinseiKubun.取消.getCode())
                    .set住宅改修申請取消事由コード(
                            div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                            .getDdlShinseiTorikesuJiyu().getSelectedKey()).build().modifiedModel();
        }
        住宅改修費支給申請.updDBDate(引き継ぎ被保険者番号, 引き継ぎサービス提供年月,
                引き継ぎ整理番号, 画面モード, 引き継ぎデータEntity.get識別コード(),
                new HokenshaNo(div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()),
                dbt3034, dbt3038, 住宅改修内容一覧, dbt3053, 償還払支給判定結果);
    }

    private List<ShokanJutakuKaishu> get住宅改修内容一覧(ShokanKihon 償還払請求基本, HihokenshaNo 引き継ぎ被保険者番号,
            ShokanShinsei dbt3034, JutakuGaisuViewStateHolderParameter param) {
        List<ShokanJutakuKaishu> kaishuList = new ArrayList<>();
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        int index = 0;
        Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> oldDataList = param.get住宅改修内容一覧_検索結果();
        for (ShokanJutakuKaishu tmp : oldDataList.aliveValues()) {
            if (index < Integer.valueOf(tmp.get連番().toString())) {
                index = Integer.valueOf(tmp.get連番().toString());
            }
        }
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        ServiceShuruiCode サービス種類コード = 住宅改修費事前申請.getServiceShuruiCode(引き継ぎ被保険者番号,
                new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth().toDateString()));
        for (dgGaisyuList_Row tmpRow : gridList) {
            if (!tmpRow.getTxtRenban().isNullOrEmpty() && (行状態_更新.equals(tmpRow.getTxtJyotai())
                    || 行状態_削除.equals(tmpRow.getTxtJyotai()) || 行状態_更新なし.equals(tmpRow.getTxtJyotai()))) {
                ShokanJutakuKaishu oldData = 住宅改修レコードの取得(tmpRow, oldDataList);
                ShokanJutakuKaishuBuilder shokanJutakuKaishuBuilder = oldData.createBuilderForEdit();
                shokanJutakuKaishuBuilder.set住宅改修内容(tmpRow.getTxtKaishuNaiyo());
                shokanJutakuKaishuBuilder.set住宅改修事業者名(tmpRow.getTxtJigyosha());
                shokanJutakuKaishuBuilder.set住宅改修住宅住所(tmpRow.getTxtJutakuAddress());
                if (tmpRow.getTxtChakkoYoteibi() != null) {
                    shokanJutakuKaishuBuilder.set住宅改修着工年月日(new FlexibleDate(
                            new RDate(tmpRow.getTxtChakkoYoteibi().toString()).toDateString()));
                }
                if (tmpRow.getTxtKanseiYoteibi() != null) {
                    shokanJutakuKaishuBuilder.set住宅改修完成年月日(new FlexibleDate(
                            new RDate(tmpRow.getTxtKanseiYoteibi().toString()).toDateString()));
                }
                shokanJutakuKaishuBuilder.set改修金額(tmpRow.getTxtKaishuKingaku().isNullOrEmpty()
                        ? 0 : Integer.parseInt(tmpRow.getTxtKaishuKingaku().toString()));
                EntityDataState state = EntityDataState.Unchanged;
                if (!行状態_更新なし.equals(tmpRow.getTxtJyotai())) {
                    state = 行状態_更新.equals(tmpRow.getTxtJyotai())
                            ? EntityDataState.Modified : EntityDataState.Deleted;
                }
                shokanJutakuKaishuBuilder.setステータス(state);
                oldData = shokanJutakuKaishuBuilder.build();
                kaishuList.add(oldData);
            } else {
                index = index + 1;
                ShokanJutakuKaishu addData = new ShokanJutakuKaishu(
                        償還払請求基本.get被保険者番号(),
                        償還払請求基本.getサービス提供年月(),
                        償還払請求基本.get整理番号(),
                        償還払請求基本.get事業者番号(),
                        償還払請求基本.get様式番号(),
                        償還払請求基本.get明細番号(),
                        new RString(String.format(FORMAT.toString(), index)));
                ShokanJutakuKaishuBuilder addDataBuilder = addData.createBuilderForEdit();
                addDataBuilder.set住宅改修内容(tmpRow.getTxtKaishuNaiyo());
                addDataBuilder.set住宅改修事業者名(tmpRow.getTxtJigyosha());
                addDataBuilder.set住宅改修住宅住所(tmpRow.getTxtJutakuAddress());
                addDataBuilder.set住宅改修着工年月日(new FlexibleDate(
                        new RDate(tmpRow.getTxtChakkoYoteibi().toString()).toDateString()));
                addDataBuilder.set住宅改修完成年月日(new FlexibleDate(
                        new RDate(tmpRow.getTxtKanseiYoteibi().toString()).toDateString()));
                addDataBuilder.set改修金額(tmpRow.getTxtKaishuKingaku().isNullOrEmpty()
                        ? 0 : Integer.parseInt(tmpRow.getTxtKaishuKingaku().toString()));
                addDataBuilder.set差額金額(0);
                addDataBuilder.setステータス(EntityDataState.Added);
                if (サービス種類コード != null) {
                    addDataBuilder.setサービスコード(
                            new ServiceCode(サービス種類コード.value().concat(サービス種類コード固定.toString())));
                }
                addDataBuilder.set事前申請サービス提供年月(dbt3034.get事前申請サービス提供年月())
                        .set審査方法区分コード(dbt3034.get審査方法区分())
                        .set事前申請整理番号(dbt3034.get事前申請整理番号()).build();
                addData = addDataBuilder.build();
                kaishuList.add(addData);
            }
        }
        return kaishuList;
    }

    private ShokanJutakuKaishu 住宅改修レコードの取得(dgGaisyuList_Row data,
            Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> oldDataList) {
        for (ShokanJutakuKaishu tmp : oldDataList.aliveValues()) {
            if (data.getTxtJigyoshaNo().equals(tmp.get事業者番号().value())
                    && data.getTxtMeseiNo().equals(tmp.get明細番号())
                    && data.getTxtRenban().equals(tmp.get連番())) {
                return tmp;
            }
        }
        return null;
    }

    private void 申請事業者理由書作成事業者番号設定(ShokanShinseiBuilder dbt3034Builder) {
        RString 申請事業者番号 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtJigyoshaNo()
                .getValue();
        if (!申請事業者番号.isNullOrEmpty()) {
            dbt3034Builder.set申請事業者番号(new JigyoshaNo(申請事業者番号));
        }
        RString 理由書作成事業者番号 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreationJigyoshaNo().getValue();
        if (!理由書作成事業者番号.isNullOrEmpty()) {
            dbt3034Builder.set理由書作成事業者番号(new JigyoshaNo(理由書作成事業者番号));
        }
    }

    private void set登録モードDB保存(HihokenshaNo 引き継ぎ被保険者番号,
            RString 送付区分,
            FlexibleYearMonth 送付年月, boolean 国保連再送付フラグ, boolean 要介護状態区分3段階変更,
            boolean 住宅住所変更,
            RString 画面モード, JutakukaishuSikyuShinseiManager 住宅改修費支給申請,
            RString 支払方法区分コード, RString 支払場所, FlexibleDate 支払期間開始年月日, FlexibleDate 支払期間終了年月日,
            RString 支払窓口開始時間, RString 支払窓口終了時間, long 口座ID, RString 受領委任契約番号,
            JutakuGaisuViewStateHolderParameter param) {
        ShokanShinsei dbt3034 = new ShokanShinsei(引き継ぎ被保険者番号, new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toDateString()), div.getTxtSeiriNo().getValue());
        RString 審査方法初期 = DbBusinessConfig.get(
                ConfigNameDBC.償還支給申請書_審査方法初期表示, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        AtenaMeisho 画面理由書作成者 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorName().getDomain();
        RString 理由書作成者 = 画面理由書作成者 == null ? RString.EMPTY : 画面理由書作成者.value();
        RDate 理由書作成日 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD()
                .getValue();
        FlexibleDate 理由書作成日Save = 理由書作成日 == null ? null : new FlexibleDate(理由書作成日.toDateString());
        ShokanShinseiBuilder dbt3034Builder = dbt3034.createBuilderForEdit()
                .set証記載保険者番号(new ShoKisaiHokenshaNo(
                                div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey())).set受付年月日(
                        FlexibleDate.getNowDate()).set申請年月日(new FlexibleDate(
                                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD()
                                .getValue().toString())).set申請理由(
                        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue())
                .set申請者区分(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun()
                        .getSelectedKey())
                .set申請者氏名(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName()
                        .getValue()).set申請者氏名カナ(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                        .getTxtShinseishaNameKana()
                        .getValue()).set申請者郵便番号(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                        .getTxtYubinNo().getValue())
                .set申請者住所(div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain()
                        .value()).set申請者電話番号(div.getJutakuKaishuShinseiContents().getShinseishaInfo()
                        .getTxtTelNo().getDomain()).set理由書作成日(理由書作成日Save)
                .set理由書作成者(理由書作成者).set理由書作成者カナ(div.getJutakuKaishuShinseiContents()
                        .getJutakuKaishuShinseiReason()
                        .getTxtCreatorKanaName().getDomain().value()).set支払金額合計(
                        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHiyoTotalNow().getValue())
                .set保険対象費用額(div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().getValue()).set審査方法区分(審査方法初期)
                .set支給申請審査区分(null).set送付区分(送付区分)
                .set送付年月(送付年月).set国保連再送付フラグ(国保連再送付フラグ).set住宅所有者(
                        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue())
                .set被保険者の関係(div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue())
                .set要介護状態３段階変更(要介護状態区分3段階変更)
                .set住宅住所変更(住宅住所変更).set審査年月日(null).set審査結果(null).set住宅改修申請区分(
                        JutakukaishuShinseiKubun.支給申請.getCode()).set住宅改修申請取消事由コード(null)
                .set領収年月日(new FlexibleDate(
                                div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue().toString()))
                .set支払方法区分コード(支払方法区分コード).set支払場所(支払場所).set支払期間開始年月日(支払期間開始年月日)
                .set支払期間終了年月日(支払期間終了年月日).set支払窓口開始時間(支払窓口開始時間)
                .set支払窓口終了時間(支払窓口終了時間).set口座ID(口座ID).set受領委任契約番号(受領委任契約番号);
        ShokanKihon dbt3038 = new ShokanKihon(引き継ぎ被保険者番号, new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()), div.getTxtSeiriNo().getValue(), 償還払請求基本_事業者番号,
                div.getDdlSyomeisyo().getSelectedKey(), 償還払請求基本_明細番号);
        ShokanKihonBuilder dbt3038Builder = dbt3038.createBuilderForEdit().set保険給付率(
                new HokenKyufuRitsu(div.getTxtKyufuritsu().getValue()));
        ShokanShukei dbt3053 = new ShokanShukei(引き継ぎ被保険者番号, new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()), div.getTxtSeiriNo().getValue(), 償還払請求基本_事業者番号,
                div.getDdlSyomeisyo().getSelectedKey(), 償還払請求基本_明細番号, 連番_固定値);
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        ServiceShuruiCode サービス種類コード = 住宅改修費事前申請.getServiceShuruiCode(引き継ぎ被保険者番号,
                new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth()
                        .toDateString()));
        ShokanShukeiBuilder dbt3053Builder = dbt3053.createBuilderForEdit().setサービス種類コード(サービス種類コード);
        List<dgGaisyuList_Row> 画面住宅住所 = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        List<ShokanJutakuKaishu> dbt3049List = new ArrayList<>();
        RString 連番 = 連番から;
        ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請情報 = param.get申請情報();
        for (dgGaisyuList_Row row : 画面住宅住所) {
            ShokanJutakuKaishu dbt3049 = new ShokanJutakuKaishu(dbt3038.get被保険者番号(),
                    dbt3038.getサービス提供年月(), dbt3038.get整理番号(), dbt3038.get事業者番号(),
                    dbt3038.get様式番号(), dbt3038.get明細番号(), 連番);
            連番 = new RString(String.format(FORMAT.toString(), (Integer.parseInt(連番.toString()) + 1)));
            ShokanJutakuKaishuBuilder dbt3049Builder = dbt3049.createBuilderForEdit();
            if (サービス種類コード != null) {
                dbt3049Builder.setサービスコード(
                        new ServiceCode(サービス種類コード.value().concat(サービス種類コード固定.toString())));
            }
            set償還払請求住宅改修(row, dbt3049Builder);
            dbt3049 = dbt3049Builder.set審査方法区分コード(審査方法初期).build();
            if (画面モード_事前申請.equals(画面モード)) {
                dbt3049 = dbt3049Builder.set事前申請サービス提供年月(償還払支給住宅改修事前申請情報.getサービス提供年月())
                        .set事前申請整理番号(償還払支給住宅改修事前申請情報.get整理番号()).build();
            }
            dbt3049List.add(dbt3049);
        }

        Decimal 保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenKyufuAmountNow().getValue();
        if (保険給付額 != null) {
            dbt3034Builder.set保険給付額(保険給付額.intValue());
            dbt3038Builder.set保険請求額(保険給付額);
            dbt3053Builder.set請求額(保険給付額);
        }
        Decimal 利用者負担額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtRiyoshaFutanAmountNow().getValue();
        if (利用者負担額 != null) {
            dbt3034Builder.set利用者負担額(利用者負担額.intValue());
            dbt3038Builder.set利用者負担額(利用者負担額.intValue());
            dbt3053Builder.set利用者負担額(利用者負担額.intValue());
        }
        Decimal 支払金額合計 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalNow().getValue();
        if (支払金額合計 != null) {
            dbt3038Builder.setサービス単位数(支払金額合計.intValue());
        }
        申請事業者理由書作成事業者番号設定(dbt3034Builder);
        if (画面モード_事前申請.equals(画面モード)) {
            dbt3034Builder.set事前申請サービス提供年月(償還払支給住宅改修事前申請情報.getサービス提供年月())
                    .set事前申請整理番号(償還払支給住宅改修事前申請情報.get整理番号());
        }
        dbt3034 = dbt3034Builder.build();
        dbt3038 = dbt3038Builder.build();
        dbt3053 = dbt3053Builder.build();
        住宅改修費支給申請.saveDBDate(dbt3034, dbt3038, dbt3053, dbt3049List);
    }

    private void set償還払請求住宅改修(dgGaisyuList_Row row, ShokanJutakuKaishuBuilder dbt3049Builder) {
        if (row.getTxtChakkoYoteibi() != null) {
            dbt3049Builder.set住宅改修着工年月日(new FlexibleDate(
                    new RDate(row.getTxtChakkoYoteibi().toString()).toDateString()));
        }
        if (row.getTxtKaishuNaiyo() != null) {
            dbt3049Builder.set住宅改修内容(row.getTxtKaishuNaiyo());
        }
        if (row.getTxtJigyosha() != null) {
            dbt3049Builder.set住宅改修事業者名(row.getTxtJigyosha());
        }
        if (row.getTxtJutakuAddress() != null) {
            dbt3049Builder.set住宅改修住宅住所(row.getTxtJutakuAddress());
        }
        if (row.getTxtKaishuKingaku() != null) {
            dbt3049Builder.set改修金額(Integer.parseInt(row.getTxtKaishuKingaku().toString()));
        }
        if (row.getTxtKanseiYoteibi() != null) {
            dbt3049Builder.set住宅改修完成年月日(new FlexibleDate(
                    new RDate(row.getTxtKanseiYoteibi().toString()).toDateString()));
        }
        dbt3049Builder.set差額金額(0);
    }

    /**
     * 償還払決定情報画面へ遷移、パラメータ設定するメソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 画面モード 画面モード
     * @param param JutakuGaisuViewStateHolderParameter
     */
    public void set画面遷移パラメータ(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RString 画面モード,
            JutakuGaisuViewStateHolderParameter param) {
        ShokanharaKeteiJyohoParameter 償還払決定情報 = new ShokanharaKeteiJyohoParameter();
        償還払決定情報.set識別コード(識別コード);
        償還払決定情報.set被保険者番号(被保険者番号);
        償還払決定情報.setサービス提供年月(new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth()
                .toDateString()));
        償還払決定情報.set整理番号(div.getTxtSeiriNo().getValue());
        償還払決定情報.set証明書(div.getDdlSyomeisyo().getSelectedKey());
        償還払決定情報.set給付率(div.getTxtKyufuritsu().getValue());
        償還払決定情報.set画面モード(画面モード);
        償還払決定情報.set保険者番号(new HokenshaNo(
                div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey()));
        param.set償還払決定情報(償還払決定情報);
    }

    private Map<RString, RString> get更新前データ() {
        return 画面データ取得();
    }

    private Map<RString, RString> 画面データ取得() {
        Map<RString, RString> 画面データ = new HashMap<>();
        RDate 提供着工年月 = div.getTxtTeikyoYM().getValue();
        画面データ.put(提供着工年月_キー, 提供着工年月 == null ? null : 提供着工年月.toDateString());
        画面データ.put(証明書_キー, div.getDdlSyomeisyo().getSelectedKey());
        画面データ.put(住宅所有者_キー, div.getJutakuKaishuShinseiContents().getTxtJutakuOwner().getValue());
        画面データ.put(被保険者との関係_キー,
                div.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().getValue());
        RDate 領収日 = div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD().getValue();
        画面データ.put(領収日_キー, 領収日 == null ? null : 領収日.toDateString());
        画面データ.put(保険者_キー,
                div.getJutakuKaishuShinseiContents().getDdlHokensha().getSelectedKey());
        List<RString> 国保連再送付 = div.getJutakuKaishuShinseiContents().getChkKokubo().getSelectedKeys();
        画面データ.put(国保連再送付_キー,
                国保連再送付.isEmpty() ? null : 国保連再送付.get(0));
        List<RString> 限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys();
        int 限度額リセットサイズ = 限度額リセット.size();
        画面データ.put(限度額リセットサイズ_キー, new RString(限度額リセットサイズ));
        if (限度額リセットサイズ > 0) {
            if (限度額リセット.contains(要介護状態区分3段階変更による)) {
                画面データ.put(要介護状態区分3段階変更_キー, 要介護状態区分3段階変更による);
            }
            if (限度額リセット.contains(住宅住所変更による)) {
                画面データ.put(住宅住所変更_キー, 住宅住所変更による);
            }
        }
        画面データ.put(申請内容_キー,
                div.getJutakuKaishuShinseiContents().getShinsaKekkaPanel().getRadShinseiNaiyoyo().getSelectedKey());
        RDate 申請日 = div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD().getValue();
        画面データ.put(申請日_キー, 申請日 == null ? null : 申請日.toDateString());
        画面データ.put(申請者区分_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        画面データ.put(申請理由_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiRiyu().getValue());
        画面データ.put(氏名から_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaNameKana().getValue());
        画面データ.put(氏名_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseishaName().getValue());
        画面データ.put(電話番号_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().getDomain().value());
        画面データ.put(申請取消事由_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        画面データ.put(郵便番号_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtYubinNo().getValue().value());
        画面データ.put(住所_キー,
                div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtAddress().getDomain().value());
        RDate 作成日 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateYMD().getValue();
        画面データ.put(作成日_キー,
                作成日 == null ? null : 作成日.toDateString());
        画面データ.put(作成者氏名から_キー, div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorKanaName().getDomain().value());
        画面データ.put(作成者氏名_キー, div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreatorName().getDomain().value());
        画面データ.put(作成事業者_キー, div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreationJigyoshaNo().getValue());
        画面データ.put(支払方法_キー,
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getShiharaiHohoRad());
        画面データ.put(支払場所_キー,
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getShiharaiBasho());
        RDate 画面支払期間開始年月日 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getStartYMD();
        RString 支払期間開始年月日 = 画面支払期間開始年月日 == null ? null : 画面支払期間開始年月日.toDateString();
        画面データ.put(支払期間開始年月日_キー, 支払期間開始年月日);
        RDate 画面支払期間終了年月日 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getEndYMD();
        RString 支払期間終了年月日 = 画面支払期間終了年月日 == null ? null : 画面支払期間終了年月日.toDateString();
        画面データ.put(支払期間終了年月日_キー, 支払期間終了年月日);
        RTime 画面支払窓口開始時間 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getStartHHMM();
        RString 支払窓口開始時間 = 画面支払窓口開始時間 == null ? null : new RString(画面支払窓口開始時間.toString());
        画面データ.put(支払窓口開始時間_キー, 支払窓口開始時間);
        RTime 画面支払窓口終了時間 = div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getEndHHMM();
        RString 支払窓口終了時間 = 画面支払窓口終了時間 == null ? null : new RString(画面支払窓口終了時間.toString());
        画面データ.put(支払窓口終了時間_キー, 支払窓口終了時間);
        画面データ.put(口座_キー,
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getKozaNo());
        画面データ.put(受領委任契約番号_キー,
                div.getJutakuKaishuShinseiContents().getCcdShiharaiHohoJyoho().getKeiyakuNo());
        return 画面データ;
    }

    private Map<RString, RString> get画面データ() {
        return 画面データ取得();
    }

    /**
     * 画面のデータが変更されているがないかの判断
     *
     * @param 画面モード RString
     * @param param JutakuGaisuViewStateHolderParameter
     * @return (true:画面データが変更される ; false:画面データが変更されない)
     */
    public boolean is画面データが変更(RString 画面モード, JutakuGaisuViewStateHolderParameter param) {
        if (!画面モード_修正.equals(画面モード)) {
            return true;
        }
        Map<RString, RString> 更新前データmap = param.get申請情報登録_更新前データ();
        Map<RString, RString> 画面データmap = get画面データ();
        if (更新前データmap.size() != 画面データmap.size()) {
            return true;
        }
        for (Entry<RString, RString> entry : 更新前データmap.entrySet()) {
            RString 更新前データkey = entry.getKey();
            for (Entry<RString, RString> entry1 : 画面データmap.entrySet()) {
                RString 画面データkey = entry1.getKey();
                if (更新前データkey.equals(画面データkey)) {
                    if (entry.getValue() == null && entry1.getValue() == null) {
                        break;
                    }
                    if (is更新前と画面正常項目データが変更OK(entry, entry1)) {
                        return true;
                    }
                    break;
                }
            }
        }
        List<JutakuGaisuListDataParameter> 住宅住所更新前データ = param.get住宅改修内容();
        List<dgGaisyuList_Row> 画面住宅住所一覧 = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        List<dgGaisyuList_Row> 画面住宅住所 = new ArrayList<>();
        Decimal 画面費用額合計 = Decimal.ZERO;
        boolean is住宅改修内容削除 = false;
        boolean is住宅改修内容追加 = false;
        for (dgGaisyuList_Row 画面住宅住所非削除 : 画面住宅住所一覧) {
            if (画面住宅住所非削除.getTxtRenban().isNullOrEmpty()) {
                is住宅改修内容追加 = true;
                画面住宅住所.add(画面住宅住所非削除);
                画面費用額合計 = 画面費用額合計.add(new Decimal(画面住宅住所非削除.getTxtKaishuKingaku().toString()));
            } else if (!行状態_削除.equals(画面住宅住所非削除.getTxtJyotai())
                    && !画面住宅住所非削除.getTxtRenban().isNullOrEmpty()) {
                画面住宅住所.add(画面住宅住所非削除);
                画面費用額合計 = 画面費用額合計.add(new Decimal(画面住宅住所非削除.getTxtKaishuKingaku().toString()));
            } else {
                is住宅改修内容削除 = true;
            }
        }
        if (is住宅改修内容削除 || is住宅改修内容追加) {
            return true;
        }
        if (住宅住所更新前データ.size() != 画面住宅住所.size() || 住宅住所更新前データ.size() != 画面住宅住所一覧.size()) {
            return true;
        }
        if (住宅住所更新前データ.isEmpty() && 画面住宅住所.isEmpty()) {
            return false;
        } else {
            return is住宅改修データ変更(住宅住所更新前データ, 画面住宅住所);
        }
    }

    private boolean is更新前と画面正常項目データが変更OK(Entry<RString, RString> entry, Entry<RString, RString> entry1) {
        return (entry.getValue() == null && entry1.getValue() != null)
                || (entry.getValue() != null && entry1.getValue() == null)
                || (!entry.getValue().equals(entry1.getValue()));
    }

    /**
     * 費用額合計の取得するメソッドです。
     *
     * @return 費用額合計
     */
    public Decimal 費用額合計の取得() {
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        Decimal 費用額合計 = Decimal.ZERO;
        for (dgGaisyuList_Row tmpRow : gridList) {
            RString 改修金額 = tmpRow.getTxtKaishuKingaku();
            if ((!行状態_削除.equals(tmpRow.getTxtJyotai())) && 改修金額 != null) {
                費用額合計 = 費用額合計.add(new Decimal(改修金額.toString()));
            }
        }
        return 費用額合計;
    }

    /**
     * 限度額リセット有効性チェックするメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void 支払結果の設定(HihokenshaNo 被保険者番号) {
        Decimal 支給限度額 = 支給限度額の取得(被保険者番号);
        Decimal 費用額合計 = this.費用額合計の取得();
        Decimal 画面前回までの費用額合計 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHiyoTotalMae().getValue();
        Decimal 前回までの費用額合計 = 画面前回までの費用額合計 == null ? Decimal.ZERO : 画面前回までの費用額合計;
        Decimal 画面前回までの被保険対象額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getTxtHokenTaishoHiyoMae().getValue();
        Decimal 前回までの被保険対象額 = 画面前回までの被保険対象額 == null ? Decimal.ZERO : 画面前回までの被保険対象額;
        Decimal 給付率 = div.getTxtKyufuritsu().getValue();
        if (div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys().isEmpty()) {
            if (費用額合計.add(前回までの費用額合計).compareTo(支給限度額) > 0) {
                Decimal 今回被保険対象額 = 支給限度額.subtract(前回までの被保険対象額).compareTo(Decimal.ZERO) < 0
                        ? Decimal.ZERO : 支給限度額.subtract(前回までの被保険対象額);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(今回被保険対象額);
                Decimal 画面前回までの保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountMae().getValue();
                Decimal 前回までの保険給付額 = 画面前回までの保険給付額 == null ? Decimal.ZERO : 画面前回までの保険給付額;
                今回の被保険対象額設定(今回被保険対象額, 支給限度額, 給付率, 前回までの保険給付額);
                Decimal 今回の保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow()
                        .setValue(費用額合計.subtract(今回の保険給付額).compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 費用額合計.subtract(今回の保険給付額));
            } else if (費用額合計.add(前回までの費用額合計).compareTo(支給限度額) <= 0) {
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(費用額合計);
                Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(被除数).roundDownTo(0);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow()
                        .setValue(費用額合計.subtract(今回保険給付額).compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 費用額合計.subtract(今回保険給付額));
            }
        } else {
            if (費用額合計.compareTo(支給限度額) > 0) {
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(支給限度額);
                Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(被除数).roundDownTo(0);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow()
                        .setValue(費用額合計.subtract(今回保険給付額).compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 費用額合計.subtract(今回保険給付額));
            } else if (費用額合計.compareTo(支給限度額) <= 0) {
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().setValue(費用額合計);
                Decimal 画面今回の被保険対象額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenTaishoHiyoNow().getValue();
                Decimal 今回の保険給付額 = 画面今回の被保険対象額.multiply(給付率).divide(被除数).roundDownTo(0);
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
                Decimal 今回保険給付額 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                        .getTxtHokenKyufuAmountNow().getValue();
                div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo().getTxtRiyoshaFutanAmountNow()
                        .setValue(費用額合計.subtract(今回保険給付額).compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 費用額合計.subtract(今回保険給付額));
            }
        }
    }

    private Decimal 支給限度額の取得(HihokenshaNo 被保険者番号) {
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toString());
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        return 住宅改修費事前申請.getShikyuGendoGaku(被保険者番号, 画面提供着工年月);
    }

    private void 今回の被保険対象額設定(Decimal 今回被保険対象額, Decimal 支給限度額, Decimal 給付率,
            Decimal 前回までの保険給付額) {
        if (今回被保険対象額.compareTo(Decimal.ONE) > 0) {
            Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(被除数).roundDownTo(0)
                    .subtract(前回までの保険給付額);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.compareTo(Decimal.ZERO) < 0
                            ? Decimal.ZERO : 今回の保険給付額);
        } else if (Decimal.ZERO.equals(今回被保険対象額)) {
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtHokenKyufuAmountNow().setValue(Decimal.ZERO);
        }
    }

    /**
     * 限度額チェックするメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     * @return (OK：限度額を超えない、NG:限度額を超える)
     */
    public boolean is限度額を超えない(HihokenshaNo 被保険者番号, RString 整理番号) {
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
                被保険者番号, 画面提供着工年月, 整理番号, 限度リセットフラグ,
                今回の保険対象費用額 == null ? Decimal.ZERO : 今回の保険対象費用額);
    }

    /**
     * 確認対象変更有無チェックするメソッドです。
     *
     * @param param JutakuGaisuViewStateHolderParameter
     * @return (true;変更有、false:変更無)
     */
    public boolean is確認対象変更有無チェック(JutakuGaisuViewStateHolderParameter param) {
        JutakuGaisuDataParameter 住宅改修データ = param.get住宅改修データ();
        if (住宅改修データ != null) {
            List<dgGaisyuList_Row> 画面住宅改修データ = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                    .get住宅改修内容一覧();
            Decimal 画面費用額合計 = Decimal.ZERO;
            for (dgGaisyuList_Row 住宅住所非削除 : 画面住宅改修データ) {
                if (住宅住所非削除.getTxtRenban().isNullOrEmpty() || (!行状態_削除.equals(住宅住所非削除.getTxtJyotai())
                        && !住宅住所非削除.getTxtRenban().isNullOrEmpty())) {
                    画面費用額合計 = 画面費用額合計.add(new Decimal(住宅住所非削除.getTxtKaishuKingaku().toString()));
                }
            }
            Decimal 今回の支払状況 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getTxtHiyoTotalNow().getValue();
            if (!画面費用額合計.equals(今回の支払状況)) {
                return true;
            }
            List<RString> 限度額リセット = 住宅改修データ.get限度額リセット();
            List<RString> 画面限度額リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                    .getChkResetInfo().getSelectedKeys();
            if (限度額リセット == null || (限度額リセット.size() != 画面限度額リセット.size())
                    || is限度額リセット値変更(限度額リセット, 画面限度額リセット)) {
                return true;
            }
        }
        return false;
    }

    private boolean is住宅改修データ変更(List<JutakuGaisuListDataParameter> 住宅改修データdgList,
            List<dgGaisyuList_Row> gridList) {
        boolean is住宅改修データ変更 = false;
        for (int i = 0; i < gridList.size(); i++) {
            JutakuGaisuListDataParameter param = 住宅改修データdgList.get(i);
            dgGaisyuList_Row gridRow = gridList.get(i);
            is住宅改修データ変更 = is住宅改修データ変更OK(param.getTxtJutakuAddress(), gridRow.getTxtJutakuAddress())
                    || is住宅改修データ変更OK(param.getTxtJyotai(), gridRow.getTxtJyotai())
                    || is住宅改修データ変更OK(param.getTxtChakkoYoteibi(), gridRow.getTxtChakkoYoteibi())
                    || is住宅改修データ変更OK(param.getTxtJigyosha(), gridRow.getTxtJigyosha())
                    || is住宅改修データ変更OK(param.getTxtJigyoshaNo(), gridRow.getTxtJigyoshaNo())
                    || is住宅改修データ変更OK(param.getTxtKaishuNaiyo(), gridRow.getTxtKaishuNaiyo())
                    || is住宅改修データ変更OK(param.getTxtKanseiYoteibi(), gridRow.getTxtKanseiYoteibi())
                    || is住宅改修データ変更OK(param.getTxtKaishuKingaku(), gridRow.getTxtKaishuKingaku())
                    || is住宅改修データ変更OK(param.getTxtMeseiNo(), gridRow.getTxtMeseiNo())
                    || is住宅改修データ変更OK(param.getTxtRenban(), gridRow.getTxtRenban())
                    || is住宅改修データ変更OK(param.getTxtSeiriNo(), gridRow.getTxtSeiriNo());
            if (is住宅改修データ変更) {
                break;
            }
        }
        if (is住宅改修データ変更) {
            return is住宅改修データ変更;
        }
        return false;
    }

    private boolean is住宅改修データ変更OK(RString 更新前, RString 更新後) {
        if ((更新前 == null && 更新後 != null)
                || (更新前 != null && 更新後 == null)
                || (更新前 != null && 更新後 != null && !更新前.equals(更新後))) {
            return true;
        }
        return false;
    }

    private boolean is限度額リセット値変更(List<RString> 限度額リセット, List<RString> 画面限度額リセット) {
        if (!限度額リセット.isEmpty()) {
            return !限度額リセット.get(0).equals(画面限度額リセット.get(0));
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
        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtTelNo().setDomain(
                div.getJutakuKaishuShinseiHihokenshaPanel().getKaigoAtenaInfo().getAtenaInfoDiv().
                getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get連絡先１());
    }

    /**
     * 過去の住宅改修費取得と支払結果の設定するメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param param JutakuGaisuViewStateHolderParameter
     */
    public void 過去の住宅改修費取得と支払結果の設定(HihokenshaNo 被保険者番号, JutakuGaisuViewStateHolderParameter param) {
        FlexibleYearMonth 画面提供着工年月 = new FlexibleYearMonth(
                div.getTxtTeikyoYM().getValue().getYearMonth().toDateString());
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        RString 住宅住所 = RString.EMPTY;
        if (!gridList.isEmpty()) {
            住宅住所 = gridList.get(0).getTxtJutakuAddress();
        }
        JutakuKaishuJizenShinsei 住宅改修費事前申請 = JutakuKaishuJizenShinsei.createInstance();
        ShiharaiKekkaResult 住宅改修費支払結果 = 住宅改修費事前申請.getJutakuKaishuHi(
                被保険者番号, 画面提供着工年月, 住宅住所);
        前回まで支払結果の初期化(住宅改修費支払結果, true, 被保険者番号);
        ShiharaiKekkaResult 前回までの支払結果 = param.get過去住宅改修費支払結果();
        RString 前回まで住宅住所 = RString.EMPTY;
        if (前回までの支払結果 != null) {
            前回まで住宅住所 = 前回までの支払結果.get住宅改修住宅住所();
        }
        List<RString> 限度リセット = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().getSelectedKeys();
        if (!住宅住所.equals(前回まで住宅住所)) {
            if (!限度リセット.contains(住宅住所変更による)) {
                限度リセット.add(住宅住所変更による);
            }
        } else {
            if (限度リセット.contains(住宅住所変更による)) {
                限度リセット.remove(住宅住所変更による);
            }
        }
        div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiResetInfo()
                .getChkResetInfo().setSelectedItemsByKey(限度リセット);
        JutakuGaisuDataParameter 住宅改修データ = new JutakuGaisuDataParameter();
        住宅改修データ.set住宅改修データ(get住宅改修内容一覧データ(gridList));
        param.set住宅改修データ(住宅改修データ);
    }

    /**
     * 作成事業者名称を取得するメソッドです。
     */
    public void get作成事業者名() {
        RString 作成事業者番号 = div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                .getTxtCreationJigyoshaNo().getValue();
        if (!作成事業者番号.isNullOrEmpty()) {
            JigyoshaNo 作成事業者 = new JigyoshaNo(作成事業者番号);
            AtenaMeisho 作成事業者名称 = JutakuKaishuJizenShinsei.createInstance().getJigyoshaName(作成事業者);
            div.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason()
                    .getTxtCreationJigyoshaName().setDomain(作成事業者名称);
        }
    }

    /**
     * 住宅改修内容のチェックするメソッドです。
     *
     * @return 住宅改修内容チェックエラーメッセージ
     */
    public RString 住宅改修内容一覧チェック() {
        List<dgGaisyuList_Row> gridList = div.getJutakuKaishuShinseiContents().getCcdJutakugaisyunaiyoList()
                .get住宅改修内容一覧();
        List<JyutakuGaisyunaiyoListParameter> paramList = new ArrayList<>();
        JyutakuGaisyunaiyoListParameter param;
        for (dgGaisyuList_Row row : gridList) {
            RString 状態 = RString.EMPTY.equals(row.getTxtJyotai()) ? 住宅改修_状態 : row.getTxtJyotai();
            param = JyutakuGaisyunaiyoListParameter.createSelectByKeyParam(
                    状態, row.getTxtJutakuAddress(),
                    new FlexibleDate(new RDate(row.getTxtChakkoYoteibi().toString()).toDateString()));
            paramList.add(param);
        }
        return JutakukaishuSikyuShinseiManager.createInstance().checkJyutakuGaisyunaiyoList(paramList,
                new FlexibleYearMonth(div.getTxtTeikyoYM().getValue().getYearMonth().toDateString()));
    }
}
