/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員用特記事項と一次判定結果票情報バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTokkiJikouItiziHanteiDataSakuseiA3Process extends BatchProcessBase<NinteiShinseiJohoEntity> {

    private static final RString SELECT_NINTEIJOHO = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getNinteiShinseiJoho");
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
//    private IShiryoShinsakaiIinMapper mapper;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;

    @Override
    protected void initialize() {
//        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_NINTEIJOHO, myBatisParameter);
    }

    @Override
    protected void process(NinteiShinseiJohoEntity entity) {

        // TODO 帳票を実装しない、
        myBatisParameter.setShinseishoKanri(entity.getShinseishoKanriNo());
        myBatisParameter.setNinteichosaRirekiNo(entity.getNinteichosaRirekiNo());
//        myBatisParameter.setGenponKubun(GenponMaskKubun.マスク.getコード());
//        if (mapper.getNinteiTokkijikoCount(myBatisParameter) == 0) {
//            myBatisParameter.setGenponKubun(GenponMaskKubun.原本.getコード());
//        }
//        List<NinteiTokkijikoEntity> 特記事項情報 = mapper.getNinteiTokkijiko(myBatisParameter);
    }
}
