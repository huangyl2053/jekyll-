/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.hanyolistshokanbaraijokyo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishu.JutakukaishuShinseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun.KyufuJissekiYoshikiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shinseisha.ShinseishaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.HanyoListShokanbaraiJokyoNoRenbanCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.IIdoJiyu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.DayOfWeek;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 汎用リスト出力(償還払い状況)CSVデータ編集
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
public class HanyoListCsvNoRenbanDataCreate {

    private static final RString 入所施設種類_11 = new RString("11");
    private static final RString 入所施設種類_12 = new RString("12");
    private static final RString 入所施設種類_21 = new RString("21");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString 住特 = new RString("住特");
    private static final RString 他 = new RString("他");
    private static final int INDEX_13 = 13;
    private static final int INDEX_15 = 15;
    private final FlexibleDate システム日付;

    /**
     * コンストラクタ
     *
     * @param システム日付
     */
    public HanyoListCsvNoRenbanDataCreate(FlexibleDate システム日付) {
        this.システム日付 = システム日付;
    }

    /**
     * createCsvData
     *
     * @param entity HanyoListShokanbaraiJokyoEntity
     * @param parameter HanyoListShokanbaraiJokyoProcessParameter
     * @return HanyoListShokanbaraiJokyoNoRenbanCSVEntity
     */
    public HanyoListShokanbaraiJokyoNoRenbanCSVEntity createCsvData(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity = new HanyoListShokanbaraiJokyoNoRenbanCSVEntity();
        set宛名(entity, csvEntity, parameter);
        set宛先(entity, csvEntity);
        set被保険者台帳管理(entity, csvEntity, parameter);
        set介護保険(entity, csvEntity, parameter);
        set支給申請(entity, csvEntity, parameter);
        set判定結果情報(entity, csvEntity, parameter);
        set福祉用具(entity, csvEntity, parameter);
        set請求住宅(entity, csvEntity, parameter);
        set口座情報(entity, csvEntity);
        return csvEntity;
    }

    private void set介護保険(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {

        JigyoshaNo 指定事業者コード = entity.get入所施設コード();
        csvEntity.set指定事業者コード(指定事業者コード != null
                ? 指定事業者コード.getColumnValue() : RString.EMPTY);
        csvEntity.set施設入所日(dataToRString(entity.get入所年月日(), parameter));
        csvEntity.set施設退所日(dataToRString(entity.get退所年月日(), parameter));
        if (入所施設種類_11.equals(entity.get入所施設種類())) {
            set介護事業者(entity, csvEntity, parameter);
        } else if (入所施設種類_12.equals(entity.get入所施設種類()) || 入所施設種類_21.equals(entity.get入所施設種類())) {
            set介護対象施設(entity, csvEntity, parameter);
        }

    }

    private void set介護事業者(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {

        AtenaMeisho 指定事業者名 = entity.get事業者名称_60();
        AtenaKanaMeisho 指定事業者名カナ = entity.get事業者名称カナ_60();
        csvEntity.set指定事業者名(指定事業者名 != null
                ? 指定事業者名.getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者名カナ(指定事業者名カナ != null
                ? 指定事業者名カナ.getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_60() != null
                ? entity.get郵便番号_60().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者住所(entity.get事業者住所_60() != null
                ? entity.get事業者住所_60().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者名(entity.get代表者名_62() != null
                ? entity.get代表者名_62().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_62() != null
                ? entity.get代表者名カナ_62().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者役職(entity.get代表者役職名_62());
        csvEntity.set指定事業者電話番号(entity.get電話番号_60() != null
                ? entity.get電話番号_60().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_60() != null
                ? entity.getFax番号_60().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者ケアマネ数(numToRString(entity.get所属人数()));
        csvEntity.set指定事業者利用者数(numToRString(entity.get利用者数()));
        csvEntity.set指定事業者認定日(dataToRString(entity.get有効開始日_60(), parameter));
        csvEntity.set指定事業者取消日(dataToRString(entity.get有効終了日_60(), parameter));
        csvEntity.set指定事業者実施地域(entity.getサービス実施地域_60());

    }

    private void set介護対象施設(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        csvEntity.set指定事業者名(entity.get事業者名称_05() != null
                ? entity.get事業者名称_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者名カナ(entity.get事業者名称カナ_05() != null
                ? entity.get事業者名称カナ_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者郵便番号(entity.get郵便番号_05() != null
                ? entity.get郵便番号_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者住所(entity.get事業者住所_05() != null
                ? entity.get事業者住所_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者名(entity.get代表者名_05() != null
                ? entity.get代表者名_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者名カナ(entity.get代表者名カナ_05() != null
                ? entity.get代表者名カナ_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者代表者役職(entity.get役職_05());
        csvEntity.set指定事業者電話番号(entity.get電話番号_05() != null
                ? entity.get電話番号_05().getColumnValue() : RString.EMPTY);
        csvEntity.set指定事業者ＦＡＸ番号(entity.getFax番号_05() == null
                ? RString.EMPTY : entity.getFax番号_05().getColumnValue());
        csvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        csvEntity.set指定事業者利用者数(RString.EMPTY);
        csvEntity.set指定事業者認定日(dataToRString(entity.get有効開始日_05(), parameter));
        csvEntity.set指定事業者取消日(dataToRString(entity.get有効終了日_05(), parameter));
        csvEntity.set指定事業者実施地域(RString.EMPTY);
    }

    private void set宛名(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get宛名Entity() != null) {
            ShikibetsuCode 識別コード = entity.get宛名Entity().getShikibetsuCode();
            csvEntity.set識別コード(識別コード != null
                    ? 識別コード.getColumnValue() : RString.EMPTY);
            csvEntity.set住民種別(entity.get宛名Entity().getJuminShubetsuCode());
            AtenaMeisho 氏名 = entity.get宛名Entity().getKanjiShimei();
            csvEntity.set氏名(氏名 != null
                    ? 氏名.getColumnValue() : RString.EMPTY);
            AtenaKanaMeisho 氏名カナ = entity.get宛名Entity().getKanaShimei();
            csvEntity.set氏名カナ(氏名カナ != null
                    ? 氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set生年月日(dataToRString(entity.get宛名Entity().getSeinengappiYMD(), parameter));
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            AgeCalculator ageCalculator = new AgeCalculator(宛名.get生年月日(), 宛名.get住民状態(), 宛名.get消除異動年月日());
            csvEntity.set年齢(ageCalculator.get年齢());
            if (宛名.get性別() != null) {
                csvEntity.set性別(宛名.get性別().getName().getShortJapanese());
            }
            TsuzukigaraCode 続柄コード = entity.get宛名Entity().getTsuzukigaraCode();
            csvEntity.set続柄コード(続柄コード != null
                    ? 続柄コード.getColumnValue() : RString.EMPTY);
            SetaiCode 世帯コード = entity.get宛名Entity().getSetaiCode();
            csvEntity.set世帯コード(世帯コード != null
                    ? 世帯コード.getColumnValue() : RString.EMPTY);
            AtenaMeisho 世帯主名 = entity.get宛名Entity().getSetainushiMei();
            csvEntity.set世帯主名(世帯主名 != null
                    ? 世帯主名.getColumnValue() : RString.EMPTY);
            ZenkokuJushoCode 住所コード = entity.get宛名Entity().getZenkokuJushoCode();
            csvEntity.set住所コード(住所コード != null
                    ? 住所コード.getColumnValue() : RString.EMPTY);
            YubinNo 郵便番号 = entity.get宛名Entity().getYubinNo();
            csvEntity.set郵便番号(郵便番号 != null
                    ? 郵便番号.getColumnValue() : RString.EMPTY);
            set住所番地方書(entity, csvEntity);
            set宛名本人(entity, csvEntity, parameter);
        }
    }

    private void set住所番地方書(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity
    ) {
        if (entity.get宛名Entity() != null) {
            AtenaBanchi 番地 = entity.get宛名Entity().getBanchi();
            Katagaki 方書 = entity.get宛名Entity().getKatagaki();
            AtenaJusho 住所 = entity.get宛名Entity().getJusho();
            if (番地 != null && 方書 != null && 住所 != null) {
                csvEntity.set住所番地方書(住所.getColumnValue()
                        .concat(番地.getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(方書.getColumnValue()));
            }
            csvEntity.set住所(住所 != null
                    ? 住所.getColumnValue() : RString.EMPTY);
            csvEntity.set番地(番地 != null
                    ? 番地.getColumnValue() : RString.EMPTY);
            csvEntity.set方書(方書 != null
                    ? 方書.getColumnValue() : RString.EMPTY);
        }

    }

    private void set宛名本人(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get宛名Entity() != null) {
            IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
            GyoseikuCode 行政区コード = entity.get宛名Entity().getGyoseikuCode();
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
            TelNo 連絡先1 = entity.get宛名Entity().getRenrakusaki1();
            TelNo 連絡先2 = entity.get宛名Entity().getRenrakusaki2();
            YubinNo 前住所郵便番号 = entity.get宛名Entity().getTennyumaeYubinNo();
            csvEntity.set行政区コード(行政区コード != null
                    ? 行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set行政区名(entity.get宛名Entity().getGyoseikuName());
            csvEntity.set地区１(地区1);
            csvEntity.set地区２(地区2);
            csvEntity.set地区３(地区3);
            csvEntity.set連絡先１(連絡先1 != null
                    ? 連絡先1.getColumnValue() : RString.EMPTY);
            csvEntity.set連絡先２(連絡先2 != null
                    ? 連絡先2.getColumnValue() : RString.EMPTY);
            csvEntity.set登録異動日(dataToRString(entity.get宛名Entity().getTorokuIdoYMD(), parameter));
            IIdoJiyu 登録事由 = 宛名.get登録事由();
            IIdoJiyu 住定事由 = 宛名.get住定事由();
            IIdoJiyu 消除事由 = 宛名.get消除事由();
            csvEntity.set登録事由(登録事由 != null ? 登録事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set登録届出日(dataToRString(entity.get宛名Entity().getTorokuTodokedeYMD(), parameter));
            csvEntity.set住定異動日(dataToRString(entity.get宛名Entity().getJuteiIdoYMD(), parameter));
            csvEntity.set住定事由(住定事由 != null ? 住定事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set住定届出日(dataToRString(entity.get宛名Entity().getJuteiTodokedeYMD(), parameter));
            csvEntity.set消除異動日(dataToRString(entity.get宛名Entity().getShojoIdoYMD(), parameter));
            csvEntity.set消除事由(登録事由 != null ? 消除事由.get異動事由略称() : RString.EMPTY);
            csvEntity.set消除届出日(dataToRString(entity.get宛名Entity().getShojoTodokedeYMD(), parameter));
            //TODO
            csvEntity.set転出入理由(RString.EMPTY);
            csvEntity.set前住所郵便番号(前住所郵便番号 != null
                    ? 前住所郵便番号.getColumnValue() : RString.EMPTY);
        }
        set前住所番地方書(entity, csvEntity);
    }

    private void set前住所番地方書(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity) {
        if (entity.get宛名Entity() != null) {
            AtenaJusho 前住所 = entity.get宛名Entity().getTennyumaeJusho();
            AtenaBanchi 前住所番地 = entity.get宛名Entity().getTennyumaeBanchi();
            Katagaki 前住所方書 = entity.get宛名Entity().getTennyumaeKatagaki();

            if (前住所 != null && 前住所番地 != null && 前住所方書 != null) {
                csvEntity.set前住所番地方書(前住所.getColumnValue()
                        .concat(前住所番地.getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(前住所方書.getColumnValue()));
            }
            csvEntity.set前住所(前住所 != null
                    ? 前住所.getColumnValue() : RString.EMPTY);
            csvEntity.set前住所番地(前住所番地 != null
                    ? 前住所番地.getColumnValue() : RString.EMPTY);
            csvEntity.set前住所方書(前住所方書 != null
                    ? 前住所方書.getColumnValue() : RString.EMPTY);
        }

    }

    private void set宛先(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            AtenaMeisho 送付先氏名 = entity.get宛先Entity().getKanjiShimei();
            AtenaKanaMeisho 送付先氏名カナ = entity.get宛先Entity().getKanaShimei();
            ZenkokuJushoCode 送付先住所コード = entity.get宛先Entity().getZenkokuJushoCode();
            YubinNo 送付先郵便番号 = entity.get宛先Entity().getYubinNo();
            GyoseikuCode 送付先行政区コード = entity.get宛先Entity().getGyoseikuCode();
            csvEntity.set送付先氏名(送付先氏名 != null
                    ? 送付先氏名.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先氏名カナ(送付先氏名カナ != null
                    ? 送付先氏名カナ.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先住所コード(送付先住所コード != null
                    ? 送付先住所コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先郵便番号(送付先郵便番号 != null
                    ? 送付先郵便番号.getColumnValue() : RString.EMPTY);

            csvEntity.set送付先行政区コード(送付先行政区コード != null
                    ? 送付先行政区コード.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先行政区名(entity.get宛先Entity().getGyoseiku());
            set送付先住所番地方書(entity, csvEntity);
        }
    }

    private void set送付先住所番地方書(HanyoListShokanbaraiJokyoEntity entity,
            HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity) {
        if (entity.get宛先Entity() != null) {
            AtenaJusho 送付先住所 = entity.get宛先Entity().getJusho();
            AtenaBanchi 送付先番地 = entity.get宛先Entity().getBanchi();
            Katagaki 送付先方書 = entity.get宛先Entity().getKatagaki();
            if (送付先住所 != null && 送付先番地 != null && 送付先方書 != null) {
                csvEntity.set送付先住所番地方書(送付先住所.getColumnValue()
                        .concat(送付先番地.getColumnValue()).concat(RString.FULL_SPACE)
                        .concat(送付先方書.getColumnValue()));
            }
            csvEntity.set送付先住所(送付先住所 != null
                    ? 送付先住所.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先番地(送付先番地 != null
                    ? 送付先番地.getColumnValue() : RString.EMPTY);
            csvEntity.set送付先方書(送付先方書 != null
                    ? 送付先方書.getColumnValue() : RString.EMPTY);
        }

    }

    private void set福祉用具(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get福祉用具Entity() != null) {
            csvEntity.set購入年月日(dataToRString(entity.get福祉用具Entity().getFukushiYoguHanbaiYMD(), parameter));
            csvEntity.set商品名(entity.get福祉用具Entity().getFukushiYoguShohinName());
            csvEntity.set種目名(entity.get福祉用具Entity().getFukushiYoguShumokuCode());
            csvEntity.set製造事業者名(entity.get福祉用具Entity().getFukushiYoguSeizoJigyoshaName());
            csvEntity.set販売事業者名(entity.get福祉用具Entity().getFukushiYoguHanbaiJigyoshaName());
            csvEntity.set購入金額(new RString(String.valueOf(entity.get福祉用具Entity().getKounyuKingaku())));
            csvEntity.set品目名(entity.get福祉用具Entity().getHinmokuCode());
            csvEntity.set販売事業者名(entity.get福祉用具Entity().getFukushiYoguHanbaiJigyoshaName());
        }
    }

    private void set請求住宅(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get請求住宅Entity() != null) {
            csvEntity.set着工年月日(dataToRString(entity.get請求住宅Entity().getJutakuKaishuChakkoYMD(), parameter));
            csvEntity.set完成年月日(dataToRString(entity.get請求住宅Entity().getJutakuKaishuKanseiYMD(), parameter));
            csvEntity.set改修事業者名(entity.get請求住宅Entity().getJutakuKaishuJigyoshaName());
            csvEntity.set住宅住所(entity.get請求住宅Entity().getJutakuKaishuJutakuAddress());
            csvEntity.set購入金額(new RString(String.valueOf(entity.get請求住宅Entity().getKaishuKingaku())));
        }
    }

    private void set支給申請(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get支給申請Entity() != null) {
            FlexibleYearMonth サービス提供年月 = entity.get支給申請Entity().getServiceTeikyoYM();
            ShoKisaiHokenshaNo 給付証記載保険者番号 = entity.get支給申請Entity().getShoKisaiHokenshaNo();
            TelNo 申請電話番号 = entity.get支給申請Entity().getShinseishaTelNo();
            FlexibleYearMonth 国保連送付年月 = entity.get支給申請Entity().getSofuYM();
            csvEntity.setサービス提供年月(monthToRString(サービス提供年月, parameter));
            csvEntity.set整理番号(entity.get支給申請Entity().getSeiriNo());
            csvEntity.set様式番号(get様式番号(entity));
            csvEntity.set給付証記載保険者番号(給付証記載保険者番号 != null
                    ? 給付証記載保険者番号.getColumnValue() : RString.EMPTY);
            csvEntity.set申請日(dataToRString(entity.get支給申請Entity().getShinseiYMD(), parameter));
            csvEntity.set申請理由(entity.get支給申請Entity().getShinseiRiyu());
            csvEntity.set申請区分(get申請区分(entity));
            csvEntity.set申請氏名(entity.get支給申請Entity().getShinseishaNameKanji());
            csvEntity.set申請氏名カナ(entity.get支給申請Entity().getShinseishaNameKana());
            csvEntity.set申請電話番号(申請電話番号 != null
                    ? 申請電話番号.getColumnValue() : RString.EMPTY);
            csvEntity.set申請支払金額(numToRString(entity.get支給申請Entity().getShiharaiKingakuTotal()));
            csvEntity.set受付日(dataToRString(entity.get支給申請Entity().getUketsukeYMD(), parameter));
            csvEntity.set保険請求額(new RString(String.valueOf(entity.get支給申請Entity().getHokenKyufugaku())));
            csvEntity.set自己負担額(new RString(String.valueOf(entity.get支給申請Entity().getRiyoshaFutangaku())));
            csvEntity.set支払方法(entity.get支給申請Entity().getShiharaiHohoKubunCode());
            csvEntity.set国保連送付年月(monthToRString(国保連送付年月, parameter));
            RString 申請状態 = entity.get支給申請Entity().getKaishuShinseiKubun();
            if (申請状態 != null && !申請状態.isEmpty()) {
                JutakukaishuShinseiKubun 住宅改修申請区分 = JutakukaishuShinseiKubun.toValue(申請状態);
                csvEntity.set申請状態(住宅改修申請区分 != null ? 住宅改修申請区分.get名称() : RString.EMPTY);
            }
            if (entity.get支給住宅Entity() != null) {
                csvEntity.set施行完了予定日(dataToRString(entity.get支給住宅Entity().getSekoKanryoYoteiYMD(), parameter));
            }
            RString 申請取消事由 = RString.EMPTY;
            RString 申請取消事由Code = entity.get支給申請Entity().getKaishuShinseiTorikeshijiyuCode();
            if (申請取消事由Code != null && !申請取消事由Code.isEmpty()) {
                申請取消事由 = CodeMaster.getCodeMeisho(SubGyomuCode.DBC介護給付, DBCCodeShubetsu.住宅改修費申請取消事由コード.getコード(),
                        new Code(申請取消事由Code), FlexibleDate.getNowDate());
            }
            csvEntity.set申請取消事由(申請取消事由);
            csvEntity.set支給届出年月日(dataToRString(entity.get支給申請Entity().getShinseiYMD(), parameter));
            csvEntity.set支給受付年月日(dataToRString(entity.get支給申請Entity().getUketsukeYMD(), parameter));
            csvEntity.set領収年月日(dataToRString(entity.get支給申請Entity().getRyoshuYMD(), parameter));
            csvEntity.set支払場所(entity.get支給申請Entity().getShiharaiBasho());
            csvEntity.set支払開始日(dataToRString(entity.get支給申請Entity().getShiharaiKaishiYMD(), parameter));
            csvEntity.set支払終了日(dataToRString(entity.get支給申請Entity().getShiharaiShuryoYMD(), parameter));
            FlexibleDate 支払開始日 = entity.get支給申請Entity().getShiharaiKaishiYMD();
            FlexibleDate 支払終了日 = entity.get支給申請Entity().getShiharaiShuryoYMD();
            if (支払開始日 != null && !支払開始日.isEmpty()) {
                DayOfWeek 支払開始曜日 = 支払開始日.getDayOfWeek();
                csvEntity.set支払開始曜日(支払開始曜日 != null ? new RString(支払開始曜日.toString()) : RString.EMPTY);
            }
            if (支払終了日 != null && !支払終了日.isEmpty()) {
                DayOfWeek 支払終了曜日 = 支払終了日.getDayOfWeek();
                csvEntity.set支払終了曜日(支払終了曜日 != null ? new RString(支払終了曜日.toString()) : RString.EMPTY);
            }
            csvEntity.set支払開始時間(entity.get支給申請Entity().getShiharaiKaishiTime());
            csvEntity.set支払終了時間(entity.get支給申請Entity().getShiharaiShuryoTime());

        }
    }

    private void set判定結果情報(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (entity.get判定結果情報Entity() != null) {
            csvEntity.set決定日(dataToRString(entity.get判定結果情報Entity().getKetteiYMD(), parameter));
            csvEntity.set支給不支給区分(ShikyuFushikyuKubun.to名称OrDefault(entity.get判定結果情報Entity().getShikyuHushikyuKetteiKubun(), RString.EMPTY));
            csvEntity.set支払金額(numToRString(entity.get判定結果情報Entity().getShiharaiKingaku()));
            csvEntity.set通知書作成日(dataToRString(entity.get判定結果情報Entity().getKetteiTsuchishoSakuseiYMD(), parameter));
            csvEntity.set通知書Ｎo(entity.get判定結果情報Entity().getKetteiTsuchiNo());
            csvEntity.set振込書作成日(dataToRString(entity.get判定結果情報Entity().getFurikomiMeisaishoSakuseiYMD(), parameter));
        }
    }

    private void set被保険者台帳管理(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity,
            HanyoListShokanbaraiJokyoProcessParameter parameter) {

        csvEntity.set市町村コード(entity.get市町村コード() != null
                ? entity.get市町村コード().getColumnValue() : RString.EMPTY);
        Association association = AssociationFinderFactory.createInstance().getAssociation(entity.get市町村コード());
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        csvEntity.set市町村名(association.get市町村名());
        csvEntity.set保険者コード(地方公共団体.get地方公共団体コード().getColumnValue());
        csvEntity.set保険者名(地方公共団体.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get被保険者番号() != null
                ? entity.get被保険者番号().getColumnValue() : RString.EMPTY);
        RString 資格取得事由 = RString.EMPTY;
        if (entity.get資格取得事由コード() != null && !entity.get資格取得事由コード().isEmpty()) {
            資格取得事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格取得事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set資格取得事由(資格取得事由);
        csvEntity.set資格取得日(dataToRString(entity.get資格取得年月日(), parameter));
        csvEntity.set資格取得届出日(dataToRString(entity.get資格取得届出年月日(), parameter));
        RString 資格喪失事由 = RString.EMPTY;
        if (entity.get資格喪失事由コード() != null && !entity.get資格喪失事由コード().isEmpty()) {
            資格喪失事由 = CodeMaster.getCodeRyakusho(SubGyomuCode.DBA介護資格, DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu(),
                    new Code(entity.get資格喪失事由コード()), FlexibleDate.getNowDate());
        }
        csvEntity.set喪失事由(資格喪失事由);
        csvEntity.set資格喪失日(dataToRString(entity.get資格喪失年月日(), parameter));
        csvEntity.set資格喪失届出日(dataToRString(entity.get資格喪失届出年月日(), parameter));
        if (entity.get被保険者区分コード() != null && !entity.get被保険者区分コード().isEmpty()) {
            HihokenshaKubunCode 被保険者区分コード = HihokenshaKubunCode.toValue(entity.get被保険者区分コード());
            csvEntity.set資格区分(被保険者区分コード != null ? 被保険者区分コード.get名称() : RString.EMPTY);
        }
        csvEntity.set住所地特例状態(entity.is住所地特例フラグ() ? 住特 : RString.EMPTY);
        csvEntity.set資格証記載保険者番号(get証記載保険者番号(entity));
        csvEntity.set受給申請事由(codeToRString(entity.get受給申請事由()));
        csvEntity.set受給申請日(dataToRString(entity.get受給申請年月日(), parameter));
        if (entity.get要介護認定状態区分コード() == null || entity.get要介護認定状態区分コード().isEmpty()) {
            csvEntity.set受給要介護度(RString.EMPTY);
        } else {
            csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.toValue(システム日付, codeToRString(entity.get要介護認定状態区分コード())).getName());
        }
        csvEntity.set受給認定開始日(dataToRString(entity.get認定有効期間開始日(), parameter));
        csvEntity.set受給認定終了日(dataToRString(entity.get認定有効期間終了日(), parameter));
        csvEntity.set受給認定日(dataToRString(entity.get受給認定日(), parameter));
        csvEntity.set受給旧措置(entity.get旧措置者フラグ());
        csvEntity.set受給みなし更新認定(codeToRString(entity.getみなし要介護区分コード()));
        csvEntity.set受給直近事由(codeToRString(entity.get直近異動事由コード()));

    }

    private void set口座情報(HanyoListShokanbaraiJokyoEntity entity, HanyoListShokanbaraiJokyoNoRenbanCSVEntity csvEntity) {
        KozaRelateEntity releteEntity = entity.get口座情報Entity();
        if (releteEntity != null) {
            IKoza 口座 = new Koza(releteEntity);
            if (口座.isゆうちょ銀行()) {
                csvEntity.set銀行郵便区分(INDEX_2);
                csvEntity.set支店コード(口座.get店番());
            } else {
                csvEntity.set銀行郵便区分(INDEX_1);
                KinyuKikanShitenCode 支店コード = 口座.get支店コード();
                csvEntity.set支店コード(支店コード != null ? 支店コード.getColumnValue() : RString.EMPTY);
            }
            KinyuKikanCode 銀行コード = 口座.get金融機関コード();
            KinyuKikan 金融機関 = 口座.get金融機関();
            KinyuKikanShiten 支店 = 口座.get支店();
            csvEntity.set銀行コード(銀行コード != null ? 銀行コード.getColumnValue() : RString.EMPTY);
            csvEntity.set銀行名カナ(金融機関 != null ? 金融機関.get金融機関カナ名称() : RString.EMPTY);
            csvEntity.set銀行名(金融機関 != null ? 金融機関.get金融機関名称() : RString.EMPTY);
            csvEntity.set支店名カナ(支店 != null ? 支店.get支店カナ名称() : RString.EMPTY);
            csvEntity.set支店名(支店 != null ? 支店.get支店名称() : RString.EMPTY);
            YokinShubetsuPattern 口座種目 = 口座.get預金種別();
            csvEntity.set口座種目(口座種目 != null ? 口座種目.get預金種別名称() : RString.EMPTY);
            csvEntity.set口座番号(口座.get口座番号());
            csvEntity.set名義人カナ短(RString.EMPTY);
            csvEntity.set名義人短(RString.EMPTY);
            AtenaKanaMeisho 名義人カナ = 口座.get口座名義人();
            csvEntity.set名義人カナ(名義人カナ != null ? 名義人カナ.getColumnValue() : RString.EMPTY);
            AtenaMeisho 名義人 = 口座.get口座名義人漢字();
            csvEntity.set名義人(名義人 != null ? 名義人.getColumnValue() : RString.EMPTY);
        }

    }

    private RString get証記載保険者番号(HanyoListShokanbaraiJokyoEntity entity) {
        HokenshaList 保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        HokenshaSummary 保険者;
        if (entity.is広域内住所地特例フラグ()) {
            if (entity.get広住特措置元市町村コード() == null) {
                return RString.EMPTY;
            }
            保険者 = 保険者リスト.get(entity.get広住特措置元市町村コード());

        } else {
            if (entity.get市町村コード() == null) {
                return RString.EMPTY;
            }
            保険者 = 保険者リスト.get(entity.get市町村コード());
        }
        ShoKisaiHokenshaNo 証記載保険者番号 = 保険者.get証記載保険者番号();
        return 証記載保険者番号 != null ? 証記載保険者番号.getColumnValue() : RString.EMPTY;
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

    private RString get様式番号(HanyoListShokanbaraiJokyoEntity entity) {
        RStringBuilder builder = new RStringBuilder();
        Map<RString, Object> map様式番号 = new HashMap<>();
        List<DbT3038ShokanKihonEntity> 請求基本List = entity.get請求基本List();
        if (請求基本List == null || 請求基本List.isEmpty()) {
            return RString.EMPTY;
        }
        List<RString> lst様式番号 = new ArrayList<>();
        for (int i = 0; i < 請求基本List.size(); i++) {
            if (map様式番号.containsKey(請求基本List.get(i).getYoshikiNo())) {
                continue;
            }
            map様式番号.put(請求基本List.get(i).getYoshikiNo(), true);
            lst様式番号.add(KyufuJissekiYoshikiKubun.toValue(請求基本List.get(i).getYoshikiNo()).get様式番号());
        }
        if (lst様式番号.size() == 1) {
            return lst様式番号.get(0);
        }
        for (int i = 1; i < lst様式番号.size(); i++) {
            builder.append(lst様式番号.get(i - 1));

            if (builder.toRString().length() + 1 + lst様式番号.get(i).length() < INDEX_13) {
                builder.append(RString.FULL_SPACE);
                if (i == lst様式番号.size() - 1) {
                    builder.append(lst様式番号.get(i));
                }
            } else {
                if (i == (lst様式番号.size() - 1) && (builder.toRString().length() + 1 + lst様式番号.get(i).length()) < INDEX_15) {
                    builder.append(RString.FULL_SPACE);
                    builder.append(lst様式番号.get(i));
                    break;
                }
                builder.append(RString.FULL_SPACE).append(他);
                break;
            }
        }

        return builder.toRString();
    }

    private RString dataToRString(FlexibleDate 日付, HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.is日付スラッシュ付加()) {
            return 日付.seireki().separator(Separator.NONE).fillType(FillType.NONE).toDateString();
        } else {
            return 日付.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
    }

    private RString monthToRString(FlexibleYearMonth 日付, HanyoListShokanbaraiJokyoProcessParameter parameter) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        if (!parameter.is日付スラッシュ付加()) {
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

    private RString codeToRString(Code code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return new RString(code.toString());
    }

}
