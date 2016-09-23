/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.rirekishusei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.rirekishusei.RirekiShuseiBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.rirekishusei.RirekiShuseiRelateEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.rirekishusei.IRirekiShuseiMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4120ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4121ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4201NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4202NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4301ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4302ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4120ShinseitodokedeJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4202NinteichosahyoGaikyoChosaDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特殊修正のサービスクラスです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
public class RirekiShuseiManager {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac dbt4001Dac;
    private final DbT4101NinteiShinseiJohoDac dbt4101Dac;
    private final DbT4102NinteiKekkaJohoDac dbt4102Dac;
    private final DbT4116IchijiHanteiKekkaJohoDac dbt4116Dac;
    private final DbT4120ShinseitodokedeJohoDac dbt4120Dac;
    private final DbT4121ShinseiRirekiJohoDac dbt4121Dac;
    private final DbT4123NinteiKeikakuJohoDac dbt4123Dac;
    private final DbT4201NinteichosaIraiJohoDac dbt4201Dac;
    private final DbT4202NinteichosahyoGaikyoChosaDac dbt4202Dac;
    private final DbT4301ShujiiIkenshoIraiJohoDac dbt4301Dac;
    private final DbT4302ShujiiIkenshoJohoDac dbt4302Dac;

    /**
     * コンストラクタです。
     */
    RirekiShuseiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbt4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbt4101Dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        this.dbt4102Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
        this.dbt4116Dac = InstanceProvider.create(DbT4116IchijiHanteiKekkaJohoDac.class);
        this.dbt4120Dac = InstanceProvider.create(DbT4120ShinseitodokedeJohoDac.class);
        this.dbt4121Dac = InstanceProvider.create(DbT4121ShinseiRirekiJohoDac.class);
        this.dbt4123Dac = InstanceProvider.create(DbT4123NinteiKeikakuJohoDac.class);
        this.dbt4201Dac = InstanceProvider.create(DbT4201NinteichosaIraiJohoDac.class);
        this.dbt4202Dac = InstanceProvider.create(DbT4202NinteichosahyoGaikyoChosaDac.class);
        this.dbt4301Dac = InstanceProvider.create(DbT4301ShujiiIkenshoIraiJohoDac.class);
        this.dbt4302Dac = InstanceProvider.create(DbT4302ShujiiIkenshoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    RirekiShuseiManager(MapperProvider mapperProvider, DbT4001JukyushaDaichoDac dbt4001Dac,
            DbT4101NinteiShinseiJohoDac dbt4101Dac, DbT4102NinteiKekkaJohoDac dbt4102Dac,
            DbT4116IchijiHanteiKekkaJohoDac dbt4116Dac, DbT4120ShinseitodokedeJohoDac dbt4120Dac,
            DbT4121ShinseiRirekiJohoDac dbt4121Dac, DbT4123NinteiKeikakuJohoDac dbt4123Dac,
            DbT4201NinteichosaIraiJohoDac dbt4201Dac, DbT4202NinteichosahyoGaikyoChosaDac dbt4202Dac,
            DbT4301ShujiiIkenshoIraiJohoDac dbt4301Dac, DbT4302ShujiiIkenshoJohoDac dbt4302Dac) {
        this.mapperProvider = mapperProvider;
        this.dbt4001Dac = dbt4001Dac;
        this.dbt4101Dac = dbt4101Dac;
        this.dbt4102Dac = dbt4102Dac;
        this.dbt4116Dac = dbt4116Dac;
        this.dbt4120Dac = dbt4120Dac;
        this.dbt4121Dac = dbt4121Dac;
        this.dbt4123Dac = dbt4123Dac;
        this.dbt4201Dac = dbt4201Dac;
        this.dbt4202Dac = dbt4202Dac;
        this.dbt4301Dac = dbt4301Dac;
        this.dbt4302Dac = dbt4302Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link RirekiShuseiManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link RirekiShuseiManager}のインスタンス
     */
    public static RirekiShuseiManager createInstance() {
        return InstanceProvider.create(RirekiShuseiManager.class);
    }

    /**
     * 特殊修正画面初期検索
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<RirekiShuseiBusiness>
     */
    public SearchResult<RirekiShuseiBusiness> getDataForLoad(RString 被保険者番号) {

        List<RirekiShuseiBusiness> resultList = new ArrayList<>();
        List<RirekiShuseiRelateEntity> entityList
                = mapperProvider.create(IRirekiShuseiMapper.class).getDataForLoad(被保険者番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<RirekiShuseiBusiness>emptyList(), 0, false);
        }
        for (RirekiShuseiRelateEntity entity : entityList) {
            resultList.add(new RirekiShuseiBusiness(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }

    /**
     * 申請書管理番号で前回受給者台帳を取得します
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 受給者台帳
     */
    public JukyushaDaicho get前回受給者台帳(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4121ShinseiRirekiJohoEntity> entity = dbt4121Dac.selectByKey(申請書管理番号);
        if (entity.get().getZenkaiShinseishoKanriNo() != null && entity.get().getZenkaiShinseishoKanriNo().isEmpty()) {
            List<DbT4001JukyushaDaichoEntity> entityList = dbt4001Dac.selectサービス(申請書管理番号);
            if (entityList != null && !entityList.isEmpty()) {
                return new JukyushaDaicho(entityList.get(0));
            }
        }
        return null;
    }

    /**
     * 申請書管理番号で認定申請情報を取得します
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    public DbT4101NinteiShinseiJoho get認定申請情報(ShinseishoKanriNo 申請書管理番号) {
        Optional<DbT4101NinteiShinseiJohoEntity> entity = dbt4101Dac.selectByKey(申請書管理番号);
        if (entity.isPresent()) {
            return new DbT4101NinteiShinseiJoho(entity.get());
        }
        return null;
    }

    /**
     * 要介護認定申請情報{@link DbT4101NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 {@link DbT4101NinteiShinseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定申請情報(DbT4101NinteiShinseiJoho 要介護認定申請情報) {
        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4101Dac.save(要介護認定申請情報.toEntity());
    }

    /**
     * 受給者台帳{@link JukyushaDaicho}を保存します。
     *
     * @param 受給者台帳 {@link JukyushaDaicho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者台帳(JukyushaDaicho 受給者台帳) {
        if (!受給者台帳.hasChanged()) {
            return false;
        }
        return 1 == dbt4001Dac.save(受給者台帳.toEntity());
    }

    /**
     * 要介護認定結果情報{@link DbT4102NinteiKekkaJoho}を保存します。
     *
     * @param 要介護認定結果情報 {@link DbT4102NinteiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定結果情報(DbT4102NinteiKekkaJoho 要介護認定結果情報) {
        if (!要介護認定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4102Dac.save(要介護認定結果情報.toEntity());
    }

    /**
     * 要介護認定一次判定結果情報{@link IchijiHanteiKekkaJoho}を保存します。
     *
     * @param 要介護認定一次判定結果情報 {@link IchijiHanteiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定一次判定結果情報(IchijiHanteiKekkaJoho 要介護認定一次判定結果情報) {
        if (!要介護認定一次判定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4116Dac.save(要介護認定一次判定結果情報.toEntity());
    }

    /**
     * 申請届出情報{@link ShinseitodokedeJoho}を保存します。
     *
     * @param 申請届出情報 {@link ShinseitodokedeJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請届出情報(DbT4120ShinseitodokedeJoho 申請届出情報) {
        if (!申請届出情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4120Dac.save(申請届出情報.toEntity());
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 申請履歴情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請履歴情報(DbT4121ShinseiRirekiJoho 申請履歴情報) {
        if (!申請履歴情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4121Dac.save(申請履歴情報.toEntity());
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 申請履歴情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean delete申請履歴情報(DbT4121ShinseiRirekiJoho 申請履歴情報) {
        return 1 == dbt4121Dac.deletePhysical(申請履歴情報.toEntity());
    }

    /**
     * 要介護認定計画情報{@link DbT4123NinteiKeikakuJoho}を保存します。
     *
     * @param 要介護認定計画情報 {@link DbT4123NinteiKeikakuJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定計画情報(DbT4123NinteiKeikakuJoho 要介護認定計画情報) {
        if (!要介護認定計画情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4123Dac.save(要介護認定計画情報.toEntity());
    }

    /**
     * 認定調査依頼情報{@link DbT4201NinteichosaIraiJoho}を保存します。
     *
     * @param 認定調査依頼情報 {@link DbT4201NinteichosaIraiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査依頼情報(DbT4201NinteichosaIraiJoho 認定調査依頼情報) {
        if (!認定調査依頼情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4201Dac.save(認定調査依頼情報.toEntity());
    }

    /**
     * 認定調査票_概況調査{@link DbT4202NinteichosahyoGaikyoChosa}を保存します。
     *
     * @param 認定調査票_概況調査 {@link DbT4202NinteichosahyoGaikyoChosa}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査(DbT4202NinteichosahyoGaikyoChosa 認定調査票_概況調査) {
        if (!認定調査票_概況調査.hasChanged()) {
            return false;
        }
        return 1 == dbt4202Dac.save(認定調査票_概況調査.toEntity());
    }

    /**
     * 主治医意見書作成依頼情報{@link DbT4301ShujiiIkenshoIraiJoho}を保存します。
     *
     * @param 主治医意見書作成依頼情報 {@link DbT4301ShujiiIkenshoIraiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save主治医意見書作成依頼情報(DbT4301ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報) {
        if (!主治医意見書作成依頼情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4301Dac.save(主治医意見書作成依頼情報.toEntity());
    }

    /**
     * 要介護認定主治医意見書情報{@link DbT4302ShujiiIkenshoJoho}を保存します。
     *
     * @param 要介護認定主治医意見書情報 {@link DbT4302ShujiiIkenshoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定主治医意見書情報(DbT4302ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        if (!要介護認定主治医意見書情報.hasChanged()) {
            return false;
        }
        return 1 == dbt4302Dac.save(要介護認定主治医意見書情報.toEntity());
    }
}
