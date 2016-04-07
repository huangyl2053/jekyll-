/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shiharaihohojyoho.KozaJohoPSM;

import java.io.Serializable;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shiharaihohojyoho.KozaJohoPSMEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座情報を保持するクラスです。
 */
public class KozaJohoPSM implements Serializable {

    private final KozaJohoPSMEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 口座情報PSM
     */
    public KozaJohoPSM(KozaJohoPSMEntity entity) {
        this.entity = entity;
    }

    /**
     * insertDantaiCdを取得します。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return entity.getInsertDantaiCd();
    }

    /**
     * insertTimestampを取得します。
     *
     * @return insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return entity.getInsertTimestamp();
    }

    /**
     * insertReamsLoginIdを取得します。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return entity.getInsertReamsLoginId();
    }

    /**
     * insertContextIdを取得します。
     *
     * @return insertContextId
     */
    public UUID getInsertContextId() {
        return entity.getInsertContextId();
    }

    /**
     * updateCountを取得します。
     *
     * @return updateCount
     */
    public int getUpdateCount() {
        return entity.getUpdateCount();
    }

    /**
     * lastUpdateTimestampを取得します。
     *
     * @return lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return entity.getLastUpdateTimestamp();
    }

    /**
     * lastUpdateReamsLoginIdを取得します。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return entity.getLastUpdateReamsLoginId();
    }

    /**
     * 口座IDを取得します。
     *
     * @return 口座ID
     */
    public long get口座ID() {
        return entity.getKozaId();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 業務コードを取得します。
     *
     * @return 業務コード
     */
    public GyomuCode get業務コード() {
        return entity.getGyomuCode();
    }

    /**
     * サブ業務コードを取得します。
     *
     * @return サブ業務コード
     */
    public SubGyomuCode getサブ業務コード() {
        return entity.getSubGyomuCode();
    }

    /**
     * 科目コードを取得します。
     *
     * @return 科目コード
     */
    public KamokuCode get科目コード() {
        return entity.getKamokuCode();
    }

    /**
     * 業務固有キーを取得します。
     *
     * @return 業務固有キー
     */
    public RString get業務固有キー() {
        return entity.getGyomuKoyuKey();
    }

    /**
     * 用途区分を取得します。
     *
     * @return 用途区分
     */
    public Code get用途区分() {
        return entity.getYotoKubun();
    }

    /**
     * 用途区分名称を取得します。
     *
     * @return 用途区分名称
     */
    public RString get用途区分名称() {
        return entity.getYotoKubunMeisho();
    }

    /**
     * 金融機関コードを取得します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return entity.getKinyuKikanCode();
    }

    /**
     * 金融機関名称を取得します。
     *
     * @return 金融機関名称
     */
    public RString get金融機関名称() {
        return entity.getKinyuKikanMeisho();
    }

    /**
     * 支店コードを取得します。
     *
     * @return 支店コード
     */
    public KinyuKikanShitenCode get支店コード() {
        return entity.getKinyuKikanShitenCode();
    }

    /**
     * 支店名称を取得します。
     *
     * @return 支店名称
     */
    public RString get支店名称() {
        return entity.getKinyuKikanShitenMeisho();
    }

    /**
     * 預金種別を取得します。
     *
     * @return 預金種別
     */
    public RString get預金種別() {
        return entity.getYokinShubetsu();
    }

    /**
     * 預金種別名称を取得します。
     *
     * @return 預金種別名称
     */
    public RString get預金種別名称() {
        return entity.getYokinShubetsuRyakusho();
    }

    /**
     * 口座番号を取得します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return entity.getKozaNo();
    }

    /**
     * 通帳記号を取得します。
     *
     * @return 通帳記号
     */
    public RString get通帳記号() {
        return entity.getTsuchoKigo();
    }

    /**
     * 通帳番号を取得します。
     *
     * @return 通帳番号
     */
    public RString get通帳番号() {
        return entity.getTsuchoNo();
    }

    /**
     * 口座名義人識別コード を取得します。
     *
     * @return 口座名義人識別コード
     */
    public ShikibetsuCode get口座名義人識別コード() {
        return entity.getKozaMeigininShikibetsuCode();
    }

    /**
     * 口座名義人を取得します。
     *
     * @return 口座名義人
     */
    public AtenaKanaMeisho get口座名義人() {
        return entity.getKozaMeiginin();
    }

    /**
     * 口座名義人漢字を取得します。
     *
     * @return 口座名義人漢字
     */
    public AtenaMeisho get口座名義人漢字() {
        return entity.getKozaMeigininKanji();
    }

    /**
     * 開始年月日を取得します。
     *
     * @return 開始年月日
     */
    public RDate get開始年月日() {
        return entity.getKaishiYMD();
    }

    /**
     * 終了年月日を取得します。
     *
     * @return 終了年月日
     */
    public RDate get終了年月日() {
        return entity.getShuryoYMD();
    }

    /**
     * 検索用名義人を取得します。
     *
     * @return 検索用名義人
     */
    public AtenaKanaMeisho get検索用名義人() {
        return entity.getKensakuyoMeiginin();
    }

    /**
     * 口座表示区分を取得します。
     *
     * @return 口座表示区分
     */
    public RString get口座表示区分() {
        return entity.getKozaHyojiKubun();
    }

    /**
     * 口座登録番号を取得します。
     *
     * @return 口座登録番号
     */
    public RString get口座登録番号() {
        return entity.getKozaTorokuNo();
    }

    /**
     * 口座登録区分コードを取得します。
     *
     * @return 口座登録区分コード
     */
    public Code get口座登録区分コード() {
        return entity.getKozaTorokuKubunCode();
    }

    /**
     * 口座開始受付年月日を取得します。
     *
     * @return 口座開始受付年月日
     */
    public RDate get口座開始受付年月日() {
        return entity.getKozaKaishiUketsukeYMD();
    }

    /**
     * 口座終了受付年月日を取得します。
     *
     * @return 口座終了受付年月日
     */
    public RDate get口座終了受付年月日() {
        return entity.getKozaShuryoUketsukeYMD();
    }

    /**
     * 口座登録年月日を取得します。
     *
     * @return 口座登録年月日
     */
    public RDate get口座登録年月日() {
        return entity.getKozaTorokuYMD();
    }

    /**
     * 店番を取得します。
     *
     * @return 店番
     */
    public RString get店番() {
        return entity.getTemban();
    }
}
