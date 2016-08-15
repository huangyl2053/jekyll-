 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.config.kyotsu.hokenshajoho.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KanriJoho;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurityjoho.KoseiShichosonJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.DousaKanren;
import jp.co.ndensan.reams.db.dbx.definition.core.RojinHokenJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.chohyo.kyotsu.ChohyoKyotsuJushoHenshuHoho;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.util.ObjectUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7908KaigoDonyuKeitaiDac;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.auth.AuthItem;
import jp.co.ndensan.reams.uz.uza.auth.AuthType;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import lombok.Getter;
import lombok.Setter;

/**
 * 市町村セキュリティ情報取得のクラスです。
 *
 * @reamsid_L DBU-0050-010 liangbc
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShichosonSecurityJoho {

    private static final RString 権限項目種類 = new RString("koseiShichosonKengen");
    private static final RString 導入済 = new RString("1");
    private static final RString 未導入 = new RString("0");
    private static final Integer 市町村ＩＤ有効桁数_DEFAULT = 2;
    private static final Integer 市町村識別ID_MAX = 99;
    private static final RString 市町村識別ID_DEFAULT = new RString("00");

    private static DbT7908KaigoDonyuKeitaiDac 介護導入形態Dac;
    private static DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private RString 介護導入区分;
    private Code 導入形態コード;
    private Boolean 支所管理有無フラグ;
    private RString 広域タイプ;
    private Integer 市町村ＩＤ有効桁数;
    private KoseiShichosonJoho 市町村情報;

    /**
     * コンストラクタです。
     */
    private ShichosonSecurityJoho() {
    }

    /**
     * 市町村セキュリティ情報を取得する(画面用)
     *
     * @param 業務分類 業務分類
     * @return 市町村セキュリティ情報
     */
    public static ShichosonSecurityJoho getShichosonSecurityJoho(GyomuBunrui 業務分類) {
        return getShichosonSecurityJoho(業務分類, null);
    }

    /**
     * 市町村セキュリティ情報を取得する(Batch用)
     *
     * @param 業務分類 業務分類
     * @param loginUserId 画面からのloginUserId
     * @return 市町村セキュリティ情報
     */
    public static ShichosonSecurityJoho getShichosonSecurityJoho(GyomuBunrui 業務分類, RString loginUserId) {
        requireNonNull(業務分類, UrErrorMessages.対象データなし.getMessage().toString());
        介護導入形態Dac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        List<DbT7908KaigoDonyuKeitaiEntity> entitys = 介護導入形態Dac.selectByGyomuBunrui(業務分類.code());
        if (entitys.isEmpty()) {
            return get未導入市町村セキュリティ情報();
        } else {
            DbT7908KaigoDonyuKeitaiEntity 介護導入形態 = entitys.get(0);
            return get導入済市町村セキュリティ情報(介護導入形態, loginUserId);
        }
    }

    /**
     * 市町村識別IDをキーに構成市町村マスタ(DbT7051KoseiShichosonMaster)から一致する構成市町村情報を取得する、取得できない場合、NULLを返す
     *
     * @param 市町村識別ID 市町村識別ID
     * @return 構成市町村情報
     */
    public static KoseiShichosonJoho getKouseiShichosonJoho(RString 市町村識別ID) {
        if (!is市町村識別ID市町村識別IDが01から99である(市町村識別ID)) {
            return null;
        }
        構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        DbT7051KoseiShichosonMasterEntity dbT7051KoseiShichosonMasterEntity = 構成市町村マスタDac.selectByKey(市町村識別ID);
        if (null == dbT7051KoseiShichosonMasterEntity) {
            return null;
        } else {
            return get構成市町村情報(dbT7051KoseiShichosonMasterEntity);
        }
    }

    /**
     * 業務コンフィグから管理情報を取得する
     *
     * @param 業務分類 業務分類
     * @return 管理情報
     */
    public static KanriJoho getKanriJoho(GyomuBunrui 業務分類) {
        requireNonNull(業務分類, UrErrorMessages.対象データなし.getMessage().toString());
        介護導入形態Dac = InstanceProvider.create(DbT7908KaigoDonyuKeitaiDac.class);
        List<DbT7908KaigoDonyuKeitaiEntity> entitys = 介護導入形態Dac.selectByGyomuBunrui(業務分類.code());
        if (entitys.isEmpty()) {
            return null;
        } else {
            DbT7908KaigoDonyuKeitaiEntity 介護導入形態 = entitys.get(0);
            return getKanriJoho(介護導入形態);
        }
    }

    private static KanriJoho getKanriJoho(DbT7908KaigoDonyuKeitaiEntity 介護導入形態) {
        requireNonNull(介護導入形態, UrErrorMessages.対象データなし.getMessage().toString());
        KanriJoho 管理情報 = new KanriJoho();
        管理情報.set導入形態コード(介護導入形態.getDonyuKeitaiCode());
        管理情報.set支所管理有無フラグ(介護導入形態.getShishoKanriUmuFlag());
        管理情報.set広域タイプ(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_広域タイプ, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        管理情報.set市町村ＩＤ有効桁数(市町村ＩＤ有効桁数_DEFAULT);
        管理情報.set市町村情報(get市町村情報Form介護共通業務コンフィグ());
        return 管理情報;
    }

    /**
     * 公開メソッドを利用して、市町村識別IDを取得する
     *
     * @param reamsLoginId ログインユーザID
     * @return 市町村識別ID
     */
    public static List<AuthorityItem> getShichosonShikibetsuId(RString reamsLoginId) {
        requireNonNull(reamsLoginId, UrErrorMessages.対象データなし.getMessage().toString());
        return AuthItem.getAuthorities(reamsLoginId, new AuthType.Of().kinds(権限項目種類).create(), RDate.getNowDate());
    }

    private static ShichosonSecurityJoho get未導入市町村セキュリティ情報() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = new ShichosonSecurityJoho();
        市町村セキュリティ情報.set介護導入区分(未導入);
        市町村セキュリティ情報.set導入形態コード(null);
        市町村セキュリティ情報.set支所管理有無フラグ(Boolean.FALSE);
        市町村セキュリティ情報.set広域タイプ(null);
        市町村セキュリティ情報.set市町村ＩＤ有効桁数(null);
        市町村セキュリティ情報.set市町村情報(null);
        return 市町村セキュリティ情報;
    }

    private static ShichosonSecurityJoho get導入済市町村セキュリティ情報(DbT7908KaigoDonyuKeitaiEntity 介護導入形態, RString loginUserId) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = new ShichosonSecurityJoho();
        市町村セキュリティ情報.set介護導入区分(導入済);
        if (new Code("120").equals(介護導入形態.getDonyuKeitaiCode())
                || new Code("112").equals(介護導入形態.getDonyuKeitaiCode())
                || new Code("220").equals(介護導入形態.getDonyuKeitaiCode())) {
            KanriJoho kanriJoho = getKanriJoho(介護導入形態);
            converterKanriJohoToShichosonSecurityJoho(市町村セキュリティ情報, kanriJoho);
        } else if (new Code("111").equals(介護導入形態.getDonyuKeitaiCode())
                || new Code("211").equals(介護導入形態.getDonyuKeitaiCode())) {
            RString 市町村識別ID = getShichosonShikibetsuId(
                    ObjectUtil.defaultIfNull(loginUserId, UrControlDataFactory.createInstance().getLoginInfo().getUserId())).get(0).getItemId();
            if (市町村識別ID_DEFAULT.equals(市町村識別ID)) {
                KanriJoho kanriJoho = getKanriJoho(介護導入形態);
                converterKanriJohoToShichosonSecurityJoho(市町村セキュリティ情報, kanriJoho);
            } else {
                市町村セキュリティ情報.set市町村情報(getKouseiShichosonJoho(市町村識別ID));
                市町村セキュリティ情報.set導入形態コード(介護導入形態.getDonyuKeitaiCode());
                市町村セキュリティ情報.set支所管理有無フラグ(介護導入形態.getShishoKanriUmuFlag());
                市町村セキュリティ情報.set広域タイプ(
                        DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_広域タイプ, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
                市町村セキュリティ情報.set市町村ＩＤ有効桁数(市町村ＩＤ有効桁数_DEFAULT);
            }
        }
        return 市町村セキュリティ情報;
    }

    private static boolean is市町村識別ID市町村識別IDが01から99である(RString 市町村識別ID) {
        int shichosonShokibetsuID;
        if (null == 市町村識別ID) {
            return Boolean.FALSE;
        }
        try {
            shichosonShokibetsuID = Integer.valueOf(市町村識別ID.toString());
        } catch (NumberFormatException ex) {
            return Boolean.FALSE;
        }
        if (1 <= shichosonShokibetsuID && shichosonShokibetsuID <= 市町村識別ID_MAX) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private static KoseiShichosonJoho get構成市町村情報(DbT7051KoseiShichosonMasterEntity entity) {
        KoseiShichosonJoho 構成市町村情報 = new KoseiShichosonJoho();
        構成市町村情報.set市町村識別ID(entity.getShichosonShokibetsuID());
        構成市町村情報.set市町村コード(entity.getShichosonCode());
        構成市町村情報.set証記載保険者番号(entity.getShoKisaiHokenshaNo());
        構成市町村情報.set国保連広域内市町村番号(entity.getKokuhorenKoikiShichosonNo());
        構成市町村情報.set市町村名称(entity.getShichosonMeisho());
        構成市町村情報.set都道府県名称(entity.getTodofukenMeisho());
        構成市町村情報.set郡名称(entity.getGunMeisho());
        構成市町村情報.set郵便番号(entity.getYubinNo());
        構成市町村情報.set住所(entity.getJusho());
        構成市町村情報.set電話番号(entity.getTelNo());
        構成市町村情報.set最優先地区コード(entity.getYusenChikuCode());
        構成市町村情報.set帳票用都道府県名称表示有無(entity.getTyohyoTodoufukenHyojiUmu());
        構成市町村情報.set帳票用郡名称表示有無(entity.getTyohyoGunHyojiUmu());
        構成市町村情報.set帳票用市町村名称表示有無(entity.getTyohyoShichosonHyojiUmu());
        構成市町村情報.set帳票用住所編集方法(entity.getTyohyoJushoHenshuHouhou());
        構成市町村情報.set帳票用方書表示有無(entity.getTyohyoKatagakiHyojiUmu());
        構成市町村情報.set老人保健市町村番号(entity.getRojinhokenShichosonNo());
        構成市町村情報.set老人保健受給者番号体系(entity.getRokenJukyushaNoTaikei());
        構成市町村情報.set特徴分配集約(entity.getTokuchoBunpaishuyaku());
        構成市町村情報.set移行日(entity.getIkoYMD());
        構成市町村情報.set加入日(entity.getKanyuYMD());
        構成市町村情報.set離脱日(entity.getRidatsuYMD());
        構成市町村情報.set合併旧市町村区分(entity.getGappeiKyuShichosonKubun());
        構成市町村情報.set合併旧市町村表示有無(entity.getGappeiKyuShichosonHyojiUmu());
        構成市町村情報.set合併情報地域番号(entity.getGappeiChiikiNo());
        構成市町村情報.set運用保険者番号(entity.getUnyoHokenshaNo());
        構成市町村情報.set運用開始日(entity.getUnyoKaishiYMD());
        構成市町村情報.set運用終了日(entity.getUnyoShuryoYMD());
        構成市町村情報.set運用形態区分(entity.getUnyoKeitaiKubun());
        return 構成市町村情報;
    }

    private static KoseiShichosonJoho get市町村情報Form介護共通業務コンフィグ() {
        KoseiShichosonJoho 市町村情報 = new KoseiShichosonJoho();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        市町村情報.set市町村識別ID(市町村識別ID_DEFAULT);
        市町村情報.set市町村コード(導入団体クラス.get地方公共団体コード());
        市町村情報.set証記載保険者番号(
                new ShoKisaiHokenshaNo(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        市町村情報.set国保連広域内市町村番号(RString.EMPTY);
        市町村情報.set市町村名称(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_保険者名称, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set都道府県名称(導入団体クラス.get都道府県名());
        市町村情報.set郡名称(導入団体クラス.get郡名());
        市町村情報.set郵便番号(new YubinNo(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_郵便番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        市町村情報.set住所(new AtenaJusho(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_住所, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        市町村情報.set電話番号(new TelNo(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_電話番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告)));
        市町村情報.set最優先地区コード(DbBusinessConfig.get(ConfigKeysHokenshaJoho.保険者情報_最優先地区コード, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set帳票用都道府県名称表示有無(DbBusinessConfig.get(
                ChohyoKyotsuJushoHenshuHoho.KannaiJushoHenshu.帳票共通住所編集方法_管内住所編集_都道府県名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set帳票用郡名称表示有無(DbBusinessConfig.get(
                ChohyoKyotsuJushoHenshuHoho.KannaiJushoHenshu.帳票共通住所編集方法_管内住所編集_郡名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set帳票用市町村名称表示有無(DbBusinessConfig.get(
                ChohyoKyotsuJushoHenshuHoho.KannaiJushoHenshu.帳票共通住所編集方法_管内住所編集_市町村名付与有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set帳票用住所編集方法(DbBusinessConfig.get(
                ChohyoKyotsuJushoHenshuHoho.KannaiJushoHenshu.帳票共通住所編集方法_管内住所編集_編集方法, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set帳票用方書表示有無(DbBusinessConfig.get(
                ChohyoKyotsuJushoHenshuHoho.JushoHenshu.帳票共通住所編集方法_住所編集_方書表示有無, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set老人保健市町村番号(DbBusinessConfig.get(
                RojinHokenJoho.老人保健情報_市町村番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        市町村情報.set老人保健受給者番号体系(DbBusinessConfig.get(
                RojinHokenJoho.老人保健情報_管理体系, RDate.getNowDate(), SubGyomuCode.DBD介護受給));
        市町村情報.set特徴分配集約(DbBusinessConfig.get(
                DousaKanren.動作関連_特徴分配集約システム, RDate.getNowDate(), SubGyomuCode.DBB介護賦課));
        市町村情報.set移行日(FlexibleDate.EMPTY);
        市町村情報.set加入日(FlexibleDate.EMPTY);
        市町村情報.set離脱日(FlexibleDate.EMPTY);
        市町村情報.set合併旧市町村区分(RString.EMPTY);
        市町村情報.set合併旧市町村表示有無(RString.EMPTY);
        市町村情報.set合併情報地域番号(RString.EMPTY);
        市町村情報.set運用保険者番号(ShoKisaiHokenshaNo.EMPTY);
        市町村情報.set運用開始日(FlexibleDate.EMPTY);
        市町村情報.set運用終了日(FlexibleDate.EMPTY);
        市町村情報.set運用形態区分(RString.EMPTY);
        return 市町村情報;
    }

    private static void converterKanriJohoToShichosonSecurityJoho(ShichosonSecurityJoho 市町村セキュリティ情報, KanriJoho kanriJoho) {
        市町村セキュリティ情報.set導入形態コード(kanriJoho.get導入形態コード());
        市町村セキュリティ情報.set市町村ＩＤ有効桁数(kanriJoho.get市町村ＩＤ有効桁数());
        市町村セキュリティ情報.set広域タイプ(kanriJoho.get広域タイプ());
        市町村セキュリティ情報.set支所管理有無フラグ(kanriJoho.is支所管理有無フラグ());
        市町村セキュリティ情報.set市町村情報(kanriJoho.get市町村情報());
    }

}
