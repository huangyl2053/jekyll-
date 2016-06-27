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
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.IinTuikaSiryoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteiTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.PsmJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinCodeEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.SonotaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.TokkiIranJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;

/**
 * 審査会資料一括作成（委員）のMapperクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public interface IShiryoShinsakaiIinMapper {

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
     * 介護認定審査会で審査対象となる要介護認定申請者に関する基本情報を取得します。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<NinteiShinseiJohoEntity> 委員用特記事項情報
     */
    List<NinteiShinseiJohoEntity> getNinteiShinseiJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 認定調査項目に関する特記事項の件数を取得します。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return int 特記事項の件数
     */
    int getNinteiTokkijikoCount(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<NinteiTokkijikoEntity> 特記事項情報
     */
    List<NinteiTokkijikoEntity> getNinteiTokkijiko(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 委員用一次判定結果を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<ItiziHanteiEntity> 委員用一次判定結果
     */
    List<ItiziHanteiEntity> getItiziHantei(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 前回申請管理番号を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return 前回申請管理番号
     */
    ShinseishoKanriNo getZenShinseishoKanriNo(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 要介護認定申請者の調査結果に関する特記事項情報件数を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return int 特記事項の件数
     */
    int getNinteichosahyoTokkijikoCount(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 要介護認定申請者の調査結果に関する特記事項情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<NinteichosahyoTokkijikoEntity> 特記事項情報
     */
    List<NinteichosahyoTokkijikoEntity> getNinteichosahyoTokkijiko(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 要介護認定申請者の主治医意見書イメージ情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<ShinsakaiWariateJohoEntity> 委員用主治医意見書
     */
    List<ShinsakaiWariateJohoEntity> getShinsakaiWariateJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

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
     * 前回の申請管理番号を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return DbT5121ShinseiRirekiJohoEntity
     */
    DbT5121ShinseiRirekiJohoEntity get前回の申請管理番号(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 前回二次判定情報を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return DbT5102NinteiKekkaJohoEntity
     */
    DbT5102NinteiKekkaJohoEntity get前回二次判定(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 審査対象者数を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return 審査対象者数
     */
    int getShinseiJohoCount(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 要介護認定申請者の一覧を取得する。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return List<ShinseiJohoEntity> 介護認定審査対象者一覧表情報
     */
    List<ShinseiJohoEntity> getShinseiJoho(IinShinsakaiIinJohoMyBatisParameter parameter);

    /**
     * 委員用概況特記情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<TokkiIranJohoEntity> 概況特記情報
     */
    List<TokkiIranJohoEntity> getTokkiIranJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 委員用その他資料情報を取得する。
     *
     * @param parameter IinTokkiJikouItiziHanteiMyBatisParameter
     * @return List<TokkiIranJohoEntity> その他資料情報
     */
    List<SonotaJohoEntity> getSonotaJoho(IinTokkiJikouItiziHanteiMyBatisParameter parameter);

    /**
     * 追加資料鑑の介護認定審査会委員氏名を取得する。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return List<ShinsakaiIinJohoEntity> 介護認定審査会委員氏名
     */
    List<ShinsakaiIinJohoEntity> getIinShimei(IinTuutishoMyBatisParameter parameter);

    /**
     * 追加資料鑑の追加審査対象者数を取得する
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return int 追加審査対象者数
     */
    int getShinsakaiWariateJohoCount(IinTuutishoMyBatisParameter parameter);

    /**
     * 追加資料鑑情報を取得する。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
     */
    IinTuikaSiryoEntity getShinsakaiKaisaiKekkaJoho(IinTuutishoMyBatisParameter parameter);

    /**
     * 追加審査対象一覧情報を取得する。
     *
     * @param parameter IinTuutishoMyBatisParameter
     * @return List<IinTuikaSiryoEntity> 追加資料鑑情報
     */
    List<IinTuikaSiryoEntity> getIinTuikaSiryo(IinTuutishoMyBatisParameter parameter);

    /**
     * 介護認定審査会開催予定情報のSelectByKey処理です。
     *
     * @param parameter IinShinsakaiIinJohoMyBatisParameter
     * @return DbT5501ShinsakaiKaisaiYoteiJohoEntity
     */
    DbT5501ShinsakaiKaisaiYoteiJohoEntity getSelectByKey(IinItiziHanteiMyBatisParameter parameter);
}
