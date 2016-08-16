/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbt4030011;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定書情報を取得するクラス
 *
 * @reamsid_L DBD-3860-030 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishoJohoBusiness {

    private NinteishoJohoEntity ninteishoJohoEntity;

    /**
     * コンストラクタです。
     */
    public NinteishoJohoBusiness() {
        ninteishoJohoEntity = new NinteishoJohoEntity();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        ninteishoJohoEntity.set被保険者番号(被保険者番号);
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return ninteishoJohoEntity.get被保険者番号();
    }

    /**
     * 対象者氏名を設定します。
     *
     * @param 対象者氏名 対象者氏名
     */
    public void set対象者氏名(RString 対象者氏名) {
        ninteishoJohoEntity.set対象者氏名(対象者氏名);
    }

    /**
     * 対象者住所を設定します。
     *
     * @param 対象者住所 対象者住所
     */
    public void set対象者住所(RString 対象者住所) {
        ninteishoJohoEntity.set対象者住所(対象者住所);
    }

    /**
     * 対象者生年月日を設定します。
     *
     * @param 対象者生年月日 対象者生年月日
     */
    public void set対象者生年月日(RString 対象者生年月日) {
        ninteishoJohoEntity.set対象者生年月日(対象者生年月日);
    }

    /**
     * 対象者性別を設定します。
     *
     * @param 対象者性別 対象者性別
     */
    public void set対象者性別(RString 対象者性別) {
        ninteishoJohoEntity.set対象者性別(対象者性別);
    }

    /**
     * 申請者氏名を設定します。
     *
     * @param 申請者氏名 申請者氏名
     */
    public void set申請者氏名(RString 申請者氏名) {
        ninteishoJohoEntity.set申請者氏名(申請者氏名);
    }

    /**
     * 申請者住所を設定します。
     *
     * @param 申請者住所 申請者住所
     */
    public void set申請者住所(RString 申請者住所) {
        ninteishoJohoEntity.set申請者住所(申請者住所);
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 発行日
     */
    public void set発行日(RDate 発行日) {
        ninteishoJohoEntity.set発行日(発行日);
    }

    /**
     * 障害理由区分を設定します。
     *
     * @param 障害理由区分 障害理由区分
     */
    public void set障害理由区分(RString 障害理由区分) {
        ninteishoJohoEntity.set障害理由区分(障害理由区分);
    }

    /**
     * 障害理由内容を設定します。
     *
     * @param 障害理由内容 障害理由内容
     */
    public void set障害理由内容(RString 障害理由内容) {
        ninteishoJohoEntity.set障害理由内容(障害理由内容);
    }

    /**
     * 文書番号を設定します。
     *
     * @param 文書番号 文書番号
     */
    public void set文書番号(RString 文書番号) {
        ninteishoJohoEntity.set文書番号(文書番号);
    }

    /**
     * 要介護認定日を設定します。
     *
     * @param 要介護認定日 要介護認定日
     */
    public void set要介護認定日(FlexibleDate 要介護認定日) {
        ninteishoJohoEntity.set要介護認定日(要介護認定日);
    }

    /**
     * 申告年を設定します。
     *
     * @param 申告年 申告年
     */
    public void set申告年(RDate 申告年) {
        ninteishoJohoEntity.set申告年(申告年);
    }

}
