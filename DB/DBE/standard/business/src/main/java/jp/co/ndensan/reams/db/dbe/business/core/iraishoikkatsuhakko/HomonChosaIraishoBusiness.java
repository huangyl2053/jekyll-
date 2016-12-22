/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyogaikyotokki.GaikyotokkiA4Business;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.chosahyokihonchosakatamen.ChosahyoKihonchosaKatamenItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbz.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyogaikyochosa.ChosahyoGaikyochosaItem;
import jp.co.ndensan.reams.db.dbz.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.RensakusakiTsuzukigara;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 *
 * バッチ設計_DBE240001_訪問調査依頼書発行のBusinessクラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class HomonChosaIraishoBusiness {

    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
    private static final int INT11 = 11;
    private static final int INT12 = 11;
    private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
    private static final RString 記号_星 = new RString("*");
    private static final RString 文字列0 = new RString("0");
    private static final RString 文字列1 = new RString("1");
    private static final RString 文字列2 = new RString("2");
    private static final RString 文字列3 = new RString("3");
    private static final RString 文字列4 = new RString("4");
    private static final RString 文字列5 = new RString("5");
    private static final RString 記号 = new RString("✔");
    private static final RString YOKAIGOJOTAIKUBUN01 = new RString("01");
    private static final RString YOKAIGOJOTAIKUBUN12 = new RString("12");
    private static final RString YOKAIGOJOTAIKUBUN13 = new RString("13");
    private static final RString YOKAIGOJOTAIKUBUN21 = new RString("21");
    private static final RString YOKAIGOJOTAIKUBUN22 = new RString("22");
    private static final RString YOKAIGOJOTAIKUBUN23 = new RString("23");
    private static final RString YOKAIGOJOTAIKUBUN24 = new RString("24");
    private static final RString YOKAIGOJOTAIKUBUN25 = new RString("25");
    private static final RString TITLE = new RString("調査票差異チェック票");
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString NINTEIOCHOSAIRAISHO = new RString("【認定調査依頼書印刷区分】");
    private static final RString NINTEICHOSAHYO = new RString("【認定調査票印刷区分】");
    private static final RString NINTEICHOSAIRAILIST = new RString("【認定調査依頼リスト】");
    private static final RString NINTEICHOSAITAKUSAKICODE = new RString("　　【認定調査委託先コード】");
    private static final RString NINTEICHOSAINCODE = new RString("　　【認定調査員コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString NINTEICHOSAIRAISYO = new RString("【認定調査依頼書出力区分】");
    private static final RString NINTEICHOSADESIGN = new RString("【認定調査票（デザイン用紙）出力区分】");
    private static final RString TOKKIJIKODESIGN = new RString("【特記事項（デザイン用紙）出力区分】");
    private static final RString NINTEICHOSAOCR = new RString("【認定調査票OCR出力区分】");
    private static final RString TOKKIJIKOOCR = new RString("【特記事項OCR出力区分】");
    private static final RString GAIKYOTOKKI = new RString("【概況特記出力区分】");
    private static final RString NINTEICHOSACHECKHYO = new RString("【認定調査差異チェック表出力区分】");
    private static final RString ZENKONINTEICHOSAHYO = new RString("【前回認定調査結果との比較表出力区分】");
    private static final RString TOKKIJIKO_KOMOKUARI = new RString("【特記事項（項目有り）】");
    private static final RString TOKKIJIKO_KOMOKUNASHI = new RString("【特記事項（項目無し）】");
    private static final RString TOKKIJIKO_FREE = new RString("【特記事項（フリータイプ）】");
    private static final RString TENYURYOKU = new RString("【手入力タイプ】");
    private static final RString NINTEICHOSAIRAICHOHYO = new RString("【認定調査依頼一覧表出力区分】");
    private static final RString NINTEICHOSAIRAIRIREKIICHIRAN = new RString("【認定調査依頼履歴一覧出力区分】");
    private static final RString UESANKAKU = new RString("▲");
    private static final RString SHITASANKAKU = new RString("▼");
    private RString 誕生日明治;
    private RString 誕生日大正;
    private RString 誕生日昭和;
    private RString 性別_男;
    private RString 性別_女;
    private RString 申請年1;
    private RString 申請年2;
    private RString 申請月1;
    private RString 申請月2;
    private RString 申請日1;
    private RString 申請日2;
    private RString shinseishoKanriNo = RString.EMPTY;
    private final HomonChosaIraishoProcessParamter processParamter;
    private final List<ChosahyoSaiCheckhyoRelateEntity> checkEntityList;
    private final Map<RString, RString> 今回連番Map;
    private final Map<RString, RString> 前回連番Map;
    private final RDate 基準日;

    /**
     * コンストラクタです。
     *
     * @param processParamter processParamter
     */
    public HomonChosaIraishoBusiness(HomonChosaIraishoProcessParamter processParamter) {
        this.processParamter = processParamter;
        checkEntityList = new ArrayList<>();
        今回連番Map = new HashMap();
        前回連番Map = new HashMap();
        基準日 = RDate.getNowDate();
    }

    /**
     * 帳票「前回認定調査結果との比較表」Entityの設定メッソドです。
     *
     * @param entity entity
     */
    public void setcheckEntityList(HomonChosaIraishoRelateEntity entity) {
        ChosahyoSaiCheckhyoRelateEntity checkEntity = new ChosahyoSaiCheckhyoRelateEntity();
        今回連番Map.put(entity.get今回連番(), entity.get今回連番に対する調査項目());
        前回連番Map.put(entity.get前回連番(), entity.get前回連番に対する調査項目());
        checkEntity.set審査会日(entity.get介護認定審査会開催年月日());
        checkEntity.set合議体番号(entity.get合議体番号());
        checkEntity.set被保険者番号(entity.get被保険者番号());
        checkEntity.set被保険者氏名(entity.get被保険者氏名());
        checkEntity.set前回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get要介護認定一次判定結果コード()));
        checkEntity.set今回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get今回一次判定結果コード()));
        checkEntity.set前回二次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get二次判定要介護状態区分コード()));
        checkEntity.set今回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get今回認知症高齢者自立度()).get名称());
        checkEntity.set今回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get今回障害高齢者自立度()).get名称());
        checkEntity.set前回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get前回認知症高齢者自立度()).get名称());
        checkEntity.set前回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get前回障害高齢者自立度()).get名称());
        if (entity.get申請書管理番号() != null && !shinseishoKanriNo.equals(entity.get申請書管理番号())) {
            shinseishoKanriNo = entity.get申請書管理番号();
            checkEntityList.add(checkEntity);
        }
    }

    /**
     * 帳票「前回認定調査結果との比較表」EntityListの取得メッソドです。
     *
     * @return List<ChosahyoSaiCheckhyoRelateEntity>
     */
    public List<ChosahyoSaiCheckhyoRelateEntity> getCheckEntityList() {
        return checkEntityList;
    }

    private RString get判定結果(RString 厚労省IF識別コード, RString 判定結果コード) {
        RString 判定結果 = RString.EMPTY;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode99.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode09.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode06.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode02.toValue(判定結果コード).get名称();
        }
        return 判定結果;
    }

    /**
     * DbT5201NinteichosaIraiJohoEntityの取得メッソドです。
     *
     * @param entity entity
     * @return DbT5201NinteichosaIraiJohoEntity
     */
    public DbT5201NinteichosaIraiJohoEntity update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = entity.getDbt5201Entity();
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (文字列1.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                            RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        dbT5201Entity.setNinteichosaKigenYMD(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5201Entity.setNinteichosaKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5201Entity.setNinteichosaKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        if (processParamter.isNinteiChosaIraiChohyo() || processParamter.is認定調査依頼書()) {
            dbT5201Entity.setIraishoShutsuryokuYMD(get発行日(processParamter.getHakkobi()));
        }
        if (is調査票等出力年月日()) {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(get発行日(processParamter.getHakkobi()));
        }
        return dbT5201Entity;
    }

    private FlexibleDate get発行日(RString hakkobi) {
        FlexibleDate 発行日 = FlexibleDate.EMPTY;
        if (!RString.isNullOrEmpty(hakkobi)) {
            発行日 = new FlexibleDate(hakkobi);
        }
        return 発行日;
    }

    private boolean is調査票等出力年月日() {
        return processParamter.is認定調査依頼書()
                || processParamter.is認定調査票_デザイン用紙()
                || processParamter.is特記事項_デザイン用紙()
                || processParamter.is認定調査票OCR()
                || processParamter.is特記事項OCR()
                || processParamter.is概況特記()
                || processParamter.is認定調査差異チェック票()
                || processParamter.is前回認定調査結果との比較表()
                || processParamter.is特記事項_項目あり()
                || processParamter.is特記事項_項目無し()
                || processParamter.is特記事項_フリータイプ()
                || processParamter.is手入力タイプ();
    }

    /**
     * 帳票「認定調査依頼一覧表」のItem設定メッソドです。
     *
     * @param entity entity
     * @param 連番 連番
     * @param ninshoshaSource ninshoshaSource
     * @param 通知文Map 通知文Map
     * @return ChosaIraiIchiranhyoBodyItem
     */
    public ChosaIraiIchiranhyoBodyItem setBodyItem(HomonChosaIraishoRelateEntity entity, int 連番, NinshoshaSource ninshoshaSource,
            Map<Integer, RString> 通知文Map) {
        return new ChosaIraiIchiranhyoBodyItem(
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.koinShoryaku,
                entity.get調査委託先住所_郵便番号(),
                entity.get調査委託先住所(),
                entity.get事業者名称(),
                entity.get代表者名(),
                get認定調査依頼一覧表名称付与(),
                entity.get事業者番号(),
                通知文Map.get(1),
                通知文Map.get(2),
                new RString(String.valueOf(連番)),
                entity.get調査員氏名(),
                entity.get被保険者番号(),
                entity.get認定申請年月日(),
                NinteiShinseiShinseijiKubunCode.toValue(entity.get認定申請区分_申請時_コード()).get名称(),
                entity.get被保険者氏名(),
                entity.get被保険者氏名カナ(),
                Seibetsu.toValue(entity.get性別()).get名称(),
                entity.get生年月日(),
                entity.get住所(),
                entity.get電話番号(),
                set提出期限(entity));
    }

    private RString set提出期限(HomonChosaIraishoRelateEntity entity) {
        RString 提出期限 = RString.EMPTY;
        if (文字列1.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, 基準日, SubGyomuCode.DBE認定支援))) {
            if (文字列0.equals(processParamter.getTeishutsuKigen())) {
                int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                        基準日, SubGyomuCode.DBE認定支援).toString());
                提出期限 = entity.get認定調査依頼年月日() != null && !entity.get認定調査依頼年月日().isEmpty()
                        ? new RString(entity.get認定調査依頼年月日().plusDay(期限日数).toString()) : RString.EMPTY;
            } else if (文字列1.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = RString.EMPTY;
            } else if (文字列2.equals(processParamter.getTeishutsuKigen())) {
                提出期限 = processParamter.getKyotsuHizuke();
            }
        } else {
            提出期限 = entity.get認定調査期限年月日();
        }
        return 提出期限;
    }

    private RString get認定調査依頼一覧表名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼一覧表_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        RString meishoFuyo = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            meishoFuyo = RString.EMPTY;
        } else if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.様.get名称();
        } else if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.殿.get名称();
        }
        return meishoFuyo;
    }

    /**
     * 帳票「認定調査依頼書」のItem設定メッソドです。
     *
     * @param entity entity
     * @param ninshoshaSource ninshoshaSource
     * @param 通知文Map 通知文Map
     * @param 文書番号 文書番号
     * @return ChosaIraishoHeadItem
     */
    public ChosaIraishoHeadItem setChosaIraishoHeadItem(HomonChosaIraishoRelateEntity entity, Map<Integer, RString> 通知文Map,
            NinshoshaSource ninshoshaSource, RString 文書番号) {
        if (entity.get生年月日() != null && !entity.get生年月日().isEmpty()) {
            get年号(new FlexibleDate(entity.get生年月日()));
        }
        get性別(entity.get性別());
        getカスタマーバーコード(entity);
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        return new ChosaIraishoHeadItem(ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.koinShoryaku,
                文書番号,
                entity.get調査委託先住所_郵便番号(),
                entity.get調査委託先住所(),
                entity.get事業者名称(),
                entity.get調査員氏名(),
                get認定調査依頼書名称付与(),
                getカスタマーバーコード(entity),
                entity.get被保険者番号(),
                ConfigNameDBE.認定調査依頼書.get名称(),
                通知文Map.get(1),
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INT3),
                被保険者番号リスト.get(INT4),
                被保険者番号リスト.get(INT5),
                被保険者番号リスト.get(INT6),
                被保険者番号リスト.get(INT7),
                被保険者番号リスト.get(INT8),
                被保険者番号リスト.get(INT9),
                entity.get被保険者氏名カナ(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                entity.get生年月日(),
                entity.get被保険者氏名(),
                性別_男,
                性別_女,
                entity.get郵便番号() != null ? new YubinNo(entity.get郵便番号()).getEditedYubinNo() : RString.EMPTY,
                entity.get住所(),
                entity.get電話番号(),
                entity.get訪問調査先郵便番号() != null ? new YubinNo(entity.get訪問調査先郵便番号()).getEditedYubinNo() : RString.EMPTY,
                entity.get訪問調査先住所(),
                entity.get訪問調査先名称(),
                entity.get訪問調査先電話番号(),
                entity.get認定申請年月日(),
                set提出期限(entity),
                通知文Map.get(2));
    }

    /**
     * 帳票「要介護認定調査票（基本調査）の帳票DBE221012」のItem設定メッソドです。
     *
     * @param entity entity
     * @return ChosahyoKihonchosaKatamenItem
     */
    public ChosahyoKihonchosaKatamenItem setChosahyoKihonchosaKatamenItem(HomonChosaIraishoRelateEntity entity) {
        get申請日(entity);
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        List<RString> 証記載保険者番号リスト = getValueList(entity.get証記載保険者番号());
        return new ChosahyoKihonchosaKatamenItem(
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INT3),
                被保険者番号リスト.get(INT4),
                被保険者番号リスト.get(INT5),
                被保険者番号リスト.get(INT6),
                被保険者番号リスト.get(INT7),
                被保険者番号リスト.get(INT8),
                被保険者番号リスト.get(INT9),
                申請年1,
                申請年2,
                申請月1,
                申請月2,
                申請日1,
                申請日2,
                証記載保険者番号リスト.get(0),
                証記載保険者番号リスト.get(1),
                証記載保険者番号リスト.get(2),
                証記載保険者番号リスト.get(INT3),
                証記載保険者番号リスト.get(INT4),
                証記載保険者番号リスト.get(INT5));
    }

    /**
     * 帳票「要介護認定調査票（概況調査）の帳票DBE221011」のItem設定メッソドです。
     *
     * @param entity entity
     * @return ChosahyoKihonchosaKatamenItem
     */
    public ChosahyoGaikyochosaItem setDBE221011Item(HomonChosaIraishoRelateEntity entity) {
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        List<RString> 証記載保険者番号リスト = getValueList(entity.get証記載保険者番号());
        List<RString> 記入者コードリスト = getValueList(entity.get認定調査員コード());
        List<RString> 定調査委託先コードリスト = getValueList(entity.get認定調査委託先コード());
        get申請日(entity);
        get性別(entity.get性別());
        get年号(entity.get生年月日());
        RString 要支援 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN13.equals(entity.get前回要介護状態区分コード())) {
            要支援 = 記号;
        }
        RString 要支援詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN12.equals(entity.get前回要介護状態区分コード())) {
            要支援詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN13.equals(entity.get前回要介護状態区分コード())) {
            要支援詳細 = 文字列2;
        }
        get年月日(entity.get生年月日());
        return new ChosahyoGaikyochosaItem(証記載保険者番号リスト.get(0),
                証記載保険者番号リスト.get(1),
                証記載保険者番号リスト.get(2),
                証記載保険者番号リスト.get(INT3),
                証記載保険者番号リスト.get(INT4),
                証記載保険者番号リスト.get(INT5),
                申請年1,
                申請年2,
                申請月1,
                申請月2,
                申請日1,
                申請日2,
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INT3),
                被保険者番号リスト.get(INT4),
                被保険者番号リスト.get(INT5),
                被保険者番号リスト.get(INT6),
                被保険者番号リスト.get(INT7),
                被保険者番号リスト.get(INT8),
                被保険者番号リスト.get(INT9),
                記入者コードリスト.get(0),
                記入者コードリスト.get(1),
                記入者コードリスト.get(2),
                記入者コードリスト.get(INT3),
                記入者コードリスト.get(INT4),
                記入者コードリスト.get(INT5),
                記入者コードリスト.get(INT6),
                記入者コードリスト.get(INT7),
                entity.get調査員氏名(),
                定調査委託先コードリスト.get(0),
                定調査委託先コードリスト.get(1),
                定調査委託先コードリスト.get(2),
                定調査委託先コードリスト.get(INT3),
                定調査委託先コードリスト.get(INT4),
                定調査委託先コードリスト.get(INT5),
                定調査委託先コードリスト.get(INT6),
                定調査委託先コードリスト.get(INT7),
                定調査委託先コードリスト.get(INT8),
                定調査委託先コードリスト.get(INT9),
                定調査委託先コードリスト.get(INT11),
                定調査委託先コードリスト.get(INT12),
                entity.get事業者名称(),
                entity.get被保険者氏名カナ(),
                entity.get被保険者氏名(),
                性別_男,
                性別_女,
                entity.get住所(),
                entity.get郵便番号(),
                entity.get電話番号(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                get年月日(entity.get生年月日()),
                !RString.isNullOrEmpty(entity.get生年月日()) ? entity.get生年月日().substring(INT4, INT6) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get生年月日()) ? entity.get生年月日().substring(INT6, INT8) : RString.EMPTY,
                entity.get年齢(),
                entity.get連絡先住所(),
                entity.get連絡先郵便番号(),
                entity.get連絡先電話番号(),
                entity.get連絡先携帯番号(),
                entity.get連絡先氏名(),
                !RString.isNullOrEmpty(entity.get連絡先続柄())
                ? RensakusakiTsuzukigara.toValue(entity.get連絡先続柄()).get名称() : RString.EMPTY,
                RString.isNullOrEmpty(entity.get前回認定年月日()) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? 記号 : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(0, INT4) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(INT4, INT6) : RString.EMPTY,
                !RString.isNullOrEmpty(entity.get前回認定年月日()) ? entity.get前回認定年月日().substring(INT6, INT8) : RString.EMPTY,
                YOKAIGOJOTAIKUBUN01.equals(entity.get前回要介護状態区分コード()) ? 記号 : RString.EMPTY,
                要支援,
                要支援詳細,
                get要介護詳細(entity),
                get要介護詳細(entity.get前回要介護状態区分コード()),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    private RString get年月日(RString 生年月日) {
        RString 年 = RString.EMPTY;
        if (!RString.isNullOrEmpty(生年月日)) {
            年 = new FlexibleYear(生年月日.substring(0, INT4)).wareki().eraType(EraType.KANJI).toDateString().substring(2, INT4);
        }
        return 年;
    }

    private RString get要介護詳細(HomonChosaIraishoRelateEntity entity) {
        RString 要介護 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN22.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN23.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN24.equals(entity.get前回要介護状態区分コード())
                || YOKAIGOJOTAIKUBUN25.equals(entity.get前回要介護状態区分コード())) {
            要介護 = 記号;
        }
        return 要介護;
    }

    private RString get要介護詳細(RString yokaigoJotaiKubun) {
        RString 要介護詳細 = RString.EMPTY;
        if (YOKAIGOJOTAIKUBUN21.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列1;
        } else if (YOKAIGOJOTAIKUBUN22.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列2;
        } else if (YOKAIGOJOTAIKUBUN23.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列3;
        } else if (YOKAIGOJOTAIKUBUN24.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列4;
        } else if (YOKAIGOJOTAIKUBUN25.equals(yokaigoJotaiKubun)) {
            要介護詳細 = 文字列5;
        }
        return 要介護詳細;
    }

    private void get性別(RString 性別コード) {
        if (性別コード.equals(Seibetsu.男.getコード())) {
            性別_男 = 記号;
        } else if (性別コード.equals(Seibetsu.女.getコード())) {
            性別_女 = 記号;
        }
    }

    private void get年号(RString 生年月日) {
        誕生日明治 = RString.EMPTY;
        誕生日大正 = RString.EMPTY;
        誕生日昭和 = RString.EMPTY;
        if (!RString.isNullOrEmpty(生年月日)) {
            RString 年号 = new FlexibleDate(生年月日).wareki().toDateString();
            if (年号.startsWith(年号_明治)) {
                誕生日明治 = 記号;
            } else if (年号.startsWith(年号_大正)) {
                誕生日大正 = 記号;
            } else if (年号.startsWith(年号_昭和)) {
                誕生日昭和 = 記号;
            }
        }
    }

    private void get申請日(HomonChosaIraishoRelateEntity entity) {
        申請年1 = RString.EMPTY;
        申請年2 = RString.EMPTY;
        申請月1 = RString.EMPTY;
        申請月2 = RString.EMPTY;
        申請日1 = RString.EMPTY;
        申請日2 = RString.EMPTY;
        RString 申請日 = entity.get認定申請年月日();
        if (!RString.isNullOrEmpty(申請日)) {
            RString shiseiYMD = new FlexibleDate(申請日).wareki().eraType(EraType.KANJI).toDateString();
            申請年1 = shiseiYMD.substring(2, INT3);
            申請年2 = shiseiYMD.substring(INT3, INT4);
            申請月1 = shiseiYMD.substring(INT5, INT6);
            申請月2 = shiseiYMD.substring(INT6, INT7);
            申請日1 = shiseiYMD.substring(INT8, INT9);
            申請日2 = shiseiYMD.substring(INT9, INT10);
        }
    }

    private RString get認定調査依頼書名称付与() {
        RString key = DbBusinessConfig.get(ConfigNameDBE.認定調査依頼書_宛先敬称, 基準日, SubGyomuCode.DBE認定支援);
        RString meishoFuyo = RString.EMPTY;
        if (ChohyoAtesakiKeisho.なし.getコード().equals(key)) {
            meishoFuyo = RString.EMPTY;
        } else if (ChohyoAtesakiKeisho.様.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.様.get名称();
        } else if (ChohyoAtesakiKeisho.殿.getコード().equals(key)) {
            meishoFuyo = ChohyoAtesakiKeisho.殿.get名称();
        }
        return meishoFuyo;
    }

    private void get年号(FlexibleDate 生年月日) {
        RString 年号 = 生年月日.wareki().toDateString();
        if (年号.startsWith(年号_明治)) {
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_大正)) {
            誕生日明治 = 記号_星;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_昭和)) {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
        } else {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        }
    }

    private RString getカスタマーバーコード(HomonChosaIraishoRelateEntity entity) {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        RString 郵便番号 = entity.get調査委託先住所_郵便番号();
        RString 住所 = entity.get調査委託先住所();
        if (!RString.isNullOrEmpty(郵便番号) && !RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(郵便番号, 住所);
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
    }

    /**
     * 帳票「前回認定調査結果との比較表」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return ChosahyoSaiCheckhyoItem
     */
    public ChosahyoSaiCheckhyoItem setItem(ChosahyoSaiCheckhyoRelateEntity entity) {
        ChosahyoSaiCheckhyoItem item = new ChosahyoSaiCheckhyoItem();
        item.setTitle(TITLE);
        item.setHihokenshaNo(entity.get被保険者番号());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setZenkaiIchijihanteikekka(entity.get前回一次判定結果());
        item.setKonkaiIchijihanteikekka(entity.get今回一次判定結果());
        item.setShinsakaiYMD(entity.get審査会日());
        item.setGogitaiNo(entity.get合議体番号());
        item.setZenkaiNijihanteikekka(entity.get前回二次判定結果());
        setZenkaiChosakekka(item);
        item.setZenkaiChosakekkaNo75(entity.get前回障害高齢者自立度());
        item.setZenkaiChosakekkaNo76(entity.get前回認知症高齢者自立度());
        setKonkaiChosakekka(item);
        item.setKonkaiChosakekkaNo75(entity.get今回障害高齢者自立度());
        item.setKonkaiChosakekkaNo76(entity.get今回認知症高齢者自立度());
        setTokkiFuragu(item);
        return item;
    }

    /**
     * 帳票「要介護認定調査票（特記事項）の帳票DBE221022」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return ChosahyoTokkijikoBusiness
     */
    public ChosahyoTokkijikoBusiness setDBE221022Item(HomonChosaIraishoRelateEntity entity) {
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        List<RString> 証記載保険者番号リスト = getValueList(entity.get証記載保険者番号());
        get申請日(entity);
        return new ChosahyoTokkijikoBusiness(証記載保険者番号リスト.get(0),
                証記載保険者番号リスト.get(1),
                証記載保険者番号リスト.get(2),
                証記載保険者番号リスト.get(INT3),
                証記載保険者番号リスト.get(INT4),
                証記載保険者番号リスト.get(INT5),
                申請年1,
                申請年2,
                申請月1,
                申請月2,
                申請日1,
                申請日2,
                entity.get被保険者氏名(),
                被保険者番号リスト.get(0),
                被保険者番号リスト.get(1),
                被保険者番号リスト.get(2),
                被保険者番号リスト.get(INT3),
                被保険者番号リスト.get(INT4),
                被保険者番号リスト.get(INT5),
                被保険者番号リスト.get(INT6),
                被保険者番号リスト.get(INT7),
                被保険者番号リスト.get(INT8),
                被保険者番号リスト.get(INT9));
    }

    /**
     * 出力条件表Listを取得メッソドです。
     *
     * @return List<RString>
     */
    public List<RString> set出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(ConvertDate(processParamter.getIraiFromYMD()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(ConvertDate(processParamter.getIraiToYMD()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEIOCHOSAIRAISHO);
        builder.append(processParamter.getNinteioChosaIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYO);
        builder.append(processParamter.getNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> ninteiChosaIraiList = processParamter.getNinteiChosaIraiList();
        for (GridParameter gridParameter : ninteiChosaIraiList) {
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAITAKUSAKICODE);
            builder.append(gridParameter.getNinteichosaItakusakiCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAINCODE);
            builder.append(gridParameter.getNinteiChosainCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(ConvertDate(processParamter.getHakkobi()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(ConvertDate(processParamter.getTeishutsuKigen()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(ConvertDate(processParamter.getKyotsuHizuke()));
        出力条件.add(builder.toRString());

        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAISYO);
        builder.append(processParamter.is認定調査依頼書());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSADESIGN);
        builder.append(processParamter.is認定調査票_デザイン用紙());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TOKKIJIKODESIGN);
        builder.append(processParamter.is特記事項_デザイン用紙());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAOCR);
        builder.append(processParamter.is認定調査票OCR());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TOKKIJIKOOCR);
        builder.append(processParamter.is特記事項OCR());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(GAIKYOTOKKI);
        builder.append(processParamter.is概況特記());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSACHECKHYO);
        builder.append(processParamter.is認定調査差異チェック票());
        builder = new RStringBuilder();
        builder.append(ZENKONINTEICHOSAHYO);
        builder.append(processParamter.is前回認定調査結果との比較表());
        builder = new RStringBuilder();
        builder.append(TOKKIJIKO_KOMOKUARI);
        builder.append(processParamter.is特記事項_項目あり());
        builder = new RStringBuilder();
        builder.append(TOKKIJIKO_KOMOKUNASHI);
        builder.append(processParamter.is特記事項_項目無し());
        builder = new RStringBuilder();
        builder.append(TOKKIJIKO_FREE);
        builder.append(processParamter.is特記事項_フリータイプ());
        builder = new RStringBuilder();
        builder.append(TENYURYOKU);
        builder.append(processParamter.is手入力タイプ());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAICHOHYO);
        builder.append(processParamter.isNinteiChosaIraiChohyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAIRIREKIICHIRAN);
        builder.append(processParamter.is認定調査依頼履歴一覧());
        出力条件.add(builder.toRString());
        出力条件.add(builder.toRString());
        出力条件.add(builder.toRString());
        出力条件.add(builder.toRString());
        return 出力条件;
    }

    private RString ConvertDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (!FlexibleDate.canConvert(date)) {
            return date;
        }
        return new FlexibleDate(date).wareki().toDateString();
    }

    private void setZenkaiChosakekka(ChosahyoSaiCheckhyoItem item) {
        item.setZenkaiChosakekkaNo1(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()));
        item.setZenkaiChosakekkaNo2(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()));
        item.setZenkaiChosakekkaNo3(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()));
        item.setZenkaiChosakekkaNo4(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()));
        item.setZenkaiChosakekkaNo5(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()));
        item.setZenkaiChosakekkaNo6(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()));
        item.setZenkaiChosakekkaNo7(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()));
        item.setZenkaiChosakekkaNo8(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()));
        item.setZenkaiChosakekkaNo9(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()));
        item.setZenkaiChosakekkaNo10(前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()));
        item.setZenkaiChosakekkaNo11(前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()));
        item.setZenkaiChosakekkaNo12(前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()));
        item.setZenkaiChosakekkaNo13(前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()));
        item.setZenkaiChosakekkaNo14(前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()));
        item.setZenkaiChosakekkaNo15(前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()));
        item.setZenkaiChosakekkaNo16(前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()));
        item.setZenkaiChosakekkaNo17(前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()));
        item.setZenkaiChosakekkaNo18(前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()));
        item.setZenkaiChosakekkaNo19(前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()));
        item.setZenkaiChosakekkaNo20(前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()));
        item.setZenkaiChosakekkaNo21(前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()));
        item.setZenkaiChosakekkaNo22(前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()));
        item.setZenkaiChosakekkaNo23(前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()));
        item.setZenkaiChosakekkaNo24(前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()));
        item.setZenkaiChosakekkaNo25(前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()));
        item.setZenkaiChosakekkaNo26(前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()));
        item.setZenkaiChosakekkaNo27(前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()));
        item.setZenkaiChosakekkaNo28(前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()));
        item.setZenkaiChosakekkaNo29(前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()));
        item.setZenkaiChosakekkaNo30(前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()));
        item.setZenkaiChosakekkaNo31(前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()));
        item.setZenkaiChosakekkaNo32(前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()));
        item.setZenkaiChosakekkaNo33(前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()));
        item.setZenkaiChosakekkaNo34(前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()));
        item.setZenkaiChosakekkaNo35(前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()));
        item.setZenkaiChosakekkaNo36(前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()));
        item.setZenkaiChosakekkaNo37(前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()));
        item.setZenkaiChosakekkaNo38(前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()));
        item.setZenkaiChosakekkaNo39(前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()));
        item.setZenkaiChosakekkaNo40(前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()));
        item.setZenkaiChosakekkaNo41(前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()));
        item.setZenkaiChosakekkaNo42(前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()));
        item.setZenkaiChosakekkaNo43(前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()));
        item.setZenkaiChosakekkaNo44(前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()));
        item.setZenkaiChosakekkaNo45(前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()));
        item.setZenkaiChosakekkaNo46(前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()));
        item.setZenkaiChosakekkaNo47(前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()));
        item.setZenkaiChosakekkaNo48(前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()));
        item.setZenkaiChosakekkaNo49(前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()));
        item.setZenkaiChosakekkaNo50(前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()));
        item.setZenkaiChosakekkaNo51(前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()));
        item.setZenkaiChosakekkaNo52(前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()));
        item.setZenkaiChosakekkaNo53(前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()));
        item.setZenkaiChosakekkaNo54(前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()));
        item.setZenkaiChosakekkaNo55(前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()));
        item.setZenkaiChosakekkaNo56(前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()));
        item.setZenkaiChosakekkaNo57(前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()));
        item.setZenkaiChosakekkaNo58(前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()));
        item.setZenkaiChosakekkaNo59(前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()));
        item.setZenkaiChosakekkaNo60(前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()));
        item.setZenkaiChosakekkaNo61(前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()));
        item.setZenkaiChosakekkaNo62(前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()));
        item.setZenkaiChosakekkaNo63(前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()));
        item.setZenkaiChosakekkaNo64(前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()));
        item.setZenkaiChosakekkaNo65(前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()));
        item.setZenkaiChosakekkaNo66(前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()));
        item.setZenkaiChosakekkaNo67(前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()));
        item.setZenkaiChosakekkaNo68(前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()));
        item.setZenkaiChosakekkaNo69(前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()));
        item.setZenkaiChosakekkaNo70(前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()));
        item.setZenkaiChosakekkaNo71(前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()));
        item.setZenkaiChosakekkaNo72(前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()));
        item.setZenkaiChosakekkaNo73(前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()));
        item.setZenkaiChosakekkaNo74(前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()));
    }

    private void setKonkaiChosakekka(ChosahyoSaiCheckhyoItem item) {
        item.setKonkaiChosakekkaNo1(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()));
        item.setKonkaiChosakekkaNo2(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()));
        item.setKonkaiChosakekkaNo3(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()));
        item.setKonkaiChosakekkaNo4(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()));
        item.setKonkaiChosakekkaNo5(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()));
        item.setKonkaiChosakekkaNo6(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()));
        item.setKonkaiChosakekkaNo7(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()));
        item.setKonkaiChosakekkaNo8(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()));
        item.setKonkaiChosakekkaNo9(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()));
        item.setKonkaiChosakekkaNo10(今回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()));
        item.setKonkaiChosakekkaNo11(今回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()));
        item.setKonkaiChosakekkaNo12(今回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()));
        item.setKonkaiChosakekkaNo13(今回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()));
        item.setKonkaiChosakekkaNo14(今回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()));
        item.setKonkaiChosakekkaNo15(今回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()));
        item.setKonkaiChosakekkaNo16(今回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()));
        item.setKonkaiChosakekkaNo17(今回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()));
        item.setKonkaiChosakekkaNo18(今回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()));
        item.setKonkaiChosakekkaNo19(今回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()));
        item.setKonkaiChosakekkaNo20(今回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()));
        item.setKonkaiChosakekkaNo21(今回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()));
        item.setKonkaiChosakekkaNo22(今回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()));
        item.setKonkaiChosakekkaNo23(今回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()));
        item.setKonkaiChosakekkaNo24(今回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()));
        item.setKonkaiChosakekkaNo25(今回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()));
        item.setKonkaiChosakekkaNo26(今回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()));
        item.setKonkaiChosakekkaNo27(今回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()));
        item.setKonkaiChosakekkaNo28(今回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()));
        item.setKonkaiChosakekkaNo29(今回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()));
        item.setKonkaiChosakekkaNo30(今回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()));
        item.setKonkaiChosakekkaNo31(今回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()));
        item.setKonkaiChosakekkaNo32(今回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()));
        item.setKonkaiChosakekkaNo33(今回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()));
        item.setKonkaiChosakekkaNo34(今回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()));
        item.setKonkaiChosakekkaNo35(今回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()));
        item.setKonkaiChosakekkaNo36(今回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()));
        item.setKonkaiChosakekkaNo37(今回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()));
        item.setKonkaiChosakekkaNo38(今回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()));
        item.setKonkaiChosakekkaNo39(今回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()));
        item.setKonkaiChosakekkaNo40(今回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()));
        item.setKonkaiChosakekkaNo41(今回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()));
        item.setKonkaiChosakekkaNo42(今回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()));
        item.setKonkaiChosakekkaNo43(今回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()));
        item.setKonkaiChosakekkaNo44(今回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()));
        item.setKonkaiChosakekkaNo45(今回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()));
        item.setKonkaiChosakekkaNo46(今回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()));
        item.setKonkaiChosakekkaNo47(今回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()));
        item.setKonkaiChosakekkaNo48(今回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()));
        item.setKonkaiChosakekkaNo49(今回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()));
        item.setKonkaiChosakekkaNo50(今回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()));
        item.setKonkaiChosakekkaNo51(今回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()));
        item.setKonkaiChosakekkaNo52(今回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()));
        item.setKonkaiChosakekkaNo53(今回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()));
        item.setKonkaiChosakekkaNo54(今回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()));
        item.setKonkaiChosakekkaNo55(今回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()));
        item.setKonkaiChosakekkaNo56(今回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()));
        item.setKonkaiChosakekkaNo57(今回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()));
        item.setKonkaiChosakekkaNo58(今回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()));
        item.setKonkaiChosakekkaNo59(今回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()));
        item.setKonkaiChosakekkaNo60(今回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()));
        item.setKonkaiChosakekkaNo61(今回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()));
        item.setKonkaiChosakekkaNo62(今回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()));
        item.setKonkaiChosakekkaNo63(今回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()));
        item.setKonkaiChosakekkaNo64(今回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()));
        item.setKonkaiChosakekkaNo65(今回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()));
        item.setKonkaiChosakekkaNo66(今回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()));
        item.setKonkaiChosakekkaNo67(今回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()));
        item.setKonkaiChosakekkaNo68(今回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()));
        item.setKonkaiChosakekkaNo69(今回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()));
        item.setKonkaiChosakekkaNo70(今回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()));
        item.setKonkaiChosakekkaNo71(今回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()));
        item.setKonkaiChosakekkaNo72(今回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()));
        item.setKonkaiChosakekkaNo73(今回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()));
        item.setKonkaiChosakekkaNo74(今回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()));
    }

    private void setTokkiFuragu(ChosahyoSaiCheckhyoItem item) {
        item.setTokkiFuraguNo1(set軽重FLG(item.getZenkaiChosakekkaNo1(), item.getKonkaiChosakekkaNo1()));
        item.setTokkiFuraguNo2(set軽重FLG(item.getZenkaiChosakekkaNo2(), item.getKonkaiChosakekkaNo2()));
        item.setTokkiFuraguNo3(set軽重FLG(item.getZenkaiChosakekkaNo3(), item.getKonkaiChosakekkaNo3()));
        item.setTokkiFuraguNo4(set軽重FLG(item.getZenkaiChosakekkaNo4(), item.getKonkaiChosakekkaNo4()));
        item.setTokkiFuraguNo5(set軽重FLG(item.getZenkaiChosakekkaNo5(), item.getKonkaiChosakekkaNo5()));
        item.setTokkiFuraguNo6(set軽重FLG(item.getZenkaiChosakekkaNo6(), item.getKonkaiChosakekkaNo6()));
        item.setTokkiFuraguNo7(set軽重FLG(item.getZenkaiChosakekkaNo7(), item.getKonkaiChosakekkaNo7()));
        item.setTokkiFuraguNo8(set軽重FLG(item.getZenkaiChosakekkaNo8(), item.getKonkaiChosakekkaNo8()));
        item.setTokkiFuraguNo9(set軽重FLG(item.getZenkaiChosakekkaNo9(), item.getKonkaiChosakekkaNo9()));
        item.setTokkiFuraguNo10(set軽重FLG(item.getZenkaiChosakekkaNo10(), item.getKonkaiChosakekkaNo10()));
        item.setTokkiFuraguNo11(set軽重FLG(item.getZenkaiChosakekkaNo11(), item.getKonkaiChosakekkaNo11()));
        item.setTokkiFuraguNo12(set軽重FLG(item.getZenkaiChosakekkaNo12(), item.getKonkaiChosakekkaNo12()));
        item.setTokkiFuraguNo13(set軽重FLG(item.getZenkaiChosakekkaNo13(), item.getKonkaiChosakekkaNo13()));
        item.setTokkiFuraguNo14(set軽重FLG(item.getZenkaiChosakekkaNo14(), item.getKonkaiChosakekkaNo14()));
        item.setTokkiFuraguNo15(set軽重FLG(item.getZenkaiChosakekkaNo15(), item.getKonkaiChosakekkaNo15()));
        item.setTokkiFuraguNo16(set軽重FLG(item.getZenkaiChosakekkaNo16(), item.getKonkaiChosakekkaNo16()));
        item.setTokkiFuraguNo17(set軽重FLG(item.getZenkaiChosakekkaNo17(), item.getKonkaiChosakekkaNo17()));
        item.setTokkiFuraguNo18(set軽重FLG(item.getZenkaiChosakekkaNo18(), item.getKonkaiChosakekkaNo18()));
        item.setTokkiFuraguNo19(set軽重FLG(item.getZenkaiChosakekkaNo19(), item.getKonkaiChosakekkaNo19()));
        item.setTokkiFuraguNo20(set軽重FLG(item.getZenkaiChosakekkaNo20(), item.getKonkaiChosakekkaNo20()));
        item.setTokkiFuraguNo21(set軽重FLG(item.getZenkaiChosakekkaNo21(), item.getKonkaiChosakekkaNo21()));
        item.setTokkiFuraguNo22(set軽重FLG(item.getZenkaiChosakekkaNo22(), item.getKonkaiChosakekkaNo22()));
        item.setTokkiFuraguNo23(set軽重FLG(item.getZenkaiChosakekkaNo23(), item.getKonkaiChosakekkaNo23()));
        item.setTokkiFuraguNo24(set軽重FLG(item.getZenkaiChosakekkaNo24(), item.getKonkaiChosakekkaNo24()));
        item.setTokkiFuraguNo25(set軽重FLG(item.getZenkaiChosakekkaNo25(), item.getKonkaiChosakekkaNo25()));
        item.setTokkiFuraguNo26(set軽重FLG(item.getZenkaiChosakekkaNo26(), item.getKonkaiChosakekkaNo26()));
        item.setTokkiFuraguNo27(set軽重FLG(item.getZenkaiChosakekkaNo27(), item.getKonkaiChosakekkaNo27()));
        item.setTokkiFuraguNo28(set軽重FLG(item.getZenkaiChosakekkaNo28(), item.getKonkaiChosakekkaNo28()));
        item.setTokkiFuraguNo29(set軽重FLG(item.getZenkaiChosakekkaNo29(), item.getKonkaiChosakekkaNo29()));
        item.setTokkiFuraguNo30(set軽重FLG(item.getZenkaiChosakekkaNo30(), item.getKonkaiChosakekkaNo30()));
        item.setTokkiFuraguNo31(set軽重FLG(item.getZenkaiChosakekkaNo31(), item.getKonkaiChosakekkaNo31()));
        item.setTokkiFuraguNo32(set軽重FLG(item.getZenkaiChosakekkaNo32(), item.getKonkaiChosakekkaNo32()));
        item.setTokkiFuraguNo33(set軽重FLG(item.getZenkaiChosakekkaNo33(), item.getKonkaiChosakekkaNo33()));
        item.setTokkiFuraguNo34(set軽重FLG(item.getZenkaiChosakekkaNo34(), item.getKonkaiChosakekkaNo34()));
        item.setTokkiFuraguNo35(set軽重FLG(item.getZenkaiChosakekkaNo35(), item.getKonkaiChosakekkaNo35()));
        item.setTokkiFuraguNo36(set軽重FLG(item.getZenkaiChosakekkaNo36(), item.getKonkaiChosakekkaNo36()));
        item.setTokkiFuraguNo37(set軽重FLG(item.getZenkaiChosakekkaNo37(), item.getKonkaiChosakekkaNo37()));
        item.setTokkiFuraguNo38(set軽重FLG(item.getZenkaiChosakekkaNo38(), item.getKonkaiChosakekkaNo38()));
        item.setTokkiFuraguNo39(set軽重FLG(item.getZenkaiChosakekkaNo39(), item.getKonkaiChosakekkaNo39()));
        item.setTokkiFuraguNo40(set軽重FLG(item.getZenkaiChosakekkaNo40(), item.getKonkaiChosakekkaNo40()));
        item.setTokkiFuraguNo41(set軽重FLG(item.getZenkaiChosakekkaNo41(), item.getKonkaiChosakekkaNo41()));
        item.setTokkiFuraguNo42(set軽重FLG(item.getZenkaiChosakekkaNo42(), item.getKonkaiChosakekkaNo42()));
        item.setTokkiFuraguNo43(set軽重FLG(item.getZenkaiChosakekkaNo43(), item.getKonkaiChosakekkaNo43()));
        item.setTokkiFuraguNo44(set軽重FLG(item.getZenkaiChosakekkaNo44(), item.getKonkaiChosakekkaNo44()));
        item.setTokkiFuraguNo45(set軽重FLG(item.getZenkaiChosakekkaNo45(), item.getKonkaiChosakekkaNo45()));
        item.setTokkiFuraguNo46(set軽重FLG(item.getZenkaiChosakekkaNo46(), item.getKonkaiChosakekkaNo46()));
        item.setTokkiFuraguNo47(set軽重FLG(item.getZenkaiChosakekkaNo47(), item.getKonkaiChosakekkaNo47()));
        item.setTokkiFuraguNo48(set軽重FLG(item.getZenkaiChosakekkaNo48(), item.getKonkaiChosakekkaNo48()));
        item.setTokkiFuraguNo49(set軽重FLG(item.getZenkaiChosakekkaNo49(), item.getKonkaiChosakekkaNo49()));
        item.setTokkiFuraguNo50(set軽重FLG(item.getZenkaiChosakekkaNo50(), item.getKonkaiChosakekkaNo50()));
        item.setTokkiFuraguNo51(set軽重FLG(item.getZenkaiChosakekkaNo51(), item.getKonkaiChosakekkaNo51()));
        item.setTokkiFuraguNo52(set軽重FLG(item.getZenkaiChosakekkaNo52(), item.getKonkaiChosakekkaNo52()));
        item.setTokkiFuraguNo53(set軽重FLG(item.getZenkaiChosakekkaNo53(), item.getKonkaiChosakekkaNo53()));
        item.setTokkiFuraguNo54(set軽重FLG(item.getZenkaiChosakekkaNo54(), item.getKonkaiChosakekkaNo54()));
        item.setTokkiFuraguNo55(set軽重FLG(item.getZenkaiChosakekkaNo55(), item.getKonkaiChosakekkaNo55()));
        item.setTokkiFuraguNo56(set軽重FLG(item.getZenkaiChosakekkaNo56(), item.getKonkaiChosakekkaNo56()));
        item.setTokkiFuraguNo57(set軽重FLG(item.getZenkaiChosakekkaNo57(), item.getKonkaiChosakekkaNo57()));
        item.setTokkiFuraguNo58(set軽重FLG(item.getZenkaiChosakekkaNo58(), item.getKonkaiChosakekkaNo58()));
        item.setTokkiFuraguNo59(set軽重FLG(item.getZenkaiChosakekkaNo59(), item.getKonkaiChosakekkaNo59()));
        item.setTokkiFuraguNo60(set軽重FLG(item.getZenkaiChosakekkaNo60(), item.getKonkaiChosakekkaNo60()));
        item.setTokkiFuraguNo61(set軽重FLG(item.getZenkaiChosakekkaNo61(), item.getKonkaiChosakekkaNo61()));
        item.setTokkiFuraguNo62(set軽重FLG(item.getZenkaiChosakekkaNo62(), item.getKonkaiChosakekkaNo62()));
        item.setTokkiFuraguNo63(set軽重FLG(item.getZenkaiChosakekkaNo63(), item.getKonkaiChosakekkaNo63()));
        item.setTokkiFuraguNo64(set軽重FLG(item.getZenkaiChosakekkaNo64(), item.getKonkaiChosakekkaNo64()));
        item.setTokkiFuraguNo65(set軽重FLG(item.getZenkaiChosakekkaNo65(), item.getKonkaiChosakekkaNo65()));
        item.setTokkiFuraguNo66(set軽重FLG(item.getZenkaiChosakekkaNo66(), item.getKonkaiChosakekkaNo66()));
        item.setTokkiFuraguNo67(set軽重FLG(item.getZenkaiChosakekkaNo67(), item.getKonkaiChosakekkaNo67()));
        item.setTokkiFuraguNo68(set軽重FLG(item.getZenkaiChosakekkaNo68(), item.getKonkaiChosakekkaNo68()));
        item.setTokkiFuraguNo69(set軽重FLG(item.getZenkaiChosakekkaNo69(), item.getKonkaiChosakekkaNo69()));
        item.setTokkiFuraguNo70(set軽重FLG(item.getZenkaiChosakekkaNo70(), item.getKonkaiChosakekkaNo70()));
        item.setTokkiFuraguNo71(set軽重FLG(item.getZenkaiChosakekkaNo71(), item.getKonkaiChosakekkaNo71()));
        item.setTokkiFuraguNo72(set軽重FLG(item.getZenkaiChosakekkaNo72(), item.getKonkaiChosakekkaNo72()));
        item.setTokkiFuraguNo73(set軽重FLG(item.getZenkaiChosakekkaNo73(), item.getKonkaiChosakekkaNo73()));
        item.setTokkiFuraguNo74(set軽重FLG(item.getZenkaiChosakekkaNo74(), item.getKonkaiChosakekkaNo74()));
        item.setTokkiFuraguNo75(set軽重FLG(item.getZenkaiChosakekkaNo75(), item.getKonkaiChosakekkaNo75()));
        item.setTokkiFuraguNo76(set軽重FLG(item.getZenkaiChosakekkaNo76(), item.getKonkaiChosakekkaNo76()));
    }

    private RString set軽重FLG(RString 前回, RString 今回) {
        RString 軽重FLG = RString.EMPTY;
        if (!RString.isNullOrEmpty(前回) && !RString.isNullOrEmpty(今回) && 前回.compareTo(今回) < 0) {
            軽重FLG = UESANKAKU;
        } else if (!RString.isNullOrEmpty(前回) && !RString.isNullOrEmpty(今回) && 今回.compareTo(前回) < 0) {
            軽重FLG = SHITASANKAKU;
        }
        return 軽重FLG;
    }

    /**
     * get認定調査票差異チェック票Listを設定メッソドです。
     *
     * @param entity entity
     * @return
     */
    public ChosahyoSaiCheckhyoRelateEntity set認定調査票差異チェック票List(HomonChosaIraishoRelateEntity entity) {
        ChosahyoSaiCheckhyoRelateEntity checkEntity = new ChosahyoSaiCheckhyoRelateEntity();
        前回連番Map.put(entity.get前回連番(), entity.get前回連番に対する調査項目());
        checkEntity.set被保険者番号(entity.get被保険者番号());
        checkEntity.set被保険者氏名(entity.get被保険者氏名());
        checkEntity.set前回二次判定日(entity.get二次判定年月日());
        checkEntity.set生年月日(entity.get生年月日());
        checkEntity.set年齢(entity.get年齢());
        checkEntity.set前回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get要介護認定一次判定結果コード()));
        checkEntity.set前回二次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get二次判定要介護状態区分コード()));
        checkEntity.set前回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get前回認知症高齢者自立度()).get名称());
        checkEntity.set前回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get前回障害高齢者自立度()).get名称());
        if (entity.get申請書管理番号() != null && !shinseishoKanriNo.equals(entity.get申請書管理番号())) {
            shinseishoKanriNo = entity.get申請書管理番号();
            checkEntityList.add(checkEntity);
        }
        return checkEntity;
    }

    /**
     * 帳票「認定調査票差異チェック票_DBE292001」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return SaiChekkuhyoItem
     */
    public SaiChekkuhyoItem setDBE292001Item(ChosahyoSaiCheckhyoRelateEntity entity) {
        return new SaiChekkuhyoItem(
                entity.get前回一次判定結果(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get年齢(),
                entity.get前回二次判定結果(),
                entity.get前回二次判定日(),
                entity.get生年月日(),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()),
                entity.get前回障害高齢者自立度(),
                entity.get前回認知症高齢者自立度());
    }

    /**
     * 帳票「認定調査票差異チェック票_DBE292002」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return SaiChekkuhyoItem
     */
    public SaiChekkuhyoItem setDBE292002Item(ChosahyoSaiCheckhyoRelateEntity entity) {
        return new SaiChekkuhyoItem(
                entity.get前回一次判定結果(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get年齢(),
                entity.get前回二次判定結果(),
                entity.get前回二次判定日(),
                entity.get生年月日(),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * 帳票「認定調査票差異チェック票_DBE292003」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return SaiChekkuhyoItem
     */
    public SaiChekkuhyoItem setDBE292003Item(ChosahyoSaiCheckhyoRelateEntity entity) {
        return setDBE292002Item(entity);
    }

    /**
     * 帳票「認定調査票差異チェック票_DBE292004」のItemを取得メッソドです。
     *
     * @param entity entity
     * @return SaiChekkuhyoItem
     */
    public SaiChekkuhyoItem setDBE292004Item(ChosahyoSaiCheckhyoRelateEntity entity) {
        return new SaiChekkuhyoItem(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()),
                entity.get前回障害高齢者自立度(),
                entity.get前回認知症高齢者自立度()
        );

    }

    /**
     * 帳票の編集。
     *
     * @param entity HomonChosaIraishoRelateEntity
     * @return GaikyotokkiA4Business
     */
    public GaikyotokkiA4Business setReportEntity(HomonChosaIraishoRelateEntity entity) {
        List<RString> 保険者番号リスト = getValueList(entity.get証記載保険者番号());
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        GaikyotokkiA4Business reportEntity = new GaikyotokkiA4Business();
        reportEntity.setHokenshaNo1(保険者番号リスト.get(0));
        reportEntity.setHokenshaNo2(保険者番号リスト.get(1));
        reportEntity.setHokenshaNo3(保険者番号リスト.get(2));
        reportEntity.setHokenshaNo4(保険者番号リスト.get(INT3));
        reportEntity.setHokenshaNo5(保険者番号リスト.get(INT4));
        reportEntity.setHokenshaNo6(保険者番号リスト.get(INT5));
        RString ninteiShinseiDay = new FlexibleDate(entity.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        reportEntity.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
        reportEntity.setShinseiYY2(ninteiShinseiDay.substring(2, INT3));
        reportEntity.setShinseiMM1(ninteiShinseiDay.substring(INT4, INT5));
        reportEntity.setShinseiMM2(ninteiShinseiDay.substring(INT5, INT6));
        reportEntity.setShinseiDD1(ninteiShinseiDay.substring(INT7, INT8));
        reportEntity.setShinseiDD2(ninteiShinseiDay.substring(INT8));
        reportEntity.setHihokenshaNo1(被保険者番号リスト.get(0));
        reportEntity.setHihokenshaNo2(被保険者番号リスト.get(1));
        reportEntity.setHihokenshaNo3(被保険者番号リスト.get(2));
        reportEntity.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        reportEntity.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        reportEntity.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        reportEntity.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        reportEntity.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        reportEntity.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        reportEntity.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        reportEntity.setShinseishaName(entity.get被保険者氏名());
        return reportEntity;
    }

    /**
     * 帳票の編集。
     *
     * @param entity HomonChosaIraishoRelateEntity
     * @return GaikyotokkiA4Business
     */
    public GaikyotokkiA4Business setDBE221051Item(HomonChosaIraishoRelateEntity entity) {
//            RString ninteiShinseiDay = new FlexibleDate(entity.get認定申請年月日()).wareki().eraType(EraType.ALPHABET).firstYear(FirstYear.ICHI_NEN)
//                    .separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        RString ninteiShinseiDay = entity.get認定申請年月日();
        List<RString> 証記載保険者番号リスト = getValueList(entity.get証記載保険者番号());
        List<RString> 被保険者番号リスト = getValueList(entity.get被保険者番号());
        GaikyotokkiA4Business reportEntity = new GaikyotokkiA4Business();

        reportEntity.setShinseiYY1(ninteiShinseiDay.substring(1, 2));
        reportEntity.setShinseiYY2(ninteiShinseiDay.substring(2, INT3));
        reportEntity.setShinseiMM1(ninteiShinseiDay.substring(INT4, INT5));
        reportEntity.setShinseiMM2(ninteiShinseiDay.substring(INT5, INT6));
        reportEntity.setShinseiDD1(ninteiShinseiDay.substring(INT7, INT8));
        reportEntity.setShinseiDD2(ninteiShinseiDay.substring(INT8));
        reportEntity.setHokenshaNo1(証記載保険者番号リスト.get(0));
        reportEntity.setHokenshaNo2(証記載保険者番号リスト.get(1));
        reportEntity.setHokenshaNo3(証記載保険者番号リスト.get(2));
        reportEntity.setHokenshaNo4(証記載保険者番号リスト.get(INT3));
        reportEntity.setHokenshaNo5(証記載保険者番号リスト.get(INT4));
        reportEntity.setHokenshaNo6(証記載保険者番号リスト.get(INT5));
        reportEntity.setHihokenshaNo1(被保険者番号リスト.get(0));
        reportEntity.setHihokenshaNo2(被保険者番号リスト.get(1));
        reportEntity.setHihokenshaNo3(被保険者番号リスト.get(2));
        reportEntity.setHihokenshaNo4(被保険者番号リスト.get(INT3));
        reportEntity.setHihokenshaNo5(被保険者番号リスト.get(INT4));
        reportEntity.setHihokenshaNo6(被保険者番号リスト.get(INT5));
        reportEntity.setHihokenshaNo7(被保険者番号リスト.get(INT6));
        reportEntity.setHihokenshaNo8(被保険者番号リスト.get(INT7));
        reportEntity.setHihokenshaNo9(被保険者番号リスト.get(INT8));
        reportEntity.setHihokenshaNo10(被保険者番号リスト.get(INT9));
        reportEntity.setShinseishaName(entity.get被保険者氏名());
        return reportEntity;
    }

    private List<RString> getValueList(RString value) {
        List<RString> valueList = new ArrayList<>();
        for (int i = 0; i <= INT9; i++) {
            valueList.add(RString.EMPTY);
        }
        if (0 < value.length()) {
            valueList.set(0, value.substring(0, 1));
        }
        if (1 < value.length()) {
            valueList.set(1, value.substring(1, 2));
        }
        if (2 < value.length()) {
            valueList.set(2, value.substring(2, INT3));
        }
        if (INT3 < value.length()) {
            valueList.set(INT3, value.substring(INT3, INT4));
        }
        if (INT4 < value.length()) {
            valueList.set(INT4, value.substring(INT4, INT5));
        }
        if (INT5 < value.length()) {
            valueList.set(INT5, value.substring(INT5, INT6));
        }
        if (INT6 < value.length()) {
            valueList.set(INT6, value.substring(INT6, INT7));
        }
        if (INT7 < value.length()) {
            valueList.set(INT7, value.substring(INT7, INT8));
        }
        if (INT8 < value.length()) {
            valueList.set(INT8, value.substring(INT8, INT9));
        }
        if (INT9 < value.length()) {
            valueList.set(INT9, value.substring(INT9));
        }
        return valueList;
    }

}
