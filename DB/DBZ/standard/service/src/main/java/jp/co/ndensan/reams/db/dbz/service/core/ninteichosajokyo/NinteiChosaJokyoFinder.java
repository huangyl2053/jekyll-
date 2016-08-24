/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.ninteichosajokyo;

import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosajokyo.INinteiChosaJokyoMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 共有子Div「認定調査状況」のサービスクラスです。
 *
 * @reamsid_L DBZ-1330-020 chengsanyuan
 */
public class NinteiChosaJokyoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteiChosaJokyoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    NinteiChosaJokyoFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiChosaJokyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiChosaJokyoFinder}のインスタンス
     */
    public static NinteiChosaJokyoFinder createInstance() {
        return InstanceProvider.create(NinteiChosaJokyoFinder.class);
    }

    /**
     * 介護事業者情報を取得します。
     *
     * @param サーブ業務コード サーブ業務コード
     * @return 介護事業者情報
     */
    public KaigoJigyosha get介護事業者情報(SubGyomuCode サーブ業務コード) {
        DbT7060KaigoJigyoshaEntity entity = null;
        if (SubGyomuCode.DBD介護受給.value().equals(サーブ業務コード.value())) {
            entity = mapperProvider.create(INinteiChosaJokyoMapper.class).get介護事業者情報By介護受給(RDate.getNowDate());
        }
        if (SubGyomuCode.DBE認定支援.value().equals(サーブ業務コード.value())) {
            entity = mapperProvider.create(INinteiChosaJokyoMapper.class).get介護事業者情報By介護認定(RDate.getNowDate());
        }
        if (entity == null) {
            return null;
        }
        return new KaigoJigyosha(entity);
    }
}
