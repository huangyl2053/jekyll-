/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosasche;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichousasukejuru.NinteiChousaSukejuruParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichousasukejuru.NinteiChousaSukejuruRelateEntity;

/**
 *
 * 認定調査スケジュール登録1のマッパーインタフェースです。
 */
public interface INinteichosaScheduleMapper {

    /**
     * 認定調査スケジュール登録1情報のリストを取得します。
     *
     * @param 認定調査スケジュール登録1情報検索条件 認定調査スケジュール登録1情報検索条件
     * @return NinteiChousaSukejuruRelateEntity
     */
    List<NinteiChousaSukejuruRelateEntity> getNinteiChousaSukeList(NinteiChousaSukejuruParameter 認定調査スケジュール登録1情報検索条件);
}
