/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc020070.KozaJohoForMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuUpdateTempRelateEntity;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 口座情報を経由して取得する、更新用一時の内容を更新する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class KozaJohoForShikyugakuUpdateTempProcess extends BatchProcessBase<ShikyugakuUpdateTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get口座情報");
    private static final RString ONE = new RString("1");
    private static final RString TABLE_NAME = new RString("ShikyugakuUpdateTemp");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected IBatchReader createReader() {
        IKozaSearchKey key = new KozaSearchKeyBuilder().set業務コード(GyomuCode.DB介護保険).
                setサブ業務コード(SubGyomuCode.DBC介護給付).
                set用途区分(new KozaYotoKubunCodeValue(new Code(ONE))).
                set基準日(FlexibleDate.getNowDate()).
                build();
        List<KamokuCode> kamokuList = new ShunoKamokuAuthority().
                get参照権限科目コード(UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        KozaJohoForMybatisParameter parameter = new KozaJohoForMybatisParameter(key, kamokuList);
        return new BatchDbReader(MYBATIS_ID, parameter);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuUpdateTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuUpdateTempRelateEntity entity) {
        IKoza ikoza = new Koza(entity.get口座());
        ShikyugakuUpdateTempEntity 更新用一時 = entity.get更新用一時();
        更新用一時.setKinyukikanMei(ikoza.get金融機関().get金融機関名称());
        更新用一時.setKinyukikanCode(ikoza.get金融機関().get金融機関コード());
        更新用一時.setKinyuKikanShitenCode(ikoza.get支店コード());
        更新用一時.setKinyuKikanShitenMei(ikoza.get支店().get支店名称());
        更新用一時.setKozaShumoku(ikoza.get預金種別().get預金種別コード());
        更新用一時.setKozaShumokuMei(ikoza.get預金種別名称());
        更新用一時.setKozaNo(ikoza.get口座番号());
        更新用一時.setKozaMeiginin(ikoza.get口座名義人());

        更新用一時.setState(EntityDataState.Modified);
        tempDbWriter.update(entity);
    }
}
