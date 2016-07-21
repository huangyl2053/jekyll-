/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hanyolistkyotakuservicekeikaku;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkyotakuservicekeikaku.HanyoListKyotakuServiceKeikakuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト 居宅サービス計画CsvEntityEditorクラスです。
 *
 * @reamsid_L DBC-3091-020 surun
 */
public class HanyoListKyotakuServiceKeikakuCsvEntityEditor {

    private static final RString KEY_ONE = new RString("1");
    private static final RString KEY_TWO = new RString("2");
    private static final RString KEY_THREE = new RString("3");
    private static final RString KEY_FOUR = new RString("4");
    private static final RString 介護保険施設 = new RString("11");
    private static final RString 住所地特例対象施設 = new RString("12");
    private static final RString 適用除外施設 = new RString("21");
    private static final RString 特例状態住特 = new RString("住特");
    private static final RString FLAG = new RString("1");
    private static final RString 介護資格取得事由 = new RString("0007");
    private static final RString 介護資格喪失事由 = new RString("0010");
    private static final RString 表示名称_新規 = new RString("新規");
    private static final RString 表示名称_変更 = new RString("変更");
    private static final RString 表示名称_暫定 = new RString("暫定");
    private static final RString 表示名称_指定居宅介護支援事業者作成 = new RString("指定居宅介護支援事業者作成");
    private static final RString 表示名称_基準該当居宅介護支援事業者作成 = new RString("基準該当居宅介護支援事業者作成");
    private static final RString 表示名称_介護予防支援事業者作成 = new RString("介護予防支援事業者作成");
    private final FlexibleDate システム日付;

    public HanyoListKyotakuServiceKeikakuCsvEntityEditor(FlexibleDate システム日付) {
        this.システム日付 = システム日付;
    }

    /**
     * editor
     *
     * @param entity HanyoListKyotakuServiceKeikakuEntity
     * @param parameter HanyoListKyotakuServiceKeikakuProcessParameter
     * @param 連番 Decimal
     * @return HanyoListKyotakuServiceKeikakuCsvEntity
     */
    public HanyoListKyotakuServiceKeikakuCsvEntity editor(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuProcessParameter parameter, Decimal 連番) {
        HanyoListKyotakuServiceKeikakuCsvEntity csvEntity = new HanyoListKyotakuServiceKeikakuCsvEntity();
        if (parameter.isCsv連番付加()) {
            csvEntity.set連番(numToRString(連番));
        } else {
            csvEntity.set連番(RString.EMPTY);
        }
        editor宛名(entity, csvEntity, parameter);
        editor地区(entity, csvEntity);
        editor前住所(entity, csvEntity, parameter);
        editor宛先(entity, csvEntity);
        editor資格(entity, csvEntity, parameter);
        if (介護保険施設.equals(entity.getDbV1004入所施設種類())) {
            editor指定事業者_介護保険施設(entity, csvEntity, parameter);

        } else if (住所地特例対象施設.equals(entity.getDbV1004入所施設種類())
                || 適用除外施設.equals(entity.getDbV1004入所施設種類())) {
            editor指定事業者_住所地特例対象施設_適用除外施設(entity, csvEntity, parameter);
        }
        editor計画(entity, csvEntity, parameter);
        editor受給(entity, csvEntity, parameter);
        return csvEntity;
    }

    private RString dataToRString(FlexibleDate 日付, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.isCsv日付スラッシュ編集()) {
            return 日付.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        } else {
            return 日付.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }

    private boolean isNull(Object object) {
        return object == null;
    }

    private void editor宛名(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {
        ShikibetsuCode shikibetsuCode = entity.get宛名Entity().getShikibetsuCode();
        if (shikibetsuCode != null) {
            csvEntity.set識別コード(shikibetsuCode.getColumnValue());
        } else {
            csvEntity.set識別コード(RString.EMPTY);
        }
        csvEntity.set住民種別(isNull(entity.get宛名Entity().getJuminShubetsuCode()) ? RString.EMPTY : entity.get宛名Entity()
                .getJuminShubetsuCode());
        AtenaMeisho atenaMeisho = entity.get宛名Entity().getKanjiShimei();
        if (atenaMeisho != null) {
            csvEntity.set氏名(atenaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho = entity.get宛名Entity().getKanaShimei();
        if (atenaKanaMeisho != null) {
            csvEntity.set氏名カナ(atenaKanaMeisho.getColumnValue());
        } else {
            csvEntity.set氏名カナ(RString.EMPTY);
        }
        csvEntity.set生年月日(dataToRString(entity.get宛名Entity().getSeinengappiYMD(), parameter));

        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(),
                宛名.get消除異動年月日());
        csvEntity.set年齢(ageCalculator.get年齢());
        if (宛名.get性別() != null) {
            csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
        }
        TsuzukigaraCode tsuzukigaraCode = entity.get宛名Entity().getTsuzukigaraCode();
        if (tsuzukigaraCode != null) {
            csvEntity.set続柄コード(tsuzukigaraCode.getColumnValue());
        } else {
            csvEntity.set続柄コード(RString.EMPTY);
        }
        SetaiCode setaiCode = entity.get宛名Entity().getSetaiCode();
        if (setaiCode != null) {
            csvEntity.set世帯コード(setaiCode.getColumnValue());
        } else {
            csvEntity.set世帯コード(RString.EMPTY);
        }
        AtenaMeisho atenaMeisho1 = entity.get宛名Entity().getSetainushiMei();
        if (atenaMeisho1 != null) {
            csvEntity.set世帯主名(atenaMeisho1.getColumnValue());
        } else {
            csvEntity.set世帯主名(RString.EMPTY);
        }
        ZenkokuJushoCode zenkokuJushoCode = entity.get宛名Entity().getZenkokuJushoCode();
        if (zenkokuJushoCode != null) {
            csvEntity.set住所コード(zenkokuJushoCode.getColumnValue());
        } else {
            csvEntity.set住所コード(RString.EMPTY);
        }
        YubinNo yubinNo = entity.get宛名Entity().getYubinNo();
        if (yubinNo != null) {
            csvEntity.set郵便番号(yubinNo.getColumnValue());
        } else {
            csvEntity.set郵便番号(RString.EMPTY);
        }
    }

    private void editor地区(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity) {

        StringBuilder stringBuilder = new StringBuilder();
        AtenaJusho atenaJusho = entity.get宛名Entity().getJusho();
        if (atenaJusho != null) {
            stringBuilder.append(atenaJusho.toString());
        }
        AtenaBanchi atenaBanchi = entity.get宛名Entity().getBanchi();
        if (atenaBanchi != null) {
            stringBuilder.append(atenaBanchi.toString());
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(RString.FULL_SPACE);
        }
        Katagaki katagaki = entity.get宛名Entity().getKatagaki();
        if (katagaki != null) {
            stringBuilder.append(katagaki.toString());
        }
        if (stringBuilder.length() > 0) {
            csvEntity.set住所番地方書(new RString(stringBuilder.toString()));
        } else {
            csvEntity.set住所番地方書(RString.EMPTY);
        }

        if (atenaJusho != null) {
            csvEntity.set住所(atenaJusho.getColumnValue());
        } else {
            csvEntity.set住所(RString.EMPTY);
        }
        if (atenaBanchi != null) {
            csvEntity.set番地(atenaBanchi.getColumnValue());
        } else {
            csvEntity.set番地(RString.EMPTY);
        }
        if (katagaki != null) {
            csvEntity.set方書(katagaki.getColumnValue());
        } else {
            csvEntity.set方書(RString.EMPTY);
        }
        GyoseikuCode gyoseikuCode = entity.get宛名Entity().getGyoseikuCode();
        if (gyoseikuCode != null) {
            csvEntity.set行政区コード(gyoseikuCode.value());
        } else {
            csvEntity.set行政区コード(RString.EMPTY);
        }
        csvEntity.set行政区名(isNull(entity.get宛名Entity().getGyoseikuName())
                ? RString.EMPTY : entity.get宛名Entity().getGyoseikuName());
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
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
        TelNo telNo = entity.get宛名Entity().getRenrakusaki1();
        if (telNo != null) {
            csvEntity.set連絡先１(telNo.value());
        } else {
            csvEntity.set連絡先１(RString.EMPTY);
        }
        TelNo telNo2 = entity.get宛名Entity().getRenrakusaki2();
        if (telNo2 != null) {
            csvEntity.set連絡先２(telNo2.value());
        } else {
            csvEntity.set連絡先２(RString.EMPTY);
        }
    }

    private void editor前住所(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {

        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        IIdoJiyu 登録事由 = 宛名.get登録事由();
        IIdoJiyu 住定事由 = 宛名.get住定事由();
        IIdoJiyu 消除事由 = 宛名.get消除事由();
        csvEntity.set登録異動日(dataToRString(entity.get宛名Entity().getTorokuIdoYMD(), parameter));
        csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set登録届出日(dataToRString(entity.get宛名Entity().getTorokuTodokedeYMD(), parameter));
        csvEntity.set住定異動日(dataToRString(entity.get宛名Entity().getJuteiIdoYMD(), parameter));
        csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set住定届出日(dataToRString(entity.get宛名Entity().getJuteiTodokedeYMD(), parameter));
        csvEntity.set消除異動日(dataToRString(entity.get宛名Entity().getShojoIdoYMD(), parameter));
        csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由略称() : RString.EMPTY);
        csvEntity.set消除届出日(dataToRString(entity.get宛名Entity().getShojoTodokedeYMD(), parameter));
        csvEntity.set転出入理由(RString.EMPTY);
        YubinNo yubinNo1 = entity.get宛名Entity().getTennyumaeYubinNo();
        if (yubinNo1 != null) {
            csvEntity.set前住所郵便番号(yubinNo1.value());
        } else {
            csvEntity.set前住所郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho1 = entity.get宛名Entity().getTennyumaeJusho();
        AtenaBanchi atenaBanchi1 = entity.get宛名Entity().getTennyumaeBanchi();
        Katagaki katagaki1 = entity.get宛名Entity().getTennyumaeKatagaki();
        StringBuilder stringBuilder1 = new StringBuilder();
        if (atenaJusho1 != null) {
            stringBuilder1.append(atenaJusho1.value());
        }
        if (atenaBanchi1 != null) {
            stringBuilder1.append(atenaBanchi1.value());
        }
        if (stringBuilder1.length() > 0) {
            stringBuilder1.append(RString.FULL_SPACE);
        }
        if (katagaki1 != null) {
            stringBuilder1.append(katagaki1.value());
        }
        if (stringBuilder1.length() > 0) {
            csvEntity.set前住所番地方書(new RString(stringBuilder1.toString()));
        } else {
            csvEntity.set前住所番地方書(RString.EMPTY);
        }
        if (atenaJusho1 != null) {
            csvEntity.set前住所(atenaJusho1.value());
        } else {
            csvEntity.set前住所(RString.EMPTY);
        }
        if (atenaBanchi1 != null) {
            csvEntity.set前住所番地(atenaBanchi1.value());
        } else {
            csvEntity.set前住所番地(RString.EMPTY);
        }
        if (katagaki1 != null) {
            csvEntity.set前住所方書(katagaki1.value());
        } else {
            csvEntity.set前住所方書(RString.EMPTY);
        }

    }

    private void editor宛先(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity) {

        csvEntity.set市町村コード(isNull(entity.getDbV1001市町村コード())
                ? RString.EMPTY : entity.getDbV1001市町村コード().value());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(entity.getDbV1001市町村コード(),
                FlexibleDate.getNowDate());
        csvEntity.set市町村名(地方公共団体.get市町村名());
        Association 地方公共団体1 = AssociationFinderFactory.createInstance().getAssociation();
        csvEntity.set保険者コード(地方公共団体1.get地方公共団体コード().getColumnValue());
        csvEntity.set保険者名(地方公共団体1.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        AtenaMeisho atenaMeisho2 = entity.get宛先Entity().getKanjiShimei();
        if (atenaMeisho2 != null) {
            csvEntity.set送付先氏名(atenaMeisho2.value());
        } else {
            csvEntity.set送付先氏名(RString.EMPTY);
        }
        AtenaKanaMeisho atenaKanaMeisho1 = entity.get宛先Entity().getKanaShimei();
        if (atenaKanaMeisho1 != null) {
            csvEntity.set送付先氏名カナ(atenaKanaMeisho1.value());
        } else {
            csvEntity.set送付先氏名カナ(RString.EMPTY);
        }

        ZenkokuJushoCode zenkokuJushoCode1 = entity.get宛先Entity().getZenkokuJushoCode();
        if (zenkokuJushoCode1 != null) {
            csvEntity.set送付先住所コード(zenkokuJushoCode1.getColumnValue());
        } else {
            csvEntity.set送付先住所コード(RString.EMPTY);
        }
        YubinNo yubinNo2 = entity.get宛先Entity().getYubinNo();
        if (yubinNo2 != null) {
            csvEntity.set送付先郵便番号(yubinNo2.value());
        } else {
            csvEntity.set送付先郵便番号(RString.EMPTY);
        }
        AtenaJusho atenaJusho2 = entity.get宛先Entity().getJusho();
        AtenaBanchi atenaBanchi2 = entity.get宛先Entity().getBanchi();
        Katagaki katagaki2 = entity.get宛先Entity().getKatagaki();
        StringBuilder stringBuilder2 = new StringBuilder();
        if (atenaJusho2 != null) {
            stringBuilder2.append(atenaJusho2.getColumnValue());
        }
        if (atenaBanchi2 != null) {
            stringBuilder2.append(atenaBanchi2.getColumnValue());
        }
        if (stringBuilder2.length() > 0) {
            stringBuilder2.append(RString.FULL_SPACE);
        }
        if (katagaki2 != null) {
            stringBuilder2.append(katagaki2.getColumnValue());
        }
        if (stringBuilder2.length() > 0) {
            csvEntity.set送付先住所番地方書(new RString(stringBuilder2.toString()));
        } else {
            csvEntity.set送付先住所番地方書(RString.EMPTY);
        }
        if (atenaJusho2 != null) {
            csvEntity.set送付先住所(atenaJusho2.getColumnValue());
        } else {
            csvEntity.set送付先住所(RString.EMPTY);
        }
        if (atenaBanchi2 != null) {
            csvEntity.set送付先番地(atenaBanchi2.value());
        } else {
            csvEntity.set送付先番地(RString.EMPTY);
        }
        if (katagaki2 != null) {
            csvEntity.set送付先方書(katagaki2.value());
        } else {
            csvEntity.set送付先方書(RString.EMPTY);
        }
        GyoseikuCode gyoseikuCode1 = entity.get宛先Entity().getGyoseikuCode();
        if (gyoseikuCode1 != null) {
            csvEntity.set送付先行政区コード(gyoseikuCode1.value());
        } else {
            csvEntity.set送付先行政区コード(RString.EMPTY);
        }
    }

    private void editor資格(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {

        csvEntity.set送付先行政区名(isNull(entity.get宛先Entity().getGyoseiku())
                ? RString.EMPTY : entity.get宛名Entity().getGyoseikuName());
        csvEntity.set被保険者番号(isNull(entity.getDbV1001被保険者番号())
                ? RString.EMPTY : entity.getDbV1001被保険者番号().value());
        RString 資格取得事由 = RString.EMPTY;
        if (entity.getDbV1001資格取得事由コード() != null && !entity.getDbV1001資格取得事由コード().isEmpty()) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, new CodeShubetsu(介護資格取得事由),
                    new Code(entity.getDbV1001資格取得事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(isNull(資格取得事由)
                ? RString.EMPTY : 資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.getDbV1001資格取得年月日(), parameter));
        csvEntity.set資格取得届出日(dataToRString(entity.getDbV1001資格取得届出年月日(), parameter));
        RString 喪失事由 = RString.EMPTY;
        if (entity.getDbV1001資格喪失事由コード() != null && !entity.getDbV1001資格喪失事由コード().isEmpty()) {
            喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, new CodeShubetsu(介護資格喪失事由),
                    new Code(entity.getDbV1001資格喪失事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(isNull(喪失事由)
                ? RString.EMPTY : 喪失事由);
        csvEntity.set資格喪失日(dataToRString(entity.getDbV1001資格喪失年月日(), parameter));
        csvEntity.set資格喪失届日(dataToRString(entity.getDbV1001資格喪失届出年月日(), parameter));
        HihokenshaKubunCode hihokenshaKubunCode = HihokenshaKubunCode.toValue(entity.getDbV1001被保険者区分コード());
        csvEntity.set資格区分(isNull(hihokenshaKubunCode)
                ? RString.EMPTY : hihokenshaKubunCode.get名称());
        if (FLAG.equals(entity.getDbV1001住所地特例フラグ())) {
            csvEntity.set住所地特例状態(特例状態住特);
        } else {
            csvEntity.set住所地特例状態(RString.EMPTY);
        }
        HokenshaList hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        if (FLAG.equals(entity.getDbV1001広域内住所地特例フラグ())) {
            if (entity.getDbV1001広住特措置元市町村コード() != null && !entity.getDbV1001広住特措置元市町村コード().isEmpty()) {
                HokenshaSummary hokenshaSummary = hokenshaList.get(entity.getDbV1001広住特措置元市町村コード());
                csvEntity.set資格証記載保険者番号(hokenshaSummary.get証記載保険者番号().getColumnValue());
            }
        } else {
            if (entity.getDbV1001市町村コード() != null && !entity.getDbV1001市町村コード().isEmpty()) {
                HokenshaSummary hokenshaSummary = hokenshaList.get(entity.getDbV1001市町村コード());
                csvEntity.set資格証記載保険者番号(hokenshaSummary.get証記載保険者番号().getColumnValue());
            }
        }
        csvEntity.set指定事業者コード(isNull(entity.getDbV1004入所施設コード())
                ? RString.EMPTY : entity.getDbV1004入所施設コード().value());
        csvEntity.set施設入所日(dataToRString(entity.getDbV1004入所年月日(), parameter));
        csvEntity.set施設退所日(dataToRString(entity.getDbV1004退所年月日(), parameter));

    }

    private void editor指定事業者_介護保険施設(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {
        csvEntity.set指定事業者名(isNull(entity.getDbT7060事業者名称())
                ? RString.EMPTY : entity.getDbT7060事業者名称().value());
        csvEntity.set指定事業者名カナ(isNull(entity.getDbT7060事業者名称カナ())
                ? RString.EMPTY : entity.getDbT7060事業者名称カナ().value());
        csvEntity.set指定事業者郵便番号(isNull(entity.getDbT7060郵便番号())
                ? RString.EMPTY : entity.getDbT7060郵便番号().value());
        csvEntity.set指定事業者住所(isNull(entity.getDbT7060事業者住所())
                ? RString.EMPTY : entity.getDbT7060事業者住所().value());
        csvEntity.set指定事業者代表者名(isNull(entity.getDbT7062代表者名())
                ? RString.EMPTY : entity.getDbT7062代表者名().value());
        csvEntity.set指定事業者代表者名カナ(isNull(entity.getDbT7062代表者名カナ())
                ? RString.EMPTY : entity.getDbT7062代表者名カナ().value());
        csvEntity.set指定事業者代表者役職(isNull(entity.getDbT7062代表者役職名())
                ? RString.EMPTY : entity.getDbT7062代表者役職名());
        csvEntity.set指定事業者電話番号(isNull(entity.getDbT7060電話番号())
                ? RString.EMPTY : entity.getDbT7060電話番号().value());
        csvEntity.set指定事業者ＦＡＸ番号(isNull(entity.getDbT7060FAX番号())
                ? RString.EMPTY : entity.getDbT7060FAX番号().value());
        csvEntity.set指定事業者ケアマネ数(numToRString(entity.getDbT7060所属人数()));
        csvEntity.set指定事業者利用者数(numToRString(entity.getDbT7060利用者数()));
        csvEntity.set指定事業者認定日(dataToRString(entity.getDbT7060有効開始日(), parameter));
        csvEntity.set指定事業者取消日(dataToRString(entity.getDbT7060有効終了日(), parameter));
        csvEntity.set指定事業者実施地域(isNull(entity.getDbT7060サービス実施地域())
                ? RString.EMPTY : entity.getDbT7060サービス実施地域());

    }

    private void editor指定事業者_住所地特例対象施設_適用除外施設(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {
        csvEntity.set指定事業者名(isNull(entity.getDbV1005事業者名称())
                ? RString.EMPTY : entity.getDbV1005事業者名称().value());
        csvEntity.set指定事業者名カナ(isNull(entity.getDbV1005事業者名称カナ())
                ? RString.EMPTY : entity.getDbV1005事業者名称カナ().value());
        csvEntity.set指定事業者郵便番号(isNull(entity.getDbV1005郵便番号())
                ? RString.EMPTY : entity.getDbV1005郵便番号().value());
        csvEntity.set指定事業者住所(isNull(entity.getDbV1005事業者住所())
                ? RString.EMPTY : entity.getDbV1005事業者住所().value());
        csvEntity.set指定事業者代表者名(isNull(entity.getDbV1005代表者名称())
                ? RString.EMPTY : entity.getDbV1005代表者名称().value());
        csvEntity.set指定事業者代表者名カナ(isNull(entity.getDbV1005代表者名称カナ())
                ? RString.EMPTY : entity.getDbV1005代表者名称カナ().value());
        csvEntity.set指定事業者代表者役職(isNull(entity.getDbV1005役職())
                ? RString.EMPTY : entity.getDbV1005役職());
        csvEntity.set指定事業者電話番号(isNull(entity.getDbV1005電話番号())
                ? RString.EMPTY : entity.getDbV1005電話番号().value());
        csvEntity.set指定事業者ＦＡＸ番号(isNull(entity.getDbV1005FAX番号())
                ? RString.EMPTY : entity.getDbV1005FAX番号().value());
        csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        csvEntity.set指定事業者利用者数(RString.EMPTY);
        csvEntity.set指定事業者認定日(dataToRString(entity.getDbV1005有効開始日(), parameter));
        csvEntity.set指定事業者取消日(dataToRString(entity.getDbV1005有効終了年月日(), parameter));
        csvEntity.set指定事業者実施地域(RString.EMPTY);
    }

    private void editor計画(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {
        RString 届出区分 = entity.getDbT3005届出区分();
        if (KEY_ONE.equals(届出区分)) {
            csvEntity.set届出区分(表示名称_新規);
        } else if (KEY_TWO.equals(届出区分)) {
            csvEntity.set届出区分(表示名称_変更);
        } else if (KEY_THREE.equals(届出区分)) {
            csvEntity.set届出区分(表示名称_暫定);
        } else {
            csvEntity.set届出区分(RString.EMPTY);
        }
        RString 居宅計画作成区分 = entity.getDbT3006作成区分コード();
        if (KEY_ONE.equals(居宅計画作成区分)) {
            csvEntity.set居宅計画作成区分(表示名称_指定居宅介護支援事業者作成);
        } else if (KEY_TWO.equals(居宅計画作成区分)) {
            csvEntity.set居宅計画作成区分(表示名称_基準該当居宅介護支援事業者作成);
        } else if (KEY_FOUR.equals(居宅計画作成区分)) {
            csvEntity.set居宅計画作成区分(表示名称_介護予防支援事業者作成);
        } else {
            csvEntity.set居宅計画作成区分(RString.EMPTY);
        }
        csvEntity.set計画事業者番号(isNull(entity.getDbT3006計画事業者番号())
                ? RString.EMPTY : entity.getDbT3006計画事業者番号().value());
        csvEntity.set計画事業者名(
                isNull(entity.getDbT7060_Keikaku事業者名称())
                ? RString.EMPTY
                : entity.getDbT7060_Keikaku事業者名称().value());
        csvEntity.set計画事業者カナ(
                isNull(entity.getDbT7060_Keikaku事業者カナ名称())
                ? RString.EMPTY
                : entity.getDbT7060_Keikaku事業者カナ名称().value());
        csvEntity.set計画管理者名(isNull(entity.getDbT7062代表者名())
                ? RString.EMPTY : entity.getDbT7062代表者名().value());
        csvEntity.set計画管理者カナ(isNull(entity.getDbT7062代表者名カナ())
                ? RString.EMPTY : entity.getDbT7062代表者名カナ().value());
        csvEntity.set計画適用開始日(dataToRString(entity.getDbT3006適用開始年月日(), parameter));
        csvEntity.set計画適用終了日(dataToRString(entity.getDbT3006適用終了年月日(), parameter));
        csvEntity.set計画届出日(dataToRString(entity.getDbT3005届出年月日(), parameter));
        csvEntity.set計画作成日(dataToRString(entity.getDbT3007計画作成年月日(), parameter));
        RString 変更年月日;
        if (entity.getDbT3007被保険者番号() == null || entity.getDbT3007被保険者番号().isEmpty()) {
            変更年月日 = dataToRString(entity.getDbT3006事業者変更年月日(), parameter);
        } else {
            変更年月日 = dataToRString(entity.getDbT3007計画変更年月日(), parameter);
        }
        csvEntity.set計画変更日(変更年月日);
        csvEntity.set変更理由(isNull(entity.getDbT3007変更理由())
                ? RString.EMPTY : entity.getDbT3007変更理由());
        csvEntity.set委託先計画事業者番号(isNull(entity.getDbT3006委託先事業者番号())
                ? RString.EMPTY : entity.getDbT3006委託先事業者番号().value());
        csvEntity.set委託先計画事業者名(
                isNull(entity.getDbT7060_Itaku事業者名称())
                ? RString.EMPTY
                : entity.getDbT7060_Itaku事業者名称().value());
    }

    private void editor受給(HanyoListKyotakuServiceKeikakuEntity entity,
            HanyoListKyotakuServiceKeikakuCsvEntity csvEntity, HanyoListKyotakuServiceKeikakuProcessParameter parameter) {

        csvEntity.set受給申請事由(isNull(entity.getDbV4001受給申請事由())
                ? RString.EMPTY : entity.getDbV4001受給申請事由().value());
        csvEntity.set受給申請日(dataToRString(entity.getDbV4001受給申請年月日(), parameter));
        if (entity.getDbV4001要介護認定状態区分コード() == null || entity.getDbV4001要介護認定状態区分コード().isEmpty()) {
            csvEntity.set受給要介護度(RString.EMPTY);
        } else {
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(システム日付, entity.getDbV4001要介護認定状態区分コード().value()).getName());
        }
        csvEntity.set受給認定開始日(dataToRString(entity.getDbV4001認定有効期間開始日(), parameter));
        csvEntity.set受給認定終了日(dataToRString(entity.getDbV4001認定有効期間終了日(), parameter));
        csvEntity.set受給認定日(dataToRString(entity.getDbV4001受給認定日(), parameter));
        csvEntity.set受給旧措置(entity.getDbV4001旧措置フラグ());
        csvEntity.set受給みなし更新認定(isNull(entity.getDbT4001みなし要介護区分コード())
                ? RString.EMPTY : entity.getDbT4001みなし要介護区分コード().value());
        csvEntity.set受給直近事由(isNull(entity.getDbV4001直近異動事由コード())
                ? RString.EMPTY : entity.getDbV4001直近異動事由コード().value());
    }

}
