/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.furikomidaitasakusai;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc8010001.DBC8010001;
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
 * 振込明細・振込みデータ作成を管理するクラスです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001MainManager {

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     */
    public DBC8010001MainManager() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     *
     * @param サブ業務コード SubGyomuCode
     * @param 市町村コード LasdecCode
     * @param 処理名 RString
     * @param 処理枝番 RString
     * @param 年度 FlexibleYear
     * @param 年度内連番 RString
     * @return DBC8010001
     */
    public DBC8010001 get前回処理情報(SubGyomuCode サブ業務コード, LasdecCode 市町村コード, RString 処理名, RString 処理枝番,
            FlexibleYear 年度, RString 年度内連番) {

        DbT7022ShoriDateKanriEntity entity = dac.selectByKey(サブ業務コード, 市町村コード, 処理名, 処理枝番, 年度, 年度内連番);
        if (null == entity) {
            return null;
        }
        entity.initializeMd5();

        return new DBC8010001(entity);
    }

    /**
     *
     * @param メニューID RString
     * @param 振込単位 RString
     * @return DBC8010001
     */
    public DBC8010001 getFurikomiGroupItakushaRelateEntity(RString メニューID, RString 振込単位) {
        List<FurikomiGroupItakushaRelateEntity> list = getFurikomiGroupItakushaRelateEntityList(メニューID, 振込単位);
        FurikomiGroupItakushaRelateEntity fentity = new FurikomiGroupItakushaRelateEntity();
        if (!list.isEmpty()) {
            fentity = list.get(0);
        }
        return new DBC8010001(fentity);
    }

    /**
     * 存在の存在。
     *
     * @param メニューID RString
     * @param 振込単位 RString
     * @return if存在
     */
    public boolean if存在(RString メニューID, RString 振込単位) {
        List<FurikomiGroupItakushaRelateEntity> list = getFurikomiGroupItakushaRelateEntityList(メニューID, 振込単位);
        return !list.isEmpty();
    }

    /**
     * 委託者情報の取得。
     *
     * @param メニューID RString
     * @param 振込単位 RString
     * @return List<FurikomiGroupItakushaRelateEntity>
     */
    public List<FurikomiGroupItakushaRelateEntity> getFurikomiGroupItakushaRelateEntityList(RString メニューID, RString 振込単位) {
        List<FurikomiGroupItakushaRelateEntity> list;
        RString 業務内区分 = new RString("");
        switch (メニューID.toString()) {
            case "DBCMN43003":
                switch (振込単位.toString()) {
                    case "1":
                        業務内区分 = FurikomiGyomunaiKubun.償還高額.getコード();
                        break;
                    case "2":
                        業務内区分 = FurikomiGyomunaiKubun.高額.getコード();
                        break;
                    default:
                        break;
                }
                break;
            case "DBCMN54002":
                switch (振込単位.toString()) {
                    case "1":
                        業務内区分 = FurikomiGyomunaiKubun.償還高額.getコード();
                        break;
                    case "2":
                        業務内区分 = FurikomiGyomunaiKubun.償還.getコード();
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        FurikomiItakushaKoseiMapperParameter parameter;
        parameter = FurikomiItakushaKoseiMapperParameter.createSelectByKeyParamAllowsNull(null, SubGyomuCode.DBC介護給付, 業務内区分, null, null, null);
        FurikomiGroupItakushaItakushaKoseiFinder finder = FurikomiGroupItakushaItakushaKoseiFinder.createInstance();
        list = finder.getFurikomiGroupItakushItakushKosei(parameter);
        return list;
    }
}
