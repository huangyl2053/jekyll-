/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hanteikekkajouhoushuturyoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuRelateEntity;

/**
 * 判定結果情報出力（保険者）のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0190-010 lizhuoxuan
 */
public interface IHanteiKekkaJouhouShuturyokuMapper {

    /**
     * 判定結果情報のリストを取得します。
     *
     * @param 判定結果情報出力_保険者情報検索条件 判定結果情報出力_保険者情報検索条件
     * @return HanteiKekkaJouhouShuturyokuRelateEntity
     */
    List<HanteiKekkaJouhouShuturyokuRelateEntity> getNinteiChousaSukeList(HanteiKekkaJouhouShuturyokuParameter 判定結果情報出力_保険者情報検索条件);

    /**
     * 判定結果情報の該当件数を取得します。
     *
     * @param 判定結果情報出力_保険者情報検索条件 判定結果情報出力_保険者情報検索条件
     * @return 該当件数
     */
    int countNinteiChousaSukeList(HanteiKekkaJouhouShuturyokuParameter 判定結果情報出力_保険者情報検索条件);
}
