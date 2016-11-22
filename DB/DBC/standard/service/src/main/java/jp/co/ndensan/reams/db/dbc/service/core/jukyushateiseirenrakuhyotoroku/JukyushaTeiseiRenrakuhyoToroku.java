/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyoBuilder;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushaatenaayouhou.JukyushaAtenaJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaatenaayouhou.JukyushaAtenaJyouhouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushaatenajyouhou.IJukyushaAtenaJyouhouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_kyotakuServiceSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCKD00007_(共有子Div)受給者異動連絡票（画面）のビジネスクラスです。
 *
 * @reamsid_L DBC-4350-110 chenhui
 */
public class JukyushaTeiseiRenrakuhyoToroku {

    private final DbT3001JukyushaIdoRenrakuhyoDac dbt3001Dac;
    private final DbT1001HihokenshaDaichoDac dbt1001Dac;
    private final DbT7060KaigoJigyoshaDac dbt7060Dac;
    private final DbT7063KaigoJigyoshaShiteiServiceDac dbt7063Dac;
    private final DbT4001JukyushaDaichoDac dbt4001Dac;
    private final DbT3105SogoJigyoTaishoshaDac dbt3105Dac;
    private final MapperProvider mProvider;
    private static final RString 新規モード = new RString("新規モード");
    private static final RString 被保険者 = new RString("被保険者");
    private static final RString サービス種類コード_43 = new RString("43");
    private static final RString サービス種類コード_46 = new RString("46");
    private static final RString 基本情報準拠区分_0 = new RString("0");
    private static final RString 基本情報準拠区分_1 = new RString("1");
    private static final RString 介護資格取得事由 = new RString("0007");
    private static final RString 介護資格喪失事由 = new RString("0010");
    private static final RString 自己作成 = new RString("自己作成");

    /**
     * コンストラクタです。
     */
    JukyushaTeiseiRenrakuhyoToroku() {
        this.dbt3001Dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
        this.dbt1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbt7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbt7063Dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
        this.dbt4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbt3105Dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        this.mProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * にて生成した{@link JukyushaTeiseiRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return TokuchoHeijunkaKakutei
     */
    public static JukyushaTeiseiRenrakuhyoToroku createInstance() {
        return InstanceProvider.create(JukyushaTeiseiRenrakuhyoToroku.class);
    }

    /**
     * 受給者異動情報取得のメソッドです。
     *
     * @param 処理モード RString
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 int
     * @param 論理削除フラグ RString
     * @param 異動日 FlexibleDate
     *
     * @return JukyushaIdoRenrakuhyo
     *
     */
    public JukyushaIdoRenrakuhyo getJukyushaIdoJoho(RString 処理モード, ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号,
            int 履歴番号, boolean 論理削除フラグ, FlexibleDate 異動日) {
        JukyushaIdoRenrakuhyo 受給者訂正;
        if (新規モード.equals(処理モード)) {
            IJukyushaAtenaJyouhouMapper mapper = mProvider.create(IJukyushaAtenaJyouhouMapper.class);
            ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                    KensakuYusenKubun.住登外優先);
            builder.setデータ取得区分(DataShutokuKubun.直近レコード);
            builder.set識別コード(識別コード);
            IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
            JukyushaAtenaJyouhouParameter parameter_宛名 = JukyushaAtenaJyouhouParameter.createSelectByKeyParam(searchKey);
            JukyushaAtenaJyouhouEntity psm_entity = mapper.get宛名情報(parameter_宛名);
            List<ShoKisaiHokenshaNo> 証記載保険者番号と広域保険者番号 = getShokisaiNotoKouikiNo(被保険者番号, 異動日);
            ShoKisaiHokenshaNo 証記載保険者番号 = new ShoKisaiHokenshaNo(RString.EMPTY);
            if (証記載保険者番号と広域保険者番号.get(0) != null) {
                証記載保険者番号 = 証記載保険者番号と広域保険者番号.get(0);
            }
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            if (被保険者番号 == null) {
                被保険者番号 = new HihokenshaNo(RString.EMPTY);
            }
            受給者訂正 = new JukyushaIdoRenrakuhyo(
                    システム日付, RString.EMPTY, RString.EMPTY, 証記載保険者番号, 被保険者番号, 履歴番号);
            JukyushaIdoRenrakuhyoBuilder 受給者訂正Builder = 受給者訂正.createBuilderForEdit();
            受給者訂正Builder.set送付年月(システム日付.getYearMonth());
            受給者訂正Builder.set証記載保険者番号(証記載保険者番号);
            if (証記載保険者番号と広域保険者番号.get(1) != null) {
                受給者訂正Builder.set広域連合_政令市_保険者番号(証記載保険者番号と広域保険者番号.get(1));
            }
            if (psm_entity != null) {
                受給者訂正Builder.set性別コード(psm_entity.get性別コード());
                受給者訂正Builder.set生年月日(psm_entity.get生年月日());
                受給者訂正Builder.set被保険者氏名カナ(psm_entity.getカナ名称());
            }
            受給者訂正 = 受給者訂正Builder.build();
        } else {
            DbT3001JukyushaIdoRenrakuhyoEntity 受給者訂正Entity
                    = dbt3001Dac.select受給者訂正情報(被保険者番号 == null ? null : 被保険者番号.getColumnValue(),
                            異動日 == null ? null : new RString(異動日.toString()),
                            論理削除フラグ, 履歴番号);
            if (受給者訂正Entity == null) {
                return null;
            }
            受給者訂正 = new JukyushaIdoRenrakuhyo(受給者訂正Entity);
        }
        return 受給者訂正;
    }

    /**
     * 検索した被保番号が　受給者異動送付に検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean selectBooleanHihokenshaNo(HihokenshaNo 被保険者番号) {
        List<DbT3001JukyushaIdoRenrakuhyoEntity> 受給者訂正Entity
                = dbt3001Dac.selectHihokenshaNo(被保険者番号 == null ? null : 被保険者番号);
        return 受給者訂正Entity == null || 受給者訂正Entity.isEmpty();
    }

    /**
     * 検索した被保番号が　受給者異動送付に検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean selectBooleanDbT3105SogoJigyoTaishosha(HihokenshaNo 被保険者番号) {
        List<DbT3105SogoJigyoTaishoshaEntity> 事業対象者Entity
                = dbt3105Dac.get事業対象者(被保険者番号 == null ? null : 被保険者番号);
        return 事業対象者Entity == null || 事業対象者Entity.isEmpty();
    }

    /**
     * 検索した被保番号が　受給者異動送付に検索
     *
     * @param 被保険者番号 HihokenshaNo
     * @return boolean
     */
    public boolean selectBooleanDbT4001JukyushaDaicho(HihokenshaNo 被保険者番号) {
        List<DbT4001JukyushaDaichoEntity> 受給者台帳Entity
                = dbt4001Dac.get受給者台帳(被保険者番号 == null ? null : 被保険者番号);
        return 受給者台帳Entity == null || 受給者台帳Entity.isEmpty();
    }

    /**
     * 証記載保険者番号と広域保険者番号取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     *
     * @return List<ShoKisaiHokenshaNo>
     */
    public List<ShoKisaiHokenshaNo> getShokisaiNotoKouikiNo(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        ShoKisaiHokenshaNo 証記載保険者番号 = null;
        ShoKisaiHokenshaNo 広域保険者番号 = null;
        List<ShoKisaiHokenshaNo> 証記載保険者番号と広域保険者番号 = new ArrayList();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getKey())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getKey())) {
            List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
            if (!市町村情報.isEmpty()) {
                証記載保険者番号 = 市町村情報.get(0).get証記載保険者番号();
            }
        } else if (被保険者番号 != null && 異動日 != null) {
            DbT1001HihokenshaDaichoEntity dbt1001Entity = get市町村コードと広住例措置元市町村コード(被保険者番号, 異動日);
            LasdecCode 市町村コード = null;
            if (dbt1001Entity.getKoikinaiTokureiSochimotoShichosonCode() != null) {
                市町村コード = dbt1001Entity.getKoikinaiTokureiSochimotoShichosonCode();
            } else if (dbt1001Entity.getShichosonCode() != null) {
                市町村コード = dbt1001Entity.getShichosonCode();
            }
            if (DonyuKeitaiCode.事務広域.getCode().equals(導入形態コード.getKey())) {
                List<ShichosonCodeYoriShichoson> 市町村コードによる市町村情報
                        = KoikiShichosonJohoFinder.createInstance().shichosonCodeYoriShichosonJoho(市町村コード).records();
                証記載保険者番号 = get証記載保険者番号(市町村コードによる市町村情報);
                List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
                広域保険者番号 = get広域保険者番号(市町村情報);
            }
        }
        証記載保険者番号と広域保険者番号.add(証記載保険者番号);
        証記載保険者番号と広域保険者番号.add(広域保険者番号);
        return 証記載保険者番号と広域保険者番号;
    }

    private ShoKisaiHokenshaNo get証記載保険者番号(List<ShichosonCodeYoriShichoson> 市町村コードによる市町村情報) {
        if (市町村コードによる市町村情報 != null && !市町村コードによる市町村情報.isEmpty()) {
            return 市町村コードによる市町村情報.get(0).get証記載保険者番号();
        }
        return null;
    }

    private ShoKisaiHokenshaNo get広域保険者番号(List<KoikiZenShichosonJoho> 市町村情報) {
        if (市町村情報 != null && !市町村情報.isEmpty()) {
            return 市町村情報.get(0).get証記載保険者番号();
        }
        return null;
    }

    /**
     * 市町村コードと広住例措置元市町村コード取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     *
     * @return DbT1001HihokenshaDaichoEntity
     */
    public DbT1001HihokenshaDaichoEntity get市町村コードと広住例措置元市町村コード(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        DbT1001HihokenshaDaichoEntity maxEntity
                = dbt1001Dac.selectMax異動日(被保険者番号, 異動日.getYearMonth());
        if (maxEntity != null && maxEntity.getIdoYMD().isBeforeOrEquals(異動日)) {
            if (maxEntity.getIdoYMD().equals(異動日)) {
                return maxEntity;
            }
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(介護資格喪失事由), FlexibleDate.getNowDate());
            for (UzT0007CodeEntity list : codeList) {
                if (list.getコード().value().equals(maxEntity.getIdoJiyuCode())) {
                    throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(被保険者.toString()));
                }
            }
            return maxEntity;
        } else {
            DbT1001HihokenshaDaichoEntity minEntity
                    = dbt1001Dac.selectMin異動日(被保険者番号, 異動日.getYearMonth());
            if (minEntity == null) {
                throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(被保険者.toString()));
            }
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(介護資格取得事由), FlexibleDate.getNowDate());
            for (UzT0007CodeEntity list : codeList) {
                if (list.getコード().value().equals(minEntity.getIdoJiyuCode())) {
                    throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(被保険者.toString()));
                }
            }
            return minEntity;
        }
    }

    /**
     * 支援事業者名称取得のメソッドです。
     *
     * @param 支援事業者番号 JigyoshaNo
     * @param 計画作成区分 RString
     * @param 基準日 FlexibleDate
     *
     * @return AtenaMeisho
     */
    public AtenaMeisho getSienJikyoshaName(JigyoshaNo 支援事業者番号, RString 計画作成区分, FlexibleDate 基準日) {
        if (支援事業者番号 == null || 支援事業者番号.isEmpty()) {
            return null;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定サービスentity = null;
        if (JukyushaIF_kyotakuServiceSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(計画作成区分)) {
            介護事業者指定サービスentity = dbt7063Dac.select事業者名称(支援事業者番号.value(), サービス種類コード_43, 基準日);
        } else if (JukyushaIF_kyotakuServiceSakuseiKubunCode.介護予防支援事業所作成.getコード().equals(計画作成区分)) {
            介護事業者指定サービスentity = dbt7063Dac.select事業者名称(支援事業者番号.value(), サービス種類コード_46, 基準日);
        } else if (JukyushaIF_kyotakuServiceSakuseiKubunCode.自己作成.getコード().equals(計画作成区分)) {
            return new AtenaMeisho(自己作成);
        }
        if (介護事業者指定サービスentity == null) {
            return null;
        }
        if (基本情報準拠区分_0.equals(介護事業者指定サービスentity.getKihonJohoJunkyoKubun())) {
            return 介護事業者指定サービスentity.getJigyoshaName();
        } else if (基本情報準拠区分_1.equals(介護事業者指定サービスentity.getKihonJohoJunkyoKubun())) {
            DbT7060KaigoJigyoshaEntity 介護事業者Entity = dbt7060Dac.select事業者の名称(支援事業者番号, 基準日);
            if (介護事業者Entity != null) {
                return 介護事業者Entity.getJigyoshaName();
            }
        }
        return null;
    }
}
