/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.chosakekkainfokihon;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosakekkainfokihon.ChosaKekkaInfoKihonParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.ChosaKekkaInfoKihonRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosakekkainfokihon.TokiJikouRelateEntity;

/**
 * 認定調査結果情報照会_基本調査のマッパーインタフェースです。
 *
 * @reamsid_L DBE-3000-270 lizhuoxuan
 */
public interface IChosaKekkaInfoKihonMapper {

    /**
     * 認定調査結果情報照会_基本調査のリストを取得します。
     *
     * @param 認定調査票_概況調査検索条件 認定調査票_概況調査検索条件
     * @return ChosaKekkaInfoKihonRelateEntity
     */
    List<ChosaKekkaInfoKihonRelateEntity> getChosaKekkaInfoKihonList1(ChosaKekkaInfoKihonParameter 認定調査票_概況調査検索条件);

    /**
     * 認定調査結果情報照会_基本調査のリストを取得します。
     *
     * @param 認定調査票_サービスの状況検索条件 認定調査票_サービスの状況検索条件
     * @return TokiJikouRelateEntity
     */
    List<TokiJikouRelateEntity> getChosaKekkaInfoKihonList2(ChosaKekkaInfoKihonParameter 認定調査票_サービスの状況検索条件);
}
