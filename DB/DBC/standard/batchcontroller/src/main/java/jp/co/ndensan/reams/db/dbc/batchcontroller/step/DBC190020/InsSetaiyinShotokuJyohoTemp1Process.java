/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.definition.core.kijunshunyugaku.ShinseishoHakkoChushutsuJoken;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsSetaiyinShotokuJyohoTemp1ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.HihokenshaDaichoTempSixColumnEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用申請書_年次分作成の世帯員所得情報一時テーブルに登録1 クラスです
 *
 * @reamsid_L DBC-4630-030 jiangwenkai
 */
public class InsSetaiyinShotokuJyohoTemp1Process extends BatchProcessBase<HihokenshaDaichoTempSixColumnEntity> {

    private InsSetaiyinShotokuJyohoTemp1ProcessParameter parameter;
    private InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter para;
    private static final RString 世帯員把握入力テーブル = new RString("TmpSetaiHaaku");
    private static final RString READ_DATA_ID0 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.select処理年度の対象者");
    private static final RString READ_DATA_ID1 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.select被保険者番号指定の対象者");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter writer;

    @Override
    protected void initialize() {
        this.para = new InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter();
        this.para.set世帯員把握基準日(this.parameter.get世帯員把握基準日());
        if (RString.isNullOrEmpty(this.parameter.get被保険者番号().getColumnValue())) {
            this.para.set被保険者番号(null);
        } else {
            this.para.set被保険者番号(this.parameter.get被保険者番号());
        }

    }

    @Override
    protected IBatchReader createReader() {
        if (ShinseishoHakkoChushutsuJoken.処理年度.getコード().equals(this.parameter.get抽出条件())) {
            return new BatchDbReader(READ_DATA_ID0, para);
        } else {
            return new BatchDbReader(READ_DATA_ID1, para);
        }
    }

    @Override
    protected void createWriter() {
        writer = new BatchEntityCreatedTempTableWriter(世帯員把握入力テーブル, SetaiHakuEntity.class);
    }

    @Override
    protected void process(HihokenshaDaichoTempSixColumnEntity entity) {
        if (!ShinseishoHakkoChushutsuJoken.白紙印刷.getコード().equals(this.parameter.get抽出条件())) {
            SetaiHakuEntity hakuEntity = new SetaiHakuEntity();
            hakuEntity.setHihokenshaNo(entity.getHihokenshaNo());
            hakuEntity.setShikibetsuCode(entity.getShikibetsuCode());
            hakuEntity.setKijunYMD(parameter.get世帯員把握基準日());
            hakuEntity.setShotokuNendo(parameter.get世帯員把握基準日().getNendo());
            hakuEntity.setJushochiTokureiFlag(entity.getJushochiTokureiFlag());
            writer.insert(hakuEntity);

        }
    }

}
