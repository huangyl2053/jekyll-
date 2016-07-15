/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosajissekishokai;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.chosahyojissekiichiran.ChosahyoJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyojissekiichiran.ChosahyoJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosahyojissekiichiran.IChosahyoJissekiIchiranMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 認定調査実績照会の画面処理クラスです。
 *
 * @reamsid_L DBE-1691-010 dangjingjing
 */
public class NinteiChosaJissekiShokaiFindler {

    private final MapperProvider mapperProvider;

    NinteiChosaJissekiShokaiFindler() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    NinteiChosaJissekiShokaiFindler(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaJissekiShokaiFindler}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosaJissekiShokaiFindler}のインスタンス
     */
    public static NinteiChosaJissekiShokaiFindler creatInstance() {
        return InstanceProvider.create(NinteiChosaJissekiShokaiFindler.class);
    }

    /**
     * 認定調査実績照会を取得します。
     *
     * @param param 検索用パラメータです。
     * @return SearchResult<NinteiChosaJissekiShokai>
     */
    public SearchResult<ChosahyoJissekiIchiran> get帳票出力用認定調査実績集計表(ChosahyoJissekiIchiranMybitisParamter param) {
        IChosahyoJissekiIchiranMapper mapper = mapperProvider.create(IChosahyoJissekiIchiranMapper.class);
        List<ChosahyoJissekiIchiranRelateEntity> relateEntity = mapper.get帳票出力用認定調査実績集計表(param);
        List<ChosahyoJissekiIchiran> list = new ArrayList<>();
        for (ChosahyoJissekiIchiranRelateEntity entity : relateEntity) {
            list.add(new ChosahyoJissekiIchiran(entity));
        }
        return SearchResult.of(list, 0, false);
    }

}
