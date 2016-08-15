/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTuutishoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.KaisaiYoteiJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.KaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.PsmJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinCodeEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;

/**
 * 審査会資料一括作成（委員）のMapperクラスです。
 *
 * @reamsid_L DBE-0150-200 wangxiaodong
 */
public interface IShiryoShinsakaiIinMapper {

    /**
     * 審査会資料共通情報を取得します。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<ShinsakaiSiryoKyotsuEntity>
     */
    List<ShinsakaiSiryoKyotsuEntity> getShinsakaiSiryoKyotsu(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 介護認定審査会開催予定情報を取得します。
     *
     * @param parameter KaisaiYoteiJohoMyBatisParameter
     * @return 介護認定審査会開催予定情報
     */
    KaisaiYoteiJohoEntity get開催予定情報(KaisaiYoteiJohoMyBatisParameter parameter);

    /**
     * 委員情報を取得します。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return List<ShinsakaiIinCodeEntity> 介護認定審査会委員情報
     */
    List<ShinsakaiIinCodeEntity> getShinsakaiIinCode(IinTuutishoMyBatisParameter parameter);

    /**
     * 審査会開催のお知らせ一覧情報を取得します。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return List<ShinsakaiYoteiJohoEntity> 審査会開催のお知らせ一覧情報
     */
    List<ShinsakaiYoteiJohoEntity> getShinsakaiYoteiJoho(IinTuutishoMyBatisParameter parameter);

    /**
     * 宛先情報の取得処理です。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity
     */
    DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity get宛先情報(IinTuutishoMyBatisParameter parameter);

    /**
     * 宛先情報の取得処理です。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return PsmJohoEntity
     */
    PsmJohoEntity get主治医宛名情報(IinTuutishoMyBatisParameter parameter);

    /**
     * 宛先情報の取得処理です。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return PsmJohoEntity
     */
    PsmJohoEntity get認定調査員宛名情報(IinTuutishoMyBatisParameter parameter);

    /**
     * 宛先情報の取得処理です。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return PsmJohoEntity
     */
    PsmJohoEntity getその他宛名情報(IinTuutishoMyBatisParameter parameter);

    /**
     * 委員用一次判定結果を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<ItiziHanteiEntity> 委員用一次判定結果
     */
    List<ItiziHanteiEntity> getItiziHantei(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 予防給付サービス情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> getYoboService(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 介護給付サービスを取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5207NinteichosahyoServiceJokyoEntity>
     */
    List<DbT5207NinteichosahyoServiceJokyoEntity> getKaigoService(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 認定調査票（概況調査）サービスの状況フラグ情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return DbT5208NinteichosahyoServiceJokyoFlagEntity
     */
    DbT5208NinteichosahyoServiceJokyoFlagEntity getServiceJokyoFlag(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 調査結果に関する特記事項情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5205NinteichosahyoTokkijikoEntity>
     */
    List<DbT5205NinteichosahyoTokkijikoEntity> getTokkijiko(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 主治医意見書項目情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> getIkenshoIkenItem(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 前回主治医意見書項目情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
     */
    List<DbT5304ShujiiIkenshoIkenItemEntity> getZenkaiIkenshoIkenItem(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 主治医意見書項目情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5211NinteichosahyoChosaItemEntity> getChosahyoChosaItem(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 前回申請書管理番号より、前回調査票調査項目情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<DbT5211NinteichosahyoChosaItemEntity>
     */
    List<DbT5211NinteichosahyoChosaItemEntity> getZenkaiChosahyoChosaItem(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 申請書管理番号と認定調査依頼履歴番号より、現在の状況を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return DbT5211NinteichosahyoChosaItemEntity>
     */
    DbT5210NinteichosahyoShisetsuRiyoEntity getGenzaiJokyo(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 要介護認定申請者に関する予備判定記入情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<HanteiJohoEntity> 予備判定記入情報
     */
    List<HanteiJohoEntity> getHanteiJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 介護認定審査対象者一覧表を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return List<ShinsakaiIinJohoEntity> 介護認定審査対象者一覧表情報
     */
    List<ShinsakaiIinJohoEntity> getShinsakaiIinJoho(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 審査対象者数を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return 審査対象者数
     */
    int getShinsakaiTaiyosyaJohoCount(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 審査会対象者情報を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return List<ShinsakaiTaiyosyaJohoEntity> 審査会対象者情報
     */
    List<ShinsakaiTaiyosyaJohoEntity> getShinsakaiTaiyosyaJoho(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 委員用概況特記情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<TokkiIranJohoEntity> 概況特記情報
     */
    List<DbT5205NinteichosahyoTokkijikoEntity> getTokkiIranJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 介護認定審査会開催予定情報のSelectByKey処理です。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     */
    DbT5501ShinsakaiKaisaiYoteiJohoEntity getSelectByKey(IinItiziHanteiMyBatisParameter parameter);

    /**
     * 委員用一次判定結果と特記事項情報を取得します。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return ItiziHanteiEntity 一次判定結果
     */
    List<ItiziHanteiEntity> getTokkiJikouItiziHantei(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 委員用一次判定結果と特記事項情報件数を取得します。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return ItiziHanteiEntity 一次判定結果
     */
    int getTokkiJikouItiziHanteiCount(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

}
