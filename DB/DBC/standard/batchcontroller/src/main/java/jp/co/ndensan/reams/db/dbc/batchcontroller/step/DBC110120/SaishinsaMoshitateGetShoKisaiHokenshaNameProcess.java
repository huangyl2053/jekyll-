/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110120;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.DbWT1741SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout.SaishinsaMoshitateMeisyoKanrenEntity;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護給付費再審査申立書情報作成・証記載保険者名取得を実行する。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
public class SaishinsaMoshitateGetShoKisaiHokenshaNameProcess extends BatchProcessBase<SaishinsaMoshitateMeisyoKanrenEntity> {

    private static final RString READ_DATA_ID_1 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select旧市町村名称関連リスト");
    private static final RString READ_DATA_ID_2 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsamoshitateshoout.ISaishinsaMoshitateshoOutJohoMapper.select市町村名称関連リスト");
    private RString 検索データ_ID;
    private static final RString MSG_導入形態コード = new RString("導入形態コード");
    @BatchWriter
    private IBatchTableWriter 再審査申立一時tableWriter;
    private static final RString 再審査申立一時_TABLE_NAME = new RString("DbWT1741SaishinsaMoshitate");

    @Override
    protected void initialize() {

        ShichosonSecurityJohoFinder 市町村finder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho joho = 市町村finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (null == joho || KaigoDonyuKubun.未導入.code().equals(joho.get介護導入区分().code())) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(MSG_導入形態コード.toString()).toString());
        }
        DonyuKeitaiCode 導入形態コード = joho.get導入形態コード();
        if (導入形態コード.is単一()) {
            検索データ_ID = READ_DATA_ID_1;
        } else if (導入形態コード.is広域()) {
            検索データ_ID = READ_DATA_ID_2;
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(検索データ_ID);
    }

    @Override
    protected void createWriter() {
        再審査申立一時tableWriter
                = new BatchEntityCreatedTempTableWriter(再審査申立一時_TABLE_NAME, DbWT1741SaishinsaMoshitateEntity.class);
    }

    @Override
    protected void process(SaishinsaMoshitateMeisyoKanrenEntity entity) {
        DbWT1741SaishinsaMoshitateEntity 再審査申立 = entity.get再審査申立();
        DbT7056GappeiShichosonEntity 合併市町村 = entity.get合併市町村();
        DbT7051KoseiShichosonMasterEntity 構成市町村マスタ = entity.get構成市町村マスタ();
        if (null != 合併市町村) {
            再審査申立.setShokisaiHokenshaName(合併市町村.getKyuShichosonMeisho());
            再審査申立.setState(EntityDataState.Modified);
            再審査申立一時tableWriter.update(再審査申立);
        }
        if (null != 構成市町村マスタ) {
            再審査申立.setShokisaiHokenshaName(構成市町村マスタ.getShichosonMeisho());
            再審査申立.setState(EntityDataState.Modified);
            再審査申立一時tableWriter.update(再審査申立);
        }
    }

}
