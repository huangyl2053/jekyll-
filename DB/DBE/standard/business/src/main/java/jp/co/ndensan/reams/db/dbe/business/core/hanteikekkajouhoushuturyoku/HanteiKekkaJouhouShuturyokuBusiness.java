/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.hanteikekkajouhoushuturyoku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkajouhoushuturyoku.HanteiKekkaJouhouShuturyokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定結果情報出力（保険者）を管理するクラスです。
 */
public class HanteiKekkaJouhouShuturyokuBusiness {

    private final HanteiKekkaJouhouShuturyokuRelateEntity entity;

    /**
     * 判定結果情報出力（保険者）項目を返します。
     *
     * @param entity HanteiKekkaJouhouShuturyokuRelateEntity
     */
    public HanteiKekkaJouhouShuturyokuBusiness(HanteiKekkaJouhouShuturyokuRelateEntity entity) {
        this.entity = entity;
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
     * 被保険者カナ氏名を返します。
     *
     * @return 被保険者カナ氏名
     */
    public RString get被保険者カナ氏名() {
        return entity.getHihokenshaKana();
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
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public RString get認定申請区分_申請時コード() {
        return entity.getNinteiShinseiShinseijiKubunCode();
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
     * 開催番号を返します。
     *
     * @return 開催番号
     */
    public RString get開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 開催予定日を返します。
     *
     * @return 開催予定日
     */
    public RString get開催予定日() {
        return entity.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 開催日を返します。
     *
     * @return 開催日
     */
    public RString get開催日() {
        return entity.getShinsakaiKaisaiYMD();
    }

    /**
     * 審査会結果情報抽出年月日を返します。
     *
     * @return 審査会結果情報抽出年月日
     */
    public RString get審査会結果情報抽出年月日() {
        return entity.getShinsakaiKekkaJohoChushutsuYMD();
    }
}
