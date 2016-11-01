/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ichijihanteizumidatashutsuryoku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuMybitisParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteizumidatashutsuryoku.IchijiHanteizumiDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * 一次判定データ出力RelateEntityです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public interface IchijiHanteizumiDataShutsuryokuMapper {

    /**
     * 一次判定済みデータの取得します。
     *
     * @param paramter IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return IchijiHanteizumiDataShutsuryokuRelateEntity
     */
    List<IchijiHanteizumiDataShutsuryokuRelateEntity> get一次判定済みデータ(IchijiHanteizumiDataShutsuryokuMybitisParamter paramter);

    /**
     * 一次判定結果票の取得します。
     *
     * @param paramter IchijiHanteizumiDataShutsuryokuMybitisParamter
     * @return IchijiHanteizumiDataShutsuryokuRelateEntity
     */
    List<IchijiHanteizumiDataRelateEntity> get一次判定結果票(IchijiHanteizumiDataShutsuryokuMybitisParamter paramter);

    /**
     * 検索条件より、認定調査票（概況調査）サービスの状況情報を検索する。
     *
     * @param param 認定調査票（概況調査）サービスの状況報検索条件
     * @return DbT5207NinteichosahyoServiceJokyoEntity{@code list}
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> get認定調査票サービス状況(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、認定調査票調査項目情報を検索する。
     *
     * @param param 認定調査票調査項目
     * @return DbT5211NinteichosahyoChosaItemEntity{@code list}
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get認定調査票調査項目(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、前回認定調査票調査項目情報を検索する。
     *
     * @param param 前回認定調査票調査項目報検索条件
     * @return DbT5211NinteichosahyoChosaItemEntity{@code list}
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get前回認定調査票調査項目(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、要介護認定主治医意見書意見項目を検索する。
     *
     * @param param 要介護認定主治医意見書意見項目検索条件
     * @return DbT5304ShujiiIkenshoIkenItemEntity{@code list}
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get主治医意見書意見項目(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、前回主治医意見書意見項目を検索する。
     *
     * @param param 前回主治医意見書意見項目検索条件
     * @return DbT5304ShujiiIkenshoIkenItemEntity{@code list}
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get前回主治医意見書意見項目(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、認定調査票（概況調査）サービスの状況フラグを検索する。
     *
     * @param param 認定調査票（概況調査）サービスの状況フラグ検索条件
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity{@code list}
     */
    List<DbT5208NinteichosahyoServiceJokyoFlagEntity> get認定調査票フラグ(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、認定調査票記入項目を検索する。
     *
     * @param param 認定調査票記入項目検索条件
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity{@code list}
     */
    List<DbT5209NinteichosahyoKinyuItemEntity> get認定調査票記入項目(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

    /**
     * 検索条件より、認定調査特記事項番号を検索する。
     *
     * @param param 認定調査特記事項番号検索条件
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity{@code list}
     */
    List<DbT5205NinteichosahyoTokkijikoEntity> get認定調査特記事項番号(IchijiHanteizumiDataShutsuryokuMybitisParamter param);

}
