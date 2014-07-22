/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.mapper;

import jp.co.ndensan.reams.db.dbz.business.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;

/**
 * 連絡先情報ビジネスクラスとエンティティの変換を行うクラスです。
 *
 * @author n9606 漢那 憲作
 */
public final class RenrakusakiInfoMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private RenrakusakiInfoMapper() {
    }

    /**
     * 連絡先情報エンティティから連絡先情報への対応付けを行います。
     *
     * @param entity 連絡先情報Entity
     * @return 連絡先情報データ
     */
    public static RenrakusakiJoho toRenrakusakiInfo(
            DbT5050RenrakusakiJohoEntity entity) throws NullPointerException {

        return new RenrakusakiJoho(
                entity.getRenrakusakiShimei(),
                entity.getRenrakusakiKanaSimei(),
                entity.getRenrakusakiTelNo(),
                entity.getRenrakusakiKeitaiTelNo(),
                entity.getRenrakusakiYubinNo(),
                entity.getRenrakusakiJusho(),
                entity.getRenrakusakiTuzukigara(),
                entity.getRenrakusakiKubunNo(),
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo()
        );

    }

    /**
     * 連絡先情報を連絡先情報エンティティに変換します。
     *
     * @param renrakusakiJoho 連絡先情報
     * @return 連絡先情報エンティティ
     */
    public static DbT5050RenrakusakiJohoEntity toRenrakusakiJohoEntity(RenrakusakiJoho renrakusakiJoho) {

        DbT5050RenrakusakiJohoEntity entity = new DbT5050RenrakusakiJohoEntity();

        entity.setRenrakusakiShimei(renrakusakiJoho.get氏名());
        entity.setRenrakusakiKanaSimei(renrakusakiJoho.get氏名カナ());
        entity.setRenrakusakiTelNo(renrakusakiJoho.get電話番号());
        entity.setRenrakusakiKeitaiTelNo(renrakusakiJoho.get携帯番号());
        entity.setRenrakusakiYubinNo(renrakusakiJoho.get郵便番号());
        entity.setRenrakusakiJusho(renrakusakiJoho.get住所());
        entity.setRenrakusakiTuzukigara(renrakusakiJoho.get続柄());
        entity.setRenrakusakiKubunNo(renrakusakiJoho.get連絡先区分番号());
        entity.setShoKisaiHokenshaNo(renrakusakiJoho.get保険者番号());
        entity.setHihokenshaNo(renrakusakiJoho.get被保険者番号());

        return entity;
    }
}
