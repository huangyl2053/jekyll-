/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「賦課情報取得」処理の「仮算定額変更情報一時作成」です。（一括発行の場合）
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class FukaJohoShutokuIkatsuHakoProcess extends BatchProcessBase<KarisanteiGakuHenkoEntity> {

    FukaJohoShutokuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 仮算定額変更情報一時tableWriter;

    private static final RString 仮算定額変更情報一時_TABLE_NAME = new RString("DbT2002FukaTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper."
            + "select特徴平準化_6月分更新後とリアルのデータ_一括発行起動");

    @Override
    protected void createWriter() {
        仮算定額変更情報一時tableWriter = new BatchEntityCreatedTempTableWriter(仮算定額変更情報一時_TABLE_NAME, DbT2002FukaTempTableEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        List<RString> 通知内容コード = new ArrayList<>();
        通知内容コード.add(TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード());
        通知内容コード.add(TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード());
        RString 更正前後区分 = new RString("2");
        RString 作成処理名 = ShoriName.特徴平準化計算_6月分.get名称();

        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        IKozaSearchKey key = builder.build();
        return new BatchDbReader(MAPPERPATH, new TokuchoHeijunka6gatsuMyBatisParameter(
                parameter.is一括発行フラグ(), parameter.get調定年度(), 通知内容コード, 更正前後区分, 作成処理名, null, null, null, null, key));
    }

    @Override
    protected void process(KarisanteiGakuHenkoEntity entity) {
        仮算定額変更情報一時tableWriter.insert(entity.toDbT2002FukaTempTableEntity());

        TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        IKozaSearchKey key = builder.build();
        service.update計算後情報更正前(new TokuchoHeijunka6gatsuMyBatisParameter(
                parameter.is一括発行フラグ(), null, null, null, ShoriName.特徴平準化計算_6月分.get名称(), null, null, null, null, key));
    }

}
