/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt43002;

import java.util.HashSet;
import java.util.Set;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt43002.HonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko.TmpHonsanteiTsuchishoTableEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteitsuchishoikkatsuhakko.HonsanteiTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 全件賦課情報一時テーブルに登録するクラスです。
 *
 * @reamsid_L DBB-0780-050 xicongwang
 */
public class InsZenkenFukaInfoTmpProcess extends BatchProcessBase<HonsanteiTsuchishoTempEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "honsanteitsuchishoikkatsuhakko.IHonsanteiTsuchishoIkkatsuHakkoMapper.select計算後情報一時");

    private static final RString 本算定通知書一時テーブル = new RString("TmpHonsanteiTsuchisho");
    private Set<TsuchishoNo> 通知書番号set;
    private IHonsanteiTsuchishoIkkatsuHakkoMapper mapper;
    private HonsanteiTsuchishoIkkatsuHakkoSyori honsanteiSyori;
    private HonsanteiTsuchishoIkkatsuHakko manager;
    private HonsanteifukaProcessParameter processParameter;
    private HonsanteiTsuchishoIkkatsuHakkoParameter parameter;

    @BatchWriter
    BatchEntityCreatedTempTableWriter 本算定通知書一時テーブルtableWriter;

    @Override
    protected void initialize() {
        通知書番号set = new HashSet<>();
        manager = HonsanteiTsuchishoIkkatsuHakko.createInstance();
        honsanteiSyori = new HonsanteiTsuchishoIkkatsuHakkoSyori();
        parameter = manager.get本算定通知書パラメータ(processParameter.get調定年度(),
                processParameter.get賦課年度(), processParameter.get最新調定日時());
        mapper = getMapper(IHonsanteiTsuchishoIkkatsuHakkoMapper.class);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter);
    }

    @Override
    protected void createWriter() {
        本算定通知書一時テーブルtableWriter
                = new BatchEntityCreatedTempTableWriter(本算定通知書一時テーブル, TmpHonsanteiTsuchishoTableEntity.class);
    }

    @Override
    protected void beforeExecute() {
        mapper.clear本算定通知書一時();
    }

    @Override
    protected void process(HonsanteiTsuchishoTempEntity tempEntity) {
        if (!通知書番号set.contains(tempEntity.get計算後情報_更正後().getTsuchishoNo())) {
            通知書番号set.add(tempEntity.get計算後情報_更正後().getTsuchishoNo());
            本算定通知書一時テーブルtableWriter.insert(honsanteiSyori.to賦課情報(tempEntity));
        }
    }

    @Override
    protected void afterExecute() {

    }

}
