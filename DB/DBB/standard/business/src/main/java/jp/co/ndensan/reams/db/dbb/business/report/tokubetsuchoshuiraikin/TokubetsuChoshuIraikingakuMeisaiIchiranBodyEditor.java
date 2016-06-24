/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.param.TokubetsuChoshuIraikingakuMeisaiIchiranInputParam;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariTokuchoKaishiTsuchisyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.PrecedingFiscalYearInformation;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuiraikin.TokubetsuChoshuIraikingakuMeisaiIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表のBodyEditor
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
public class TokubetsuChoshuIraikingakuMeisaiIchiranBodyEditor
        implements ITokubetsuChoshuIraikingakuMeisaiIchiranEditor {

    private final KariTokuchoKaishiTsuchisyoJoho 通知書情報;
    private static final RString 特徴開始月 = new RString("４月");

    /**
     * インスタンスを生成します。
     *
     * @param inputEntity {@link TokubetsuChoshuIraikingakuMeisaiIchiranInputParam}
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranBodyEditor(
            TokubetsuChoshuIraikingakuMeisaiIchiranInputParam inputEntity) {
        this.通知書情報 = inputEntity.get通知書情報();

    }

    @Override
    public TokubetsuChoshuIraikingakuMeisaiIchiranSource edit(TokubetsuChoshuIraikingakuMeisaiIchiranSource source) {
        if (null != 通知書情報) {
            source.listCenter_4 = 通知書情報.get特徴捕捉月();
        }
        if (null != 通知書情報 && null != 通知書情報.get編集後仮算定通知書共通情報()) {
            EditedKariSanteiTsuchiShoKyotsu 編集後共通情報 = 通知書情報.get編集後仮算定通知書共通情報();
            if (null != 編集後共通情報.get通知書番号()) {
                source.listUpper_1 = 編集後共通情報.get通知書番号().getColumnValue();
            }
            if (null != 編集後共通情報.get識別コード()) {
                source.listUpper_2 = 編集後共通情報.get識別コード().getColumnValue();
            }
            if (null != 編集後共通情報.get被保険者番号()) {
                source.listLower_1 = 編集後共通情報.get被保険者番号().getColumnValue();
            }
            if (null != 編集後共通情報.get編集後宛先()) {
                set編集後宛先(source, 編集後共通情報.get編集後宛先());
            }
            if (null != 編集後共通情報.get編集後個人()) {
                set編集後個人(source, 編集後共通情報.get編集後個人());
            }
            if (null != 編集後共通情報.get前年度情報()) {
                set前年度情報(source, 編集後共通情報.get前年度情報());
            }
            if (null != 編集後共通情報.get更正後()) {
                set更正後(source, 編集後共通情報.get更正後());
            }
        }
        source.listCenter_5 = 特徴開始月;
        source.listCenter_7 = RString.EMPTY;
        source.keisanHoho = RString.EMPTY;

        return source;
    }

    private void set編集後宛先(TokubetsuChoshuIraikingakuMeisaiIchiranSource source,
            EditedAtesaki 編集後宛先) {
        if (null != 編集後宛先.get行政区コード()) {
            source.listUpper_3 = 編集後宛先.get行政区コード().getColumnValue();
        }
        source.listUpper_5 = 編集後宛先.get編集後住所();
        if (null != 編集後宛先.get住所コード()) {
            source.listLower_3 = 編集後宛先.get住所コード().getColumnValue();
        }
    }

    private void set編集後個人(TokubetsuChoshuIraikingakuMeisaiIchiranSource source,
            EditedKojin 編集後個人) {
        if (null != 編集後個人.get世帯コード()) {
            source.listLower_2 = 編集後個人.get世帯コード().getColumnValue();
        }
        if (null != 編集後個人.get名称() && null != 編集後個人.get名称().getName()) {
            source.listLower_5 = 編集後個人.get名称().getName().getColumnValue();
        }
    }

    private void set前年度情報(TokubetsuChoshuIraikingakuMeisaiIchiranSource source,
            PrecedingFiscalYearInformation 前年度情報) {
        if (null != 前年度情報.get前年度保険料率()) {
            source.listCenter_2 = new RString(前年度情報.get前年度保険料率().toString());
        }
        if (null != 前年度情報.get前年度最終期特徴期別介護保険料()) {
            source.listCenter_3 = DecimalFormatter.toコンマ区切りRString(
                    前年度情報.get前年度最終期特徴期別介護保険料(), 0);
        }
    }

    private void set更正後(TokubetsuChoshuIraikingakuMeisaiIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {
        source.listUpper_4 = 更正後.get更正後特別徴収対象年金コード();
        source.listUpper_6 = 更正後.get更正後特別徴収義務者();
        source.listCenter_1 = 更正後.get保険料段階();
        if (null != 更正後.get更正後特徴期別金額01()) {
            source.listCenter_6 = DecimalFormatter.toコンマ区切りRString(
                    更正後.get更正後特徴期別金額01(), 0);
        }
        source.listLower_4 = 更正後.get更正後特別徴収対象年金コード();
        source.listLower_6 = 更正後.get更正後特別徴収対象年金();
    }

}
