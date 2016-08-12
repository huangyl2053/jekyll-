/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.batchcontroller.step.dbx001001;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.dbx001001.TokuchoTenbikiTeishiMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.processprm.dbx001001.TokuchoTenbikiTeishiProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin.ChoshuhohokoshinEntity;
import jp.co.ndensan.reams.db.dbx.service.core.choshuhoho.ChoshuHohoKoshin;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴天引き停止徴収方法更新のプロセスクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
public class ChoshuhohoKoshinProcess extends BatchProcessBase<ChoshuhohokoshinEntity> {

    private static final RString 年 = new RString("年");
    private static final RString 月 = new RString("月");
    private static final RString FULLYEAR = new RString("0000");
    private static final RString FULLMONTH = new RString("00");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate"
            + ".tokuchotenbikiteishichoshuhohokoshin.ITokuchoTenbikiTeishiChoshuhohokoshinMapper.getChoshoHohos");
    private TokuchoTenbikiTeishiProcessParameter parameter;
    private ChoshuHohoKoshin service;
    @BatchWriter
    BatchPermanentTableWriter<DbT2001ChoshuHohoEntity> tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, toMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected void initialize() {
        service = ChoshuHohoKoshin.createInstance();
    }

    @Override
    protected void process(ChoshuhohokoshinEntity entity) {
        DbV2001ChoshuHohoEntity 介護徴収方法ビュー = entity.get介護徴収方法();
        if (介護徴収方法ビュー == null) {
            return;
        }
        ChoshuHoho 新介護徴収方法 = service.getChoshuHohoKoshinData(
                new ChoshuHoho(toDbT2001ChoshuHohoEntity(介護徴収方法ビュー)), YMDHMS.now(), null, null);
        if (!新介護徴収方法.toEntity().equalsPrimaryKeys(toDbT2001ChoshuHohoEntity(介護徴収方法ビュー))) {
            tableWriter.insert(新介護徴収方法.toEntity());
        }
    }

    private TokuchoTenbikiTeishiMyBatisParameter toMyBatisParameter() {
        parameter.set天引月(formatMonthFull(parameter.get天引月()));
        parameter.set年度(formatYearFull(parameter.get年度()));
        return new TokuchoTenbikiTeishiMyBatisParameter(parameter.get日付関連調定年度(),
                parameter.get天引月(), parameter.get年度());
    }

    private RString formatMonthFull(RString month) {
        if (RString.isNullOrEmpty(month) || month.trim().isEmpty()
                || month.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        month = month.trim().replace(月, RString.EMPTY).trim();
        return new RString(new Decimal(month.toString()).toString(FULLMONTH.toString()));
    }

    private RString formatYearFull(RString year) {
        if (RString.isNullOrEmpty(year) || year.trim().isEmpty()
                || year.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        year = year.trim().replace(年, RString.EMPTY).trim();
        return new RString(new Decimal(year.toString()).toString(FULLYEAR.toString()));
    }

    private DbT2001ChoshuHohoEntity toDbT2001ChoshuHohoEntity(DbV2001ChoshuHohoEntity 介護徴収方法ビュー) {
        DbT2001ChoshuHohoEntity 介護徴収方法 = new DbT2001ChoshuHohoEntity();
        FlexibleYear flexibleYear = 介護徴収方法ビュー.getFukaNendo();
        介護徴収方法.setFukaNendo(flexibleYear == null ? FlexibleYear.EMPTY : flexibleYear);
        HihokenshaNo hihokenshaNo = 介護徴収方法ビュー.getHihokenshaNo();
        介護徴収方法.setHihokenshaNo(hihokenshaNo == null ? HihokenshaNo.EMPTY : hihokenshaNo);
        介護徴収方法.setRirekiNo(介護徴収方法ビュー.getRirekiNo());
        介護徴収方法.setChoshuHoho4gatsu(介護徴収方法ビュー.getChoshuHoho4gatsu());
        介護徴収方法.setChoshuHoho5gatsu(介護徴収方法ビュー.getChoshuHoho5gatsu());
        介護徴収方法.setChoshuHoho6gatsu(介護徴収方法ビュー.getChoshuHoho6gatsu());
        介護徴収方法.setChoshuHoho7gatsu(介護徴収方法ビュー.getChoshuHoho7gatsu());
        介護徴収方法.setChoshuHoho8gatsu(介護徴収方法ビュー.getChoshuHoho8gatsu());
        介護徴収方法.setChoshuHoho9gatsu(介護徴収方法ビュー.getChoshuHoho9gatsu());
        介護徴収方法.setChoshuHoho10gatsu(介護徴収方法ビュー.getChoshuHoho10gatsu());
        介護徴収方法.setChoshuHoho11gatsu(介護徴収方法ビュー.getChoshuHoho11gatsu());
        介護徴収方法.setChoshuHoho12gatsu(介護徴収方法ビュー.getChoshuHoho12gatsu());
        介護徴収方法.setChoshuHoho1gatsu(介護徴収方法ビュー.getChoshuHoho1gatsu());
        介護徴収方法.setChoshuHoho2gatsu(介護徴収方法ビュー.getChoshuHoho2gatsu());
        介護徴収方法.setChoshuHoho3gatsu(介護徴収方法ビュー.getChoshuHoho3gatsu());
        介護徴収方法.setChoshuHohoYoku4gatsu(介護徴収方法ビュー.getChoshuHohoYoku4gatsu());
        介護徴収方法.setChoshuHohoYoku5gatsu(介護徴収方法ビュー.getChoshuHohoYoku5gatsu());
        介護徴収方法.setChoshuHohoYoku6gatsu(介護徴収方法ビュー.getChoshuHohoYoku6gatsu());
        介護徴収方法.setChoshuHohoYoku7gatsu(介護徴収方法ビュー.getChoshuHohoYoku7gatsu());
        介護徴収方法.setChoshuHohoYoku8gatsu(介護徴収方法ビュー.getChoshuHohoYoku8gatsu());
        介護徴収方法.setChoshuHohoYoku9gatsu(介護徴収方法ビュー.getChoshuHohoYoku9gatsu());
        介護徴収方法.setKariNenkinNo(介護徴収方法ビュー.getKariNenkinNo());
        介護徴収方法.setKariNenkinCode(介護徴収方法ビュー.getKariNenkinCode());
        介護徴収方法.setKariHosokuM(介護徴収方法ビュー.getKariHosokuM());
        介護徴収方法.setHonNenkinNo(介護徴収方法ビュー.getHonNenkinNo());
        介護徴収方法.setHonNenkinCode(介護徴収方法ビュー.getHonNenkinCode());
        介護徴収方法.setHonHosokuM(介護徴収方法ビュー.getHonHosokuM());
        介護徴収方法.setYokunendoKariNenkinNo(介護徴収方法ビュー.getYokunendoKariNenkinNo());
        介護徴収方法.setYokunendoKariNenkinCode(介護徴収方法ビュー.getYokunendoKariNenkinCode());
        介護徴収方法.setYokunendoKariHosokuM(介護徴収方法ビュー.getYokunendoKariHosokuM());
        介護徴収方法.setIraiSohuzumiFlag(介護徴収方法ビュー.getIraiSohuzumiFlag());
        介護徴収方法.setTsuikaIraiSohuzumiFlag(介護徴収方法ビュー.getTsuikaIraiSohuzumiFlag());
        介護徴収方法.setTokuchoTeishiNichiji(介護徴収方法ビュー.getTokuchoTeishiNichiji());
        介護徴収方法.setTokuchoTeishiJiyuCode(介護徴収方法ビュー.getTokuchoTeishiJiyuCode());
        return 介護徴収方法;
    }
}
