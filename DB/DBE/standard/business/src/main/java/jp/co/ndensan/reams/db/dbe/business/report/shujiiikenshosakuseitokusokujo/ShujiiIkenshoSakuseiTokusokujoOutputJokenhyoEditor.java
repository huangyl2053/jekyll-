/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakuseitokusokujo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE233001.ShujiiIkenTokusokujoHakkoReportProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 主治医意見書督促状の出力条件表編集クラスです。
 */
public class ShujiiIkenshoSakuseiTokusokujoOutputJokenhyoEditor {

    private static final RString チェックボックス未選択 = new RString("0");
    private static final int 督促方法コード_督促状郵送 = 0;
    private static final int 督促方法コード_督促状FAX = 1;
    private static final int 督促方法コード_電話 = 2;
    private static final int 督促方法コード_その他 = 3;
    private static final int 督促メモ表示最大桁数 = 184;
    private final ShujiiIkenTokusokujoHakkoReportProcessParameter param;

    /**
     * コンストラクタです。
     *
     * @param param {@link ShujiiIkenTokusokujoHakkoReportProcessParameter}
     */
    public ShujiiIkenshoSakuseiTokusokujoOutputJokenhyoEditor(
            ShujiiIkenTokusokujoHakkoReportProcessParameter param) {
        this.param = param;
    }

    /**
     * 出力条件を編集して返します。
     *
     * @return 条件リスト
     */
    public List<RString> edit() {
        List<RString> 出力条件List = new ArrayList<>();
        出力条件List.add(new RString("【保険者コード】").concat(edit保険者コード(param.getTemp_保険者コード())));
        出力条件List.add(new RString("【督促基準日】").concat(param.getTemp_基準日().wareki().toDateString()));
        出力条件List.add(new RString("【作成期限】").concat(edit作成期限(param.getTemp_主治医意見書督促期限日数())));
        出力条件List.add(new RString("【主治医医療機関コード】").concat(
                param.getTemp_主治医医療機関コード() == null ? RString.EMPTY : param.getTemp_主治医医療機関コード()));
        出力条件List.add(new RString("【主治医コード】").concat(
                param.getTemp_主治医コード() == null ? RString.EMPTY : param.getTemp_主治医コード()));
        出力条件List.add(new RString("【印刷済対象者】").concat(edit印刷済対象者条件(param.getTemp_印刷済対象者())));
        出力条件List.add(new RString("【印刷済対象者】").concat(edit印刷済対象者条件(param.getTemp_印刷済対象者())));
        出力条件List.add(new RString("【督促方法】").concat(edit督促方法(param.getTemp_督促方法())));
        出力条件List.add(new RString("【督促メモ】").concat(edit督促メモ(param.getTemp_督促メモ())));
        出力条件List.add(new RString("【督促日】").concat(param.getTemp_督促日().wareki().toDateString()));
        return 出力条件List;
    }

    private RString edit保険者コード(RString 保険者コード) {
        return 保険者コード == null || 保険者コード.isEmpty()
                ? new RString("全市町村")
                : 保険者コード;
    }

    private RString edit作成期限(Decimal 期限日数) {
        return new RString("作成期限から").concat(期限日数.toString()).concat("日以上過ぎた申請");
    }

    private RString edit印刷済対象者条件(RString 印刷済対象者) {
        return 印刷済対象者 == null || 印刷済対象者.isEmpty() || 印刷済対象者.equals(チェックボックス未選択)
                ? new RString("対象にする")
                : new RString("対象外にする");
    }

    private RString edit督促方法(int 督促方法コード) {
        switch (督促方法コード) {
            case 督促方法コード_督促状郵送:
                return new RString("督促状郵送");
            case 督促方法コード_督促状FAX:
                return new RString("督促状FAX");
            case 督促方法コード_電話:
                return new RString("電話");
            case 督促方法コード_その他:
                return new RString("その他");
            default:
                return RString.EMPTY;
        }
    }

    private RString edit督促メモ(RString 督促メモ) {
        if (督促メモ == null || 督促メモ.isEmpty()) {
            return RString.EMPTY;
        }
        if (督促メモ.length() <= 督促メモ表示最大桁数) {
            return 督促メモ;
        }
        return 督促メモ.substring(0, 督促メモ表示最大桁数);
    }
}
