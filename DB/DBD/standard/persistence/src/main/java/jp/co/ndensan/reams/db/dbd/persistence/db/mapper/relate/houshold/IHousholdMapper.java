/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.houshold;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.houshold.HousholdParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold.HousholdEntity;

/**
 * 非課税年金対象者情報登録 Mapperです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
public interface IHousholdMapper {

    /**
     * 引数により、非課税年金対象情報を取得します。
     *
     * @param parameter パラメータ
     * @return 申請一覧情報
     */
    List<HousholdEntity> 非課税年金対象情報取得(HousholdParameter parameter);

}
