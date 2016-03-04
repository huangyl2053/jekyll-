/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3077JuryoininKeiyakuJigyoshaDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.juryoininkeiyakujigyosha.IJuryoininKeiyakuJigyoshaMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任契約事業者登録・追加・修正・照会
 */
public class JuryoininKeiyakuJigyoshaManager {

    private final MapperProvider mapperProvider;
    private final DbT3077JuryoininKeiyakuJigyoshaDac dbT3077Dac;

    /**
     * コンストラクタです。
     */
    public JuryoininKeiyakuJigyoshaManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT3077Dac = InstanceProvider.create(DbT3077JuryoininKeiyakuJigyoshaDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param mapperProvider MapperProvider
     * @param dbT3077Dac DbT3077JuryoininKeiyakuJigyoshaDac
     */
    public JuryoininKeiyakuJigyoshaManager(MapperProvider mapperProvider,
            DbT3077JuryoininKeiyakuJigyoshaDac dbT3077Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT3077Dac = dbT3077Dac;
    }

    /**
     * 初期化メソッド
     *
     * @return JuryoininKeiyakuJigyoshaManager
     */
    public static JuryoininKeiyakuJigyoshaManager createInstance() {
        return InstanceProvider.create(JuryoininKeiyakuJigyoshaManager.class);
    }

    /**
     * 契約事業者一覧取得
     *
     * @param parameter JuryoininKeiyakuJigyoshaParameter
     * @return List<JuryoininKeiyakuJigyosha>
     */
    @Transaction
    public List<JuryoininKeiyakuJigyosha> getJuryoininKeiyakuJigyoshaList(
            JuryoininKeiyakuJigyoshaParameter parameter) {

        IJuryoininKeiyakuJigyoshaMapper mapper = mapperProvider.create(IJuryoininKeiyakuJigyoshaMapper.class);
        List<DbT3077JuryoininKeiyakuJigyoshaEntity> entityList = mapper.get契約事業者一覧(parameter);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<JuryoininKeiyakuJigyosha> result = new ArrayList();
        for (DbT3077JuryoininKeiyakuJigyoshaEntity tmp : entityList) {
            result.add(new JuryoininKeiyakuJigyosha(tmp));
        }

        return result;
    }

    /**
     * 登録処理
     *
     * @param data JuryoininKeiyakuJigyosha
     * @return 登録件数
     */
    @Transaction
    public int insJuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyosha data) {
        RString 契約事業者番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.契約事業者番号.getコード()).nextString();
        int 登録件数 = 0;
        if (data != null) {
            DbT3077JuryoininKeiyakuJigyoshaEntity entity = data.toEntity();
            entity.setKeiyakuJigyoshaNo(契約事業者番号);
            entity.setState(EntityDataState.Added);
            登録件数 = dbT3077Dac.save(entity);
        }
        return 登録件数;
    }

    /**
     * 修正処理
     *
     * @param data JuryoininKeiyakuJigyosha
     * @return 更新件数
     */
    @Transaction
    public int updJuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyosha data) {
        int 更新件数 = 0;
        if (data != null) {
            DbT3077JuryoininKeiyakuJigyoshaEntity entity = data.toEntity();
            entity.setState(EntityDataState.Modified);
            更新件数 = dbT3077Dac.save(entity);
        }
        return 更新件数;
    }

    /**
     * 削除処理
     *
     * @param data JuryoininKeiyakuJigyosha
     * @return 削除件数
     */
    @Transaction
    public int delJuryoininKeiyakuJigyosha(JuryoininKeiyakuJigyosha data) {
        int 削除件数 = 0;
        if (data != null) {
            DbT3077JuryoininKeiyakuJigyoshaEntity entity = data.toEntity();
            entity.setState(EntityDataState.Deleted);
            削除件数 = dbT3077Dac.delete(entity);
        }
        return 削除件数;
    }

    /**
     * 契約事業者取得処理
     *
     * @param 契約事業者番号 RString
     * @param 契約日FROM FlexibleDate
     * @param 契約日TO FlexibleDate
     * @return JuryoininKeiyakuJigyosha
     */
    @Transaction
    public JuryoininKeiyakuJigyosha getJuryoininKeiyakuJigyosha(
            RString 契約事業者番号,
            FlexibleDate 契約日FROM,
            FlexibleDate 契約日TO) {
        IJuryoininKeiyakuJigyoshaMapper mapper = mapperProvider.create(IJuryoininKeiyakuJigyoshaMapper.class);

        Map<String, Object> parameter = new HashMap<>();
        parameter.put("keiyakuJigyoshaNo", 契約事業者番号);
        parameter.put("kaishiYMD", 契約日FROM);
        parameter.put("shuryoYMD", 契約日TO);
        JuryoininKeiyakuJigyoshaResult entity = mapper.get契約事業者(parameter);
        if (entity == null) {
            return null;
        }
        return new JuryoininKeiyakuJigyosha(entity.getEntity());
    }
}
