 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokuChoHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBodyEditor implements ITokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranEditor {

    private final TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表;
    private final TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表;
    private static final int NUM_0 = 0;
    private static final int NUM_1 = 1;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final RString 編集コード_併徴者 = new RString("併徴者");
    private static final RString 編集コード_仮徴収額修正者 = new RString("仮徴収額修正者");
    private static final RString 編集コード_対象外_減額 = new RString("対象外_減額");
    private static final RString 編集コード_対象外_増額 = new RString("象外_増額");
    private static final RString 編集コード_特徴6月開始者 = new RString("特徴6月開始者");
    private final Association association;

    protected TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranBodyEditor(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表, Association association) {
        this.特徴平準化結果対象者一覧表 = 特徴平準化結果対象者一覧表;
        this.特徴平準化結果対象外一覧表 = 特徴平準化結果対象外一覧表;
        this.association = association;
    }

    @Override
    public TokuChoHeijunkaKeisanJuneKekkaIchiranSource edit(TokuChoHeijunkaKeisanJuneKekkaIchiranSource source) {
        source.hokenshaNo = association.get地方公共団体コード().value();
        source.hokenshaName = association.get市町村名();
        ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsu(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200009.getReportId());
        if (特徴平準化結果対象者一覧表 != null) {
            対象者項目編集(特徴平準化結果対象者一覧表, source, 帳票制御共通, association);
        }
        if (特徴平準化結果対象外一覧表 != null) {
            対象外項目編集(特徴平準化結果対象外一覧表, source, 帳票制御共通, association);
        }
        return source;
    }

    private void 対象者項目編集(TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者,
            TokuChoHeijunkaKeisanJuneKekkaIchiranSource source, ChohyoSeigyoKyotsu 帳票制御共通, Association association) {
        TokuchoHeijyunkaTaishoshaEntity item = 特徴平準化結果対象者.get特徴平準化結果対象者();
        RString 編集備考 = 備考名を転換(item.get備考コード());
        TsuchishoNo 通知書番号 = item.get通知書番号();
        if (通知書番号 != null) {
            source.listUpper_1 = 通知書番号.value();
        }
        if (item.get識別コード() != null) {
            source.listUpper_2 = item.get識別コード().value();
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = item.get宛名の情報();
        if (宛名の情報 != null) {
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名の情報);
            source.listUpper_4 = JushoHenshu.editJusho(帳票制御共通, iKojin, association);
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                source.listUpper_3 = 行政区コード.value();
            }
            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                source.listLower_3 = 町域コード.value();
            }
            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                source.listLower_4 = 氏名.value();
            }
        }
        final RString 特別徴収業務者コード = item.get特別徴収業務者コード();
        if (特別徴収業務者コード != null) {
            source.listUpper_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate());
        }
        変更前特徴額設定(item, source);
        source.listCenter_1 = item.get保険料段階仮算定時();
        if (特徴平準化結果対象者.get今年度保険料率() != null) {
            source.listCenter_2 = DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get今年度保険料率(), 0);
        }
        if (特徴平準化結果対象者.get調整金額() != null) {
            source.listCenter_3 = DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象者.get調整金額(), 0);
        }
        source.listCenter_4 = 編集備考;
        HihokenshaNo 被保険者番号 = item.get被保険者番号();
        if (被保険者番号 != null) {
            source.listLower_1 = 被保険者番号.value();
        }
        SetaiCode 世帯コード = item.get世帯コード();
        if (世帯コード != null) {
            source.listLower_2 = 世帯コード.value();
        }
        RString 仮徴収年金コード = item.get仮徴収年金コード();
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            source.listLower_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate());
        }
        特徴期期別金額設定(item, source);
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishoshaEntity item, TokuChoHeijunkaKeisanJuneKekkaIchiranSource source) {
        if (item.get特徴期期別金額01() != null) {
            source.listLower_6 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額01(), 0);
        }
        if (item.get特徴期期別金額02() != null) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額02(), 0);
        }
        if (item.get特徴期期別金額03() != null) {
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額03(), 0);
        }
        if (item.get特徴期期別金額04() != null) {
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額04(), 0);
        }
        if (item.get特徴期期別金額05() != null) {
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額05(), 0);
        }
        if (item.get特徴期期別金額06() != null) {
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額06(), 0);
        }
    }

    private void 変更前特徴額設定(TokuchoHeijyunkaTaishoshaEntity item, TokuChoHeijunkaKeisanJuneKekkaIchiranSource source) {
        if (item.get変更前特徴額_１期() != null) {
            source.listUpper_6 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_１期(), 0);
        }
        if (item.get変更前特徴額_２期() != null) {
            source.listUpper_7 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_２期(), 0);
        }
        if (item.get変更前特徴額_３期() != null) {
            source.listUpper_8 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_３期(), 0);
        }
        if (item.get変更前特徴額_４期() != null) {
            source.listUpper_9 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_４期(), 0);
        }
        if (item.get変更前特徴額_５期() != null) {
            source.listUpper_10 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_５期(), 0);
        }
        if (item.get変更前特徴額_６期() != null) {
            source.listUpper_11 = DecimalFormatter.toコンマ区切りRString(item.get変更前特徴額_６期(), 0);
        }
    }

    private void 対象外項目編集(TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外,
            TokuChoHeijunkaKeisanJuneKekkaIchiranSource source, ChohyoSeigyoKyotsu 帳票制御共通, Association association) {
        TokuchoHeijyunkaTaishogaiEntity item = 特徴平準化結果対象外.get特徴平準化結果対象外();
        RString 編集備考 = 備考名を転換(item.get備考コード());
        TsuchishoNo 通知書番号 = item.get通知書番号();
        if (通知書番号 != null) {
            source.listUpper_1 = 通知書番号.value();
        }
        if (item.get識別コード() != null) {
            source.listUpper_2 = item.get識別コード().value();
        }
        final UaFt200FindShikibetsuTaishoEntity 宛名の情報 = item.get宛名の情報();
        if (宛名の情報 != null) {
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名の情報);
            source.listUpper_4 = JushoHenshu.editJusho(帳票制御共通, iKojin, association);
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                source.listUpper_3 = 行政区コード.value();
            }
            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                source.listLower_3 = 町域コード.value();
            }
            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                source.listLower_4 = 氏名.value();
            }
        }
        final RString 特別徴収業務者コード = item.get特別徴収業務者コード();
        if (特別徴収業務者コード != null) {
            source.listUpper_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate());
        }
        source.listCenter_1 = item.get保険料段階仮算定時();
        if (特徴平準化結果対象外.get今年度保険料率() != null) {
            source.listCenter_2 = DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get今年度保険料率(), 0);
        }
        if (特徴平準化結果対象外.get調整金額() != null) {
            source.listCenter_3 = DecimalFormatter.toコンマ区切りRString(特徴平準化結果対象外.get調整金額(), 0);
        }
        source.listCenter_4 = 編集備考;
        HihokenshaNo 被保険者番号 = item.get被保険者番号();
        if (被保険者番号 != null) {
            source.listLower_1 = 被保険者番号.value();
        }
        SetaiCode 世帯コード = item.get世帯コード();
        if (世帯コード != null) {
            source.listLower_2 = 世帯コード.value();
        }
        RString 仮徴収年金コード = item.get仮徴収年金コード();
        if (仮徴収年金コード != null && (NUM_3 <= 仮徴収年金コード.length())) {
            source.listLower_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.年金コード.getCodeShubetsu(),
                    new Code(仮徴収年金コード.substring(NUM_0, NUM_3)), FlexibleDate.getNowDate());
        }
        特徴期期別金額設定(item, source);
    }

    private void 特徴期期別金額設定(TokuchoHeijyunkaTaishogaiEntity item, TokuChoHeijunkaKeisanJuneKekkaIchiranSource source) {
        if (item.get特徴期期別金額01() != null) {
            source.listLower_6 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額01(), 0);
        }
        if (item.get特徴期期別金額02() != null) {
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額02(), 0);
        }
        if (item.get特徴期期別金額03() != null) {
            source.listLower_8 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額03(), 0);
        }
        if (item.get特徴期期別金額04() != null) {
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額04(), 0);
        }
        if (item.get特徴期期別金額05() != null) {
            source.listLower_10 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額05(), 0);
        }
        if (item.get特徴期期別金額06() != null) {
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(item.get特徴期期別金額06(), 0);
        }
    }

    private RString 備考名を転換(RString 編集コード) {
        RString 備考名 = RString.EMPTY;
        if (!RString.isNullOrEmpty(編集コード)) {
            switch (Integer.parseInt(編集コード.toString())) {
                case NUM_1:
                    備考名 = 編集コード_併徴者;
                    break;
                case NUM_2:
                    備考名 = 編集コード_仮徴収額修正者;
                    break;
                case NUM_3:
                    備考名 = 編集コード_仮徴収額修正者;
                    break;
                case NUM_4:
                    備考名 = 編集コード_対象外_減額;
                    break;
                case NUM_5:
                    備考名 = 編集コード_対象外_増額;
                    break;
                case NUM_6:
                    備考名 = 編集コード_特徴6月開始者;
                    break;
                default:
                    break;
            }
            return 備考名;
        }
        return RString.EMPTY;
    }
}
