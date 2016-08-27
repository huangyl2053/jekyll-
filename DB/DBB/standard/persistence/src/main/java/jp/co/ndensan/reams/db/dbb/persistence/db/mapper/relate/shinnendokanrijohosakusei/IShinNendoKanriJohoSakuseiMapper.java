/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.shinnendokanrijohosakusei;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shinnendokanrijohosakusei.ShinNendoKanriJohoSakuseiEntity;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
public interface IShinNendoKanriJohoSakuseiMapper {

    /**
     * selectカスタムコンフィグByKey取得する。
     *
     * @param paramter HashMap<String, Object>
     * @return List<ShinNendoKanriJohoSakuseiEntity>
     */
    List<ShinNendoKanriJohoSakuseiEntity> selectカスタムコンフィグByKey(HashMap<String, Object> paramter);

    /**
     * insertカスタムコンフィグByKeyする。
     *
     * @param entity ShinNendoKanriJohoSakuseiEntity
     */
    void insertカスタムコンフィグByKey(ShinNendoKanriJohoSakuseiEntity entity);
}
