///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicejyuryokakuninsho;
//
//import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoEntity;
//import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicejyuryokakuninsho.KogakuServiceJyuryoKakuninShoSource;
//import jp.co.ndensan.reams.uz.uza.report.Report;
//import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
//
///**
// * 帳票設計_DBC100031_高額サービス費受領委任契約承認（不承認）確認書 のReportクラスです。
// *
// * @reamsid_L DBC-1980-040 qinzhen
// */
//public class KogakuServiceJyuryoKakuninShoReport extends Report<KogakuServiceJyuryoKakuninShoSource> {
//
//    private final KogakuServiceJyuryoKakuninShoEntity entity;
//
//    /**
//     * コンストラクタです
//     *
//     * @param entity KogakuServiceJyuryoKakuninShoEntity
//     */
//    public KogakuServiceJyuryoKakuninShoReport(KogakuServiceJyuryoKakuninShoEntity entity) {
//        this.entity = entity;
//
//    }
//
//    @Override
//    public void writeBy(ReportSourceWriter<KogakuServiceJyuryoKakuninShoSource> writer) {
//
//        IKogakuServiceJyuryoKakuninShoEditor editor = new KogakuServiceJyuryoKakuninShoEditor(entity);
//
//        IKogakuServiceJyuryoKakuninShoBuilder builder = new KogakuServiceJyuryoKakuninShoBuilder(editor);
//
//        writer.writeLine(builder);
//
//    }
//}
