/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteiinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4101ninteishinseijoho.DbT4101NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt4102ninteikekkajoho.DbT4102NinteiKekkaJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt5102ninteikekkajoho.DbT5102NinteiKekkaJohoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.dbt7202kaigoninteihokaiseikanri.DbT7202KaigoNinteiHokaiseiKanriBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7202KaigoNinteiHokaiseiKanriDac;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DBZ.NinteiInput_認定情報の取得処理です。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class NinteiInputFinder {

    private final DbT4101NinteiShinseiJohoDac dbT4101dac;
    private final DbT4102NinteiKekkaJohoDac dbT4102dac;
    private final DbT5101NinteiShinseiJohoDac dbT5101dac;
    private final DbT5102NinteiKekkaJohoDac dbT5102dac;
    private final DbT4001JukyushaDaichoDac dbT4001dac;
    private final DbT7202KaigoNinteiHokaiseiKanriDac dbt7202dac;

    /**
     * コンストラクタ
     */
    NinteiInputFinder() {
        this.dbT4101dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        this.dbT4102dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
        this.dbT5101dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbT5102dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
        this.dbT4001dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbt7202dac = InstanceProvider.create(DbT7202KaigoNinteiHokaiseiKanriDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param dbT4101dac dbT4101dac
     * @param dbT4102dac dbT4102dac
     * @param dbT5101dac dbT5101dac
     * @param dbT5102dac dbT5102dac
     * @param dbT4001dac dbT4001dac
     */
    NinteiInputFinder(
            DbT4101NinteiShinseiJohoDac dbT4101dac,
            DbT4102NinteiKekkaJohoDac dbT4102dac,
            DbT5101NinteiShinseiJohoDac dbT5101dac,
            DbT5102NinteiKekkaJohoDac dbT5102dac,
            DbT4001JukyushaDaichoDac dbT4001dac,
            DbT7202KaigoNinteiHokaiseiKanriDac dbt7202dac) {
        this.dbT4101dac = dbT4101dac;
        this.dbT4102dac = dbT4102dac;
        this.dbT5101dac = dbT5101dac;
        this.dbT5102dac = dbT5102dac;
        this.dbT4001dac = dbT4001dac;
        this.dbt7202dac = dbt7202dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiInputFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiInputFinder}のインスタンス
     */
    public static NinteiInputFinder createInstance() {
        return InstanceProvider.create(NinteiInputFinder.class);
    }

    /**
     * 要介護認定申請情報(受給)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJohoBusiness
     */
    @Transaction
    public DbT4101NinteiShinseiJohoBusiness get要介護認定申請情報受給(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4101NinteiShinseiJohoEntity> ninteiShinseiJoho = dbT4101dac.selectByKey(申請書管理番号);
        if (ninteiShinseiJoho.isPresent()) {
            return new DbT4101NinteiShinseiJohoBusiness(ninteiShinseiJoho.get());
        }
        return null;
    }

    /**
     * 要介護認定結果情報(受給)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4102NinteiKekkaJohoBusiness
     */
    @Transaction
    public DbT4102NinteiKekkaJohoBusiness get要介護認定結果情報受給(ShinseishoKanriNo 申請書管理番号) {
        DbT4102NinteiKekkaJohoEntity entity = dbT4102dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return new DbT4102NinteiKekkaJohoBusiness(entity);
        }
        return null;
    }

    /**
     * 要介護認定申請情報(認定)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiShinseiJoho
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定申請情報認定(ShinseishoKanriNo 申請書管理番号) {
        DbT5101NinteiShinseiJohoEntity entity = dbT5101dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return new NinteiShinseiJoho(entity);
        }
        return null;
    }

    /**
     * 要介護認定結果情報(認定)データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5102NinteiKekkaJohoBusiness
     */
    @Transaction
    public DbT5102NinteiKekkaJohoBusiness get要介護認定結果情報認定(ShinseishoKanriNo 申請書管理番号) {
        DbT5102NinteiKekkaJohoEntity entity = dbT5102dac.selectByKey(申請書管理番号);
        if (entity != null) {
            return new DbT5102NinteiKekkaJohoBusiness(entity);
        }
        return null;
    }

    /**
     * 受給者台帳情報データを返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return JukyushaDaicho
     */
    @Transaction
    public SearchResult<JukyushaDaicho> getサービス(ShinseishoKanriNo 申請書管理番号) {
        List<JukyushaDaicho> jukyushaDaichoList = new ArrayList<>();
        List<DbT4001JukyushaDaichoEntity> entityList = dbT4001dac.selectサービス(申請書管理番号);
        if (entityList != null) {
            for (DbT4001JukyushaDaichoEntity entity : entityList) {
                jukyushaDaichoList.add(new JukyushaDaicho(entity));
            }
        }
        return SearchResult.of(jukyushaDaichoList, 0, false);
    }

    /**
     * 最古法改正施行年月日データを返します。
     *
     * @return DbT7202KaigoNinteiHokaiseiKanriBusiness
     */
    @Transaction
    public DbT7202KaigoNinteiHokaiseiKanriBusiness get最古法改正施行年月日() {
        DbT7202KaigoNinteiHokaiseiKanriEntity entity = dbt7202dac.get最古法改正施行年月日();
        if (entity != null) {
            return new DbT7202KaigoNinteiHokaiseiKanriBusiness(entity);
        }
        return null;
    }
}
