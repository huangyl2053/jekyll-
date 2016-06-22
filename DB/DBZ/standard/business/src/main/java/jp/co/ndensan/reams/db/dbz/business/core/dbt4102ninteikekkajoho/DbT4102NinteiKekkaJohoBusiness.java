/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.dbt4102ninteikekkajoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報(受給)クラスです。
 *
 * @reamsid_L DBZ-1300-080 yaodongsheng
 */
public class DbT4102NinteiKekkaJohoBusiness {

    private final DbT4102NinteiKekkaJohoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 要介護認定結果情報(受給)Entity
     */
    public DbT4102NinteiKekkaJohoBusiness(DbT4102NinteiKekkaJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 二次判定年月日を取得します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code get二次判定要介護状態区分コード() {
        return entity.getNijiHanteiYokaigoJotaiKubunCode();
    }

    /**
     * 二次判定認定有効期間を取得します。
     *
     * @return 二次判定認定有効期間
     */
    public int get二次判定認定有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 二次判定認定有効開始年月日を取得します。
     *
     * @return 二次判定認定有効開始年月日
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 二次判定認定有効終了年月日を取得します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 介護認定審査会資料作成年月日を取得します。
     *
     * @return 介護認定審査会資料作成年月日
     */
    public FlexibleDate get介護認定審査会資料作成年月日() {
        return entity.getShinsakaiShiryoSakuseiYMD();
    }

    /**
     * 介護認定審査会開催番号を取得します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.getShinsakaiIken();
    }

    /**
     * 一次判定結果変更理由を取得します。
     *
     * @return 一次判定結果変更理由
     */
    public RString get一次判定結果変更理由() {
        return entity.getIchijiHanteiKekkaHenkoRiyu();
    }

    /**
     * 要介護状態像例コードを取得します。
     *
     * @return 要介護状態像例コード
     */
    public Code get要介護状態像例コード() {
        return entity.getYokaigoJotaizoReiCode();
    }

    /**
     * 認定審査会意見種類を取得します。
     *
     * @return 認定審査会意見種類
     */
    public RString get認定審査会意見種類() {
        return entity.getNinteishinsakaiIkenShurui();
    }

    /**
     * 審査会メモを取得します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return entity.getShinsakaiMemo();
    }

    /**
     * 二次判定結果入力方法を取得します。
     *
     * @return 二次判定結果入力方法
     */
    public Code get二次判定結果入力方法() {
        return entity.getNijiHanteiKekkaInputHoho();
    }

    /**
     * 二次判定結果入力年月日を取得します。
     *
     * @return 二次判定結果入力年月日
     */
    public FlexibleDate get二次判定結果入力年月日() {
        return entity.getNijiHanteiKekkaInputYMD();
    }
}
