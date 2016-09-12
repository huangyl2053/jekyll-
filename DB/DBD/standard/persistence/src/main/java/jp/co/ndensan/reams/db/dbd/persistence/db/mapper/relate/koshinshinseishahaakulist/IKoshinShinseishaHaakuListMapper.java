/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshinshinseishahaakulist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5110001.KoshinShinseishaHaakuListMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001.PreviousInformationEntity;

/**
 * 更新未申請者把握リスト作成 Mapperです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
public interface IKoshinShinseishaHaakuListMapper {

    /**
     * 前回の情報を取得する。
     *
     * @param parameter パラメータ
     * @return 前回の情報
     */
    List<PreviousInformationEntity> get前回の情報(KoshinShinseishaHaakuListMyBatisParameter parameter);

}
