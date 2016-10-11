/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001;

import jp.co.ndensan.reams.db.dbz.definition.core.honninkubun.HonninKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojins;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.setai.ISetai;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.setai.ISetaiFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員（住民）の把握_被保険者番号のデータ抽出クラスです。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class InsSetaiinHaakuTmp3Process extends BatchProcessBase<SetaiHakuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka."
            + "ISetaiShotokuKazeiHanteiMapper.get世帯員把握入力Temp");
    private static final RString TABLE_NAME = new RString("TmpSetaiShotoku");
    private ISetaiFinder finder;

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void beforeExecute() {
        finder = ShikibetsuTaishoService.getSetaiFinder();
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, SetaiShotokuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void process(SetaiHakuEntity entity) {
        ISetai isetai = null;
        if (entity.getShikibetsuCode() != null && entity.getKijunYMD() != null) {
            isetai = finder.findBy識別コード(GyomuCode.DB介護保険,
                    entity.getShikibetsuCode(),
                    entity.getKijunYMD());
        }
        if (isetai != null) {
            IKojins 世帯員リスト = isetai.get世帯員リスト();
            for (IKojin iKojin : 世帯員リスト) {
                SetaiShotokuEntity 世帯員所得情報Entity = new SetaiShotokuEntity();
                世帯員所得情報Entity.setHihokenshaNo(entity.getHihokenshaNo());
                世帯員所得情報Entity.setShikibetsuCode(iKojin.get識別コード());
                世帯員所得情報Entity.setKijunYMD(entity.getKijunYMD());
                世帯員所得情報Entity.setShotokuNendo(entity.getShotokuNendo());
                世帯員所得情報Entity.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
                世帯員所得情報Entity.setSetaiCode(iKojin.get世帯コード());
                if (entity.getShikibetsuCode() != null) {
                    RString 本人区分 = entity.getShikibetsuCode().equals(iKojin.get識別コード())
                            ? HonninKubun.本人.getCode() : HonninKubun.世帯構成員.getCode();
                    世帯員所得情報Entity.setHonninKubun(本人区分);
                } else {
                    世帯員所得情報Entity.setHonninKubun(HonninKubun.世帯構成員.getCode());
                }
                tableWriter.insert(世帯員所得情報Entity);
            }
        }
    }
}
