/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteishinchokujohoshokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai.YokaigoNinteiParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.CursorMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.HihokenshaJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai.HihokenshaJohoParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.HihokenshaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteishinchokujohoshokai.IYokaigoNinteiShinchokuJohoShokaiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 要介護認定進捗状況照会を管理するクラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
public class YokaigoNinteiShinchokuJohoShokaiFinder {

    /**
     * コンストラクタです。
     */
    YokaigoNinteiShinchokuJohoShokaiFinder() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiShinchokuJohoShokaiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiShinchokuJohoShokaiFinder}のインスタンス
     */
    public static YokaigoNinteiShinchokuJohoShokaiFinder createInstance() {
        return InstanceProvider.create(YokaigoNinteiShinchokuJohoShokaiFinder.class);
    }

    /**
     * 申請者一覧内容検索します。
     *
     * @param parameter 申請者一覧内容検索のパラメータ
     * @return SearchResult<YokaigoNinteiShinchokuJoho>
     */
    public SearchResult<YokaigoNinteiShinchokuJoho> selectItirannJoho(final YokaigoNinteiParamter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        List<YokaigoNinteiShinchokuJoho> yokaigoNinteiShinchokuJohoList = new ArrayList<>();

        final List<YokaigoNinteiShinchokuJohoShokaiRelateEntity> entityList = new ArrayList<>();
        InstanceProvider.create(CursorMapperProvider.class).select(new RString("get申請者一覧内容"), parameter, new ResultHandler() {
            @Override
            public void handleResult(ResultContext rc) {
                if (rc.getResultCount() > parameter.getMaximumDisplayNumber()) {
                    rc.stop();
                    return;
                }

                entityList.add((YokaigoNinteiShinchokuJohoShokaiRelateEntity) rc.getResultObject());
            }
        });

        for (YokaigoNinteiShinchokuJohoShokaiRelateEntity entity : entityList) {
            yokaigoNinteiShinchokuJohoList.add(new YokaigoNinteiShinchokuJoho(entity));
        }
        int totalCount;
        if (entityList.isEmpty()) {
            totalCount = 0;
        } else {
            totalCount = entityList.get(0).getTotalCount();
        }
        boolean exceedsLimit = parameter.getMaximumDisplayNumber() < totalCount;
        return SearchResult.of(yokaigoNinteiShinchokuJohoList, totalCount, exceedsLimit);
    }

    /**
     * 被保険者情報を取得します。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @param hihokenshaNo 被保険者番号
     * @return 被保険者情報
     */
    @Transaction
    public HihokenshaJohoBusiness select被保険者情報(RString shoKisaiHokenshaNo, RString hihokenshaNo) {
        MapperProvider mapperProvider = InstanceProvider.create(MapperProvider.class);
        IYokaigoNinteiShinchokuJohoShokaiMapper mapper = mapperProvider.create(IYokaigoNinteiShinchokuJohoShokaiMapper.class);
        HihokenshaJohoRelateEntity entityList
                = mapper.get被保険者情報(HihokenshaJohoParamter.createParameter(shoKisaiHokenshaNo, hihokenshaNo));
        if (entityList == null) {
            return null;
        }
        return new HihokenshaJohoBusiness(entityList);
    }
}
