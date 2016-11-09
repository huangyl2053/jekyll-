/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jikofutangakushomeishotoroku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeisho;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGakuShomeishoMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeishotoroku.JikofutangakuShomeishoTorokuEntity;

/**
 * 事業分自己負担額証明書登録（単）用Businessクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JikofutangakuShomeishoTorokuBusiness implements Serializable {

    private final JikofutangakuShomeishoTorokuEntity torokuEntity;

    /**
     * コンストラクタです。
     *
     * @param torokuEntity JikofutangakuShomeishoTorokuEntity
     */
    public JikofutangakuShomeishoTorokuBusiness(JikofutangakuShomeishoTorokuEntity torokuEntity) {
        this.torokuEntity = torokuEntity;
    }

    /**
     * 事業高額合算自己負担額証明書情報を取得します。
     *
     * @return JigyoKogakuGassanJikoFutanGakuShomeisho
     */
    public JigyoKogakuGassanJikoFutanGakuShomeisho get事業高額合算自己負担額証明書情報() {
        DbT3180JigyoKogakuGassanJikoFutanGakuShomeishoEntity dbT3180Entity = torokuEntity.getDbT3180Entity();
        dbT3180Entity.initializeMd5();
        return new JigyoKogakuGassanJikoFutanGakuShomeisho(dbT3180Entity);
    }

    /**
     * 事業高額合算自己負担額証明書明細情報を取得します。
     *
     * @return List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
     */
    public List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> get事業高額合算自己負担額証明書明細情報() {
        List<DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity> dbT3181EntityList = torokuEntity.getDbT3181EntityList();
        List<JigyoKogakuGassanJikoFutanGakuShomeishoMeisai> list = new ArrayList<>();
        for (DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity : dbT3181EntityList) {
            entity.initializeMd5();
            list.add(new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(entity));
        }
        return list;
    }
}
