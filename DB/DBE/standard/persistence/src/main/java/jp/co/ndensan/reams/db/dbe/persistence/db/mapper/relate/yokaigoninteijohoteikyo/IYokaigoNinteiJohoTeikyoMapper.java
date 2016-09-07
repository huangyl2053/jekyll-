/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoBatchMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.HihokenshaJyuhouRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinnteiRiriRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinteichosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoninteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供のマッパーインタフェースです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public interface IYokaigoNinteiJohoTeikyoMapper {

    /**
     * 検索条件より、被保険者情報を検索する。
     *
     * @param param 被保険者情報検索条件
     * @return HihokenshaJyuhouRelateEntityの{@code list}
     */
    HihokenshaJyuhouRelateEntity get被保険者情報(YokaigoNinteiJohoTeiParameter param);

    /**
     * 検索条件より、認定履歴一覧情報を検索する。
     *
     * @param param 認定履歴一覧情報検索条件
     * @return NinnteiRiriRelateEntityの{@code list}
     */
    List<NinnteiRiriRelateEntity> get認定履歴一覧(YokaigoNinteiJohoTeiParameter param);

    /**
     * 検索条件より、要介護認定申請者情報を検索する。
     *
     * @param param 要介護認定申請者情報検索条件
     * @return YokaigoninteiEntityの{@code list}
     */
    List<YokaigoninteiEntity> get要介護認定申請者(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、認定調査票（概況調査）サービスの状況情報を検索する。
     *
     * @param param 認定調査票（概況調査）サービスの状況報検索条件
     * @return DbT5207NinteichosahyoServiceJokyoEntity{@code list}
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> get認定調査票サービス状況(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、認定調査票調査項目情報を検索する。
     *
     * @param param 認定調査票調査項目報検索条件
     * @return DbT5211NinteichosahyoChosaItemEntity{@code list}
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get認定調査票調査項目(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、前回認定調査票調査項目情報を検索する。
     *
     * @param param 前回認定調査票調査項目報検索条件
     * @return DbT5211NinteichosahyoChosaItemEntity{@code list}
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get前回認定調査票調査項目(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、要介護認定主治医意見書意見項目を検索する。
     *
     * @param param 要介護認定主治医意見書意見項目検索条件
     * @return DbT5304ShujiiIkenshoIkenItemEntity{@code list}
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get主治医意見書意見項目(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、前回要介護認定主治医意見書意見項目を検索する。
     *
     * @param param 前回要介護認定主治医意見書意見項目検索条件
     * @return DbT5304ShujiiIkenshoIkenItemEntity{@code list}
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get前回主治医意見書意見項目(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、認定調査票（概況調査）サービスの状況フラグを検索する。
     *
     * @param param 認定調査票（概況調査）サービスの状況フラグ検索条件
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity{@code list}
     */
    List<DbT5208NinteichosahyoServiceJokyoFlagEntity> get認定調査票フラグ(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、認定調査票（概況調査）記入項目を検索する。
     *
     * @param param 認定調査票（概況調査）記入項目検索条件
     * @return DbT5209NinteichosahyoKinyuItemEntity{@code list}
     */
    List<DbT5209NinteichosahyoKinyuItemEntity> get認定調査票記入項目(YokaigoBatchMybitisParamter param);

    /**
     * 要介護認定申請情報の更新する。
     *
     * @param param 要介護認定申請情報検索条件
     * @return DbT5101NinteiShinseiJohoEntity
     */
    DbT5101NinteiShinseiJohoEntity get要介護認定申請情報(YokaigoBatchMybitisParamter param);

    /**
     * イメージ共有ファイルIDを検索する。
     *
     * @param param イメージ共有ファイルID検索条件
     * @return int{@code list}
     */
    RDateTime getイメージ(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、認定調査特記事項番号を検索する。
     *
     * @param param 認定調査特記事項番号検索条件
     * @return List<RString>
     */
    List<RString> get認定調査特記事項番号(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、特記事項区分を検索する。
     *
     * @param param 特記事項区分検索条件
     * @return NinteichosaRelateEntity{@code list}
     */
    List<NinteichosaRelateEntity> get特記事項区分(YokaigoBatchMybitisParamter param);

    /**
     * 検索条件より、特記事項リストを検索する。
     *
     * @param param 特特記事項リスト検索条件
     * @return NinteichosaRelateEntity{@code list}
     */
    List<NinteichosaRelateEntity> get特記事項リスト(YokaigoBatchMybitisParamter param);
}
