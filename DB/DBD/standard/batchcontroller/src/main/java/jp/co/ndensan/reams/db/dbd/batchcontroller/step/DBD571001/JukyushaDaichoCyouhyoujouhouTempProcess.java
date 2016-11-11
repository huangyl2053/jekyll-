/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd571001.JukyushaDaichoCyouhyoujouhou;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd571001.IdoChushutsuDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.IdoChushutsuDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.SenTouEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.temptable.JukyushaDaichoCyouhyoujouhouTempTableEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho.IJukyushaDaichoMainMapper;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBD571001_受給者台帳のtmpTableのprocess処理クラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class JukyushaDaichoCyouhyoujouhouTempProcess extends BatchProcessBase<SenTouEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushadaicho."
            + "IJukyushaDaichoMainMapper.get個人情報と要介護認定情報new");
    private IdoChushutsuDaichoProcessParameter processParamter;
    private IJukyushaDaichoMainMapper mapper;
    private List<HihokenshaNo> 被保険者番号リスト;
    private List<ShikibetsuCode> 識別コードリスト;
    private ShikibetsuCode 識別コードKEY;
    private HihokenshaNo 被保険者番号KEY;
    private DonyuKeitaiCode 導入形態コード;
    private boolean is広域;
    private boolean is単一;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    /**
     * OutputParameter用キー outTemptable
     */
    public static final RString OUT_TEMP_TABLE_1;

    static {
        OUT_TEMP_TABLE_1 = new RString("outTempTable");
    }
    private OutputParameter<RString> outTempTable;
    private RString outtemptable;

    @Override
    protected void initialize() {
        mapper = getMapper(IJukyushaDaichoMainMapper.class);
        被保険者番号リスト = new ArrayList();
        識別コードリスト = new ArrayList();
        被保険者番号KEY = HihokenshaNo.EMPTY;
        識別コードKEY = ShikibetsuCode.EMPTY;
        outTempTable = new OutputParameter<>();
        outtemptable = new RString("0");
        ShichosonSecurityJohoFinder finder = ShichosonSecurityJohoFinder.createInstance();
        ShichosonSecurityJoho 市町村セキュリティ情報 = finder.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード();
            if (導入形態コード.equals(DonyuKeitaiCode.事務広域)
                    || 導入形態コード.equals(DonyuKeitaiCode.事務構成市町村)) {
                is広域 = true;
            }
            if (導入形態コード.equals(DonyuKeitaiCode.事務単一)) {
                is単一 = true;
            }
        }
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        List<IdoChushutsuDaichoEntity> entityList = mapper.get新たな抽出対象リスト();
        if (!entityList.isEmpty()) {
            for (IdoChushutsuDaichoEntity entity : entityList) {
                if (entity != null) {
                    被保険者番号と識別コード設値(entity);
                }
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toIdoChushutsuDaichoNewMybatisParameter(被保険者番号リスト, 識別コードリスト, is広域, is単一));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(JukyushaDaichoCyouhyoujouhouTempTableEntity.class)
                .tempTableName(JukyushaDaichoCyouhyoujouhouTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(SenTouEntity t) {
        JukyushaDaichoCyouhyoujouhouTempTableEntity tempTableEntity = create検索条件一時テーブル情報(t);
        tmpTableWriter.insert(tempTableEntity);
        outtemptable = new RString("1");
    }

    @Override
    protected void afterExecute() {
        outTempTable.setValue(outtemptable);
    }

    private JukyushaDaichoCyouhyoujouhouTempTableEntity create検索条件一時テーブル情報(SenTouEntity t) {
        JukyushaDaichoCyouhyoujouhouTempTableEntity resultEntity = new JukyushaDaichoCyouhyoujouhouTempTableEntity();
        JukyushaDaichoCyouhyoujouhou 帳票出力用受給者台帳 = new JukyushaDaichoCyouhyoujouhou();
        帳票出力用受給者台帳.create検索条件一時テーブル情報(t, resultEntity);
        return resultEntity;

    }

    private void 被保険者番号と識別コード設値(IdoChushutsuDaichoEntity entity) {
        if (!被保険者番号KEY.equals(entity.get被保険者番号())) {
            被保険者番号KEY = entity.get被保険者番号();
            if (entity.get被保険者番号() == null) {
                被保険者番号リスト.add(HihokenshaNo.EMPTY);
            } else {
                被保険者番号リスト.add(entity.get被保険者番号());
            }
        }
        if (!識別コードKEY.equals(entity.get識別コード())) {
            識別コードKEY = entity.get識別コード();
            if (entity.get識別コード() == null) {
                識別コードリスト.add(ShikibetsuCode.EMPTY);
            } else {
                識別コードリスト.add(entity.get識別コード());
            }
        }
    }
}
