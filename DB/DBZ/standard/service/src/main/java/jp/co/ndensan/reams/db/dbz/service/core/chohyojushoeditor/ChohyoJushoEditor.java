/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.chohyojushoeditor.JushoEditHoho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 帳票住所編集です。
 *
 * @reamsid_L DBC-0980-580 yangchenbing
 */
public class ChohyoJushoEditor {

    private static final RString 帳票独自 = new RString("1");
    private static final RString 市町村共通 = new RString("0");
    private static final int NUM0 = 0;
    private static final RString 定値_0 = new RString("0");
    private static final RString 定値_1 = new RString("1");
    private static final RString 定値_2 = new RString("2");
    private static final RString 定値_3 = new RString("3");
    private static final RString 定値_4 = new RString("4");
    private static final RString 定値_L = new RString("（");
    private static final RString 定値_R = new RString("）");
    private static final RString 管内 = new RString("管内");
    private final DbT7065ChohyoSeigyoKyotsuDac dbt7065dac;
    private final List<JushoEditHoho> list;
    private DonyuKeitaiCode 導入形態コード;

    /**
     * コンストラクタです。
     *
     * @param subgyomucode SubGyomuCode
     * @param 帳票分類ID RString
     * @param gyomubunrui GyomuBunrui
     */
    public ChohyoJushoEditor(SubGyomuCode subgyomucode, RString 帳票分類ID, GyomuBunrui gyomubunrui) {
        dbt7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        RDate nowDate = RDate.getNowDate();
        list = new ArrayList();
        subgyomucode = (subgyomucode == null ? SubGyomuCode.EMPTY : subgyomucode);
        帳票分類ID = (帳票分類ID == null ? RString.EMPTY : 帳票分類ID);
        if (gyomubunrui == null) {
            throw new NullPointerException();
        }
        ShichosonSecurityJoho shichosonsecurityjoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(gyomubunrui);
        if (shichosonsecurityjoho != null) {
            導入形態コード = shichosonsecurityjoho.get導入形態コード();
            if (導入形態コード != null && 導入形態コード.is単一()) {
                step帳票独自の場合(subgyomucode, 帳票分類ID, shichosonsecurityjoho, nowDate);
            } else if (導入形態コード != null && !導入形態コード.is単一()) {
                step市町村共通の場合(shichosonsecurityjoho, nowDate);
            }
        } else {
            throw new NullPointerException();
        }
    }

    private void step帳票独自の場合(SubGyomuCode subgyomucode, RString 帳票分類ID, ShichosonSecurityJoho shichosonsecurityjoho, RDate nowDate) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        if (association == null) {
            throw new NullPointerException();
        }
        DbT7065ChohyoSeigyoKyotsuEntity entity = dbt7065dac.selectByKey(subgyomucode, new ReportId(帳票分類ID));
        if (entity == null || 市町村共通.equals(entity.getJushoHenshuKubun())) {
            JushoEditHoho jushoedithoho = new JushoEditHoho();
            jushoedithoho.set市町村コード(shichosonsecurityjoho.get市町村情報().get市町村コード());
            jushoedithoho.set管内住所編集_都道府県名付与有無(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
            jushoedithoho.set管内住所編集_郡名付与有無(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
            jushoedithoho.set管内住所編集_市町村名付与有無(
                    DbBusinessConfig.get(ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
            jushoedithoho.set管内住所編集_住所編集方法(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, nowDate, SubGyomuCode.DBU介護統計報告));
            jushoedithoho.set住所編集_方書表示有無(DbBusinessConfig.get(
                    ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, nowDate, SubGyomuCode.DBU介護統計報告));
            jushoedithoho.set都道府県名(association.get都道府県名());
            jushoedithoho.set郡名(association.get郡名());
            jushoedithoho.set市町村名(association.get市町村名());
            list.add(jushoedithoho);
        } else if (帳票独自.equals(entity.getJushoHenshuKubun())) {
            JushoEditHoho jushoedithoho = new JushoEditHoho();
            jushoedithoho.set市町村コード(shichosonsecurityjoho.get市町村情報().get市町村コード());
            jushoedithoho.set管内住所編集_都道府県名付与有無(entity.getJushoHenshuTodoufukenMeiHyojiUmu() ? 定値_1 : 定値_0);
            jushoedithoho.set管内住所編集_郡名付与有無(entity.getJushoHenshuGunMeiHyojiUmu() ? 定値_1 : 定値_0);
            jushoedithoho.set管内住所編集_市町村名付与有無(entity.getJushoHenshuShichosonMeiHyojiUmu() ? 定値_1 : 定値_0);
            jushoedithoho.set管内住所編集_住所編集方法(entity.getJushoHenshuChoikiHenshuHoho());
            jushoedithoho.set住所編集_方書表示有無(entity.getJushoHenshuKatagakiHyojiUmu() ? 定値_1 : 定値_0);
            jushoedithoho.set都道府県名(association.get都道府県名());
            jushoedithoho.set郡名(association.get郡名());
            jushoedithoho.set市町村名(association.get市町村名());
            list.add(jushoedithoho);
        }
    }

    private void step市町村共通の場合(ShichosonSecurityJoho shichosonsecurityjoho, RDate nowDate) {
        JushoEditHoho jushoedithoho = new JushoEditHoho();
        jushoedithoho.set市町村コード(shichosonsecurityjoho.get市町村情報().get市町村コード());
        jushoedithoho.set管内住所編集_都道府県名付与有無(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
        jushoedithoho.set管内住所編集_郡名付与有無(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_郡名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
        jushoedithoho.set管内住所編集_市町村名付与有無(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_市町村名付与有無, nowDate, SubGyomuCode.DBU介護統計報告));
        jushoedithoho.set管内住所編集_住所編集方法(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_管内住所編集_編集方法, nowDate, SubGyomuCode.DBU介護統計報告));
        jushoedithoho.set住所編集_方書表示有無(DbBusinessConfig.get(
                ConfigNameDBU.帳票共通住所編集方法_住所編集_方書表示有無, nowDate, SubGyomuCode.DBU介護統計報告));
        jushoedithoho.set都道府県名(RString.EMPTY);
        jushoedithoho.set郡名(RString.EMPTY);
        jushoedithoho.set市町村名(RString.EMPTY);
        list.add(jushoedithoho);
        List<KoseiShichosonMaster> koseishichosonmasterlist = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        if (koseishichosonmasterlist != null) {
            for (KoseiShichosonMaster koseishichosonmaster : koseishichosonmasterlist) {
                JushoEditHoho jushoedithoho1 = new JushoEditHoho();
                jushoedithoho1.set市町村コード(koseishichosonmaster.get市町村コード());
                jushoedithoho1.set管内住所編集_都道府県名付与有無(koseishichosonmaster.get帳票用都道府県名称表示有無());
                jushoedithoho1.set管内住所編集_郡名付与有無(koseishichosonmaster.get帳票用郡名称表示有無());
                jushoedithoho1.set管内住所編集_市町村名付与有無(koseishichosonmaster.get帳票用市町村名称表示有無());
                jushoedithoho1.set管内住所編集_住所編集方法(koseishichosonmaster.get帳票用住所編集方法());
                jushoedithoho1.set住所編集_方書表示有無(koseishichosonmaster.get帳票用方書表示有無());
                jushoedithoho1.set都道府県名(koseishichosonmaster.get都道府県名称());
                jushoedithoho1.set郡名(koseishichosonmaster.get郡名称());
                jushoedithoho1.set市町村名(koseishichosonmaster.get市町村名称());
                list.add(jushoedithoho1);
            }
        }
    }

    /**
     * 帳票出力用住所に編集します。
     *
     * @param 管内管外区分 RString
     * @param 住所 RString
     * @param 行政区名 RString
     * @param 方書 RString
     * @param 番地 RString
     * @param 市町村コード LasdecCode
     * @return 編集後住所 RString
     */
    public RString editJusho(RString 管内管外区分, RString 住所, RString 番地, RString 方書, RString 行政区名, LasdecCode 市町村コード) {
        住所 = 住所 != null ? 住所 : RString.EMPTY;
        番地 = 番地 != null ? 番地 : RString.EMPTY;
        方書 = 方書 != null ? 方書 : RString.EMPTY;
        行政区名 = 行政区名 != null ? 行政区名 : RString.EMPTY;
        RString 編集後住所 = RString.EMPTY;
        JushoEditHoho jushoedithoho = new JushoEditHoho();
        if (導入形態コード.is単一() || 市町村コード == null || 市町村コード.isEmpty()) {
            jushoedithoho = list.get(NUM0);
        } else if (導入形態コード.is広域() && !list.isEmpty()) {
            jushoedithoho = list.get(NUM0);
            for (JushoEditHoho entity : list) {
                if (市町村コード.equals(entity.get市町村コード())) {
                    jushoedithoho = entity;
                    break;
                }
            }
        }
        if (管内.equals(管内管外区分)) {
            編集後住所 = execute管内住所の編集(編集後住所, jushoedithoho, 住所, 番地, 行政区名, 方書);
        } else {
            編集後住所 = execute管外住所の編集(編集後住所, jushoedithoho, 住所, 番地, 行政区名, 方書);
        }
        return 編集後住所;
    }

    private RString execute管内住所の編集(RString 編集後住所, JushoEditHoho jushoedithoho, RString 住所, RString 番地, RString 行政区名, RString 方書) {
        if (定値_1.equals(jushoedithoho.get管内住所編集_都道府県名付与有無()) && jushoedithoho.get都道府県名() != null) {
            編集後住所 = 編集後住所.concat(jushoedithoho.get都道府県名());
        }
        if (定値_1.equals(jushoedithoho.get管内住所編集_郡名付与有無()) && jushoedithoho.get郡名() != null) {
            編集後住所 = 編集後住所.concat(jushoedithoho.get郡名());
        }
        if (定値_1.equals(jushoedithoho.get管内住所編集_市町村名付与有無()) && jushoedithoho.get市町村名() != null) {
            編集後住所 = 編集後住所.concat(jushoedithoho.get市町村名());
        }
        if (定値_1.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(住所).concat(番地);
        } else if (定値_2.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(行政区名).concat(番地);
        } else if (定値_3.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(住所).concat(番地);
            if (!RString.isNullOrEmpty(行政区名)) {
                編集後住所 = 編集後住所.concat(定値_L).concat(行政区名).concat(定値_R);
            }
        } else if (定値_4.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(番地);
        }
        if (定値_1.equals(jushoedithoho.get住所編集_方書表示有無()) && !RString.isNullOrEmpty(方書)) {
            編集後住所 = 編集後住所.concat(RString.FULL_SPACE).concat(方書);
        }
        return 編集後住所;
    }

    private RString execute管外住所の編集(RString 編集後住所, JushoEditHoho jushoedithoho, RString 住所, RString 番地, RString 行政区名, RString 方書) {
        if (定値_1.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(住所).concat(番地);
        } else if (定値_2.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(行政区名).concat(番地);
        } else if (定値_3.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(住所).concat(番地);
            if (!RString.isNullOrEmpty(行政区名)) {
                編集後住所 = 編集後住所.concat(定値_L).concat(行政区名).concat(定値_R);
            }
        } else if (定値_4.equals(jushoedithoho.get管内住所編集_住所編集方法())) {
            編集後住所 = 編集後住所.concat(番地);
        }
        if (定値_1.equals(jushoedithoho.get住所編集_方書表示有無()) && !RString.isNullOrEmpty(方書)) {
            編集後住所 = 編集後住所.concat(RString.FULL_SPACE).concat(方書);
        }
        return 編集後住所;
    }
}
