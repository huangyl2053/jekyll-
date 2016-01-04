/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihousyosai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dba.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dba.business.shichoson.Shichoson;
import jp.co.ndensan.reams.db.dba.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.service.KyuShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保詳細のクラスです。
 */
public class HihousyosaiFinder {

    private final DbT7051KoseiShichosonMasterDac dbT7051Dac;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;

    /**
     * コンストラクタです。
     */
    HihousyosaiFinder() {
        dbT7051Dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dbT7051Dac DbT7051KoseiShichosonMasterDac
     * @param dbT1001dac DbT1001HihokenshaDaichoDac
     */
    HihousyosaiFinder(DbT7051KoseiShichosonMasterDac dbT7051Dac,
            DbT1001HihokenshaDaichoDac dbT1001dac) {
        this.dbT7051Dac = dbT7051Dac;
        this.dbT1001Dac = dbT1001dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihousyosaiFinder}のインスタンスを返します。
     *
     * @return HihousyosaiFinder
     */
    public static HihousyosaiFinder createInstance() {
        return InstanceProvider.create(HihousyosaiFinder.class);
    }

    /**
     * 所在保険者リスト情報取得します
     *
     * @return SearchResult<KoseiShichosonMaster> 構成市町村マスタリスト
     */
    @Transaction
    public SearchResult<KoseiShichosonMaster> getKoseiShichosonMasterList() {
        List<KoseiShichosonMaster> businessList = new ArrayList<>();
        List<DbT7051KoseiShichosonMasterEntity> entityList = dbT7051Dac.selectByGappeiKyuShichosonKubun();
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<KoseiShichosonMaster>emptyList(), 0, false);
        }
        for (DbT7051KoseiShichosonMasterEntity entity : entityList) {
            businessList.add(new KoseiShichosonMaster(entity));
        }

        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 旧保険者リスト情報取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @return SearchResult<Shichoson>
     */
    @Transaction
    public SearchResult<Shichoson> getGappeiShichosonList(
            LasdecCode 市町村コード,
            DonyukeitaiCode 導入形態コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));
        List<Shichoson> 旧保険者List = new ArrayList<>();
        List<KyuShichosonCode> 旧市町村コード情報List
                = KyuShichosonCode.getKyuShichosonCodeJoho(市町村コード, 導入形態コード).get旧市町村コード情報List();
        if (旧市町村コード情報List.isEmpty()) {
            return SearchResult.of(Collections.<Shichoson>emptyList(), 0, false);
        }
        for (KyuShichosonCode 旧市町村コード : 旧市町村コード情報List) {
            Shichoson shichosonBusiness = new Shichoson();
            shichosonBusiness.set旧市町村コード(旧市町村コード.get旧市町村コード());
            shichosonBusiness.set旧市町村名称(旧市町村コード.get旧市町村名称());
            旧保険者List.add(shichosonBusiness);
        }
        return SearchResult.of(旧保険者List, 0, false);
    }

    /**
     * 得喪情報取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @param 枝番 枝番
     * @return HihokenshaDaicho 被保険者台帳管理オブジェクト
     */
    @Transaction
    public HihokenshaDaicho getTokusouJoho(HihokenshaNo 被保険者番号, FlexibleDate 異動日, RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        DbT1001HihokenshaDaichoEntity entity = dbT1001Dac.selectByHihokenshaNo(被保険者番号, 異動日, 枝番);
        if (entity == null) {
            return null;
        }
        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保区分リスト情報取得です。
     *
     * @param code Code
     * @return SearchResult<ShikakuKubun> 資格区分リスト
     */
    @Transaction
    public SearchResult<ShikakuKubun> getHihokubunList(RString code) {
        List<ShikakuKubun> shikakuKubunList = new ArrayList<>();
        ShikakuKubun shikakuKubun = ShikakuKubun.toValue(code);
        shikakuKubunList.add(shikakuKubun);
        return SearchResult.of(shikakuKubunList, 0, false);
    }
}
