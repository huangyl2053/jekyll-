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
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE309003.DBE309003_IchijihanteiSumidataIfParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.IchijiHanteizumiDataShutsuryokuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001.dgIchijiHanteiZumi_Row;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ichijihanteikekkahyo.IchijihanteikekkahyoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser20;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser31;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser33;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser34;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.GenzainoJokyoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.KariIchijiHanteiKubun;
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
    private List<RString> 特記事項番号List;
    private static final int 元号 = 4;

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
        for (IchijiHanteizumiDataShutsuryokuBusiness business : list) {
            dgIchijiHanteiZumi_Row row = new dgIchijiHanteiZumi_Row();
            row.setHokenshaMei(nullOrEmpty(business.get市町村名称()));
            if (!RString.isNullOrEmpty(business.get認定申請年月日())) {
                row.setShinseibi(new FlexibleDate(business.get認定申請年月日()).wareki().toDateString());
            }
            row.setHihoBango(business.get被保険者番号());
            row.setShimei(business.get被保険者氏名());
            row.setShinseitoki(NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード()).get名称());
            row.setHorei(NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード()).get名称());
            if (!RString.isNullOrEmpty(business.get要介護認定一次判定年月日())) {
                row.setKanryobi(new FlexibleDate(business.get要介護認定一次判定年月日()).wareki().toDateString());
            }
            row.setIchijihanteikekka(shutsuryoku.set要介護状態区分コード(business.get厚労省IF識別コード(), business.get要介護認定一次判定結果コード()));
            if (!RString.isNullOrEmpty(business.get一次判定情報抽出年月日())) {
                row.setShiryoSakusei(new FlexibleDate(business.get一次判定情報抽出年月日()).wareki().toDateString());
            }
            row.setKeikokuCode(nullOrEmpty(business.get要介護認定一次判定警告コード()));
            row.setShinseishoKanriNo(business.get申請書管理番号());
            row.setShoKisaiHokenshaNo(business.get証記載保険者番号());
            PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, new ExpandedInformation(Code.EMPTY, RString.EMPTY, RString.EMPTY));
            personalData.addExpandedInfo(new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"),
                    business.get申請書管理番号()));
            AccessLogger.log(AccessLogType.照会, personalData);
            dgChosainList.add(row);
        }
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
        return IchijiHanteizumiDataShutsuryokuMybitisParamter.createParam(
                div.getRadJyoken().getSelectedKey(),
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                div.getTextBoxNum().getValue(),
                総合事業開始区分,
                null,
                false);

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
        boolean 仮一次判定区分 = KariIchijiHanteiKubun.本一次判定.is仮一次判定();
        return IchijiHanteizumiDataShutsuryokuMybitisParamter.createParam(
                div.getRadJyoken().getSelectedKey(),
                申請日From,
                申請日To,
                一次判定日From,
                一次判定日To,
                div.getTextBoxNum().getValue(),
                総合事業開始区分,
                shinseishoKanriNo,
                仮一次判定区分);

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
        parameter.set申請日From(div.getTxtShinseibi().getFromValue().toDateString());
        parameter.set申請日To(div.getTxtShinseibi().getToValue().toDateString());
        parameter.set申請日From(div.getTxtIchijiHanteibi().getFromValue().toDateString());
        parameter.set申請日To(div.getTxtIchijiHanteibi().getToValue().toDateString());
        return parameter;
    }

    /**
     * 帳票印刷の設定します。
     *
     * @param 一次判定結果list 一次判定済みデータ
     */
    public void set帳票(List<IchijiHanteizumiDataBusiness> 一次判定結果list) {
        特記事項番号List = new ArrayList<>();
        IchijiHanteizumiDataShutsuryoku shutsuryoku = new IchijiHanteizumiDataShutsuryoku();
        for (IchijiHanteizumiDataBusiness business : 一次判定結果list) {
            特記事項番号List.add(business.get一次判定結果情報().getNinteichosaTokkijikoNo());
        }
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
            a4Data.set前々回要介護度(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(), business.get一次判定結果情報().get前々回要介護度()));
            a4Data.set前々回認定有効期間(business.get一次判定結果情報().get前々回認定有効期間());
            a4Data.set前々回認定有効期間開始年月日(business.get一次判定結果情報().get前々回認定有効期間開始());
            a4Data.set前々回認定有効期間終了年月日(business.get一次判定結果情報().get前々回認定有効期間終了());
            a4Data.set前回要介護度(shutsuryoku.set要介護状態区分コード(business.get一次判定結果情報().get厚労省IF識別コード(), business.get一次判定結果情報().get前回認定結果()));
            a4Data.set前回認定有効期間(business.get一次判定結果情報().get前回認定有効期間());
            a4Data.set前回認定有効期間開始年月日(business.get一次判定結果情報().get前回認定有効期間開始());
            a4Data.set前回認定有効期間終了年月日(business.get一次判定結果情報().get前回認定有効期間終了());
            a4Data.set前回認定日(business.get一次判定結果情報().get前回二次判定年月日());
            if (business.get一次判定結果情報().get前回状態像() != null) {
                a4Data.set前回状態像(YokaigoJotaizoReiCode.toValue(business.get一次判定結果情報().get前回状態像()).get名称());
            }
            a4Data.set管理番号(business.get一次判定結果情報().get申請書管理番号());
            a4Data.set氏名(business.get一次判定結果情報().get被保険者氏名());
            a4Data.set被保険者番号(business.get一次判定結果情報().get被保険者番号());
            a4Data.set保険者番号(business.get一次判定結果情報().get保険者番号());
            a4Data.set所属(申請日);
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
            a4Data.set警告コード(business.get一次判定結果情報().get警告コード());
            a4Data.set中間評価項目得点第1群(business.get一次判定結果情報().get中間評価項目得点第1群());
            a4Data.set中間評価項目得点第2群(business.get一次判定結果情報().get中間評価項目得点第2群());
            a4Data.set中間評価項目得点第3群(business.get一次判定結果情報().get中間評価項目得点第3群());
            a4Data.set中間評価項目得点第4群(business.get一次判定結果情報().get中間評価項目得点第4群());
            a4Data.set中間評価項目得点第5群(business.get一次判定結果情報().get中間評価項目得点第5群());
            a4Data.set日常生活自立度リスト(set日常生活自立度リスト(特記事項番号List, business));
            a4Data.set認定調査結果認知症高齢者自立度(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度());
            List<RString> 高齢者自立度リスト = new ArrayList<>();
            高齢者自立度リスト.add(RString.isNullOrEmpty(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度()) ? RString.EMPTY
                    : ShogaiNichijoSeikatsuJiritsudoCode.toValue(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度()).get名称());
            高齢者自立度リスト.add(RString.isNullOrEmpty(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度()) ? RString.EMPTY
                    : NinchishoNichijoSeikatsuJiritsudoCode.toValue(business.get一次判定結果情報().get認知症高齢者自立度日常生活自立度()).get名称());
            a4Data.set高齢者自立度リスト(高齢者自立度リスト);
            a4Data.set意見書認知症高齢者自立度(business.get一次判定結果情報().get障害高齢者自立度日常生活自立度());
            a4Data.set現在のサービス利用状況名(business.get一次判定結果情報().getサービス区分コード());
            a4Data.set現在のサービス状況(shutsuryoku.setサービス状況(business));
            a4Data.set主治医意見書項目1リスト(set主治医意見書項目1リスト(business));
            a4Data.set主治医意見書項目2リスト(set主治医意見書項目2リスト(business));
            a4Data.set主治医意見書項目3リスト(set主治医意見書項目3リスト(business));
            a4Data.set主治医意見書項目4リスト(set主治医意見書項目4リスト(business));
            a4Data.set身体機能_起居動作リスト(set身体機能_起居動作リスト(特記事項番号List, business));
            a4Data.set身体機能_起居動作1リスト(shutsuryoku.set身体機能_起居動作1リスト(business));
            a4Data.set身体機能_起居動作2リスト(shutsuryoku.set精神_行動障害2リスト(business));
            a4Data.set身体機能_起居動作3リスト(shutsuryoku.set精神_行動障害3リスト(business));
            a4Data.set身体機能_起居動作4リスト(shutsuryoku.set精神_行動障害4リスト(business));
            a4Data.set生活機能リスト(set生活機能リスト(特記事項番号List, business));
            a4Data.set生活機能1リスト(set生活機能1リスト(business));
            a4Data.set生活機能2リスト(set生活機能2リスト(business));
            a4Data.set生活機能3リスト(set生活機能3リスト(business));
            a4Data.set生活機能4リスト(set生活機能4リスト(business));
            a4Data.set認知機能リスト(set認知機能リスト(特記事項番号List, business));
            a4Data.set認知機能1リスト(set認知機能1リスト(business));
            a4Data.set認知機能2リスト(set認知機能2リスト(business));
            a4Data.set認知機能3リスト(set認知機能3リスト(business));
            a4Data.set認知機能4リスト(set認知機能4リスト(business));
            a4Data.set精神_行動障害リスト(set精神_行動障害リスト(特記事項番号List, business));
            a4Data.set精神_行動障害1リスト(shutsuryoku.set精神_行動障害1リスト(business));
            a4Data.set精神_行動障害2リスト(shutsuryoku.set精神_行動障害2リスト(business));
            a4Data.set精神_行動障害3リスト(shutsuryoku.set精神_行動障害3リスト(business));
            a4Data.set精神_行動障害4リスト(shutsuryoku.set精神_行動障害4リスト(business));
            a4Data.set社会生活への適応リスト(set社会生活への適応リスト(特記事項番号List, business));
            a4Data.set社会生活への適応1リスト(set社会生活への適応1リスト(business));
            a4Data.set社会生活への適応2リスト(set社会生活への適応2リスト(business));
            a4Data.set社会生活への適応3リスト(set社会生活への適応3リスト(business));
            a4Data.set社会生活への適応4リスト(set社会生活への適応4リスト(business));
            a4Data.set特別な医療1リスト(set特別な医療1リスト(特記事項番号List, business));
            a4Data.set特別な医療2リスト(set特別な医療2リスト(特記事項番号List, business));
            a4Data.set特別な医療3_1リスト(set特別な医療3_1リスト(business));
            a4Data.set特別な医療3_2リスト(set特別な医療3_2リスト(business));
            a4Data.set特別な医療4_1リスト(set特別な医療4_1リスト(business));
            a4Data.set特別な医療4_2リスト(set特別な医療4_2リスト(business));
            printService.print(a4Data);
        }
    }

    private RString nullOrEmpty(RString obj) {
        if (RString.isNullOrEmpty(obj)) {
            return RString.EMPTY;
        } else {
            return obj;
        }

    }

    private List<RString> set特別な医療4_2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療4_2リスト = new ArrayList<>();
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().get気管切開の処置(), business.get一次判定結果情報().get前回気管切開の処置()));
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().get疼痛の看護(), business.get一次判定結果情報().get前回疼痛の看護()));
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().get経管栄養(), business.get一次判定結果情報().get前回経管栄養()));
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().getモニター測定(), business.get一次判定結果情報().get前回モニター測定()));
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().getじょくそうの処置(), business.get一次判定結果情報().get前回じょくそうの処置()));
        特別な医療4_2リスト.add(get状況改善(business.get一次判定結果情報().getカテーテル(), business.get一次判定結果情報().get前回カテーテル()));
        return 特別な医療4_2リスト;
    }

    private List<RString> set特別な医療4_1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療4_1リスト = new ArrayList<>();
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().get気管切開の処置()));
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().get疼痛の看護()));
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().get経管栄養()));
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().getモニター測定()));
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().getじょくそうの処置()));
        特別な医療4_1リスト.add(get名称01(business.get一次判定結果情報().getカテーテル()));
        return 特別な医療4_1リスト;
    }

    private List<RString> set特別な医療3_2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療3_2リスト = new ArrayList<>();
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().get点滴の管理(), business.get一次判定結果情報().get前回点滴の管理()));
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().get中心静脈栄養(), business.get一次判定結果情報().get前回中心静脈栄養()));
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().get透析(), business.get一次判定結果情報().get前回透析()));
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().getストーマの処置(), business.get一次判定結果情報().get前回ストーマの処置()));
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().get酸素療法(), business.get一次判定結果情報().get前回酸素療法()));
        特別な医療3_2リスト.add(get状況改善(business.get一次判定結果情報().getレスピレーター(), business.get一次判定結果情報().get前回レスピレーター()));
        return 特別な医療3_2リスト;
    }

    private List<RString> set特別な医療3_1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療3_1リスト = new ArrayList<>();
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().get点滴の管理()));
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().get中心静脈栄養()));
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().get透析()));
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().getストーマの処置()));
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().get酸素療法()));
        特別な医療3_1リスト.add(get名称01(business.get一次判定結果情報().getレスピレーター()));
        return 特別な医療3_1リスト;
    }

    /**
     * 日常生活自立度リストを設定します。
     *
     * @param list 特記事項番号
     * @param bodyItem 一次判定結果Entity
     * @return 日常生活自立度リスト
     */
    private List<RString> set日常生活自立度リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 日常生活自立度リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_701));
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_702));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_901));
            日常生活自立度リスト.add(get特記事項有無(list, 特記事項番号_902));
        }
        return 日常生活自立度リスト;
    }

    private RString get特記事項有無(List<RString> list, RString 番号) {
        if (list.contains(番号)) {
            return new RString("※");
        }
        return RString.EMPTY;
    }

    private List<RString> set社会生活への適応4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 社会生活機能(business);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード)
                    || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称12(business.get一次判定結果情報().get薬の内服()));
                社会生活への適応4リスト.add(get名称12(business.get一次判定結果情報().get金銭の管理()));
                社会生活への適応4リスト.add(get名称17(business.get一次判定結果情報().get日常の意思決定()));
                社会生活への適応4リスト.add(get名称16(business.get一次判定結果情報().get集団への不適応()));
                社会生活への適応4リスト.add(get名称10(business.get一次判定結果情報().get買い物()));
                社会生活への適応4リスト.add(get名称10(business.get一次判定結果情報().get簡単な調理()));
            }
            if (識別コード06A.equals(厚労省IF識別コード)
                    || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称22(business.get一次判定結果情報().get薬の内服()));
                社会生活への適応4リスト.add(get名称22(business.get一次判定結果情報().get金銭の管理()));
                社会生活への適応4リスト.add(get名称17(business.get一次判定結果情報().get日常の意思決定()));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称22(business.get一次判定結果情報().get薬の内服()));
                社会生活への適応4リスト.add(get名称22(business.get一次判定結果情報().get金銭の管理()));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private List<RString> 社会生活機能(IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(nullOrEmpty(差分結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服())).isEmpty()
                    ? RString.EMPTY : get名称12(business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()).isEmpty()
                    ? RString.EMPTY : get名称12(business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()).isEmpty()
                    ? RString.EMPTY : get名称17(business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get集団への不適応(), business.get一次判定結果情報().get前回集団への不適応()).isEmpty()
                    ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回集団への不適応()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get買い物(), business.get一次判定結果情報().get前回買い物()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回買い物()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get簡単な調理(), business.get一次判定結果情報().get前回簡単な調理()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回簡単な調理()));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()).isEmpty()
                    ? RString.EMPTY : get名称17(business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応4リスト.add(差分結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        return 社会生活への適応4リスト;
    }

    private List<RString> set社会生活への適応3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get集団への不適応(), business.get一次判定結果情報().get前回集団への不適応()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get買い物(), business.get一次判定結果情報().get前回買い物()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get簡単な調理(), business.get一次判定結果情報().get前回簡単な調理()));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応3リスト.add(get意見書状況結果(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        return 社会生活への適応3リスト;
    }

    private List<RString> set社会生活への適応2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get集団への不適応(), business.get一次判定結果情報().get前回集団への不適応()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get買い物(), business.get一次判定結果情報().get前回買い物()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get簡単な調理(), business.get一次判定結果情報().get前回簡単な調理()));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get日常の意思決定(), business.get一次判定結果情報().get前回日常の意思決定()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get集団への不適応(), business.get一次判定結果情報().get前回集団への不適応()));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get薬の内服(), business.get一次判定結果情報().get前回薬の内服()));
            社会生活への適応2リスト.add(get状況改善(business.get一次判定結果情報().get金銭の管理(), business.get一次判定結果情報().get前回金銭の管理()));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        return 社会生活への適応2リスト;
    }

    private List<RString> set社会生活への適応1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称12(business.get一次判定結果情報().get薬の内服()));
            社会生活への適応1リスト.add(get名称12(business.get一次判定結果情報().get金銭の管理()));
            社会生活への適応1リスト.add(get名称17(business.get一次判定結果情報().get日常の意思決定()));
            社会生活への適応1リスト.add(get名称16(business.get一次判定結果情報().get集団への不適応()));
            社会生活への適応1リスト.add(get名称10(business.get一次判定結果情報().get買い物()));
            社会生活への適応1リスト.add(get名称10(business.get一次判定結果情報().get簡単な調理()));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称22(business.get一次判定結果情報().get薬の内服()));
            社会生活への適応1リスト.add(get名称22(business.get一次判定結果情報().get金銭の管理()));
            社会生活への適応1リスト.add(get名称17(business.get一次判定結果情報().get日常の意思決定()));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称22(business.get一次判定結果情報().get薬の内服()));
            社会生活への適応1リスト.add(get名称22(business.get一次判定結果情報().get金銭の管理()));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        return 社会生活への適応1リスト;
    }

    /**
     * 特別な医療2リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 特別な医療2リスト
     */
    public List<RString> set特別な医療2リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_607));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_608));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_609));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_610));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_611));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_612));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_807));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_808));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_809));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_810));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_811));
            特別な医療2リスト.add(get特記事項有無(list, 特記事項番号_812));
        }
        return 特別な医療2リスト;
    }

    /**
     * 特別な医療1リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 特別な医療1リスト
     */
    public List<RString> set特別な医療1リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 特別な医療1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_601));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_602));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_603));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_604));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_605));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_606));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_801));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_802));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_803));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_804));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_805));
            特別な医療1リスト.add(get特記事項有無(list, 特記事項番号_806));
        }
        return 特別な医療1リスト;
    }

    /**
     * 社会生活への適応リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 社会生活への適応リスト
     */
    public List<RString> set社会生活への適応リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 社会生活への適応リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_501));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_502));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_503));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_504));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_505));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_506));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_503));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_504));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_506));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_510));
            社会生活への適応リスト.add(get特記事項有無(list, 特記事項番号_511));
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
            社会生活への適応リスト.add(RString.EMPTY);
        }
        return 社会生活への適応リスト;
    }

    /**
     * 生活機能リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 生活機能リスト
     */
    public List<RString> set生活機能リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_201));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_202));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_203));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_204));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_205));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_208));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_209));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_210));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_211));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_212));
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_1002));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_206));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_402));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_403));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5011));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5012));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5013));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5021));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_5022));
            生活機能リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_207));
            生活機能リスト.add(RString.EMPTY);
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_404));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_409));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_405));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_406));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_501));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_502));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_503));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_506));
            生活機能リスト.add(get特記事項有無(list, 特記事項番号_507));
            生活機能リスト.add(RString.EMPTY);
        }
        return 生活機能リスト;
    }

    /**
     * 身体機能起居動作リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 身体機能起居動作リスト
     */
    public List<RString> set身体機能_起居動作リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_101));
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_102));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_103));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_104));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_105));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_106));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_107));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_108));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_109));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_110));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_111));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_112));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_113));
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_5014));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_204));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_303));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(RString.EMPTY);
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_201));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_202));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_203));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_205));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_206));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_301));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_302));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_304));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_504));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_601));
            身体機能_起居動作リスト.add(get特記事項有無(list, 特記事項番号_602));
        }
        return 身体機能_起居動作リスト;
    }

    /**
     * 精神行動障害リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 精神行動障害リスト
     */
    public List<RString> set精神_行動障害リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_401));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_402));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_403));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_404));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_405));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_406));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_407));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_408));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_409));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_410));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_411));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_412));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_413));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_414));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_415));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_719));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_701));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_702));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_704));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_705));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_707));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_708));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_709));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_711));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_713));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_714));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_716));
            精神_行動障害リスト.add(get特記事項有無(list, 特記事項番号_512));
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
            精神_行動障害リスト.add(RString.EMPTY);
        }
        return 精神_行動障害リスト;
    }

    /**
     * 主治医意見書項目3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目3リスト
     */
    public List<RString> set主治医意見書項目3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目3リスト = new ArrayList<>();
        主治医意見書項目3リスト.add(get意見書状況結果(business.get一次判定結果情報().get意見書認知症高齢者自立度(),
                business.get一次判定結果情報().get前回意見書認知症高齢者自立度()));
        主治医意見書項目3リスト.add(get意見書状況結果(business.get一次判定結果情報().get短期記憶(),
                business.get一次判定結果情報().get前回短期記憶()));
        主治医意見書項目3リスト.add(get意見書状況結果(business.get一次判定結果情報().get日常の意思決定を行うための認知能力(),
                business.get一次判定結果情報().get前回日常の意思決定を行うための認知能力()));
        主治医意見書項目3リスト.add(get意見書状況結果(business.get一次判定結果情報().get自分の意思の伝達能力(),
                business.get一次判定結果情報().get前回自分の意思の伝達能力()));
        主治医意見書項目3リスト.add(get意見書状況結果(business.get一次判定結果情報().get食事行為(),
                business.get一次判定結果情報().get前回食事行為()));
        return 主治医意見書項目3リスト;
    }

    /**
     * 主治医意見書項目4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目4リスト
     */
    public List<RString> set主治医意見書項目4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        RString 結果印刷有無 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate());
        if (差分のみ印刷.equals(結果印刷有無)) {
            return 主治医差分(business);
        }
        if (印刷しない.equals(結果印刷有無)) {
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(結果印刷有無)) {
            主治医意見書項目4リスト.add(IkenKomoku03.toValue(business.get一次判定結果情報().get意見書認知症高齢者自立度()).get名称());
            主治医意見書項目4リスト.add(IkenKomoku04.toValue(business.get一次判定結果情報().get短期記憶()).get名称());
            主治医意見書項目4リスト.add(IkenKomoku05.toValue(business.get一次判定結果情報().get日常の意思決定を行うための認知能力()).get名称());
            主治医意見書項目4リスト.add(IkenKomoku06.toValue(business.get一次判定結果情報().get自分の意思の伝達能力()).get名称());
            主治医意見書項目4リスト.add(IkenKomoku14.toValue(business.get一次判定結果情報().get食事行為()).get名称());
        }
        return 主治医意見書項目4リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set主治医意見書項目2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目2リスト = new ArrayList<>();
        主治医意見書項目2リスト.add(get状況改善(business.get一次判定結果情報().get意見書認知症高齢者自立度(),
                business.get一次判定結果情報().get前回意見書認知症高齢者自立度()));
        主治医意見書項目2リスト.add(get状況改善(business.get一次判定結果情報().get短期記憶(),
                business.get一次判定結果情報().get前回短期記憶()));
        主治医意見書項目2リスト.add(get状況改善(business.get一次判定結果情報().get日常の意思決定を行うための認知能力(),
                business.get一次判定結果情報().get前回日常の意思決定を行うための認知能力()));
        主治医意見書項目2リスト.add(get状況改善(business.get一次判定結果情報().get自分の意思の伝達能力(),
                business.get一次判定結果情報().get前回自分の意思の伝達能力()));
        主治医意見書項目2リスト.add(get状況改善(business.get一次判定結果情報().get食事行為(),
                business.get一次判定結果情報().get前回食事行為()));
        return 主治医意見書項目2リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set主治医意見書項目1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目1リスト = new ArrayList<>();
        主治医意見書項目1リスト.add(get名称03(business.get一次判定結果情報().get意見書認知症高齢者自立度()));
        主治医意見書項目1リスト.add(get名称03(business.get一次判定結果情報().get短期記憶()));
        主治医意見書項目1リスト.add(get名称03(business.get一次判定結果情報().get日常の意思決定を行うための認知能力()));
        主治医意見書項目1リスト.add(get名称03(business.get一次判定結果情報().get自分の意思の伝達能力()));
        主治医意見書項目1リスト.add(get名称03(business.get一次判定結果情報().get食事行為()));
        return 主治医意見書項目1リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set生活機能1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get移乗()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get移動()));
            生活機能1リスト.add(get名称11(business.get一次判定結果情報().getえん下()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get食事摂取()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get排尿()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get排便()));
            生活機能1リスト.add(get名称12(business.get一次判定結果情報().get口腔清潔()));
            生活機能1リスト.add(get名称12(business.get一次判定結果情報().get洗顔()));
            生活機能1リスト.add(get名称12(business.get一次判定結果情報().get整髪()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().get上衣の着脱()));
            生活機能1リスト.add(get名称10(business.get一次判定結果情報().getズボン等の着脱()));
            生活機能1リスト.add(get名称13(business.get一次判定結果情報().get外出頻度()));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get移乗()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get移動()));
            生活機能1リスト.add(get名称11(business.get一次判定結果情報().getえん下()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get食事摂取()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get排尿()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get排便()));
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get口腔清潔()));
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get洗顔()));
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get整髪()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get上衣の着脱()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().getズボン等の着脱()));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().get移乗()));
            生活機能1リスト.add(business.get一次判定結果情報().get移動());
            生活機能1リスト.add(get名称31(business.get一次判定結果情報().getえん下()));
            生活機能1リスト.add(get名称33(business.get一次判定結果情報().get食事摂取()));
            生活機能1リスト.add(business.get一次判定結果情報().get排尿());
            生活機能1リスト.add(business.get一次判定結果情報().get排便());
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get口腔清潔()));
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get洗顔()));
            生活機能1リスト.add(get名称22(business.get一次判定結果情報().get整髪()));
            生活機能1リスト.add(get名称34(business.get一次判定結果情報().get上衣の着脱()));
            生活機能1リスト.add(get名称20(business.get一次判定結果情報().getズボン等の着脱()));
            生活機能1リスト.add(business.get一次判定結果情報().get外出頻度());
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(get名称13(business.get一次判定結果情報().get外出頻度()));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能1リスト.add(business.get一次判定結果情報().get外出頻度());
        }
        return 生活機能1リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set生活機能2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能2リスト = new ArrayList<>();
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get移乗(), business.get一次判定結果情報().get前回移乗()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get移動(), business.get一次判定結果情報().get前回移動()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().getえん下(), business.get一次判定結果情報().get前回えん下()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get食事摂取(), business.get一次判定結果情報().get前回食事摂取()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get排尿(), business.get一次判定結果情報().get前回排尿()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get排便(), business.get一次判定結果情報().get前回排便()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get口腔清潔(), business.get一次判定結果情報().get前回口腔清潔()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get洗顔(), business.get一次判定結果情報().get前回洗顔()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get整髪(), business.get一次判定結果情報().get前回整髪()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get上衣の着脱(), business.get一次判定結果情報().get前回上衣の着脱()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().getズボン等の着脱(), business.get一次判定結果情報().get前回ズボン等の着脱()));
        生活機能2リスト.add(get状況改善(business.get一次判定結果情報().get外出頻度(), business.get一次判定結果情報().get前回外出頻度()));
        return 生活機能2リスト;
    }

    /**
     * 主治医意見書項目2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set生活機能3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能3リスト = new ArrayList<>();
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get移乗(), business.get一次判定結果情報().get前回移乗()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get移動(), business.get一次判定結果情報().get前回移動()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().getえん下(), business.get一次判定結果情報().get前回えん下()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get食事摂取(), business.get一次判定結果情報().get前回食事摂取()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get排尿(), business.get一次判定結果情報().get前回排尿()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get排便(), business.get一次判定結果情報().get前回排便()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get口腔清潔(), business.get一次判定結果情報().get前回口腔清潔()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get洗顔(), business.get一次判定結果情報().get前回洗顔()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get整髪(), business.get一次判定結果情報().get前回整髪()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get上衣の着脱(), business.get一次判定結果情報().get前回上衣の着脱()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().getズボン等の着脱(), business.get一次判定結果情報().get前回ズボン等の着脱()));
        生活機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get外出頻度(), business.get一次判定結果情報().get前回外出頻度()));
        return 生活機能3リスト;
    }

    /**
     * 主治医意見書項目4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目4リスト
     */
    public List<RString> set生活機能4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        RString 結果印刷有無 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate());
        if (差分のみ印刷.equals(結果印刷有無)) {
            return 生活機能(business);
        }
        if (印刷しない.equals(結果印刷有無)) {
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
        if (印刷する.equals(結果印刷有無)) {
            if (識別コード09B.equals(厚労省IF識別コード)
                    || 識別コード09A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get移乗()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get移動()));
                生活機能4リスト.add(get名称11(business.get一次判定結果情報().getえん下()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get食事摂取()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get排尿()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get排便()));
                生活機能4リスト.add(get名称12(business.get一次判定結果情報().get口腔清潔()));
                生活機能4リスト.add(get名称12(business.get一次判定結果情報().get洗顔()));
                生活機能4リスト.add(get名称12(business.get一次判定結果情報().get整髪()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().get上衣の着脱()));
                生活機能4リスト.add(get名称10(business.get一次判定結果情報().getズボン等の着脱()));
                生活機能4リスト.add(get名称13(business.get一次判定結果情報().get外出頻度()));
            }
            if (識別コード06A.equals(厚労省IF識別コード)
                    || 識別コード02A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get移乗()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get移動()));
                生活機能4リスト.add(get名称11(business.get一次判定結果情報().getえん下()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get食事摂取()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get排尿()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get排便()));
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get口腔清潔()));
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get洗顔()));
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get整髪()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get上衣の着脱()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().getズボン等の着脱()));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().get移乗()));
                生活機能4リスト.add(business.get一次判定結果情報().get移動());
                生活機能4リスト.add(get名称31(business.get一次判定結果情報().getえん下()));
                生活機能4リスト.add(get名称33(business.get一次判定結果情報().get食事摂取()));
                生活機能4リスト.add(business.get一次判定結果情報().get排尿());
                生活機能4リスト.add(business.get一次判定結果情報().get排便());
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get口腔清潔()));
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get洗顔()));
                生活機能4リスト.add(get名称22(business.get一次判定結果情報().get整髪()));
                生活機能4リスト.add(get名称34(business.get一次判定結果情報().get上衣の着脱()));
                生活機能4リスト.add(get名称20(business.get一次判定結果情報().getズボン等の着脱()));
                生活機能4リスト.add(business.get一次判定結果情報().get外出頻度());
            }
            if (識別コード06A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(get名称13(business.get一次判定結果情報().get外出頻度()));
            }
            if (識別コード02A.equals(厚労省IF識別コード)) {
                生活機能4リスト.add(business.get一次判定結果情報().get外出頻度());
            }
        }
        return 生活機能4リスト;
    }

    /**
     * 認知機能1リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 認知機能1リスト
     */
    public List<RString> set認知機能1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能1リスト = new ArrayList<>();
        認知機能1リスト.add(get名称14(business.get一次判定結果情報().get意思の伝達()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get毎日の日課を理解()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get生年月日をいう()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get短期記憶()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get自分の名前をいう()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get今の季節を理解()));
        認知機能1リスト.add(get名称15(business.get一次判定結果情報().get場所の理解()));
        認知機能1リスト.add(get名称16(business.get一次判定結果情報().get徘徊()));
        認知機能1リスト.add(get名称16(business.get一次判定結果情報().get外出して戻れない()));
        return 認知機能1リスト;
    }

    /**
     * 認知機能1リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 認知機能1リスト
     */
    public List<RString> set認知機能2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能2リスト = new ArrayList<>();
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get意思の伝達(), business.get一次判定結果情報().get前回意思の伝達()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get毎日の日課を理解(), business.get一次判定結果情報().get前回毎日の日課を理解()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get生年月日をいう(), business.get一次判定結果情報().get前回生年月日をいう()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get短期記憶(), business.get一次判定結果情報().get前回短期記憶()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get自分の名前をいう(), business.get一次判定結果情報().get前回自分の名前をいう()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get今の季節を理解(), business.get一次判定結果情報().get前回今の季節を理解()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get場所の理解(), business.get一次判定結果情報().get前回場所の理解()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get徘徊(), business.get一次判定結果情報().get前回徘徊()));
        認知機能2リスト.add(get状況改善(business.get一次判定結果情報().get外出して戻れない(), business.get一次判定結果情報().get前回外出して戻れない()));
        return 認知機能2リスト;
    }

    /**
     * 認知機能3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 認知機能3リスト
     */
    public List<RString> set認知機能3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能3リスト = new ArrayList<>();
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get意思の伝達(), business.get一次判定結果情報().get前回意思の伝達()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get毎日の日課を理解(), business.get一次判定結果情報().get前回毎日の日課を理解()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get生年月日をいう(), business.get一次判定結果情報().get前回生年月日をいう()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get短期記憶(), business.get一次判定結果情報().get前回短期記憶()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get自分の名前をいう(), business.get一次判定結果情報().get前回自分の名前をいう()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get今の季節を理解(), business.get一次判定結果情報().get前回今の季節を理解()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get場所の理解(), business.get一次判定結果情報().get前回場所の理解()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get徘徊(), business.get一次判定結果情報().get前回徘徊()));
        認知機能3リスト.add(get意見書状況結果(business.get一次判定結果情報().get外出して戻れない(), business.get一次判定結果情報().get前回外出して戻れない()));
        return 認知機能3リスト;
    }

    /**
     * 認知機能4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 認知機能4リスト
     */
    public List<RString> set認知機能4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        RString 結果印刷有無 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate());
        if (差分のみ印刷.equals(結果印刷有無)) {
            return 認知機能(business);
        }
        if (印刷しない.equals(結果印刷有無)) {
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
        if (印刷する.equals(結果印刷有無)) {
            認知機能4リスト.add(get名称14(business.get一次判定結果情報().get意思の伝達()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get毎日の日課を理解()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get生年月日をいう()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get短期記憶()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get自分の名前をいう()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get今の季節を理解()));
            認知機能4リスト.add(get名称15(business.get一次判定結果情報().get場所の理解()));
            認知機能4リスト.add(get名称16(business.get一次判定結果情報().get徘徊()));
            認知機能4リスト.add(get名称16(business.get一次判定結果情報().get外出して戻れない()));
        }
        return 認知機能4リスト;
    }

    private RString get状況改善(RString 今回調査, RString 前回調査) {
        RString 状況改善 = RString.EMPTY;
        if (RString.isNullOrEmpty(前回調査) || RString.isNullOrEmpty(今回調査)) {
            return 状況改善;
        }
        if ((Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private RString get意見書状況結果(RString 今回調査, RString 前回調査) {
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査) || RString.isNullOrEmpty(今回調査)) {
            return RString.EMPTY;
        }

        return new RString(Integer.parseInt(今回調査.toString()) - Integer.parseInt(前回調査.toString()));
    }

    private List<RString> 主治医差分(IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        主治医意見書項目4リスト.add(差分結果(business.get一次判定結果情報().get意見書認知症高齢者自立度(),
                business.get一次判定結果情報().get前回意見書認知症高齢者自立度()).isEmpty() ? RString.EMPTY
                : IkenKomoku03.toValue(business.get一次判定結果情報().get前回意見書認知症高齢者自立度()).get名称());
        主治医意見書項目4リスト.add(差分結果(business.get一次判定結果情報().get短期記憶(),
                business.get一次判定結果情報().get前回短期記憶()).isEmpty() ? RString.EMPTY
                : IkenKomoku04.toValue(business.get一次判定結果情報().get前回短期記憶()).get名称());
        主治医意見書項目4リスト.add(差分結果(business.get一次判定結果情報().get日常の意思決定を行うための認知能力(),
                business.get一次判定結果情報().get前回日常の意思決定を行うための認知能力()).isEmpty() ? RString.EMPTY
                : IkenKomoku05.toValue(business.get一次判定結果情報().get前回日常の意思決定を行うための認知能力()).get名称());
        主治医意見書項目4リスト.add(差分結果(business.get一次判定結果情報().get自分の意思の伝達能力(),
                business.get一次判定結果情報().get前回自分の意思の伝達能力()).isEmpty() ? RString.EMPTY
                : IkenKomoku06.toValue(business.get一次判定結果情報().get前回自分の意思の伝達能力()).get名称());
        主治医意見書項目4リスト.add(差分結果(business.get一次判定結果情報().get食事行為(),
                business.get一次判定結果情報().get前回食事行為()).isEmpty() ? RString.EMPTY
                : IkenKomoku14.toValue(business.get一次判定結果情報().get前回食事行為()).get名称());
        return 主治医意見書項目4リスト;
    }

    private List<RString> 生活機能(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get移乗(), business.get一次判定結果情報().get前回移乗()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回移乗()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get移動(), business.get一次判定結果情報().get前回移動()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回移動()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().getえん下(), business.get一次判定結果情報().get前回えん下()).isEmpty()
                    ? RString.EMPTY : get名称11(business.get一次判定結果情報().get前回えん下()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get食事摂取(), business.get一次判定結果情報().get前回食事摂取()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回食事摂取()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get排尿(), business.get一次判定結果情報().get前回排尿()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回排尿()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get排便(), business.get一次判定結果情報().get前回排便()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回排便()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get口腔清潔(), business.get一次判定結果情報().get前回口腔清潔()).isEmpty()
                    ? RString.EMPTY : get名称12(business.get一次判定結果情報().get前回口腔清潔()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get洗顔(), business.get一次判定結果情報().get前回洗顔()).isEmpty()
                    ? RString.EMPTY : get名称12(business.get一次判定結果情報().get前回洗顔()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get整髪(), business.get一次判定結果情報().get前回整髪()).isEmpty()
                    ? RString.EMPTY : get名称12(business.get一次判定結果情報().get前回整髪()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get上衣の着脱(), business.get一次判定結果情報().get前回上衣の着脱()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回上衣の着脱()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().getズボン等の着脱(), business.get一次判定結果情報().get前回ズボン等の着脱()).isEmpty()
                    ? RString.EMPTY : get名称10(business.get一次判定結果情報().get前回ズボン等の着脱()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get外出頻度(), business.get一次判定結果情報().get前回外出頻度()).isEmpty()
                    ? RString.EMPTY : get名称13(business.get一次判定結果情報().get前回外出頻度()));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set生活機能差分99A(business);
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            return set生活機能差分02A(business);
        }
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分99A(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get移乗(), business.get一次判定結果情報().get前回移乗()).isEmpty()
                ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回移乗()));
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().getえん下(), business.get一次判定結果情報().get前回えん下()).isEmpty()
                ? RString.EMPTY : get名称33(business.get一次判定結果情報().get前回えん下()));
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get食事摂取(), business.get一次判定結果情報().get前回食事摂取()).isEmpty()
                ? RString.EMPTY : get名称33(business.get一次判定結果情報().get前回食事摂取()));
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(RString.EMPTY);
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get口腔清潔(), business.get一次判定結果情報().get前回口腔清潔()).isEmpty()
                ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回口腔清潔()));
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get洗顔(), business.get一次判定結果情報().get前回洗顔()).isEmpty()
                ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回洗顔()));
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get整髪(), business.get一次判定結果情報().get前回整髪()).isEmpty()
                ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回整髪()));
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().get上衣の着脱(), business.get一次判定結果情報().get前回上衣の着脱()).isEmpty()
                ? RString.EMPTY : get名称34(business.get一次判定結果情報().get前回上衣の着脱()));
        生活機能4リスト.add(差分結果(business.get一次判定結果情報().getズボン等の着脱(), business.get一次判定結果情報().get前回ズボン等の着脱()).isEmpty()
                ? RString.EMPTY : get名称34(business.get一次判定結果情報().get前回ズボン等の着脱()));
        生活機能4リスト.add(RString.EMPTY);
        return 生活機能4リスト;
    }

    private List<RString> set生活機能差分02A(IchijiHanteizumiDataBusiness business) {
        List<RString> 生活機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get移乗(), business.get一次判定結果情報().get前回移乗()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回移乗()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get移動(), business.get一次判定結果情報().get前回移動()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回移動()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().getえん下(), business.get一次判定結果情報().get前回えん下()).isEmpty()
                    ? RString.EMPTY : get名称11(business.get一次判定結果情報().get前回えん下()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get食事摂取(), business.get一次判定結果情報().get前回食事摂取()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回食事摂取()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get排尿(), business.get一次判定結果情報().get前回排尿()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回排尿()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get排便(), business.get一次判定結果情報().get前回排便()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回排便()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get口腔清潔(), business.get一次判定結果情報().get前回口腔清潔()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回口腔清潔()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get洗顔(), business.get一次判定結果情報().get前回洗顔()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回洗顔()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get整髪(), business.get一次判定結果情報().get前回整髪()).isEmpty()
                    ? RString.EMPTY : get名称22(business.get一次判定結果情報().get前回整髪()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get上衣の着脱(), business.get一次判定結果情報().get前回上衣の着脱()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回上衣の着脱()));
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().getズボン等の着脱(), business.get一次判定結果情報().get前回ズボン等の着脱()).isEmpty()
                    ? RString.EMPTY : get名称20(business.get一次判定結果情報().get前回ズボン等の着脱()));
        }
        if (識別コード02A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード)) {
            生活機能4リスト.add(差分結果(business.get一次判定結果情報().get外出頻度(), business.get一次判定結果情報().get前回外出頻度()).isEmpty()
                    ? RString.EMPTY : get名称13(business.get一次判定結果情報().get前回外出頻度()));
        }
        return 生活機能4リスト;
    }

    private List<RString> 認知機能(IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get意思の伝達(), business.get一次判定結果情報().get前回意思の伝達()).isEmpty()
                    ? RString.EMPTY : get名称14(business.get一次判定結果情報().get前回意思の伝達()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get毎日の日課を理解(), business.get一次判定結果情報().get前回毎日の日課を理解()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回毎日の日課を理解()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get生年月日をいう(), business.get一次判定結果情報().get前回生年月日をいう()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回生年月日をいう()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get短期記憶(), business.get一次判定結果情報().get前回短期記憶()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回短期記憶()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get自分の名前をいう(), business.get一次判定結果情報().get前回自分の名前をいう()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回自分の名前をいう()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get今の季節を理解(), business.get一次判定結果情報().get前回今の季節を理解()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回今の季節を理解()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get場所の理解(), business.get一次判定結果情報().get前回場所の理解()).isEmpty()
                    ? RString.EMPTY : get名称15(business.get一次判定結果情報().get前回場所の理解()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get徘徊(), business.get一次判定結果情報().get前回徘徊()).isEmpty()
                    ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回徘徊()));
            認知機能4リスト.add(差分結果(business.get一次判定結果情報().get外出して戻れない(), business.get一次判定結果情報().get前回外出して戻れない()).isEmpty()
                    ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回外出して戻れない()));
        }
        return 認知機能4リスト;
    }

    private RString 差分結果(RString 今回調査, RString 前回調査) {
        if (RString.isNullOrEmpty(今回調査) || RString.isNullOrEmpty(前回調査)) {
            return RString.EMPTY;
        }
        if (!今回調査.equals(前回調査)) {
            return 前回調査;
        }
        return RString.EMPTY;
    }

    /**
     * 認知機能リストを設定します。
     *
     * @param list 特記事項番号
     * @param business IchijiHanteizumiDataBusiness
     * @return 認知機能リスト
     */
    public List<RString> set認知機能リスト(List<RString> list, IchijiHanteizumiDataBusiness business) {
        List<RString> 認知機能リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_301));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_302));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_303));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_304));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_305));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_306));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_307));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_308));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_309));
        }
        if (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_603));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6051));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6052));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6053));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6054));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6055));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_6056));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_710));
            認知機能リスト.add(get特記事項有無(list, 特記事項番号_712));
        }
        return 認知機能リスト;
    }

    private RString get名称01(RString 名称01) {

        if (RString.isNullOrEmpty(名称01)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser01.toValue(名称01).get名称();
        }
    }

    private RString get名称03(RString 名称03) {

        if (RString.isNullOrEmpty(名称03)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser03.toValue(名称03).get名称();
        }
    }

    private RString get名称14(RString 名称14) {

        if (RString.isNullOrEmpty(名称14)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser14.toValue(名称14).get名称();
        }
    }

    private RString get名称15(RString 名称15) {

        if (RString.isNullOrEmpty(名称15)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser15.toValue(名称15).get名称();
        }
    }

    private RString get名称16(RString 名称16) {

        if (RString.isNullOrEmpty(名称16)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser16.toValue(名称16).get名称();
        }
    }

    private RString get名称22(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser22.toValue(名称22).get名称();
        }
    }

    private RString get名称10(RString 名称07) {

        if (RString.isNullOrEmpty(名称07)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser10.toValue(名称07).get名称();
        }
    }

    private RString get名称20(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser20.toValue(名称22).get名称();
        }
    }

    private RString get名称11(RString 名称07) {

        if (RString.isNullOrEmpty(名称07)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser11.toValue(名称07).get名称();
        }
    }

    private RString get名称31(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser31.toValue(名称22).get名称();
        }
    }

    private RString get名称33(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser33.toValue(名称22).get名称();
        }
    }

    private RString get名称12(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser12.toValue(名称22).get名称();
        }
    }

    private RString get名称34(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser34.toValue(名称22).get名称();
        }
    }

    private RString get名称13(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser13.toValue(名称22).get名称();
        }
    }

    private RString get名称17(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser17.toValue(名称22).get名称();
        }
    }
}
