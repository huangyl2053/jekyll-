/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijohosakusei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijohosakusei.GogitaiJohoSakuseiRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体情報作成のビジネスクラスです
 */
public class GogitaiJohoSakuseiRsult implements Serializable {

    private final GogitaiJohoSakuseiRelateEntity entity;
    private RString status;

    /**
     * 状態を取得します。
     *
     * @return 状態
     */
    public RString getStatus() {
        return status;
    }

    /**
     * 状態を設定します。
     *
     * @param status 状態
     */
    public void setStatus(RString status) {
        this.status = status;
    }

    /**
     * コンストラクタです。
     *
     * @param entity 合議体情報作成RelateEntity
     */
    public GogitaiJohoSakuseiRsult(GogitaiJohoSakuseiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return entity.getGogitaiJohoEntity().getGogitaiNo();
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return entity.getGogitaiJohoEntity().getGogitaiMei();
    }

    /**
     * 合議体有効期間開始年月日を取得します。
     *
     * @return 合議体有効期間開始年月日
     */
    public FlexibleDate get合議体有効期間開始年月日() {
        return entity.getGogitaiJohoEntity().getGogitaiYukoKikanKaishiYMD();
    }

    /**
     * 合議体有効期間終了年月日を取得します。
     *
     * @return 合議体有効期間終了年月日
     */
    public FlexibleDate get合議体有効期間終了年月日() {
        return entity.getGogitaiJohoEntity().getGogitaiYukoKikanShuryoYMD();
    }

    /**
     * 合議体開始予定時刻を取得します。
     *
     * @return 合議体開始予定時刻
     */
    public RString get合議体開始予定時刻() {
        return entity.getGogitaiJohoEntity().getGogitaiKaishiYoteiTime();
    }

    /**
     * 合議体終了予定時刻を取得します。
     *
     * @return 合議体終了予定時刻
     */
    public RString get合議体終了予定時刻() {
        return entity.getGogitaiJohoEntity().getGogitaiShuryoYoteiTime();
    }

    /**
     * 介護認定審査会予定定員を取得します。
     *
     * @return 介護認定審査会予定定員
     */
    public int get介護認定審査会予定定員() {
        return entity.getGogitaiJohoEntity().getShinsakaiYoteiTeiin();
    }

    /**
     * 介護認定審査会自動割当定員を取得します。
     *
     * @return 介護認定審査会自動割当定員
     */
    public int get介護認定審査会自動割当定員() {
        return entity.getGogitaiJohoEntity().getShinsakaiJidoWariateTeiin();
    }

    /**
     * 介護認定審査会委員定員を取得します。
     *
     * @return 介護認定審査会委員定員
     */
    public int get介護認定審査会委員定員() {
        return entity.getGogitaiJohoEntity().getShinsakaiIinTeiin();
    }

    /**
     * 合議体精神科医存在フラグを取得します。
     *
     * @return 合議体精神科医存在フラグ
     */
    public boolean get合議体精神科医存在フラグ() {
        return entity.getGogitaiJohoEntity().getGogitaiSeishinkaSonzaiFlag();
    }

    /**
     * 合議体ダミーフラグを取得します。
     *
     * @return 合議体ダミーフラグ
     */
    public boolean get合議体ダミーフラグ() {
        return entity.getGogitaiJohoEntity().getGogitaiDummyFlag();
    }

    /**
     * 介護認定審査会開催場所コードを取得します。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.getGogitaiJohoEntity().getShinsakaiKaisaiBashoCode();
    }

    /**
     * 開催場所名称を取得します。
     *
     * @return 開催場所名称
     */
    public RString get開催場所名称() {
        return entity.getShinsakaiKaisaiBashoJohoEntity().getShinsakaiKaisaiBashoName();
    }

    /**
     * 合議体長区分コードを取得します。
     *
     * @return 合議体長区分コード
     */
    public Code get合議体長区分コード() {
        return entity.getGogitaiWariateIinJohoEntity().getGogitaichoKubunCode();
    }

    /**
     * 介護認定審査会委員コードを取得します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getGogitaiWariateIinJohoEntity().getShinsakaiIinCode();
    }

    /**
     * 審査会委員名称を取得します。
     *
     * @return 審査会委員名称
     */
    public AtenaMeisho get審査会委員名称() {
        return entity.getShinsakaiIinJohoEntity().getShinsakaiIinShimei();
    }

    /**
     * 補欠を取得します。
     *
     * @return 補欠
     */
    public boolean get補欠() {
        return entity.getGogitaiWariateIinJohoEntity().getSubstituteFlag();
    }
}
