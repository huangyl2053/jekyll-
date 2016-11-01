/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015003;

import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho.IdofukaJohoTempParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt36002.KarisanteiIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.TmpHonsanteiTsuchishoTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.karisanteiidotsuchisho.IKarisanteiIdoFukaMapper;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidotsuchisho.KarisanteiIdoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「異動分賦課情報取得」処理クラスです。
 *
 * @reamsid_L DBB-0890-030 xicongwang
 */
public class InsIdoFukaTemp1Process extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "karisanteiidotsuchisho.IKarisanteiIdoFukaMapper.select計算後情報");

    private static final RString 異動賦課情報一時テーブル = new RString("TmpFukaInfo");
    private Set<TsuchishoNo> 通知書番号set;
    private IKarisanteiIdoFukaMapper mapper;
    private KarisanteiIdoTsuchishoHakkoSyori karisanteiSyori;
    private KarisanteiIdoTsuchishoIkkatsuHakko manager;
    private KarisanteiIdoFukaProcessParameter processParameter;
    private IdofukaJohoTempParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 異動賦課情報一時テーブルtableWriter;

    @Override
    protected void initialize() {
        通知書番号set = new HashSet<>();
        manager = KarisanteiIdoTsuchishoIkkatsuHakko.createInstance();
        karisanteiSyori = new KarisanteiIdoTsuchishoHakkoSyori();
        parameter = manager.get仮算定異動パラメータ(processParameter.get調定年度(),
                processParameter.get賦課年度(), processParameter.get最新調定日時());
        mapper = getMapper(IKarisanteiIdoFukaMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void createWriter() {
        異動賦課情報一時テーブルtableWriter
                = new BatchEntityCreatedTempTableWriter(異動賦課情報一時テーブル, TmpHonsanteiTsuchishoTableEntity.class);
    }

    @Override
    protected void beforeExecute() {
        mapper.clear賦課情報一時テーブル();
    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {
        if (!通知書番号set.contains(tempEntity.get計算後情報_更正後().getTsuchishoNo())) {
            通知書番号set.add(tempEntity.get計算後情報_更正後().getTsuchishoNo());
            異動賦課情報一時テーブルtableWriter.insert(karisanteiSyori.to賦課情報(tempEntity));
        }
    }

    @Override
    protected void afterExecute() {

    }
}
