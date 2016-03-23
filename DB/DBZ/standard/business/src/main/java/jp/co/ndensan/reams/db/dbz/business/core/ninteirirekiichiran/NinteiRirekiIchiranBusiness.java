/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteirirekiichiran;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 受給者台帳情報一覧ガイドにＤＢから検索するデータが表示するクラスです。
 */
public class NinteiRirekiIchiranBusiness {

    private final DbT4001JukyushaDaichoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 資格得喪Entity
     */
    public NinteiRirekiIchiranBusiness(DbT4001JukyushaDaichoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請日を取得します。
     *
     * @return 申請日
     */
    public FlexibleDate get申請日() {
        return entity.getJukyuShinseiYMD();
    }

    /**
     * 要介護認定状態区分を取得します。
     *
     * @return 要介護認定状態区分
     */
    public Code get要介護認定状態区分() {
        return entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効開始日を取得します。
     *
     * @return 認定有効開始日
     */
    public FlexibleDate get認定有効開始日() {
        return entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効終了日を取得します。
     *
     * @return 認定有効終了日
     */
    public FlexibleDate get認定有効終了日() {
        return entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 申請種別を取得します。
     *
     * @return 申請種別
     */
    public Code get申請種別() {
        return entity.getJukyuShinseiJiyu();
    }

    /**
     * みなし区分を取得します。
     *
     * @return みなし区分
     */
    public Code getみなし区分() {
        return entity.getMinashiCode();
    }

    /**
     * 旧措置者フラグを取得します。
     *
     * @return 旧措置者フラグ
     */
    public boolean is旧措置者フラグ() {
        return entity.getKyuSochishaFlag();
    }

    /**
     * 認定年月日を取得します。
     *
     * @return 認定年月日
     */
    public FlexibleDate get認定年月日() {
        return entity.getNinteiYMD();
    }

    /**
     * ２号特定疾病コードを取得します。
     *
     * @return ２号特定疾病コード
     */
    public Code get２号特定疾病コード() {
        return entity.getNigoTokuteiShippeiCode();
    }
}
