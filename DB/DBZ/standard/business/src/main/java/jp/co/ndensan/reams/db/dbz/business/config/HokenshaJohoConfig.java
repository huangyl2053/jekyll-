/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.config.HokenshaJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 保険者情報のconfigを扱います。
 *
 * @author N3327 三浦 凌
 */
public class HokenshaJohoConfig {

    private final ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private final HokenshaName hokenshaName;
    private final AtenaJusho hokenshaJusho;
    private final TelNo hokenshaTelNo;
    private final YubinNo hokenshaYubinNo;

    /**
     * インスタンスを生成します。コンフィグ取得時の適用基準日には、{@link RDate#getNowDate()}を用います。
     */
    public HokenshaJohoConfig() {
        this(UrBusinessConfigFactory.createInstance(), RDate.getNowDate());
    }

    /**
     * コンストラクタです。{@link IBusinessConfigLoader loader}を指定して、インスタンスを生成します。
     *
     * @param loader {@link IBusinessConfigLoader loader}
     * @param date 適用基準日
     */
    protected HokenshaJohoConfig(IUrBusinessConfig loader, RDate date) {
        this.shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(loader.get(HokenshaJoho.保険者情報_保険者番号, date));
        this.hokenshaName = new HokenshaName(loader.get(HokenshaJoho.保険者情報_保険者名称, date));
        this.hokenshaJusho = new AtenaJusho(loader.get(HokenshaJoho.保険者情報_住所, date));
        this.hokenshaTelNo = new TelNo(loader.get(HokenshaJoho.保険者情報_電話番号, date));
        this.hokenshaYubinNo = new YubinNo(loader.get(HokenshaJoho.保険者情報_郵便番号, date));
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号;
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.shoKisaiHokenshaNo;
    }

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public HokenshaName get保険者名称() {
        return this.hokenshaName;
    }

    /**
     * 保険者の住所を返します。
     *
     * @return 保険者の住所
     */
    public AtenaJusho get保険者住所() {
        return this.hokenshaJusho;
    }

    /**
     * 保険者の電話番号を返します。
     *
     * @return 保険者の電話番号
     */
    public TelNo get電話番号() {
        return this.hokenshaTelNo;
    }

    /**
     * 保険者の郵便番号を返します。
     *
     * @return 保険者の郵便番号
     */
    public YubinNo get郵便番号() {
        return this.hokenshaYubinNo;
    }
}
