/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.jukyushokai;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報を定義するクラスです。
 *
 * @reamsid_L DBD-3560-011 xuyue
 */
public class JukyuShokaiShinseiJoho {

    private final DbT4001JukyushaDaichoEntity 受給者台帳Entity;
    private final DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity;

    /**
     * コンストラクタです。
     *
     * @param 受給者台帳Entity 受給者台帳Entity
     * @param 要介護認定インターフェース情報Entity 要介護認定インターフェース情報Entity
     */
    public JukyuShokaiShinseiJoho(DbT4001JukyushaDaichoEntity 受給者台帳Entity,
            DbT4003YokaigoNinteiInterfaceEntity 要介護認定インターフェース情報Entity) {
        this.受給者台帳Entity = 受給者台帳Entity;
        this.要介護認定インターフェース情報Entity = 要介護認定インターフェース情報Entity;
    }

    /**
     * 受給者台帳_市町村コードを取得します。
     *
     * @return 受給者台帳_市町村コード
     */
    public LasdecCode get受給者台帳_市町村コード() {
        return 受給者台帳Entity.getShichosonCode();
    }

    /**
     * 受給者台帳_枝番を取得します。
     *
     * @return 受給者台帳_枝番
     */
    public RString get受給者台帳_枝番() {
        return 受給者台帳Entity.getEdaban();
    }

    /**
     * 受給者台帳_受給申請年月日を取得します。
     *
     * @return 受給者台帳_受給申請年月日
     */
    public FlexibleDate get受給者台帳_受給申請年月日() {
        return 受給者台帳Entity.getJukyuShinseiYMD();
    }

    /**
     * 受給者台帳_認定年月日を取得します。
     *
     * @return 受給者台帳_認定年月日
     */
    public FlexibleDate get受給者台帳_認定年月日() {
        return 受給者台帳Entity.getNinteiYMD();
    }

    /**
     * 受給者台帳_認定有効開始年月日を取得します。
     *
     * @return 受給者台帳_認定有効開始年月日
     */
    public FlexibleDate get受給者台帳_認定有効開始年月日() {
        return 受給者台帳Entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 受給者台帳_認定有効終了年月日を取得します。
     *
     * @return 受給者台帳_認定有効終了年月日
     */
    public FlexibleDate get受給者台帳_認定有効終了年月日() {
        return 受給者台帳Entity.getNinteiYukoKikanShuryoYMD();
    }

    /**
     * 受給者台帳_旧措置フラグを取得します。
     *
     * @return 受給者台帳_旧措置フラグ
     */
    public boolean is受給者台帳_旧措置フラグ() {
        return 受給者台帳Entity.getKyuSochishaFlag();
    }

    /**
     * 受給者台帳_要介護認定状態区分コードを取得します。
     *
     * @return 受給者台帳_要介護認定状態区分コード
     */
    public Code get受給者台帳_要介護認定状態区分コード() {
        return 受給者台帳Entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 受給者台帳_履歴番号を取得します。
     *
     * @return 受給者台帳_履歴番号
     */
    public RString get受給者台帳_履歴番号() {
        return 受給者台帳Entity.getRirekiNo();
    }

    /**
     * 受給者台帳_受給申請事由を取得します。
     *
     * @return 受給者台帳_受給申請事由
     */
    public Code get受給者台帳_受給申請事由() {
        return 受給者台帳Entity.getJukyuShinseiJiyu();
    }

    /**
     * 受給者台帳_要支援者認定申請区分を取得します。
     *
     * @return had生保受給
     */
    public boolean is受給者台帳_要支援者認定申請区分() {
        return 受給者台帳Entity.getYoshienshaNinteiShinseiFlag();
    }

    /**
     * 受給者台帳_論理削除フラグを取得します。
     *
     * @return 受給者台帳_論理削除フラグ
     */
    public boolean is受給者台帳_論理削除フラグ() {
        return 受給者台帳Entity.getLogicalDeletedFlag();
    }

    /**
     * 受給者台帳_削除事由コードを取得します。
     *
     * @return 受給者台帳_削除事由コード
     */
    public Code get受給者台帳_削除事由コード() {
        return 受給者台帳Entity.getSakujoJiyuCode();
    }

    /**
     * 受給者台帳_データ区分を取得します。
     *
     * @return 受給者台帳_データ区分
     */
    public Code get受給者台帳_データ区分() {
        return 受給者台帳Entity.getDataKubun();
    }

    /**
     * 受給者台帳_みなし要介護区分コードを取得します。
     *
     * @return 受給者台帳_みなし要介護区分コード
     */
    public Code get受給者台帳_みなし要介護区分コード() {
        return 受給者台帳Entity.getMinashiCode();
    }

    /**
     * 要介護認定インタフェース情報_審査会意見を取得します。
     *
     * @return 要介護認定インタフェース情報_審査会意見
     */
    public RString get要介護認定インタフェース情報_審査会意見() {
        return 要介護認定インターフェース情報Entity.getShinsakaiIken();
    }

}
