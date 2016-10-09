/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karinonyutsuchishohakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karinonyutsuchishohakkoichiran.KariNonyuTsuchishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 保険料納入通知書（仮算定）発行一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0710-050 yebangqiang
 */
public class KariNonyuTsuchishoHakkoIchiranReport extends Report<KariNonyuTsuchishoHakkoIchiranSource> {

    private final KariSanteiNonyuTsuchiShoJoho entity;
    private final List<KariSanteiNonyuTsuchiShoJoho> entityList;
    private final List<RString> 並び順List;
    private final YMDHMS 帳票作成日時;
    private final int 出力期;
    private final Association association;
    private final Decimal 連番;

    /**
     * コンストラクタです。
     *
     * @param entity 仮算定納入通知書情報Entity
     * @param 並び順List List<RString>
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @param association Association
     * @param 連番 Decimal
     */
    public KariNonyuTsuchishoHakkoIchiranReport(KariSanteiNonyuTsuchiShoJoho entity,
            List<RString> 並び順List, YMDHMS 帳票作成日時, int 出力期, Association association, Decimal 連番) {
        this.entity = entity;
        this.entityList = null;
        this.並び順List = 並び順List;
        this.帳票作成日時 = 帳票作成日時;
        this.出力期 = 出力期;
        this.association = association;
        this.連番 = 連番;
    }

    /**
     * コンストラクタです。
     *
     * @param entityList 仮算定納入通知書情報EntityList
     * @param 並び順List List<RString>
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @param association Association
     */
    public KariNonyuTsuchishoHakkoIchiranReport(List<KariSanteiNonyuTsuchiShoJoho> entityList,
            List<RString> 並び順List, YMDHMS 帳票作成日時, int 出力期, Association association) {
        this.entity = null;
        this.entityList = entityList;
        this.並び順List = 並び順List;
        this.帳票作成日時 = 帳票作成日時;
        this.出力期 = 出力期;
        this.association = association;
        this.連番 = Decimal.ONE;
    }

    /**
     * createFormメソッド
     *
     * @param 仮算定納入通知書情報EntityList List<KariSanteiNonyuTsuchiShoJoho>
     * @param 並び順List List<RString>
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @param association Association
     * @return KariNonyuTsuchishoHakkoIchiranReport
     */
    public static KariNonyuTsuchishoHakkoIchiranReport createForm(
            @NonNull List<KariSanteiNonyuTsuchiShoJoho> 仮算定納入通知書情報EntityList, List<RString> 並び順List,
            YMDHMS 帳票作成日時, int 出力期, Association association) {
        return new KariNonyuTsuchishoHakkoIchiranReport(仮算定納入通知書情報EntityList, 並び順List, 帳票作成日時, 出力期, association);
    }

    /**
     * createFormメソッド
     *
     * @param 仮算定納入通知書情報Entity KariSanteiNonyuTsuchiShoJoho
     * @param 並び順List List<RString>
     * @param 帳票作成日時 YMDHMS
     * @param 出力期 int
     * @param association Association
     * @param 連番 Decimal
     * @return KariNonyuTsuchishoHakkoIchiranReport
     */
    public static KariNonyuTsuchishoHakkoIchiranReport createForm(
            @NonNull KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報Entity, List<RString> 並び順List,
            YMDHMS 帳票作成日時, int 出力期, Association association, Decimal 連番) {
        return new KariNonyuTsuchishoHakkoIchiranReport(仮算定納入通知書情報Entity, 並び順List, 帳票作成日時, 出力期, association, 連番);
    }

    @Override
    public void writeBy(ReportSourceWriter<KariNonyuTsuchishoHakkoIchiranSource> writer) {
        IKariNonyuTsuchishoHakkoIchiranEditor headerEditor = new KariNonyuTsuchishoHakkoIchiranHeaderEditor(帳票作成日時);
        IKariNonyuTsuchishoHakkoIchiranEditor bodyEditor = new KariNonyuTsuchishoHakkoIchiranBodyEditor(entity,
                並び順List, 出力期, association, 連番);
        IKariNonyuTsuchishoHakkoIchiranBuilder builder = new KariNonyuTsuchishoHakkoIchiranBuilder(
                headerEditor, bodyEditor);
        writer.writeLine(builder);
    }
}
