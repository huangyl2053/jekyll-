/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hihokenshashoshikakushohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter;
import static jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter.createParam;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KaigoHokenShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ServiceTypeListEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.hihokenshoshikakushohakko.IHihokenshoShikakushoHakkoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共有子Div「被保険者証・資格証」の状態を変更するクラスです
 *
 */
public class HihokenshashoShikakushoHakkoFinder {

    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString JIBUNSAKUSEI = new RString("自己作成");
    private static final RString 居宅サービス計画 = new RString("1");
    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final DbT4001JukyushaDaichoDac dbT4001Dac;
    private final DbT7130KaigoServiceShuruiDac dbT7130Dac;
    private final DbT3006KyotakuKeikakuJigyoshaSakuseiDac dbT3006Dac;
    private final DbT3007KyotakuKeikakuJikoSakuseiDac dbT3007Dac;
    private final DbT7060KaigoJigyoshaDac dbT7060Dac;
    private final DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac;
    private static final int HYOJI_SIZE = 150;

    /**
     * 支払方法変更管理区分を表す列挙型です。
     *
     * @author LDNS
     */
    public enum ShiharaiHenkoKanriKubun {

        /**
         * コード:1 名称:２号差止 略称:定義なし
         */
        _２号差止("1", "２号差止"),
        /**
         * コード:2 名称:１号償還払い化 略称:定義なし
         */
        _１号償還払い化("2", "１号償還払い化"),
        /**
         * コード:3 名称:１号給付額減額 略称:定義なし
         */
        _１号給付額減額("3", "１号給付額減額");

        private final RString code;
        private final RString fullName;

        private ShiharaiHenkoKanriKubun(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        /**
         * 支払方法変更管理区分のコードを返します。
         *
         * @return 支払方法変更管理区分のコード
         */
        public RString getコード() {
            return code;
        }

        /**
         * 支払方法変更管理区分の名称を返します。
         *
         * @return 支払方法変更管理区分の名称
         */
        public RString get名称() {
            return fullName;
        }

        /**
         * 支払方法変更管理区分のコードと一致する内容を探します。
         *
         * @param code 支払方法変更管理区分のコード
         * @return {@code code} に対応する支払方法変更管理区分
         */
        public static ShiharaiHenkoKanriKubun toValue(RString code) {

            for (ShiharaiHenkoKanriKubun shiharaiHenkoKanriKubun : ShiharaiHenkoKanriKubun.values()) {
                if (shiharaiHenkoKanriKubun.code.equals(code)) {
                    return shiharaiHenkoKanriKubun;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更管理区分"));
        }
    }

    /**
     * 有効無効区分を表す列挙型です。
     *
     * @author LDNS
     */
    public enum YukoMukoKubun {

        /**
         * コード:0 名称:初期値（申請中の場合） 略称:定義なし
         */
        初期値_申請中の場合("0", "初期値（申請中の場合）"),
        /**
         * コード:1 名称:有効 略称:定義なし
         */
        有効("1", "有効"),
        /**
         * コード:2 名称:無効 略称:定義なし
         */
        無効("2", "無効");

        private final RString code;
        private final RString fullName;

        private YukoMukoKubun(String code, String fullname) {
            this.code = new RString(code);
            this.fullName = new RString(fullname);
        }

        /**
         * 有効無効区分のコードを返します。
         *
         * @return 有効無効区分のコード
         */
        public RString getコード() {
            return code;
        }

        /**
         * 有効無効区分の名称を返します。
         *
         * @return 有効無効区分の名称
         */
        public RString get名称() {
            return fullName;
        }

        /**
         * 有効無効区分のコードと一致する内容を探します。
         *
         * @param code 有効無効区分のコード
         * @return {@code code} に対応する有効無効区分
         */
        public static YukoMukoKubun toValue(RString code) {

            for (YukoMukoKubun yukoMukoKubun : YukoMukoKubun.values()) {
                if (yukoMukoKubun.code.equals(code)) {
                    return yukoMukoKubun;
                }
            }
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("有効無効区分"));
        }
    }

    /**
     * コンストラクタです。
     */
    HihokenshashoShikakushoHakkoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.dbT4001Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.dbT7130Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.dbT3006Dac = InstanceProvider.create(DbT3006KyotakuKeikakuJigyoshaSakuseiDac.class);
        this.dbT3007Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);
        this.dbT7060Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.dbT1005Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    HihokenshashoShikakushoHakkoFinder(MapperProvider mapperProvider,
            DbT1001HihokenshaDaichoDac dbT1001Dac,
            DbT4001JukyushaDaichoDac dbT4001Dac,
            DbT7130KaigoServiceShuruiDac dbT7130Dac,
            DbT3006KyotakuKeikakuJigyoshaSakuseiDac dbT3006Dac,
            DbT3007KyotakuKeikakuJikoSakuseiDac dbT3007Dac,
            DbT7060KaigoJigyoshaDac dbT7060Dac,
            DbT1005KaigoJogaiTokureiTaishoShisetsuDac dbT1005Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT1001Dac = dbT1001Dac;
        this.dbT4001Dac = dbT4001Dac;
        this.dbT7130Dac = dbT7130Dac;
        this.dbT3006Dac = dbT3006Dac;
        this.dbT3007Dac = dbT3007Dac;
        this.dbT7060Dac = dbT7060Dac;
        this.dbT1005Dac = dbT1005Dac;
    }

    /**
     * インスタンスを生成します。
     *
     * @return {@link HihokenshashoShikakushoHakkoFinder}
     */
    public static HihokenshashoShikakushoHakkoFinder createInstance() {
        return InstanceProvider.create(HihokenshashoShikakushoHakkoFinder.class);
    }

    /**
     * 被保険者証資格証発行情報取得です。
     *
     * @param 被保険者番号 被保険者番号
     * @param メニューID メニューID
     * @return 被保険者証資格証発行情報取得Entity
     */
    @Transaction
    public HihokenshoShikakushoHakkoEntity 被保険者証資格証発行情報取得(HihokenshaNo 被保険者番号, RString メニューID) {

        // SQL発行
        IHihokenshoShikakushoHakkoMapper mapper = this.mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);
        HihokenshoShikakushoHakkoMapperParameter parameter
                = createParam(被保険者番号,
                        メニューID,
                        YukoMukoKubun.有効.getコード(),
                        Boolean.FALSE,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY);
        HihokenshoShikakushoHakkoEntity entity = mapper.被保険者証資格証発行情報取得(parameter);

        if (null == entity) {
            return null;
        }
        // 保険者情報取得
        this.保険者情報取得(entity, 被保険者番号);

        // 指定サービス種類の取得
        this.指定サービス種類の取得(entity, 被保険者番号);

        // 限度額データ取得
        this.限度額データ取得(entity);

        // 給付制限データ取得
        this.給付制限データ取得(entity, メニューID);

        // 支援事業者データ取得
        this.支援事業者データ取得(entity);

        // 施設入退所データ取得
        this.施設入退所データ取得(entity);

        return entity;
    }

    /**
     * 被保険者証資格証発行情報取得です。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     * @param 被保険者番号 被保険者番号
     */
    private void 保険者情報取得(HihokenshoShikakushoHakkoEntity entity, HihokenshaNo 被保険者番号) {

        DbT1001HihokenshaDaichoEntity hokenshajohoEntity = dbT1001Dac.get被保険者証資格証発行情報(被保険者番号);

        if (hokenshajohoEntity != null) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            RString 保険者名称 = RString.EMPTY;
            LasdecCode shichosonCode = hokenshajohoEntity.getKoikinaiTokureiSochimotoShichosonCode();
            if (shichosonCode != null) {
                保険者名称 = finder.
                        shichosonCodeYoriShichosonJoho(shichosonCode).
                        records().get(0).get市町村名称();
                entity.set市町村コード(shichosonCode.value());
                entity.set保険者名称(保険者名称);
            } else if (hokenshajohoEntity.getShichosonCode() != null) {
                保険者名称 = finder.shichosonCodeYoriShichosonJoho(hokenshajohoEntity.getShichosonCode()).records().get(0).get市町村名称();
                entity.set市町村コード(hokenshajohoEntity.getShichosonCode().value());
                entity.set保険者名称(保険者名称);

            }
        }

    }

    /**
     * 指定サービス種類の取得
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     * @param 被保険者番号 被保険者番号
     */
    private void 指定サービス種類の取得(HihokenshoShikakushoHakkoEntity entity, HihokenshaNo 被保険者番号) {

        DbT4001JukyushaDaichoEntity jukyushaDaichoEntity = dbT4001Dac.get指定サービス種類(被保険者番号);

        List<RString> サービス種類list = new ArrayList<>();

        if (jukyushaDaichoEntity != null) {
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui01(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui02(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui03(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui04(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui05(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui06(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui07(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui08(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui09(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui10(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui11(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui12(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui13(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui14(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui15(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui16(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui17(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui18(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui19(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui20(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui21(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui22(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui23(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui24(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui25(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui26(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui27(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui28(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui29(), サービス種類list);
            this.addサービス種類list(jukyushaDaichoEntity.getShiteiServiceShurui30(), サービス種類list);
        }
        if (entity != null) {
            RString 介護認定審査会意見_名称
                    = (entity.get介護認定審査会意見() == null ? RString.EMPTY : entity.get介護認定審査会意見()).concat(RString.FULL_SPACE);
            RString 介護認定審査会意見_略称
                    = (entity.get介護認定審査会意見() == null ? RString.EMPTY : entity.get介護認定審査会意見()).concat(RString.FULL_SPACE);
            this.set介護認定審査会意見(サービス種類list, 介護認定審査会意見_名称, 介護認定審査会意見_略称);

            if (介護認定審査会意見_名称.length() < HYOJI_SIZE) {

                entity.set介護認定審査会意見(介護認定審査会意見_名称);
            } else if (介護認定審査会意見_略称.length() < HYOJI_SIZE) {

                entity.set介護認定審査会意見(介護認定審査会意見_略称);
            } else {

                entity.set介護認定審査会意見(介護認定審査会意見_略称.substring(0, HYOJI_SIZE));
            }
        }
    }

    /**
     * 限度額データ取得です。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     */
    @Transaction
    private void 限度額データ取得(HihokenshoShikakushoHakkoEntity entity
    ) {

        IHihokenshoShikakushoHakkoMapper mapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        HihokenshoShikakushoHakkoMapperParameter parameter
                = createParam(HihokenshaNo.EMPTY,
                        RString.EMPTY,
                        RString.EMPTY,
                        Boolean.TRUE,
                        RString.EMPTY,
                        FlexibleDate.EMPTY,
                        FlexibleDate.EMPTY,
                        RString.EMPTY,
                        entity.get認定有効期間開始年月日(),
                        entity.get認定有効期間終了年月日());
        List<ServiceTypeListEntity> 限度額取得EntityList = mapper
                .限度額データ取得(parameter);

        entity.setServiceTypeListEntityList(限度額取得EntityList);
    }

    /**
     * 給付制限データ取得です。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     * @param メニューID メニューID
     *
     */
    @Transaction
    private void 給付制限データ取得(HihokenshoShikakushoHakkoEntity entity, RString メニューID
    ) {

        IHihokenshoShikakushoHakkoMapper mapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);
        List<ShiharaiHohoHenkoEntity> shiharaiHohoHenkoList = mapper.支払方法変更の情報取得();

        if (shiharaiHohoHenkoList.isEmpty()) {
            return;
        }

        for (int i = 0; i < shiharaiHohoHenkoList.size(); i++) {

            this.給付制限データ取得編集１(entity, shiharaiHohoHenkoList, メニューID, i);
            this.給付制限データ取得編集２(entity, shiharaiHohoHenkoList, メニューID, i);
            this.給付制限データ取得編集３(entity, shiharaiHohoHenkoList, メニューID, i);

        }
    }

    /**
     * 支援事業者データ取得。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     */
    @Transaction
    private void 支援事業者データ取得(HihokenshoShikakushoHakkoEntity entity
    ) {

        IHihokenshoShikakushoHakkoMapper mapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        List<KyotakuKeikakuTodokedeEntity> kyotakuKeikakuTodokedeList = mapper.居宅給付計画届出情報取得();

        if (kyotakuKeikakuTodokedeList.isEmpty()) {
            return;
        }
        int dbT3006Count = dbT3006Dac.selectAll().size();
        int dbT3007Count = dbT3007Dac.selectAll().size();

        for (int i = 0;
                i < kyotakuKeikakuTodokedeList.size();
                i++) {
            if (i == 0) {
                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006 = dbT3006Dac.selectByKey(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue());

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = dbT7060Dac.select事業者名称(dbT3006.getKeikakuJigyoshaNo()).get(0);

                    entity.set事業者１(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日１(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日１(dbT3006.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007 = dbT3007Dac.get居宅給付計画自己作成(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue(),
                            居宅サービス計画);

                    entity.set事業者１(JIBUNSAKUSEI);
                    entity.set届出年月日１(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日１(dbT3007.getTekiyoKaishiYMD());
                }

            } else if (i == 1) {

                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006 = dbT3006Dac.selectByKey(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue());

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = dbT7060Dac.select事業者名称(dbT3006.getKeikakuJigyoshaNo()).get(0);

                    entity.set事業者２(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日２(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日２(dbT3006.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007 = dbT3007Dac.get居宅給付計画自己作成(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue(),
                            居宅サービス計画);

                    entity.set事業者２(JIBUNSAKUSEI);
                    entity.set届出年月日２(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日２(dbT3007.getTekiyoKaishiYMD());
                }
            } else if (i == 2) {

                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006 = dbT3006Dac.selectByKey(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue());

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = dbT7060Dac.select事業者名称(dbT3006.getKeikakuJigyoshaNo()).get(0);

                    entity.set事業者３(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日３(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日３(dbT3006.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007 = dbT3007Dac.get居宅給付計画自己作成(
                            kyotakuKeikakuTodokedeList.get(i).get被保険者番号(),
                            kyotakuKeikakuTodokedeList.get(i).get対象年月(),
                            kyotakuKeikakuTodokedeList.get(i).get履歴番号().intValue(),
                            居宅サービス計画);

                    entity.set事業者３(JIBUNSAKUSEI);
                    entity.set届出年月日３(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日３(dbT3007.getTekiyoKaishiYMD());
                }
            }
        }
    }

    /**
     * 施設入退所データ取得。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     */
    @Transaction
    private void 施設入退所データ取得(HihokenshoShikakushoHakkoEntity entity
    ) {

        IHihokenshoShikakushoHakkoMapper mapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        List<KaigoHokenShisetsuNyutaishoEntity> resultList = mapper.介護保険施設入退所の情報取得();

        if (resultList.isEmpty()) {
            return;
        }

        for (int i = 0;
                i < resultList.size();
                i++) {

            if (i == 0) {
                if (ShisetsuType.介護保険施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT7060KaigoJigyoshaEntity dbT7060 = dbT7060Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設１(dbT7060.getJigyoshaName().value());
                } else if (ShisetsuType.住所地特例対象施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005 = dbT1005Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設１(dbT1005.getJigyoshaMeisho().value());
                }
                entity.set入所年月日１(resultList.get(i).get入所年月日());
                entity.set退所年月日１(resultList.get(i).get退所年月日());
            } else if (i == 1) {
                if (ShisetsuType.介護保険施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT7060KaigoJigyoshaEntity dbT7060 = dbT7060Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設２(dbT7060.getJigyoshaName().value());
                } else if (ShisetsuType.住所地特例対象施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005 = dbT1005Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設２(dbT1005.getJigyoshaMeisho().value());

                }
                entity.set入所年月日２(resultList.get(i).get入所年月日());
                entity.set退所年月日２(resultList.get(i).get退所年月日());
            } else if (i == 2) {
                if (ShisetsuType.介護保険施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT7060KaigoJigyoshaEntity dbT7060 = dbT7060Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設３(dbT7060.getJigyoshaName().value());
                } else if (ShisetsuType.住所地特例対象施設.getCode().equals(resultList.get(i).get入所施設種類())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005 = dbT1005Dac.
                            select事業者名称(new JigyoshaNo(resultList.get(i).get入所施設コード())).get(0);

                    entity.set入所施設３(dbT1005.getJigyoshaMeisho().value());

                }
                entity.set入所年月日３(resultList.get(i).get入所年月日());
                entity.set退所年月日３(resultList.get(i).get退所年月日());
            }
        }
    }

    /**
     * サービス種類listを作成。
     *
     */
    private void addサービス種類list(ServiceShuruiCode code, List<RString> サービス種類list) {

        if (code == null) {
            サービス種類list.add(null);
        } else {
            サービス種類list.add(code.value());
        }
    }

    /**
     * 介護認定審査会意見を設定。
     *
     */
    private void set介護認定審査会意見(List<RString> サービス種類list, RString 介護認定審査会意見_名称,
            RString 介護認定審査会意見_略称) {

        for (int i = 0; i < サービス種類list.size(); i++) {

            if (サービス種類list.get(i) != null) {
                DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity
                        = dbT7130Dac.getサービス種類名称Andサービス種類略称(サービス種類list.get(i));

                if (kaigoServiceShuruiEntity == null) {
                    continue;
                }
                if (i == 0) {
                    介護認定審査会意見_名称 = 介護認定審査会意見_名称.concat(kaigoServiceShuruiEntity.getServiceShuruiMeisho() == null
                            ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiMeisho());
                    介護認定審査会意見_略称 = 介護認定審査会意見_略称.concat(kaigoServiceShuruiEntity.getServiceShuruiRyakusho() == null
                            ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiRyakusho());
                    continue;
                }
                介護認定審査会意見_名称 = 介護認定審査会意見_名称.concat(new RString("、")).
                        concat(kaigoServiceShuruiEntity.getServiceShuruiMeisho() == null
                                ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiMeisho());
                介護認定審査会意見_略称 = 介護認定審査会意見_略称.concat(new RString("、")).
                        concat(kaigoServiceShuruiEntity.getServiceShuruiRyakusho() == null
                                ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiRyakusho());

            } else {
                break;
            }
        }
    }

    /**
     * 給付制限データ取得編集１。
     *
     */
    private void 給付制限データ取得編集１(
            HihokenshoShikakushoHakkoEntity entity,
            List<ShiharaiHohoHenkoEntity> shiharaiHohoHenkoList,
            RString メニューID,
            int i) {
        if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        }

    }

    /**
     * 給付制限データ取得編集２。
     *
     */
    private void 給付制限データ取得編集２(
            HihokenshoShikakushoHakkoEntity entity,
            List<ShiharaiHohoHenkoEntity> shiharaiHohoHenkoList,
            RString メニューID,
            int i) {

        if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12001.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        }
    }

    /**
     * 給付制限データ取得編集３。
     *
     */
    private void 給付制限データ取得編集３(
            HihokenshoShikakushoHakkoEntity entity,
            List<ShiharaiHohoHenkoEntity> shiharaiHohoHenkoList,
            RString メニューID,
            int i) {

        if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 0) {
            entity.set給付制限内容１(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 1) {
            entity.set給付制限内容２(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        } else if (MENUID_DBUMN12002.equals(メニューID)
                && ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分())
                && i == 2) {
            entity.set給付制限内容３(BusinessConfig.
                    get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
            entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
            entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
        }
    }
}
