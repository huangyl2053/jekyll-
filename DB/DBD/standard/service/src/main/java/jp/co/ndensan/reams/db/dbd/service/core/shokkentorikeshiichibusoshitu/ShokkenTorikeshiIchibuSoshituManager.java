/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shokkentorikeshiichibusoshitu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiBusiness;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shokkentorikeshiichibusoshitu.ShokkenTorikeshiNinteiJohoKonkaiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shokkentorikeshiichibusoshitu.IShokkenTorikeshiIchibuSoshituMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4102NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5150RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5150RenrakusakiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 職権修正／職権取消(一部)／認定結果入力(サ変・区変)のManagerです。
 *
 * @reamsid_L DBD-1320-010 zuotao
 */
public class ShokkenTorikeshiIchibuSoshituManager {

    private final MapperProvider mapperProvider;
    private final DbV4001JukyushaDaichoAliveDac dbV4001Dac;
    private final DbT5150RenrakusakiJohoDac 連絡先Dac;
    private final DbT4101NinteiShinseiJohoDac 介護認定申請情報Dac;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT4102NinteiKekkaJohoDac 認定結果情報Dac;

    /**
     * コンストラクタです。
     */
    public ShokkenTorikeshiIchibuSoshituManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbV4001Dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
        this.連絡先Dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
        this.介護認定申請情報Dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.認定結果情報Dac = InstanceProvider.create(DbT4102NinteiKekkaJohoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokkenTorikeshiIchibuSoshituManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShokkenTorikeshiIchibuSoshituManager}のインスタンス
     */
    public static ShokkenTorikeshiIchibuSoshituManager createInstance() {
        return InstanceProvider.create(ShokkenTorikeshiIchibuSoshituManager.class);
    }

    /**
     * 今回情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 今回情報
     */
    @Transaction
    public SearchResult<ShokkenTorikeshiNinteiJohoKonkaiBusiness> select今回情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        IShokkenTorikeshiIchibuSoshituMapper mapper = mapperProvider.create(IShokkenTorikeshiIchibuSoshituMapper.class);
        List<ShokkenTorikeshiNinteiJohoKonkaiEntity> list = mapper.select今回情報(申請書管理番号);
        if (list.isEmpty()) {
            return SearchResult.of(Collections.<ShokkenTorikeshiNinteiJohoBusiness>emptyList(), 0, false);
        }
        List<ShokkenTorikeshiNinteiJohoKonkaiBusiness> businessList = new ArrayList<>();
        for (ShokkenTorikeshiNinteiJohoKonkaiEntity entity : list) {
            businessList.add(ShokkenTorikeshiNinteiJohoKonkaiBusiness.createBusiness(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 前回情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 前回情報
     */
    @Transaction
    public ShokkenTorikeshiNinteiJohoKonkaiBusiness select前回情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        IShokkenTorikeshiIchibuSoshituMapper mapper = mapperProvider.create(IShokkenTorikeshiIchibuSoshituMapper.class);
        ShokkenTorikeshiNinteiJohoKonkaiEntity entity = mapper.select前回情報(申請書管理番号);
        if (entity == null) {
            return null;
        }
        return ShokkenTorikeshiNinteiJohoKonkaiBusiness.createBusiness(entity);
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請書管理番号
     */
    @Transaction
    public ShinseishoKanriNo select申請書管理番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbV4001JukyushaDaichoEntity entity = dbV4001Dac.select申請書管理番号(被保険者番号);
        if (entity == null) {
            return ShinseishoKanriNo.EMPTY;
        }
        return entity.getShinseishoKanriNo();
    }

    /**
     * 連絡先情報を返す。
     *
     * @param 申請書管理番号 申請書管理番号
     *
     * @return 連絡先情報 List<RenrakusakiJoho>
     */
    @Transaction
    public List<RenrakusakiJoho> get連絡先情報(RString 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        List<DbT5150RenrakusakiJohoEntity> 連絡先List = 連絡先Dac.getShinsakaiNinteiShinseiJoho(new ShinseishoKanriNo(申請書管理番号));
        List<RenrakusakiJoho> resultList = new ArrayList<>();
        for (DbT5150RenrakusakiJohoEntity entity : 連絡先List) {
            entity.initializeMd5();
            resultList.add(new RenrakusakiJoho(entity));
        }
        return resultList;
    }

    /**
     * 介護認定申請情報を更新します。
     *
     * @param 介護認定申請情報 介護認定申請情報
     * @param state 更新状態
     *
     * @return 更新件数
     */
    @Transaction
    public int save介護認定申請情報(DbT4101NinteiShinseiJoho 介護認定申請情報, EntityDataState state) {
        DbT4101NinteiShinseiJohoEntity entity = 介護認定申請情報.toEntity();
        entity.setState(state);
        return 介護認定申請情報Dac.save(entity);
    }

    /**
     * 受給者台帳を更新します。
     *
     * @param 受給者台帳 受給者台帳
     * @param state 更新状態
     *
     * @return 更新件数
     */
    @Transaction
    public int save受給者台帳(JukyushaDaicho 受給者台帳, EntityDataState state) {
        DbT4001JukyushaDaichoEntity entity = 受給者台帳.toEntity();
        entity.setState(state);
        return 受給者台帳Dac.save(entity);
    }

    /**
     * 認定結果情報を更新します。
     *
     * @param 認定結果情報 認定結果情報
     * @param state 更新状態
     *
     * @return 更新件数
     */
    @Transaction
    public int save認定結果情報(DbT4102NinteiKekkaJoho 認定結果情報, EntityDataState state) {
        DbT4102NinteiKekkaJohoEntity entity = 認定結果情報.toEntity();
        entity.setState(state);
        return 認定結果情報Dac.save(entity);
    }
}
