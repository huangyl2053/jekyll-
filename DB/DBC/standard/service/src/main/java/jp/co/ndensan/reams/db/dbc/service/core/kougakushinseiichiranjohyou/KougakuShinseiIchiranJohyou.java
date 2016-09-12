/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakushinseiichiranjohyou;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouEntityResult;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakushinseiichiranjohyou.KougakuShinseiIchiranJohyouEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kougakushinseiichiranjohyou.IKougakuShinseiIchiranJohyouMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCKD00005_高額申請一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-050 quxiaodong
 */
public class KougakuShinseiIchiranJohyou {

    private final MapperProvider mapperProvider;
    private final DbT1001HihokenshaDaichoDac 被保険者台帳管理Dac;

    /**
     * コンストラクタです。
     */
    public KougakuShinseiIchiranJohyou() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.被保険者台帳管理Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * 初期化メソッドです。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KougakuShinseiIchiranJohyou}のインスタンス
     */
    public static KougakuShinseiIchiranJohyou createInstance() {
        return InstanceProvider.create(KougakuShinseiIchiranJohyou.class);
    }

    /**
     * 高額一覧情報（高額）取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月From FlexibleYearMonth
     * @param サービス年月To FlexibleYearMonth
     * @return List<KougakuShinseiIchiranJohyouEntityResult>
     */
    public List<KougakuShinseiIchiranJohyouEntityResult> getKogakuKyuufuTaishouList(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月From, FlexibleYearMonth サービス年月To) {
        IKougakuShinseiIchiranJohyouMapper mapper = mapperProvider.create(IKougakuShinseiIchiranJohyouMapper.class);
        KougakuShinseiIchiranJohyouParameter parameter
                = new KougakuShinseiIchiranJohyouParameter(被保険者番号, サービス年月From, サービス年月To);
        List<KougakuShinseiIchiranJohyouEntity> kotaList = mapper.getKougakuShinseiIchiranJohyou(parameter);
        List<KougakuShinseiIchiranJohyouEntityResult> result = new ArrayList<>();
        if (kotaList == null || kotaList.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (KougakuShinseiIchiranJohyouEntity entity : kotaList) {
                result.add(new KougakuShinseiIchiranJohyouEntityResult(entity));
            }
        }
        return result;
    }

    /**
     * 高額申請一覧情報（事業高額）取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月From FlexibleYearMonth
     * @param サービス年月To FlexibleYearMonth
     * @return List<KougakuShinseiIchiranJohyouEntityResult>
     */
    public List<KougakuShinseiIchiranJohyouEntityResult> getJigyouKougakuShinseiIchiranJohyou(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月From, FlexibleYearMonth サービス年月To) {
        IKougakuShinseiIchiranJohyouMapper mapper = mapperProvider.create(IKougakuShinseiIchiranJohyouMapper.class);
        KougakuShinseiIchiranJohyouParameter parameter
                = new KougakuShinseiIchiranJohyouParameter(被保険者番号, サービス年月From, サービス年月To);
        List<KougakuShinseiIchiranJohyouEntity> kotaList = mapper.getJigyouKougakuShinseiIchiranJohyou(parameter);
        List<KougakuShinseiIchiranJohyouEntityResult> result = new ArrayList<>();
        if (kotaList == null || kotaList.isEmpty()) {
            return new ArrayList<>();
        } else {
            for (KougakuShinseiIchiranJohyouEntity entity : kotaList) {
                result.add(new KougakuShinseiIchiranJohyouEntityResult(entity));
            }
        }
        return result;
    }

    /**
     * 証記載保険者番号取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 導入形態コード FlexibleYearMonth
     * @return ShoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenBangou(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月, RString 導入形態コード) {
        ShoKisaiHokenshaNo 証記載保険者番号 = null;
        DbT1001HihokenshaDaichoEntity 被保険者台帳管理1 = 被保険者台帳管理Dac.selectMax異動日(被保険者番号, サービス年月);
        LasdecCode 市町村コード = LasdecCode.EMPTY;
        if (被保険者台帳管理1 != null && 被保険者台帳管理1.getIdoYMD().getYearMonth().compareTo(サービス年月) < 0) {
            List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                    DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), FlexibleDate.getNowDate());
            for (UzT0007CodeEntity list : codeList) {
                if (list.getコード().value().equals(被保険者台帳管理1.getIdoJiyuCode())) {
                    throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
                }
            }
        }
        if (被保険者台帳管理1 != null) {
            LasdecCode 市町村コード1 = 被保険者台帳管理1.getShichosonCode();
            LasdecCode 広住特措置元市町村コード1 = 被保険者台帳管理1.getKoikinaiTokureiSochimotoShichosonCode();
            if (広住特措置元市町村コード1 != null && !広住特措置元市町村コード1.isEmpty()) {
                市町村コード = 広住特措置元市町村コード1;
            } else {
                市町村コード = 市町村コード1;
            }
        } else {
            DbT1001HihokenshaDaichoEntity 被保険者台帳管理2 = 被保険者台帳管理Dac.
                    selectMin異動日(被保険者番号, サービス年月);
            if (被保険者台帳管理2 != null) {
                市町村コード = get市町村コード(被保険者台帳管理2);
            } else {
                throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
            }
        }
        RString 導入形態コード1 = DonyuKeitaiCode.事務広域.getCode();
        RString 導入形態コード2 = DonyuKeitaiCode.事務構成市町村.getCode();
        RString 導入形態コード3 = DonyuKeitaiCode.事務単一.getCode();
        if (導入形態コード.equals(導入形態コード2) || 導入形態コード.equals(導入形態コード3)) {
            SearchResult<KoikiZenShichosonJoho> result1 = KoikiShichosonJohoFinder.createInstance().koseiShichosonJoho();
            if (!result1.records().isEmpty()) {
                証記載保険者番号 = result1.records().get(0).get証記載保険者番号();
            }
        } else if (導入形態コード.equals(導入形態コード1)) {
            SearchResult<ShichosonCodeYoriShichoson> result2 = KoikiShichosonJohoFinder.
                    createInstance().shichosonCodeYoriShichosonJoho(市町村コード);
            if (!result2.records().isEmpty()) {
                証記載保険者番号 = result2.records().get(0).get証記載保険者番号();
            }
        }
        return 証記載保険者番号;
    }

    private LasdecCode get市町村コード(DbT1001HihokenshaDaichoEntity 被保険者台帳管理) {
        LasdecCode 市町村コード;
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.DBA介護資格,
                DBACodeShubetsu.介護資格喪失事由_被保険者.getコード(), FlexibleDate.getNowDate());
        for (UzT0007CodeEntity list : codeList) {
            if (list.getコード().value().equals(被保険者台帳管理.getIdoJiyuCode())) {
                throw new ApplicationException(DbcErrorMessages.対象年月被保険者データなし.getMessage());
            }
        }
        LasdecCode 市町村コード2 = 被保険者台帳管理.getShichosonCode();
        LasdecCode 広住特措置元市町村コード2 = 被保険者台帳管理.getKoikinaiTokureiSochimotoShichosonCode();
        if (広住特措置元市町村コード2 != null && !広住特措置元市町村コード2.isEmpty()) {
            市町村コード = 広住特措置元市町村コード2;
        } else {
            市町村コード = 市町村コード2;
        }
        return 市町村コード;
    }
}
