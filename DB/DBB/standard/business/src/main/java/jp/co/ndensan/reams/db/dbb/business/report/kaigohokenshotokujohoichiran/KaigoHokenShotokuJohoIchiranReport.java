/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のReport
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranReport extends Report<KaigoHokenShotokuJohoIchiranSource> {

    private final KaigoHokenShotokuTempEntity 所得情報一覧Entity;
    private final RString 導入形態コード;
    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final List<RString> 出力順リスト;
    private final List<RString> 改頁リスト;
    private final Association association;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 所得情報一覧Entity KaigoHokenShotokuTempEntity
     * @param 導入形態コード RString
     * @param 市町村コード LasdecCode
     * @param 市町村名称 RString
     * @param 出力順リスト List<RString>
     * @param 改頁リスト List<RString>
     * @param association Association
     * @param 連番 int
     */
    public KaigoHokenShotokuJohoIchiranReport(KaigoHokenShotokuTempEntity 所得情報一覧Entity,
            RString 導入形態コード,
            LasdecCode 市町村コード,
            RString 市町村名称,
            List<RString> 出力順リスト,
            List<RString> 改頁リスト,
            Association association,
            int 連番) {
        this.所得情報一覧Entity = 所得情報一覧Entity;
        this.導入形態コード = 導入形態コード;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.出力順リスト = 出力順リスト;
        this.改頁リスト = 改頁リスト;
        this.association = association;
        this.連番 = 連番;
    }

    @Override
    public void writeBy(ReportSourceWriter<KaigoHokenShotokuJohoIchiranSource> writer) {
        IKaigoHokenShotokuJohoIchiranEditor editor = new KaigoHokenShotokuJohoIchiranEditor(
                所得情報一覧Entity, 導入形態コード, 市町村コード, 市町村名称, 出力順リスト, 改頁リスト, association, 連番);
        IKaigoHokenShotokuJohoIchiranBuilder builder = new KaigoHokenShotokuJohoIchiranBuilder(editor);
        writer.writeLine(builder);
    }
}
