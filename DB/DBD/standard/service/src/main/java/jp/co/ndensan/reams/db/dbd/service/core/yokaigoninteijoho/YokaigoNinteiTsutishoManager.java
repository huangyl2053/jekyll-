/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.yokaigoninteijoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutisho;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigonintei.YokaigoNinteiTsutishoIkkatsuHakkoJoho;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.yokaigoninteijoho.YokaigoNinteiTsutishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiTsutishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho.YokaigoNinteiTsutishoIkkatsuHakkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.yokaigoninteijoho.IYokaigoNinteiTsutishoMapper;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 要介護認定通知書発行の処理します。
 *
 * @reamsid_L DBE-1430-010 lit
 */
public class YokaigoNinteiTsutishoManager {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;

    /**
     * コンストラクタです。
     */
    YokaigoNinteiTsutishoManager() {
        mapperProvider = InstanceProvider.create(MapperProvider.class);
        受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @@param mapperProvider MapperProvider
     */
    YokaigoNinteiTsutishoManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
        受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTsutishoManager}のインスタンスを返します。
     *
     * @return YokaigoNinteiTsutishoManager
     *
     */
    public static YokaigoNinteiTsutishoManager createInstance() {
        return InstanceProvider.create(YokaigoNinteiTsutishoManager.class);

    }

    /**
     * 対象者情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 対象者情報 YokaigoNinteiTsutisho
     */
    public List<YokaigoNinteiTsutisho> get対象者情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ) {
        IYokaigoNinteiTsutishoMapper mapper = mapperProvider.create(IYokaigoNinteiTsutishoMapper.class);
        List<YokaigoNinteiTsutishoEntity> entities = mapper.get対象者情報(認定通知書発行検索用パラメータ);
        List<YokaigoNinteiTsutisho> result = new ArrayList<>();
        for (YokaigoNinteiTsutishoEntity entity : entities) {
            entity.initializeMd5ToEntities();
            result.add(new YokaigoNinteiTsutisho(entity));
        }
        return result;
    }

    /**
     * 認定結果通知書情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 認定結果通知書情報 YokaigoNinteiTsutisho
     */
    public YokaigoNinteiTsutisho get認定結果通知書情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ) {
        IYokaigoNinteiTsutishoMapper mapper = mapperProvider.create(IYokaigoNinteiTsutishoMapper.class);
        List<YokaigoNinteiTsutishoEntity> entities = mapper.get認定結果通知書情報(認定通知書発行検索用パラメータ);
        if (null != entities && !entities.isEmpty()) {
            YokaigoNinteiTsutishoEntity entity = entities.get(0);
            entity.initializeMd5ToEntities();
            return new YokaigoNinteiTsutisho(entity);
        }
        return null;
    }

    /**
     * 受給者台帳情報の取得します。
     *
     * @param 認定通知書発行検索用パラメータ YokaigoNinteiTsutishoMybatisParameter
     * @return 受給者台帳情報 List<YokaigoNinteiTsutisho>
     */
    public List<YokaigoNinteiTsutisho> get受給者台帳情報(YokaigoNinteiTsutishoMybatisParameter 認定通知書発行検索用パラメータ) {
        List<YokaigoNinteiTsutisho> result = new ArrayList<>();
        IYokaigoNinteiTsutishoMapper mapper = mapperProvider.create(IYokaigoNinteiTsutishoMapper.class);
        List<YokaigoNinteiTsutishoEntity> entities = mapper.get受給者台帳情報(認定通知書発行検索用パラメータ);
        for (YokaigoNinteiTsutishoEntity entity : entities) {
            entity.initializeMd5ToEntities();
            result.add(new YokaigoNinteiTsutisho(entity));
        }
        return result;
    }

    /**
     * 一括発行データの取得します。
     *
     * @param 市町村コード RString
     * @param 処理名 RString
     * @return 一括発行データ YokaigoNinteiTsutishoIkkatsuHakkoJoho
     */
    public YokaigoNinteiTsutishoIkkatsuHakkoJoho get一括発行データ(RString 市町村コード, RString 処理名) {
        IYokaigoNinteiTsutishoMapper mapper = mapperProvider.create(IYokaigoNinteiTsutishoMapper.class);
        List<YokaigoNinteiTsutishoIkkatsuHakkoEntity> entities = mapper.get一括発行データ(市町村コード, 処理名);
        if (null != entities && !entities.isEmpty()) {
            return new YokaigoNinteiTsutishoIkkatsuHakkoJoho(entities.get(0));
        }
        return null;
    }

    /**
     * 要介護認定通知書発行情報の保存します。
     *
     * @param 要介護認定通知書発行情報 YokaigoNinteiTsutisho
     */
    public void save受給者台帳(YokaigoNinteiTsutisho 要介護認定通知書発行情報) {
        if (要介護認定通知書発行情報.hasChanged受給者台帳情報()) {
            受給者台帳Dac.save(要介護認定通知書発行情報.get受給者台帳Entity());
        }
    }
}
