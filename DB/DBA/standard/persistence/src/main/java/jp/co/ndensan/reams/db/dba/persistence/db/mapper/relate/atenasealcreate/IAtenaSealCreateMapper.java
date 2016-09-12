/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.atenasealcreate.AtenaSealCreateMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.AtenaSealCreateRelateEntity;

/**
 * 宛名シール作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public interface IAtenaSealCreateMapper {

    /**
     * 年齢到達予定者選択したの場合、データを取得します。
     *
     * @param parameter AtenaSealCreateShitaMybatisParameter
     * @return List<AtenaSealCreateRelateEntity>
     */
    List<AtenaSealCreateRelateEntity> getTekiyoKaisha(AtenaSealCreateMybatisParameter parameter);

    /**
     * 取込件数確認します。
     *
     * @return int
     */
    int getIttoki();

    /**
     * 年齢到達予定者選択しないの場合、データを取得します。
     *
     * @param parameter AtenaSealCreateShitaMybatisParameter
     * @return List<AtenaSealCreateRelateEntity>
     */
    List<AtenaSealCreateRelateEntity> getHihokenshadai(AtenaSealCreateMybatisParameter parameter);

}
