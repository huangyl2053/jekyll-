/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.yokaigoninteijohoteikyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.HihokenshaJyuhouBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinnteiRiriBusiness;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.HihokenshaJyuhouRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.NinnteiRiriRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.yokaigoninteijohoteikyo.IYokaigoNinteiJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.auth.AuthItem;
import jp.co.ndensan.reams.uz.uza.auth.AuthType;
import jp.co.ndensan.reams.uz.uza.auth.valueobject.AuthorityItem;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定情報提供を管理するクラスです。
 *
 * @reamsid_L DBE-0230-010 zhangzhiming
 */
public class YokaigoNinteiJohoTeikyoFinder {

    private final MapperProvider mapperProvider;
    private final RString 支所 = new RString("shishoKengen");

    /**
     * コンストラクタです。
     *
     */
    YokaigoNinteiJohoTeikyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider MapperProvider
     */
    YokaigoNinteiJohoTeikyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiJohoTeikyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiJohoTeikyoFinder}のインスタンス
     */
    public static YokaigoNinteiJohoTeikyoFinder createInstance() {
        return InstanceProvider.create(YokaigoNinteiJohoTeikyoFinder.class);
    }

    /**
     * 被保険者情報を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 被保険者情報
     */
    @Transaction
    public HihokenshaJyuhouBusiness select被保険者情報(RString hihokenshaNo) {
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        HihokenshaJyuhouRelateEntity entityList = mapper
                .get被保険者情報(YokaigoNinteiJohoTeiParameter.createParameter(hihokenshaNo, RString.EMPTY, RString.EMPTY, false));
        if (entityList == null) {
            return null;
        }
        return new HihokenshaJyuhouBusiness(entityList);
    }

    /**
     * 認定履歴一覧情報を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @return 認定履歴一覧
     */
    @Transaction
    public SearchResult<NinnteiRiriBusiness> select認定履歴一覧(RString hihokenshaNo) {
        List<NinnteiRiriBusiness> resultList = new ArrayList<>();
        IYokaigoNinteiJohoTeikyoMapper mapper = mapperProvider.create(IYokaigoNinteiJohoTeikyoMapper.class);
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 証記載保険者番号 = 市町村セキュリティ情報.get市町村情報().get証記載保険者番号().getColumnValue();
        RString 支所コード = RString.EMPTY;
        if (市町村セキュリティ情報.get支所管理有無フラグ()) {
            AuthType.Of 種類 = new AuthType.Of();
            種類.kinds(支所);
            List<AuthorityItem> item = AuthItem.getAuthorities(ControlDataHolder.getUserId(), 種類.create(), RDate.getNowDate());
            if (item != null && !item.isEmpty()) {
                支所コード = AuthItem.getAuthorities(ControlDataHolder.getUserId(), 種類.create(), RDate.getNowDate()).get(0).getItemId();
            }
        }
        if (!RString.isNullOrEmpty(証記載保険者番号)) {
            List<NinnteiRiriRelateEntity> entityList = mapper
                    .get認定履歴一覧(YokaigoNinteiJohoTeiParameter.createParameter(hihokenshaNo, 証記載保険者番号, 支所コード, false));
            if (entityList == null || entityList.isEmpty()) {
                return SearchResult.of(Collections.<NinnteiRiriBusiness>emptyList(), 0, false);
            }
            for (NinnteiRiriRelateEntity entity : entityList) {
                resultList.add(new NinnteiRiriBusiness(entity));
            }
        }
        return SearchResult.of(resultList, 0, false);
    }
}
