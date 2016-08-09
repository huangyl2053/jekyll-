/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuGaikyoTokkiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ImjJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;

/**
 * 審査会資料一括作成（事務局）のMapperクラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public interface IJimuShiryoShinsakaiIinMapper {

    /**
     * 審査会資料共通情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return ShinsakaiSiryoKyotsuEntity 審査会資料共通情報
     */
    List<ShinsakaiSiryoKyotsuEntity> get共通情報(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局用介護認定審査対象者一覧表件数を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return 審査対象者数
     */
    int get事務局情報件数(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局用要介護認定申請者の一覧を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<ShinseiJohoEntity> 要介護認定申請者
     */
    List<ShinsakaiTaiyosyaJohoEntity> get事務局情報(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局用要介護認定申請者の一覧を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<ShinseiJohoEntity> 要介護認定申請者
     */
    List<ShinsakaiTaiyosyaJohoEntity> get審査会追加分(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局用介護認定審査対象者一覧表情報を取得します。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return List<ShinsakaiIinJohoEntity> 介護認定審査対象者一覧表情報
     */
    List<ShinsakaiIinJohoEntity> get事務局委員氏名(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局特記情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5205NinteichosahyoTokkijikoEntity> 事務局特記情報
     */
    List<DbT5205NinteichosahyoTokkijikoEntity> get事務局特記情報(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 予防給付サービス状況を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> get予防給付(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 介護給付サービス状況を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> get介護給付(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * サービス状況フラグを取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ
     */
    DbT5208NinteichosahyoServiceJokyoFlagEntity get状況フラグ(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 特記事項情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項
     */
    List<DbT5205NinteichosahyoTokkijikoEntity> get特記事項(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 主治医意見書情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get主治医意見書(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 調査票調査項目を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get調査票項目(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 前回調査票調査項目情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目
     */
    List<DbT5211NinteichosahyoChosaItemEntity> get前回調査票項目(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 現在の状況を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return DbT5210NinteichosahyoShisetsuRiyoEntity 現在状況
     */
    DbT5210NinteichosahyoShisetsuRiyoEntity get現在状況(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 前回主治医意見書情報を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return List<DbT5304ShujiiIkenshoIkenItem> 前回主治医意見書
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> get前回主治医意見書(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局一次判定結果を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return ItiziHanteiEntity 事務局一次判定結果
     */
    List<ItiziHanteiEntity> get事務局一次判定結果(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 要介護認定申請者に関する予備判定記入情報を取得する。
     *
     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
     * @return List<HanteiJohoEntity> 予備判定記入情報
     */
    List<HanteiJohoEntity> getJimuHanteiJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 事務局用概況特記一覧表を取得する。
     *
     * @param parameter JimuGaikyoTokkiMyBatisParameter
     * @return List<GaikyoTokkiEntity>
     */
    List<GaikyoTokkiEntity> getJimuGaikyoTokki(JimuGaikyoTokkiMyBatisParameter parameter);

    /**
     * 事務局用概況特記イメージを取得する。
     *
     * @param parameter JimuGaikyoTokkiMyBatisParameter
     * @return List<ImjJohoEntity>
     */
    List<ImjJohoEntity> getJimuImjJoho(JimuGaikyoTokkiMyBatisParameter parameter);

    /**
     * 事務局一次判定結果を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return ItiziHanteiEntity 事務局一次判定結果
     */
    List<ItiziHanteiEntity> get事務局一次判定(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 事務局一次判定結果を取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return int 事務局一次判定結果件数
     */
    int get事務局一次判定件数(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 概況特記テキストを取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return ShinsakaiSiryoKyotsuEntity 概況特記テキスト
     */
    List<ShinsakaiSiryoKyotsuEntity> get概況特記テキスト(JimuShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 概況特記イメージを取得します。
     *
     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
     * @return ShinsakaiSiryoKyotsuEntity 概況特記イメージ
     */
    List<ShinsakaiSiryoKyotsuEntity> get概況特記イメージ(JimuShinsakaiIinJohoMyBatisParameter parameter);
}
