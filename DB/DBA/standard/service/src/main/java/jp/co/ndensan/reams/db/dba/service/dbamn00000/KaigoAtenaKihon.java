/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.dbamn00000;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.dbamn00000.KaigoAtenaKihonBusiness;
import jp.co.ndensan.reams.db.dba.entity.dbamn00000.KaigoAtenaKihonEntity;
import jp.co.ndensan.reams.db.dba.persistence.dbamn00000.IKaigoAtenaKihonMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護宛名基本情報を取得するクラスです。
 *
 */
public class KaigoAtenaKihon {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KaigoAtenaKihon() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 介護資格系基本情報取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return KaigoAtenaKihonBusiness リスト
     */
    public List<KaigoAtenaKihonBusiness> getKaigoShikakuKihon(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        IKaigoAtenaKihonMapper mapper = mapperProvider.create(IKaigoAtenaKihonMapper.class);
        List<KaigoAtenaKihonEntity> kaigoAtenaKihonList = mapper.selectKaigoShikakuKihonByShikibetsuCode(識別コード);
        if (kaigoAtenaKihonList == null || kaigoAtenaKihonList.isEmpty()) {
            throw new RuntimeException();
        }
        HihokenshaNo hihokenshaNo = HihokenshaNo.EMPTY;
        List<KaigoAtenaKihonBusiness> business = new ArrayList<>();
        for (KaigoAtenaKihonEntity entity : kaigoAtenaKihonList) {
            if (hihokenshaNo.equals(entity.getHihokenshaNo())) {
                continue;
            }
            business.add(new KaigoAtenaKihonBusiness(entity));
            hihokenshaNo = entity.getHihokenshaNo();
        }
        return business;
    }
}
