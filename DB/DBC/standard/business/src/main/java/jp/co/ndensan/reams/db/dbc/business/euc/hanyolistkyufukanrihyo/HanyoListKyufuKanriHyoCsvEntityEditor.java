/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyufukanrihyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.JigyoshoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kyotakuservice.KyufukanrihyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710080.HanyoListKyufuKanriHyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710080.HanyoListKyufuKanriHyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710080.HanyoListKyufuKanriHyoNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080.HanyoListKyufuKanriHyoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.ShikakuShutokuJiyuHihokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.ShikakuSositsuJiyuHihokensha;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 汎用リスト(給付管理票)CSVデータの編集クラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
public class HanyoListKyufuKanriHyoCsvEntityEditor {

    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_訪問通所 = new RString("訪問通所");
    private static final RString 定数_短期入所 = new RString("短期入所");
    private static final RString 定数_居宅 = new RString("居宅");
    private static final RString 定数_住特 = new RString("住特");
    private static final RString 定数_初回申請 = new RString("初回申請");
    private static final RString 定数_再申請内 = new RString("再申請内");
    private static final RString 定数_再申請外 = new RString("再申請外");
    private static final RString 定数_支援から申請 = new RString("支援から申請");
    private static final RString 定数_区分変更申請 = new RString("区分変更申請");
    private static final RString 定数_サ変更申請 = new RString("サ変更申請");
    private static final RString 定数_施行前申請 = new RString("施行前申請");
    private static final RString 定数_追加 = new RString("追加");
    private static final RString 定数_旧措置者 = new RString("旧措置者");
    private static final RString 定数_みなし = new RString("みなし");
    private static final RString SLASH = new RString("/");
    private static final RString 追加_認定 = new RString("認定　　　　　");
    private static final RString 要介護度変更申請認定 = new RString("変更申請認定　");
    private static final RString 要介護度変更申請却下 = new RString("変更申請却下　");
    private static final RString サービス種類変更申請認定 = new RString("サ変更申請認定");
    private static final RString サービス種類変更申請却下 = new RString("サ変更申請却下");
    private static final RString 削除 = new RString("削除　　　　　");
    private static final RString 修正 = new RString("修正　　　　　");
    private static final RString 受給申請却下 = new RString("受給申請却下　");
    private static final RString 削除回復 = new RString("削除回復　　　");
    private static final RString 職権記載 = new RString("職権記載　　　");
    private static final RString 職権修正 = new RString("職権修正　　　");
    private static final RString 職権取消 = new RString("職権取消　　　");
    private static final RString 履歴修正 = new RString("履歴修正　　　");
    private static final RString HEADER_連番 = new RString("連番");
    private static final RString HEADER_識別コード = new RString("識別コード");
    private static final RString HEADER_住民種別 = new RString("住民種別");
    private static final RString HEADER_氏名 = new RString("氏名");
    private static final RString HEADER_氏名カナ = new RString("氏名カナ");
    private static final RString HEADER_生年月日 = new RString("生年月日");
    private static final RString HEADER_年齢 = new RString("年齢");
    private static final RString HEADER_性別 = new RString("性別");
    private static final RString HEADER_続柄コード = new RString("続柄コード");
    private static final RString HEADER_世帯コード = new RString("世帯コード");
    private static final RString HEADER_世帯主名 = new RString("世帯主名");
    private static final RString HEADER_住所コード = new RString("住所コード");
    private static final RString HEADER_郵便番号 = new RString("郵便番号");
    private static final RString HEADER_住所番地方書 = new RString("住所＋番地＋方書");
    private static final RString HEADER_住所 = new RString("住所");
    private static final RString HEADER_番地 = new RString("番地");
    private static final RString HEADER_方書 = new RString("方書");
    private static final RString HEADER_行政区コード = new RString("行政区コード");
    private static final RString HEADER_行政区名 = new RString("行政区名");
    private static final RString HEADER_地区１ = new RString("地区１");
    private static final RString HEADER_地区２ = new RString("地区２");
    private static final RString HEADER_地区３ = new RString("地区３");
    private static final RString HEADER_連絡先１ = new RString("連絡先１");
    private static final RString HEADER_連絡先２ = new RString("連絡先２");
    private static final RString HEADER_登録異動日 = new RString("登録異動日");
    private static final RString HEADER_登録事由 = new RString("登録事由");
    private static final RString HEADER_登録届出日 = new RString("登録届出日");
    private static final RString HEADER_住定異動日 = new RString("住定異動日");
    private static final RString HEADER_住定事由 = new RString("住定事由");
    private static final RString HEADER_住定届出日 = new RString("住定届出日");
    private static final RString HEADER_消除異動日 = new RString("消除異動日");
    private static final RString HEADER_消除事由 = new RString("消除事由");
    private static final RString HEADER_消除届出日 = new RString("消除届出日");
    private static final RString HEADER_転出入理由 = new RString("転出入理由");
    private static final RString HEADER_前住所郵便番号 = new RString("前住所郵便番号");
    private static final RString HEADER_前住所番地方書 = new RString("前住所＋番地＋方書");
    private static final RString HEADER_前住所 = new RString("前住所");
    private static final RString HEADER_前住所番地 = new RString("前住所番地");
    private static final RString HEADER_前住所方書 = new RString("前住所方書");
    private static final RString HEADER_市町村コード = new RString("市町村コード");
    private static final RString HEADER_市町村名 = new RString("市町村名");
    private static final RString HEADER_保険者コード = new RString("保険者コード");
    private static final RString HEADER_保険者名 = new RString("保険者名");
    private static final RString HEADER_空白 = new RString("空白");
    private static final RString HEADER_被保険者番号 = new RString("被保険者番号");
    private static final RString HEADER_資格取得事由 = new RString("資格取得事由");
    private static final RString HEADER_資格取得日 = new RString("資格取得日");
    private static final RString HEADER_資格取得届出日 = new RString("資格取得届出日");
    private static final RString HEADER_喪失事由 = new RString("喪失事由");
    private static final RString HEADER_資格喪失日 = new RString("資格喪失日");
    private static final RString HEADER_資格喪失届日 = new RString("資格喪失届日");
    private static final RString HEADER_資格区分 = new RString("資格区分");
    private static final RString HEADER_住所地特例状態 = new RString("住所地特例状態");
    private static final RString HEADER_資格証記載保険者番号 = new RString("（資格）証記載保険者番号");
    private static final RString HEADER_審査年月 = new RString("審査年月");
    private static final RString HEADER_サービス年月 = new RString("サービス年月");
    private static final RString HEADER_明細行番号 = new RString("明細行番号");
    private static final RString HEADER_計画事業者番号 = new RString("計画事業者番号");
    private static final RString HEADER_計画事業者名 = new RString("計画事業者名");
    private static final RString HEADER_保険者番号 = new RString("保険者番号");
    private static final RString HEADER_管理票作成日 = new RString("管理票作成日");
    private static final RString HEADER_管理票作成区分 = new RString("管理票作成区分");
    private static final RString HEADER_管理票種別区分 = new RString("管理票種別区分");
    private static final RString HEADER_管理票生年月日 = new RString("管理票生年月日");
    private static final RString HEADER_管理票性別 = new RString("管理票性別");
    private static final RString HEADER_管理票要介護度 = new RString("管理票要介護度");
    private static final RString HEADER_限度額適用開始 = new RString("限度額適用開始");
    private static final RString HEADER_限度額適用終了 = new RString("限度額適用終了");
    private static final RString HEADER_支給限度額 = new RString("支給限度額");
    private static final RString HEADER_計画作成区分 = new RString("計画作成区分");
    private static final RString HEADER_サービス事業者番号 = new RString("サービス事業者番号");
    private static final RString HEADER_サービス事業者名 = new RString("サービス事業者名");
    private static final RString HEADER_事業者区分 = new RString("事業者区分");
    private static final RString HEADER_サービス種類 = new RString("サービス種類");
    private static final RString HEADER_サービス種類名 = new RString("サービス種類名");
    private static final RString HEADER_給付計画単位日数 = new RString("給付計画単位日数");
    private static final RString HEADER_前月まで計画日数 = new RString("前月まで計画日数");
    private static final RString HEADER_指定サービス小計 = new RString("指定サービス小計");
    private static final RString HEADER_基準該当サービス小計 = new RString("基準該当サービス小計");
    private static final RString HEADER_合計単位日数 = new RString("合計単位日数");
    private static final RString HEADER_担当介護支援専門員番号 = new RString("担当介護支援専門員番号");
    private static final RString HEADER_委託先の居宅介護支援事業者番号 = new RString("委託先の居宅介護支援事業者番号");
    private static final RString HEADER_委託先の居宅介護支援事業者名 = new RString("委託先の居宅介護支援事業者名");
    private static final RString HEADER_委託先の担当介護支援専門員番号 = new RString("委託先の担当介護支援専門員番号");
    private static final RString HEADER_受給申請事由 = new RString("受給申請事由");
    private static final RString HEADER_受給申請日 = new RString("受給申請日");
    private static final RString HEADER_受給要介護度 = new RString("受給要介護度");
    private static final RString HEADER_受給認定開始日 = new RString("受給認定開始日");
    private static final RString HEADER_受給認定終了日 = new RString("受給認定終了日");
    private static final RString HEADER_受給認定日 = new RString("受給認定日");
    private static final RString HEADER_受給旧措置 = new RString("受給旧措置");
    private static final RString HEADER_受給みなし更新認定 = new RString("受給みなし更新認定");
    private static final RString HEADER_受給直近事由 = new RString("受給直近事由");

    private final HanyoListKyufuKanriHyoEntity entity;
    private final HanyoListKyufuKanriHyoProcessParameter param;
    private final Association 地方公共団体情報;
    private final Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private final FlexibleDate システム日付;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     * @param param param
     * @param 地方公共団体情報 地方公共団体情報
     * @param 構成市町村マスタ 構成市町村マスタ
     * @param システム日付 システム日付
     * @param 連番 連番
     */
    public HanyoListKyufuKanriHyoCsvEntityEditor(HanyoListKyufuKanriHyoEntity entity, HanyoListKyufuKanriHyoProcessParameter param,
            Association 地方公共団体情報, Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ, FlexibleDate システム日付, int 連番) {
        this.entity = entity;
        this.param = param;
        this.地方公共団体情報 = 地方公共団体情報;
        this.構成市町村マスタ = 構成市町村マスタ;
        this.システム日付 = システム日付;
        this.連番 = 連番;
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyufuKanriHyoCsvEntity}
     */
    public HanyoListKyufuKanriHyoCsvEntity edit() {
        HanyoListKyufuKanriHyoCsvEntity csvEntity = new HanyoListKyufuKanriHyoCsvEntity();
        edit_part2(csvEntity);
        edit_part3(csvEntity);
        csvEntity.set審査年月(format日付項目(entity.getShinsaYM()));
        csvEntity.setサービス年月(format日付項目(entity.getServiceTeikyoYM()));
        csvEntity.set明細行番号(entity.getKyufuMeisaiLineNo());
        JigyoshaNo kyotakushienJigyoshoNo = entity.getKyotakushienJigyoshoNo();
        if (kyotakushienJigyoshoNo != null) {
            csvEntity.set計画事業者番号(kyotakushienJigyoshoNo.getColumnValue());
        }
        if (定数_2.equals(entity.getKyotakuServicePlanSakuseiKubunCode())
                || entity.get計画事業者() == null) {
            csvEntity.set計画事業者名(RString.EMPTY);
        } else {
            csvEntity.set計画事業者名(entity.get計画事業者().getJigyoshaName().getColumnValue());
        }
        HokenshaNo hokenshaNo = entity.getHokenshaNo();
        if (hokenshaNo != null) {
            csvEntity.set保険者番号(hokenshaNo.getColumnValue());
        }
        csvEntity.set管理票作成日(format日付項目(entity.getKyufuSakuseiYMD()));
        if (!RString.isNullOrEmpty(entity.getKyufuSakuseiKubunCode())) {
            csvEntity.set管理票作成区分(KyufukanrihyoSakuseiKubun.toValue(
                    entity.getKyufuSakuseiKubunCode()).get名称());
        }
        if (定数_1.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_訪問通所);
        } else if (定数_2.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_短期入所);
        } else if (定数_3.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_居宅);
        } else {
            csvEntity.set管理票種別区分(RString.EMPTY);
        }
        csvEntity.set管理票生年月日(format日付項目(entity.getHiHokenshaUmareYMD()));
        if (entity.getSeibetsuCode() != null) {
            csvEntity.set管理票性別(Seibetsu.toValue(entity.getSeibetsuCode()).get名称());
        }
        csvEntity.set管理票要介護度(entity.getYoKaigoJotaiKubunCode());
        csvEntity.set限度額適用開始(format日付項目(entity.getGendogakuTekiyoKaishiYM()));
        csvEntity.set限度額適用終了(format日付項目(entity.getGendogakuTekiyoShuryoYM()));
        csvEntity.set支給限度額(new RString(entity.getKyotakuKaigoYoboShikyuGendogaku()));
        if (entity.getKyotakuServicePlanSakuseiKubunCode() != null) {
            csvEntity.set計画作成区分(KyotakuservicekeikakuSakuseikubunCode.toValue(
                    entity.getKyotakuServicePlanSakuseiKubunCode()).get名称());
        }
        JigyoshaNo serviceJigyoshoNo = entity.getServiceJigyoshoNo();
        if (serviceJigyoshoNo != null) {
            csvEntity.setサービス事業者番号(serviceJigyoshoNo.getColumnValue());
        }
        if (entity.getサービス事業者() != null) {
            csvEntity.setサービス事業者名(entity.getサービス事業者().getJigyoshaName().getColumnValue());
        }
//        if (!RString.isNullOrEmpty(entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode())) {
//            csvEntity.set事業者区分(JigyoshoKubun.toValue(
//                    entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode()).get名称());
//        }
        ServiceShuruiCode serviceShuruiCode = entity.getServiceShuruiCode();
        if (serviceShuruiCode != null) {
            csvEntity.setサービス種類(serviceShuruiCode.getColumnValue());
        }
        if (entity.getサービス種類() != null) {
            csvEntity.setサービス種類名(entity.getサービス種類().getServiceShuruiMeisho());
        }
        csvEntity.set給付計画単位日数(new RString(entity.getKyufuKeikakuTanisuNissu()));
        csvEntity.set前月まで計画日数(new RString(entity.getKyufuKeikakuNissu()));
        csvEntity.set指定サービス小計(new RString(entity.getShiteiServiceSubTotal()));
        csvEntity.set基準該当サービス小計(new RString(entity.getKijyunGaitoServiceSubTotal()));
        csvEntity.set合計単位日数(new RString(entity.getKyufuKeikakuTotalTanisuNissu()));
        csvEntity.set担当介護支援専門員番号(entity.getTantoKaigoShienSemmoninNo());
        JigyoshaNo kaigoShienJigyoshaNo = entity.getKaigoShienJigyoshaNo();
        if (kaigoShienJigyoshaNo != null) {
            csvEntity.set委託先の居宅介護支援事業者番号(kaigoShienJigyoshaNo.getColumnValue());
        }
        csvEntity.set委託先の担当介護支援専門員番号(entity.getItakusakiTantoKaigoShienSemmoninNo());
        if (entity.get居宅支援事業者() != null) {
            csvEntity.set委託先の居宅介護支援事業者名(entity.get居宅支援事業者().getJigyoshaName().getColumnValue());
        }
        return csvEntity;

    }

    private void edit_part2(HanyoListKyufuKanriHyoCsvEntity csvEntity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        if (param.is連番付加()) {
            csvEntity.set連番(new RString(連番));
        }
        csvEntity.set識別コード(kojin.get識別コード().getColumnValue());
        csvEntity.set住民種別(kojin.get住民状態().住民状態略称());
        csvEntity.set氏名(kojin.get名称().getName().getColumnValue());
        csvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
        csvEntity.set生年月日(format日付項目(kojin.get生年月日().toFlexibleDate()));
        csvEntity.set年齢(kojin.get年齢算出().get年齢());
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
        csvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
        csvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
        csvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
        csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
        if (kojin.get住所().get方書() != null && !kojin.get住所().get方書().isEmpty()) {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue())
                    .concat(RString.FULL_SPACE).concat(kojin.get住所().get方書().getColumnValue()));
        } else {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set住所(kojin.get住所().get住所());
        csvEntity.set番地(kojin.get住所().get番地().getBanchi().getColumnValue());
        csvEntity.set方書(kojin.get住所().get方書().getColumnValue());
        csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
        csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
        csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
        csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
        csvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
        csvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
        csvEntity.set登録異動日(format日付項目(kojin.get登録異動年月日()));
        csvEntity.set登録事由(kojin.get登録事由().get異動事由正式名称());
        csvEntity.set登録届出日(format日付項目(kojin.get登録届出年月日()));
        csvEntity.set住定異動日(format日付項目(kojin.get住定異動年月日()));
        csvEntity.set住定事由(kojin.get住定事由().get異動事由正式名称());
        csvEntity.set住定届出日(format日付項目(kojin.get住定届出年月日()));
        csvEntity.set消除異動日(format日付項目(kojin.get消除異動年月日()));
        csvEntity.set消除事由(kojin.get消除事由().get異動事由正式名称());
        csvEntity.set消除届出日(format日付項目(kojin.get消除届出年月日()));
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
        if (kojin.get転入前().get方書() != null && !kojin.get転入前().get方書().isEmpty()) {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()).
                    concat(RString.FULL_SPACE).concat(kojin.get転入前().get方書().getColumnValue()));
        } else {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set前住所(kojin.get転入前().get住所());
        csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().getColumnValue());
        csvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());
        if (entity.get受給者台帳() != null) {
            csvEntity.set受給申請事由(get受給申請事由(entity.get受給者台帳().getJukyuShinseiJiyu().getColumnValue()));

            csvEntity.set受給申請日(format日付項目(entity.get受給者台帳().getJukyuShinseiYMD()));
            if (entity.get受給者台帳() == null
                    || entity.get受給者台帳().getYokaigoJotaiKubunCode() == null
                    || entity.get受給者台帳().getYokaigoJotaiKubunCode().isEmpty()) {
                csvEntity.set受給要介護度(RString.EMPTY);
            } else {
                csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.
                        toValue(システム日付, entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue()).getName());
            }
            csvEntity.set受給認定開始日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanKaishiYMD()));
            csvEntity.set受給認定終了日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set受給認定日(format日付項目(entity.get受給者台帳().getNinteiYMD()));
            if (entity.get受給者台帳().isKyuSochishaFlag()) {
                csvEntity.set受給旧措置(定数_旧措置者);
            } else {
                csvEntity.set受給旧措置(RString.EMPTY);
            }
            if (MinashiCode.通常の認定.getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue())) {
                csvEntity.set受給みなし更新認定(RString.EMPTY);
            } else {
                csvEntity.set受給みなし更新認定(定数_みなし);
            }
            if (entity.get受給者台帳().getChokkinIdoJiyuCode() != null) {
                csvEntity.set受給直近事由(set異動事由文言(entity.get受給者台帳().getChokkinIdoJiyuCode().getColumnValue()));
            }
        }
    }

    private void edit_part3(HanyoListKyufuKanriHyoCsvEntity csvEntity) {
        csvEntity.set市町村コード(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get最新被保台帳().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get市町村名称());
            csvEntity.set資格証記載保険者番号(
                    構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get証記載保険者番号().getColumnValue());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get最新被保台帳().getHihokenshaNo().getColumnValue());
        if (entity.get最新被保台帳().getShikakuShutokuJiyuCode() != null) {
            csvEntity.set資格取得事由(new ShikakuShutokuJiyuHihokensha(entity.get最新被保台帳().getShikakuShutokuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格取得日(format日付項目(entity.get最新被保台帳().getShikakuShutokuYMD()));
        csvEntity.set資格取得届出日(format日付項目(entity.get最新被保台帳().getShikakuShutokuTodokedeYMD()));
        if (entity.get最新被保台帳().getShikakuSoshitsuJiyuCode() != null) {
            csvEntity.set喪失事由(new ShikakuSositsuJiyuHihokensha(entity.get最新被保台帳().getShikakuSoshitsuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格喪失日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuYMD()));
        csvEntity.set資格喪失届日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuTodokedeYMD()));
        if (!RString.isNullOrEmpty(entity.get最新被保台帳().getHihokennshaKubunCode())) {
            csvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get最新被保台帳().getHihokennshaKubunCode()).get名称());
        }
        if (定数_1.equals(entity.get最新被保台帳().getJushochiTokureiFlag())) {
            csvEntity.set住所地特例状態(定数_住特);
        }
        if (定数_1.equals(entity.get最新被保台帳().getKoikinaiJushochiTokureiFlag())) {
            LasdecCode temp = entity.get最新被保台帳().getKoikinaiTokureiSochimotoShichosonCode();
            if (temp != null) {
                csvEntity.set資格証記載保険者番号(temp.getColumnValue());
            }
        } else {
            csvEntity.set資格証記載保険者番号(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        }
    }

    /**
     * CSVレコードを取得します。
     *
     * @return {@link HanyoListKyufuKanriHyoCsvEntity}
     */
    public HanyoListKyufuKanriHyoNoRenbanCsvEntity noRenbanEdit() {
        HanyoListKyufuKanriHyoNoRenbanCsvEntity csvEntity = new HanyoListKyufuKanriHyoNoRenbanCsvEntity();
        noRenbanEdit_part2(csvEntity);
        csvEntity.set審査年月(format日付項目(entity.getShinsaYM()));
        csvEntity.setサービス年月(format日付項目(entity.getServiceTeikyoYM()));
        csvEntity.set明細行番号(entity.getKyufuMeisaiLineNo());
        JigyoshaNo kyotakushienJigyoshoNo = entity.getKyotakushienJigyoshoNo();
        if (kyotakushienJigyoshoNo != null) {
            csvEntity.set計画事業者番号(kyotakushienJigyoshoNo.getColumnValue());
        }
        if (定数_2.equals(entity.getKyotakuServicePlanSakuseiKubunCode())
                || entity.get計画事業者() == null) {
            csvEntity.set計画事業者名(RString.EMPTY);
        } else {
            csvEntity.set計画事業者名(entity.get計画事業者().getJigyoshaName().getColumnValue());
        }
        HokenshaNo hokenshaNo = entity.getHokenshaNo();
        if (hokenshaNo != null) {
            csvEntity.set保険者番号(hokenshaNo.getColumnValue());
        }
        csvEntity.set管理票作成日(format日付項目(entity.getKyufuSakuseiYMD()));
        if (!RString.isNullOrEmpty(entity.getKyufuSakuseiKubunCode())) {
            csvEntity.set管理票作成区分(KyufukanrihyoSakuseiKubun.toValue(
                    entity.getKyufuSakuseiKubunCode()).get名称());
        }
        if (定数_1.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_訪問通所);
        } else if (定数_2.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_短期入所);
        } else if (定数_3.equals(entity.getKyufuShubetsuKubunCode())) {
            csvEntity.set管理票種別区分(定数_居宅);
        } else {
            csvEntity.set管理票種別区分(RString.EMPTY);
        }
        csvEntity.set管理票生年月日(format日付項目(entity.getHiHokenshaUmareYMD()));
        if (entity.getSeibetsuCode() != null) {
            csvEntity.set管理票性別(Seibetsu.toValue(entity.getSeibetsuCode()).get名称());
        }
        csvEntity.set管理票要介護度(entity.getYoKaigoJotaiKubunCode());
        csvEntity.set限度額適用開始(format日付項目(entity.getGendogakuTekiyoKaishiYM()));
        csvEntity.set限度額適用終了(format日付項目(entity.getGendogakuTekiyoShuryoYM()));
        csvEntity.set支給限度額(new RString(entity.getKyotakuKaigoYoboShikyuGendogaku()));
        if (entity.getKyotakuServicePlanSakuseiKubunCode() != null) {
            csvEntity.set計画作成区分(KyotakuservicekeikakuSakuseikubunCode.toValue(
                    entity.getKyotakuServicePlanSakuseiKubunCode()).get名称());
        }
        JigyoshaNo serviceJigyoshoNo = entity.getServiceJigyoshoNo();
        if (serviceJigyoshoNo != null) {
            csvEntity.setサービス事業者番号(serviceJigyoshoNo.getColumnValue());
        }
        if (entity.getサービス事業者() != null) {
            csvEntity.setサービス事業者名(entity.getサービス事業者().getJigyoshaName().getColumnValue());
        }
        if (!RString.isNullOrEmpty(entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode())) {
            csvEntity.set事業者区分(JigyoshoKubun.toValue(
                    entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode()).get名称());
        }
        ServiceShuruiCode serviceShuruiCode = entity.getServiceShuruiCode();
        if (serviceShuruiCode != null) {
            csvEntity.setサービス種類(serviceShuruiCode.getColumnValue());
        }
        if (entity.getサービス種類() != null) {
            csvEntity.setサービス種類名(entity.getサービス種類().getServiceShuruiMeisho());
        }
        csvEntity.set給付計画単位日数(new RString(entity.getKyufuKeikakuTanisuNissu()));
        csvEntity.set前月まで計画日数(new RString(entity.getKyufuKeikakuNissu()));
        csvEntity.set指定サービス小計(new RString(entity.getShiteiServiceSubTotal()));
        csvEntity.set基準該当サービス小計(new RString(entity.getKijyunGaitoServiceSubTotal()));
        csvEntity.set合計単位日数(new RString(entity.getKyufuKeikakuTotalTanisuNissu()));
        csvEntity.set担当介護支援専門員番号(entity.getTantoKaigoShienSemmoninNo());
        JigyoshaNo kaigoShienJigyoshaNo = entity.getKaigoShienJigyoshaNo();
        if (kaigoShienJigyoshaNo != null) {
            csvEntity.set委託先の居宅介護支援事業者番号(kaigoShienJigyoshaNo.getColumnValue());
        }
        csvEntity.set委託先の担当介護支援専門員番号(entity.getItakusakiTantoKaigoShienSemmoninNo());
        if (entity.get居宅支援事業者() != null) {
            csvEntity.set委託先の居宅介護支援事業者名(entity.get居宅支援事業者().getJigyoshaName().getColumnValue());
        }
        return csvEntity;

    }

    private void noRenbanEdit_part2(HanyoListKyufuKanriHyoNoRenbanCsvEntity csvEntity) {
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        csvEntity.set識別コード(kojin.get識別コード().getColumnValue());
        csvEntity.set住民種別(kojin.get住民状態().住民状態略称());
        csvEntity.set氏名(kojin.get名称().getName().getColumnValue());
        csvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
        csvEntity.set生年月日(format日付項目(kojin.get生年月日().toFlexibleDate()));
        csvEntity.set年齢(kojin.get年齢算出().get年齢());
        csvEntity.set性別(kojin.get性別().getName().getShortJapanese());
        csvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
        csvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
        csvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
        csvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
        csvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
        if (kojin.get住所().get方書() != null && !kojin.get住所().get方書().isEmpty()) {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue())
                    .concat(RString.FULL_SPACE).concat(kojin.get住所().get方書().getColumnValue()));
        } else {
            csvEntity.set住所番地方書(kojin.get住所().get住所().concat(kojin.get住所().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set住所(kojin.get住所().get住所());
        csvEntity.set番地(kojin.get住所().get番地().getBanchi().getColumnValue());
        csvEntity.set方書(kojin.get住所().get方書().getColumnValue());
        csvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
        csvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
        csvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
        csvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
        csvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
        csvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
        csvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
        csvEntity.set登録異動日(format日付項目(kojin.get登録異動年月日()));
        csvEntity.set登録事由(kojin.get登録事由().get異動事由正式名称());
        csvEntity.set登録届出日(format日付項目(kojin.get登録届出年月日()));
        csvEntity.set住定異動日(format日付項目(kojin.get住定異動年月日()));
        csvEntity.set住定事由(kojin.get住定事由().get異動事由正式名称());
        csvEntity.set住定届出日(format日付項目(kojin.get住定届出年月日()));
        csvEntity.set消除異動日(format日付項目(kojin.get消除異動年月日()));
        csvEntity.set消除事由(kojin.get消除事由().get異動事由正式名称());
        csvEntity.set消除届出日(format日付項目(kojin.get消除届出年月日()));
        csvEntity.set転出入理由(RString.EMPTY);
        csvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
        if (kojin.get転入前().get方書() != null && !kojin.get転入前().get方書().isEmpty()) {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()).
                    concat(RString.FULL_SPACE).concat(kojin.get転入前().get方書().getColumnValue()));
        } else {
            csvEntity.set前住所番地方書(kojin.get転入前().get住所().concat(kojin.get転入前().get番地().getBanchi().getColumnValue()));
        }
        csvEntity.set前住所(kojin.get転入前().get住所());
        csvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().getColumnValue());
        csvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());
        if (entity.get受給者台帳() != null) {
            csvEntity.set受給申請事由(get受給申請事由(entity.get受給者台帳().getJukyuShinseiJiyu().getColumnValue()));

            csvEntity.set受給申請日(format日付項目(entity.get受給者台帳().getJukyuShinseiYMD()));
            if (entity.get受給者台帳() == null
                    || entity.get受給者台帳().getYokaigoJotaiKubunCode() == null
                    || entity.get受給者台帳().getYokaigoJotaiKubunCode().isEmpty()) {
                csvEntity.set受給要介護度(RString.EMPTY);
            } else {
                csvEntity.set受給要介護度(YokaigoJotaiKubunSupport.
                        toValue(システム日付, entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue()).getName());
            }
            csvEntity.set受給認定開始日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanKaishiYMD()));
            csvEntity.set受給認定終了日(format日付項目(entity.get受給者台帳().getNinteiYukoKikanShuryoYMD()));
            csvEntity.set受給認定日(format日付項目(entity.get受給者台帳().getNinteiYMD()));
            if (entity.get受給者台帳().isKyuSochishaFlag()) {
                csvEntity.set受給旧措置(定数_旧措置者);
            } else {
                csvEntity.set受給旧措置(RString.EMPTY);
            }
            if (MinashiCode.通常の認定.getコード().equals(entity.get受給者台帳().getMinashiCode().getColumnValue())) {
                csvEntity.set受給みなし更新認定(RString.EMPTY);
            } else {
                csvEntity.set受給みなし更新認定(定数_みなし);
            }
            if (entity.get受給者台帳().getChokkinIdoJiyuCode() != null) {
                csvEntity.set受給直近事由(set異動事由文言(entity.get受給者台帳().getChokkinIdoJiyuCode().getColumnValue()));
            }
        }
        csvEntity.set市町村コード(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        if (構成市町村マスタ.containsKey(entity.get最新被保台帳().getShichosonCode())) {
            csvEntity.set市町村名(構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get市町村名称());
            csvEntity.set資格証記載保険者番号(
                    構成市町村マスタ.get(entity.get最新被保台帳().getShichosonCode()).get証記載保険者番号().getColumnValue());
        }
        csvEntity.set保険者コード(地方公共団体情報.getLasdecCode_().getColumnValue());
        csvEntity.set保険者名(地方公共団体情報.get市町村名());
        csvEntity.set空白(RString.EMPTY);
        csvEntity.set被保険者番号(entity.get最新被保台帳().getHihokenshaNo().getColumnValue());
        if (entity.get最新被保台帳().getShikakuShutokuJiyuCode() != null) {
            csvEntity.set資格取得事由(new ShikakuShutokuJiyuHihokensha(entity.get最新被保台帳().getShikakuShutokuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格取得日(format日付項目(entity.get最新被保台帳().getShikakuShutokuYMD()));
        csvEntity.set資格取得届出日(format日付項目(entity.get最新被保台帳().getShikakuShutokuTodokedeYMD()));
        if (entity.get最新被保台帳().getShikakuSoshitsuJiyuCode() != null) {
            csvEntity.set喪失事由(new ShikakuSositsuJiyuHihokensha(entity.get最新被保台帳().getShikakuSoshitsuJiyuCode()).getRyakusho());
        }
        csvEntity.set資格喪失日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuYMD()));
        csvEntity.set資格喪失届日(format日付項目(entity.get最新被保台帳().getShikakuSoshitsuTodokedeYMD()));
        if (!RString.isNullOrEmpty(entity.get最新被保台帳().getHihokennshaKubunCode())) {
            csvEntity.set資格区分(HihokenshaKubunCode.toValue(entity.get最新被保台帳().getHihokennshaKubunCode()).get名称());
        }
        if (定数_1.equals(entity.get最新被保台帳().getJushochiTokureiFlag())) {
            csvEntity.set住所地特例状態(定数_住特);
        }
        if (定数_1.equals(entity.get最新被保台帳().getKoikinaiJushochiTokureiFlag())) {
            LasdecCode temp = entity.get最新被保台帳().getKoikinaiTokureiSochimotoShichosonCode();
            if (temp != null) {
                csvEntity.set資格証記載保険者番号(temp.getColumnValue());
            }
        } else {
            csvEntity.set資格証記載保険者番号(entity.get最新被保台帳().getShichosonCode().getColumnValue());
        }
    }

    private RString get受給申請事由(RString key) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(key)) {
            return 定数_初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(key)) {
            return 定数_再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(key)) {
            return 定数_再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(key)) {
            if (NinteiShienShinseiKubun.認定支援申請.getコード().
                    equals(entity.get受給者台帳().getYokaigoJotaiKubunCode().getColumnValue())) {
                return 定数_支援から申請;
            } else {
                return 定数_区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(key)) {
            return 定数_サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(key)) {
            return 定数_施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(key)) {
            return 定数_追加;
        }
        return RString.EMPTY;
    }

    private RString format日付項目(FlexibleDate date) {

        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付スラッシュ付加()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }

    private RString format日付項目(FlexibleYearMonth date) {

        if (date == null) {
            return RString.EMPTY;
        }
        RString temp = date.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).
                toDateString();
        if (!param.is日付スラッシュ付加()) {
            temp = temp.replace(SLASH, RString.EMPTY);
        }
        return temp;
    }

    private RString set異動事由文言(RString 異動事由コード) {
        if (RString.isNullOrEmpty(異動事由コード)) {
            return RString.EMPTY;
        }
        RString 直近異動事由 = ChokkinIdoJiyuCode.toValue(異動事由コード).get名称();
        if (ChokkinIdoJiyuCode.未登録.get名称().equals(直近異動事由)) {
            return RString.EMPTY;
        } else if (ChokkinIdoJiyuCode.追加_認定.get名称().equals(直近異動事由)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.get名称().equals(直近異動事由)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.get名称().equals(直近異動事由)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.get名称().equals(直近異動事由)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.get名称().equals(直近異動事由)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.get名称().equals(直近異動事由)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.get名称().equals(直近異動事由)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.get名称().equals(直近異動事由)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.get名称().equals(直近異動事由)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.get名称().equals(直近異動事由)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.get名称().equals(直近異動事由)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.get名称().equals(直近異動事由)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.get名称().equals(直近異動事由)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }

    /**
     * CSVのHeaderを取得します。
     *
     * @return HanyoListKyufuKanriHyoCsvEntity
     */
    public static HanyoListKyufuKanriHyoCsvEntity getHeader() {
        return new HanyoListKyufuKanriHyoCsvEntity(
                HEADER_連番,
                HEADER_識別コード,
                HEADER_住民種別,
                HEADER_氏名,
                HEADER_氏名カナ,
                HEADER_生年月日,
                HEADER_年齢,
                HEADER_性別,
                HEADER_続柄コード,
                HEADER_世帯コード,
                HEADER_世帯主名,
                HEADER_住所コード,
                HEADER_郵便番号,
                HEADER_住所番地方書,
                HEADER_住所,
                HEADER_番地,
                HEADER_方書,
                HEADER_行政区コード,
                HEADER_行政区名,
                HEADER_地区１,
                HEADER_地区２,
                HEADER_地区３,
                HEADER_連絡先１,
                HEADER_連絡先２,
                HEADER_登録異動日,
                HEADER_登録事由,
                HEADER_登録届出日,
                HEADER_住定異動日,
                HEADER_住定事由,
                HEADER_住定届出日,
                HEADER_消除異動日,
                HEADER_消除事由,
                HEADER_消除届出日,
                HEADER_転出入理由,
                HEADER_前住所郵便番号,
                HEADER_前住所番地方書,
                HEADER_前住所,
                HEADER_前住所番地,
                HEADER_前住所方書,
                HEADER_市町村コード,
                HEADER_市町村名,
                HEADER_保険者コード,
                HEADER_保険者名,
                HEADER_空白,
                HEADER_被保険者番号,
                HEADER_資格取得事由,
                HEADER_資格取得日,
                HEADER_資格取得届出日,
                HEADER_喪失事由,
                HEADER_資格喪失日,
                HEADER_資格喪失届日,
                HEADER_資格区分,
                HEADER_住所地特例状態,
                HEADER_資格証記載保険者番号,
                HEADER_審査年月,
                HEADER_サービス年月,
                HEADER_明細行番号,
                HEADER_計画事業者番号,
                HEADER_計画事業者名,
                HEADER_保険者番号,
                HEADER_管理票作成日,
                HEADER_管理票作成区分,
                HEADER_管理票種別区分,
                HEADER_管理票生年月日,
                HEADER_管理票性別,
                HEADER_管理票要介護度,
                HEADER_限度額適用開始,
                HEADER_限度額適用終了,
                HEADER_支給限度額,
                HEADER_計画作成区分,
                HEADER_サービス事業者番号,
                HEADER_サービス事業者名,
                HEADER_事業者区分,
                HEADER_サービス種類,
                HEADER_サービス種類名,
                HEADER_給付計画単位日数,
                HEADER_前月まで計画日数,
                HEADER_指定サービス小計,
                HEADER_基準該当サービス小計,
                HEADER_合計単位日数,
                HEADER_担当介護支援専門員番号,
                HEADER_委託先の居宅介護支援事業者番号,
                HEADER_委託先の居宅介護支援事業者名,
                HEADER_委託先の担当介護支援専門員番号,
                HEADER_受給申請事由,
                HEADER_受給申請日,
                HEADER_受給要介護度,
                HEADER_受給認定開始日,
                HEADER_受給認定終了日,
                HEADER_受給認定日,
                HEADER_受給旧措置,
                HEADER_受給みなし更新認定,
                HEADER_受給直近事由
        );
    }

    /**
     * CSVのHeaderを取得します。
     *
     * @return HanyoListKyufuKanriHyoNoRenbanCsvEntity
     */
    public static HanyoListKyufuKanriHyoNoRenbanCsvEntity getHeaderNoRenban() {
        return new HanyoListKyufuKanriHyoNoRenbanCsvEntity(
                HEADER_識別コード,
                HEADER_住民種別,
                HEADER_氏名,
                HEADER_氏名カナ,
                HEADER_生年月日,
                HEADER_年齢,
                HEADER_性別,
                HEADER_続柄コード,
                HEADER_世帯コード,
                HEADER_世帯主名,
                HEADER_住所コード,
                HEADER_郵便番号,
                HEADER_住所番地方書,
                HEADER_住所,
                HEADER_番地,
                HEADER_方書,
                HEADER_行政区コード,
                HEADER_行政区名,
                HEADER_地区１,
                HEADER_地区２,
                HEADER_地区３,
                HEADER_連絡先１,
                HEADER_連絡先２,
                HEADER_登録異動日,
                HEADER_登録事由,
                HEADER_登録届出日,
                HEADER_住定異動日,
                HEADER_住定事由,
                HEADER_住定届出日,
                HEADER_消除異動日,
                HEADER_消除事由,
                HEADER_消除届出日,
                HEADER_転出入理由,
                HEADER_前住所郵便番号,
                HEADER_前住所番地方書,
                HEADER_前住所,
                HEADER_前住所番地,
                HEADER_前住所方書,
                HEADER_市町村コード,
                HEADER_市町村名,
                HEADER_保険者コード,
                HEADER_保険者名,
                HEADER_空白,
                HEADER_被保険者番号,
                HEADER_資格取得事由,
                HEADER_資格取得日,
                HEADER_資格取得届出日,
                HEADER_喪失事由,
                HEADER_資格喪失日,
                HEADER_資格喪失届日,
                HEADER_資格区分,
                HEADER_住所地特例状態,
                HEADER_資格証記載保険者番号,
                HEADER_審査年月,
                HEADER_サービス年月,
                HEADER_明細行番号,
                HEADER_計画事業者番号,
                HEADER_計画事業者名,
                HEADER_保険者番号,
                HEADER_管理票作成日,
                HEADER_管理票作成区分,
                HEADER_管理票種別区分,
                HEADER_管理票生年月日,
                HEADER_管理票性別,
                HEADER_管理票要介護度,
                HEADER_限度額適用開始,
                HEADER_限度額適用終了,
                HEADER_支給限度額,
                HEADER_計画作成区分,
                HEADER_サービス事業者番号,
                HEADER_サービス事業者名,
                HEADER_事業者区分,
                HEADER_サービス種類,
                HEADER_サービス種類名,
                HEADER_給付計画単位日数,
                HEADER_前月まで計画日数,
                HEADER_指定サービス小計,
                HEADER_基準該当サービス小計,
                HEADER_合計単位日数,
                HEADER_担当介護支援専門員番号,
                HEADER_委託先の居宅介護支援事業者番号,
                HEADER_委託先の居宅介護支援事業者名,
                HEADER_委託先の担当介護支援専門員番号,
                HEADER_受給申請事由,
                HEADER_受給申請日,
                HEADER_受給要介護度,
                HEADER_受給認定開始日,
                HEADER_受給認定終了日,
                HEADER_受給認定日,
                HEADER_受給旧措置,
                HEADER_受給みなし更新認定,
                HEADER_受給直近事由
        );
    }
}
