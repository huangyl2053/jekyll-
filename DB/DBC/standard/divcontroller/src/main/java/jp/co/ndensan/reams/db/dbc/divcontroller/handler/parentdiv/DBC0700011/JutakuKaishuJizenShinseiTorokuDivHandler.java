/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0700011;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinseiBuilder;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.JutakuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist.JyutakugaisyunaiyoListDataPassModel;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu.JutakukaishuShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shoninkubun.ShoninKubun;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList.dgGaisyuList_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011.JutakuKaishuJizenShinseiTorokuDiv;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujyusyo.JutakuKaishuJyusyoChofukuHanntei;
import jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei.JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager;
import jp.co.ndensan.reams.db.dbc.service.report.jutakukaishujizenshinseitsuchisho.JutakuKaishuJizenShinseiTsuchishoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

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
    private static final RString 状態_登録 = new RString("toroku");
    private static final RString 状態_参照 = new RString("sansyo");
    private static final RString 取消事由なし = new RString("0");
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
    private static final RString メッセージ引数_着工日完成日 = new RString("着工日、または完成日");
    private static final RString メッセージ引数_着工日 = new RString("着工日");
    private static final RString 初期化済み = new RString("true");
    private static final RString 固定値_事業者番号 = new RString("0000000000");
    private static final RString 固定値_サービスコード = new RString("0000");
    private static final RString 固定値_明細番号 = new RString("0001");
    private static final int 住宅改修データなしコード = 1;
    private static final int 着工日不一致コード = 2;
    private static final int 対象住宅住所不一致コード = 3;
    private static final RString 非表示用フラグ_TRUE = new RString("true");
    private static final RString 行状態_削除 = new RString("削除");
    private static final RString 行状態_更新 = new RString("更新");
    private static final RString 行状態_登録 = new RString("登録");
    private static final RString 連番フォーマット = new RString("%02d");
    private static final RString 事前申請情報 = new RString("事前申請情報");
    private static final RString 登録FLAG = new RString("登録");
    private static final RString 承認 = new RString("1");
    private static final RString 不承認 = new RString("0");

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
     * @return result 償還払支給住宅改修事前申請情報
     */
    public ShokanJutakuKaishuJizenShinsei 登録以外初期化(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        ShokanJutakuKaishuJizenShinsei result = JutakuKaishuJizenShinsei.createInstance()
                .getJutakuKaishuJizenShinseiJyoho(被保険者番号, サービス提供年月, 整理番号);
        if (result == null) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        }
        loadTabShinseiJyoho(result);
        return result;
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

    private void loadTabShinseiJyoho(ShokanJutakuKaishuJizenShinsei param) {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                .setValue(new RDate(param.getサービス提供年月().toString()));
        div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu()
                .setValue(new RString(param.get保険給付率().value().toString()));
        申請者情報の初期化(param);

        List<KeyValueDataSource> torikeshiList = new ArrayList<>();
        KeyValueDataSource blank = new KeyValueDataSource(取消事由なし, RString.EMPTY);
        torikeshiList.add(blank);
        List<UzT0007CodeEntity> 取消事由リスト = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.住宅改修費申請取消事由コード.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity 取消事由 : 取消事由リスト) {
            KeyValueDataSource dataSource = new KeyValueDataSource(取消事由.getコード().value(), 取消事由.getコード名称());
            torikeshiList.add(dataSource);
        }
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDataSource(torikeshiList);
        if (param.get住宅改修申請取消事由コード() != null && !param.get住宅改修申請取消事由コード().isEmpty()) {
            div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu()
                    .setSelectedKey(param.get住宅改修申請取消事由コード());
        }
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().setValue(param.get申請者郵便番号());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress()
                .setDomain(new AtenaJusho(param.get申請者住所()));
        if (param.get理由書作成日() != null && !param.get理由書作成日().isEmpty()) {
            div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreateYMD()
                    .setValue(new RDate(param.get理由書作成日().toString()));

        }
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorKanaName()
                .setValue(param.get理由書作成者カナ());
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorName()
                .setValue(param.get理由書作成者());
        div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaNo()
                .setValue((param.get理由書作成事業者番号() == null || param.get理由書作成事業者番号().isEmpty())
                        ? RString.EMPTY : param.get理由書作成事業者番号().value());

        if (param.get理由書作成事業者番号() != null && !param.get理由書作成事業者番号().isEmpty()) {
            AtenaMeisho 作成事業者名称 = JutakuKaishuJizenShinsei.createInstance().getJigyoshaName(param.get理由書作成事業者番号());
            div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaName()
                    .setValue((作成事業者名称 == null || 作成事業者名称.isEmpty()) ? RString.EMPTY : 作成事業者名称.value());
        }
        div.setHidShinseiJyohoFlg(初期化済み);
    }

    private void 申請者情報の初期化(ShokanJutakuKaishuJizenShinsei param) {
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
                .setValue((param.get事業者番号() == null || param.get事業者番号().isEmpty())
                        ? RString.EMPTY : param.get事業者番号().value());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName()
                .setValue(param.get申請者氏名());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana()
                .setValue(param.get申請者氏名カナ());
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo()
                .setDomain(param.get申請者電話番号());
    }

    /**
     * 口座情報選択時
     *
     * @param 画面モード RString
     * @param data 償還払支給住宅改修事前申請情報
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 整理番号 RString
     */
    public void 口座情報選択時(RString 画面モード, ShokanJutakuKaishuJizenShinsei data,
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号, RString 整理番号) {
        SikyuSinseiJyohoParameter param = new SikyuSinseiJyohoParameter();
        if (登録モード.equals(画面モード)) {
            param.setShikibetsuCode(識別コード);
            param.setHihokenshaNo(被保険者番号);
            if (div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue() != null) {
                param.setShikyushinseiServiceYM(new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                        .getValue().getYearMonth().toDateString()));
            }
            param.setShikyushinseiSeiriNo(整理番号);
        } else if (data != null) {
            param.setShikibetsuCode(識別コード);
            param.setHihokenshaNo(data.get被保険者番号());
            param.setShikyushinseiServiceYM(data.getサービス提供年月());
            param.setShikyushinseiSeiriNo(data.get整理番号());
            param.setShiharaiHohoKubun(ShiharaiHohoKubun.toValue(data.get支払方法区分コード()));
            param.setShiharaiBasho(data.get支払場所());
            if (data.get支払期間開始年月日() != null && !data.get支払期間開始年月日().isEmpty()) {
                param.setStartYMD(new RDate(data.get支払期間開始年月日().toString()));
            }
            if (data.get支払期間終了年月日() != null && !data.get支払期間終了年月日().isEmpty()) {
                param.setEndYMD(new RDate(data.get支払期間終了年月日().toString()));
            }
            if (data.get支払窓口開始時間() != null && !data.get支払窓口開始時間().isEmpty()) {
                param.setStartHHMM(new RTime(data.get支払窓口開始時間()));
            }
            if (data.get支払窓口終了時間() != null && !data.get支払窓口終了時間().isEmpty()) {
                param.setEndHHMM(new RTime(data.get支払窓口終了時間()));
            }
            param.setKozaId(data.get口座ID());
            param.setKeiyakuNo(data.get受領委任契約番号());
        }
        RString 状態 = 画面モード;
        if (削除モード.equals(画面モード) || 取消モード.equals(画面モード)) {
            状態 = 照会モード;
        }
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabKozaJyoho()
                .getCcdJutakuKaishuJizenShinseiKoza().initialize(param, 状態);
        div.setHidKozaJyohoFlg(初期化済み);
    }

    /**
     * 住宅改修情報選択時
     *
     * @param 画面モード RString
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param data 償還払支給住宅改修事前申請情報
     * @param seiriNo 整理番号
     * @param flexibleYearMonth サービス提供年月
     * @return result 住宅改修データ
     */
    public ShiharaiKekkaResult 住宅改修情報選択時(RString 画面モード, HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード, ShokanJutakuKaishuJizenShinsei data,
            RString seiriNo, FlexibleYearMonth flexibleYearMonth) {
        ShiharaiKekkaResult result;

        if (登録モード.equals(画面モード)) {
            JyutakugaisyunaiyoListDataPassModel model = new JyutakugaisyunaiyoListDataPassModel();
            model.set被保険者番号(被保険者番号);
            model.set状態(状態_登録);
            model.setサービス提供年月(new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                    .getValue().getYearMonth().toDateString()));
            model.set識別コード(識別コード);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                    .getCcdJutakuJizenShinseiDetail().initialize(model);
        } else {
            RString yoshikiNo = JutakuKaishuJizenShinsei.createInstance()
                    .getYoshikiNo(被保険者番号, flexibleYearMonth, seiriNo);
            JyutakugaisyunaiyoListDataPassModel model = new JyutakugaisyunaiyoListDataPassModel();
            model.set被保険者番号(被保険者番号);
            model.setサービス提供年月(flexibleYearMonth);
            model.set整理番号(seiriNo);
            model.set様式番号(yoshikiNo);
            model.set状態((照会モード.equals(画面モード) || 削除モード.equals(画面モード) || 取消モード.equals(画面モード))
                    ? 状態_参照 : 状態_登録);
            model.set識別コード(識別コード);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                    .getCcdJutakuJizenShinseiDetail().initialize(model);
        }
        result = JutakuKaishuJizenShinsei.createInstance()
                .getKakoJutakuKaishuHi(被保険者番号, new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                                .getValue().getYearMonth().toDateString()));
        loadTabKozaJyoho(result, 画面モード, data);
        div.setHidJutakuKaisyuJyohoFlg(初期化済み);
        return result;
    }

    /**
     * 前回までの支払結果設定
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void 前回までの支払結果設定(HihokenshaNo 被保険者番号) {
        ShiharaiKekkaResult result;

        result = JutakuKaishuJizenShinsei.createInstance()
                .getKakoJutakuKaishuHi(被保険者番号, new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM()
                                .getValue().getYearMonth().toDateString()));

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalMae().setValue(result.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoMae().setValue(result.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountMae().setValue(result.get保険給付額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountMae().setValue(result.get利用者負担額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .setHdnResetServiceYM(result.get開始サービス提供年月().toDateString());
    }

    /**
     * 住宅改修内容のチェック
     */
    public void 住宅改修内容のチェック() {
        List<dgGaisyuList_Row> gridList = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        List<RString> 著工日リスト = new ArrayList<>();
        List<RString> 完成日リスト = new ArrayList<>();

        if (!gridList.isEmpty()) {
            int 住宅改修内容チェック結果 = 住宅改修内容のレコードチェック(gridList, 著工日リスト, 完成日リスト);
            if (住宅改修データなしコード == 住宅改修内容チェック結果) {
                throw new ApplicationException(DbcErrorMessages.住宅改修データなし.getMessage());
            }
            if (着工日不一致コード == 住宅改修内容チェック結果) {
                throw new ApplicationException(DbcErrorMessages.着工日不一致.getMessage());
            }
            if (対象住宅住所不一致コード == 住宅改修内容チェック結果) {
                throw new ApplicationException(DbcErrorMessages.対象住宅住所不一致.getMessage());
            }
        } else {
            throw new ApplicationException(DbcErrorMessages.住宅改修データなし.getMessage());
        }

        if (div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(サービス年月.toString()));
        }
        RString kubun = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_償還, RDate.getNowDate(),
                SubGyomuCode.DBC介護給付);
        if (文字_1.equals(kubun)) {
            if (!著工日リスト.contains(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue()
                    .getYearMonth().toDateString())
                    && !完成日リスト.contains(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue()
                            .getYearMonth().toDateString())) {
                throw new ApplicationException(DbcErrorMessages.サービス年月と不一致.getMessage()
                        .replace(メッセージ引数_着工日完成日.toString()));
            }
        } else if (文字_2.equals(kubun) && !著工日リスト.contains(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString())) {
            throw new ApplicationException(DbcErrorMessages.サービス年月と不一致.getMessage()
                    .replace(メッセージ引数_着工日.toString()));
        }
    }

    /**
     * チェックボックスの変更
     */
    public void チェックボックスの変更() {
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        if (非表示用フラグ_TRUE.equals(div.getHidSandannkaiMsgFlg())
                && !selectedItems.contains(要介護状態区分)) {
            div.setHidSandannkaiMsgFlg(RString.EMPTY);
        }
        if (非表示用フラグ_TRUE.equals(div.getHidLimitMsgDisplayedFlg())
                && !selectedItems.contains(住宅住所変更)) {
            div.setHidLimitMsgDisplayedFlg(RString.EMPTY);
        }
        div.setHidDataChangeFlg(非表示用フラグ_TRUE);
    }

    private int 住宅改修内容のレコードチェック(List<dgGaisyuList_Row> gridList,
            List<RString> 著工日リスト, List<RString> 完成日リスト) {
        RString 著工日に対する年月 = RString.EMPTY;
        RString 対象住宅住所 = RString.EMPTY;
        int 削除レコード数 = 0;
        int 著工日に対する年月不一致レコード = 0;
        int 対象住宅住所が不一致レコード = 0;
        for (dgGaisyuList_Row tmpRow : gridList) {
            if (!RowState.Deleted.equals(tmpRow.getRowState())) {
                著工日に対する年月 = new FlexibleDate(new RDate(tmpRow.getTxtChakkoYoteibi().toString()).toDateString())
                        .getYearMonth().toDateString();
                対象住宅住所 = tmpRow.getTxtJutakuAddress();
                break;
            }
        }

        for (dgGaisyuList_Row tmpRow : gridList) {
            if (RowState.Deleted.equals(tmpRow.getRowState())) {
                削除レコード数 = 削除レコード数 + 1;
            } else {
                RString tmp著工日 = RString.isNullOrEmpty(tmpRow.getTxtChakkoYoteibi()) ? RString.EMPTY
                        : new FlexibleDate(new RDate(tmpRow.getTxtChakkoYoteibi().toString()).toDateString())
                        .getYearMonth().toDateString();
                RString tmp完成日 = RString.isNullOrEmpty(tmpRow.getTxtKanseiYoteibi()) ? RString.EMPTY
                        : new FlexibleDate(new RDate(tmpRow.getTxtKanseiYoteibi().toString()).toDateString())
                        .getYearMonth().toDateString();
                著工日リスト.add(tmp著工日);
                完成日リスト.add(tmp完成日);
                if (!著工日に対する年月.equals(tmp著工日)) {
                    著工日に対する年月不一致レコード++;
                }
                if (!対象住宅住所.equals(tmpRow.getTxtJutakuAddress())) {
                    対象住宅住所が不一致レコード++;
                }
            }
        }

        if (削除レコード数 == gridList.size()) {
            return 住宅改修データなしコード;
        }
        if (著工日に対する年月不一致レコード > 0) {
            return 着工日不一致コード;
        }
        if (対象住宅住所が不一致レコード > 0) {
            return 対象住宅住所不一致コード;
        }
        return 0;
    }

    /**
     * 入力チェック
     *
     * @param 画面モード RString
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 入力チェック(RString 画面モード, HihokenshaNo hihokenshaNo) {
        if (RString.isNullOrEmpty(div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(住宅所有者.toString()));
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish()
                && div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD()
                .getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(判定決定日.toString()));
        }
        if (ShoninKubun.承認しない.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())
                && RString.isNullOrEmpty(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getTxtFushoninReason().getValue())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(不承認理由.toString()));
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish()
                && div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD().getValue() == null) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(発行日.toString()));
        }
        住宅改修内容のチェック();
        if (登録モード.equals(画面モード)) {
            return 要介護認定有効のチェック(hihokenshaNo);
        } else if (取消モード.equals(画面モード) && 取消事由なし.equals(div.getKaigoShikakuKihonShaPanel()
                .getShinseishaInfo().getDdlShinseiTorikesuJiyu().getSelectedKey())) {
            throw new ApplicationException(UrErrorMessages.必須.getMessage().replace(申請取消事由.toString()));
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
     * @param data 償還払支給住宅改修事前申請情報
     */
    public void 承認結果通知書作成(HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            RString 整理番号,
            RString 画面モード,
            ShokanJutakuKaishuJizenShinsei data) {
        boolean 出力チェックON = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish();
        if (削除モード.equals(画面モード) || 取消モード.equals(画面モード) || !出力チェックON) {
            return;
        }

        RString 判定区分 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getRadJudgeKubun().getSelectedKey();
        if (修正モード.equals(画面モード)
                && new RString(data.get判定決定年月日().toString()).equals(div.getKaigoShikakuKihonShaPanel()
                        .getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString())
                && data.get判定区分().equals(判定区分)
                && new RString(data.get事前申請決定通知発行日().toString()).equals(div.getKaigoShikakuKihonShaPanel()
                        .getTabShinseiContents().getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho()
                        .getTxtHakkoYMD().getValue().toDateString())) {
            if (承認.equals(判定区分) && data.get承認条件().equals(div.getKaigoShikakuKihonShaPanel()
                    .getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition().getValue())) {
                return;
            } else if (不承認.equals(判定区分) && data.get不承認理由().equals(div.getKaigoShikakuKihonShaPanel()
                    .getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason().getValue())) {
                return;
            }
        }

        JutakuKaishuJizenShinseiParameter parameter = new JutakuKaishuJizenShinseiParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.set被保険者氏名(div.getKaigoShikakuKihonShaPanel().getCcdKaigoAtenaInfo().get氏名漢字());
        parameter.set識別コード(識別コード);
        if (div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtShinseiYMD().getValue() != null) {
            parameter.set申請日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue().toDateString()));
            parameter.set受付日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue().toDateString()));
        }
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
        parameter.set事業者名(new RString(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().
                getTxtJigyoshaName().getPlaceHolder().toString()));
        parameter.set承認年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString()));
        parameter.set不承認の理由(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getTxtFushoninReason().getValue());
        ServiceShuruiCode サービス種類コード = data.getサービス種類コード();
        FlexibleYearMonth サービス提供年月 = data.getサービス提供年月();
        RString 給付の種類 = JutakuKaishuJizenShinsei.createInstance()
                .getServiceShuruiMeisho(サービス種類コード, サービス提供年月);
        parameter.set給付の種類(給付の種類);
        parameter.set作成者氏名(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorName().getValue());
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
        parameter.set文書番号(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getCcdBunshoBango().get文書番号());

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
        if (result == null) {
            throw new ApplicationException(DbcErrorMessages.要介護状態_事前申請不可.getMessage());
        }
        Code 要介護認定状態区分コード = result.get要介護認定状態区分コード();

        List<RString> 要介護認定状態区分コードリスト = new ArrayList<>();
        for (YoKaigoJotaiKubun 状態区分 : YoKaigoJotaiKubun.values()) {
            要介護認定状態区分コードリスト.add(状態区分.getCode());
        }
        if (!要介護認定状態区分コードリスト.contains(要介護認定状態区分コード.getKey())) {
            throw new ApplicationException(DbcErrorMessages.要介護状態_事前申請不可.getMessage());
        }

        if (YoKaigoJotaiKubun.非該当.getCode().equals(要介護認定状態区分コード.getKey())) {
            if (result.is旧措置者フラグ()) {
                return true;
            } else {
                throw new ApplicationException(DbcErrorMessages.要介護状態_事前申請不可.getMessage());
            }
        }
        return false;
    }

    /**
     * 過去の住宅改修費取得
     *
     * @param hihokenshaNo HihokenshaNo
     * @param 前回までの支払結果 ShiharaiKekkaResult
     * @param 画面モード RString
     * @param 整理番号 FlexibleYearMonth
     * @param サービス提供年月 RString
     * @return result ShiharaiKekkaResult
     */
    public ShiharaiKekkaResult 過去の住宅改修費取得(HihokenshaNo hihokenshaNo, ShiharaiKekkaResult 前回までの支払結果,
            RString 画面モード, RString 整理番号, FlexibleYearMonth サービス提供年月) {
        RString 住宅住所 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧().get(0).getTxtJutakuAddress();
        final JutakuKaishuJizenShinsei 住宅改修事前申請 = JutakuKaishuJizenShinsei.createInstance();
        ShiharaiKekkaResult result = null;
        if (登録モード.equals(画面モード)) {
            result = 住宅改修事前申請.getOldJutakuKaishuHi(hihokenshaNo, サービス提供年月, 整理番号);
        } else {
            result = 住宅改修事前申請.getJutakuKaishuHi(hihokenshaNo,
                    new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().getValue().getYearMonth().toDateString()),
                    住宅住所);
        }
        if (result == null) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHiyoTotalMae().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenTaishoHiyoMae().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountMae().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtRiyoshaFutanAmountMae().setValue(Decimal.ZERO);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHiyoTotalMae().setValue(result.get費用額合計());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenTaishoHiyoMae().setValue(result.get費用額合計());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountMae().setValue(result.get保険給付額());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtRiyoshaFutanAmountMae().setValue(result.get利用者負担額());
        }

        RString 前回まで住宅住所 = RString.EMPTY;
        if (前回までの支払結果 != null) {
            前回まで住宅住所 = 前回までの支払結果.get住宅改修住宅住所();
        }
        KeyValueDataSource item = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        if (!住宅住所.equals(前回まで住宅住所)) {
            if (!selectedItems.contains(item)) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                        .getChkResetInfo().getSelectedItems().add(item);
            }
        } else if (selectedItems.contains(item)) {
            selectedItems.remove(item);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getChkResetInfo().setSelectedItems(selectedItems);
        }
        return result;
    }

    /**
     * 住宅改修データを画面メモリに保存
     *
     * @return 改修内容データMap Map
     */
    public Map<Integer, JutakuJizenShinseiEntity> to住宅改修データを画面メモリに保存() {
        List<dgGaisyuList_Row> 住宅改修内容一覧データ = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        Map<Integer, JutakuJizenShinseiEntity> 改修内容データMap = new HashMap<>();
        for (dgGaisyuList_Row row : 住宅改修内容一覧データ) {
            JutakuJizenShinseiEntity entity = new JutakuJizenShinseiEntity(
                    new RString(row.getRowState().toString()),
                    row.getTxtKaishuNaiyo(),
                    row.getTxtJigyosha(),
                    row.getTxtJutakuAddress(),
                    row.getTxtChakkoYoteibi(),
                    row.getTxtKanseiYoteibi(),
                    row.getTxtKaishuKingaku());
            改修内容データMap.put(row.getId(), entity);
        }
        return 改修内容データMap;
    }

    /**
     * 費用額合計の設定
     */
    public void 費用額合計の設定() {
        List<dgGaisyuList_Row> rowList = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        Decimal 費用額合計 = Decimal.ZERO;
        for (dgGaisyuList_Row tmpRow : rowList) {
            if (!RowState.Deleted.equals(tmpRow.getRowState()) && !tmpRow.getTxtKaishuKingaku().isNullOrEmpty()) {
                費用額合計 = 費用額合計.add(new Decimal(tmpRow.getTxtKaishuKingaku().replace(",", "").toString()));
            }
        }
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalNow().setValue(費用額合計);
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
                .checkYaokaigoJyotaiSandannkai(hihokenshaNo,
                        new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                                .getTabJutakuKaisyuJyoho().getTotalPanel().getHdnResetServiceYM()),
                        yearMonth);
    }

    /**
     * 改修住所変更による限度額リセットチェック
     *
     * @param hihokenshaNo HihokenshaNo
     * @return チェック結果
     */
    public boolean 改修住所変更による限度額リセットチェック(HihokenshaNo hihokenshaNo) {
        RString 住宅住所 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧().get(0).getTxtJutakuAddress();
        FlexibleYearMonth yearMonth = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString());
        return JutakuKaishuJyusyoChofukuHanntei.createInstance()
                .checkKaishuJyusyoChofukuToroku(hihokenshaNo,
                        new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                                .getTabJutakuKaisyuJyoho().getTotalPanel().getHdnResetServiceYM()),
                        yearMonth, 住宅住所);
    }

    /**
     * 支払結果の設定
     *
     * @param hihokenshaNo HihokenshaNo
     */
    public void 支払結果の設定(HihokenshaNo hihokenshaNo) {
        FlexibleYearMonth サービス提供年月 = new FlexibleYearMonth(div.getKaigoShikakuKihonShaPanel()
                .getTxtServiceYM().getValue().getYearMonth().toDateString());
        Decimal 支給限度額 = JutakuKaishuJizenShinsei.createInstance().getShikyuGendoGaku(hihokenshaNo, サービス提供年月);

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
        Decimal 前回までの費用額合計 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalMae().getValue();
        if (費用額合計.add(前回までの費用額合計).compareTo(支給限度額) > 0) {
            Decimal 前回までの被保険対象額 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoMae().getValue();
            Decimal 今回の被保険対象額 = 支給限度額.compareTo(前回までの被保険対象額) < 0 ? Decimal.ZERO : 支給限度額
                    .subtract(前回までの被保険対象額);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(今回の被保険対象額);
            if (今回の被保険対象額.compareTo(Decimal.ONE) >= 0) {
                Decimal 前回までの保険給付額 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountMae().getValue();
                Decimal 給付率 = new Decimal(div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().getValue().toString());
                Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(数字_100)
                        .subtract(前回までの保険給付額).roundDownTo(0);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                        .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額.compareTo(Decimal.ZERO) < 0
                                ? Decimal.ZERO : 今回の保険給付額);
            } else if (今回の被保険対象額.compareTo(Decimal.ZERO) == 0) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().setValue(Decimal.ZERO);
            }
            Decimal 今回の利用者負担額 = 今回の被保険対象額.subtract(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue());
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(費用額合計);
            Decimal 給付率 = new Decimal(div.getKaigoShikakuKihonShaPanel().getTxtKyufuritsu().getValue().toString());
            Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(数字_100).roundDownTo(0);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
            Decimal 今回の利用者負担額 = 費用額合計.subtract(今回の保険給付額);
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
            Decimal 今回の保険給付額 = 支給限度額.multiply(給付率).divide(数字_100).roundDownTo(0);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
            Decimal 今回の利用者負担額 = 支給限度額.subtract(今回の保険給付額);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().setValue(費用額合計);
            Decimal 今回の保険給付額 = 費用額合計.multiply(給付率).divide(数字_100).roundDownTo(0);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(今回の保険給付額);
            Decimal 今回の利用者負担額 = 費用額合計.subtract(今回の保険給付額);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().setValue(今回の利用者負担額);
        }
    }

    /**
     * 住宅改修データと限度額リセット値を画面メモリに保存する
     *
     * @return selectedKey 限度額リセット値
     */
    public List<RString> 住宅改修データと限度額リセット値の保存() {
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        List<RString> selectedKey = new ArrayList<>();
        if (selectedItems != null && !selectedItems.isEmpty()) {
            for (KeyValueDataSource tmpDataSource : selectedItems) {
                selectedKey.add(tmpDataSource.getKey());
            }
        }
        div.setHidTxtHiyoTotalNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalNow().getValue().toString()));
        div.setHidTxtHokenTaishoHiyoNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().getValue().toString()));
        div.setHidTxtHokenKyufuAmountNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue().toString()));
        div.setHidTxtRiyoshaFutanAmountNow(new RString(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue().toString()));
        return selectedKey;
    }

    /**
     * 限度額リセット値を画面メモリに保存する
     *
     * @return selectedKey 限度額リセット値
     */
    public List<RString> get限度額リセット値() {
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        List<RString> selectedKey = new ArrayList<>();
        if (selectedItems != null && !selectedItems.isEmpty()) {
            for (KeyValueDataSource tmpDataSource : selectedItems) {
                selectedKey.add(tmpDataSource.getKey());
            }
        }
        return selectedKey;
    }

    /**
     * 確認対象変更有無チェック
     *
     * @param 住宅改修内容一覧データMap Map
     * @param selectedItemsOld List
     * @return チェック結果
     */
    public boolean 確認対象変更有無チェック(Map<Integer, JutakuJizenShinseiEntity> 住宅改修内容一覧データMap,
            List<RString> selectedItemsOld) {

        boolean flag;
        if (住宅改修内容一覧データMap != null && !住宅改修内容一覧データMap.isEmpty()) {
            List<dgGaisyuList_Row> 住宅改修内容一覧データ = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
            if (住宅改修内容一覧データMap.size() < 住宅改修内容一覧データ.size()) {
                return true;
            } else {
                flag = getCheckFlag(住宅改修内容一覧データ, 住宅改修内容一覧データMap);
            }
        } else {
            return true;
        }
        if (flag) {
            return true;
        }
        return 限度額リセット値変更有無チェック(selectedItemsOld);
    }

    private boolean getCheckFlag(List<dgGaisyuList_Row> 住宅改修内容一覧データ,
            Map<Integer, JutakuJizenShinseiEntity> 住宅改修内容一覧データMap) {
        for (dgGaisyuList_Row row : 住宅改修内容一覧データ) {
            if (RowState.Modified.equals(row.getRowState())
                    || RowState.Deleted.equals(row.getRowState())
                    || RowState.Added.equals(row.getRowState())) {
                JutakuJizenShinseiEntity entity = 住宅改修内容一覧データMap.get(row.getId());
                if (!entity.get状態().equals(row.getRowState())) {
                    return true;
                }
                if (!entity.get住宅改修内容().equals(row.getTxtKaishuNaiyo())) {
                    return true;
                }
                if (!entity.get事業者().equals(row.getTxtJigyosha())) {
                    return true;
                }
                if (!entity.get住宅住所().equals(row.getTxtJutakuAddress())) {
                    return true;
                }
                if (!entity.get着工日().equals(row.getTxtChakkoYoteibi())) {
                    return true;
                }
                if (!entity.get完成日().equals(row.getTxtKanseiYoteibi())) {
                    return true;
                }
                if (!entity.get改修金額().equals(row.getTxtKaishuKingaku().replace(",", ""))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean 限度額リセット値変更有無チェック(List<RString> selectedItemsOld) {
        List<KeyValueDataSource> selectedItemsNew = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        List<RString> selectedKeyNew = new ArrayList<>();
        if (selectedItemsNew != null && !selectedItemsNew.isEmpty()) {
            for (KeyValueDataSource tmpDataSource : selectedItemsNew) {
                selectedKeyNew.add(tmpDataSource.getKey());
            }
        }
        if (selectedItemsOld == null && !selectedKeyNew.isEmpty()) {
            return true;
        } else if (selectedItemsOld != null && !selectedKeyNew.equals(selectedItemsOld)) {
            return true;
        }
        return false;
    }

    /**
     * 様式番号
     *
     * @param hihokenshaNo HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return 様式番号
     */
    public RString get様式番号(HihokenshaNo hihokenshaNo, FlexibleYearMonth サービス提供年月) {
        return JutakuKaishuJizenShinsei.createInstance().createYoshikiNo(hihokenshaNo, サービス提供年月);
    }

    /**
     * 申請内容の保存_登録
     *
     * @param 画面モード RString
     * @param hihokenshaNo HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 様式番号 RString
     * @return map
     */
    public Map<RString, Object> 申請内容の保存_登録(RString 画面モード, HihokenshaNo hihokenshaNo,
            FlexibleYearMonth サービス提供年月, RString 整理番号, RString 様式番号) {
        ShokanJutakuKaishuJizenShinsei insertData = new ShokanJutakuKaishuJizenShinsei(hihokenshaNo, サービス提供年月, 整理番号);
        ShokanJutakuKaishuJizenShinseiBuilder builder = insertData.createBuilderForEdit();
        登録データの設定(builder, hihokenshaNo, サービス提供年月);
        insertData = builder.build();

        List<ShokanJutakuKaishu> kaishuList = new ArrayList<>();
        List<dgGaisyuList_Row> gridList = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        if (!gridList.isEmpty()) {
            int index = 1;
            for (dgGaisyuList_Row row : gridList) {
                ShokanJutakuKaishu tmpData = new ShokanJutakuKaishu(hihokenshaNo, サービス提供年月, 整理番号,
                        new JigyoshaNo(固定値_事業者番号), 様式番号, 固定値_明細番号,
                        new RString(String.format(連番フォーマット.toString(), index++)));
                tmpData = tmpData.createBuilderForEdit()
                        .set住宅改修内容(row.getTxtKaishuNaiyo())
                        .set住宅改修事業者名(row.getTxtJigyosha())
                        .set住宅改修住宅住所(row.getTxtJutakuAddress())
                        .set改修金額(row.getTxtKaishuKingaku().isNullOrEmpty() ? 0 : Integer.parseInt(row.getTxtKaishuKingaku().replace(",", "").toString()))
                        .set住宅改修着工年月日((row.getTxtChakkoYoteibi() != null && !row.getTxtChakkoYoteibi().isEmpty())
                                ? new FlexibleDate(new RDate(row.getTxtChakkoYoteibi().toString()).toDateString()) : FlexibleDate.EMPTY)
                        .set住宅改修完成年月日((row.getTxtKanseiYoteibi() != null && !row.getTxtKanseiYoteibi().isEmpty())
                                ? new FlexibleDate(new RDate(row.getTxtKanseiYoteibi().toString()).toDateString()) : FlexibleDate.EMPTY)
                        .setサービスコード(new ServiceCode(insertData.getサービス種類コード().value().concat(固定値_サービスコード)))
                        .set事前申請サービス提供年月(insertData.getサービス提供年月())
                        .set事前申請整理番号(insertData.get整理番号())
                        .build();
                kaishuList.add(tmpData);
            }
        }
        Map<RString, Object> map = new HashMap<>();
        map.put(事前申請情報, insertData);
        map.put(登録FLAG, JutakuKaishuJizenShinsei.createInstance().saveDBDate(insertData, kaishuList));
        return map;
    }

    /**
     * 申請内容の保存_削除
     *
     * @param deleteData 償還払支給住宅改修事前申請情報
     * @param oldDataList 住宅改修内容一覧_検索結果
     * @return boolean
     */
    public boolean 申請内容の保存_削除(ShokanJutakuKaishuJizenShinsei deleteData,
            Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> oldDataList) {

        List<ShokanJutakuKaishu> kaishuList = new ArrayList<>();
        if (oldDataList != null) {
            for (ShokanJutakuKaishu tmp : oldDataList.aliveValues()) {
                kaishuList.add(tmp);
            }
        }
        return JutakuKaishuJizenShinsei.createInstance().delDBDate(deleteData, kaishuList);
    }

    /**
     * 申請内容の保存_取消と更新
     *
     * @param 画面モード RString
     * @param hihokenshaNo HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 整理番号 RString
     * @param 様式番号 様式番号
     * @param updateData 償還払支給住宅改修事前申請情報
     * @param oldDataList 住宅改修内容一覧_検索結果
     * @return boolean
     */
    public boolean 申請内容の保存_取消と更新(RString 画面モード, HihokenshaNo hihokenshaNo, FlexibleYearMonth サービス提供年月,
            RString 整理番号, RString 様式番号,
            ShokanJutakuKaishuJizenShinsei updateData,
            Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> oldDataList) {
        ShokanJutakuKaishuJizenShinseiBuilder builder = updateData.createBuilderForEdit();
        if (取消モード.equals(画面モード)) {
            取消データの設定(builder);
        } else {
            更新データの設定(builder, hihokenshaNo, サービス提供年月);
        }
        updateData = builder.build();
        List<ShokanJutakuKaishu> kaishuList = 住宅改修レコードの設定(updateData, hihokenshaNo, サービス提供年月,
                整理番号, 様式番号, oldDataList);
        return JutakuKaishuJizenShinsei.createInstance().updDBDate(updateData, kaishuList, 画面モード);
    }

    private List<ShokanJutakuKaishu> 住宅改修レコードの設定(ShokanJutakuKaishuJizenShinsei updateData,
            HihokenshaNo hihokenshaNo, FlexibleYearMonth サービス提供年月, RString 整理番号, RString 様式番号,
            Models<ShokanJutakuKaishuIdentifier, ShokanJutakuKaishu> oldDataList) {
        List<ShokanJutakuKaishu> kaishuList = new ArrayList<>();
        List<dgGaisyuList_Row> gridList = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        int maxIndex = 最大連番を取得する(gridList);
        for (dgGaisyuList_Row tmpRow : gridList) {
            if (RowState.Modified.equals(tmpRow.getRowState()) || RowState.Deleted.equals(tmpRow.getRowState())) {
                ShokanJutakuKaishu oldData = 住宅改修レコードの取得(tmpRow, oldDataList);
                ShokanJutakuKaishuBuilder shokanJutakuKaishuBuilder = oldData.createBuilderForEdit();
                shokanJutakuKaishuBuilder.set住宅改修事業者名(tmpRow.getTxtJigyosha());
                shokanJutakuKaishuBuilder.set住宅改修内容(tmpRow.getTxtKaishuNaiyo());
                shokanJutakuKaishuBuilder.set住宅改修住宅住所(tmpRow.getTxtJutakuAddress());
                shokanJutakuKaishuBuilder.set住宅改修着工年月日((tmpRow.getTxtChakkoYoteibi() != null
                        && !tmpRow.getTxtChakkoYoteibi().isEmpty()) ? new FlexibleDate(new RDate(tmpRow
                                        .getTxtChakkoYoteibi().toString()).toDateString()) : FlexibleDate.EMPTY);
                shokanJutakuKaishuBuilder.set住宅改修完成年月日((tmpRow.getTxtKanseiYoteibi() != null
                        && !tmpRow.getTxtKanseiYoteibi().isEmpty()) ? new FlexibleDate(new RDate(tmpRow
                                        .getTxtKanseiYoteibi().toString()).toDateString()) : FlexibleDate.EMPTY);
                shokanJutakuKaishuBuilder.set改修金額(tmpRow.getTxtKaishuKingaku().isNullOrEmpty() ? 0 : Integer
                        .parseInt(tmpRow.getTxtKaishuKingaku().replace(",", "").toString()));
                shokanJutakuKaishuBuilder.setサービスコード(new ServiceCode(updateData.getサービス種類コード().value()
                        .concat(固定値_サービスコード)));
                shokanJutakuKaishuBuilder.set事前申請サービス提供年月(updateData.getサービス提供年月());
                shokanJutakuKaishuBuilder.set事前申請整理番号(updateData.get整理番号());
                EntityDataState state = RowState.Modified.equals(tmpRow.getRowState()) ? EntityDataState.Modified
                        : EntityDataState.Deleted;
                shokanJutakuKaishuBuilder.setステータス(state);
                oldData = shokanJutakuKaishuBuilder.build();
                kaishuList.add(oldData);
            } else if (RowState.Added.equals(tmpRow.getRowState())) {
                maxIndex++;
                ShokanJutakuKaishu addData = new ShokanJutakuKaishu(hihokenshaNo, サービス提供年月, 整理番号,
                        new JigyoshaNo(固定値_事業者番号), 様式番号, 固定値_明細番号,
                        new RString(String.format(連番フォーマット.toString(), maxIndex)));
                ShokanJutakuKaishuBuilder addDataBuilder = addData.createBuilderForEdit();
                addDataBuilder.set住宅改修事業者名(tmpRow.getTxtJigyosha());
                addDataBuilder.set住宅改修内容(tmpRow.getTxtKaishuNaiyo());
                addDataBuilder.set住宅改修住宅住所(tmpRow.getTxtJutakuAddress());
                addDataBuilder.set住宅改修着工年月日((tmpRow.getTxtChakkoYoteibi() != null
                        && !tmpRow.getTxtChakkoYoteibi().isEmpty()) ? new FlexibleDate(new RDate(tmpRow
                                        .getTxtChakkoYoteibi().toString()).toDateString()) : FlexibleDate.EMPTY);
                addDataBuilder.set住宅改修完成年月日((tmpRow.getTxtKanseiYoteibi() != null
                        && !tmpRow.getTxtKanseiYoteibi().isEmpty()) ? new FlexibleDate(new RDate(tmpRow.getTxtKanseiYoteibi()
                                        .toString()).toDateString()) : FlexibleDate.EMPTY);
                addDataBuilder.set改修金額(tmpRow.getTxtKaishuKingaku().isNullOrEmpty() ? 0
                        : Integer.parseInt(tmpRow.getTxtKaishuKingaku().replace(",", "").toString()));
                addDataBuilder.setサービスコード(new ServiceCode(updateData.getサービス種類コード().value()
                        .concat(固定値_サービスコード)));
                addDataBuilder.set事前申請サービス提供年月(updateData.getサービス提供年月());
                addDataBuilder.set事前申請整理番号(updateData.get整理番号());
                addDataBuilder.setステータス(EntityDataState.Added);
                addData = addDataBuilder.build();
                kaishuList.add(addData);
            }
        }
        return kaishuList;
    }

    private int 最大連番を取得する(List<dgGaisyuList_Row> gridList) {
        int rtnIndex = 0;
        for (dgGaisyuList_Row tmpRow : gridList) {
            if (tmpRow.getTxtRenban() != null && !tmpRow.getTxtRenban().isEmpty()
                    && Integer.parseInt(tmpRow.getTxtRenban().toString()) > rtnIndex) {
                rtnIndex = Integer.parseInt(tmpRow.getTxtRenban().toString());
            }
        }
        return rtnIndex;
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

    private void 取消データの設定(ShokanJutakuKaishuJizenShinseiBuilder builder) {
        builder.set住宅改修申請区分(JutakukaishuShinseiKubun.取消.getCode());
        builder.set住宅改修申請取消事由コード(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getDdlShinseiTorikesuJiyu().getSelectedKey());
    }

    private void 更新データの設定(ShokanJutakuKaishuJizenShinseiBuilder builder,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        if (div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD().getValue() != null) {
            builder.set申請年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue().toDateString()));
        }
        builder.set申請理由(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiRiyu().getValue());
        builder.set申請者区分(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        builder.set申請者氏名(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName().getValue());
        builder.set申請者氏名カナ(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana().getValue());
        builder.set申請者郵便番号(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().getValue());
        builder.set申請者住所(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress().getDomain().value());
        builder.set申請者電話番号(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo().getDomain());
        final JigyoshaNo 申請事業者番号 = new JigyoshaNo(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtJigyoshaNo().getValue());
        if (!申請事業者番号.isEmpty()) {
            builder.set申請事業者番号(申請事業者番号);
        }
        if (div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreateYMD().getValue() != null) {
            builder.set理由書作成日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                    .getTxtCreateYMD().getValue().toDateString()));
        }
        builder.set理由書作成者(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorName().getValue());
        builder.set理由書作成者カナ(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorKanaName().getValue());
        final JigyoshaNo 理由書作成事業者番号 = new JigyoshaNo(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreationJigyoshaNo().getValue());
        if (!理由書作成事業者番号.isEmpty()) {
            builder.set理由書作成事業者番号(理由書作成事業者番号);
        }
        RString 支払方法区分コード = div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                .getCcdJutakuKaishuJizenShinseiKoza().getShiharaiHohoRad();
        builder.set支払方法区分コード(支払方法区分コード);
        if (ShiharaiHohoKubun.窓口払.getコード().equals(支払方法区分コード)) {
            builder.set支払場所(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getShiharaiBasho());
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getStartYMD() != null) {
                builder.set支払期間開始年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getStartYMD().toDateString()));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getEndYMD() != null) {
                builder.set支払期間終了年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getEndYMD().toDateString()));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza()
                    .getStartHHMM() != null) {
                builder.set支払窓口開始時間(new RString(String.format(連番フォーマット.toString(),
                        div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza()
                        .getStartHHMM().getHour())).concat(new RString(String.format(連番フォーマット.toString(),
                                                div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                                                .getCcdJutakuKaishuJizenShinseiKoza().getStartHHMM().getMinute()))));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza().getEndHHMM() != null) {
                builder.set支払窓口終了時間(new RString(String.format(連番フォーマット.toString(),
                        div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getEndHHMM().getHour()))
                        .concat(new RString(String.format(連番フォーマット.toString(),
                                                div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                                                .getCcdJutakuKaishuJizenShinseiKoza().getEndHHMM().getMinute()))));
            }
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(支払方法区分コード)) {
            builder.set口座ID(Long.valueOf(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getKozaNo().toString()));
        } else if (ShiharaiHohoKubun.受領委任払.getコード().equals(支払方法区分コード)) {
            builder.set受領委任契約番号(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getKeiyakuNo());
        }
        ServiceShuruiCode サービス種類コード = JutakuKaishuJizenShinsei.createInstance()
                .getServiceShuruiCode(被保険者番号, サービス提供年月);
        if (サービス種類コード != null) {
            builder.setサービス種類コード(サービス種類コード);
        }
        builder.set住宅所有者(div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().getValue());
        builder.set被保険者との関係(div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho()
                .getTxtRelationWithHihokensha().getValue());
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        if (selectedItems.contains(要介護状態区分)) {
            builder.set要介護状態３段階変更(true);
        } else {
            builder.set要介護状態３段階変更(false);
        }
        if (selectedItems.contains(住宅住所変更)) {
            builder.set住宅住所変更(true);
        } else {
            builder.set住宅住所変更(false);
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtJudgeYMD() != null) {
            builder.set判定決定年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString()));
        }
        builder.set判定区分(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getRadJudgeKubun().getSelectedKey());
        if (ShoninKubun.承認する.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())) {
            builder.set承認条件(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtShoninCondition().getValue());
            builder.set不承認理由(RString.EMPTY);
        } else {
            builder.set承認条件(RString.EMPTY);
            builder.set不承認理由(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtFushoninReason().getValue());
        }
        builder.set給付額等_費用額合計(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue().intValue());
        builder.set給付額等_保険対象費用額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenTaishoHiyoNow().getValue().intValue());
        builder.set給付額等_利用者自己負担額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue().intValue());
        builder.set給付額等_保険給付費額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenKyufuAmountNow().getValue().intValue());
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish()) {
            builder.set事前申請決定通知発行日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD()
                    .getValue().toDateString()));
        }
        builder.set保険給付率(new HokenKyufuRitsu(new Decimal(div.getKaigoShikakuKihonShaPanel()
                .getTxtKyufuritsu().getValue().toString())));
    }

    private void 登録データの設定(ShokanJutakuKaishuJizenShinseiBuilder builder,
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        ShoKisaiHokenshaNo 証記載保険者番号 = JutakuKaishuJizenShinsei.createInstance()
                .getShoKisaiHokenshaNo(被保険者番号, サービス提供年月);
        builder.set証記載保険者番号(証記載保険者番号);
        builder.set受付年月日(FlexibleDate.getNowDate());
        if (div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD().getValue() != null) {
            builder.set申請年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                    .getTxtShinseiYMD().getValue().toDateString()));
        }
        builder.set申請理由(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiRiyu().getValue());
        builder.set申請者区分(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun().getSelectedKey());
        builder.set申請者氏名(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName().getValue());
        builder.set申請者氏名カナ(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana().getValue());
        builder.set申請者郵便番号(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().getValue());
        builder.set申請者住所(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress().getDomain().value());
        builder.set申請者電話番号(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtTelNo().getDomain());
        JigyoshaNo 申請事業者番号 = new JigyoshaNo(div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtJigyoshaNo().getValue());
        if (!申請事業者番号.isEmpty()) {
            builder.set申請事業者番号(申請事業者番号);
        }
        if (div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreateYMD().getValue() != null) {
            builder.set理由書作成日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                    .getTxtCreateYMD().getValue().toDateString()));
        }
        builder.set理由書作成者(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorName().getValue());
        builder.set理由書作成者カナ(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorKanaName().getValue());
        JigyoshaNo 理由書作成事業者番号 = new JigyoshaNo(div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreationJigyoshaNo().getValue());
        if (!理由書作成事業者番号.isEmpty()) {
            builder.set理由書作成事業者番号(理由書作成事業者番号);
        }
        RString 支払方法区分コード = div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                .getCcdJutakuKaishuJizenShinseiKoza().getShiharaiHohoRad();
        builder.set支払方法区分コード(支払方法区分コード);
        if (ShiharaiHohoKubun.窓口払.getコード().equals(支払方法区分コード)) {
            builder.set支払場所(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getShiharaiBasho());
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getStartYMD() != null) {
                builder.set支払期間開始年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getStartYMD().toDateString()));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getEndYMD() != null) {
                builder.set支払期間終了年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getEndYMD().toDateString()));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza()
                    .getStartHHMM() != null) {
                builder.set支払窓口開始時間(new RString(String.format(連番フォーマット.toString(),
                        div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza().getStartHHMM().getHour()))
                        .concat(new RString(String.format(連番フォーマット.toString(), div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                                                .getCcdJutakuKaishuJizenShinseiKoza().getStartHHMM().getMinute()))));
            }
            if (div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza()
                    .getEndHHMM() != null) {
                builder.set支払窓口終了時間(new RString(String.format(連番フォーマット.toString(),
                        div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                        .getCcdJutakuKaishuJizenShinseiKoza().getEndHHMM().getHour()))
                        .concat(new RString(String.format(連番フォーマット.toString(), div.getKaigoShikakuKihonShaPanel()
                                                .getTabKozaJyoho().getCcdJutakuKaishuJizenShinseiKoza().getEndHHMM().getMinute()))));
            }
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(支払方法区分コード) && !div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                .getCcdJutakuKaishuJizenShinseiKoza().getKozaNo().isEmpty()) {
            builder.set口座ID(Long.valueOf(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getKozaNo().toString()));
        } else if (ShiharaiHohoKubun.受領委任払.getコード().equals(支払方法区分コード)) {
            builder.set受領委任契約番号(div.getKaigoShikakuKihonShaPanel().getTabKozaJyoho()
                    .getCcdJutakuKaishuJizenShinseiKoza().getKeiyakuNo());
        }
        ServiceShuruiCode サービス種類コード = JutakuKaishuJizenShinsei.createInstance()
                .getServiceShuruiCode(被保険者番号, サービス提供年月);
        if (サービス種類コード != null) {
            builder.setサービス種類コード(サービス種類コード);
        }
        builder.set住宅所有者(div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().getValue());
        builder.set被保険者との関係(div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho()
                .getTxtRelationWithHihokensha().getValue());
        List<KeyValueDataSource> selectedItems = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getChkResetInfo().getSelectedItems();
        KeyValueDataSource 要介護状態区分 = new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE);
        KeyValueDataSource 住宅住所変更 = new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE);
        if (selectedItems.contains(要介護状態区分)) {
            builder.set要介護状態３段階変更(true);
        } else {
            builder.set要介護状態３段階変更(false);
        }
        if (selectedItems.contains(住宅住所変更)) {
            builder.set住宅住所変更(true);
        } else {
            builder.set住宅住所変更(false);
        }
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtJudgeYMD() != null) {
            builder.set判定決定年月日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabShinsaKakka().getTxtJudgeYMD().getValue().toDateString()));
        }
        builder.set判定区分(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getRadJudgeKubun().getSelectedKey());
        if (ShoninKubun.承認する.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())) {
            builder.set承認条件(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtShoninCondition().getValue());
            builder.set不承認理由(RString.EMPTY);
        } else {
            builder.set承認条件(RString.EMPTY);
            builder.set不承認理由(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                    .getTxtFushoninReason().getValue());
        }
        builder.set給付額等_費用額合計(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHiyoTotalNow().getValue().intValue());
        builder.set給付額等_保険対象費用額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenTaishoHiyoNow().getValue().intValue());
        builder.set給付額等_利用者自己負担額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue().intValue());
        builder.set給付額等_保険給付費額(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                .getTotalPanel().getTxtHokenKyufuAmountNow().getValue().intValue());
        if (div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().isIsPublish()) {
            builder.set事前申請決定通知発行日(new FlexibleDate(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD()
                    .getValue().toDateString()));
        }
        builder.set住宅改修申請区分(JutakukaishuShinseiKubun.事前申請.getCode());
        builder.set保険給付率(new HokenKyufuRitsu(new Decimal(div.getKaigoShikakuKihonShaPanel()
                .getTxtKyufuritsu().getValue().toString())));
    }

    /**
     * 画面項目の制御処理です。
     *
     * @param 画面モード RString
     * @param 償還払支給住宅改修事前申請情報 ShokanJutakuKaishuJizenShinsei
     * @param 引継ぎサービス年月 RDate
     * @param 被保険者番号 HihokenshaNo
     */
    public void 項目表示制御処理(RString 画面モード,
            ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請情報,
            RDate 引継ぎサービス年月, HihokenshaNo 被保険者番号) {
        if (照会モード.equals(画面モード)) {
            照会モード初期化();
        } else if (修正モード.equals(画面モード)) {
            修正モード初期化();
        } else if (削除モード.equals(画面モード)) {
            削除モード初期化(償還払支給住宅改修事前申請情報);
        } else if (取消モード.equals(画面モード)) {
            取消モード初期化();
        } else if (登録モード.equals(画面モード)) {
            登録モード初期化(引継ぎサービス年月, 被保険者番号);
        }
    }

    private void 登録モード初期化(RDate 引継ぎサービス年月, HihokenshaNo 被保険者番号) {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().setValue(引継ぎサービス年月);
        給付率設定(被保険者番号);

        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().setIsPublish(false);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisplayNone(true);
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

        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().setDisabledPublishCheckBox(true);
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD().setDisabled(true);
    }

    private void 修正モード初期化() {
        div.getKaigoShikakuKihonShaPanel().getTxtServiceYM().setDisabled(true);
        div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisplayNone(true);
    }

    private void 削除モード初期化(ShokanJutakuKaishuJizenShinsei data) {
        照会モード初期化();
        if (JutakukaishuShinseiKubun.取消.getCode().equals(data.get住宅改修申請区分())) {
            div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisplayNone(false);
        } else {
            div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseiTorikesuJiyu().setDisplayNone(true);
        }
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
    private void loadTabKozaJyoho(ShiharaiKekkaResult param, RString 画面モード, ShokanJutakuKaishuJizenShinsei data) {
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHiyoTotalMae().setValue(param.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenTaishoHiyoMae().setValue(param.get費用額合計());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtHokenKyufuAmountMae().setValue(param.get保険給付額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .getTxtRiyoshaFutanAmountMae().setValue(param.get利用者負担額());
        div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                .setHdnResetServiceYM(param.get開始サービス提供年月().toDateString());

        if (data != null) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHiyoTotalNow().setValue(Decimal.valueOf(data.get給付額等_費用額合計()));
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenTaishoHiyoNow().setValue(Decimal.valueOf(data.get給付額等_保険対象費用額()));
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(Decimal.valueOf(data.get給付額等_保険給付費額()));
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtRiyoshaFutanAmountNow().setValue(Decimal.valueOf(data.get給付額等_利用者自己負担額()));
            div.setHidTxtHiyoTotalNow(new RString(data.get給付額等_費用額合計()));
            div.setHidTxtHokenTaishoHiyoNow(new RString(data.get給付額等_保険対象費用額()));
            div.setHidTxtHokenKyufuAmountNow(new RString(data.get給付額等_保険給付費額()));
            div.setHidTxtRiyoshaFutanAmountNow(new RString(data.get給付額等_利用者自己負担額()));
        } else {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHiyoTotalNow().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenTaishoHiyoNow().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtHokenKyufuAmountNow().setValue(Decimal.ZERO);
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getTxtRiyoshaFutanAmountNow().setValue(Decimal.ZERO);
            div.setHidTxtHiyoTotalNow(new RString(Decimal.ZERO.toString()));
            div.setHidTxtHokenTaishoHiyoNow(new RString(Decimal.ZERO.toString()));
            div.setHidTxtHokenKyufuAmountNow(new RString(Decimal.ZERO.toString()));
            div.setHidTxtRiyoshaFutanAmountNow(new RString(Decimal.ZERO.toString()));
        }

        if (登録モード.equals(画面モード) || data == null) {
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getChkResetInfo().setSelectedItems(Collections.EMPTY_LIST);
        } else {
            List<KeyValueDataSource> selectedItems = new ArrayList<>();
            if (data.is要介護状態３段階変更()) {
                selectedItems.add(new KeyValueDataSource(要介護状態区分_KEY, 要介護状態区分_VALUE));
            }
            if (data.is住宅住所変更()) {
                selectedItems.add(new KeyValueDataSource(住宅住所変更_KEY, 住宅住所変更_VALUE));
            }
            div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel()
                    .getChkResetInfo().setSelectedItems(selectedItems);
        }
    }

    /**
     * 審査結果タブの初期化
     *
     * @param data 償還払支給住宅改修事前申請情報
     * @param 画面モード RString
     */
    public void loadTabShinsaKakka(ShokanJutakuKaishuJizenShinsei data, RString 画面モード) {
        if (!登録モード.equals(画面モード) && data != null) {
            if (data.get判定決定年月日() != null) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtJudgeYMD()
                        .setValue(new RDate(data.get判定決定年月日().toString()));
            }
            if (data.get判定区分() != null && !data.get判定区分().isEmpty()) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun()
                        .setSelectedKey(data.get判定区分());
            } else {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getRadJudgeKubun()
                        .setSelectedKey(ShoninKubun.承認する.getコード());
            }
            if (ShoninKubun.承認する.getコード().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                    .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey())) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition()
                        .setValue(data.get承認条件());
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason()
                        .setDisabled(true);
            } else if (ShoninKubun.承認しない.getコード().equals(data.get判定区分())) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtShoninCondition()
                        .setDisabled(true);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka().getTxtFushoninReason()
                        .setValue(data.get不承認理由());
            }
            if (data.get事前申請決定通知発行日() != null) {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getJutakuKaishuJizenShoninKetteiTsuchisho().setIsPublish(true);
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getJutakuKaishuJizenShoninKetteiTsuchisho().getTxtHakkoYMD()
                        .setValue(new RDate(data.get事前申請決定通知発行日().toString()));
            } else {
                div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                        .getJutakuKaishuJizenShoninKetteiTsuchisho().setIsPublish(false);
            }
        }
    }

    /**
     * 画面データ変更有無
     *
     * @param oldShinseiData 償還払支給住宅改修事前申請情報
     * @param oldKekkaData 住宅改修データ
     */
    public void 画面データ変更有無(ShokanJutakuKaishuJizenShinsei oldShinseiData, ShiharaiKekkaResult oldKekkaData) {
        RString 画面入力住宅所有者 = div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho().getTxtJutakuOwner().getValue();
        if ((oldShinseiData.get住宅所有者() == null && 画面入力住宅所有者 != null)
                || (oldShinseiData.get住宅所有者() != null && !oldShinseiData.get住宅所有者().equals(画面入力住宅所有者))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return;
        }
        RString 画面入力被保険者との関係 = div.getKaigoShikakuKihonShaPanel().getTabShinseiJyoho()
                .getTxtRelationWithHihokensha().getValue();
        if ((oldShinseiData.get被保険者との関係() == null && 画面入力被保険者との関係 != null)
                || (oldShinseiData.get被保険者との関係() != null && !oldShinseiData.get被保険者との関係()
                .equals(画面入力被保険者との関係))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return;
        }
        RString 画面入力事業者番号 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtJigyoshaNo().getValue();
        if ((oldShinseiData.get事業者番号() == null && 画面入力事業者番号 != null)
                || (oldShinseiData.get事業者番号() != null && !oldShinseiData.get事業者番号().value().equals(画面入力事業者番号))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return;
        }

        if (申請情報データ変更有無_申請情報(oldShinseiData)) {
            return;
        }
        if (申請情報データ変更有無_申請者(oldShinseiData)) {
            return;
        }
        if (申請情報データ変更有無_理由(oldShinseiData)) {
            return;
        }
        if (審査結果データ変更有無_判定(oldShinseiData)) {
            return;
        }
        if (審査結果データ変更有無_承認(oldShinseiData)) {
            return;
        }
        if (画面住宅改修グリッドデータ変更有無()) {
            return;
        }
        画面住宅改修データ変更有無(oldKekkaData, oldShinseiData);
    }

    /**
     * 申請情報データ変更有無_申請情報
     *
     * @param oldShinseiData 元データ
     * @return 変更有無
     */
    public boolean 申請情報データ変更有無_申請情報(ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        RDate 画面入力申請年月日 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiYMD().getValue();
        if ((oldShinseiData.get申請年月日() == null && 画面入力申請年月日 != null)
                || (oldShinseiData.get申請年月日() != null && !new RDate(oldShinseiData.get申請年月日().toString())
                .equals(画面入力申請年月日))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力申請者区分 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getDdlShinseishaKubun()
                .getSelectedKey();
        if ((oldShinseiData.get申請者区分() == null && 画面入力申請者区分 != null)
                || (oldShinseiData.get申請者区分() != null && !oldShinseiData.get申請者区分().equals(画面入力申請者区分))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力申請理由 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseiRiyu().getValue();
        if ((oldShinseiData.get申請理由() == null && 画面入力申請理由 != null)
                || (oldShinseiData.get申請理由() != null && !oldShinseiData.get申請理由().equals(画面入力申請理由))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力申請者氏名 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaName().getValue();
        if ((oldShinseiData.get申請者氏名() == null && 画面入力申請者氏名 != null)
                || (oldShinseiData.get申請者氏名() != null && !oldShinseiData.get申請者氏名().equals(画面入力申請者氏名))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        return false;
    }

    /**
     * 申請情報データ変更有無_申請者
     *
     * @param oldShinseiData 元データ
     * @return 変更有無
     */
    public boolean 申請情報データ変更有無_申請者(ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        RString 画面入力申請者氏名カナ = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtShinseishaNameKana().getValue();
        if ((oldShinseiData.get申請者氏名カナ() == null && 画面入力申請者氏名カナ != null)
                || (oldShinseiData.get申請者氏名カナ() != null && !oldShinseiData.get申請者氏名カナ().equals(画面入力申請者氏名カナ))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        TelNo 画面入力申請者電話番号 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo()
                .getTxtTelNo().getDomain();
        if ((oldShinseiData.get申請者電話番号() == null && 画面入力申請者電話番号 != null)
                || (oldShinseiData.get申請者電話番号() != null && !oldShinseiData.get申請者電話番号().equals(画面入力申請者電話番号))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }

        RString 画面入力住所 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtAddress().getDomain().value();
        if ((oldShinseiData.get申請者住所() == null && 画面入力住所 != null)
                || (oldShinseiData.get申請者住所() != null && !oldShinseiData.get申請者住所().equals(画面入力住所))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        YubinNo 画面入力郵便番号 = div.getKaigoShikakuKihonShaPanel().getShinseishaInfo().getTxtYubinNo().getValue();
        if ((oldShinseiData.get申請者郵便番号() == null && 画面入力郵便番号 != null)
                || (oldShinseiData.get申請者郵便番号() != null && !oldShinseiData.get申請者郵便番号().equals(画面入力郵便番号))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        return false;
    }

    /**
     * 申請情報データ変更有無_理由
     *
     * @param oldShinseiData 元データ
     * @return 変更有無
     */
    public boolean 申請情報データ変更有無_理由(ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        RDate 画面入力作成日 = div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreateYMD().getValue();
        if ((oldShinseiData.get理由書作成日() == null && 画面入力作成日 != null)
                || (oldShinseiData.get理由書作成日() != null && !new RDate(oldShinseiData.get理由書作成日().toString())
                .equals(画面入力作成日))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力作成者氏名カナ = div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreatorKanaName().getValue();
        if ((oldShinseiData.get理由書作成者カナ() == null && 画面入力作成者氏名カナ != null)
                || (oldShinseiData.get理由書作成者カナ() != null && !oldShinseiData.get理由書作成者カナ().equals(画面入力作成者氏名カナ))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }

        RString 画面入力作成者氏名 = div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason().getTxtCreatorName()
                .getValue();
        if ((oldShinseiData.get理由書作成者() == null && 画面入力作成者氏名 != null)
                || (oldShinseiData.get理由書作成者() != null && !oldShinseiData.get理由書作成者().equals(画面入力作成者氏名))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力作成事業者 = div.getKaigoShikakuKihonShaPanel().getJutakuKaishuJizenShinseiReason()
                .getTxtCreationJigyoshaNo().getValue();
        if ((oldShinseiData.get理由書作成事業者番号() == null && 画面入力作成事業者 != null)
                || (oldShinseiData.get理由書作成事業者番号() != null && !oldShinseiData.get理由書作成事業者番号()
                .value().equals(画面入力作成事業者))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        return false;
    }

    /**
     * 審査結果データ変更有無_判定
     *
     * @param oldShinseiData 元データ
     * @return 変更有無
     */
    public boolean 審査結果データ変更有無_判定(ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        RDate 画面入力判定決定年月日 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabShinsaKakka()
                .getTxtJudgeYMD().getValue();
        if ((oldShinseiData.get判定決定年月日() == null && 画面入力判定決定年月日 != null)
                || (oldShinseiData.get判定決定年月日() != null && !new RDate(oldShinseiData.get判定決定年月日().toString())
                .equals(画面入力判定決定年月日))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力判定区分 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getRadJudgeKubun().getSelectedKey();
        if ((oldShinseiData.get判定区分() == null && 画面入力判定区分 != null)
                || (oldShinseiData.get判定区分() != null && !oldShinseiData.get判定区分().equals(画面入力判定区分))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        return false;
    }

    /**
     * 審査結果データ変更有無_承認
     *
     * @param oldShinseiData 元データ
     * @return 変更有無
     */
    public boolean 審査結果データ変更有無_承認(ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        RString 画面入力承認条件 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtShoninCondition().getValue();
        if ((oldShinseiData.get承認条件() == null && 画面入力承認条件 != null)
                || (oldShinseiData.get承認条件() != null && !oldShinseiData.get承認条件().equals(画面入力承認条件))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RString 画面入力不承認理由 = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabShinsaKakka().getTxtFushoninReason().getValue();
        if ((oldShinseiData.get不承認理由() == null && 画面入力不承認理由 != null)
                || (oldShinseiData.get不承認理由() != null && !oldShinseiData.get不承認理由().equals(画面入力不承認理由))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        RDate 画面入力事前申請決定通知発行日 = div.getKaigoShikakuKihonShaPanel()
                .getTabShinseiContents().getTabShinsaKakka().getJutakuKaishuJizenShoninKetteiTsuchisho()
                .getTxtHakkoYMD().getValue();
        if ((oldShinseiData.get事前申請決定通知発行日() == null && 画面入力事前申請決定通知発行日 != null)
                || (oldShinseiData.get事前申請決定通知発行日() != null && !new RDate(oldShinseiData.get事前申請決定通知発行日().toString())
                .equals(画面入力事前申請決定通知発行日))) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return true;
        }
        return false;
    }

    /**
     * 画面住宅改修グリッドデータ変更有無
     *
     * @return 変更有無
     */
    public boolean 画面住宅改修グリッドデータ変更有無() {
        List<dgGaisyuList_Row> gridList = div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getCcdJutakuJizenShinseiDetail().get住宅改修内容一覧();
        if (gridList != null && !gridList.isEmpty()) {
            for (dgGaisyuList_Row tmpRow : gridList) {
                if (RowState.Modified.equals(tmpRow.getRowState())
                        || RowState.Deleted.equals(tmpRow.getRowState())
                        || RowState.Added.equals(tmpRow.getRowState())) {
                    div.setHidDataChangeFlg(非表示用フラグ_TRUE);
                    return true;
                }
            }
        }
        return false;
    }

    private void 画面住宅改修データ変更有無(ShiharaiKekkaResult oldKekkaData, ShokanJutakuKaishuJizenShinsei oldShinseiData) {
        if (oldKekkaData == null) {
            if (!Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                    .getTotalPanel().getTxtHiyoTotalMae().getValue())
                    || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                            .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoMae().getValue())
                    || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                            .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountMae().getValue())
                    || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                            .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountMae().getValue())) {
                div.setHidDataChangeFlg(非表示用フラグ_TRUE);
                return;
            }
        } else if (!oldKekkaData.get費用額合計().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalMae().getValue())
                || !oldKekkaData.get費用額合計().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoMae().getValue())
                || !oldKekkaData.get保険給付額().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountMae().getValue())
                || !oldKekkaData.get利用者負担額().equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountMae().getValue())) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            return;
        }

        if (oldShinseiData != null) {
            if (!Decimal.valueOf(oldShinseiData.get給付額等_費用額合計()).equals(div.getKaigoShikakuKihonShaPanel()
                    .getTabShinseiContents().getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalNow().getValue())
                    || !Decimal.valueOf(oldShinseiData.get給付額等_保険対象費用額()).equals(div
                            .getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                            .getTotalPanel().getTxtHokenTaishoHiyoNow().getValue())
                    || !Decimal.valueOf(oldShinseiData.get給付額等_保険給付費額()).equals(div
                            .getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                            .getTotalPanel().getTxtHokenKyufuAmountNow().getValue())
                    || !Decimal.valueOf(oldShinseiData.get給付額等_利用者自己負担額()).equals(div
                            .getKaigoShikakuKihonShaPanel().getTabShinseiContents().getTabJutakuKaisyuJyoho()
                            .getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue())) {
                div.setHidDataChangeFlg(非表示用フラグ_TRUE);
            }
        } else if (!Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHiyoTotalNow().getValue())
                || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenTaishoHiyoNow().getValue())
                || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtHokenKyufuAmountNow().getValue())
                || !Decimal.ZERO.equals(div.getKaigoShikakuKihonShaPanel().getTabShinseiContents()
                        .getTabJutakuKaisyuJyoho().getTotalPanel().getTxtRiyoshaFutanAmountNow().getValue())) {
            div.setHidDataChangeFlg(非表示用フラグ_TRUE);
        }
    }
}
