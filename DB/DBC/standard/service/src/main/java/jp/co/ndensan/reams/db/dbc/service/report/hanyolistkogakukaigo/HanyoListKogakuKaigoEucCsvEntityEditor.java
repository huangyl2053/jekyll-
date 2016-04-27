/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.hanyolistkogakukaigo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyourisutosyuturyoku.HanyoListKogakuKaigoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyouRisutoSyuturyokuEucCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyourisutosyuturyoku.HanyouRisutoSyuturyokuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * @reamsid_L DBC-2820-010 sunhui
 */
public class HanyoListKogakuKaigoEucCsvEntityEditor {

    private final RString 全角空白 = new RString("　");
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
    private static final RString RST_2 = new RString("２");
    private static final RString RST_緩１ = new RString("緩１");
    private static final RString RST_緩２ = new RString("緩２");
    private static final RString RST_般 = new RString("般");
    private static final RString RST_現 = new RString("現");
    private static final RString RST_第１ = new RString("第１");
    private static final RString RST_第２ = new RString("第２");
    private static final RString RST_第３ = new RString("第３");
    private static final RString RST_第４ = new RString("第４");
    private static final RString RST_第５ = new RString("第５");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;

    /**
     * コンストラクタです。
     */
    public HanyoListKogakuKaigoEucCsvEntityEditor() {
    }

    /**
     * CSVの編集
     *
     * @param entity HanyouRisutoSyuturyokuEntity
     * @param parameter HanyouRisutoSyuturyokuProcessParameter
     * @param 連番 連番
     * @return HanyouRisutoSyuturyokuEucCsvEntity
     */
    public HanyouRisutoSyuturyokuEucCsvEntity edit(HanyouRisutoSyuturyokuEntity entity,
            HanyoListKogakuKaigoProcessParameter parameter, Decimal 連番) {
        HanyouRisutoSyuturyokuEucCsvEntity csvEntity = new HanyouRisutoSyuturyokuEucCsvEntity();
        if (parameter.isRebanFuka()) {
            csvEntity.set連番(numToRString(連番));
        }

        set宛名(entity, csvEntity, parameter);
        set宛先(entity, csvEntity);
        set入所施設種類(entity, csvEntity, parameter);
        set支給申請(entity, csvEntity, parameter);
        set給付対象者合計(entity, csvEntity, parameter);
        set支給判定結果(entity, csvEntity, parameter);
        set支給審査決定(entity, csvEntity, parameter);
        set給付対象者明細(entity, csvEntity);
        set受給者台帳(entity, csvEntity, parameter);
        csvEntity.set市町村コード(entity.get市町村コード() != null
                ? entity.get市町村コード().getColumnValue() : RString.EMPTY);

        Association association = AssociationFinderFactory.createInstance().getAssociation();
        csvEntity.set市町村名(association.get市町村名());
        // TODO 保険者コードと保険者名
        csvEntity.set保険者コード(RString.EMPTY);
        csvEntity.set保険者名(RString.EMPTY);

        csvEntity.set空白(RString.EMPTY);
        HihokenshaNo 被保険者番号 = entity.get被保険者番号();
        csvEntity.set被保険者番号(被保険者番号 != null ? 被保険者番号.getColumnValue() : RString.EMPTY);
        RString 資格取得事由コード = entity.get資格取得事由コード();
        if (資格取得事由コード != null) {
            RString 略称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(取得コード種別), new Code(資格取得事由コード), FlexibleDate.getNowDate());
            csvEntity.set資格取得事由(略称 != null ? 略称 : RString.EMPTY);
        }
        FlexibleDate 資格取得日 = entity.get資格取得年月日();
        csvEntity.set資格取得日(資格取得日 != null ? get日付項目(資格取得日, parameter) : RString.EMPTY);
        FlexibleDate 資格取得届出日 = entity.get資格取得届出年月日();
        csvEntity.set資格取得届出日(資格取得届出日 != null ? get日付項目(資格取得届出日, parameter) : RString.EMPTY);
        RString 喪失事由コード = entity.get資格取得事由コード();
        if (喪失事由コード != null) {
            RString 略称 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付,
                    new CodeShubetsu(喪失事由コード種別), new Code(喪失事由コード), FlexibleDate.getNowDate());
            csvEntity.set喪失事由(略称 != null ? 略称 : RString.EMPTY);
        }
        FlexibleDate 資格喪失日 = entity.get資格喪失年月日();
        csvEntity.set資格喪失日(資格喪失日 != null ? get日付項目(資格喪失日, parameter) : RString.EMPTY);
        FlexibleDate 資格喪失届日 = entity.get資格喪失届出年月日();
        csvEntity.set資格取得届出日(資格喪失届日 != null ? get日付項目(資格喪失届日, parameter) : RString.EMPTY);
        if (entity.get被保険者区分コード() != null) {
            HihokenshaKubunCode 被保険者区分コード = HihokenshaKubunCode.toValue(entity.get被保険者区分コード());
            csvEntity.set資格区分(被保険者区分コード != null ? 被保険者区分コード.get名称() : RString.EMPTY);
        }
        boolean 住所地特例フラグ = entity.is住所地特例フラグ();
        csvEntity.set住所地特例状態(住所地特例フラグ ? 住所地特例状態_住特 : RString.EMPTY);
        boolean 広域内住所地特例フラグ = entity.is広域内住所地特例フラグ();
        LasdecCode 広住特措置元市町村コード = entity.get広住特措置元市町村コード();
        LasdecCode 市町村コード = entity.get市町村コード();
        List<HokenshaSummary> list = new ArrayList<>();
        HokenshaList hokenshaList = HokenshaList.createFor単一(list);
        HokenshaSummary hokenshaSummary;
        if (広域内住所地特例フラグ) {
            hokenshaSummary = hokenshaList.get(広住特措置元市町村コード);
        } else {
            hokenshaSummary = hokenshaList.get(市町村コード);
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = hokenshaSummary.get証記載保険者番号();
        csvEntity.set資格証記載保険者番号(証記載保険者番号 != null ? 証記載保険者番号.getColumnValue() : RString.EMPTY);

        // TODO 89.銀行郵便区分 -- 101.名義人
//        if (koza.isゆうちょ銀行()) {
//            csvEntity.set銀行郵便区分(ゆうちょ);
//        } else {
//            csvEntity.set銀行郵便区分(銀行);
//        }
//        KinyuKikanCode 金融機関コード = koza.get金融機関コード();
//        csvEntity.set銀行コード(金融機関コード != null ? 金融機関コード.getColumnValue() : RString.EMPTY);
        return csvEntity;
    }

    private void set受給者台帳(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        JigyoshaNo 指定事業者コード = entity.get入所施設コード();
        csvEntity.set指定事業者コード(指定事業者コード != null ? 指定事業者コード.getColumnValue() : RString.EMPTY);
        FlexibleDate 施設入所日 = entity.get入所年月日();
        csvEntity.set施設入所日(施設入所日 != null ? get日付項目(施設入所日, parameter) : RString.EMPTY);
        FlexibleDate 施設退所日 = entity.get退所年月日();
        csvEntity.set施設退所日(施設退所日 != null ? get日付項目(施設退所日, parameter) : RString.EMPTY);
        csvEntity.set支払開始曜日(RDate.getNowDate().toDateString());
        csvEntity.set支払終了曜日(RDate.getNowDate().toDateString());
        csvEntity.set受給申請事由(entity.get受給申請事由() != null
                ? entity.get受給申請事由().getColumnValue() : RString.EMPTY);
        csvEntity.set受給申請日(entity.get受給申請年月日() != null
                ? get日付項目(entity.get受給申請年月日(), parameter) : RString.EMPTY);
        csvEntity.set受給要介護度(entity.get要介護認定状態区分コード() != null
                ? entity.get要介護認定状態区分コード().getColumnValue() : RString.EMPTY);
        csvEntity.set受給認定開始日(entity.get認定有効期間開始日() != null
                ? get日付項目(entity.get認定有効期間開始日(), parameter) : RString.EMPTY);
        csvEntity.set受給認定終了日(entity.get認定有効期間終了日() != null
                ? get日付項目(entity.get認定有効期間終了日(), parameter) : RString.EMPTY);
        csvEntity.set受給認定日(entity.get受給認定日() != null
                ? get日付項目(entity.get受給認定日(), parameter) : RString.EMPTY);
        csvEntity.set受給旧措置(entity.is旧措置フラグ());
        csvEntity.set受給みなし更新認定(entity.getみなし要介護区分コード() != null
                ? entity.getみなし要介護区分コード().getColumnValue() : RString.EMPTY);
        csvEntity.set受給直近事由(entity.get直近異動事由コード() != null
                ? entity.get直近異動事由コード().getColumnValue() : RString.EMPTY);
    }

    private void set宛名(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get宛名())) {
            ShikibetsuCode 識別コード = entity.get宛名().getShikibetsuCode();
            csvEntity.set識別コード(識別コード != null ? 識別コード.getColumnValue() : RString.EMPTY);
            csvEntity.set住民種別(entity.get宛名().getJuminShubetsuCode());
            AtenaMeisho 漢字氏名 = entity.get宛名().getKanjiShimei();
            csvEntity.set氏名(漢字氏名 != null ? 漢字氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 氏名カナ = entity.get宛名().getKanaShimei();
            csvEntity.set氏名カナ(氏名カナ != null ? 氏名カナ.getColumnValue() : RString.EMPTY);
            FlexibleDate 生年月日 = entity.get宛名().getSeinengappiYMD();
            csvEntity.set生年月日(生年月日 != null ? get日付項目(生年月日, parameter) : RString.EMPTY);
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(), 宛名.get消除異動年月日());
            csvEntity.set年齢(ageCalculator.get年齢());
            csvEntity.set性別(entity.get宛名().getSeibetsuCode());
            TsuzukigaraCode 続柄コード = entity.get宛名().getTsuzukigaraCode();
            csvEntity.set続柄コード(続柄コード != null ? 続柄コード.getColumnValue() : RString.EMPTY);
            SetaiCode 世帯コード = entity.get宛名().getSetaiCode();
            csvEntity.set世帯コード(世帯コード != null ? 世帯コード.getColumnValue() : RString.EMPTY);
            AtenaMeisho 世帯主名 = entity.get宛名().getSetainushiMei();
            csvEntity.set世帯主名(世帯主名 != null ? 世帯主名.getColumnValue() : RString.EMPTY);
            AtenaJusho 住所コード = entity.get宛名().getJusho();
            csvEntity.set住所コード(住所コード != null ? 住所コード.getColumnValue() : RString.EMPTY);
            YubinNo 郵便番号 = entity.get宛名().getYubinNo();
            csvEntity.set郵便番号(郵便番号 != null ? 郵便番号.getColumnValue() : RString.EMPTY);
            AtenaJusho 住所 = entity.get宛名().getJusho();
            csvEntity.set住所(住所 != null ? 住所.getColumnValue() : RString.EMPTY);
            AtenaBanchi 番地 = entity.get宛名().getBanchi();
            csvEntity.set番地(番地 != null ? 番地.getColumnValue() : RString.EMPTY);
            Katagaki 方書 = entity.get宛名().getKatagaki();
            csvEntity.set方書(方書 != null ? 方書.getColumnValue() : RString.EMPTY);
            csvEntity.set住所と番地と方書((住所 != null ? 住所.getColumnValue() : RString.EMPTY)
                    .concat(番地 != null ? 番地.getColumnValue() : RString.EMPTY)
                    .concat(全角空白)
                    .concat(方書 != null ? 方書.getColumnValue() : RString.EMPTY));
            set宛名(entity, csvEntity);
        }
    }

    private void set宛名(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {
        GyoseikuCode 行政区コード = entity.get宛名().getGyoseikuCode();
        csvEntity.set行政区コード(行政区コード != null ? 行政区コード.getColumnValue() : RString.EMPTY);
        csvEntity.set行政区名(entity.get宛名().getGyoseikuName());
        csvEntity.set地区１(entity.get宛名().getChikuName1());
        csvEntity.set地区２(entity.get宛名().getChikuName2());
        csvEntity.set地区３(entity.get宛名().getChikuName3());
        TelNo 連絡先１ = entity.get宛名().getRenrakusaki1();
        csvEntity.set連絡先１(連絡先１ != null ? 連絡先１.getColumnValue() : RString.EMPTY);
        TelNo 連絡先２ = entity.get宛名().getRenrakusaki2();
        csvEntity.set連絡先２(連絡先２ != null ? 連絡先２.getColumnValue() : RString.EMPTY);
        FlexibleDate 登録異動日 = entity.get宛名().getTorokuIdoYMD();
        csvEntity.set登録異動日(登録異動日 != null ? new RString(登録異動日.toString()) : RString.EMPTY);
        csvEntity.set登録事由(entity.get宛名().getTorokuJiyuCode());
        FlexibleDate 登録届出日 = entity.get宛名().getTorokuTodokedeYMD();
        csvEntity.set登録届出日(登録届出日 != null ? new RString(登録届出日.toString()) : RString.EMPTY);
        FlexibleDate 住定異動日 = entity.get宛名().getJuteiIdoYMD();
        csvEntity.set住定異動日(住定異動日 != null ? new RString(住定異動日.toString()) : RString.EMPTY);
        csvEntity.set住定事由(entity.get宛名().getJuteiJiyuCode());
        FlexibleDate 住定届出日 = entity.get宛名().getJuteiTodokedeYMD();
        csvEntity.set住定届出日(住定届出日 != null ? new RString(住定届出日.toString()) : RString.EMPTY);
        FlexibleDate 消除異動日 = entity.get宛名().getShojoIdoYMD();
        csvEntity.set消除異動日(消除異動日 != null ? new RString(消除異動日.toString()) : RString.EMPTY);
        csvEntity.set消除事由(entity.get宛名().getShojoJiyuCode());
        FlexibleDate 消除届出日 = entity.get宛名().getShojoTodokedeYMD();
        csvEntity.set消除届出日(消除届出日 != null ? new RString(消除届出日.toString()) : RString.EMPTY);
        //  TODO 宛名・本人・
        RString 転出入理由 = entity.get宛名().getAimaiShojobiMongon();
        csvEntity.set転出入理由(転出入理由);
        YubinNo 前住所郵便番号 = entity.get宛名().getTennyumaeYubinNo();
        csvEntity.set前住所郵便番号(前住所郵便番号 != null ? 前住所郵便番号.getColumnValue() : RString.EMPTY);
        AtenaJusho 前住所 = entity.get宛名().getTennyumaeJusho();
        csvEntity.set前住所(前住所 != null ? 前住所.getColumnValue() : RString.EMPTY);
        AtenaBanchi 前住所番地 = entity.get宛名().getTennyumaeBanchi();
        csvEntity.set前住所番地(前住所番地 != null ? 前住所番地.getColumnValue() : RString.EMPTY);
        Katagaki 前住所方書 = entity.get宛名().getTennyumaeKatagaki();
        csvEntity.set前住所方書(前住所方書 != null ? 前住所方書.getColumnValue() : RString.EMPTY);
        csvEntity.set前住所と番地と方書((前住所 != null ? 前住所.getColumnValue() : RString.EMPTY)
                .concat(前住所番地 != null ? 前住所番地.getColumnValue() : RString.EMPTY)
                .concat(全角空白)
                .concat(前住所方書 != null ? 前住所方書.getColumnValue() : RString.EMPTY));
    }

    private void set宛先(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {

        UaFt250FindAtesakiEntity 宛先 = entity.get宛先();
        if (isNotNull(宛先)) {
            AtenaMeisho 送付先氏名 = 宛先.getKanjiShimei();
            csvEntity.set送付先氏名(送付先氏名 != null ? 送付先氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 送付先氏名カナ = 宛先.getKanaShimei();
            csvEntity.set送付先氏名カナ(送付先氏名カナ != null ? 送付先氏名カナ.getColumnValue() : RString.EMPTY);
            // 宛名・送付先・住所コード
            ChoikiCode 送付先住所コード = 宛先.getChoikiCode();
            csvEntity.set送付先住所コード(送付先住所コード != null ? 送付先住所コード.getColumnValue() : RString.EMPTY);
            YubinNo 送付先郵便番号 = 宛先.getYubinNo();
            csvEntity.set送付先郵便番号(送付先郵便番号 != null ? 送付先郵便番号.getColumnValue() : RString.EMPTY);
            // 宛名・送付先・住所コード
            AtenaJusho 送付先住所 = 宛先.getJusho();
            csvEntity.set送付先住所(送付先住所 != null ? 送付先住所.getColumnValue() : RString.EMPTY);
            AtenaBanchi 送付先番地 = 宛先.getBanchi();
            csvEntity.set送付先番地(送付先番地 != null ? 送付先番地.getColumnValue() : RString.EMPTY);
            Katagaki 送付先方書 = 宛先.getKatagaki();
            csvEntity.set送付先方書(送付先方書 != null ? 送付先方書.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先住所と番地と方書((送付先住所 != null ? 送付先住所.getColumnValue() : RString.EMPTY)
                    .concat(送付先番地 != null ? 送付先番地.getColumnValue() : RString.EMPTY)
                    .concat(全角空白)
                    .concat(送付先方書 != null ? 送付先方書.getColumnValue() : RString.EMPTY));
            GyoseikuCode 送付先行政区コード = 宛先.getGyoseikuCode();
            csvEntity.set送付先行政区コード(送付先行政区コード != null ? 送付先行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先行政区名(宛先.getGyoseiku());
        }
    }

    private void set入所施設種類(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (入所施設種類_11.equals(entity.get入所施設種類())) {
            set介護保険施設(entity, csvEntity, parameter);
        } else if (入所施設種類_12.equals(entity.get入所施設種類()) || 入所施設種類_21.equals(entity.get入所施設種類())) {
            csvEntity.set指定事業者名(entity.get事業者名称_05().isEmpty()
                    ? RString.EMPTY : entity.get事業者名称_05().getColumnValue());
            csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_05().isEmpty()
                    ? RString.EMPTY : entity.get事業者名称カナ_05().getColumnValue());
            csvEntity.set指定事業者郵便番号(entity.get郵便番号_05().isEmpty()
                    ? RString.EMPTY : entity.get郵便番号_05().getColumnValue());
            csvEntity.set指定事業者住所(entity.get事業者住所_05().isEmpty()
                    ? RString.EMPTY : entity.get事業者住所_05().getColumnValue());
            csvEntity.set指定事業者代表者名(entity.get代表者名_05().isEmpty()
                    ? RString.EMPTY : entity.get代表者名_05().getColumnValue());
            csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_05().isEmpty()
                    ? RString.EMPTY : entity.get代表者名カナ_05().getColumnValue());
            csvEntity.set指定事業者代表者役職(entity.get役職_05());
            csvEntity.set指定事業者電話番号(entity.get電話番号_05().isEmpty()
                    ? RString.EMPTY : entity.get電話番号_05().getColumnValue());
            csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_05().isEmpty()
                    ? RString.EMPTY : entity.getFax番号_05().getColumnValue());
            csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            csvEntity.set指定事業者利用者数(RString.EMPTY);
            csvEntity.set指定事業者認定日(get日付項目(entity.get有効開始日_05(), parameter));
            csvEntity.set指定事業者取消日(get日付項目(entity.get有効終了日_05(), parameter));
            csvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private void set介護保険施設(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        csvEntity.set指定事業者名(entity.get事業者名称_60().isEmpty()
                ? RString.EMPTY : entity.get事業者名称_60().getColumnValue());
        csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_60().isEmpty()
                ? RString.EMPTY : entity.get事業者名称カナ_60().getColumnValue());
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_60().isEmpty()
                ? RString.EMPTY : entity.get郵便番号_60().getColumnValue());
        csvEntity.set指定事業者住所(entity.get事業者住所_60().isEmpty()
                ? RString.EMPTY : entity.get事業者住所_60().getColumnValue());
        csvEntity.set指定事業者代表者名(entity.get代表者名_62().isEmpty()
                ? RString.EMPTY : entity.get代表者名_62().getColumnValue());
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_62().isEmpty()
                ? RString.EMPTY : entity.get代表者名カナ_62().getColumnValue());
        csvEntity.set指定事業者代表者役職(entity.get代表者役職名_62());
        csvEntity.set指定事業者電話番号(entity.get電話番号_60().isEmpty()
                ? RString.EMPTY : entity.get電話番号_60().getColumnValue());
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_60().isEmpty()
                ? RString.EMPTY : entity.getFax番号_60().getColumnValue());
        csvEntity.set指定事業者ケアマネ数(numToRString(entity.get所属人数()));
        csvEntity.set指定事業者利用者数(numToRString(entity.get利用者数()));
        csvEntity.set指定事業者認定日(get日付項目(entity.get有効開始日_60(), parameter));
        csvEntity.set指定事業者取消日(get日付項目(entity.get有効終了日_60(), parameter));
        csvEntity.set指定事業者実施地域(entity.getサービス実施地域_60());
    }

    private void set支給申請(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get支給申請())) {
            csvEntity.set支払場所(entity.get支給申請().getShiharaiBasho());
            FlexibleDate 支払開始日 = entity.get支給申請().getShiharaiKaishiYMD();
            csvEntity.set支払開始日(支払開始日 != null ? get日付項目(支払開始日, parameter) : RString.EMPTY);
            FlexibleDate 支払終了日 = entity.get支給申請().getShiharaiShuryoYMD();
            csvEntity.set支払終了日(支払終了日 != null ? get日付項目(支払終了日, parameter) : RString.EMPTY);
            RString 支払開始時間 = entity.get支給申請().getShiharaiKaishiTime();
            csvEntity.set支払開始時間(支払開始時間 != null ? 支払開始時間 : RString.EMPTY);
            RString 支払終了時間 = entity.get支給申請().getShiharaiShuryoTime();
            csvEntity.set支払終了時間(支払終了時間 != null ? 支払終了時間 : RString.EMPTY);

            csvEntity.setサービス提供年月(entity.get支給申請().getServiceTeikyoYM().isEmpty()
                    ? RString.EMPTY : get年月(entity.get支給申請().getServiceTeikyoYM(), parameter));
            Decimal 管理番号 = entity.get支給申請().getRirekiNo();
            csvEntity.set管理番号(管理番号 != null ? new RString(管理番号.toString()) : RString.EMPTY);
            HokenshaNo 給付証記載保険者番号 = entity.get支給申請().getShoKisaiHokenshaNo();
            csvEntity.set給付証記載保険者番号(給付証記載保険者番号 != null ? 給付証記載保険者番号.getColumnValue() : RString.EMPTY);
            FlexibleDate 申請日 = entity.get支給申請().getShinseiYMD();
            csvEntity.set申請日(申請日 != null ? new RString(申請日.toString()) : RString.EMPTY);
            csvEntity.set申請理由(entity.get支給申請().getShinseiRiyu());
            csvEntity.set申請区分(entity.get支給申請().getShinseishaKubun());
            AtenaMeisho 申請氏名 = entity.get支給申請().getShinseishaShimei();
            csvEntity.set申請氏名(申請氏名 != null ? 申請氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 申請氏名カナ = entity.get支給申請().getShinseishaShimeiKana();
            csvEntity.set申請氏名カナ(申請氏名カナ != null ? 申請氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set申請電話番号(entity.get支給申請().getShinseishaTelNo().isEmpty()
                    ? RString.EMPTY : entity.get支給申請().getShinseishaTelNo().getColumnValue());
            FlexibleDate 受付日 = entity.get支給申請().getUketsukeYMD();
            csvEntity.set受付日(受付日 != null ? get日付項目(受付日, parameter) : RString.EMPTY);
            RString 支払方法区分コード = entity.get支給申請().getShiharaiHohoKubunCode();
            ShiharaiHohoKubun 支払方法区分 = ShiharaiHohoKubun.toValue(支払方法区分コード);
            csvEntity.set支払方法(支払方法区分 != null ? 支払方法区分.get名称() : RString.EMPTY);
        }
    }

    private void set給付対象者合計(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get給付対象者合計())) {
            csvEntity.set申請支払額(numToRString(entity.get給付対象者合計().getKogakuShikyuGaku()));
            csvEntity.set判定費用額(numToRString(entity.get給付対象者合計().getServiceHiyoGokeiGakuGokei()));
            csvEntity.set判定利用負担額(numToRString(entity.get給付対象者合計().getRiyoshaFutanGakuGokei()));
            csvEntity.set判定算定基準額(numToRString(entity.get給付対象者合計().getSanteiKijunGaku()));
            csvEntity.set判定支払済金額(numToRString(entity.get給付対象者合計().getShiharaiSumiKingakuGokei()));
            csvEntity.set判定高額支給額(numToRString(entity.get給付対象者合計().getKogakuShikyuGaku()));
            FlexibleYearMonth 判定受取年月 = entity.get給付対象者合計().getTashoshaUketoriYM();
            csvEntity.set判定受取年月(判定受取年月 != null ? get年月(判定受取年月, parameter) : RString.EMPTY);
            FlexibleYearMonth 高額対象判定年月 = entity.get給付対象者合計().getTaishoshaHanteiShinsaYM();
            csvEntity.set高額対象判定年月(高額対象判定年月 != null ? get年月(高額対象判定年月, parameter) : RString.EMPTY);
        }
    }

    private void set支給判定結果(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get支給判定結果())) {
            FlexibleDate 決定日 = entity.get支給判定結果().getKetteiYMD();
            csvEntity.set決定日(決定日 != null ? get日付項目(決定日, parameter) : RString.EMPTY);
            Decimal 保決定利用負担額 = entity.get支給判定結果().getHonninShiharaiGaku();
            csvEntity.set保決定利用負担額(保決定利用負担額 != null ? numToRString(保決定利用負担額) : RString.EMPTY);
            csvEntity.set保決定支給区分(entity.get支給判定結果().getShikyuKubunCode());
            Decimal 保決定高額支給額 = entity.get支給判定結果().getShikyuKingaku();
            csvEntity.set保決定高額支給額(保決定高額支給額 != null ? numToRString(保決定高額支給額) : RString.EMPTY);
            csvEntity.set保決定不支給理由(entity.get支給判定結果().getFushikyuRiyu());
            csvEntity.set審査方法(entity.get支給判定結果().getShinsaHohoKubun());
            FlexibleYearMonth 保決定送付年月 = entity.get支給判定結果().getHanteiKekkaSofuYM();
            csvEntity.set保決定送付年月(保決定送付年月 != null ? get年月(保決定送付年月, parameter) : RString.EMPTY);
            FlexibleDate 通知書作成日 = entity.get支給判定結果().getKetteiTsuchishoSakuseiYMD();
            csvEntity.set通知書作成日(通知書作成日 != null ? get日付項目(通知書作成日, parameter) : RString.EMPTY);
            FlexibleDate 振込書作成日 = entity.get支給判定結果().getFurikomiMeisaishoSakuseiYMD();
            csvEntity.set振込書作成日(振込書作成日 != null ? get日付項目(振込書作成日, parameter) : RString.EMPTY);
        }
    }

    private void set支給審査決定(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity,
            HanyoListKogakuKaigoProcessParameter parameter) {

        if (isNotNull(entity.get支給審査決定())) {
            FlexibleYearMonth 国決定年月 = entity.get支給審査決定().getKetteiYM();
            csvEntity.set国決定年月(国決定年月 != null ? get年月(国決定年月, parameter) : RString.EMPTY);
            csvEntity.set国決定通知書ＮＯ(entity.get支給審査決定().getTsuchishoNo());
            Decimal 国決定利用負担額 = entity.get支給審査決定().getRiyoshaFutanGaku();
            csvEntity.set国決定利用負担額(numToRString(国決定利用負担額));
            csvEntity.set国決定支給区分(entity.get支給審査決定().getShikyuKubunCode());
            Decimal 国決定高額支給額 = entity.get支給審査決定().getKogakuShikyuGaku();
            csvEntity.set国決定高額支給額(numToRString(国決定高額支給額));
            FlexibleYearMonth 国決定受取年月 = entity.get支給審査決定().getKetteishaUketoriYM();
            csvEntity.set国決定受取年月(国決定受取年月 != null ? get年月(国決定受取年月, parameter) : RString.EMPTY);
        }

    }

    private void set給付対象者明細(HanyouRisutoSyuturyokuEntity entity, HanyouRisutoSyuturyokuEucCsvEntity csvEntity) {

        if (isNotNull(entity.get給付対象者明細())) {
            csvEntity.set備考算定基準(entity.get給付対象者明細().getKogakuKyufuKonkyo());
            // DBCコンフィグ.国保連共同処理受託区分_高額
            csvEntity.set国保連委託なし(entity.get給付対象者明細().getKogakuKyufuKonkyo());
            // 高額介護サービス費給付対象者明細.高額対象外フラグ
            csvEntity.set高額自動償還(entity.get給付対象者明細().getKogakuKyufuKonkyo());
            csvEntity.set利用者負担段階(get高額給付根拠(entity.get給付対象者明細().getKogakuKyufuKonkyo()));
        }
    }

    private boolean isNotNull(Object object) {
        return object != null;
    }

    private RString get日付項目(FlexibleDate 生年月日, HanyoListKogakuKaigoProcessParameter parameter) {

        if (!parameter.isHizukeHeshu()) {
            return 生年月日.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        } else {
            return 生年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString get年月(FlexibleYearMonth 年月, HanyoListKogakuKaigoProcessParameter parameter) {
        if (!parameter.isHizukeHeshu()) {
            return 年月.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        }
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }

    private RString get高額給付根拠(RString 高額給付根拠) {

        RString 世帯の所得区分コード;
        RString 本人の所得区分コード;
        RString 老齢福祉年金受給の有無;
        if (高額給付根拠.trim().isEmpty()) {
            return RString.EMPTY;
        } else {
            List<RString> list = 高額給付根拠.toRStringList();
            if (null != list.get(INDEX_0) && (list.get(INDEX_0).equals(RST_月)
                    || list.get(INDEX_0).equals(RString.EMPTY))) {
                世帯の所得区分コード = null != list.get(INDEX_1) ? list.get(INDEX_1) : RString.EMPTY;
                本人の所得区分コード = null != list.get(INDEX_2) ? list.get(INDEX_2) : RString.EMPTY;
                老齢福祉年金受給の有無 = null != list.get(INDEX_4) ? list.get(INDEX_4) : RString.EMPTY;
            } else {
                世帯の所得区分コード = null != list.get(INDEX_0) ? list.get(INDEX_0) : RString.EMPTY;
                本人の所得区分コード = null != list.get(INDEX_1) ? list.get(INDEX_1) : RString.EMPTY;
                老齢福祉年金受給の有無 = null != list.get(INDEX_3) ? list.get(INDEX_3) : RString.EMPTY;
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
