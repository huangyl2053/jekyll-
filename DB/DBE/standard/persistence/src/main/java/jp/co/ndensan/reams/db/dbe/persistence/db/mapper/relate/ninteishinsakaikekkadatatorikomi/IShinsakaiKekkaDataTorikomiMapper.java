/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinsakaikekkadatatorikomi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteishinsakaikekkadatatorikomi.ShinsakaiKekkaDataTorikomiMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomi.TmpNinteiShinsakaiWariateIinJohoItijiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsaIinRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinsakaikekkadatatorikomimobile.TempShinsakaiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;

/**
 * 介護認定審査会審査結果データ取込み（モバイル）インタフェースです
 *
 * @reamsid_L DBE-1841-020 xuyongchao
 */
public interface IShinsakaiKekkaDataTorikomiMapper {

    /**
     * 検索条件より、認定審査会割当委員情報を検索する。
     *
     * @return TmpNinteiShinsakaiWariateIinJohoItijiEntity 検索結果の{@link TmpNinteiShinsakaiWariateIinJohoItijiEntity}
     */
    List<TempShinsaIinRelateEntity> getShinsakaiWariateIinJoho();

    /**
     * 検索条件より、認定審査会割当委員情報を検索する。
     *
     * @return TempShinsakaiKekkaEntity 検索結果の{@link TempShinsakaiKekkaEntity}
     */
    List<TempShinsakaiKekkaEntity> getNijiHanteikekkaTourokuJoho();

    /**
     * 審査会情報一時テーブルを検索する。
     *
     * @return TempShinsakaiJohoEntity 検索結果の{@link TempShinsakaiJohoEntity}
     */
    List<TempShinsakaiJohoEntity> getShinsakaiJohoTemp();

    /**
     * 検索条件より、要介護認定1.5次判定結果情報を検索する。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5510IchiGojiHanteiKekkaJohoEntity
     */
    DbT5510IchiGojiHanteiKekkaJohoEntity getIchiGojiHanteiKekka(ShinseishoKanriNo 申請書管理番号);

    /**
     * 検索条件より、介護認定審査会割当委員情報を検索する。
     *
     * @param param ShinsakaiKekkaDataTorikomiMybatisParameter
     * @return DbT5503ShinsakaiWariateIinJohoEntity
     */
    DbT5503ShinsakaiWariateIinJohoEntity getShinsakaiWariateIin(ShinsakaiKekkaDataTorikomiMybatisParameter param);

    /**
     * 検索条件より、要介護認定結果情報を検索する。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5102NinteiKekkaJohoEntity
     */
    DbT5102NinteiKekkaJohoEntity getNinteiKekkan(ShinseishoKanriNo 申請書管理番号);

    /**
     * 検索条件より、要介護認定完了情報を検索する。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT5105NinteiKanryoJohoEntity
     */
    DbT5105NinteiKanryoJohoEntity getNinteiKanryo(ShinseishoKanriNo 申請書管理番号);

    /**
     * 検索条件より、要介護認定結果情報を検索する。
     *
     * @param param ShinsakaiKekkaDataTorikomiMybatisParameter
     * @return DbT5502ShinsakaiWariateJohoEntity
     */
    DbT5502ShinsakaiWariateJohoEntity getShinsakaiWariateJoho(ShinsakaiKekkaDataTorikomiMybatisParameter param);

    /**
     * 検索条件より、審査会情報を検索する。
     *
     * @param param ShinsakaiKekkaDataTorikomiMybatisParameter
     * @return DbT5511ShinsakaiKaisaiKekkaJohoEntity
     */
    DbT5511ShinsakaiKaisaiKekkaJohoEntity getShinsakaiJoho(ShinsakaiKekkaDataTorikomiMybatisParameter param);
}
