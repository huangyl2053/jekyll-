/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyouRisutoSyuturyokuEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku.HanyouRisutoSyuturyokuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト出力(高額介護サービス費状況)のCSVEntityEditorです。
 *
 * @reamsid_L DBC-3092-020 sunhui
 */
public class HanyoListKogakuKaigoEucCsvEntityEditor {

    private final RString 住所地特例状態_住特 = new RString("住特");
    private static final RString 入所施設種類_11 = new RString("11");
    private static final RString 入所施設種類_12 = new RString("12");
    private static final RString 入所施設種類_21 = new RString("21");
    private static final RString 取得コード種別 = new RString("0007");
    private static final RString 喪失事由コード種別 = new RString("0010");
    private static final RString RST_月 = new RString("月");
    private static final RString RST_生 = new RString("生");
    private static final RString RST_市 = new RString("市");
    private static final RString RST_低 = new RString("低");
    private static final RString RST_老 = new RString("老");
    private static final RString RST_2 = new RString("2");
    private static final RString RST_緩１ = new RString("緩１");
    private static final RString RST_緩２ = new RString("緩２");
    private static final RString RST_般 = new RString("般");
    private static final RString RST_現 = new RString("現");
    private static final RString RST_第１ = new RString("第１");
    private static final RString RST_第２ = new RString("第２");
    private static final RString RST_第３ = new RString("第３");
    private static final RString RST_第４ = new RString("第４");
    private static final RString RST_第５ = new RString("第５");
    private static final RString RST_1 = new RString("1");
    private static final RString 償還方法_自 = new RString("自");
    private static final RString 償還方法_申 = new RString("申");
    private static final RString 国保連委託_無し = new RString("受託無し");
    private static final RString 国保連委託_有り = new RString("受託有り");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private final FlexibleDate システム日付;

    /**
     * コンストラクタです。
     */
    public HanyoListKogakuKaigoEucCsvEntityEditor(FlexibleDate システム日付) {
        this.システム日付 = システム日付;
    }

    /**
     * CSVの編集
     *
     * @param entity HanyouRisutoSyuturyokuEntity
     * @param parameter HanyouRisutoSyuturyokuProcessParameter
     * @param 連番 Decimal
     * <p>
     * @return HanyouRisutoSyuturyokuEucCsvEntity
     */
    public HanyouRisutoSyuturyokuEucCsvEntity edit(HanyouRisutoSyuturyokuEntity entity,
            HanyoListKogakuKaigoProcessParameter parameter,
            Decimal 連番) {
        HanyouRisutoSyuturyokuEucCsvEntity csvEntity = new HanyouRisutoSyuturyokuEucCsvEntity();
        csvEntity.set連番(numToRString(連番));
        set宛名(entity, csvEntity, parameter);
        set宛先(entity, csvEntity);
        set口座(entity, csvEntity);
        set入所施設種類(entity, csvEntity, parameter);
        set支給申請(entity, csvEntity, parameter);
        set給付対象者合計(entity, csvEntity, parameter);
        set支給判定結果(entity, csvEntity, parameter);
        set支給審査決定(entity, csvEntity, parameter);
        set給付対象者明細(entity, csvEntity);
        set受給者台帳(entity, csvEntity, parameter);
        csvEntity.set市町村コード(entity.get市町村コード() != null
                ? entity.get市町村コード().getColumnValue()
                : RString.EMPTY);

        Association association = AssociationFinderFactory.createInstance().getAssociation(entity
                .get市町村コード());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        csvEntity.set市町村名(association.get市町村名());
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().getColumnValue());
        csvEntity.set保険者名(地方公共団体.get市町村名());

        csvEntity.set空白(RString.EMPTY);
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        csvEntity.set被保険者番号(被保険者番号 != null
                ? 被保険者番号.getColumnValue()
                : RString.EMPTY);
        RString 資格取得事由コード = entity.get資格取得事由コード();
        if (資格取得事由コード != null && !資格取得事由コード.isEmpty()) {
            RString 略称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(取得コード種別), new Code(資格取得事由コード),
                    FlexibleDate.getNowDate());
            csvEntity.set資格取得事由(略称 != null
                    ? 略称
                    : RString.EMPTY);
        }
        FlexibleDate 資格取得日 = entity.get資格取得年月日();
        csvEntity.set資格取得日(get日付項目(資格取得日, parameter));
        FlexibleDate 資格取得届出日 = entity.get資格取得届出年月日();
        csvEntity.set資格取得届出日(get日付項目(資格取得届出日, parameter));
        RString 喪失事由コード = entity.get資格喪失事由コード();
        if (喪失事由コード != null && !喪失事由コード.isEmpty()) {
            RString 略称 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(喪失事由コード種別), new Code(喪失事由コード),
                    FlexibleDate.getNowDate());
            csvEntity.set喪失事由(略称 != null
                    ? 略称
                    : RString.EMPTY);
        }
        FlexibleDate 資格喪失日 = entity.get資格喪失年月日();
        csvEntity.set資格喪失日(get日付項目(資格喪失日, parameter));
        FlexibleDate 資格喪失届日 = entity.get資格喪失届出年月日();
        csvEntity.set資格取得届出日(get日付項目(資格喪失届日, parameter));
        if (entity.get被保険者区分コード() != null && !entity.get被保険者区分コード().isEmpty()) {
            HihokenshaKubunCode 被保険者区分コード = HihokenshaKubunCode.toValue(entity.get被保険者区分コード());
            csvEntity.set資格区分(被保険者区分コード != null
                    ? 被保険者区分コード.get名称()
                    : RString.EMPTY);
        }
        boolean 住所地特例フラグ = entity.is住所地特例フラグ();
        csvEntity.set住所地特例状態(住所地特例フラグ
                ? 住所地特例状態_住特
                : RString.EMPTY);
        boolean 広域内住所地特例フラグ = entity.is広域内住所地特例フラグ();
        LasdecCode 広住特措置元市町村コード = entity.get広住特措置元市町村コード();
        LasdecCode 市町村コード = entity.get市町村コード();
        HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(
                GyomuBunrui.介護事務);
        HokenshaSummary hokenshaSummary;
        if (広域内住所地特例フラグ) {
            hokenshaSummary = hokenshaList.get(広住特措置元市町村コード);
        } else {
            hokenshaSummary = hokenshaList.get(市町村コード);
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = hokenshaSummary.get証記載保険者番号();
        csvEntity.set資格証記載保険者番号(証記載保険者番号 != null && !証記載保険者番号.isEmpty()
                ? 証記載保険者番号.getColumnValue()
                : RString.EMPTY);

        return csvEntity;
    }

    private void set受給者台帳(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        JigyoshaNo 指定事業者コード = entity.get入所施設コード();
        csvEntity.set指定事業者コード(指定事業者コード != null
                ? 指定事業者コード.getColumnValue()
                : RString.EMPTY);
        FlexibleDate 施設入所日 = entity.get入所年月日();
        csvEntity.set施設入所日(get日付項目(施設入所日, parameter));
        FlexibleDate 施設退所日 = entity.get退所年月日();
        csvEntity.set施設退所日(get日付項目(施設退所日, parameter));

        csvEntity.set受給申請事由(entity.get受給申請事由() != null
                ? entity.get受給申請事由().getColumnValue()
                : RString.EMPTY);
        csvEntity.set受給申請日(get日付項目(entity.get受給申請年月日(), parameter));
        if (entity.get要介護認定状態区分コード() != null && !entity.get要介護認定状態区分コード().isEmpty()) {
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(システム日付, entity.get要介護認定状態区分コード().getColumnValue()).getName());
        }
        csvEntity.set受給認定開始日(get日付項目(entity.get認定有効期間開始日(), parameter));
        csvEntity.set受給認定終了日(get日付項目(entity.get認定有効期間終了日(), parameter));
        csvEntity.set受給認定日(get日付項目(entity.get受給認定日(), parameter));
        csvEntity.set受給旧措置(entity.get旧措置フラグ());
        csvEntity.set受給みなし更新認定(entity.getみなし要介護区分コード() != null
                ? entity.getみなし要介護区分コード().getColumnValue()
                : RString.EMPTY);
        csvEntity.set受給直近事由(entity.get直近異動事由コード() != null
                ? entity.get直近異動事由コード().getColumnValue()
                : RString.EMPTY);
    }

    private void set宛名(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get宛名())) {
            ShikibetsuCode 識別コード = entity.get宛名().getShikibetsuCode();
            csvEntity.set識別コード(識別コード != null
                    ? 識別コード.getColumnValue()
                    : RString.EMPTY);
            csvEntity.set住民種別(entity.get宛名().getJuminShubetsuCode());
            AtenaMeisho 漢字氏名 = entity.get宛名().getKanjiShimei();
            csvEntity.set氏名(漢字氏名 != null
                    ? 漢字氏名.getColumnValue()
                    : RString.EMPTY);
            AtenaKanaMeisho 氏名カナ = entity.get宛名().getKanaShimei();
            csvEntity.set氏名カナ(氏名カナ != null
                    ? 氏名カナ.getColumnValue()
                    : RString.EMPTY);
            FlexibleDate 生年月日 = entity.get宛名().getSeinengappiYMD();
            csvEntity.set生年月日(get日付項目(生年月日, parameter));
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(),
                    宛名.get消除異動年月日());
            csvEntity.set年齢(ageCalculator.get年齢());
            if (宛名.get性別() != null) {
                csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
            }
            TsuzukigaraCode 続柄コード = entity.get宛名().getTsuzukigaraCode();
            csvEntity.set続柄コード(続柄コード != null
                    ? 続柄コード.getColumnValue()
                    : RString.EMPTY);
            SetaiCode 世帯コード = entity.get宛名().getSetaiCode();
            csvEntity.set世帯コード(世帯コード != null
                    ? 世帯コード.getColumnValue()
                    : RString.EMPTY);
            AtenaMeisho 世帯主名 = entity.get宛名().getSetainushiMei();
            csvEntity.set世帯主名(世帯主名 != null
                    ? 世帯主名.getColumnValue()
                    : RString.EMPTY);
            ZenkokuJushoCode 住所コード = entity.get宛名().getZenkokuJushoCode();
            csvEntity.set住所コード(住所コード != null
                    ? 住所コード.getColumnValue()
                    : RString.EMPTY);
            YubinNo 郵便番号 = entity.get宛名().getYubinNo();
            csvEntity.set郵便番号(郵便番号 != null
                    ? 郵便番号.getColumnValue()
                    : RString.EMPTY);
            AtenaJusho 住所 = entity.get宛名().getJusho();
            csvEntity.set住所(住所 != null
                    ? 住所.getColumnValue()
                    : RString.EMPTY);
            AtenaBanchi 番地 = entity.get宛名().getBanchi();
            csvEntity.set番地(番地 != null
                    ? 番地.getColumnValue()
                    : RString.EMPTY);
            Katagaki 方書 = entity.get宛名().getKatagaki();
            csvEntity.set方書(方書 != null
                    ? 方書.getColumnValue()
                    : RString.EMPTY);
            csvEntity.set住所と番地と方書((住所 != null
                    ? 住所.getColumnValue()
                    : RString.EMPTY)
                    .concat(番地 != null
                            ? 番地.getColumnValue()
                            : RString.EMPTY)
                    .concat(RString.FULL_SPACE)
                    .concat(方書 != null
                            ? 方書.getColumnValue()
                            : RString.EMPTY));
            set宛名(entity, csvEntity);
        }
    }

    private void set宛名(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {
        set地区(entity, csvEntity);
        GyoseikuCode 行政区コード = entity.get宛名().getGyoseikuCode();
        csvEntity.set行政区コード(行政区コード != null
                ? 行政区コード.getColumnValue()
                : RString.EMPTY);
        csvEntity.set行政区名(entity.get宛名().getGyoseikuName());
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        TelNo 連絡先１ = entity.get宛名().getRenrakusaki1();
        csvEntity.set連絡先１(連絡先１ != null
                ? 連絡先１.getColumnValue()
                : RString.EMPTY);
        TelNo 連絡先２ = entity.get宛名().getRenrakusaki2();
        csvEntity.set連絡先２(連絡先２ != null
                ? 連絡先２.getColumnValue()
                : RString.EMPTY);
        IIdoJiyu 登録事由 = 宛名.get登録事由();
        IIdoJiyu 住定事由 = 宛名.get住定事由();
        IIdoJiyu 消除事由 = 宛名.get消除事由();
        FlexibleDate 登録異動日 = entity.get宛名().getTorokuIdoYMD();
        csvEntity.set登録異動日(登録異動日 != null
                ? new RString(登録異動日.toString())
                : RString.EMPTY);
        csvEntity.set登録事由(登録事由 != null
                ? 登録事由.get異動事由略称()
                : RString.EMPTY);
        FlexibleDate 登録届出日 = entity.get宛名().getTorokuTodokedeYMD();
        csvEntity.set登録届出日(登録届出日 != null
                ? new RString(登録届出日.toString())
                : RString.EMPTY);
        FlexibleDate 住定異動日 = entity.get宛名().getJuteiIdoYMD();
        csvEntity.set住定異動日(住定異動日 != null
                ? new RString(住定異動日.toString())
                : RString.EMPTY);
        csvEntity.set住定事由(住定事由 != null
                ? 住定事由.get異動事由略称()
                : RString.EMPTY);
        FlexibleDate 住定届出日 = entity.get宛名().getJuteiTodokedeYMD();
        csvEntity.set住定届出日(住定届出日 != null
                ? new RString(住定届出日.toString())
                : RString.EMPTY);
        FlexibleDate 消除異動日 = entity.get宛名().getShojoIdoYMD();
        csvEntity.set消除異動日(消除異動日 != null
                ? new RString(消除異動日.toString())
                : RString.EMPTY);
        csvEntity.set消除事由(登録事由 != null
                ? 消除事由.get異動事由略称()
                : RString.EMPTY);
        FlexibleDate 消除届出日 = entity.get宛名().getShojoTodokedeYMD();
        csvEntity.set消除届出日(消除届出日 != null
                ? new RString(消除届出日.toString())
                : RString.EMPTY);
        //  TODO 宛名・本人・は不明です
        csvEntity.set転出入理由(RString.EMPTY);
        YubinNo 前住所郵便番号 = entity.get宛名().getTennyumaeYubinNo();
        csvEntity.set前住所郵便番号(前住所郵便番号 != null
                ? 前住所郵便番号.getColumnValue()
                : RString.EMPTY);

    }

    private void set地区(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {
        AtenaJusho 前住所 = entity.get宛名().getTennyumaeJusho();
        csvEntity.set前住所(前住所 != null
                ? 前住所.getColumnValue()
                : RString.EMPTY);
        AtenaBanchi 前住所番地 = entity.get宛名().getTennyumaeBanchi();
        csvEntity.set前住所番地(前住所番地 != null
                ? 前住所番地.getColumnValue()
                : RString.EMPTY);
        Katagaki 前住所方書 = entity.get宛名().getTennyumaeKatagaki();
        csvEntity.set前住所方書(前住所方書 != null
                ? 前住所方書.getColumnValue()
                : RString.EMPTY);
        csvEntity.set前住所と番地と方書((前住所 != null
                ? 前住所.getColumnValue()
                : RString.EMPTY)
                .concat(前住所番地 != null
                        ? 前住所番地.getColumnValue()
                        : RString.EMPTY)
                .concat(RString.FULL_SPACE)
                .concat(前住所方書 != null
                        ? 前住所方書.getColumnValue()
                        : RString.EMPTY));
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        RString 地区1 = RString.EMPTY;
        RString 地区2 = RString.EMPTY;
        RString 地区3 = RString.EMPTY;
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku1() != null) {
            地区1 = 宛名.get行政区画().getChiku1().get名称();
        }
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku2() != null) {
            地区2 = 宛名.get行政区画().getChiku2().get名称();
        }
        if (宛名.get行政区画() != null && 宛名.get行政区画().getChiku3() != null) {
            地区3 = 宛名.get行政区画().getChiku3().get名称();
        }
        csvEntity.set地区１(地区1);
        csvEntity.set地区２(地区2);
        csvEntity.set地区３(地区3);
    }

    private void set宛先(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {

        UaFt250FindAtesakiEntity 宛先 = entity.get宛先();
        if (isNotNull(宛先)) {
            AtenaMeisho 送付先氏名 = 宛先.getKanjiShimei();
            csvEntity.set送付先氏名(送付先氏名 != null
                    ? 送付先氏名.getColumnValue()
                    : RString.EMPTY);
            AtenaKanaMeisho 送付先氏名カナ = 宛先.getKanaShimei();
            csvEntity.set送付先氏名カナ(送付先氏名カナ != null
                    ? 送付先氏名カナ.getColumnValue()
                    : RString.EMPTY);
            ZenkokuJushoCode 送付先住所コード = 宛先.getZenkokuJushoCode();
            csvEntity.set送付先住所コード(送付先住所コード != null
                    ? 送付先住所コード.getColumnValue()
                    : RString.EMPTY);
            YubinNo 送付先郵便番号 = 宛先.getYubinNo();
            csvEntity.set送付先郵便番号(送付先郵便番号 != null
                    ? 送付先郵便番号.getColumnValue()
                    : RString.EMPTY);
            AtenaJusho 送付先住所 = 宛先.getJusho();
            csvEntity.set送付先住所(送付先住所コード != null
                    ? 送付先住所コード.getColumnValue()
                    : RString.EMPTY);
            AtenaBanchi 送付先番地 = 宛先.getBanchi();
            csvEntity.set送付先番地(送付先番地 != null
                    ? 送付先番地.getColumnValue()
                    : RString.EMPTY);
            Katagaki 送付先方書 = 宛先.getKatagaki();
            csvEntity.set送付先方書(送付先方書 != null
                    ? 送付先方書.getColumnValue()
                    : RString.EMPTY);
            csvEntity.set送付先住所と番地と方書((送付先住所 != null
                    ? 送付先住所.getColumnValue()
                    : RString.EMPTY)
                    .concat(送付先番地 != null
                            ? 送付先番地.getColumnValue()
                            : RString.EMPTY)
                    .concat(RString.FULL_SPACE)
                    .concat(送付先方書 != null
                            ? 送付先方書.getColumnValue()
                            : RString.EMPTY));
            GyoseikuCode 送付先行政区コード = 宛先.getGyoseikuCode();
            csvEntity.set送付先行政区コード(送付先行政区コード != null
                    ? 送付先行政区コード.getColumnValue()
                    : RString.EMPTY);
            csvEntity.set送付先行政区名(宛先.getGyoseiku());
        }
    }

    private void set口座(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {
        if (entity.get口座情報() != null && entity.get口座情報().getUaT0310KozaEntity() != null
                && (entity.get口座情報().getKinyuKikanEntity() != null || !entity.get口座情報()
                .getKinyuKikanEntity().isEmpty())
                && (entity.get口座情報().getUrT0700ShunoKanriEntity() != null || !entity.get口座情報()
                .getUrT0700ShunoKanriEntity().isEmpty())) {
            KozaRelateEntity releteEntity = entity.get口座情報();
            IKoza 口座 = new Koza(releteEntity);
            if (口座.isゆうちょ銀行()) {
                csvEntity.set銀行郵便区分(RST_2);
                csvEntity.set支店コード(口座.get店番());
            } else {
                csvEntity.set銀行郵便区分(RST_1);
                KinyuKikanShitenCode 支店コード = 口座.get支店コード();
                csvEntity.set支店コード(支店コード != null
                        ? 支店コード.getColumnValue()
                        : RString.EMPTY);
            }
            KinyuKikanCode 銀行コード = 口座.get金融機関コード();
            KinyuKikan 金融機関 = 口座.get金融機関();
            KinyuKikanShiten 支店 = 口座.get支店();
            csvEntity.set銀行コード(銀行コード != null
                    ? 銀行コード.getColumnValue()
                    : RString.EMPTY);
            csvEntity.set銀行名カナ(金融機関 != null
                    ? 金融機関.get金融機関カナ名称()
                    : RString.EMPTY);
            csvEntity.set銀行名(金融機関 != null
                    ? 金融機関.get金融機関名称()
                    : RString.EMPTY);
            csvEntity.set支店名カナ(支店 != null
                    ? 支店.get支店カナ名称()
                    : RString.EMPTY);
            csvEntity.set支店名(支店 != null
                    ? 支店.get支店名称()
                    : RString.EMPTY);
            YokinShubetsuPattern 口座種目 = 口座.get預金種別();
            csvEntity.set口座種目(口座種目 != null
                    ? 口座種目.get預金種別名称()
                    : RString.EMPTY);
            csvEntity.set口座番号(口座.get口座番号());
            csvEntity.set名義人カナ短(RString.EMPTY);
            csvEntity.set名義人短(RString.EMPTY);
            AtenaKanaMeisho 名義人カナ = 口座.get口座名義人();
            csvEntity.set名義人カナ(名義人カナ != null
                    ? 名義人カナ.getColumnValue()
                    : RString.EMPTY);
            AtenaMeisho 名義人 = 口座.get口座名義人漢字();
            csvEntity.set名義人(名義人 != null
                    ? 名義人.getColumnValue()
                    : RString.EMPTY);
        }

    }

    private void set入所施設種類(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (入所施設種類_11.equals(entity.get入所施設種類())) {
            set介護保険施設(entity, csvEntity, parameter);
        } else if (入所施設種類_12.equals(entity.get入所施設種類()) || 入所施設種類_21.equals(entity.get入所施設種類())) {
            csvEntity.set指定事業者名(entity.get事業者名称_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get事業者名称_05().getColumnValue());
            csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get事業者名称カナ_05().getColumnValue());
            csvEntity.set指定事業者郵便番号(entity.get郵便番号_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get郵便番号_05().getColumnValue());
            csvEntity.set指定事業者住所(entity.get事業者住所_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get事業者住所_05().getColumnValue());
            csvEntity.set指定事業者代表者名(entity.get代表者名_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get代表者名_05().getColumnValue());
            csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get代表者名カナ_05().getColumnValue());
            csvEntity.set指定事業者代表者役職(entity.get役職_05());
            csvEntity.set指定事業者電話番号(entity.get電話番号_05().isEmpty()
                    ? RString.EMPTY
                    : entity.get電話番号_05().getColumnValue());
            csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_05().isEmpty()
                    ? RString.EMPTY
                    : entity.getFax番号_05().getColumnValue());
            csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            csvEntity.set指定事業者利用者数(RString.EMPTY);
            csvEntity.set指定事業者認定日(get日付項目(entity.get有効開始日_05(), parameter));
            csvEntity.set指定事業者取消日(get日付項目(entity.get有効終了日_05(), parameter));
            csvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private void set介護保険施設(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        csvEntity.set指定事業者名(entity.get事業者名称_60().isEmpty()
                ? RString.EMPTY
                : entity.get事業者名称_60().getColumnValue());
        csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_60().isEmpty()
                ? RString.EMPTY
                : entity.get事業者名称カナ_60().getColumnValue());
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_60().isEmpty()
                ? RString.EMPTY
                : entity.get郵便番号_60().getColumnValue());
        csvEntity.set指定事業者住所(entity.get事業者住所_60().isEmpty()
                ? RString.EMPTY
                : entity.get事業者住所_60().getColumnValue());
        csvEntity.set指定事業者代表者名(entity.get代表者名_62().isEmpty()
                ? RString.EMPTY
                : entity.get代表者名_62().getColumnValue());
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_62().isEmpty()
                ? RString.EMPTY
                : entity.get代表者名カナ_62().getColumnValue());
        csvEntity.set指定事業者代表者役職(entity.get代表者役職名_62());
        csvEntity.set指定事業者電話番号(entity.get電話番号_60().isEmpty()
                ? RString.EMPTY
                : entity.get電話番号_60().getColumnValue());
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_60().isEmpty()
                ? RString.EMPTY
                : entity.getFax番号_60().getColumnValue());
        csvEntity.set指定事業者ケアマネ数(numToRString(entity.get所属人数()));
        csvEntity.set指定事業者利用者数(numToRString(entity.get利用者数()));
        csvEntity.set指定事業者認定日(get日付項目(entity.get有効開始日_60(), parameter));
        csvEntity.set指定事業者取消日(get日付項目(entity.get有効終了日_60(), parameter));
        csvEntity.set指定事業者実施地域(entity.getサービス実施地域_60());
    }

    private void set支給申請(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (entity != null) {
            csvEntity.set支払場所(entity.get支払場所());
            FlexibleDate 支払開始日 = entity.get支払期間開始年月日();
            csvEntity.set支払開始日(get日付項目(支払開始日, parameter));
            FlexibleDate 支払終了日 = entity.get支払期間終了年月日();
            csvEntity.set支払終了日(get日付項目(支払終了日, parameter));
            csvEntity.set支払開始曜日(convertDayOfWeek(支払開始日));
            csvEntity.set支払終了曜日(convertDayOfWeek(支払終了日));
            csvEntity.set支払開始時間(entity.get支払窓口開始時間());
            csvEntity.set支払終了時間(entity.get支払窓口終了時間());
            csvEntity.setサービス提供年月(get年月(entity.getサービス提供年月(), parameter));
            Decimal 履歴番号 = entity.get履歴番号();
            csvEntity.set管理番号(履歴番号 != null
                    ? new RString(履歴番号.toString())
                    : RString.EMPTY);
            HokenshaNo 証記載保険者番号 = entity.get証記載保険者番号();
            csvEntity.set給付証記載保険者番号(証記載保険者番号 != null && !証記載保険者番号.isEmpty()
                    ? entity.get証記載保険者番号().getColumnValue()
                    : RString.EMPTY);
            FlexibleDate 申請日 = entity.get申請年月日();
            csvEntity.set申請日(申請日 != null
                    ? new RString(申請日.toString())
                    : RString.EMPTY);
            csvEntity.set申請理由(entity.get申請理由());
            csvEntity.set申請区分(entity.get申請者区分());
            AtenaMeisho 申請氏名 = entity.get申請者氏名();
            csvEntity.set申請氏名(申請氏名 != null
                    ? 申請氏名.getColumnValue()
                    : RString.EMPTY);
            AtenaKanaMeisho 申請氏名カナ = entity.get申請者氏名カナ();
            csvEntity.set申請氏名カナ(申請氏名カナ != null
                    ? 申請氏名カナ.getColumnValue()
                    : RString.EMPTY);
            TelNo 申請者電話番号 = entity.get申請者電話番号();
            csvEntity.set申請電話番号(申請者電話番号 != null && !申請者電話番号.isEmpty()
                    ? entity.get申請者電話番号().getColumnValue()
                    : RString.EMPTY);
            FlexibleDate 受付日 = entity.get受付年月日();
            csvEntity.set受付日(get日付項目(受付日, parameter));
            RString 支払方法区分コード = entity.get支払方法区分コード();
            if (支払方法区分コード != null && !支払方法区分コード.isEmpty()) {
                ShiharaiHohoKubun 支払方法区分 = ShiharaiHohoKubun.toValue(支払方法区分コード);
                csvEntity.set支払方法(支払方法区分 != null
                        ? 支払方法区分.get名称()
                        : RString.EMPTY);
            }
        }
    }

    private RString convertDayOfWeek(FlexibleDate targetDate) {
        return targetDate != null
                && targetDate.isValid()
                ? new RString(targetDate.getDayOfWeek().toString())
                : RString.EMPTY;
    }

    private void set給付対象者合計(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {
        if (entity != null) {
            csvEntity.set申請支払額(numToRString(entity.get合計_高額支給額()));
            csvEntity.set判定費用額(numToRString(entity.getサービス費用合計額合計()));
            csvEntity.set判定利用負担額(numToRString(entity.get利用者負担額合計()));
            csvEntity.set判定算定基準額(numToRString(entity.get算定基準額()));
            csvEntity.set判定支払済金額(numToRString(entity.get支払済金額合計()));
            csvEntity.set判定高額支給額(numToRString(entity.get合計_高額支給額()));
            FlexibleYearMonth 判定受取年月 = entity.get対象者受取年月();
            csvEntity.set判定受取年月(get年月(判定受取年月, parameter));
            FlexibleYearMonth 高額対象判定年月 = entity.get対象者判定審査年月();
            csvEntity.set高額対象判定年月(get年月(高額対象判定年月, parameter));
        }
    }

    private void set支給判定結果(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {
        if (entity != null) {
            FlexibleDate 決定日 = entity.get決定年月日();
            csvEntity.set決定日(get日付項目(決定日, parameter));
            Decimal 保決定利用負担額 = entity.get本人支払額();
            csvEntity.set保決定利用負担額(保決定利用負担額 != null
                    ? numToRString(保決定利用負担額)
                    : RString.EMPTY);
            csvEntity.set保決定支給区分(entity.get判定_支給区分コード());
            Decimal 保決定高額支給額 = entity.get支給金額();
            csvEntity.set保決定高額支給額(保決定高額支給額 != null
                    ? numToRString(保決定高額支給額)
                    : RString.EMPTY);
            csvEntity.set保決定不支給理由(entity.get不支給理由());
            csvEntity.set審査方法(entity.get審査方法区分());
            FlexibleYearMonth 保決定送付年月 = entity.get判定結果送付年月();
            csvEntity.set保決定送付年月(get年月(保決定送付年月, parameter));
            FlexibleDate 通知書作成日 = entity.get決定通知書作成年月日();
            csvEntity.set通知書作成日(get日付項目(通知書作成日, parameter));
            FlexibleDate 振込書作成日 = entity.get振込通知書作成年月日();
            csvEntity.set振込書作成日(get日付項目(振込書作成日, parameter));
        }
    }

    private void set支給審査決定(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {
        if (entity != null) {
            FlexibleYearMonth 国決定年月 = entity.get決定年月();
            csvEntity.set国決定年月(get年月(国決定年月, parameter));
            csvEntity.set国決定通知書ＮＯ(entity.get通知書番号());
            Decimal 国決定利用負担額 = entity.get利用者負担額();
            csvEntity.set国決定利用負担額(numToRString(国決定利用負担額));
            csvEntity.set国決定支給区分(
                    entity.get決定_支給区分コード() != null
                    && entity.get決定_支給区分コード().toString().equals("1")
                    ? ShikyuKubun.支給.get名称()
                    : RString.EMPTY);
            Decimal 国決定高額支給額 = entity.get決定_高額支給額();
            csvEntity.set国決定高額支給額(numToRString(国決定高額支給額));
            FlexibleYearMonth 国決定受取年月 = entity.get決定者受取年月();
            csvEntity.set国決定受取年月(get年月(国決定受取年月, parameter));
        }
    }

    private void set給付対象者明細(HanyouRisutoSyuturyokuEntity entity,
            HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {

        if (entity != null) {
            csvEntity.set備考算定基準(entity.get高額給付根拠());
            RString 国保連委託なし = DbBusinessConfig.get(ConfigNameDBC.国保連共同処理受託区分_高額, RDate.getNowDate(),
                    SubGyomuCode.DBC介護給付);
            if (RST_1.equals(国保連委託なし)) {
                csvEntity.set国保連委託なし(国保連委託_無し);
            } else if (RST_2.equals(国保連委託なし)) {
                csvEntity.set国保連委託なし(国保連委託_有り);
            } else {
                csvEntity.set国保連委託なし(RString.EMPTY);
            }
            if (entity.is自動償還対象フラグ()) {
                csvEntity.set高額自動償還(償還方法_自);
            } else {
                csvEntity.set高額自動償還(償還方法_申);
            }
            csvEntity.set利用者負担段階(get高額給付根拠(entity.get高額給付根拠()));
        }
    }

    private boolean isNotNull(Object object) {
        return object != null;
    }

    private RString get日付項目(FlexibleDate 生年月日, HanyoListKogakuKaigoProcessParameter parameter) {
        if (生年月日 == null || 生年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.isHizukeHeshu()) {
            return 生年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        } else {
            return 生年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString get年月(FlexibleYearMonth 年月, HanyoListKogakuKaigoProcessParameter parameter) {
        if (年月 == null || 年月.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.isHizukeHeshu()) {
            return 年月.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        } else {
            return 年月.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString numToRString(Decimal 項目) {
        if (項目 == null) {
            return RString.EMPTY;
        }
        return new RString(項目.toString());
    }

    private RString get高額給付根拠(RString 高額給付根拠) {

        RString 世帯の所得区分コード;
        RString 本人の所得区分コード;
        RString 老齢福祉年金受給の有無;
        if (高額給付根拠 == null || 高額給付根拠.trim().isEmpty()) {
            return RString.EMPTY;
        } else {
            List<RString> list = 高額給付根拠.toRStringList();

            if (list.size() >= INDEX_1 && (list.get(INDEX_0).equals(RST_月)
                    || list.get(INDEX_0).equals(RString.EMPTY))) {
                世帯の所得区分コード = list.size() >= INDEX_2
                        ? list.get(INDEX_1)
                        : RString.EMPTY;
                本人の所得区分コード = list.size() >= INDEX_3
                        ? list.get(INDEX_2)
                        : RString.EMPTY;
                老齢福祉年金受給の有無 = list.size() >= INDEX_5
                        ? list.get(INDEX_4)
                        : RString.EMPTY;
            } else {
                世帯の所得区分コード = list.size() >= INDEX_1
                        ? list.get(INDEX_0)
                        : RString.EMPTY;
                本人の所得区分コード = list.size() >= INDEX_2
                        ? list.get(INDEX_1)
                        : RString.EMPTY;
                老齢福祉年金受給の有無 = list.size() >= INDEX_4
                        ? list.get(INDEX_3)
                        : RString.EMPTY;
            }

            if (RST_生.equals(本人の所得区分コード)) {
                return RST_第１;
            } else {
                if (RST_市.equals(世帯の所得区分コード)) {
                    return get市(老齢福祉年金受給の有無);
                } else if (RST_低.equals(世帯の所得区分コード)) {
                    return get低(老齢福祉年金受給の有無);
                } else if (RST_般.equals(世帯の所得区分コード)) {
                    return RST_第４;
                } else if (RST_現.equals(世帯の所得区分コード)) {
                    return RST_第５;
                } else {
                    return RString.EMPTY;
                }
            }
        }
    }

    private RString get市(RString 老齢福祉年金受給の有無) {

        if (RST_老.equals(老齢福祉年金受給の有無)) {
            return RST_第１;
        } else if (RST_2.equals(老齢福祉年金受給の有無)) {
            return RST_第２;
        } else {
            return RST_第３;
        }
    }

    private RString get低(RString 老齢福祉年金受給の有無) {

        if (RST_緩１.equals(老齢福祉年金受給の有無)) {
            return RST_第２;
        } else if (RST_緩２.equals(老齢福祉年金受給の有無)) {
            return RST_第３;
        } else {
            return RST_第４;
        }
    }
}
