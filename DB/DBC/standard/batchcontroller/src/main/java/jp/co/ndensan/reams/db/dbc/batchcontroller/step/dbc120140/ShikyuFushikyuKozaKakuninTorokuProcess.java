/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120140;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuKozaMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc120140.ShikyuFushikyuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuKetteiKozaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shikyufushikyu.IShikyuFushikyuInMapper;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連から渡された口座情報（高額合算支給不支給決定一時TBLの口座情報）が口座マスタに登録されているか確認する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuKozaKakuninTorokuProcess extends BatchProcessBase<ShikyuFushikyuKetteiKozaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get口座登録");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給不支給決定一時tableWriter;
    private static final RString 高額合算支給不支給決定一時_TABLE_NAME
            = new RString("DbWT38B1KogakuGassanShikyuFushikyuKettei");

    private ShikyuFushikyuKozaMyBatisParameter kozaParameter;

    @Override
    protected void initialize() {
        IShikyuFushikyuInMapper mapper = getMapper(IShikyuFushikyuInMapper.class);
        ShunoKamokuFinder 収納科目Finder = ShunoKamokuFinder.createInstance();
        IShunoKamoku 介護給付_高額合算 = 収納科目Finder.get科目(ShunoKamokuShubetsu.介護給付_高額合算);
        ShikyuFushikyuMyBatisParameter mybatisParameter = new ShikyuFushikyuMyBatisParameter();
        mybatisParameter.set科目コード(介護給付_高額合算.getコード());
        RString 主キー = mapper.get業務別主キー(mybatisParameter);
        IKozaSearchKey searchKey = new KozaSearchKeyBuilder()
                .set業務コード(GyomuCode.DB介護保険)
                .setサブ業務コード(SubGyomuCode.DBC介護給付)
                .set科目コード(介護給付_高額合算.getコード())
                .set業務別主キー(主キー)
                .set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()))
                .set基準日(FlexibleDate.getNowDate()).build();
        List<KamokuCode> kamokuList = new ArrayList<>();
        kamokuList.add(介護給付_高額合算.getコード());
        kozaParameter
                = new ShikyuFushikyuKozaMyBatisParameter(searchKey, kamokuList);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, kozaParameter);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給不支給決定一時_TABLE_NAME,
                        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(ShikyuFushikyuKetteiKozaEntity entity) {
        DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 支給不支給決定 = entity.get支給不支給決定();
        TokuteiKozaRelateEntity 口座 = entity.get口座();
        if (null != 口座) {
            支給不支給決定.set口座ID(口座.getUaT0310KozaEntity().getKozaId());
            高額合算支給不支給決定一時tableWriter.update(支給不支給決定.toEntity());
        }
    }
}
