/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshintaisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.koshintaisho.KoshinTaishoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.koshintaisho.SelectSyuuShadeTaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBD5010001_完了処理・更新管理のMapperです。
 *
 * @reamsid_L DBD-2030-010 x_youyj
 */
public interface IKoshinTaishoMapper {

    /**
     * 調査データ（モバイル用）の抽出
     *
     * @param parameter KoshinTaishoMybatisParameter
     * @return List<selectSyuuShadeTaEntity>
     */
    List<SelectSyuuShadeTaEntity> get調査データの取得(KoshinTaishoMybatisParameter parameter);

    /**
     * 認定調査依頼情報の取得
     *
     * @param shinseishoKanriNo RString
     * @return DbT4201NinteichosaIraiJohoEntity
     */
    DbT4201NinteichosaIraiJohoEntity get認定調査依頼情報の取得(RString shinseishoKanriNo);

    /**
     * 要介護認定申請情報の取得する
     *
     * @param shinseishoKanriNo RString
     * @return DbT4101NinteiShinseiJohoEntity
     */
    DbT4101NinteiShinseiJohoEntity get要介護認定申請情報の取得(RString shinseishoKanriNo);
}
