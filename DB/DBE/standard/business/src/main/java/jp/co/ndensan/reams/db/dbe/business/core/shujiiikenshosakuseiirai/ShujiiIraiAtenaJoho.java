/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshosakuseiirai;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiirai.ShujiiIraiAtenaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼_宛先情報Businessです。
 *
 * @reamsid_L DBE-0050-010 zuotao
 */
public class ShujiiIraiAtenaJoho {

    private final ShujiiIraiAtenaJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 宛先情報Entity
     */
    public ShujiiIraiAtenaJoho(ShujiiIraiAtenaJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * Temp_宛名機関名を取得します。
     *
     * @return Temp_宛名機関名
     */
    public RString getTemp_宛名機関名() {
        return entity.getAtenaKikanMeisho();
    }

    /**
     * Temp_宛名郵便番号を取得します。
     *
     * @return Temp_宛名郵便番号
     */
    public YubinNo getTemp_宛名郵便番号() {
        return entity.getAtenaYubinNo();
    }

    /**
     * Temp_宛名住所を取得します。
     *
     * @return Temp_宛名住所
     */
    public AtenaJusho getTemp_宛名住所() {
        return entity.getAtenaJusho();
    }

    /**
     * Temp_宛名氏名を取得します。
     *
     * @return Temp_宛名氏名
     */
    public AtenaMeisho getTemp_宛名氏名() {
        return entity.getAtenaShimei();
    }
}
