/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.parts;

import jp.co.ndensan.reams.db.dbb.business.FukaErrorInternalReportItem;
import jp.co.ndensan.reams.ur.urz.business.internalreport.IInternalReportCommon;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 賦課エラー一覧内部帳票のエディタを生成するファクトリクラスです。
 *
 * @author N9606 漢那 憲作
 */
public final class FukaErrorListEditorFactory {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private FukaErrorListEditorFactory() {
    }

    /**
     * 引数から内部帳票情報、バッチ情報、賦課エラー一覧1行分のデータを受け取り、エディタにマッピングして返します。
     *
     * @param common 内部帳票情報
     * @param item 賦課エラー一覧、1行分のデータ
     * @return 賦課エラー一覧エディタ
     */
    public static IFukaErrorListEditor createInstance(final IInternalReportCommon common, final FukaErrorInternalReportItem item) {

        return new IFukaErrorListEditor() {
            @Override
            public FukaErrorListSource buildSource() {
                FukaErrorListSource source = new FukaErrorListSource();
                source.listMeisho = common.get内部帳票名();
                source.listSakuseiNichiji = new RString(common.get内部帳票作成日時().toString());
                source.batchShoriMeisho = common.getバッチ名();
                source.batchKidoNichiji = new RString(common.getバッチ起動日時().toString());
                source.page = new RString("1");
                source.listFukaNendo_1 = item.get賦課年度().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
                source.listTsuchishoNo_1 = item.get通知書番号().getColumnValue();
                source.listErrorNaiyo_1 = item.getエラー詳細().getMeisho();
                source.listHihoNo_1 = item.get被保険者番号().getColumnValue();
                source.listShikibetsuCode_1 = item.get識別コード().getColumnValue();
                source.listNo_1 = new RString("1");

                return source;
            }
        };

    }
}
