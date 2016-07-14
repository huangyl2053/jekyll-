/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorlist.KogakuSogoJigyoServicehiHanteiErrorListEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリスト Report
 *
 * @reamsid_L DBC-2010-130 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranReport extends Report<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> {

    private final List<KogakuSogoJigyoServicehiHanteiErrorListEntity> entityList;
    private final Association association;
    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;
    private final List<RString> 改頁項目List;

    /**
     * インスタンスを生成します。
     *
     * @param entityList List<KogakuSogoJigyoServicehiHanteiErrorListEntity>
     * @param association Association
     * @param 並び順の１件目 RString
     * @param 並び順の２件目 RString
     * @param 並び順の３件目 RString
     * @param 並び順の４件目 RString
     * @param 並び順の５件目 RString
     * @param 改頁項目List List<RString>
     */
    public KogakuSogoJigyoServicehiHanteiErrorIchiranReport(List<KogakuSogoJigyoServicehiHanteiErrorListEntity> entityList,
            Association association, RString 並び順の１件目, RString 並び順の２件目, RString 並び順の３件目,
            RString 並び順の４件目, RString 並び順の５件目, List<RString> 改頁項目List) {
        this.entityList = entityList;
        this.association = association;
        this.並び順の１件目 = 並び順の１件目;
        this.並び順の２件目 = 並び順の２件目;
        this.並び順の３件目 = 並び順の３件目;
        this.並び順の４件目 = 並び順の４件目;
        this.並び順の５件目 = 並び順の５件目;
        this.改頁項目List = 改頁項目List;
    }

    @Override
    public void writeBy(ReportSourceWriter<KogakuSogoJigyoServicehiHanteiErrorIchiranSource> reportSourceWriter) {
        IKogakuSogoJigyoServicehiHanteiErrorIchiranEditor editor
                = new KogakuSogoJigyoServicehiHanteiErrorIchiranEditor(entityList, association, 並び順の１件目, 並び順の２件目,
                        並び順の３件目, 並び順の４件目, 並び順の５件目, 改頁項目List);
        IKogakuSogoJigyoServicehiHanteiErrorIchiranBuilder builder
                = new KogakuSogoJigyoServicehiHanteiErrorIchiranBuilder(editor);
        reportSourceWriter.writeLine(builder);
    }
}
