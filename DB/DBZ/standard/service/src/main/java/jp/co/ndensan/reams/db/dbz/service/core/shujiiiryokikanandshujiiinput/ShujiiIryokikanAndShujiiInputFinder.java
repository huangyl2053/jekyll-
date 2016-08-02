/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.shujiiiryokikanandshujiiinput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanAndShujiiInputResult;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5121ShinseiRirekiJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 主治医医療機関&主治医入力のサービスクラスです。
 *
 * @reamsid_L DBE-1300-140 chengsanyuan
 */
public class ShujiiIryokikanAndShujiiInputFinder {

    private final DbT5101NinteiShinseiJohoDac dbt5101dac;
    private final DbT5121ShinseiRirekiJohoDac dbt5121dac;
    private final DbT5911ShujiiIryoKikanJohoDac dbt5911dac;
    private final DbT5912ShujiiJohoDac dbt5912dac;

    /**
     * コンストラクタです。
     */
    ShujiiIryokikanAndShujiiInputFinder() {
        this.dbt5101dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.dbt5121dac = InstanceProvider.create(DbT5121ShinseiRirekiJohoDac.class);
        this.dbt5911dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
        this.dbt5912dac = InstanceProvider.create(DbT5912ShujiiJohoDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT5101NinteiShinseiJohoDac {@link dbt5101dac}
     * @param DbT5121ShinseiRirekiJohoDac {@link dbt5121dac}
     * @param DbT5911ShujiiIryoKikanJohoDac {@link dbt5911dac}
     * @param DbT5912ShujiiJohoDac {@link dbt5912dac}
     */
    ShujiiIryokikanAndShujiiInputFinder(
            DbT5101NinteiShinseiJohoDac dbt5101dac,
            DbT5121ShinseiRirekiJohoDac dbt5121dac,
            DbT5911ShujiiIryoKikanJohoDac dbt5911dac,
            DbT5912ShujiiJohoDac dbt5912dac) {
        this.dbt5101dac = dbt5101dac;
        this.dbt5121dac = dbt5121dac;
        this.dbt5911dac = dbt5911dac;
        this.dbt5912dac = dbt5912dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiInputFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIryokikanAndShujiiInputFinder}のインスタンス
     */
    public static ShujiiIryokikanAndShujiiInputFinder createInstance() {
        return InstanceProvider.create(ShujiiIryokikanAndShujiiInputFinder.class);
    }

    /**
     * 主治医医療機関名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return RString
     */
    public RString getIryoKikanMeisho(LasdecCode 市町村コード, RString 主治医医療機関コード) {
        return dbt5911dac.selectByKeyAndJokyoFlg(市町村コード, 主治医医療機関コード) == null
                ? RString.EMPTY
                : dbt5911dac.selectByKeyAndJokyoFlg(市町村コード, 主治医医療機関コード).getIryoKikanMeisho();
    }

    /**
     * 主治医名称を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return RString
     */
    public RString getShujiiName(LasdecCode 市町村コード, RString 主治医医療機関コード, RString 主治医コード) {
        return dbt5912dac.selectByKeyAndJokyoFlg(市町村コード, 主治医医療機関コード, 主治医コード) == null
                ? RString.EMPTY
                : dbt5912dac.selectByKeyAndJokyoFlg(市町村コード, 主治医医療機関コード, 主治医コード).getShujiiName();
    }

    /**
     * 前回申請情報を取得します。
     *
     * @param 申請管理番号 申請管理番号
     * @param 市町村コード 市町村コード
     * @return RString
     */
    public ShujiiIryokikanAndShujiiInputResult getZenkaiFukushaJoho(
            ShinseishoKanriNo 申請管理番号, LasdecCode 市町村コード) {
        ShujiiIryokikanAndShujiiInputResult result = new ShujiiIryokikanAndShujiiInputResult();
        DbT5121ShinseiRirekiJohoEntity dbt5121Entity = dbt5121dac.selectByKey(申請管理番号);
        if (dbt5121Entity == null) {
            return result;
        }
        DbT5101NinteiShinseiJohoEntity entity = dbt5101dac.selectByKey(dbt5121Entity.getZenkaiShinseishoKanriNo());
        if (entity == null) {
            return result;
        }
        RString 主治医医療機関名称 = getIryoKikanMeisho(市町村コード, entity.getShujiiIryokikanCode().value());
        DbT5912ShujiiJohoEntity dbt5912entity = dbt5912dac.selectByKeyAndJokyoFlg(
                市町村コード, entity.getShujiiIryokikanCode().value(), entity.getShujiiCode().value());
        if (dbt5912entity == null) {
            return result;
        }
        result.set主治医コード(entity.getShujiiCode().value());
        result.set主治医医療機関コード(entity.getShujiiIryokikanCode().value());
        result.set主治医医療機関名称(主治医医療機関名称);
        result.set主治医氏名(dbt5912entity.getShujiiName());
        result.set指定医フラグ(dbt5912entity.getShiteiiFlag());
        return result;
    }
}
