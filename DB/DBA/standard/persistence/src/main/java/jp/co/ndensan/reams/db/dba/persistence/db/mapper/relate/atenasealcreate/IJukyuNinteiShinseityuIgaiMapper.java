/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.atenasealcreate;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.db.relate.atenasealcreate.JukyuNinteiShinseityuIgaiEntity;

/**
 * 宛名シール作成のマッパーインタフェースです。
 *
 * @reamsid_L DBA-1210-030 zhengsongling
 */
public interface IJukyuNinteiShinseityuIgaiMapper {

    /**
     * 抽出対象者が資格取得者＋年齢到達予定者または抽出対象者に受給認定申請中を除くの場合、データを取得します。
     *
     * @return List<JukyuNinteiShinseityuIgaiEntity>
     */
    List<JukyuNinteiShinseityuIgaiEntity> getList();
}
