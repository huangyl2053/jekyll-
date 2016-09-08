/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassanjikofutangaku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.KogakuGassanJSaiSyoriJyunbi.IKogakuGassanJSaiSyoriJyunbiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.DbWT37H1KogakuGassanaJikofutangakuTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanjikofutangaku.IKogakuGassanJSaiSyoriJyunbiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算自己負担額証明書情報取込のmanagerです。<br>
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
public class KogakuGassanJSaiSyoriJyunbiManager {

    private final MapperProvider mapperProvider;
    private final IKogakuGassanJSaiSyoriJyunbiMapper mapper;

    /**
     *
     */
    public KogakuGassanJSaiSyoriJyunbiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(IKogakuGassanJSaiSyoriJyunbiMapper.class);
    }

    /**
     * 再処理準備
     *
     * @param データ作成区分 RString
     * @param 処理年月 FlexibleYearMonth
     */
    @Transaction
    public void do再処理準備(RString データ作成区分, FlexibleYearMonth 処理年月) {
        IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter
                = IKogakuGassanJSaiSyoriJyunbiMapperParameter.create再処理準備Param(
                        データ作成区分, 処理年月);
        mapper.do再処理準備(parameter);
    }

    /**
     * マスタ更新
     *
     * @param データ作成区分 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 RString
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    public List<DbT3070KogakuGassanJikoFutanGakuEntity> doBeforeマスタ更新(
            RString データ作成区分,
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            ShoKisaiHokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter
                = IKogakuGassanJSaiSyoriJyunbiMapperParameter.createBeforeマスタ更新Param(
                        データ作成区分, 被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        return mapper.doBeforeマスタ更新(parameter);
    }

    /**
     * マスタ更新
     *
     * @param 自己負担額証明書整理番号 RString
     * @param 処理年月 FlexibleYearMonth
     */
    public void doマスタ更新(RString 自己負担額証明書整理番号, FlexibleYearMonth 処理年月) {
        IKogakuGassanJSaiSyoriJyunbiMapperParameter parameter
                = IKogakuGassanJSaiSyoriJyunbiMapperParameter.createマスタ更新Param(自己負担額証明書整理番号, 処理年月);
        mapper.doマスタ更新(parameter);
    }

    /**
     * select連番
     *
     * @return DbWT37H1KogakuGassanaJikofutangakuTempEntity
     */
    public List<DbWT37H1KogakuGassanaJikofutangakuTempEntity> select連番() {
        return mapper.select連番();
    }
}
