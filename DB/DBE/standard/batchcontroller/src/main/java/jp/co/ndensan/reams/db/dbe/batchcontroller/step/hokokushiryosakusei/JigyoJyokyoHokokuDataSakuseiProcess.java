package jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei;

import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.JigyoJyokyoHokokuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei.JigyoJyokyoHokokuHeaderEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定事業状況報告の取得バッチクラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class JigyoJyokyoHokokuDataSakuseiProcess extends BatchProcessBase<JigyoJyokyoHokokuHeaderEntity> {

    private static final RString SELECT_HEADER = new RString("jp.co.ndensan.reams.db.dbe.persistence"
            + ".db.mapper.relate.hokokushiryosakusei.IHokokuShiryoSakuSeiMapper.getJigyoJyokyoHokokuHeader");
    private static final RString 第1号保険者者 = new RString("0");
    private static final RString 歳65以上75未満 = new RString("1");
    private static final RString 歳75以上 = new RString("2");
    private static final RString 第2号被保険者 = new RString("3");
    private static final int 年齢_65 = 65;
    private static final int 年齢_75 = 75;
    private JigyoJyokyoHokokuProcessParameter paramter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter jigyoJyokyoHokokuTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_HEADER, paramter.toJigyoJyokyoHokokuMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        jigyoJyokyoHokokuTemp = new BatchEntityCreatedTempTableWriter(JigyoJyokyoHokokuHeaderEntity.TABLE_NAME,
                JigyoJyokyoHokokuHeaderEntity.class);
    }

    @Override
    protected void process(JigyoJyokyoHokokuHeaderEntity item) {
        if (HihokenshaKubunCode.第１号被保険者.getコード().equals(item.getHihokenshaKubunCode())) {
            item.setHihokenshaKubunCode(第1号保険者者);
            jigyoJyokyoHokokuTemp.insert(item);
            if (年齢_65 <= item.getAge() && item.getAge() < 年齢_75) {
                item.setHihokenshaKubunCode(歳65以上75未満);
                jigyoJyokyoHokokuTemp.insert(item);
            } else if (年齢_75 <= item.getAge()) {
                item.setHihokenshaKubunCode(歳75以上);
                jigyoJyokyoHokokuTemp.insert(item);
            }
        } else if (HihokenshaKubunCode.第２号被保険者.getコード().equals(item.getHihokenshaKubunCode())) {
            item.setHihokenshaKubunCode(第2号被保険者);
            jigyoJyokyoHokokuTemp.insert(item);
        }
    }

}
