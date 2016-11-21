/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB012003;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TblDataShutokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.FukaJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
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
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 「賦課情報取得」処理の「仮算定額変更情報一時作成」です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class FukaJohoShutokuProcess extends BatchProcessBase<KarisanteiGakuHenkoEntity> {

    FukaJohoShutokuProcessParameter parameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 仮算定額変更情報一時tableWriter;

    private static final RString 仮算定額変更情報一時_TABLE_NAME = new RString("DbT2002FukaTemp");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select特徴平準化_6月分更新後とリアルのデータ");
    private static final RString LEFT_FORMAT = new RString("'{");
    private static final RString RIGHT_FORMAT = new RString("}'");
    private static final RString MIDDLE_FORMAT = new RString(",");

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
        builder.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振替口座.getCode()));
        IKozaSearchKey key = builder.build();
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(ControlDataHolder.getUserId());
        RStringBuilder rStringBuilder = new RStringBuilder();
        rStringBuilder.append(LEFT_FORMAT);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                rStringBuilder.append(list.get(i) == null ? RString.EMPTY : list.get(i).getColumnValue());
                if (i != list.size() - 1) {
                    rStringBuilder.append(MIDDLE_FORMAT);
                }
            }
        }
        rStringBuilder.append(RIGHT_FORMAT);
        RString 科目コード = rStringBuilder.toRString();
        RString 処理日 = new RString(FlexibleDate.getNowDate().toString());
        return new BatchDbReader(MAPPERPATH, new TblDataShutokuMyBatisParameter(parameter.get調定年度(),
                通知内容コード, 更正前後区分, 作成処理名, 科目コード, 処理日, key, list));
    }

    @Override
    protected void process(KarisanteiGakuHenkoEntity entity) {
        仮算定額変更情報一時tableWriter.insert(entity.toDbT2002FukaTempTableEntity());
    }

}
