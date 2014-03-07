/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.IShujii;
import jp.co.ndensan.reams.db.dbe.business.Shujii;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiJokyo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.business._IryoKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;

/**
 * 主治医情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class ShujiiMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private ShujiiMapper() {
    }

    /**
     * 主治医情報エンティティを主治医情報に変換して返します。
     *
     * @param entity 主治医情報エンティティ
     * @return 主治医情報
     */
    public static IShujii toShujii(DbT7012ShujiiJohoEntity entity) {
        return new Shujii(
                new ShichosonCode(entity.getShichosonCode()),
                entity.getKaigoIryokikanCode(),
                new KaigoDoctorCode(entity.getKaigoIshiCode()),
                new _IryoKikanCode(entity.getIryokikanCode()),
                entity.getShujiiCode(),
                IshiJokyo.toValue(entity.getShujiiJokyo()),
                entity.getYubinNo(),
                new AtenaJusho(entity.getJusho()),
                entity.getTelNo(),
                entity.getFaxNo());
    }

    /**
     * 主治医情報を主治医情報エンティティに変換して返します。
     *
     * @param shujii 主治医情報
     * @return 主治医情報エンティティ
     */
    public static DbT7012ShujiiJohoEntity toEntity(IShujii shujii) {
        DbT7012ShujiiJohoEntity entity = new DbT7012ShujiiJohoEntity();
        entity.setShichosonCode(shujii.get市町村コード().getValue());
        entity.setKaigoIryokikanCode(shujii.get介護医療機関コード());
        entity.setKaigoIshiCode(shujii.get介護医師コード().value());
        entity.setIryokikanCode(shujii.get医療機関コード().getValue());
        entity.setShujiiCode(shujii.get医師識別番号());
        entity.setShujiiJokyo(shujii.is有効());
        entity.setYubinNo(shujii.get郵便番号());
        entity.setJusho(shujii.get住所().value());
        entity.setTelNo(shujii.get電話番号());
        entity.setFaxNo(shujii.getFAX番号());
        return entity;
    }
}
