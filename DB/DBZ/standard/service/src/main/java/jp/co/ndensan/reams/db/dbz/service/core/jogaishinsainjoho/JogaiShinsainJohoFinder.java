/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.jogaishinsainjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinRelateJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.jogaishinsainjoho.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5914SonotaKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jogaishinsainjoho.IJogaiShinsainJohoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 除外審査員情報データの取得処理クラスです。
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
public class JogaiShinsainJohoFinder {

    private final MapperProvider mapperProvider;
    private final DbT5911ShujiiIryoKikanJohoDac dbT5911Dac;
    private final DbT5910NinteichosaItakusakiJohoDac dbT5910Dac;
    private final DbT5914SonotaKikanJohoDac dbT5914Dac;
    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;

    /**
     * コンストラクタ。
     */
    public JogaiShinsainJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5911Dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        this.dbT5910Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.dbT5914Dac = InstanceProvider.create(DbT5914SonotaKikanJohoDac.class);
        this.dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     * @param dbT5911Dac DbT5911ShujiiIryoKikanJohoDac
     * @param dbT5910Dac DbT5910NinteichosaItakusakiJohoDac
     * @param dbT5914Dac DbT5914SonotaKikanJohoDac
     * @param dbT7051Dac DbT7051KoseiShichosonMasterDac
     */
    public JogaiShinsainJohoFinder(MapperProvider mapperProvider,
            DbT5911ShujiiIryoKikanJohoDac dbT5911Dac,
            DbT5910NinteichosaItakusakiJohoDac dbT5910Dac,
            DbT5914SonotaKikanJohoDac dbT5914Dac,
            DbT7051KoseiShichosonMasterDac dbT7051Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5911Dac = dbT5911Dac;
        this.dbT5910Dac = dbT5910Dac;
        this.dbT5914Dac = dbT5914Dac;
        this.dbT7051Dac = dbT7051Dac;
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
     * 審査会委員一覧検索して前回審査会委員情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return SearchResult<ShinsakaiIinRelateJoho>
     */
    public SearchResult<ShinsakaiIinRelateJoho> get審査会委員一覧検索して前回審査会委員情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        IJogaiShinsainJohoMapper mapper = mapperProvider.create(IJogaiShinsainJohoMapper.class);
        List<ShinsakaiIinRelateJoho> shinsakaiIinRelateJohoList = new ArrayList<>();
        List<ShinsakaiIinJohoRelateEntity> shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(申請書管理番号);
        for (ShinsakaiIinJohoRelateEntity entity : shinsakaiIinJohoList) {
            shinsakaiIinRelateJohoList.add(new ShinsakaiIinRelateJoho(entity));
        }
        return SearchResult.of(shinsakaiIinRelateJohoList, 0, false);
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
        List<ShinsakaiIinJohoRelateEntity> shinsakaiIinJohoList = mapper.getShinsakaiIinJoho2(申請書管理番号);
        for (ShinsakaiIinJohoRelateEntity entity : shinsakaiIinJohoList) {
            shinsakaiIinRelateJohoList.add(new ShinsakaiIinRelateJoho(entity));
        }
        return SearchResult.of(shinsakaiIinRelateJohoList, 0, false);
    }
    
    /**
     * 審査会委員一覧検索して審査会委員情報を取得します
     *
     * @param 審査会委員コード 審査会委員コード
     * @return SearchResult<ShinsakaiIinRelateJoho>
     */
    public SearchResult<ShinsakaiIinRelateJoho> get審査会委員コードより審査会委員情報(RString 審査会委員コード) {
        requireNonNull(審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員コード"));
        IJogaiShinsainJohoMapper mapper = mapperProvider.create(IJogaiShinsainJohoMapper.class);
        List<ShinsakaiIinRelateJoho> shinsakaiIinRelateJohoList = new ArrayList<>();
        List<ShinsakaiIinJohoRelateEntity> shinsakaiIinJohoList = mapper.getShinsakaiIinJohoByCode(審査会委員コード);
        for (ShinsakaiIinJohoRelateEntity entity : shinsakaiIinJohoList) {
            shinsakaiIinRelateJohoList.add(new ShinsakaiIinRelateJoho(entity));
        }
        return SearchResult.of(shinsakaiIinRelateJohoList, 0, false);
    }

    /**
     * 医療機関名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return 医療機関名称
     */
    public RString get医療機関名称(RString 市町村コード, ShujiiIryokikanCode 主治医医療機関コード) {
        if (!RString.isNullOrEmpty(主治医医療機関コード.value())
                && !RString.isNullOrEmpty(市町村コード)) {
            DbT5911ShujiiIryoKikanJohoEntity entity = dbT5911Dac.selectByKey(new LasdecCode(市町村コード), 主治医医療機関コード);
            if (entity != null) {
                return entity.getIryoKikanMeisho();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 医療機関名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 事業者名称
     */
    public RString get事業者名称(RString 市町村コード, RString 認定調査委託先コード) {
        if (!RString.isNullOrEmpty(認定調査委託先コード)
                && !RString.isNullOrEmpty(市町村コード)) {
            DbT5910NinteichosaItakusakiJohoEntity entity = dbT5910Dac.selectByKey(new LasdecCode(市町村コード), 認定調査委託先コード);
            if (entity != null) {
                return entity.getJigyoshaMeisho();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 医療機関名称を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他期間コード その他期間コード
     * @return 機関名称
     */
    public RString get機関名称(ShoKisaiHokenshaNo 証記載保険者番号, RString その他期間コード) {
        if (証記載保険者番号 != null
                && !RString.isNullOrEmpty(その他期間コード)) {
            DbT5914SonotaKikanJohoEntity entity = dbT5914Dac.selectByKey(証記載保険者番号, その他期間コード);
            if (entity != null) {
                return entity.getKikanMeisho();
            }
        }
        return RString.EMPTY;
    }

    /**
     * 市町村名称を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @return 市町村名称
     */
    public RString get市町村名称(ShoKisaiHokenshaNo 証記載保険者番号) {
        List<DbT7051KoseiShichosonMasterEntity> entityList = dbT7051Dac.getshichosonMeisho(証記載保険者番号);
        if (!entityList.isEmpty()) {
            return entityList.get(0).getShichosonMeisho();
        }
        return RString.EMPTY;
    }
}
