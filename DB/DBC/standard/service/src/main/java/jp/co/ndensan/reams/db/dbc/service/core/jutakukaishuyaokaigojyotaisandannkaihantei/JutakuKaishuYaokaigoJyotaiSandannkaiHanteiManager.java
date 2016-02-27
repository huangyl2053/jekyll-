/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishuyaokaigojyotaisandannkaihantei
        .IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修費要介護状態３段階変更判定
 *
 */
public class JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager {

    private final MapperProvider mapperProvider;
    private final RString 要支援 = new RString("1");
    private final RString 要介護 = new RString("2");

    /**
     * コンストラクタです
     */
    public JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです
     *
     * @param mapperProvider MapperProvider
     */
    public JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager}のインスタンス
     */
    public static JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager createInstance() {
        return InstanceProvider.create(JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager.class);
    }

    /**
     * 介護状態区分取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return Code 要介護認定状態区分コード
     */
    @Transaction
    public Code getYaokaigoJyotaiKubun(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Map<String, Object> 要介護認定状態区分検索条件 = new HashMap<>();
        要介護認定状態区分検索条件.put("被保険者番号", 被保険者番号);
        要介護認定状態区分検索条件.put("サービス提供年月", サービス提供年月);
        IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper mapper = mapperProvider.create(IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper.class);
        return mapper.select要介護認定状態区分コードByParam(要介護認定状態区分検索条件);
    }

    /**
     * サービス提供年月取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return DbT3034ShokanShinseiEntity
     */
    @Transaction
    public DbT3034ShokanShinseiEntity getサービス提供年月(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Map<String, Object> サービス提供年月検索条件 = new HashMap<>();
        サービス提供年月検索条件.put("被保険者番号", 被保険者番号);
        サービス提供年月検索条件.put("サービス提供年月", サービス提供年月);
        IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper mapper = mapperProvider.create(IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper.class);
        return mapper.selectサービス提供年月ByParam(サービス提供年月検索条件);
    }

    /**
     * 要介護状態３段階変更の判定
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return bolean
     */
    public boolean checkYaokaigoJyotaiSandannkai(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Code konnkaiYokaigoJotaiKubunCode = getYaokaigoJyotaiKubun(被保険者番号, サービス提供年月);
        if (konnkaiYokaigoJotaiKubunCode == null) {
            return false;
        } 
        if (!konnkaiYokaigoJotaiKubunCode.value().startsWith(要支援, 0)
                && !konnkaiYokaigoJotaiKubunCode.value().startsWith(要介護, 0)) {
            return false;
        }
        DbT3034ShokanShinseiEntity entity = getサービス提供年月(被保険者番号, サービス提供年月);
        if (entity == null) {
            return false;
        }
        Code shokaiYokaigoJotaiKubunCode = getYaokaigoJyotaiKubun(被保険者番号, entity.getServiceTeikyoYM());
        if (shokaiYokaigoJotaiKubunCode == null) {
            return false;
        } 
        if (!shokaiYokaigoJotaiKubunCode.value().startsWith(要支援, 0)
                && !shokaiYokaigoJotaiKubunCode.value().startsWith(要介護, 0)) {
            return false;
        }
        return check(konnkaiYokaigoJotaiKubunCode, shokaiYokaigoJotaiKubunCode);
    }
    
    private boolean check(Code konnkaiYokaigoJotaiKubunCode,
            Code shokaiYokaigoJotaiKubunCode) {
        boolean flag = false;
        if (shokaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.経過的要介護.getコード())
                && (konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護3.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護4.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護5.getコード()))) {
            flag = true;
        }
        if (shokaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要支援1.getコード())
                && (konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護3.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護4.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護5.getコード()))) {
            flag = true;
        }
        if (shokaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要支援2.getコード())
                && (konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護4.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護5.getコード()))) {
            flag = true;
        }
        if (shokaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護1.getコード())
                && (konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護4.getコード())
                || konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護5.getコード()))) {
            flag = true;
        }
        if (shokaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護2.getコード())
                && konnkaiYokaigoJotaiKubunCode.value().equals(YokaigoJotaiKubun06.要介護5.getコード())) {
            flag = true;
        }
        return flag;
    }
}
