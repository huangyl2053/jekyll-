/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事務局審査会資料組み合わせ一覧A4版のReportクラスです。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaishiryoA4Report extends Report<JimuShinsakaishiryoA4ReportSource> {

    private final List<JimuShinsakaishiryoBusiness> shinsakaishiryoList;
    private final IchijihanteikekkahyoA4Entity ichijihanteiEntity;
    private final TokkiText1A4Business tokkiTextBusiness;
    private final JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho;
    private final JimuSonotashiryoBusiness sonotashiryoBusiness;
    private final List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList;
    private static final int LENGTH_20 = 20;
    private static final int MAXCOUNT = 30;

    /**
     * インスタンスを生成します。
     *
     * @param shinsakaishiryoList List<JimuShinsakaishiryoBusiness>
     * @param ichijihanteiEntity IchijihanteikekkahyoA4Entity
     * @param tokkiTextBusiness 特記事項の編集クラス
     * @param shinsakaiWariateJoho 主治医意見書のBusinessの編集クラス
     * @param sonotashiryoBusiness その他資料情報のBusinessの編集クラス
     * @param tuikaSiryoBusinessList 追加資料鑑情報のBusinessの編集クラス
     */
    public JimuShinsakaishiryoA4Report(List<JimuShinsakaishiryoBusiness> shinsakaishiryoList,
            IchijihanteikekkahyoA4Entity ichijihanteiEntity, TokkiText1A4Business tokkiTextBusiness,
            JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho, JimuSonotashiryoBusiness sonotashiryoBusiness,
            List<JimuTuikaSiryoBusiness> tuikaSiryoBusinessList) {
        this.shinsakaishiryoList = shinsakaishiryoList;
        this.ichijihanteiEntity = ichijihanteiEntity;
        this.tokkiTextBusiness = tokkiTextBusiness;
        this.shinsakaiWariateJoho = shinsakaiWariateJoho;
        this.sonotashiryoBusiness = sonotashiryoBusiness;
        this.tuikaSiryoBusinessList = tuikaSiryoBusinessList;
    }

    @Override
    public void writeBy(ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter) {
        for (JimuShinsakaishiryoBusiness business : shinsakaishiryoList) {
            IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group1Editor(business);
            IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        for (int i = 0; i < LENGTH_20; i++) {
            IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group2Editor(ichijihanteiEntity, i);
            IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
            reportSourceWriter.writeLine(builder);
        }
        List<TokkiA4Entity> 短冊情報リスト = tokkiTextBusiness.get短冊情報リスト();
        List<RString> 短冊リスト = get短冊リスト(短冊情報リスト);
        for (int i = 0; i < 短冊リスト.size(); i++) {
            if (i < MAXCOUNT) {
                IJimuShinsakaishiryoA4Editor editor1 = new JimuShinsakaishiryoA4Group3Editor(tokkiTextBusiness, 短冊情報リスト, 短冊リスト, i);
                IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor1);
                reportSourceWriter.writeLine(builder);
            } else {
                int page = (i + MAXCOUNT) / MAXCOUNT;
                IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group4Editor(tokkiTextBusiness, 短冊情報リスト, 短冊リスト, i, page - 1);
                IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
                reportSourceWriter.writeLine(builder2);
            }
        }
        IJimuShinsakaishiryoA4Editor editor = new JimuShinsakaishiryoA4Group5Editor(shinsakaiWariateJoho);
        IJimuShinsakaishiryoA4Builder builder = new JimuShinsakaishiryoA4Builder(editor);
        reportSourceWriter.writeLine(builder);
        IJimuShinsakaishiryoA4Editor editor1 = new JimuShinsakaishiryoA4Group6Editor(shinsakaiWariateJoho);
        IJimuShinsakaishiryoA4Builder builder1 = new JimuShinsakaishiryoA4Builder(editor1);
        reportSourceWriter.writeLine(builder1);
        //TODO 複数件の場合、実装なし。
        IJimuShinsakaishiryoA4Editor editor2 = new JimuShinsakaishiryoA4Group7Editor(sonotashiryoBusiness);
        IJimuShinsakaishiryoA4Builder builder2 = new JimuShinsakaishiryoA4Builder(editor2);
        reportSourceWriter.writeLine(builder2);
        for (JimuTuikaSiryoBusiness tuikaSiryoBusiness : tuikaSiryoBusinessList) {
            IJimuShinsakaishiryoA4Editor editor3 = new JimuShinsakaishiryoA4Group8Editor(tuikaSiryoBusiness);
            IJimuShinsakaishiryoA4Builder builder3 = new JimuShinsakaishiryoA4Builder(editor3);
            reportSourceWriter.writeLine(builder3);
        }
    }

    private List<RString> get短冊リスト(List<TokkiA4Entity> 短冊情報リスト) {
        List<RString> bodyList = new ArrayList<>();
        if (!短冊情報リスト.isEmpty()) {
            for (TokkiA4Entity entity : 短冊情報リスト) {
                bodyList.add(entity.get事項番号());
                bodyList.add(entity.get項目名称());
            }
        }
        return bodyList;
    }
}
