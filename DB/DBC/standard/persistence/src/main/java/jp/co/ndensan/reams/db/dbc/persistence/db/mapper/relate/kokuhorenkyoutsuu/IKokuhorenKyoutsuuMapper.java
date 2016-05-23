/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kokuhorenkyoutsuu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kokuhorenkyoutsuu.KokuhorenInterfaceUpdateMybaticParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyoutsuu.SyoriKekkaListItijiEntity;

/**
 * 国保連情報取込処理共通のMapperです<br>
 * 国保連インタフェース管理TBLを更新します。
 *
 * @reamsid_L DBC-0980-550 zhangrui
 */
public interface IKokuhorenKyoutsuuMapper {

    /**
     * selectbyKeyUndeleted
     *
     * @param parameter keyのパラメーター
     * @return List<DbT3104KokuhorenInterfaceKanriEntity>
     */
    List<DbT3104KokuhorenInterfaceKanriEntity> selectbyKeyUndeleted(KokuhorenInterfaceUpdateMybaticParameter parameter);

    /**
     * 処理結果リスト一時TBLを作成する。
     */
    void create処理結果リスト一時TBL();

    /**
     * 処理結果リスト一時テーブルの登録処理
     *
     * @param entity 処理結果リスト一時テーブルEntity
     */
    void insert処理結果リスト一時TBL(SyoriKekkaListItijiEntity entity);

    /**
     * 処理結果リスト一時TBLを取得する。
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    List<SyoriKekkaListItijiEntity> select処理結果リスト一時TBL();

    /**
     * 一意の処理結果リストを取得する。
     *
     * @return 処理結果リスト一時TBLのエンティティ
     */
    SyoriKekkaListItijiEntity select処理結果リストUNIQUE();
}
