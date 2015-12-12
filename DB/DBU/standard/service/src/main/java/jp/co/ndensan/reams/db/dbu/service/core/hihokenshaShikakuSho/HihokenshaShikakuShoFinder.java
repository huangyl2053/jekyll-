/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.hihokenshaShikakuSho;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.core.hihokenshashikakushodata.HihokenshaShikakuShoDataParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.hihokenshashikakushodataentity.HihokenshaShikakuShoDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

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
     * 資格者証発行画面データ取得です。
     *
     * @param hihokenshaShikakuShoDataParameter
     * @return HihokenshaShikakuShoDataEntity INSERT用データEntity
     */
    public HihokenshaShikakuShoDataEntity insertShoKofuKaishu(HihokenshaShikakuShoDataParameter hihokenshaShikakuShoDataParameter) {
        HihokenshaShikakuShoDataEntity hihokenshaShikakuShoDataEntity = insert用データEntity(hihokenshaShikakuShoDataParameter);
        if (hihokenshaShikakuShoDataEntity == null) {
            return null;
        }
        return hihokenshaShikakuShoDataEntity;
    }

    private HihokenshaShikakuShoDataEntity insert用データEntity(HihokenshaShikakuShoDataParameter hihokenshaShikakuShoDataParameter) {
        HihokenshaShikakuShoDataEntity hihokenshaShikakuShoDataEntity = new HihokenshaShikakuShoDataEntity();
        hihokenshaShikakuShoDataEntity.setHihokenshaNo(hihokenshaShikakuShoDataParameter.getHihokenshaNo());
        if (hihokenshaShikakuShoDataParameter.getMenuId().equals(new RString("DBUMN120001"))) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(new RString("0001"));
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(FlexibleDate.EMPTY);
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(new RString("01"));
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(new RString("02"));
        }
        if (hihokenshaShikakuShoDataParameter.getMenuId().equals(new RString("DBUMN120002"))) {
            hihokenshaShikakuShoDataEntity.setKofuShoShurui(new RString("0002"));
            hihokenshaShikakuShoDataEntity.setYukoKigenYMD(hihokenshaShikakuShoDataParameter.getYukoKigenYMD());
            hihokenshaShikakuShoDataEntity.setShinYoshikiSumiKubunCode(RString.EMPTY);
            hihokenshaShikakuShoDataEntity.setShoYoshikiKubunCode(RString.EMPTY);
        }
        List<DbT7037ShoKofuKaishuEntity> rirekiNo = dbT7037ShoKofuKaishuDac.getRirekiNo(hihokenshaShikakuShoDataParameter.getHihokenshaNo());
        if (rirekiNo == null || rirekiNo.isEmpty()) {
            hihokenshaShikakuShoDataEntity.setRirekiNo(1);
        } else {
            hihokenshaShikakuShoDataEntity.setRirekiNo(rirekiNo.get(0).getRirekiNo() + 1);
        }
        hihokenshaShikakuShoDataEntity.setShikibetsuCode(hihokenshaShikakuShoDataParameter.getShikibetsuCode());
        hihokenshaShikakuShoDataEntity.setKofuYMD(hihokenshaShikakuShoDataParameter.getKofuYMD());
        hihokenshaShikakuShoDataEntity.setKofuJiyu(hihokenshaShikakuShoDataParameter.getKofuJiyu());
        hihokenshaShikakuShoDataEntity.setKofuRiyu(hihokenshaShikakuShoDataParameter.getKofuRiyu());
        hihokenshaShikakuShoDataEntity.setKaishuYMD(FlexibleDate.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuJiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setKaishuRiyu(RString.EMPTY);
        hihokenshaShikakuShoDataEntity.setTanpyoHakkoUmuFlag(true);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        if (DonyukeitaiCode.事務広域.getコード().equals(導入形態コード.getKey()) || DonyukeitaiCode.事務構成市町村.getコード().
                equals(導入形態コード.getKey()) || DonyukeitaiCode.認定広域.getコード().equals(導入形態コード.getKey())) {
            DbT7051KoseiShichosonMasterEntity 市町村コード = dbT7051KoseiShichosonMasterDac.
                    shichosonCode(hihokenshaShikakuShoDataParameter.getShoKisaiHokenshaNo());
            hihokenshaShikakuShoDataEntity.setShichosonCode(市町村コード.getShichosonCode());
        } else if (DonyukeitaiCode.事務単一.getコード().equals(導入形態コード.getKey())
                || DonyukeitaiCode.認定単一.getコード().equals(導入形態コード.getKey())) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            hihokenshaShikakuShoDataEntity.setShichosonCode(association.get地方公共団体コード());
        }
        hihokenshaShikakuShoDataEntity.setHakkoShoriTimestamp(new YMDHMS(RDateTime.now()));
        hihokenshaShikakuShoDataEntity.setLogicalDeletedFlag(false);
        return hihokenshaShikakuShoDataEntity;
    }
}
