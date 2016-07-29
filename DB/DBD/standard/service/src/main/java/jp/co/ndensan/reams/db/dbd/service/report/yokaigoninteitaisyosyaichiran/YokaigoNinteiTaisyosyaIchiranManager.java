/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.yokaigoninteitaisyosyaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteiinterface.YokaigoNinteiInterface;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiran;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiranEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4003YokaigoNinteiInterfaceDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteitaisyosyaichiran.IYokaigoNinteiTaisyosyaIchiranMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定処理対象者一覧画面のManagerです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
public class YokaigoNinteiTaisyosyaIchiranManager {

    private final MapperProvider mapperProvider;
    private final DbT4003YokaigoNinteiInterfaceDac 要介護認定インターフェース情報Dac;

    /**
     * コンストラクタです。
     */
    YokaigoNinteiTaisyosyaIchiranManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        要介護認定インターフェース情報Dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @@param mapperProvider MapperProvider
     */
    YokaigoNinteiTaisyosyaIchiranManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        要介護認定インターフェース情報Dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTaisyosyaIchiranManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTaisyosyaIchiranManager}のインスタンス
     */
    public static YokaigoNinteiTaisyosyaIchiranManager createInstance() {
        return InstanceProvider.create(YokaigoNinteiTaisyosyaIchiranManager.class);
    }

    /**
     * 広域タイプリストを取得する
     *
     * @return 広域タイプリスト
     */
    public List<YokaigoNinteiTaisyosyaIchiran> get広域タイプリスト() {
        List<YokaigoNinteiTaisyosyaIchiran> 広域タイプリスト = new ArrayList<>();
        IYokaigoNinteiTaisyosyaIchiranMapper mapper = mapperProvider.create(IYokaigoNinteiTaisyosyaIchiranMapper.class);
        List<YokaigoNinteiTaisyosyaIchiranEntity> entities = mapper.get広域タイプ();
        for (YokaigoNinteiTaisyosyaIchiranEntity entity : entities) {
            広域タイプリスト.add(new YokaigoNinteiTaisyosyaIchiran(entity));
        }
        return 広域タイプリスト;
    }

    /**
     * 単独タイプリストを取得する
     *
     * @return 単独タイプリスト
     */
    public List<YokaigoNinteiTaisyosyaIchiran> get単独タイプリスト() {
        List<YokaigoNinteiTaisyosyaIchiran> 単独タイプリスト = new ArrayList<>();
        IYokaigoNinteiTaisyosyaIchiranMapper mapper = mapperProvider.create(IYokaigoNinteiTaisyosyaIchiranMapper.class);
        List<YokaigoNinteiTaisyosyaIchiranEntity> entities = mapper.get単独タイプ();
        for (YokaigoNinteiTaisyosyaIchiranEntity entity : entities) {
            単独タイプリスト.add(new YokaigoNinteiTaisyosyaIchiran(entity));
        }
        return 単独タイプリスト;

    }

    /**
     * 要介護認定インターフェース情報リストを取得する
     *
     * @param 申請書管理番号リスト List<RString>
     * @return 要介護認定インターフェース情報リスト
     */
    public ArrayList<YokaigoNinteiInterface> get要介護認定インターフェース情報リスト(List<RString> 申請書管理番号リスト) {
        ArrayList<YokaigoNinteiInterface> 要介護認定インターフェース情報リスト = new ArrayList<>();
        DbT4003YokaigoNinteiInterfaceDac dac = InstanceProvider.create(DbT4003YokaigoNinteiInterfaceDac.class);
        for (DbT4003YokaigoNinteiInterfaceEntity entity : dac.select申請書管理番号リスト(申請書管理番号リスト)) {
            entity.initializeMd5();
            要介護認定インターフェース情報リスト.add(new YokaigoNinteiInterface(entity));
        }
        return 要介護認定インターフェース情報リスト;
    }

    /**
     * save消込処理
     *
     * @param 画面情報 YokaigoNinteiInterface
     */
    @Transaction
    public void save(YokaigoNinteiInterface 画面情報) {
        要介護認定インターフェース情報Dac.save(画面情報.toEntity());
    }

}
