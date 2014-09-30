/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KaigoTeikeibun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.mapper.KaigoTeikeibunMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.KaigoTeikeibunDac;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護定型文情報を検索するためのクラスです。
 *
 * @author n9606 漢那 憲作
 */
public class KaigoTeikeibunFinder {

    private final KaigoTeikeibunDac dac;

    /**
     * コンストラクタクラスです。
     *
     */
    public KaigoTeikeibunFinder() {
        dac = InstanceProvider.create(KaigoTeikeibunDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     */
    KaigoTeikeibunFinder(KaigoTeikeibunDac dac) {
        this.dac = dac;
    }

    /**
     * 定型区分を指定して該当する定型文データを全件取得するクラスです。
     *
     * @param teikeiKbn 定型区分
     * @return KaigoTeikeibunのList
     */
    public List<KaigoTeikeibun> getTeikeibunList(RString teikeiKbn) {
        List<KaigoTeikeibun> list = new ArrayList();
        List<DbT7103TeikeibunJohoEntity> entityList = dac.select(teikeiKbn);

        for (DbT7103TeikeibunJohoEntity entity : entityList) {
            KaigoTeikeibun teikeibun = KaigoTeikeibunMapper.toKaigoTeikeibun(entity);
            list.add(teikeibun);
        }

        return list;
    }

    /**
     * 定型区分、種別を指定して該当する定型文データを全件取得するクラスです。
     *
     * @param teikeiKbn 定型区分
     * @param teikeiShubetsu 定型種別
     * @return KaigoTeikeibunのList
     */
    public List<KaigoTeikeibun> getTeikeibunList(RString teikeiKbn,
            RString teikeiShubetsu) {
        List<KaigoTeikeibun> list = new ArrayList();
        List<DbT7103TeikeibunJohoEntity> entityList = dac.select(teikeiKbn, teikeiShubetsu);

        for (DbT7103TeikeibunJohoEntity entity : entityList) {
            KaigoTeikeibun teikeibun = KaigoTeikeibunMapper.toKaigoTeikeibun(entity);
            list.add(teikeibun);
        }

        return list;
    }

    /**
     * 定型区分、種別、コードを指定して該当する定型文データを一件取得するクラスです。
     *
     * @param teikeiKbn 定型区分
     * @param teikeiShubetsu 定型種別
     * @param teikeibunCode 定型文コード
     * @return KaigoTeikeibun
     */
    public KaigoTeikeibun getTeikeibun(RString teikeiKbn,
            RString teikeiShubetsu, RString teikeibunCode) {

        DbT7103TeikeibunJohoEntity teikeibunEntity = dac.select(
                teikeiKbn, teikeiShubetsu, teikeibunCode);
        KaigoTeikeibun teikeibun = KaigoTeikeibunMapper.toKaigoTeikeibun(teikeibunEntity);

        return teikeibun;
    }
}
