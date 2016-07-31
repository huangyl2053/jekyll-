/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishousainaiyou;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DbT3058KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakusabisuhishousainaiyou.KougakuSabisuhiShousaiNaiyouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakusabisuhishousainaiyou.IKougakuSabisuhiShousaiNaiyouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_KogakuServicehiDetail_高額サービス費詳細内容入力共有子Div
 *
 * @reamsid_L DBC-4380-020 quxiaodong
 */
public class KougakuSabisuhiShousaiNaiyou {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;
    private static final RString 送付済モード = new RString("送付済モード");
    private static final RString 修正モード = new RString("修正モード");
    private static final RString 削除モード = new RString("削除モード");
    private static final RString 照会モード = new RString("照会モード");
    private static final RString 高額サービス費支給申請書登録 = new RString("DBCMN42001");
    private static final RString 高額介護サービス費照会 = new RString("DBCMN11004");
    private static final RString 総合事業高額サービス費支給申請書登録 = new RString("DBCMN42002");
    private static final RString 総合事業高額介護サービス費照会 = new RString("DBCMN11016");
    private static final RString 介護資格喪失事由 = new RString("0010");
    private static final RString 介護資格取得事由 = new RString("0007");

    /**
     * コンストラクタです。
     */
    public KougakuSabisuhiShousaiNaiyou() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KogakuKyuufuTaishouList}のインスタンス
     */
    public static KougakuSabisuhiShousaiNaiyou createInstance() {
        return InstanceProvider.create(KougakuSabisuhiShousaiNaiyou.class);
    }

    /**
     * 高額サービス費詳細内容取得
     *
     * @param 画面モード RString
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 証記載保険者番号 HokenshaNo
     * @param 履歴番号 int
     * @return List<KougakuSabisuhiShousaiNaiyouResultEntity>
     */
    public KougakuSabisuhiShousaiNaiyouResult getKougakuSabisuhiShousaiNaiyou(
            RString 画面モード,
            RString メニューID,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            HokenshaNo 証記載保険者番号,
            int 履歴番号) {
        IKougakuSabisuhiShousaiNaiyouMapper mapper = mapperProvider.create(IKougakuSabisuhiShousaiNaiyouMapper.class);
        KougakuSabisuhiShousaiNaiyouParameter parameter = new KougakuSabisuhiShousaiNaiyouParameter(
                被保険者番号, サービス年月, 証記載保険者番号, 履歴番号);
        KougakuSabisuhiShousaiNaiyouResult 高額サービス費詳細内容Entity = new KougakuSabisuhiShousaiNaiyouResult();
        if (修正モード.equals(画面モード) || 送付済モード.equals(画面モード)
                || 削除モード.equals(画面モード) || 照会モード.equals(画面モード)) {
            if (高額サービス費支給申請書登録.equals(メニューID) || 高額介護サービス費照会.equals(メニューID)) {
                KougakuSabisuhiShousaiNaiyouEntity 高額詳細内容 = mapper.get高額サービス費詳細内容(parameter);
                高額サービス費詳細内容Entity = get高額詳細内容(高額詳細内容);
            } else if (総合事業高額サービス費支給申請書登録.equals(メニューID)
                    || 総合事業高額介護サービス費照会.equals(メニューID)) {
                KougakuSabisuhiShousaiNaiyouEntity 事業高額詳細内容 = mapper.get事業高額サービス費詳細内容(parameter);
                高額サービス費詳細内容Entity = get事業高額詳細内容(事業高額詳細内容);
            }
        }
        if (照会モード.equals(画面モード)) {
            if (高額介護サービス費照会.equals(メニューID)) {
                KougakuSabisuhiShousaiNaiyouEntity 高額決定情報 = mapper.get高額決定エリア情報(parameter);
                get高額決定情報(高額決定情報, 高額サービス費詳細内容Entity);
            } else if (総合事業高額介護サービス費照会.equals(メニューID)) {
                KougakuSabisuhiShousaiNaiyouEntity 事業高額決定情報 = mapper.get事業高額決定エリア情報(parameter);
                get事業高額決定情報(事業高額決定情報, 高額サービス費詳細内容Entity);
            }
        }
        return 高額サービス費詳細内容Entity;
    }

    /**
     * 転出入判定
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @return int
     */
    public int getTenshutsuNyuuHantei(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月) {
        int i = 0;
        DbT1001HihokenshaDaichoEntity max異動日対応の保険者台帳管理
                = 被保険者台帳管理Dac.selectMax異動日(被保険者番号, サービス年月);
        if (max異動日対応の保険者台帳管理 != null
                && max異動日対応の保険者台帳管理.getIdoYMD().getYearMonth().compareTo(サービス年月) < 0) {
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    new CodeShubetsu(介護資格喪失事由), FlexibleDate.getNowDate());
            for (UzT0007CodeEntity list : codeList) {
                if (list.getコード().value().equals(max異動日対応の保険者台帳管理.getIdoJiyuCode())) {
                    throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
                }
            }
        }
        if (max異動日対応の保険者台帳管理 != null) {
            i = 検索件数(max異動日対応の保険者台帳管理, サービス年月);
        } else {
            DbT1001HihokenshaDaichoEntity min異動日対応の保険者台帳管理 = 被保険者台帳管理Dac.
                    selectMin異動日(被保険者番号, サービス年月);
            if (min異動日対応の保険者台帳管理 != null) {
                check条件２異動事由(min異動日対応の保険者台帳管理);
                i = 検索件数(min異動日対応の保険者台帳管理, サービス年月);
            } else {
                throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
            }
        }
        return i;
    }

    private KougakuSabisuhiShousaiNaiyouResult get高額詳細内容(KougakuSabisuhiShousaiNaiyouEntity 高額詳細内容) {
        KougakuSabisuhiShousaiNaiyouResult result = new KougakuSabisuhiShousaiNaiyouResult();
        if (高額詳細内容 == null) {
            return null;
        } else {
            result.set高額介護サービス費支給申請Entity(
                    new KogakuShikyuShinsei(高額詳細内容.get高額介護サービス費支給申請Entity()));
            if (高額詳細内容.get高額介護サービス費支給判定結果Entity() != null) {
                result.set高額介護サービス費支給判定結果Entity(
                        new KogakuShikyuHanteiKekka(高額詳細内容.get高額介護サービス費支給判定結果Entity()));
            }
            if (高額詳細内容.get高額介護サービス費支給対象者合計Entity() != null) {
                result.set高額介護サービス費支給対象者合計Entity(
                        new KogakuKyufuTaishoshaGokei(高額詳細内容.get高額介護サービス費支給対象者合計Entity()));
            }
            return result;
        }
    }

    private KougakuSabisuhiShousaiNaiyouResult get事業高額詳細内容(
            KougakuSabisuhiShousaiNaiyouEntity 事業高額詳細内容) {
        KougakuSabisuhiShousaiNaiyouResult result = new KougakuSabisuhiShousaiNaiyouResult();
        if (事業高額詳細内容 == null) {
            return null;
        } else {
            result.set事業高額介護サービス費支給申請Entity(
                    new JigyoKogakuShikyuShinsei(事業高額詳細内容.get事業高額介護サービス費支給申請Entity()));
            if (事業高額詳細内容.get事業高額介護サービス費支給判定結果Entity() != null) {
                result.set事業高額介護サービス費支給判定結果Entity(
                        new JigyoKogakuShikyuHanteiKekka(事業高額詳細内容.get事業高額介護サービス費支給判定結果Entity()));
            }
            if (事業高額詳細内容.get事業高額介護サービス費支給対象者合計Entity() != null) {
                result.set事業高額介護サービス費支給対象者合計Entity(
                        new JigyoKogakuKyufuTaishoshaGokei(
                                事業高額詳細内容.get事業高額介護サービス費支給対象者合計Entity()));
            }
            return result;
        }
    }

    private void get高額決定情報(KougakuSabisuhiShousaiNaiyouEntity 高額決定情報,
            KougakuSabisuhiShousaiNaiyouResult result) {
        if (高額決定情報 != null) {
            result.set高額介護サービス費支給審査決定Entity(
                    new DbT3058KogakuShikyuShinsaKettei(高額決定情報.get高額介護サービス費支給審査決定Entity()));
            if (高額決定情報.get高額介護サービス費支給判定結果Entity() != null) {
                result.set高額介護サービス費支給判定結果Entity(
                        new KogakuShikyuHanteiKekka(高額決定情報.get高額介護サービス費支給判定結果Entity()));
            }
            if (高額決定情報.get高額介護サービス費支給対象者合計Entity() != null) {
                result.set高額介護サービス費支給対象者合計Entity(
                        new KogakuKyufuTaishoshaGokei(高額決定情報.get高額介護サービス費支給対象者合計Entity()));
            }
        }
    }

    private void get事業高額決定情報(
            KougakuSabisuhiShousaiNaiyouEntity 事業高額決定情報,
            KougakuSabisuhiShousaiNaiyouResult result) {
        if (事業高額決定情報 != null) {
            result.set事業高額介護サービス費支給審査決定Entity(
                    new KogakuShikyuShinsaKettei(事業高額決定情報.get事業高額介護サービス費支給審査決定Entity()));
            if (事業高額決定情報.get高額介護サービス費支給判定結果Entity() != null) {
                result.set事業高額介護サービス費支給判定結果Entity(
                        new JigyoKogakuShikyuHanteiKekka(事業高額決定情報.get事業高額介護サービス費支給判定結果Entity()));
            }
            if (事業高額決定情報.get事業高額介護サービス費支給対象者合計Entity() != null) {
                result.set事業高額介護サービス費支給対象者合計Entity(
                        new JigyoKogakuKyufuTaishoshaGokei(
                                事業高額決定情報.get事業高額介護サービス費支給対象者合計Entity()));
            }
        }
    }

    private int 検索件数(DbT1001HihokenshaDaichoEntity 被保険者台帳管理, FlexibleYearMonth サービス年月) {
        if (被保険者台帳管理.getIdoYMD() != null && 被保険者台帳管理.getIdoYMD().getYearMonth().equals(サービス年月)
                && ShikakuHenkoJiyu.広域内転居.getコード().equals(被保険者台帳管理.getIdoJiyuCode())) {
            return 1;
        } else {
            return 0;
        }
    }

    private void check条件２異動事由(DbT1001HihokenshaDaichoEntity 被保険者台帳管理) {
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                new CodeShubetsu(介護資格取得事由), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity list : codeList) {
            if (list.getコード().value().equals(被保険者台帳管理.getIdoJiyuCode())) {
                throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
            }
        }
    }
}
