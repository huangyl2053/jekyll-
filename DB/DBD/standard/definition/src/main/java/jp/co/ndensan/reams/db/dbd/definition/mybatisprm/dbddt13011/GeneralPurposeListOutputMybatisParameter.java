/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbddt13011;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(施設入退所)のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class GeneralPurposeListOutputMybatisParameter implements IMyBatisParameter {

    private boolean is直近データ抽出;
    private boolean is抽出方法区分_基準日;
    private boolean is抽出方法区分_範囲;
    private boolean is抽出項目区分_入所日;
    private boolean is日付範囲From;
    private boolean is日付範囲To;
    private boolean is抽出項目区分_退所日;
    private boolean is直近データ抽出_True;
    private boolean is資格区分;
    private boolean is宛名抽出区分_年齢;
    private boolean is宛名抽出区分_年齢From;
    private boolean is宛名抽出区分_年齢To;
    private boolean is宛名抽出区分_生年月日;
    private boolean is宛名抽出区分_生年月日From;
    private boolean is宛名抽出区分_生年月日To;
    private boolean is宛名抽出条件_市町村コード_非全部;
    private boolean is住所From;
    private boolean is住所To;
    private boolean is行政区From;
    private boolean is行政区To;
    private boolean is地区1From;
    private boolean is地区1To;
    private boolean is地区2From;
    private boolean is地区2To;
    private boolean is地区3From;
    private boolean is地区3To;

    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;

    private FlexibleDate kijunYMD;
    private FlexibleDate startYMD;
    private FlexibleDate endYMD;
    private Decimal ageFrom;
    private Decimal ageTo;
    private FlexibleDate seinengappiYMDFrom;
    private FlexibleDate seinengappiYMDTo;
    private RString shichosonCode;
    private RString jusho_From;
    private RString jusho_To;

    private RString gyoseiku_From;
    private RString gyoseiku_To;

    private RString chiku1_From;
    private RString chiku1_To;
    private RString chiku2_From;
    private RString chiku2_To;
    private RString chiku3_From;
    private RString chiku3_To;

    /**
     * コンストラクタです。
     *
     * @param 抽出方法区分 抽出方法区分
     * @param 抽出項目区分 抽出項目区分
     * @param 基準日 基準日
     * @param 日付範囲From 日付範囲From
     * @param 日付範囲To 日付範囲To
     * @param 直近データ抽出 直近データ抽出
     * @param 喪失区分 喪失区分
     * @param 項目名付加 項目名付加
     * @param 連番付加 連番付加
     * @param 日付スラッシュ付加 日付スラッシュ付加
     * @param 宛名抽出条件 宛名抽出条件
     * @param 出力順 出力順
     * @param 出力項目 出力項目
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛名識別対象PSM
     */
    public GeneralPurposeListOutputMybatisParameter(ChushutsuHohoKubun 抽出方法区分,
            RString 抽出項目区分,
            FlexibleDate 基準日,
            FlexibleDate 日付範囲From,
            FlexibleDate 日付範囲To,
            boolean 直近データ抽出,
            SoshitsuKubun 喪失区分,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            AtenaSelectBatchParameter 宛名抽出条件,
            Long 出力順,
            RString 出力項目,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {

        is直近データ抽出 = 直近データ抽出;
        kijunYMD = 基準日;
        set抽出方法区分について(抽出方法区分, 抽出項目区分, 直近データ抽出,
                日付範囲From, 日付範囲To, psmShikibetsuTaisho, psmAtesaki);
        set宛名抽出区分について(宛名抽出条件);
    }

    private void set抽出方法区分について(ChushutsuHohoKubun 抽出方法区分, RString 抽出項目区分, boolean 直近データ抽出,
            FlexibleDate 日付範囲From,
            FlexibleDate 日付範囲To,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {

        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;

        RString 抽出方法区分_基準日 = new RString("基準日");
        RString 抽出方法区分_範囲 = new RString("範囲");
        RString 抽出項目区分_範囲_入所日 = new RString("入所日");
        RString 抽出項目区分_範囲_退所日 = new RString("退所日");

        if (抽出方法区分_基準日.equals(抽出方法区分)) {
            is抽出方法区分_基準日 = true;
        }
        if (抽出方法区分_範囲.equals(抽出方法区分.get名称())) {
            is抽出方法区分_範囲 = true;

            if (抽出項目区分_範囲_入所日.equals(抽出項目区分)) {
                is抽出項目区分_入所日 = true;
                set日付範囲について(日付範囲From, 日付範囲To);
            }

            if (抽出項目区分_範囲_退所日.equals(抽出項目区分)) {
                is抽出項目区分_退所日 = true;
                set日付範囲について(日付範囲From, 日付範囲To);
            }

            if (直近データ抽出) {
                is直近データ抽出 = true;
            }
        }
    }

    private void set日付範囲について(FlexibleDate 日付範囲From,
            FlexibleDate 日付範囲To) {

        if (日付範囲From != null) {
            is日付範囲From = true;
            startYMD = 日付範囲From;
        }
        if (日付範囲To != null) {
            is日付範囲To = true;
            endYMD = 日付範囲To;
        }
    }

    private void set宛名抽出区分について(AtenaSelectBatchParameter 宛名抽出条件) {

        set年齢範囲について(宛名抽出条件);
        set生年月日範囲について(宛名抽出条件);
        set市町村コードについて(宛名抽出条件);
        set地区選択区分について(宛名抽出条件);
    }

    private void set年齢範囲について(AtenaSelectBatchParameter 宛名抽出条件) {

        if (NenreiSoChushutsuHoho.年齢範囲.equals(宛名抽出条件.getAgeSelectKijun())) {
            is宛名抽出区分_年齢 = true;

            Range<Decimal> ageRange = 宛名抽出条件.getNenreiRange();
            if (Decimal.ZERO != ageRange.getFrom()) {
                is宛名抽出区分_年齢From = true;
                ageFrom = ageRange.getFrom();
            }
            if (Decimal.ZERO != ageRange.getTo()) {
                is宛名抽出区分_年齢To = true;
                ageTo = ageRange.getTo();

            }
        }
    }

    private void set生年月日範囲について(AtenaSelectBatchParameter 宛名抽出条件) {
        if (NenreiSoChushutsuHoho.生年月日範囲.equals(宛名抽出条件.getAgeSelectKijun())) {
            is宛名抽出区分_生年月日 = true;
            Range<RDate> seinengappiRange = 宛名抽出条件.getSeinengappiRange();

            if (seinengappiRange.getFrom() == null && seinengappiRange.getTo() != null) {
                is宛名抽出区分_生年月日From = true;
            }
            if (seinengappiRange.getTo() == null && seinengappiRange.getFrom() != null) {
                is宛名抽出区分_生年月日To = true;
            }
        }
    }

    private void set市町村コードについて(AtenaSelectBatchParameter 宛名抽出条件) {
        if (new RString("すべて").equals(宛名抽出条件.getShichoson_Code().getColumnValue())) {
            is宛名抽出条件_市町村コード_非全部 = true;
            shichosonCode = 宛名抽出条件.getShichoson_Code().getColumnValue();
        }
    }

    private void set地区選択区分について(AtenaSelectBatchParameter 宛名抽出条件) {
        Chiku 地区選択区分 = 宛名抽出条件.getChiku_Kubun();
        if (!Chiku.全て.equals(地区選択区分)) {
            if (!宛名抽出条件.getJusho_From().isNullOrEmpty()) {
                is住所From = true;
                jusho_From = 宛名抽出条件.getJusho_From();
            }
            if (!宛名抽出条件.getJusho_To().isNullOrEmpty()) {
                is住所To = true;
                jusho_To = 宛名抽出条件.getJusho_To();
            }

            if (!宛名抽出条件.getGyoseiku_From().isNullOrEmpty()) {
                is行政区From = true;
                gyoseiku_From = 宛名抽出条件.getGyoseiku_From();
            }

            if (!宛名抽出条件.getGyoseiku_To().isNullOrEmpty()) {
                is行政区To = true;
                gyoseiku_To = 宛名抽出条件.getGyoseiku_To();
            }

            if (!宛名抽出条件.getChiku1_From().isNullOrEmpty()) {
                is地区1From = true;
                chiku1_From = 宛名抽出条件.getChiku1_From();
            }

            if (!宛名抽出条件.getChiku1_To().isNullOrEmpty()) {
                is地区1To = true;
                chiku1_To = 宛名抽出条件.getChiku1_To();
            }

            if (!宛名抽出条件.getChiku2_From().isNullOrEmpty()) {
                is地区2From = true;
                chiku2_From = 宛名抽出条件.getChiku2_From();
            }
            if (!宛名抽出条件.getChiku2_To().isNullOrEmpty()) {
                is地区2To = true;
                chiku2_To = 宛名抽出条件.getChiku2_To();
            }

            if (!宛名抽出条件.getChiku3_From().isNullOrEmpty()) {
                is地区3From = true;
                chiku3_From = 宛名抽出条件.getChiku3_From();
            }
            if (!宛名抽出条件.getChiku3_To().isNullOrEmpty()) {
                is地区3To = true;
                chiku3_To = 宛名抽出条件.getChiku3_To();
            }
        }
    }
}
