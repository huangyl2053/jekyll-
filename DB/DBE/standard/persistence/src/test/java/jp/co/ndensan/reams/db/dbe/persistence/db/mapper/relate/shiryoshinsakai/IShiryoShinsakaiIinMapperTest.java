/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.ShinsakaiShiryoUpdateMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput.IImageinputMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * {@link IImageinputMapper}のテストです。
 */
public class IShiryoShinsakaiIinMapperTest extends DbeTestDacBase {

    private static final RString 審査会開催番号 = new RString("20160150");
    private static final int 審査順開始 = 1;
    private static final int 審査順終了 = 3;
    private static final boolean is作成条件範囲 = false;
    private static final boolean is作成条件追加 = false;
    
    @BatchWriter
    BatchPermanentTableWriter<DbT5502ShinsakaiWariateJohoEntity> DbT5502TableWriter;

    public IShiryoShinsakaiIinMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    @Test
    public void getSelectByKey_DbT5502ShinsakaiWariateJoho() {
        DbT5502TableWriter = new BatchPermanentTableWriter(DbT5502ShinsakaiWariateJohoEntity.class);
        IShiryoShinsakaiIinMapper sut = this.sqlSession.getMapper(IShiryoShinsakaiIinMapper.class);
        ShinsakaiShiryoUpdateMyBatisParameter param = new ShinsakaiShiryoUpdateMyBatisParameter(審査会開催番号, 審査順開始, 審査順終了, is作成条件範囲, is作成条件追加);
        List<DbT5502ShinsakaiWariateJohoEntity> entities = sut.getSelectByKey_DbT5502ShinsakaiWariateJoho(param);
        System.out.println(entities.isEmpty());
        System.out.println(entities.size());
        DbT5502ShinsakaiWariateJohoEntity entity = entities.get(0);
        System.out.println(entity.getShinsakaiKaisaiNo());
        System.out.println(entity.getShinseishoKanriNo());
        System.out.println(entity.getShinsakaiKaisaiYMD());
        for (DbT5502ShinsakaiWariateJohoEntity entity2 : entities) {
            entity2.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
            try {
                DbT5502TableWriter.update(entity2);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
