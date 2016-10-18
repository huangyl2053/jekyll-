/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.KibetsuGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.CalculateChoteiParameter;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan.KoseiShorikoaResult;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmen.Gemmen;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJohoBuilder;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.FukaJohoSaishn;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.KaigoHokenryoGemmenParam;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.NendobunFukaGemmenListResult;
import jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen.TuuchisyoGaihatuParam;
import jp.co.ndensan.reams.db.dbb.business.core.tsuchisho.notsu.ShutsuryokuKiKoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.FukaJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.fukarirekiall.FukaRirekiAll.IFukaRirekiAllDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KeteiinfoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KiwarigakuKanendo1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KiwarigakuKanendo2Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.KiwarigakuPanel1Div;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.PrintInfoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.ShinseiJokyoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.ShinseiinfoDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.TorikeshiInfoDiv;
import jp.co.ndensan.reams.db.dbb.service.core.basic.ChoshuHohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.fuka.fukakeisan.FukaKeisan;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho.FukaJohoManager;
import jp.co.ndensan.reams.db.dbb.service.core.kaigohokenryogemmen.KaigoHokenryoGemmen;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.HonsanteiIkoHantei;
import jp.co.ndensan.reams.db.dbb.service.core.tsuchisho.notsu.ShutsuryokuKiKohoFactory;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBBCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.Tsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.searchkey.KaigoFukaKihonSearchKey;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.HihokenshaDaichoManager;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 介護保険料減免画面のHandlerです。
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenJuminKihonHandler {

    private final GemmenJuminKihonDiv div;
    private final KitsukiList 特徴期月リスト = new TokuchoKiUtil().get期月リスト();
    private final KitsukiList 普徴期月リスト = new FuchoKiUtil().get期月リスト();
    private final KitsukiList 過年度期月リスト = new KanendoKiUtil().get期月リスト();
    private static final int ゼロ_定値 = 0;
    private static final int イチ_定値 = 1;
    private static final int 二_定値 = 2;
    private static final int ミ_定値 = 3;
    private static final int ヨ_定値 = 4;
    private static final int ゴ_定値 = 5;
    private static final int ロク_定値 = 6;
    private static final int ナナ_定値 = 7;
    private static final int ハチ_定値 = 8;
    private static final int キュウ_定値 = 9;
    private static final int ジュウ_定値 = 10;
    private static final int ジュウイチ_定値 = 11;
    private static final int ジュウ二_定値 = 12;
    private static final int ジュウミ_定値 = 13;
    private static final int ジュウヨ_定値 = 14;
    private static final int ジュウゴ_定値 = 15;
    private static final RString 期R = new RString("期");
    private static final RString 月R = new RString("月");
    private static final RString 保存R = new RString("保存");
    private static final RString 氏名R = new RString("氏名");
    private static final RString コロン = new RString(":");
    private static final RString 調定月日 = new RString("0401");
    private static final RString 通知書番号R = new RString("通知書番号");
    private static final RString 空 = RString.EMPTY;
    private static final RString 定値_ゼロ = new RString("0");
    private static final RString 定値_イチ = new RString("1");
    private static final RString 定値_二 = new RString("2");
    private static final RString 定値_ミ = new RString("3");
    private static final RString 定値_ヨ = new RString("4");
    private static final RString 定値_ロク = new RString("6");
    private static final RString 保存ボタン = new RString("btnUpt");
    private static final RString 発行ボタンSHOW = new RString("1");
    private static final RString 訂正をやめるボタン = new RString("btnTeiseiCancel");
    private static final RString 取消をやめるボタン = new RString("btnTorikeshiCancel");
    private static final RString 状況_申請中 = new RString("申請中");
    private static final RString 状況_決定済 = new RString("決定済");
    private static final RString 状況_新規 = new RString("新規申請");
    private static final RString 承認 = new RString("承認する");
    private static final RString 不承認 = new RString("承認しない");
    private static final RString 出力方法_別々に出力 = new RString("別々に出力");
    private static final RString 出力方法_全件出力 = new RString("全件出力");
    private static final RString 出力形式_現金用 = new RString("現金用");
    private static final RString 出力形式_口座用 = new RString("口座用");
    private static final RString 入力状況_新規申請 = new RString("新規_申請");
    private static final RString 入力状況_新規決定 = new RString("新規_決定");
    private static final RString 入力状況_申請中取消 = new RString("申請中_取消");
    private static final RString 入力状況_申請中申請 = new RString("申請中_申請");
    private static final RString 入力状況_申請中決定 = new RString("申請中_決定");
    private static final RString 入力状況_決定済訂正 = new RString("決定済_訂正");
    private static final RString 入力状況_決定済取消 = new RString("決定済_取消");
    private static final RString 画面モード_訂正 = new RString("訂正");
    private static final RString 減免決定通知書 = new RString("保険料減免決定通知書");
    private static final RString 賦課台帳 = new RString("賦課台帳（更正決定決議書）");
    private static final RString 減免取消通知書 = new RString("保険料減免取消通知書");
    private static final RString 発行するボタン = new RString("btnPrt");

    /**
     * ヘッダパネルの初期化メソッドです。
     *
     * @param 識別コード ShikibetsuCode
     * @param searchKey KaigoFukaKihonSearchKey
     */
    public void loadヘッダパネル(ShikibetsuCode 識別コード, KaigoFukaKihonSearchKey searchKey) {
        div.getCcdKaigoAtenaKihon().initialize(識別コード);
        div.getCcdKaigoFukaKihon().load(searchKey);
    }

    /**
     * 全賦課履歴情報グリッドと状況情報パネルの初期化メソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FukaNendo
     * @return 件数 int
     */
    public int load全賦課履歴情報グリッド(HihokenshaNo 被保険者番号, FukaNendo 賦課年度) {
        IFukaRirekiAllDiv 全賦課履歴 = div.getGemmenFukaRirekiAll().getCcdFukaRirekiAll();
        return 全賦課履歴.load(被保険者番号, 賦課年度);
    }

    /**
     * 賦課基本を取得する。
     *
     * @return 賦課基本 Fuka
     */
    public Fuka get賦課基本() {
        IFukaRirekiAllDiv 全賦課履歴 = div.getGemmenFukaRirekiAll().getCcdFukaRirekiAll();
        return 全賦課履歴.get賦課履歴().get賦課履歴All().toList().get(0);
    }

    /**
     * 状況情報パネルの値を設定する。
     *
     * @param 最新減免の情報 GemmenJoho
     * @return 状況 RString
     */
    public RString load状況情報パネル(GemmenJoho 最新減免の情報) {
        div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD().setRequired(false);
        RString 減免作成区分;
        RString 状況;
        if (最新減免の情報 == null || 最新減免の情報.getGemmenList().isEmpty()) {
            状況 = 状況_新規;
        } else {
            減免作成区分 = 最新減免の情報.get減免作成区分();
            状況 = get状況(減免作成区分);
        }
        ShinseiJokyoDiv 状況情報パネル = div.getGemmenMain().getShinseiJokyo();
        状況情報パネル.getTxtShinseiJokyo().setValue(状況);
        if (状況_新規.equals(状況)) {
            状況情報パネル.getBtnTesei().setVisible(false);
            状況情報パネル.getBtnTorikeshi().setVisible(false);
        } else if (状況_申請中.equals(状況)) {
            状況情報パネル.getBtnTesei().setVisible(false);
            状況情報パネル.getBtnTorikeshi().setVisible(true);
            状況情報パネル.getBtnTorikeshi().setDisabled(false);
        } else if (状況_決定済.equals(状況)) {
            状況情報パネル.getBtnTesei().setVisible(true);
            状況情報パネル.getBtnTesei().setDisabled(false);
            状況情報パネル.getBtnTorikeshi().setVisible(true);
            状況情報パネル.getBtnTorikeshi().setDisabled(false);
        }
        return 状況;
    }

    /**
     * 申請情報パネルの値を設定する。
     *
     * @param 最新減免の情報 GemmenJoho
     * @return 減免種類コード Code
     */
    public Code load申請情報パネル(GemmenJoho 最新減免の情報) {
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        if (最新減免の情報 != null) {
            申請情報パネル.getTxtChoteiYY().setValue(new RDate(最新減免の情報.get調定年度().toString()));
            申請情報パネル.getTxtFukaYY().setValue(new RDate(最新減免の情報.get賦課年度().toString()));
            List<Gemmen> 介護賦課減免List = 最新減免の情報.getGemmenList();
            if (介護賦課減免List != null && !介護賦課減免List.isEmpty()) {
                return set申請情報パネル(介護賦課減免List.get(0), 申請情報パネル);
            }
        }
        return null;
    }

    /**
     * 決定情報パネルの値を設定する。
     *
     * @param 最新減免の情報 GemmenJoho
     */
    public void load決定情報パネル(GemmenJoho 最新減免の情報) {
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        決定情報パネル.getRadKetteiKubun().setDataSource(get決定区分());
        決定情報パネル.getRadKetteiKubun().setSelectedIndex(ゼロ_定値);
        if (最新減免の情報 != null) {
            決定情報パネル.getTxtZenkaiGemmengaku().setValue(最新減免の情報.get減免額());
            List<Gemmen> 介護賦課減免List = 最新減免の情報.getGemmenList();
            if (介護賦課減免List != null && !介護賦課減免List.isEmpty()) {
                set決定情報パネル(介護賦課減免List.get(0), 決定情報パネル);
            }
        }
    }

    /**
     * 減免情報パネルの初期化メソッドです。
     *
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     */
    public void load減免情報パネル(NendobunFukaGemmenList 年度分賦課減免リスト) {
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        減免情報パネル.getTxtGemmengaku().setValue(null);
        GemmenJoho 現年度 = 年度分賦課減免リスト.get現年度();
        if (現年度 != null) {
            set普通徴収グリッド(現年度);
            set特別徴収グリッド(現年度);
        }
        GemmenJoho 過年度1 = 年度分賦課減免リスト.get過年度1();
        GemmenJoho 過年度2 = 年度分賦課減免リスト.get過年度2();
        KiwarigakuKanendo1Div 過年度1パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo1();
        KiwarigakuKanendo2Div 過年度2パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo2();
        if (過年度1 != null && 過年度2 == null) {
            過年度1パネル.setDisplayNone(false);
            過年度2パネル.setDisplayNone(true);
            set過年度情報グリッド1(過年度1);
        } else if (過年度1 == null && 過年度2 != null) {
            過年度1パネル.setDisplayNone(false);
            過年度2パネル.setDisplayNone(true);
            set過年度情報グリッド1(過年度2);
        } else if (過年度1 != null && 過年度2 != null) {
            過年度1パネル.setDisplayNone(false);
            過年度2パネル.setDisplayNone(false);
            set過年度情報グリッド1(過年度1);
            set過年度情報グリッド2(過年度2);
        }
    }

    /**
     * 全賦課履歴情報グリッドの選択ボタン押下のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return 減免リスト NendobunFukaGemmenListResult
     */
    public NendobunFukaGemmenListResult onClick_選択ボタン(HihokenshaNo 被保険者番号) {
        IFukaRirekiAllDiv 全賦課履歴 = div.getGemmenFukaRirekiAll().getCcdFukaRirekiAll();
        TsuchishoNo 通知書番号 = 全賦課履歴.getClicked通知書番号();
        FlexibleYear 調定年度 = 全賦課履歴.getClicked調定年度();
        FlexibleYear 賦課年度 = 全賦課履歴.getClicked賦課年度();
        NendobunFukaGemmenListResult 減免リスト = KaigoHokenryoGemmen.createInstance()
                .getJokyo(調定年度, 賦課年度, 通知書番号, 被保険者番号);
        return 減免リスト;
    }

    /**
     * 「訂正する」ボタン押下、画面の状態制御です。
     */
    public void onClick_訂正の状態() {
        ShinseiJokyoDiv 状況情報パネル = div.getGemmenMain().getShinseiJokyo();
        状況情報パネル.setDisplayNone(false);
        状況情報パネル.getBtnTesei().setVisible(false);
        状況情報パネル.getBtnTorikeshi().setVisible(false);
        div.getGemmenMain().getTorikeshiInfo().setDisplayNone(true);
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        申請情報パネル.setDisplayNone(false);
        申請情報パネル.getTxtShinseiYMD().setReadOnly(false);
        申請情報パネル.getTxtShinseiGemmengaku().setReadOnly(false);
        申請情報パネル.getBtnGemmenShurui().setDisabled(false);
        申請情報パネル.getTxtShinseiRiyu().setReadOnly(false);
        申請情報パネル.getTxtGemmenShurui().setReadOnly(true);
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        決定情報パネル.setDisplayNone(false);
        決定情報パネル.getTxtKetteiYMD().setReadOnly(false);
        決定情報パネル.getTxtZenkaiGemmengaku().setReadOnly(true);
        決定情報パネル.getRadKetteiKubun().setDisabled(false);
        決定情報パネル.getTxtKetteiRiyu().setReadOnly(false);
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        減免情報パネル.setDisplayNone(false);
        減免情報パネル.getTxtGemmengaku().setReadOnly(false);
        減免情報パネル.getBtnCalculate().setDisabled(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(訂正をやめるボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
    }

    /**
     * 状況情報パネル、取消情報パネル、申請情報パネル、決定情報パネルと減免情報パネルのクリアメソッドです。
     */
    public void clearパネル() {
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        TorikeshiInfoDiv 取消情報パネル = div.getGemmenMain().getTorikeshiInfo();
        申請情報パネル.getTxtChoteiYY().clearValue();
        申請情報パネル.getTxtFukaYY().clearValue();
        申請情報パネル.getTxtShinseiYMD().clearValue();
        申請情報パネル.getTxtShinseiGemmengaku().clearValue();
        申請情報パネル.getTxtGemmenShurui().clearValue();
        申請情報パネル.getTxtShinseiRiyu().setValue(null);
        決定情報パネル.getTxtKetteiYMD().clearValue();
        決定情報パネル.getTxtZenkaiGemmengaku().clearValue();
        決定情報パネル.getRadKetteiKubun().setSelectedIndex(ゼロ_定値);
        決定情報パネル.getTxtKetteiRiyu().setValue(null);
        取消情報パネル.getTxtTorikeshiYMD().clearValue();
        取消情報パネル.getTxtTorikeshiShurui().clearValue();
        取消情報パネル.getTxtTorikeshiRiyu().clearValue();
        減免情報パネル.getTxtGemmengaku().clearValue();
    }

    /**
     * 取消情報パネルのクリアメソッドです。
     */
    public void clear取消パネル() {
        TorikeshiInfoDiv 取消情報パネル = div.getGemmenMain().getTorikeshiInfo();
        取消情報パネル.getTxtTorikeshiYMD().clearValue();
        取消情報パネル.getTxtTorikeshiShurui().clearValue();
        取消情報パネル.getTxtTorikeshiRiyu().setValue(null);
        取消情報パネル.getTxtTorikeshiRiyu().clearValue();
    }

    /**
     * 「取消する」ボタン押下、画面の状態制御です。
     */
    public void onClick_取消の状態() {
        ShinseiJokyoDiv 状況情報パネル = div.getGemmenMain().getShinseiJokyo();
        状況情報パネル.setDisplayNone(false);
        状況情報パネル.getBtnTesei().setVisible(false);
        状況情報パネル.getBtnTorikeshi().setVisible(false);
        RString 状況 = 状況情報パネル.getTxtShinseiJokyo().getValue();
        div.getGemmenMain().getTorikeshiInfo().setDisplayNone(false);
        TorikeshiInfoDiv 取消情報パネル = div.getGemmenMain().getTorikeshiInfo();
        取消情報パネル.setDisplayNone(false);
        取消情報パネル.getTxtTorikeshiYMD().setValue(null);
        取消情報パネル.getTxtTorikeshiYMD().setRequired(true);
        取消情報パネル.getTxtTorikeshiShurui().setValue(null);
        取消情報パネル.getTxtTorikeshiRiyu().setValue(null);
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        申請情報パネル.setDisplayNone(false);
        申請情報パネル.getTxtShinseiYMD().setReadOnly(true);
        申請情報パネル.getTxtShinseiGemmengaku().setReadOnly(true);
        申請情報パネル.getBtnGemmenShurui().setDisabled(true);
        申請情報パネル.getTxtShinseiRiyu().setReadOnly(true);
        申請情報パネル.getTxtGemmenShurui().setReadOnly(true);
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        if (状況_申請中.equals(状況)) {
            決定情報パネル.setDisplayNone(true);
            減免情報パネル.setDisplayNone(true);
        } else if (状況_決定済.equals(状況)) {
            決定情報パネル.setDisplayNone(false);
            減免情報パネル.setDisplayNone(false);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(true);
            決定情報パネル.getTxtZenkaiGemmengaku().setReadOnly(true);
            決定情報パネル.getRadKetteiKubun().setDisabled(true);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(true);
            減免情報パネル.getTxtGemmengaku().setReadOnly(true);
            減免情報パネル.getBtnCalculate().setDisabled(true);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(取消をやめるボタン, false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, false);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
    }

    /**
     * 期別減免情報リストを生成する。
     *
     * @param 現年度 GemmenJoho
     * @return List<KibetsuGemmenList> 期別減免情報リスト
     */
    public List<KibetsuGemmenList> get期別減免情報リスト(GemmenJoho 現年度) {
        List<KibetsuGemmenList> 期別減免情報リスト = new ArrayList<>();
        for (int i = イチ_定値; i < ジュウゴ_定値; i++) {
            KibetsuGemmenList 期別減免情報 = new KibetsuGemmenList();
            Kitsuki 期月_特徴 = 特徴期月リスト.get期の最初月(i);
            Kitsuki 期月_普徴 = 普徴期月リスト.get期の最初月(i);
            if (期月_特徴.isPresent()) {
                期別減免情報.set特徴期(期月_特徴.get期().padZeroToLeft(二_定値));
                期別減免情報.set特徴月(期月_特徴.get月().getコード());
                Decimal 特徴期別金額 = get減免前特徴期別金額(期月_特徴.get期(), 現年度);
                if (特徴期別金額 != null) {
                    期別減免情報.set特徴期別金額(DecimalFormatter.toコンマ区切りRString(特徴期別金額, ゼロ_定値));
                } else {
                    期別減免情報.set特徴期別金額(定値_ゼロ);
                }
            } else {
                期別減免情報.set特徴期(空);
                期別減免情報.set特徴月(空);
                期別減免情報.set特徴期別金額(空);
            }
            if (期月_普徴.isPresent()) {
                期別減免情報.set普徴期(期月_普徴.get期().padZeroToLeft(二_定値));
                期別減免情報.set普徴月(期月_普徴.get月().getコード());
                Decimal 普徴期別金額 = get減免前普徴期別金額(期月_普徴.get期(), 現年度);
                if (普徴期別金額 != null) {
                    期別減免情報.set普徴期別減免前(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
                } else {
                    期別減免情報.set普徴期別減免前(定値_ゼロ);
                }
                Noki 賦課納期 = FukaNokiResearcher.createInstance().get普徴納期(Integer.valueOf(期月_普徴.get期().toString()));
                RDate 納期限 = 賦課納期.get納期限();
                if (納期限 != null) {
                    期別減免情報.set普徴期別納期限(納期限.wareki().toDateString());
                }
            } else {
                期別減免情報.set普徴期(空);
                期別減免情報.set普徴月(空);
                期別減免情報.set普徴期別減免前(空);
                期別減免情報.set普徴期別納期限(空);
            }
            期別減免情報リスト.add(期別減免情報);
        }
        return 期別減免情報リスト;
    }

    private void set過年度情報グリッド1(GemmenJoho 過年度1) {
        KiwarigakuKanendo1Div 過年度1パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo1();
        過年度1パネル.getLblKiwarigaku24Gatsu().setText(空);
        過年度1パネル.getTxtKanendoChoteiYY1().setValue(new RDate(過年度1.get調定年度().toString()));
        過年度1パネル.getTxtKanendoFukaYY1().setValue(new RDate(過年度1.get賦課年度().toString()));

        List<Kibetsu> 介護期別情報リスト = 過年度1.getKibetsuList();
        if (介護期別情報リスト == null || 介護期別情報リスト.isEmpty()) {
            return;
        }
        Kibetsu 介護期別情報 = 介護期別情報リスト.get(ゼロ_定値);
        int 期 = 介護期別情報.get期();
        List<Kitsuki> 期の月List = 過年度期月リスト.get期の月(期);
        int 月_期 = 期の月List.get(0).get月AsInt();
        RString 月 = new RString(月_期).concat(月R);
        過年度1パネル.getLblKiwarigaku24Gatsu().setText(月);
        過年度1パネル.getKiwarigakuPanel2().getKi1().setText(get期(new RString(期)));
        Decimal 普徴期別金額 = get減免前普徴期別金額(new RString(期), 過年度1);
        if (普徴期別金額 != null) {
            過年度1パネル.getKiwarigakuPanel2().getMae1().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
            過年度1パネル.getKiwarigakuPanel2().getMaeTotalMae1().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
        } else {
            過年度1パネル.getKiwarigakuPanel2().getMae1().setText(null);
            過年度1パネル.getKiwarigakuPanel2().getMaeTotalMae1().setText(null);
        }
        Noki 賦課納期 = FukaNokiResearcher.createInstance().get過年度納期(期);
        RDate 納期限 = 賦課納期.get納期限();
        if (納期限 != null) {
            過年度1パネル.getKiwarigakuPanel2().getNokigen1().setText(納期限.wareki().toDateString());
        } else {
            過年度1パネル.getKiwarigakuPanel2().getNokigen1().setText(null);
        }
    }

    private void set過年度情報グリッド2(GemmenJoho 過年度2) {
        KiwarigakuKanendo2Div 過年度2パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo2();
        過年度2パネル.getLblKiwarigaku34Gatsu().setText(空);
        過年度2パネル.getTxtKanendoChoteiYY2().setValue(new RDate(過年度2.get調定年度().toString()));
        過年度2パネル.getTxtKanendoFukaYY2().setValue(new RDate(過年度2.get賦課年度().toString()));
        List<Kibetsu> 介護期別情報リスト = 過年度2.getKibetsuList();

        if (介護期別情報リスト == null || 介護期別情報リスト.isEmpty()) {
            return;
        }
        Kibetsu 介護期別情報 = 介護期別情報リスト.get(ゼロ_定値);
        int 期 = 介護期別情報.get期();
        List<Kitsuki> 期の月List = 過年度期月リスト.get期の月(期);
        int 月_期 = 期の月List.get(0).get月AsInt();
        RString 月 = new RString(月_期).concat(月R);
        過年度2パネル.getLblKiwarigaku34Gatsu().setText(月);
        過年度2パネル.getKiwarigakuPanel3().getKi2().setText(get期(new RString(期)));
        Decimal 普徴期別金額 = get減免前普徴期別金額(new RString(期), 過年度2);
        if (普徴期別金額 != null) {
            過年度2パネル.getKiwarigakuPanel3().getMae2().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
            過年度2パネル.getKiwarigakuPanel3().getMaeTotalMae2().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
        } else {
            過年度2パネル.getKiwarigakuPanel3().getMae2().setText(null);
            過年度2パネル.getKiwarigakuPanel3().getMaeTotalMae2().setText(null);
        }
        Noki 賦課納期 = FukaNokiResearcher.createInstance().get過年度納期(期);
        RDate 納期限 = 賦課納期.get納期限();
        if (納期限 != null) {
            過年度2パネル.getKiwarigakuPanel3().getNokigen().setText(納期限.wareki().toDateString());
        } else {
            過年度2パネル.getKiwarigakuPanel3().getNokigen().setText(null);
        }
    }

    private void set特別徴収グリッド(GemmenJoho 現年度) {
        KiwarigakuPanel1Div 減免情報パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuPanel1();
        RString 期_4月 = 特徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_6月 = 特徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_8月 = 特徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_10月 = 特徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_12月 = 特徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_2月 = 特徴期月リスト.get月の期(Tsuki._2月).get期();
        減免情報パネル.getLblTokuchoKi1().setText(get期(期_4月));
        減免情報パネル.getLblTokuchoKi2().setText(get期(期_6月));
        減免情報パネル.getLblTokuchoKi3().setText(get期(期_8月));
        減免情報パネル.getLblTokuchoKi4().setText(get期(期_10月));
        減免情報パネル.getLblTokuchoKi5().setText(get期(期_12月));
        減免情報パネル.getLblTokuchoKi6().setText(get期(期_2月));
        Decimal 特徴期別金額_4月 = get減免前特徴期別金額(期_4月, 現年度);
        Decimal 特徴期別金額_6月 = get減免前特徴期別金額(期_6月, 現年度);
        Decimal 特徴期別金額_8月 = get減免前特徴期別金額(期_8月, 現年度);
        Decimal 特徴期別金額_10月 = get減免前特徴期別金額(期_10月, 現年度);
        Decimal 特徴期別金額_12月 = get減免前特徴期別金額(期_12月, 現年度);
        Decimal 特徴期別金額_2月 = get減免前特徴期別金額(期_2月, 現年度);
        Decimal 特別徴収_合計 = Decimal.ZERO;
        if (特徴期別金額_4月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_4月);
            減免情報パネル.getLblTokuchoGemmemMae1().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_4月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae1().setText(null);
        }
        if (特徴期別金額_6月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_6月);
            減免情報パネル.getLblTokuchoGemmemMae2().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_6月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae2().setText(null);
        }
        if (特徴期別金額_8月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_8月);
            減免情報パネル.getLblTokuchoGemmemMae3().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_8月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae3().setText(null);
        }
        if (特徴期別金額_10月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_10月);
            減免情報パネル.getLblTokuchoGemmemMae4().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_10月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae4().setText(null);
        }
        if (特徴期別金額_12月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_12月);
            減免情報パネル.getLblTokuchoGemmemMae5().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_12月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae5().setText(null);
        }
        if (特徴期別金額_2月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_2月);
            減免情報パネル.getLblTokuchoGemmemMae6().setText(DecimalFormatter.toコンマ区切りRString(特徴期別金額_2月, ゼロ_定値));
        } else {
            減免情報パネル.getLblTokuchoGemmemMae6().setText(null);
        }
        減免情報パネル.getLblTokuchoGemmemMaeTotal().setText(DecimalFormatter.toコンマ区切りRString(特別徴収_合計, ゼロ_定値));
    }

    private void set普通徴収グリッド(GemmenJoho 現年度) {
        KiwarigakuPanel1Div 減免情報パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuPanel1();
        RString 期_4月 = 普徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 普徴期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 普徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 普徴期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 普徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 普徴期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 普徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_11月 = 普徴期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 普徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 普徴期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 普徴期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 普徴期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_翌年4月 = 普徴期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_翌年5月 = 普徴期月リスト.get月の期(Tsuki.翌年度5月).get期();
        減免情報パネル.getLblFuchoKi13().setText(get期(期_4月));
        減免情報パネル.getLblFuchoKi14().setText(get期(期_5月));
        減免情報パネル.getLblFuchoKi1().setText(get期(期_6月));
        減免情報パネル.getLblFuchoKi2().setText(get期(期_7月));
        減免情報パネル.getLblFuchoKi3().setText(get期(期_8月));
        減免情報パネル.getLblFuchoKi4().setText(get期(期_9月));
        減免情報パネル.getLblFuchoKi5().setText(get期(期_10月));
        減免情報パネル.getLblFuchoKi6().setText(get期(期_11月));
        減免情報パネル.getLblFuchoKi7().setText(get期(期_12月));
        減免情報パネル.getLblFuchoKi8().setText(get期(期_1月));
        減免情報パネル.getLblFuchoKi9().setText(get期(期_2月));
        減免情報パネル.getLblFuchoKi10().setText(get期(期_3月));
        減免情報パネル.getLblFuchoKi11().setText(get期(期_翌年4月));
        減免情報パネル.getLblFuchoKi12().setText(get期(期_翌年5月));
        Decimal 普徴期別金額_4月 = get減免前普徴期別金額(期_4月, 現年度);
        Decimal 普徴期別金額_5月 = get減免前普徴期別金額(期_5月, 現年度);
        Decimal 普徴期別金額_6月 = get減免前普徴期別金額(期_6月, 現年度);
        Decimal 普徴期別金額_7月 = get減免前普徴期別金額(期_7月, 現年度);
        Decimal 普徴期別金額_8月 = get減免前普徴期別金額(期_8月, 現年度);
        Decimal 普徴期別金額_9月 = get減免前普徴期別金額(期_9月, 現年度);
        Decimal 普徴期別金額_10月 = get減免前普徴期別金額(期_10月, 現年度);
        Decimal 普徴期別金額_11月 = get減免前普徴期別金額(期_11月, 現年度);
        Decimal 普徴期別金額_12月 = get減免前普徴期別金額(期_12月, 現年度);
        Decimal 普徴期別金額_1月 = get減免前普徴期別金額(期_1月, 現年度);
        Decimal 普徴期別金額_2月 = get減免前普徴期別金額(期_2月, 現年度);
        Decimal 普徴期別金額_3月 = get減免前普徴期別金額(期_3月, 現年度);
        Decimal 普徴期別金額_翌年4月 = get減免前普徴期別金額(期_翌年4月, 現年度);
        Decimal 普徴期別金額_翌年5月 = get減免前普徴期別金額(期_翌年5月, 現年度);
        Decimal 普通徴収_合計 = set減免前普徴期別金額(普徴期別金額_4月, 普徴期別金額_5月, 普徴期別金額_6月, 普徴期別金額_7月,
                普徴期別金額_8月, 普徴期別金額_9月, 普徴期別金額_10月, 普徴期別金額_11月, 普徴期別金額_12月, 普徴期別金額_1月,
                普徴期別金額_2月, 普徴期別金額_3月, 普徴期別金額_翌年4月, 普徴期別金額_翌年5月, 減免情報パネル);
        減免情報パネル.getLblFuchoGemmemMaeTotal().setText(DecimalFormatter.toコンマ区切りRString(普通徴収_合計, ゼロ_定値));
        set納期限(期_4月, 期_5月, 期_6月, 期_7月, 期_8月, 期_9月, 期_10月,
                期_11月, 期_12月, 期_1月, 期_2月, 期_3月, 期_翌年4月, 期_翌年5月, 減免情報パネル);
    }

    private RString get納期限(RString 期) {
        Noki 賦課納期 = FukaNokiResearcher.createInstance().get普徴納期(Integer.valueOf(期.toString()));
        if (賦課納期 != null) {
            return 賦課納期.get納期限().wareki().toDateString();
        }
        return null;
    }

    private RString get期(RString 期) {
        if (期 != null && !期.isEmpty()) {
            return 期.trimStart(定値_ゼロ.toString().charAt(ゼロ_定値)).concat(期R);
        }
        return null;
    }

    private Decimal get減免前特徴期別金額(RString 期, GemmenJoho 現年度) {
        if (期 == null || 期.isEmpty()) {
            return null;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return 現年度.get特徴期別金額01();
            case 二_定値:
                return 現年度.get特徴期別金額02();
            case ミ_定値:
                return 現年度.get特徴期別金額03();
            case ヨ_定値:
                return 現年度.get特徴期別金額04();
            case ゴ_定値:
                return 現年度.get特徴期別金額05();
            case ロク_定値:
                return 現年度.get特徴期別金額06();
            default:
                return null;
        }
    }

    private void set納期限(RString 期_4月, RString 期_5月, RString 期_6月, RString 期_7月, RString 期_8月,
            RString 期_9月, RString 期_10月, RString 期_11月, RString 期_12月, RString 期_1月, RString 期_2月,
            RString 期_3月, RString 期_翌年4月, RString 期_翌年5月, KiwarigakuPanel1Div 減免情報パネル) {
        if (!期_4月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen13().setText(get納期限(期_4月));
        }
        if (!期_5月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen14().setText(get納期限(期_5月));
        }
        if (!期_6月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen1().setText(get納期限(期_6月));
        }
        if (!期_7月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen2().setText(get納期限(期_7月));
        }
        if (!期_8月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen3().setText(get納期限(期_8月));
        }
        if (!期_9月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen4().setText(get納期限(期_9月));
        }
        if (!期_10月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen5().setText(get納期限(期_10月));
        }
        if (!期_11月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen6().setText(get納期限(期_11月));
        }
        if (!期_12月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen7().setText(get納期限(期_12月));
        }
        if (!期_1月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen8().setText(get納期限(期_1月));
        }
        if (!期_2月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen9().setText(get納期限(期_2月));
        }
        if (!期_3月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen10().setText(get納期限(期_3月));
        }
        if (!期_翌年4月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen11().setText(get納期限(期_翌年4月));
        }
        if (!期_翌年5月.isEmpty()) {
            減免情報パネル.getLblFuchoNokigen12().setText(get納期限(期_翌年5月));
        }
    }

    private Decimal set減免後普徴期別金額(Decimal 普徴期別金額_4月, Decimal 普徴期別金額_5月, Decimal 普徴期別金額_6月,
            Decimal 普徴期別金額_7月, Decimal 普徴期別金額_8月, Decimal 普徴期別金額_9月, Decimal 普徴期別金額_10月,
            Decimal 普徴期別金額_11月, Decimal 普徴期別金額_12月, Decimal 普徴期別金額_1月, Decimal 普徴期別金額_2月,
            Decimal 普徴期別金額_3月, Decimal 普徴期別金額_翌年4月, Decimal 普徴期別金額_翌年5月, KiwarigakuPanel1Div 減免情報パネル) {
        Decimal 普通徴収_合計 = Decimal.ZERO;
        減免情報パネル.getTxtFuchoGemmemGo13().setValue(普徴期別金額_4月);
        減免情報パネル.getTxtFuchoGemmemGo14().setValue(普徴期別金額_5月);
        減免情報パネル.getTxtFuchoGemmemGo1().setValue(普徴期別金額_6月);
        減免情報パネル.getTxtFuchoGemmemGo2().setValue(普徴期別金額_7月);
        減免情報パネル.getTxtFuchoGemmemGo3().setValue(普徴期別金額_8月);
        減免情報パネル.getTxtFuchoGemmemGo4().setValue(普徴期別金額_9月);
        減免情報パネル.getTxtFuchoGemmemGo5().setValue(普徴期別金額_10月);
        減免情報パネル.getTxtFuchoGemmemGo6().setValue(普徴期別金額_11月);
        減免情報パネル.getTxtFuchoGemmemGo7().setValue(普徴期別金額_12月);
        減免情報パネル.getTxtFuchoGemmemGo8().setValue(普徴期別金額_1月);
        減免情報パネル.getTxtFuchoGemmemGo9().setValue(普徴期別金額_2月);
        減免情報パネル.getTxtFuchoGemmemGo10().setValue(普徴期別金額_3月);
        減免情報パネル.getTxtFuchoGemmemGo11().setValue(普徴期別金額_翌年4月);
        減免情報パネル.getTxtFuchoGemmemGo12().setValue(普徴期別金額_翌年5月);
        if (普徴期別金額_4月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_4月);
        }
        if (普徴期別金額_5月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_5月);
        }
        if (普徴期別金額_6月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_6月);
        }
        if (普徴期別金額_7月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_7月);
        }
        if (普徴期別金額_8月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_8月);
        }
        if (普徴期別金額_9月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_9月);
        }
        if (普徴期別金額_10月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_10月);
        }
        if (普徴期別金額_11月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_11月);
        }
        if (普徴期別金額_12月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_12月);
        }
        if (普徴期別金額_1月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_1月);
        }
        if (普徴期別金額_2月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_2月);
        }
        if (普徴期別金額_3月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_3月);
        }
        if (普徴期別金額_翌年4月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_翌年4月);
        }
        if (普徴期別金額_翌年5月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_翌年5月);
        }
        return 普通徴収_合計;
    }

    private Decimal set減免前普徴期別金額(Decimal 普徴期別金額_4月, Decimal 普徴期別金額_5月, Decimal 普徴期別金額_6月,
            Decimal 普徴期別金額_7月, Decimal 普徴期別金額_8月, Decimal 普徴期別金額_9月, Decimal 普徴期別金額_10月,
            Decimal 普徴期別金額_11月, Decimal 普徴期別金額_12月, Decimal 普徴期別金額_1月, Decimal 普徴期別金額_2月,
            Decimal 普徴期別金額_3月, Decimal 普徴期別金額_翌年4月, Decimal 普徴期別金額_翌年5月, KiwarigakuPanel1Div 減免情報パネル) {
        Decimal 普通徴収_合計 = Decimal.ZERO;
        if (普徴期別金額_4月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_4月);
            減免情報パネル.getLblFuchoGemmemMae13().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_4月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae13().setText(null);
        }
        if (普徴期別金額_5月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_5月);
            減免情報パネル.getLblFuchoGemmemMae14().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_5月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae14().setText(null);
        }
        if (普徴期別金額_6月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_6月);
            減免情報パネル.getLblFuchoGemmemMae1().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_6月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae1().setText(null);
        }
        if (普徴期別金額_7月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_7月);
            減免情報パネル.getLblFuchoGemmemMae2().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_7月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae2().setText(null);
        }
        if (普徴期別金額_8月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_8月);
            減免情報パネル.getLblFuchoGemmemMae3().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_8月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae3().setText(null);
        }
        if (普徴期別金額_9月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_9月);
            減免情報パネル.getLblFuchoGemmemMae4().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_9月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae4().setText(null);
        }
        if (普徴期別金額_10月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_10月);
            減免情報パネル.getLblFuchoGemmemMae5().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_10月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae5().setText(null);
        }
        if (普徴期別金額_11月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_11月);
            減免情報パネル.getLblFuchoGemmemMae6().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_11月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae6().setText(null);
        }
        if (普徴期別金額_12月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_12月);
            減免情報パネル.getLblFuchoGemmemMae7().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_12月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae7().setText(null);
        }
        if (普徴期別金額_1月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_1月);
            減免情報パネル.getLblFuchoGemmemMae8().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_1月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae8().setText(null);
        }
        if (普徴期別金額_2月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_2月);
            減免情報パネル.getLblFuchoGemmemMae9().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_2月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae9().setText(null);
        }
        if (普徴期別金額_3月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_3月);
            減免情報パネル.getLblFuchoGemmemMae10().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_3月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae10().setText(null);
        }
        if (普徴期別金額_翌年4月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_翌年4月);
            減免情報パネル.getLblFuchoGemmemMae11().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_翌年4月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae11().setText(null);
        }
        if (普徴期別金額_翌年5月 != null) {
            普通徴収_合計 = 普通徴収_合計.add(普徴期別金額_翌年5月);
            減免情報パネル.getLblFuchoGemmemMae12().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額_翌年5月, ゼロ_定値));
        } else {
            減免情報パネル.getLblFuchoGemmemMae12().setText(null);
        }
        return 普通徴収_合計;
    }

    private Decimal get減免前普徴期別金額(RString 期, GemmenJoho 現年度) {
        if (期 == null || 期.isEmpty()) {
            return null;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return 現年度.get普徴期別金額01();
            case 二_定値:
                return 現年度.get普徴期別金額02();
            case ミ_定値:
                return 現年度.get普徴期別金額03();
            case ヨ_定値:
                return 現年度.get普徴期別金額04();
            case ゴ_定値:
                return 現年度.get普徴期別金額05();
            case ロク_定値:
                return 現年度.get普徴期別金額06();
            case ナナ_定値:
                return 現年度.get普徴期別金額07();
            case ハチ_定値:
                return 現年度.get普徴期別金額08();
            case キュウ_定値:
                return 現年度.get普徴期別金額09();
            case ジュウ_定値:
                return 現年度.get普徴期別金額10();
            case ジュウイチ_定値:
                return 現年度.get普徴期別金額11();
            case ジュウ二_定値:
                return 現年度.get普徴期別金額12();
            case ジュウミ_定値:
                return 現年度.get普徴期別金額13();
            case ジュウヨ_定値:
                return 現年度.get普徴期別金額14();
            default:
                return null;
        }
    }

    /**
     * 全賦課履歴情報.表示件数＝1件の場合、パネルの状態の設定する。
     *
     * @param 状況 RString
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     */
    public void loadパネル状態1(RString 状況, NendobunFukaGemmenList 年度分賦課減免リスト) {
        div.getGemmenMain().getTorikeshiInfo().setDisplayNone(true);
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        申請情報パネル.setDisplayNone(false);
        申請情報パネル.getTxtGemmenShurui().setReadOnly(true);
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        決定情報パネル.getTxtZenkaiGemmengaku().setReadOnly(true);
        決定情報パネル.setDisplayNone(false);
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        減免情報パネル.setDisplayNone(false);
        div.getGemmenMain().getShinseiJokyo().setDisplayNone(false);
        div.getGemmenMain().getShinseiinfo().setDisplayNone(false);
        div.getGemmenMain().getKeteiinfo().setDisplayNone(false);
        div.getGemmenMain().getKiwarigaku().setDisplayNone(false);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存ボタン, false);
        if (状況_新規.equals(状況) || 状況_申請中.equals(状況)) {
            申請情報パネル.getTxtShinseiYMD().setReadOnly(false);
            申請情報パネル.getTxtShinseiGemmengaku().setReadOnly(false);
            申請情報パネル.getBtnGemmenShurui().setDisabled(false);
            申請情報パネル.getTxtShinseiRiyu().setReadOnly(false);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(false);
            決定情報パネル.getRadKetteiKubun().setDisabled(false);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(false);
            減免情報パネル.getTxtGemmengaku().setReadOnly(false);
            減免情報パネル.getBtnCalculate().setDisabled(false);
            減免情報パネル.getKiwarigakuPanel1().setDisplayNone(false);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, false);
        } else if (状況_決定済.equals(状況)) {
            申請情報パネル.getTxtShinseiYMD().setReadOnly(true);
            申請情報パネル.getTxtShinseiGemmengaku().setReadOnly(true);
            申請情報パネル.getBtnGemmenShurui().setDisabled(true);
            申請情報パネル.getTxtShinseiRiyu().setReadOnly(true);
            決定情報パネル.getTxtKetteiYMD().setReadOnly(true);
            決定情報パネル.getRadKetteiKubun().setDisabled(true);
            決定情報パネル.getTxtKetteiRiyu().setReadOnly(true);
            減免情報パネル.getTxtGemmengaku().setReadOnly(true);
            減免情報パネル.getBtnCalculate().setDisabled(true);
            CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
        }
        if (年度分賦課減免リスト.isHas過年度賦課()) {
            減免情報パネル.getKiwarigakuKanendo1().setDisplayNone(false);
            if (年度分賦課減免リスト.get過年度1() != null && 年度分賦課減免リスト.get過年度2() != null) {
                減免情報パネル.getKiwarigakuKanendo2().setDisplayNone(false);
            }
        } else {
            減免情報パネル.getKiwarigakuKanendo1().setDisplayNone(true);
            減免情報パネル.getKiwarigakuKanendo2().setDisplayNone(true);
        }
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
    }

    /**
     * 「計算する」ボタンの事件です。
     *
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     * @param 被保険者番号 HihokenshaNo
     * @param 賦課年度 FlexibleYear
     */
    public void 計算する(NendobunFukaGemmenList 年度分賦課減免リスト, FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        CalculateChoteiParameter para = new CalculateChoteiParameter();
        para.set賦課年度(年度分賦課減免リスト.get賦課年度());
        para.set調定日時(YMDHMS.now());
        para.set年度分賦課リスト_更正前(年度分賦課減免リスト.to年度分賦課リスト());
        para.set徴収方法の情報_更正前(new ChoshuHohoManager().get介護徴収方法(賦課年度, 被保険者番号));
        Decimal 減免前介護保険料_年額 = 年度分賦課減免リスト.get現年度().get減免前介護保険料_年額();
        Decimal 減免額_画面 = div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue();
        Decimal 減免額 = (減免前介護保険料_年額 != null ? 減免前介護保険料_年額 : Decimal.ZERO)
                .subtract(減免額_画面 != null ? 減免額_画面 : Decimal.ZERO);
        para.set年額保険料(減免額);
        para.set資格の情報(HihokenshaDaichoManager.createInstance().selectByHihokenshaNo(被保険者番号));
        KoseiShorikoaResult 計算結果fuka = FukaKeisan.createInstance().do調定計算(para);
        NendobunFukaGemmenListResult 計算結果 = new NendobunFukaGemmenListResult(計算結果fuka, 年度分賦課減免リスト);
        set減免後普通徴収グリッド(計算結果);
        set減免後特別徴収グリッド(計算結果);
        set減免後過年度情報グリッド1(計算結果);
        set減免後過年度情報グリッド2(計算結果);
    }

    private void set減免後過年度情報グリッド1(NendobunFukaGemmenListResult 計算結果) {
        if (計算結果 == null || 計算結果.get年度分賦課減免リスト() == null || 計算結果.get年度分賦課減免リスト().get過年度1() == null) {
            return;
        }
        GemmenJoho 過年度1 = 計算結果.get年度分賦課減免リスト().get過年度1();
        if (過年度1 == null) {
            return;
        }
        List<Kibetsu> 介護期別情報リスト = 過年度1.getKibetsuList();
        if (介護期別情報リスト == null || 介護期別情報リスト.isEmpty()) {
            return;
        }
        Kibetsu 介護期別情報 = 介護期別情報リスト.get(ゼロ_定値);
        Decimal 普徴期別金額 = get減免前普徴期別金額(new RString(介護期別情報.get期()), 過年度1);
        KiwarigakuKanendo1Div 過年度1パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo1();
        if (普徴期別金額 != null) {
            過年度1パネル.getKiwarigakuPanel2().getTxtGo1().setValue(普徴期別金額);
            過年度1パネル.getKiwarigakuPanel2().getMaeTotalGo1().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
        } else {
            過年度1パネル.getKiwarigakuPanel2().getTxtGo1().setValue(null);
            過年度1パネル.getKiwarigakuPanel2().getMaeTotalGo1().setText(null);
        }
    }

    private void set減免後過年度情報グリッド2(NendobunFukaGemmenListResult 計算結果) {
        if (計算結果 == null || 計算結果.get年度分賦課減免リスト() == null || 計算結果.get年度分賦課減免リスト().get過年度2() == null) {
            return;
        }
        GemmenJoho 過年度2 = 計算結果.get年度分賦課減免リスト().get過年度2();
        if (過年度2 == null) {
            return;
        }
        List<Kibetsu> 介護期別情報リスト = 過年度2.getKibetsuList();
        if (介護期別情報リスト == null || 介護期別情報リスト.isEmpty()) {
            return;
        }
        Kibetsu 介護期別情報 = 介護期別情報リスト.get(ゼロ_定値);
        Decimal 普徴期別金額 = get減免前普徴期別金額(new RString(介護期別情報.get期()), 過年度2);
        KiwarigakuKanendo2Div 過年度2パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuKanendo2();
        if (普徴期別金額 != null) {
            過年度2パネル.getKiwarigakuPanel3().getTxtGo2().setValue(普徴期別金額);
            過年度2パネル.getKiwarigakuPanel3().getMaeTotalGo2().setText(DecimalFormatter.toコンマ区切りRString(普徴期別金額, ゼロ_定値));
        } else {
            過年度2パネル.getKiwarigakuPanel3().getTxtGo2().setValue(null);
            過年度2パネル.getKiwarigakuPanel3().getMaeTotalGo2().setText(null);
        }
    }

    private void set減免後特別徴収グリッド(NendobunFukaGemmenListResult 計算結果) {
        if (計算結果 == null || 計算結果.get年度分賦課減免リスト() == null || 計算結果.get年度分賦課減免リスト().get現年度() == null) {
            return;
        }
        GemmenJoho 現年度 = 計算結果.get年度分賦課減免リスト().get現年度();
        KiwarigakuPanel1Div 減免情報パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuPanel1();
        RString 期_4月 = 特徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_6月 = 特徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_8月 = 特徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_10月 = 特徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_12月 = 特徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_2月 = 特徴期月リスト.get月の期(Tsuki._2月).get期();
        Decimal 特徴期別金額_4月 = get減免前特徴期別金額(期_4月, 現年度);
        Decimal 特徴期別金額_6月 = get減免前特徴期別金額(期_6月, 現年度);
        Decimal 特徴期別金額_8月 = get減免前特徴期別金額(期_8月, 現年度);
        Decimal 特徴期別金額_10月 = get減免前特徴期別金額(期_10月, 現年度);
        Decimal 特徴期別金額_12月 = get減免前特徴期別金額(期_12月, 現年度);
        Decimal 特徴期別金額_2月 = get減免前特徴期別金額(期_2月, 現年度);
        Decimal 特別徴収_合計 = Decimal.ZERO;
        減免情報パネル.getTxtTokuchoGemmemGo1().setValue(特徴期別金額_4月);
        減免情報パネル.getTxtTokuchoGemmemGo2().setValue(特徴期別金額_6月);
        減免情報パネル.getTxtTokuchoGemmemGo3().setValue(特徴期別金額_8月);
        減免情報パネル.getTxtTokuchoGemmemGo4().setValue(特徴期別金額_10月);
        減免情報パネル.getTxtTokuchoGemmemGo5().setValue(特徴期別金額_12月);
        減免情報パネル.getTxtTokuchoGemmemGo6().setValue(特徴期別金額_2月);
        if (特徴期別金額_4月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_4月);
        }
        if (特徴期別金額_6月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_6月);
        }
        if (特徴期別金額_8月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_8月);
        }
        if (特徴期別金額_10月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_10月);
        }
        if (特徴期別金額_12月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_12月);
        }
        if (特徴期別金額_2月 != null) {
            特別徴収_合計 = 特別徴収_合計.add(特徴期別金額_2月);
        }
        減免情報パネル.getLblTokuchoGemmemGoTotal().setText(DecimalFormatter.toコンマ区切りRString(特別徴収_合計, ゼロ_定値));
    }

    private void set減免後普通徴収グリッド(NendobunFukaGemmenListResult 計算結果) {
        if (計算結果 == null || 計算結果.get年度分賦課減免リスト() == null || 計算結果.get年度分賦課減免リスト().get現年度() == null) {
            return;
        }
        GemmenJoho 現年度 = 計算結果.get年度分賦課減免リスト().get現年度();
        KiwarigakuPanel1Div 減免情報パネル = div.getGemmenMain().getKiwarigaku().getKiwarigakuPanel1();
        RString 期_4月 = 普徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 普徴期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 普徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 普徴期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 普徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 普徴期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 普徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_11月 = 普徴期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 普徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 普徴期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 普徴期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 普徴期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_翌年4月 = 普徴期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_翌年5月 = 普徴期月リスト.get月の期(Tsuki.翌年度5月).get期();
        Decimal 普徴期別金額_4月 = get減免前普徴期別金額(期_4月, 現年度);
        Decimal 普徴期別金額_5月 = get減免前普徴期別金額(期_5月, 現年度);
        Decimal 普徴期別金額_6月 = get減免前普徴期別金額(期_6月, 現年度);
        Decimal 普徴期別金額_7月 = get減免前普徴期別金額(期_7月, 現年度);
        Decimal 普徴期別金額_8月 = get減免前普徴期別金額(期_8月, 現年度);
        Decimal 普徴期別金額_9月 = get減免前普徴期別金額(期_9月, 現年度);
        Decimal 普徴期別金額_10月 = get減免前普徴期別金額(期_10月, 現年度);
        Decimal 普徴期別金額_11月 = get減免前普徴期別金額(期_11月, 現年度);
        Decimal 普徴期別金額_12月 = get減免前普徴期別金額(期_12月, 現年度);
        Decimal 普徴期別金額_1月 = get減免前普徴期別金額(期_1月, 現年度);
        Decimal 普徴期別金額_2月 = get減免前普徴期別金額(期_2月, 現年度);
        Decimal 普徴期別金額_3月 = get減免前普徴期別金額(期_3月, 現年度);
        Decimal 普徴期別金額_翌年4月 = get減免前普徴期別金額(期_翌年4月, 現年度);
        Decimal 普徴期別金額_翌年5月 = get減免前普徴期別金額(期_翌年5月, 現年度);
        Decimal 普通徴収_合計 = set減免後普徴期別金額(普徴期別金額_4月, 普徴期別金額_5月, 普徴期別金額_6月, 普徴期別金額_7月,
                普徴期別金額_8月, 普徴期別金額_9月, 普徴期別金額_10月, 普徴期別金額_11月, 普徴期別金額_12月, 普徴期別金額_1月,
                普徴期別金額_2月, 普徴期別金額_3月, 普徴期別金額_翌年4月, 普徴期別金額_翌年5月, 減免情報パネル);
        減免情報パネル.getLblFuchoGemmemGoTotal().setText(DecimalFormatter.toコンマ区切りRString(普通徴収_合計, ゼロ_定値));
    }

    /**
     * 全賦課履歴情報.表示件数 ≠ 1件の場合、パネルの状態の設定する。
     */
    public void loadパネル状態2() {
        div.getGemmenMain().getShinseiJokyo().setDisplayNone(true);
        div.getGemmenMain().getTorikeshiInfo().setDisplayNone(true);
        div.getGemmenMain().getShinseiinfo().setDisplayNone(true);
        div.getGemmenMain().getKeteiinfo().setDisplayNone(true);
        div.getGemmenMain().getKiwarigaku().setDisplayNone(true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(訂正をやめるボタン, true);
        CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(取消をやめるボタン, true);
        CommonButtonHolder.setDisabledByCommonButtonFieldName(保存ボタン, true);
    }

    /**
     * 全賦課履歴情報のVisibleを制御する。
     *
     * @param flag boolean
     */
    public void set全賦課履歴情報Visible(boolean flag) {
        div.getGemmenFukaRirekiAll().setDisplayNone(!flag);
    }

    private RString get状況(RString 減免作成区分) {
        if (減免作成区分 == null || 減免作成区分.isEmpty()) {
            return 空;
        }
        switch (Integer.valueOf(減免作成区分.toString())) {
            case ゼロ_定値:
                return 状況_申請中;
            case イチ_定値:
                return 状況_決定済;
            case 二_定値:
                return 状況_決定済;
            case ミ_定値:
                return 状況_新規;
            case ヨ_定値:
                return 状況_決定済;
            default:
                return 空;
        }
    }

    private void set決定情報パネル(Gemmen 介護賦課減免, KeteiinfoDiv 決定情報パネル) {
        if (介護賦課減免.get減免決定日() != null) {
            決定情報パネル.getTxtKetteiYMD().setValue(介護賦課減免.get減免決定日());
        }
        RString 減免状態区分 = 介護賦課減免.get減免状態区分();
        if (定値_二.equals(減免状態区分)) {
            決定情報パネル.getRadKetteiKubun().setSelectedValue(不承認);
        } else {
            決定情報パネル.getRadKetteiKubun().setSelectedValue(承認);
        }
        RString 減免事由 = 介護賦課減免.get減免事由();
        if (減免事由 == null || 減免事由.isEmpty()) {
            決定情報パネル.getTxtKetteiRiyu().clearValue();
        } else {
            決定情報パネル.getTxtKetteiRiyu().setValue(介護賦課減免.get減免事由());
        }
    }

    private Code set申請情報パネル(Gemmen 介護賦課減免, ShinseiinfoDiv 申請情報パネル) {
        if (介護賦課減免.get減免申請日() != null) {
            申請情報パネル.getTxtShinseiYMD().setValue(new RDate(介護賦課減免.get減免申請日().toString()));
        }
        申請情報パネル.getTxtShinseiGemmengaku().setValue(介護賦課減免.get申請減免額());
        if (介護賦課減免.get減免種類コード() != null) {
            申請情報パネル.getTxtGemmenShurui().setValue(CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課,
                    DBBCodeShubetsu.保険料減免種類.getコード(), 介護賦課減免.get減免種類コード(), FlexibleDate.getNowDate()));
        }
        RString 申請事由 = 介護賦課減免.get申請事由();
        if (申請事由 == null || 申請事由.isEmpty()) {
            申請情報パネル.getTxtShinseiRiyu().clearValue();
        } else {
            申請情報パネル.getTxtShinseiRiyu().setValue(申請事由);
        }
        return 介護賦課減免.get減免種類コード();
    }

    /**
     * 更新確認メッセージを出力する。
     *
     * @param 最新減免の情報 GemmenJoho
     * @return 更新確認メッセージの判断
     */
    public RString メッセージ判断(GemmenJoho 最新減免の情報) {
        RString 状況 = div.getGemmenMain().getShinseiJokyo().getTxtShinseiJokyo().getValue();
        if (状況_新規.equals(状況)) {
            boolean 申請_入力 = is申請情報入力(最新減免の情報);
            boolean 決定_入力 = is決定情報入力(最新減免の情報);
            if (申請_入力 && !決定_入力) {
                return 入力状況_新規申請;
            } else if (決定_入力) {
                return 入力状況_新規決定;
            }
        } else if (状況_申請中.equals(状況)) {
            boolean is取消_入力 = is取消情報入力();
            if (is取消_入力) {
                return 入力状況_申請中取消;
            }
            boolean 申請_入力 = is申請情報入力(最新減免の情報);
            boolean 決定_入力 = is決定情報入力(最新減免の情報);
            if (申請_入力 && !決定_入力) {
                return 入力状況_申請中申請;
            } else if (決定_入力) {
                return 入力状況_申請中決定;
            }
        } else if (状況_決定済.equals(状況)) {
            boolean is取消_入力 = is取消情報入力();
            if (is取消_入力) {
                return 入力状況_決定済取消;
            }
            boolean 申請_入力 = is申請情報入力(最新減免の情報);
            boolean 決定_入力 = is決定情報入力(最新減免の情報);
            if (申請_入力 || 決定_入力) {
                return 入力状況_決定済訂正;
            }
        }
        return 空;
    }

    /**
     * 「保存前編集」を実行する。
     *
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     * @param 賦課年度 FlexibleYear
     * @param 被保険者番号 HihokenshaNo
     * @return 年度分賦課減免リストと徴収方法の情報 NendobunFukaGemmenListResult
     */
    public NendobunFukaGemmenList 保存前の編集(NendobunFukaGemmenList 年度分賦課減免リスト, FlexibleYear 賦課年度, HihokenshaNo 被保険者番号) {
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        GemmenJoho 最新減免の情報 = 年度分賦課減免リスト.get最新減免の情報();
        RString 状況 = div.getGemmenMain().getShinseiJokyo().getTxtShinseiJokyo().getValue();
        RString 状況区分 = 空;
        if (状況_新規.equals(状況)) {
            状況区分 = 定値_ゼロ;
        } else if (状況_申請中.equals(状況)) {
            状況区分 = 定値_イチ;
        } else if (状況_決定済.equals(状況)) {
            状況区分 = 定値_二;
        }
        RString 前回状態区分 = 空;
        List<Gemmen> 介護賦課減免List = 最新減免の情報.getGemmenList();
        if (介護賦課減免List != null && !介護賦課減免List.isEmpty()) {
            Gemmen 介護賦課減免 = 介護賦課減免List.get(0);
            前回状態区分 = 介護賦課減免.get減免状態区分();
        }
        RDate 取消日 = div.getGemmenMain().getTorikeshiInfo().getTxtTorikeshiYMD().getValue();
        RString 今回状態区分;
        RString 今回作成区分;
        if (取消日 != null) {
            今回状態区分 = 前回状態区分;
            今回作成区分 = 定値_ミ;
        } else {
            KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
            FlexibleDate 決定日 = 決定情報パネル.getTxtKetteiYMD().getValue();
            if (決定日 != null) {
                RString 決定区分 = 決定情報パネル.getRadKetteiKubun().getSelectedValue();
                今回状態区分 = 承認.equals(決定区分) ? 定値_イチ : 定値_二;
                今回作成区分 = 定値_二.equals(状況区分) ? 定値_ヨ : 今回状態区分;
            } else {
                今回状態区分 = 定値_ゼロ;
                今回作成区分 = 定値_ゼロ;
            }
        }
        年度分賦課減免リスト = set年度分賦課減免リスト(今回状態区分, 今回作成区分, 最新減免の情報, 年度分賦課減免リスト,
                賦課年度, 被保険者番号, 状況区分, 今回状態区分, 減免情報パネル);
        return 年度分賦課減免リスト;
    }

    private NendobunFukaGemmenList set年度分賦課減免リスト(RString 今回状態区分, RString 今回作成区分,
            GemmenJoho 最新減免の情報, NendobunFukaGemmenList 年度分賦課減免リスト, FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号, RString 状況区分, RString 前回状態区分, KiwarigakuDiv 減免情報パネル) {
        if ((定値_イチ.equals(今回状態区分) && 定値_イチ.equals(今回作成区分))
                || (定値_イチ.equals(今回状態区分) && 定値_ヨ.equals(今回作成区分))) {
            最新減免の情報 = set調定額(最新減免の情報, 減免情報パネル);
            年度分賦課減免リスト.set最新減免の情報(最新減免の情報);
        } else if ((定値_イチ.equals(今回状態区分) && 定値_ミ.equals(今回作成区分))
                || (定値_二.equals(状況区分) && 定値_イチ.equals(前回状態区分)
                && 定値_二.equals(今回状態区分) && 定値_ヨ.equals(今回作成区分))) {
            CalculateChoteiParameter para = new CalculateChoteiParameter();
            para.set賦課年度(年度分賦課減免リスト.get賦課年度());
            para.set調定日時(YMDHMS.now());
            para.set年度分賦課リスト_更正前(年度分賦課減免リスト.to年度分賦課リスト());
            para.set徴収方法の情報_更正前(new ChoshuHohoManager().get介護徴収方法(賦課年度, 被保険者番号));
            Decimal 減免前介護保険料_年額 = 年度分賦課減免リスト.get現年度().get減免前介護保険料_年額();
            Decimal 減免額_画面 = div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue();
            Decimal 減免額 = (減免前介護保険料_年額 != null ? 減免前介護保険料_年額 : Decimal.ZERO)
                    .subtract(減免額_画面 != null ? 減免額_画面 : Decimal.ZERO);
            para.set年額保険料(減免額);
            para.set資格の情報(HihokenshaDaichoManager.createInstance().selectByHihokenshaNo(被保険者番号));
            KoseiShorikoaResult 計算結果 = FukaKeisan.createInstance().do調定計算(para);
            年度分賦課減免リスト = new NendobunFukaGemmenListResult(計算結果, 年度分賦課減免リスト).get年度分賦課減免リスト();
        }
        return 年度分賦課減免リスト;
    }

    /**
     * 更新結果確認画面の初期化メソッドです。
     *
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     * @return show発行ボタン true
     */
    public boolean onClick_btnUpt(NendobunFukaGemmenList 年度分賦課減免リスト) {
        boolean show発行ボタン = true;
        FlexibleYear 調定年度 = 年度分賦課減免リスト.get最新減免の情報().get調定年度();
        FlexibleYear 賦課年度 = 年度分賦課減免リスト.get最新減免の情報().get賦課年度();
        TsuchishoNo 通知書番号 = 年度分賦課減免リスト.get最新減免の情報().get通知書番号();
        GemmenJoho 減免の情報 = KaigoHokenryoGemmen.createInstance().getGemmenJoho(調定年度, 賦課年度, 通知書番号);
        FukaJohoRelateMapperParameter 賦課の情報検索条件
                = FukaJohoRelateMapperParameter.createSelectListParam(調定年度, 賦課年度, 通知書番号);
        List<FukaJoho> 賦課情報List = FukaJohoManager.createInstance().get最新の賦課情報(賦課の情報検索条件);
        div.getGemmenPrintinfo().getCcdKanryoMessage().setSuccessMessage(画面モード_訂正);
        RString 減免状態区分 = 減免の情報.get減免状態区分();
        RString 減免作成区分 = 減免の情報.get減免作成区分();
        PrintInfoDiv 発行パネル = div.getGemmenPrintinfo().getPrintInfo();
        発行パネル.getPritPublish1().setVisible(true);
        発行パネル.getPritPublish1().getBunshoBango1().initialize(null);
        発行パネル.getPritPublish1().getComdiv1().initialize(true, null, false, true, null, false);
        発行パネル.getPritPublish1().getComdiv1().setSendDateDisable(true);
        発行パネル.getPritPublish2().setVisible(true);
        発行パネル.getPritPublish2().getBunshoBango2().initialize(null);
        発行パネル.getPritPublish2().getComdiv2().initialize(true, null, false, true, null, false);
        発行パネル.getPritPublish2().getComdiv2().setSendDateDisable(true);
        発行パネル.getPritPublish3().setVisible(true);
        発行パネル.getPritPublish4().setVisible(true);
        発行パネル.getPritPublish4().setTitle(賦課台帳);
        発行パネル.getPritPublish1().setTitle(減免決定通知書);
        if ((定値_ゼロ.equals(減免状態区分) && 定値_ゼロ.equals(減免作成区分))
                || (定値_ゼロ.equals(減免状態区分) && 定値_ミ.equals(減免作成区分))) {
            発行パネル.getPritPublish1().setVisible(false);
            発行パネル.getPritPublish2().setVisible(false);
            発行パネル.getPritPublish3().setVisible(false);
            発行パネル.getPritPublish4().setVisible(false);
            show発行ボタン = false;
        } else if (定値_二.equals(減免状態区分) && 定値_二.equals(減免作成区分)) {
            発行パネル.getPritPublish2().setVisible(false);
            発行パネル.getPritPublish3().setVisible(false);
            発行パネル.getPritPublish4().setVisible(false);
        } else if (定値_イチ.equals(減免状態区分) && 定値_ミ.equals(減免作成区分)) {
            発行パネル.getPritPublish1().setTitle(減免取消通知書);
        }
        RString 氏名 = div.getCcdKaigoAtenaKihon().get氏名漢字();
        div.getGemmenPrintinfo().getCcdKanryoMessage().setSuccessMessage(new RString(
                UrInformationMessages.正常終了.getMessage().replace(保存R.toString()).evaluate()),
                氏名R.concat(コロン).concat(氏名),
                通知書番号R.concat(コロン).concat(通知書番号.getColumnValue()));
        if (発行パネル.getPritPublish3().isVisible()) {
            発行パネル.getPritPublish3().getComdiv3().initialize(true, null, false, true, null, false);
            発行パネル.getPritPublish3().getComdiv3().setSendDateDisable(true);
            発行パネル.getPritPublish3().getRadShutsuryokuHoho().setDataSource(get出力方法());
            発行パネル.getPritPublish3().getRadShutsuryokuKeishiki().setDataSource(get出力形式());
            発行パネル.getPritPublish3().getRadShutsuryokuHoho().setSelectedIndex(ゼロ_定値);
            発行パネル.getPritPublish3().getRadShutsuryokuKeishiki().setSelectedIndex(ゼロ_定値);
            if (賦課情報List != null && !賦課情報List.isEmpty()) {
                発行パネル.getPritPublish3().getDdlShutsuryokuKi().setDataSource(get出力期DDL(調定年度, 賦課情報List.get(0)));
                発行パネル.getPritPublish3().getDdlShutsuryokuKi().setSelectedIndex(ゼロ_定値);
            }
        }
        return show発行ボタン;
    }

    /**
     * 「発行する」ボタンの制御です。
     *
     * @param show発行ボタン RString
     */
    public void onStateTransition(RString show発行ボタン) {
        if (発行ボタンSHOW.equals(show発行ボタン)) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(発行するボタン, true);
        } else {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(発行するボタン, false);
        }
    }

    /**
     * 発行するボタン押下のメソッドです。
     *
     * @param 年度分賦課減免リスト NendobunFukaGemmenList
     * @return SourceDataCollection
     */
    public SourceDataCollection onClick_発行(NendobunFukaGemmenList 年度分賦課減免リスト) {
        FlexibleYear 調定年度 = 年度分賦課減免リスト.get最新減免の情報().get調定年度();
        FlexibleYear 賦課年度 = 年度分賦課減免リスト.get最新減免の情報().get賦課年度();
        TsuchishoNo 通知書番号 = 年度分賦課減免リスト.get最新減免の情報().get通知書番号();
        FukaJohoSaishn 賦課情報 = KaigoHokenryoGemmen.createInstance().getFukaJoho(調定年度, 賦課年度, 通知書番号);
        TuuchisyoGaihatuParam 通知書発行パラメータ = new TuuchisyoGaihatuParam();
        if (賦課情報 == null) {
            通知書発行パラメータ.set賦課の情報_更正前(null);
            通知書発行パラメータ.set賦課の情報_更正後(null);
        } else {
            通知書発行パラメータ.set賦課の情報_更正前(賦課情報.get賦課の情報_更正前());
            通知書発行パラメータ.set賦課の情報_更正後(賦課情報.get賦課の情報_更正後());
        }
        PrintInfoDiv 発行パネル = div.getGemmenPrintinfo().getPrintInfo();
        boolean is減免決定通知書checked;
        boolean is取消決定通知書checked;
        if (減免決定通知書.equals(発行パネル.getPritPublish1().getTitle())) {
            is減免決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
            is取消決定通知書checked = false;
        } else {
            is取消決定通知書checked = 発行パネル.getPritPublish1().isIsPublish() && 発行パネル.getPritPublish1().isVisible();
            is減免決定通知書checked = false;
        }
        RDate 発行日_減免 = 発行パネル.getPritPublish1().getComdiv1().getIssueDate();
        FlexibleDate 減免_発行日 = 発行日_減免 == null ? null : new FlexibleDate(発行日_減免.toString());
        RDate 発行日_変更兼特徴中止 = 発行パネル.getPritPublish2().getComdiv2().getIssueDate();
        FlexibleDate 変更兼特徴中止_発行日 = 発行日_変更兼特徴中止 == null ? null : new FlexibleDate(発行日_変更兼特徴中止.toString());
        RDate 発行日_納入 = 発行パネル.getPritPublish3().getComdiv3().getIssueDate();
        FlexibleDate 納入_発行日 = 発行日_納入 == null ? null : new FlexibleDate(発行日_納入.toString());
        RDate 送付日_納入 = 発行パネル.getPritPublish3().getComdiv3().getSendDate();
        FlexibleDate 納入_送付日 = 送付日_納入 == null ? null : new FlexibleDate(送付日_納入.toString());
        RString 減免_文書番号 = 発行パネル.getPritPublish1().getBunshoBango1().get文書番号();

        boolean is変更通知書兼特徴checked = 発行パネル.getPritPublish2().isIsPublish() && 発行パネル.getPritPublish2().isVisible();
        boolean is納入通知書checked = 発行パネル.getPritPublish3().isIsPublish() && 発行パネル.getPritPublish3().isVisible();
        boolean is賦課台帳checked = 発行パネル.getPritPublish4().isIsPublish() && 発行パネル.getPritPublish4().isVisible();
        通知書発行パラメータ.set減免決定_出力有無(is減免決定通知書checked);
        通知書発行パラメータ.set減免決定_発行日(減免_発行日);
        通知書発行パラメータ.set減免決定_文書番号(減免_文書番号);
        通知書発行パラメータ.set減免取消_出力有無(is取消決定通知書checked);
        通知書発行パラメータ.set減免取消_発行日(減免_発行日);
        通知書発行パラメータ.set減免取消_文書番号(減免_文書番号);
        通知書発行パラメータ.set変更兼特徴中止_出力有無(is変更通知書兼特徴checked);
        通知書発行パラメータ.set変更兼特徴中止_発行日(変更兼特徴中止_発行日);
        通知書発行パラメータ.set変更兼特徴中止_文書番号(発行パネル.getPritPublish2().getBunshoBango2().get文書番号());
        通知書発行パラメータ.set納入_出力有無(is納入通知書checked);
        通知書発行パラメータ.set納入_発行日(納入_発行日);
        通知書発行パラメータ.set納入_送付日(納入_送付日);
        通知書発行パラメータ.set納入_出力期(発行パネル.getPritPublish3().getDdlShutsuryokuKi().getSelectedKey());
        通知書発行パラメータ.set納入_出力方法(発行パネル.getPritPublish3().getRadShutsuryokuHoho().getSelectedKey());
        通知書発行パラメータ.set納入_出力形式(発行パネル.getPritPublish3().getRadShutsuryokuKeishiki().getSelectedKey());
        通知書発行パラメータ.set賦課台帳_出力有無(is賦課台帳checked);
        onClick_btnUpt(年度分賦課減免リスト);
        return KaigoHokenryoGemmen.createInstance().publish(通知書発行パラメータ);
    }

    private GemmenJoho set調定額(GemmenJoho 最新減免の情報, KiwarigakuDiv 減免情報パネル) {
        GemmenJohoBuilder builder = 最新減免の情報.createBuilderForEdit();
        RString 期_4月 = 普徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 期_5月 = 普徴期月リスト.get月の期(Tsuki._5月).get期();
        RString 期_6月 = 普徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 期_7月 = 普徴期月リスト.get月の期(Tsuki._7月).get期();
        RString 期_8月 = 普徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 期_9月 = 普徴期月リスト.get月の期(Tsuki._9月).get期();
        RString 期_10月 = 普徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 期_11月 = 普徴期月リスト.get月の期(Tsuki._11月).get期();
        RString 期_12月 = 普徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 期_1月 = 普徴期月リスト.get月の期(Tsuki._1月).get期();
        RString 期_2月 = 普徴期月リスト.get月の期(Tsuki._2月).get期();
        RString 期_3月 = 普徴期月リスト.get月の期(Tsuki._3月).get期();
        RString 期_翌年4月 = 普徴期月リスト.get月の期(Tsuki.翌年度4月).get期();
        RString 期_翌年5月 = 普徴期月リスト.get月の期(Tsuki.翌年度5月).get期();
        builder = set普徴期別金額(期_4月, builder, 減免情報パネル.getTxtFuchoGemmemGo13().getValue());
        builder = set普徴期別金額(期_5月, builder, 減免情報パネル.getTxtFuchoGemmemGo14().getValue());
        builder = set普徴期別金額(期_6月, builder, 減免情報パネル.getTxtFuchoGemmemGo1().getValue());
        builder = set普徴期別金額(期_7月, builder, 減免情報パネル.getTxtFuchoGemmemGo2().getValue());
        builder = set普徴期別金額(期_8月, builder, 減免情報パネル.getTxtFuchoGemmemGo3().getValue());
        builder = set普徴期別金額(期_9月, builder, 減免情報パネル.getTxtFuchoGemmemGo4().getValue());
        builder = set普徴期別金額(期_10月, builder, 減免情報パネル.getTxtFuchoGemmemGo5().getValue());
        builder = set普徴期別金額(期_11月, builder, 減免情報パネル.getTxtFuchoGemmemGo6().getValue());
        builder = set普徴期別金額(期_12月, builder, 減免情報パネル.getTxtFuchoGemmemGo7().getValue());
        builder = set普徴期別金額(期_1月, builder, 減免情報パネル.getTxtFuchoGemmemGo8().getValue());
        builder = set普徴期別金額(期_2月, builder, 減免情報パネル.getTxtFuchoGemmemGo9().getValue());
        builder = set普徴期別金額(期_3月, builder, 減免情報パネル.getTxtFuchoGemmemGo10().getValue());
        builder = set普徴期別金額(期_翌年4月, builder, 減免情報パネル.getTxtFuchoGemmemGo11().getValue());
        builder = set普徴期別金額(期_翌年5月, builder, 減免情報パネル.getTxtFuchoGemmemGo12().getValue());
        RString 特期_4月 = 特徴期月リスト.get月の期(Tsuki._4月).get期();
        RString 特期_6月 = 特徴期月リスト.get月の期(Tsuki._6月).get期();
        RString 特期_8月 = 特徴期月リスト.get月の期(Tsuki._8月).get期();
        RString 特期_10月 = 特徴期月リスト.get月の期(Tsuki._10月).get期();
        RString 特期_12月 = 特徴期月リスト.get月の期(Tsuki._12月).get期();
        RString 特期_2月 = 特徴期月リスト.get月の期(Tsuki._2月).get期();
        builder = set特徴期別金額(特期_4月, builder, 減免情報パネル.getTxtTokuchoGemmemGo1().getValue());
        builder = set特徴期別金額(特期_6月, builder, 減免情報パネル.getTxtTokuchoGemmemGo2().getValue());
        builder = set特徴期別金額(特期_8月, builder, 減免情報パネル.getTxtTokuchoGemmemGo3().getValue());
        builder = set特徴期別金額(特期_10月, builder, 減免情報パネル.getTxtTokuchoGemmemGo4().getValue());
        builder = set特徴期別金額(特期_12月, builder, 減免情報パネル.getTxtTokuchoGemmemGo5().getValue());
        builder = set特徴期別金額(特期_2月, builder, 減免情報パネル.getTxtTokuchoGemmemGo6().getValue());
        return builder.build();
    }

    private GemmenJohoBuilder set特徴期別金額(RString 期, GemmenJohoBuilder builder, Decimal 金額) {
        if (期 == null || 期.isEmpty()) {
            return builder;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return builder.set特徴期別金額01(金額);
            case 二_定値:
                return builder.set特徴期別金額02(金額);
            case ミ_定値:
                return builder.set特徴期別金額03(金額);
            case ヨ_定値:
                return builder.set特徴期別金額04(金額);
            case ゴ_定値:
                return builder.set特徴期別金額05(金額);
            case ロク_定値:
                return builder.set特徴期別金額06(金額);
            default:
                return builder;
        }

    }

    private GemmenJohoBuilder set普徴期別金額(RString 期, GemmenJohoBuilder builder, Decimal 金額) {
        if (期 == null || 期.isEmpty()) {
            return builder;
        }
        switch (Integer.valueOf(期.toString())) {
            case イチ_定値:
                return builder.set普徴期別金額01(金額);
            case 二_定値:
                return builder.set普徴期別金額02(金額);
            case ミ_定値:
                return builder.set普徴期別金額03(金額);
            case ヨ_定値:
                return builder.set普徴期別金額04(金額);
            case ゴ_定値:
                return builder.set普徴期別金額05(金額);
            case ロク_定値:
                return builder.set普徴期別金額06(金額);
            case ナナ_定値:
                return builder.set普徴期別金額07(金額);
            case ハチ_定値:
                return builder.set普徴期別金額08(金額);
            case キュウ_定値:
                return builder.set普徴期別金額09(金額);
            case ジュウ_定値:
                return builder.set普徴期別金額10(金額);
            case ジュウイチ_定値:
                return builder.set普徴期別金額11(金額);
            case ジュウ二_定値:
                return builder.set普徴期別金額12(金額);
            case ジュウミ_定値:
                return builder.set普徴期別金額13(金額);
            case ジュウヨ_定値:
                return builder.set普徴期別金額14(金額);
            default:
                return builder;
        }
    }

    private boolean is申請情報入力(GemmenJoho 最新減免の情報) {
        List<Gemmen> 介護賦課減免List = 最新減免の情報.getGemmenList();
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        if (介護賦課減免List != null && !介護賦課減免List.isEmpty()) {
            Gemmen 介護賦課減免 = 介護賦課減免List.get(0);
            boolean flag1 = checkDate(介護賦課減免.get減免申請日(), 申請情報パネル.getTxtShinseiYMD().getValue());
            boolean flag2 = checkDecimal(介護賦課減免.get申請減免額(), 申請情報パネル.getTxtShinseiGemmengaku().getValue());
            boolean flag3 = checkRString(CodeMaster.getCodeRyakusho(SubGyomuCode.DBB介護賦課, DBBCodeShubetsu.保険料減免種類.getコード(),
                    介護賦課減免.get減免種類コード(), FlexibleDate.getNowDate()), 申請情報パネル.getTxtGemmenShurui().getValue());
            boolean flag4 = checkRString(介護賦課減免.get申請事由(), 申請情報パネル.getTxtShinseiRiyu().getValue());
            return flag1 && flag2 && flag3 && flag4;
        } else {
            RDate 申請日 = 申請情報パネル.getTxtShinseiYMD().getValue();
            boolean flag1 = 申請日 != null;
            boolean flag2 = 申請情報パネル.getTxtShinseiGemmengaku().getValue() != null;
            RString 取消種類 = 申請情報パネル.getTxtGemmenShurui().getValue();
            boolean flag3 = !(取消種類 == null || 取消種類.isEmpty());
            RString 申請事由 = 申請情報パネル.getTxtShinseiRiyu().getValue();
            boolean flag4 = !(申請事由 == null || 申請事由.isEmpty());
            return flag1 || flag2 || flag3 || flag4;
        }
    }

    private boolean is決定情報入力(GemmenJoho 最新減免の情報) {
        List<Gemmen> 介護賦課減免List = 最新減免の情報.getGemmenList();
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        if (介護賦課減免List != null && !介護賦課減免List.isEmpty()) {
            Gemmen 介護賦課減免 = 介護賦課減免List.get(0);
            flag1 = checkDate(介護賦課減免.get減免決定日(), 決定情報パネル.getTxtKetteiYMD().getValue());

            RString 決定区分 = 決定情報パネル.getRadKetteiKubun().getSelectedValue();
            if (承認.equals(決定区分)) {
                flag3 = checkRString(定値_イチ, 介護賦課減免.get減免状態区分());
            } else {
                flag3 = checkRString(定値_二, 介護賦課減免.get減免状態区分());
            }
            flag4 = checkRString(介護賦課減免.get申請事由(), 決定情報パネル.getTxtKetteiRiyu().getValue());
        } else {
            FlexibleDate 減免決定日 = 決定情報パネル.getTxtKetteiYMD().getValue();
            flag1 = !(減免決定日 == null || 減免決定日.isEmpty());
            flag3 = !承認.equals(決定情報パネル.getRadKetteiKubun().getSelectedValue());
            RString 申請事由 = 決定情報パネル.getTxtKetteiRiyu().getValue();
            flag4 = !(申請事由 == null || 申請事由.isEmpty());
        }
        if (最新減免の情報.toEntity() != null) {
            flag2 = checkDecimal(最新減免の情報.get減免額(), 決定情報パネル.getTxtZenkaiGemmengaku().getValue());
        } else {
            flag2 = 最新減免の情報.get減免額() != null;
        }
        return flag1 || flag2 || flag3 || flag4;
    }

    private boolean is取消情報入力() {
        TorikeshiInfoDiv 取消情報パネル = div.getGemmenMain().getTorikeshiInfo();
        boolean flag1 = 取消情報パネル.getTxtTorikeshiYMD().getValue() != null;
        RString 取消種類 = 取消情報パネル.getTxtTorikeshiShurui().getValue();
        boolean flag2 = !(取消種類 == null || 取消種類.isEmpty());
        RString 取消理由 = 取消情報パネル.getTxtTorikeshiRiyu().getValue();
        boolean flag3 = !(取消理由 == null || 取消理由.isEmpty());
        return flag1 || flag2 || flag3;
    }

    /**
     * 取消種類ボタンの事件です。
     *
     * @return 取消種類code Code
     */
    public Code onOkClose取消種類() {
        RString 取消種類code = DataPassingConverter.deserialize(div.getGemmenTorikeshiShuruiCode(), RString.class);
        RString 取消理由 = DataPassingConverter.deserialize(div.getGemmenTorikeshiShuruiHyojiMongon(), RString.class);
        div.getGemmenMain().getTorikeshiInfo().getTxtTorikeshiShurui().setValue(取消理由);
        return new Code(取消種類code);
    }

    /**
     * 減免種類ボタンの事件です。
     *
     * @return 減免種類code Code
     */
    public Code onOkClose減免種類() {
        RString 減免種類code = DataPassingConverter.deserialize(div.getGemmenShuruiCode(), RString.class);
        RString 減免事由 = DataPassingConverter.deserialize(div.getGemmenShuruiHyojiMongon(), RString.class);
        div.getGemmenMain().getShinseiinfo().getTxtGemmenShurui().setValue(減免事由);
        return new Code(減免種類code);
    }

    /**
     * 画面情報paramを取得する。
     *
     * @param 減免種類コード Code
     * @param 取消種類コード Code
     * @return 画面情報param
     */
    public KaigoHokenryoGemmenParam get画面情報param(Code 減免種類コード, Code 取消種類コード) {
        ShinseiinfoDiv 申請情報パネル = div.getGemmenMain().getShinseiinfo();
        KeteiinfoDiv 決定情報パネル = div.getGemmenMain().getKeteiinfo();
        KiwarigakuDiv 減免情報パネル = div.getGemmenMain().getKiwarigaku();
        TorikeshiInfoDiv 取消情報パネル = div.getGemmenMain().getTorikeshiInfo();
        KaigoHokenryoGemmenParam param = new KaigoHokenryoGemmenParam();
        param.set状況(div.getGemmenMain().getShinseiJokyo().getTxtShinseiJokyo().getValue());
        RString 決定区分 = 決定情報パネル.getRadKetteiKubun().getSelectedKey();
        param.set決定区分(定値_ゼロ.equals(決定区分));
        param.set申請日(申請情報パネル.getTxtShinseiYMD().getValue() != null
                ? new FlexibleDate(申請情報パネル.getTxtShinseiYMD().getValue().toString()) : null);
        param.set決定日(決定情報パネル.getTxtKetteiYMD().getValue() != null
                ? new FlexibleDate(決定情報パネル.getTxtKetteiYMD().getValue().toString()) : null);
        param.set取消日(取消情報パネル.getTxtTorikeshiYMD().getValue() != null
                ? new FlexibleDate(取消情報パネル.getTxtTorikeshiYMD().getValue().toString()) : null);
        param.set減免額(減免情報パネル.getTxtGemmengaku().getValue());
        param.set前回減免額(決定情報パネル.getTxtZenkaiGemmengaku().getValue());
        param.set申請事由(申請情報パネル.getTxtShinseiRiyu().getValue());
        param.set減免種類コード(減免種類コード);
        param.set減免事由(申請情報パネル.getTxtGemmenShurui().getValue());
        param.set減免取消種類コード(取消種類コード);
        param.set減免取消事由(取消情報パネル.getTxtTorikeshiShurui().getValue());
        param.set申請減免額(申請情報パネル.getTxtShinseiGemmengaku().getValue());
        return param;
    }

    private List<KeyValueDataSource> get決定区分() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        KeyValueDataSource dataSource1 = new KeyValueDataSource(定値_ゼロ, 承認);
        KeyValueDataSource dataSource2 = new KeyValueDataSource(定値_イチ, 不承認);
        dataSources.add(dataSource1);
        dataSources.add(dataSource2);
        return dataSources;
    }

    private List<KeyValueDataSource> get出力方法() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        KeyValueDataSource dataSource1 = new KeyValueDataSource(定値_ゼロ, 出力方法_別々に出力);
        KeyValueDataSource dataSource2 = new KeyValueDataSource(定値_イチ, 出力方法_全件出力);
        dataSources.add(dataSource1);
        dataSources.add(dataSource2);
        return dataSources;
    }

    private List<KeyValueDataSource> get出力形式() {
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        KeyValueDataSource dataSource1 = new KeyValueDataSource(定値_ゼロ, 出力形式_現金用);
        KeyValueDataSource dataSource2 = new KeyValueDataSource(定値_イチ, 出力形式_口座用);
        dataSources.add(dataSource1);
        dataSources.add(dataSource2);
        return dataSources;
    }

    private List<KeyValueDataSource> get出力期DDL(FlexibleYear 調定年度, FukaJoho 賦課情報) {
        RDate 調定年月日 = new RDate(調定年度.toString().concat(調定月日.toString()));
        boolean is本算定 = HonsanteiIkoHantei.createInstance().is本算定後(賦課情報);
        RString config = DbBusinessConfig.get(ConfigNameDBB.普徴期情報_納付書の型1, 調定年月日, SubGyomuCode.DBB介護賦課);
        boolean is期毎タイプ = 定値_ヨ.equals(config) || 定値_ロク.equals(config);
        List<KeyValueDataSource> dataSources = new ArrayList<>();
        List<ShutsuryokuKiKoho> 出力期候補List = ShutsuryokuKiKohoFactory.createInstance(調定年度).create出力期候補(is期毎タイプ, !is本算定);
        for (ShutsuryokuKiKoho 出力期候補 : 出力期候補List) {
            KeyValueDataSource dataSource = new KeyValueDataSource(出力期候補.get期月().get期(), 出力期候補.get表示文字列());
            dataSources.add(dataSource);
        }
        return dataSources;
    }

    /**
     * コンストラクタです
     *
     * @param div MainPanelDiv
     */
    public GemmenJuminKihonHandler(GemmenJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * 画面の入力チェック
     */
    public void setRequired() {
        div.getGemmenMain().getTorikeshiInfo().getTxtTorikeshiYMD().setRequired(false);
        RString 状況 = div.getGemmenMain().getShinseiJokyo().getTxtShinseiJokyo().getValue();
        if (!状況_決定済.equals(状況)) {
            div.getGemmenMain().getShinseiinfo().getTxtShinseiYMD().setRequired(true);
        }
    }

    private boolean checkDate(FlexibleDate fDate, RDate rDate) {
        if (fDate == null || fDate.isEmpty()) {
            return !(rDate == null);
        } else {
            return !(new RDate(fDate.toString()).equals(rDate));
        }
    }

    private boolean checkDate(FlexibleDate date1, FlexibleDate date2) {
        if (date1 == null || date1.isEmpty()) {
            return (date2 == null);
        } else {
            return !(date1.equals(date2));
        }
    }

    private boolean checkDecimal(Decimal dec1, Decimal dec2) {
        if (dec1 == null) {
            return !(dec2 == null);
        } else {
            if (dec2 == null) {
                return true;
            } else {
                return (dec1.compareTo(dec2) == ゼロ_定値);
            }
        }
    }

    private boolean checkRString(RString str1, RString str2) {
        if (str1 == null || str1.isEmpty()) {
            return !(str2 == null || str2.isEmpty());
        } else {
            return !str1.equals(str2);
        }
    }
}
