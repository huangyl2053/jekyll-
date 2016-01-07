/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.batchcontroller.step.koikinaijushochitokurei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei.KoikinaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbu.definition.koikinaijushochitokurei.KoikinaiJushochiTokureiEnum;
import jp.co.ndensan.reams.db.dbu.definition.processprm.koikinaijushochitokurei.KoikinaiJushochiTokureiProcessParamter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei.KoikinaiJushochiTokureiRelateEntity;
import jp.co.ndensan.reams.db.dbu.persistence.mapper.relate.koikinaijushochitokurei.IKoikinaiJushochiTokureiMapper;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 広域内住所地特例者情報の設定クラスです。
 */
public class KoikinaiJushochiTokureiProcess extends SimpleBatchProcessBase{
    
    private static final RString 直近 = new RString("1");
    private static final RString 基準日 = new RString("2");
    private static final RString 範囲 = new RString("3");
    private static final ReportId REPORT_ID = new ReportId(KoikinaiJushochiTokureiEnum.ReportId.getコード());
    private KoikinaiJushochiTokureiProcessParamter paramter;

    @Override
    protected void process() {
        get広域内住所地特例者情報();
        
    }
    
    private void get広域内住所地特例者情報() {
        if (直近.equals(paramter.getModel())) {
            
        } else if (基準日.equals(paramter.getModel())) {
            get基準日広住特適用();
        } else if (範囲.equals(paramter.getModel())) {
            get範囲広住特適用();
        }
    }
    
    private List<KoikinaiJushochiTokureiEntity> get直近広住特適用() {
        List<KoikinaiJushochiTokureiEntity> 広域内住所地特例者List = new ArrayList<>();
        List<KoikinaiJushochiTokureiRelateEntity> 直近広住特適用情報List = getMapper(IKoikinaiJushochiTokureiMapper.class).
                get直近広住特適用情報(paramter.toMybatisParamter());
        for (KoikinaiJushochiTokureiRelateEntity entity : 直近広住特適用情報List) {
            KoikinaiJushochiTokureiEntity 広域内住所地特例者Entity = new KoikinaiJushochiTokureiEntity();
            広域内住所地特例者Entity.set被保険者番号(entity.getHihokenshaNo().getColumnValue());
            広域内住所地特例者Entity.set氏名カナ(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get名称().getKana().getColumnValue());
            広域内住所地特例者Entity.set生年月日(new RString(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get生年月日().toString()));
            広域内住所地特例者Entity.set住所コード(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get住所().get全国住所コード().getColumnValue());
            広域内住所地特例者Entity.set行政区CD(ShikibetsuTaishoFactory
                    .createKojin(entity.getFt200Entity()).get行政区画().getGyoseiku().getコード().getColumnValue());
            
            
        }
        return 広域内住所地特例者List;
    }
    
    private List<KoikinaiJushochiTokureiRelateEntity> get基準日広住特適用() {
        return getMapper(IKoikinaiJushochiTokureiMapper.class).
                get基準日広住特適用情報(paramter.toMybatisParamter());
    }
    
    private List<KoikinaiJushochiTokureiRelateEntity> get範囲広住特適用() {
        return getMapper(IKoikinaiJushochiTokureiMapper.class).
                get範囲広住特適用情報(paramter.toMybatisParamter());
    }

}
