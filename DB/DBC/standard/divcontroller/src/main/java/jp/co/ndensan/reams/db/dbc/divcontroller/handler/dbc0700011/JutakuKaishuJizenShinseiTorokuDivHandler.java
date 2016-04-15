/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0700011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishusikyushinsei.JutakuKaishuShikyuGendogakuHantei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei.JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager;
import jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiTsuchishoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
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
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 住宅改修費支給申請ハンドラークラスです
 *
 * @reamsid_L DBC-0990-060 panhe
 */
public final class JutakuKaishuJizenShinseiTorokuDivHandler {

    private final JutakuKaishuJizenShinseiTorokuDiv div;
    private static final RString 登録モード = new RString("登録");
    private static final RString 取消モード = new RString("取消");
    private static final RString 削除モード = new RString("削除");
    private static final RString 修正モード = new RString("修正");
    private static final RString 照会モード = new RString("照会");
    private static final RString コード種別 = new RString("0028");
    private static final RString 取消事由なし = new RString("0");
    private static final RString 申請情報 = new RString("申請情報");
    private static final RString 口座情報 = new RString("口座情報");
    private static final RString 住宅改修情報 = new RString("住宅改修情報");
    private static final RString 審査結果 = new RString("審査結果");
    private static final RString サービス年月 = new RString("サービス年月");
    private static final RString 住宅所有者 = new RString("住宅所有者");
    private static final RString 判定決定日 = new RString("判定決定日");
    private static final RString 不承認理由 = new RString("不承認理由");
    private static final RString 申請取消事由 = new RString("申請取消事由");
    private static final RString 発行日 = new RString("発行日");
    private static final RString 文字_1 = new RString("1");
    private static final RString 文字_2 = new RString("2");
    private static final RString 要介護状態区分_KEY = new RString("threeUp");
    private static final RString 要介護状態区分_VALUE = new RString("要介護状態区分３段階変更による");
    private static final RString 住宅住所変更_KEY = new RString("changeAddress");
    private static final RString 住宅住所変更_VALUE = new RString("住宅住所変更による");
    private static final Decimal 数字_100 = new Decimal("100");
    private static final RString 償還払給付費 = new RString("001");
    private static final RString メッセージ引数_着工日完成日 = new RString("着工日、または完成日");
    private static final RString メッセージ引数_着工日 = new RString("着工日");
    private static final RString 初期化済み = new RString("true");

    private JutakuKaishuJizenShinseiTorokuDivHandler(JutakuKaishuJizenShinseiTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです
     *
     * @param div 画面DIV
     * @return Mainハンドラークラス
     */
    public static JutakuKaishuJizenShinseiTorokuDivHandler of(JutakuKaishuJizenShinseiTorokuDiv div) {
        return new JutakuKaishuJizenShinseiTorokuDivHandler(div);
    }

    /**
     * 画面の初期化するメソッド
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     */
    public void 登録以外初期化(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {
        ShokanJutakuKaishuJizenShinsei result = JutakuKaishuJizenShinsei.createInstance()
                .getJutakuKaishuJizenShinseiJyoho(被保険者番号, サービス提供年月, 整理番号);
        if (result == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        ViewStateHolder.put(ViewStateKeys.償還払支給住宅改修事前申請情報, result);
//        loadTabShinseiJyoho(result);
    }

    /**
     * 本人情報をコピーする
     */
    public void 本人情報をコピーする() {
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana()
                .setValue(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名カナ());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName()
                .setValue(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名漢字());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo()
                .setDomain(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().getAtenaInfoDiv()
                        .getAtenaShokaiSimpleData().getShikibetsuTaishoHisory().get直近().get連絡先１());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo()
                .setValue(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get郵便番号());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress()
                .setDomain(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get住所());
    }

    /**
     * 給付率の設定
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void 給付率設定(HihokenshaNo 被保険者番号) {
        RDate 画面サービス年月 = div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue();
        if (画面サービス年月 == null) {
            div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().setValue(RString.EMPTY);
        } else {
            HokenKyufuRitsu result = JutakuKaishuJizenShinsei.createInstance().getKyufuritsu(被保険者番号,
                    new FlexibleYearMonth(画面サービス年月.getYearMonth().toDateString()));
            div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().setValue(new RString(result.value().toString()));
        }
    }

    /**
     * 申請情報タブの初期化
     *
     * @param param ShokanJutakuKaishuJizenShinsei
     */
    private void loadTabShinseiJyoho(ShokanJutakuKaishuJizenShinsei param) {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                .setValue(new RDate(param.getサービス提供年月().toString()));
        div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu()
                .setValue(new RString(param.get保険給付率().value().toString()));

        div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner()
                .setValue(param.get住宅所有者());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtRelationWithHihokensha()
                .setValue(param.get被保険者との関係());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD()
                .setValue(new RDate(param.get申請年月日().toString()));
        List<KeyValueDataSource> shinseishaKubunList = new ArrayList<>();
        shinseishaKubunList.add(new KeyValueDataSource(
                ShinseishaKubun.本人.getコード(), ShinseishaKubun.本人.get名称()));
        shinseishaKubunList.add(new KeyValueDataSource(
                ShinseishaKubun.代理人.getコード(), ShinseishaKubun.代理人.get名称()));
        shinseishaKubunList.add(new KeyValueDataSource(
                ShinseishaKubun.受領委任事業者.getコード(), ShinseishaKubun.受領委任事業者.get名称()));
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun()
                .setDataSource(shinseishaKubunList);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun()
                .setSelectedKey(param.get申請者区分());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiRiyu()
                .setValue(param.get申請理由());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtJigyoshaNo()
                .setValue(param.get事業者番号().value());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName()
                .setValue(param.get申請者氏名());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana()
                .setValue(param.get申請者氏名カナ());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo()
                .setDomain(param.get申請者電話番号());

        List<KeyValueDataSource> torikeshiList = new ArrayList<>();
        KeyValueDataSource blank = new KeyValueDataSource(取消事由なし, RString.EMPTY);
        torikeshiList.add(blank);
        List<UzT0007CodeEntity> 取消事由リスト = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                new CodeShubetsu(コード種別), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity 取消事由 : 取消事由リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource(取消事由.getコード().value(), 取消事由.getコード名称());
            torikeshiList.add(dataSource);
        }
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDataSource(torikeshiList);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu()
                .setSelectedKey(param.get住宅改修申請取消事由コード());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().setValue(param.get申請者郵便番号());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress()
                .setDomain(new AtenaJusho(param.get申請者住所()));
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreateYMD()
                .setValue(new RDate(param.get理由書作成日().toString()));
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorKanaName()
                .setDomain(new AtenaKanaMeisho(param.get理由書作成者カナ()));
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorName()
                .setDomain(new AtenaMeisho(param.get理由書作成者()));
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaNo()
                .setValue(param.get理由書作成事業者番号().value());

        AtenaMeisho 作成事業者名称 = JutakuKaishuJizenShinsei.createInstance().getJigyoshaName(param.get理由書作成事業者番号());
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaName()
                .setValue(作成事業者名称.value());
//        div.setHidShinseiJyohoFlg(初期化済み);
    }

    /**
     * タブ選択変更
     *
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     */
    public void タブ選択変更(RString 画面モード, HihokenshaNo 被保険者番号) {
        RString selectedTab = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getSelectedItem().getTitle();
        ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                ShokanJutakuKaishuJizenShinsei.class);

        if (口座情報.equals(selectedTab) && !初期化済み.equals(div.getHidKozaJyohoFlg())) {
            SikyuSinseiJyohoParameter param = new SikyuSinseiJyohoParameter();
            if (登録モード.equals(画面モード)) {
                param.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
                param.setHihokenshaNo(data.get被保険者番号());
                param.setShikyushinseiServiceYM(data.getサービス提供年月());
                param.setShikyushinseiSeiriNo(data.get整理番号());
            } else {
                param.setShikibetsuCode(ViewStateHolder.get(ViewStateKeys.識別コード, ShikibetsuCode.class));
                param.setHihokenshaNo(data.get被保険者番号());
                param.setShikyushinseiServiceYM(data.getサービス提供年月());
                param.setShikyushinseiSeiriNo(data.get整理番号());
                param.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(data.get支払方法区分コード()));
                param.setShiharaiBasho(data.get支払場所());
                param.setStartYMD(new RDate(data.get支払期間開始年月日().toString()));
                param.setEndYMD(new RDate(data.get支払期間終了年月日().toString()));
                param.setStartHHMM(new RTime(data.get支払窓口開始時間()));
                param.setEndHHMM(new RTime(data.get支払窓口終了時間()));
                param.setKozaId(data.get口座ID());
                param.setKeiyakuNo(data.get受領委任契約番号());
            }
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().initialize(param, new KamokuCode(償還払給付費), 画面モード);
            div.setHidKozaJyohoFlg(初期化済み);
        } else if (住宅改修情報.equals(selectedTab) && !初期化済み.equals(div.getHidJutakuKaisyuJyohoFlg())) {
            if (登録モード.equals(画面モード)) {
                // TODO QAのNo.157(Redmine#75208)「住宅改修内容一覧」共有子Divが登録モードとして初期化する

                ShiharaiKekkaResult result = JutakuKaishuJizenShinsei.createInstance()
                        .getNewJutakuKaishuHi(被保険者番号);
                loadTabKozaJyoho(result);
            } else {
                // TODO 引き継ぎデータの取得はやっていない、ダミー値を設定する
                HihokenshaNo hihokenshaNo = new HihokenshaNo("800000008");
                FlexibleYearMonth flexibleYearMonth = new FlexibleYearMonth("199008");
                RString seiriNo = new RString("0000000001");
                RString yoshikiNo = JutakuKaishuJizenShinsei.createInstance()
                        .getYoshikiNo(hihokenshaNo, flexibleYearMonth, seiriNo);
                // TODO 「住宅改修内容一覧」共有子Divのload

                ShiharaiKekkaResult result = JutakuKaishuJizenShinsei.createInstance()
                        .getOldJutakuKaishuHi(被保険者番号, flexibleYearMonth, seiriNo);
                loadTabKozaJyoho(result);
            }
            div.setHidJutakuKaisyuJyohoFlg(初期化済み);
        } else if (審査結果.equals(selectedTab) && !初期化済み.equals(div.getHidSeikyuSummaryFlg())) {
            if (!登録モード.equals(画面モード)) {
                loadTabShinsaKakka(data, 画面モード);
            }
            div.setHidSeikyuSummaryFlg(初期化済み);
        }
    }

    /**
     * 住宅改修内容のチェック
     */
    public void 住宅改修内容のチェック() {
        // TODO 「住宅改修内容一覧」共有子DIV

        if (div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(サービス年月.toString()));
        }

        RString kubun = DbBusinessConifg.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        // TODO
        kubun = new RString("3");
        if (文字_1.equals(kubun)) {
            // TODO 住宅改修内容一覧に有効の着工日、完成日のいすれの年月と一致しないと、エラーとする

            throw new ApplicationException(DbcErrorMessages.サービス年月と不一致.getMessage()
                    .replace(メッセージ引数_着工日完成日.toString()));
        } else if (文字_2.equals(kubun)) {
            // TODO 住宅改修内容一覧に有効の着工日は画面．サービス年月と同月しないと、エラーとする

            throw new ApplicationException(DbcErrorMessages.サービス年月と不一致.getMessage()
                    .replace(メッセージ引数_着工日.toString()));
        }
    }

    /**
     * 入力チェック
     *
     * @param 画面モード RString
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 入力チェック(RString 画面モード, HihokenshaNo hihokenshaNo) {
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().getValue().isNullOrEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(住宅所有者.toString()));
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD()
                .getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(判定決定日.toString()));
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason()
                .getValue().isNullOrEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(不承認理由.toString()));
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(発行日.toString()));
        }
        住宅改修内容のチェック();

        if (登録モード.equals(画面モード)) {
            return 要介護認定有効のチェック(hihokenshaNo);
        } else if (取消モード.equals(画面モード)) {
            if (取消事由なし.equals(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu()
                    .getSelectedKey())) {
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(申請取消事由.toString()));
            }
        }
        return false;
    }

    /**
     * 承認結果通知書作成
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 整理番号 RString
     * @param 画面モード RString
     */
    public void 承認結果通知書作成(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, RString 整理番号, RString 画面モード) {
        boolean 出力チェックON = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish();
        if (削除モード.equals(画面モード) || 取消モード.equals(画面モード) || !出力チェックON) {
            return;
        }

        ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                ShokanJutakuKaishuJizenShinsei.class);
        if (修正モード.equals(画面モード)
                && !出力チェックON
                && new RString(data.get判定決定年月日().toString()).equals(div.getKaigoShikakuKihonShaPanel()
                        .getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString())
                && data.get判定区分().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getRadJudgeKubun().getSelectedKey())
                && data.get承認条件().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getTxtShoninCondition().getValue())
                && data.get不承認理由().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getTxtFushoninReason().getValue())
                && new RString(data.get事前申請決定通知発行日().toString()).equals(div.getKaigoShikakuKihonShaPanel()
                        .getTabShinseiContents().getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho()
                        .getTxtHakkoYMD().getValue().toDateString())) {
            return;
        }

        JutakuKaishuJizenShinseiParameter parameter = new JutakuKaishuJizenShinseiParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.set被保険者氏名(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名漢字());
        parameter.set識別コード(識別コード);
        parameter.set申請日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtShinseiYMD().getValue().toDateString()));
        parameter.set判定区分(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getRadJudgeKubun().getSelectedKey());
        if (ShoninKubun.承認する.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())) {
            parameter.set承認条件(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtShoninCondition().getValue());
        } else {
            parameter.set不承認理由(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtFushoninReason().getValue());
        }
        parameter.set発行日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD().getValue().toDateString()));
        parameter.set事業者名(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtJigyoshaNo().getValue());
        parameter.set承認年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString()));
        parameter.set不承認の理由(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getTxtFushoninReason().getValue());
        parameter.set作成者氏名(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorName().getDomain().value());
        parameter.setサービス提供年月(new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                .getValue().getYearMonth().toDateString()));
        parameter.set整理番号(整理番号);
        parameter.set費用額合計(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue());
        parameter.set保険対象費用額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenTaishoHiyoNow().getValue());
        parameter.set保険給付額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenKyufuAmountNow().getValue());
        parameter.set利用者負担額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue());
        parameter.set住宅改修住宅住所(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress().getDomain().value());

        JutakuKaishuJizenShinseiTsuchishoManager.createInstance().createJutakuKaishuJizenShinseiTsuchisho(parameter);
    }

    /**
     * 要介護認定有効のチェック
     *
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 要介護認定有効のチェック(HihokenshaNo hihokenshaNo) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                .getValue().getYearMonth().toDateString());
        YokaigoNinteiJyoho result = JutakuKaishuJizenShinsei.createInstance().getYokaigoNinteiJyoho(hihokenshaNo,
                サービス提供年月);
        Code 要介護認定状態区分コード = result.get要介護認定状態区分コード();

        List<RString> 要介護認定状態区分コードリスト = new ArrayList<>();
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.非該当.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援_経過的要介護.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援1.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要支援2.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護1.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護2.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護3.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護4.getCode());
        要介護認定状態区分コードリスト.add(YoKaigoJotaiKubun.要介護5.getCode());
        if (!要介護認定状態区分コードリスト.contains(要介護認定状態区分コード.getKey())) {
            // TODO DBCErrorMessages．要介護状態になっていないため、事前申請できません。
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(申請取消事由.toString()));
        }

        if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護認定状態区分コード.getKey())) {
            if (result.is旧措置者フラグ()) {
                return true;
            } else {
                // TODO DBCErrorMessages．要介護状態になっていないため、事前申請できません。
                throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(申請取消事由.toString()));
            }
        }
        return false;
    }

    /**
     * 過去の住宅改修費取得
     *
     * @param hihokenshaNo HihokenshaNo
     */
    public void 過去の住宅改修費取得(HihokenshaNo hihokenshaNo) {
        // TODO ダミー値を設定
        RString 住宅住所 = new RString("住宅住所");
        ShiharaiKekkaResult result = JutakuKaishuJizenShinsei.createInstance().getJutakuKaishuHi(hihokenshaNo,
                new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue().getYearMonth().toDateString()),
                住宅住所);
        if (result == null) {
            return;
        }

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalMae().setValue(result.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoMae().setValue(result.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountMae().setValue(result.get保険給付額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountMae().setValue(result.get利用者負担額());

        KeyValueDataSource item = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        if (住宅住所.equals(result.get住宅改修住宅住所())) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getChkResetInfo().getSelectedItems().add(item);
        } else {
            List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
            if (selectedItems.contains(item)) {
                selectedItems.remove(item);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                        .getChkResetInfo().setSelectedItems(selectedItems);
            }
        }
        ViewStateHolder.put(ViewStateKeys.住宅改修データ, result);
    }

    /**
     * 費用額合計の設定
     */
    public void 費用額合計の設定() {
        // TODO 「住宅改修内容一覧」共有子DIVのグリッドのレコード分処理を繰り返して、改修金額の計算を行う
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalNow().setValue(Decimal.TEN);
    }

    /**
     * 要介護状態３段階変更の有効性チェック
     *
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 要介護状態３段階変更の有効性チェック(HihokenshaNo hihokenshaNo) {
        FlexibleYearMonth yearMonth = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString());

        return JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.createInstance()
                .checkYaokaigoJyotaiSandannkai(hihokenshaNo, yearMonth);
    }

    /**
     * 改修住所変更による限度額リセットチェック
     *
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 改修住所変更による限度額リセットチェック(HihokenshaNo hihokenshaNo) {
        // TODO ダミー値を設定
        RString 住宅住所 = new RString("住宅住所");
        FlexibleYearMonth yearMonth = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString());
        return JutakuKaishuJyusyoChofukuHanntei.createInstance()
                .checkKaishuJyusyoChofukuToroku(hihokenshaNo, yearMonth, 住宅住所);
    }

    /**
     * 限度額チェック
     *
     * @param hihokenshaNo HihokenshaNo
     * @param seiriNo RString
     * @return チェック結果
     */
    public boolean 限度額チェック(HihokenshaNo hihokenshaNo, RString seiriNo) {
        FlexibleYearMonth yearMonth = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString());

        boolean resetFlg = true;
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        if (!selectedItems.contains(要介護状態区分) && !selectedItems.contains(住宅住所変更)) {
            resetFlg = false;
        }
        Decimal hiyoTotalNow = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue();

        JutakuKaishuShikyuGendogakuHantei test = new JutakuKaishuShikyuGendogakuHantei();

        return test.checkJutakukaishuShikyuGendogaku(hihokenshaNo, yearMonth, seiriNo, resetFlg, hiyoTotalNow);
    }

    /**
     * 支払結果の設定
     *
     * @param hihokenshaNo HihokenshaNo
     */
    public void 支払結果の設定(HihokenshaNo hihokenshaNo) {
        // TODO ダミー値を設定 「住宅改修内容一覧」共有子Divの一覧Gridに「着工予定日」
        FlexibleYearMonth 着工予定日 = FlexibleYearMonth.MAX;
        Decimal 支給限度額 = JutakuKaishuJizenShinsei.createInstance().getShikyuGendoGaku(hihokenshaNo, 着工予定日);

        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        if (!selectedItems.contains(要介護状態区分) && !selectedItems.contains(住宅住所変更)) {
            setチェックしない保険給付額(支給限度額);
        } else {
            setチェックする保険給付額(支給限度額);
        }
    }

    /**
     * 保険給付額の設定
     *
     * @param 支給限度額 Decimal
     */
    private void setチェックしない保険給付額(Decimal 支給限度額) {
        Decimal 費用額合計 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue();
        if (費用額合計.add(費用額合計).compareTo(支給限度額) > 0) {
            Decimal 前回までの被保険対象額 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoMae().getValue();
            Decimal 今回の被保険対象額 = 支給限度額.compareTo(前回までの被保険対象額) < 0 ? Decimal.ZERO : 支給限度額
                    .subtract(前回までの被保険対象額);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(今回の被保険対象額);
            if (今回の被保険対象額.compareTo(Decimal.ONE) > 0) {
                Decimal 前回までの保険給付額 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountMae().getValue();
                Decimal 給付率 = new Decimal(div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().getValue().toString());
                Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(数字_100).subtract(前回までの保険給付額);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 今回の保険給付額.minusToZero());
            } else if (今回の被保険対象額.compareTo(Decimal.ONE) == 0) {
                Decimal 今回の保険給付額 = Decimal.ZERO;
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
            }
            Decimal 今回の利用者負担額 = 費用額合計.subtract(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(費用額合計);
            Decimal 給付率 = new Decimal(div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().getValue().toString());
            Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(数字_100);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.minusToZero());
            Decimal 今回の利用者負担額 = 費用額合計.subtract(今回の保険給付額.minusToZero());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        }
    }

    /**
     * 保険給付額の設定
     *
     * @param 支給限度額 Decimal
     */
    private void setチェックする保険給付額(Decimal 支給限度額) {
        Decimal 費用額合計 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue();
        Decimal 給付率 = new Decimal(div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().getValue().toString());
        if (費用額合計.compareTo(支給限度額) > 0) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(支給限度額);
            Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(数字_100);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.minusToZero());
            Decimal 今回の利用者負担額 = 費用額合計.subtract(今回の保険給付額.minusToZero());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(費用額合計);
            Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(数字_100);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.minusToZero());
            Decimal 今回の利用者負担額 = 費用額合計.subtract(今回の保険給付額.minusToZero());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        }
    }

    /**
     * 住宅改修データと限度額リセット値を画面メモリに保存する
     */
    public void 住宅改修データと限度額リセット値の保存() {
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        ViewStateHolder.put(ViewStateKeys.限度額リセット値, (ArrayList<KeyValueDataSource>) selectedItems);
        div.setHidTxtHiyoTotalNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalNow().getValue().toString()));
        div.setHidTxtHokenTaishoHiyoNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().getValue().toString()));
        div.setHidTxtHokenKyufuAmountNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue().toString()));
        div.setHidTxtRiyoshaFutanAmountNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue().toString()));
    }

    /**
     * 確認対象変更有無チェック
     *
     * @return チェック結果
     */
    public boolean 確認対象変更有無チェック() {

        ShiharaiKekkaResult resultOld = ViewStateHolder.get(ViewStateKeys.住宅改修データ, ShiharaiKekkaResult.class);
        if (resultOld != null) {
            if (resultOld.get費用額合計().compareTo(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalMae().getValue()) != 0) {
                return true;
            }
            if (resultOld.get費用額合計().compareTo(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoMae().getValue()) != 0) {
                return true;
            }
            if (resultOld.get保険給付額().compareTo(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountMae().getValue()) != 0) {
                return true;
            }
            if (resultOld.get利用者負担額().compareTo(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountMae().getValue()) != 0) {
                return true;
            }
        }

        List<KeyValueDataSource> selectedItemsNew = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        List<KeyValueDataSource> selectedItemsOld = ViewStateHolder.get(ViewStateKeys.限度額リセット値, List.class);

        if (!selectedItemsNew.equals(selectedItemsOld)) {
            return true;
        }
        if (!div.getHidTxtHiyoTotalNow().equals(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalNow().getValue().toString()))) {
            return true;
        }
        if (!div.getHidTxtHokenTaishoHiyoNow().equals(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().getValue().toString()))) {
            return true;
        }
        if (!div.getHidTxtHokenKyufuAmountNow().equals(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue().toString()))) {
            return true;
        }
        if (!div.getHidTxtRiyoshaFutanAmountNow().equals(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue().toString()))) {
            return true;
        }

        return false;
    }

    /**
     * 申請内容の保存
     *
     * @param 画面モード RString
     * @return 保存結果
     */
    public boolean 申請内容の保存(RString 画面モード) {
        if (登録モード.equals(画面モード)) {
            return JutakuKaishuJizenShinsei.createInstance().saveDBDate(null, null);
        } else if (削除モード.equals(画面モード)) {
            ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                    ShokanJutakuKaishuJizenShinsei.class);
            return JutakuKaishuJizenShinsei.createInstance().delDBDate(data, null);
        } else {
            ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                    ShokanJutakuKaishuJizenShinsei.class);
            return JutakuKaishuJizenShinsei.createInstance().updDBDate(null, null, 画面モード);
        }
    }

    /**
     * 画面項目の制御処理です。
     *
     * @param 画面モード RString
     */
    public void 項目表示制御処理(RString 画面モード) {
        if (照会モード.equals(画面モード)) {
            照会モード初期化();
        } else if (修正モード.equals(画面モード)) {
            修正モード初期化();
        } else if (削除モード.equals(画面モード)) {
            削除モード初期化();
        } else if (取消モード.equals(画面モード)) {
            取消モード初期化();
        }
    }

    private void 照会モード初期化() {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtRelationWithHihokensha().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiRiyu().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtJigyoshaNo().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getBtnJigyosha().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getBtnHonninJohoCopy().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreateYMD().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorKanaName().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorName().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaNo().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getBtnJigyoshaInputGuide().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaName().setDisabled(true);

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalMae().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoMae().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountMae().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountMae().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getBtnRireki().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalNow().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoNow().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountNow().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountNow().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getBtnLimitOverCheck().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getChkResetInfo().setDisabled(true);

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason().setDisabled(true);

    }

    private void 修正モード初期化() {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisplayNone(true);
    }

    private void 削除モード初期化() {
        照会モード初期化();
        // TODO QAのNo.643　申請取消事由の設定
    }

    private void 取消モード初期化() {
        照会モード初期化();
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisabled(false);
    }

    /**
     * 住宅改修情報タブの初期化
     *
     * @param param ShiharaiKekkaResult
     */
    private void loadTabKozaJyoho(ShiharaiKekkaResult param) {
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalMae().setValue(param.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoMae().setValue(param.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountMae().setValue(param.get保険給付額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountMae().setValue(param.get利用者負担額());

        ShokanJutakuKaishuJizenShinsei data = ViewStateHolder.get(ViewStateKeys.償還払支給住宅改修事前申請情報,
                ShokanJutakuKaishuJizenShinsei.class);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalNow().setValue(Decimal.valueOf(data.get給付額等_費用額合計()));
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoNow().setValue(Decimal.valueOf(data.get給付額等_保険対象費用額()));
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountNow().setValue(Decimal.valueOf(data.get給付額等_保険給付費額()));
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountNow().setValue(Decimal.valueOf(data.get給付額等_利用者自己負担額()));

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getChkResetInfo().setSelectedItems(Collections.EMPTY_LIST);
    }

    /**
     * 審査結果タブの初期化
     *
     * @param data ShokanJutakuKaishuJizenShinsei
     * @param 画面モード RString
     */
    private void loadTabShinsaKakka(ShokanJutakuKaishuJizenShinsei data, RString 画面モード) {
        if (!登録モード.equals(画面モード)) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD()
                    .setValue(new RDate(data.get判定決定年月日().toString()));
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun()
                    .setSelectedKey(data.get判定区分());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition()
                    .setValue(data.get承認条件());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason()
                    .setValue(data.get不承認理由());

            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getJutakuKaishuJizenShoninKetteiTsuchisho().setIsPublish(false);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD()
                    .setValue(new RDate(data.get事前申請決定通知発行日().toString()));
        }
    }
}
