package jp.co.ndensan.reams.db.dbc.service.core.futanwariai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.futanwariai.FutanWariaiSokujiKouseiResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariai.FutanWariaiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariai.FutanWariaiSokujiKouseiRelateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariai.IFutanWariaiMeisaiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3115RiyoshaFutanWariaiKonkyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 利用者負担割合即時更正_修正の情報を取得するクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class RiyoshaFutanWariaiSokujiKouseiFinder {

    private final MapperProvider mapperProvider;
    private final DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac;
    private final DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac;
    private final DbT3115RiyoshaFutanWariaiKonkyoDac 利用者負担割合根拠Dac;

    /**
     * コンストラクタです。
     */
    RiyoshaFutanWariaiSokujiKouseiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.利用者負担割合Dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
        this.利用者負担割合明細Dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
        this.利用者負担割合根拠Dac = InstanceProvider.create(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RiyoshaFutanWariaiSokujiKouseiFinder}のインスタンスを返します。
     *
     * @return RiyoshaFutanWariaiSokujiKouseiFinder
     */
    public static RiyoshaFutanWariaiSokujiKouseiFinder createInstance() {
        return InstanceProvider.create(RiyoshaFutanWariaiSokujiKouseiFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    RiyoshaFutanWariaiSokujiKouseiFinder(MapperProvider mapperProvider,
            DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac,
            DbT3114RiyoshaFutanWariaiMeisaiDac 利用者負担割合明細Dac,
            DbT3115RiyoshaFutanWariaiKonkyoDac 利用者負担割合根拠Dac) {
        this.mapperProvider = mapperProvider;
        this.利用者負担割合Dac = 利用者負担割合Dac;
        this.利用者負担割合明細Dac = 利用者負担割合明細Dac;
        this.利用者負担割合根拠Dac = 利用者負担割合根拠Dac;

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    RiyoshaFutanWariaiSokujiKouseiFinder(MapperProvider mapperProvider,
            DbT3113RiyoshaFutanWariaiDac 利用者負担割合Dac) {
        this.mapperProvider = mapperProvider;
        this.利用者負担割合Dac = 利用者負担割合Dac;
        this.利用者負担割合明細Dac = null;
        this.利用者負担割合根拠Dac = null;

    }

    /**
     * 利用者負担割合情報を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return FutanWariaiSokujiKouseiResult
     */
    public FutanWariaiSokujiKouseiResult get利用者負担割合情報(FutanWariaiMybatisParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合情報検索条件"));
        IFutanWariaiMeisaiMapper mapper = mapperProvider.create(IFutanWariaiMeisaiMapper.class);
        FutanWariaiSokujiKouseiRelateEntity 利用者負担割合情報 = mapper.select利用者負担割合情報(parameter);
        if (利用者負担割合情報 == null) {
            return null;
        }
        利用者負担割合情報.initializeMd5ToEntities();
        return new FutanWariaiSokujiKouseiResult(利用者負担割合情報);
    }

    /**
     * 利用者負担割合情報を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return List<FutanWariaiSokujiKouseiRelateEntity>
     */
    public List<RiyoshaFutanWariai> get利用者負担割合BY年度と被保険者番号(FutanWariaiMybatisParameter parameter) {
        IFutanWariaiMeisaiMapper mapper = mapperProvider.create(IFutanWariaiMeisaiMapper.class);
        List<DbT3113RiyoshaFutanWariaiEntity> 利用者負担割合情報list = mapper.select利用者負担割合BY年度と被保険者番号(parameter);
        List<RiyoshaFutanWariai> list = new ArrayList<>();
        if (利用者負担割合情報list != null && !利用者負担割合情報list.isEmpty()) {
            for (DbT3113RiyoshaFutanWariaiEntity entity : 利用者負担割合情報list) {
                list.add(new RiyoshaFutanWariai(entity));
            }
        }
        return list;
    }

    /**
     * 履歴番号を取得します。
     *
     * @param parameter FutanWariaiMybatisParameter
     * @return List<RString>
     */
    public List<RString> get履歴番号BY年度(FutanWariaiMybatisParameter parameter) {
        IFutanWariaiMeisaiMapper mapper = mapperProvider.create(IFutanWariaiMeisaiMapper.class);
        List<RString> 履歴番号list = mapper.select履歴番号BY年度(parameter);
        return 履歴番号list;
    }
}
