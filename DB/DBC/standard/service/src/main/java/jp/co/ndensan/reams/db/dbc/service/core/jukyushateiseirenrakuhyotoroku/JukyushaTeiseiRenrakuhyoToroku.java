/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushateiseirenrakuhyotoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KeikakuSakuseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jukyushaatenaayouhou.JukyushaAtenaJyouhouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaatenaayouhou.JukyushaAtenaJyouhouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushaatenajyouhou.IJukyushaAtenaJyouhouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
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
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final MapperProvider mProvider;
    private static final RString 新規モード = new RString("新規モード");
    private static final RString 被保険者 = new RString("被保険者");
    private static final RString サービス種類コード_43 = new RString("43");
    private static final RString サービス種類コード_46 = new RString("46");
    private static final RString 基本情報準拠区分_0 = new RString("0");
    private static final RString 基本情報準拠区分_1 = new RString("1");

    /**
     * コンストラクタです。
     */
    JukyushaTeiseiRenrakuhyoToroku() {
        this.dbt3001Dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
        this.dbt1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbt7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbt7063Dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
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
            DbT3001JukyushaIdoRenrakuhyoEntity 受給者訂正Entity = new DbT3001JukyushaIdoRenrakuhyoEntity();
            FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
            受給者訂正Entity.setShoKisaiHokenshaNo(証記載保険者番号と広域保険者番号.get(0));
            受給者訂正Entity.setHiHokenshaNo(被保険者番号);
            受給者訂正Entity.setIdoYMD(システム日付);
            受給者訂正Entity.setSeibetsuCode(psm_entity.get性別コード());
            受給者訂正Entity.setUmareYMD(psm_entity.get生年月日());
            受給者訂正Entity.setHiHokenshaNameKana(psm_entity.getカナ名称());
            受給者訂正Entity.setSofuYM(システム日付.getYearMonth());
            受給者訂正 = new JukyushaIdoRenrakuhyo(受給者訂正Entity);
        } else {
            DbT3001JukyushaIdoRenrakuhyoEntity 受給者訂正Entity
                    = dbt3001Dac.select受給者訂正情報(被保険者番号.getColumnValue(),
                            new RString(異動日.toString()), 論理削除フラグ, 履歴番号);
            if (受給者訂正Entity == null) {
                return null;
            }
            受給者訂正 = new JukyushaIdoRenrakuhyo(受給者訂正Entity);
        }
        return 受給者訂正;
    }

    /**
     * 証記載保険者番号と広域保険者番号取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate return List<ShoKisaiHokenshaNo>
     */
    private List<ShoKisaiHokenshaNo> getShokisaiNotoKouikiNo(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村セキュリティ情報.get導入形態コード();
        ShoKisaiHokenshaNo 証記載保険者番号 = null;
        ShoKisaiHokenshaNo 広域保険者番号 = null;
        List<ShoKisaiHokenshaNo> 証記載保険者番号と広域保険者番号 = new ArrayList();
        if (DonyuKeitaiCode.事務単一.getCode().equals(導入形態コード.getKey())
                || DonyuKeitaiCode.事務構成市町村.getCode().equals(導入形態コード.getKey())) {
            List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
            証記載保険者番号 = 市町村情報.get(0).get証記載保険者番号();
        } else {
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
                証記載保険者番号 = 市町村コードによる市町村情報.get(0).get証記載保険者番号();
                List<KoikiZenShichosonJoho> 市町村情報 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho().records();
                広域保険者番号 = 市町村情報.get(0).get証記載保険者番号();
            }
        }
        証記載保険者番号と広域保険者番号.add(証記載保険者番号);
        証記載保険者番号と広域保険者番号.add(広域保険者番号);
        return 証記載保険者番号と広域保険者番号;
    }

    /**
     * 市町村コードと広住例措置元市町村コード取得のメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 FlexibleDate
     */
    private DbT1001HihokenshaDaichoEntity get市町村コードと広住例措置元市町村コード(HihokenshaNo 被保険者番号, FlexibleDate 異動日) {
        DbT1001HihokenshaDaichoEntity dbt1001Entity = dbt1001Dac.selectByHihokenshaNo(被保険者番号);
        if (dbt1001Entity == null) {
            return new DbT1001HihokenshaDaichoEntity();
        }
        if (dbt1001Entity.getIdoYMD().equals(異動日)) {
            return dbt1001Entity;
        } else if (dbt1001Entity.getIdoYMD().isBefore(異動日)) {
            if (DBACodeShubetsu.介護資格喪失事由_被保険者.getCodeShubetsu().getColumnValue().equals(dbt1001Entity.getIdoJiyuCode())) {
                throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(被保険者.toString()));
            }
            return dbt1001Entity;
        } else {
            if (DBACodeShubetsu.介護資格取得事由_被保険者.getCodeShubetsu().getColumnValue().equals(dbt1001Entity.getIdoJiyuCode())) {
                throw new ApplicationException(UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(被保険者.toString()));
            }
            return dbt1001Entity;
        }
    }

    /**
     * 支援事業者名称取得のメソッドです。
     *
     * @param 支援事業者番号 JigyoshaNo
     * @param 計画作成区分 RString
     * @param 基準日 FlexibleDate
     *
     * @return RString
     */
    public AtenaMeisho getSienJikyoshaName(JigyoshaNo 支援事業者番号, RString 計画作成区分, FlexibleDate 基準日) {
        if (支援事業者番号 == null || 支援事業者番号.isEmpty()) {
            return null;
        }
        DbT7063KaigoJigyoshaShiteiServiceEntity 介護事業者指定サービスentity = null;
        if (JukyushaIF_KeikakuSakuseiKubunCode.居宅介護支援事業所作成.getコード().equals(計画作成区分)) {
            介護事業者指定サービスentity = dbt7063Dac.select事業者名称(支援事業者番号.value(), サービス種類コード_43, 基準日);
        } else if (JukyushaIF_KeikakuSakuseiKubunCode.介護予防支援事業所_地域包括支援センター作成.getコード().equals(計画作成区分)) {
            介護事業者指定サービスentity = dbt7063Dac.select事業者名称(支援事業者番号.value(), サービス種類コード_46, 基準日);
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
