/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.sonotakikanmaster;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他機関情報Entityクラスです。
 *
 * @author n8407
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SonotaKikanJohoEntity {

    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString sonotaKikanCode;
    private RString hokenshaName;
    private DbT5914SonotaKikanJohoEntity entity;

    /**
     * md5の初期化をします。
     */
    public void initializeMd5() {
        this.entity.initializeMd5();
    }

    /**
     * @return 証記載保番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return this.shoKisaiHokenshaNo;
    }

    /**
     * @return その他機関コード
     */
    public RString getSonotaKikanCode() {
        return this.sonotaKikanCode;
    }

    /**
     * @return 機関名称
     */
    public RString getKikanMeisho() {
        return this.entity.getKikanMeisho();
    }

    /**
     * @return 機関名称カナ
     */
    public RString getKikanMeishoKana() {
        return this.entity.getKikanMeishoKana();
    }

    /**
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return this.entity.getYubinNo();
    }

    /**
     * @return 住所
     */
    public RString getJusho() {
        return this.entity.getJusho();
    }

    /**
     * @return 住所カナ
     */
    public RString getJushoKana() {
        return this.entity.getJushoKana();
    }

    /**
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return this.entity.getTelNo();
    }

    /**
     * @return 調査委託区分
     */
    public RString getChosaItakuKubun() {
        return this.entity.getChosaItakuKubun();
    }

    /**
     * @return 割付定員
     */
    public int getWaritsukeTeiin() {
        return this.entity.getWaritsukeTeiin();
    }

    /**
     * @return 割付地区
     */
    public ChikuCode getWaritsukeChiku() {
        return this.entity.getWaritsukeChiku();
    }

    /**
     * @return 機関区分
     */
    public RString getKikanKubun() {
        return this.entity.getKikanKubun();
    }

    /**
     * @return 状況フラグ
     */
    public boolean isYuko() {
        return this.entity.getHaishiFlag();
    }

    /**
     * @return 金融機関コード
     */
    public KinyuKikanCode getKinyuKikanCode() {
        return this.entity.getKinyuKikanCode();
    }

    /**
     * @return 金融機関支店コード
     */
    public KinyuKikanShitenCode getKinyuKikanShitenCode() {
        return this.entity.getKinyuKikanShitenCode();
    }

    /**
     * @return 預金種別
     */
    public RString getYokinShubetsu() {
        return this.entity.getYokinShubetsu();
    }

    /**
     * @return 口座番号
     */
    public RString getKozaNo() {
        return this.entity.getKozaNo();
    }

    /**
     * @return 口座名義人カナ
     */
    public AtenaKanaMeisho getKozaMeigininKana() {
        return this.entity.getKozaMeigininKana();
    }

    /**
     * @return 口座名義人
     */
    public AtenaMeisho getKozaMeiginin() {
        return this.entity.getKozaMeiginin();
    }
}
