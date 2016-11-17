/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR51001_所得照会票発行一覧表のReport
 *
 * @reamsid_L DBB-1720-060 lijunjun
 */
public class ShotokushokaihyoHakkoIchiranReport extends
        Report<ShotokushokaihyoHakkoIchiranSource> {

    private final List<ShotokuShoukaiDataTempEntity> 所得照会票発行一覧リスト;
    private final List<KoikiZenShichosonJoho> 構成市町村情報リスト;
    private final List<RString> 出力順項目リスト;
    private final Map<RString, RString> 改頁項目Map;
    private final List<RString> 改頁項目リスト;
    private final FlexibleDate 照会年月日;
    private final FlexibleYear 処理年度;
    private final boolean テストプリント;
    private final Association association;

    /**
     * コンストラクタです.
     *
     * @param 所得照会票発行一覧リスト List<ShotokuShoukaiDataTempEntity>
     * @param 構成市町村情報リスト List<KoikiZenShichosonJoho>
     * @param 出力順項目リスト List<RString>
     * @param 改頁項目Map Map<RString, RString>
     * @param 改頁項目リスト List<RString>
     * @param 照会年月日 FlexibleDate
     * @param 処理年度 FlexibleDate
     * @param テストプリント boolean
     * @param association Association
     */
    public ShotokushokaihyoHakkoIchiranReport(List<ShotokuShoukaiDataTempEntity> 所得照会票発行一覧リスト,
            List<KoikiZenShichosonJoho> 構成市町村情報リスト,
            List<RString> 出力順項目リスト,
            Map<RString, RString> 改頁項目Map,
            List<RString> 改頁項目リスト,
            FlexibleDate 照会年月日,
            FlexibleYear 処理年度,
            boolean テストプリント,
            Association association) {
        this.所得照会票発行一覧リスト = 所得照会票発行一覧リスト;
        this.構成市町村情報リスト = 構成市町村情報リスト;
        this.出力順項目リスト = 出力順項目リスト;
        this.改頁項目Map = 改頁項目Map;
        this.改頁項目リスト = 改頁項目リスト;
        this.照会年月日 = 照会年月日;
        this.処理年度 = 処理年度;
        this.テストプリント = テストプリント;
        this.association = association;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShotokushokaihyoHakkoIchiranSource> writer) {
        for (ShotokuShoukaiDataTempEntity 所得照会票発行一覧 : 所得照会票発行一覧リスト) {
            IShotokushokaihyoHakkoIchiranEditor editor = new ShotokushokaihyoHakkoIchiranEditor(所得照会票発行一覧,
                    構成市町村情報リスト, 出力順項目リスト, 改頁項目Map, 改頁項目リスト, 照会年月日, 処理年度, テストプリント, association);
            IShotokushokaihyoHakkoIchiranBuilder builder = new ShotokushokaihyoHakkoIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }
}
