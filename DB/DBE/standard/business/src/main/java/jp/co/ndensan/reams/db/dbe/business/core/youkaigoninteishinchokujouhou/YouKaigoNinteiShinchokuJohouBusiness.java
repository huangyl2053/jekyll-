/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteishinchokujouhou;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteishinchokujouhou.YouKaigoNinteiShinchokuJohouRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定進捗情報データ出力のBusiness処理です。
 *
 * @reamsid_L DBE-1500-010 wanghui
 */
public class YouKaigoNinteiShinchokuJohouBusiness {

    private final YouKaigoNinteiShinchokuJohouRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link YouKaigoNinteiShinchokuJohouRelateEntity}より{@link NinteiChosainMaster}を生成します。
     *
     * @param entity DBより取得した{@link YouKaigoNinteiShinchokuJohouRelateEntity}
     */
    public YouKaigoNinteiShinchokuJohouBusiness(YouKaigoNinteiShinchokuJohouRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 認定申請区分申請時コードを返します。
     *
     * @return 認定申請区分申請時コード
     */
    public RString get認定申請区分申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 認定申請区分法令コードを返します。
     *
     * @return 認定申請区分法令コード
     */
    public RString get認定申請区分法令コード() {
        return entity.getNinteiShinseiHoreiKubunCode();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public RString get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaMeisho();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.getChosainShimei();
    }

    /**
     * 認定調査実施年月日を返します。
     *
     * @return 認定調査実施年月日
     */
    public RString get認定調査実施年月日() {
        return entity.getNinteichosaJisshiYMD();
    }

    /**
     * 主治医意見書受領年月日を返します。
     *
     * @return 主治医意見書受領年月日
     */
    public RString get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 要介護認定一次判定年月日を返します。
     *
     * @return 要介護認定一次判定年月日
     */
    public RString get要介護認定一次判定年月日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public RString get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 介護認定審査会資料作成年月日を返します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public RString get介護認定審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定審査会開催予定年月日を返します。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public RString get介護認定審査会開催予定年月日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 介護認定審査会開催年月日を返します。
     *
     * @return 介護認定審査会開催年月日
     */
    public RString get介護認定審査会開催年月日() {
        return entity.getShinsakaiKaisaiYMD();
    }
}
