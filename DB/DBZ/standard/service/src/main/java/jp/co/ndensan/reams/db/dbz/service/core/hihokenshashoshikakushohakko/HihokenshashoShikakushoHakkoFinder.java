/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.hihokenshashoshikakushohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShurui;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShurui.serviceShuruiCd;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShurui.teikyoKaishiYM;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShurui.teikyoshuryoYM;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter;
import static jp.co.ndensan.reams.db.dbz.definition.core.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoMapperParameter.createParam;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaicho.logicalDeletedFlag;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.edaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaicho.yukoMukoKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.HihokenshoShikakushoHakkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KaigoHokenShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ServiceTypeListEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.hihokenshoshikakushohakko.IHihokenshoShikakushoHakkoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 共有子Div「被保険者証・資格証」の状態を変更するクラスです
 *
 */
public class HihokenshashoShikakushoHakkoFinder {

    @InjectSession
    private SqlSession session;
    private static final RString MENUID_DBUMN12001 = new RString("DBUMN12001");
    private static final RString MENUID_DBUMN12002 = new RString("DBUMN12002");
    private static final RString JIBUNSAKUSEI = new RString("自己作成");
    private final MapperProvider mapperProvider;

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
    }

    /**
     * テスト用コンストラクタです。
     *
     */
    HihokenshashoShikakushoHakkoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
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
        IHihokenshoShikakushoHakkoMapper hihokenshoShikakushoHakkoMapper = this.mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);
        HihokenshoShikakushoHakkoMapperParameter SQL発行Parameter
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
        HihokenshoShikakushoHakkoEntity entity = new HihokenshoShikakushoHakkoEntity();
        entity = hihokenshoShikakushoHakkoMapper.被保険者証資格証発行情報取得(SQL発行Parameter);

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

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT1001HihokenshaDaichoEntity hokenshajohoEntity = new DbT1001HihokenshaDaichoEntity();
        hokenshajohoEntity = accessor.select().
                table(DbT1001HihokenshaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(logicalDeletedFlag, false))).order(by(idoYMD, Order.DESC), by(edaNo, Order.DESC)).limit(1).toObject(DbT1001HihokenshaDaichoEntity.class);

        // 「ビジネス設計_DBUMN00000_市町村情報取得_広域」の「市町村コードによる市町村情報」を呼び出し
        //上記取得できる場合、広住特措置元市町村コードがNULLではない場合
        if (hokenshajohoEntity != null) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            RString 保険者名称 = RString.EMPTY;

            // 広住特措置元市町村コードがNULLではない場合
            if (!hokenshajohoEntity.getKoikinaiTokureiSochimotoShichosonCode().isEmpty()) {
                保険者名称 = finder.shichosonCodeYoriShichosonJoho(hokenshajohoEntity.getKoikinaiTokureiSochimotoShichosonCode()).get(0).getShichosonMeisho();
                entity.set市町村コード(hokenshajohoEntity.getKoikinaiTokureiSochimotoShichosonCode().value());
                entity.set保険者名称(保険者名称);
                // 住特措置元市町村コードがNULLの場合
            } else {
                保険者名称 = finder.shichosonCodeYoriShichosonJoho(hokenshajohoEntity.getShichosonCode()).get(0).getShichosonMeisho();
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
    @Transaction
    private void 指定サービス種類の取得(HihokenshoShikakushoHakkoEntity entity, HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        DbT4001JukyushaDaichoEntity jukyushaDaichoEntity = new DbT4001JukyushaDaichoEntity();
        jukyushaDaichoEntity = accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(DbT4001JukyushaDaicho.hihokenshaNo, 被保険者番号),
                                eq(yukoMukoKubun, YukoMukoKubun.有効.getコード()),
                                eq(DbT4001JukyushaDaicho.logicalDeletedFlag, false))).order(by(rirekiNo, Order.DESC), by(edaban, Order.DESC)).limit(1).toObject(DbT4001JukyushaDaichoEntity.class);

        List<RString> サービス種類list = new ArrayList<>();

        サービス種類list.add(0, jukyushaDaichoEntity.getShiteiServiceShurui01().value());
        サービス種類list.add(1, jukyushaDaichoEntity.getShiteiServiceShurui02().value());
        サービス種類list.add(2, jukyushaDaichoEntity.getShiteiServiceShurui03().value());
        サービス種類list.add(3, jukyushaDaichoEntity.getShiteiServiceShurui04().value());
        サービス種類list.add(4, jukyushaDaichoEntity.getShiteiServiceShurui05().value());
        サービス種類list.add(5, jukyushaDaichoEntity.getShiteiServiceShurui06().value());
        サービス種類list.add(6, jukyushaDaichoEntity.getShiteiServiceShurui07().value());
        サービス種類list.add(7, jukyushaDaichoEntity.getShiteiServiceShurui08().value());
        サービス種類list.add(8, jukyushaDaichoEntity.getShiteiServiceShurui09().value());
        サービス種類list.add(9, jukyushaDaichoEntity.getShiteiServiceShurui10().value());
        サービス種類list.add(10, jukyushaDaichoEntity.getShiteiServiceShurui11().value());
        サービス種類list.add(11, jukyushaDaichoEntity.getShiteiServiceShurui12().value());
        サービス種類list.add(12, jukyushaDaichoEntity.getShiteiServiceShurui13().value());
        サービス種類list.add(13, jukyushaDaichoEntity.getShiteiServiceShurui14().value());
        サービス種類list.add(14, jukyushaDaichoEntity.getShiteiServiceShurui15().value());
        サービス種類list.add(15, jukyushaDaichoEntity.getShiteiServiceShurui16().value());
        サービス種類list.add(16, jukyushaDaichoEntity.getShiteiServiceShurui17().value());
        サービス種類list.add(17, jukyushaDaichoEntity.getShiteiServiceShurui18().value());
        サービス種類list.add(18, jukyushaDaichoEntity.getShiteiServiceShurui19().value());
        サービス種類list.add(19, jukyushaDaichoEntity.getShiteiServiceShurui20().value());
        サービス種類list.add(20, jukyushaDaichoEntity.getShiteiServiceShurui21().value());
        サービス種類list.add(21, jukyushaDaichoEntity.getShiteiServiceShurui22().value());
        サービス種類list.add(22, jukyushaDaichoEntity.getShiteiServiceShurui23().value());
        サービス種類list.add(23, jukyushaDaichoEntity.getShiteiServiceShurui24().value());
        サービス種類list.add(24, jukyushaDaichoEntity.getShiteiServiceShurui25().value());
        サービス種類list.add(25, jukyushaDaichoEntity.getShiteiServiceShurui26().value());
        サービス種類list.add(26, jukyushaDaichoEntity.getShiteiServiceShurui27().value());
        サービス種類list.add(27, jukyushaDaichoEntity.getShiteiServiceShurui28().value());
        サービス種類list.add(28, jukyushaDaichoEntity.getShiteiServiceShurui29().value());
        サービス種類list.add(29, jukyushaDaichoEntity.getShiteiServiceShurui30().value());

        RString 介護認定審査会意見_名称 = (entity.get介護認定審査会意見() == null ? RString.EMPTY : entity.get介護認定審査会意見()).concat(RString.FULL_SPACE);
        RString 介護認定審査会意見_略称 = (entity.get介護認定審査会意見() == null ? RString.EMPTY : entity.get介護認定審査会意見()).concat(RString.FULL_SPACE);
        for (int i = 0; i < サービス種類list.size(); i++) {

            if (サービス種類list.get(i) != null) {
                DbT7130KaigoServiceShuruiEntity kaigoServiceShuruiEntity = new DbT7130KaigoServiceShuruiEntity();
                kaigoServiceShuruiEntity = accessor.select().
                        table(DbT7130KaigoServiceShurui.class).
                        where(and(eq(serviceShuruiCd, サービス種類list.get(i)),
                                        leq(teikyoKaishiYM, RDate.getNowDate()),
                                        or(leq(RDate.getNowDate(), teikyoshuryoYM), isNULL(teikyoshuryoYM)))).toObject(DbT7130KaigoServiceShuruiEntity.class);

                if (kaigoServiceShuruiEntity == null) {
                    continue;
                }
                介護認定審査会意見_名称 = 介護認定審査会意見_名称.concat(new RString("、")).concat(kaigoServiceShuruiEntity.getServiceShuruiMeisho() == null ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiMeisho());
                介護認定審査会意見_略称 = 介護認定審査会意見_略称.concat(new RString("、")).concat(kaigoServiceShuruiEntity.getServiceShuruiRyakusho() == null ? RString.EMPTY : kaigoServiceShuruiEntity.getServiceShuruiRyakusho());

            } else {
                break;
            }

        }

        if (介護認定審査会意見_略称.length() >= 150) {

            entity.set介護認定審査会意見(介護認定審査会意見_略称.substring(0, 150));
        } else if (介護認定審査会意見_名称.length() >= 150) {

            entity.set介護認定審査会意見(介護認定審査会意見_略称);
        } else {

            entity.set介護認定審査会意見(介護認定審査会意見_名称);
        }
    }

    /**
     * 限度額データ取得です。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     */
    @Transaction
    private void 限度額データ取得(HihokenshoShikakushoHakkoEntity entity) {

        IHihokenshoShikakushoHakkoMapper hihokenshoShikakushoHakkoMapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        HihokenshoShikakushoHakkoMapperParameter 限度額データ取得Parameter
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
        List<ServiceTypeListEntity> 限度額取得EntityList = new ArrayList<>();
        限度額取得EntityList = hihokenshoShikakushoHakkoMapper
                .限度額データ取得(限度額データ取得Parameter);

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
    private void 給付制限データ取得(HihokenshoShikakushoHakkoEntity entity, RString メニューID) {

        IHihokenshoShikakushoHakkoMapper hihokenshoShikakushoHakkoMapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);
        List<ShiharaiHohoHenkoEntity> shiharaiHohoHenkoList = new ArrayList<>();
        shiharaiHohoHenkoList = hihokenshoShikakushoHakkoMapper.支払方法変更の情報取得();

        if (shiharaiHohoHenkoList.isEmpty()) {
            return;
        }

        for (int i = 0; i < shiharaiHohoHenkoList.size(); i++) {

            if (MENUID_DBUMN12001.equals(メニューID)) {
                if (ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {

                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }

                } else if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {
                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }
                } else if (ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {
                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }
                }
            } else if (MENUID_DBUMN12002.equals(メニューID)) {
                if (ShiharaiHenkoKanriKubun._２号差止.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {

                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }

                } else if (ShiharaiHenkoKanriKubun._１号償還払い化.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {
                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }
                } else if (ShiharaiHenkoKanriKubun._１号給付額減額.getコード().equals(shiharaiHohoHenkoList.get(i).get管理区分().code())) {
                    if (i == 0) {
                        entity.set給付制限内容１(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始１(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了１(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    } else if (i == 1) {
                        entity.set給付制限内容２(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始２(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了２(shiharaiHohoHenkoList.get(i).get適用終了年月日());

                    } else if (i == 2) {
                        entity.set給付制限内容３(BusinessConfig.get(ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言, SubGyomuCode.DBD介護受給));
                        entity.set制限期間開始３(shiharaiHohoHenkoList.get(i).get適用開始年月日());
                        entity.set制限期間終了３(shiharaiHohoHenkoList.get(i).get適用終了年月日());
                    }
                }
            }
        }
    }

    /**
     * 支援事業者データ取得。
     *
     * @param HihokenshoShikakushoHakkoEntity HihokenshoShikakushoHakkoEntity
     */
    @Transaction
    private void 支援事業者データ取得(HihokenshoShikakushoHakkoEntity entity) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        IHihokenshoShikakushoHakkoMapper hihokenshoShikakushoHakkoMapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        List<KyotakuKeikakuTodokedeEntity> kyotakuKeikakuTodokedeList = new ArrayList<>();
        kyotakuKeikakuTodokedeList = hihokenshoShikakushoHakkoMapper.居宅給付計画届出情報取得();

        if (kyotakuKeikakuTodokedeList.isEmpty()) {
            return;
        }
        int dbT3006Count = accessor.select().table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).getCount();
        int dbT3007Count = accessor.select().table(DbT3007KyotakuKeikakuJikoSakusei.class).getCount();

        for (int i = 0; i < kyotakuKeikakuTodokedeList.size(); i++) {
            if (i == 0) {
                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006KyotakuKeikakuJigyoshaSakusei = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
                    dbT3006KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                            where(and(
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
                    dbT7060KaigoJigyosha = accessor.select().table(DbT7060KaigoJigyosha.class).where(
                            eq(DbT7060KaigoJigyosha.jigyoshaNo, dbT3006KyotakuKeikakuJigyoshaSakusei.getKeikakuJigyoshaNo())).
                            order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT7060KaigoJigyoshaEntity.class);

                    entity.set事業者１(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日１(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日１(dbT3006KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007KyotakuKeikakuJigyoshaSakusei = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
                    dbT3007KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3007KyotakuKeikakuJikoSakusei.class).
                            where(and(
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.hihokenshaNo, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);

                    entity.set事業者１(JIBUNSAKUSEI);
                    entity.set届出年月日１(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日１(dbT3007KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
                }

            } else if (i == 1) {

                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006KyotakuKeikakuJigyoshaSakusei = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
                    dbT3006KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                            where(and(
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
                    dbT7060KaigoJigyosha = accessor.select().table(DbT7060KaigoJigyosha.class).where(
                            eq(DbT7060KaigoJigyosha.jigyoshaNo, dbT3006KyotakuKeikakuJigyoshaSakusei.getKeikakuJigyoshaNo())).
                            order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT7060KaigoJigyoshaEntity.class);

                    entity.set事業者２(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日２(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日２(dbT3006KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007KyotakuKeikakuJigyoshaSakusei = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
                    dbT3007KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3007KyotakuKeikakuJikoSakusei.class).
                            where(and(
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.hihokenshaNo, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);

                    entity.set事業者２(JIBUNSAKUSEI);
                    entity.set届出年月日２(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日２(dbT3007KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
                }
            } else if (i == 2) {

                if (dbT3006Count > 0) {
                    DbT3006KyotakuKeikakuJigyoshaSakuseiEntity dbT3006KyotakuKeikakuJigyoshaSakusei = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
                    dbT3006KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                            where(and(
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);

                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
                    dbT7060KaigoJigyosha = accessor.select().table(DbT7060KaigoJigyosha.class).where(
                            eq(DbT7060KaigoJigyosha.jigyoshaNo, dbT3006KyotakuKeikakuJigyoshaSakusei.getKeikakuJigyoshaNo())).
                            order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT7060KaigoJigyoshaEntity.class);

                    entity.set事業者３(dbT7060KaigoJigyosha.getJigyoshaName().value());
                    entity.set届出年月日３(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日３(dbT3006KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
                } else if (dbT3007Count > 0) {

                    DbT3007KyotakuKeikakuJikoSakuseiEntity dbT3007KyotakuKeikakuJigyoshaSakusei = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
                    dbT3007KyotakuKeikakuJigyoshaSakusei = accessor.select().
                            table(DbT3007KyotakuKeikakuJikoSakusei.class).
                            where(and(
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.hihokenshaNo, kyotakuKeikakuTodokedeList.get(i).get被保険者番号()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.taishoYM, kyotakuKeikakuTodokedeList.get(i).get対象年月()),
                                            eq(DbT3007KyotakuKeikakuJikoSakusei.rirekiNo, kyotakuKeikakuTodokedeList.get(i).get履歴番号()))).toObject(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);

                    entity.set事業者３(JIBUNSAKUSEI);
                    entity.set届出年月日３(kyotakuKeikakuTodokedeList.get(i).get届出年月日());
                    entity.set適用開始年月日３(dbT3007KyotakuKeikakuJigyoshaSakusei.getTekiyoKaishiYMD());
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
    private void 施設入退所データ取得(HihokenshoShikakushoHakkoEntity entity) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        IHihokenshoShikakushoHakkoMapper hihokenshoShikakushoHakkoMapper = mapperProvider.create(IHihokenshoShikakushoHakkoMapper.class);

        List<KaigoHokenShisetsuNyutaishoEntity> kaigoHokenShisetsuNyutaishoList = new ArrayList<>();
        kaigoHokenShisetsuNyutaishoList = hihokenshoShikakushoHakkoMapper.介護保険施設入退所の情報取得();

        if (kaigoHokenShisetsuNyutaishoList.isEmpty()) {
            return;
        }

        for (int i = 0; i < kaigoHokenShisetsuNyutaishoList.size(); i++) {

            if (i == 0) {
                if (ShisetsuType.介護保険施設.getCode().equals(kaigoHokenShisetsuNyutaishoList.get(i).get入所施設種類())) {
                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
                    dbT7060KaigoJigyosha = accessor.select().table(DbT7060KaigoJigyosha.class).where(
                            eq(DbT7060KaigoJigyosha.jigyoshaNo, kaigoHokenShisetsuNyutaishoList.get(i).get入所施設コード())).
                            order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT7060KaigoJigyoshaEntity.class);

                    entity.set入所施設１(dbT7060KaigoJigyosha.getJigyoshaName().value());
                } else if (ShisetsuType.住所地特例対象施設.getCode().equals(kaigoHokenShisetsuNyutaishoList.get(i).get入所施設種類())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005KaigoJogaiTokureiTaishoShisetsu = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
                    dbT1005KaigoJogaiTokureiTaishoShisetsu = accessor.select().table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).where(
                            eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo, kaigoHokenShisetsuNyutaishoList.get(i).get入所施設コード())).
                            order(by(DbT1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);

                    entity.set入所施設１(dbT1005KaigoJogaiTokureiTaishoShisetsu.getJigyoshaMeisho().value());

                }
                entity.set入所年月日１(kaigoHokenShisetsuNyutaishoList.get(i).get入所年月日());
                entity.set退所年月日１(kaigoHokenShisetsuNyutaishoList.get(i).get退所年月日());
            } else if (i == 1) {
                if (ShisetsuType.介護保険施設.getCode().equals(kaigoHokenShisetsuNyutaishoList.get(i).get入所施設種類())) {
                    DbT7060KaigoJigyoshaEntity dbT7060KaigoJigyosha = new DbT7060KaigoJigyoshaEntity();
                    dbT7060KaigoJigyosha = accessor.select().table(DbT7060KaigoJigyosha.class).where(
                            eq(DbT7060KaigoJigyosha.jigyoshaNo, kaigoHokenShisetsuNyutaishoList.get(i).get入所施設コード())).
                            order(by(DbT7060KaigoJigyosha.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT7060KaigoJigyoshaEntity.class);

                    entity.set入所施設２(dbT7060KaigoJigyosha.getJigyoshaName().value());
                } else if (ShisetsuType.住所地特例対象施設.getCode().equals(kaigoHokenShisetsuNyutaishoList.get(i).get入所施設種類())) {
                    DbT1005KaigoJogaiTokureiTaishoShisetsuEntity dbT1005KaigoJogaiTokureiTaishoShisetsu = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
                    dbT1005KaigoJogaiTokureiTaishoShisetsu = accessor.select().table(DbT1005KaigoJogaiTokureiTaishoShisetsu.class).where(
                            eq(DbT1005KaigoJogaiTokureiTaishoShisetsu.jigyoshaNo, kaigoHokenShisetsuNyutaishoList.get(i).get入所施設コード())).
                            order(by(DbT1005KaigoJogaiTokureiTaishoShisetsu.yukoKaishiYMD, Order.DESC)).limit(1).toObject(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity.class);

                    entity.set入所施設２(dbT1005KaigoJogaiTokureiTaishoShisetsu.getJigyoshaMeisho().value());

                }
                entity.set入所年月日２(kaigoHokenShisetsuNyutaishoList.get(i).get入所年月日());
                entity.set退所年月日２(kaigoHokenShisetsuNyutaishoList.get(i).get退所年月日());
            }
        }
    }
}
