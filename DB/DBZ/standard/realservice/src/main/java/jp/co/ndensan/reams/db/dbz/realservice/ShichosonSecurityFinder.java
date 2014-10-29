/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.ShichosonSecurity;
import jp.co.ndensan.reams.db.dbz.business.config.HokenshaJohoConfig;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.model.KoikiShichosonSecurityModel;
import jp.co.ndensan.reams.db.dbz.model.util.items.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KoikiShichosonSecurityDac;
import jp.co.ndensan.reams.db.dbz.realservice.search.KoikiShichosonSecuritySearchItem;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.realservice.search.INewSearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.ISearchCondition;
import jp.co.ndensan.reams.ur.urz.realservice.search.SearchConditionFactory;
import jp.co.ndensan.reams.ur.urz.realservice.search.StringOperator;
import jp.co.ndensan.reams.uz.uza.auth.AuthGroup;
import jp.co.ndensan.reams.uz.uza.auth.GroupEntity;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.gyomu.GyomuCodeMaster;
import jp.co.ndensan.reams.uz.uza.util.gyomu.IntroductionGyomuWithTanitsuFg;

/**
 * 市町村情報のセキュリティを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShichosonSecurityFinder {

    private static final boolean 介護導入あり = true;
    private static final boolean 介護導入なし = false;
    private static final ShichosonShikibetsuID 市町村識別ID_デフォルト = new ShichosonShikibetsuID("00");
    private static final ShichosonShikibetsuID 市町村識別ID_介護未導入 = null;
    private static final ShichosonCode 市町村コード_介護未導入 = null;

    private final KoikiShichosonSecurityDac dac;
    private final HokenshaJohoConfig config;
    private final List<GroupEntity> groupList;
    private final IntroductionGyomuWithTanitsuFg[] gyomuList;

    /**
     * InstanceProviderを用いてDacのインスタンスを生成し、メンバ変数に保持します。
     */
    public ShichosonSecurityFinder() {
        dac = InstanceProvider.create(KoikiShichosonSecurityDac.class);
        config = new HokenshaJohoConfig();
        groupList = AuthGroup.getAllGroups();
        gyomuList = GyomuCodeMaster.getIntroductionGyomuList();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param dac 広域市町村セキュリティDac
     * @param config 保険者情報Config
     * @param groupList グループリスト
     * @param gyomuList 導入業務リスト
     */
    ShichosonSecurityFinder(
            KoikiShichosonSecurityDac dac,
            HokenshaJohoConfig config,
            List<GroupEntity> groupList,
            IntroductionGyomuWithTanitsuFg[] gyomuList) {
        this.dac = dac;
        this.config = config;
        this.groupList = groupList;
        this.gyomuList = gyomuList.clone();
    }

    /**
     * 市町村情報のセキュリティを取得します。
     *
     * @return 市町村情報のセキュリティ
     * @throws IllegalArgumentException 保険者構成が不正の時
     */
    public ShichosonSecurity getSecurity() throws IllegalArgumentException {
        if (is介護導入()) {
            switch (config.get保険者構成()) {
                case 単一市町村:
                    return getSecurityOf単一市町村();
                case 広域保険者:
                    return getSecurityOf広域保険者();
                default:
                    throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("保険者構成").evaluate());
            }
        }
        return getSecurityOf介護未導入();
    }

    private ShichosonSecurity getSecurityOf単一市町村() {
        // TODO N8156 宮本 康 「業務共通_市町村情報_市町村コード」から取得する。
        ShichosonCode 市町村コード_コンフィグ = new ShichosonCode("12345");
        return new ShichosonSecurity(介護導入あり, 市町村識別ID_デフォルト, 市町村コード_コンフィグ);
    }

    private ShichosonSecurity getSecurityOf広域保険者() {
        if (!groupList.isEmpty()) {
            IItemList<KoikiShichosonSecurityModel> securityList = get広域市町村SecurityList();
            if (!securityList.isEmpty()) {
                KoikiShichosonSecurityModel security = securityList.asList().get(0);
                return new ShichosonSecurity(介護導入あり, security.get市町村識別ID(), security.get市町村コード());
            }
            throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("広域市町村セキュリティ").evaluate());
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.getMessage().replace("グループID").evaluate());
    }

    private ShichosonSecurity getSecurityOf介護未導入() {
        return new ShichosonSecurity(介護導入なし, 市町村識別ID_介護未導入, 市町村コード_介護未導入);
    }

    private boolean is介護導入() {
        for (IntroductionGyomuWithTanitsuFg gyomu : gyomuList) {
            if (gyomu.getSubGyomu().getSubGyomuCode() == SubGyomuCode.DBU介護統計報告) {
                return 介護導入あり;
            }
        }
        return 介護導入なし;
    }

    private IItemList<KoikiShichosonSecurityModel> get広域市町村SecurityList() {
        return dac.select(makeSearchKeyOf広域市町村Security().makeSearchCondition());
    }

    private ISearchCondition makeSearchKeyOf広域市町村Security() {
        INewSearchCondition searchKey = null;
        for (GroupEntity group : groupList) {
            INewSearchCondition groupIdSearchKey = SearchConditionFactory.condition(
                    KoikiShichosonSecuritySearchItem.グループID, StringOperator.完全一致, group.getGroupId());
            if (searchKey == null) {
                searchKey = groupIdSearchKey;
            } else {
                searchKey.and(groupIdSearchKey);
            }
        }
        return searchKey;
    }
}
