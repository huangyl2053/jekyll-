/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jigyogasanjigyobunmeisaishosakusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc8020001.DBC8020001;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ux.uxx.definition.mybatisprm.kozafurikomi.furikomiitakushakosei.FurikomiItakushaKoseiMapperParameter;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.kozafurikomi.furikomigroup.FurikomiGroupItakushaRelateEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.kozafurikomi.furikomi.FurikomiGroupItakushaItakushaKoseiFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 事業合算・事業分振込明細書作成（一括）を管理するクラスです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class DBC8020001MainManager {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public DBC8020001MainManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * 前回処理情報取得のメソッドです。
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @return DBC8020001
     */
    public DBC8020001 get前回処理情報(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleYear 年度, RString 年度内連番) {

        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();

        return new DBC8020001(entity);
    }

    /**
     * 委託者情報取得のメソッドです。
     *
     * @param メニューID RString
     * @return DBC8020001
     */
    public DBC8020001 getFurikomiGroupItakushaRelateEntity(RString メニューID) {
        List<FurikomiGroupItakushaRelateEntity> list = getFurikomiGroupItakushaRelateEntityList(メニューID);
        FurikomiGroupItakushaRelateEntity fentity = new FurikomiGroupItakushaRelateEntity();
        if (list != null && !list.isEmpty()) {
            fentity = list.get(0);
        }
        return new DBC8020001(fentity);
    }

    /**
     * 委託者情報存在チェックのメソッドです。
     *
     * @param メニューID RString
     * @return boolean
     */
    public boolean if存在(RString メニューID) {
        List<FurikomiGroupItakushaRelateEntity> list = getFurikomiGroupItakushaRelateEntityList(メニューID);
        return (list != null && !list.isEmpty());
    }

    private List<FurikomiGroupItakushaRelateEntity> getFurikomiGroupItakushaRelateEntityList(RString メニューID) {
        List<FurikomiGroupItakushaRelateEntity> list;
        RString 業務内区分 = RString.EMPTY;
        switch (メニューID.toString()) {
            case "DBCMN63005":
                業務内区分 = FurikomiGyomunaiKubun.高額合算.getコード();
                break;
            case "DBCMNL3003":
                業務内区分 = FurikomiGyomunaiKubun.事業高額.getコード();
                break;
            case "DBCMNN2004":
                業務内区分 = FurikomiGyomunaiKubun.事業高額合算.getコード();
                break;
            default:
                break;
        }
        FurikomiItakushaKoseiMapperParameter parameter
                = FurikomiItakushaKoseiMapperParameter.createSelectByKeyParamAllowsNull(
                        null, SubGyomuCode.DBC介護給付, 業務内区分, null, null, null);
        FurikomiGroupItakushaItakushaKoseiFinder finder = FurikomiGroupItakushaItakushaKoseiFinder.createInstance();
        list = finder.getFurikomiGroupItakushItakushKosei(parameter);
        return list;
    }
}
