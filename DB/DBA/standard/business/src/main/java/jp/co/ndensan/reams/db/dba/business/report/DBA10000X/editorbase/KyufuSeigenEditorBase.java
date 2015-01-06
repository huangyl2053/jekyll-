/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.DBA10000X.editorbase;

import jp.co.ndensan.reams.db.dba.business.report.DBA10000X.*;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.HihokenshashoB4;
import jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.db.dba.model.report.DBA10000X.IHihokenshashoCommonEditData;
import jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 被保険者証の、給付制限情報を編集するためのEditorBaseです。
 *
 * @author n8178 城間篤人
 */
public class KyufuSeigenEditorBase {

    private final HihokenshashoModel hihokenshashoModel;

    /**
     * コンストラクタです。引数から被保険者の情報を受け取ります。
     *
     * @param hihokenshashoModel 被保険者台帳情報
     */
    public KyufuSeigenEditorBase(HihokenshashoModel hihokenshashoModel) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));

        this.hihokenshashoModel = hihokenshashoModel;
    }

    public void set給付制限(IHihokenshashoCommonEditData source) {
        //TODO
        //1, HihokenshaShikakuHakkoの持つ、給付制限情報のListを、サービス金額の降順でソートする。
        //2, ソートした給付制限情報の、1番目の情報を以下に設定する。
        //  2-1, 制限の名称が8文字以下の場合、以下に対して給付制限名称を印字する。
        //source.seigen11 - 名称の前4文字を印字
        //source.seigen21 - 名称の後ろ4文字を印字
        //  2-2, 制限の名称が8文字より大きい場合、以下に対して給付制限名称を印字する。
        //source.seigenLong11 - 名称の前6文字を印字
        //source.seigenLong21 - 名称の後ろ6文字を印字
        //  2-3, 以下に、給付制限開始日と終了日を設定する。
        //source.seigenSt11
        //source.seigenEd11
        //
        //3, ソートした給付制限情報の、2番目の情報を以下に設定する。
        //  3-1, 制限の名称が8文字以下の場合、以下に対して給付制限名称を印字する。
        //source.seigen31 - 名称の前4文字を印字
        //source.seigen41 - 名称の後ろ4文字を印字
        //  3-2, 制限の名称が8文字より大きい場合、以下に対して給付制限名称を印字する。
        //source.seigenLong31 - 名称の前6文字を印字
        //source.seigenLong41 - 名称の後ろ6文字を印字
        //  3-3, 以下に、給付制限開始日と終了日を設定する。
        //source.seigenSt21
        //source.seigenEd21
        //
        //4, ソートした給付制限情報の、3番目の情報を以下に設定する。
        //  4-1, 制限の名称が8文字以下の場合、以下に対して給付制限名称を印字する。
        //source.seigen51 - 名称の前4文字を印字
        //source.seigen61 - 名称の後ろ4文字を印字
        //  4-2, 制限の名称が8文字より大きい場合、以下に対して給付制限名称を印字する。
        //source.seigenLong51 - 名称の前6文字を印字
        //source.seigenLong61 - 名称の後ろ6文字を印字
        //  4-3, 以下に、給付制限開始日と終了日を設定する。
        //source.seigenSt31
        //source.seigenEd31
    }

    public void set居宅介護支援事業者(IHihokenshashoCommonEditData source) {
        //TODO
        //1, HihokenshaShikakuHakkoModelから取得した居宅介護支援事業者の情報を、適用年月日で降順ソートする。
        //
        //2, ソートした居宅介護支援事業者の、1番目の情報を以下に設定する。
        //  2-1, 支援事業者名称の文字数で処理を分岐する。
        //      2-1-1, 支援事業者名称が40文字以下の場合
        //          source.gyosha1に支援事業者名を設定
        //      2-1-2, 支援事業者名称が40文字以下の場合
        //          source.itakuGyosha1に支援事業者名を設定
        //  2-2, 被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分の値で処理を分岐する。
        //      2-1, 適用開始日切替表示区分の値が0の場合
        //          source.todokeYmd11に適用届出日を設定する。
        //      2-2, 適用開始日切替表示区分の値が1の場合
        //          source.todokeYmd11に適用開始日を設定する。
        //
        //3, ソートした居宅介護支援事業者の、2番目の情報を以下に設定する。
        //  3-1, 支援事業者名称の文字数で処理を分岐する。
        //      3-1-1, 支援事業者名称が40文字以下の場合
        //          3-1-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.gyosha2に支援事業者名称を設定する。
        //          3-1-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          3-1-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.gyosha2に支援事業者名称を設定する。
        //                   また、source.gyosha2Asaに対して、支援事業者名称の文字数の、2倍の文字数の"*"を設定する。
        //          3-1-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.gyosha2Masshoに支援事業者名称を設定する。
        //      3-1-2, 支援事業者名称が40文字より大きい場合
        //          3-1-2-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.itakuGyosha2に支援事業者名称を設定する。
        //          3-1-2-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          3-1-2-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.itakuGyosha2に支援事業者名称を設定する。
        //                   また、source.itakuGyosha2Asaに対して、支援事業者名称の文字数の、2倍の文字数の"*"を設定する。
        //          3-1-2-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.itakuGyosha2Masshoに支援事業者名称を設定する。
        //  3-2, 被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分の値で処理を分岐する。
        //      3-2-1, 適用開始日切替表示区分の値が0の場合
        //          3-2-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.todokeYmd21に適用届出日を設定する。
        //          3-2-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          3-2-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.todokeYmd21に適用届出日を設定する。
        //                   また、source.todokeYmd2Asa1に対して、適用届出日の文字数だけ"*"を設定する。
        //          3-2-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.todokeYmd2Massho1に適用届出日を設定する。
        //      3-2-2, 適用開始日切替表示区分の値が1の場合
        //          3-2-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.todokeYmd21に適用開始日を設定する。
        //          3-2-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          3-2-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.todokeYmd21に適用開始日を設定する。
        //                   また、source.todokeYmd2Asa1に対して、適用届出日の文字数だけ"*"を設定する。
        //          3-2-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.todokeYmd2Massho1に適用開始日を設定する。
        //4, ソートした居宅介護支援事業者の、3番目の情報を以下に設定する。
        //  4-1, 支援事業者名称の文字数で処理を分岐する。
        //      4-1-1, 支援事業者名称が40文字以下の場合
        //          4-1-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.gyosha3に支援事業者名称を設定する。
        //          4-1-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          4-1-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.gyosha3に支援事業者名称を設定する。
        //                   また、source.gyosha3Asaに対して、支援事業者名称の文字数の、2倍の文字数の"*"を設定する。
        //          4-1-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.gyosha3Masshoに支援事業者名称を設定する。
        //      4-1-2, 支援事業者名称が40文字より大きい場合
        //          4-1-2-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.itakuGyosha3に支援事業者名称を設定する。
        //          4-1-2-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          4-1-2-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.itakuGyosha3に支援事業者名称を設定する。
        //                   また、source.itakuGyosha3Asaに対して、支援事業者名称の文字数の、2倍の文字数の"*"を設定する。
        //          4-1-2-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.itakuGyosha3Masshoに支援事業者名称を設定する。
        //  4-2, 被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分の値で処理を分岐する。
        //      4-2-1, 適用開始日切替表示区分の値が0の場合
        //          4-2-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.todokeYmd31に適用届出日を設定する。
        //          4-2-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          4-2-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.todokeYmd31に適用届出日を設定する。
        //                   また、source.todokeYmd2Asa1に対して、適用届出日の文字数だけ"*"を設定する。
        //          4-2-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.todokeYmd3Massho1に適用届出日を設定する。
        //      4-2-2, 適用開始日切替表示区分の値が1の場合
        //          4-2-1-1, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が0の場合
        //                   source.todokeYmd31に適用開始日を設定する。
        //          4-2-1-2, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が1の場合
        //                   何も行わない。
        //          4-2-1-3, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が2の場合
        //                   source.todokeYmd31に適用開始日を設定する。
        //                   また、source.todokeYmd3Asa1に対して、適用届出日の文字数だけ"*"を設定する。
        //          4-2-1-4, 被保険者証表示方法_居宅支援事業者履歴_表示方法の値が3の場合
        //                   source.todokeYmd3Massho1に適用開始日を設定する。
        //
    }

    public void set介護保険施設等(IHihokenshashoCommonEditData source) {
        //1, HihokenshaShikakuHakkoModelから取得した居宅介護支援事業者の情報を、入所年月日で降順ソートする。
        //2, ソートした居宅介護支援事業者の、1番目の情報を以下に設定する。
        //source.shisetsuSyu11 - 施設種類
        //source.shisetsuname11 - 施設名証
        //source.nyushoymd11 - 入所年月日を設定する。
        //source.taiinymd11 - 退所年月日を設定する。
        //  2-1, 事業者番号の先頭から３桁目（１ケタ）での判定について、１(医科)、３(歯科)、４(薬局)、６(訪問看護ステーション)の場合
        //      source.nyushochk11 に"*"を印字して、デザインシート上の入所日を潰す。
        //      source.taishochk11 に"*"を印字して、デザインシート上の退所日を潰す。
        //  2-2,
        //      source.nyuinchk11 に"*"を印字して、デザインシート上の入院日を潰す。
        //      source.taiinchk11 に"*"を印字して、デザインシート上の退院日を潰す。
        //
        //3, ソートした居宅介護支援事業者の、2番目の情報を以下に設定する。
        //source.shisetsuSyu21 - 施設種類
        //source.shisetsuname21 - 施設名証
        //source.nyushoymd21 - 入所年月日を設定する。
        //source.taiinymd21 - 退所年月日を設定する。
        //  3-1, 事業者番号の先頭から３桁目（１ケタ）での判定について、１(医科)、３(歯科)、４(薬局)、６(訪問看護ステーション)の場合
        //      source.nyushochk21 に"*"を印字して、デザインシート上の入所日を潰す。
        //      source.taishochk21 に"*"を印字して、デザインシート上の退所日を潰す。
        //  3-2,
        //      source.nyuinchk21 に"*"を印字して、デザインシート上の入院日を潰す。
        //      source.taiinchk21 に"*"を印字して、デザインシート上の退院日を潰す。
    }

}
