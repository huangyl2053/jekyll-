/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hokenkyufushokankettei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.ShukeiNoyoshiki2;
import jp.co.ndensan.reams.db.dbu.definition.processprm.hokenkyufushokankettei.JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TempDwbTKyufujissekiShukeiKonkyo2Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei.YoboKyufusuJohoKonkyoCsvEntity;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.hokenkyufushokankettei.IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth._DateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.ZipUtil;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険給付【償還_決定】のBusinessクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
public class HokenkyufuShokanKetteiManager {

    private static final RString 訪問介護コード = new RString("16");
    private static final RString 訪問入浴コード = new RString("17");
    private static final RString 訪問看護コード = new RString("18");
    private static final RString 訪問リハコード = new RString("19");
    private static final RString 療養指導コード = new RString("26");
    private static final RString 通所介護コード = new RString("20");
    private static final RString 通所リハコード = new RString("21");
    private static final RString 短期生活コード = new RString("23");
    private static final RString 短期老健コード = new RString("24");
    private static final RString 短期医療コード = new RString("25");
    private static final RString 用具貸与コード = new RString("22");
    private static final RString 用具購入コード = new RString("04");
    private static final RString 住宅改修コード = new RString("05");
    private static final RString 特施生活コード = new RString("28");
    private static final RString 予防介護コード = new RString("29");
    private static final RString 定期随時コード = new RString("37");
    private static final RString 夜間訪問コード = new RString("32");
    private static final RString 地域通所コード = new RString("39");
    private static final RString 認知通所コード = new RString("33");
    private static final RString 小多居宅コード = new RString("34");
    private static final RString 認知共同コード = new RString("27");
    private static final RString 地特生活コード = new RString("35");
    private static final RString 地福祉生コード = new RString("36");
    private static final RString 看小規多コード = new RString("38");
    private static final RString 福祉施設コード = new RString("07");
    private static final RString 老健施設コード = new RString("08");
    private static final RString 医療施設コード = new RString("09");
    private static final RString 訪問介護名称 = new RString("訪問介護");
    private static final RString 訪問入浴名称 = new RString("訪問入浴介護");
    private static final RString 訪問看護名称 = new RString("訪問看護");
    private static final RString 訪問リハ名称 = new RString("訪問リハビリテーション");
    private static final RString 療養指導名称 = new RString("居宅療養管理指導");
    private static final RString 通所介護名称 = new RString("通所介護");
    private static final RString 通所リハ名称 = new RString("通所リハビリテーション");
    private static final RString 短期生活名称 = new RString("短期入所生活介護");
    private static final RString 短期老健名称 = new RString("短期入所療養介護(介護老人保健施設)");
    private static final RString 短期医療名称 = new RString("短期入所療養介護(介護療養型医療施設等)");
    private static final RString 用具貸与名称 = new RString("福祉用具貸与");
    private static final RString 用具購入名称 = new RString("福祉用具購入費");
    private static final RString 住宅改修名称 = new RString("住宅改修費");
    private static final RString 特施生活名称 = new RString("特定施設入居者生活介護");
    private static final RString 予防介護名称 = new RString("介護予防支援・居宅介護支援");
    private static final RString 定期随時名称 = new RString("定期巡回・随時対応型訪問介護看護");
    private static final RString 夜間訪問名称 = new RString("夜間対応型訪問介護");
    private static final RString 地域通所名称 = new RString("地域密着型通所介護");
    private static final RString 認知通所名称 = new RString("認知症対応型通所介護");
    private static final RString 小多居宅名称 = new RString("小規模多機能型居宅介護");
    private static final RString 認知共同名称 = new RString("認知症対応型共同生活介護");
    private static final RString 地特生活名称 = new RString("地域密着型特定施設入居者生活介護");
    private static final RString 地福祉生名称 = new RString("地域密着型介護老人福祉施設入居者生活介護");
    private static final RString 看小規多名称 = new RString("複合型サービス(看護小規模多機能型居宅介護)");
    private static final RString 福祉施設名称 = new RString("介護老人福祉施設");
    private static final RString 老健施設名称 = new RString("介護老人保健施設");
    private static final RString 医療施設名称 = new RString("介護療養型医療施設");
    private static final RString 左かぎ括弧 = new RString("「");
    private static final RString 右かぎ括弧 = new RString("」");
    private static final RString 左括弧 = new RString("(");
    private static final RString 右括弧 = new RString(")");
    private static final RString 自立 = new RString("1");
    private static final RString 要介護 = new RString("2");
    private static final RString 要介護１ = new RString("3");
    private static final RString 要介護２ = new RString("4");
    private static final RString 要介護３ = new RString("5");
    private static final RString 要介護４ = new RString("6");
    private static final RString 要介護５ = new RString("7");
    private static final RString 要支援１ = new RString("9");
    private static final RString 要支援２ = new RString("10");
    private static final RString 縦番号_NO3 = new RString("16");
    private static final RString 縦番号_NO4 = new RString("17");
    private static final RString 縦番号_NO5 = new RString("18");
    private static final RString 縦番号_NO6 = new RString("19");
    private static final RString 縦番号_NO7 = new RString("26");
    private static final RString 縦番号_NO9 = new RString("20");
    private static final RString 縦番号_NO10 = new RString("21");
    private static final RString 縦番号_NO12 = new RString("23");
    private static final RString 縦番号_NO13 = new RString("24");
    private static final RString 縦番号_NO14 = new RString("25");
    private static final RString 縦番号_NO16 = new RString("22");
    private static final RString 縦番号_NO17 = new RString("04");
    private static final RString 縦番号_NO18 = new RString("05");
    private static final RString 縦番号_NO19 = new RString("28");
    private static final RString 縦番号_NO20 = new RString("29");
    private static final RString 縦番号_NO22 = new RString("37");
    private static final RString 縦番号_NO23 = new RString("32");
    private static final RString 縦番号_NO24 = new RString("39");
    private static final RString 縦番号_NO25 = new RString("33");
    private static final RString 縦番号_NO26 = new RString("34");
    private static final RString 縦番号_NO27 = new RString("27");
    private static final RString 縦番号_NO28 = new RString("35");
    private static final RString 縦番号_NO29 = new RString("36");
    private static final RString 縦番号_NO30 = new RString("38");
    private static final RString 縦番号_NO32 = new RString("07");
    private static final RString 縦番号_NO33 = new RString("08");
    private static final RString 縦番号_NO34 = new RString("09");
    private static final RString 縦番号_NO36 = new RString("11");
    private static final RString 縦番号_NO37 = new RString("12");
    private static final RString 縦番号_NO38 = new RString("13");
    private static final RString 入力識別番号_812 = new RString("812");
    private static final RString 入力識別番号_21B = new RString("21B");
    private static final RString 入力識別番号_718 = new RString("718");
    private static final RString 入力識別番号_218 = new RString("218");
    private static final RString 入力識別番号_719 = new RString("719");
    private static final RString 入力識別番号_219 = new RString("219");
    private static final RString 入力識別番号_71A = new RString("71A");
    private static final RString 入力識別番号_21A = new RString("21A");
    private static final RString 六十五歳 = new RString("65");
    private static final int 保険給付率_90 = 90;
    private static final int 保険給付率_89 = 89;
    private static final int 保険給付率_80 = 80;
    private static final int 保険給付率_79 = 79;
    private static final int 月 = 8;
    private static final int 前年 = 2;
    private static final RString エラーフラグ_0 = new RString("0");
    private static final RString エラーフラグ_1 = new RString("1");
    private static final RString 負担割合区分_10 = new RString("10");
    private static final RString 負担割合区分_20 = new RString("20");
    private static final RString 負担割合区分_１割 = new RString("１割");
    private static final RString 負担割合区分_２割 = new RString("２割");
    private static final RString 市町村区分 = new RString("1");
    private static final RString 償還 = new RString("06");
    private static final RString 高額サービス費 = new RString("16");
    private static final int 予防給付縦番号INDEX = 39;
    private static final int 予防給付横番号INDEX = 12;
    private static final int 特定入所者縦番号INDEX = 17;
    private static final int 特定入所者横番号INDEX = 12;
    private static final RString 保険者分 = new RString("1");
    private static final RString 構成市町村分 = new RString("2");
    private static final RString 旧市町村分 = new RString("3");

    private RString setCSV用縦番号(RString 縦番号) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(左かぎ括弧);
        builder.append(縦番号);
        builder.append(左括弧);
        if (訪問介護コード.equals(縦番号)) {
            builder.append(訪問介護名称);
        } else if (訪問入浴コード.equals(縦番号)) {
            builder.append(訪問入浴名称);
        } else if (訪問看護コード.equals(縦番号)) {
            builder.append(訪問看護名称);
        } else if (訪問リハコード.equals(縦番号)) {
            builder.append(訪問リハ名称);
        } else if (療養指導コード.equals(縦番号)) {
            builder.append(療養指導名称);
        } else if (通所介護コード.equals(縦番号)) {
            builder.append(通所介護名称);
        } else if (通所リハコード.equals(縦番号)) {
            builder.append(通所リハ名称);
        } else if (短期生活コード.equals(縦番号)) {
            builder.append(短期生活名称);
        } else if (短期老健コード.equals(縦番号)) {
            builder.append(短期老健名称);
        } else if (短期医療コード.equals(縦番号)) {
            builder.append(短期医療名称);
        } else if (用具貸与コード.equals(縦番号)) {
            builder.append(用具貸与名称);
        } else if (用具購入コード.equals(縦番号)) {
            builder.append(用具購入名称);
        } else if (住宅改修コード.equals(縦番号)) {
            builder.append(住宅改修名称);
        } else {
            setSubCSV用縦番号(builder, 縦番号);
        }
        builder.append(右括弧);
        builder.append(右かぎ括弧);
        return builder.toRString();
    }

    private void setSubCSV用縦番号(RStringBuilder builder, RString 縦番号) {
        if (特施生活コード.equals(縦番号)) {
            builder.append(特施生活名称);
        } else if (予防介護コード.equals(縦番号)) {
            builder.append(予防介護名称);
        } else if (定期随時コード.equals(縦番号)) {
            builder.append(定期随時名称);
        } else if (夜間訪問コード.equals(縦番号)) {
            builder.append(夜間訪問名称);
        } else if (地域通所コード.equals(縦番号)) {
            builder.append(地域通所名称);
        } else if (認知通所コード.equals(縦番号)) {
            builder.append(認知通所名称);
        } else if (小多居宅コード.equals(縦番号)) {
            builder.append(小多居宅名称);
        } else if (認知共同コード.equals(縦番号)) {
            builder.append(認知共同名称);
        } else if (地特生活コード.equals(縦番号)) {
            builder.append(地特生活名称);
        } else if (地福祉生コード.equals(縦番号)) {
            builder.append(地福祉生名称);
        } else if (看小規多コード.equals(縦番号)) {
            builder.append(看小規多名称);
        } else if (福祉施設コード.equals(縦番号)) {
            builder.append(福祉施設名称);
        } else if (老健施設コード.equals(縦番号)) {
            builder.append(老健施設名称);
        } else if (医療施設コード.equals(縦番号)) {
            builder.append(医療施設名称);
        }
    }

    private RString setCSV用横番号(RString 横番号) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(左かぎ括弧);
        builder.append(横番号);
        builder.append(左括弧);
        if (自立.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.非該当.get名称());
        } else if (要介護.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要支援_経過的要介護.get名称());
        } else if (要介護１.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要介護1.get名称());
        } else if (要介護２.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要介護2.get名称());
        } else if (要介護３.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要介護3.get名称());
        } else if (要介護４.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要介護4.get名称());
        } else if (要介護５.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要介護5.get名称());
        } else if (要支援１.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要支援1.get名称());
        } else if (要支援２.equals(横番号)) {
            builder.append(YokaigoJotaiKubun.要支援2.get名称());
        }
        builder.append(右括弧);
        builder.append(右かぎ括弧);
        return builder.toRString();
    }

    /**
     * 給付実績集計根拠一時テーブルの更新処理です。
     *
     * @param tempEntity 一時テーブルのEntity
     * @param 集計年月 集計年月
     * @return TempDwbTKyufujissekiShukeiKonkyo1Entity
     */
    public TempDwbTKyufujissekiShukeiKonkyo1Entity update一時テーブルデータ(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity, RString 集計年月) {
        set縦番号(tempEntity);
        set横番号(tempEntity);
        AgeCalculator age = new AgeCalculator(new _DateOfBirth(new FlexibleDate(tempEntity.getUmareYMD())),
                JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, new FlexibleDate(集計年月));
        if (六十五歳.compareTo(age.get年齢()) < 1) {
            tempEntity.setShikakuKubun(new RString("1号"));
        } else {
            tempEntity.setShikakuKubun(new RString("2号"));
        }
        FlexibleDate サービス提供年月 = new FlexibleDate(tempEntity.getServiceTeikyoYM());
        if (サービス提供年月.getMonthValue() < 月) {
            tempEntity.setFutanWariaiNendo(new RString(サービス提供年月.getYearValue() - 前年));
        } else {
            tempEntity.setFutanWariaiNendo(new RString(サービス提供年月.getYearValue()));
        }
        if (tempEntity.getHokenKyufuritsu() != null) {
            set負担割合区分_再編集と作成区分エラーフラグ(tempEntity);
        }
        return tempEntity;
    }

    /**
     * 特定入所者一時テーブルの更新処理です。
     *
     * @param tempEntity 特定入所者一時テーブルのEntity
     * @return TempDwbTKyufujissekiShukeiKonkyo2Entity
     */
    public TempDwbTKyufujissekiShukeiKonkyo2Entity update特定入所者一時テーブル(TempDwbTKyufujissekiShukeiKonkyo2Entity tempEntity) {
        set縦番号2(tempEntity);
        set横番号2(tempEntity);
        return tempEntity;
    }

    private void set負担割合区分_再編集と作成区分エラーフラグ(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (保険給付率_89 < tempEntity.getHokenKyufuritsu().value().intValue()
                && 負担割合区分_10.equals(tempEntity.getFutanWariaiKubun())) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_0);
        }
        if (保険給付率_89 < tempEntity.getHokenKyufuritsu().value().intValue()
                && 負担割合区分_20.equals(tempEntity.getFutanWariaiKubun())
                && !RString.isNullOrEmpty(tempEntity.getRiyoshaFutanGenmenHihokenshaNo())) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_1);
        }
        if (保険給付率_89 < tempEntity.getHokenKyufuritsu().value().intValue()
                && 負担割合区分_20.equals(tempEntity.getFutanWariaiKubun())
                && RString.isNullOrEmpty(tempEntity.getRiyoshaFutanGenmenHihokenshaNo())) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_1);
            tempEntity.setFutanWariaiKubun(負担割合区分_10);
        }
        if (保険給付率_80 < tempEntity.getHokenKyufuritsu().value().intValue()
                && tempEntity.getHokenKyufuritsu().value().intValue() < 保険給付率_89
                && 負担割合区分_20.equals(tempEntity.getFutanWariaiKubun())) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_0);
        }
        if (保険給付率_80 < tempEntity.getHokenKyufuritsu().value().intValue()
                && tempEntity.getHokenKyufuritsu().value().intValue() < 保険給付率_89
                && 負担割合区分_10.equals(tempEntity.getFutanWariaiKubun())) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_1);
            tempEntity.setFutanWariaiKubun(負担割合区分_20);
        }
        if (tempEntity.getHokenKyufuritsu().value().intValue() < 保険給付率_79) {
            tempEntity.setSakuseiKubunErrorFlag(エラーフラグ_0);
        }
        set再掲分保険率(tempEntity);
    }

    private void set再掲分保険率(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (負担割合区分_10.equals(tempEntity.getFutanWariaiKubun())
                && 保険給付率_90 < tempEntity.getHokenKyufuritsu().value().intValue()) {
            tempEntity.setSaikeibunHokenritu(new RString(tempEntity.getHokenKyufuritsu().value().subtract(保険給付率_90).toString()));
        }
        if (負担割合区分_20.equals(tempEntity.getFutanWariaiKubun())
                && 保険給付率_80 < tempEntity.getHokenKyufuritsu().value().intValue()) {
            tempEntity.setSaikeibunHokenritu(new RString(tempEntity.getHokenKyufuritsu().value().subtract(保険給付率_80).toString()));
        }
    }

    /**
     * 予防給付数情報根拠CSVを設定します。
     *
     * @param entity 一時テーブルのEntity
     * @param 集計番号 集計番号
     * @param 旧市町村区分 旧市町村区分
     * @return YoboKyufusuJohoKonkyoCsvEntity
     */
    public YoboKyufusuJohoKonkyoCsvEntity set予防給付数情報根拠CSVData(TempDwbTKyufujissekiShukeiKonkyo1Entity entity,
            RString 集計番号, RString 旧市町村区分) {
        YoboKyufusuJohoKonkyoCsvEntity csvEntity = new YoboKyufusuJohoKonkyoCsvEntity();
        csvEntity.setデータ区分(entity.getDataKubun());
        csvEntity.set集計区分(entity.getShukeiKubun());
        if (市町村区分.equals(旧市町村区分)) {
            csvEntity.set表番号(高額サービス費);
        } else {
            csvEntity.set表番号(償還);
        }
        csvEntity.set集計番号(集計番号);
        csvEntity.set集計単位(entity.getShukeiTani());
        csvEntity.set縦番号(setCSV用縦番号(entity.getTateNo()));
        csvEntity.set横番号(setCSV用横番号(entity.getYokoNo()));
        csvEntity.set入力識別番号(entity.getInputShikibetsuNo());
        csvEntity.set証記載保険者番号(entity.getShokisaiHokenshaNo().value());
        csvEntity.set被保険者番号(entity.getHihokenshaNo().value());
        csvEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        csvEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        csvEntity.set事業者番号(entity.getJigyoshaNo().value());
        csvEntity.set整理番号(entity.getSeiriNo());
        csvEntity.set明細番号(entity.getMeisaiNo());
        if (entity.getMotoSeiriNo() != null) {
            csvEntity.set元整理番号(entity.getMotoSeiriNo().value());
        }
        csvEntity.set申請管理支給区分コード(entity.getShinseiKanrisikyuKubunCode());
        csvEntity.set生年月日(entity.getUmareYMD());
        csvEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        csvEntity.set旧措置入所者特例コード(entity.getKyuSochiNyushoshaTokureiCode());
        if (entity.getHokenKyufuritsu() != null) {
            csvEntity.set保険給付率(new RString(entity.getHokenKyufuritsu().value().toString()));
        }
        csvEntity.set給付実績情報作成区分コード(entity.getKyufuSakuseiKubunCode());
        csvEntity.set食事費用被保険者番号(entity.getShokujihiyoHokenshaNo());
        csvEntity.set基本提供日数(new RString(entity.getKihonTeikyoNissu()));
        csvEntity.set特別提供日数(new RString(entity.getTokubetsuTeikyoNissu()));
        csvEntity.set食事提供延べ日数(new RString(entity.getShokujiTeikyoNobeNissu()));
        csvEntity.set基本提供単価(decimalToRString(entity.getKihonTeikyoTanka()));
        csvEntity.set特別提供単価(decimalToRString(entity.getTokubetsuTeikyoTanka()));
        csvEntity.set後_食事提供費請求額(decimalToRString(entity.getAtoShokujiTeikyoSeikyuGaku()));
        csvEntity.set食事費用支給区分コード(entity.getShokujiHiyosikyuKubunCode());
        csvEntity.set食事費用支給金額(decimalToRString(entity.getShokujiHiyosikyuGaku()));
        csvEntity.setサービス種類コード(entity.getServiceSyuruiCode().value());
        csvEntity.set請求点数単価(decimalToRString(entity.getSeikyuTensuTanka()));
        csvEntity.set請求額(decimalToRString(entity.getSeikyugaku()));
        csvEntity.set利用者負担額(decimalToRString(entity.getRiyoshaFutangaku()));
        csvEntity.set後_点数合計(new RString(entity.getAtoTensuGokei()));
        csvEntity.set後_保険請求分請求額(decimalToRString(entity.getAtoHokenSeikyugaku()));
        csvEntity.set後_出来高点数合計(new RString(entity.getAtoDekidakaTensuGokei()));
        csvEntity.set後_出来高請求額(decimalToRString(entity.getAtoDekidakaSeikyuGaku()));
        csvEntity.set集計支給区分コード(entity.getShukeiShikyukubunCode());
        csvEntity.set集計支給金額(decimalToRString(entity.getShukeiShikyuKingaku()));
        csvEntity.set増減点(new RString(entity.getZougenten()));
        csvEntity.set後_点数(new RString(entity.getAtoTensu()));
        csvEntity.set後_請求金額(decimalToRString(entity.getAtoSeikyuKingaku()));
        csvEntity.set計画費支給区分コード(entity.getKeikakuhiShikyukubunCode());
        csvEntity.set計画費支給金額(decimalToRString(entity.getKeikakuhiShikyuKingaku()));
        csvEntity.set明細点数(decimalToRString(entity.getMeisaiTensu()));
        csvEntity.set資格区分(entity.getShikakuKubun());
        if (entity.getShichosonCode() != null) {
            csvEntity.set市町村コード(entity.getShichosonCode().value());
        }
        if (entity.getKyuShichosonCode() != null) {
            csvEntity.set旧市町村コード(entity.getKyuShichosonCode().value());
        }
        csvEntity.set現物分存在フラグ(entity.getGenbutsubunSonzaiFlag());
        if (負担割合区分_10.equals(entity.getFutanWariaiKubun())) {
            csvEntity.set負担割合区分(負担割合区分_１割);
        } else if (負担割合区分_20.equals(entity.getFutanWariaiKubun())) {
            csvEntity.set負担割合区分(負担割合区分_２割);
        }
        csvEntity.set審査年月(entity.getShinsaYM());
        return csvEntity;
    }

    /**
     * 特定入所者保険給付数情報根拠CSVを設定します。
     *
     * @param entity 特定入所者集計根拠テーブル
     * @param 集計番号 集計番号
     * @param 旧市町村区分 旧市町村区分
     * @return TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity
     */
    public TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity set特定入所者保険給付数情報根拠CSVData(
            TempDwbTKyufujissekiShukeiKonkyo2Entity entity,
            RString 集計番号, RString 旧市町村区分) {
        TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity csvEntity = new TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity();
        csvEntity.setデータ区分(entity.getDataKubun());
        csvEntity.set集計区分(entity.getShukeiKubun());
        if (市町村区分.equals(旧市町村区分)) {
            csvEntity.set表番号(高額サービス費);
        } else {
            csvEntity.set表番号(償還);
        }
        csvEntity.set集計番号(集計番号);
        csvEntity.set集計単位(entity.getShukeiTani());
        csvEntity.set縦番号(entity.getTateNo());
        csvEntity.set横番号(entity.getYokoNo());
        csvEntity.set入力識別番号(entity.getInputShikibetsuNo());
        csvEntity.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        csvEntity.set被保険者番号(entity.getHihokenshaNo());
        csvEntity.setサービス提供年月(entity.getServiceTeikyoYM());
        csvEntity.set給付実績区分コード(entity.getKyufuJissekiKubunCode());
        csvEntity.set事業者番号(entity.getJigyoshaNo());
        csvEntity.set整理番号(entity.getSeiriNo());
        csvEntity.set明細番号(entity.getMeisaiNo());
        csvEntity.set元整理番号(entity.getMotoSeiriNo());
        csvEntity.set支給区分コード(entity.getShikyukubunCode());
        csvEntity.set生年月日(entity.getUmareYMD());
        csvEntity.set要介護状態区分コード(entity.getYoKaigoJotaiKubunCode());
        csvEntity.set給付実績情報作成区分コード(entity.getKyufuSakuseiKubunCode());
        csvEntity.set連番(entity.getRenban());
        csvEntity.set順次番号(entity.getRecodeJunjiNo());
        csvEntity.setサービス種類コード(entity.getServiceSyuruiCode());
        csvEntity.setサービス項目コード(entity.getServiceKomokuCode());
        csvEntity.set後_保険分請求額(new RString(entity.getAtoHokenbunSeikyugaku().toString()));
        csvEntity.set資格区分(entity.getShikakuKubun());
        csvEntity.set市町村コード(entity.getShichosonCode());
        csvEntity.set旧市町村コード(entity.getKyuShichosonCode());
        csvEntity.set現物分存在フラグ(entity.getGenbutsubunSonzaiFlag());
        return csvEntity;
    }

    /**
     * 事業報告統計データに追加します。
     *
     * @param processParameter 保険給付【償還_決定】のProcess用パラメータ
     * @param mapper 保険給付【償還_決定】のMapper
     */
    public void 追加事業報告統計データ(JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter,
            IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper) {
        RString zipFilePath = new RString(Path.combinePath(processParameter.getCsvFilePath(),
                new RString("JigyoHokokuRenkei_Hokenkyufu_ShokanKettei.zip")).toString());
        ZipUtil.createFromFolder(zipFilePath, processParameter.getCsvFilePath());
        processParameter.getManager().spool(zipFilePath);
        mapper.delete事業報告統計データ(processParameter.createDelete事業報告統計データMybitisParamter());
        RString 表番号;
        if (市町村区分.equals(processParameter.get旧市町村区分())) {
            表番号 = 高額サービス費;
        } else {
            表番号 = 償還;
        }
        if (市町村区分.equals(processParameter.get構成市町村区分())) {
            for (RString 市町村コード : processParameter.get構成市町村コードリスト()) {
                予防給付より追加事業報告統計データ(市町村コード, RString.EMPTY, 表番号, 構成市町村分, processParameter, mapper);
                特定入所者より追加事業報告統計データ(市町村コード, RString.EMPTY, 表番号, 構成市町村分, processParameter, mapper);
            }
        } else if (市町村区分.equals(processParameter.get旧市町村区分())) {
            for (RString 市町村コード : processParameter.get旧市町村コードリスト()) {
                予防給付より追加事業報告統計データ(RString.EMPTY, 市町村コード, 表番号, 旧市町村分, processParameter, mapper);
                特定入所者より追加事業報告統計データ(RString.EMPTY, 市町村コード, 表番号, 旧市町村分, processParameter, mapper);
            }
        } else {
            予防給付より追加事業報告統計データ(processParameter.get市町村コード(), RString.EMPTY, 表番号, 保険者分, processParameter, mapper);
            特定入所者より追加事業報告統計データ(processParameter.get市町村コード(), RString.EMPTY, 表番号, 保険者分, processParameter, mapper);
        }
    }

    private void set縦番号(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (ServiceCategoryShurui.訪問介護.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予訪介護.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO3);
        } else if (ServiceCategoryShurui.訪問入浴.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予訪入浴.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO4);
        } else if (ServiceCategoryShurui.訪問看護.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予訪看護.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO5);
        } else if (ServiceCategoryShurui.訪問リハ.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予訪リハ.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO6);
        } else if (ServiceCategoryShurui.療養指導.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予療養指.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO7);
        } else if (ServiceCategoryShurui.通所介護.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予通介護.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO9);
        } else if (ServiceCategoryShurui.通所リハ.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予通リハ.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO10);
        } else if (ServiceCategoryShurui.短期生活.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予短介護.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO12);
        } else if (ServiceCategoryShurui.短期老健.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予短老健.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO13);
        } else {
            setSub縦番号(tempEntity);
        }
    }

    private void setSub縦番号(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (ServiceCategoryShurui.短期医療.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予短医療.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO14);
        } else if (ServiceCategoryShurui.用具貸与.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予用貸与.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO16);
        } else if (ServiceCategoryShurui.用具販売.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予用販売.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO17);
        } else if (ServiceCategoryShurui.住宅改修.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予住改修.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO18);
        } else if (ServiceCategoryShurui.特施短外.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.予特施設.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.特施短期.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO19);
        } else if (ServiceCategoryShurui.定期随時.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO22);
        } else if (ServiceCategoryShurui.地夜間訪.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO23);
        } else if (ServiceCategoryShurui.地域通所.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO24);
        } else if (ServiceCategoryShurui.地通所介.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地予通所.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO25);
        } else {
            setSub縦番号のSub1(tempEntity);
        }
    }

    private void setSub縦番号のSub1(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (ServiceCategoryShurui.地小規単.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地予小外.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地小規単.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地予小短.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO26);
        } else if (ServiceCategoryShurui.地共同介.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地予共同.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地共同短.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.地予共短.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO27);
        } else if (ServiceCategoryShurui.地施短外.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO28);
        } else if (ServiceCategoryShurui.地福祉生.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO29);
        } else if (ServiceCategoryShurui.看小短外.getコード().equals(tempEntity.getServiceSyuruiCode().value())
                || ServiceCategoryShurui.看小規短.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO30);
        } else if (ServiceCategoryShurui.福祉施設.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO32);
        } else if (ServiceCategoryShurui.老健施設.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO33);
        } else if (ServiceCategoryShurui.医療施設.getコード().equals(tempEntity.getServiceSyuruiCode().value())) {
            tempEntity.setTateNo(縦番号_NO34);
        } else {
            setSub縦番号のSub2(tempEntity);
        }
    }

    private void setSub縦番号のSub2(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (入力識別番号_812.equals(tempEntity.getInputShikibetsuNo())
                || 入力識別番号_21B.equals(tempEntity.getInputShikibetsuNo())) {
            tempEntity.setTateNo(縦番号_NO20);
        }
        if (tempEntity.getShokujiHiyosikyuGaku() != null
                && (入力識別番号_718.equals(tempEntity.getInputShikibetsuNo())
                || 入力識別番号_218.equals(tempEntity.getInputShikibetsuNo()))) {
            tempEntity.setTateNo(縦番号_NO36);
        } else if (tempEntity.getShokujiHiyosikyuGaku() != null
                && (入力識別番号_719.equals(tempEntity.getInputShikibetsuNo())
                || 入力識別番号_219.equals(tempEntity.getInputShikibetsuNo()))) {
            tempEntity.setTateNo(縦番号_NO37);
        } else if (tempEntity.getShokujiHiyosikyuGaku() != null
                && (入力識別番号_71A.equals(tempEntity.getInputShikibetsuNo())
                || 入力識別番号_21A.equals(tempEntity.getInputShikibetsuNo()))) {
            tempEntity.setTateNo(縦番号_NO38);
        }
    }

    private void set縦番号2(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        if (ServiceCategoryShurui.訪問介護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪介護.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO3);
        } else if (ServiceCategoryShurui.訪問入浴.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪入浴.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO4);
        } else if (ServiceCategoryShurui.訪問看護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪看護.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO5);
        } else if (ServiceCategoryShurui.訪問リハ.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予訪リハ.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO6);
        } else if (ServiceCategoryShurui.療養指導.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予療養指.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO7);
        } else if (ServiceCategoryShurui.通所介護.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予通介護.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO9);
        } else if (ServiceCategoryShurui.通所リハ.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予通リハ.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO10);
        } else if (ServiceCategoryShurui.短期生活.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予短介護.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO12);
        } else if (ServiceCategoryShurui.短期老健.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予短老健.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO13);
        } else {
            setSub縦番号2(entity);
        }
    }

    private void setSub縦番号2(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        if (ServiceCategoryShurui.短期医療.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予短医療.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO14);
        } else if (ServiceCategoryShurui.用具貸与.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予用貸与.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO16);
        } else if (ServiceCategoryShurui.用具販売.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予用販売.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO17);
        } else if (ServiceCategoryShurui.住宅改修.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予住改修.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO18);
        } else if (ServiceCategoryShurui.特施短外.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.予特施設.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.特施短期.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO19);
        } else if (ServiceCategoryShurui.定期随時.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO22);
        } else if (ServiceCategoryShurui.地夜間訪.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO23);
        } else if (ServiceCategoryShurui.地域通所.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO24);
        } else if (ServiceCategoryShurui.地通所介.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予通所.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO25);
        } else {
            setSub縦番号のSub1_2(entity);
        }
    }

    private void setSub縦番号のSub1_2(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        if (ServiceCategoryShurui.地小規単.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予小外.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地小規単.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予小短.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO26);
        } else if (ServiceCategoryShurui.地共同介.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予共同.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地共同短.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.地予共短.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO27);
        } else if (ServiceCategoryShurui.地施短外.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO28);
        } else if (ServiceCategoryShurui.地福祉生.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO29);
        } else if (ServiceCategoryShurui.看小短外.getコード().equals(entity.getServiceSyuruiCode())
                || ServiceCategoryShurui.看小規短.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO30);
        } else if (ServiceCategoryShurui.福祉施設.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO32);
        } else if (ServiceCategoryShurui.老健施設.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO33);
        } else if (ServiceCategoryShurui.医療施設.getコード().equals(entity.getServiceSyuruiCode())) {
            entity.setTateNo(縦番号_NO34);
        } else {
            setSub縦番号のSub2_2(entity);
        }
    }

    private void setSub縦番号のSub2_2(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        if (入力識別番号_812.equals(entity.getInputShikibetsuNo())
                || 入力識別番号_21B.equals(entity.getInputShikibetsuNo())) {
            entity.setTateNo(縦番号_NO20);
        }
//        if (entity.getShokujiHiyosikyuGaku() != null
//                && (入力識別番号_718.equals(entity.getInputShikibetsuNo())
//                || 入力識別番号_218.equals(entity.getInputShikibetsuNo()))) {
//            entity.setTateNo(縦番号_NO36);
//        } else if (entity.getShokujiHiyosikyuGaku() != null
//                && (入力識別番号_719.equals(entity.getInputShikibetsuNo())
//                || 入力識別番号_219.equals(entity.getInputShikibetsuNo()))) {
//            entity.setTateNo(縦番号_NO37);
//        } else if (entity.getShokujiHiyosikyuGaku() != null
//                && (入力識別番号_71A.equals(entity.getInputShikibetsuNo())
//                || 入力識別番号_21A.equals(entity.getInputShikibetsuNo()))) {
//            entity.setTateNo(縦番号_NO38);
//        }
    }

    private void set横番号(TempDwbTKyufujissekiShukeiKonkyo1Entity tempEntity) {
        if (YokaigoJotaiKubun.非該当.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(自立);
        } else if (YokaigoJotaiKubun.要支援_経過的要介護.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護);
        } else if (YokaigoJotaiKubun.要介護1.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護１);
        } else if (YokaigoJotaiKubun.要介護2.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護２);
        } else if (YokaigoJotaiKubun.要介護3.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護３);
        } else if (YokaigoJotaiKubun.要介護4.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護４);
        } else if (YokaigoJotaiKubun.要介護5.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要介護５);
        } else if (YokaigoJotaiKubun.要支援1.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要支援１);
        } else if (YokaigoJotaiKubun.要支援2.getコード().equals(tempEntity.getYoKaigoJotaiKubunCode())) {
            tempEntity.setYokoNo(要支援２);
        }
    }

    private void set横番号2(TempDwbTKyufujissekiShukeiKonkyo2Entity entity) {
        if (YokaigoJotaiKubun.非該当.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(自立);
        } else if (YokaigoJotaiKubun.要支援_経過的要介護.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護);
        } else if (YokaigoJotaiKubun.要介護1.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護１);
        } else if (YokaigoJotaiKubun.要介護2.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護２);
        } else if (YokaigoJotaiKubun.要介護3.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護３);
        } else if (YokaigoJotaiKubun.要介護4.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護４);
        } else if (YokaigoJotaiKubun.要介護5.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要介護５);
        } else if (YokaigoJotaiKubun.要支援1.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要支援１);
        } else if (YokaigoJotaiKubun.要支援2.getコード().equals(entity.getYoKaigoJotaiKubunCode())) {
            entity.setYokoNo(要支援２);
        }
    }

    private static List<RString> get予防給付集計番号List() {
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付1総数_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_単位数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_費用額.getコード());
        集計番号List.add(ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_給付費.getコード());
        return 集計番号List;
    }

    private static List<RString> get特定入所者集計番号List() {
        List<RString> 集計番号List = new ArrayList<>();
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_給付費.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_件数.getコード());
        集計番号List.add(ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_給付費.getコード());
        return 集計番号List;
    }

    private void 予防給付より追加事業報告統計データ(RString 市町村コード, RString 旧市町村コード, RString 表番号, RString 統計対象区分,
            JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter,
            IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper) {
        for (RString 集計番号 : get予防給付集計番号List()) {
            for (int i = 1; i <= 予防給付縦番号INDEX; i++) {
                for (int j = 1; j <= 予防給付横番号INDEX; j++) {
                    Decimal 集計結果値;
                    if (ShukeiNoyoshiki2._1_介護給付_予防給付1総数_件数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0101_1(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j))
                                .subtract(mapper.get集計結果値_0101_2(processParameter.create集計結果値MybitisParamter(
                                                        市町村コード, 旧市町村コード, i, j)));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付1総数_単位数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0102(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付1総数_費用額.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0103(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付1総数_給付費.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0104(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_件数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0107_1(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j))
                                .subtract(mapper.get集計結果値_0107_2(processParameter.create集計結果値MybitisParamter(
                                                        市町村コード, 旧市町村コード, i, j)));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_単位数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0108(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_費用額.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0109(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2二割負担被保険者分_再掲_給付費.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0110(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_件数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0201_1(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j))
                                .subtract(mapper.get集計結果値_0201_2(processParameter.create集計結果値MybitisParamter(
                                                        市町村コード, 旧市町村コード, i, j)));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_単位数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0202(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_費用額.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0203(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._1_介護給付_予防給付2第２号被保険者分_再掲_給付費.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0204(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else {
                        集計結果値 = sub予防給付より追加事業報告統計データ(集計番号, 市町村コード, 旧市町村コード, i, j, processParameter, mapper);
                    }
                    RString true市町村コード;
                    if (RString.isNullOrEmpty(市町村コード)) {
                        true市町村コード = 旧市町村コード;
                    } else {
                        true市町村コード = 市町村コード;
                    }
                    mapper.insert事業報告統計データ(processParameter.createInsert事業報告統計データMybitisParamter(
                            true市町村コード, 表番号, 集計番号, i, j, 集計結果値, 統計対象区分));
                }
            }
        }
    }

    private Decimal sub予防給付より追加事業報告統計データ(RString 集計番号, RString 市町村コード, RString 旧市町村コード, int i, int j,
            JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter,
            IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper) {
        Decimal 集計結果値 = Decimal.ZERO;
        if (ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_件数.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0301_1(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j))
                    .subtract(mapper.get集計結果値_0301_2(processParameter.create集計結果値MybitisParamter(
                                            市町村コード, 旧市町村コード, i, j)));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_単位数.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0302(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_費用額.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0303(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付3総数_特例分_給付費.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0304(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_件数.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0401_1(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j))
                    .subtract(mapper.get集計結果値_0401_2(processParameter.create集計結果値MybitisParamter(
                                            市町村コード, 旧市町村コード, i, j)));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_単位数.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0402(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_費用額.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0403(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        } else if (ShukeiNoyoshiki2._1_介護給付_予防給付4第２号被保険者分_再掲_特例分_給付費.getコード().equals(集計番号)) {
            集計結果値 = mapper.get集計結果値_0404(processParameter.create集計結果値MybitisParamter(
                    市町村コード, 旧市町村コード, i, j));
        }
        return 集計結果値;
    }

    private void 特定入所者より追加事業報告統計データ(RString 市町村コード, RString 旧市町村コード, RString 表番号, RString 統計対象区分,
            JigyoHokokuRenkeiHokenkyufuShokanKetteiProcessParameter processParameter,
            IJigyoHokokuRenkeiHokenkyufuShokanKetteiMapper mapper) {
        for (RString 集計番号 : get特定入所者集計番号List()) {
            for (int i = 1; i <= 特定入所者縦番号INDEX; i++) {
                for (int j = 1; j <= 特定入所者横番号INDEX; j++) {
                    Decimal 集計結果値 = Decimal.ZERO;
                    if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_件数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0105(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費1総数_給付費.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0106(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_件数.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0205(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    } else if (ShukeiNoyoshiki2._2_特定入所者介護_介護予防_サービス費2第２号被保険者分_給付費.getコード().equals(集計番号)) {
                        集計結果値 = mapper.get集計結果値_0206(processParameter.create集計結果値MybitisParamter(
                                市町村コード, 旧市町村コード, i, j));
                    }
                    mapper.insert事業報告統計データ(processParameter.createInsert事業報告統計データMybitisParamter(
                            市町村コード, 表番号, 集計番号, i, j, 集計結果値, 統計対象区分));
                }
            }
        }
    }

    private RString decimalToRString(Decimal 金額) {
        if (金額 == null) {
            return RString.EMPTY;
        }
        return new RString(金額.toString());
    }
}
