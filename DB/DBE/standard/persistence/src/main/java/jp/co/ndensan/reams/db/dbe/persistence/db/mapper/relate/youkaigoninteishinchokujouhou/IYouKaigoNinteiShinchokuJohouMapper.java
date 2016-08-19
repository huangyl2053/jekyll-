/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.youkaigoninteishinchokujouhou;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouRelateEntity;

/**
 * 要介護認定進捗情報データ出力の処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public interface IYouKaigoNinteiShinchokuJohouMapper {

    /**
     * 対象者一覧情報の取得します。
     *
     * @param param 要介護認定進捗情報データ出力を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定進捗情報データ出力RelateEntityクラスです。
     */
    List<YouKaigoNinteiShinchokuJohouRelateEntity> get結果情報(YouKaigoNinteiShinchokuJohouParameter param);

    /**
     * 対象者一覧画面情報区分取得します。
     *
     * @param param 要介護認定進捗情報データ出力を特定するためのMyBatis用パラメータクラスです。
     * @return YouKaiGoNinTeiKekTesuChiRelateEntity 要介護認定進捗情報データ出力RelateEntityクラスです。
     */
    List<YouKaigoNinteiShinchokuJohouRelateEntity> get進捗情報(YouKaigoNinteiShinchokuJohouParameter param);
}
