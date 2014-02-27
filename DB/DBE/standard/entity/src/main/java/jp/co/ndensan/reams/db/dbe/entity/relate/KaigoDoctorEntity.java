/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7012ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.entity.DoctorEntity;

/**
 * 介護医師のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class KaigoDoctorEntity {

    private DbT7012ShujiiJohoEntity dbT7012ShujiiJohoEntity = null;
    private DoctorEntity doctorEntity = null;

    /**
     * インスタンスを生成します。
     */
    public KaigoDoctorEntity() {
    }

    /**
     * 主治医情報エンティティを取得します。
     *
     * @return 主治医情報エンティティ
     */
    public DbT7012ShujiiJohoEntity getDbT7012ShujiiJohoEntity() {
        return dbT7012ShujiiJohoEntity;
    }

    /**
     * 主治医情報エンティティを設定します。
     *
     * @param entity 主治医情報エンティティ
     */
    public void setDbT7012ShujiiJohoEntity(DbT7012ShujiiJohoEntity entity) {
        this.dbT7012ShujiiJohoEntity = entity;
    }

    /**
     * 医師情報エンティティを取得します。
     *
     * @return 医師情報エンティティ
     */
    public DoctorEntity getDoctorEntity() {
        return doctorEntity;
    }

    /**
     * 医師情報エンティティを設定します。
     *
     * @param entity 医師情報エンティティ
     */
    public void setDoctorEntity(DoctorEntity entity) {
        this.doctorEntity = entity;
    }
}
