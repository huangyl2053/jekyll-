/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuyaokaigojyotaisandannkaihantei;

import java.util.HashMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishuyaokaigojyotaisandannkaihantei.IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 */
public class JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです
     */
    public JutakuKaishuYaokaigoJyotaiSandannkaiHanteiManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * コンストラクタです
     *
     * @param mapperProvider
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
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 要介護認定状態区分コード
     */
    @Transaction
    public Code get要介護認定状態区分コード(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        Map<String, Object> 要介護認定状態区分検索条件 = new HashMap<String, Object>();
        要介護認定状態区分検索条件.put("被保険者番号", 被保険者番号);
        要介護認定状態区分検索条件.put("サービス提供年月", サービス提供年月);
        IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper mapper = mapperProvider.create(IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper.class);
        Code code = mapper.select要介護認定状態区分コードByParam(要介護認定状態区分検索条件);
        return code;
    }

    /**
     * サービス提供年月取得
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 
     */
    @Transaction
    public DbT3034ShokanShinseiEntity getサービス提供年月(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
         Map<String, Object> サービス提供年月検索条件 = new HashMap<String, Object>();
        サービス提供年月検索条件.put("被保険者番号", 被保険者番号);
        サービス提供年月検索条件.put("サービス提供年月", サービス提供年月);
        IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper mapper = mapperProvider.create(IJutakuKaishuYaokaigoJyotaiSandannkaiHanteiMapper.class);
        DbT3034ShokanShinseiEntity entity = mapper.selectサービス提供年月ByParam(サービス提供年月検索条件);
        return entity;
    }

    /**
     * 要介護状態３段階変更の判定
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return bolean
     */
    public boolean checkYaokaigoJyotaiSandannkai(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Code konnkaiYokaigoJotaiKubunCode = get要介護認定状態区分コード(被保険者番号, サービス提供年月);
        if (konnkaiYokaigoJotaiKubunCode == null) {
            return false;
        }
        
       
        DbT3034ShokanShinseiEntity entity = getサービス提供年月(被保険者番号, サービス提供年月);
        if (entity == null) {
            return false;
        }
        
        Code shokaiYokaigoJotaiKubunCode = get要介護認定状態区分コード(被保険者番号, entity.getServiceTeikyoYM());
        if (shokaiYokaigoJotaiKubunCode == null) {
            return false;
        }
        
        //TODO 获取UR業務共通Enum．要介護状態区分(要支援状態区分)のコード
         YokaigoJotaiKubun99 konnkaiYokaigoJotaiKubun = YokaigoJotaiKubun99.toValue(konnkaiYokaigoJotaiKubunCode.getColumnValue());
         YokaigoJotaiKubun99 shokaiYokaigoJotaiKubun = YokaigoJotaiKubun99.toValue(shokaiYokaigoJotaiKubunCode.getColumnValue());
         if (konnkaiYokaigoJotaiKubun.toString().equals("要支援_経過的要介護") && (shokaiYokaigoJotaiKubun.toString().equals("要介護3") 
                 || shokaiYokaigoJotaiKubun.toString().equals("要介護4") || shokaiYokaigoJotaiKubun.toString().equals("要介護5"))) {
             return true;
        } else if (konnkaiYokaigoJotaiKubun.toString().equals("要支援1") && (shokaiYokaigoJotaiKubun.toString().equals("要介護3") 
                 || shokaiYokaigoJotaiKubun.toString().equals("要介護4") || shokaiYokaigoJotaiKubun.toString().equals("要介護5"))) {
            return true;
        } else if (konnkaiYokaigoJotaiKubun.toString().equals("要支援2") && ( shokaiYokaigoJotaiKubun.toString().equals("要介護4") 
                || shokaiYokaigoJotaiKubun.toString().equals("要介護5"))){
                return true;
        } else if (konnkaiYokaigoJotaiKubun.toString().equals("要介護1") && ( shokaiYokaigoJotaiKubun.toString().equals("要介護4") 
                || shokaiYokaigoJotaiKubun.toString().equals("要介護5"))) {
            return true;
        } else if (konnkaiYokaigoJotaiKubun.toString().equals("要介護2") && shokaiYokaigoJotaiKubun.toString().equals("要介護5")) {
            return true;
        } 
        return false;
    }

}
