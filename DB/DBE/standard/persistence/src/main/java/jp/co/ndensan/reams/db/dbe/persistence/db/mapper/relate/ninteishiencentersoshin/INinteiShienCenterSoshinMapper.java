/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishiencentersoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteishiencentersoshin.NinteiShienCenterSoshinParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishiencentersoshin.NinteiShienCenterSoshinEntity;

/**
 * センター送信準備のMapperクラスです。
 *
 * @reamsid_L DBE-1520-011 lishengli
 */
public interface INinteiShienCenterSoshinMapper {

    /**
     * 対象者一覧情報の取得する。
     *
     * @param parameter センター送信準備のParameter
     * @return List<NinteiShienCenterSoshinEntity>
     */
    List<NinteiShienCenterSoshinEntity> get対象者一覧情報(NinteiShienCenterSoshinParameter parameter);
}
