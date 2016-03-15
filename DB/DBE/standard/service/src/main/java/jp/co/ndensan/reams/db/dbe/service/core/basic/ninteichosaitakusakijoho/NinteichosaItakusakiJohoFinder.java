/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosaitakusakijoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.ChikuShichosonBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiKanKanRiBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.JiMuSyoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosaitakusakijoho.NinteichosaScheduleBusiness;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiKanKanRiParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.JiMuSyoParameter;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho.NinteichosaScheduleParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.ChikuShichosonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiKanKanRiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.JiMuSyoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho.NinteichosaScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ninteichosaitakusakijoho.INinteichosaItakusakiJohoMapper;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 認定調査スケジュール登録9クラスです。
 */
public class NinteichosaItakusakiJohoFinder {

    private final MapperProvider mapperProvider;
    private final DbT5910NinteichosaItakusakiJohoDac dbT5910Dac;
    private final DbT5913ChosainJohoDac dbT5913ChosainJohoDac;

    /**
     * コンストラクタです。
     */
    NinteichosaItakusakiJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5910Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbT5913ChosainJohoDac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    NinteichosaItakusakiJohoFinder(MapperProvider mapperProvider,
            DbT5910NinteichosaItakusakiJohoDac dbT5910Dac,
            DbT5913ChosainJohoDac dbT5913ChosainJohoDac) {
        this.mapperProvider = mapperProvider;
        this.dbT5910Dac = dbT5910Dac;
        this.dbT5913ChosainJohoDac = dbT5913ChosainJohoDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoFinder}のインスタンス
     */
    public static NinteichosaItakusakiJohoFinder createInstance() {
        return InstanceProvider.create(NinteichosaItakusakiJohoFinder.class);
    }

    /**
     * 市町村リストを取得する。
     *
     * @param 調査地区コード RString
     * @return 市町村リスト
     */
    @Transaction
    public SearchResult<ChikuShichosonBusiness> get市町村リスト(RString 調査地区コード) {
        List<ChikuShichosonBusiness> chikuShichosonList = new ArrayList();
        INinteichosaItakusakiJohoMapper mapper = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
        List<ChikuShichosonRelateEntity> 市町村リスト = mapper.select市町村リスト(調査地区コード);
        if (市町村リスト == null || 市町村リスト.isEmpty()) {
            return SearchResult.of(Collections.<ChikuShichosonBusiness>emptyList(), 0, false);
        }
        for (ChikuShichosonRelateEntity entity : 市町村リスト) {
            chikuShichosonList.add(new ChikuShichosonBusiness(entity));
        }
        return SearchResult.of(chikuShichosonList, 0, false);
    }

    /**
     * 対象認定調査員所属機関リストを取得する。
     *
     * @param 市町村コード RString
     * @return 対象認定調査員所属機関リスト
     */
    @Transaction
    public SearchResult<NinteichosaItakusakiJoho> get対象認定調査員所属機関(LasdecCode 市町村コード) {

        List<DbT5910NinteichosaItakusakiJohoEntity> entityList = dbT5910Dac.select対象認定調査員所属機関(市町村コード);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaItakusakiJoho>emptyList(), 0, false);
        }
        List<NinteichosaItakusakiJoho> ninteichosaItakusakiJoho = new ArrayList<>();
        for (DbT5910NinteichosaItakusakiJohoEntity entity : entityList) {
            ninteichosaItakusakiJoho.add(new NinteichosaItakusakiJoho(entity));
        }
        return SearchResult.of(ninteichosaItakusakiJoho, 0, false);
    }

    /**
     * 対象認定調査員リストを取得する。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 対象認定調査員リスト
     */
    @Transaction
    public SearchResult<ChosainJoho> get対象認定調査員(LasdecCode 市町村コード, ChosaItakusakiCode 認定調査委託先コード) {

        List<DbT5913ChosainJohoEntity> entityList = dbT5913ChosainJohoDac.select調査員情報(市町村コード, 認定調査委託先コード);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<ChosainJoho>emptyList(), 0, false);
        }
        List<ChosainJoho> chosainJohoList = new ArrayList<>();
        for (DbT5913ChosainJohoEntity entity : entityList) {
            chosainJohoList.add(new ChosainJoho(entity));
        }
        return SearchResult.of(chosainJohoList, 0, false);
    }

    /**
     * 調査員の場合で認定調査スケジュール情報を取得します。
     *
     * @param parametere 認定調査スケジュール情報パラメータ
     * @return SearchResult<NinteichosaScheduleBusiness> 認定調査スケジュール情報
     */
    @Transaction
    public SearchResult<NinteichosaScheduleBusiness> get調査員(NinteichosaScheduleParameter parametere) {
        INinteichosaItakusakiJohoMapper mapper = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
        List<NinteichosaScheduleRelateEntity> entityList = mapper.get調査員(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaScheduleBusiness>emptyList(), 0, false);
        }
        List<NinteichosaScheduleBusiness> 調査員List = new ArrayList<>();
        for (NinteichosaScheduleRelateEntity entity : entityList) {
            調査員List.add(new NinteichosaScheduleBusiness(entity));
        }
        return SearchResult.of(調査員List, 0, false);
    }

    /**
     * 事務所の場合で認定調査スケジュール情報を取得します。
     *
     * @param parametere 認定調査スケジュール情報パラメータ
     * @return SearchResult<JiMuSyoBusiness> 認定調査スケジュール情報
     */
    @Transaction
    public SearchResult<JiMuSyoBusiness> get事務所(JiMuSyoParameter parametere) {
        INinteichosaItakusakiJohoMapper mapper = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
        List<JiMuSyoEntity> entityList = mapper.get事務所(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<JiMuSyoBusiness>emptyList(), 0, false);
        }
        List<JiMuSyoBusiness> 事務所List = new ArrayList<>();
        for (JiMuSyoEntity entity : entityList) {
            事務所List.add(new JiMuSyoBusiness(entity));
        }
        return SearchResult.of(事務所List, 0, false);
    }

    /**
     * 時間管理の場合で認定調査スケジュール情報を取得します。
     *
     * @param parametere 認定調査スケジュール情報パラメータ
     * @return SearchResult<JiKanKanRiBusiness> 認定調査スケジュール情報
     */
    @Transaction
    public SearchResult<JiKanKanRiBusiness> get時間管理(JiKanKanRiParameter parametere) {
        INinteichosaItakusakiJohoMapper mapper = mapperProvider.create(INinteichosaItakusakiJohoMapper.class);
        List<JiKanKanRiEntity> entityList = mapper.get時間管理(parametere);
        if (entityList == null || entityList.isEmpty()) {
            return SearchResult.of(Collections.<JiKanKanRiBusiness>emptyList(), 0, false);
        }
        List<JiKanKanRiBusiness> 時間管理List = new ArrayList<>();
        for (JiKanKanRiEntity entity : entityList) {
            時間管理List.add(new JiKanKanRiBusiness(entity));
        }
        return SearchResult.of(時間管理List, 0, false);
    }
}
