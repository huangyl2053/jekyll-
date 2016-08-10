/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.jukyushaidochecklist;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5720001.JyukyushaDaichoIdoCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001.JyukyushaDaichoIdoCheckListEntity;

/**
 * バッチ設計_受給者台帳異動チェックリストのMapperです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public interface IJukyushaIdoCheckListMapper {

    /**
     * 帳票出力対象データ取得のselect処理です。
     *
     * @param parameter JyukyushaDaichoIdoCheckListMybatisParameter
     * @return 帳票出力対象データlist
     */
    List<JyukyushaDaichoIdoCheckListEntity> get帳票出力対象データ(JyukyushaDaichoIdoCheckListMybatisParameter parameter);

}
