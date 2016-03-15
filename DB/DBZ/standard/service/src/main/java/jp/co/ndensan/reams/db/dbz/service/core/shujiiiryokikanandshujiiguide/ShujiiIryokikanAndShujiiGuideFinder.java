/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiguide;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujiiRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shujiiiryokikanandshujiiguide.IShujiiIryokikanAndShujiiGuideMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関＆主治医情報の取得処理です。
 */
public class ShujiiIryokikanAndShujiiGuideFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiIryokikanAndShujiiGuideFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    ShujiiIryokikanAndShujiiGuideFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiGuideFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiGuideFinder}のインスタンス
     */
    public static ShujiiIryokikanAndShujiiGuideFinder createInstance() {
        return InstanceProvider.create(ShujiiIryokikanAndShujiiGuideFinder.class);
    }

    /**
     * 入力された検索条件によって、主治医医療機関＆主治医情報を取得します。
     *
     * @param parameter 主治医医療機関＆主治医情報検索パラメーター
     * @return SearchResult<ShujiiIryokikanAndShujii>
     */
    @Transaction
    public SearchResult<ShujiiIryokikanAndShujii> search主治医医療機関_主治医情報(
            ShujiiIryokikanAndShujiiGuideParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("パラメーター"));
        IShujiiIryokikanAndShujiiGuideMapper mapper = mapperProvider.create(IShujiiIryokikanAndShujiiGuideMapper.class);
        List<ShujiiIryokikanAndShujiiRelateEntity> shinsakaiiinJohoList;
        if (parameter.isSubGyomuCodeFlag()) {
            shinsakaiiinJohoList = mapper.get子主治医医療機関_子主治医情報(parameter);
        } else {
            shinsakaiiinJohoList = mapper.get主治医医療機関_主治医情報(parameter);
        }
        List<ShujiiIryokikanAndShujii> businessList = new ArrayList();
        for (ShujiiIryokikanAndShujiiRelateEntity entity : shinsakaiiinJohoList) {
            businessList.add(new ShujiiIryokikanAndShujii(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }
}
