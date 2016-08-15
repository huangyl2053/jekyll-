/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nendokirikae.NendoKirikaeMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 徴収方法マスタ年度切替processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class InsetDbT2001ChoshuHohoProcess extends BatchProcessBase<DbV2001ChoshuHohoEntity> {

    private NendoKirikaeProcessParameter processParameter;
    private NendoKirikaeMybatisParameter parameter;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae."
            + "INendoKirikaeMapper.select徴収方法Newest");

    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected void initialize() {
        super.initialize();
        parameter = new NendoKirikaeMybatisParameter();
        parameter.set調定年度(processParameter.get調定年度());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(DbT2001ChoshuHohoEntity.class);
    }

    @Override
    protected void process(DbV2001ChoshuHohoEntity entity) {
        DbT2001ChoshuHohoEntity newEntity = new DbT2001ChoshuHohoEntity();
        newEntity.setFukaNendo(processParameter.get調定年度().plusYear(INT_1));
        HihokenshaNo 被保険者番号 = entity.getHihokenshaNo();
        if (被保険者番号 != null) {
            newEntity.setHihokenshaNo(被保険者番号);
        }
        newEntity.setRirekiNo(INT_0);
        YMDHMS 特別徴収停止日時 = entity.getTokuchoTeishiNichiji();
        if ((ChoshuHoho.特別徴収_厚生労働省.getコード().equals(entity.getChoshuHoho3gatsu())
                || ChoshuHoho.特別徴収_地共済.getコード().equals(entity.getChoshuHoho3gatsu()))
                && (特別徴収停止日時 == null || 特別徴収停止日時.isEmpty())) {
            newEntity.setChoshuHoho4gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho5gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho6gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho7gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho8gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho9gatsu(entity.getChoshuHoho3gatsu());
            newEntity.setChoshuHoho10gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHoho11gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHoho12gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHoho1gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHoho2gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHoho3gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku4gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku5gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku6gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku7gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku8gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setChoshuHohoYoku9gatsu(ChoshuHoho.資格なし.getコード());
            newEntity.setKariNenkinNo(entity.getKariNenkinNo());
            newEntity.setKariNenkinCode(entity.getKariNenkinNo());
            newEntity.setKariHosokuM(entity.getKariNenkinNo());
        }
        if ((ChoshuHoho.特別徴収_厚生労働省.getコード().equals(entity.getChoshuHoho3gatsu())
                || ChoshuHoho.特別徴収_地共済.getコード().equals(entity.getChoshuHoho3gatsu()))
                && 特別徴収停止日時 != null && !特別徴収停止日時.isEmpty()) {
            newEntity.setChoshuHoho4gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho5gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho6gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho7gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho8gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho9gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho10gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho11gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho12gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho1gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho2gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho3gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku4gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku5gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku6gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku7gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku8gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku9gatsu(ChoshuHoho.普通徴収.getコード());
        }
        if (ChoshuHoho.普通徴収.getコード().equals(entity.getChoshuHoho3gatsu())) {
            newEntity.setChoshuHoho4gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho5gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho6gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho7gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho8gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho9gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho10gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho11gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho12gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho1gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho2gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHoho3gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku4gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku5gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku6gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku7gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku8gatsu(ChoshuHoho.普通徴収.getコード());
            newEntity.setChoshuHohoYoku9gatsu(ChoshuHoho.普通徴収.getコード());
        }
        writer.insert(newEntity);
    }
}
