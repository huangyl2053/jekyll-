/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.hanyorisutokokikoreisha;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuKomokuKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(後期高齢者)のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-5520-030 mawy
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HanyoRisutoKokiKoreishaMybatisParameter implements IMyBatisParameter {

    private static final int 年の月数 = 12;
    private static final int 月の日数 = 31;

    private RString cyusyutsuhohokubun;
    private RString cyusyutsukomokukubun;
    private FlexibleDate kizyunnichi;
    private FlexibleDate hitsukehanifrom;
    private FlexibleDate hitsukehanito;
    private boolean chokindatacyusyutsu;
    private RString soshitsukubun;
    private AtenaSelectBatchParameter atenacyusyutsujyoken;
    private RString syutsuryokujun;
    private RString syutsuryokukomoku;
    private boolean is基準日;
    private boolean is範囲;
    private boolean is取得日;
    private boolean is喪失日;
    private boolean has日付範囲From;
    private boolean has日付範囲To;
    private boolean is資格取得者のみ;
    private boolean is資格喪失者のみ;
    private boolean is年齢;
    private boolean has年齢From;
    private FlexibleDate 年齢From年月日;
    private boolean has年齢To;
    private FlexibleDate 年齢To年月日;
    private boolean is生年月日;
    private boolean has生年月日From;
    private FlexibleDate 生年月日From;
    private boolean has生年月日To;
    private FlexibleDate 生年月日To;
    private boolean has市町村コード;
    private RString 市町村コード;
    private RString 地区選択コードFrom;
    private RString 地区選択コードTo;
    private boolean is住所;
    private boolean has地区選択From;
    private boolean has地区選択To;
    private boolean is行政区;
    private boolean has行政区From;
    private boolean has行政区To;
    private boolean is地区;
    private boolean has地区１From;
    private boolean has地区１To;
    private boolean has地区２From;
    private boolean has地区２To;
    private boolean has地区３From;
    private boolean has地区３To;
    private final RString psmShikibetsuTaisho;
    private final RString psmAtesaki;

    /**
     * コンストラクタです。
     *
     * @param cyusyutsuhohokubun 抽出方法区分
     * @param cyusyutsukomokukubun 抽出項目区分
     * @param kizyunnichi 基準日
     * @param hitsukehanifrom 日付範囲From
     * @param hitsukehanito 日付範囲To
     * @param chokindatacyusyutsu 直近データ抽出
     * @param soshitsukubun 喪失区分
     * @param csvkomokumeifuka CSV項目名付加
     * @param csvrenbanfuka CSV連番付加
     * @param csvhitsukesurasyuhensyu CSV日付スラッシュ編集
     * @param atenacyusyutsujyoken 宛名抽出条件
     * @param syutsuryokujun 出力順
     * @param syutsuryokukomoku 出力項目
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param psmAtesaki 宛名識別対象PSM
     */
    public HanyoRisutoKokiKoreishaMybatisParameter(
            RString cyusyutsuhohokubun,
            RString cyusyutsukomokukubun,
            FlexibleDate kizyunnichi,
            FlexibleDate hitsukehanifrom,
            FlexibleDate hitsukehanito,
            boolean chokindatacyusyutsu,
            RString soshitsukubun,
            AtenaSelectBatchParameter atenacyusyutsujyoken,
            RString syutsuryokujun,
            RString syutsuryokukomoku,
            RString psmShikibetsuTaisho,
            RString psmAtesaki) {
        this.cyusyutsuhohokubun = cyusyutsuhohokubun;
        this.cyusyutsukomokukubun = cyusyutsukomokukubun;
        this.kizyunnichi = kizyunnichi;
        this.hitsukehanifrom = hitsukehanifrom;
        this.hitsukehanito = hitsukehanito;
        this.chokindatacyusyutsu = chokindatacyusyutsu;
        this.soshitsukubun = soshitsukubun;
        this.atenacyusyutsujyoken = atenacyusyutsujyoken;
        this.syutsuryokujun = syutsuryokujun;
        this.syutsuryokukomoku = syutsuryokukomoku;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        set抽出方法区分(cyusyutsuhohokubun);
        set年齢層抽出方法(atenacyusyutsujyoken);
        set地区区分(atenacyusyutsujyoken);
        set市町村コード(atenacyusyutsujyoken);
        if (SoshitsuKubun.資格取得者のみ.getコード().equals(soshitsukubun)) {
            is資格取得者のみ = true;
        } else if (SoshitsuKubun.資格喪失者のみ.getコード().equals(soshitsukubun)) {
            is資格喪失者のみ = true;
        }
    }

    private void set抽出方法区分(RString cyusyutsuhohokubun) {
        if (ChushutsuHohoKubun.基準日.getコード().equals(cyusyutsuhohokubun)) {
            is基準日 = true;
        } else if (ChushutsuHohoKubun.範囲.getコード().equals(cyusyutsuhohokubun)) {
            is範囲 = true;
            if (ChushutsuKomokuKubun.取得日.getコード().equals(cyusyutsukomokukubun)) {
                is取得日 = true;
            } else if (ChushutsuKomokuKubun.喪失日.getコード().equals(cyusyutsukomokukubun)) {
                is喪失日 = true;
            }
        }
        if (nullHandan(hitsukehanifrom)) {
            has日付範囲From = true;
        }
        if (nullHandan(hitsukehanito)) {
            has日付範囲To = true;
        }
    }

    private void set市町村コード(AtenaSelectBatchParameter atenacyusyutsujyoken) {
        if (nullHandan(atenacyusyutsujyoken.getShichoson_Code())) {
            has市町村コード = true;
            市町村コード = atenacyusyutsujyoken.getShichoson_Code().code市町村RString();
        }
    }

    private void set年齢層抽出方法(AtenaSelectBatchParameter atenacyusyutsujyoken) {
        if (NenreiSoChushutsuHoho.年齢範囲.equals(atenacyusyutsujyoken.getAgeSelectKijun())) {
            is年齢 = true;
            Range<Decimal> 年齢範囲 = atenacyusyutsujyoken.getNenreiRange();
            if (nullHandan(年齢範囲) && nullHandan(年齢範囲.getFrom())) {
                has年齢From = true;
                年齢From年月日 = get逆算した生年月日From(年齢範囲.getFrom());
            } else if (nullHandan(年齢範囲) && nullHandan(年齢範囲.getTo())) {
                has年齢To = true;
                年齢To年月日 = get逆算した生年月日To(年齢範囲.getTo());
            }
        } else if (NenreiSoChushutsuHoho.生年月日範囲.equals(atenacyusyutsujyoken.getAgeSelectKijun())) {
            is生年月日 = true;
            Range<RDate> 生年月日範囲 = atenacyusyutsujyoken.getSeinengappiRange();
            if (nullHandan(生年月日範囲) && nullHandan(生年月日範囲.getFrom())) {
                has生年月日From = true;
                生年月日From = new FlexibleDate(生年月日範囲.getFrom().toDateString());
            } else if (nullHandan(生年月日範囲) && nullHandan(生年月日範囲.getTo())) {
                has生年月日To = true;
                生年月日To = new FlexibleDate(生年月日範囲.getTo().toDateString());
            }
        }
    }

    private void set地区区分(AtenaSelectBatchParameter atenacyusyutsujyoken) {
        if (Chiku.住所.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is住所 = true;
            if (nullHandan(atenacyusyutsujyoken.getJusho_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getJusho_From();
                has地区選択From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getJusho_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getJusho_To();
                has地区選択To = true;
            }
        } else if (Chiku.行政区.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is行政区 = true;
            if (nullHandan(atenacyusyutsujyoken.getGyoseiku_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getGyoseiku_From();
                has行政区From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getGyoseiku_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getGyoseiku_To();
                has行政区To = true;
            }
        } else if (Chiku.地区.equals(atenacyusyutsujyoken.getChiku_Kubun())) {
            is地区 = true;
            if (nullHandan(atenacyusyutsujyoken.getChiku1_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku1_From();
                has地区１From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku1_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku1_To();
                has地区１To = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku2_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku2_From();
                has地区２From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku2_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku2_To();
                has地区２To = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku3_From())) {
                地区選択コードFrom = atenacyusyutsujyoken.getChiku3_From();
                has地区３From = true;
            }
            if (nullHandan(atenacyusyutsujyoken.getChiku3_To())) {
                地区選択コードTo = atenacyusyutsujyoken.getChiku3_To();
                has地区３To = true;
            }
        }
    }

    private FlexibleDate get逆算した生年月日From(Decimal 年齢範囲From) {
        FlexibleYear year = FlexibleDate.getNowDate().getYear().minusYear(年齢範囲From.intValue());
        return new FlexibleDate(year.getYearValue(), 年の月数, 月の日数);
    }

    private FlexibleDate get逆算した生年月日To(Decimal 年齢範囲To) {
        FlexibleYear year = FlexibleDate.getNowDate().getYear().minusYear(年齢範囲To.intValue());
        return new FlexibleDate(year.getYearValue(), 1, 1);
    }

    private static boolean nullHandan(RString handan) {
        return handan != null && !handan.isEmpty();
    }

    private static boolean nullHandan(Range 範囲) {
        return 範囲 != null;
    }

    private static boolean nullHandan(Decimal 年齢) {
        return 年齢 != null;
    }

    private static boolean nullHandan(RDate 生年月日) {
        return 生年月日 != null;
    }

    private static boolean nullHandan(FlexibleDate 生年月日) {
        return 生年月日 != null;
    }

    private static boolean nullHandan(LasdecCode 市町村コード) {
        return 市町村コード != null && !市町村コード.isEmpty();
    }
}
