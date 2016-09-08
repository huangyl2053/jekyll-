/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankaiList;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 段階別被保険者数一覧表帳票クラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranReport extends Report<ShotokuDankaiBetsuHihokenshasuIchiranSource> {

    private final HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity;
    private final HyojunDankaibetsuHihokenshasuGroup 標準設定段階別被保険者数合計entity;
    private final YMDHMS 作成日時;
    private final RDate 資格基準日;
    private final RDate 調定基準日;
    private final FlexibleYear 年度;
    private final HokenryoDankaiList hokenryoDankaiList;

    /**
     * コンストラクタです。
     *
     * @param 保険者設定段階別被保険者数合計entity HokenshaDankaibetsuHihokenshasuGroup
     * @param 標準設定段階別被保険者数合計entity HyojunDankaibetsuHihokenshasuGroup
     * @param 作成日時 YMDHMS
     * @param 資格基準日 RDate
     * @param 調定基準日 RDate
     * @param 年度 FlexibleYear
     * @param hokenryoDankaiList HokenryoDankaiList
     */
    public ShotokuDankaiBetsuHihokenshasuIchiranReport(
            HokenshaDankaibetsuHihokenshasuGroup 保険者設定段階別被保険者数合計entity,
            HyojunDankaibetsuHihokenshasuGroup 標準設定段階別被保険者数合計entity,
            YMDHMS 作成日時, RDate 資格基準日, RDate 調定基準日, FlexibleYear 年度,
            HokenryoDankaiList hokenryoDankaiList) {

        this.保険者設定段階別被保険者数合計entity = 保険者設定段階別被保険者数合計entity;
        this.標準設定段階別被保険者数合計entity = 標準設定段階別被保険者数合計entity;
        this.作成日時 = 作成日時;
        this.資格基準日 = 資格基準日;
        this.調定基準日 = 調定基準日;
        this.年度 = 年度;
        this.hokenryoDankaiList = hokenryoDankaiList;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShotokuDankaiBetsuHihokenshasuIchiranSource> writer) {
        IShotokuDankaiBetsuHihokenshasuIchiranEditor headerEditor
                = new ShotokuDankaiBetsuHihokenshasuIchiranHeaderEditor(保険者設定段階別被保険者数合計entity, 資格基準日, 調定基準日);
        IShotokuDankaiBetsuHihokenshasuIchiranEditor bodyEditor
                = new ShotokuDankaiBetsuHihokenshasuIchiranBodyEditor(保険者設定段階別被保険者数合計entity,
                        標準設定段階別被保険者数合計entity, 作成日時, 年度, hokenryoDankaiList);
        IShotokuDankaiBetsuHihokenshasuIchiranBuilder builder = new ShotokuDankaiBetsuHihokenshasuIchiranBuilder(headerEditor, bodyEditor);
        writer.writeLine(builder);
    }

}
