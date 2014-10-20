/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.config.DbzConfigKeys.HokenshaInfo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 保険者情報のconfigを扱います。
 *
 * @author N3327 三浦 凌
 */
public final class HokenshaInfoConfig {

    private final ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private final HokenshaName hokenshaName;
    private final AtenaJusho hokenshaJusho;
    private final TelNo hokenshaTelNo;
    private final YubinNo hokenshaYubinNo;

    /**
     * インスタンスを生成します。
     */
    public HokenshaInfoConfig() {
        this(UrBusinessConfigFactory.createInstance());
    }

    /**
     * {@link IBusinessConfigLoader loader}を指定して、インスタンスを生成します。<br/>
     * テストでも利用します。
     *
     * @param loader {@link IBusinessConfigLoader loader}
     */
    HokenshaInfoConfig(IUrBusinessConfig loader) {
        this.shoKisaiHokenshaNo = new ShoKisaiHokenshaNo(loader.get(HokenshaInfo.保険者情報_保険者番号));
        this.hokenshaName = new HokenshaName(loader.get(HokenshaInfo.保険者情報_保険者名称));
        this.hokenshaJusho = new AtenaJusho(loader.get(HokenshaInfo.保険者情報_住所));
        this.hokenshaTelNo = new TelNo(loader.get(HokenshaInfo.保険者情報_電話番号));
        this.hokenshaYubinNo = new YubinNo(loader.get(HokenshaInfo.保険者情報_郵便番号));
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
