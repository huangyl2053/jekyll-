/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.kyotsutokei.ConfigKeysGappeiJohoKanri;
import jp.co.ndensan.reams.db.dbz.service.kyushichosoncode.KyuShichosonCodeJoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import lombok.Getter;
import lombok.Setter;

/**
 * 旧市町村コード情報の取得処理のクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KyuShichosonCode {

    private static final RString 合併あり = new RString("1");
    private static final RString 合併なし = new RString("0");
    private LasdecCode 旧市町村コード;
    private HokenshaNo 旧保険者番号;
    private RString 旧市町村名称;
    private static DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private static DbT7055GappeiJohoDac 合併情報Dac;
    private static DbT7056GappeiShichosonDac 合併市町村Dac;

    /**
     * コンストラクタです。
     */
    private KyuShichosonCode() {
    }

    /**
     * 旧市町村コード情報の取得処理です。
     *
     * @param 市町村コード 市町村コード
     * @param 導入形態コード 導入形態コード
     * @return 旧市町村コード情報
     */
    public static KyuShichosonCodeJoho getKyuShichosonCodeJoho(LasdecCode 市町村コード, DonyukeitaiCode 導入形態コード) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        合併情報Dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
        合併市町村Dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
        if (DonyukeitaiCode.事務単一.equals(導入形態コード)
                || DonyukeitaiCode.事務構成市町村.equals(導入形態コード)
                || DonyukeitaiCode.認定単一.equals(導入形態コード)) {
            shichosonCodeJoho = getTannitsuKyuShichosonCodeJoho(市町村コード);
        } else if (DonyukeitaiCode.事務広域.equals(導入形態コード)
                || DonyukeitaiCode.認定広域.equals(導入形態コード)) {
            shichosonCodeJoho = getKouikiKyuShichosonCodeJoho(市町村コード);
        }
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho getTannitsuKyuShichosonCodeJoho(LasdecCode 市町村コード) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        if (合併あり.equals(BusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告))) {
            DbT7055GappeiJohoEntity 最新の地域番号 = 合併情報Dac.getSaisinNoTiikiNo(市町村コード);
            if (null == 最新の地域番号) {
                shichosonCodeJoho = get合併市町村無し旧市町村コード情報();
            } else {
                shichosonCodeJoho = get単一旧市町村コード情報(最新の地域番号);
            }
        } else if (合併なし.equals(BusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告))) {
            shichosonCodeJoho = get合併市町村無し旧市町村コード情報();
        }
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho getKouikiKyuShichosonCodeJoho(LasdecCode 市町村コード) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        if (合併あり.equals(BusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告))) {
            DbT7055GappeiJohoEntity 最新の地域番号 = 合併情報Dac.getSaisinNoTiikiNo(市町村コード);
            if (null == 最新の地域番号) {
                shichosonCodeJoho = get合併市町村無し旧市町村コード情報();
            } else {
                shichosonCodeJoho = get広域旧市町村コード情報(最新の地域番号);
            }
        } else if (合併なし.equals(BusinessConfig.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分, SubGyomuCode.DBU介護統計報告))) {
            shichosonCodeJoho = get合併市町村無し旧市町村コード情報();
        }
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho get合併市町村無し旧市町村コード情報() {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        List<KyuShichosonCode> list = new ArrayList<>();
        shichosonCodeJoho.set旧市町村コード情報List(list);
        shichosonCodeJoho.set合併市町村有無フラグ(Boolean.FALSE);
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho get単一合併市町村あり旧市町村コード情報(List<DbT7056GappeiShichosonEntity> 旧市町村コード情報List) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        List<KyuShichosonCode> shichosonCodes = new ArrayList<>();
        for (DbT7056GappeiShichosonEntity dbT7056GappeiShichosonEntity : 旧市町村コード情報List) {
            KyuShichosonCode shichosonCode = new KyuShichosonCode();
            shichosonCode.set旧保険者番号(dbT7056GappeiShichosonEntity.getKyuHokenshaNo());
            shichosonCode.set旧市町村コード(dbT7056GappeiShichosonEntity.getKyuShichosonCode());
            shichosonCode.set旧市町村名称(dbT7056GappeiShichosonEntity.getKyuShichosonMeisho());
            shichosonCodes.add(shichosonCode);
        }
        shichosonCodeJoho.set旧市町村コード情報List(shichosonCodes);
        shichosonCodeJoho.set合併市町村有無フラグ(Boolean.TRUE);
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho get広域合併市町村あり旧市町村コード情報(List<DbT7051KoseiShichosonMasterEntity> 旧市町村コード情報List) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        List<KyuShichosonCode> shichosonCodes = new ArrayList<>();
        for (DbT7051KoseiShichosonMasterEntity dbT7051KoseiShichosonMasterEntity : 旧市町村コード情報List) {
            KyuShichosonCode shichosonCode = new KyuShichosonCode();
            shichosonCode.set旧保険者番号(new HokenshaNo(dbT7051KoseiShichosonMasterEntity.getShoKisaiHokenshaNo().getColumnValue()));
            shichosonCode.set旧市町村コード(dbT7051KoseiShichosonMasterEntity.getShichosonCode());
            shichosonCode.set旧市町村名称(dbT7051KoseiShichosonMasterEntity.getShichosonMeisho());
            shichosonCodes.add(shichosonCode);
        }
        shichosonCodeJoho.set旧市町村コード情報List(shichosonCodes);
        shichosonCodeJoho.set合併市町村有無フラグ(Boolean.TRUE);
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho get単一旧市町村コード情報(DbT7055GappeiJohoEntity 最新の地域番号) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        List<DbT7056GappeiShichosonEntity> 旧市町村コード情報List = 合併市町村Dac.getTannitsuKyuShichosonCodeJohoList();
        int 地域番号の二桁目 = Integer.valueOf(最新の地域番号.getChiikiNo().substring(1, 2).toString());
        if (1 == 地域番号の二桁目) {
            shichosonCodeJoho = get単一合併市町村あり旧市町村コード情報(旧市町村コード情報List);
        } else if (1 < 地域番号の二桁目) {
            List<DbT7055GappeiJohoEntity> 合併情報List = 合併情報Dac.getGappeiJohoList(最新の地域番号.getChiikiNo());
            for (DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity : 合併情報List) {
                for (int i = 0; i < 旧市町村コード情報List.size(); i++) {
                    if (旧市町村コード情報List.get(i).getKyuShichosonCode().equals(dbT7055GappeiJohoEntity.getShichosonCode())) {
                        旧市町村コード情報List.remove(i);
                        break;
                    }
                }
            }
            shichosonCodeJoho = get単一合併市町村あり旧市町村コード情報(旧市町村コード情報List);
        }
        return shichosonCodeJoho;
    }

    private static KyuShichosonCodeJoho get広域旧市町村コード情報(DbT7055GappeiJohoEntity 最新の地域番号) {
        KyuShichosonCodeJoho shichosonCodeJoho = new KyuShichosonCodeJoho();
        RString 地域番号の一桁目 = 最新の地域番号.getChiikiNo().substring(0, 1);
        List<DbT7051KoseiShichosonMasterEntity> 旧市町村コード情報List = 構成市町村マスタDac.getKouikiKyuShichosonCodeJohoList(地域番号の一桁目);
        int 地域番号の二桁目 = Integer.valueOf(最新の地域番号.getChiikiNo().substring(1, 2).toString());
        if (1 == 地域番号の二桁目) {
            shichosonCodeJoho = get広域合併市町村あり旧市町村コード情報(旧市町村コード情報List);
        } else if (1 < 地域番号の二桁目) {
            List<DbT7055GappeiJohoEntity> 合併情報List = 合併情報Dac.getGappeiJohoList(最新の地域番号.getChiikiNo());
            for (DbT7055GappeiJohoEntity dbT7055GappeiJohoEntity : 合併情報List) {
                for (int i = 0; i < 旧市町村コード情報List.size(); i++) {
                    if (旧市町村コード情報List.get(i).getShichosonCode().equals(dbT7055GappeiJohoEntity.getShichosonCode())) {
                        旧市町村コード情報List.remove(i);
                        break;
                    }
                }
            }
            shichosonCodeJoho = get広域合併市町村あり旧市町村コード情報(旧市町村コード情報List);
        }
        return shichosonCodeJoho;
    }
}
