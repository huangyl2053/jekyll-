/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.jogaishinsainjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinRelateJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.jogaishinsainjoho.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jogaishinsainjoho.IJogaiShinsainJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 除外審査員情報データの取得処理クラスです。
 *
 * @reamsid_L DBE-1300-040 dongyabin
 */
public class JogaiShinsainJohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタ。
     */
    public JogaiShinsainJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    public JogaiShinsainJohoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JogaiShinsainJohoFinder}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static JogaiShinsainJohoFinder createInstance() {
        return InstanceProvider.create(JogaiShinsainJohoFinder.class);
    }

    /**
     * 審査会委員一覧検索して審査会委員情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<ShinsakaiIinRelateJoho>
     */
    public SearchResult<ShinsakaiIinRelateJoho> get審査会委員一覧検索して審査会委員情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        IJogaiShinsainJohoMapper mapper = mapperProvider.create(IJogaiShinsainJohoMapper.class);
        List<ShinsakaiIinRelateJoho> shinsakaiIinRelateJohoList = new ArrayList<>();
        List<ShinsakaiIinJohoRelateEntity> shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(申請書管理番号);
        for (ShinsakaiIinJohoRelateEntity entity : shinsakaiIinJohoList) {
            shinsakaiIinRelateJohoList.add(new ShinsakaiIinRelateJoho(entity));
        }
        return SearchResult.of(shinsakaiIinRelateJohoList, 0, false);
    }

}
