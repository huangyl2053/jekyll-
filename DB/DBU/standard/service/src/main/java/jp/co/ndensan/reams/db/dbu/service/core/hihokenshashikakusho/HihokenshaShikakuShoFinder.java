/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshashikakusho;

import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashikakushodata.HihokenshaShikakuShoDataParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.hihokenshashikakushodataentity.HihokenshaShikakuShoDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者証・資格者証データ取得するクラスです。
 */
public class HihokenshaShikakuShoFinder {

    private final DbT7037ShoKofuKaishuDac dbT7037ShoKofuKaishuDac;
    private final DbT7051KoseiShichosonMasterDac dbT7051KoseiShichosonMasterDac;

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
     * 資格者証発行画面データ取得です。
     *
     * @param dataParameter HihokenshaShikakuShoDataParameter
     * @return HihokenshaShikakuShoDataEntity insert用データEntity
     */
    @Transaction
    public HihokenshaShikakuShoDataEntity insertShoKofuKaishu(HihokenshaShikakuShoDataParameter dataParameter) {
        return insert用データEntity(dataParameter);
    }

    private HihokenshaShikakuShoDataEntity insert用データEntity(HihokenshaShikakuShoDataParameter shikakuShoDataParameter) {
        HihokenshaShikakuShoDataEntity hihokenshaShikakuShoDataEntity = new HihokenshaShikakuShoDataEntity();
        hihokenshaShikakuShoDataEntity.setHihokenshaNo(shikakuShoDataParameter.getHihokenshaNo());
        if (shikakuShoDataParameter.getMenuId().equals(new RString("DBUMN120001"))) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(new RString("0001"));
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(FlexibleDate.EMPTY);
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(new RString("01"));
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(new RString("02"));
        }
        if (shikakuShoDataParameter.getMenuId().equals(new RString("DBUMN120002"))) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(new RString("0002"));
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(shikakuShoDataParameter.getYukoKigenYMD());
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(RString.EMPTY);
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(RString.EMPTY);
        }
        DbT7037ShoKofuKaishuEntity entity = dbT7037ShoKofuKaishuDac.getRirekiNo(shikakuShoDataParameter.getHihokenshaNo());
        if (entity == null) {
            hihokenshaShikakuShoDataEntity.setRirekiNo(1);
        } else {
            hihokenshaShikakuShoDataEntity.setRirekiNo(entity.getRirekiNo() + 1);
        }
        hihokenshaShikakuShoDataEntity.setShikibetsuCode(shikakuShoDataParameter.getShikibetsuCode());
        hihokenshaShikakuShoDataEntity.setKofuYMD(shikakuShoDataParameter.getKofuYMD());
        hihokenshaShikakuShoDataEntity.setKofuJiyu(shikakuShoDataParameter.getKofuJiyu());
        hihokenshaShikakuShoDataEntity.setKofuRiyu(shikakuShoDataParameter.getKofuRiyu());
        hihokenshaShikakuShoDataEntity.setKaishuYMD(FlexibleDate.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuJiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuRiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setTanpyoHakkoUmuFlag(true);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey()) || DonyuKeitaiCode.事務構成市町村.getCode().
                equals(導入形態コード.getKey()) || DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード.getKey())) {
            DbT7051KoseiShichosonMasterEntity 市町村コード = dbT7051KoseiShichosonMasterDac.
                    selectByKey(shikakuShoDataParameter.getShoKisaiHokenshaNo().value());
            hihokenshaShikakuShoDataEntity.setShichosonCode(市町村コード.getShichosonCode());
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
