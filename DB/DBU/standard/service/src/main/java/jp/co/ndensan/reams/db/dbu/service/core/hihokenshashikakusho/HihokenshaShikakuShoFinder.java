/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashikakusho;

import jp.co.ndensan.reams.db.dba.definition.core.kofusho.KofushoShurui;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashikakushodata.HihokenshaShikakuShoDataParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.hihokenshashikakushodataentity.HihokenshaShikakuShoDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoYoshikiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者証・資格者証データ取得するクラスです。
 *
 * @reamsid_L DBU-0490-020 zhangzhiming
 */
public class HihokenshaShikakuShoFinder {

    private final DbT7037ShoKofuKaishuDac dbT7037ShoKofuKaishuDac;
    private final DbT7051KoseiShichosonMasterDac dbT7051KoseiShichosonMasterDac;
    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");

    /**
     * コンストラクタ。
     *
     */
    public HihokenshaShikakuShoFinder() {

        this.dbT7037ShoKofuKaishuDac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
        this.dbT7051KoseiShichosonMasterDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbT7037ShoKofuKaishuDac DbT7037ShoKofuKaishuDac
     * @param dbT7051KoseiShichosonMasterDac DbT7051KoseiShichosonMasterDac
     */
    HihokenshaShikakuShoFinder(DbT7037ShoKofuKaishuDac dbT7037ShoKofuKaishuDac,
            DbT7051KoseiShichosonMasterDac dbT7051KoseiShichosonMasterDac) {
        this.dbT7037ShoKofuKaishuDac = dbT7037ShoKofuKaishuDac;
        this.dbT7051KoseiShichosonMasterDac = dbT7051KoseiShichosonMasterDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShoFinder}のインスタンス
     */
    public static HihokenshaShikakuShoFinder createInstance() {
        return InstanceProvider.create(HihokenshaShikakuShoFinder.class);
    }

    /**
     * 資格者証発行画面データ取得です。
     *
     * @param hihokenshaShikakuParameter HihokenshaShikakuShoDataParameter
     * @return HihokenshaShikakuShoDataEntity insert用データEntity
     */
    @Transaction
    public HihokenshaShikakuShoDataEntity insertShoKofuKaishu(HihokenshaShikakuShoDataParameter hihokenshaShikakuParameter) {
        return insert用データEntity(hihokenshaShikakuParameter);
    }

    /**
     * 証交付回収データinsert処理です。
     *
     * @param entity HihokenshaShikakuShoDataEntity
     * @return int
     */
    @Transaction
    public int insert(HihokenshaShikakuShoDataEntity entity) {
        DbT7037ShoKofuKaishuEntity dbt7037Entity = new DbT7037ShoKofuKaishuEntity();
        dbt7037Entity.setHihokenshaNo(entity.getHihokenshaNo());
        dbt7037Entity.setKofuShoShurui(entity.getKofuShoShurui());
        dbt7037Entity.setRirekiNo(entity.getRirekiNo());
        dbt7037Entity.setShichosonCode(entity.getShichosonCode());
        dbt7037Entity.setShikibetsuCode(entity.getShikibetsuCode());
        dbt7037Entity.setKofuYMD(entity.getKofuYMD());
        dbt7037Entity.setYukoKigenYMD(entity.getYukoKigenYMD());
        dbt7037Entity.setKofuJiyu(entity.getKofuJiyu());
        dbt7037Entity.setKofuRiyu(entity.getKofuRiyu());
        dbt7037Entity.setKaishuYMD(entity.getKaishuYMD());
        dbt7037Entity.setKaishuJiyu(entity.getKaishuJiyu());
        dbt7037Entity.setKaishuRiyu(entity.getKaishuRiyu());
        dbt7037Entity.setTanpyoHakkoUmuFlag(entity.isTanpyoHakkoUmuFlag());
        dbt7037Entity.setHakkoShoriTimestamp(entity.getHakkoShoriTimestamp());
        dbt7037Entity.setShinYoshikiSumiKubunCode(entity.getShinYoshikiSumiKubunCode());
        dbt7037Entity.setShoYoshikiKubunCode(entity.getShoYoshikiKubunCode());
        dbt7037Entity.setLogicalDeletedFlag(entity.isLogicalDeletedFlag());
        return dbT7037ShoKofuKaishuDac.save(dbt7037Entity);
    }

    private HihokenshaShikakuShoDataEntity insert用データEntity(HihokenshaShikakuShoDataParameter hihokenshaShikakuParameter) {
        HihokenshaShikakuShoDataEntity hihokenshaShikakuShoDataEntity = new HihokenshaShikakuShoDataEntity();
        hihokenshaShikakuShoDataEntity.setHihokenshaNo(hihokenshaShikakuParameter.getHihokenshaNo());
        if (hihokenshaShikakuParameter.getMenuId().equals(MENUID_DBUMN12001)) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(KofushoShurui.被保険者証.getコード());
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(FlexibleDate.EMPTY);
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(ShoYoshikiKubun.新様式.getコード());
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(ShoYoshikiKubun.新様式２.getコード());
        }
        if (hihokenshaShikakuParameter.getMenuId().equals(MENUID_DBUMN12002)) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(KofushoShurui.資格者証.getコード());
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(hihokenshaShikakuParameter.getYukoKigenYMD());
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(RString.EMPTY);
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(RString.EMPTY);
        }
        DbT7037ShoKofuKaishuEntity entity = dbT7037ShoKofuKaishuDac.getRirekiNo(hihokenshaShikakuParameter.getHihokenshaNo());
        if (entity == null) {
            hihokenshaShikakuShoDataEntity.setRirekiNo(1);
        } else {
            hihokenshaShikakuShoDataEntity.setRirekiNo(entity.getRirekiNo() + 1);
        }
        hihokenshaShikakuShoDataEntity.setShikibetsuCode(hihokenshaShikakuParameter.getShikibetsuCode());
        hihokenshaShikakuShoDataEntity.setKofuYMD(hihokenshaShikakuParameter.getKofuYMD());
        hihokenshaShikakuShoDataEntity.setKofuJiyu(hihokenshaShikakuParameter.getKofuJiyu());
        hihokenshaShikakuShoDataEntity.setKofuRiyu(hihokenshaShikakuParameter.getKofuRiyu());
        hihokenshaShikakuShoDataEntity.setKaishuYMD(FlexibleDate.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuJiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuRiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setTanpyoHakkoUmuFlag(true);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey()) || DonyuKeitaiCode.事務構成市町村.getCode().
                equals(導入形態コード.getKey()) || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.getKey())) {
            DbT7051KoseiShichosonMasterEntity 市町村コード = dbT7051KoseiShichosonMasterDac.
                    shichosonCode(hihokenshaShikakuParameter.getShoKisaiHokenshaNo());
            if (市町村コード != null) {
                hihokenshaShikakuShoDataEntity.setShichosonCode(市町村コード.getShichosonCode());
            } else {
                hihokenshaShikakuShoDataEntity.setShichosonCode(LasdecCode.EMPTY);
            }
        } else if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getKey())
                || DonyuKeitaiCode.認定単一.getCode().equals(導入形態コード.getKey())) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            hihokenshaShikakuShoDataEntity.setShichosonCode(association.get地方公共団体コード());
        }
        hihokenshaShikakuShoDataEntity.setHakkoShoriTimestamp(new YMDHMS(RDateTime.now()));
        hihokenshaShikakuShoDataEntity.setLogicalDeletedFlag(false);
        return hihokenshaShikakuShoDataEntity;
    }
}
