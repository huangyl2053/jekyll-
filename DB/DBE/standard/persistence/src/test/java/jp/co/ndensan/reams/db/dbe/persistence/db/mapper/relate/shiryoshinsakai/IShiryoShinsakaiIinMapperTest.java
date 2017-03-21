/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.ShinsakaiShiryoUpdateMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.TokkijikoIchiranJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.imageinput.IImageinputMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5504ShinsakaiWariateJohoKenshuEntity;
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

    private static final RString 審査会開催番号 = new RString("20160266");
    private static final RString 出力順 = RString.EMPTY;
    private static final ShinseishoKanriNo 申請書管理番号 = new ShinseishoKanriNo("20211820170300193");
    private static final int 認定調査依頼履歴番号 = 1;
    private static final String 境界線 = ("***************************");
    private static final int 審査順開始 = 1;
    private static final int 審査順終了 = 2;
    private static final boolean is作成条件範囲 = false;
    private static final boolean is作成条件追加 = false;
    private static final boolean is合議体ダミーフラグ = false;
    private static final boolean is出力順Empty = true;

    @BatchWriter
    BatchPermanentTableWriter<DbT5501ShinsakaiKaisaiYoteiJohoEntity> DbT5501TableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5502ShinsakaiWariateJohoEntity> DbT5502TableWriter;
    @BatchWriter
    BatchPermanentTableWriter<DbT5504ShinsakaiWariateJohoKenshuEntity> DbT5504TableWriter;

    public IShiryoShinsakaiIinMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

//    @Test
//    public void getSelectByKey_DbT5501ShinsakaiKaisaiYotei() {
//        DbT5501TableWriter = new BatchPermanentTableWriter(DbT5501ShinsakaiKaisaiYoteiJohoEntity.class);
//        IShiryoShinsakaiIinMapper sut = this.sqlSession.getMapper(IShiryoShinsakaiIinMapper.class);
//        ShinsakaiShiryoUpdateMyBatisParameter param = new ShinsakaiShiryoUpdateMyBatisParameter(
//                審査会開催番号, 審査順開始, 審査順終了, is作成条件範囲, is作成条件追加, is合議体ダミーフラグ);
//        DbT5501ShinsakaiKaisaiYoteiJohoEntity entity = sut.getSelectByKey(param);
//        System.out.println(entity == null);
//        System.out.println(entity.getShinsakaiKaisaiNo());
//        entity.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
//        try {
//            DbT5501TableWriter.update(entity);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
//    @Test
//    public void getSelectByKey_DbT5502ShinsakaiWariateJoho() {
//        DbT5502TableWriter = new BatchPermanentTableWriter(DbT5502ShinsakaiWariateJohoEntity.class);
//        IShiryoShinsakaiIinMapper sut = this.sqlSession.getMapper(IShiryoShinsakaiIinMapper.class);
//        ShinsakaiShiryoUpdateMyBatisParameter param = new ShinsakaiShiryoUpdateMyBatisParameter(
//                審査会開催番号, 審査順開始, 審査順終了, is作成条件範囲, is作成条件追加, is合議体ダミーフラグ);
//        List<DbT5502ShinsakaiWariateJohoEntity> entities = sut.getSelectByKey_DbT5502ShinsakaiWariateJoho(param);
//
//        System.out.println(entities.isEmpty());
//        System.out.println(entities.size());
//        DbT5502ShinsakaiWariateJohoEntity entity = entities.get(0);
//
//        System.out.println(entity.getShinsakaiKaisaiNo());
//        System.out.println(entity.getShinseishoKanriNo());
//        System.out.println(entity.getShinsakaiKaisaiYMD());
//        for (DbT5502ShinsakaiWariateJohoEntity entity2 : entities) {
//            entity2.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
//            try {
//                DbT5502TableWriter.update(entity2);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }
//    @Test
//    public void getSelectByKey_DbT5504ShinsakaiWariateJohoKenshu() {
//        DbT5504TableWriter = new BatchPermanentTableWriter(DbT5504ShinsakaiWariateJohoKenshuEntity.class);
//        IShiryoShinsakaiIinMapper sut = this.sqlSession.getMapper(IShiryoShinsakaiIinMapper.class);
//        ShinsakaiShiryoUpdateMyBatisParameter param = new ShinsakaiShiryoUpdateMyBatisParameter(
//                審査会開催番号, 審査順開始, 審査順終了, is作成条件範囲, is作成条件追加, is合議体ダミーフラグ);
//        List<DbT5504ShinsakaiWariateJohoKenshuEntity> entities = sut.getSelectByKey_DbT5504ShinsakaiWariateJohoKenshu(param);
//
//        System.out.println(entities.isEmpty());
//        System.out.println(entities.size());
//        DbT5504ShinsakaiWariateJohoKenshuEntity entity = entities.get(0);
//
//        System.out.println(entity.getShinsakaiKaisaiNo());
//        System.out.println(entity.getShinseishoKanriNo());
//        System.out.println(entity.getShinsakaiKaisaiYMD());
//        for (DbT5504ShinsakaiWariateJohoKenshuEntity entity2 : entities) {
//            entity2.setShinsakaiShiryoSakuseiYMD(FlexibleDate.getNowDate());
//            try {
//                DbT5504TableWriter.update(entity2);
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//    }
    @Test
    public void getTokkiIranJoho() {
        IShiryoShinsakaiIinMapper sut = this.sqlSession.getMapper(IShiryoShinsakaiIinMapper.class);
        IinTokkiJikouItiziHanteiMyBatisParameter param = new IinTokkiJikouItiziHanteiMyBatisParameter(
                審査会開催番号, 出力順, 審査順開始, 審査順終了, is作成条件範囲, is作成条件追加, is出力順Empty, is合議体ダミーフラグ);
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(申請書管理番号);
        認定調査依頼履歴番号リスト.add(認定調査依頼履歴番号);
        param.setShinseishoKanriNoList(申請書管理番号リスト);
        param.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        List<TokkijikoIchiranJohoRelateEntity> entityList = sut.getTokkiIranJoho(param);
        System.out.println(entityList.size());
        for (TokkijikoIchiranJohoRelateEntity entity : entityList) {
            System.out.println(境界線);
            System.out.println(entity.getMaxRemban());
            System.out.println(entity.get認定調査票特記事項Entity().getNinteichosaTokkijikoNo());
            System.out.println(entity.get認定調査票特記事項Entity().getTokkiJiko());
        }
    }
}
