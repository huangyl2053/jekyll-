/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE3090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryoku;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku.IchijihanteikekkahyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE309003.DBE309003_IchijihanteiSumidataIfParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.dgIchijiHanteiZumi_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ichijihanteikekkahyo.IchijihanteikekkahyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.JotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.SuiteiKyufuKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.kekka.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 画面設計_DBE3090001_一次判定データ出力Handlerです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryokuHandler {

    private final IchijiHanteizumiDataShutsuryokuDiv div;
    private static final RString 申請日 = new RString("0");
    private static final RString 一次判定日 = new RString("1");
    private static final RString 識別コード09B = new RString("09B");
    private static final RString 識別コード06A = new RString("06A");
    private static final RString 識別コード02A = new RString("02A");
    private static final RString 識別コード09A = new RString("09A");
    private static final RString 識別コード99A = new RString("99A");
    private static final RString 特記事項番号_101 = new RString("101");
    private static final RString 特記事項番号_102 = new RString("102");
    private static final RString 特記事項番号_103 = new RString("103");
    private static final RString 特記事項番号_104 = new RString("104");
    private static final RString 特記事項番号_105 = new RString("105");
    private static final RString 特記事項番号_106 = new RString("106");
    private static final RString 特記事項番号_107 = new RString("107");
    private static final RString 特記事項番号_108 = new RString("108");
    private static final RString 特記事項番号_109 = new RString("109");
    private static final RString 特記事項番号_110 = new RString("110");
    private static final RString 特記事項番号_111 = new RString("111");
    private static final RString 特記事項番号_112 = new RString("112");
    private static final RString 特記事項番号_113 = new RString("113");
    private static final RString 特記事項番号_201 = new RString("201");
    private static final RString 特記事項番号_202 = new RString("202");
    private static final RString 特記事項番号_203 = new RString("203");
    private static final RString 特記事項番号_204 = new RString("204");
    private static final RString 特記事項番号_205 = new RString("205");
    private static final RString 特記事項番号_206 = new RString("206");
    private static final RString 特記事項番号_207 = new RString("207");
    private static final RString 特記事項番号_208 = new RString("208");
    private static final RString 特記事項番号_209 = new RString("209");
    private static final RString 特記事項番号_210 = new RString("210");
    private static final RString 特記事項番号_211 = new RString("211");
    private static final RString 特記事項番号_212 = new RString("212");
    private static final RString 特記事項番号_301 = new RString("301");
    private static final RString 特記事項番号_302 = new RString("302");
    private static final RString 特記事項番号_303 = new RString("303");
    private static final RString 特記事項番号_304 = new RString("304");
    private static final RString 特記事項番号_305 = new RString("305");
    private static final RString 特記事項番号_306 = new RString("306");
    private static final RString 特記事項番号_307 = new RString("307");
    private static final RString 特記事項番号_308 = new RString("308");
    private static final RString 特記事項番号_309 = new RString("309");
    private static final RString 特記事項番号_401 = new RString("401");
    private static final RString 特記事項番号_402 = new RString("402");
    private static final RString 特記事項番号_403 = new RString("403");
    private static final RString 特記事項番号_404 = new RString("404");
    private static final RString 特記事項番号_405 = new RString("405");
    private static final RString 特記事項番号_406 = new RString("406");
    private static final RString 特記事項番号_407 = new RString("407");
    private static final RString 特記事項番号_408 = new RString("408");
    private static final RString 特記事項番号_409 = new RString("409");
    private static final RString 特記事項番号_410 = new RString("410");
    private static final RString 特記事項番号_411 = new RString("411");
    private static final RString 特記事項番号_412 = new RString("412");
    private static final RString 特記事項番号_413 = new RString("413");
    private static final RString 特記事項番号_414 = new RString("414");
    private static final RString 特記事項番号_415 = new RString("415");
    private static final RString 特記事項番号_501 = new RString("501");
    private static final RString 特記事項番号_502 = new RString("502");
    private static final RString 特記事項番号_503 = new RString("503");
    private static final RString 特記事項番号_504 = new RString("504");
    private static final RString 特記事項番号_505 = new RString("505");
    private static final RString 特記事項番号_506 = new RString("506");
    private static final RString 特記事項番号_507 = new RString("507");
    private static final RString 特記事項番号_510 = new RString("510");
    private static final RString 特記事項番号_511 = new RString("511");
    private static final RString 特記事項番号_512 = new RString("512");
    private static final RString 特記事項番号_601 = new RString("601");
    private static final RString 特記事項番号_602 = new RString("602");
    private static final RString 特記事項番号_603 = new RString("603");
    private static final RString 特記事項番号_604 = new RString("604");
    private static final RString 特記事項番号_605 = new RString("605");
    private static final RString 特記事項番号_606 = new RString("606");
    private static final RString 特記事項番号_607 = new RString("607");
    private static final RString 特記事項番号_608 = new RString("608");
    private static final RString 特記事項番号_609 = new RString("609");
    private static final RString 特記事項番号_610 = new RString("610");
    private static final RString 特記事項番号_611 = new RString("611");
    private static final RString 特記事項番号_612 = new RString("612");
    private static final RString 特記事項番号_801 = new RString("801");
    private static final RString 特記事項番号_802 = new RString("802");
    private static final RString 特記事項番号_803 = new RString("803");
    private static final RString 特記事項番号_804 = new RString("804");
    private static final RString 特記事項番号_805 = new RString("805");
    private static final RString 特記事項番号_806 = new RString("806");
    private static final RString 特記事項番号_807 = new RString("807");
    private static final RString 特記事項番号_808 = new RString("808");
    private static final RString 特記事項番号_809 = new RString("809");
    private static final RString 特記事項番号_810 = new RString("810");
    private static final RString 特記事項番号_811 = new RString("811");
    private static final RString 特記事項番号_812 = new RString("812");
    private static final RString 特記事項番号_701 = new RString("701");
    private static final RString 特記事項番号_702 = new RString("702");
    private static final RString 特記事項番号_901 = new RString("901");
    private static final RString 特記事項番号_902 = new RString("902");
    private static final RString 特記事項番号_704 = new RString("704");
    private static final RString 特記事項番号_705 = new RString("705");
    private static final RString 特記事項番号_707 = new RString("707");
    private static final RString 特記事項番号_708 = new RString("708");
    private static final RString 特記事項番号_709 = new RString("709");
    private static final RString 特記事項番号_710 = new RString("710");
    private static final RString 特記事項番号_711 = new RString("711");
    private static final RString 特記事項番号_712 = new RString("712");
    private static final RString 特記事項番号_713 = new RString("713");
    private static final RString 特記事項番号_714 = new RString("714");
    private static final RString 特記事項番号_716 = new RString("716");
    private static final RString 特記事項番号_719 = new RString("719");
    private static final RString 特記事項番号_1002 = new RString("1002");
    private static final RString 特記事項番号_5011 = new RString("5011");
    private static final RString 特記事項番号_5012 = new RString("5012");
    private static final RString 特記事項番号_5013 = new RString("5013");
    private static final RString 特記事項番号_5014 = new RString("5014");
    private static final RString 特記事項番号_5021 = new RString("5021");
    private static final RString 特記事項番号_5022 = new RString("5022");
    private static final RString 特記事項番号_6051 = new RString("6051");
    private static final RString 特記事項番号_6052 = new RString("6052");
    private static final RString 特記事項番号_6053 = new RString("6053");
    private static final RString 特記事項番号_6054 = new RString("6054");
    private static final RString 特記事項番号_6055 = new RString("6055");
    private static final RString 特記事項番号_6056 = new RString("6056");
    private static final RString 印刷する = new RString("1");
    private static final RString 印刷しない = new RString("2");
    private static final RString 差分のみ印刷 = new RString("3");
    private static final int 元号 = 4;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番22 = 22;
    private static final int 連番23 = 23;
    private static final int 連番24 = 24;
    private static final int 連番25 = 25;
    private static final int 連番26 = 26;
    private static final int 連番27 = 27;
    private static final int 連番28 = 28;
    private static final int 連番29 = 29;
    private static final int 連番30 = 30;
    private static final int 連番31 = 31;
    private static final int 連番32 = 32;
    private static final int 連番33 = 33;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番57 = 57;
    private static final int 連番59 = 59;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番65 = 65;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 68;
    private static final int 連番69 = 69;
    private static final int 連番70 = 70;
    private static final int 連番71 = 71;
    private static final int 連番72 = 72;
    private static final int 連番73 = 73;
    private static final int 連番74 = 74;
    private static final int 連番75 = 75;
    private static final int 連番76 = 76;
    private static final int 連番77 = 77;
    private static final int 連番78 = 78;
    private static final int 連番79 = 79;
    private static final int 連番80 = 80;
    private static final int 連番81 = 81;
    private static final int 連番82 = 82;
    private static final int 連番83 = 83;
    private static final int 連番84 = 84;

    /**
     * コンストラクタです。
     *
     * @param div 一次判定データ出力Div
     */
    public IchijiHanteizumiDataShutsuryokuHandler(IchijiHanteizumiDataShutsuryokuDiv div) {
        this.div = div;
    }

    /**
     * 一次判定データ出力初期化の設定します。
     *
     */
    public void onLoad() {
        div.getTextBoxNum().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        div.getTextBoxNum().setMaxValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 「日付指定」ラジオボタンの設定します。
     *
     */
    public void settxtShinseibi() {
        if (申請日.equals(div.getRadJyoken().getSelectedKey())) {
            div.getTxtShinseibi().setDisabled(false);
            div.getTxtIchijiHanteibi().setDisabled(true);
            div.getTxtIchijiHanteibi().clearFromValue();
            div.getTxtIchijiHanteibi().clearToValue();
        } else if (一次判定日.equals(div.getRadJyoken().getSelectedKey())) {
            div.getTxtShinseibi().setDisabled(true);
            div.getTxtIchijiHanteibi().setDisabled(false);
            div.getTxtShinseibi().clearFromValue();
            div.getTxtShinseibi().clearToValue();
        }
    }

    /**
     * 検索条件をクリアの設定します。
     *
     */
    public void setbtnKensakuClear() {
        div.getTxtShinseibi().clearFromValue();
        div.getTxtShinseibi().clearToValue();
        div.getTxtIchijiHanteibi().clearFromValue();
        div.getTxtIchijiHanteibi().clearToValue();
        div.getTextBoxNum().clearValue();
    }

    /**
     * 画面一覧の設定します。
     *
     * @param list 一次判定済みデータ
     */
    public void setdgIchijiHanteiZumi(List<IchijiHanteizumiDataShutsuryokuBusiness> list) {
        List<dgIchijiHanteiZumi_Row> dgChosainList = new ArrayList<>();
        IchijiHanteizumiDataShutsuryoku shutsuryoku = new IchijiHanteizumiDataShutsuryoku();
        boolean ボタン制御フラグ = true;
        for (IchijiHanteizumiDataShutsuryokuBusiness business : list) {
            dgIchijiHanteiZumi_Row row = new dgIchijiHanteiZumi_Row();
            row.setHokenshaMei(nullOrEmpty(business.get市町村名称()));
            if (!RString.isNullOrEmpty(business.get認定申請年月日())) {
                row.setShinseibi(new FlexibleDate(business.get認定申請年月日()).wareki().toDateString());
            }
            row.setHihoBango(business.get被保険者番号());
            row.setShimei(business.get被保険者氏名());
            row.setShinseitoki(NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード()).get名称());
            if (RString.isNullOrEmpty(business.get認定申請区分法令コード())) {
                row.setHorei(RString.EMPTY);
            } else {
                row.setHorei(NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード()).get名称());
            }
            if (!RString.isNullOrEmpty(business.get要介護認定一次判定年月日())) {
                row.setKanryobi(new FlexibleDate(business.get要介護認定一次判定年月日()).wareki().toDateString());
            }
            row.setIchijihanteikekka(shutsuryoku.set要介護状態区分コード(business.get厚労省IF識別コード(),
                    business.get要介護認定一次判定結果コード()));
            if (!RString.isNullOrEmpty(business.get一次判定情報抽出年月日())) {
                row.setShiryoSakusei(new FlexibleDate(business.get一次判定情報抽出年月日()).wareki().toDateString());
            }
            row.setKeikokuCode(nullOrEmpty(business.get要介護認定一次判定警告コード()));
            row.setShinseishoKanriNo(business.get申請書管理番号());
            row.setShoKisaiHokenshaNo(business.get証記載保険者番号());
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY,
                    new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号()));
            AccessLogger.log(AccessLogType.照会, personalData);
            dgChosainList.add(row);
            ボタン制御フラグ = false;
        }
        div.getShoriOptions().setDisplayNone(ボタン制御フラグ);
        div.getDgIchijiHanteiZumi().setDataSource(dgChosainList);
    }

    /**
     * 画面一覧の設定します。
     *
     * @return IchijiHanteizumiDataShutsuryokuMybitisParamter
     */
    public IchijiHanteizumiDataShutsuryokuMybitisParamter createParam() {
        RString 申請日From = RString.EMPTY;
        RString 申請日To = RString.EMPTY;
        RString 一次判定日From = RString.EMPTY;
        RString 一次判定日To = RString.EMPTY;
        if (div.getTxtShinseibi().getFromValue() != null) {
            申請日From = div.getTxtShinseibi().getFromValue().toDateString();
        }
        if (div.getTxtShinseibi().getToValue() != null) {
            申請日To = div.getTxtShinseibi().getToValue().toDateString();
        }
        if (div.getTxtIchijiHanteibi().getFromValue() != null) {
            一次判定日From = div.getTxtIchijiHanteibi().getFromValue().toDateString();
        }
        if (div.getTxtIchijiHanteibi().getToValue() != null) {
            一次判定日To = div.getTxtIchijiHanteibi().getToValue().toDateString();
        }
        RString 総合事業開始区分 = DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate());
        RString 仮一次判定区分 = KariIchijiHanteiKubun.本一次判定.get名称();
        return IchijiHanteizumiDataShutsuryokuMybitisParamter.createParam(
                div.getRadJyoken().getSelectedKey(),
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                div.getTextBoxNum().getValue(),
                総合事業開始区分,
                null,
                Boolean.valueOf(仮一次判定区分.toString()));
    }

    /**
     * 画面一覧の設定します。
     *
     * @return IchijiHanteizumiDataShutsuryokuMybitisParamter
     */
    public IchijiHanteizumiDataShutsuryokuMybitisParamter createParam帳票() {
        RString 申請日From = RString.EMPTY;
        RString 申請日To = RString.EMPTY;
        RString 一次判定日From = RString.EMPTY;
        RString 一次判定日To = RString.EMPTY;
        if (div.getTxtShinseibi().getFromValue() != null) {
            申請日From = div.getTxtShinseibi().getFromValue().toDateString();
        }
        if (div.getTxtShinseibi().getToValue() != null) {
            申請日To = div.getTxtShinseibi().getToValue().toDateString();
        }
        if (div.getTxtIchijiHanteibi().getFromValue() != null) {
            一次判定日From = div.getTxtIchijiHanteibi().getFromValue().toDateString();
        }
        if (div.getTxtIchijiHanteibi().getToValue() != null) {
            一次判定日To = div.getTxtIchijiHanteibi().getToValue().toDateString();
        }
        RString 総合事業開始区分 = DbBusinessConfig.get(ConfigNameDBE.総合事業開始区分, RDate.getNowDate());
        List<dgIchijiHanteiZumi_Row> dgChosainList = div.getDgIchijiHanteiZumi().getSelectedItems();
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgIchijiHanteiZumi_Row row : dgChosainList) {

            shinseishoKanriNo.add(row.getShinseishoKanriNo());
        }
        RString 仮一次判定区分 = KariIchijiHanteiKubun.本一次判定.get名称();
        return IchijiHanteizumiDataShutsuryokuMybitisParamter.createParam(div.getRadJyoken().getSelectedKey(),
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                div.getTextBoxNum().getValue(),
                総合事業開始区分,
                shinseishoKanriNo,
                Boolean.valueOf(仮一次判定区分.toString()));

    }

    /**
     * 一次判定データ出力作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    public DBE309003_IchijihanteiSumidataIfParameter setBatchParameter() {
        DBE309003_IchijihanteiSumidataIfParameter parameter = new DBE309003_IchijihanteiSumidataIfParameter();
        List<dgIchijiHanteiZumi_Row> dgChosainList = div.getDgIchijiHanteiZumi().getSelectedItems();
        List<RString> shinseishoKanriNo = new ArrayList<>();
        for (dgIchijiHanteiZumi_Row row : dgChosainList) {

            shinseishoKanriNo.add(row.getShinseishoKanriNo());
        }
        parameter.setShinseishoKanriNoList(shinseishoKanriNo);
        parameter.set日付指定(div.getRadJyoken().getSelectedKey());
        if (new RString("1").equals(div.getRadJyoken().getSelectedKey())) {
            parameter.set一次判定日From(div.getTxtIchijiHanteibi().getFromValue().toDateString());
            parameter.set一次判定日To(div.getTxtIchijiHanteibi().getToValue().toDateString());
        } else if (new RString("0").equals(div.getRadJyoken().getSelectedKey())) {
            parameter.set申請日From(div.getTxtShinseibi().getFromValue().toDateString());
            parameter.set申請日To(div.getTxtShinseibi().getToValue().toDateString());
        }
        return parameter;
    }

    /**
     * 帳票印刷の設定します。
     *
     * @param 一次判定結果list 一次判定済みデータ
     * @param 認定調査票概況調査リスト List<NinteichosahyoServiceJokyo>
     * @param 認定調査票フラグリスト List<NinteichosahyoServiceJokyoFlag>
     * @param 認定調査票調査項目リスト List<NinteichosahyoChosaItem>
     * @param 前回調査項目リスト List<NinteichosahyoChosaItem>
     * @param dbt5304Entity List<ShujiiIkenshoIkenItem>
     * @param 前回dbt5304Entity List<ShujiiIkenshoIkenItem>
     * @param 認定調査特記事項番号リスト List<NinteichosahyoTokkijiko>
     */
    public void set帳票(List<IchijiHanteizumiDataBusiness> 一次判定結果list,
            List<NinteichosahyoServiceJokyo> 認定調査票概況調査リスト, List<NinteichosahyoServiceJokyoFlag> 認定調査票フラグリスト,
            List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, List<NinteichosahyoChosaItem> 前回調査項目リスト,
            List<ShujiiIkenshoIkenItem> dbt5304Entity, List<ShujiiIkenshoIkenItem> 前回dbt5304Entity,
            List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト) {
        IchijiHanteizumiDataShutsuryoku shutsuryoku = new IchijiHanteizumiDataShutsuryoku();
        IchijihanteikekkahyoBusiness a4Data = new IchijihanteikekkahyoBusiness();
        for (IchijiHanteizumiDataBusiness business : 一次判定結果list) {
            IchijihanteikekkahyoPrintService printService = new IchijihanteikekkahyoPrintService();
            a4Data.setタイトル(new RString("一次判定結果票"));
            if (business.get一次判定結果情報().get作成年月日() != null) {
                a4Data.set作成日_元号(new FlexibleDate(business.get一次判定結果情報().get作成年月日()).wareki().eraType(EraType.KANJI).getEra());
                a4Data.set作成日_年(new FlexibleDate(business.get一次判定結果情報().get作成年月日())
                        .wareki().eraType(EraType.KANJI).getYear().substring(2, 元号));
                a4Data.set作成日_月(new FlexibleDate(business.get一次判定結果情報().get作成年月日()).wareki().eraType(EraType.KANJI).getMonth());
                a4Data.set作成日_日(new FlexibleDate(business.get一次判定結果情報().get作成年月日()).wareki().eraType(EraType.KANJI).getDay());
            }
            if (business.get一次判定結果情報().get認定申請年月日() != null) {
                a4Data.set申請日_元号(new FlexibleDate(business.get一次判定結果情報().get認定申請年月日()).wareki().eraType(EraType.KANJI).getEra());
                a4Data.set申請日_年(new FlexibleDate(business.get一次判定結果情報().get認定申請年月日())
                        .wareki().eraType(EraType.KANJI).getYear().substring(2, 元号));
                a4Data.set申請日_月(new FlexibleDate(business.get一次判定結果情報().get認定申請年月日())
                        .wareki().eraType(EraType.KANJI).getMonth());
                a4Data.set申請日_日(new FlexibleDate(business.get一次判定結果情報().get認定申請年月日())
                        .wareki().eraType(EraType.KANJI).getDay());
            }
            if (business.get一次判定結果情報().get実施年月日() != null) {
                a4Data.set調査日_元号(new FlexibleDate(business.get一次判定結果情報().get実施年月日()).wareki().eraType(EraType.KANJI).getEra());
                a4Data.set調査日_年(new FlexibleDate(business.get一次判定結果情報().get実施年月日())
                        .wareki().eraType(EraType.KANJI).getYear().substring(2, 元号));
                a4Data.set調査日_月(new FlexibleDate(business.get一次判定結果情報().get実施年月日()).wareki().eraType(EraType.KANJI).getMonth());
                a4Data.set調査日_日(new FlexibleDate(business.get一次判定結果情報().get実施年月日()).wareki().eraType(EraType.KANJI).getDay());
            }
            if (business.get一次判定結果情報().get審査会開催日() != null) {
                a4Data.set審査日_元号(new FlexibleDate(business.get一次判定結果情報().get審査会開催日()).wareki().eraType(EraType.KANJI).getEra());
                a4Data.set審査日_年(new FlexibleDate(business.get一次判定結果情報().get審査会開催日())
                        .wareki().eraType(EraType.KANJI).getYear().substring(2, 元号));
                a4Data.set審査日_月(new FlexibleDate(business.get一次判定結果情報().get審査会開催日()).wareki().eraType(EraType.KANJI).getMonth());
                a4Data.set審査日_日(new FlexibleDate(business.get一次判定結果情報().get審査会開催日()).wareki().eraType(EraType.KANJI).getDay());
            }
            a4Data.set合議体番号(business.get一次判定結果情報().get合議体番号());
            a4Data.set審査順(business.get一次判定結果情報().get審査会審査順());
            a4Data.set被保険者区分(HihokenshaKubunCode.toValue(business.get一次判定結果情報().get被保険者区分コード()).get名称());
            a4Data.set申請区分(NinteiShinseiShinseijiKubunCode.toValue(business.get一次判定結果情報().get申請区分申()).get名称());
            a4Data.set年齢(business.get一次判定結果情報().get年齢());
            a4Data.set性別(Seibetsu.toValue(business.get一次判定結果情報().get性別()).get名称());
            a4Data.set現在の状況(GenzainoJokyoCode.toValue(business.get一次判定結果情報().get施設利用()).get名称());
            a4Data.set前々回要介護度(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(),
                    business.get一次判定結果情報().get前々回要介護度()));
            a4Data.set前々回認定有効期間(business.get一次判定結果情報().get前々回認定有効期間());
            a4Data.set前々回認定有効期間開始年月日(business.get一次判定結果情報().get前々回認定有効期間開始());
            a4Data.set前々回認定有効期間終了年月日(business.get一次判定結果情報().get前々回認定有効期間終了());
            a4Data.set前回要介護度(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(),
                    business.get一次判定結果情報().get前回認定結果()));
            a4Data.set前回認定有効期間(business.get一次判定結果情報().get二次判定認定有効期間());
            a4Data.set前回認定有効期間開始年月日(business.get一次判定結果情報().get前回認定有効期間開始年月日());
            a4Data.set前回認定有効期間終了年月日(business.get一次判定結果情報().get前回認定有効期間終了年月日());
            a4Data.set前回認定日(business.get一次判定結果情報().get二次判定年月日());
            if (business.get一次判定結果情報().get前回状態像() != null) {
                a4Data.set前回状態像(YokaigoJotaizoReiCode.toValue(business.get一次判定結果情報().get前回状態像()).get名称());
            }
            a4Data.set管理番号(business.get一次判定結果情報().get申請書管理番号());
            a4Data.set氏名(business.get一次判定結果情報().get被保険者氏名());
            a4Data.set被保険者番号(business.get一次判定結果情報().get被保険者番号());
            a4Data.set保険者番号(business.get一次判定結果情報().get証記載保険者番号());
            a4Data.set所属(business.get一次判定結果情報().get所属());
            a4Data.set市町村名(business.get一次判定結果情報().get市町村名());
            a4Data.set事業者番号(business.get一次判定結果情報().get事業者番号());
            a4Data.set事業者名(business.get一次判定結果情報().get事業者名称());
            a4Data.set認定調査員番号(business.get一次判定結果情報().get認定調査員コード());
            a4Data.set認定調査員氏名(business.get一次判定結果情報().get調査員氏名());
            a4Data.set認定調査員資格(Sikaku.toValue(business.get一次判定結果情報().get調査員資格()).get名称());
            a4Data.set医療機関番号(business.get一次判定結果情報().get主治医医療機関コード());
            a4Data.set医療機関名称(business.get一次判定結果情報().get医療機関名称());
            a4Data.set主治医番号(business.get一次判定結果情報().get主治医コード());
            a4Data.set主治医氏名(business.get一次判定結果情報().get主治医氏名());
            a4Data.set一次判定結果(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(),
                    business.get一次判定結果情報().get一次判定結果()));
            a4Data.set二次判定結果(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(),
                    business.get一次判定結果情報().get二次判定結果()));
            a4Data.set認定有効期間(business.get一次判定結果情報().get認定有効期間());
            a4Data.set認定有効期間開始年月日(business.get一次判定結果情報().get認定有効期間開始年月日());
            a4Data.set認定有効期間終了年月日(business.get一次判定結果情報().get認定有効期間終了年月日());
            a4Data.set特定疾病名(TokuteiShippei.toValue(business.get一次判定結果情報().get特定疾病()).get名称());
            if (business.get一次判定結果情報().get要介護状態像例コード() != null) {
                a4Data.set状態像名称(YokaigoJotaizoReiCode.toValue(business.get一次判定結果情報().get要介護状態像例コード()).get名称());
            }
            a4Data.set要介護認定等基準時間(business.get一次判定結果情報().get要介護認定等基準時間());
            a4Data.set要介護認定等基準時間_食事(business.get一次判定結果情報().get要介護認定等基準時間食事());
            a4Data.set要介護認定等基準時間_排泄(business.get一次判定結果情報().get要介護認定等基準時間排泄());
            a4Data.set要介護認定等基準時間_移動(business.get一次判定結果情報().get要介護認定等基準時間移動());
            a4Data.set要介護認定等基準時間_清潔保持(business.get一次判定結果情報().get要介護認定等基準時間清潔保持());
            a4Data.set要介護認定等基準時間_間接(business.get一次判定結果情報().get要介護認定等基準時間間接ケア());
            a4Data.set要介護認定等基準時間_BPSD関連(business.get一次判定結果情報().get要介護認定等基準時間BPSD関連());
            a4Data.set要介護認定等基準時間_機能訓練(business.get一次判定結果情報().get要介護認定等基準時間機能訓練());
            a4Data.set要介護認定等基準時間_医療関連(business.get一次判定結果情報().get要介護認定等基準時間医療関連());
            a4Data.set要介護認定等基準時間_認知症加算(business.get一次判定結果情報().get要介護認定等基準時間認知症加算());
            a4Data.set警告コード(business.get一次判定結果情報().get要介護認定一次判定警告コード());
            a4Data.set中間評価項目得点第1群(business.get一次判定結果情報().get中間評価項目得点第1群());
            a4Data.set中間評価項目得点第2群(business.get一次判定結果情報().get中間評価項目得点第2群());
            a4Data.set中間評価項目得点第3群(business.get一次判定結果情報().get中間評価項目得点第3群());
            a4Data.set中間評価項目得点第4群(business.get一次判定結果情報().get中間評価項目得点第4群());
            a4Data.set中間評価項目得点第5群(business.get一次判定結果情報().get中間評価項目得点第5群());
            a4Data.set日常生活自立度リスト(set日常生活自立度リスト(認定調査特記事項番号リスト, business));
            a4Data.set認定調査結果認知症高齢者自立度(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度());
            List<RString> 高齢者自立度リスト = new ArrayList<>();
            高齢者自立度リスト.add(RString.isNullOrEmpty(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度()) ? RString.EMPTY
                    : ShogaiNichijoSeikatsuJiritsudoCode.toValue(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度()).get名称());
            高齢者自立度リスト.add(RString.isNullOrEmpty(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度()) ? RString.EMPTY
                    : NinchishoNichijoSeikatsuJiritsudoCode.toValue(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度()).get名称());
            a4Data.set高齢者自立度リスト(高齢者自立度リスト);
            a4Data.set状態の安定性(RString.isNullOrEmpty(business.get一次判定結果情報().get状態の安定性()) ? RString.EMPTY
                    : JotaiAnteiseiCode.toValue(business.get一次判定結果情報().get状態の安定性()).get名称());
            a4Data.set給付区分(RString.isNullOrEmpty(business.get一次判定結果情報().get給付区分()) ? RString.EMPTY
                    : SuiteiKyufuKubunCode.toValue(business.get一次判定結果情報().get給付区分()).get名称());
            a4Data.set意見書認知症高齢者自立度(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度());
            a4Data.set現在のサービス利用状況名(business.get一次判定結果情報().getサービス区分コード());
            a4Data.set現在のサービス状況(shutsuryoku.setサービス状況(business, 認定調査票概況調査リスト, 認定調査票フラグリスト));
            set帳票印刷(a4Data, business, shutsuryoku, 認定調査票調査項目リスト, 前回調査項目リスト,
                    dbt5304Entity, 前回dbt5304Entity, 認定調査特記事項番号リスト);
            printService.print(a4Data);
        }
    }

    private void set帳票印刷(IchijihanteikekkahyoBusiness a4Data, IchijiHanteizumiDataBusiness business,
            IchijiHanteizumiDataShutsuryoku shutsuryoku, List<NinteichosahyoChosaItem> 認定調査票調査項目リスト,
            List<NinteichosahyoChosaItem> 前回調査項目リスト, List<ShujiiIkenshoIkenItem> dbt5304Entity,
            List<ShujiiIkenshoIkenItem> 前回dbt5304Entity,
            List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト) {
        a4Data.set主治医意見書項目1リスト(set主治医意見書項目1リスト(business, dbt5304Entity));
        a4Data.set主治医意見書項目2リスト(set主治医意見書項目2リスト(business, dbt5304Entity, 前回dbt5304Entity));
        a4Data.set主治医意見書項目3リスト(shutsuryoku.set主治医意見書項目3リスト(business, dbt5304Entity, 前回dbt5304Entity));
        a4Data.set主治医意見書項目4リスト(shutsuryoku.set主治医意見書項目4リスト(business, dbt5304Entity, 前回dbt5304Entity));
        a4Data.set身体機能_起居動作リスト(set身体機能_起居動作リスト(認定調査特記事項番号リスト, business));
        a4Data.set身体機能_起居動作1リスト(shutsuryoku.set身体機能_起居動作1リスト(business, 認定調査票調査項目リスト));
        a4Data.set身体機能_起居動作2リスト(shutsuryoku.set身体機能_起居動作2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set身体機能_起居動作3リスト(shutsuryoku.set身体機能_起居動作3リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set身体機能_起居動作4リスト(shutsuryoku.set身体機能_起居動作4リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set生活機能リスト(set生活機能リスト(認定調査特記事項番号リスト, business));
        a4Data.set生活機能1リスト(set生活機能1リスト(business, 認定調査票調査項目リスト));
        a4Data.set生活機能2リスト(set生活機能2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set生活機能3リスト(set生活機能3リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set生活機能4リスト(set生活機能4リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set認知機能リスト(set認知機能リスト(認定調査特記事項番号リスト, business));
        a4Data.set認知機能1リスト(set認知機能1リスト(business, 認定調査票調査項目リスト));
        a4Data.set認知機能2リスト(set認知機能2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set認知機能3リスト(set認知機能3リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set認知機能4リスト(set認知機能4リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set精神_行動障害リスト(set精神_行動障害リスト(認定調査特記事項番号リスト, business));
        a4Data.set精神_行動障害1リスト(shutsuryoku.set精神_行動障害1リスト(business, 認定調査票調査項目リスト));
        a4Data.set精神_行動障害2リスト(shutsuryoku.set精神_行動障害2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set精神_行動障害3リスト(shutsuryoku.set精神_行動障害3リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set精神_行動障害4リスト(shutsuryoku.set精神_行動障害4リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set社会生活への適応リスト(set社会生活への適応リスト(認定調査特記事項番号リスト, business));
        a4Data.set社会生活への適応1リスト(shutsuryoku.set社会生活への適応1リスト(business, 認定調査票調査項目リスト));
        a4Data.set社会生活への適応2リスト(shutsuryoku.set社会生活への適応2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set社会生活への適応3リスト(shutsuryoku.set社会生活への適応3リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set社会生活への適応4リスト(shutsuryoku.set社会生活への適応4リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set特別な医療1リスト(set特別な医療1リスト(business, 認定調査特記事項番号リスト));
        a4Data.set特別な医療2リスト(set特別な医療2リスト(business, 認定調査特記事項番号リスト));
        a4Data.set特別な医療3_1リスト(set特別な医療3_1リスト(business, 認定調査票調査項目リスト));
        a4Data.set特別な医療3_2リスト(set特別な医療3_2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
        a4Data.set特別な医療4_1リスト(set特別な医療4_1リスト(business, 認定調査票調査項目リスト));
        a4Data.set特別な医療4_2リスト(set特別な医療4_2リスト(business, 認定調査票調査項目リスト, 前回調査項目リスト));
    }

    private RString nullOrEmpty(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return RString.EMPTY;
        } else {
            return obj;
        }
    }

    private List<RString> set特別な医療4_2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 特別な医療4_2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番68));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番70));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番71));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番72));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番74));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番75));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番76));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番77));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番78));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番79));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番80));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番81));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番82));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番83));
            特別な医療4_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番84));
        }
        return 特別な医療4_2リスト;
    }

    private List<RString> set特別な医療4_1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 特別な医療4_1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番68));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番69));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番70));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番71));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番72));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番73));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番73));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番74));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番75));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番76));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番77));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番78));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番79));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番80));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番81));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番82));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番83));
            特別な医療4_1リスト.add(get名称01(dbt5211Entity, 連番84));
        }
        return 特別な医療4_1リスト;
    }

    private List<RString> set特別な医療3_2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 特別な医療3_2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番62));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番64));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番65));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番68));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番70));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番71));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番72));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番73));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番74));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番75));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番76));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番77));
            特別な医療3_2リスト.add(get調査連番(調査項目, 前回調査項目, 連番78));
        }
        return 特別な医療3_2リスト;
    }

    private List<RString> set特別な医療3_1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 特別な医療3_1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番62));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番63));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番64));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番65));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番66));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番67));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番67));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番68));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番69));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番70));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番71));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番72));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番73));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番74));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番75));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番76));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番77));
            特別な医療3_1リスト.add(get名称01(dbt5211Entity, 連番78));
        }
        return 特別な医療3_1リスト;
    }

    /**
     * 日常生活自立度リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 日常生活自立度リスト
     */
    private List<RString> set日常生活自立度リスト(List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト, IchijiHanteizumiDataBusiness business) {
        List<RString> 日常生活自立度リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            日常生活自立度リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_701, business));
            日常生活自立度リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_702, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            日常生活自立度リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_901, business));
            日常生活自立度リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_902, business));
        }
        return 日常生活自立度リスト;
    }

    private RString get特記事項有無(List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト,
            RString 番号, IchijiHanteizumiDataBusiness business) {
        List<RString> list = new ArrayList<>();
        for (NinteichosahyoTokkijiko tokkijiko : 認定調査特記事項番号リスト) {
            if (business.get一次判定結果情報().get申請書管理番号().equals(tokkijiko.get申請書管理番号().value())) {
                list.add(tokkijiko.get認定調査特記事項番号());
            }
        }
        if (list.contains(番号)) {
            return new RString("※");
        }
        return RString.EMPTY;
    }

    private List<RString> set特別な医療2リスト(IchijiHanteizumiDataBusiness business,
            List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト) {
        List<RString> 特別な医療2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_607, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_608, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_609, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_610, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_611, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_612, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_807, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_808, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_809, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_810, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_811, business));
            特別な医療2リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_812, business));
        }
        return 特別な医療2リスト;
    }

    private List<RString> set特別な医療1リスト(IchijiHanteizumiDataBusiness business,
            List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト) {
        List<RString> 特別な医療1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_601, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_602, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_603, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_604, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_605, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_606, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_801, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_802, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_803, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_804, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_805, business));
            特別な医療1リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_806, business));
        }
        return 特別な医療1リスト;
    }

    private List<RString> set社会生活への適応リスト(List<NinteichosahyoTokkijiko> 認定調査特記事項番号リスト,
            IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_501, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_502, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_503, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_504, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_505, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_506, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_503, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_504, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_506, business));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_510, business));
            社会生活への適応リスト.add(get特記事項有無(認定調査特記事項番号リスト, 特記事項番号_511, business));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        return 社会生活への適応リスト;
    }

    private List<RString> set生活機能リスト(List<NinteichosahyoTokkijiko> list,
            IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_201, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_202, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_203, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_204, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_205, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_208, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_209, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_210, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_211, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_212, business));
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_1002, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022, business));
            生活機能リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207, business));
            生活機能リスト.add(RString.EMPTY);
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_404, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_409, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_501, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_502, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_503, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_506, business));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_507, business));
            生活機能リスト.add(RString.EMPTY);
        }
        return 生活機能リスト;
    }

    private List<RString> set身体機能_起居動作リスト(List<NinteichosahyoTokkijiko> list,
            IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101, business));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101, business));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101, business));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101, business));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101, business));
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_103, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_104, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_105, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_106, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_107, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_108, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_109, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_110, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_111, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_112, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_113, business));
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_5014, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602, business));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_206, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_304, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601, business));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602, business));
        }
        return 身体機能_起居動作リスト;
    }

    private List<RString> set精神_行動障害リスト(List<NinteichosahyoTokkijiko> list,
            IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_401, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_402, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_403, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_404, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_405, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_406, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_407, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_408, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_409, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_410, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_411, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_412, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_413, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_414, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_415, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_719, business));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716, business));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_512, business));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        return 精神_行動障害リスト;
    }

    private List<RString> set主治医意見書項目2リスト(IchijiHanteizumiDataBusiness business, List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目) {
        List<RString> 主治医意見書項目2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番13));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番68));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番17));
            主治医意見書項目2リスト.add(get状況改善(意見書項目, 前回意見書項目, 連番18));
        }
        return 主治医意見書項目2リスト;
    }

    private static RString get状況改善(List<ShujiiIkenshoIkenItem> 調査項目,
            List<ShujiiIkenshoIkenItem> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get意見項目())) {
            今回調査 = 調査項目.get(連番).get意見項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get意見項目())) {
            前回調査 = 前回調査項目.get(連番).get意見項目();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private List<RString> set主治医意見書項目1リスト(IchijiHanteizumiDataBusiness business, List<ShujiiIkenshoIkenItem> dbt5304Entity) {
        List<RString> 主治医意見書項目1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番13));
            主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番68));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目1リスト.add(get意見書名称03(dbt5304Entity, 連番14));
            主治医意見書項目1リスト.add(get意見書名称04(dbt5304Entity, 連番15));
            主治医意見書項目1リスト.add(get意見書名称05(dbt5304Entity, 連番16));
            主治医意見書項目1リスト.add(get意見書名称06(dbt5304Entity, 連番17));
            主治医意見書項目1リスト.add(get意見書名称14(dbt5304Entity, 連番18));
        }
        return 主治医意見書項目1リスト;
    }

    private List<RString> set生活機能1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目リスト) {
        List<RString> 生活機能1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称10(調査項目リスト, 連番20));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番21));
            生活機能1リスト.add(get名称11(調査項目リスト, 連番22));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番23));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番24));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番25));
            生活機能1リスト.add(get名称12(調査項目リスト, 連番26));
            生活機能1リスト.add(get名称12(調査項目リスト, 連番27));
            生活機能1リスト.add(get名称12(調査項目リスト, 連番28));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番29));
            生活機能1リスト.add(get名称10(調査項目リスト, 連番30));
            生活機能1リスト.add(get名称13(調査項目リスト, 連番31));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称20(調査項目リスト, 連番17));
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(get名称33(調査項目リスト, 連番25));
            生活機能1リスト.add(get名称33(調査項目リスト, 連番30));
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(RString.EMPTY);
            生活機能1リスト.add(get名称22(調査項目リスト, 連番31));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番32));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番33));
            生活機能1リスト.add(get名称34(調査項目リスト, 連番36));
            生活機能1リスト.add(get名称34(調査項目リスト, 連番37));
            生活機能1リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称20(調査項目リスト, 連番16));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番17));
            生活機能1リスト.add(get名称11(調査項目リスト, 連番23));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番24));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番26));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番27));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番28));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番29));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番30));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番32));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番33));
            生活機能1リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称20(調査項目リスト, 連番16));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番17));
            生活機能1リスト.add(get名称11(調査項目リスト, 連番23));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番24));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番26));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番27));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番28));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番29));
            生活機能1リスト.add(get名称22(調査項目リスト, 連番30));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番32));
            生活機能1リスト.add(get名称20(調査項目リスト, 連番33));
            生活機能1リスト.add(get名称13(調査項目リスト, 連番80));
        }
        return 生活機能1リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set生活機能2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 生活機能2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番20));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番21));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番22));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番25));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番25));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(RString.EMPTY);
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番23));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番24));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番26));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番27));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番28));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番29));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番30));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            生活機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番80));
        }
        return 生活機能2リスト;
    }

    private List<RString> set生活機能3リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 生活機能3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番20));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番21));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番22));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番25));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番25));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(RString.EMPTY);
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番36));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番23));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番24));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番26));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番27));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番28));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番29));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番30));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            生活機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番80));
        }
        return 生活機能3リスト;
    }

    private List<RString> set生活機能4リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 生活機能(business, 調査項目, dbt5211Entity);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
            生活機能4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番20));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番21));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番22));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番25));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称12(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称10(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称13(dbt5211Entity, 連番31));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get名称33(dbt5211Entity, 連番25));
                生活機能4リスト.add(get名称33(dbt5211Entity, 連番30));
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(RString.EMPTY);
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番31));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番33));
                生活機能4リスト.add(get名称34(dbt5211Entity, 連番36));
                生活機能4リスト.add(get名称34(dbt5211Entity, 連番37));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(RString.EMPTY);
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番16));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番17));
                生活機能4リスト.add(get名称11(dbt5211Entity, 連番23));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番24));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番26));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番27));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番28));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番29));
                生活機能4リスト.add(get名称22(dbt5211Entity, 連番30));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番32));
                生活機能4リスト.add(get名称20(dbt5211Entity, 連番33));
                生活機能4リスト.add(get名称13(dbt5211Entity, 連番80));
            }
        }
        return 生活機能4リスト;
    }

    private List<RString> 生活機能(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番20).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番20));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番21).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番21));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番22).isEmpty() ? RString.EMPTY : get名称11(dbt5211Entity, 連番22));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番23).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番23));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番24).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番24));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番25).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番25));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番26).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番26));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番27).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番27));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番28).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番28));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番29).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番29));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称10(dbt5211Entity, 連番30));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称13(dbt5211Entity, 連番31));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set生活機能差分99A(調査項目, dbt5211Entity);
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
            return set生活機能差分02A(business, 調査項目, dbt5211Entity);
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番17));
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番25).isEmpty() ? RString.EMPTY : get名称33(dbt5211Entity, 連番25));
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称33(dbt5211Entity, 連番30));
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番31));
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番32));
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番33));
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36).isEmpty() ? RString.EMPTY : get名称34(dbt5211Entity, 連番36));
        生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37).isEmpty() ? RString.EMPTY : get名称34(dbt5211Entity, 連番37));
        生活機能4リスト.add(RString.EMPTY);
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分02A(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番16));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番17));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番23).isEmpty() ? RString.EMPTY : get名称11(dbt5211Entity, 連番23));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番24).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番24));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番26).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番26));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番27).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番27));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番28).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番28));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番29).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番29));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番30).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番30));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番32));
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33).isEmpty() ? RString.EMPTY : get名称20(dbt5211Entity, 連番33));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番80).isEmpty() ? RString.EMPTY : get名称13(dbt5211Entity, 連番80));
        }
        return 生活機能4リスト;
    }

    private List<RString> set認知機能1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> dbt5211Entity) {
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        List<RString> 認知機能1リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番32));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番33));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番34));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番35));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番36));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番37));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番38));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番39));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番40));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番40));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番42));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番43));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番44));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番45));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番46));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番47));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番57));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番59));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            認知機能1リスト.add(get名称14(dbt5211Entity, 連番46));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番48));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番49));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番50));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番51));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番52));
            認知機能1リスト.add(get名称15(dbt5211Entity, 連番53));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番63));
            認知機能1リスト.add(get名称16(dbt5211Entity, 連番65));
        }
        return 認知機能1リスト;
    }

    private List<RString> set認知機能2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 認知機能2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番32));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番33));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番35));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番38));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番39));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番43));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番47));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番59));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番50));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番53));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            認知機能2リスト.add(get調査連番(調査項目, 前回調査項目, 連番65));
        }
        return 認知機能2リスト;
    }

    private List<RString> set認知機能3リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 認知機能3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番32));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番33));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番35));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番36));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番38));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番39));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番43));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番47));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番59));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番50));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番53));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番63));
            認知機能3リスト.add(get状況結果(調査項目, 前回調査項目, 連番65));
        }
        return 認知機能3リスト;
    }

    private List<RString> set認知機能4リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 認知機能(調査項目, 前回調査項目, business);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
            認知機能4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                認知機能4リスト.add(get名称14(調査項目, 連番32));
                認知機能4リスト.add(get名称15(調査項目, 連番33));
                認知機能4リスト.add(get名称15(調査項目, 連番34));
                認知機能4リスト.add(get名称15(調査項目, 連番35));
                認知機能4リスト.add(get名称15(調査項目, 連番36));
                認知機能4リスト.add(get名称15(調査項目, 連番37));
                認知機能4リスト.add(get名称15(調査項目, 連番38));
                認知機能4リスト.add(get名称16(調査項目, 連番39));
                認知機能4リスト.add(get名称16(調査項目, 連番40));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                認知機能4リスト.add(get名称14(調査項目, 連番40));
                認知機能4リスト.add(get名称15(調査項目, 連番42));
                認知機能4リスト.add(get名称15(調査項目, 連番43));
                認知機能4リスト.add(get名称15(調査項目, 連番44));
                認知機能4リスト.add(get名称15(調査項目, 連番45));
                認知機能4リスト.add(get名称15(調査項目, 連番46));
                認知機能4リスト.add(get名称15(調査項目, 連番47));
                認知機能4リスト.add(get名称16(調査項目, 連番57));
                認知機能4リスト.add(get名称16(調査項目, 連番59));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                認知機能4リスト.add(get名称14(調査項目, 連番46));
                認知機能4リスト.add(get名称15(調査項目, 連番48));
                認知機能4リスト.add(get名称15(調査項目, 連番49));
                認知機能4リスト.add(get名称15(調査項目, 連番50));
                認知機能4リスト.add(get名称15(調査項目, 連番51));
                認知機能4リスト.add(get名称15(調査項目, 連番52));
                認知機能4リスト.add(get名称15(調査項目, 連番53));
                認知機能4リスト.add(get名称16(調査項目, 連番63));
                認知機能4リスト.add(get名称16(調査項目, 連番65));
            }
        }
        return 認知機能4リスト;
    }

    private List<RString> 認知機能(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity, IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番32).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番32));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番33).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番33));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番34));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番35));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番36).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番36));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番37));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番38));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番39));
            認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番40));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set認知機能差分99A(調査項目, dbt5211Entity);
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            return set認知機能差分02A(調査項目, dbt5211Entity);
        }
        return 認知機能4リスト;
    }

    private List<RString> set認知機能差分02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番40));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番42));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番43));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番44));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番45));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番46));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番47));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番57));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番59).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番59));
        return 認知機能4リスト;
    }

    private List<RString> set認知機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46).isEmpty() ? RString.EMPTY : get名称14(dbt5211Entity, 連番46));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番48));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番49));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番50));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番51));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番52));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53).isEmpty() ? RString.EMPTY : get名称15(dbt5211Entity, 連番53));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番63));
        認知機能4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番65).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番65));
        return 認知機能4リスト;
    }

    private RString get調査連番(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private RString get状況結果(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private RString 機能差分結果(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size() && !RString.isNullOrEmpty(前回意見書項目.get(連番).get調査項目())) {
            RString 前回調査 = 前回意見書項目.get(連番).get調査項目();
            if (!今回調査.equals(前回調査)) {
                return 前回調査;
            }
        }
        return RString.EMPTY;
    }

    private List<RString> set認知機能リスト(List<NinteichosahyoTokkijiko> list,
            IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_301, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_302, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_303, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_304, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_305, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_306, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_307, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_308, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_309, business));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_603, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6051, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6052, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6053, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6054, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6055, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6056, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_710, business));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_712, business));
        }
        return 認知機能リスト;
    }

    private RString get名称34(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser34.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称33(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser33.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称22(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser22.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称20(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser20.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称16(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser16.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称13(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser13.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称11(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser11.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称10(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser10.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称12(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser12.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get名称01(List<NinteichosahyoChosaItem> dbt5211Entity, int 連番) {
        if (連番 < dbt5211Entity.size()) {
            if (RString.isNullOrEmpty(dbt5211Entity.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser01.toValue(dbt5211Entity.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称03(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku03.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称14(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku14.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称06(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku06.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称05(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku05.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称04(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku04.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称14(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser14.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称15(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser15.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }
}
