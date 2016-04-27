/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hanyolistshokanbaraijokyo;

import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyoListShokanbaraiJokyoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト出力(償還払い状況)CSVデータ編集
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public class HanyoListCsvDataCreate {

    private static final RString 入所施設種類_11 = new RString("11");
    private static final RString 入所施設種類_12 = new RString("12");
    private static final RString 入所施設種類_21 = new RString("21");
    private static final CodeShubetsu 申請取消事由コード種別 = new CodeShubetsu("0028");
    private static final CodeShubetsu 資格取得事由コード種別 = new CodeShubetsu("0007");
    private static final RString 住特 = new RString("住特");

    /**
     * createCsvData
     *
     * @param entity HanyoListShokanbaraiJokyoEntity
     * @param parameter HanyoListShokanbaraiJokyoProcessParameter
     * @param 連番 Decimal
     * @param 保険者リスト HokenshaList
     * @return HanyoListShokanbaraiJokyoCSVEntity
     */
    public HanyoListShokanbaraiJokyoCSVEntity createCsvData(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoProcessParameter parameter, Decimal 連番,
            HokenshaList 保険者リスト) {
        HanyoListShokanbaraiJokyoCSVEntity csvEntity = new HanyoListShokanbaraiJokyoCSVEntity();
        if (parameter.is連番付加()) {
            csvEntity.set連番(numToRString(連番));
        }
        set宛名(entity, csvEntity);
        set宛先(entity, csvEntity);
        set被保険者台帳管理(entity, csvEntity, 保険者リスト);
        set介護保険(entity, csvEntity);
        set支給申請(entity, csvEntity);
        set判定結果情報(entity, csvEntity);
        set福祉用具(entity, csvEntity);
        set請求住宅(entity, csvEntity);
        set口座情報(entity, csvEntity);
        return csvEntity;
    }

    private void set介護保険(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        csvEntity.set指定事業者コード(entity.get入所施設コード() == null || entity.get入所施設コード().isEmpty()
                ? RString.EMPTY : entity.get入所施設コード().value());
        csvEntity.set施設入所日(dataToRString(entity.get入所年月日()));
        csvEntity.set施設退所日(dataToRString(entity.get退所年月日()));
        if (入所施設種類_11.equals(entity.get入所施設種類())) {
            set介護事業者(entity, csvEntity);
        } else if (入所施設種類_12.equals(entity.get入所施設種類()) || 入所施設種類_21.equals(entity.get入所施設種類())) {
            set介護対象施設(entity, csvEntity);
        }
    }

    private void set介護事業者(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        csvEntity.set指定事業者名(entity.get事業者名称_60() == null || entity.get事業者名称_60().isEmpty()
                ? RString.EMPTY : entity.get事業者名称_60().value());
        csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_60() == null || entity.get事業者名称カナ_60().isEmpty()
                ? RString.EMPTY : entity.get事業者名称カナ_60().value());
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_60() == null || entity.get郵便番号_60().isEmpty()
                ? RString.EMPTY : entity.get郵便番号_60().value());
        csvEntity.set指定事業者住所(entity.get事業者住所_60() == null || entity.get事業者住所_60().isEmpty()
                ? RString.EMPTY : entity.get事業者住所_60().value());
        csvEntity.set指定事業者代表者名(entity.get代表者名_62() == null || entity.get代表者名_62().isEmpty()
                ? RString.EMPTY : entity.get代表者名_62().value());
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_62() == null || entity.get代表者名カナ_62().isEmpty()
                ? RString.EMPTY : entity.get代表者名カナ_62().value());
        csvEntity.set指定事業者代表者役職(entity.get代表者役職名_62());
        csvEntity.set指定事業者電話番号(entity.get電話番号_60() == null || entity.get電話番号_60().isEmpty()
                ? RString.EMPTY : entity.get電話番号_60().value());
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_60() == null || entity.getFax番号_60().isEmpty()
                ? RString.EMPTY : entity.getFax番号_60().value());
        csvEntity.set指定事業者ケアマネ数(numToRString(entity.get所属人数()));
        csvEntity.set指定事業者利用者数(numToRString(entity.get利用者数()));
        csvEntity.set指定事業者認定日(dataToRString(entity.get有効開始日_60()));
        csvEntity.set指定事業者取消日(dataToRString(entity.get有効終了日_60()));
        csvEntity.set指定事業者実施地域(entity.getサービス実施地域_60());

    }

    private void set介護対象施設(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        csvEntity.set指定事業者名(entity.get事業者名称_05() == null
                || entity.get事業者名称_05().isEmpty()
                ? RString.EMPTY : entity.get事業者名称_05().value());
        csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_05() == null
                || entity.get事業者名称カナ_05().isEmpty()
                ? RString.EMPTY : entity.get事業者名称カナ_05().value());
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_05() == null || entity.get郵便番号_05().isEmpty()
                ? RString.EMPTY : entity.get郵便番号_05().value());
        csvEntity.set指定事業者住所(entity.get事業者住所_05() == null || entity.get事業者住所_05().isEmpty()
                ? RString.EMPTY : entity.get事業者住所_05().value());
        csvEntity.set指定事業者代表者名(entity.get代表者名_05() == null || entity.get代表者名_05().isEmpty()
                ? RString.EMPTY : entity.get代表者名_05().value());
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_05() == null || entity.get代表者名カナ_05().isEmpty()
                ? RString.EMPTY : entity.get代表者名カナ_05().value());
        csvEntity.set指定事業者代表者役職(entity.get役職_05());
        csvEntity.set指定事業者電話番号(entity.get電話番号_05() == null || entity.get電話番号_05().isEmpty()
                ? RString.EMPTY : entity.get電話番号_05().value());
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_05() == null || entity.getFax番号_05().isEmpty()
                ? RString.EMPTY : entity.getFax番号_05().value());
        csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        csvEntity.set指定事業者利用者数(RString.EMPTY);
        csvEntity.set指定事業者認定日(dataToRString(entity.get有効開始日_05()));
        csvEntity.set指定事業者取消日(dataToRString(entity.get有効終了日_05()));
        csvEntity.set指定事業者実施地域(RString.EMPTY);
    }

    private void set宛名(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get宛名Entity() != null) {
            csvEntity.set識別コード(entity.get宛名Entity().getShikibetsuCode() == null
                    || entity.get宛名Entity().getShikibetsuCode().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getShikibetsuCode().getColumnValue());
            csvEntity.set住民種別(entity.get宛名Entity().getJuminShubetsuCode());
            csvEntity.set氏名(entity.get宛名Entity().getKanjiShimei() == null
                    || entity.get宛名Entity().getKanjiShimei().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getKanjiShimei().getColumnValue());
            csvEntity.set氏名カナ(entity.get宛名Entity().getKanaShimei() == null
                    || entity.get宛名Entity().getKanaShimei().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getKanaShimei().getColumnValue());
            csvEntity.set生年月日(dataToRString(entity.get宛名Entity().getSeinengappiYMD()));
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(), 宛名.get消除異動年月日());
            csvEntity.set年齢(ageCalculator.get年齢());
            csvEntity.set性別(entity.get宛名Entity().getSeibetsuCode());
            csvEntity.set続柄コード(entity.get宛名Entity().getTsuzukigaraCode() == null
                    || entity.get宛名Entity().getTsuzukigaraCode().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getTsuzukigaraCode().getColumnValue());
            csvEntity.set世帯コード(entity.get宛名Entity().getSetaiCode() == null
                    || entity.get宛名Entity().getSetaiCode().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getSetaiCode().getColumnValue());
            csvEntity.set世帯主名(entity.get宛名Entity().getSetainushiMei() == null
                    || entity.get宛名Entity().getSetainushiMei().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getSetainushiMei().getColumnValue());
            csvEntity.set住所コード(entity.get宛名Entity().getZenkokuJushoCode() == null
                    || entity.get宛名Entity().getZenkokuJushoCode().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getZenkokuJushoCode().getColumnValue());
            csvEntity.set郵便番号(entity.get宛名Entity().getYubinNo() == null
                    || entity.get宛名Entity().getYubinNo().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getYubinNo().isEmpty()
                    ? RString.EMPTY : entity.get宛名Entity().getYubinNo().getColumnValue());
            set住所番地方書(entity, csvEntity);
            set宛名本人(entity, csvEntity);
        }
    }

    private void set住所番地方書(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get宛名Entity().getBanchi() != null
                && entity.get宛名Entity().getBanchi() != null
                && entity.get宛名Entity().getKatagaki() != null
                && !entity.get宛名Entity().getJusho().isEmpty()
                && !entity.get宛名Entity().getBanchi().isEmpty()
                && !entity.get宛名Entity().getKatagaki().isEmpty()) {
            csvEntity.set住所番地方書(entity.get宛名Entity().getJusho().getColumnValue()
                    .concat(entity.get宛名Entity().getBanchi().getColumnValue()).concat(new RString("　"))
                    .concat(entity.get宛名Entity().getKatagaki().getColumnValue()));
        }
        csvEntity.set住所(entity.get宛名Entity().getJusho() == null
                || entity.get宛名Entity().getJusho().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getJusho().getColumnValue());
        csvEntity.set番地(entity.get宛名Entity().getBanchi() == null
                || entity.get宛名Entity().getBanchi().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getBanchi().getColumnValue());
        csvEntity.set方書(entity.get宛名Entity().getKatagaki() == null
                || entity.get宛名Entity().getKatagaki().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getKatagaki().getColumnValue());

    }

    private void set宛名本人(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {

        csvEntity.set行政区コード(entity.get宛名Entity().getGyoseikuCode() == null
                || entity.get宛名Entity().getGyoseikuCode().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getGyoseikuCode().getColumnValue());
        csvEntity.set行政区名(entity.get宛名Entity().getGyoseikuName());
        csvEntity.set地区１(entity.get宛名Entity().getChikuCode1() == null
                || entity.get宛名Entity().getChikuCode1().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getChikuCode1().getColumnValue());
        csvEntity.set地区２(entity.get宛名Entity().getChikuCode2() == null
                || entity.get宛名Entity().getChikuCode2().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getChikuCode2().getColumnValue());
        csvEntity.set地区３(entity.get宛名Entity().getChikuCode3() == null
                || entity.get宛名Entity().getChikuCode3().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getChikuCode3().getColumnValue());
        csvEntity.set連絡先１(entity.get宛名Entity().getRenrakusaki1().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getRenrakusaki1().getColumnValue());
        csvEntity.set連絡先２(entity.get宛名Entity().getRenrakusaki2() == null
                || entity.get宛名Entity().getRenrakusaki2().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getRenrakusaki2().getColumnValue());
        csvEntity.set登録異動日(dataToRString(entity.get宛名Entity().getTorokuIdoYMD()));
        csvEntity.set登録事由(entity.get宛名Entity().getTorokuJiyuCode());
        csvEntity.set登録届出日(dataToRString(entity.get宛名Entity().getTorokuTodokedeYMD()));
        csvEntity.set住定異動日(dataToRString(entity.get宛名Entity().getJuteiIdoYMD()));
        csvEntity.set住定事由(entity.get宛名Entity().getJuteiJiyuCode());
        csvEntity.set住定届出日(dataToRString(entity.get宛名Entity().getJuteiTodokedeYMD()));
        csvEntity.set消除異動日(dataToRString(entity.get宛名Entity().getShojoIdoYMD()));
        csvEntity.set消除事由(entity.get宛名Entity().getShojoJiyuCode());
        csvEntity.set消除届出日(dataToRString(entity.get宛名Entity().getShojoTodokedeYMD()));
        //TODO
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(entity.get宛名Entity().getTennyumaeYubinNo() == null
                || entity.get宛名Entity().getTennyumaeYubinNo().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getTennyumaeYubinNo().getColumnValue());
        set前住所番地方書(entity, csvEntity);
    }

    private void set前住所番地方書(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get宛名Entity().getTennyumaeJusho() != null
                && entity.get宛名Entity().getTennyumaeBanchi() != null
                && entity.get宛名Entity().getTennyumaeKatagaki() != null
                && !entity.get宛名Entity().getTennyumaeJusho().isEmpty()
                && !entity.get宛名Entity().getTennyumaeBanchi().isEmpty()
                && !entity.get宛名Entity().getTennyumaeKatagaki().isEmpty()) {
            csvEntity.set前住所番地方書(entity.get宛名Entity().getTennyumaeJusho().getColumnValue()
                    .concat(entity.get宛名Entity().getTennyumaeBanchi().getColumnValue()).concat(new RString("　"))
                    .concat(entity.get宛名Entity().getTennyumaeKatagaki().getColumnValue()));
        }
        csvEntity.set前住所(entity.get宛名Entity().getTennyumaeJusho() == null
                || entity.get宛名Entity().getTennyumaeJusho().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getTennyumaeJusho().getColumnValue());
        csvEntity.set前住所番地(entity.get宛名Entity().getTennyumaeBanchi() == null
                || entity.get宛名Entity().getTennyumaeBanchi().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getTennyumaeBanchi().getColumnValue());
        csvEntity.set前住所方書(entity.get宛名Entity().getTennyumaeKatagaki() == null
                || entity.get宛名Entity().getTennyumaeKatagaki().isEmpty()
                ? RString.EMPTY : entity.get宛名Entity().getTennyumaeKatagaki().getColumnValue());

    }

    private void set宛先(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            csvEntity.set送付先氏名(entity.get宛先Entity().getKanjiShimei() == null
                    || entity.get宛先Entity().getKanjiShimei().isEmpty()
                    ? RString.EMPTY : entity.get宛先Entity().getKanjiShimei().getColumnValue());
            csvEntity.set送付先氏名カナ(entity.get宛先Entity().getKanaShimei() == null
                    || entity.get宛先Entity().getKanaShimei().isEmpty()
                    ? RString.EMPTY : entity.get宛先Entity().getKanjiShimei().getColumnValue());
            csvEntity.set送付先住所コード(entity.get宛先Entity().getZenkokuJushoCode() == null
                    || entity.get宛先Entity().getZenkokuJushoCode().isEmpty()
                    ? RString.EMPTY : entity.get宛先Entity().getKanjiShimei().getColumnValue());
            csvEntity.set送付先郵便番号(entity.get宛先Entity().getYubinNo() == null
                    || entity.get宛先Entity().getYubinNo().isEmpty()
                    ? RString.EMPTY : entity.get宛先Entity().getKanjiShimei().getColumnValue());

            csvEntity.set送付先行政区コード(entity.get宛先Entity().getGyoseikuCode() == null
                    || entity.get宛先Entity().getGyoseikuCode().isEmpty()
                    ? RString.EMPTY : entity.get宛先Entity().getGyoseikuCode().getColumnValue());
            csvEntity.set送付先行政区名(entity.get宛先Entity().getGyoseiku());
            set送付先住所番地方書(entity, csvEntity);
        }
    }

    private void set送付先住所番地方書(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get宛先Entity().getJusho() != null
                && entity.get宛先Entity().getBanchi() != null
                && entity.get宛先Entity().getKatagaki() != null
                && !entity.get宛先Entity().getJusho().isEmpty()
                && !entity.get宛先Entity().getBanchi().isEmpty()
                && !entity.get宛先Entity().getKatagaki().isEmpty()) {
            csvEntity.set送付先住所番地方書(entity.get宛先Entity().getJusho().getColumnValue()
                    .concat(entity.get宛先Entity().getBanchi().getColumnValue()).concat(new RString("　"))
                    .concat(entity.get宛先Entity().getKatagaki().getColumnValue()));
        }
        csvEntity.set送付先住所(entity.get宛先Entity().getJusho() == null
                || entity.get宛先Entity().getJusho().isEmpty()
                ? RString.EMPTY : entity.get宛先Entity().getJusho().getColumnValue());
        csvEntity.set送付先番地(entity.get宛先Entity().getBanchi() == null
                || entity.get宛先Entity().getBanchi().isEmpty()
                ? RString.EMPTY : entity.get宛先Entity().getBanchi().getColumnValue());
        csvEntity.set送付先方書(entity.get宛先Entity().getKatagaki() == null
                || entity.get宛先Entity().getKatagaki().isEmpty()
                ? RString.EMPTY : entity.get宛先Entity().getKatagaki().getColumnValue());

    }

    private void set福祉用具(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get福祉用具Entity() != null) {
            csvEntity.set購入年月日(dataToRString(entity.get福祉用具Entity().getFukushiYoguHanbaiYMD()));
            csvEntity.set商品名(entity.get福祉用具Entity().getFukushiYoguShohinName());
            csvEntity.set種目名(entity.get福祉用具Entity().getFukushiYoguShumokuCode());
            csvEntity.set製造事業者名(entity.get福祉用具Entity().getFukushiYoguSeizoJigyoshaName());
            csvEntity.set販売事業者名(entity.get福祉用具Entity().getFukushiYoguHanbaiJigyoshaName());
            csvEntity.set購入金額(new RString(String.valueOf(entity.get福祉用具Entity().getKounyuKingaku())));
            csvEntity.set品目名(entity.get福祉用具Entity().getHinmokuCode());
            csvEntity.set販売事業者名(entity.get福祉用具Entity().getFukushiYoguHanbaiJigyoshaName());
        }
    }

    private void set請求住宅(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get請求住宅Entity() != null) {
            csvEntity.set着工年月日(dataToRString(entity.get請求住宅Entity().getJutakuKaishuChakkoYMD()));
            csvEntity.set完成年月日(dataToRString(entity.get請求住宅Entity().getJutakuKaishuKanseiYMD()));
            csvEntity.set改修事業者名(entity.get請求住宅Entity().getJutakuKaishuJigyoshaName());
            csvEntity.set住宅住所(entity.get請求住宅Entity().getJutakuKaishuJutakuAddress());
            csvEntity.set購入金額(new RString(String.valueOf(entity.get請求住宅Entity().getKaishuKingaku())));
        }
    }

    private void set支給申請(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get支給申請Entity() != null) {
            csvEntity.setサービス提供年月(entity.get支給申請Entity().getServiceTeikyoYM() == null
                    || entity.get支給申請Entity().getServiceTeikyoYM().isEmpty()
                    || entity.get支給申請Entity().getServiceTeikyoYM() == null
                    ? RString.EMPTY : entity.get支給申請Entity().getServiceTeikyoYM().toDateString());
            csvEntity.set整理番号(entity.get支給申請Entity().getSeiriNo());
            if (entity.get請求基本Entity() != null) {
                csvEntity.set整理番号(entity.get請求基本Entity().getYoshikiNo());
            }
            csvEntity.set給付証記載保険者番号(entity.get支給申請Entity().getShoKisaiHokenshaNo() == null
                    || entity.get支給申請Entity().getShoKisaiHokenshaNo().isEmpty()
                    ? RString.EMPTY : entity.get支給申請Entity().getShoKisaiHokenshaNo().value());
            csvEntity.set申請日(dataToRString(entity.get支給申請Entity().getShinseiYMD()));
            csvEntity.set申請理由(entity.get支給申請Entity().getShinseiRiyu());
            csvEntity.set申請区分(get申請区分(entity));
            csvEntity.set申請氏名(entity.get支給申請Entity().getShinseishaNameKanji());
            csvEntity.set申請氏名カナ(entity.get支給申請Entity().getShinseishaNameKana());
            csvEntity.set申請電話番号(entity.get支給申請Entity().getShinseishaTelNo() == null
                    || entity.get支給申請Entity().getShinseishaTelNo().isEmpty()
                    ? RString.EMPTY : entity.get支給申請Entity().getShinseishaTelNo().value());
            csvEntity.set申請支払金額(numToRString(entity.get支給申請Entity().getShiharaiKingakuTotal()));
            csvEntity.set受付日(dataToRString(entity.get支給申請Entity().getUketsukeYMD()));
            csvEntity.set保険請求額(new RString(String.valueOf(entity.get支給申請Entity().getHokenKyufugaku())));
            csvEntity.set自己負担額(new RString(String.valueOf(entity.get支給申請Entity().getRiyoshaFutangaku())));
            csvEntity.set支払方法(entity.get支給申請Entity().getShiharaiHohoKubunCode());
            csvEntity.set国保連送付年月(entity.get支給申請Entity().getSofuYM() == null
                    || entity.get支給申請Entity().getSofuYM().isEmpty()
                    ? RString.EMPTY : entity.get支給申請Entity().getSofuYM().toDateString());
            csvEntity.set申請状態(entity.get支給申請Entity().getKaishuShinseiKubun());
            csvEntity.set施行完了予定日(dataToRString(entity.get支給住宅Entity().getSekoKanryoYoteiYMD()));
            RString 申請取消事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, 申請取消事由コード種別,
                    new Code(entity.get支給申請Entity().getKaishuShinseiTorikeshijiyuCode()), FlexibleDate.getNowDate());
            csvEntity.set申請取消事由(RString.EMPTY);
            csvEntity.set支給届出年月日(dataToRString(entity.get支給申請Entity().getShinseiYMD()));
            csvEntity.set支給受付年月日(dataToRString(entity.get支給申請Entity().getUketsukeYMD()));
            csvEntity.set領収年月日(dataToRString(entity.get支給申請Entity().getRyoshuYMD()));
            csvEntity.set支払場所(entity.get支給申請Entity().getShiharaiBasho());
            csvEntity.set支払開始日(dataToRString(entity.get支給申請Entity().getShiharaiKaishiYMD()));
            csvEntity.set支払終了日(dataToRString(entity.get支給申請Entity().getShiharaiShuryoYMD()));
            if (entity.get支給申請Entity().getShiharaiKaishiYMD() != null
                    && !entity.get支給申請Entity().getShiharaiKaishiYMD().isEmpty()) {
                csvEntity.set支払開始曜日(new RString(entity.get支給申請Entity().getShiharaiKaishiYMD()
                        .getDayOfWeek().toString()));
            }
            if (entity.get支給申請Entity().getShiharaiShuryoYMD() != null
                    && !entity.get支給申請Entity().getShiharaiShuryoYMD().isEmpty()) {
                csvEntity.set支払終了曜日(new RString(entity.get支給申請Entity().getShiharaiShuryoYMD()
                        .getDayOfWeek().toString()));
            }
            csvEntity.set支払開始時間(entity.get支給申請Entity().getShiharaiKaishiTime());
            csvEntity.set支払終了時間(entity.get支給申請Entity().getShiharaiShuryoTime());

        }
    }

    private void set判定結果情報(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get判定結果情報Entity() != null) {
            csvEntity.set決定日(dataToRString(entity.get判定結果情報Entity().getKetteiYMD()));
            csvEntity.set支給不支給区分(entity.get判定結果情報Entity().getShikyuHushikyuKetteiKubun());
            csvEntity.set支払金額(numToRString(entity.get判定結果情報Entity().getShiharaiKingaku()));
            csvEntity.set通知書作成日(dataToRString(entity.get判定結果情報Entity().getKetteiTsuchishoSakuseiYMD()));
            csvEntity.set通知書Ｎo(entity.get判定結果情報Entity().getKetteiTsuchiNo());
            csvEntity.set振込書作成日(dataToRString(entity.get判定結果情報Entity().getFurikomiMeisaishoSakuseiYMD()));
        }
    }

    private void set被保険者台帳管理(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity,
            HokenshaList 保険者リスト) {
        csvEntity.set市町村コード(entity.get市町村コード() == null
                || entity.get市町村コード().isEmpty()
                ? RString.EMPTY : entity.get市町村コード().getColumnValue());
        Association association = AssociationFinderFactory.createInstance().getAssociation(entity.get市町村コード());
        csvEntity.set市町村名(association.get市町村名());
        //TODO
        csvEntity.set保険者コード(RString.EMPTY);
        csvEntity.set保険者名(RString.EMPTY);
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get被保険者番号() == null || entity.get被保険者番号().isEmpty()
                ? RString.EMPTY : entity.get被保険者番号().getColumnValue());
        RString 資格取得事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, 資格取得事由コード種別,
                new Code(entity.get資格取得事由コード()), FlexibleDate.getNowDate());
        csvEntity.set資格取得事由(資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.get資格取得年月日()));
        csvEntity.set資格取得届出日(dataToRString(entity.get資格取得届出年月日()));
        csvEntity.set喪失事由(entity.get資格喪失事由コード());
        csvEntity.set資格喪失日(dataToRString(entity.get資格喪失年月日()));
        csvEntity.set資格喪失届出日(dataToRString(entity.get資格喪失届出年月日()));
        csvEntity.set資格区分(entity.get被保険者区分コード());
        csvEntity.set住所地特例状態(entity.is住所地特例フラグ() ? 住特 : RString.EMPTY);
        csvEntity.set資格証記載保険者番号(get証記載保険者番号(entity, 保険者リスト));
        csvEntity.set受給申請事由(codeToRString(entity.get受給申請事由()));
        csvEntity.set受給申請日(dataToRString(entity.get受給申請年月日()));
        csvEntity.set受給要介護度(codeToRString(entity.get要介護認定状態区分コード()));
        csvEntity.set受給認定開始日(dataToRString(entity.get認定有効期間開始日()));
        csvEntity.set受給認定終了日(dataToRString(entity.get認定有効期間終了日()));
        csvEntity.set受給認定日(dataToRString(entity.get受給認定日()));
        csvEntity.set受給旧措置(entity.get旧措置者フラグ());
        csvEntity.set受給みなし更新認定(codeToRString(entity.getみなし要介護区分コード()));
        csvEntity.set受給直近事由(codeToRString(entity.get直近異動事由コード()));
    }

    private void set口座情報(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoCSVEntity csvEntity) {
        if (entity.get口座情報Entity() != null) {
            csvEntity.set銀行コード(entity.get口座情報Entity().getKinyuKikanCode() == null
                    || entity.get口座情報Entity().getKinyuKikanCode().isEmpty()
                    ? RString.EMPTY : entity.get口座情報Entity().getKinyuKikanCode().getColumnValue());
        }

    }

    private RString get証記載保険者番号(HanyoListShokanbaraiJokyoEntity entity, HokenshaList 保険者リスト) {
        RString 証記載保険者番号 = RString.EMPTY;
        if (entity.is広域内住所地特例フラグ()) {
            if (entity.get広住特措置元市町村コード() == null) {
                return RString.EMPTY;
            }
            証記載保険者番号 = 保険者リスト.get(entity.get広住特措置元市町村コード()).get証記載保険者番号().getColumnValue();
        } else {
            if (entity.get市町村コード() == null) {
                return RString.EMPTY;
            }
            証記載保険者番号 = 保険者リスト.get(entity.get市町村コード()).get証記載保険者番号().getColumnValue();
        }
        return 証記載保険者番号;
    }

    private RString get申請区分(HanyoListShokanbaraiJokyoEntity entity) {
        RString 申請区分 = RString.EMPTY;
        if (ShinseishaKubun.本人.getコード().equals(entity.get支給申請Entity().getShinseishaKubun())) {
            申請区分 = ShinseishaKubun.本人.get名称();
        } else if (ShinseishaKubun.代理人.getコード().equals(entity.get支給申請Entity().getShinseishaKubun())) {
            申請区分 = ShinseishaKubun.代理人.get名称();
        } else if (ShinseishaKubun.受領委任事業者.getコード().equals(entity.get支給申請Entity().getShinseishaKubun())) {
            申請区分 = ShinseishaKubun.受領委任事業者.get名称();
        }
        return 申請区分;
    }

    private RString dataToRString(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }

    private RString numToRString(Decimal 数字) {
        if (数字 == null) {
            return RString.EMPTY;
        }
        return new RString(数字.toString());
    }

    private RString codeToRString(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(code.toString());
    }

}
