/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.dbd5190001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.YokaigoNinteiGaibuDataOutputHistory;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190001.NinteiShinseiJohoParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5190001.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT7204YokaigoNinteiGaibuDataOutputHistoryDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.ninteishinseijoho.INinteiShinseiJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定外部データ出力履歴を取得する
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class RenkeiDataSakuseiShinseiJohoManager {

    private final DbT7204YokaigoNinteiGaibuDataOutputHistoryDac dac_7204;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public RenkeiDataSakuseiShinseiJohoManager() {
        this.dac_7204 = InstanceProvider.create(DbT7204YokaigoNinteiGaibuDataOutputHistoryDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    RenkeiDataSakuseiShinseiJohoManager(DbT7204YokaigoNinteiGaibuDataOutputHistoryDac dac_7204, MapperProvider mapperProvider) {
        this.dac_7204 = dac_7204;
        this.mapperProvider = mapperProvider;
    }

    /**
     * RenkeiDataSakuseiShinseiJohoManagerのインスタンス化
     *
     * @return RenkeiDataSakuseiShinseiJohoManager
     */
    public static RenkeiDataSakuseiShinseiJohoManager createInstance() {
        return InstanceProvider.create(RenkeiDataSakuseiShinseiJohoManager.class);
    }

    /**
     * 介護認定外部データ出力履歴取得の方法
     *
     * @param dataKubun Code
     * @return YokaigoNinteiGaibuDataOutputHistory
     */
    @Transaction
    public YokaigoNinteiGaibuDataOutputHistory get介護認定外部データ出力履歴(Code dataKubun) {
        DbT7204YokaigoNinteiGaibuDataOutputHistoryEntity entity = dac_7204.selectデータ出力履歴時間(dataKubun);
        if (entity != null) {
            return new YokaigoNinteiGaibuDataOutputHistory(entity);
        } else {
            return null;
        }
    }

    /**
     * 対象者一覧情報の検索
     *
     * @param shoKisaiHokenshaNo RString
     * @param konkaikaishiTimestamp RString
     * @param konkaisyuryoTimestamp RString
     * @param hihokenshaNo RString
     * @param saidaikensu RString
     * @return NinteiShinseiJohoChild
     */
    @Transaction
    public SearchResult<NinteiShinseiJohoBusiness> get対象者一覧情報の検索(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu) {
        List<NinteiShinseiJohoBusiness> ninteishinseijohoList = new ArrayList();
        NinteiShinseiJohoParameter parameter = NinteiShinseiJohoParameter
                .createSelectByKeyParam(shoKisaiHokenshaNo, konkaikaishiTimestamp,
                        konkaisyuryoTimestamp, hihokenshaNo, saidaikensu);
        INinteiShinseiJohoMapper mapper = mapperProvider.create(INinteiShinseiJohoMapper.class);
        if (parameter.getShoKisaiHokenshaNo() != null) {
            List<NinteiShinseiJohoEntity> entitys = mapper.get要介護認定申請情報(parameter);
            if (entitys == null || entitys.isEmpty()) {
                return SearchResult.of(Collections.<NinteiShinseiJohoBusiness>emptyList(), 0, false);
            }
            for (NinteiShinseiJohoEntity entity : entitys) {
                ninteishinseijohoList.add(new NinteiShinseiJohoBusiness(entity));
            }

        }
        return SearchResult.of(ninteishinseijohoList, 0, false);

    }
}
