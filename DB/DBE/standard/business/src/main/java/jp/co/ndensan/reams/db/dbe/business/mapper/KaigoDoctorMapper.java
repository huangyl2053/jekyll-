/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.mapper;

import jp.co.ndensan.reams.db.dbe.business.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.entity.relate.KaigoDoctorEntity;
import jp.co.ndensan.reams.ur.urz.entity.mapper.DoctorMapper;

/**
 * 介護医師情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class KaigoDoctorMapper {

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private KaigoDoctorMapper() {
    }

    /**
     * 介護医師情報エンティティ、介護医療機関情報を介護医師情報に変換して返します。
     *
     * @param kaigoDoctorEntity 介護医師情報エンティティ
     * @param kaigoIryoKikan 介護医療機関情報
     * @return 介護医師情報
     */
    public static KaigoDoctor toKaigoDoctor(KaigoDoctorEntity kaigoDoctorEntity, KaigoIryoKikan kaigoIryoKikan) {
        return new KaigoDoctor(
                DoctorMapper.toDoctor(kaigoDoctorEntity.getDoctorEntity()),
                ShujiiMapper.toShujii(kaigoDoctorEntity.getDbT7012ShujiiJohoEntity()),
                kaigoIryoKikan);
    }
}
