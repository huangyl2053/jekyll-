/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteishinchokujohoshokai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai.YokaigoNinteiParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteishinchokujohoshokai.YokaigoNinteiShinchokuJohoShokaiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteishinchokujohoshokai.IYokaigoNinteiShinchokuJohoShokaiMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 要介護認定進捗状況照会を管理するクラスです。
 *
 * @reamsid_L DBE-0210-010 dongyabin
 */
public class YokaigoNinteiShinchokuJohoShokaiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    YokaigoNinteiShinchokuJohoShokaiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    YokaigoNinteiShinchokuJohoShokaiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
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
     * @param paramter 申請者一覧内容検索のパラメータ
     * @return SearchResult<YokaigoNinteiShinchokuJoho>
     */
    public SearchResult<YokaigoNinteiShinchokuJoho> selectItirannJoho(YokaigoNinteiParamter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("parameter"));
        List<YokaigoNinteiShinchokuJoho> yokaigoNinteiShinchokuJohoList = new ArrayList<>();
        IYokaigoNinteiShinchokuJohoShokaiMapper mapper = mapperProvider.create(IYokaigoNinteiShinchokuJohoShokaiMapper.class);
        List<YokaigoNinteiShinchokuJohoShokaiRelateEntity> entityList = mapper.get申請者一覧内容(parameter);
        for (YokaigoNinteiShinchokuJohoShokaiRelateEntity entity : entityList) {
            yokaigoNinteiShinchokuJohoList.add(new YokaigoNinteiShinchokuJoho(entity));
        }
        int totalCount = mapper.count申請者(parameter);
        boolean exceedsLimit = parameter.isMaximumDisplayNumberFlag() && parameter.getMaximumDisplayNumber() < totalCount;
        return SearchResult.of(yokaigoNinteiShinchokuJohoList, mapper.count申請者(parameter), exceedsLimit);
    }
}
