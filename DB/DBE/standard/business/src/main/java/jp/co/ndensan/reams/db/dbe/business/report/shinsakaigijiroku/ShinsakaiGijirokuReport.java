/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaigijiroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.SanGyoumeKuIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.SanGyoumeYonJyoIchiRanEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiGijirokuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaigijiroku.ShinsakaiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaigijiroku.ShinsakaiGijirokuReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 介護認定審査会議事録のReportです。
 *
 * @reamsid_L DBE-0170-040 wangkun
 */
public class ShinsakaiGijirokuReport extends Report<ShinsakaiGijirokuReportSource> {

    private final ShinsakaiGijirokuEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item 介護認定審査会議事録のITEM
     */
    protected ShinsakaiGijirokuReport(ShinsakaiGijirokuEntity item) {
        this.item = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShinsakaiGijirokuReportSource> reportSourceWriter) {

        get新規と更新と区変の件数(item);
//            ShinsakaiGijirokuEditor editor = new ShinsakaiGijirokuEditor(data);
//            ShinsakaiGijirokuBodyEditor bodyEditor = new ShinsakaiGijirokuBodyEditor(dataBody);
//            ShinsakaiGijirokuBodyEditor2 bodyEditor2 = new ShinsakaiGijirokuBodyEditor2(editor);

//            ShinsakaiGijirokuBuilder builder = new ShinsakaiGijirokuBuilder(editor, bodyEditor, bodyEditor2);
//            reportSourceWriter.writeLine(builder);
    }

    private List<SanGyoumeYonJyoIchiRanEntity> get新規と更新と区変の件数(ShinsakaiGijirokuEntity item) {
        List<SanGyoumeYonJyoIchiRanEntity> resultList = new ArrayList<>();
        ShinsakaiKekkaJohoRelateEntity entity = item.get審査会審査結果等();
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get新規申請件数()),
                new RString(entity.get新規_状変の内2号被保険者数()),
                new RString(entity.get新規_状変在宅数()),
                new RString(entity.get新規_状変施設数())));
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get更新申請件数()),
                new RString(entity.get更新申請内2号被保険者数()),
                new RString(entity.get新規_状変在宅数()),
                new RString(entity.get新規_状変施設数())));
        resultList.add(new SanGyoumeYonJyoIchiRanEntity(new RString(entity.get判定件数()),
                new RString(entity.get判定件数_2号被保険者数()),
                new RString(entity.get判定件数_在宅数()),
                new RString(entity.get判定件数_施設数())));

        return resultList;
    }

    private List<SanGyoumeKuIchiRanEntity> get新規と更新と区変毎の件数毎の件数上(ShinsakaiGijirokuEntity item) {
        List<SanGyoumeKuIchiRanEntity> resultList = new ArrayList<>();
        ShinsakaiKekkaJohoRelateEntity entity = item.get審査会審査結果等();
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get新規_状変一次判定非該当数()),
                new RString(entity.get新規_状変一次判定要支援1数()),
                new RString(entity.get新規_状変一次判定要支援2数()),
                new RString(entity.get新規_状変一次判定要介護1数()),
                new RString(entity.get新規_状変一次判定要介護2数()),
                new RString(entity.get新規_状変一次判定要介護3数()),
                new RString(entity.get新規_状変一次判定要介護4数()),
                new RString(entity.get新規_状変一次判定要介護5数()),
                new RString(entity.get新規_状変一次判定再調査数())));
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get更新申請の一次判定非該当数()),
                new RString(entity.get更新申請の一次判定要支援1数()),
                new RString(entity.get更新申請の一次判定要支援2数()),
                new RString(entity.get更新申請の一次判定要介護1数()),
                new RString(entity.get更新申請の一次判定要介護2数()),
                new RString(entity.get更新申請の一次判定要介護3数()),
                new RString(entity.get更新申請の一次判定要介護4数()),
                new RString(entity.get更新申請の一次判定要介護5数()),
                new RString(entity.get更新申請の一次判定再調査数())));
        // TODO
        resultList.add(new SanGyoumeKuIchiRanEntity(new RString(entity.get二次判定_非該当()),
                new RString(entity.get二次判定_要支１()),
                new RString(entity.get二次判定_要支２()),
                new RString(entity.get二次判定_要介護１()),
                new RString(entity.get二次判定_要介護２()),
                new RString(entity.get二次判定_要介護３()),
                new RString(entity.get二次判定_要介護４()),
                new RString(entity.get二次判定_要介護５()),
                new RString(entity.get二次判定_要介護２())));

        return resultList;
    }

}
