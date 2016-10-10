/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kijunsyunyunenji.InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kijunsyunyunenji.InsTaishoSeitaiyinTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp1Entity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象世帯員クラスTempに更新1のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
public class UpdTaishoSeitaiyinTemp1Process extends BatchProcessBase<UpdTaishoSeitaiyinTemp1Entity> {

    private InsTaishoSeitaiyinTempProcessParameter parameter;
    private InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter mybatisParameter;

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_10 = new RString("10");
    private static final RString RSTRING_20 = new RString("20");
    private static final RString RSTRING_64 = new RString("64");
    private static final RString RSTRING_65 = new RString("65");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに更新1");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @Override
    protected void initialize() {
        super.initialize();
        this.mybatisParameter = new InsSetaiyinShotokuJyohoTemp1ProcessMybatisParameter();
        this.mybatisParameter.set世帯員把握基準日(this.parameter.get世帯員把握基準日());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, mybatisParameter);

    }

    @Override
    protected void createWriter() {
        this.taiShoTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TaishoSetaiinEntity.class);

    }

    @Override
    protected void process(UpdTaishoSeitaiyinTemp1Entity entity) {
        TaishoSetaiinEntity 対象世帯員 = entity.get対象世帯員();
        DbV1001HihokenshaDaichoEntity 被保険者台帳管理 = entity.get被保険者台帳管理Newest();
        if (null != 被保険者台帳管理) {
            if ((RSTRING_10.equals(対象世帯員.getAtenaDateDhubetsu_kijunDay())
                    || RSTRING_20.equals(対象世帯員.getAtenaDateDhubetsu_kijunDay())) && RSTRING_1.equals(被保険者台帳管理.getJushochiTokureiFlag())) {
                対象世帯員.setJukyuKubun(RSTRING_3);
                対象世帯員.setShichosonCode(被保険者台帳管理.getShichosonCode().getColumnValue());
                対象世帯員.setJushochiTokureiFlag(被保険者台帳管理.getJushochiTokureiFlag());
            }
            if (対象世帯員.getAge() != null && RSTRING_65.compareTo(対象世帯員.getAge()) <= 0) {
                対象世帯員.setHihokennshaKubun(RSTRING_1);
                対象世帯員.setJukyuKubun(RSTRING_3);
            } else if (対象世帯員.getAge() != null && RSTRING_64.compareTo(対象世帯員.getAge()) >= 0) {
                対象世帯員.setHihokennshaKubun(RSTRING_2);
                対象世帯員.setJukyuKubun(RSTRING_3);
            } else {
                対象世帯員.setHihokennshaKubun(RString.EMPTY);
            }

        } else {
            if (対象世帯員.getAge() != null && RSTRING_65.compareTo(対象世帯員.getAge()) <= 0) {
                対象世帯員.setHihokennshaKubun(RSTRING_3);
                対象世帯員.setJukyuKubun(RSTRING_3);
            } else {
                対象世帯員.setHihokennshaKubun(RString.EMPTY);
            }
        }

        this.taiShoTableWriter.update(対象世帯員);
    }

}
