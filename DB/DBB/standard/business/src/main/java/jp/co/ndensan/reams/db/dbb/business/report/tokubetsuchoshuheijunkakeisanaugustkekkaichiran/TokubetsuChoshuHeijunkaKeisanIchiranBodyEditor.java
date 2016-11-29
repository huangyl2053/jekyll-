/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 BodyEditorクラスです。
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranBodyEditor implements ITokubetsuChoshuHeijunkaKeisanIchiranEditor {

    private final TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表;
    private final TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private static final int NUM_0 = 0;
    private static final int NUM_2 = 2;
    private static final int NUM_3 = 3;
    private static final int NUM_4 = 4;
    private static final int NUM_5 = 5;
    private static final int NUM_7 = 7;
    private static final RString 編集コード_仮徴収額修正者 = new RString("仮徴収額修正者");
    private static final RString 編集コード_平準化の結果0円以下 = new RString("平準化の結果0円以下");
    private static final RString 編集コード_対象外_減額 = new RString("対象外_減額");
    private static final RString 編集コード_対象外_増額 = new RString("対象外_増額");
    private static final RString 編集コード_変更なし = new RString("変更なし");
    private static final RString 編集コード_6月特徴開始者 = new RString("6月特徴開始者");
    private static final RString 編集コード_8月特徴開始者 = new RString("8月特徴開始者");
    private static final Code DATA_3 = new Code("0003");
    private static final RString 被保険者番号_1 = new RString("被保険者番号");
    private final Association association;

    /**
     *
     * @param 特徴平準化結果対象者一覧表 TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param 特徴平準化結果対象外一覧表 TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param association Association
     */
    public TokubetsuChoshuHeijunkaKeisanIchiranBodyEditor(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association association) {
        this.特徴平準化結果対象者一覧表 = 特徴平準化結果対象者一覧表;
        this.特徴平準化結果対象外一覧表 = 特徴平準化結果対象外一覧表;
        this.帳票制御共通 = 帳票制御共通;
        this.association = association;
    }

    @Override
    public TokubetsuChoshuHeijunkaKeisanIchiranSource edit(TokubetsuChoshuHeijunkaKeisanIchiranSource source) {
        source.hokenshacd = association.get地方公共団体コード().value();
        source.hokenshamei = association.get市町村名();
        if (特徴平準化結果対象者一覧表 != null) {
            対象者項目編集(特徴平準化結果対象者一覧表, source, 帳票制御共通, association);
        }
        if (特徴平準化結果対象外一覧表 != null) {
            対象外項目編集(特徴平準化結果対象外一覧表, source, 帳票制御共通, association);
        }
        setPageBreakEmpty(source);
        return source;
    }

    private void setPageBreakEmpty(TokubetsuChoshuHeijunkaKeisanIchiranSource source) {
        if (source.listUpper_3 == null) {
            source.listUpper_3 = RString.EMPTY;
        }
        if (source.listLower_2 == null) {
            source.listLower_2 = RString.EMPTY;
        }
        if (source.listUpper_2 == null) {
            source.listUpper_2 = RString.EMPTY;
        }
        if (source.listLower_1 == null) {
            source.listLower_1 = RString.EMPTY;
        }
        if (source.listLower_3 == null) {
            source.listLower_3 = RString.EMPTY;
        }
        if (source.shichosonCode == null) {
            source.shichosonCode = RString.EMPTY;
        }
    }

    private void 対象者項目編集(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者,
            TokubetsuChoshuHeijunkaKeisanIchiranSource source,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association association) {
        TokuchoHeijyunkaTaishoshaEntity item = 特徴平準化結果対象者.get特徴平準化結果対象者();
        TsuchishoNo 通知書番号 = item.get通知書番号();
        if (通知書番号 != null) {
            source.listUpper_1 = 通知書番号.value();
        }
        if (item.get識別コード() != null) {
            source.listUpper_2 = item.get識別コード().value();
        } else {
            source.listUpper_2 = RString.EMPTY;
        }

        UaFt200FindShikibetsuTaishoEntity 宛名の情報 = item.get宛名の情報();

        if (宛名の情報 != null) {
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                source.listUpper_3 = 行政区コード.value();
            }
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名の情報);
            source.listUpper_4 = JushoHenshu.editJusho(帳票制御共通, iKojin, association);

            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                source.listLower_3 = 町域コード.value();
            }

            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                source.listLower_4 = 氏名.value();
            }
        }

        RString 特別徴収業務者コード = item.get特別徴収業務者コード();
        if (特別徴収業務者コード != null) {
            source.listUpper_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate());
        }
        set変更前特徴額(source, item);

        if (item.get普徴期期別金額01() != null) {
            source.listUpper_9 = doカンマ編集(item.get普徴期期別金額01());
        }
        if (item.get普徴期期別金額02() != null) {
            source.listUpper_10 = doカンマ編集(item.get普徴期期別金額02());
        }
        if (item.get普徴期期別金額03() != null) {
            source.listUpper_11 = doカンマ編集(item.get普徴期期別金額03());
        }
        if (item.get普徴期期別金額04() != null) {
            source.listUpper_12 = doカンマ編集(item.get普徴期期別金額04());
        }

        if (item.get保険料算定段階2() == null) {
            source.listCenter_1 = item.get保険料算定段階1();
        } else {
            source.listCenter_1 = item.get保険料算定段階2();
        }
        if (特徴平準化結果対象者.get今年度保険料率() != null) {
            source.listCenter_2 = doカンマ編集(特徴平準化結果対象者.get今年度保険料率());
        }
        if (特徴平準化結果対象者.get調整金額() != null) {
            source.listCenter_3 = doカンマ編集(特徴平準化結果対象者.get調整金額());
        }

        備考を編集(item, source);

        HihokenshaNo 被保険者番号 = item.get被保険者番号();
        if (被保険者番号 != null) {
            source.listLower_1 = 被保険者番号.value();
        }
        source.拡張情報 = new ExpandedInformation(DATA_3, 被保険者番号_1, source.listLower_1);
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
        set賦課市町村コード(source, item);
        set変更後特徴額と普通仮徴収額(item, source);

    }

    private void set賦課市町村コード(TokubetsuChoshuHeijunkaKeisanIchiranSource source, TokuchoHeijyunkaTaishoshaEntity item) {
        if (item.get賦課市町村コード() != null) {
            source.shichosonCode = item.get賦課市町村コード().value();
        } else {
            source.shichosonCode = RString.EMPTY;
        }
    }

    private void set変更前特徴額(TokubetsuChoshuHeijunkaKeisanIchiranSource source, TokuchoHeijyunkaTaishoshaEntity item) {

        if (item.get変更前特徴額_１期() != null) {
            source.listUpper_6 = doカンマ編集(item.get変更前特徴額_１期());
        }
        if (item.get変更前特徴額_２期() != null) {
            source.listUpper_7 = doカンマ編集(item.get変更前特徴額_２期());
        }
        if (item.get変更前特徴額_３期() != null) {
            source.listUpper_8 = doカンマ編集(item.get変更前特徴額_３期());
        }
    }

    private void 備考を編集(TokuchoHeijyunkaTaishoshaEntity item, TokubetsuChoshuHeijunkaKeisanIchiranSource source) {
        if (!ChoshuHoho.特別徴収_厚生労働省.getコード().equals(item.get徴収方法4月())
                && !ChoshuHoho.特別徴収_地共済.getコード().equals(item.get徴収方法4月())
                && (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(item.get徴収方法6月())
                || ChoshuHoho.特別徴収_地共済.getコード().equals(item.get徴収方法6月()))) {

            source.listCenter_4 = 編集コード_6月特徴開始者;
        }
        if (!ChoshuHoho.特別徴収_厚生労働省.getコード().equals(item.get徴収方法6月())
                && !ChoshuHoho.特別徴収_地共済.getコード().equals(item.get徴収方法6月())
                && (ChoshuHoho.特別徴収_厚生労働省.getコード().equals(item.get徴収方法8月())
                || ChoshuHoho.特別徴収_地共済.getコード().equals(item.get徴収方法8月()))) {
            source.listCenter_4 = 編集コード_8月特徴開始者;
        }
    }

    private void 対象外項目編集(
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外,
            TokubetsuChoshuHeijunkaKeisanIchiranSource source,
            ChohyoSeigyoKyotsu 帳票制御共通,
            Association association) {
        TokuchoHeijyunkaTaishogaiEntity item = 特徴平準化結果対象外.get特徴平準化結果対象外();
        TsuchishoNo 通知書番号 = item.get通知書番号();
        if (通知書番号 != null) {
            source.listUpper_1 = 通知書番号.value();
        }
        if (item.get識別コード() != null) {
            source.listUpper_2 = item.get識別コード().value();
        } else {
            source.listUpper_2 = RString.EMPTY;
        }
        UaFt200FindShikibetsuTaishoEntity 宛名の情報 = item.get宛名の情報();

        if (宛名の情報 != null) {
            GyoseikuCode 行政区コード = 宛名の情報.getGyoseikuCode();
            if (行政区コード != null) {
                source.listUpper_3 = 行政区コード.value();
            }
            IKojin iKojin = ShikibetsuTaishoFactory.createKojin(宛名の情報);
            source.listUpper_4 = JushoHenshu.editJusho(帳票制御共通, iKojin, association);

            ChoikiCode 町域コード = 宛名の情報.getChoikiCode();
            if (町域コード != null) {
                source.listLower_3 = 町域コード.value();
            }

            AtenaMeisho 氏名 = 宛名の情報.getKanjiShimei();
            if (氏名 != null) {
                source.listLower_4 = 氏名.value();
            }
        }

        RString 特別徴収業務者コード = item.get特別徴収業務者コード();
        if (特別徴収業務者コード != null) {
            source.listUpper_5 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                    UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                    new Code(特別徴収業務者コード), FlexibleDate.getNowDate());
        }

        source.listUpper_6 = RString.EMPTY;
        source.listUpper_7 = RString.EMPTY;
        source.listUpper_8 = RString.EMPTY;

        source.listUpper_9 = doカンマ編集(item.get普徴期期別金額01());
        source.listUpper_10 = doカンマ編集(item.get普徴期期別金額02());
        source.listUpper_11 = doカンマ編集(item.get普徴期期別金額03());
        source.listUpper_12 = doカンマ編集(item.get普徴期期別金額04());

        if (item.get保険料算定段階2() == null) {
            source.listCenter_1 = item.get保険料算定段階1();
        } else {
            source.listCenter_1 = item.get保険料算定段階2();
        }

        source.listCenter_2 = doカンマ編集(特徴平準化結果対象外.get今年度保険料率());
        source.listCenter_3 = doカンマ編集(特徴平準化結果対象外.get調整金額());

        RString 編集備考 = 備考名を転換(item.get備考コード());
        source.listCenter_4 = 編集備考;

        HihokenshaNo 被保険者番号 = item.get被保険者番号();
        if (被保険者番号 != null) {
            source.listLower_1 = 被保険者番号.value();
        }
        source.拡張情報 = new ExpandedInformation(DATA_3, 被保険者番号_1, source.listLower_1);
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
        if (item.get賦課市町村コード() != null) {
            source.shichosonCode = item.get賦課市町村コード().value();
        }

        set変更後特徴額と普通仮徴収額外(item, source);

    }

    private void set変更後特徴額と普通仮徴収額(TokuchoHeijyunkaTaishoshaEntity item, TokubetsuChoshuHeijunkaKeisanIchiranSource source) {
        if (item.get特徴期期別金額01() != null) {
            source.listLower_6 = doカンマ編集(item.get特徴期期別金額01());
        }
        if (item.get特徴期期別金額02() != null) {
            source.listLower_7 = doカンマ編集(item.get特徴期期別金額02());
        }
        if (item.get特徴期期別金額03() != null) {
            source.listLower_8 = doカンマ編集(item.get特徴期期別金額03());
        }
        if (item.get普徴期期別金額05() != null) {
            source.listLower_9 = doカンマ編集(item.get普徴期期別金額05());
        }
        if (item.get普徴期期別金額06() != null) {
            source.listLower_10 = doカンマ編集(item.get普徴期期別金額06());
        }

        source.listLower_11 = RString.EMPTY;

        source.listLower_12 = RString.EMPTY;

    }

    private void set変更後特徴額と普通仮徴収額外(TokuchoHeijyunkaTaishogaiEntity item, TokubetsuChoshuHeijunkaKeisanIchiranSource source) {

        source.listLower_6 = doカンマ編集(item.get特徴期期別金額01());
        source.listLower_7 = doカンマ編集(item.get特徴期期別金額02());
        source.listLower_8 = doカンマ編集(item.get特徴期期別金額03());
        source.listLower_9 = doカンマ編集(item.get普徴期期別金額05());
        source.listLower_10 = doカンマ編集(item.get普徴期期別金額06());
        source.listLower_11 = RString.EMPTY;
        source.listLower_12 = RString.EMPTY;

    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString 備考名を転換(RString 編集コード) {
        RString 備考名 = RString.EMPTY;
        if (!RString.isNullOrEmpty(編集コード)) {
            switch (Integer.parseInt(編集コード.toString())) {
                case NUM_2:
                    備考名 = 編集コード_仮徴収額修正者;
                    break;
                case NUM_3:
                    備考名 = 編集コード_平準化の結果0円以下;
                    break;
                case NUM_4:
                    備考名 = 編集コード_対象外_減額;
                    break;
                case NUM_5:
                    備考名 = 編集コード_対象外_増額;
                    break;
                case NUM_7:
                    備考名 = 編集コード_変更なし;
                    break;
                default:
                    break;
            }
            return 備考名;
        }
        return RString.EMPTY;
    }
}
