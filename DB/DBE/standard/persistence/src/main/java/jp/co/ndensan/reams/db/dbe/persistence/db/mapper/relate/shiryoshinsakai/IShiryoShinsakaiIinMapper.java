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
//    /**
//     * 介護認定審査会で審査対象となる要介護認定申請者に関する基本情報を取得します。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteiShinseiJohoEntity> 委員用特記事項情報
//     */
//    List<NinteiShinseiJohoEntity> getNinteiShinseiJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 認定調査項目に関する特記事項の件数を取得します。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return int 特記事項の件数
//     */
//    int getNinteiTokkijikoCount(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteiTokkijikoEntity> 特記事項情報
//     */
//    List<NinteiTokkijikoEntity> getNinteiTokkijiko(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

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

//
//    /**
//     * 前回結果情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<DbT5211NinteichosahyoChosaItemEntity>
//     */
//    List<DbT5211NinteichosahyoChosaItemEntity> get前回結果(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前々回情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5102NinteiKekkaJohoEntity
//     */
//    ZenzenkayiJyohouEntity get前々回情報(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回の要介護認定一次判定結果情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5116IchijiHanteiKekkaJohoEntity
//     */
//    DbT5116IchijiHanteiKekkaJohoEntity get前回の要介護認定一次判定結果情報(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 介護認定審査会開催番号に該当する申請書管理番号の個数の取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return 申請書管理番号の個数
//     */
//    int get申請書管理番号の個数(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回申請管理番号を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return 前回申請管理番号
//     */
//    ShinseishoKanriNo getZenShinseishoKanriNo(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者の調査結果に関する特記事項情報件数を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return int 特記事項の件数
//     */
//    int getNinteichosahyoTokkijikoCount(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteichosahyoTokkijikoEntity> 特記事項情報
//     */
//    List<NinteichosahyoTokkijikoEntity> getNinteichosahyoTokkijiko(IinTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局用一次判定結果を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<ItiziHanteiEntity> 委員用一次判定結果
//     */
//    List<ItiziHanteiEntity> getJimuItiziHantei(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回結果情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<DbT5211NinteichosahyoChosaItemEntity>
//     */
//    List<DbT5211NinteichosahyoChosaItemEntity> getJimu前回結果(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前々回情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5102NinteiKekkaJohoEntity
//     */
//    ZenzenkayiJyohouEntity getJimu前々回情報(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回の要介護認定一次判定結果情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5116IchijiHanteiKekkaJohoEntity
//     */
//    DbT5116IchijiHanteiKekkaJohoEntity getJimu前回の要介護認定一次判定結果情報(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回申請管理番号を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return 前回申請管理番号
//     */
//    ShinseishoKanriNo getJimuZenShinseishoKanriNo(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteichosahyoTokkijikoEntity> 特記事項情報
//     */
//    List<NinteichosahyoTokkijikoEntity> getJimuNinteichosahyoTokkijiko(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteichosahyoTokkijikoEntity> 特記事項情報
//     */
//    DbT7051KoseiShichosonMasterEntity getJimu市町村名(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事業者名を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5910NinteichosaItakusakiJohoEntity
//     */
//    DbT5910NinteichosaItakusakiJohoEntity getJimu事業者名(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 調査員情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5913ChosainJohoEntity
//     */
//    DbT5913ChosainJohoEntity getJimu調査員情報(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 医療機関名称の取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5911ShujiiIryoKikanJohoEntity
//     */
//    DbT5911ShujiiIryoKikanJohoEntity getJimu医療機関名称(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 主治医氏名の取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return DbT5912ShujiiJohoEntity
//     */
//    DbT5912ShujiiJohoEntity getJimu主治医氏名(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 前回要介護認定主治医意見書意見項目情報の取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<DbT5304ShujiiIkenshoIkenItemEntity>
//     */
//    List<DbT5304ShujiiIkenshoIkenItemEntity> getJimu前回要介護認定主治医意見書意見項目情報(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 介護認定審査会開催番号に該当する申請書管理番号の個数の取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return 申請書管理番号の個数
//     */
//    int getJimu申請書管理番号の個数(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
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

//    /**
//     * 追加資料鑑の介護認定審査会委員氏名を取得する。
//     *
//     * @param parameter IinTuutishoMyBatisParameter
//     * @return List<ShinsakaiIinJohoEntity> 介護認定審査会委員氏名
//     */
//    List<ShinsakaiIinJohoEntity> getIinShimei(IinTuutishoMyBatisParameter parameter);
//
//    /**
//     * 追加資料鑑の追加審査対象者数を取得する
//     *
//     * @param parameter IinTuutishoMyBatisParameter
//     * @return int 追加審査対象者数
//     */
//    int getShinsakaiWariateJohoCount(IinTuutishoMyBatisParameter parameter);
//
//    /**
//     * 追加資料鑑情報を取得する。
//     *
//     * @param parameter IinTuutishoMyBatisParameter
//     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
//     */
//    IinTuikaSiryoEntity getShinsakaiKaisaiKekkaJoho(IinTuutishoMyBatisParameter parameter);
//
//    /**
//     * 追加審査対象一覧情報を取得する。
//     *
//     * @param parameter IinTuutishoMyBatisParameter
//     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
//     */
//    List<IinTuikaSiryoEntity> getIinTuikaSiryo(IinTuutishoMyBatisParameter parameter);
    /**
     * 介護認定審査会開催予定情報のSelectByKey処理です。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     */
    DbT5501ShinsakaiKaisaiYoteiJohoEntity getSelectByKey(IinItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局用介護認定審査対象者一覧表件数を取得する。
//     *
//     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
//     * @return 審査対象者数
//     */
//    int getJimuShinseiJohoCount(JimuShinsakaiIinJohoMyBatisParameter parameter);
//
//    /**
//     * 事務局用要介護認定申請者の一覧を取得する。
//     *
//     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
//     * @return List<ShinseiJohoEntity> 要介護認定申請者
//     */
//    List<ShinsakaiTaiyosyaJohoEntity> getJimuShinseiJoho(JimuShinsakaiIinJohoMyBatisParameter parameter);
//
//    /**
//     * 事務局用介護認定審査対象者一覧表情報を取得する。
//     *
//     * @param parameter IinShinsakaiIinJohoMyBatisParameter
//     * @return List<ShinsakaiIinJohoEntity> 介護認定審査対象者一覧表情報
//     */
//    List<ShinsakaiIinJohoEntity> getJimuShinsakaiIinJoho(JimuShinsakaiIinJohoMyBatisParameter parameter);
//
//    /**
//     * 前回の申請管理番号を取得する。
//     *
//     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
//     * @return DbT5121ShinseiRirekiJohoEntity
//     */
//    DbT5121ShinseiRirekiJohoEntity get事務局前回の申請管理番号(JimuShinsakaiIinJohoMyBatisParameter parameter);
//
//    /**
//     * 前回二次判定情報を取得する。
//     *
//     * @param parameter JimuShinsakaiIinJohoMyBatisParameter
//     * @return DbT5102NinteiKekkaJohoEntity
//     */
//    DbT5102NinteiKekkaJohoEntity get事務局前回二次判定(JimuShinsakaiIinJohoMyBatisParameter parameter);
//
//    /**
//     * 事務局追加資料鑑の追加審査対象者数を取得する
//     *
//     * @param parameter JimuTuutishoMyBatisParameter
//     * @return int 追加審査対象者数
//     */
//    int getJimuShinsakaiWariateJohoCount(JimuTuutishoMyBatisParameter parameter);
//
//    /**
//     * 事務局追加資料鑑情報を取得する。
//     *
//     * @param parameter JimuTuutishoMyBatisParameter
//     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
//     */
//    IinTuikaSiryoEntity getJimuShinsakaiKaisaiKekkaJoho(JimuTuutishoMyBatisParameter parameter);
//
//    /**
//     * 事務局追加審査対象一覧情報を取得する。
//     *
//     * @param parameter JimuTuutishoMyBatisParameter
//     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
//     */
//    List<IinTuikaSiryoEntity> getJimuTuikaSiryo(JimuTuutishoMyBatisParameter parameter);
//
//    /**
//     * 事務局追加資料鑑の介護認定審査会委員氏名を取得する。
//     *
//     * @param parameter JimuTuutishoMyBatisParameter
//     * @return List<ShinsakaiIinJohoEntity> 介護認定審査会委員氏名
//     */
//    List<ShinsakaiIinJohoEntity> getJimuShimei(JimuTuutishoMyBatisParameter parameter);
//
//    /**
//     * 要介護認定申請者に関する予備判定記入情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<HanteiJohoEntity> 予備判定記入情報
//     */
//    List<HanteiJohoEntity> getJimuHanteiJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局用その他資料情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<TokkiIranJohoEntity> その他資料情報
//     */
//    List<SonotaJohoEntity> getJimuSonotaJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局用概況特記一覧表を取得する。
//     *
//     * @param parameter JimuGaikyoTokkiMyBatisParameter
//     * @return List<GaikyoTokkiEntity>
//     */
//    List<GaikyoTokkiEntity> getJimuGaikyoTokki(JimuGaikyoTokkiMyBatisParameter parameter);
//
//    /**
//     * 事務局用概況特記イメージを取得する。
//     *
//     * @param parameter JimuGaikyoTokkiMyBatisParameter
//     * @return List<ImjJohoEntity>
//     */
//    List<ImjJohoEntity> getJimuImjJoho(JimuGaikyoTokkiMyBatisParameter parameter);
//
//    /**
//     * 事務局用要介護認定申請者の主治医意見書イメージ情報を取得する。
//     *
//     * @param parameter JimuTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<ShinsakaiWariateJohoEntity> 委員用主治医意見書
//     */
//    List<ShinsakaiWariateJohoEntity> getJimuShinsakaiWariateJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局介護認定審査会で審査対象となる要介護認定申請者に関する基本情報を取得します。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteiShinseiJohoEntity> 事務局特記事項情報
//     */
//    List<NinteiShinseiJohoEntity> getJimuNinteiShinseiJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局要介護認定申請者の調査結果に関する特記事項情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<NinteiTokkijikoEntity> 事務局特記事項情報
//     */
//    List<NinteiTokkijikoEntity> getJimuNinteiTokkijiko(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
//
//    /**
//     * 事務局用概況特記情報を取得する。
//     *
//     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
//     * @return List<TokkiIranJohoEntity> 概況特記情報
//     */
//    List<TokkiIranJohoEntity> getJimuTokkiIranJoho(JimuTokkiJikouItiziHanteiMyBatisParameter parameter);
}
