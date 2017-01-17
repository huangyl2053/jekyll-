/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosainmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai.ShichosonMeishoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosainmaster.NinteiChosainMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosainmaster.NinteiChosainMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosainmaster.NinteiChosainMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosainmaster.NinteiChosainMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosainmaster.INinteiChosainMasterMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報の検索クラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
public class NinteiChosainMasterFinder {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    NinteiChosainMasterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param MapperProvider
     * @param DbT7051KoseiShichosonMasterDac
     */
    NinteiChosainMasterFinder(MapperProvider mapperProvider, DbT7051KoseiShichosonMasterDac dac) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosainMasterFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosainMasterFinder}のインスタンス
     */
    public static NinteiChosainMasterFinder createInstance() {
        return InstanceProvider.create(NinteiChosainMasterFinder.class);
    }

    /**
     * 検索条件に従い、調査員情報を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return NinteiChosainMaster 構調査員情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<NinteiChosainMaster> getChosainJohoIchiranList(NinteiChosainMasterMapperParameter 調査員情報検索条件) {
        requireNonNull(調査員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報検索条件"));
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);

        List<NinteiChosainMasterRelateEntity> relateEntityList = mapper.selectChosainJohoIchiranList(調査員情報検索条件);
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteiChosainMaster>emptyList(), 0, false);
        }
        List<NinteiChosainMaster> 調査員情報List = new ArrayList<>();
        for (NinteiChosainMasterRelateEntity relateEntity : relateEntityList) {
            調査員情報List.add(new NinteiChosainMaster(relateEntity));
        }
        return SearchResult.of(調査員情報List, 0, false);
    }

    /**
     * 検索条件に従い、調査員情報を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return int 調査員情報の件数
     */
    @Transaction
    public int getChosainJohoIchiranListKensu(NinteiChosainMasterMapperParameter 調査員情報検索条件) {
        requireNonNull(調査員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報検索条件"));
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        return mapper.selectChosainJohoIchiranListKensu(調査員情報検索条件);
    }

    /**
     * 検索条件に従い、調査員情報を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return NinteiChosainMaster 構調査員情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ChosainJoho> getChosainJohoList(NinteiChosainMasterMapperParameter 調査員情報検索条件) {
        List<ChosainJoho> businessList = new ArrayList<>();
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        List<DbT5913ChosainJohoEntity> entityList = mapper.selectChosainJohoList(調査員情報検索条件);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ChosainJoho>emptyList(), 0, false);
        }
        for (DbT5913ChosainJohoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ChosainJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件に従い、調査員情報の件数を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return 調査員情報の件数
     */
    @Transaction
    public int getChosainJohoCount(NinteiChosainMasterSearchParameter 調査員情報検索条件) {
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        return mapper.selectChosainJohoCount(調査員情報検索条件);
    }

    /**
     * 検索条件に従い、要介護認定申請情報の件数を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return 要介護認定申請情報の件数
     */
    @Transaction
    public int getNinteiShinseiJohoCount(NinteiChosainMasterSearchParameter 調査員情報検索条件) {
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        return mapper.selectNinteiShinseiJohoCount(調査員情報検索条件);
    }

    /**
     * 検索条件に従い、認定調査依頼情報の件数を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return 認定調査依頼情報の件数
     */
    @Transaction
    public int getNinteichosaIraiJohoCount(NinteiChosainMasterSearchParameter 調査員情報検索条件) {
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        return mapper.selectNinteichosaIraiJohoCount(調査員情報検索条件);
    }

    /**
     * 検索条件に従い、調査員情報の件数を検索します。
     *
     * @param 調査員情報検索条件 調査員情報検索条件
     * @return 調査員情報の件数
     */
    @Transaction
    public RString getNinteichosaItakusakiMeisho(NinteiChosainMasterSearchParameter 調査員情報検索条件) {
        INinteiChosainMasterMapper mapper = mapperProvider.create(INinteiChosainMasterMapper.class);
        return mapper.selectNinteichosaItakusakiJoho(調査員情報検索条件);
    }

    /**
     * 市町村名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return SearchResult<ShichosonMeishoBusiness> 市町村名称リスト
     */
    @Transaction
    public SearchResult<ShichosonMeishoBusiness> getShichosonMeisho(LasdecCode 市町村コード) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dac.selectByshichosonCode(市町村コード);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShichosonMeishoBusiness>emptyList(), 0, false);
        }
        List<ShichosonMeishoBusiness> shichosonMeisho = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            shichosonMeisho.add(new ShichosonMeishoBusiness(entity));
        }
        return SearchResult.of(shichosonMeisho, 0, false);
    }
}
