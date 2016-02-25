/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.shinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisaikekka.ShinsakaiKaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.shinsakaiKaisaiKekka.ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijohoshinsakai.IGogitaiJohoShinsaMapper;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護認定審査会開催予定登録1クラスです。
 */
public class MonthlyShinsakaiKaisaiYoteiJoho {

    private final MapperProvider mapperProvider;
    private static final RString 未開催 = new RString("1");
    private static final RString 審査会名称 = new RString("第○○審査会");

    /**
     * コンストラクタです。
     */
    MonthlyShinsakaiKaisaiYoteiJoho() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link MonthlyShinsakaiKaisaiYoteiJoho}のインスタンスを返します。
     *
     * @return MonthlyShinsakaiKaisaiYoteiJoho
     */
    public static MonthlyShinsakaiKaisaiYoteiJoho createInstance() {

        return InstanceProvider.create(MonthlyShinsakaiKaisaiYoteiJoho.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link mapperProvider}
     */
    MonthlyShinsakaiKaisaiYoteiJoho(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * 介護認定審査会開催予定情報の編集処理です。
     *
     * @param コピー日 コピー日
     * @param コピー開始日 コピー開始日
     * @param 開催予定情報 開催予定情報
     * @return SearchResult<ShinsakaiKaisaiYoteiJohoBusiness>
     */
    public SearchResult<ShinsakaiKaisaiYoteiJohoBusiness> copy審査会開催予定情報(RString コピー日, RString コピー開始日,
            List<ShinsakaiKaisaiYoteiJohoBusiness> 開催予定情報) {
        IGogitaiJohoShinsaMapper mapper = mapperProvider.create(IGogitaiJohoShinsaMapper.class);
        List<ShinsakaiKaisaiYoteiJohoEntity> entityList = mapper.get開催予定情報(コピー日);
        for (ShinsakaiKaisaiYoteiJohoEntity entity : entityList) {
            entity.set開催予定日(new FlexibleDate(コピー開始日));
            entity.set開催番号(RString.EMPTY);
            entity.set介護認定審査会進捗状況(未開催);
            entity.set審査会名称(審査会名称);
            開催予定情報.add(new ShinsakaiKaisaiYoteiJohoBusiness(entity));
        }
        return SearchResult.of(開催予定情報, 0, false);
    }
}
