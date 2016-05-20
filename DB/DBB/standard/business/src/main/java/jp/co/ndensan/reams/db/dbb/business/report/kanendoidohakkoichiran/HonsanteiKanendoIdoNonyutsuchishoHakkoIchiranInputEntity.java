/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBPR45002_保険料納入通知書（本算定過年度異動）発行一覧表 入力Entityです。
 *
 * Sourceは帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0920-050 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranInputEntity {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 調定年度;
    private final RString 出力期;
    private final RString 帳票作成日時;
    private final RString 出力順ID;
    private final RString 地方公共団体コード;
    private final RString 市町村名;
    private final int 連番;
    private final List<RString> 納入対象賦課年度List;

    /**
     * コンストラクタです。
     *
     * @param 編集後本算定通知書共通情報 EditedHonSanteiTsuchiShoKyotsuのListです
     * @param 調定年度 RString
     * @param 出力期 RString
     * @param 帳票作成日時 RString
     * @param 出力順ID RString
     * @param 地方公共団体コード RString
     * @param 市町村名 RString
     * @param 連番 int
     * @param 納入対象賦課年度List List<RString>
     */
    public HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranInputEntity(
            EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 調定年度, RString 出力期, RString 帳票作成日時,
            RString 出力順ID, RString 地方公共団体コード, RString 市町村名, int 連番, List<RString> 納入対象賦課年度List) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.調定年度 = 調定年度;
        this.出力期 = 出力期;
        this.帳票作成日時 = 帳票作成日時;
        this.出力順ID = 出力順ID;
        this.地方公共団体コード = 地方公共団体コード;
        this.市町村名 = 市町村名;
        this.連番 = 連番;
        this.納入対象賦課年度List = 納入対象賦課年度List;
    }

}
