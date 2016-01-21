/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.youkaigoninteikekktesuchi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChi;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.youkaigoninteikekktesuchi.IYouKaiGoNinTeiKekTesuChiMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果通知情報を管理するクラスです。
 */
public class YouKaiGoNinTeiKekTesuChiFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public YouKaiGoNinTeiKekTesuChiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YouKaiGoNinTeiKekTesuChiFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YouKaiGoNinTeiKekTesuChiFinder}のインスタンス
     */
    public static YouKaiGoNinTeiKekTesuChiFinder createInstance() {
        return InstanceProvider.create(YouKaiGoNinTeiKekTesuChiFinder.class);
    }

    /**
     * 主治医選択一覧情報を取得します。
     *
     * @param param 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiKaisaiBashoJohoの{@code list}
     */
    @Transaction
    public SearchResult<YouKaiGoNinTeiKekTesuChi> get主治医選択一覧(YouKaiGoNinTeiKekTesuChiMapperParameter param) {
        List<YouKaiGoNinTeiKekTesuChi> businessList = new ArrayList<>();
        IYouKaiGoNinTeiKekTesuChiMapper YouKaiMapper = mapperProvider.create(IYouKaiGoNinTeiKekTesuChiMapper.class);
        List<YouKaiGoNinTeiKekTesuChiRelateEntity> youKaiEntityList = YouKaiMapper.getSyuJiSenTakuYiChiRan(param);

        for (YouKaiGoNinTeiKekTesuChiRelateEntity entity : youKaiEntityList) {
            businessList.add(new YouKaiGoNinTeiKekTesuChi(entity));
        }
        return SearchResult.of(businessList, businessList.size(), true);
    }

    /**
     * 結果通知出力対象申請者一覧情報を取得します。
     *
     * @param param 要介護認定結果情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiKaisaiBashoJohoの{@code list}
     */
    @Transaction
    public SearchResult<YouKaiGoNinTeiKekTesuChi> get結果通知出力対象申請者一覧(YouKaiGoNinTeiKekTesuChiMapperParameter param) {
        List<YouKaiGoNinTeiKekTesuChi> businessList = new ArrayList<>();
        IYouKaiGoNinTeiKekTesuChiMapper YouKaiMapper
                = mapperProvider.create(IYouKaiGoNinTeiKekTesuChiMapper.class);
        List<YouKaiGoNinTeiKekTesuChiRelateEntity> youKaiEntityList = YouKaiMapper.getKeKaTsuChiSyuTsuRyoKuTaiSyou(param);
        int 連番 = 1;
        for (YouKaiGoNinTeiKekTesuChiRelateEntity entity : youKaiEntityList) {
            entity.setRenNo(連番);
            businessList.add(new YouKaiGoNinTeiKekTesuChi(entity));
            連番 = 連番 + 1;
        }
        return SearchResult.of(businessList, businessList.size(), true);
    }

}
